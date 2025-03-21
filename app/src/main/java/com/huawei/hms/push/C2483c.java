package com.huawei.hms.push;

import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: BundleUtil.java */
/* renamed from: com.huawei.hms.push.c */
/* loaded from: classes.dex */
public class C2483c {
    /* renamed from: a */
    public static byte[] m7540a(Bundle bundle, String str) {
        try {
            byte[] byteArray = bundle.getByteArray(str);
            return byteArray == null ? new byte[0] : byteArray;
        } catch (Exception e2) {
            HMSLog.m7717i("BundleUtil", "getByteArray exception" + e2.getMessage());
            return new byte[0];
        }
    }

    /* renamed from: b */
    public static String m7541b(Bundle bundle, String str) {
        try {
            return bundle.getString(str);
        } catch (Exception e2) {
            HMSLog.m7717i("BundleUtil", "getString exception" + e2.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    public static String m7542c(Bundle bundle, String str) {
        try {
            String string = bundle.getString(str);
            return string == null ? "" : string;
        } catch (Exception e2) {
            HMSLog.m7717i("BundleUtil", "getString exception" + e2.getMessage());
            return "";
        }
    }
}
