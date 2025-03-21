package p251g.p252a.p268y0.p273e.p274a;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: CompletableUsing.java */
/* renamed from: g.a.y0.e.a.o0 */
/* loaded from: classes2.dex */
public final class C4674o0<R> extends AbstractC4474c {

    /* renamed from: a */
    final Callable<R> f17733a;

    /* renamed from: b */
    final InterfaceC4584o<? super R, ? extends InterfaceC4513i> f17734b;

    /* renamed from: c */
    final InterfaceC4576g<? super R> f17735c;

    /* renamed from: d */
    final boolean f17736d;

    /* compiled from: CompletableUsing.java */
    /* renamed from: g.a.y0.e.a.o0$a */
    static final class a<R> extends AtomicReference<Object> implements InterfaceC4491f, InterfaceC4552c {
        private static final long serialVersionUID = -674404550052917487L;
        final InterfaceC4491f actual;

        /* renamed from: d */
        InterfaceC4552c f17737d;
        final InterfaceC4576g<? super R> disposer;
        final boolean eager;

        a(InterfaceC4491f interfaceC4491f, R r, InterfaceC4576g<? super R> interfaceC4576g, boolean z) {
            super(r);
            this.actual = interfaceC4491f;
            this.disposer = interfaceC4576g;
            this.eager = z;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f17737d.dispose();
            this.f17737d = EnumC4592d.DISPOSED;
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
            return this.f17737d.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            this.f17737d = EnumC4592d.DISPOSED;
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

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            this.f17737d = EnumC4592d.DISPOSED;
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

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f17737d, interfaceC4552c)) {
                this.f17737d = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }
    }

    public C4674o0(Callable<R> callable, InterfaceC4584o<? super R, ? extends InterfaceC4513i> interfaceC4584o, InterfaceC4576g<? super R> interfaceC4576g, boolean z) {
        this.f17733a = callable;
        this.f17734b = interfaceC4584o;
        this.f17735c = interfaceC4576g;
        this.f17736d = z;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        try {
            R call = this.f17733a.call();
            try {
                ((InterfaceC4513i) C4601b.m18284a(this.f17734b.apply(call), "The completableFunction returned a null CompletableSource")).mo17074a(new a(interfaceC4491f, call, this.f17735c, this.f17736d));
            } catch (Throwable th) {
                C4561b.m18199b(th);
                if (this.f17736d) {
                    try {
                        this.f17735c.accept(call);
                    } catch (Throwable th2) {
                        C4561b.m18199b(th2);
                        EnumC4593e.error(new C4560a(th, th2), interfaceC4491f);
                        return;
                    }
                }
                EnumC4593e.error(th, interfaceC4491f);
                if (this.f17736d) {
                    return;
                }
                try {
                    this.f17735c.accept(call);
                } catch (Throwable th3) {
                    C4561b.m18199b(th3);
                    C4476a.m17152b(th3);
                }
            }
        } catch (Throwable th4) {
            C4561b.m18199b(th4);
            EnumC4593e.error(th4, interfaceC4491f);
        }
    }
}
