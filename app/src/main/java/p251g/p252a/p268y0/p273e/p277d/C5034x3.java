package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: ObservableUsing.java */
/* renamed from: g.a.y0.e.d.x3 */
/* loaded from: classes2.dex */
public final class C5034x3<T, D> extends AbstractC4469b0<T> {

    /* renamed from: a */
    final Callable<? extends D> f19501a;

    /* renamed from: b */
    final InterfaceC4584o<? super D, ? extends InterfaceC4504g0<? extends T>> f19502b;

    /* renamed from: c */
    final InterfaceC4576g<? super D> f19503c;

    /* renamed from: d */
    final boolean f19504d;

    /* compiled from: ObservableUsing.java */
    /* renamed from: g.a.y0.e.d.x3$a */
    static final class a<T, D> extends AtomicBoolean implements InterfaceC4514i0<T>, InterfaceC4552c {
        private static final long serialVersionUID = 5904473792286235046L;
        final InterfaceC4514i0<? super T> actual;
        final InterfaceC4576g<? super D> disposer;
        final boolean eager;
        final D resource;

        /* renamed from: s */
        InterfaceC4552c f19505s;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, D d2, InterfaceC4576g<? super D> interfaceC4576g, boolean z) {
            this.actual = interfaceC4514i0;
            this.resource = d2;
            this.disposer = interfaceC4576g;
            this.eager = z;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            disposeAfter();
            this.f19505s.dispose();
        }

        void disposeAfter() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    C4476a.m17152b(th);
                }
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return get();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (!this.eager) {
                this.actual.onComplete();
                this.f19505s.dispose();
                disposeAfter();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    this.actual.onError(th);
                    return;
                }
            }
            this.f19505s.dispose();
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (!this.eager) {
                this.actual.onError(th);
                this.f19505s.dispose();
                disposeAfter();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th2) {
                    C4561b.m18199b(th2);
                    th = new C4560a(th, th2);
                }
            }
            this.f19505s.dispose();
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19505s, interfaceC4552c)) {
                this.f19505s = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }
    }

    public C5034x3(Callable<? extends D> callable, InterfaceC4584o<? super D, ? extends InterfaceC4504g0<? extends T>> interfaceC4584o, InterfaceC4576g<? super D> interfaceC4576g, boolean z) {
        this.f19501a = callable;
        this.f19502b = interfaceC4584o;
        this.f19503c = interfaceC4576g;
        this.f19504d = z;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        try {
            D call = this.f19501a.call();
            try {
                ((InterfaceC4504g0) C4601b.m18284a(this.f19502b.apply(call), "The sourceSupplier returned a null ObservableSource")).subscribe(new a(interfaceC4514i0, call, this.f19503c, this.f19504d));
            } catch (Throwable th) {
                C4561b.m18199b(th);
                try {
                    this.f19503c.accept(call);
                    EnumC4593e.error(th, interfaceC4514i0);
                } catch (Throwable th2) {
                    C4561b.m18199b(th2);
                    EnumC4593e.error(new C4560a(th, th2), interfaceC4514i0);
                }
            }
        } catch (Throwable th3) {
            C4561b.m18199b(th3);
            EnumC4593e.error(th3, interfaceC4514i0);
        }
    }
}
