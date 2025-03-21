package p031c.p035b.p043c.p070y.p071a;

import com.just.agentweb.DefaultWebClient;
import p286h.p323z2.C5736h0;

/* compiled from: SMSParsedResult.java */
/* renamed from: c.b.c.y.a.w */
/* loaded from: classes.dex */
public final class C1158w extends AbstractC1152q {

    /* renamed from: b */
    private final String[] f2379b;

    /* renamed from: c */
    private final String[] f2380c;

    /* renamed from: d */
    private final String f2381d;

    /* renamed from: e */
    private final String f2382e;

    public C1158w(String str, String str2, String str3, String str4) {
        super(EnumC1153r.SMS);
        this.f2379b = new String[]{str};
        this.f2380c = new String[]{str2};
        this.f2381d = str3;
        this.f2382e = str4;
    }

    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1152q
    /* renamed from: a */
    public String mo2006a() {
        StringBuilder sb = new StringBuilder(100);
        AbstractC1152q.m2116a(this.f2379b, sb);
        AbstractC1152q.m2115a(this.f2381d, sb);
        AbstractC1152q.m2115a(this.f2382e, sb);
        return sb.toString();
    }

    /* renamed from: c */
    public String m2136c() {
        return this.f2382e;
    }

    /* renamed from: d */
    public String[] m2137d() {
        return this.f2379b;
    }

    /* renamed from: e */
    public String m2138e() {
        StringBuilder sb = new StringBuilder();
        sb.append(DefaultWebClient.SCHEME_SMS);
        boolean z = true;
        for (int i2 = 0; i2 < this.f2379b.length; i2++) {
            if (z) {
                z = false;
            } else {
                sb.append(',');
            }
            sb.append(this.f2379b[i2]);
            String[] strArr = this.f2380c;
            if (strArr != null && strArr[i2] != null) {
                sb.append(";via=");
                sb.append(this.f2380c[i2]);
            }
        }
        boolean z2 = this.f2382e != null;
        boolean z3 = this.f2381d != null;
        if (z2 || z3) {
            sb.append('?');
            if (z2) {
                sb.append("body=");
                sb.append(this.f2382e);
            }
            if (z3) {
                if (z2) {
                    sb.append(C5736h0.f20714c);
                }
                sb.append("subject=");
                sb.append(this.f2381d);
            }
        }
        return sb.toString();
    }

    /* renamed from: f */
    public String m2139f() {
        return this.f2381d;
    }

    /* renamed from: g */
    public String[] m2140g() {
        return this.f2380c;
    }

    public C1158w(String[] strArr, String[] strArr2, String str, String str2) {
        super(EnumC1153r.SMS);
        this.f2379b = strArr;
        this.f2380c = strArr2;
        this.f2381d = str;
        this.f2382e = str2;
    }
}
