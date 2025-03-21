package p251g.p252a.p268y0.p273e.p276c;

import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: MaybeOnErrorComplete.java */
/* renamed from: g.a.y0.e.c.y0 */
/* loaded from: classes2.dex */
public final class C4904y0<T> extends AbstractC4836a<T, T> {

    /* renamed from: b */
    final InterfaceC4587r<? super Throwable> f18730b;

    /* compiled from: MaybeOnErrorComplete.java */
    /* renamed from: g.a.y0.e.c.y0$a */
    static final class a<T> implements InterfaceC4559v<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4559v<? super T> f18731a;

        /* renamed from: b */
        final InterfaceC4587r<? super Throwable> f18732b;

        /* renamed from: c */
        InterfaceC4552c f18733c;

        a(InterfaceC4559v<? super T> interfaceC4559v, InterfaceC4587r<? super Throwable> interfaceC4587r) {
            this.f18731a = interfaceC4559v;
            this.f18732b = interfaceC4587r;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18733c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18733c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.f18731a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            try {
                if (this.f18732b.test(th)) {
                    this.f18731a.onComplete();
                } else {
                    this.f18731a.onError(th);
                }
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                this.f18731a.onError(new C4560a(th, th2));
            }
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18733c, interfaceC4552c)) {
                this.f18733c = interfaceC4552c;
                this.f18731a.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.f18731a.onSuccess(t);
        }
    }

    public C4904y0(InterfaceC4588y<T> interfaceC4588y, InterfaceC4587r<? super Throwable> interfaceC4587r) {
        super(interfaceC4588y);
        this.f18730b = interfaceC4587r;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18548a.mo18100a(new a(interfaceC4559v, this.f18730b));
    }
}
