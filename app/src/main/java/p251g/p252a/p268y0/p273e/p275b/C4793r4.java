package p251g.p252a.p268y0.p273e.p275b;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4602a;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5163c;
import p251g.p252a.p268y0.p284j.C5172l;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableWithLatestFromMany.java */
/* renamed from: g.a.y0.e.b.r4 */
/* loaded from: classes2.dex */
public final class C4793r4<T, R> extends AbstractC4686a<T, R> {

    /* renamed from: c */
    @InterfaceC4547g
    final InterfaceC5821b<?>[] f18369c;

    /* renamed from: d */
    @InterfaceC4547g
    final Iterable<? extends InterfaceC5821b<?>> f18370d;

    /* renamed from: e */
    final InterfaceC4584o<? super Object[], R> f18371e;

    /* compiled from: FlowableWithLatestFromMany.java */
    /* renamed from: g.a.y0.e.b.r4$a */
    final class a implements InterfaceC4584o<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public R apply(T t) throws Exception {
            return (R) C4601b.m18284a(C4793r4.this.f18371e.apply(new Object[]{t}), "The combiner returned a null value");
        }
    }

    /* compiled from: FlowableWithLatestFromMany.java */
    /* renamed from: g.a.y0.e.b.r4$b */
    static final class b<T, R> extends AtomicInteger implements InterfaceC4602a<T>, InterfaceC5823d {
        private static final long serialVersionUID = 1577321883966341961L;
        final InterfaceC5822c<? super R> actual;
        final InterfaceC4584o<? super Object[], R> combiner;
        volatile boolean done;
        final C5163c error;
        final AtomicLong requested;

        /* renamed from: s */
        final AtomicReference<InterfaceC5823d> f18373s;
        final c[] subscribers;
        final AtomicReferenceArray<Object> values;

        b(InterfaceC5822c<? super R> interfaceC5822c, InterfaceC4584o<? super Object[], R> interfaceC4584o, int i2) {
            this.actual = interfaceC5822c;
            this.combiner = interfaceC4584o;
            c[] cVarArr = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3] = new c(this, i3);
            }
            this.subscribers = cVarArr;
            this.values = new AtomicReferenceArray<>(i2);
            this.f18373s = new AtomicReference<>();
            this.requested = new AtomicLong();
            this.error = new C5163c();
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            EnumC5160j.cancel(this.f18373s);
            for (c cVar : this.subscribers) {
                cVar.dispose();
            }
        }

        void cancelAllBut(int i2) {
            c[] cVarArr = this.subscribers;
            for (int i3 = 0; i3 < cVarArr.length; i3++) {
                if (i3 != i2) {
                    cVarArr[i3].dispose();
                }
            }
        }

        void innerComplete(int i2, boolean z) {
            if (z) {
                return;
            }
            this.done = true;
            EnumC5160j.cancel(this.f18373s);
            cancelAllBut(i2);
            C5172l.m18632a(this.actual, this, this.error);
        }

        void innerError(int i2, Throwable th) {
            this.done = true;
            EnumC5160j.cancel(this.f18373s);
            cancelAllBut(i2);
            C5172l.m18631a((InterfaceC5822c<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        void innerNext(int i2, Object obj) {
            this.values.set(i2, obj);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            C5172l.m18632a(this.actual, this, this.error);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            C5172l.m18631a((InterfaceC5822c<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (tryOnNext(t) || this.done) {
                return;
            }
            this.f18373s.get().request(1L);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            EnumC5160j.deferredSetOnce(this.f18373s, this.requested, interfaceC5823d);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            EnumC5160j.deferredRequest(this.f18373s, this.requested, j2);
        }

        void subscribe(InterfaceC5821b<?>[] interfaceC5821bArr, int i2) {
            c[] cVarArr = this.subscribers;
            AtomicReference<InterfaceC5823d> atomicReference = this.f18373s;
            for (int i3 = 0; i3 < i2 && !EnumC5160j.isCancelled(atomicReference.get()); i3++) {
                interfaceC5821bArr[i3].subscribe(cVarArr[i3]);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4602a
        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.values;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            objArr[0] = t;
            int i2 = 0;
            while (i2 < length) {
                Object obj = atomicReferenceArray.get(i2);
                if (obj == null) {
                    return false;
                }
                i2++;
                objArr[i2] = obj;
            }
            try {
                C5172l.m18630a(this.actual, C4601b.m18284a(this.combiner.apply(objArr), "The combiner returned a null value"), this, this.error);
                return true;
            } catch (Throwable th) {
                C4561b.m18199b(th);
                cancel();
                onError(th);
                return false;
            }
        }
    }

    /* compiled from: FlowableWithLatestFromMany.java */
    /* renamed from: g.a.y0.e.b.r4$c */
    static final class c extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final b<?, ?> parent;

        c(b<?, ?> bVar, int i2) {
            this.parent = bVar;
            this.index = i2;
        }

        void dispose() {
            EnumC5160j.cancel(this);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.innerNext(this.index, obj);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.setOnce(this, interfaceC5823d)) {
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }
    }

    public C4793r4(@InterfaceC4546f AbstractC4519l<T> abstractC4519l, @InterfaceC4546f InterfaceC5821b<?>[] interfaceC5821bArr, InterfaceC4584o<? super Object[], R> interfaceC4584o) {
        super(abstractC4519l);
        this.f18369c = interfaceC5821bArr;
        this.f18370d = null;
        this.f18371e = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super R> interfaceC5822c) {
        int length;
        InterfaceC5821b<?>[] interfaceC5821bArr = this.f18369c;
        if (interfaceC5821bArr == null) {
            interfaceC5821bArr = new InterfaceC5821b[8];
            try {
                length = 0;
                for (InterfaceC5821b<?> interfaceC5821b : this.f18370d) {
                    if (length == interfaceC5821bArr.length) {
                        interfaceC5821bArr = (InterfaceC5821b[]) Arrays.copyOf(interfaceC5821bArr, (length >> 1) + length);
                    }
                    int i2 = length + 1;
                    interfaceC5821bArr[length] = interfaceC5821b;
                    length = i2;
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                EnumC5157g.error(th, interfaceC5822c);
                return;
            }
        } else {
            length = interfaceC5821bArr.length;
        }
        if (length == 0) {
            new C4828y1(this.f17759b, new a()).mo17216d((InterfaceC5822c) interfaceC5822c);
            return;
        }
        b bVar = new b(interfaceC5822c, this.f18371e, length);
        interfaceC5822c.onSubscribe(bVar);
        bVar.subscribe(interfaceC5821bArr, length);
        this.f17759b.m17799a((InterfaceC4529q) bVar);
    }

    public C4793r4(@InterfaceC4546f AbstractC4519l<T> abstractC4519l, @InterfaceC4546f Iterable<? extends InterfaceC5821b<?>> iterable, @InterfaceC4546f InterfaceC4584o<? super Object[], R> interfaceC4584o) {
        super(abstractC4519l);
        this.f18369c = null;
        this.f18370d = iterable;
        this.f18371e = interfaceC4584o;
    }
}
