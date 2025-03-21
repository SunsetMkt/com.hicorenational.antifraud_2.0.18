package com.vivo.push.restructure.request;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.vivo.push.util.C3996g;
import java.util.Map;

/* compiled from: RequestManager.java */
/* renamed from: com.vivo.push.restructure.request.e */
/* loaded from: classes2.dex */
final class HandlerC3969e extends Handler {

    /* renamed from: a */
    final /* synthetic */ C3968d f14183a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC3969e(C3968d c3968d, Looper looper) {
        super(looper);
        this.f14183a = c3968d;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Map map;
        Map map2;
        int i2 = message.what;
        map = this.f14183a.f14178a;
        if (map.containsKey(Integer.valueOf(i2))) {
            map2 = this.f14183a.f14178a;
            C3996g.m13250a().execute(new RunnableC3970f(this, (C3966b) map2.remove(Integer.valueOf(i2))));
        }
    }
}
