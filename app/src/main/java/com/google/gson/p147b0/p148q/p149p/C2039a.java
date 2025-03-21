package com.google.gson.p147b0.p148q.p149p;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: ISO8601Utils.java */
/* renamed from: com.google.gson.b0.q.p.a */
/* loaded from: classes.dex */
public class C2039a {

    /* renamed from: a */
    private static final String f5878a = "UTC";

    /* renamed from: b */
    private static final TimeZone f5879b = TimeZone.getTimeZone(f5878a);

    /* renamed from: a */
    public static String m5521a(Date date) {
        return m5523a(date, false, f5879b);
    }

    /* renamed from: a */
    public static String m5522a(Date date, boolean z) {
        return m5523a(date, z, f5879b);
    }

    /* renamed from: a */
    public static String m5523a(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        m5525a(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        m5525a(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        m5525a(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        m5525a(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        m5525a(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        m5525a(sb, gregorianCalendar.get(13), 2);
        if (z) {
            sb.append('.');
            m5525a(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i2 = offset / 60000;
            int abs = Math.abs(i2 / 60);
            int abs2 = Math.abs(i2 % 60);
            sb.append(offset >= 0 ? '+' : '-');
            m5525a(sb, abs, 2);
            sb.append(':');
            m5525a(sb, abs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ce A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bb, NumberFormatException -> 0x01bd, IndexOutOfBoundsException -> 0x01bf, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bb, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0036, B:13:0x003c, B:18:0x0054, B:20:0x0064, B:21:0x0066, B:23:0x0072, B:24:0x0074, B:26:0x007a, B:30:0x0084, B:35:0x0094, B:37:0x009c, B:42:0x00c8, B:44:0x00ce, B:46:0x00d5, B:47:0x0182, B:52:0x00df, B:53:0x00fa, B:54:0x00fb, B:57:0x0117, B:59:0x0124, B:62:0x012d, B:64:0x014c, B:67:0x015b, B:68:0x017d, B:70:0x0180, B:71:0x0106, B:72:0x01b3, B:73:0x01ba, B:74:0x00b6, B:75:0x00b9), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b3 A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bb, NumberFormatException -> 0x01bd, IndexOutOfBoundsException -> 0x01bf, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bb, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0036, B:13:0x003c, B:18:0x0054, B:20:0x0064, B:21:0x0066, B:23:0x0072, B:24:0x0074, B:26:0x007a, B:30:0x0084, B:35:0x0094, B:37:0x009c, B:42:0x00c8, B:44:0x00ce, B:46:0x00d5, B:47:0x0182, B:52:0x00df, B:53:0x00fa, B:54:0x00fb, B:57:0x0117, B:59:0x0124, B:62:0x012d, B:64:0x014c, B:67:0x015b, B:68:0x017d, B:70:0x0180, B:71:0x0106, B:72:0x01b3, B:73:0x01ba, B:74:0x00b6, B:75:0x00b9), top: B:2:0x0004 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Date m5524a(java.lang.String r17, java.text.ParsePosition r18) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.p147b0.p148q.p149p.C2039a.m5524a(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    /* renamed from: a */
    private static boolean m5526a(String str, int i2, char c2) {
        return i2 < str.length() && str.charAt(i2) == c2;
    }

    /* renamed from: a */
    private static int m5520a(String str, int i2, int i3) throws NumberFormatException {
        int i4;
        int i5;
        if (i2 < 0 || i3 > str.length() || i2 > i3) {
            throw new NumberFormatException(str);
        }
        if (i2 < i3) {
            i4 = i2 + 1;
            int digit = Character.digit(str.charAt(i2), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
            i5 = -digit;
        } else {
            i4 = i2;
            i5 = 0;
        }
        while (i4 < i3) {
            int i6 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
            i5 = (i5 * 10) - digit2;
            i4 = i6;
        }
        return -i5;
    }

    /* renamed from: a */
    private static void m5525a(StringBuilder sb, int i2, int i3) {
        String num = Integer.toString(i2);
        for (int length = i3 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }

    /* renamed from: a */
    private static int m5519a(String str, int i2) {
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt < '0' || charAt > '9') {
                return i2;
            }
            i2++;
        }
        return str.length();
    }
}
