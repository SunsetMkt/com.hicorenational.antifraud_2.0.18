package h.k2.n.a;

import h.e1;
import h.q2.t.i0;
import h.t0;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* compiled from: DebugMetadata.kt */
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static final int f16301a = 1;

    private static final f a(@i.c.a.d a aVar) {
        return (f) aVar.getClass().getAnnotation(f.class);
    }

    private static final int b(@i.c.a.d a aVar) {
        try {
            Field declaredField = aVar.getClass().getDeclaredField("label");
            i0.a((Object) declaredField, "field");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(aVar);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @h.q2.e(name = "getSpilledVariableFieldMapping")
    @t0(version = "1.3")
    @i.c.a.e
    public static final String[] c(@i.c.a.d a aVar) {
        i0.f(aVar, "$this$getSpilledVariableFieldMapping");
        f a2 = a(aVar);
        if (a2 == null) {
            return null;
        }
        a(1, a2.v());
        ArrayList arrayList = new ArrayList();
        int b2 = b(aVar);
        int[] i2 = a2.i();
        int length = i2.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i2[i3] == b2) {
                arrayList.add(a2.s()[i3]);
                arrayList.add(a2.n()[i3]);
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new e1("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @h.q2.e(name = "getStackTraceElement")
    @t0(version = "1.3")
    @i.c.a.e
    public static final StackTraceElement d(@i.c.a.d a aVar) {
        String str;
        i0.f(aVar, "$this$getStackTraceElementImpl");
        f a2 = a(aVar);
        if (a2 == null) {
            return null;
        }
        a(1, a2.v());
        int b2 = b(aVar);
        int i2 = b2 < 0 ? -1 : a2.l()[b2];
        String a3 = i.f16304c.a(aVar);
        if (a3 == null) {
            str = a2.c();
        } else {
            str = a3 + '/' + a2.c();
        }
        return new StackTraceElement(str, a2.m(), a2.f(), i2);
    }

    private static final void a(int i2, int i3) {
        if (i3 <= i2) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i2 + ", got " + i3 + ". Please update the Kotlin standard library.").toString());
    }
}
