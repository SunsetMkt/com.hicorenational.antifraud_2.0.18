package i.a.a.a.m;

import java.util.Locale;

/* compiled from: Metaphone.java */
/* loaded from: classes2.dex */
public class g implements i.a.a.a.i {

    /* renamed from: b, reason: collision with root package name */
    private static final String f16790b = "AEIOU";

    /* renamed from: c, reason: collision with root package name */
    private static final String f16791c = "EIY";

    /* renamed from: d, reason: collision with root package name */
    private static final String f16792d = "CSPTG";

    /* renamed from: a, reason: collision with root package name */
    private int f16793a = 4;

    private boolean a(int i2, int i3) {
        return i3 + 1 == i2;
    }

    private boolean a(StringBuffer stringBuffer, int i2) {
        return f16790b.indexOf(stringBuffer.charAt(i2)) >= 0;
    }

    public String b(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str.length() == 1) {
            return str.toUpperCase(Locale.ENGLISH);
        }
        char[] charArray = str.toUpperCase(Locale.ENGLISH).toCharArray();
        StringBuffer stringBuffer = new StringBuffer(40);
        StringBuffer stringBuffer2 = new StringBuffer(10);
        int i2 = 0;
        char c2 = charArray[0];
        if (c2 != 'A') {
            if (c2 == 'G' || c2 == 'K' || c2 == 'P') {
                if (charArray[1] == 'N') {
                    stringBuffer.append(charArray, 1, charArray.length - 1);
                } else {
                    stringBuffer.append(charArray);
                }
            } else if (c2 != 'W') {
                if (c2 != 'X') {
                    stringBuffer.append(charArray);
                } else {
                    charArray[0] = 'S';
                    stringBuffer.append(charArray);
                }
            } else if (charArray[1] == 'R') {
                stringBuffer.append(charArray, 1, charArray.length - 1);
            } else if (charArray[1] == 'H') {
                stringBuffer.append(charArray, 1, charArray.length - 1);
                stringBuffer.setCharAt(0, 'W');
            } else {
                stringBuffer.append(charArray);
            }
        } else if (charArray[1] == 'E') {
            stringBuffer.append(charArray, 1, charArray.length - 1);
        } else {
            stringBuffer.append(charArray);
        }
        int length = stringBuffer.length();
        while (stringBuffer2.length() < a() && i2 < length) {
            char charAt = stringBuffer.charAt(i2);
            if (charAt == 'C' || !b(stringBuffer, i2, charAt)) {
                switch (charAt) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        if (i2 == 0) {
                            stringBuffer2.append(charAt);
                            break;
                        }
                        break;
                    case 'B':
                        if (!b(stringBuffer, i2, 'M') || !a(length, i2)) {
                            stringBuffer2.append(charAt);
                            break;
                        }
                        break;
                    case 'C':
                        if (!b(stringBuffer, i2, 'S') || a(length, i2) || f16791c.indexOf(stringBuffer.charAt(i2 + 1)) < 0) {
                            if (!a(stringBuffer, i2, "CIA")) {
                                if (!a(length, i2) && f16791c.indexOf(stringBuffer.charAt(i2 + 1)) >= 0) {
                                    stringBuffer2.append('S');
                                    break;
                                } else if (!b(stringBuffer, i2, 'S') || !a(stringBuffer, i2, 'H')) {
                                    if (!a(stringBuffer, i2, 'H')) {
                                        stringBuffer2.append('K');
                                        break;
                                    } else if (i2 != 0 || length < 3 || !a(stringBuffer, 2)) {
                                        stringBuffer2.append('X');
                                        break;
                                    } else {
                                        stringBuffer2.append('K');
                                        break;
                                    }
                                } else {
                                    stringBuffer2.append('K');
                                    break;
                                }
                            } else {
                                stringBuffer2.append('X');
                                break;
                            }
                        }
                        break;
                    case 'D':
                        if (!a(length, i2 + 1) && a(stringBuffer, i2, 'G')) {
                            int i3 = i2 + 2;
                            if (f16791c.indexOf(stringBuffer.charAt(i3)) >= 0) {
                                stringBuffer2.append('J');
                                i2 = i3;
                                break;
                            }
                        }
                        stringBuffer2.append('T');
                        break;
                    case 'F':
                    case 'J':
                    case 'L':
                    case 'M':
                    case 'N':
                    case 'R':
                        stringBuffer2.append(charAt);
                        break;
                    case 'G':
                        int i4 = i2 + 1;
                        if ((!a(length, i4) || !a(stringBuffer, i2, 'H')) && ((a(length, i4) || !a(stringBuffer, i2, 'H') || a(stringBuffer, i2 + 2)) && (i2 <= 0 || (!a(stringBuffer, i2, "GN") && !a(stringBuffer, i2, "GNED"))))) {
                            boolean b2 = b(stringBuffer, i2, 'G');
                            if (!a(length, i2) && f16791c.indexOf(stringBuffer.charAt(i4)) >= 0 && !b2) {
                                stringBuffer2.append('J');
                                break;
                            } else {
                                stringBuffer2.append('K');
                                break;
                            }
                        }
                        break;
                    case 'H':
                        if (!a(length, i2) && ((i2 <= 0 || f16792d.indexOf(stringBuffer.charAt(i2 - 1)) < 0) && a(stringBuffer, i2 + 1))) {
                            stringBuffer2.append('H');
                            break;
                        }
                        break;
                    case 'K':
                        if (i2 <= 0) {
                            stringBuffer2.append(charAt);
                            break;
                        } else if (!b(stringBuffer, i2, 'C')) {
                            stringBuffer2.append(charAt);
                            break;
                        }
                        break;
                    case 'P':
                        if (!a(stringBuffer, i2, 'H')) {
                            stringBuffer2.append(charAt);
                            break;
                        } else {
                            stringBuffer2.append('F');
                            break;
                        }
                    case 'Q':
                        stringBuffer2.append('K');
                        break;
                    case 'S':
                        if (!a(stringBuffer, i2, "SH") && !a(stringBuffer, i2, "SIO") && !a(stringBuffer, i2, "SIA")) {
                            stringBuffer2.append('S');
                            break;
                        } else {
                            stringBuffer2.append('X');
                            break;
                        }
                        break;
                    case 'T':
                        if (!a(stringBuffer, i2, "TIA") && !a(stringBuffer, i2, "TIO")) {
                            if (!a(stringBuffer, i2, "TCH")) {
                                if (!a(stringBuffer, i2, "TH")) {
                                    stringBuffer2.append('T');
                                    break;
                                } else {
                                    stringBuffer2.append('0');
                                    break;
                                }
                            }
                        } else {
                            stringBuffer2.append('X');
                            break;
                        }
                        break;
                    case 'V':
                        stringBuffer2.append('F');
                        break;
                    case 'W':
                    case 'Y':
                        if (!a(length, i2) && a(stringBuffer, i2 + 1)) {
                            stringBuffer2.append(charAt);
                            break;
                        }
                        break;
                    case 'X':
                        stringBuffer2.append('K');
                        stringBuffer2.append('S');
                        break;
                    case 'Z':
                        stringBuffer2.append('S');
                        break;
                }
                i2++;
            } else {
                i2++;
            }
            if (stringBuffer2.length() > a()) {
                stringBuffer2.setLength(a());
            }
        }
        return stringBuffer2.toString();
    }

    @Override // i.a.a.a.f
    public Object encode(Object obj) throws i.a.a.a.g {
        if (obj instanceof String) {
            return b((String) obj);
        }
        throw new i.a.a.a.g("Parameter supplied to Metaphone encode is not of type java.lang.String");
    }

    private boolean a(StringBuffer stringBuffer, int i2, char c2) {
        return i2 >= 0 && i2 < stringBuffer.length() - 1 && stringBuffer.charAt(i2 + 1) == c2;
    }

    private boolean a(StringBuffer stringBuffer, int i2, String str) {
        if (i2 < 0 || (str.length() + i2) - 1 >= stringBuffer.length()) {
            return false;
        }
        return stringBuffer.substring(i2, str.length() + i2).equals(str);
    }

    @Override // i.a.a.a.i
    public String a(String str) {
        return b(str);
    }

    public boolean a(String str, String str2) {
        return b(str).equals(b(str2));
    }

    public int a() {
        return this.f16793a;
    }

    public void a(int i2) {
        this.f16793a = i2;
    }

    private boolean b(StringBuffer stringBuffer, int i2, char c2) {
        return i2 > 0 && i2 < stringBuffer.length() && stringBuffer.charAt(i2 - 1) == c2;
    }
}
