package p251g.p252a.p257e1;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p268y0.p281g.C5113b;
import p251g.p252a.p268y0.p281g.C5115d;
import p251g.p252a.p268y0.p281g.C5118g;
import p251g.p252a.p268y0.p281g.C5119h;
import p251g.p252a.p268y0.p281g.C5126o;
import p251g.p252a.p268y0.p281g.C5128q;
import p251g.p252a.p268y0.p281g.C5129r;

/* compiled from: Schedulers.java */
/* renamed from: g.a.e1.a */
/* loaded from: classes2.dex */
public final class C4488a {

    /* renamed from: a */
    @InterfaceC4546f
    static final AbstractC4516j0 f17318a = C4476a.m17166e(new h());

    /* renamed from: b */
    @InterfaceC4546f
    static final AbstractC4516j0 f17319b = C4476a.m17147b(new b());

    /* renamed from: c */
    @InterfaceC4546f
    static final AbstractC4516j0 f17320c = C4476a.m17154c(new c());

    /* renamed from: d */
    @InterfaceC4546f
    static final AbstractC4516j0 f17321d = C5129r.m18578e();

    /* renamed from: e */
    @InterfaceC4546f
    static final AbstractC4516j0 f17322e = C4476a.m17161d(new f());

    /* compiled from: Schedulers.java */
    /* renamed from: g.a.e1.a$a */
    static final class a {

        /* renamed from: a */
        static final AbstractC4516j0 f17323a = new C5113b();

        a() {
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: g.a.e1.a$b */
    static final class b implements Callable<AbstractC4516j0> {
        b() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public AbstractC4516j0 call() throws Exception {
            return a.f17323a;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: g.a.e1.a$c */
    static final class c implements Callable<AbstractC4516j0> {
        c() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public AbstractC4516j0 call() throws Exception {
            return d.f17324a;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: g.a.e1.a$d */
    static final class d {

        /* renamed from: a */
        static final AbstractC4516j0 f17324a = new C5118g();

        d() {
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: g.a.e1.a$e */
    static final class e {

        /* renamed from: a */
        static final AbstractC4516j0 f17325a = new C5119h();

        e() {
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: g.a.e1.a$f */
    static final class f implements Callable<AbstractC4516j0> {
        f() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public AbstractC4516j0 call() throws Exception {
            return e.f17325a;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: g.a.e1.a$g */
    static final class g {

        /* renamed from: a */
        static final AbstractC4516j0 f17326a = new C5128q();

        g() {
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: g.a.e1.a$h */
    static final class h implements Callable<AbstractC4516j0> {
        h() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public AbstractC4516j0 call() throws Exception {
            return g.f17326a;
        }
    }

    private C4488a() {
        throw new IllegalStateException("No instances!");
    }

    @InterfaceC4546f
    /* renamed from: a */
    public static AbstractC4516j0 m17267a() {
        return C4476a.m17124a(f17319b);
    }

    @InterfaceC4546f
    /* renamed from: b */
    public static AbstractC4516j0 m17269b() {
        return C4476a.m17146b(f17320c);
    }

    @InterfaceC4546f
    /* renamed from: c */
    public static AbstractC4516j0 m17270c() {
        return C4476a.m17153c(f17322e);
    }

    /* renamed from: d */
    public static void m17271d() {
        m17267a().mo17410b();
        m17269b().mo17410b();
        m17270c().mo17410b();
        m17272e().mo17410b();
        m17274g().mo17410b();
        C5126o.m18574a();
    }

    @InterfaceC4546f
    /* renamed from: e */
    public static AbstractC4516j0 m17272e() {
        return C4476a.m17160d(f17318a);
    }

    /* renamed from: f */
    public static void m17273f() {
        m17267a().mo17411c();
        m17269b().mo17411c();
        m17270c().mo17411c();
        m17272e().mo17411c();
        m17274g().mo17411c();
        C5126o.m18575b();
    }

    @InterfaceC4546f
    /* renamed from: g */
    public static AbstractC4516j0 m17274g() {
        return f17321d;
    }

    @InterfaceC4546f
    /* renamed from: a */
    public static AbstractC4516j0 m17268a(@InterfaceC4546f Executor executor) {
        return new C5115d(executor);
    }
}
