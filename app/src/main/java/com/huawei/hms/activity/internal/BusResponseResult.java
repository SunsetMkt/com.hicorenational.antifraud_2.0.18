package com.huawei.hms.activity.internal;

import android.content.Intent;

/* loaded from: classes.dex */
public class BusResponseResult {

    /* renamed from: a */
    private Intent f7032a;

    /* renamed from: b */
    private int f7033b;

    public int getCode() {
        return this.f7033b;
    }

    public Intent getIntent() {
        return this.f7032a;
    }

    public void setCode(int i2) {
        this.f7033b = i2;
    }

    public void setIntent(Intent intent) {
        this.f7032a = intent;
    }
}
