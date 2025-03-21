package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableAll.java */
/* renamed from: g.a.y0.e.d.f */
/* loaded from: classes2.dex */
public final class C4937f<T> extends AbstractC4907a<T, Boolean> {

    /* renamed from: b */
    final InterfaceC4587r<? super T> f18955b;

    /* compiled from: ObservableAll.java */
    /* renamed from: g.a.y0.e.d.f$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super Boolean> f18956a;

        /* renamed from: b */
        final InterfaceC4587r<? super T> f18957b;

        /* renamed from: c */
        InterfaceC4552c f18958c;

        /* renamed from: d */
        boolean f18959d;

        a(InterfaceC4514i0<? super Boolean> interfaceC4514i0, InterfaceC4587r<? super T> interfaceC4587r) {
            this.f18956a = interfaceC4514i0;
            this.f18957b = interfaceC4587r;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18958c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18958c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f18959d) {
                return;
            }
            this.f18959d = true;
            this.f18956a.onNext(true);
            this.f18956a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f18959d) {
                C4476a.m17152b(th);
            } else {
                this.f18959d = true;
                this.f18956a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f18959d) {
                return;
            }
            try {
                if (this.f18957b.test(t)) {
                    return;
                }
                this.f18959d = true;
                this.f18958c.dispose();
                this.f18956a.onNext(false);
                this.f18956a.onComplete();
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f18958c.dispose();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18958c, interfaceC4552c)) {
                this.f18958c = interfaceC4552c;
                this.f18956a.onSubscribe(this);
            }
        }
    }

    public C4937f(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4587r<? super T> interfaceC4587r) {
        super(interfaceC4504g0);
        this.f18955b = interfaceC4587r;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super Boolean> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f18955b));
    }
}
