package com.heytap.msp.push.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.heytap.mcssdk.C2080a;
import com.heytap.mcssdk.C2090f;
import com.heytap.mcssdk.p160k.C2107g;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.DataMessage;

/* loaded from: classes.dex */
public class DataMessageCallbackService extends Service implements IDataMessageCallBackService {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        C2080a.m5698w().m5723c(getApplicationContext());
        C2090f.m5791a(getApplicationContext(), intent, this);
        return 2;
    }

    @Override // com.heytap.msp.push.callback.IDataMessageCallBackService
    public void processMessage(Context context, DataMessage dataMessage) {
        C2107g.m5884b("Receive DataMessageCallbackService:messageTitle: " + dataMessage.getTitle() + " ------content:" + dataMessage.getContent() + "------describe:" + dataMessage.getDescription());
    }
}
