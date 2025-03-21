package p031c.p035b.p043c.p070y.p071a;

import java.util.regex.Pattern;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.EnumC0953a;
import p388ui.activity.BaseProgressUploadActivity;

/* compiled from: VINResultParser.java */
/* renamed from: c.b.c.y.a.i0 */
/* loaded from: classes.dex */
public final class C1142i0 extends AbstractC1156u {

    /* renamed from: f */
    private static final Pattern f2340f = Pattern.compile("[IOQ]");

    /* renamed from: g */
    private static final Pattern f2341g = Pattern.compile("[A-Z0-9]{17}");

    /* renamed from: b */
    private static int m2082b(int i2) {
        if (i2 >= 1 && i2 <= 7) {
            return 9 - i2;
        }
        if (i2 == 8) {
            return 10;
        }
        if (i2 == 9) {
            return 0;
        }
        if (i2 < 10 || i2 > 17) {
            throw new IllegalArgumentException();
        }
        return 19 - i2;
    }

    /* renamed from: c */
    private static int m2084c(char c2) {
        if (c2 >= 'A' && c2 <= 'I') {
            return (c2 - 'A') + 1;
        }
        if (c2 >= 'J' && c2 <= 'R') {
            return (c2 - 'J') + 1;
        }
        if (c2 >= 'S' && c2 <= 'Z') {
            return (c2 - 'S') + 2;
        }
        if (c2 < '0' || c2 > '9') {
            throw new IllegalArgumentException();
        }
        return c2 - '0';
    }

    /* renamed from: b */
    private static int m2081b(char c2) {
        if (c2 >= 'E' && c2 <= 'H') {
            return (c2 - 'E') + 1984;
        }
        if (c2 >= 'J' && c2 <= 'N') {
            return (c2 - 'J') + 1988;
        }
        if (c2 == 'P') {
            return 1993;
        }
        if (c2 >= 'R' && c2 <= 'T') {
            return (c2 - 'R') + 1994;
        }
        if (c2 >= 'V' && c2 <= 'Y') {
            return (c2 - 'V') + 1997;
        }
        if (c2 >= '1' && c2 <= '9') {
            return (c2 - '1') + BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_1;
        }
        if (c2 < 'A' || c2 > 'D') {
            throw new IllegalArgumentException();
        }
        return (c2 - 'A') + 2010;
    }

    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1156u
    /* renamed from: a */
    public C1140h0 mo2004a(C1107r c1107r) {
        if (c1107r.m1910a() != EnumC0953a.CODE_39) {
            return null;
        }
        String trim = f2340f.matcher(c1107r.m1917e()).replaceAll("").trim();
        if (!f2341g.matcher(trim).matches()) {
            return null;
        }
        try {
            if (!m2080a((CharSequence) trim)) {
                return null;
            }
            String substring = trim.substring(0, 3);
            return new C1140h0(trim, substring, trim.substring(3, 9), trim.substring(9, 17), m2083b((CharSequence) substring), trim.substring(3, 8), m2081b(trim.charAt(9)), trim.charAt(10), trim.substring(11));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: b */
    private static String m2083b(CharSequence charSequence) {
        char charAt = charSequence.charAt(0);
        char charAt2 = charSequence.charAt(1);
        if (charAt == '9') {
            if (charAt2 >= 'A' && charAt2 <= 'E') {
                return "BR";
            }
            if (charAt2 < '3' || charAt2 > '9') {
                return null;
            }
            return "BR";
        }
        if (charAt == 'S') {
            if (charAt2 >= 'A' && charAt2 <= 'M') {
                return "UK";
            }
            if (charAt2 < 'N' || charAt2 > 'T') {
                return null;
            }
            return "DE";
        }
        if (charAt == 'Z') {
            if (charAt2 < 'A' || charAt2 > 'R') {
                return null;
            }
            return "IT";
        }
        switch (charAt) {
            case '1':
            case '4':
            case '5':
                return "US";
            case '2':
                return "CA";
            case '3':
                if (charAt2 < 'A' || charAt2 > 'W') {
                    return null;
                }
                return "MX";
            default:
                switch (charAt) {
                    case 'J':
                        if (charAt2 < 'A' || charAt2 > 'T') {
                            return null;
                        }
                        return "JP";
                    case 'K':
                        if (charAt2 < 'L' || charAt2 > 'R') {
                            return null;
                        }
                        return "KO";
                    case 'L':
                        return "CN";
                    case 'M':
                        if (charAt2 < 'A' || charAt2 > 'E') {
                            return null;
                        }
                        return "IN";
                    default:
                        switch (charAt) {
                            case 'V':
                                if (charAt2 >= 'F' && charAt2 <= 'R') {
                                    return "FR";
                                }
                                if (charAt2 < 'S' || charAt2 > 'W') {
                                    return null;
                                }
                                return "ES";
                            case 'W':
                                return "DE";
                            case 'X':
                                if (charAt2 == '0') {
                                    return "RU";
                                }
                                if (charAt2 < '3' || charAt2 > '9') {
                                    return null;
                                }
                                return "RU";
                            default:
                                return null;
                        }
                }
        }
    }

    /* renamed from: a */
    private static boolean m2080a(CharSequence charSequence) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < charSequence.length()) {
            int i4 = i2 + 1;
            i3 += m2082b(i4) * m2084c(charSequence.charAt(i2));
            i2 = i4;
        }
        return charSequence.charAt(8) == m2079a(i3 % 11);
    }

    /* renamed from: a */
    private static char m2079a(int i2) {
        if (i2 < 10) {
            return (char) (i2 + 48);
        }
        if (i2 == 10) {
            return 'X';
        }
        throw new IllegalArgumentException();
    }
}
