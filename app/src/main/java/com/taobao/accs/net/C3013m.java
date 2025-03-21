package com.taobao.accs.net;

import android.content.Intent;
import android.os.Handler;
import anet.channel.ISessionListener;
import com.just.agentweb.DefaultWebClient;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import java.util.Iterator;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.m */
/* loaded from: classes2.dex */
class C3013m implements ISessionListener {

    /* renamed from: a */
    final /* synthetic */ C3011k f9572a;

    C3013m(C3011k c3011k) {
        this.f9572a = c3011k;
    }

    @Override // anet.channel.ISessionListener
    public void onConnectionChanged(Intent intent) {
        Handler handler;
        if (intent != null) {
            boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
            String stringExtra = intent.getStringExtra(Constants.KEY_HOST);
            ALog.m9182e(this.f9572a.mo9100d(), "onConnectionChanged", "currentHost", DefaultWebClient.HTTPS_SCHEME + this.f9572a.f9529i.getInappHost(), "changeHost", stringExtra, "state", Boolean.valueOf(booleanExtra));
            if ((DefaultWebClient.HTTPS_SCHEME + this.f9572a.f9529i.getInappHost()).equals(stringExtra)) {
                AbstractC3007g.m9112a(GlobalClientInfo.getContext()).m9114a();
                int intExtra = intent.getIntExtra(Constants.KEY_ERROR_CODE, -1);
                String stringExtra2 = intent.getStringExtra(Constants.KEY_ERROR_DETAIL);
                boolean booleanExtra2 = intent.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
                boolean booleanExtra3 = intent.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
                TaoBaseService.ConnectInfo connectInfo = booleanExtra ? new TaoBaseService.ConnectInfo(stringExtra, booleanExtra2, booleanExtra3) : new TaoBaseService.ConnectInfo(stringExtra, booleanExtra2, booleanExtra3, intExtra, stringExtra2);
                connectInfo.connected = booleanExtra;
                Iterator<AccsConnectStateListener> it = this.f9572a.m9110n().iterator();
                while (it.hasNext()) {
                    AccsConnectStateListener next = it.next();
                    handler = this.f9572a.f9562r;
                    handler.post(new RunnableC3014n(this, connectInfo, next));
                }
            }
        }
    }
}
