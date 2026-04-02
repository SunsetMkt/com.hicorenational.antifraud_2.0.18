package com.taobao.accs.net;

import android.content.Intent;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class d implements Runnable {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ALog.d(this.a.d(), "startChannelService", new Object[0]);
        Intent intent = new Intent(Constants.ACTION_START_SERVICE);
        intent.putExtra("appKey", this.a.i());
        intent.putExtra(Constants.KEY_TTID, this.a.a);
        intent.putExtra(Constants.KEY_PACKAGE_NAME, GlobalClientInfo.getContext().getPackageName());
        intent.putExtra("app_sercet", this.a.f5806i.getAppSecret());
        intent.putExtra(Constants.KEY_MODE, AccsClientConfig.mEnv);
        intent.putExtra(Config.PROPERTY_APP_KEY, Config.a(GlobalClientInfo.getContext()));
        intent.putExtra(Constants.KEY_CONFIG_TAG, this.a.f5810m);
        intent.setClassName(GlobalClientInfo.getContext().getPackageName(), com.taobao.accs.utl.j.channelService);
        com.taobao.accs.a.a.a(GlobalClientInfo.getContext(), intent);
        Intent intent2 = new Intent();
        intent2.setAction(AgooConstants.INTENT_FROM_AGOO_REPORT);
        intent2.setPackage(GlobalClientInfo.getContext().getPackageName());
        String packageName = GlobalClientInfo.getContext().getPackageName();
        GlobalClientInfo.getContext().getPackageName();
        intent2.setClassName(packageName, com.taobao.accs.client.a.b());
        com.taobao.accs.a.a.a(GlobalClientInfo.getContext(), intent2);
    }
}
