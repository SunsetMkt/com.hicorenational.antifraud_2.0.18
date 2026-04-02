package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableSkip.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m3<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f10807c;

    /* JADX INFO: compiled from: FlowableSkip.java */
    static final class a<T> implements h.a.q<T>, j.d.d {
        final j.d.c<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f10808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        j.d.d f10809c;

        a(j.d.c<? super T> cVar, long j2) {
            this.a = cVar;
            this.f10808b = j2;
        }

        @Override // j.d.d
        public void cancel() {
            this.f10809c.cancel();
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
            long j2 = this.f10808b;
            if (j2 != 0) {
                this.f10808b = j2 - 1;
            } else {
                this.a.onNext(t);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10809c, dVar)) {
                long j2 = this.f10808b;
                this.f10809c = dVar;
                this.a.onSubscribe(this);
                dVar.request(j2);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            this.f10809c.request(j2);
        }
    }

    public m3(h.a.l<T> lVar, long j2) {
        super(lVar);
        this.f10807c = j2;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f10807c));
    }
}
