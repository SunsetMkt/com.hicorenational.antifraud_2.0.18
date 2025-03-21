package com.taobao.accs.net;

import android.content.Intent;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.client.C2978a;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.p197a.C2961a;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3042j;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.d */
/* loaded from: classes2.dex */
class RunnableC3004d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AbstractC3001a f9543a;

    RunnableC3004d(AbstractC3001a abstractC3001a) {
        this.f9543a = abstractC3001a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ALog.m9180d(this.f9543a.mo9100d(), "startChannelService", new Object[0]);
        Intent intent = new Intent(Constants.ACTION_START_SERVICE);
        intent.putExtra("appKey", this.f9543a.m9105i());
        intent.putExtra(Constants.KEY_TTID, this.f9543a.f9521a);
        intent.putExtra(Constants.KEY_PACKAGE_NAME, GlobalClientInfo.getContext().getPackageName());
        intent.putExtra("app_sercet", this.f9543a.f9529i.getAppSecret());
        intent.putExtra(Constants.KEY_MODE, AccsClientConfig.mEnv);
        intent.putExtra(Config.PROPERTY_APP_KEY, Config.m24934a(GlobalClientInfo.getContext()));
        intent.putExtra(Constants.KEY_CONFIG_TAG, this.f9543a.f9533m);
        intent.setClassName(GlobalClientInfo.getContext().getPackageName(), C3042j.channelService);
        C2961a.m8908a(GlobalClientInfo.getContext(), intent);
        Intent intent2 = new Intent();
        intent2.setAction(AgooConstants.INTENT_FROM_AGOO_REPORT);
        intent2.setPackage(GlobalClientInfo.getContext().getPackageName());
        String packageName = GlobalClientInfo.getContext().getPackageName();
        GlobalClientInfo.getContext().getPackageName();
        intent2.setClassName(packageName, C2978a.m8977b());
        C2961a.m8908a(GlobalClientInfo.getContext(), intent2);
    }
}
