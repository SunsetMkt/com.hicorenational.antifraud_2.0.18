package com.umeng.message.proguard;

import android.app.Application;
import android.os.Build;
import com.umeng.analytics.pro.bh;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class e {
    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            Application a2 = x.a();
            jSONObject.put("appkey", PushAgent.getInstance(a2).getMessageAppkey());
            jSONObject.put("channel", PushAgent.getInstance(a2).getMessageChannel());
            jSONObject.put("umid", d.k(a2));
            jSONObject.put("din", d.c(a2));
            jSONObject.put("device_id", d.d(a2));
            jSONObject.put(bh.v, d.f(a2));
            jSONObject.put(bh.A, d.c());
            if (d.e(a2) != null) {
                jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, d.e(a2));
            }
            if (d.b() != null) {
                jSONObject.put("serial_number", d.b());
            }
            String p = d.p(a2);
            if (a.a.u.a.f1254k.equals(p)) {
                UMLog.aq(ab.f11221b, 0, "\\|");
            }
            jSONObject.put("push_switch", p);
            jSONObject.put("sdk_type", "Android");
            jSONObject.put("sdk_version", MsgConstant.SDK_VERSION);
            String[] g2 = d.g(a2);
            jSONObject.put(bh.Q, g2[0]);
            jSONObject.put(bh.R, g2[1]);
            jSONObject.put("carrier", d.m(a2));
            jSONObject.put("device_model", d.d());
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("app_version", d.b(a2));
            jSONObject.put("version_code", d.a(a2));
            jSONObject.put("package_name", a2.getPackageName());
            jSONObject.put("resolution", d.l(a2));
            jSONObject.put(bh.w, d.a());
            jSONObject.put(bh.M, d.i(a2));
            String[] j2 = d.j(a2);
            jSONObject.put(bh.O, j2[0]);
            jSONObject.put(bh.N, j2[1]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }
}
