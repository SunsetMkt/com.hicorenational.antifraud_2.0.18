package com.umeng.ut.a.a;

import android.content.Context;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.ut.b.a.a.d;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class a {
    public static String a(String str) {
        String str2;
        Context m41a = com.umeng.ut.a.a.a().m41a();
        if (m41a == null) {
            return "";
        }
        try {
            str2 = UMUtils.getAppkey(m41a);
        } catch (Throwable unused) {
            str2 = "";
        }
        return d.d(String.format("{\"type\":\"%s\",\"timestamp\":%s,\"data\":%s}", "audid", com.umeng.ut.a.a.a().m42a(), a(str, "", str2, m41a.getPackageName())));
    }

    private static String a(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("audid", str2);
        hashMap.put("utdid", str);
        hashMap.put("appkey", str3);
        hashMap.put("appName", str4);
        return new JSONObject(d.a(hashMap)).toString();
    }
}
