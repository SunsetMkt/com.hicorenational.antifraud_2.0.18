package com.google.gson.p147b0;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: PreJava9DateFormatProvider.java */
/* renamed from: com.google.gson.b0.l */
/* loaded from: classes.dex */
public class C2019l {
    /* renamed from: a */
    public static DateFormat m5374a(int i2, int i3) {
        return new SimpleDateFormat(m5375b(i2) + AbstractC1191a.f2568g + m5376c(i3), Locale.US);
    }

    /* renamed from: b */
    private static String m5375b(int i2) {
        if (i2 == 0) {
            return "EEEE, MMMM d, yyyy";
        }
        if (i2 == 1) {
            return "MMMM d, yyyy";
        }
        if (i2 == 2) {
            return "MMM d, yyyy";
        }
        if (i2 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i2);
    }

    /* renamed from: c */
    private static String m5376c(int i2) {
        if (i2 == 0 || i2 == 1) {
            return "h:mm:ss a z";
        }
        if (i2 == 2) {
            return "h:mm:ss a";
        }
        if (i2 == 3) {
            return "h:mm a";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i2);
    }

    /* renamed from: d */
    public static DateFormat m5377d(int i2) {
        return new SimpleDateFormat(m5373a(i2), Locale.US);
    }

    /* renamed from: a */
    private static String m5373a(int i2) {
        if (i2 == 0) {
            return "EEEE, MMMM d, y";
        }
        if (i2 == 1) {
            return "MMMM d, y";
        }
        if (i2 == 2) {
            return "MMM d, y";
        }
        if (i2 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i2);
    }
}
