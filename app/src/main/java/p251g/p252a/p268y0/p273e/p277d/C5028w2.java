package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4573d;
import p251g.p252a.p268y0.p269a.C4589a;
import p251g.p252a.p268y0.p271c.InterfaceC4605d;
import p251g.p252a.p268y0.p280f.C5111c;

/* compiled from: ObservableSequenceEqualSingle.java */
/* renamed from: g.a.y0.e.d.w2 */
/* loaded from: classes2.dex */
public final class C5028w2<T> extends AbstractC4518k0<Boolean> implements InterfaceC4605d<Boolean> {

    /* renamed from: a */
    final InterfaceC4504g0<? extends T> f19478a;

    /* renamed from: b */
    final InterfaceC4504g0<? extends T> f19479b;

    /* renamed from: c */
    final InterfaceC4573d<? super T, ? super T> f19480c;

    /* renamed from: d */
    final int f19481d;

    /* compiled from: ObservableSequenceEqualSingle.java */
    /* renamed from: g.a.y0.e.d.w2$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4552c {
        private static final long serialVersionUID = -6178010334400373240L;
        final InterfaceC4524n0<? super Boolean> actual;
        volatile boolean cancelled;
        final InterfaceC4573d<? super T, ? super T> comparer;
        final InterfaceC4504g0<? extends T> first;
        final b<T>[] observers;
        final C4589a resources = new C4589a(2);
        final InterfaceC4504g0<? extends T> second;

        /* renamed from: v1 */
        T f19482v1;

        /* renamed from: v2 */
        T f19483v2;

        a(InterfaceC4524n0<? super Boolean> interfaceC4524n0, int i2, InterfaceC4504g0<? extends T> interfaceC4504g0, InterfaceC4504g0<? extends T> interfaceC4504g02, InterfaceC4573d<? super T, ? super T> interfaceC4573d) {
            this.actual = interfaceC4524n0;
            this.first = interfaceC4504g0;
            this.second = interfaceC4504g02;
            this.comparer = interfaceC4573d;
            this.observers = new b[]{new b<>(this, 0, i2), new b<>(this, 1, i2)};
        }

        void cancel(C5111c<T> c5111c, C5111c<T> c5111c2) {
            this.cancelled = true;
            c5111c.clear();
            c5111c2.clear();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.resources.dispose();
            if (getAndIncrement() == 0) {
                b<T>[] bVarArr = this.observers;
                bVarArr[0].f19485b.clear();
                bVarArr[1].f19485b.clear();
            }
        }

        void drain() {
            Throwable th;
            Throwable th2;
            if (getAndIncrement() != 0) {
                return;
            }
            b<T>[] bVarArr = this.observers;
            b<T> bVar = bVarArr[0];
            C5111c<T> c5111c = bVar.f19485b;
            b<T> bVar2 = bVarArr[1];
            C5111c<T> c5111c2 = bVar2.f19485b;
            int i2 = 1;
            while (!this.cancelled) {
                boolean z = bVar.f19487d;
                if (z && (th2 = bVar.f19488e) != null) {
                    cancel(c5111c, c5111c2);
                    this.actual.onError(th2);
                    return;
                }
                boolean z2 = bVar2.f19487d;
                if (z2 && (th = bVar2.f19488e) != null) {
                    cancel(c5111c, c5111c2);
                    this.actual.onError(th);
                    return;
                }
                if (this.f19482v1 == null) {
                    this.f19482v1 = c5111c.poll();
                }
                boolean z3 = this.f19482v1 == null;
                if (this.f19483v2 == null) {
                    this.f19483v2 = c5111c2.poll();
                }
                boolean z4 = this.f19483v2 == null;
                if (z && z2 && z3 && z4) {
                    this.actual.onSuccess(true);
                    return;
                }
                if (z && z2 && z3 != z4) {
                    cancel(c5111c, c5111c2);
                    this.actual.onSuccess(false);
                    return;
                }
                if (!z3 && !z4) {
                    try {
                        if (!this.comparer.mo18210a(this.f19482v1, this.f19483v2)) {
                            cancel(c5111c, c5111c2);
                            this.actual.onSuccess(false);
                            return;
                        } else {
                            this.f19482v1 = null;
                            this.f19483v2 = null;
                        }
                    } catch (Throwable th3) {
                        C4561b.m18199b(th3);
                        cancel(c5111c, c5111c2);
                        this.actual.onError(th3);
                        return;
                    }
                }
                if (z3 || z4) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
            c5111c.clear();
            c5111c2.clear();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.cancelled;
        }

        boolean setDisposable(InterfaceC4552c interfaceC4552c, int i2) {
            return this.resources.setResource(i2, interfaceC4552c);
        }

        void subscribe() {
            b<T>[] bVarArr = this.observers;
            this.first.subscribe(bVarArr[0]);
            this.second.subscribe(bVarArr[1]);
        }
    }

    /* compiled from: ObservableSequenceEqualSingle.java */
    /* renamed from: g.a.y0.e.d.w2$b */
    static final class b<T> implements InterfaceC4514i0<T> {

        /* renamed from: a */
        final a<T> f19484a;

        /* renamed from: b */
        final C5111c<T> f19485b;

        /* renamed from: c */
        final int f19486c;

        /* renamed from: d */
        volatile boolean f19487d;

        /* renamed from: e */
        Throwable f19488e;

        b(a<T> aVar, int i2, int i3) {
            this.f19484a = aVar;
            this.f19486c = i2;
            this.f19485b = new C5111c<>(i3);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f19487d = true;
            this.f19484a.drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f19488e = th;
            this.f19487d = true;
            this.f19484a.drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.f19485b.offer(t);
            this.f19484a.drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f19484a.setDisposable(interfaceC4552c, this.f19486c);
        }
    }

    public C5028w2(InterfaceC4504g0<? extends T> interfaceC4504g0, InterfaceC4504g0<? extends T> interfaceC4504g02, InterfaceC4573d<? super T, ? super T> interfaceC4573d, int i2) {
        this.f19478a = interfaceC4504g0;
        this.f19479b = interfaceC4504g02;
        this.f19480c = interfaceC4573d;
        this.f19481d = i2;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4605d
    /* renamed from: a */
    public AbstractC4469b0<Boolean> mo18288a() {
        return C4476a.m17119a(new C5023v2(this.f19478a, this.f19479b, this.f19480c, this.f19481d));
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    public void mo17357b(InterfaceC4524n0<? super Boolean> interfaceC4524n0) {
        a aVar = new a(interfaceC4524n0, this.f19481d, this.f19478a, this.f19479b, this.f19480c);
        interfaceC4524n0.onSubscribe(aVar);
        aVar.subscribe();
    }
}
