package com.hihonor.push.sdk;

import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.z;

/* JADX INFO: loaded from: classes.dex */
public class y implements Runnable {
    public final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z.a f4292b;

    public y(z.a aVar, int i2) {
        this.f4292b = aVar;
        this.a = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4292b.a(HonorPushErrorEnum.fromCode(this.a));
    }
}
