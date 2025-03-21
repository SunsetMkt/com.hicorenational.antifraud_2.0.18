package p031c.p035b.p043c.p070y.p071a;

/* compiled from: EmailAddressParsedResult.java */
/* renamed from: c.b.c.y.a.h */
/* loaded from: classes.dex */
public final class C1139h extends AbstractC1152q {

    /* renamed from: b */
    private final String[] f2325b;

    /* renamed from: c */
    private final String[] f2326c;

    /* renamed from: d */
    private final String[] f2327d;

    /* renamed from: e */
    private final String f2328e;

    /* renamed from: f */
    private final String f2329f;

    C1139h(String str) {
        this(new String[]{str}, null, null, null, null);
    }

    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1152q
    /* renamed from: a */
    public String mo2006a() {
        StringBuilder sb = new StringBuilder(30);
        AbstractC1152q.m2116a(this.f2325b, sb);
        AbstractC1152q.m2116a(this.f2326c, sb);
        AbstractC1152q.m2116a(this.f2327d, sb);
        AbstractC1152q.m2115a(this.f2328e, sb);
        AbstractC1152q.m2115a(this.f2329f, sb);
        return sb.toString();
    }

    /* renamed from: c */
    public String[] m2063c() {
        return this.f2327d;
    }

    /* renamed from: d */
    public String m2064d() {
        return this.f2329f;
    }

    /* renamed from: e */
    public String[] m2065e() {
        return this.f2326c;
    }

    @Deprecated
    /* renamed from: f */
    public String m2066f() {
        String[] strArr = this.f2325b;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        return strArr[0];
    }

    @Deprecated
    /* renamed from: g */
    public String m2067g() {
        return "mailto:";
    }

    /* renamed from: h */
    public String m2068h() {
        return this.f2328e;
    }

    /* renamed from: i */
    public String[] m2069i() {
        return this.f2325b;
    }

    C1139h(String[] strArr, String[] strArr2, String[] strArr3, String str, String str2) {
        super(EnumC1153r.EMAIL_ADDRESS);
        this.f2325b = strArr;
        this.f2326c = strArr2;
        this.f2327d = strArr3;
        this.f2328e = str;
        this.f2329f = str2;
    }
}
