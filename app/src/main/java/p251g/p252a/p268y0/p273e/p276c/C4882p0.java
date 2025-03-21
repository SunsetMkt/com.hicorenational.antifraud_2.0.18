package p251g.p252a.p268y0.p273e.p276c;

import p251g.p252a.AbstractC4474c;
import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4604c;

/* compiled from: MaybeIgnoreElementCompletable.java */
/* renamed from: g.a.y0.e.c.p0 */
/* loaded from: classes2.dex */
public final class C4882p0<T> extends AbstractC4474c implements InterfaceC4604c<T> {

    /* renamed from: a */
    final InterfaceC4588y<T> f18675a;

    /* compiled from: MaybeIgnoreElementCompletable.java */
    /* renamed from: g.a.y0.e.c.p0$a */
    static final class a<T> implements InterfaceC4559v<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4491f f18676a;

        /* renamed from: b */
        InterfaceC4552c f18677b;

        a(InterfaceC4491f interfaceC4491f) {
            this.f18676a = interfaceC4491f;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18677b.dispose();
            this.f18677b = EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18677b.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.f18677b = EnumC4592d.DISPOSED;
            this.f18676a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.f18677b = EnumC4592d.DISPOSED;
            this.f18676a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18677b, interfaceC4552c)) {
                this.f18677b = interfaceC4552c;
                this.f18676a.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.f18677b = EnumC4592d.DISPOSED;
            this.f18676a.onComplete();
        }
    }

    public C4882p0(InterfaceC4588y<T> interfaceC4588y) {
        this.f18675a = interfaceC4588y;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        this.f18675a.mo18100a(new a(interfaceC4491f));
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4604c
    /* renamed from: c */
    public AbstractC4533s<T> mo18287c() {
        return C4476a.m17131a(new C4879o0(this.f18675a));
    }
}
