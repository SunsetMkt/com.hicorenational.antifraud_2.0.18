package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableReduceMaybe.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q2<T> extends h.a.s<T> implements h.a.y0.c.h<T>, h.a.y0.c.b<T> {
    final h.a.l<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.c<T, T, T> f10912b;

    /* JADX INFO: compiled from: FlowableReduceMaybe.java */
    static final class a<T> implements h.a.q<T>, h.a.u0.c {
        final h.a.v<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.c<T, T, T> f10913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        T f10914c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        j.d.d f10915d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f10916e;

        a(h.a.v<? super T> vVar, h.a.x0.c<T, T, T> cVar) {
            this.a = vVar;
            this.f10913b = cVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f10915d.cancel();
            this.f10916e = true;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10916e;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f10916e) {
                return;
            }
            this.f10916e = true;
            T t = this.f10914c;
            if (t != null) {
                this.a.onSuccess(t);
            } else {
                this.a.onComplete();
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10916e) {
                h.a.c1.a.b(th);
            } else {
                this.f10916e = true;
                this.a.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.f10916e) {
                return;
            }
            T t2 = this.f10914c;
            if (t2 == null) {
                this.f10914c = t;
                return;
            }
            try {
                this.f10914c = (T) h.a.y0.b.b.a((Object) this.f10913b.apply(t2, t), "The reducer returned a null value");
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f10915d.cancel();
                onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10915d, dVar)) {
                this.f10915d = dVar;
                this.a.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public q2(h.a.l<T> lVar, h.a.x0.c<T, T, T> cVar) {
        this.a = lVar;
        this.f10912b = cVar;
    }

    @Override // h.a.y0.c.b
    public h.a.l<T> b() {
        return h.a.c1.a.a(new p2(this.a, this.f10912b));
    }

    @Override // h.a.y0.c.h
    public j.d.b<T> source() {
        return this.a;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.a.a((h.a.q) new a(vVar, this.f10912b));
    }
}
