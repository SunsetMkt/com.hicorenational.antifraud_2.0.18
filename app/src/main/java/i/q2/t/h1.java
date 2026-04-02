package i.q2.t;

import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: Reflection.java */
/* JADX INFO: loaded from: classes2.dex */
public class h1 {
    private static final i1 a;

    /* JADX INFO: renamed from: b */
    static final String f12212b = " (Kotlin reflection is not available)";

    /* JADX INFO: renamed from: c */
    private static final i.w2.c[] f12213c;

    static {
        i1 i1Var = null;
        try {
            i1Var = (i1) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (i1Var == null) {
            i1Var = new i1();
        }
        a = i1Var;
        f12213c = new i.w2.c[0];
    }

    public static i.w2.c a(Class cls) {
        return a.a(cls);
    }

    public static i.w2.c b(Class cls) {
        return a.b(cls);
    }

    public static i.w2.f c(Class cls, String str) {
        return a.c(cls, str);
    }

    @i.t0(version = "1.4")
    public static i.w2.q d(Class cls) {
        return a.a(b(cls), Collections.emptyList(), false);
    }

    public static i.w2.c a(Class cls, String str) {
        return a.a(cls, str);
    }

    public static i.w2.c b(Class cls, String str) {
        return a.b(cls, str);
    }

    @i.t0(version = "1.4")
    public static i.w2.q c(Class cls) {
        return a.a(b(cls), Collections.emptyList(), true);
    }

    public static i.w2.c[] a(Class[] clsArr) {
        int length = clsArr.length;
        if (length == 0) {
            return f12213c;
        }
        i.w2.c[] cVarArr = new i.w2.c[length];
        for (int i2 = 0; i2 < length; i2++) {
            cVarArr[i2] = b(clsArr[i2]);
        }
        return cVarArr;
    }

    @i.t0(version = "1.4")
    public static i.w2.q b(Class cls, i.w2.s sVar) {
        return a.a(b(cls), Collections.singletonList(sVar), false);
    }

    @i.t0(version = "1.4")
    public static i.w2.q b(Class cls, i.w2.s sVar, i.w2.s sVar2) {
        return a.a(b(cls), Arrays.asList(sVar, sVar2), false);
    }

    @i.t0(version = "1.4")
    public static i.w2.q b(Class cls, i.w2.s... sVarArr) {
        return a.a(b(cls), i.g2.r.J(sVarArr), false);
    }

    @i.t0(version = "1.1")
    public static String a(j0 j0Var) {
        return a.a(j0Var);
    }

    @i.t0(version = "1.3")
    public static String a(b0 b0Var) {
        return a.a(b0Var);
    }

    public static i.w2.g a(d0 d0Var) {
        return a.a(d0Var);
    }

    public static i.w2.n a(z0 z0Var) {
        return a.a(z0Var);
    }

    public static i.w2.i a(q0 q0Var) {
        return a.a(q0Var);
    }

    public static i.w2.o a(b1 b1Var) {
        return a.a(b1Var);
    }

    public static i.w2.j a(s0 s0Var) {
        return a.a(s0Var);
    }

    public static i.w2.p a(d1 d1Var) {
        return a.a(d1Var);
    }

    public static i.w2.k a(u0 u0Var) {
        return a.a(u0Var);
    }

    @i.t0(version = "1.4")
    public static i.w2.q a(Class cls, i.w2.s sVar) {
        return a.a(b(cls), Collections.singletonList(sVar), true);
    }

    @i.t0(version = "1.4")
    public static i.w2.q a(Class cls, i.w2.s sVar, i.w2.s sVar2) {
        return a.a(b(cls), Arrays.asList(sVar, sVar2), true);
    }

    @i.t0(version = "1.4")
    public static i.w2.q a(Class cls, i.w2.s... sVarArr) {
        return a.a(b(cls), i.g2.r.J(sVarArr), true);
    }
}
