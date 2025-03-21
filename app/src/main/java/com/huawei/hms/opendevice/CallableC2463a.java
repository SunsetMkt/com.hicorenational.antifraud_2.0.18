package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import java.util.concurrent.Callable;

/* compiled from: AAIDCallable.java */
/* renamed from: com.huawei.hms.opendevice.a */
/* loaded from: classes.dex */
public class CallableC2463a implements Callable<AAIDResult> {

    /* renamed from: a */
    private Context f7654a;

    public CallableC2463a(Context context) {
        this.f7654a = context;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AAIDResult call() throws Exception {
        Context context = this.f7654a;
        if (context == null) {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        String m7448b = C2464b.m7448b(context);
        AAIDResult aAIDResult = new AAIDResult();
        aAIDResult.setId(m7448b);
        return aAIDResult;
    }
}
