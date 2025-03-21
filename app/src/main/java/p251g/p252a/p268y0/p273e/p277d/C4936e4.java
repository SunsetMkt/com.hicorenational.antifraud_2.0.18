package p251g.p252a.p268y0.p273e.p277d;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p284j.C5163c;
import p251g.p252a.p268y0.p284j.C5172l;

/* compiled from: ObservableWithLatestFromMany.java */
/* renamed from: g.a.y0.e.d.e4 */
/* loaded from: classes2.dex */
public final class C4936e4<T, R> extends AbstractC4907a<T, R> {

    /* renamed from: b */
    @InterfaceC4547g
    final InterfaceC4504g0<?>[] f18950b;

    /* renamed from: c */
    @InterfaceC4547g
    final Iterable<? extends InterfaceC4504g0<?>> f18951c;

    /* renamed from: d */
    @InterfaceC4546f
    final InterfaceC4584o<? super Object[], R> f18952d;

    /* compiled from: ObservableWithLatestFromMany.java */
    /* renamed from: g.a.y0.e.d.e4$a */
    final class a implements InterfaceC4584o<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public R apply(T t) throws Exception {
            return (R) C4601b.m18284a(C4936e4.this.f18952d.apply(new Object[]{t}), "The combiner returned a null value");
        }
    }

    /* compiled from: ObservableWithLatestFromMany.java */
    /* renamed from: g.a.y0.e.d.e4$b */
    static final class b<T, R> extends AtomicInteger implements InterfaceC4514i0<T>, InterfaceC4552c {
        private static final long serialVersionUID = 1577321883966341961L;
        final InterfaceC4514i0<? super R> actual;
        final InterfaceC4584o<? super Object[], R> combiner;

        /* renamed from: d */
        final AtomicReference<InterfaceC4552c> f18954d;
        volatile boolean done;
        final C5163c error;
        final c[] observers;
        final AtomicReferenceArray<Object> values;

        b(InterfaceC4514i0<? super R> interfaceC4514i0, InterfaceC4584o<? super Object[], R> interfaceC4584o, int i2) {
            this.actual = interfaceC4514i0;
            this.combiner = interfaceC4584o;
            c[] cVarArr = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cVarArr[i3] = new c(this, i3);
            }
            this.observers = cVarArr;
            this.values = new AtomicReferenceArray<>(i2);
            this.f18954d = new AtomicReference<>();
            this.error = new C5163c();
        }

        void cancelAllBut(int i2) {
            c[] cVarArr = this.observers;
            for (int i3 = 0; i3 < cVarArr.length; i3++) {
                if (i3 != i2) {
                    cVarArr[i3].dispose();
                }
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this.f18954d);
            for (c cVar : this.observers) {
                cVar.dispose();
            }
        }

        void innerComplete(int i2, boolean z) {
            if (z) {
                return;
            }
            this.done = true;
            cancelAllBut(i2);
            C5172l.m18629a(this.actual, this, this.error);
        }

        void innerError(int i2, Throwable th) {
            this.done = true;
            EnumC4592d.dispose(this.f18954d);
            cancelAllBut(i2);
            C5172l.m18628a((InterfaceC4514i0<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        void innerNext(int i2, Object obj) {
            this.values.set(i2, obj);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(this.f18954d.get());
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            C5172l.m18629a(this.actual, this, this.error);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            C5172l.m18628a((InterfaceC4514i0<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.values;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            int i2 = 0;
            objArr[0] = t;
            while (i2 < length) {
                Object obj = atomicReferenceArray.get(i2);
                if (obj == null) {
                    return;
                }
                i2++;
                objArr[i2] = obj;
            }
            try {
                C5172l.m18627a(this.actual, C4601b.m18284a(this.combiner.apply(objArr), "combiner returned a null value"), this, this.error);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                dispose();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this.f18954d, interfaceC4552c);
        }

        void subscribe(InterfaceC4504g0<?>[] interfaceC4504g0Arr, int i2) {
            c[] cVarArr = this.observers;
            AtomicReference<InterfaceC4552c> atomicReference = this.f18954d;
            for (int i3 = 0; i3 < i2 && !EnumC4592d.isDisposed(atomicReference.get()) && !this.done; i3++) {
                interfaceC4504g0Arr[i3].subscribe(cVarArr[i3]);
            }
        }
    }

    /* compiled from: ObservableWithLatestFromMany.java */
    /* renamed from: g.a.y0.e.d.e4$c */
    static final class c extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final b<?, ?> parent;

        c(b<?, ?> bVar, int i2) {
            this.parent = bVar;
            this.index = i2;
        }

        public void dispose() {
            EnumC4592d.dispose(this);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.innerNext(this.index, obj);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this, interfaceC4552c);
        }
    }

    public C4936e4(@InterfaceC4546f InterfaceC4504g0<T> interfaceC4504g0, @InterfaceC4546f InterfaceC4504g0<?>[] interfaceC4504g0Arr, @InterfaceC4546f InterfaceC4584o<? super Object[], R> interfaceC4584o) {
        super(interfaceC4504g0);
        this.f18950b = interfaceC4504g0Arr;
        this.f18951c = null;
        this.f18952d = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super R> interfaceC4514i0) {
        int length;
        InterfaceC4504g0<?>[] interfaceC4504g0Arr = this.f18950b;
        if (interfaceC4504g0Arr == null) {
            interfaceC4504g0Arr = new InterfaceC4504g0[8];
            try {
                length = 0;
                for (InterfaceC4504g0<?> interfaceC4504g0 : this.f18951c) {
                    if (length == interfaceC4504g0Arr.length) {
                        interfaceC4504g0Arr = (InterfaceC4504g0[]) Arrays.copyOf(interfaceC4504g0Arr, (length >> 1) + length);
                    }
                    int i2 = length + 1;
                    interfaceC4504g0Arr[length] = interfaceC4504g0;
                    length = i2;
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                EnumC4593e.error(th, interfaceC4514i0);
                return;
            }
        } else {
            length = interfaceC4504g0Arr.length;
        }
        if (length == 0) {
            new C5017u1(this.f18742a, new a()).mo16855d((InterfaceC4514i0) interfaceC4514i0);
            return;
        }
        b bVar = new b(interfaceC4514i0, this.f18952d, length);
        interfaceC4514i0.onSubscribe(bVar);
        bVar.subscribe(interfaceC4504g0Arr, length);
        this.f18742a.subscribe(bVar);
    }

    public C4936e4(@InterfaceC4546f InterfaceC4504g0<T> interfaceC4504g0, @InterfaceC4546f Iterable<? extends InterfaceC4504g0<?>> iterable, @InterfaceC4546f InterfaceC4584o<? super Object[], R> interfaceC4584o) {
        super(interfaceC4504g0);
        this.f18950b = null;
        this.f18951c = iterable;
        this.f18952d = interfaceC4584o;
    }
}
