package com.taobao.agoo.p201a.p202a;

import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3048p;

/* compiled from: Taobao */
/* renamed from: com.taobao.agoo.a.a.a */
/* loaded from: classes2.dex */
public class C3058a extends AbstractC3059b {
    public static final String JSON_CMD_REMOVEALIAS = "removeAlias";
    public static final String JSON_CMD_REMOVEALLALIAS = "unbindAllAlias";
    public static final String JSON_CMD_SETALIAS = "setAlias";
    public static final String JSON_PUSH_USER_TOKEN = "pushAliasToken";

    /* renamed from: a */
    public String f9775a;

    /* renamed from: b */
    public String f9776b;

    /* renamed from: c */
    public String f9777c;

    /* renamed from: d */
    public String f9778d;

    /* renamed from: b */
    public static byte[] m9299b(String str, String str2, String str3) {
        C3058a c3058a = new C3058a();
        c3058a.f9775a = str;
        c3058a.f9776b = str2;
        c3058a.f9778d = str3;
        c3058a.f9779e = JSON_CMD_REMOVEALIAS;
        return c3058a.m9301a();
    }

    /* renamed from: c */
    public static byte[] m9300c(String str, String str2, String str3) {
        C3058a c3058a = new C3058a();
        c3058a.f9775a = str;
        c3058a.f9776b = str2;
        c3058a.f9777c = str3;
        c3058a.f9779e = JSON_CMD_REMOVEALIAS;
        return c3058a.m9301a();
    }

    /* renamed from: a */
    public byte[] m9301a() {
        try {
            String jSONObject = new C3048p.a().m9262a(AbstractC3059b.JSON_CMD, this.f9779e).m9262a("appKey", this.f9775a).m9262a("deviceId", this.f9776b).m9262a("alias", this.f9777c).m9262a(JSON_PUSH_USER_TOKEN, this.f9778d).m9263a().toString();
            ALog.m9183i("AliasDO", "buildData", "data", jSONObject);
            return jSONObject.getBytes("utf-8");
        } catch (Throwable th) {
            ALog.m9181e("AliasDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m9298a(String str, String str2, String str3) {
        C3058a c3058a = new C3058a();
        c3058a.f9775a = str;
        c3058a.f9776b = str2;
        c3058a.f9777c = str3;
        c3058a.f9779e = JSON_CMD_SETALIAS;
        return c3058a.m9301a();
    }

    /* renamed from: a */
    public static byte[] m9297a(String str, String str2) {
        C3058a c3058a = new C3058a();
        c3058a.f9775a = str;
        c3058a.f9776b = str2;
        c3058a.f9779e = JSON_CMD_REMOVEALLALIAS;
        return c3058a.m9301a();
    }
}
