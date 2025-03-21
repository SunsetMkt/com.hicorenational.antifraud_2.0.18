package com.taobao.accs.data;

import android.content.Intent;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.data.l */
/* loaded from: classes2.dex */
class RunnableC2994l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Intent f9496a;

    /* renamed from: b */
    final /* synthetic */ MsgDistributeService f9497b;

    RunnableC2994l(MsgDistributeService msgDistributeService, Intent intent) {
        this.f9497b = msgDistributeService;
        this.f9496a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        ALog.m9183i("MsgDistributeService", "onStartCommand send message", new Object[0]);
        ACCSManager.AccsRequest accsRequest = (ACCSManager.AccsRequest) this.f9496a.getSerializableExtra(Constants.KEY_SEND_REQDATA);
        String stringExtra = this.f9496a.getStringExtra(Constants.KEY_PACKAGE_NAME);
        String stringExtra2 = this.f9496a.getStringExtra("appKey");
        String stringExtra3 = this.f9496a.getStringExtra(Constants.KEY_CONFIG_TAG);
        if (TextUtils.isEmpty(stringExtra3)) {
            stringExtra3 = stringExtra2;
        }
        ACCSManager.getAccsInstance(this.f9497b.getApplicationContext(), stringExtra2, stringExtra3).mo8916a(this.f9497b.getApplicationContext(), accsRequest, stringExtra, false);
    }
}
