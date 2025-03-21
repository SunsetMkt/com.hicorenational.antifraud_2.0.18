package p251g.p252a.p268y0.p273e.p276c;

import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: MaybeFilter.java */
/* renamed from: g.a.y0.e.c.x */
/* loaded from: classes2.dex */
public final class C4901x<T> extends AbstractC4836a<T, T> {

    /* renamed from: b */
    final InterfaceC4587r<? super T> f18720b;

    /* compiled from: MaybeFilter.java */
    /* renamed from: g.a.y0.e.c.x$a */
    static final class a<T> implements InterfaceC4559v<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4559v<? super T> f18721a;

        /* renamed from: b */
        final InterfaceC4587r<? super T> f18722b;

        /* renamed from: c */
        InterfaceC4552c f18723c;

        a(InterfaceC4559v<? super T> interfaceC4559v, InterfaceC4587r<? super T> interfaceC4587r) {
            this.f18721a = interfaceC4559v;
            this.f18722b = interfaceC4587r;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            InterfaceC4552c interfaceC4552c = this.f18723c;
            this.f18723c = EnumC4592d.DISPOSED;
            interfaceC4552c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18723c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.f18721a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.f18721a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18723c, interfaceC4552c)) {
                this.f18723c = interfaceC4552c;
                this.f18721a.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            try {
                if (this.f18722b.test(t)) {
                    this.f18721a.onSuccess(t);
                } else {
                    this.f18721a.onComplete();
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f18721a.onError(th);
            }
        }
    }

    public C4901x(InterfaceC4588y<T> interfaceC4588y, InterfaceC4587r<? super T> interfaceC4587r) {
        super(interfaceC4588y);
        this.f18720b = interfaceC4587r;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18548a.mo18100a(new a(interfaceC4559v, this.f18720b));
    }
}
