package h.a.y0.e.b;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: FlowableInternalHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p1 {

    /* JADX INFO: compiled from: FlowableInternalHelper.java */
    static final class a<T> implements Callable<h.a.w0.a<T>> {
        private final h.a.l<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10874b;

        a(h.a.l<T> lVar, int i2) {
            this.a = lVar;
            this.f10874b = i2;
        }

        @Override // java.util.concurrent.Callable
        public h.a.w0.a<T> call() {
            return this.a.h(this.f10874b);
        }
    }

    /* JADX INFO: compiled from: FlowableInternalHelper.java */
    static final class b<T> implements Callable<h.a.w0.a<T>> {
        private final h.a.l<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f10876c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final TimeUnit f10877d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final h.a.j0 f10878e;

        b(h.a.l<T> lVar, int i2, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
            this.a = lVar;
            this.f10875b = i2;
            this.f10876c = j2;
            this.f10877d = timeUnit;
            this.f10878e = j0Var;
        }

        @Override // java.util.concurrent.Callable
        public h.a.w0.a<T> call() {
            return this.a.a(this.f10875b, this.f10876c, this.f10877d, this.f10878e);
        }
    }

    /* JADX INFO: compiled from: FlowableInternalHelper.java */
    static final class c<T, U> implements h.a.x0.o<T, j.d.b<U>> {
        private final h.a.x0.o<? super T, ? extends Iterable<? extends U>> a;

        c(h.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
            this.a = oVar;
        }

        @Override // h.a.x0.o
        public j.d.b<U> apply(T t) throws Exception {
            return new g1((Iterable) h.a.y0.b.b.a(this.a.apply(t), "The mapper returned a null Iterable"));
        }
    }

    /* JADX INFO: compiled from: FlowableInternalHelper.java */
    static final class d<U, R, T> implements h.a.x0.o<U, R> {
        private final h.a.x0.c<? super T, ? super U, ? extends R> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final T f10879b;

        d(h.a.x0.c<? super T, ? super U, ? extends R> cVar, T t) {
            this.a = cVar;
            this.f10879b = t;
        }

        @Override // h.a.x0.o
        public R apply(U u) throws Exception {
            return this.a.apply(this.f10879b, u);
        }
    }

    /* JADX INFO: compiled from: FlowableInternalHelper.java */
    static final class e<T, R, U> implements h.a.x0.o<T, j.d.b<R>> {
        private final h.a.x0.c<? super T, ? super U, ? extends R> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h.a.x0.o<? super T, ? extends j.d.b<? extends U>> f10880b;

        e(h.a.x0.c<? super T, ? super U, ? extends R> cVar, h.a.x0.o<? super T, ? extends j.d.b<? extends U>> oVar) {
            this.a = cVar;
            this.f10880b = oVar;
        }

        @Override // h.a.x0.o
        public j.d.b<R> apply(T t) throws Exception {
            return new a2((j.d.b) h.a.y0.b.b.a(this.f10880b.apply(t), "The mapper returned a null Publisher"), new d(this.a, t));
        }
    }

    /* JADX INFO: compiled from: FlowableInternalHelper.java */
    static final class f<T, U> implements h.a.x0.o<T, j.d.b<T>> {
        final h.a.x0.o<? super T, ? extends j.d.b<U>> a;

        f(h.a.x0.o<? super T, ? extends j.d.b<U>> oVar) {
            this.a = oVar;
        }

        @Override // h.a.x0.o
        public j.d.b<T> apply(T t) throws Exception {
            return new y3((j.d.b) h.a.y0.b.b.a(this.a.apply(t), "The itemDelay returned a null Publisher"), 1L).o(h.a.y0.b.a.c(t)).f(t);
        }
    }

    /* JADX INFO: compiled from: FlowableInternalHelper.java */
    static final class g<T> implements Callable<h.a.w0.a<T>> {
        private final h.a.l<T> a;

        g(h.a.l<T> lVar) {
            this.a = lVar;
        }

        @Override // java.util.concurrent.Callable
        public h.a.w0.a<T> call() {
            return this.a.B();
        }
    }

    /* JADX INFO: compiled from: FlowableInternalHelper.java */
    static final class h<T, R> implements h.a.x0.o<h.a.l<T>, j.d.b<R>> {
        private final h.a.x0.o<? super h.a.l<T>, ? extends j.d.b<R>> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h.a.j0 f10881b;

        h(h.a.x0.o<? super h.a.l<T>, ? extends j.d.b<R>> oVar, h.a.j0 j0Var) {
            this.a = oVar;
            this.f10881b = j0Var;
        }

        @Override // h.a.x0.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public j.d.b<R> apply(h.a.l<T> lVar) throws Exception {
            return h.a.l.q((j.d.b) h.a.y0.b.b.a(this.a.apply(lVar), "The selector returned a null Publisher")).a(this.f10881b);
        }
    }

    /* JADX INFO: compiled from: FlowableInternalHelper.java */
    public enum i implements h.a.x0.g<j.d.d> {
        INSTANCE;

        @Override // h.a.x0.g
        public void accept(j.d.d dVar) throws Exception {
            dVar.request(i.q2.t.m0.f12222b);
        }
    }

    /* JADX INFO: compiled from: FlowableInternalHelper.java */
    static final class j<T, S> implements h.a.x0.c<S, h.a.k<T>, S> {
        final h.a.x0.b<S, h.a.k<T>> a;

        j(h.a.x0.b<S, h.a.k<T>> bVar) {
            this.a = bVar;
        }

        @Override // h.a.x0.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public S apply(S s, h.a.k<T> kVar) throws Exception {
            this.a.a(s, kVar);
            return s;
        }
    }

    /* JADX INFO: compiled from: FlowableInternalHelper.java */
    static final class k<T, S> implements h.a.x0.c<S, h.a.k<T>, S> {
        final h.a.x0.g<h.a.k<T>> a;

        k(h.a.x0.g<h.a.k<T>> gVar) {
            this.a = gVar;
        }

        @Override // h.a.x0.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public S apply(S s, h.a.k<T> kVar) throws Exception {
            this.a.accept(kVar);
            return s;
        }
    }

    /* JADX INFO: compiled from: FlowableInternalHelper.java */
    static final class l<T> implements h.a.x0.a {
        final j.d.c<T> a;

        l(j.d.c<T> cVar) {
            this.a = cVar;
        }

        @Override // h.a.x0.a
        public void run() throws Exception {
            this.a.onComplete();
        }
    }

    /* JADX INFO: compiled from: FlowableInternalHelper.java */
    static final class m<T> implements h.a.x0.g<Throwable> {
        final j.d.c<T> a;

        m(j.d.c<T> cVar) {
            this.a = cVar;
        }

        @Override // h.a.x0.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            this.a.onError(th);
        }
    }

    /* JADX INFO: compiled from: FlowableInternalHelper.java */
    static final class n<T> implements h.a.x0.g<T> {
        final j.d.c<T> a;

        n(j.d.c<T> cVar) {
            this.a = cVar;
        }

        @Override // h.a.x0.g
        public void accept(T t) throws Exception {
            this.a.onNext(t);
        }
    }

    /* JADX INFO: compiled from: FlowableInternalHelper.java */
    static final class o<T> implements Callable<h.a.w0.a<T>> {
        private final h.a.l<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f10882b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final TimeUnit f10883c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final h.a.j0 f10884d;

        o(h.a.l<T> lVar, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
            this.a = lVar;
            this.f10882b = j2;
            this.f10883c = timeUnit;
            this.f10884d = j0Var;
        }

        @Override // java.util.concurrent.Callable
        public h.a.w0.a<T> call() {
            return this.a.e(this.f10882b, this.f10883c, this.f10884d);
        }
    }

    /* JADX INFO: compiled from: FlowableInternalHelper.java */
    static final class p<T, R> implements h.a.x0.o<List<j.d.b<? extends T>>, j.d.b<? extends R>> {
        private final h.a.x0.o<? super Object[], ? extends R> a;

        p(h.a.x0.o<? super Object[], ? extends R> oVar) {
            this.a = oVar;
        }

        @Override // h.a.x0.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public j.d.b<? extends R> apply(List<j.d.b<? extends T>> list) {
            return h.a.l.a((Iterable) list, (h.a.x0.o) this.a, false, h.a.l.Q());
        }
    }

    private p1() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, S> h.a.x0.c<S, h.a.k<T>, S> a(h.a.x0.g<h.a.k<T>> gVar) {
        return new k(gVar);
    }

    public static <T, U> h.a.x0.o<T, j.d.b<T>> b(h.a.x0.o<? super T, ? extends j.d.b<U>> oVar) {
        return new f(oVar);
    }

    public static <T> h.a.x0.g<T> c(j.d.c<T> cVar) {
        return new n(cVar);
    }

    public static <T, S> h.a.x0.c<S, h.a.k<T>, S> a(h.a.x0.b<S, h.a.k<T>> bVar) {
        return new j(bVar);
    }

    public static <T> h.a.x0.g<Throwable> b(j.d.c<T> cVar) {
        return new m(cVar);
    }

    public static <T, R> h.a.x0.o<List<j.d.b<? extends T>>, j.d.b<? extends R>> c(h.a.x0.o<? super Object[], ? extends R> oVar) {
        return new p(oVar);
    }

    public static <T> h.a.x0.a a(j.d.c<T> cVar) {
        return new l(cVar);
    }

    public static <T, U, R> h.a.x0.o<T, j.d.b<R>> a(h.a.x0.o<? super T, ? extends j.d.b<? extends U>> oVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        return new e(cVar, oVar);
    }

    public static <T, U> h.a.x0.o<T, j.d.b<U>> a(h.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
        return new c(oVar);
    }

    public static <T> Callable<h.a.w0.a<T>> a(h.a.l<T> lVar) {
        return new g(lVar);
    }

    public static <T> Callable<h.a.w0.a<T>> a(h.a.l<T> lVar, int i2) {
        return new a(lVar, i2);
    }

    public static <T> Callable<h.a.w0.a<T>> a(h.a.l<T> lVar, int i2, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
        return new b(lVar, i2, j2, timeUnit, j0Var);
    }

    public static <T> Callable<h.a.w0.a<T>> a(h.a.l<T> lVar, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
        return new o(lVar, j2, timeUnit, j0Var);
    }

    public static <T, R> h.a.x0.o<h.a.l<T>, j.d.b<R>> a(h.a.x0.o<? super h.a.l<T>, ? extends j.d.b<R>> oVar, h.a.j0 j0Var) {
        return new h(oVar, j0Var);
    }
}
