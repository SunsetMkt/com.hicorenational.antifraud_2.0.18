package p324i.p325a.p326a.p327a.p330m;

import java.util.Locale;
import p324i.p325a.p326a.p327a.C5762g;
import p324i.p325a.p326a.p327a.InterfaceC5764i;

/* compiled from: Metaphone.java */
/* renamed from: i.a.a.a.m.g */
/* loaded from: classes2.dex */
public class C5785g implements InterfaceC5764i {

    /* renamed from: b */
    private static final String f20844b = "AEIOU";

    /* renamed from: c */
    private static final String f20845c = "EIY";

    /* renamed from: d */
    private static final String f20846d = "CSPTG";

    /* renamed from: a */
    private int f20847a = 4;

    /* renamed from: a */
    private boolean m24323a(int i2, int i3) {
        return i3 + 1 == i2;
    }

    /* renamed from: a */
    private boolean m24324a(StringBuffer stringBuffer, int i2) {
        return f20844b.indexOf(stringBuffer.charAt(i2)) >= 0;
    }

    /* renamed from: b */
    public String m24331b(String str) {
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
        while (stringBuffer2.length() < m24328a() && i2 < length) {
            char charAt = stringBuffer.charAt(i2);
            if (charAt == 'C' || !m24327b(stringBuffer, i2, charAt)) {
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
                        if (!m24327b(stringBuffer, i2, 'M') || !m24323a(length, i2)) {
                            stringBuffer2.append(charAt);
                            break;
                        }
                        break;
                    case 'C':
                        if (!m24327b(stringBuffer, i2, 'S') || m24323a(length, i2) || f20845c.indexOf(stringBuffer.charAt(i2 + 1)) < 0) {
                            if (!m24326a(stringBuffer, i2, "CIA")) {
                                if (!m24323a(length, i2) && f20845c.indexOf(stringBuffer.charAt(i2 + 1)) >= 0) {
                                    stringBuffer2.append('S');
                                    break;
                                } else if (!m24327b(stringBuffer, i2, 'S') || !m24325a(stringBuffer, i2, 'H')) {
                                    if (!m24325a(stringBuffer, i2, 'H')) {
                                        stringBuffer2.append('K');
                                        break;
                                    } else if (i2 != 0 || length < 3 || !m24324a(stringBuffer, 2)) {
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
                        if (!m24323a(length, i2 + 1) && m24325a(stringBuffer, i2, 'G')) {
                            int i3 = i2 + 2;
                            if (f20845c.indexOf(stringBuffer.charAt(i3)) >= 0) {
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
                        if ((!m24323a(length, i4) || !m24325a(stringBuffer, i2, 'H')) && ((m24323a(length, i4) || !m24325a(stringBuffer, i2, 'H') || m24324a(stringBuffer, i2 + 2)) && (i2 <= 0 || (!m24326a(stringBuffer, i2, "GN") && !m24326a(stringBuffer, i2, "GNED"))))) {
                            boolean m24327b = m24327b(stringBuffer, i2, 'G');
                            if (!m24323a(length, i2) && f20845c.indexOf(stringBuffer.charAt(i4)) >= 0 && !m24327b) {
                                stringBuffer2.append('J');
                                break;
                            } else {
                                stringBuffer2.append('K');
                                break;
                            }
                        }
                        break;
                    case 'H':
                        if (!m24323a(length, i2) && ((i2 <= 0 || f20846d.indexOf(stringBuffer.charAt(i2 - 1)) < 0) && m24324a(stringBuffer, i2 + 1))) {
                            stringBuffer2.append('H');
                            break;
                        }
                        break;
                    case 'K':
                        if (i2 <= 0) {
                            stringBuffer2.append(charAt);
                            break;
                        } else if (!m24327b(stringBuffer, i2, 'C')) {
                            stringBuffer2.append(charAt);
                            break;
                        }
                        break;
                    case 'P':
                        if (!m24325a(stringBuffer, i2, 'H')) {
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
                        if (!m24326a(stringBuffer, i2, "SH") && !m24326a(stringBuffer, i2, "SIO") && !m24326a(stringBuffer, i2, "SIA")) {
                            stringBuffer2.append('S');
                            break;
                        } else {
                            stringBuffer2.append('X');
                            break;
                        }
                        break;
                    case 'T':
                        if (!m24326a(stringBuffer, i2, "TIA") && !m24326a(stringBuffer, i2, "TIO")) {
                            if (!m24326a(stringBuffer, i2, "TCH")) {
                                if (!m24326a(stringBuffer, i2, "TH")) {
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
                        if (!m24323a(length, i2) && m24324a(stringBuffer, i2 + 1)) {
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
            if (stringBuffer2.length() > m24328a()) {
                stringBuffer2.setLength(m24328a());
            }
        }
        return stringBuffer2.toString();
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5761f
    public Object encode(Object obj) throws C5762g {
        if (obj instanceof String) {
            return m24331b((String) obj);
        }
        throw new C5762g("Parameter supplied to Metaphone encode is not of type java.lang.String");
    }

    /* renamed from: a */
    private boolean m24325a(StringBuffer stringBuffer, int i2, char c2) {
        return i2 >= 0 && i2 < stringBuffer.length() - 1 && stringBuffer.charAt(i2 + 1) == c2;
    }

    /* renamed from: a */
    private boolean m24326a(StringBuffer stringBuffer, int i2, String str) {
        if (i2 < 0 || (str.length() + i2) - 1 >= stringBuffer.length()) {
            return false;
        }
        return stringBuffer.substring(i2, str.length() + i2).equals(str);
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5764i
    /* renamed from: a */
    public String mo24152a(String str) {
        return m24331b(str);
    }

    /* renamed from: a */
    public boolean m24330a(String str, String str2) {
        return m24331b(str).equals(m24331b(str2));
    }

    /* renamed from: a */
    public int m24328a() {
        return this.f20847a;
    }

    /* renamed from: a */
    public void m24329a(int i2) {
        this.f20847a = i2;
    }

    /* renamed from: b */
    private boolean m24327b(StringBuffer stringBuffer, int i2, char c2) {
        return i2 > 0 && i2 < stringBuffer.length() && stringBuffer.charAt(i2 - 1) == c2;
    }
}
