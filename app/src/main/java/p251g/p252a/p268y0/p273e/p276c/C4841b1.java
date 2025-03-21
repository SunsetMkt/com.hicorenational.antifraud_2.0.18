package p251g.p252a.p268y0.p273e.p276c;

import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;

/* compiled from: MaybePeek.java */
/* renamed from: g.a.y0.e.c.b1 */
/* loaded from: classes2.dex */
public final class C4841b1<T> extends AbstractC4836a<T, T> {

    /* renamed from: b */
    final InterfaceC4576g<? super InterfaceC4552c> f18561b;

    /* renamed from: c */
    final InterfaceC4576g<? super T> f18562c;

    /* renamed from: d */
    final InterfaceC4576g<? super Throwable> f18563d;

    /* renamed from: e */
    final InterfaceC4570a f18564e;

    /* renamed from: f */
    final InterfaceC4570a f18565f;

    /* renamed from: g */
    final InterfaceC4570a f18566g;

    public C4841b1(InterfaceC4588y<T> interfaceC4588y, InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g, InterfaceC4576g<? super T> interfaceC4576g2, InterfaceC4576g<? super Throwable> interfaceC4576g3, InterfaceC4570a interfaceC4570a, InterfaceC4570a interfaceC4570a2, InterfaceC4570a interfaceC4570a3) {
        super(interfaceC4588y);
        this.f18561b = interfaceC4576g;
        this.f18562c = interfaceC4576g2;
        this.f18563d = interfaceC4576g3;
        this.f18564e = interfaceC4570a;
        this.f18565f = interfaceC4570a2;
        this.f18566g = interfaceC4570a3;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        this.f18548a.mo18100a(new a(interfaceC4559v, this));
    }

    /* compiled from: MaybePeek.java */
    /* renamed from: g.a.y0.e.c.b1$a */
    static final class a<T> implements InterfaceC4559v<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4559v<? super T> f18567a;

        /* renamed from: b */
        final C4841b1<T> f18568b;

        /* renamed from: c */
        InterfaceC4552c f18569c;

        a(InterfaceC4559v<? super T> interfaceC4559v, C4841b1<T> c4841b1) {
            this.f18567a = interfaceC4559v;
            this.f18568b = c4841b1;
        }

        /* renamed from: a */
        void m18408a(Throwable th) {
            try {
                this.f18568b.f18563d.accept(th);
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                th = new C4560a(th, th2);
            }
            this.f18569c = EnumC4592d.DISPOSED;
            this.f18567a.onError(th);
            m18407a();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            try {
                this.f18568b.f18566g.run();
            } catch (Throwable th) {
                C4561b.m18199b(th);
                C4476a.m17152b(th);
            }
            this.f18569c.dispose();
            this.f18569c = EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18569c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            if (this.f18569c == EnumC4592d.DISPOSED) {
                return;
            }
            try {
                this.f18568b.f18564e.run();
                this.f18569c = EnumC4592d.DISPOSED;
                this.f18567a.onComplete();
                m18407a();
            } catch (Throwable th) {
                C4561b.m18199b(th);
                m18408a(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            if (this.f18569c == EnumC4592d.DISPOSED) {
                C4476a.m17152b(th);
            } else {
                m18408a(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18569c, interfaceC4552c)) {
                try {
                    this.f18568b.f18561b.accept(interfaceC4552c);
                    this.f18569c = interfaceC4552c;
                    this.f18567a.onSubscribe(this);
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    interfaceC4552c.dispose();
                    this.f18569c = EnumC4592d.DISPOSED;
                    EnumC4593e.error(th, this.f18567a);
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            if (this.f18569c == EnumC4592d.DISPOSED) {
                return;
            }
            try {
                this.f18568b.f18562c.accept(t);
                this.f18569c = EnumC4592d.DISPOSED;
                this.f18567a.onSuccess(t);
                m18407a();
            } catch (Throwable th) {
                C4561b.m18199b(th);
                m18408a(th);
            }
        }

        /* renamed from: a */
        void m18407a() {
            try {
                this.f18568b.f18565f.run();
            } catch (Throwable th) {
                C4561b.m18199b(th);
                C4476a.m17152b(th);
            }
        }
    }
}
