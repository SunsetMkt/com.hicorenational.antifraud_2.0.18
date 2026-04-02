package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;

/* JADX INFO: compiled from: OppoDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes2.dex */
public class bc implements au {
    private boolean a = false;

    @Override // com.umeng.analytics.pro.au
    public String a(Context context) {
        try {
            if (!this.a) {
                j.e.b.a.a.a.a.a(context);
                this.a = true;
            }
            if (j.e.b.a.a.a.a.a()) {
                return j.e.b.a.a.a.a.c(context);
            }
            UMLog.mutlInfo(2, "\u5f53\u524d\u8bbe\u5907\u4e0d\u652f\u6301\u83b7\u53d6OAID");
            return null;
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "\u672a\u68c0\u6d4b\u5230\u60a8\u96c6\u6210OAID SDK\u5305");
            return null;
        }
    }
}
