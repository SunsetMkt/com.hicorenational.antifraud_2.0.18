package com.taobao.agoo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.taobao.accs.client.C2978a;
import com.taobao.accs.p197a.C2961a;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AgooCommondReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            context.getPackageName();
            String m8977b = C2978a.m8977b();
            intent.setFlags(0);
            intent.setClassName(context, m8977b);
            C2961a.m8908a(context, intent);
        } catch (Throwable unused) {
        }
    }
}
