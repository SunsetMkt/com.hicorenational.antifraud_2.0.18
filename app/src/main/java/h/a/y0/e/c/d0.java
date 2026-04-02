package h.a.y0.e.c;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeFlatMapNotification.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d0<T, R> extends h.a.y0.e.c.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends h.a.y<? extends R>> f11119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super Throwable, ? extends h.a.y<? extends R>> f11120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Callable<? extends h.a.y<? extends R>> f11121d;

    /* JADX INFO: compiled from: MaybeFlatMapNotification.java */
    static final class a<T, R> extends AtomicReference<h.a.u0.c> implements h.a.v<T>, h.a.u0.c {
        private static final long serialVersionUID = 4375739915521278546L;
        final h.a.v<? super R> actual;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11122d;
        final Callable<? extends h.a.y<? extends R>> onCompleteSupplier;
        final h.a.x0.o<? super Throwable, ? extends h.a.y<? extends R>> onErrorMapper;
        final h.a.x0.o<? super T, ? extends h.a.y<? extends R>> onSuccessMapper;

        /* JADX INFO: renamed from: h.a.y0.e.c.d0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MaybeFlatMapNotification.java */
        final class C0201a implements h.a.v<R> {
            C0201a() {
            }

            @Override // h.a.v
            public void onComplete() {
                a.this.actual.onComplete();
            }

            @Override // h.a.v
            public void onError(Throwable th) {
                a.this.actual.onError(th);
            }

            @Override // h.a.v
            public void onSubscribe(h.a.u0.c cVar) {
                h.a.y0.a.d.setOnce(a.this, cVar);
            }

            @Override // h.a.v, h.a.n0
            public void onSuccess(R r) {
                a.this.actual.onSuccess(r);
            }
        }

        a(h.a.v<? super R> vVar, h.a.x0.o<? super T, ? extends h.a.y<? extends R>> oVar, h.a.x0.o<? super Throwable, ? extends h.a.y<? extends R>> oVar2, Callable<? extends h.a.y<? extends R>> callable) {
            this.actual = vVar;
            this.onSuccessMapper = oVar;
            this.onErrorMapper = oVar2;
            this.onCompleteSupplier = callable;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
            this.f11122d.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.v
        public void onComplete() {
            try {
                ((h.a.y) h.a.y0.b.b.a(this.onCompleteSupplier.call(), "The onCompleteSupplier returned a null MaybeSource")).a(new C0201a());
            } catch (Exception e2) {
                h.a.v0.b.b(e2);
                this.actual.onError(e2);
            }
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            try {
                ((h.a.y) h.a.y0.b.b.a(this.onErrorMapper.apply(th), "The onErrorMapper returned a null MaybeSource")).a(new C0201a());
            } catch (Exception e2) {
                h.a.v0.b.b(e2);
                this.actual.onError(new h.a.v0.a(th, e2));
            }
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11122d, cVar)) {
                this.f11122d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            try {
                ((h.a.y) h.a.y0.b.b.a(this.onSuccessMapper.apply(t), "The onSuccessMapper returned a null MaybeSource")).a(new C0201a());
            } catch (Exception e2) {
                h.a.v0.b.b(e2);
                this.actual.onError(e2);
            }
        }
    }

    public d0(h.a.y<T> yVar, h.a.x0.o<? super T, ? extends h.a.y<? extends R>> oVar, h.a.x0.o<? super Throwable, ? extends h.a.y<? extends R>> oVar2, Callable<? extends h.a.y<? extends R>> callable) {
        super(yVar);
        this.f11119b = oVar;
        this.f11120c = oVar2;
        this.f11121d = callable;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super R> vVar) {
        this.a.a(new a(vVar, this.f11119b, this.f11120c, this.f11121d));
    }
}
