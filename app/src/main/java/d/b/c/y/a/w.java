package d.b.c.y.a;

import com.just.agentweb.DefaultWebClient;

/* JADX INFO: compiled from: SMSParsedResult.java */
/* JADX INFO: loaded from: classes.dex */
public final class w extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String[] f9986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String[] f9987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f9988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f9989e;

    public w(String str, String str2, String str3, String str4) {
        super(r.SMS);
        this.f9986b = new String[]{str};
        this.f9987c = new String[]{str2};
        this.f9988d = str3;
        this.f9989e = str4;
    }

    @Override // d.b.c.y.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        q.a(this.f9986b, sb);
        q.a(this.f9988d, sb);
        q.a(this.f9989e, sb);
        return sb.toString();
    }

    public String c() {
        return this.f9989e;
    }

    public String[] d() {
        return this.f9986b;
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        sb.append(DefaultWebClient.SCHEME_SMS);
        boolean z = true;
        for (int i2 = 0; i2 < this.f9986b.length; i2++) {
            if (z) {
                z = false;
            } else {
                sb.append(',');
            }
            sb.append(this.f9986b[i2]);
            String[] strArr = this.f9987c;
            if (strArr != null && strArr[i2] != null) {
                sb.append(";via=");
                sb.append(this.f9987c[i2]);
            }
        }
        boolean z2 = this.f9989e != null;
        boolean z3 = this.f9988d != null;
        if (z2 || z3) {
            sb.append('?');
            if (z2) {
                sb.append("body=");
                sb.append(this.f9989e);
            }
            if (z3) {
                if (z2) {
                    sb.append(i.z2.h0.f12423c);
                }
                sb.append("subject=");
                sb.append(this.f9988d);
            }
        }
        return sb.toString();
    }

    public String f() {
        return this.f9988d;
    }

    public String[] g() {
        return this.f9987c;
    }

    public w(String[] strArr, String[] strArr2, String str, String str2) {
        super(r.SMS);
        this.f9986b = strArr;
        this.f9987c = strArr2;
        this.f9988d = str;
        this.f9989e = str2;
    }
}
