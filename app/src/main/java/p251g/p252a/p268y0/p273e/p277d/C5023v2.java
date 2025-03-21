package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4573d;
import p251g.p252a.p268y0.p269a.C4589a;
import p251g.p252a.p268y0.p280f.C5111c;

/* compiled from: ObservableSequenceEqual.java */
/* renamed from: g.a.y0.e.d.v2 */
/* loaded from: classes2.dex */
public final class C5023v2<T> extends AbstractC4469b0<Boolean> {

    /* renamed from: a */
    final InterfaceC4504g0<? extends T> f19452a;

    /* renamed from: b */
    final InterfaceC4504g0<? extends T> f19453b;

    /* renamed from: c */
    final InterfaceC4573d<? super T, ? super T> f19454c;

    /* renamed from: d */
    final int f19455d;

    /* compiled from: ObservableSequenceEqual.java */
    /* renamed from: g.a.y0.e.d.v2$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4552c {
        private static final long serialVersionUID = -6178010334400373240L;
        final InterfaceC4514i0<? super Boolean> actual;
        volatile boolean cancelled;
        final InterfaceC4573d<? super T, ? super T> comparer;
        final InterfaceC4504g0<? extends T> first;
        final b<T>[] observers;
        final C4589a resources = new C4589a(2);
        final InterfaceC4504g0<? extends T> second;

        /* renamed from: v1 */
        T f19456v1;

        /* renamed from: v2 */
        T f19457v2;

        a(InterfaceC4514i0<? super Boolean> interfaceC4514i0, int i2, InterfaceC4504g0<? extends T> interfaceC4504g0, InterfaceC4504g0<? extends T> interfaceC4504g02, InterfaceC4573d<? super T, ? super T> interfaceC4573d) {
            this.actual = interfaceC4514i0;
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
                bVarArr[0].f19459b.clear();
                bVarArr[1].f19459b.clear();
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
            C5111c<T> c5111c = bVar.f19459b;
            b<T> bVar2 = bVarArr[1];
            C5111c<T> c5111c2 = bVar2.f19459b;
            int i2 = 1;
            while (!this.cancelled) {
                boolean z = bVar.f19461d;
                if (z && (th2 = bVar.f19462e) != null) {
                    cancel(c5111c, c5111c2);
                    this.actual.onError(th2);
                    return;
                }
                boolean z2 = bVar2.f19461d;
                if (z2 && (th = bVar2.f19462e) != null) {
                    cancel(c5111c, c5111c2);
                    this.actual.onError(th);
                    return;
                }
                if (this.f19456v1 == null) {
                    this.f19456v1 = c5111c.poll();
                }
                boolean z3 = this.f19456v1 == null;
                if (this.f19457v2 == null) {
                    this.f19457v2 = c5111c2.poll();
                }
                boolean z4 = this.f19457v2 == null;
                if (z && z2 && z3 && z4) {
                    this.actual.onNext(true);
                    this.actual.onComplete();
                    return;
                }
                if (z && z2 && z3 != z4) {
                    cancel(c5111c, c5111c2);
                    this.actual.onNext(false);
                    this.actual.onComplete();
                    return;
                }
                if (!z3 && !z4) {
                    try {
                        if (!this.comparer.mo18210a(this.f19456v1, this.f19457v2)) {
                            cancel(c5111c, c5111c2);
                            this.actual.onNext(false);
                            this.actual.onComplete();
                            return;
                        }
                        this.f19456v1 = null;
                        this.f19457v2 = null;
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

    /* compiled from: ObservableSequenceEqual.java */
    /* renamed from: g.a.y0.e.d.v2$b */
    static final class b<T> implements InterfaceC4514i0<T> {

        /* renamed from: a */
        final a<T> f19458a;

        /* renamed from: b */
        final C5111c<T> f19459b;

        /* renamed from: c */
        final int f19460c;

        /* renamed from: d */
        volatile boolean f19461d;

        /* renamed from: e */
        Throwable f19462e;

        b(a<T> aVar, int i2, int i3) {
            this.f19458a = aVar;
            this.f19460c = i2;
            this.f19459b = new C5111c<>(i3);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f19461d = true;
            this.f19458a.drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f19462e = th;
            this.f19461d = true;
            this.f19458a.drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.f19459b.offer(t);
            this.f19458a.drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f19458a.setDisposable(interfaceC4552c, this.f19460c);
        }
    }

    public C5023v2(InterfaceC4504g0<? extends T> interfaceC4504g0, InterfaceC4504g0<? extends T> interfaceC4504g02, InterfaceC4573d<? super T, ? super T> interfaceC4573d, int i2) {
        this.f19452a = interfaceC4504g0;
        this.f19453b = interfaceC4504g02;
        this.f19454c = interfaceC4573d;
        this.f19455d = i2;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super Boolean> interfaceC4514i0) {
        a aVar = new a(interfaceC4514i0, this.f19455d, this.f19452a, this.f19453b, this.f19454c);
        interfaceC4514i0.onSubscribe(aVar);
        aVar.subscribe();
    }
}
