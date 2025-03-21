package com.huawei.hms.hatool;

import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.u0 */
/* loaded from: classes.dex */
public class C2451u0 {
    /* renamed from: a */
    protected static C2410f0 m7373a(String str, String str2, String str3, String str4) {
        C2410f0 c2410f0 = new C2410f0();
        c2410f0.m7194a(str);
        c2410f0.m7195b(AbstractC2443q0.m7305f());
        c2410f0.m7198e(str2);
        c2410f0.m7196c(str4);
        StringBuffer stringBuffer = new StringBuffer("hmshi");
        stringBuffer.append(str3);
        stringBuffer.append("qrt");
        c2410f0.m7197d(stringBuffer.toString());
        return c2410f0;
    }

    /* renamed from: a */
    protected static C2427l m7374a(String str, String str2) {
        C2427l c2427l = new C2427l();
        c2427l.m7365a(C2421j.m7169a().m7170a(str, str2));
        return c2427l;
    }

    /* renamed from: a */
    protected static C2459y0 m7375a(String str, String str2, String str3) {
        C2459y0 c2459y0 = new C2459y0();
        c2459y0.m7368c(AbstractC2443q0.m7312j());
        c2459y0.m7370e(AbstractC2443q0.m7314l());
        c2459y0.m7366a(str3);
        c2459y0.m7367b(C2421j.m7169a().m7173b(str2, str));
        return c2459y0;
    }

    /* renamed from: b */
    protected static C2417h1 m7376b(String str, String str2) {
        C2452v.m7385c("hmsSdk", "generate UploadData EventModelHandlerBase");
        C2432m1.m7236d().m7238a(str, str2);
        if (!TextUtils.isEmpty(C2432m1.m7236d().m7237a())) {
            return new C2417h1(C2432m1.m7236d().m7240c());
        }
        C2452v.m7390f("hmsSdk", "event chifer is empty");
        return null;
    }

    /* renamed from: c */
    protected static Map<String, String> m7377c(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", AbstractC2443q0.m7305f());
        hashMap.put("App-Ver", AbstractC2443q0.m7307g());
        hashMap.put("Sdk-Name", "hianalytics");
        hashMap.put("Sdk-Ver", "2.2.0.314");
        hashMap.put("Device-Type", Build.MODEL);
        hashMap.put("servicetag", str);
        C2452v.m7380a("hmsSdk", "sendData RequestId : %s", str2);
        hashMap.put("Request-Id", str2);
        return hashMap;
    }
}
