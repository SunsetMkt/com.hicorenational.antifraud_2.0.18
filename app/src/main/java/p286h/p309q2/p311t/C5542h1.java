package p286h.p309q2.p311t;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p286h.InterfaceC5610t0;
import p286h.p289g2.C5294r;
import p286h.p320w2.C5678s;
import p286h.p320w2.InterfaceC5662c;
import p286h.p320w2.InterfaceC5665f;
import p286h.p320w2.InterfaceC5666g;
import p286h.p320w2.InterfaceC5668i;
import p286h.p320w2.InterfaceC5669j;
import p286h.p320w2.InterfaceC5670k;
import p286h.p320w2.InterfaceC5673n;
import p286h.p320w2.InterfaceC5674o;
import p286h.p320w2.InterfaceC5675p;
import p286h.p320w2.InterfaceC5676q;

/* compiled from: Reflection.java */
/* renamed from: h.q2.t.h1 */
/* loaded from: classes2.dex */
public class C5542h1 {

    /* renamed from: a */
    private static final C5545i1 f20378a;

    /* renamed from: b */
    static final String f20379b = " (Kotlin reflection is not available)";

    /* renamed from: c */
    private static final InterfaceC5662c[] f20380c;

    static {
        C5545i1 c5545i1 = null;
        try {
            c5545i1 = (C5545i1) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (c5545i1 == null) {
            c5545i1 = new C5545i1();
        }
        f20378a = c5545i1;
        f20380c = new InterfaceC5662c[0];
    }

    /* renamed from: a */
    public static InterfaceC5662c m22481a(Class cls) {
        return f20378a.m22555a(cls);
    }

    /* renamed from: b */
    public static InterfaceC5662c m22496b(Class cls) {
        return f20378a.m22567b(cls);
    }

    /* renamed from: c */
    public static InterfaceC5665f m22501c(Class cls, String str) {
        return f20378a.m22569c(cls, str);
    }

    @InterfaceC5610t0(version = "1.4")
    /* renamed from: d */
    public static InterfaceC5676q m22503d(Class cls) {
        return f20378a.m22564a(m22496b(cls), Collections.emptyList(), false);
    }

    /* renamed from: a */
    public static InterfaceC5662c m22482a(Class cls, String str) {
        return f20378a.m22556a(cls, str);
    }

    /* renamed from: b */
    public static InterfaceC5662c m22497b(Class cls, String str) {
        return f20378a.m22568b(cls, str);
    }

    @InterfaceC5610t0(version = "1.4")
    /* renamed from: c */
    public static InterfaceC5676q m22502c(Class cls) {
        return f20378a.m22564a(m22496b(cls), Collections.emptyList(), true);
    }

    /* renamed from: a */
    public static InterfaceC5662c[] m22495a(Class[] clsArr) {
        int length = clsArr.length;
        if (length == 0) {
            return f20380c;
        }
        InterfaceC5662c[] interfaceC5662cArr = new InterfaceC5662c[length];
        for (int i2 = 0; i2 < length; i2++) {
            interfaceC5662cArr[i2] = m22496b(clsArr[i2]);
        }
        return interfaceC5662cArr;
    }

    @InterfaceC5610t0(version = "1.4")
    /* renamed from: b */
    public static InterfaceC5676q m22498b(Class cls, C5678s c5678s) {
        return f20378a.m22564a(m22496b(cls), Collections.singletonList(c5678s), false);
    }

    @InterfaceC5610t0(version = "1.4")
    /* renamed from: b */
    public static InterfaceC5676q m22499b(Class cls, C5678s c5678s, C5678s c5678s2) {
        return f20378a.m22564a(m22496b(cls), Arrays.asList(c5678s, c5678s2), false);
    }

    @InterfaceC5610t0(version = "1.4")
    /* renamed from: b */
    public static InterfaceC5676q m22500b(Class cls, C5678s... c5678sArr) {
        List<C5678s> m20544J;
        C5545i1 c5545i1 = f20378a;
        InterfaceC5662c m22496b = m22496b(cls);
        m20544J = C5294r.m20544J(c5678sArr);
        return c5545i1.m22564a(m22496b, m20544J, false);
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    public static String m22494a(AbstractC5547j0 abstractC5547j0) {
        return f20378a.m22566a(abstractC5547j0);
    }

    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    public static String m22493a(InterfaceC5523b0 interfaceC5523b0) {
        return f20378a.m22565a(interfaceC5523b0);
    }

    /* renamed from: a */
    public static InterfaceC5666g m22483a(C5529d0 c5529d0) {
        return f20378a.m22557a(c5529d0);
    }

    /* renamed from: a */
    public static InterfaceC5673n m22487a(AbstractC5595z0 abstractC5595z0) {
        return f20378a.m22561a(abstractC5595z0);
    }

    /* renamed from: a */
    public static InterfaceC5668i m22484a(AbstractC5568q0 abstractC5568q0) {
        return f20378a.m22558a(abstractC5568q0);
    }

    /* renamed from: a */
    public static InterfaceC5674o m22488a(AbstractC5524b1 abstractC5524b1) {
        return f20378a.m22562a(abstractC5524b1);
    }

    /* renamed from: a */
    public static InterfaceC5669j m22485a(AbstractC5581s0 abstractC5581s0) {
        return f20378a.m22559a(abstractC5581s0);
    }

    /* renamed from: a */
    public static InterfaceC5675p m22489a(AbstractC5530d1 abstractC5530d1) {
        return f20378a.m22563a(abstractC5530d1);
    }

    /* renamed from: a */
    public static InterfaceC5670k m22486a(AbstractC5585u0 abstractC5585u0) {
        return f20378a.m22560a(abstractC5585u0);
    }

    @InterfaceC5610t0(version = "1.4")
    /* renamed from: a */
    public static InterfaceC5676q m22490a(Class cls, C5678s c5678s) {
        return f20378a.m22564a(m22496b(cls), Collections.singletonList(c5678s), true);
    }

    @InterfaceC5610t0(version = "1.4")
    /* renamed from: a */
    public static InterfaceC5676q m22491a(Class cls, C5678s c5678s, C5678s c5678s2) {
        return f20378a.m22564a(m22496b(cls), Arrays.asList(c5678s, c5678s2), true);
    }

    @InterfaceC5610t0(version = "1.4")
    /* renamed from: a */
    public static InterfaceC5676q m22492a(Class cls, C5678s... c5678sArr) {
        List<C5678s> m20544J;
        C5545i1 c5545i1 = f20378a;
        InterfaceC5662c m22496b = m22496b(cls);
        m20544J = C5294r.m20544J(c5678sArr);
        return c5545i1.m22564a(m22496b, m20544J, true);
    }
}
