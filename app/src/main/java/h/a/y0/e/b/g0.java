package h.a.y0.e.b;

import h.a.j0;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: FlowableDelay.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g0<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f10667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f10668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.a.j0 f10669e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f10670f;

    /* JADX INFO: compiled from: FlowableDelay.java */
    static final class a<T> implements h.a.q<T>, j.d.d {
        final j.d.c<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f10671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f10672c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final j0.c f10673d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final boolean f10674e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        j.d.d f10675f;

        /* JADX INFO: renamed from: h.a.y0.e.b.g0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FlowableDelay.java */
        final class RunnableC0191a implements Runnable {
            RunnableC0191a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.a.onComplete();
                } finally {
                    a.this.f10673d.dispose();
                }
            }
        }

        /* JADX INFO: compiled from: FlowableDelay.java */
        final class b implements Runnable {
            private final Throwable a;

            b(Throwable th) {
                this.a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.a.onError(this.a);
                } finally {
                    a.this.f10673d.dispose();
                }
            }
        }

        /* JADX INFO: compiled from: FlowableDelay.java */
        final class c implements Runnable {
            private final T a;

            c(T t) {
                this.a = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.onNext(this.a);
            }
        }

        a(j.d.c<? super T> cVar, long j2, TimeUnit timeUnit, j0.c cVar2, boolean z) {
            this.a = cVar;
            this.f10671b = j2;
            this.f10672c = timeUnit;
            this.f10673d = cVar2;
            this.f10674e = z;
        }

        @Override // j.d.d
        public void cancel() {
            this.f10675f.cancel();
            this.f10673d.dispose();
        }

        @Override // j.d.c
        public void onComplete() {
            this.f10673d.a(new RunnableC0191a(), this.f10671b, this.f10672c);
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.f10673d.a(new b(th), this.f10674e ? this.f10671b : 0L, this.f10672c);
        }

        @Override // j.d.c
        public void onNext(T t) {
            this.f10673d.a(new c(t), this.f10671b, this.f10672c);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10675f, dVar)) {
                this.f10675f = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            this.f10675f.request(j2);
        }
    }

    public g0(h.a.l<T> lVar, long j2, TimeUnit timeUnit, h.a.j0 j0Var, boolean z) {
        super(lVar);
        this.f10667c = j2;
        this.f10668d = timeUnit;
        this.f10669e = j0Var;
        this.f10670f = z;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(this.f10670f ? cVar : new h.a.g1.e(cVar), this.f10667c, this.f10668d, this.f10669e.a(), this.f10670f));
    }
}
