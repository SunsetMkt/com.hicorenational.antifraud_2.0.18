package com.vivo.push.util;

import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2085b;
import com.vivo.push.C3924m;
import com.vivo.push.p232b.C3852x;
import com.vivo.push.restructure.C3932a;
import java.util.HashMap;

/* compiled from: ClientReportUtil.java */
/* renamed from: com.vivo.push.util.f */
/* loaded from: classes2.dex */
public final class C3995f {
    /* renamed from: a */
    public static boolean m13248a(long j2, long j3) {
        C4010u.m13309d("ClientReportUtil", "report message: " + j2 + ", reportType: " + j3);
        C3852x c3852x = new C3852x(j3);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(C2085b.f6162c, String.valueOf(j2));
        String mo13112a = C3932a.m13069a().m13074e().mo13112a();
        if (!TextUtils.isEmpty(mo13112a)) {
            hashMap.put("remoteAppId", mo13112a);
        }
        c3852x.m12886a(hashMap);
        C3924m.m13016a().m13032a(c3852x);
        return true;
    }

    /* renamed from: a */
    public static boolean m13249a(long j2, HashMap<String, String> hashMap) {
        C3852x c3852x = new C3852x(j2);
        c3852x.m12886a(hashMap);
        c3852x.m12887d();
        C3924m.m13016a().m13032a(c3852x);
        return true;
    }
}
