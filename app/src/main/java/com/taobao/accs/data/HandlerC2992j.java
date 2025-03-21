package com.taobao.accs.data;

import android.content.Intent;
import android.os.Handler;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.data.j */
/* loaded from: classes2.dex */
class HandlerC2992j extends Handler {

    /* renamed from: a */
    final /* synthetic */ MsgDistributeService f9494a;

    HandlerC2992j(MsgDistributeService msgDistributeService) {
        this.f9494a = msgDistributeService;
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        if (message != null) {
            ALog.m9183i("MsgDistributeService", "handleMessage on receive msg", "msg", message.toString());
            Intent intent = (Intent) message.getData().getParcelable(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            if (intent != null) {
                ALog.m9183i("MsgDistributeService", "handleMessage get intent success", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent.toString());
                this.f9494a.onStartCommand(intent, 0, 0);
            }
        }
    }
}
