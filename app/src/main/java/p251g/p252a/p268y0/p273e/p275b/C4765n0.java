package p251g.p252a.p268y0.p273e.p275b;

import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p268y0.p271c.InterfaceC4602a;
import p251g.p252a.p268y0.p271c.InterfaceC4613l;
import p251g.p252a.p268y0.p283i.AbstractC5153c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableDoFinally.java */
@InterfaceC4545e
/* renamed from: g.a.y0.e.b.n0 */
/* loaded from: classes2.dex */
public final class C4765n0<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final InterfaceC4570a f18113c;

    /* compiled from: FlowableDoFinally.java */
    /* renamed from: g.a.y0.e.b.n0$a */
    static final class a<T> extends AbstractC5153c<T> implements InterfaceC4602a<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final InterfaceC4602a<? super T> actual;
        final InterfaceC4570a onFinally;

        /* renamed from: qs */
        InterfaceC4613l<T> f18114qs;

        /* renamed from: s */
        InterfaceC5823d f18115s;
        boolean syncFused;

        a(InterfaceC4602a<? super T> interfaceC4602a, InterfaceC4570a interfaceC4570a) {
            this.actual = interfaceC4602a;
            this.onFinally = interfaceC4570a;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f18115s.cancel();
            runFinally();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
            this.f18114qs.clear();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return this.f18114qs.isEmpty();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.actual.onComplete();
            runFinally();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18115s, interfaceC5823d)) {
                this.f18115s = interfaceC5823d;
                if (interfaceC5823d instanceof InterfaceC4613l) {
                    this.f18114qs = (InterfaceC4613l) interfaceC5823d;
                }
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            T poll = this.f18114qs.poll();
            if (poll == null && this.syncFused) {
                runFinally();
            }
            return poll;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.f18115s.request(j2);
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            InterfaceC4613l<T> interfaceC4613l = this.f18114qs;
            if (interfaceC4613l == null || (i2 & 4) != 0) {
                return 0;
            }
            int requestFusion = interfaceC4613l.requestFusion(i2);
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

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4602a
        public boolean tryOnNext(T t) {
            return this.actual.tryOnNext(t);
        }
    }

    /* compiled from: FlowableDoFinally.java */
    /* renamed from: g.a.y0.e.b.n0$b */
    static final class b<T> extends AbstractC5153c<T> implements InterfaceC4529q<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final InterfaceC5822c<? super T> actual;
        final InterfaceC4570a onFinally;

        /* renamed from: qs */
        InterfaceC4613l<T> f18116qs;

        /* renamed from: s */
        InterfaceC5823d f18117s;
        boolean syncFused;

        b(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4570a interfaceC4570a) {
            this.actual = interfaceC5822c;
            this.onFinally = interfaceC4570a;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f18117s.cancel();
            runFinally();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
            this.f18116qs.clear();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return this.f18116qs.isEmpty();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.actual.onComplete();
            runFinally();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18117s, interfaceC5823d)) {
                this.f18117s = interfaceC5823d;
                if (interfaceC5823d instanceof InterfaceC4613l) {
                    this.f18116qs = (InterfaceC4613l) interfaceC5823d;
                }
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            T poll = this.f18116qs.poll();
            if (poll == null && this.syncFused) {
                runFinally();
            }
            return poll;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            this.f18117s.request(j2);
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            InterfaceC4613l<T> interfaceC4613l = this.f18116qs;
            if (interfaceC4613l == null || (i2 & 4) != 0) {
                return 0;
            }
            int requestFusion = interfaceC4613l.requestFusion(i2);
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

    public C4765n0(AbstractC4519l<T> abstractC4519l, InterfaceC4570a interfaceC4570a) {
        super(abstractC4519l);
        this.f18113c = interfaceC4570a;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        if (interfaceC5822c instanceof InterfaceC4602a) {
            this.f17759b.m17799a((InterfaceC4529q) new a((InterfaceC4602a) interfaceC5822c, this.f18113c));
        } else {
            this.f17759b.m17799a((InterfaceC4529q) new b(interfaceC5822c, this.f18113c));
        }
    }
}
