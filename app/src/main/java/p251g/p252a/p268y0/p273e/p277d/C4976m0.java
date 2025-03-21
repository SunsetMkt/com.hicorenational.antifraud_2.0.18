package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableDoOnEach.java */
/* renamed from: g.a.y0.e.d.m0 */
/* loaded from: classes2.dex */
public final class C4976m0<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final InterfaceC4576g<? super T> f19131b;

    /* renamed from: c */
    final InterfaceC4576g<? super Throwable> f19132c;

    /* renamed from: d */
    final InterfaceC4570a f19133d;

    /* renamed from: e */
    final InterfaceC4570a f19134e;

    /* compiled from: ObservableDoOnEach.java */
    /* renamed from: g.a.y0.e.d.m0$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f19135a;

        /* renamed from: b */
        final InterfaceC4576g<? super T> f19136b;

        /* renamed from: c */
        final InterfaceC4576g<? super Throwable> f19137c;

        /* renamed from: d */
        final InterfaceC4570a f19138d;

        /* renamed from: e */
        final InterfaceC4570a f19139e;

        /* renamed from: f */
        InterfaceC4552c f19140f;

        /* renamed from: g */
        boolean f19141g;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4576g<? super T> interfaceC4576g, InterfaceC4576g<? super Throwable> interfaceC4576g2, InterfaceC4570a interfaceC4570a, InterfaceC4570a interfaceC4570a2) {
            this.f19135a = interfaceC4514i0;
            this.f19136b = interfaceC4576g;
            this.f19137c = interfaceC4576g2;
            this.f19138d = interfaceC4570a;
            this.f19139e = interfaceC4570a2;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19140f.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19140f.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19141g) {
                return;
            }
            try {
                this.f19138d.run();
                this.f19141g = true;
                this.f19135a.onComplete();
                try {
                    this.f19139e.run();
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    C4476a.m17152b(th);
                }
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                onError(th2);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f19141g) {
                C4476a.m17152b(th);
                return;
            }
            this.f19141g = true;
            try {
                this.f19137c.accept(th);
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                th = new C4560a(th, th2);
            }
            this.f19135a.onError(th);
            try {
                this.f19139e.run();
            } catch (Throwable th3) {
                C4561b.m18199b(th3);
                C4476a.m17152b(th3);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f19141g) {
                return;
            }
            try {
                this.f19136b.accept(t);
                this.f19135a.onNext(t);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f19140f.dispose();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19140f, interfaceC4552c)) {
                this.f19140f = interfaceC4552c;
                this.f19135a.onSubscribe(this);
            }
        }
    }

    public C4976m0(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4576g<? super T> interfaceC4576g, InterfaceC4576g<? super Throwable> interfaceC4576g2, InterfaceC4570a interfaceC4570a, InterfaceC4570a interfaceC4570a2) {
        super(interfaceC4504g0);
        this.f19131b = interfaceC4576g;
        this.f19132c = interfaceC4576g2;
        this.f19133d = interfaceC4570a;
        this.f19134e = interfaceC4570a2;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f19131b, this.f19132c, this.f19133d, this.f19134e));
    }
}
