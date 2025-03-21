package com.vivo.push;

import android.os.Handler;
import android.os.Message;
import com.vivo.push.util.C4010u;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: IPCManager.java */
/* renamed from: com.vivo.push.j */
/* loaded from: classes2.dex */
final class C3921j implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ ServiceConnectionC3920i f14067a;

    C3921j(ServiceConnectionC3920i serviceConnectionC3920i) {
        this.f14067a = serviceConnectionC3920i;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        if (message == null) {
            C4010u.m13292a("AidlManager", "handleMessage error : msg is null");
            return false;
        }
        int i2 = message.what;
        if (i2 == 1) {
            C4010u.m13292a("AidlManager", "In connect, bind core service time out");
            atomicInteger = this.f14067a.f14062f;
            if (atomicInteger.get() == 2) {
                this.f14067a.m12997a(1);
            }
        } else if (i2 != 2) {
            C4010u.m13301b("AidlManager", "unknow msg what [" + message.what + "]");
        } else {
            atomicInteger2 = this.f14067a.f14062f;
            if (atomicInteger2.get() == 4) {
                this.f14067a.m13004f();
            }
            this.f14067a.m12997a(1);
        }
        return true;
    }
}
