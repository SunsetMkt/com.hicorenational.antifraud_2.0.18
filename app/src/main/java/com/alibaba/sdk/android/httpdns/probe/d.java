package com.alibaba.sdk.android.httpdns.probe;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    private static IPProbeService a;

    public static synchronized IPProbeService a(b bVar) {
        if (a == null) {
            a = new e();
            a.setIPListUpdateCallback(bVar);
        }
        return a;
    }
}
