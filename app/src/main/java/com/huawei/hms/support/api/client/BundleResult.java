package com.huawei.hms.support.api.client;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class BundleResult {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bundle f4929b;

    public BundleResult(int i2, Bundle bundle) {
        this.a = i2;
        this.f4929b = bundle;
    }

    public int getResultCode() {
        return this.a;
    }

    public Bundle getRspBody() {
        return this.f4929b;
    }

    public void setResultCode(int i2) {
        this.a = i2;
    }

    public void setRspBody(Bundle bundle) {
        this.f4929b = bundle;
    }
}
