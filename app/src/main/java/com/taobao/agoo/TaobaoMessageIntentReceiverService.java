package com.taobao.agoo;

import android.content.Context;
import com.taobao.accs.client.C2978a;
import com.taobao.accs.utl.ALog;
import org.android.agoo.message.MessageReceiverService;

/* loaded from: classes2.dex */
public class TaobaoMessageIntentReceiverService extends MessageReceiverService {
    @Override // org.android.agoo.message.MessageReceiverService
    public String getIntentServiceClassName(Context context) {
        ALog.m9186w("Taobao", "getPackage Name=" + context.getPackageName(), new Object[0]);
        context.getPackageName();
        return C2978a.m8977b();
    }
}
