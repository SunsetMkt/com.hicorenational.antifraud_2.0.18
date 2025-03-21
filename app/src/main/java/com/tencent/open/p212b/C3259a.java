package com.tencent.open.p212b;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.taobao.accs.utl.UtilityImpl;
import com.tencent.open.log.SLog;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.b.a */
/* loaded from: classes2.dex */
public class C3259a {

    /* renamed from: a */
    protected static final Uri f11162a = Uri.parse("content://telephony/carriers/preferapn");

    /* renamed from: a */
    public static String m10432a(Context context) {
        int m10435d = m10435d(context);
        if (m10435d == 2) {
            return UtilityImpl.NET_TYPE_WIFI;
        }
        if (m10435d == 1) {
            return "cmwap";
        }
        if (m10435d == 4) {
            return "cmnet";
        }
        if (m10435d == 16) {
            return "uniwap";
        }
        if (m10435d == 8) {
            return "uninet";
        }
        if (m10435d == 64) {
            return "wap";
        }
        if (m10435d == 32) {
            return "net";
        }
        if (m10435d == 512) {
            return "ctwap";
        }
        if (m10435d == 256) {
            return "ctnet";
        }
        if (m10435d == 2048) {
            return "3gnet";
        }
        if (m10435d == 1024) {
            return "3gwap";
        }
        String m10433b = m10433b(context);
        return (m10433b == null || m10433b.length() == 0) ? "none" : m10433b;
    }

    /* renamed from: b */
    public static String m10433b(Context context) {
        return "";
    }

    /* renamed from: c */
    public static String m10434c(Context context) {
        try {
            Cursor query = context.getContentResolver().query(f11162a, null, null, null, null);
            if (query == null) {
                return null;
            }
            query.moveToFirst();
            if (query.isAfterLast()) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            String string = query.getString(query.getColumnIndex("proxy"));
            if (query != null) {
                query.close();
            }
            return string;
        } catch (SecurityException e2) {
            SLog.m10500e("openSDK_LOG.APNUtil", "getApnProxy has exception: " + e2.getMessage());
            return "";
        }
    }

    /* renamed from: d */
    public static int m10435d(Context context) {
        NetworkInfo m10436e;
        try {
            m10436e = m10436e(context);
        } catch (Exception e2) {
            SLog.m10500e("openSDK_LOG.APNUtil", "getMProxyType has exception: " + e2.getMessage());
        }
        if (m10436e == null) {
            return 128;
        }
        if (m10436e.getTypeName().toUpperCase().equals("WIFI")) {
            return 2;
        }
        String lowerCase = m10436e.getExtraInfo().toLowerCase();
        if (lowerCase.startsWith("cmwap")) {
            return 1;
        }
        if (!lowerCase.startsWith("cmnet") && !lowerCase.startsWith("epc.tmobile.com")) {
            if (lowerCase.startsWith("uniwap")) {
                return 16;
            }
            if (lowerCase.startsWith("uninet")) {
                return 8;
            }
            if (lowerCase.startsWith("wap")) {
                return 64;
            }
            if (lowerCase.startsWith("net")) {
                return 32;
            }
            if (lowerCase.startsWith("ctwap")) {
                return 512;
            }
            if (lowerCase.startsWith("ctnet")) {
                return 256;
            }
            if (lowerCase.startsWith("3gwap")) {
                return 1024;
            }
            if (lowerCase.startsWith("3gnet")) {
                return 2048;
            }
            if (lowerCase.startsWith("#777")) {
                String m10434c = m10434c(context);
                if (m10434c != null) {
                    if (m10434c.length() > 0) {
                        return 512;
                    }
                }
                return 256;
            }
            return 128;
        }
        return 4;
    }

    /* renamed from: e */
    static NetworkInfo m10436e(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }
}
