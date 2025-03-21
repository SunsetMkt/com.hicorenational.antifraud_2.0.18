package com.hihonor.push.sdk;

import com.hihonor.push.sdk.C2242z;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;

/* renamed from: com.hihonor.push.sdk.y */
/* loaded from: classes.dex */
public class RunnableC2240y implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f6853a;

    /* renamed from: b */
    public final /* synthetic */ C2242z.a f6854b;

    public RunnableC2240y(C2242z.a aVar, int i2) {
        this.f6854b = aVar;
        this.f6853a = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6854b.m6406a(HonorPushErrorEnum.fromCode(this.f6853a));
    }
}
