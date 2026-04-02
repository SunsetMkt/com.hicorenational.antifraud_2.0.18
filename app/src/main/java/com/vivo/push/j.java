package com.vivo.push;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: IPCManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class j implements Handler.Callback {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message == null) {
            com.vivo.push.util.u.a("AidlManager", "handleMessage error : msg is null");
            return false;
        }
        int i2 = message.what;
        if (i2 == 1) {
            com.vivo.push.util.u.a("AidlManager", "In connect, bind core service time out");
            if (this.a.f8542f.get() == 2) {
                this.a.a(1);
            }
        } else if (i2 != 2) {
            com.vivo.push.util.u.b("AidlManager", "unknow msg what [" + message.what + "]");
        } else {
            if (this.a.f8542f.get() == 4) {
                this.a.f();
            }
            this.a.a(1);
        }
        return true;
    }
}
