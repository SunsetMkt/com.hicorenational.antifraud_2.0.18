package h.a.y0.e.b;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: FlowableMapNotification.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z1<T, R> extends h.a.y0.e.b.a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends R> f11084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.x0.o<? super Throwable, ? extends R> f11085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Callable<? extends R> f11086e;

    /* JADX INFO: compiled from: FlowableMapNotification.java */
    static final class a<T, R> extends h.a.y0.h.s<T, R> {
        private static final long serialVersionUID = 2757120512858778108L;
        final Callable<? extends R> onCompleteSupplier;
        final h.a.x0.o<? super Throwable, ? extends R> onErrorMapper;
        final h.a.x0.o<? super T, ? extends R> onNextMapper;

        a(j.d.c<? super R> cVar, h.a.x0.o<? super T, ? extends R> oVar, h.a.x0.o<? super Throwable, ? extends R> oVar2, Callable<? extends R> callable) {
            super(cVar);
            this.onNextMapper = oVar;
            this.onErrorMapper = oVar2;
            this.onCompleteSupplier = callable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // j.d.c
        public void onComplete() {
            try {
                complete(h.a.y0.b.b.a(this.onCompleteSupplier.call(), "The onComplete publisher returned is null"));
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.actual.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // j.d.c
        public void onError(Throwable th) {
            try {
                complete(h.a.y0.b.b.a(this.onErrorMapper.apply(th), "The onError publisher returned is null"));
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                this.actual.onError(new h.a.v0.a(th, th2));
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            try {
                Object objA = h.a.y0.b.b.a(this.onNextMapper.apply(t), "The onNext publisher returned is null");
                this.produced++;
                this.actual.onNext(objA);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.actual.onError(th);
            }
        }
    }

    public z1(h.a.l<T> lVar, h.a.x0.o<? super T, ? extends R> oVar, h.a.x0.o<? super Throwable, ? extends R> oVar2, Callable<? extends R> callable) {
        super(lVar);
        this.f11084c = oVar;
        this.f11085d = oVar2;
        this.f11086e = callable;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super R> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f11084c, this.f11085d, this.f11086e));
    }
}
