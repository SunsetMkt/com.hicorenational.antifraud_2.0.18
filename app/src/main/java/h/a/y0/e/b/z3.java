package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableTakeUntil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z3<T, U> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final j.d.b<? extends U> f11089c;

    /* JADX INFO: compiled from: FlowableTakeUntil.java */
    static final class a<T> extends AtomicInteger implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = -4945480365982832967L;
        final j.d.c<? super T> actual;
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<j.d.d> s = new AtomicReference<>();
        final a<T>.C0200a other = new C0200a();
        final h.a.y0.j.c error = new h.a.y0.j.c();

        /* JADX INFO: renamed from: h.a.y0.e.b.z3$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FlowableTakeUntil.java */
        final class C0200a extends AtomicReference<j.d.d> implements h.a.q<Object> {
            private static final long serialVersionUID = -3592821756711087922L;

            C0200a() {
            }

            @Override // j.d.c
            public void onComplete() {
                h.a.y0.i.j.cancel(a.this.s);
                a aVar = a.this;
                h.a.y0.j.l.a(aVar.actual, aVar, aVar.error);
            }

            @Override // j.d.c
            public void onError(Throwable th) {
                h.a.y0.i.j.cancel(a.this.s);
                a aVar = a.this;
                h.a.y0.j.l.a((j.d.c<?>) aVar.actual, th, (AtomicInteger) aVar, aVar.error);
            }

            @Override // j.d.c
            public void onNext(Object obj) {
                h.a.y0.i.j.cancel(this);
                onComplete();
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
            h.a.y0.j.l.a(this.actual, t, this, this.error);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            h.a.y0.i.j.deferredSetOnce(this.s, this.requested, dVar);
        }

        @Override // j.d.d
        public void request(long j2) {
            h.a.y0.i.j.deferredRequest(this.s, this.requested, j2);
        }
    }

    public z3(h.a.l<T> lVar, j.d.b<? extends U> bVar) {
        super(lVar);
        this.f11089c = bVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        a aVar = new a(cVar);
        cVar.onSubscribe(aVar);
        this.f11089c.subscribe(aVar.other);
        this.f10561b.a((h.a.q) aVar);
    }
}
