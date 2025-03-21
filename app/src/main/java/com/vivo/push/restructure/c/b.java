package com.vivo.push.restructure.c;

import android.text.TextUtils;
import com.vivo.push.b.x;
import com.vivo.push.m;
import com.vivo.push.util.u;
import java.util.HashMap;

/* compiled from: ReportImpl.java */
/* loaded from: classes2.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private com.vivo.push.restructure.b.a f12178a;

    public b(com.vivo.push.restructure.b.a aVar) {
        this.f12178a = aVar;
    }

    @Override // com.vivo.push.restructure.c.a
    public final void a(int i2, String str) {
        u.d("ReportImpl", "reportIntercepted() , msgID = " + str + ", code = " + i2);
        if (i2 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        x xVar = new x(i2);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(com.heytap.mcssdk.constant.b.f5825c, str);
        com.vivo.push.restructure.b.a aVar = this.f12178a;
        if (aVar != null) {
            String a2 = aVar.a();
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put("remoteAppId", a2);
            }
        }
        xVar.a(hashMap);
        m.a().a(xVar);
    }
}
