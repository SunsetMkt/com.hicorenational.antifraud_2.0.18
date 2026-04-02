package com.taobao.accs.net;

import android.text.TextUtils;
import com.taobao.accs.utl.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class t implements Runnable {
    final /* synthetic */ k a;

    t(k kVar) {
        this.a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.a.f5801d == null || TextUtils.isEmpty(this.a.i())) {
                return;
            }
            ALog.i(this.a.d(), "mTryStartServiceRunable bindapp", new Object[0]);
            this.a.k();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
