package com.huawei.hms.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: classes.dex */
public abstract class NetWorkUtil {

    public static final class NetType {
        public static final int NET = -2;
        public static final int TYPE_2G = 2;
        public static final int TYPE_3G = 3;
        public static final int TYPE_4G = 4;
        public static final int TYPE_5G = 5;
        public static final int TYPE_ETHERNET = 9;
        public static final int TYPE_NEED_INIT = -1;
        public static final int TYPE_OTHER = 6;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WIFI = 1;
        public static final int WAP = -3;
    }

    /* renamed from: a */
    private static NetworkInfo m7792a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static int getNetworkType(Context context) {
        if (context == null) {
            return 0;
        }
        return m7791a(m7792a(context));
    }

    /* renamed from: a */
    private static int m7791a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isConnected()) {
            if (networkInfo.getType() == 1) {
                return 1;
            }
            if (networkInfo.getType() == 0) {
                int subtype = networkInfo.getSubtype();
                if (subtype == 20) {
                    return 5;
                }
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 15:
                        return 3;
                    case 13:
                    case 14:
                        return 4;
                    default:
                        return 6;
                }
            }
            if (9 == networkInfo.getType()) {
                return 9;
            }
        }
        return 0;
    }
}
