package c.b.c.y.a;

import java.util.regex.Pattern;
import ui.activity.BaseProgressUploadActivity;

/* compiled from: VINResultParser.java */
/* loaded from: classes.dex */
public final class i0 extends u {

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f2959f = Pattern.compile("[IOQ]");

    /* renamed from: g, reason: collision with root package name */
    private static final Pattern f2960g = Pattern.compile("[A-Z0-9]{17}");

    private static int b(int i2) {
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

    private static int c(char c2) {
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

    private static int b(char c2) {
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

    @Override // c.b.c.y.a.u
    public h0 a(c.b.c.r rVar) {
        if (rVar.a() != c.b.c.a.CODE_39) {
            return null;
        }
        String trim = f2959f.matcher(rVar.e()).replaceAll("").trim();
        if (!f2960g.matcher(trim).matches()) {
            return null;
        }
        try {
            if (!a((CharSequence) trim)) {
                return null;
            }
            String substring = trim.substring(0, 3);
            return new h0(trim, substring, trim.substring(3, 9), trim.substring(9, 17), b((CharSequence) substring), trim.substring(3, 8), b(trim.charAt(9)), trim.charAt(10), trim.substring(11));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static String b(CharSequence charSequence) {
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

    private static boolean a(CharSequence charSequence) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < charSequence.length()) {
            int i4 = i2 + 1;
            i3 += b(i4) * c(charSequence.charAt(i2));
            i2 = i4;
        }
        return charSequence.charAt(8) == a(i3 % 11);
    }

    private static char a(int i2) {
        if (i2 < 10) {
            return (char) (i2 + 48);
        }
        if (i2 == 10) {
            return 'X';
        }
        throw new IllegalArgumentException();
    }
}
