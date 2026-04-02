package com.huawei.hms.push;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: CommonHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends Handler {
    private WeakReference<a> a;

    /* JADX INFO: compiled from: CommonHandler.java */
    public interface a {
        void a(Message message);
    }

    public f(a aVar) {
        this.a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        a aVar = this.a.get();
        if (aVar != null) {
            aVar.a(message);
        }
    }
}
