package com.huawei.hms.activity.internal;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class BusResponseResult {
    private Intent a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4409b;

    public int getCode() {
        return this.f4409b;
    }

    public Intent getIntent() {
        return this.a;
    }

    public void setCode(int i2) {
        this.f4409b = i2;
    }

    public void setIntent(Intent intent) {
        this.a = intent;
    }
}
