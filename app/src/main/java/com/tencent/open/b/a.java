package com.tencent.open.b;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.taobao.accs.utl.UtilityImpl;
import com.tencent.open.log.SLog;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    protected static final Uri a = Uri.parse("content://telephony/carriers/preferapn");

    public static String a(Context context) {
        int iD = d(context);
        if (iD == 2) {
            return UtilityImpl.NET_TYPE_WIFI;
        }
        if (iD == 1) {
            return "cmwap";
        }
        if (iD == 4) {
            return "cmnet";
        }
        if (iD == 16) {
            return "uniwap";
        }
        if (iD == 8) {
            return "uninet";
        }
        if (iD == 64) {
            return "wap";
        }
        if (iD == 32) {
            return "net";
        }
        if (iD == 512) {
            return "ctwap";
        }
        if (iD == 256) {
            return "ctnet";
        }
        if (iD == 2048) {
            return "3gnet";
        }
        if (iD == 1024) {
            return "3gwap";
        }
        String strB = b(context);
        return (strB == null || strB.length() == 0) ? "none" : strB;
    }

    public static String b(Context context) {
        return "";
    }

    public static String c(Context context) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(a, null, null, null, null);
            if (cursorQuery == null) {
                return null;
            }
            cursorQuery.moveToFirst();
            if (cursorQuery.isAfterLast()) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            }
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("proxy"));
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return string;
        } catch (SecurityException e2) {
            SLog.e("openSDK_LOG.APNUtil", "getApnProxy has exception: " + e2.getMessage());
            return "";
        }
    }

    public static int d(Context context) {
        try {
            NetworkInfo networkInfoE = e(context);
            if (networkInfoE == null) {
                return 128;
            }
            if (networkInfoE.getTypeName().toUpperCase().equals("WIFI")) {
                return 2;
            }
            String lowerCase = networkInfoE.getExtraInfo().toLowerCase();
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
                    String strC = c(context);
                    if (strC != null) {
                        if (strC.length() > 0) {
                            return 512;
                        }
                    }
                    return 256;
                }
            }
            return 4;
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.APNUtil", "getMProxyType has exception: " + e2.getMessage());
        }
        return 128;
    }

    static NetworkInfo e(Context context) {
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
