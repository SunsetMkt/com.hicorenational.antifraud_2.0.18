package com.taobao.accs.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.taobao.accs.internal.ServiceImpl;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3042j;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.internal.e */
/* loaded from: classes2.dex */
class RunnableC3000e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ServiceImpl.BinderC29951 f9518a;

    RunnableC3000e(ServiceImpl.BinderC29951 binderC29951) {
        this.f9518a = binderC29951;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        try {
            context = ServiceImpl.this.f9507c;
            if (context != null) {
                context2 = ServiceImpl.this.f9507c;
                if (UtilityImpl.m9219e(context2)) {
                    Intent intent = new Intent();
                    intent.setAction("org.agoo.android.intent.action.PING_V4");
                    context3 = ServiceImpl.this.f9507c;
                    intent.setClassName(context3.getPackageName(), C3042j.channelService);
                    context4 = ServiceImpl.this.f9507c;
                    context4.startService(intent);
                    UTMini uTMini = UTMini.getInstance();
                    context5 = ServiceImpl.this.f9507c;
                    uTMini.commitEvent(66001, "probeServiceEnabled", UtilityImpl.m9228j(context5));
                    ALog.m9180d("ServiceImpl", "ReceiverImpl probeTaoBao........mContext.startService(intent) [probe][successfully]", new Object[0]);
                    ALog.m9180d("ServiceImpl", "ReceiverImpl probeTaoBao........messageServiceBinder [probe][end]", new Object[0]);
                }
            }
            Process.killProcess(Process.myPid());
            ALog.m9180d("ServiceImpl", "ReceiverImpl probeTaoBao........messageServiceBinder [probe][end]", new Object[0]);
        } catch (Throwable th) {
            ALog.m9180d("ServiceImpl", "ReceiverImpl probeTaoBao error........e=" + th, new Object[0]);
        }
    }
}
