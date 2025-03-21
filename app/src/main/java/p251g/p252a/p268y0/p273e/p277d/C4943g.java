package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4605d;

/* compiled from: ObservableAllSingle.java */
/* renamed from: g.a.y0.e.d.g */
/* loaded from: classes2.dex */
public final class C4943g<T> extends AbstractC4518k0<Boolean> implements InterfaceC4605d<Boolean> {

    /* renamed from: a */
    final InterfaceC4504g0<T> f18989a;

    /* renamed from: b */
    final InterfaceC4587r<? super T> f18990b;

    /* compiled from: ObservableAllSingle.java */
    /* renamed from: g.a.y0.e.d.g$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4524n0<? super Boolean> f18991a;

        /* renamed from: b */
        final InterfaceC4587r<? super T> f18992b;

        /* renamed from: c */
        InterfaceC4552c f18993c;

        /* renamed from: d */
        boolean f18994d;

        a(InterfaceC4524n0<? super Boolean> interfaceC4524n0, InterfaceC4587r<? super T> interfaceC4587r) {
            this.f18991a = interfaceC4524n0;
            this.f18992b = interfaceC4587r;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18993c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18993c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f18994d) {
                return;
            }
            this.f18994d = true;
            this.f18991a.onSuccess(true);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f18994d) {
                C4476a.m17152b(th);
            } else {
                this.f18994d = true;
                this.f18991a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f18994d) {
                return;
            }
            try {
                if (this.f18992b.test(t)) {
                    return;
                }
                this.f18994d = true;
                this.f18993c.dispose();
                this.f18991a.onSuccess(false);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f18993c.dispose();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18993c, interfaceC4552c)) {
                this.f18993c = interfaceC4552c;
                this.f18991a.onSubscribe(this);
            }
        }
    }

    public C4943g(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4587r<? super T> interfaceC4587r) {
        this.f18989a = interfaceC4504g0;
        this.f18990b = interfaceC4587r;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4605d
    /* renamed from: a */
    public AbstractC4469b0<Boolean> mo18288a() {
        return C4476a.m17119a(new C4937f(this.f18989a, this.f18990b));
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super Boolean> interfaceC4524n0) {
        this.f18989a.subscribe(new a(interfaceC4524n0, this.f18990b));
    }
}
