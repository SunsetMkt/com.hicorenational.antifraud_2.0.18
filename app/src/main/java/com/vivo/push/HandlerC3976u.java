package com.vivo.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.vivo.push.util.C4010u;

/* compiled from: PushClientThread.java */
/* renamed from: com.vivo.push.u */
/* loaded from: classes2.dex */
final class HandlerC3976u extends Handler {
    HandlerC3976u(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object obj = message.obj;
        if (obj instanceof AbstractRunnableC3971s) {
            AbstractRunnableC3971s abstractRunnableC3971s = (AbstractRunnableC3971s) obj;
            C4010u.m13306c("PushClientThread", "PushClientThread-handleMessage, task = ".concat(String.valueOf(abstractRunnableC3971s)));
            abstractRunnableC3971s.run();
        }
    }
}
