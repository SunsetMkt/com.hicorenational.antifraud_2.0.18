package p251g.p252a.p268y0.p273e.p276c;

import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4571b;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: MaybeDoOnEvent.java */
/* renamed from: g.a.y0.e.c.s */
/* loaded from: classes2.dex */
public final class C4890s<T> extends AbstractC4836a<T, T> {

    /* renamed from: b */
    final InterfaceC4571b<? super T, ? super Throwable> f18699b;

    /* compiled from: MaybeDoOnEvent.java */
    /* renamed from: g.a.y0.e.c.s$a */
    static final class a<T> implements InterfaceC4559v<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4559v<? super T> f18700a;

        /* renamed from: b */
        final InterfaceC4571b<? super T, ? super Throwable> f18701b;

        /* renamed from: c */
        InterfaceC4552c f18702c;

        a(InterfaceC4559v<? super T> interfaceC4559v, InterfaceC4571b<? super T, ? super Throwable> interfaceC4571b) {
            this.f18700a = interfaceC4559v;
            this.f18701b = interfaceC4571b;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18702c.dispose();
            this.f18702c = EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18702c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.f18702c = EnumC4592d.DISPOSED;
            try {
                this.f18701b.mo18209a(null, null);
                this.f18700a.onComplete();
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f18700a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.f18702c = EnumC4592d.DISPOSED;
            try {
                this.f18701b.mo18209a(null, th);
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                th = new C4560a(th, th2);
            }
            this.f18700a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18702c, interfaceC4552c)) {
                this.f18702c = interfaceC4552c;
                this.f18700a.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.f18702c = EnumC4592d.DISPOSED;
            try {
                this.f18701b.mo18209a(t, null);
                this.f18700a.onSuccess(t);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f18700a.onError(th);
            }
        }
    }

    public C4890s(InterfaceC4588y<T> interfaceC4588y, InterfaceC4571b<? super T, ? super Throwable> interfaceC4571b) {
        super(interfaceC4588y);
        this.f18699b = interfaceC4571b;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18548a.mo18100a(new a(interfaceC4559v, this.f18699b));
    }
}
