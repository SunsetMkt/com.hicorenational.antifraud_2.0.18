package com.umeng.commonsdk.statistics.common;

import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: classes2.dex */
public class MLog {
    public static boolean DEBUG = false;
    private static final int LEVEL_DEBUG = 2;
    private static final int LEVEL_ERROR = 5;
    private static final int LEVEL_INFO = 3;
    private static final int LEVEL_VERBOSE = 1;
    private static final int LEVEL_WARN = 4;
    private static int LOG_MAXLENGTH = 2000;
    private static String TAG = "MobclickAgent";

    private MLog() {
    }

    /* renamed from: d */
    public static void m11743d(Locale locale, String str, Object... objArr) {
        try {
            m11739d(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m11748e(th);
        }
    }

    /* renamed from: e */
    public static void m11749e(Locale locale, String str, Object... objArr) {
        try {
            m11745e(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m11748e(th);
        }
    }

    public static String getStackTrace(Throwable th) {
        StringWriter stringWriter;
        PrintWriter printWriter = null;
        try {
            stringWriter = new StringWriter();
            try {
                PrintWriter printWriter2 = new PrintWriter(stringWriter);
                try {
                    th.printStackTrace(printWriter2);
                    printWriter2.flush();
                    stringWriter.flush();
                    String stringWriter2 = stringWriter.toString();
                    try {
                        stringWriter.close();
                    } catch (Throwable unused) {
                    }
                    printWriter2.close();
                    return stringWriter2;
                } catch (Throwable unused2) {
                    printWriter = printWriter2;
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    return "";
                }
            } catch (Throwable unused4) {
            }
        } catch (Throwable unused5) {
            stringWriter = null;
        }
    }

    /* renamed from: i */
    public static void m11755i(Locale locale, String str, Object... objArr) {
        try {
            m11751i(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m11748e(th);
        }
    }

    private static void print(int i2, String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2)) {
            int length = str2.length();
            int i3 = LOG_MAXLENGTH;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (i4 >= 100) {
                    break;
                }
                if (length > i3) {
                    if (i2 == 1) {
                        str2.substring(i5, i3);
                    } else if (i2 == 2) {
                        str2.substring(i5, i3);
                    } else if (i2 == 3) {
                        str2.substring(i5, i3);
                    } else if (i2 == 4) {
                        str2.substring(i5, i3);
                    } else if (i2 == 5) {
                        str2.substring(i5, i3);
                    }
                    i4++;
                    i5 = i3;
                    i3 = LOG_MAXLENGTH + i3;
                } else if (i2 == 1) {
                    str2.substring(i5, length);
                } else if (i2 == 2) {
                    str2.substring(i5, length);
                } else if (i2 == 3) {
                    str2.substring(i5, length);
                } else if (i2 == 4) {
                    str2.substring(i5, length);
                } else if (i2 == 5) {
                    str2.substring(i5, length);
                }
            }
        }
        if (th != null) {
            TextUtils.isEmpty(getStackTrace(th));
        }
    }

    /* renamed from: v */
    public static void m11761v(Locale locale, String str, Object... objArr) {
        try {
            m11757v(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m11748e(th);
        }
    }

    /* renamed from: w */
    public static void m11767w(Locale locale, String str, Object... objArr) {
        try {
            m11763w(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m11748e(th);
        }
    }

    /* renamed from: d */
    public static void m11741d(String str, Object... objArr) {
        try {
            if (str.contains("%")) {
                m11739d(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                m11739d(str, objArr != null ? (String) objArr[0] : "", (Throwable) null);
            }
        } catch (Throwable th) {
            m11748e(th);
        }
    }

    /* renamed from: e */
    public static void m11747e(String str, Object... objArr) {
        try {
            if (str.contains("%")) {
                m11745e(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                m11745e(str, objArr != null ? (String) objArr[0] : "", (Throwable) null);
            }
        } catch (Throwable th) {
            m11748e(th);
        }
    }

    /* renamed from: i */
    public static void m11753i(String str, Object... objArr) {
        try {
            if (str.contains("%")) {
                m11751i(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                m11751i(str, objArr != null ? (String) objArr[0] : "", (Throwable) null);
            }
        } catch (Throwable th) {
            m11748e(th);
        }
    }

    /* renamed from: v */
    public static void m11759v(String str, Object... objArr) {
        try {
            if (str.contains("%")) {
                m11757v(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                m11757v(str, objArr != null ? (String) objArr[0] : "", (Throwable) null);
            }
        } catch (Throwable th) {
            m11748e(th);
        }
    }

    /* renamed from: w */
    public static void m11765w(String str, Object... objArr) {
        try {
            if (str.contains("%")) {
                m11763w(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                m11763w(str, objArr != null ? (String) objArr[0] : "", (Throwable) null);
            }
        } catch (Throwable th) {
            m11748e(th);
        }
    }

    /* renamed from: d */
    public static void m11742d(Throwable th) {
        m11739d(TAG, (String) null, th);
    }

    /* renamed from: e */
    public static void m11748e(Throwable th) {
        m11745e(TAG, (String) null, th);
    }

    /* renamed from: i */
    public static void m11754i(Throwable th) {
        m11751i(TAG, (String) null, th);
    }

    /* renamed from: v */
    public static void m11760v(Throwable th) {
        m11757v(TAG, (String) null, th);
    }

    /* renamed from: w */
    public static void m11766w(Throwable th) {
        m11763w(TAG, (String) null, th);
    }

    /* renamed from: d */
    public static void m11740d(String str, Throwable th) {
        m11739d(TAG, str, th);
    }

    /* renamed from: e */
    public static void m11746e(String str, Throwable th) {
        m11745e(TAG, str, th);
    }

    /* renamed from: i */
    public static void m11752i(String str, Throwable th) {
        m11751i(TAG, str, th);
    }

    /* renamed from: v */
    public static void m11758v(String str, Throwable th) {
        m11757v(TAG, str, th);
    }

    /* renamed from: w */
    public static void m11764w(String str, Throwable th) {
        m11763w(TAG, str, th);
    }

    /* renamed from: d */
    public static void m11738d(String str) {
        m11739d(TAG, str, (Throwable) null);
    }

    /* renamed from: e */
    public static void m11744e(String str) {
        m11745e(TAG, str, (Throwable) null);
    }

    /* renamed from: i */
    public static void m11750i(String str) {
        m11751i(TAG, str, (Throwable) null);
    }

    /* renamed from: v */
    public static void m11756v(String str) {
        m11757v(TAG, str, (Throwable) null);
    }

    /* renamed from: w */
    public static void m11762w(String str) {
        m11763w(TAG, str, (Throwable) null);
    }

    /* renamed from: d */
    public static void m11739d(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(2, str, str2, th);
        }
    }

    /* renamed from: e */
    public static void m11745e(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(5, str, str2, th);
        }
    }

    /* renamed from: i */
    public static void m11751i(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(3, str, str2, th);
        }
    }

    /* renamed from: v */
    public static void m11757v(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(1, str, str2, th);
        }
    }

    /* renamed from: w */
    public static void m11763w(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(4, str, str2, th);
        }
    }
}
