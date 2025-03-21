package p251g.p252a.p268y0.p273e.p276c;

import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: MaybeFilterSingle.java */
/* renamed from: g.a.y0.e.c.y */
/* loaded from: classes2.dex */
public final class C4903y<T> extends AbstractC4533s<T> {

    /* renamed from: a */
    final InterfaceC4530q0<T> f18725a;

    /* renamed from: b */
    final InterfaceC4587r<? super T> f18726b;

    /* compiled from: MaybeFilterSingle.java */
    /* renamed from: g.a.y0.e.c.y$a */
    static final class a<T> implements InterfaceC4524n0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4559v<? super T> f18727a;

        /* renamed from: b */
        final InterfaceC4587r<? super T> f18728b;

        /* renamed from: c */
        InterfaceC4552c f18729c;

        a(InterfaceC4559v<? super T> interfaceC4559v, InterfaceC4587r<? super T> interfaceC4587r) {
            this.f18727a = interfaceC4559v;
            this.f18728b = interfaceC4587r;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            InterfaceC4552c interfaceC4552c = this.f18729c;
            this.f18729c = EnumC4592d.DISPOSED;
            interfaceC4552c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18729c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.f18727a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18729c, interfaceC4552c)) {
                this.f18729c = interfaceC4552c;
                this.f18727a.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            try {
                if (this.f18728b.test(t)) {
                    this.f18727a.onSuccess(t);
                } else {
                    this.f18727a.onComplete();
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f18727a.onError(th);
            }
        }
    }

    public C4903y(InterfaceC4530q0<T> interfaceC4530q0, InterfaceC4587r<? super T> interfaceC4587r) {
        this.f18725a = interfaceC4530q0;
        this.f18726b = interfaceC4587r;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18725a.mo17490a(new a(interfaceC4559v, this.f18726b));
    }
}
