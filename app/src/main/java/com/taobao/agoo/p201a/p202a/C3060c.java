package com.taobao.agoo.p201a.p202a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3042j;
import com.taobao.accs.utl.C3047o;
import com.taobao.accs.utl.C3048p;
import com.taobao.accs.utl.UtilityImpl;

/* compiled from: Taobao */
/* renamed from: com.taobao.agoo.a.a.c */
/* loaded from: classes2.dex */
public class C3060c extends AbstractC3059b {
    public static final String JSON_CMD_REGISTER = "register";

    /* renamed from: a */
    public String f9780a;

    /* renamed from: b */
    public String f9781b;

    /* renamed from: c */
    public String f9782c;

    /* renamed from: d */
    public String f9783d = String.valueOf(221);

    /* renamed from: f */
    public String f9784f;

    /* renamed from: g */
    public String f9785g;

    /* renamed from: h */
    public String f9786h;

    /* renamed from: i */
    public String f9787i;

    /* renamed from: j */
    public String f9788j;

    /* renamed from: k */
    public String f9789k;

    /* renamed from: l */
    public String f9790l;

    /* renamed from: m */
    public String f9791m;

    /* renamed from: n */
    public String f9792n;

    /* renamed from: o */
    public String f9793o;

    /* renamed from: p */
    public String f9794p;

    /* renamed from: a */
    public byte[] m9303a() {
        try {
            String jSONObject = new C3048p.a().m9262a(AbstractC3059b.JSON_CMD, this.f9779e).m9262a("appKey", this.f9780a).m9262a("utdid", this.f9781b).m9262a("appVersion", this.f9782c).m9262a("sdkVersion", this.f9783d).m9262a(Constants.KEY_TTID, this.f9784f).m9262a(Constants.KEY_PACKAGE_NAME, this.f9785g).m9262a("notifyEnable", this.f9786h).m9262a("romInfo", this.f9787i).m9262a("c0", this.f9788j).m9262a("c1", this.f9789k).m9262a("c2", this.f9790l).m9262a("c3", this.f9791m).m9262a("c4", this.f9792n).m9262a("c5", this.f9793o).m9262a("c6", this.f9794p).m9263a().toString();
            ALog.m9183i("RegisterDO", "buildData", "data", jSONObject);
            return jSONObject.getBytes("utf-8");
        } catch (Throwable th) {
            ALog.m9181e("RegisterDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m9302a(Context context, String str, String str2) {
        C3060c c3060c;
        String m9228j;
        String packageName;
        String str3;
        try {
            m9228j = UtilityImpl.m9228j(context);
            packageName = context.getPackageName();
            str3 = GlobalClientInfo.getInstance(context).getPackageInfo().versionName;
        } catch (Throwable th) {
            th = th;
            c3060c = null;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(m9228j) && !TextUtils.isEmpty(str3)) {
            c3060c = new C3060c();
            try {
                c3060c.f9779e = "register";
                c3060c.f9780a = str;
                c3060c.f9781b = m9228j;
                c3060c.f9782c = str3;
                c3060c.f9784f = str2;
                c3060c.f9785g = packageName;
                c3060c.f9788j = Build.BRAND;
                c3060c.f9789k = Build.MODEL;
                c3060c.f9786h = C3042j.m9248c(context);
                UtilityImpl.m9202a(context, Constants.SP_CHANNEL_FILE_NAME, c3060c.f9786h);
                c3060c.f9787i = new C3047o().mo9258a();
            } catch (Throwable th2) {
                th = th2;
                try {
                    ALog.m9186w("RegisterDO", "buildRegister", th.getMessage());
                    if (c3060c == null) {
                        return null;
                    }
                    return c3060c.m9303a();
                } finally {
                    if (c3060c != null) {
                        c3060c.m9303a();
                    }
                }
            }
            return c3060c.m9303a();
        }
        ALog.m9182e("RegisterDO", "buildRegister param null", "appKey", str, "utdid", m9228j, "appVersion", str3);
        return null;
    }
}
