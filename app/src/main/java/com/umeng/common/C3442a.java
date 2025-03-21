package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.C3336at;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.utils.UMUtils;

/* compiled from: EncryptHelper.java */
/* renamed from: com.umeng.common.a */
/* loaded from: classes2.dex */
public class C3442a {

    /* renamed from: a */
    private static String f12389a = null;

    /* renamed from: b */
    private static final String f12390b = "umeng+";

    /* renamed from: c */
    private static final String f12391c = "ek__id";

    /* renamed from: d */
    private static final String f12392d = "ek_key";

    /* renamed from: e */
    private static String f12393e = "";

    /* renamed from: f */
    private static final String f12394f = C3336at.m10865b().m10868b(C3336at.f11500n);

    /* renamed from: g */
    private static String f12395g = "";

    /* renamed from: h */
    private static C3442a f12396h;

    private C3442a() {
    }

    /* renamed from: a */
    public static C3442a m11498a() {
        if (f12396h == null) {
            synchronized (C3442a.class) {
                if (f12396h == null) {
                    f12396h = new C3442a();
                }
            }
        }
        return f12396h;
    }

    /* renamed from: c */
    private String m11499c(String str) {
        String str2 = "";
        try {
            String substring = str.substring(1, 9);
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < substring.length(); i2++) {
                char charAt = substring.charAt(i2);
                if (!Character.isDigit(charAt)) {
                    sb.append(charAt);
                } else if (Integer.parseInt(Character.toString(charAt)) == 0) {
                    sb.append(0);
                } else {
                    sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                }
            }
            str2 = sb.toString();
            return str2 + new StringBuilder(str2).reverse().toString();
        } catch (Throwable unused) {
            return str2;
        }
    }

    /* renamed from: b */
    public String m11502b(String str) {
        String str2;
        String str3 = null;
        try {
            return TextUtils.isEmpty(f12389a) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f12389a.getBytes()));
        } catch (Exception unused) {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败!");
            if (TextUtils.isEmpty(f12393e)) {
                return null;
            }
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试");
            try {
                String str4 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f12393e.getBytes()));
                try {
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试成功。");
                    return str4;
                } catch (Exception unused2) {
                    str3 = str4;
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试失败。换子进程备份key重试。");
                    try {
                        str2 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f12395g.getBytes()));
                    } catch (Throwable unused3) {
                    }
                    try {
                        UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试成功。");
                        return str2;
                    } catch (Throwable unused4) {
                        str3 = str2;
                        UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试失败。");
                        return str3;
                    }
                }
            } catch (Exception unused5) {
            }
        }
    }

    /* renamed from: a */
    public void m11501a(Context context) {
        try {
            if (TextUtils.isEmpty(f12389a)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(context, f12391c);
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    f12393e = m11499c(multiProcessSP);
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>>> primaryKey: " + f12393e);
                }
                SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f12394f, 0);
                if (sharedPreferences != null) {
                    f12395g = sharedPreferences.getString(f12391c, null);
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 子进程备份秘钥：主进程key: " + f12395g);
                }
                f12389a = m11499c(UMUtils.genId());
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>>> 正式秘钥：key: " + f12389a);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public String m11500a(String str) {
        try {
            return TextUtils.isEmpty(f12389a) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f12389a.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }
}
