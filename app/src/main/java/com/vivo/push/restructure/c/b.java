package com.vivo.push.restructure.c;

import android.text.TextUtils;
import com.vivo.push.b.x;
import com.vivo.push.m;
import com.vivo.push.util.u;
import java.util.HashMap;

/* JADX INFO: compiled from: ReportImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements a {
    private com.vivo.push.restructure.b.a a;

    public b(com.vivo.push.restructure.b.a aVar) {
        this.a = aVar;
    }

    @Override // com.vivo.push.restructure.c.a
    public final void a(int i2, String str) {
        u.d("ReportImpl", "reportIntercepted() , msgID = " + str + ", code = " + i2);
        if (i2 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        x xVar = new x(i2);
        HashMap<String, String> map = new HashMap<>();
        map.put(com.heytap.mcssdk.constant.b.f3893c, str);
        com.vivo.push.restructure.b.a aVar = this.a;
        if (aVar != null) {
            String strA = aVar.a();
            if (!TextUtils.isEmpty(strA)) {
                map.put("remoteAppId", strA);
            }
        }
        xVar.a(map);
        m.a().a(xVar);
    }
}
