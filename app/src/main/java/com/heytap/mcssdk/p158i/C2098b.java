package com.heytap.mcssdk.p158i;

import android.app.NotificationManager;
import android.content.Context;
import com.heytap.mcssdk.p160k.C2107g;
import com.heytap.mcssdk.p160k.C2109i;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.statis.StatisticUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.heytap.mcssdk.i.b */
/* loaded from: classes.dex */
public class C2098b implements InterfaceC2099c {

    /* renamed from: a */
    private static final int f6234a = 1;

    /* renamed from: com.heytap.mcssdk.i.b$a */
    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ DataMessage f6235a;

        /* renamed from: b */
        final /* synthetic */ Context f6236b;

        /* renamed from: c */
        final /* synthetic */ IDataMessageCallBackService f6237c;

        a(DataMessage dataMessage, Context context, IDataMessageCallBackService iDataMessageCallBackService) {
            this.f6235a = dataMessage;
            this.f6236b = context;
            this.f6237c = iDataMessageCallBackService;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f6235a.getMsgCommand() == 1) {
                C2098b.this.m5848a(this.f6236b, this.f6235a);
            } else {
                this.f6237c.processMessage(this.f6236b, this.f6235a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5848a(Context context, DataMessage dataMessage) {
        if (context == null) {
            C2107g.m5884b("context is null");
            return;
        }
        C2107g.m5884b("Receive revokeMessage  extra : " + dataMessage.getStatisticsExtra() + "notifyId :" + dataMessage.getNotifyID() + "messageId : " + dataMessage.getTaskID());
        ((NotificationManager) context.getSystemService("notification")).cancel(dataMessage.getNotifyID());
        m5850b(context, dataMessage);
    }

    /* renamed from: b */
    private void m5850b(Context context, DataMessage dataMessage) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(dataMessage);
        hashMap.put(dataMessage.getEventId(), arrayList);
        StatisticUtils.statisticEvent(context, hashMap);
    }

    @Override // com.heytap.mcssdk.p158i.InterfaceC2099c
    /* renamed from: a */
    public void mo5847a(Context context, BaseMode baseMode, IDataMessageCallBackService iDataMessageCallBackService) {
        if (baseMode != null && baseMode.getType() == 4103) {
            DataMessage dataMessage = (DataMessage) baseMode;
            if (iDataMessageCallBackService != null) {
                C2109i.m5914b(new a(dataMessage, context, iDataMessageCallBackService));
            }
        }
    }
}
