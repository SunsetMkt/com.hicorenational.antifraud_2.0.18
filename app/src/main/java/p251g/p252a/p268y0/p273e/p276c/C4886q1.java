package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: MaybeUsing.java */
/* renamed from: g.a.y0.e.c.q1 */
/* loaded from: classes2.dex */
public final class C4886q1<T, D> extends AbstractC4533s<T> {

    /* renamed from: a */
    final Callable<? extends D> f18686a;

    /* renamed from: b */
    final InterfaceC4584o<? super D, ? extends InterfaceC4588y<? extends T>> f18687b;

    /* renamed from: c */
    final InterfaceC4576g<? super D> f18688c;

    /* renamed from: d */
    final boolean f18689d;

    /* compiled from: MaybeUsing.java */
    /* renamed from: g.a.y0.e.c.q1$a */
    static final class a<T, D> extends AtomicReference<Object> implements InterfaceC4559v<T>, InterfaceC4552c {
        private static final long serialVersionUID = -674404550052917487L;
        final InterfaceC4559v<? super T> actual;

        /* renamed from: d */
        InterfaceC4552c f18690d;
        final InterfaceC4576g<? super D> disposer;
        final boolean eager;

        a(InterfaceC4559v<? super T> interfaceC4559v, D d2, InterfaceC4576g<? super D> interfaceC4576g, boolean z) {
            super(d2);
            this.actual = interfaceC4559v;
            this.disposer = interfaceC4576g;
            this.eager = z;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f18690d.dispose();
            this.f18690d = EnumC4592d.DISPOSED;
            disposeResourceAfter();
        }

        void disposeResourceAfter() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    C4476a.m17152b(th);
                }
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f18690d.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.f18690d = EnumC4592d.DISPOSED;
            if (this.eager) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    this.actual.onError(th);
                    return;
                }
            }
            this.actual.onComplete();
            if (this.eager) {
                return;
            }
            disposeResourceAfter();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.f18690d = EnumC4592d.DISPOSED;
            if (this.eager) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th2) {
                    C4561b.m18199b(th2);
                    th = new C4560a(th, th2);
                }
            }
            this.actual.onError(th);
            if (this.eager) {
                return;
            }
            disposeResourceAfter();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18690d, interfaceC4552c)) {
                this.f18690d = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.f18690d = EnumC4592d.DISPOSED;
            if (this.eager) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    this.actual.onError(th);
                    return;
                }
            }
            this.actual.onSuccess(t);
            if (this.eager) {
                return;
            }
            disposeResourceAfter();
        }
    }

    public C4886q1(Callable<? extends D> callable, InterfaceC4584o<? super D, ? extends InterfaceC4588y<? extends T>> interfaceC4584o, InterfaceC4576g<? super D> interfaceC4576g, boolean z) {
        this.f18686a = callable;
        this.f18687b = interfaceC4584o;
        this.f18688c = interfaceC4576g;
        this.f18689d = z;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        try {
            D call = this.f18686a.call();
            try {
                ((InterfaceC4588y) C4601b.m18284a(this.f18687b.apply(call), "The sourceSupplier returned a null MaybeSource")).mo18100a(new a(interfaceC4559v, call, this.f18688c, this.f18689d));
            } catch (Throwable th) {
                C4561b.m18199b(th);
                if (this.f18689d) {
                    try {
                        this.f18688c.accept(call);
                    } catch (Throwable th2) {
                        C4561b.m18199b(th2);
                        EnumC4593e.error(new C4560a(th, th2), interfaceC4559v);
                        return;
                    }
                }
                EnumC4593e.error(th, interfaceC4559v);
                if (this.f18689d) {
                    return;
                }
                try {
                    this.f18688c.accept(call);
                } catch (Throwable th3) {
                    C4561b.m18199b(th3);
                    C4476a.m17152b(th3);
                }
            }
        } catch (Throwable th4) {
            C4561b.m18199b(th4);
            EnumC4593e.error(th4, interfaceC4559v);
        }
    }
}
