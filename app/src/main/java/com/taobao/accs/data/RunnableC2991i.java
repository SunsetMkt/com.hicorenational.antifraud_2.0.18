package com.taobao.accs.data;

import android.content.Intent;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C3043k;
import java.util.Set;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.data.i */
/* loaded from: classes2.dex */
class RunnableC2991i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f9490a;

    /* renamed from: b */
    final /* synthetic */ String f9491b;

    /* renamed from: c */
    final /* synthetic */ Intent f9492c;

    /* renamed from: d */
    final /* synthetic */ C2989g f9493d;

    RunnableC2991i(C2989g c2989g, String str, String str2, Intent intent) {
        this.f9493d = c2989g;
        this.f9490a = str;
        this.f9491b = str2;
        this.f9492c = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        Set set;
        Set set2;
        Set set3;
        set = C2989g.f9486a;
        if (set != null) {
            set2 = C2989g.f9486a;
            if (set2.contains(this.f9490a)) {
                ALog.m9182e("MsgDistribute", "routing msg time out, try election", Constants.KEY_DATA_ID, this.f9490a, Constants.KEY_SERVICE_ID, this.f9491b);
                set3 = C2989g.f9486a;
                set3.remove(this.f9490a);
                C3043k.m9251a("accs", BaseMonitor.ALARM_MSG_ROUTING_RATE, "", "timeout", "pkg:" + this.f9492c.getPackage());
            }
        }
    }
}
