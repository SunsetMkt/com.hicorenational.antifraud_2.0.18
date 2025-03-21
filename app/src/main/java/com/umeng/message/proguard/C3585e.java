package com.umeng.message.proguard;

import android.app.Application;
import android.os.Build;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;
import p000a.p001a.p014u.C0052a;

/* renamed from: com.umeng.message.proguard.e */
/* loaded from: classes2.dex */
public final class C3585e {
    /* renamed from: a */
    public static JSONObject m12377a() {
        JSONObject jSONObject = new JSONObject();
        try {
            Application m12460a = C3604x.m12460a();
            jSONObject.put("appkey", PushAgent.getInstance(m12460a).getMessageAppkey());
            jSONObject.put("channel", PushAgent.getInstance(m12460a).getMessageChannel());
            jSONObject.put("umid", C3584d.m12367k(m12460a));
            jSONObject.put("din", C3584d.m12351c(m12460a));
            jSONObject.put("device_id", C3584d.m12353d(m12460a));
            jSONObject.put(C3351bh.f11668v, C3584d.m12357f(m12460a));
            jSONObject.put(C3351bh.f11549A, C3584d.m12350c());
            if (C3584d.m12355e(m12460a) != null) {
                jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, C3584d.m12355e(m12460a));
            }
            if (C3584d.m12348b() != null) {
                jSONObject.put("serial_number", C3584d.m12348b());
            }
            String m12372p = C3584d.m12372p(m12460a);
            if (C0052a.f159k.equals(m12372p)) {
                UMLog.m11549aq(C3553ab.f13149b, 0, "\\|");
            }
            jSONObject.put("push_switch", m12372p);
            jSONObject.put("sdk_type", "Android");
            jSONObject.put("sdk_version", MsgConstant.SDK_VERSION);
            String[] m12359g = C3584d.m12359g(m12460a);
            jSONObject.put(C3351bh.f11565Q, m12359g[0]);
            jSONObject.put(C3351bh.f11566R, m12359g[1]);
            jSONObject.put("carrier", C3584d.m12369m(m12460a));
            jSONObject.put("device_model", C3584d.m12352d());
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("app_version", C3584d.m12349b(m12460a));
            jSONObject.put("version_code", C3584d.m12345a(m12460a));
            jSONObject.put("package_name", m12460a.getPackageName());
            jSONObject.put("resolution", C3584d.m12368l(m12460a));
            jSONObject.put(C3351bh.f11669w, C3584d.m12344a());
            jSONObject.put(C3351bh.f11561M, C3584d.m12362i(m12460a));
            String[] m12365j = C3584d.m12365j(m12460a);
            jSONObject.put(C3351bh.f11563O, m12365j[0]);
            jSONObject.put(C3351bh.f11562N, m12365j[1]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }
}
