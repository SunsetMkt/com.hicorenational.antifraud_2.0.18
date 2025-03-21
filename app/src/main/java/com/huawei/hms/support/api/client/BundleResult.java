package com.huawei.hms.support.api.client;

import android.os.Bundle;

/* loaded from: classes.dex */
public class BundleResult {

    /* renamed from: a */
    private int f7841a;

    /* renamed from: b */
    private Bundle f7842b;

    public BundleResult(int i2, Bundle bundle) {
        this.f7841a = i2;
        this.f7842b = bundle;
    }

    public int getResultCode() {
        return this.f7841a;
    }

    public Bundle getRspBody() {
        return this.f7842b;
    }

    public void setResultCode(int i2) {
        this.f7841a = i2;
    }

    public void setRspBody(Bundle bundle) {
        this.f7842b = bundle;
    }
}
