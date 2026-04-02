package com.hihonor.push.sdk;

import com.hihonor.push.sdk.z;

/* JADX INFO: loaded from: classes.dex */
public class x implements Runnable {
    public final /* synthetic */ z.a a;

    public x(z.a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b();
    }
}
