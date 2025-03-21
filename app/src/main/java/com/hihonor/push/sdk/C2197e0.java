package com.hihonor.push.sdk;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.hihonor.push.sdk.e0 */
/* loaded from: classes.dex */
public class C2197e0 implements Handler.Callback {

    /* renamed from: a */
    public final /* synthetic */ ServiceConnectionC2200f0 f6766a;

    public C2197e0(ServiceConnectionC2200f0 serviceConnectionC2200f0) {
        this.f6766a = serviceConnectionC2200f0;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message == null || message.what != 1001) {
            return false;
        }
        this.f6766a.m6385a(8002003);
        return true;
    }
}
