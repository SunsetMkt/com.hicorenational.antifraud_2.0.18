package p031c.p035b.p043c.p070y.p071a;

/* compiled from: ParsedResult.java */
/* renamed from: c.b.c.y.a.q */
/* loaded from: classes.dex */
public abstract class AbstractC1152q {

    /* renamed from: a */
    private final EnumC1153r f2370a;

    protected AbstractC1152q(EnumC1153r enumC1153r) {
        this.f2370a = enumC1153r;
    }

    /* renamed from: a */
    public static void m2115a(String str, StringBuilder sb) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append('\n');
        }
        sb.append(str);
    }

    /* renamed from: a */
    public abstract String mo2006a();

    /* renamed from: b */
    public final EnumC1153r m2117b() {
        return this.f2370a;
    }

    public final String toString() {
        return mo2006a();
    }

    /* renamed from: a */
    public static void m2116a(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String str : strArr) {
                m2115a(str, sb);
            }
        }
    }
}
