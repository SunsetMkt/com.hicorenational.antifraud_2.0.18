package com.huawei.hms.push.task;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class IntentCallable implements Callable<Void> {

    /* renamed from: a */
    private Context f7797a;

    /* renamed from: b */
    private Intent f7798b;

    /* renamed from: c */
    private String f7799c;

    public IntentCallable(Context context, Intent intent, String str) {
        this.f7797a = context;
        this.f7798b = intent;
        this.f7799c = str;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.f7797a.sendBroadcast(this.f7798b);
        PushBiUtil.reportExit(this.f7797a, PushNaming.SET_NOTIFY_FLAG, this.f7799c, ErrorEnum.SUCCESS);
        return null;
    }
}
