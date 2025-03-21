package com.vivo.push.p237f;

import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2085b;
import com.vivo.push.AbstractC4016v;
import com.vivo.push.C3924m;
import com.vivo.push.p232b.C3849u;
import com.vivo.push.p232b.C3852x;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.util.C3990ag;
import com.vivo.push.util.C3995f;
import com.vivo.push.util.C4010u;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;

/* compiled from: OnUndoMsgReceiveTask.java */
/* renamed from: com.vivo.push.f.ag */
/* loaded from: classes2.dex */
final class C3888ag extends AbstractC3882aa {
    C3888ag(AbstractC4016v abstractC4016v) {
        super(abstractC4016v);
    }

    @Override // com.vivo.push.AbstractRunnableC3971s
    /* renamed from: a */
    protected final void mo12952a(AbstractC4016v abstractC4016v) {
        C3849u c3849u = (C3849u) abstractC4016v;
        if (C3924m.m13016a().m13048g() && !m12956a(C3990ag.m13221c(this.f14186a), c3849u.m12881e(), c3849u.m12883g())) {
            C4010u.m13309d("OnUndoMsgTask", " vertify msg is error ");
            C3852x c3852x = new C3852x(1021L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(C2085b.f6162c, String.valueOf(c3849u.m12882f()));
            String mo13112a = C3932a.m13069a().m13074e().mo13112a();
            if (!TextUtils.isEmpty(mo13112a)) {
                hashMap.put("remoteAppId", mo13112a);
            }
            c3852x.m12886a(hashMap);
            C3924m.m13016a().m13032a(c3852x);
            return;
        }
        boolean repealNotifyById = NotifyAdapterUtil.repealNotifyById(this.f14186a, c3849u.m12880d());
        C4010u.m13309d("OnUndoMsgTask", "undo message " + c3849u.m12880d() + ", " + repealNotifyById);
        if (repealNotifyById) {
            C4010u.m13303b(this.f14186a, "回收client通知成功, 上报埋点 1031, messageId = " + c3849u.m12880d());
            C3995f.m13248a(c3849u.m12880d(), 1031L);
            return;
        }
        C4010u.m13309d("OnUndoMsgTask", "undo message fail，messageId = " + c3849u.m12880d());
        C4010u.m13308c(this.f14186a, "回收client通知失败，messageId = " + c3849u.m12880d());
    }
}
