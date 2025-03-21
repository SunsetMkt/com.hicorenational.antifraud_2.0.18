package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4611j;
import p251g.p252a.p268y0.p272d.AbstractC4619b;

/* compiled from: ObservableDoFinally.java */
@InterfaceC4545e
/* renamed from: g.a.y0.e.d.l0 */
/* loaded from: classes2.dex */
public final class C4971l0<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final InterfaceC4570a f19106b;

    /* compiled from: ObservableDoFinally.java */
    /* renamed from: g.a.y0.e.d.l0$a */
    static final class a<T> extends AbstractC4619b<T> implements InterfaceC4514i0<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final InterfaceC4514i0<? super T> actual;

        /* renamed from: d */
        InterfaceC4552c f19107d;
        final InterfaceC4570a onFinally;

        /* renamed from: qd */
        InterfaceC4611j<T> f19108qd;
        boolean syncFused;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4570a interfaceC4570a) {
            this.actual = interfaceC4514i0;
            this.onFinally = interfaceC4570a;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
            this.f19108qd.clear();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19107d.dispose();
            runFinally();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19107d.isDisposed();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return this.f19108qd.isEmpty();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.actual.onComplete();
            runFinally();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19107d, interfaceC4552c)) {
                this.f19107d = interfaceC4552c;
                if (interfaceC4552c instanceof InterfaceC4611j) {
                    this.f19108qd = (InterfaceC4611j) interfaceC4552c;
                }
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            T poll = this.f19108qd.poll();
            if (poll == null && this.syncFused) {
                runFinally();
            }
            return poll;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            InterfaceC4611j<T> interfaceC4611j = this.f19108qd;
            if (interfaceC4611j == null || (i2 & 4) != 0) {
                return 0;
            }
            int requestFusion = interfaceC4611j.requestFusion(i2);
            if (requestFusion != 0) {
                this.syncFused = requestFusion == 1;
            }
            return requestFusion;
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    C4476a.m17152b(th);
                }
            }
        }
    }

    public C4971l0(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4570a interfaceC4570a) {
        super(interfaceC4504g0);
        this.f19106b = interfaceC4570a;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f19106b));
    }
}
