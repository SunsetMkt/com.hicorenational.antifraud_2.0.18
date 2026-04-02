package com.hihonor.push.sdk;

import android.os.Looper;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.sdk.b0;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.z;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class d0 implements b0 {
    public final AtomicInteger a = new AtomicInteger(1);

    /* JADX INFO: renamed from: b */
    public volatile IPushInvoke f4241b;

    /* JADX INFO: renamed from: c */
    public final b0.a f4242c;

    /* JADX INFO: renamed from: d */
    public f0 f4243d;

    public d0(b0.a aVar) {
        this.f4242c = aVar;
    }

    public boolean a() {
        return this.a.get() == 3 || this.a.get() == 4;
    }

    public final void a(int i2) {
        String str = "notifyFailed result: " + i2;
        b0.a aVar = this.f4242c;
        if (aVar != null) {
            z.a aVar2 = (z.a) aVar;
            aVar2.getClass();
            if (Looper.myLooper() == z.this.a.getLooper()) {
                aVar2.a(HonorPushErrorEnum.fromCode(i2));
            } else {
                z.this.a.post(new y(aVar2, i2));
            }
        }
    }
}
