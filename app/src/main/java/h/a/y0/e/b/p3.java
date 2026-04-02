package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableSkipUntil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p3<T, U> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final j.d.b<U> f10886c;

    /* JADX INFO: compiled from: FlowableSkipUntil.java */
    static final class a<T> extends AtomicInteger implements h.a.y0.c.a<T>, j.d.d {
        private static final long serialVersionUID = -6270983465606289181L;
        final j.d.c<? super T> actual;
        volatile boolean gate;
        final AtomicReference<j.d.d> s = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        final a<T>.C0194a other = new C0194a();
        final h.a.y0.j.c error = new h.a.y0.j.c();

        /* JADX INFO: renamed from: h.a.y0.e.b.p3$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FlowableSkipUntil.java */
        final class C0194a extends AtomicReference<j.d.d> implements h.a.q<Object> {
            private static final long serialVersionUID = -5592042965931999169L;

            C0194a() {
            }

            @Override // j.d.c
            public void onComplete() {
                a.this.gate = true;
            }

            @Override // j.d.c
            public void onError(Throwable th) {
                h.a.y0.i.j.cancel(a.this.s);
                a aVar = a.this;
                h.a.y0.j.l.a((j.d.c<?>) aVar.actual, th, (AtomicInteger) aVar, aVar.error);
            }

            @Override // j.d.c
            public void onNext(Object obj) {
                a.this.gate = true;
                get().cancel();
            }

            @Override // h.a.q
            public void onSubscribe(j.d.d dVar) {
                if (h.a.y0.i.j.setOnce(this, dVar)) {
                    dVar.request(i.q2.t.m0.f12222b);
                }
            }
        }

        a(j.d.c<? super T> cVar) {
            this.actual = cVar;
        }

        @Override // j.d.d
        public void cancel() {
            h.a.y0.i.j.cancel(this.s);
            h.a.y0.i.j.cancel(this.other);
        }

        @Override // j.d.c
        public void onComplete() {
            h.a.y0.i.j.cancel(this.other);
            h.a.y0.j.l.a(this.actual, this, this.error);
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            h.a.y0.i.j.cancel(this.other);
            h.a.y0.j.l.a((j.d.c<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.s.get().request(1L);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            h.a.y0.i.j.deferredSetOnce(this.s, this.requested, dVar);
        }

        @Override // j.d.d
        public void request(long j2) {
            h.a.y0.i.j.deferredRequest(this.s, this.requested, j2);
        }

        @Override // h.a.y0.c.a
        public boolean tryOnNext(T t) {
            if (!this.gate) {
                return false;
            }
            h.a.y0.j.l.a(this.actual, t, this, this.error);
            return true;
        }
    }

    public p3(h.a.l<T> lVar, j.d.b<U> bVar) {
        super(lVar);
        this.f10886c = bVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        a aVar = new a(cVar);
        cVar.onSubscribe(aVar);
        this.f10886c.subscribe(aVar.other);
        this.f10561b.a((h.a.q) aVar);
    }
}
