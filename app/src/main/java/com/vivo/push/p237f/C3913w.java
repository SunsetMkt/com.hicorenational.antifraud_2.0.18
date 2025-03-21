package com.vivo.push.p237f;

import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2085b;
import com.vivo.push.C3924m;
import com.vivo.push.p237f.C3911u;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.util.C3995f;
import com.vivo.push.util.C4010u;
import java.util.HashMap;

/* compiled from: OnNotificationArrivedReceiveTask.java */
/* renamed from: com.vivo.push.f.w */
/* loaded from: classes2.dex */
final class C3913w implements C3911u.a {

    /* renamed from: a */
    final /* synthetic */ RunnableC3912v f14048a;

    C3913w(RunnableC3912v runnableC3912v) {
        this.f14048a = runnableC3912v;
    }

    @Override // com.vivo.push.p237f.C3911u.a
    /* renamed from: a */
    public final void mo12987a() {
        long m13052k = C3924m.m13016a().m13052k();
        if (m13052k < 1400 && m13052k != 1340) {
            C4010u.m13301b("OnNotificationArrivedTask", "引擎版本太低，不支持正向展示功能，pushEngineSDKVersion：".concat(String.valueOf(m13052k)));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("srt", "1");
        hashMap.put("message_id", String.valueOf(this.f14048a.f14046b.m12882f()));
        String mo13112a = C3932a.m13069a().m13074e().mo13112a();
        if (!TextUtils.isEmpty(mo13112a)) {
            hashMap.put("app_id", mo13112a);
        }
        hashMap.put("type", "1");
        hashMap.put("dtp", "1");
        C3995f.m13249a(6L, (HashMap<String, String>) hashMap);
    }

    @Override // com.vivo.push.p237f.C3911u.a
    /* renamed from: b */
    public final void mo12988b() {
        HashMap hashMap = new HashMap();
        hashMap.put(C2085b.f6162c, String.valueOf(this.f14048a.f14046b.m12882f()));
        String mo13112a = C3932a.m13069a().m13074e().mo13112a();
        if (!TextUtils.isEmpty(mo13112a)) {
            hashMap.put("remoteAppId", mo13112a);
        }
        C3995f.m13249a(2122L, (HashMap<String, String>) hashMap);
    }
}
