package p031c.p035b.p043c.p044a0.p045c;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.p072z.C1164c;
import p031c.p035b.p043c.p072z.C1166e;
import p286h.p323z2.C5736h0;

/* compiled from: DecodedBitStreamParser.java */
/* renamed from: c.b.c.a0.c.c */
/* loaded from: classes.dex */
final class C0958c {

    /* renamed from: a */
    private static final char[] f1655a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: b */
    private static final char[] f1656b = {'!', C5736h0.f20712a, '#', C5736h0.f20713b, '%', C5736h0.f20714c, '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', C5736h0.f20715d, '=', C5736h0.f20716e, '?', '@', '[', '\\', ']', '^', '_'};

    /* renamed from: c */
    private static final char[] f1657c = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /* renamed from: d */
    private static final char[] f1658d = f1656b;

    /* renamed from: e */
    private static final char[] f1659e = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    /* compiled from: DecodedBitStreamParser.java */
    /* renamed from: c.b.c.a0.c.c$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f1660a = new int[b.values().length];

        static {
            try {
                f1660a[b.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1660a[b.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1660a[b.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1660a[b.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1660a[b.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: DecodedBitStreamParser.java */
    /* renamed from: c.b.c.a0.c.c$b */
    private enum b {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    private C0958c() {
    }

