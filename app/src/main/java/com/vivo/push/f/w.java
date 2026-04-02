package com.vivo.push.f;

import android.text.TextUtils;
import com.vivo.push.f.u;
import java.util.HashMap;

/* JADX INFO: compiled from: OnNotificationArrivedReceiveTask.java */
/* JADX INFO: loaded from: classes2.dex */
final class w implements u.a {
    final /* synthetic */ v a;

    w(v vVar) {
        this.a = vVar;
    }

    @Override // com.vivo.push.f.u.a
    public final void a() {
        long jK = com.vivo.push.m.a().k();
        if (jK < 1400 && jK != 1340) {
            com.vivo.push.util.u.b("OnNotificationArrivedTask", "\u5f15\u64ce\u7248\u672c\u592a\u4f4e\uff0c\u4e0d\u652f\u6301\u6b63\u5411\u5c55\u793a\u529f\u80fd\uff0cpushEngineSDKVersion\uff1a".concat(String.valueOf(jK)));
            return;
        }
        HashMap map = new HashMap();
        map.put("srt", "1");
        map.put("message_id", String.valueOf(this.a.f8532b.f()));
        String strA = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(strA)) {
            map.put("app_id", strA);
        }
        map.put("type", "1");
        map.put("dtp", "1");
        com.vivo.push.util.f.a(6L, (HashMap<String, String>) map);
    }

    @Override // com.vivo.push.f.u.a
    public final void b() {
        HashMap map = new HashMap();
        map.put(com.heytap.mcssdk.constant.b.f3893c, String.valueOf(this.a.f8532b.f()));
        String strA = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(strA)) {
            map.put("remoteAppId", strA);
        }
        com.vivo.push.util.f.a(2122L, (HashMap<String, String>) map);
    }
}
