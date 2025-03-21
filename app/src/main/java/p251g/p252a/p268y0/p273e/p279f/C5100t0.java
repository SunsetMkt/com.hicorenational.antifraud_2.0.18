package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: SingleUsing.java */
/* renamed from: g.a.y0.e.f.t0 */
/* loaded from: classes2.dex */
public final class C5100t0<T, U> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final Callable<U> f19796a;

    /* renamed from: b */
    final InterfaceC4584o<? super U, ? extends InterfaceC4530q0<? extends T>> f19797b;

    /* renamed from: c */
    final InterfaceC4576g<? super U> f19798c;

    /* renamed from: d */
    final boolean f19799d;

    /* compiled from: SingleUsing.java */
    /* renamed from: g.a.y0.e.f.t0$a */
    static final class a<T, U> extends AtomicReference<Object> implements InterfaceC4524n0<T>, InterfaceC4552c {
        private static final long serialVersionUID = -5331524057054083935L;
        final InterfaceC4524n0<? super T> actual;

        /* renamed from: d */
        InterfaceC4552c f19800d;
        final InterfaceC4576g<? super U> disposer;
        final boolean eager;

        a(InterfaceC4524n0<? super T> interfaceC4524n0, U u, boolean z, InterfaceC4576g<? super U> interfaceC4576g) {
            super(u);
            this.actual = interfaceC4524n0;
            this.eager = z;
            this.disposer = interfaceC4576g;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19800d.dispose();
            this.f19800d = EnumC4592d.DISPOSED;
            disposeAfter();
        }

        void disposeAfter() {
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
            return this.f19800d.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.f19800d = EnumC4592d.DISPOSED;
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
            disposeAfter();
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19800d, interfaceC4552c)) {
                this.f19800d = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.f19800d = EnumC4592d.DISPOSED;
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
            disposeAfter();
        }
    }

    public C5100t0(Callable<U> callable, InterfaceC4584o<? super U, ? extends InterfaceC4530q0<? extends T>> interfaceC4584o, InterfaceC4576g<? super U> interfaceC4576g, boolean z) {
        this.f19796a = callable;
        this.f19797b = interfaceC4584o;
        this.f19798c = interfaceC4576g;
        this.f19799d = z;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        try {
            U call = this.f19796a.call();
            try {
                ((InterfaceC4530q0) C4601b.m18284a(this.f19797b.apply(call), "The singleFunction returned a null SingleSource")).mo17490a(new a(interfaceC4524n0, call, this.f19799d, this.f19798c));
            } catch (Throwable th) {
                th = th;
                C4561b.m18199b(th);
                if (this.f19799d) {
                    try {
                        this.f19798c.accept(call);
                    } catch (Throwable th2) {
                        C4561b.m18199b(th2);
                        th = new C4560a(th, th2);
                    }
                }
                EnumC4593e.error(th, interfaceC4524n0);
                if (this.f19799d) {
                    return;
                }
                try {
                    this.f19798c.accept(call);
                } catch (Throwable th3) {
                    C4561b.m18199b(th3);
                    C4476a.m17152b(th3);
                }
            }
        } catch (Throwable th4) {
            C4561b.m18199b(th4);
            EnumC4593e.error(th4, interfaceC4524n0);
        }
    }
}
