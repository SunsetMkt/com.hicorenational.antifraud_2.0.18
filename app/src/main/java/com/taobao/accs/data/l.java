package com.taobao.accs.data;

import android.content.Intent;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class l implements Runnable {
    final /* synthetic */ Intent a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ MsgDistributeService f5783b;

    l(MsgDistributeService msgDistributeService, Intent intent) {
        this.f5783b = msgDistributeService;
        this.a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        ALog.i("MsgDistributeService", "onStartCommand send message", new Object[0]);
        ACCSManager.AccsRequest accsRequest = (ACCSManager.AccsRequest) this.a.getSerializableExtra(Constants.KEY_SEND_REQDATA);
        String stringExtra = this.a.getStringExtra(Constants.KEY_PACKAGE_NAME);
        String stringExtra2 = this.a.getStringExtra("appKey");
        String stringExtra3 = this.a.getStringExtra(Constants.KEY_CONFIG_TAG);
        if (TextUtils.isEmpty(stringExtra3)) {
            stringExtra3 = stringExtra2;
        }
        ACCSManager.getAccsInstance(this.f5783b.getApplicationContext(), stringExtra2, stringExtra3).a(this.f5783b.getApplicationContext(), accsRequest, stringExtra, false);
    }
}
