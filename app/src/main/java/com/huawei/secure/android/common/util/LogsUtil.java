package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class LogsUtil {

    /* renamed from: a */
    private static final Pattern f8267a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    /* renamed from: b */
    private static final char f8268b = '*';

    /* renamed from: c */
    private static final int f8269c = 2;

    /* renamed from: com.huawei.secure.android.common.util.LogsUtil$a */
    private static class C2567a extends Throwable {

        /* renamed from: d */
        private static final long f8270d = 7129050843360571879L;

        /* renamed from: a */
        private String f8271a;

        /* renamed from: b */
        private Throwable f8272b;

        /* renamed from: c */
        private Throwable f8273c;

        public C2567a(Throwable th) {
            this.f8273c = th;
        }

        /* renamed from: a */
        public void m8040a(Throwable th) {
            this.f8272b = th;
        }

        @Override // java.lang.Throwable
        public synchronized Throwable getCause() {
            Throwable th;
            th = this.f8272b;
            if (th == this) {
                th = null;
            }
            return th;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.f8271a;
        }

        @Override // java.lang.Throwable
        public String toString() {
            Throwable th = this.f8273c;
            if (th == null) {
                return "";
            }
            String name = th.getClass().getName();
            if (this.f8271a == null) {
                return name;
            }
            String str = name + ": ";
            if (this.f8271a.startsWith(str)) {
                return this.f8271a;
            }
            return str + this.f8271a;
        }

        /* renamed from: a */
        public void m8039a(String str) {
            this.f8271a = str;
        }
    }

    /* renamed from: a */
    private static String m8013a(String str, boolean z) {
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                sb.append(m8011a(str));
            } else {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    private static String m8014b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (i2 % 2 == 0) {
                charArray[i2] = f8268b;
            }
        }
        return new String(charArray);
    }

    /* renamed from: d */
    public static void m8020d(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        m8013a(str2, z);
    }

    /* renamed from: e */
    public static void m8026e(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        m8013a(str2, z);
    }

    public static Throwable getNewThrowable(Throwable th) {
        if (th == null) {
            return null;
        }
        C2567a c2567a = new C2567a(th);
        c2567a.setStackTrace(th.getStackTrace());
        c2567a.m8039a(m8014b(th.getMessage()));
        Throwable cause = th.getCause();
        C2567a c2567a2 = c2567a;
        while (cause != null) {
            C2567a c2567a3 = new C2567a(cause);
            c2567a3.setStackTrace(cause.getStackTrace());
            c2567a3.m8039a(m8014b(cause.getMessage()));
            c2567a2.m8040a(c2567a3);
            cause = cause.getCause();
            c2567a2 = c2567a3;
        }
        return c2567a;
    }

    /* renamed from: i */
    public static void m8032i(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        m8013a(str2, z);
    }

    /* renamed from: w */
    public static void m8038w(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        m8013a(str2, z);
    }

    /* renamed from: d */
    public static void m8016d(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        m8012a(str2, str3);
    }

    /* renamed from: e */
    public static void m8022e(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        m8012a(str2, str3);
    }

    /* renamed from: i */
    public static void m8028i(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        m8012a(str2, str3);
    }

    /* renamed from: w */
    public static void m8034w(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        m8012a(str2, str3);
    }

    /* renamed from: d */
    public static void m8017d(String str, String str2, String str3, Throwable th) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        m8012a(str2, str3);
        getNewThrowable(th);
    }

    /* renamed from: e */
    public static void m8023e(String str, String str2, String str3, Throwable th) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        m8012a(str2, str3);
        getNewThrowable(th);
    }

    /* renamed from: i */
    public static void m8029i(String str, String str2, String str3, Throwable th) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        m8012a(str2, str3);
        getNewThrowable(th);
    }

    /* renamed from: w */
    public static void m8035w(String str, String str2, String str3, Throwable th) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        m8012a(str2, str3);
        getNewThrowable(th);
    }

    /* renamed from: a */
    private static String m8012a(String str, String str2) {
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(m8011a(str2));
        }
        return sb.toString();
    }

    /* renamed from: d */
    public static void m8015d(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        m8013a(str2, false);
    }

    /* renamed from: e */
    public static void m8021e(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        m8013a(str2, false);
    }

    /* renamed from: i */
    public static void m8027i(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        m8013a(str2, false);
    }

    /* renamed from: w */
    public static void m8033w(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        m8013a(str2, false);
    }

    /* renamed from: d */
    public static void m8019d(String str, String str2, Throwable th, boolean z) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        m8013a(str2, z);
        getNewThrowable(th);
    }

    /* renamed from: e */
    public static void m8025e(String str, String str2, Throwable th, boolean z) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        m8013a(str2, z);
        getNewThrowable(th);
    }

    /* renamed from: i */
    public static void m8031i(String str, String str2, Throwable th, boolean z) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        m8013a(str2, z);
        getNewThrowable(th);
    }

    /* renamed from: w */
    public static void m8037w(String str, String str2, Throwable th, boolean z) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        m8013a(str2, z);
        getNewThrowable(th);
    }

    /* renamed from: d */
    public static void m8018d(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        m8013a(str2, false);
        getNewThrowable(th);
    }

    /* renamed from: e */
    public static void m8024e(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        m8013a(str2, false);
        getNewThrowable(th);
    }

    /* renamed from: i */
    public static void m8030i(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        m8013a(str2, false);
        getNewThrowable(th);
    }

    /* renamed from: w */
    public static void m8036w(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2) && th == null) {
            return;
        }
        m8013a(str2, false);
        getNewThrowable(th);
    }

    /* renamed from: a */
    private static String m8011a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i2 = 1;
        if (1 == length) {
            return String.valueOf(f8268b);
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (f8267a.matcher(String.valueOf(charAt)).matches()) {
                if (i2 % 2 == 0) {
                    charAt = f8268b;
                }
                i2++;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }
}
