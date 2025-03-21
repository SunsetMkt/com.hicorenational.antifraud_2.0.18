package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* loaded from: classes.dex */
public class DialogRedirectImpl extends DialogRedirect {

    /* renamed from: a */
    private final Activity f7277a;

    /* renamed from: b */
    private final int f7278b;

    /* renamed from: c */
    private final Intent f7279c;

    DialogRedirectImpl(Intent intent, Activity activity, int i2) {
        this.f7279c = intent;
        this.f7277a = activity;
        this.f7278b = i2;
    }

    @Override // com.huawei.hms.common.internal.DialogRedirect
    public final void redirect() {
        Activity activity;
        Intent intent = this.f7279c;
        if (intent == null || (activity = this.f7277a) == null) {
            return;
        }
        activity.startActivityForResult(intent, this.f7278b);
    }
}
