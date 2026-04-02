package i.q2.t;

import java.util.List;

/* JADX INFO: compiled from: ReflectionFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class i1 {
    private static final String a = "kotlin.jvm.functions.";

    public i.w2.c a(Class cls) {
        return new t(cls);
    }

    public i.w2.g a(d0 d0Var) {
        return d0Var;
    }

    public i.w2.i a(q0 q0Var) {
        return q0Var;
    }

    public i.w2.j a(s0 s0Var) {
        return s0Var;
    }

    public i.w2.k a(u0 u0Var) {
        return u0Var;
    }

    public i.w2.n a(z0 z0Var) {
        return z0Var;
    }

    public i.w2.o a(b1 b1Var) {
        return b1Var;
    }

    public i.w2.p a(d1 d1Var) {
        return d1Var;
    }

    public i.w2.c b(Class cls) {
        return new t(cls);
    }

    public i.w2.f c(Class cls, String str) {
        return new x0(cls, str);
    }

    public i.w2.c a(Class cls, String str) {
        return new t(cls);
    }

    public i.w2.c b(Class cls, String str) {
        return new t(cls);
    }

    @i.t0(version = "1.1")
    public String a(j0 j0Var) {
        return a((b0) j0Var);
    }

    @i.t0(version = "1.3")
    public String a(b0 b0Var) {
        String string = b0Var.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith(a) ? string.substring(21) : string;
    }

    @i.t0(version = "1.4")
    public i.w2.q a(i.w2.e eVar, List<i.w2.s> list, boolean z) {
        return new p1(eVar, list, z);
    }
}
