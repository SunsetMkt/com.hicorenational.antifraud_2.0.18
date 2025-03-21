package org.android.agoo.control;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* renamed from: org.android.agoo.control.g */
/* loaded from: classes2.dex */
class HandlerC6020g extends Handler {

    /* renamed from: a */
    final /* synthetic */ BaseIntentService f21495a;

    HandlerC6020g(BaseIntentService baseIntentService) {
        this.f21495a = baseIntentService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message != null) {
            ALog.m9183i("BaseIntentService", "handleMessage on receive msg", "msg", message.toString());
            Intent intent = (Intent) message.getData().getParcelable(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            if (intent != null) {
                ALog.m9183i("BaseIntentService", "handleMessage get intent success", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent.toString());
                ThreadPoolExecutorFactory.execute(new RunnableC6021h(this, intent));
            }
        }
    }
}
