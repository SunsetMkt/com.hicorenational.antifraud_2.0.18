package com.huawei.hms.push;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: CommonHandler.java */
/* renamed from: com.huawei.hms.push.f */
/* loaded from: classes.dex */
public class HandlerC2486f extends Handler {

    /* renamed from: a */
    private WeakReference<a> f7745a;

    /* compiled from: CommonHandler.java */
    /* renamed from: com.huawei.hms.push.f$a */
    public interface a {
        /* renamed from: a */
        void mo7517a(Message message);
    }

    public HandlerC2486f(a aVar) {
        this.f7745a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        a aVar = this.f7745a.get();
        if (aVar != null) {
            aVar.mo7517a(message);
        }
    }
}
