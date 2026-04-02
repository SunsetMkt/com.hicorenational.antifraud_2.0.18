package h.a.y0.e.d;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ObservableInternalHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m1 {

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class a<T> implements Callable<h.a.z0.a<T>> {
        private final h.a.b0<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f11479b;

        a(h.a.b0<T> b0Var, int i2) {
            this.a = b0Var;
            this.f11479b = i2;
        }

        @Override // java.util.concurrent.Callable
        public h.a.z0.a<T> call() {
            return this.a.d(this.f11479b);
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class b<T> implements Callable<h.a.z0.a<T>> {
        private final h.a.b0<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f11480b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f11481c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final TimeUnit f11482d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final h.a.j0 f11483e;

        b(h.a.b0<T> b0Var, int i2, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
            this.a = b0Var;
            this.f11480b = i2;
            this.f11481c = j2;
            this.f11482d = timeUnit;
            this.f11483e = j0Var;
        }

        @Override // java.util.concurrent.Callable
        public h.a.z0.a<T> call() {
            return this.a.a(this.f11480b, this.f11481c, this.f11482d, this.f11483e);
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    enum c implements h.a.x0.o<h.a.a0<Object>, Throwable>, h.a.x0.r<h.a.a0<Object>> {
        INSTANCE;

        @Override // h.a.x0.o
        public Throwable apply(h.a.a0<Object> a0Var) throws Exception {
            return a0Var.a();
        }

        @Override // h.a.x0.r
        public boolean test(h.a.a0<Object> a0Var) throws Exception {
            return a0Var.d();
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class d<T, U> implements h.a.x0.o<T, h.a.g0<U>> {
        private final h.a.x0.o<? super T, ? extends Iterable<? extends U>> a;

        d(h.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
            this.a = oVar;
        }

        @Override // h.a.x0.o
        public h.a.g0<U> apply(T t) throws Exception {
            return new d1((Iterable) h.a.y0.b.b.a(this.a.apply(t), "The mapper returned a null Iterable"));
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class e<U, R, T> implements h.a.x0.o<U, R> {
        private final h.a.x0.c<? super T, ? super U, ? extends R> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final T f11484b;

        e(h.a.x0.c<? super T, ? super U, ? extends R> cVar, T t) {
            this.a = cVar;
            this.f11484b = t;
        }

        @Override // h.a.x0.o
        public R apply(U u) throws Exception {
            return this.a.apply(this.f11484b, u);
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class f<T, R, U> implements h.a.x0.o<T, h.a.g0<R>> {
        private final h.a.x0.c<? super T, ? super U, ? extends R> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h.a.x0.o<? super T, ? extends h.a.g0<? extends U>> f11485b;

        f(h.a.x0.c<? super T, ? super U, ? extends R> cVar, h.a.x0.o<? super T, ? extends h.a.g0<? extends U>> oVar) {
            this.a = cVar;
            this.f11485b = oVar;
        }

        @Override // h.a.x0.o
        public h.a.g0<R> apply(T t) throws Exception {
            return new u1((h.a.g0) h.a.y0.b.b.a(this.f11485b.apply(t), "The mapper returned a null ObservableSource"), new e(this.a, t));
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class g<T, U> implements h.a.x0.o<T, h.a.g0<T>> {
        final h.a.x0.o<? super T, ? extends h.a.g0<U>> a;

        g(h.a.x0.o<? super T, ? extends h.a.g0<U>> oVar) {
            this.a = oVar;
        }

        @Override // h.a.x0.o
        public h.a.g0<T> apply(T t) throws Exception {
            return new i3((h.a.g0) h.a.y0.b.b.a(this.a.apply(t), "The itemDelay returned a null ObservableSource"), 1L).p(h.a.y0.b.a.c(t)).f(t);
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    enum h implements h.a.x0.o<Object, Object> {
        INSTANCE;

        @Override // h.a.x0.o
        public Object apply(Object obj) throws Exception {
            return 0;
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class i<T, R> implements h.a.x0.o<T, h.a.b0<R>> {
        final h.a.x0.o<? super T, ? extends h.a.q0<? extends R>> a;

        i(h.a.x0.o<? super T, ? extends h.a.q0<? extends R>> oVar) {
            this.a = oVar;
        }

        @Override // h.a.x0.o
        public h.a.b0<R> apply(T t) throws Exception {
            return h.a.c1.a.a(new h.a.y0.e.f.r0((h.a.q0) h.a.y0.b.b.a(this.a.apply(t), "The mapper returned a null SingleSource")));
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class j<T> implements h.a.x0.a {
        final h.a.i0<T> a;

        j(h.a.i0<T> i0Var) {
            this.a = i0Var;
        }

        @Override // h.a.x0.a
        public void run() throws Exception {
            this.a.onComplete();
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class k<T> implements h.a.x0.g<Throwable> {
        final h.a.i0<T> a;

        k(h.a.i0<T> i0Var) {
            this.a = i0Var;
        }

        @Override // h.a.x0.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            this.a.onError(th);
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class l<T> implements h.a.x0.g<T> {
        final h.a.i0<T> a;

        l(h.a.i0<T> i0Var) {
            this.a = i0Var;
        }

        @Override // h.a.x0.g
        public void accept(T t) throws Exception {
            this.a.onNext(t);
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class m implements h.a.x0.o<h.a.b0<h.a.a0<Object>>, h.a.g0<?>> {
        private final h.a.x0.o<? super h.a.b0<Object>, ? extends h.a.g0<?>> a;

        m(h.a.x0.o<? super h.a.b0<Object>, ? extends h.a.g0<?>> oVar) {
            this.a = oVar;
        }

        @Override // h.a.x0.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h.a.g0<?> apply(h.a.b0<h.a.a0<Object>> b0Var) throws Exception {
            return this.a.apply(b0Var.p(h.INSTANCE));
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class n<T> implements Callable<h.a.z0.a<T>> {
        private final h.a.b0<T> a;

        n(h.a.b0<T> b0Var) {
            this.a = b0Var;
        }

        @Override // java.util.concurrent.Callable
        public h.a.z0.a<T> call() {
            return this.a.x();
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class o<T, R> implements h.a.x0.o<h.a.b0<T>, h.a.g0<R>> {
        private final h.a.x0.o<? super h.a.b0<T>, ? extends h.a.g0<R>> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h.a.j0 f11486b;

        o(h.a.x0.o<? super h.a.b0<T>, ? extends h.a.g0<R>> oVar, h.a.j0 j0Var) {
            this.a = oVar;
            this.f11486b = j0Var;
        }

        @Override // h.a.x0.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h.a.g0<R> apply(h.a.b0<T> b0Var) throws Exception {
            return h.a.b0.v((h.a.g0) h.a.y0.b.b.a(this.a.apply(b0Var), "The selector returned a null ObservableSource")).a(this.f11486b);
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class p implements h.a.x0.o<h.a.b0<h.a.a0<Object>>, h.a.g0<?>> {
        private final h.a.x0.o<? super h.a.b0<Throwable>, ? extends h.a.g0<?>> a;

        p(h.a.x0.o<? super h.a.b0<Throwable>, ? extends h.a.g0<?>> oVar) {
            this.a = oVar;
        }

        @Override // h.a.x0.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h.a.g0<?> apply(h.a.b0<h.a.a0<Object>> b0Var) throws Exception {
            return this.a.apply(b0Var.h((h.a.x0.r<? super h.a.a0<Object>>) c.INSTANCE).p(c.INSTANCE));
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class q<T, S> implements h.a.x0.c<S, h.a.k<T>, S> {
        final h.a.x0.b<S, h.a.k<T>> a;

        q(h.a.x0.b<S, h.a.k<T>> bVar) {
            this.a = bVar;
        }

        @Override // h.a.x0.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public S apply(S s, h.a.k<T> kVar) throws Exception {
            this.a.a(s, kVar);
            return s;
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class r<T, S> implements h.a.x0.c<S, h.a.k<T>, S> {
        final h.a.x0.g<h.a.k<T>> a;

        r(h.a.x0.g<h.a.k<T>> gVar) {
            this.a = gVar;
        }

        @Override // h.a.x0.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public S apply(S s, h.a.k<T> kVar) throws Exception {
            this.a.accept(kVar);
            return s;
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class s<T> implements Callable<h.a.z0.a<T>> {
        private final h.a.b0<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f11487b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final TimeUnit f11488c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final h.a.j0 f11489d;

        s(h.a.b0<T> b0Var, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
            this.a = b0Var;
            this.f11487b = j2;
            this.f11488c = timeUnit;
            this.f11489d = j0Var;
        }

        @Override // java.util.concurrent.Callable
        public h.a.z0.a<T> call() {
            return this.a.e(this.f11487b, this.f11488c, this.f11489d);
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class t<T, R> implements h.a.x0.o<List<h.a.g0<? extends T>>, h.a.g0<? extends R>> {
        private final h.a.x0.o<? super Object[], ? extends R> a;

        t(h.a.x0.o<? super Object[], ? extends R> oVar) {
            this.a = oVar;
        }

        @Override // h.a.x0.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h.a.g0<? extends R> apply(List<h.a.g0<? extends T>> list) {
            return h.a.b0.a((Iterable) list, (h.a.x0.o) this.a, false, h.a.b0.L());
        }
    }

    private m1() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, S> h.a.x0.c<S, h.a.k<T>, S> a(h.a.x0.g<h.a.k<T>> gVar) {
        return new r(gVar);
    }

    public static <T> h.a.x0.g<Throwable> b(h.a.i0<T> i0Var) {
        return new k(i0Var);
    }

    public static <T, U> h.a.x0.o<T, h.a.g0<T>> c(h.a.x0.o<? super T, ? extends h.a.g0<U>> oVar) {
        return new g(oVar);
    }

    public static h.a.x0.o<h.a.b0<h.a.a0<Object>>, h.a.g0<?>> d(h.a.x0.o<? super h.a.b0<Object>, ? extends h.a.g0<?>> oVar) {
        return new m(oVar);
    }

    public static <T> h.a.x0.o<h.a.b0<h.a.a0<Object>>, h.a.g0<?>> e(h.a.x0.o<? super h.a.b0<Throwable>, ? extends h.a.g0<?>> oVar) {
        return new p(oVar);
    }

    public static <T, R> h.a.x0.o<List<h.a.g0<? extends T>>, h.a.g0<? extends R>> f(h.a.x0.o<? super Object[], ? extends R> oVar) {
        return new t(oVar);
    }

    public static <T, S> h.a.x0.c<S, h.a.k<T>, S> a(h.a.x0.b<S, h.a.k<T>> bVar) {
        return new q(bVar);
    }

    public static <T, U> h.a.x0.o<T, h.a.g0<U>> b(h.a.x0.o<? super T, ? extends Iterable<? extends U>> oVar) {
        return new d(oVar);
    }

    public static <T> h.a.x0.g<T> c(h.a.i0<T> i0Var) {
        return new l(i0Var);
    }

    public static <T> h.a.x0.a a(h.a.i0<T> i0Var) {
        return new j(i0Var);
    }

    public static <T, R> h.a.b0<R> b(h.a.b0<T> b0Var, h.a.x0.o<? super T, ? extends h.a.q0<? extends R>> oVar) {
        return b0Var.g(a(oVar), 1);
    }

    public static <T, U, R> h.a.x0.o<T, h.a.g0<R>> a(h.a.x0.o<? super T, ? extends h.a.g0<? extends U>> oVar, h.a.x0.c<? super T, ? super U, ? extends R> cVar) {
        return new f(cVar, oVar);
    }

    public static <T> Callable<h.a.z0.a<T>> a(h.a.b0<T> b0Var) {
        return new n(b0Var);
    }

    public static <T> Callable<h.a.z0.a<T>> a(h.a.b0<T> b0Var, int i2) {
        return new a(b0Var, i2);
    }

    public static <T> Callable<h.a.z0.a<T>> a(h.a.b0<T> b0Var, int i2, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
        return new b(b0Var, i2, j2, timeUnit, j0Var);
    }

    public static <T> Callable<h.a.z0.a<T>> a(h.a.b0<T> b0Var, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
        return new s(b0Var, j2, timeUnit, j0Var);
    }

    public static <T, R> h.a.x0.o<h.a.b0<T>, h.a.g0<R>> a(h.a.x0.o<? super h.a.b0<T>, ? extends h.a.g0<R>> oVar, h.a.j0 j0Var) {
        return new o(oVar, j0Var);
    }

    public static <T, R> h.a.b0<R> a(h.a.b0<T> b0Var, h.a.x0.o<? super T, ? extends h.a.q0<? extends R>> oVar) {
        return b0Var.f(a(oVar), 1);
    }

    private static <T, R> h.a.x0.o<T, h.a.b0<R>> a(h.a.x0.o<? super T, ? extends h.a.q0<? extends R>> oVar) {
        h.a.y0.b.b.a(oVar, "mapper is null");
        return new i(oVar);
    }
}
