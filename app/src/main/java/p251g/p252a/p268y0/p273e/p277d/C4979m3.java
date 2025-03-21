package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicBoolean;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p253a1.C4466m;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.C4589a;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableTakeUntil.java */
/* renamed from: g.a.y0.e.d.m3 */
/* loaded from: classes2.dex */
public final class C4979m3<T, U> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final InterfaceC4504g0<? extends U> f19190b;

    /* compiled from: ObservableTakeUntil.java */
    /* renamed from: g.a.y0.e.d.m3$a */
    final class a implements InterfaceC4514i0<U> {

        /* renamed from: a */
        private final C4589a f19191a;

        /* renamed from: b */
        private final C4466m<T> f19192b;

        a(C4589a c4589a, C4466m<T> c4466m) {
            this.f19191a = c4589a;
            this.f19192b = c4466m;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f19191a.dispose();
            this.f19192b.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f19191a.dispose();
            this.f19192b.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(U u) {
            this.f19191a.dispose();
            this.f19192b.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f19191a.setResource(1, interfaceC4552c);
        }
    }

    /* compiled from: ObservableTakeUntil.java */
    /* renamed from: g.a.y0.e.d.m3$b */
    static final class b<T> extends AtomicBoolean implements InterfaceC4514i0<T> {
        private static final long serialVersionUID = 3451719290311127173L;
        final InterfaceC4514i0<? super T> actual;
        final C4589a frc;

        /* renamed from: s */
        InterfaceC4552c f19194s;

        b(InterfaceC4514i0<? super T> interfaceC4514i0, C4589a c4589a) {
            this.actual = interfaceC4514i0;
            this.frc = c4589a;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.frc.dispose();
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.frc.dispose();
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19194s, interfaceC4552c)) {
                this.f19194s = interfaceC4552c;
                this.frc.setResource(0, interfaceC4552c);
            }
        }
    }

    public C4979m3(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4504g0<? extends U> interfaceC4504g02) {
        super(interfaceC4504g0);
        this.f19190b = interfaceC4504g02;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        C4466m c4466m = new C4466m(interfaceC4514i0);
        C4589a c4589a = new C4589a(2);
        b bVar = new b(c4466m, c4589a);
        interfaceC4514i0.onSubscribe(c4589a);
        this.f19190b.subscribe(new a(c4589a, c4466m));
        this.f18742a.subscribe(bVar);
    }
}
