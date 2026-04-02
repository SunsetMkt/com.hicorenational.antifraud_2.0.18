package com.google.gson.b0.q.p;

import com.xiaomi.mipush.sdk.Constants;
import i.z2.h0;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: ISO8601Utils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String a = "UTC";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final TimeZone f3760b = TimeZone.getTimeZone(a);

    public static String a(Date date) {
        return a(date, false, f3760b);
    }

    public static String a(Date date, boolean z) {
        return a(date, z, f3760b);
    }

    public static String a(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        a(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        a(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        a(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        a(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        a(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        a(sb, gregorianCalendar.get(13), 2);
        if (z) {
            sb.append('.');
            a(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i2 = offset / 60000;
            int iAbs = Math.abs(i2 / 60);
            int iAbs2 = Math.abs(i2 % 60);
            sb.append(offset >= 0 ? '+' : '-');
            a(sb, iAbs, 2);
            sb.append(':');
            a(sb, iAbs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00ce A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bb, NumberFormatException -> 0x01bd, IndexOutOfBoundsException -> 0x01bf, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bb, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0036, B:13:0x003c, B:17:0x0054, B:19:0x0064, B:20:0x0066, B:22:0x0072, B:23:0x0074, B:25:0x007a, B:29:0x0084, B:34:0x0094, B:36:0x009c, B:47:0x00c8, B:49:0x00ce, B:51:0x00d5, B:75:0x0182, B:55:0x00df, B:56:0x00fa, B:57:0x00fb, B:61:0x0117, B:63:0x0124, B:66:0x012d, B:68:0x014c, B:71:0x015b, B:72:0x017d, B:74:0x0180, B:60:0x0106, B:77:0x01b3, B:78:0x01ba, B:40:0x00b6, B:41:0x00b9), top: B:94:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b3 A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bb, NumberFormatException -> 0x01bd, IndexOutOfBoundsException -> 0x01bf, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bb, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0036, B:13:0x003c, B:17:0x0054, B:19:0x0064, B:20:0x0066, B:22:0x0072, B:23:0x0074, B:25:0x007a, B:29:0x0084, B:34:0x0094, B:36:0x009c, B:47:0x00c8, B:49:0x00ce, B:51:0x00d5, B:75:0x0182, B:55:0x00df, B:56:0x00fa, B:57:0x00fb, B:61:0x0117, B:63:0x0124, B:66:0x012d, B:68:0x014c, B:71:0x015b, B:72:0x017d, B:74:0x0180, B:60:0x0106, B:77:0x01b3, B:78:0x01ba, B:40:0x00b6, B:41:0x00b9), top: B:94:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Date a(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        int i2;
        int iA;
        int iA2;
        int i3;
        int i4;
        int length;
        TimeZone timeZone;
        char cCharAt;
        try {
            int index = parsePosition.getIndex();
            int i5 = index + 4;
            int iA3 = a(str, index, i5);
            if (a(str, i5, '-')) {
                i5++;
            }
            int i6 = i5 + 2;
            int iA4 = a(str, i5, i6);
            if (a(str, i6, '-')) {
                i6++;
            }
            int i7 = i6 + 2;
            int iA5 = a(str, i6, i7);
            boolean zA = a(str, i7, 'T');
            if (!zA && str.length() <= i7) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(iA3, iA4 - 1, iA5);
                gregorianCalendar.setLenient(false);
                parsePosition.setIndex(i7);
                return gregorianCalendar.getTime();
            }
            if (zA) {
                int i8 = i7 + 1;
                int i9 = i8 + 2;
                iA = a(str, i8, i9);
                if (a(str, i9, ':')) {
                    i9++;
                }
                i2 = i9 + 2;
                iA2 = a(str, i9, i2);
                if (a(str, i2, ':')) {
                    i2++;
                }
                if (str.length() > i2 && (cCharAt = str.charAt(i2)) != 'Z' && cCharAt != '+' && cCharAt != '-') {
                    int i10 = i2 + 2;
                    int iA6 = a(str, i2, i10);
                    if (iA6 > 59 && iA6 < 63) {
                        iA6 = 59;
                    }
                    if (a(str, i10, '.')) {
                        int i11 = i10 + 1;
                        int iA7 = a(str, i11 + 1);
                        int iMin = Math.min(iA7, i11 + 3);
                        int iA8 = a(str, i11, iMin);
                        int i12 = iMin - i11;
                        if (i12 == 1) {
                            iA8 *= 100;
                        } else if (i12 == 2) {
                            iA8 *= 10;
                        }
                        i4 = iA8;
                        i3 = iA6;
                        i2 = iA7;
                        if (str.length() > i2) {
                            char cCharAt2 = str.charAt(i2);
                            if (cCharAt2 == 'Z') {
                                timeZone = f3760b;
                                length = i2 + 1;
                            } else {
                                if (cCharAt2 != '+' && cCharAt2 != '-') {
                                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt2 + "'");
                                }
                                String strSubstring = str.substring(i2);
                                if (strSubstring.length() < 5) {
                                    strSubstring = strSubstring + "00";
                                }
                                length = i2 + strSubstring.length();
                                if (!"+0000".equals(strSubstring) && !"+00:00".equals(strSubstring)) {
                                    String str3 = "GMT" + strSubstring;
                                    TimeZone timeZone2 = TimeZone.getTimeZone(str3);
                                    String id = timeZone2.getID();
                                    if (!id.equals(str3) && !id.replace(Constants.COLON_SEPARATOR, "").equals(str3)) {
                                        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone2.getID());
                                    }
                                    timeZone = timeZone2;
                                } else {
                                    timeZone = f3760b;
                                }
                            }
                            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
                            gregorianCalendar2.setLenient(false);
                            gregorianCalendar2.set(1, iA3);
                            gregorianCalendar2.set(2, iA4 - 1);
                            gregorianCalendar2.set(5, iA5);
                            gregorianCalendar2.set(11, iA);
                            gregorianCalendar2.set(12, iA2);
                            gregorianCalendar2.set(13, i3);
                            gregorianCalendar2.set(14, i4);
                            parsePosition.setIndex(length);
                            return gregorianCalendar2.getTime();
                        }
                        throw new IllegalArgumentException("No time zone indicator");
                    }
                    i3 = iA6;
                    i2 = i10;
                }
                i4 = 0;
                if (str.length() > i2) {
                }
            } else {
                i2 = i7;
                iA = 0;
                iA2 = 0;
            }
            i3 = 0;
            i4 = 0;
            if (str.length() > i2) {
            }
        } catch (IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException e2) {
            if (str == null) {
                str2 = null;
            } else {
                str2 = h0.a + str + h0.a;
            }
            String message = e2.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + e2.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e2);
            throw parseException;
        }
    }

    private static boolean a(String str, int i2, char c2) {
        return i2 < str.length() && str.charAt(i2) == c2;
    }

    private static int a(String str, int i2, int i3) throws NumberFormatException {
        int i4;
        int i5;
        if (i2 < 0 || i3 > str.length() || i2 > i3) {
            throw new NumberFormatException(str);
        }
        if (i2 < i3) {
            i4 = i2 + 1;
            int iDigit = Character.digit(str.charAt(i2), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
            i5 = -iDigit;
        } else {
            i4 = i2;
            i5 = 0;
        }
        while (i4 < i3) {
            int i6 = i4 + 1;
            int iDigit2 = Character.digit(str.charAt(i4), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
            i5 = (i5 * 10) - iDigit2;
            i4 = i6;
        }
        return -i5;
    }

    private static void a(StringBuilder sb, int i2, int i3) {
        String string = Integer.toString(i2);
        for (int length = i3 - string.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(string);
    }

    private static int a(String str, int i2) {
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < '0' || cCharAt > '9') {
                return i2;
            }
            i2++;
        }
        return str.length();
    }
}
