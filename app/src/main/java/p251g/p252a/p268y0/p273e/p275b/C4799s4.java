package p251g.p252a.p268y0.p273e.p275b;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4613l;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p280f.C5110b;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5163c;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableZip.java */
/* renamed from: g.a.y0.e.b.s4 */
/* loaded from: classes2.dex */
public final class C4799s4<T, R> extends AbstractC4519l<R> {

    /* renamed from: b */
    final InterfaceC5821b<? extends T>[] f18399b;

    /* renamed from: c */
    final Iterable<? extends InterfaceC5821b<? extends T>> f18400c;

    /* renamed from: d */
    final InterfaceC4584o<? super Object[], ? extends R> f18401d;

    /* renamed from: e */
    final int f18402e;

    /* renamed from: f */
    final boolean f18403f;

    /* compiled from: FlowableZip.java */
    /* renamed from: g.a.y0.e.b.s4$a */
    static final class a<T, R> extends AtomicInteger implements InterfaceC5823d {
        private static final long serialVersionUID = -2434867452883857743L;
        final InterfaceC5822c<? super R> actual;
        volatile boolean cancelled;
        final Object[] current;
        final boolean delayErrors;
        final C5163c errors;
        final AtomicLong requested;
        final b<T, R>[] subscribers;
        final InterfaceC4584o<? super Object[], ? extends R> zipper;

        a(InterfaceC5822c<? super R> interfaceC5822c, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o, int i2, int i3, boolean z) {
            this.actual = interfaceC5822c;
            this.zipper = interfaceC4584o;
            this.delayErrors = z;
            b<T, R>[] bVarArr = new b[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                bVarArr[i4] = new b<>(this, i3);
            }
            this.current = new Object[i2];
            this.subscribers = bVarArr;
            this.requested = new AtomicLong();
            this.errors = new C5163c();
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
        }

        void cancelAll() {
            for (b<T, R> bVar : this.subscribers) {
                bVar.cancel();
            }
        }

        void drain() {
            boolean z;
            T poll;
            boolean z2;
            if (getAndIncrement() != 0) {
                return;
            }
            InterfaceC5822c<? super R> interfaceC5822c = this.actual;
            b<T, R>[] bVarArr = this.subscribers;
            int length = bVarArr.length;
            Object[] objArr = this.current;
            int i2 = 1;
            do {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j2 != j3) {
                    if (this.cancelled) {
                        return;
                    }
                    if (!this.delayErrors && this.errors.get() != null) {
                        cancelAll();
                        interfaceC5822c.onError(this.errors.terminate());
                        return;
                    }
                    boolean z3 = false;
                    for (int i3 = 0; i3 < length; i3++) {
                        b<T, R> bVar = bVarArr[i3];
                        if (objArr[i3] == null) {
                            try {
                                z = bVar.done;
                                InterfaceC4616o<T> interfaceC4616o = bVar.queue;
                                poll = interfaceC4616o != null ? interfaceC4616o.poll() : null;
                                z2 = poll == null;
                            } catch (Throwable th) {
                                C4561b.m18199b(th);
                                this.errors.addThrowable(th);
                                if (!this.delayErrors) {
                                    cancelAll();
                                    interfaceC5822c.onError(this.errors.terminate());
                                    return;
                                }
                            }
                            if (z && z2) {
                                cancelAll();
                                if (this.errors.get() != null) {
                                    interfaceC5822c.onError(this.errors.terminate());
                                    return;
                                } else {
                                    interfaceC5822c.onComplete();
                                    return;
                                }
                            }
                            if (!z2) {
                                objArr[i3] = poll;
                            }
                            z3 = true;
                        }
                    }
                    if (z3) {
                        break;
                    }
                    try {
                        interfaceC5822c.onNext((Object) C4601b.m18284a(this.zipper.apply(objArr.clone()), "The zipper returned a null value"));
                        j3++;
                        Arrays.fill(objArr, (Object) null);
                    } catch (Throwable th2) {
                        C4561b.m18199b(th2);
                        cancelAll();
                        this.errors.addThrowable(th2);
                        interfaceC5822c.onError(this.errors.terminate());
                        return;
                    }
                }
                if (j2 == j3) {
                    if (this.cancelled) {
                        return;
                    }
                    if (!this.delayErrors && this.errors.get() != null) {
                        cancelAll();
                        interfaceC5822c.onError(this.errors.terminate());
                        return;
                    }
                    for (int i4 = 0; i4 < length; i4++) {
                        b<T, R> bVar2 = bVarArr[i4];
                        if (objArr[i4] == null) {
                            try {
                                boolean z4 = bVar2.done;
                                InterfaceC4616o<T> interfaceC4616o2 = bVar2.queue;
                                T poll2 = interfaceC4616o2 != null ? interfaceC4616o2.poll() : null;
                                boolean z5 = poll2 == null;
                                if (z4 && z5) {
                                    cancelAll();
                                    if (this.errors.get() != null) {
                                        interfaceC5822c.onError(this.errors.terminate());
                                        return;
                                    } else {
                                        interfaceC5822c.onComplete();
                                        return;
                                    }
                                }
                                if (!z5) {
                                    objArr[i4] = poll2;
                                }
                            } catch (Throwable th3) {
                                C4561b.m18199b(th3);
                                this.errors.addThrowable(th3);
                                if (!this.delayErrors) {
                                    cancelAll();
                                    interfaceC5822c.onError(this.errors.terminate());
                                    return;
                                }
                            }
                        }
                    }
                }
                if (j3 != 0) {
                    for (b<T, R> bVar3 : bVarArr) {
                        bVar3.request(j3);
                    }
                    if (j2 != C5556m0.f20396b) {
                        this.requested.addAndGet(-j3);
                    }
                }
                i2 = addAndGet(-i2);
            } while (i2 != 0);
        }

