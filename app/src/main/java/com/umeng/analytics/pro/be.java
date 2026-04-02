package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;

/* JADX INFO: compiled from: VivoDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes2.dex */
public class be implements au {
    @Override // com.umeng.analytics.pro.au
    public String a(Context context) {
        String strB = null;
        try {
            if (j.e.b.d.a.e.a(context)) {
                strB = j.e.b.d.a.e.b(context);
            } else {
                UMLog.mutlInfo(2, "\u5f53\u524d\u8bbe\u5907\u4e0d\u652f\u6301\u83b7\u53d6OAID");
            }
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "\u672a\u68c0\u6d4b\u5230\u60a8\u96c6\u6210OAID SDK\u5305");
        }
        return strB;
    }
}
