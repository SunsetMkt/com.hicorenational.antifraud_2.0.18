package com.vivo.push.f;

import android.text.TextUtils;
import com.vivo.push.f.u;
import java.util.HashMap;

/* compiled from: OnNotificationArrivedReceiveTask.java */
/* loaded from: classes2.dex */
final class w implements u.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f12073a;

    w(v vVar) {
        this.f12073a = vVar;
    }

    @Override // com.vivo.push.f.u.a
    public final void a() {
        long k2 = com.vivo.push.m.a().k();
        if (k2 < 1400 && k2 != 1340) {
            com.vivo.push.util.u.b("OnNotificationArrivedTask", "引擎版本太低，不支持正向展示功能，pushEngineSDKVersion：".concat(String.valueOf(k2)));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("srt", "1");
        hashMap.put("message_id", String.valueOf(this.f12073a.f12071b.f()));
        String a2 = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(a2)) {
            hashMap.put("app_id", a2);
        }
        hashMap.put("type", "1");
        hashMap.put("dtp", "1");
        com.vivo.push.util.f.a(6L, (HashMap<String, String>) hashMap);
    }

    @Override // com.vivo.push.f.u.a
    public final void b() {
        HashMap hashMap = new HashMap();
        hashMap.put(com.heytap.mcssdk.constant.b.f5825c, String.valueOf(this.f12073a.f12071b.f()));
        String a2 = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(a2)) {
            hashMap.put("remoteAppId", a2);
        }
        com.vivo.push.util.f.a(2122L, (HashMap<String, String>) hashMap);
    }
}
