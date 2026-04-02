package h.a.y0.e.b;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: FlowableTimeInterval.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d4<T> extends h.a.y0.e.b.a<T, h.a.e1.c<T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.j0 f10617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f10618d;

    /* JADX INFO: compiled from: FlowableTimeInterval.java */
    static final class a<T> implements h.a.q<T>, j.d.d {
        final j.d.c<? super h.a.e1.c<T>> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final TimeUnit f10619b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final h.a.j0 f10620c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        j.d.d f10621d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f10622e;

        a(j.d.c<? super h.a.e1.c<T>> cVar, TimeUnit timeUnit, h.a.j0 j0Var) {
            this.a = cVar;
            this.f10620c = j0Var;
            this.f10619b = timeUnit;
        }

        @Override // j.d.d
        public void cancel() {
            this.f10621d.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            long jA = this.f10620c.a(this.f10619b);
            long j2 = this.f10622e;
            this.f10622e = jA;
            this.a.onNext(new h.a.e1.c(t, jA - j2, this.f10619b));
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10621d, dVar)) {
                this.f10622e = this.f10620c.a(this.f10619b);
                this.f10621d = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            this.f10621d.request(j2);
        }
    }

    public d4(h.a.l<T> lVar, TimeUnit timeUnit, h.a.j0 j0Var) {
        super(lVar);
        this.f10617c = j0Var;
        this.f10618d = timeUnit;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super h.a.e1.c<T>> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f10618d, this.f10617c));
    }
}
