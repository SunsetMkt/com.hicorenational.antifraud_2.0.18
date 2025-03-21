package com.taobao.agoo.p201a.p202a;

import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3048p;

/* compiled from: Taobao */
/* renamed from: com.taobao.agoo.a.a.d */
/* loaded from: classes2.dex */
public class C3061d extends AbstractC3059b {
    public static final String JSON_CMD_DISABLEPUSH = "disablePush";
    public static final String JSON_CMD_ENABLEPUSH = "enablePush";

    /* renamed from: a */
    public String f9795a;

    /* renamed from: b */
    public String f9796b;

    /* renamed from: c */
    public String f9797c;

    /* renamed from: a */
    public byte[] m9305a() {
        try {
            C3048p.a aVar = new C3048p.a();
            aVar.m9262a(AbstractC3059b.JSON_CMD, this.f9779e).m9262a("appKey", this.f9795a);
            if (TextUtils.isEmpty(this.f9796b)) {
                aVar.m9262a("utdid", this.f9797c);
            } else {
                aVar.m9262a("deviceId", this.f9796b);
            }
            String jSONObject = aVar.m9263a().toString();
            ALog.m9183i("SwitchDO", "buildData", "data", jSONObject);
            return jSONObject.getBytes("utf-8");
        } catch (Throwable th) {
            ALog.m9181e("SwitchDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m9304a(String str, String str2, String str3, boolean z) {
        C3061d c3061d = new C3061d();
        c3061d.f9795a = str;
        c3061d.f9796b = str2;
        c3061d.f9797c = str3;
        if (z) {
            c3061d.f9779e = JSON_CMD_ENABLEPUSH;
        } else {
            c3061d.f9779e = JSON_CMD_DISABLEPUSH;
        }
        return c3061d.m9305a();
    }
}