        void error(b<T, R> bVar, Throwable th) {
            if (!this.errors.addThrowable(th)) {
                C4476a.m17152b(th);
            } else {
                bVar.done = true;
                drain();
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this.requested, j2);
                drain();
            }
        }

        void subscribe(InterfaceC5821b<? extends T>[] interfaceC5821bArr, int i2) {
            b<T, R>[] bVarArr = this.subscribers;
            for (int i3 = 0; i3 < i2 && !this.cancelled; i3++) {
                if (!this.delayErrors && this.errors.get() != null) {
                    return;
                }
                interfaceC5821bArr[i3].subscribe(bVarArr[i3]);
            }
        }
    }

    /* compiled from: FlowableZip.java */
    /* renamed from: g.a.y0.e.b.s4$b */
    static final class b<T, R> extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = -4627193790118206028L;
        volatile boolean done;
        final int limit;
        final a<T, R> parent;
        final int prefetch;
        long produced;
        InterfaceC4616o<T> queue;
        int sourceMode;

        b(a<T, R> aVar, int i2) {
            this.parent = aVar;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            EnumC5160j.cancel(this);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.parent.error(this, th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.sourceMode != 2) {
                this.queue.offer(t);
            }
            this.parent.drain();
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.setOnce(this, interfaceC5823d)) {
                if (interfaceC5823d instanceof InterfaceC4613l) {
                    InterfaceC4613l interfaceC4613l = (InterfaceC4613l) interfaceC5823d;
                    int requestFusion = interfaceC4613l.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = interfaceC4613l;
                        this.done = true;
                        this.parent.drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = interfaceC4613l;
                        interfaceC5823d.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new C5110b(this.prefetch);
                interfaceC5823d.request(this.prefetch);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (this.sourceMode != 1) {
                long j3 = this.produced + j2;
                if (j3 < this.limit) {
                    this.produced = j3;
                } else {
                    this.produced = 0L;
                    get().request(j3);
                }
            }
        }
    }

    public C4799s4(InterfaceC5821b<? extends T>[] interfaceC5821bArr, Iterable<? extends InterfaceC5821b<? extends T>> iterable, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o, int i2, boolean z) {
        this.f18399b = interfaceC5821bArr;
        this.f18400c = iterable;
        this.f18401d = interfaceC4584o;
        this.f18402e = i2;
        this.f18403f = z;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super R> interfaceC5822c) {
        int length;
        InterfaceC5821b<? extends T>[] interfaceC5821bArr = this.f18399b;
        if (interfaceC5821bArr == null) {
            interfaceC5821bArr = new InterfaceC5821b[8];
            length = 0;
            for (InterfaceC5821b<? extends T> interfaceC5821b : this.f18400c) {
                if (length == interfaceC5821bArr.length) {
                    InterfaceC5821b<? extends T>[] interfaceC5821bArr2 = new InterfaceC5821b[(length >> 2) + length];
                    System.arraycopy(interfaceC5821bArr, 0, interfaceC5821bArr2, 0, length);
                    interfaceC5821bArr = interfaceC5821bArr2;
                }
                interfaceC5821bArr[length] = interfaceC5821b;
                length++;
            }
        } else {
            length = interfaceC5821bArr.length;
        }
        if (length == 0) {
            EnumC5157g.complete(interfaceC5822c);
            return;
        }
        a aVar = new a(interfaceC5822c, this.f18401d, length, this.f18402e, this.f18403f);
        interfaceC5822c.onSubscribe(aVar);
        aVar.subscribe(interfaceC5821bArr, length);
    }
}
