package com.heytap.mcssdk.p158i;

import android.content.Context;
import com.heytap.mcssdk.C2080a;
import com.heytap.mcssdk.C2090f;
import com.heytap.mcssdk.constant.MessageConstant;
import com.heytap.mcssdk.p160k.C2103c;
import com.heytap.mcssdk.p160k.C2107g;
import com.heytap.mcssdk.p160k.C2109i;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.BaseMode;

/* renamed from: com.heytap.mcssdk.i.a */
/* loaded from: classes.dex */
public class C2097a implements InterfaceC2099c {

    /* renamed from: com.heytap.mcssdk.i.a$a */
    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C2090f.c f6232a;

        a(C2090f.c cVar) {
            this.f6232a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2097a.this.m5845a(this.f6232a, C2080a.m5698w());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5845a(C2090f.c cVar, C2080a c2080a) {
        String str;
        if (cVar == null) {
            str = "message is null , please check param of parseCommandMessage(2)";
        } else if (c2080a == null) {
            str = "pushService is null , please check param of parseCommandMessage(2)";
        } else {
            if (c2080a.m5745n() != null) {
                int m5807e = cVar.m5807e();
                if (m5807e == 12287) {
                    ICallBackResultService m5745n = c2080a.m5745n();
                    if (m5745n != null) {
                        m5745n.onError(cVar.m5811g(), cVar.m5809f(), cVar.m5814i(), cVar.m5813h());
                        return;
                    }
                    return;
                }
                if (m5807e == 12298) {
                    c2080a.m5745n().onSetPushTime(cVar.m5811g(), cVar.m5809f());
                    return;
                }
                if (m5807e == 12306) {
                    c2080a.m5745n().onGetPushStatus(cVar.m5811g(), C2103c.m5861a(cVar.m5809f()));
                    return;
                }
                if (m5807e == 12309) {
                    c2080a.m5745n().onGetNotificationStatus(cVar.m5811g(), C2103c.m5861a(cVar.m5809f()));
                    return;
                }
                if (m5807e == 12289) {
                    if (cVar.m5811g() == 0) {
                        c2080a.mo5711a(cVar.m5809f());
                    }
                    c2080a.m5745n().onRegister(cVar.m5811g(), cVar.m5809f(), cVar.m5814i(), cVar.m5813h());
                    return;
                }
                if (m5807e == 12290) {
                    c2080a.m5745n().onUnRegister(cVar.m5811g(), cVar.m5814i(), cVar.m5813h());
                    return;
                }
                switch (m5807e) {
                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_OPEN /* 12316 */:
                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_CLOSE /* 12317 */:
                        ISetAppNotificationCallBackService m5747p = c2080a.m5747p();
                        if (m5747p != null) {
                            m5747p.onSetAppNotificationSwitch(cVar.m5811g());
                            break;
                        }
                        break;
                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_GET /* 12318 */:
                        int i2 = 0;
                        try {
                            i2 = Integer.parseInt(cVar.m5809f());
                        } catch (Exception unused) {
                        }
                        IGetAppNotificationCallBackService m5746o = c2080a.m5746o();
                        if (m5746o != null) {
                            m5746o.onGetAppNotificationSwitch(cVar.m5811g(), i2);
                            break;
                        }
                        break;
                }
            }
            str = "pushService.getPushCallback() is null , please check param of parseCommandMessage(2)";
        }
        C2107g.m5896e(str);
    }

    @Override // com.heytap.mcssdk.p158i.InterfaceC2099c
    /* renamed from: a */
    public void mo5847a(Context context, BaseMode baseMode, IDataMessageCallBackService iDataMessageCallBackService) {
        if (baseMode != null && baseMode.getType() == 4105) {
            C2090f.c cVar = (C2090f.c) baseMode;
            C2107g.m5884b("mcssdk-CallBackResultProcessor:" + cVar.toString());
            C2109i.m5914b(new a(cVar));
        }
    }
}
