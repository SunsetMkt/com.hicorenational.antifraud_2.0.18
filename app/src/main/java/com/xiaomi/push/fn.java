package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class fn extends fo {
    private boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8989b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private boolean f526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f8992e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f8993f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f8994g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f8995h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f8996i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f8997j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f8998k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f8999l;

    public fn() {
        this.f8989b = null;
        this.f8990c = null;
        this.a = false;
        this.f8996i = "";
        this.f8997j = "";
        this.f8998k = "";
        this.f8999l = "";
        this.f526b = false;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public String b() {
        return this.f8989b;
    }

    public String c() {
        return this.f8995h;
    }

    public String d() {
        return this.f8996i;
    }

    public String e() {
        return this.f8997j;
    }

    @Override // com.xiaomi.push.fo
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || fn.class != obj.getClass()) {
            return false;
        }
        fn fnVar = (fn) obj;
        if (!super.equals(fnVar)) {
            return false;
        }
        String str = this.f8993f;
        if (str == null ? fnVar.f8993f != null : !str.equals(fnVar.f8993f)) {
            return false;
        }
        String str2 = this.f8991d;
        if (str2 == null ? fnVar.f8991d != null : !str2.equals(fnVar.f8991d)) {
            return false;
        }
        String str3 = this.f8992e;
        if (str3 == null ? fnVar.f8992e != null : !str3.equals(fnVar.f8992e)) {
            return false;
        }
        String str4 = this.f8990c;
        if (str4 == null ? fnVar.f8990c == null : str4.equals(fnVar.f8990c)) {
            return this.f8989b == fnVar.f8989b;
        }
        return false;
    }

    public String f() {
        return this.f8998k;
    }

    public String g() {
        return this.f8999l;
    }

    public void h(String str) {
        this.f8993f = str;
    }

    @Override // com.xiaomi.push.fo
    public int hashCode() {
        String str = this.f8989b;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f8993f;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f8990c;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f8991d;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f8992e;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public void i(String str) {
        this.f8990c = str;
    }

    public void j(String str) {
        this.f8991d = str;
    }

    public void a(String str) {
        this.f8995h = str;
    }

    public void b(String str) {
        this.f8996i = str;
    }

    public void c(String str) {
        this.f8997j = str;
    }

    public void d(String str) {
        this.f8998k = str;
    }

    public void e(String str) {
        this.f8999l = str;
    }

    public void f(String str) {
        this.f8989b = str;
    }

    public void g(String str) {
        this.f8992e = str;
    }

    public String h() {
        return this.f8991d;
    }

    public void a(String str, String str2) {
        this.f8993f = str;
        this.f8994g = str2;
    }

    public void b(boolean z) {
        this.f526b = z;
    }

    @Override // com.xiaomi.push.fo
    public Bundle a() {
        Bundle bundleA = super.a();
        if (!TextUtils.isEmpty(this.f8989b)) {
            bundleA.putString("ext_msg_type", this.f8989b);
        }
        String str = this.f8991d;
        if (str != null) {
            bundleA.putString("ext_msg_lang", str);
        }
        String str2 = this.f8992e;
        if (str2 != null) {
            bundleA.putString("ext_msg_sub", str2);
        }
        String str3 = this.f8993f;
        if (str3 != null) {
            bundleA.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.f8994g)) {
            bundleA.putString("ext_body_encode", this.f8994g);
        }
        String str4 = this.f8990c;
        if (str4 != null) {
            bundleA.putString("ext_msg_thread", str4);
        }
        String str5 = this.f8995h;
        if (str5 != null) {
            bundleA.putString("ext_msg_appid", str5);
        }
        if (this.a) {
            bundleA.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.f8996i)) {
            bundleA.putString("ext_msg_seq", this.f8996i);
        }
        if (!TextUtils.isEmpty(this.f8997j)) {
            bundleA.putString("ext_msg_mseq", this.f8997j);
        }
        if (!TextUtils.isEmpty(this.f8998k)) {
            bundleA.putString("ext_msg_fseq", this.f8998k);
        }
        if (this.f526b) {
            bundleA.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.f8999l)) {
            bundleA.putString("ext_msg_status", this.f8999l);
        }
        return bundleA;
    }

    public fn(Bundle bundle) {
        super(bundle);
        this.f8989b = null;
        this.f8990c = null;
        this.a = false;
        this.f8996i = "";
        this.f8997j = "";
        this.f8998k = "";
        this.f8999l = "";
        this.f526b = false;
        this.f8989b = bundle.getString("ext_msg_type");
        this.f8991d = bundle.getString("ext_msg_lang");
        this.f8990c = bundle.getString("ext_msg_thread");
        this.f8992e = bundle.getString("ext_msg_sub");
        this.f8993f = bundle.getString("ext_msg_body");
        this.f8994g = bundle.getString("ext_body_encode");
        this.f8995h = bundle.getString("ext_msg_appid");
        this.a = bundle.getBoolean("ext_msg_trans", false);
        this.f526b = bundle.getBoolean("ext_msg_encrypt", false);
        this.f8996i = bundle.getString("ext_msg_seq");
        this.f8997j = bundle.getString("ext_msg_mseq");
        this.f8998k = bundle.getString("ext_msg_fseq");
        this.f8999l = bundle.getString("ext_msg_status");
    }

    @Override // com.xiaomi.push.fo
    /* JADX INFO: renamed from: a */
    public String mo429a() {
        fs fsVarM430a;
        StringBuilder sb = new StringBuilder();
        sb.append("<message");
        if (p() != null) {
            sb.append(" xmlns=\"");
            sb.append(p());
            sb.append("\"");
        }
        if (this.f8991d != null) {
            sb.append(" xml:lang=\"");
            sb.append(h());
            sb.append("\"");
        }
        if (j() != null) {
            sb.append(" id=\"");
            sb.append(j());
            sb.append("\"");
        }
        if (l() != null) {
            sb.append(" to=\"");
            sb.append(fx.a(l()));
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(d())) {
            sb.append(" seq=\"");
            sb.append(d());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(e())) {
            sb.append(" mseq=\"");
            sb.append(e());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(f())) {
            sb.append(" fseq=\"");
            sb.append(f());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(g())) {
            sb.append(" status=\"");
            sb.append(g());
            sb.append("\"");
        }
        if (m() != null) {
            sb.append(" from=\"");
            sb.append(fx.a(m()));
            sb.append("\"");
        }
        if (k() != null) {
            sb.append(" chid=\"");
            sb.append(fx.a(k()));
            sb.append("\"");
        }
        if (this.a) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.f8995h)) {
            sb.append(" appid=\"");
            sb.append(c());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(this.f8989b)) {
            sb.append(" type=\"");
            sb.append(this.f8989b);
            sb.append("\"");
        }
        if (this.f526b) {
            sb.append(" s=\"1\"");
        }
        sb.append(">");
        if (this.f8992e != null) {
            sb.append("<subject>");
            sb.append(fx.a(this.f8992e));
            sb.append("</subject>");
        }
        if (this.f8993f != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.f8994g)) {
                sb.append(" encode=\"");
                sb.append(this.f8994g);
                sb.append("\"");
            }
            sb.append(">");
            sb.append(fx.a(this.f8993f));
            sb.append("</body>");
        }
        if (this.f8990c != null) {
            sb.append("<thread>");
            sb.append(this.f8990c);
            sb.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.f8989b) && (fsVarM430a = m430a()) != null) {
            sb.append(fsVarM430a.m433a());
        }
        sb.append(o());
        sb.append("</message>");
        return sb.toString();
    }
}
