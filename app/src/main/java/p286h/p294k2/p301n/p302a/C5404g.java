package p286h.p294k2.p301n.p302a;

import java.lang.reflect.Field;
import java.util.ArrayList;
import p286h.C5226e1;
import p286h.InterfaceC5610t0;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: DebugMetadata.kt */
/* renamed from: h.k2.n.a.g */
/* loaded from: classes2.dex */
public final class C5404g {

    /* renamed from: a */
    private static final int f20289a = 1;

    /* renamed from: a */
    private static final InterfaceC5403f m22135a(@InterfaceC5816d AbstractC5398a abstractC5398a) {
        return (InterfaceC5403f) abstractC5398a.getClass().getAnnotation(InterfaceC5403f.class);
    }

    /* renamed from: b */
    private static final int m22137b(@InterfaceC5816d AbstractC5398a abstractC5398a) {
        try {
            Field declaredField = abstractC5398a.getClass().getDeclaredField("label");
            C5544i0.m22521a((Object) declaredField, "field");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(abstractC5398a);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @InterfaceC5481e(name = "getSpilledVariableFieldMapping")
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5817e
    /* renamed from: c */
    public static final String[] m22138c(@InterfaceC5816d AbstractC5398a abstractC5398a) {
        C5544i0.m22546f(abstractC5398a, "$this$getSpilledVariableFieldMapping");
        InterfaceC5403f m22135a = m22135a(abstractC5398a);
        if (m22135a == null) {
            return null;
        }
        m22136a(1, m22135a.m22134v());
        ArrayList arrayList = new ArrayList();
        int m22137b = m22137b(abstractC5398a);
        int[] m22129i = m22135a.m22129i();
        int length = m22129i.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m22129i[i2] == m22137b) {
                arrayList.add(m22135a.m22133s()[i2]);
                arrayList.add(m22135a.m22132n()[i2]);
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @InterfaceC5481e(name = "getStackTraceElement")
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5817e
    /* renamed from: d */
    public static final StackTraceElement m22139d(@InterfaceC5816d AbstractC5398a abstractC5398a) {
        String str;
        C5544i0.m22546f(abstractC5398a, "$this$getStackTraceElementImpl");
        InterfaceC5403f m22135a = m22135a(abstractC5398a);
        if (m22135a == null) {
            return null;
        }
        m22136a(1, m22135a.m22134v());
        int m22137b = m22137b(abstractC5398a);
        int i2 = m22137b < 0 ? -1 : m22135a.m22130l()[m22137b];
        String m22144a = C5406i.f20292c.m22144a(abstractC5398a);
        if (m22144a == null) {
            str = m22135a.m22127c();
        } else {
            str = m22144a + '/' + m22135a.m22127c();
        }
        return new StackTraceElement(str, m22135a.m22131m(), m22135a.m22128f(), i2);
    }

    /* renamed from: a */
    private static final void m22136a(int i2, int i3) {
        if (i3 <= i2) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i2 + ", got " + i3 + ". Please update the Kotlin standard library.").toString());
    }
}
