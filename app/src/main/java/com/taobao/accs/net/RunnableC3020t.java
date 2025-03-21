package com.taobao.accs.net;

import android.text.TextUtils;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.t */
/* loaded from: classes2.dex */
class RunnableC3020t implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3011k f9590a;

    RunnableC3020t(C3011k c3011k) {
        this.f9590a = c3011k;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f9590a.f9524d == null || TextUtils.isEmpty(this.f9590a.m9105i())) {
                return;
            }
            ALog.m9183i(this.f9590a.mo9100d(), "mTryStartServiceRunable bindapp", new Object[0]);
            this.f9590a.m9107k();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
