package p286h.p289g2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import p286h.C5226e1;
import p286h.InterfaceC5440n0;
import p286h.InterfaceC5610t0;
import p286h.p304m2.C5432l;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5584u;
import p324i.p336c.p337a.InterfaceC5816d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionsJVM.kt */
/* renamed from: h.g2.x */
/* loaded from: classes2.dex */
public class C5312x {
    @InterfaceC5816d
    /* renamed from: a */
    public static <T> List<T> m21750a(T t) {
        List<T> singletonList = Collections.singletonList(t);
        C5544i0.m22521a((Object) singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5440n0
    /* renamed from: b */
    private static final int m21755b(int i2) {
        if (i2 < 0) {
            if (!C5432l.m22181a(1, 3, 0)) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            C5315y.m21790f();
        }
        return i2;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final <T> List<T> m21751a(@InterfaceC5816d Enumeration<T> enumeration) {
        ArrayList list = Collections.list(enumeration);
        C5544i0.m22521a((Object) list, "java.util.Collections.list(this)");
        return list;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final Object[] m21752a(Collection<?> collection) {
        return C5584u.m22686a(collection);
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final <T> T[] m21753a(Collection<?> collection, T[] tArr) {
        if (tArr == null) {
            throw new C5226e1("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        T[] tArr2 = (T[]) C5584u.m22688a(collection, tArr);
        if (tArr2 != null) {
            return tArr2;
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> Object[] m21754a(@InterfaceC5816d T[] tArr, boolean z) {
        C5544i0.m22546f(tArr, "$this$copyToArrayOfAny");
        if (z && C5544i0.m22531a(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        C5544i0.m22521a((Object) copyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return copyOf;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5440n0
    /* renamed from: a */
    private static final int m21749a(int i2) {
        if (i2 < 0) {
            if (C5432l.m22181a(1, 3, 0)) {
                C5315y.m21789e();
            } else {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i2;
    }
}
