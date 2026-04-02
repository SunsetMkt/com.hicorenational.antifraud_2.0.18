package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class DialogRedirectImpl extends DialogRedirect {
    private final Activity a;

    /* JADX INFO: renamed from: b */
    private final int f4561b;

    /* JADX INFO: renamed from: c */
    private final Intent f4562c;

    DialogRedirectImpl(Intent intent, Activity activity, int i2) {
        this.f4562c = intent;
        this.a = activity;
        this.f4561b = i2;
    }

    @Override // com.huawei.hms.common.internal.DialogRedirect
    public final void redirect() {
        Activity activity;
        Intent intent = this.f4562c;
        if (intent == null || (activity = this.a) == null) {
            return;
        }
        activity.startActivityForResult(intent, this.f4561b);
    }
}
