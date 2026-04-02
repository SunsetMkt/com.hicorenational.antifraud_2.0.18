package com.huawei.hms.push.task;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class IntentCallable implements Callable<Void> {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Intent f4904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4905c;

    public IntentCallable(Context context, Intent intent, String str) {
        this.a = context;
        this.f4904b = intent;
        this.f4905c = str;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.a.sendBroadcast(this.f4904b);
        PushBiUtil.reportExit(this.a, PushNaming.SET_NOTIFY_FLAG, this.f4905c, ErrorEnum.SUCCESS);
        return null;
    }
}
