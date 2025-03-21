package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;

/* renamed from: com.xiaomi.push.fn */
/* loaded from: classes2.dex */
public class C4220fn extends AbstractC4221fo {

    /* renamed from: a */
    private boolean f15331a;

    /* renamed from: b */
    private String f15332b;

    /* renamed from: b */
    private boolean f15333b;

    /* renamed from: c */
    private String f15334c;

    /* renamed from: d */
    private String f15335d;

    /* renamed from: e */
    private String f15336e;

    /* renamed from: f */
    private String f15337f;

    /* renamed from: g */
    private String f15338g;

    /* renamed from: h */
    private String f15339h;

    /* renamed from: i */
    private String f15340i;

    /* renamed from: j */
    private String f15341j;

    /* renamed from: k */
    private String f15342k;

    /* renamed from: l */
    private String f15343l;

    public C4220fn() {
        this.f15332b = null;
        this.f15334c = null;
        this.f15331a = false;
        this.f15340i = "";
        this.f15341j = "";
        this.f15342k = "";
        this.f15343l = "";
        this.f15333b = false;
    }

    /* renamed from: a */
    public void m14836a(boolean z) {
        this.f15331a = z;
    }

    /* renamed from: b */
    public String m14837b() {
        return this.f15332b;
    }

    /* renamed from: c */
    public String m14840c() {
        return this.f15339h;
    }

    /* renamed from: d */
    public String m14842d() {
        return this.f15340i;
    }

    /* renamed from: e */
    public String m14844e() {
        return this.f15341j;
    }

