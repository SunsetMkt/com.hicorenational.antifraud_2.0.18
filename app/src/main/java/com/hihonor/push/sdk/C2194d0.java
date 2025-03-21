package com.hihonor.push.sdk;

import android.os.Looper;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.sdk.C2242z;
import com.hihonor.push.sdk.InterfaceC2187b0;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.hihonor.push.sdk.d0 */
/* loaded from: classes.dex */
public class C2194d0 implements InterfaceC2187b0 {

    /* renamed from: a */
    public final AtomicInteger f6760a = new AtomicInteger(1);

    /* renamed from: b */
    public volatile IPushInvoke f6761b;

    /* renamed from: c */
    public final InterfaceC2187b0.a f6762c;

    /* renamed from: d */
    public ServiceConnectionC2200f0 f6763d;

    public C2194d0(InterfaceC2187b0.a aVar) {
        this.f6762c = aVar;
    }

    /* renamed from: a */
    public boolean m6383a() {
        return this.f6760a.get() == 3 || this.f6760a.get() == 4;
    }

    /* renamed from: a */
    public final void m6382a(int i2) {
        String str = "notifyFailed result: " + i2;
        InterfaceC2187b0.a aVar = this.f6762c;
        if (aVar != null) {
            C2242z.a aVar2 = (C2242z.a) aVar;
            aVar2.getClass();
            if (Looper.myLooper() == C2242z.this.f6857a.getLooper()) {
                aVar2.m6406a(HonorPushErrorEnum.fromCode(i2));
            } else {
                C2242z.this.f6857a.post(new RunnableC2240y(aVar2, i2));
            }
        }
    }
}
