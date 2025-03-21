package com.umeng.p221ut.p222a.p223a;

import android.content.Context;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.p221ut.p222a.C3796a;
import com.umeng.p221ut.p226b.p227a.p228a.C3814d;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.umeng.ut.a.a.a */
/* loaded from: classes2.dex */
public class C3797a {
    /* renamed from: a */
    public static String m12761a(String str) {
        String str2;
        Context m12757a = C3796a.m12755a().m12757a();
        if (m12757a == null) {
            return "";
        }
        try {
            str2 = UMUtils.getAppkey(m12757a);
        } catch (Throwable unused) {
            str2 = "";
        }
        return C3814d.m12800d(String.format("{\"type\":\"%s\",\"timestamp\":%s,\"data\":%s}", "audid", C3796a.m12755a().m12758a(), m12762a(str, "", str2, m12757a.getPackageName())));
    }

    /* renamed from: a */
    private static String m12762a(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("audid", str2);
        hashMap.put("utdid", str);
        hashMap.put("appkey", str3);
        hashMap.put("appName", str4);
        return new JSONObject(C3814d.m12799a(hashMap)).toString();
    }
}