    @Override // com.xiaomi.push.AbstractC4221fo
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C4220fn.class != obj.getClass()) {
            return false;
        }
        C4220fn c4220fn = (C4220fn) obj;
        if (!super.equals(c4220fn)) {
            return false;
        }
        String str = this.f15337f;
        if (str == null ? c4220fn.f15337f != null : !str.equals(c4220fn.f15337f)) {
            return false;
        }
        String str2 = this.f15335d;
        if (str2 == null ? c4220fn.f15335d != null : !str2.equals(c4220fn.f15335d)) {
            return false;
        }
        String str3 = this.f15336e;
        if (str3 == null ? c4220fn.f15336e != null : !str3.equals(c4220fn.f15336e)) {
            return false;
        }
        String str4 = this.f15334c;
        if (str4 == null ? c4220fn.f15334c == null : str4.equals(c4220fn.f15334c)) {
            return this.f15332b == c4220fn.f15332b;
        }
        return false;
    }

    /* renamed from: f */
    public String m14846f() {
        return this.f15342k;
    }

    /* renamed from: g */
    public String m14848g() {
        return this.f15343l;
    }

    /* renamed from: h */
    public void m14851h(String str) {
        this.f15337f = str;
    }

    @Override // com.xiaomi.push.AbstractC4221fo
    public int hashCode() {
        String str = this.f15332b;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f15337f;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f15334c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f15335d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f15336e;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    /* renamed from: i */
    public void m14852i(String str) {
        this.f15334c = str;
    }

    /* renamed from: j */
    public void m14853j(String str) {
        this.f15335d = str;
    }

    /* renamed from: a */
    public void m14834a(String str) {
        this.f15339h = str;
    }

    /* renamed from: b */
    public void m14838b(String str) {
        this.f15340i = str;
    }

    /* renamed from: c */
    public void m14841c(String str) {
        this.f15341j = str;
    }

    /* renamed from: d */
    public void m14843d(String str) {
        this.f15342k = str;
    }

    /* renamed from: e */
    public void m14845e(String str) {
        this.f15343l = str;
    }

    /* renamed from: f */
    public void m14847f(String str) {
        this.f15332b = str;
    }

    /* renamed from: g */
    public void m14849g(String str) {
        this.f15336e = str;
    }

    /* renamed from: h */
    public String m14850h() {
        return this.f15335d;
    }

    /* renamed from: a */
    public void m14835a(String str, String str2) {
        this.f15337f = str;
        this.f15338g = str2;
    }

    /* renamed from: b */
    public void m14839b(boolean z) {
        this.f15333b = z;
    }

    @Override // com.xiaomi.push.AbstractC4221fo
    /* renamed from: a */
    public Bundle mo14827a() {
        Bundle mo14827a = super.mo14827a();
        if (!TextUtils.isEmpty(this.f15332b)) {
            mo14827a.putString("ext_msg_type", this.f15332b);
        }
        String str = this.f15335d;
        if (str != null) {
            mo14827a.putString("ext_msg_lang", str);
        }
        String str2 = this.f15336e;
        if (str2 != null) {
            mo14827a.putString("ext_msg_sub", str2);
        }
        String str3 = this.f15337f;
        if (str3 != null) {
            mo14827a.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.f15338g)) {
            mo14827a.putString("ext_body_encode", this.f15338g);
        }
        String str4 = this.f15334c;
        if (str4 != null) {
            mo14827a.putString("ext_msg_thread", str4);
        }
        String str5 = this.f15339h;
        if (str5 != null) {
            mo14827a.putString("ext_msg_appid", str5);
        }
        if (this.f15331a) {
            mo14827a.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.f15340i)) {
            mo14827a.putString("ext_msg_seq", this.f15340i);
        }
        if (!TextUtils.isEmpty(this.f15341j)) {
            mo14827a.putString("ext_msg_mseq", this.f15341j);
        }
        if (!TextUtils.isEmpty(this.f15342k)) {
            mo14827a.putString("ext_msg_fseq", this.f15342k);
        }
        if (this.f15333b) {
            mo14827a.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.f15343l)) {
            mo14827a.putString("ext_msg_status", this.f15343l);
        }
        return mo14827a;
    }

    public C4220fn(Bundle bundle) {
        super(bundle);
        this.f15332b = null;
        this.f15334c = null;
        this.f15331a = false;
        this.f15340i = "";
        this.f15341j = "";
        this.f15342k = "";
        this.f15343l = "";
        this.f15333b = false;
        this.f15332b = bundle.getString("ext_msg_type");
        this.f15335d = bundle.getString("ext_msg_lang");
        this.f15334c = bundle.getString("ext_msg_thread");
        this.f15336e = bundle.getString("ext_msg_sub");
        this.f15337f = bundle.getString("ext_msg_body");
        this.f15338g = bundle.getString("ext_body_encode");
        this.f15339h = bundle.getString("ext_msg_appid");
        this.f15331a = bundle.getBoolean("ext_msg_trans", false);
        this.f15333b = bundle.getBoolean("ext_msg_encrypt", false);
        this.f15340i = bundle.getString("ext_msg_seq");
        this.f15341j = bundle.getString("ext_msg_mseq");
        this.f15342k = bundle.getString("ext_msg_fseq");
        this.f15343l = bundle.getString("ext_msg_status");
    }

    @Override // com.xiaomi.push.AbstractC4221fo
    /* renamed from: a */
    public String mo14829a() {
        C4225fs m14858a;
        StringBuilder sb = new StringBuilder();
        sb.append("<message");
        if (m14875p() != null) {
            sb.append(" xmlns=\"");
            sb.append(m14875p());
            sb.append("\"");
        }
        if (this.f15335d != null) {
            sb.append(" xml:lang=\"");
            sb.append(m14850h());
            sb.append("\"");
        }
        if (m14864j() != null) {
            sb.append(" id=\"");
            sb.append(m14864j());
            sb.append("\"");
        }
        if (m14867l() != null) {
            sb.append(" to=\"");
            sb.append(C4230fx.m14901a(m14867l()));
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(m14842d())) {
            sb.append(" seq=\"");
            sb.append(m14842d());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(m14844e())) {
            sb.append(" mseq=\"");
            sb.append(m14844e());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(m14846f())) {
            sb.append(" fseq=\"");
            sb.append(m14846f());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(m14848g())) {
            sb.append(" status=\"");
            sb.append(m14848g());
            sb.append("\"");
        }
        if (m14869m() != null) {
            sb.append(" from=\"");
            sb.append(C4230fx.m14901a(m14869m()));
            sb.append("\"");
        }
        if (m14865k() != null) {
            sb.append(" chid=\"");
            sb.append(C4230fx.m14901a(m14865k()));
            sb.append("\"");
        }
        if (this.f15331a) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.f15339h)) {
            sb.append(" appid=\"");
            sb.append(m14840c());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(this.f15332b)) {
            sb.append(" type=\"");
            sb.append(this.f15332b);
            sb.append("\"");
        }
        if (this.f15333b) {
            sb.append(" s=\"1\"");
        }
        sb.append(">");
        if (this.f15336e != null) {
            sb.append("<subject>");
            sb.append(C4230fx.m14901a(this.f15336e));
            sb.append("</subject>");
        }
        if (this.f15337f != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.f15338g)) {
                sb.append(" encode=\"");
                sb.append(this.f15338g);
                sb.append("\"");
            }
            sb.append(">");
            sb.append(C4230fx.m14901a(this.f15337f));
            sb.append("</body>");
        }
        if (this.f15334c != null) {
            sb.append("<thread>");
            sb.append(this.f15334c);
            sb.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.f15332b) && (m14858a = m14858a()) != null) {
            sb.append(m14858a.m14882a());
        }
        sb.append(m14873o());
        sb.append("</message>");
        return sb.toString();
    }
}
