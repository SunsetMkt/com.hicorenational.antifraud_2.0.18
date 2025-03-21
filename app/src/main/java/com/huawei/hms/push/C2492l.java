package com.huawei.hms.push;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.plugin.PushProxy;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.p181ha.PushAnalyticsCenter;
import com.huawei.hms.push.utils.p181ha.PushBaseAnalytics;
import com.huawei.hms.support.log.HMSLog;
import com.vivo.push.PushClientConstants;

/* compiled from: PushAnalyticsUtils.java */
/* renamed from: com.huawei.hms.push.l */
/* loaded from: classes.dex */
public class C2492l {

    /* renamed from: a */
    private static final String f7751a = "l";

    /* renamed from: a */
    public static void m7571a(Context context, String str, String str2, String str3) {
        PushBaseAnalytics pushAnalytics = PushAnalyticsCenter.getInstance().getPushAnalytics();
        if (pushAnalytics == null) {
            return;
        }
        Bundle m7569a = m7569a(context, str, str2);
        HMSLog.m7717i(f7751a, "eventId:" + str3);
        pushAnalytics.report(context, str3, m7569a);
    }

    /* renamed from: a */
    private static Bundle m7569a(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("sdkVer", String.valueOf(61200300));
        bundle.putString(PushClientConstants.TAG_PKG_NAME, context.getPackageName());
        bundle.putString("aaid", HmsInstanceId.getInstance(context).getId());
        PushProxy proxy = ProxyCenter.getProxy();
        if (proxy != null) {
            bundle.putString("proxyType", proxy.getProxyType());
        }
        bundle.putString(RemoteMessageConst.MSGID, str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(RemoteMessageConst.ANALYTIC_INFO, str2);
        }
        return bundle;
    }

    /* renamed from: a */
    public static void m7570a(Context context, Bundle bundle, String str) {
        PushBaseAnalytics pushAnalytics;
        if (bundle == null || (pushAnalytics = PushAnalyticsCenter.getInstance().getPushAnalytics()) == null) {
            return;
        }
        bundle.putString("sdk_version", String.valueOf(61200300));
        HMSLog.m7717i(f7751a, "eventId:" + str);
        pushAnalytics.report(context, str, bundle);
    }
}
