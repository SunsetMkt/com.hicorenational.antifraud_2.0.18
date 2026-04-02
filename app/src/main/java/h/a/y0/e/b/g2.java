package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: FlowableOnBackpressureDrop.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g2<T> extends h.a.y0.e.b.a<T, T> implements h.a.x0.g<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.g<? super T> f10679c;

    /* JADX INFO: compiled from: FlowableOnBackpressureDrop.java */
    static final class a<T> extends AtomicLong implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = -6246093802440953054L;
        final j.d.c<? super T> actual;
        boolean done;
        final h.a.x0.g<? super T> onDrop;
        j.d.d s;

        a(j.d.c<? super T> cVar, h.a.x0.g<? super T> gVar) {
            this.actual = cVar;
            this.onDrop = gVar;
        }

        @Override // j.d.d
        public void cancel() {
            this.s.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (get() != 0) {
                this.actual.onNext(t);
                h.a.y0.j.d.c(this, 1L);
                return;
            }
            try {
                this.onDrop.accept(t);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                cancel();
                onError(th);
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

    public g2(h.a.l<T> lVar) {
        super(lVar);
        this.f10679c = this;
    }

    @Override // h.a.x0.g
    public void accept(T t) {
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f10679c));
    }

    public g2(h.a.l<T> lVar, h.a.x0.g<? super T> gVar) {
        super(lVar);
        this.f10679c = gVar;
    }
}
