package p251g.p252a.p268y0.p273e.p276c;

import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: MaybeMap.java */
/* renamed from: g.a.y0.e.c.u0 */
/* loaded from: classes2.dex */
public final class C4896u0<T, R> extends AbstractC4836a<T, R> {

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends R> f18712b;

    /* compiled from: MaybeMap.java */
    /* renamed from: g.a.y0.e.c.u0$a */
    static final class a<T, R> implements InterfaceC4559v<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4559v<? super R> f18713a;

        /* renamed from: b */
        final InterfaceC4584o<? super T, ? extends R> f18714b;

        /* renamed from: c */
        InterfaceC4552c f18715c;

        a(InterfaceC4559v<? super R> interfaceC4559v, InterfaceC4584o<? super T, ? extends R> interfaceC4584o) {
            this.f18713a = interfaceC4559v;
            this.f18714b = interfaceC4584o;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            InterfaceC4552c interfaceC4552c = this.f18715c;
            this.f18715c = EnumC4592d.DISPOSED;
            interfaceC4552c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18715c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.f18713a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.f18713a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18715c, interfaceC4552c)) {
                this.f18715c = interfaceC4552c;
                this.f18713a.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            try {
                this.f18713a.onSuccess(C4601b.m18284a(this.f18714b.apply(t), "The mapper returned a null item"));
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f18713a.onError(th);
            }
        }
    }

    public C4896u0(InterfaceC4588y<T> interfaceC4588y, InterfaceC4584o<? super T, ? extends R> interfaceC4584o) {
        super(interfaceC4588y);
        this.f18712b = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super R> interfaceC4559v) {
        this.f18548a.mo18100a(new a(interfaceC4559v, this.f18712b));
    }
}
