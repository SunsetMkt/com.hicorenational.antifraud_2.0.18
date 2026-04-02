package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableWithLatestFrom.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q4<T, U, R> extends h.a.y0.e.b.a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.c<? super T, ? super U, ? extends R> f10921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final j.d.b<? extends U> f10922d;

    /* JADX INFO: compiled from: FlowableWithLatestFrom.java */
    final class a implements h.a.q<U> {
        private final b<T, U, R> a;

        a(b<T, U, R> bVar) {
            this.a = bVar;
        }

        @Override // j.d.c
        public void onComplete() {
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.a.otherError(th);
        }

        @Override // j.d.c
        public void onNext(U u) {
            this.a.lazySet(u);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (this.a.setOther(dVar)) {
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    /* JADX INFO: compiled from: FlowableWithLatestFrom.java */
    static final class b<T, U, R> extends AtomicReference<U> implements h.a.y0.c.a<T>, j.d.d {
        private static final long serialVersionUID = -312246233408980075L;
        final j.d.c<? super R> actual;
        final h.a.x0.c<? super T, ? super U, ? extends R> combiner;
        final AtomicReference<j.d.d> s = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<j.d.d> other = new AtomicReference<>();

        b(j.d.c<? super R> cVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar2) {
            this.actual = cVar;
            this.combiner = cVar2;
        }

        @Override // j.d.d
        public void cancel() {
            h.a.y0.i.j.cancel(this.s);
            h.a.y0.i.j.cancel(this.other);
        }

        @Override // j.d.c
        public void onComplete() {
            h.a.y0.i.j.cancel(this.other);
            this.actual.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            h.a.y0.i.j.cancel(this.other);
            this.actual.onError(th);
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

        public void otherError(Throwable th) {
            h.a.y0.i.j.cancel(this.s);
            this.actual.onError(th);
        }

        @Override // j.d.d
        public void request(long j2) {
            h.a.y0.i.j.deferredRequest(this.s, this.requested, j2);
        }

        public boolean setOther(j.d.d dVar) {
            return h.a.y0.i.j.setOnce(this.other, dVar);
        }

        @Override // h.a.y0.c.a
        public boolean tryOnNext(T t) {
            U u = get();
            if (u != null) {
                try {
                    this.actual.onNext(h.a.y0.b.b.a(this.combiner.apply(t, u), "The combiner returned a null value"));
                    return true;
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    cancel();
                    this.actual.onError(th);
                }
            }
            return false;
        }
    }

    public q4(h.a.l<T> lVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar, j.d.b<? extends U> bVar) {
        super(lVar);
        this.f10921c = cVar;
        this.f10922d = bVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super R> cVar) {
        h.a.g1.e eVar = new h.a.g1.e(cVar);
        b bVar = new b(eVar, this.f10921c);
        eVar.onSubscribe(bVar);
        this.f10922d.subscribe(new a(bVar));
        this.f10561b.a((h.a.q) bVar);
    }
}
