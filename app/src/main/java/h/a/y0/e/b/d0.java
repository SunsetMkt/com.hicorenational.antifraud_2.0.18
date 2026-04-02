package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableDebounce.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d0<T, U> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends j.d.b<U>> f10605c;

    /* JADX INFO: compiled from: FlowableDebounce.java */
    static final class a<T, U> extends AtomicLong implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = 6725975399620862591L;
        final j.d.c<? super T> actual;
        final h.a.x0.o<? super T, ? extends j.d.b<U>> debounceSelector;
        final AtomicReference<h.a.u0.c> debouncer = new AtomicReference<>();
        boolean done;
        volatile long index;
        j.d.d s;

        /* JADX INFO: renamed from: h.a.y0.e.b.d0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FlowableDebounce.java */
        static final class C0190a<T, U> extends h.a.g1.b<U> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final a<T, U> f10606b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final long f10607c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final T f10608d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            boolean f10609e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final AtomicBoolean f10610f = new AtomicBoolean();

            C0190a(a<T, U> aVar, long j2, T t) {
                this.f10606b = aVar;
                this.f10607c = j2;
                this.f10608d = t;
            }

            void c() {
                if (this.f10610f.compareAndSet(false, true)) {
                    this.f10606b.emit(this.f10607c, this.f10608d);
                }
            }

            @Override // j.d.c
            public void onComplete() {
                if (this.f10609e) {
                    return;
                }
                this.f10609e = true;
                c();
            }

            @Override // j.d.c
            public void onError(Throwable th) {
                if (this.f10609e) {
                    h.a.c1.a.b(th);
                } else {
                    this.f10609e = true;
                    this.f10606b.onError(th);
                }
            }

            @Override // j.d.c
            public void onNext(U u) {
                if (this.f10609e) {
                    return;
                }
                this.f10609e = true;
                a();
                c();
            }
        }

        a(j.d.c<? super T> cVar, h.a.x0.o<? super T, ? extends j.d.b<U>> oVar) {
            this.actual = cVar;
            this.debounceSelector = oVar;
        }

        @Override // j.d.d
        public void cancel() {
            this.s.cancel();
            h.a.y0.a.d.dispose(this.debouncer);
        }

        void emit(long j2, T t) {
            if (j2 == this.index) {
                if (get() != 0) {
                    this.actual.onNext(t);
                    h.a.y0.j.d.c(this, 1L);
                } else {
                    cancel();
                    this.actual.onError(new h.a.v0.c("Could not deliver value due to lack of requests"));
                }
            }
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            h.a.u0.c cVar = this.debouncer.get();
            if (h.a.y0.a.d.isDisposed(cVar)) {
                return;
            }
            ((C0190a) cVar).c();
            h.a.y0.a.d.dispose(this.debouncer);
            this.actual.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            h.a.y0.a.d.dispose(this.debouncer);
            this.actual.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j2 = this.index + 1;
            this.index = j2;
            h.a.u0.c cVar = this.debouncer.get();
            if (cVar != null) {
                cVar.dispose();
            }
            try {
                j.d.b bVar = (j.d.b) h.a.y0.b.b.a(this.debounceSelector.apply(t), "The publisher supplied is null");
                C0190a c0190a = new C0190a(this, j2, t);
                if (this.debouncer.compareAndSet(cVar, c0190a)) {
                    bVar.subscribe(c0190a);
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                cancel();
                this.actual.onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.a(this, j2);
            }
        }
    }

    public d0(h.a.l<T> lVar, h.a.x0.o<? super T, ? extends j.d.b<U>> oVar) {
        super(lVar);
        this.f10605c = oVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(new h.a.g1.e(cVar), this.f10605c));
    }
}
