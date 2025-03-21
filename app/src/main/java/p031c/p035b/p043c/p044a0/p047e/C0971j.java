package p031c.p035b.p043c.p044a0.p047e;

import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.Arrays;
import p031c.p035b.p043c.C1071f;

/* compiled from: HighLevelEncoder.java */
/* renamed from: c.b.c.a0.e.j */
/* loaded from: classes.dex */
public final class C0971j {

    /* renamed from: a */
    private static final char f1698a = 129;

    /* renamed from: b */
    static final char f1699b = 230;

    /* renamed from: c */
    static final char f1700c = 231;

    /* renamed from: d */
    static final char f1701d = 235;

    /* renamed from: e */
    private static final char f1702e = 236;

    /* renamed from: f */
    private static final char f1703f = 237;

    /* renamed from: g */
    static final char f1704g = 238;

    /* renamed from: h */
    static final char f1705h = 239;

    /* renamed from: i */
    static final char f1706i = 240;

    /* renamed from: j */
    static final char f1707j = 254;

    /* renamed from: k */
    static final char f1708k = 254;

    /* renamed from: l */
    private static final String f1709l = "[)>\u001e05\u001d";

    /* renamed from: m */
    private static final String f1710m = "[)>\u001e06\u001d";

    /* renamed from: n */
    private static final String f1711n = "\u001e\u0004";

    /* renamed from: o */
    static final int f1712o = 0;

    /* renamed from: p */
    static final int f1713p = 1;

    /* renamed from: q */
    static final int f1714q = 2;

    /* renamed from: r */
    static final int f1715r = 3;

    /* renamed from: s */
    static final int f1716s = 4;

    /* renamed from: t */
    static final int f1717t = 5;

    private C0971j() {
    }

    /* renamed from: a */
    private static char m1290a(char c2, int i2) {
        int i3 = c2 + ((i2 * 149) % TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK) + 1;
        if (i3 > 254) {
            i3 -= TinkerReport.KEY_LOADED_EXCEPTION_RESOURCE;
        }
        return (char) i3;
    }

