package com.taobao.accs.internal;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.taobao.accs.base.IBaseReceiver;
import com.taobao.accs.client.C2978a;
import com.taobao.accs.p197a.C2961a;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3042j;
import com.taobao.accs.utl.UtilityImpl;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ReceiverImpl implements IBaseReceiver {
    @Override // com.taobao.accs.base.IBaseReceiver
    public void onReceive(Context context, Intent intent) {
        ALog.m9180d("ReceiverImpl", "ReceiverImpl onReceive begin......", new Object[0]);
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            intent = new Intent();
        }
        try {
            if (UtilityImpl.m9219e(context)) {
                intent.setClassName(context.getPackageName(), C3042j.channelService);
                C2961a.m8908a(context.getApplicationContext(), intent);
            }
            if (UtilityImpl.m9221f(context)) {
                context.getPackageName();
                intent.setClassName(context, C2978a.m8977b());
                C2961a.m8908a(context.getApplicationContext(), intent);
            }
        } catch (Throwable th) {
            ALog.m9182e("ReceiverImpl", "ReceiverImpl onReceive,exception,e=" + th.getMessage(), new Object[0]);
        }
    }
}
