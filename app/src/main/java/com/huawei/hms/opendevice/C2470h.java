package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;

/* compiled from: PushBiUtil.java */
/* renamed from: com.huawei.hms.opendevice.h */
/* loaded from: classes.dex */
public final class C2470h {
    /* renamed from: a */
    public static String m7465a(Context context, String str) {
        return HiAnalyticsClient.reportEntry(context, str, 61200300);
    }

    /* renamed from: a */
    public static void m7466a(Context context, String str, ResponseErrorCode responseErrorCode) {
        HiAnalyticsClient.reportExit(context, str, responseErrorCode.getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode(), 61200300);
    }

    /* renamed from: a */
    public static void m7468a(Context context, String str, String str2, ErrorEnum errorEnum) {
        HiAnalyticsClient.reportExit(context, str, str2, Status.SUCCESS.getStatusCode(), errorEnum.getExternalCode(), 61200300);
    }

    /* renamed from: a */
    public static void m7467a(Context context, String str, String str2, int i2) {
        HiAnalyticsClient.reportExit(context, str, str2, Status.SUCCESS.getStatusCode(), i2, 61200300);
    }
}
