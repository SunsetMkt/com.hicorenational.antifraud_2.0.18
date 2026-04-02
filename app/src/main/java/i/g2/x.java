package i.g2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: CollectionsJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
public class x {
    @j.c.a.d
    public static <T> List<T> a(T t) {
        List<T> listSingletonList = Collections.singletonList(t);
        i.q2.t.i0.a((Object) listSingletonList, "java.util.Collections.singletonList(element)");
        return listSingletonList;
    }

    @i.n0
    @i.t0(version = "1.3")
    @i.m2.f
    private static final int b(int i2) {
        if (i2 < 0) {
            if (!i.m2.l.a(1, 3, 0)) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            y.f();
        }
        return i2;
    }

    @i.m2.f
    private static final <T> List<T> a(@j.c.a.d Enumeration<T> enumeration) {
        ArrayList list = Collections.list(enumeration);
        i.q2.t.i0.a((Object) list, "java.util.Collections.list(this)");
        return list;
    }

    @i.m2.f
    private static final Object[] a(Collection<?> collection) {
        return i.q2.t.u.a(collection);
    }

    @i.m2.f
    private static final <T> T[] a(Collection<?> collection, T[] tArr) {
        if (tArr == null) {
            throw new i.e1("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        T[] tArr2 = (T[]) i.q2.t.u.a(collection, tArr);
        if (tArr2 != null) {
            return tArr2;
        }
        throw new i.e1("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @j.c.a.d
    public static final <T> Object[] a(@j.c.a.d T[] tArr, boolean z) {
        i.q2.t.i0.f(tArr, "$this$copyToArrayOfAny");
        if (z && i.q2.t.i0.a(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        i.q2.t.i0.a((Object) objArrCopyOf, "java.util.Arrays.copyOf(\u2026 Array<Any?>::class.java)");
        return objArrCopyOf;
    }

    @i.n0
    @i.t0(version = "1.3")
    @i.m2.f
    private static final int a(int i2) {
        if (i2 < 0) {
            if (i.m2.l.a(1, 3, 0)) {
                y.e();
            } else {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i2;
    }
}
