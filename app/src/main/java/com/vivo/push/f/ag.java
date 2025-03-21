package com.vivo.push.f;

import android.text.TextUtils;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;

/* compiled from: OnUndoMsgReceiveTask.java */
/* loaded from: classes2.dex */
final class ag extends aa {
    ag(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.u uVar = (com.vivo.push.b.u) vVar;
        if (com.vivo.push.m.a().g() && !a(com.vivo.push.util.ag.c(this.f12207a), uVar.e(), uVar.g())) {
            com.vivo.push.util.u.d("OnUndoMsgTask", " vertify msg is error ");
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(1021L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(com.heytap.mcssdk.constant.b.f5825c, String.valueOf(uVar.f()));
            String a2 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put("remoteAppId", a2);
            }
            xVar.a(hashMap);
            com.vivo.push.m.a().a(xVar);
            return;
        }
        boolean repealNotifyById = NotifyAdapterUtil.repealNotifyById(this.f12207a, uVar.d());
        com.vivo.push.util.u.d("OnUndoMsgTask", "undo message " + uVar.d() + ", " + repealNotifyById);
        if (repealNotifyById) {
            com.vivo.push.util.u.b(this.f12207a, "回收client通知成功, 上报埋点 1031, messageId = " + uVar.d());
            com.vivo.push.util.f.a(uVar.d(), 1031L);
            return;
        }
        com.vivo.push.util.u.d("OnUndoMsgTask", "undo message fail，messageId = " + uVar.d());
        com.vivo.push.util.u.c(this.f12207a, "回收client通知失败，messageId = " + uVar.d());
    }
}
