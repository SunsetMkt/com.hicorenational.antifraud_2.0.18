package p251g.p252a.p268y0.p273e.p276c;

import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: MaybeOnErrorReturn.java */
/* renamed from: g.a.y0.e.c.a1 */
/* loaded from: classes2.dex */
public final class C4838a1<T> extends AbstractC4836a<T, T> {

    /* renamed from: b */
    final InterfaceC4584o<? super Throwable, ? extends T> f18551b;

    /* compiled from: MaybeOnErrorReturn.java */
    /* renamed from: g.a.y0.e.c.a1$a */
    static final class a<T> implements InterfaceC4559v<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4559v<? super T> f18552a;

        /* renamed from: b */
        final InterfaceC4584o<? super Throwable, ? extends T> f18553b;

        /* renamed from: c */
        InterfaceC4552c f18554c;

        a(InterfaceC4559v<? super T> interfaceC4559v, InterfaceC4584o<? super Throwable, ? extends T> interfaceC4584o) {
            this.f18552a = interfaceC4559v;
            this.f18553b = interfaceC4584o;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18554c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18554c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.f18552a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            try {
                this.f18552a.onSuccess(C4601b.m18284a((Object) this.f18553b.apply(th), "The valueSupplier returned a null value"));
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                this.f18552a.onError(new C4560a(th, th2));
            }
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18554c, interfaceC4552c)) {
                this.f18554c = interfaceC4552c;
                this.f18552a.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.f18552a.onSuccess(t);
        }
    }

    public C4838a1(InterfaceC4588y<T> interfaceC4588y, InterfaceC4584o<? super Throwable, ? extends T> interfaceC4584o) {
        super(interfaceC4588y);
        this.f18551b = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18548a.mo18100a(new a(interfaceC4559v, this.f18551b));
    }
}
