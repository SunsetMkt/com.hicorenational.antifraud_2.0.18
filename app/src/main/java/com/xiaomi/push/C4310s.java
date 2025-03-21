package com.xiaomi.push;

import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Collection;

/* renamed from: com.xiaomi.push.s */
/* loaded from: classes2.dex */
public class C4310s {

    /* renamed from: com.xiaomi.push.s$a */
    public static class a {

        /* renamed from: a */
        private final String f16397a;

        /* renamed from: a */
        private final StringBuilder f16398a;

        /* renamed from: b */
        private final String f16399b;

        public a() {
            this(Constants.COLON_SEPARATOR, Constants.ACCEPT_TIME_SEPARATOR_SP);
        }

        /* renamed from: a */
        public a m15730a(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                if (this.f16398a.length() > 0) {
                    this.f16398a.append(this.f16399b);
                }
                StringBuilder sb = this.f16398a;
                sb.append(str);
                sb.append(this.f16397a);
                sb.append(obj);
            }
            return this;
        }

        public String toString() {
            return this.f16398a.toString();
        }

        public a(String str, String str2) {
            this.f16398a = new StringBuilder();
            this.f16397a = str;
            this.f16399b = str2;
        }
    }

    /* renamed from: a */
    public static int m15725a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return i2;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i2;
        }
    }

    /* renamed from: b */
    public static int m15729b(String str, int i2) {
        return !TextUtils.isEmpty(str) ? ((str.hashCode() / 10) * 10) + i2 : i2;
    }

    /* renamed from: a */
    public static long m15726a(String str, long j2) {
        if (TextUtils.isEmpty(str)) {
            return j2;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return j2;
        }
    }

    /* renamed from: a */
    public static boolean m15728a(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /* renamed from: a */
    public static boolean m15727a() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }
}