    /* renamed from: b */
    static boolean m1298b(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    /* renamed from: c */
    static boolean m1299c(char c2) {
        return c2 >= 128 && c2 <= 255;
    }

    /* renamed from: d */
    private static boolean m1300d(char c2) {
        return c2 == ' ' || (c2 >= '0' && c2 <= '9') || (c2 >= 'A' && c2 <= 'Z');
    }

    /* renamed from: e */
    private static boolean m1301e(char c2) {
        return c2 >= ' ' && c2 <= '^';
    }

    /* renamed from: f */
    private static boolean m1302f(char c2) {
        return c2 == ' ' || (c2 >= '0' && c2 <= '9') || (c2 >= 'a' && c2 <= 'z');
    }

    /* renamed from: g */
    private static boolean m1303g(char c2) {
        return m1305i(c2) || c2 == ' ' || (c2 >= '0' && c2 <= '9') || (c2 >= 'A' && c2 <= 'Z');
    }

    /* renamed from: h */
    private static boolean m1304h(char c2) {
        return false;
    }

    /* renamed from: i */
    private static boolean m1305i(char c2) {
        return c2 == '\r' || c2 == '*' || c2 == '>';
    }

    /* renamed from: a */
    public static String m1295a(String str) {
        return m1296a(str, EnumC0973l.FORCE_NONE, (C1071f) null, (C1071f) null);
    }

    /* renamed from: a */
    public static String m1296a(String str, EnumC0973l enumC0973l, C1071f c1071f, C1071f c1071f2) {
        int i2 = 0;
        InterfaceC0968g[] interfaceC0968gArr = {new C0962a(), new C0964c(), new C0974m(), new C0975n(), new C0967f(), new C0963b()};
        C0969h c0969h = new C0969h(str);
        c0969h.m1271a(enumC0973l);
        c0969h.m1272a(c1071f, c1071f2);
        if (str.startsWith(f1709l) && str.endsWith(f1711n)) {
            c0969h.m1269a(f1702e);
            c0969h.m1270a(2);
            c0969h.f1689f += 7;
        } else if (str.startsWith(f1710m) && str.endsWith(f1711n)) {
            c0969h.m1269a(f1703f);
            c0969h.m1270a(2);
            c0969h.f1689f += 7;
        }
        while (c0969h.m1283i()) {
            interfaceC0968gArr[i2].mo1242a(c0969h);
            if (c0969h.m1280f() >= 0) {
                i2 = c0969h.m1280f();
                c0969h.m1284j();
            }
        }
        int m1268a = c0969h.m1268a();
        c0969h.m1286l();
        int m1313b = c0969h.m1282h().m1313b();
        if (m1268a < m1313b && i2 != 0 && i2 != 5) {
            c0969h.m1269a((char) 254);
        }
        StringBuilder m1274b = c0969h.m1274b();
        if (m1274b.length() < m1313b) {
            m1274b.append(f1698a);
        }
        while (m1274b.length() < m1313b) {
            m1274b.append(m1290a(f1698a, m1274b.length() + 1));
        }
        return c0969h.m1274b().toString();
    }

    /* renamed from: a */
    static int m1292a(CharSequence charSequence, int i2, int i3) {
        float[] fArr;
        char c2;
        if (i2 >= charSequence.length()) {
            return i3;
        }
        if (i3 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i3] = 0.0f;
        }
        int i4 = 0;
        while (true) {
            int i5 = i2 + i4;
            if (i5 == charSequence.length()) {
                byte[] bArr = new byte[6];
                int[] iArr = new int[6];
                int m1294a = m1294a(fArr, iArr, Integer.MAX_VALUE, bArr);
                int m1293a = m1293a(bArr);
                if (iArr[0] == m1294a) {
                    return 0;
                }
                if (m1293a == 1 && bArr[5] > 0) {
                    return 5;
                }
                if (m1293a == 1 && bArr[4] > 0) {
                    return 4;
                }
                if (m1293a != 1 || bArr[2] <= 0) {
                    return (m1293a != 1 || bArr[3] <= 0) ? 1 : 3;
                }
                return 2;
            }
            char charAt = charSequence.charAt(i5);
            i4++;
            if (m1298b(charAt)) {
                fArr[0] = (float) (fArr[0] + 0.5d);
            } else if (m1299c(charAt)) {
                fArr[0] = (int) Math.ceil(fArr[0]);
                fArr[0] = fArr[0] + 2.0f;
            } else {
                fArr[0] = (int) Math.ceil(fArr[0]);
                fArr[0] = fArr[0] + 1.0f;
            }
            if (m1300d(charAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (m1299c(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (m1302f(charAt)) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (m1299c(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (m1303g(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (m1299c(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (m1301e(charAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (m1299c(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (m1304h(charAt)) {
                c2 = 5;
                fArr[5] = fArr[5] + 4.0f;
            } else {
                c2 = 5;
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i4 >= 4) {
                int[] iArr2 = new int[6];
                byte[] bArr2 = new byte[6];
                m1294a(fArr, iArr2, Integer.MAX_VALUE, bArr2);
                int m1293a2 = m1293a(bArr2);
                if (iArr2[0] < iArr2[c2] && iArr2[0] < iArr2[1] && iArr2[0] < iArr2[2] && iArr2[0] < iArr2[3] && iArr2[0] < iArr2[4]) {
                    return 0;
                }
                if (iArr2[5] < iArr2[0] || bArr2[1] + bArr2[2] + bArr2[3] + bArr2[4] == 0) {
                    return 5;
                }
                if (m1293a2 == 1 && bArr2[4] > 0) {
                    return 4;
                }
                if (m1293a2 == 1 && bArr2[2] > 0) {
                    return 2;
                }
                if (m1293a2 == 1 && bArr2[3] > 0) {
                    return 3;
                }
                if (iArr2[1] + 1 < iArr2[0] && iArr2[1] + 1 < iArr2[5] && iArr2[1] + 1 < iArr2[4] && iArr2[1] + 1 < iArr2[2]) {
                    if (iArr2[1] < iArr2[3]) {
                        return 1;
                    }
                    if (iArr2[1] == iArr2[3]) {
                        for (int i6 = i2 + i4 + 1; i6 < charSequence.length(); i6++) {
                            char charAt2 = charSequence.charAt(i6);
                            if (m1305i(charAt2)) {
                                return 3;
                            }
                            if (!m1303g(charAt2)) {
                                break;
                            }
                        }
                        return 1;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static int m1294a(float[] fArr, int[] iArr, int i2, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        int i3 = i2;
        for (int i4 = 0; i4 < 6; i4++) {
            iArr[i4] = (int) Math.ceil(fArr[i4]);
            int i5 = iArr[i4];
            if (i3 > i5) {
                Arrays.fill(bArr, (byte) 0);
                i3 = i5;
            }
            if (i3 == i5) {
                bArr[i4] = (byte) (bArr[i4] + 1);
            }
        }
        return i3;
    }

    /* renamed from: a */
    private static int m1293a(byte[] bArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 += bArr[i3];
        }
        return i2;
    }

    /* renamed from: a */
    public static int m1291a(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        if (i2 < length) {
            char charAt = charSequence.charAt(i2);
            while (m1298b(charAt) && i2 < length) {
                i3++;
                i2++;
                if (i2 < length) {
                    charAt = charSequence.charAt(i2);
                }
            }
        }
        return i3;
    }

    /* renamed from: a */
    static void m1297a(char c2) {
        String hexString = Integer.toHexString(c2);
        throw new IllegalArgumentException("Illegal character: " + c2 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }
}
