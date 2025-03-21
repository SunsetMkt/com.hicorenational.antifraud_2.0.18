package p251g.p252a.p268y0.p273e.p279f;

import java.util.Iterator;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p272d.AbstractC4619b;

/* compiled from: SingleFlatMapIterableObservable.java */
/* renamed from: g.a.y0.e.f.y */
/* loaded from: classes2.dex */
public final class C5107y<T, R> extends AbstractC4469b0<R> {

    /* renamed from: a */
    final InterfaceC4530q0<T> f19818a;

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends Iterable<? extends R>> f19819b;

    /* compiled from: SingleFlatMapIterableObservable.java */
    /* renamed from: g.a.y0.e.f.y$a */
    static final class a<T, R> extends AbstractC4619b<R> implements InterfaceC4524n0<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        final InterfaceC4514i0<? super R> actual;
        volatile boolean cancelled;

        /* renamed from: d */
        InterfaceC4552c f19820d;

        /* renamed from: it */
        volatile Iterator<? extends R> f19821it;
        final InterfaceC4584o<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;

        a(InterfaceC4514i0<? super R> interfaceC4514i0, InterfaceC4584o<? super T, ? extends Iterable<? extends R>> interfaceC4584o) {
            this.actual = interfaceC4514i0;
            this.mapper = interfaceC4584o;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
            this.f19821it = null;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.cancelled = true;
            this.f19820d.dispose();
            this.f19820d = EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return this.f19821it == null;
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.f19820d = EnumC4592d.DISPOSED;
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19820d, interfaceC4552c)) {
                this.f19820d = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            InterfaceC4514i0<? super R> interfaceC4514i0 = this.actual;
            try {
                Iterator<? extends R> it = this.mapper.apply(t).iterator();
                if (!it.hasNext()) {
                    interfaceC4514i0.onComplete();
                    return;
                }
                if (this.outputFused) {
                    this.f19821it = it;
                    interfaceC4514i0.onNext(null);
                    interfaceC4514i0.onComplete();
                    return;
                }
                while (!this.cancelled) {
                    try {
                        interfaceC4514i0.onNext(it.next());
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                interfaceC4514i0.onComplete();
                                return;
                            }
                        } catch (Throwable th) {
                            C4561b.m18199b(th);
                            interfaceC4514i0.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        C4561b.m18199b(th2);
                        interfaceC4514i0.onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                C4561b.m18199b(th3);
                this.actual.onError(th3);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public R poll() throws Exception {
            Iterator<? extends R> it = this.f19821it;
            if (it == null) {
                return null;
            }
            R r = (R) C4601b.m18284a(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f19821it = null;
            }
            return r;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }
    }

    public C5107y(InterfaceC4530q0<T> interfaceC4530q0, InterfaceC4584o<? super T, ? extends Iterable<? extends R>> interfaceC4584o) {
        this.f19818a = interfaceC4530q0;
        this.f19819b = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super R> interfaceC4514i0) {
        this.f19818a.mo17490a(new a(interfaceC4514i0, this.f19819b));
    }
}