    /* renamed from: a */
    static C1166e m1206a(byte[] bArr) throws C1097h {
        C1164c c1164c = new C1164c(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        b bVar = b.ASCII_ENCODE;
        do {
            if (bVar == b.ASCII_ENCODE) {
                bVar = m1205a(c1164c, sb, sb2);
            } else {
                int i2 = a.f1660a[bVar.ordinal()];
                if (i2 == 1) {
                    m1210b(c1164c, sb);
                } else if (i2 == 2) {
                    m1212d(c1164c, sb);
                } else if (i2 == 3) {
                    m1208a(c1164c, sb);
                } else if (i2 == 4) {
                    m1211c(c1164c, sb);
                } else {
                    if (i2 != 5) {
                        throw C1097h.getFormatInstance();
                    }
                    m1209a(c1164c, sb, arrayList);
                }
                bVar = b.ASCII_ENCODE;
            }
            if (bVar == b.PAD_ENCODE) {
                break;
            }
        } while (c1164c.m2183a() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String sb3 = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new C1166e(bArr, sb3, arrayList, null);
    }

    /* renamed from: b */
    private static void m1210b(C1164c c1164c, StringBuilder sb) throws C1097h {
        int m2184a;
        int[] iArr = new int[3];
        boolean z = false;
        int i2 = 0;
        while (c1164c.m2183a() != 8 && (m2184a = c1164c.m2184a(8)) != 254) {
            m1207a(m2184a, c1164c.m2184a(8), iArr);
            boolean z2 = z;
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            char[] cArr = f1656b;
                            if (i4 < cArr.length) {
                                char c2 = cArr[i4];
                                if (z2) {
                                    sb.append((char) (c2 + 128));
                                    z2 = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i4 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i4 != 30) {
                                    throw C1097h.getFormatInstance();
                                }
                                z2 = true;
                            }
                            i2 = 0;
                        } else {
                            if (i2 != 3) {
                                throw C1097h.getFormatInstance();
                            }
                            if (z2) {
                                sb.append((char) (i4 + 224));
                                z2 = false;
                                i2 = 0;
                            } else {
                                sb.append((char) (i4 + 96));
                                i2 = 0;
                            }
                        }
                    } else if (z2) {
                        sb.append((char) (i4 + 128));
                        z2 = false;
                        i2 = 0;
                    } else {
                        sb.append((char) i4);
                        i2 = 0;
                    }
                } else if (i4 < 3) {
                    i2 = i4 + 1;
                } else {
                    char[] cArr2 = f1655a;
                    if (i4 >= cArr2.length) {
                        throw C1097h.getFormatInstance();
                    }
                    char c3 = cArr2[i4];
                    if (z2) {
                        sb.append((char) (c3 + 128));
                        z2 = false;
                    } else {
                        sb.append(c3);
                    }
                }
            }
            if (c1164c.m2183a() <= 0) {
                return;
            } else {
                z = z2;
            }
        }
    }

    /* renamed from: c */
    private static void m1211c(C1164c c1164c, StringBuilder sb) {
        while (c1164c.m2183a() > 16) {
            for (int i2 = 0; i2 < 4; i2++) {
                int m2184a = c1164c.m2184a(6);
                if (m2184a == 31) {
                    int m2185b = 8 - c1164c.m2185b();
                    if (m2185b != 8) {
                        c1164c.m2184a(m2185b);
                        return;
                    }
                    return;
                }
                if ((m2184a & 32) == 0) {
                    m2184a |= 64;
                }
                sb.append((char) m2184a);
            }
            if (c1164c.m2183a() <= 0) {
                return;
            }
        }
    }

    /* renamed from: d */
    private static void m1212d(C1164c c1164c, StringBuilder sb) throws C1097h {
        int m2184a;
        int[] iArr = new int[3];
        boolean z = false;
        int i2 = 0;
        while (c1164c.m2183a() != 8 && (m2184a = c1164c.m2184a(8)) != 254) {
            m1207a(m2184a, c1164c.m2184a(8), iArr);
            boolean z2 = z;
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            char[] cArr = f1658d;
                            if (i4 < cArr.length) {
                                char c2 = cArr[i4];
                                if (z2) {
                                    sb.append((char) (c2 + 128));
                                    z2 = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i4 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i4 != 30) {
                                    throw C1097h.getFormatInstance();
                                }
                                z2 = true;
                            }
                            i2 = 0;
                        } else {
                            if (i2 != 3) {
                                throw C1097h.getFormatInstance();
                            }
                            char[] cArr2 = f1659e;
                            if (i4 >= cArr2.length) {
                                throw C1097h.getFormatInstance();
                            }
                            char c3 = cArr2[i4];
                            if (z2) {
                                sb.append((char) (c3 + 128));
                                z2 = false;
                                i2 = 0;
                            } else {
                                sb.append(c3);
                                i2 = 0;
                            }
                        }
                    } else if (z2) {
                        sb.append((char) (i4 + 128));
                        z2 = false;
                        i2 = 0;
                    } else {
                        sb.append((char) i4);
                        i2 = 0;
                    }
                } else if (i4 < 3) {
                    i2 = i4 + 1;
                } else {
                    char[] cArr3 = f1657c;
                    if (i4 >= cArr3.length) {
                        throw C1097h.getFormatInstance();
                    }
                    char c4 = cArr3[i4];
                    if (z2) {
                        sb.append((char) (c4 + 128));
                        z2 = false;
                    } else {
                        sb.append(c4);
                    }
                }
            }
            if (c1164c.m2183a() <= 0) {
                return;
            } else {
                z = z2;
            }
        }
    }

    /* renamed from: a */
    private static b m1205a(C1164c c1164c, StringBuilder sb, StringBuilder sb2) throws C1097h {
        boolean z = false;
        do {
            int m2184a = c1164c.m2184a(8);
            if (m2184a == 0) {
                throw C1097h.getFormatInstance();
            }
            if (m2184a <= 128) {
                if (z) {
                    m2184a += 128;
                }
                sb.append((char) (m2184a - 1));
                return b.ASCII_ENCODE;
            }
            if (m2184a == 129) {
                return b.PAD_ENCODE;
            }
            if (m2184a <= 229) {
                int i2 = m2184a - 130;
                if (i2 < 10) {
                    sb.append('0');
                }
                sb.append(i2);
            } else {
                if (m2184a == 230) {
                    return b.C40_ENCODE;
                }
                if (m2184a == 231) {
                    return b.BASE256_ENCODE;
                }
                if (m2184a == 232) {
                    sb.append((char) 29);
                } else if (m2184a != 233 && m2184a != 234) {
                    if (m2184a == 235) {
                        z = true;
                    } else if (m2184a == 236) {
                        sb.append("[)>\u001e05\u001d");
                        sb2.insert(0, "\u001e\u0004");
                    } else if (m2184a == 237) {
                        sb.append("[)>\u001e06\u001d");
                        sb2.insert(0, "\u001e\u0004");
                    } else {
                        if (m2184a == 238) {
                            return b.ANSIX12_ENCODE;
                        }
                        if (m2184a == 239) {
                            return b.TEXT_ENCODE;
                        }
                        if (m2184a == 240) {
                            return b.EDIFACT_ENCODE;
                        }
                        if (m2184a != 241 && m2184a >= 242 && (m2184a != 254 || c1164c.m2183a() != 0)) {
                            throw C1097h.getFormatInstance();
                        }
                    }
                }
            }
        } while (c1164c.m2183a() > 0);
        return b.ASCII_ENCODE;
    }

    /* renamed from: a */
    private static void m1208a(C1164c c1164c, StringBuilder sb) throws C1097h {
        int m2184a;
        int[] iArr = new int[3];
        while (c1164c.m2183a() != 8 && (m2184a = c1164c.m2184a(8)) != 254) {
            m1207a(m2184a, c1164c.m2184a(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i3 == 0) {
                    sb.append('\r');
                } else if (i3 == 1) {
                    sb.append('*');
                } else if (i3 == 2) {
                    sb.append(C5736h0.f20716e);
                } else if (i3 == 3) {
                    sb.append(' ');
                } else if (i3 < 14) {
                    sb.append((char) (i3 + 44));
                } else if (i3 < 40) {
                    sb.append((char) (i3 + 51));
                } else {
                    throw C1097h.getFormatInstance();
                }
            }
            if (c1164c.m2183a() <= 0) {
                return;
            }
        }
    }

    /* renamed from: a */
    private static void m1207a(int i2, int i3, int[] iArr) {
        int i4 = ((i2 << 8) + i3) - 1;
        int i5 = i4 / 1600;
        iArr[0] = i5;
        int i6 = i4 - (i5 * 1600);
        int i7 = i6 / 40;
        iArr[1] = i7;
        iArr[2] = i6 - (i7 * 40);
    }

    /* renamed from: a */
    private static void m1209a(C1164c c1164c, StringBuilder sb, Collection<byte[]> collection) throws C1097h {
        int m2186c = c1164c.m2186c() + 1;
        int i2 = m2186c + 1;
        int m1204a = m1204a(c1164c.m2184a(8), m2186c);
        if (m1204a == 0) {
            m1204a = c1164c.m2183a() / 8;
        } else if (m1204a >= 250) {
            m1204a = ((m1204a - 249) * 250) + m1204a(c1164c.m2184a(8), i2);
            i2++;
        }
        if (m1204a >= 0) {
            byte[] bArr = new byte[m1204a];
            int i3 = 0;
            while (i3 < m1204a) {
                if (c1164c.m2183a() >= 8) {
                    bArr[i3] = (byte) m1204a(c1164c.m2184a(8), i2);
                    i3++;
                    i2++;
                } else {
                    throw C1097h.getFormatInstance();
                }
            }
            collection.add(bArr);
            try {
                sb.append(new String(bArr, "ISO8859_1"));
                return;
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalStateException("Platform does not support required encoding: " + e2);
            }
        }
        throw C1097h.getFormatInstance();
    }

    /* renamed from: a */
    private static int m1204a(int i2, int i3) {
        int i4 = i2 - (((i3 * 149) % 255) + 1);
        return i4 >= 0 ? i4 : i4 + 256;
    }
}
