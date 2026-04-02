package com.vivo.push.f;

import android.text.TextUtils;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: OnUndoMsgReceiveTask.java */
/* JADX INFO: loaded from: classes2.dex */
final class ag extends aa {
    ag(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.u uVar = (com.vivo.push.b.u) vVar;
        if (com.vivo.push.m.a().g() && !a(com.vivo.push.util.ag.c(this.a), uVar.e(), uVar.g())) {
            com.vivo.push.util.u.d("OnUndoMsgTask", " vertify msg is error ");
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(1021L);
            HashMap<String, String> map = new HashMap<>();
            map.put(com.heytap.mcssdk.constant.b.f3893c, String.valueOf(uVar.f()));
            String strA = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(strA)) {
                map.put("remoteAppId", strA);
            }
            xVar.a(map);
            com.vivo.push.m.a().a(xVar);
            return;
        }
        boolean zRepealNotifyById = NotifyAdapterUtil.repealNotifyById(this.a, uVar.d());
        com.vivo.push.util.u.d("OnUndoMsgTask", "undo message " + uVar.d() + ", " + zRepealNotifyById);
        if (zRepealNotifyById) {
            com.vivo.push.util.u.b(this.a, "\u56de\u6536client\u901a\u77e5\u6210\u529f, \u4e0a\u62a5\u57cb\u70b9 1031, messageId = " + uVar.d());
            com.vivo.push.util.f.a(uVar.d(), 1031L);
            return;
        }
        com.vivo.push.util.u.d("OnUndoMsgTask", "undo message fail\uff0cmessageId = " + uVar.d());
        com.vivo.push.util.u.c(this.a, "\u56de\u6536client\u901a\u77e5\u5931\u8d25\uff0cmessageId = " + uVar.d());
    }
}
