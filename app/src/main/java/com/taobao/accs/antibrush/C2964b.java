package com.taobao.accs.antibrush;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.client.GlobalConfig;
import com.taobao.accs.utl.ALog;
import java.util.StringTokenizer;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.antibrush.b */
/* loaded from: classes.dex */
public class C2964b {
    public static final String KEY_SEC = "sec";
    public static final String TAG = "CookieMgr";

    /* renamed from: a */
    public static CookieManager f9376a = null;

    /* renamed from: b */
    private static volatile boolean f9377b = false;

    /* renamed from: a */
    public static synchronized void m8910a(Context context) {
        synchronized (C2964b.class) {
            try {
            } catch (Throwable th) {
                ALog.m9181e(TAG, "setup", th, new Object[0]);
            }
            if (!GlobalConfig.enableCookie) {
                ALog.m9183i(TAG, "disable cookie", new Object[0]);
                return;
            }
            if (f9377b) {
                return;
            }
            if (Build.VERSION.SDK_INT < 21) {
                CookieSyncManager.createInstance(context);
            }
            f9376a = CookieManager.getInstance();
            f9376a.setAcceptCookie(true);
            if (Build.VERSION.SDK_INT < 21) {
                f9376a.removeExpiredCookie();
            }
            f9377b = true;
        }
    }

    /* renamed from: b */
    public static String m8912b(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        do {
            try {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf == -1) {
                    throw new IllegalArgumentException("Invalid cookie name-value pair");
                }
                String trim = nextToken.substring(0, indexOf).trim();
                String trim2 = nextToken.substring(indexOf + 1).trim();
                if (KEY_SEC.equals(trim)) {
                    str2 = m8913c(trim2);
                }
            } catch (Throwable th) {
                ALog.m9181e(TAG, "parse", th, new Object[0]);
            }
        } while (stringTokenizer.hasMoreTokens());
        return str2;
    }

    /* renamed from: c */
    private static String m8913c(String str) {
        return (str == null || str.length() <= 2 || str.charAt(0) != '\"' || str.charAt(str.length() - 1) != '\"') ? (str == null || str.length() <= 2 || str.charAt(0) != '\'' || str.charAt(str.length() - 1) != '\'') ? str : str.substring(1, str.length() - 1) : str.substring(1, str.length() - 1);
    }

    /* renamed from: a */
    private static boolean m8911a() {
        Context context;
        if (!f9377b && (context = GlobalClientInfo.f9386a) != null) {
            m8910a(context);
        }
        return f9377b;
    }

    /* renamed from: a */
    public static synchronized String m8909a(String str) {
        synchronized (C2964b.class) {
            String str2 = null;
            if (!m8911a()) {
                ALog.m9182e(TAG, "cookieMgr not setup", new Object[0]);
                return null;
            }
            try {
                str2 = m8912b(f9376a.getCookie(str));
            } catch (Throwable th) {
                ALog.m9181e(TAG, "get cookie failed. url=" + str, th, new Object[0]);
            }
            return str2;
        }
    }
}
