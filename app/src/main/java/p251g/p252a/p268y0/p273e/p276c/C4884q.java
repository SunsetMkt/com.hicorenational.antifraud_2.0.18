package p251g.p252a.p268y0.p273e.p276c;

import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: MaybeDoAfterSuccess.java */
@InterfaceC4545e
/* renamed from: g.a.y0.e.c.q */
/* loaded from: classes2.dex */
public final class C4884q<T> extends AbstractC4836a<T, T> {

    /* renamed from: b */
    final InterfaceC4576g<? super T> f18680b;

    /* compiled from: MaybeDoAfterSuccess.java */
    /* renamed from: g.a.y0.e.c.q$a */
    static final class a<T> implements InterfaceC4559v<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4559v<? super T> f18681a;

        /* renamed from: b */
        final InterfaceC4576g<? super T> f18682b;

        /* renamed from: c */
        InterfaceC4552c f18683c;

        a(InterfaceC4559v<? super T> interfaceC4559v, InterfaceC4576g<? super T> interfaceC4576g) {
            this.f18681a = interfaceC4559v;
            this.f18682b = interfaceC4576g;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18683c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18683c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.f18681a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.f18681a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18683c, interfaceC4552c)) {
                this.f18683c = interfaceC4552c;
                this.f18681a.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.f18681a.onSuccess(t);
            try {
                this.f18682b.accept(t);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                C4476a.m17152b(th);
            }
        }
    }

    public C4884q(InterfaceC4588y<T> interfaceC4588y, InterfaceC4576g<? super T> interfaceC4576g) {
        super(interfaceC4588y);
        this.f18680b = interfaceC4576g;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18548a.mo18100a(new a(interfaceC4559v, this.f18680b));
    }
}
