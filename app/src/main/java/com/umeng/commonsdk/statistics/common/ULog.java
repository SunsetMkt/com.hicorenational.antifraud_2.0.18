package com.umeng.commonsdk.statistics.common;

import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: classes2.dex */
public class ULog {
    public static boolean DEBUG = false;
    private static final int LEVEL_DEBUG = 2;
    private static final int LEVEL_ERROR = 5;
    private static final int LEVEL_INFO = 3;
    private static final int LEVEL_VERBOSE = 1;
    private static final int LEVEL_WARN = 4;
    private static int LOG_MAXLENGTH = 2000;
    private static String TAG = "ULog";

    private ULog() {
    }

    /* renamed from: d */
    public static void m11773d(Locale locale, String str, Object... objArr) {
        try {
            m11769d(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m11778e(th);
        }
    }

    /* renamed from: e */
    public static void m11779e(Locale locale, String str, Object... objArr) {
        try {
            m11775e(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m11778e(th);
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
    public static void m11785i(Locale locale, String str, Object... objArr) {
        try {
            m11781i(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m11778e(th);
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
    public static void m11791v(Locale locale, String str, Object... objArr) {
        try {
            m11787v(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m11778e(th);
        }
    }

    /* renamed from: w */
    public static void m11797w(Locale locale, String str, Object... objArr) {
        try {
            m11793w(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m11778e(th);
        }
    }

    /* renamed from: d */
    public static void m11771d(String str, Object... objArr) {
        try {
            if (str.contains("%")) {
                m11769d(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                m11769d(str, objArr != null ? (String) objArr[0] : "", (Throwable) null);
            }
        } catch (Throwable th) {
            m11778e(th);
        }
    }

    /* renamed from: e */
    public static void m11777e(String str, Object... objArr) {
        try {
            if (str.contains("%")) {
                m11775e(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                m11775e(str, objArr != null ? (String) objArr[0] : "", (Throwable) null);
            }
        } catch (Throwable th) {
            m11778e(th);
        }
    }

    /* renamed from: i */
    public static void m11783i(String str, Object... objArr) {
        try {
            if (str.contains("%")) {
                m11781i(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                m11781i(str, objArr != null ? (String) objArr[0] : "", (Throwable) null);
            }
        } catch (Throwable th) {
            m11778e(th);
        }
    }

    /* renamed from: v */
    public static void m11789v(String str, Object... objArr) {
        try {
            if (str.contains("%")) {
                m11787v(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                m11787v(str, objArr != null ? (String) objArr[0] : "", (Throwable) null);
            }
        } catch (Throwable th) {
            m11778e(th);
        }
    }

    /* renamed from: w */
    public static void m11795w(String str, Object... objArr) {
        try {
            if (str.contains("%")) {
                m11793w(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                m11793w(str, objArr != null ? (String) objArr[0] : "", (Throwable) null);
            }
        } catch (Throwable th) {
            m11778e(th);
        }
    }

    /* renamed from: d */
    public static void m11772d(Throwable th) {
        m11769d(TAG, (String) null, th);
    }

    /* renamed from: e */
    public static void m11778e(Throwable th) {
        m11775e(TAG, (String) null, th);
    }

    /* renamed from: i */
    public static void m11784i(Throwable th) {
        m11781i(TAG, (String) null, th);
    }

    /* renamed from: v */
    public static void m11790v(Throwable th) {
        m11787v(TAG, (String) null, th);
    }

    /* renamed from: w */
    public static void m11796w(Throwable th) {
        m11793w(TAG, (String) null, th);
    }

    /* renamed from: d */
    public static void m11770d(String str, Throwable th) {
        m11769d(TAG, str, th);
    }

    /* renamed from: e */
    public static void m11776e(String str, Throwable th) {
        m11775e(TAG, str, th);
    }

    /* renamed from: i */
    public static void m11782i(String str, Throwable th) {
        m11781i(TAG, str, th);
    }

    /* renamed from: v */
    public static void m11788v(String str, Throwable th) {
        m11787v(TAG, str, th);
    }

    /* renamed from: w */
    public static void m11794w(String str, Throwable th) {
        m11793w(TAG, str, th);
    }

    /* renamed from: d */
    public static void m11768d(String str) {
        m11769d(TAG, str, (Throwable) null);
    }

    /* renamed from: e */
    public static void m11774e(String str) {
        m11775e(TAG, str, (Throwable) null);
    }

    /* renamed from: i */
    public static void m11780i(String str) {
        m11781i(TAG, str, (Throwable) null);
    }

    /* renamed from: v */
    public static void m11786v(String str) {
        m11787v(TAG, str, (Throwable) null);
    }

    /* renamed from: w */
    public static void m11792w(String str) {
        m11793w(TAG, str, (Throwable) null);
    }

    /* renamed from: d */
    public static void m11769d(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(2, str, str2, th);
        }
    }

    /* renamed from: e */
    public static void m11775e(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(5, str, str2, th);
        }
    }

    /* renamed from: i */
    public static void m11781i(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(3, str, str2, th);
        }
    }

    /* renamed from: v */
    public static void m11787v(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(1, str, str2, th);
        }
    }

    /* renamed from: w */
    public static void m11793w(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(4, str, str2, th);
        }
    }
}
