package h.a.e1;

import h.a.j0;
import h.a.y0.g.o;
import h.a.y0.g.q;
import h.a.y0.g.r;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Schedulers.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    @h.a.t0.f
    static final j0 a = h.a.c1.a.e(new h());

    /* JADX INFO: renamed from: b */
    @h.a.t0.f
    static final j0 f10321b = h.a.c1.a.b(new b());

    /* JADX INFO: renamed from: c */
    @h.a.t0.f
    static final j0 f10322c = h.a.c1.a.c(new c());

    /* JADX INFO: renamed from: d */
    @h.a.t0.f
    static final j0 f10323d = r.e();

    /* JADX INFO: renamed from: e */
    @h.a.t0.f
    static final j0 f10324e = h.a.c1.a.d(new f());

    /* JADX INFO: renamed from: h.a.e1.a$a */
    /* JADX INFO: compiled from: Schedulers.java */
    static final class C0173a {
        static final j0 a = new h.a.y0.g.b();

        C0173a() {
        }
    }

    /* JADX INFO: compiled from: Schedulers.java */
    static final class b implements Callable<j0> {
        b() {
        }

        @Override // java.util.concurrent.Callable
        public j0 call() throws Exception {
            return C0173a.a;
        }
    }

    /* JADX INFO: compiled from: Schedulers.java */
    static final class c implements Callable<j0> {
        c() {
        }

        @Override // java.util.concurrent.Callable
        public j0 call() throws Exception {
            return d.a;
        }
    }

    /* JADX INFO: compiled from: Schedulers.java */
    static final class d {
        static final j0 a = new h.a.y0.g.g();

        d() {
        }
    }

    /* JADX INFO: compiled from: Schedulers.java */
    static final class e {
        static final j0 a = new h.a.y0.g.h();

        e() {
        }
    }

    /* JADX INFO: compiled from: Schedulers.java */
    static final class f implements Callable<j0> {
        f() {
        }

        @Override // java.util.concurrent.Callable
        public j0 call() throws Exception {
            return e.a;
        }
    }

    /* JADX INFO: compiled from: Schedulers.java */
    static final class g {
        static final j0 a = new q();

        g() {
        }
    }

    /* JADX INFO: compiled from: Schedulers.java */
    static final class h implements Callable<j0> {
        h() {
        }

        @Override // java.util.concurrent.Callable
        public j0 call() throws Exception {
            return g.a;
        }
    }

    private a() {
        throw new IllegalStateException("No instances!");
    }

    @h.a.t0.f
    public static j0 a() {
        return h.a.c1.a.a(f10321b);
    }

    @h.a.t0.f
    public static j0 b() {
        return h.a.c1.a.b(f10322c);
    }

    @h.a.t0.f
    public static j0 c() {
        return h.a.c1.a.c(f10324e);
    }

    public static void d() {
        a().b();
        b().b();
        c().b();
        e().b();
        g().b();
        o.a();
    }

    @h.a.t0.f
    public static j0 e() {
        return h.a.c1.a.d(a);
    }

    public static void f() {
        a().c();
        b().c();
        c().c();
        e().c();
        g().c();
        o.b();
    }

    @h.a.t0.f
    public static j0 g() {
        return f10323d;
    }

    @h.a.t0.f
    public static j0 a(@h.a.t0.f Executor executor) {
        return new h.a.y0.g.d(executor);
    }
}
