package com.huawei.hms.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: NetworkUtil.java */
/* renamed from: com.huawei.hms.push.g */
/* loaded from: classes.dex */
public class C2487g {
    /* renamed from: a */
    public static int m7560a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return activeNetworkInfo.getType();
        }
        HMSLog.m7717i("NetworkUtil", "no connected network");
        return -1;
    }
}
