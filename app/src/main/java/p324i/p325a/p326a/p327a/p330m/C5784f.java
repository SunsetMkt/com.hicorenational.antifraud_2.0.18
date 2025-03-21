package p324i.p325a.p326a.p327a.p330m;

import androidx.exifinterface.media.ExifInterface;
import java.util.Locale;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p324i.p325a.p326a.p327a.C5762g;
import p324i.p325a.p326a.p327a.InterfaceC5764i;

/* compiled from: DoubleMetaphone.java */
/* renamed from: i.a.a.a.m.f */
/* loaded from: classes2.dex */
public class C5784f implements InterfaceC5764i {

    /* renamed from: b */
    private static final String f20834b = "AEIOUY";

    /* renamed from: c */
    private static final String[] f20835c = {"GN", "KN", "PN", "WR", "PS"};

    /* renamed from: d */
    private static final String[] f20836d = {"L", "R", "N", "M", "B", "H", "F", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, AbstractC1191a.f2568g};

    /* renamed from: e */
    private static final String[] f20837e = {"ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", "ER"};

    /* renamed from: f */
    private static final String[] f20838f = {"L", ExifInterface.GPS_DIRECTION_TRUE, "K", ExifInterface.LATITUDE_SOUTH, "N", "M", "B", "Z"};

    /* renamed from: a */
    private int f20839a = 4;

    /* renamed from: c */
    private int m24285c(String str, a aVar, int i2) {
        if (i2 > 0 && m24275a(str, i2, 4, "CHAE")) {
            aVar.m24314a('K', 'X');
        } else if (m24288c(str, i2)) {
            aVar.m24313a('K');
        } else {
            if (!m24292d(str, i2)) {
                if (i2 <= 0) {
                    aVar.m24313a('X');
                } else if (m24275a(str, 0, 2, "MC")) {
                    aVar.m24313a('K');
                } else {
                    aVar.m24314a('X', 'K');
                }
                return i2 + 2;
            }
            aVar.m24313a('K');
        }
        return i2 + 2;
    }

    /* renamed from: d */
    private int m24289d(String str, a aVar, int i2) {
        if (!m24275a(str, i2, 2, "DG")) {
            if (m24276a(str, i2, 2, "DT", "DD")) {
                aVar.m24313a('T');
                return 2 + i2;
            }
            aVar.m24313a('T');
            return i2 + 1;
        }
        int i3 = i2 + 2;
        if (m24277a(str, i3, 1, "I", ExifInterface.LONGITUDE_EAST, "Y")) {
            aVar.m24313a('J');
            return i2 + 3;
        }
        aVar.m24315a("TK");
        return i3;
    }

    /* renamed from: e */
    private int m24293e(String str, a aVar, int i2) {
        if (i2 > 0 && !m24274a(m24305a(str, i2 - 1))) {
            aVar.m24313a('K');
        } else {
            if (i2 == 0) {
                int i3 = i2 + 2;
                if (m24305a(str, i3) == 'I') {
                    aVar.m24313a('J');
                    return i3;
                }
                aVar.m24313a('K');
                return i3;
            }
            if ((i2 <= 1 || !m24277a(str, i2 - 2, 1, "B", "H", "D")) && ((i2 <= 2 || !m24277a(str, i2 - 3, 1, "B", "H", "D")) && (i2 <= 3 || !m24276a(str, i2 - 4, 1, "B", "H")))) {
                if (i2 > 2 && m24305a(str, i2 - 1) == 'U' && m24279a(str, i2 - 3, 1, "C", "G", "L", "R", ExifInterface.GPS_DIRECTION_TRUE)) {
                    aVar.m24313a('F');
                } else if (i2 > 0 && m24305a(str, i2 - 1) != 'I') {
                    aVar.m24313a('K');
                }
            }
        }
        return i2 + 2;
    }

    /* renamed from: f */
    private int m24297f(String str, a aVar, int i2) {
        if ((i2 != 0 && !m24274a(m24305a(str, i2 - 1))) || !m24274a(m24305a(str, i2 + 1))) {
            return i2 + 1;
        }
        aVar.m24313a('H');
        return i2 + 2;
    }

    /* renamed from: g */
    private int m24299g(String str, a aVar, int i2) {
        int i3 = i2 + 1;
        if (m24305a(str, i3) != 'L') {
            aVar.m24313a('L');
            return i3;
        }
        if (m24296e(str, i2)) {
            aVar.m24320c('L');
        } else {
            aVar.m24313a('L');
        }
        return i2 + 2;
    }

    /* renamed from: h */
    private int m24300h(String str, a aVar, int i2) {
        int i3 = i2 + 1;
        if (m24305a(str, i3) == 'H') {
            aVar.m24313a('F');
            return i2 + 2;
        }
        aVar.m24313a('P');
        if (m24276a(str, i3, 1, "P", "B")) {
            i3 = i2 + 2;
        }
        return i3;
    }

    /* renamed from: i */
    private int m24301i(String str, a aVar, int i2) {
        int i3 = i2 + 2;
        if (m24305a(str, i3) == 'H') {
            int i4 = i2 + 3;
            if (m24280a(str, i4, 2, "OO", "ER", "EN", "UY", "ED", "EM")) {
                if (m24276a(str, i4, 2, "ER", "EN")) {
                    aVar.m24316a("X", "SK");
                } else {
                    aVar.m24315a("SK");
                }
            } else if (i2 != 0 || m24274a(m24305a(str, 3)) || m24305a(str, 3) == 'W') {
                aVar.m24313a('X');
            } else {
                aVar.m24314a('X', 'S');
            }
        } else if (m24277a(str, i3, 1, "I", ExifInterface.LONGITUDE_EAST, "Y")) {
            aVar.m24313a('S');
        } else {
            aVar.m24315a("SK");
        }
        return i2 + 3;
    }

    /* renamed from: j */
    private int m24302j(String str, a aVar, int i2) {
        if (m24275a(str, i2, 4, "TION")) {
            aVar.m24313a('X');
        } else {
            if (!m24276a(str, i2, 3, "TIA", "TCH")) {
                if (!m24275a(str, i2, 2, "TH") && !m24275a(str, i2, 3, "TTH")) {
                    aVar.m24313a('T');
                    int i3 = i2 + 1;
                    return m24276a(str, i3, 1, ExifInterface.GPS_DIRECTION_TRUE, "D") ? i2 + 2 : i3;
                }
                int i4 = i2 + 2;
                if (m24276a(str, i4, 2, "OM", "AM") || m24276a(str, 0, 4, "VAN ", "VON ") || m24275a(str, 0, 3, "SCH")) {
                    aVar.m24313a('T');
                    return i4;
                }
                aVar.m24314a('0', 'T');
                return i4;
            }
            aVar.m24313a('X');
        }
        return i2 + 3;
    }

    /* renamed from: k */
    private int m24303k(String str, a aVar, int i2) {
        int i3 = 2;
        if (!m24275a(str, i2, 2, "WR")) {
            if (i2 == 0) {
                int i4 = i2 + 1;
                if (m24274a(m24305a(str, i4)) || m24275a(str, i2, 2, "WH")) {
                    if (m24274a(m24305a(str, i4))) {
                        aVar.m24314a('A', 'F');
                    } else {
                        aVar.m24313a('A');
                    }
                    return i4;
                }
            }
            if ((i2 == str.length() - 1 && m24274a(m24305a(str, i2 - 1))) || m24278a(str, i2 - 1, 5, "EWSKI", "EWSKY", "OWSKI", "OWSKY") || m24275a(str, 0, 3, "SCH")) {
                aVar.m24318b('F');
            } else {
                i3 = 4;
                if (m24276a(str, i2, 4, "WICZ", "WITZ")) {
                    aVar.m24316a("TS", "FX");
                }
            }
            return i2 + 1;
        }
        aVar.m24313a('R');
        return i2 + i3;
    }

    /* renamed from: l */
    private int m24304l(String str, a aVar, int i2) {
        if (i2 == 0) {
            aVar.m24313a('S');
            return i2 + 1;
        }
        if (i2 != str.length() - 1 || (!m24276a(str, i2 - 3, 3, "IAU", "EAU") && !m24276a(str, i2 - 2, 2, "AU", "OU"))) {
            aVar.m24315a("KS");
        }
        int i3 = i2 + 1;
        return m24276a(str, i3, 1, "C", "X") ? i2 + 2 : i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r7v0, types: [i.a.a.a.m.f] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.String] */
    /* renamed from: a */
    public String m24307a(String str, boolean z) {
        int i2;
        ?? m24287c = m24287c(str);
        if (m24287c == 0) {
            return null;
        }
        boolean m24295e = m24295e(m24287c);
        ?? m24291d = m24291d(m24287c);
        a aVar = new a(m24306a());
        while (!aVar.m24322c() && m24291d <= m24287c.length() - 1) {
            char charAt = m24287c.charAt(m24291d);
            if (charAt == 199) {
                aVar.m24313a('S');
            } else if (charAt != 209) {
                switch (charAt) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                    case 'Y':
                        m24291d = m24271a(aVar, m24291d);
                        break;
                    case 'B':
                        aVar.m24313a('P');
                        i2 = m24291d + 1;
                        if (m24305a(m24287c, i2) != 'B') {
                            m24291d = i2;
                            break;
                        } else {
                            m24291d += 2;
                            break;
                        }
                    case 'C':
                        m24291d = m24272a(m24287c, aVar, m24291d);
                        break;
                    case 'D':
                        m24291d = m24289d(m24287c, aVar, m24291d);
                        break;
                    case 'F':
                        aVar.m24313a('F');
                        i2 = m24291d + 1;
                        if (m24305a(m24287c, i2) != 'F') {
                            m24291d = i2;
                            break;
                        } else {
                            m24291d += 2;
                            break;
                        }
                    case 'G':
                        m24291d = m24273a(m24287c, aVar, m24291d, m24295e);
                        break;
                    case 'H':
                        m24291d = m24297f(m24287c, aVar, m24291d);
                        break;
                    case 'J':
                        m24291d = m24283b(m24287c, aVar, m24291d, m24295e);
                        break;
                    case 'K':
                        aVar.m24313a('K');
                        i2 = m24291d + 1;
                        if (m24305a(m24287c, i2) != 'K') {
                            m24291d = i2;
                            break;
                        } else {
                            m24291d += 2;
                            break;
                        }
                    case 'L':
                        m24291d = m24299g(m24287c, aVar, m24291d);
                        break;
                    case 'M':
                        aVar.m24313a('M');
                        if (!m24298f(m24287c, m24291d)) {
                            break;
                        } else {
                            m24291d += 2;
                            break;
                        }
                    case 'N':
                        aVar.m24313a('N');
                        i2 = m24291d + 1;
                        if (m24305a(m24287c, i2) != 'N') {
                            m24291d = i2;
                            break;
                        } else {
                            m24291d += 2;
                            break;
                        }
                    case 'P':
                        m24291d = m24300h(m24287c, aVar, m24291d);
                        break;
                    case 'Q':
                        aVar.m24313a('K');
                        i2 = m24291d + 1;
                        if (m24305a(m24287c, i2) != 'Q') {
                            m24291d = i2;
                            break;
                        } else {
                            m24291d += 2;
                            break;
                        }
                    case 'R':
                        m24291d = m24286c(m24287c, aVar, m24291d, m24295e);
                        break;
                    case 'S':
                        m24291d = m24290d(m24287c, aVar, m24291d, m24295e);
                        break;
                    case 'T':
                        m24291d = m24302j(m24287c, aVar, m24291d);
                        break;
                    case 'V':
                        aVar.m24313a('F');
                        i2 = m24291d + 1;
                        if (m24305a(m24287c, i2) != 'V') {
                            m24291d = i2;
                            break;
                        } else {
                            m24291d += 2;
                            break;
                        }
                    case 'W':
                        m24291d = m24303k(m24287c, aVar, m24291d);
                        break;
                    case 'X':
                        m24291d = m24304l(m24287c, aVar, m24291d);
                        break;
                    case 'Z':
                        m24291d = m24294e(m24287c, aVar, m24291d, m24295e);
                        break;
                }
            } else {
                aVar.m24313a('N');
            }
            m24291d++;
        }
        return z ? aVar.m24312a() : aVar.m24317b();
    }

    /* renamed from: b */
    public String m24311b(String str) {
        return m24307a(str, false);
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5761f
    public Object encode(Object obj) throws C5762g {
        if (obj instanceof String) {
            return m24311b((String) obj);
        }
        throw new C5762g("DoubleMetaphone encode parameter is not of type String");
    }

    /* compiled from: DoubleMetaphone.java */
    /* renamed from: i.a.a.a.m.f$a */
    public class a {

        /* renamed from: a */
        private final StringBuffer f20840a;

        /* renamed from: b */
        private final StringBuffer f20841b;

        /* renamed from: c */
        private final int f20842c;

        public a(int i2) {
            this.f20840a = new StringBuffer(C5784f.this.m24306a());
            this.f20841b = new StringBuffer(C5784f.this.m24306a());
            this.f20842c = i2;
        }

        /* renamed from: a */
        public void m24313a(char c2) {
            m24320c(c2);
            m24318b(c2);
        }

        /* renamed from: b */
        public void m24318b(char c2) {
            if (this.f20841b.length() < this.f20842c) {
                this.f20841b.append(c2);
            }
        }

        /* renamed from: c */
        public void m24320c(char c2) {
            if (this.f20840a.length() < this.f20842c) {
                this.f20840a.append(c2);
            }
        }

        /* renamed from: a */
        public void m24314a(char c2, char c3) {
            m24320c(c2);
            m24318b(c3);
        }

        /* renamed from: b */
        public void m24319b(String str) {
            int length = this.f20842c - this.f20841b.length();
            if (str.length() <= length) {
                this.f20841b.append(str);
            } else {
                this.f20841b.append(str.substring(0, length));
            }
        }

        /* renamed from: c */
        public void m24321c(String str) {
            int length = this.f20842c - this.f20840a.length();
            if (str.length() <= length) {
                this.f20840a.append(str);
            } else {
                this.f20840a.append(str.substring(0, length));
            }
        }

        /* renamed from: a */
        public void m24315a(String str) {
            m24321c(str);
            m24319b(str);
        }

        /* renamed from: a */
        public void m24316a(String str, String str2) {
            m24321c(str);
            m24319b(str2);
        }

        /* renamed from: b */
        public String m24317b() {
            return this.f20840a.toString();
        }

        /* renamed from: c */
        public boolean m24322c() {
            return this.f20840a.length() >= this.f20842c && this.f20841b.length() >= this.f20842c;
        }

        /* renamed from: a */
        public String m24312a() {
            return this.f20841b.toString();
        }
    }

    /* renamed from: b */
    private int m24282b(String str, a aVar, int i2) {
        int i3 = i2 + 2;
        if (!m24277a(str, i3, 1, "I", ExifInterface.LONGITUDE_EAST, "H") || m24275a(str, i3, 2, "HU")) {
            aVar.m24313a('K');
            return i3;
        }
        if ((i2 == 1 && m24305a(str, i2 - 1) == 'A') || m24276a(str, i2 - 1, 5, "UCCEE", "UCCES")) {
            aVar.m24315a("KS");
        } else {
            aVar.m24313a('X');
        }
        return i2 + 3;
    }

    /* renamed from: f */
    private boolean m24298f(String str, int i2) {
        int i3 = i2 + 1;
        if (m24305a(str, i3) == 'M') {
            return true;
        }
        return m24275a(str, i2 + (-1), 3, "UMB") && (i3 == str.length() - 1 || m24275a(str, i2 + 2, 2, "ER"));
    }

    /* renamed from: b */
    private int m24283b(String str, a aVar, int i2, boolean z) {
        if (!m24275a(str, i2, 4, "JOSE") && !m24275a(str, 0, 4, "SAN ")) {
            if (i2 == 0 && !m24275a(str, i2, 4, "JOSE")) {
                aVar.m24314a('J', 'A');
            } else {
                int i3 = i2 - 1;
                if (m24274a(m24305a(str, i3)) && !z) {
                    int i4 = i2 + 1;
                    if (m24305a(str, i4) == 'A' || m24305a(str, i4) == 'O') {
                        aVar.m24314a('J', 'H');
                    }
                }
                if (i2 == str.length() - 1) {
                    aVar.m24314a('J', ' ');
                } else if (!m24281a(str, i2 + 1, 1, f20838f) && !m24277a(str, i3, 1, ExifInterface.LATITUDE_SOUTH, "K", "L")) {
                    aVar.m24313a('J');
                }
            }
            int i5 = i2 + 1;
            return m24305a(str, i5) == 'J' ? i2 + 2 : i5;
        }
        if ((i2 != 0 || m24305a(str, i2 + 4) != ' ') && str.length() != 4 && !m24275a(str, 0, 4, "SAN ")) {
            aVar.m24314a('J', 'H');
        } else {
            aVar.m24313a('H');
        }
        return i2 + 1;
    }

    /* renamed from: d */
    private int m24290d(String str, a aVar, int i2, boolean z) {
        if (!m24276a(str, i2 - 1, 3, "ISL", "YSL")) {
            if (i2 == 0 && m24275a(str, i2, 5, "SUGAR")) {
                aVar.m24314a('X', 'S');
            } else {
                if (m24275a(str, i2, 2, "SH")) {
                    if (m24278a(str, i2 + 1, 4, "HEIM", "HOEK", "HOLM", "HOLZ")) {
                        aVar.m24313a('S');
                    } else {
                        aVar.m24313a('X');
                    }
                } else {
                    if (m24276a(str, i2, 3, "SIO", "SIA") || m24275a(str, i2, 4, "SIAN")) {
                        if (z) {
                            aVar.m24313a('S');
                        } else {
                            aVar.m24314a('S', 'X');
                        }
                        return i2 + 3;
                    }
                    if (i2 != 0 || !m24278a(str, i2 + 1, 1, "M", "N", "L", ExifInterface.LONGITUDE_WEST)) {
                        int i3 = i2 + 1;
                        if (!m24275a(str, i3, 1, "Z")) {
                            if (m24275a(str, i2, 2, "SC")) {
                                return m24301i(str, aVar, i2);
                            }
                            if (i2 == str.length() - 1 && m24276a(str, i2 - 2, 2, "AI", "OI")) {
                                aVar.m24318b('S');
                            } else {
                                aVar.m24313a('S');
                            }
                            if (!m24276a(str, i3, 1, ExifInterface.LATITUDE_SOUTH, "Z")) {
                                return i3;
                            }
                        }
                    }
                    aVar.m24314a('S', 'X');
                    int i4 = i2 + 1;
                    if (!m24275a(str, i4, 1, "Z")) {
                        return i4;
                    }
                }
                return i2 + 2;
            }
        }
        return i2 + 1;
    }

    /* renamed from: c */
    private int m24286c(String str, a aVar, int i2, boolean z) {
        if (i2 == str.length() - 1 && !z && m24275a(str, i2 - 2, 2, "IE") && !m24276a(str, i2 - 4, 2, "ME", "MA")) {
            aVar.m24318b('R');
        } else {
            aVar.m24313a('R');
        }
        int i3 = i2 + 1;
        return m24305a(str, i3) == 'R' ? i2 + 2 : i3;
    }

    /* renamed from: e */
    private int m24294e(String str, a aVar, int i2, boolean z) {
        int i3 = i2 + 1;
        if (m24305a(str, i3) == 'H') {
            aVar.m24313a('J');
            return i2 + 2;
        }
        if (!m24277a(str, i3, 2, "ZO", "ZI", "ZA") && (!z || i2 <= 0 || m24305a(str, i2 - 1) == 'T')) {
            aVar.m24313a('S');
        } else {
            aVar.m24316a(ExifInterface.LATITUDE_SOUTH, "TS");
        }
        if (m24305a(str, i3) == 'Z') {
            i3 = i2 + 2;
        }
        return i3;
    }

    /* renamed from: c */
    private boolean m24288c(String str, int i2) {
        if (i2 != 0) {
            return false;
        }
        int i3 = i2 + 1;
        return (m24276a(str, i3, 5, "HARAC", "HARIS") || m24278a(str, i3, 3, "HOR", "HYM", "HIA", "HEM")) && !m24275a(str, 0, 5, "CHORE");
    }

    /* renamed from: c */
    private String m24287c(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        return trim.toUpperCase(Locale.ENGLISH);
    }

    /* renamed from: e */
    private boolean m24296e(String str, int i2) {
        if (i2 == str.length() - 3 && m24277a(str, i2 - 1, 4, "ILLO", "ILLA", "ALLE")) {
            return true;
        }
        return (m24276a(str, str.length() - 2, 2, "AS", "OS") || m24276a(str, str.length() - 1, 1, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "O")) && m24275a(str, i2 - 1, 4, "ALLE");
    }

    /* renamed from: e */
    private boolean m24295e(String str) {
        return str.indexOf(87) > -1 || str.indexOf(75) > -1 || str.indexOf("CZ") > -1 || str.indexOf("WITZ") > -1;
    }

    /* renamed from: b */
    private boolean m24284b(String str, int i2) {
        if (m24275a(str, i2, 4, "CHIA")) {
            return true;
        }
        if (i2 <= 1) {
            return false;
        }
        int i3 = i2 - 2;
        if (m24274a(m24305a(str, i3)) || !m24275a(str, i2 - 1, 3, "ACH")) {
            return false;
        }
        char m24305a = m24305a(str, i2 + 2);
        return !(m24305a == 'I' || m24305a == 'E') || m24276a(str, i3, 6, "BACHER", "MACHER");
    }

    /* renamed from: d */
    private boolean m24292d(String str, int i2) {
        if (!m24276a(str, 0, 4, "VAN ", "VON ") && !m24275a(str, 0, 3, "SCH") && !m24277a(str, i2 - 2, 6, "ORCHES", "ARCHIT", "ORCHID")) {
            int i3 = i2 + 2;
            if (!m24276a(str, i3, 1, ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH)) {
                if (!m24278a(str, i2 - 1, 1, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "O", "U", ExifInterface.LONGITUDE_EAST) && i2 != 0) {
                    return false;
                }
                if (!m24281a(str, i3, 1, f20836d) && i2 + 1 != str.length() - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: d */
    private boolean m24291d(String str) {
        for (String str2 : f20835c) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5764i
    /* renamed from: a */
    public String mo24152a(String str) {
        return m24311b(str);
    }

    /* renamed from: a */
    public boolean m24309a(String str, String str2) {
        return m24310a(str, str2, false);
    }

    /* renamed from: a */
    public boolean m24310a(String str, String str2, boolean z) {
        return m24307a(str, z).equals(m24307a(str2, z));
    }

    /* renamed from: a */
    public int m24306a() {
        return this.f20839a;
    }

    /* renamed from: a */
    public void m24308a(int i2) {
        this.f20839a = i2;
    }

    /* renamed from: a */
    private int m24271a(a aVar, int i2) {
        if (i2 == 0) {
            aVar.m24313a('A');
        }
        return i2 + 1;
    }

    /* renamed from: a */
    private int m24272a(String str, a aVar, int i2) {
        if (m24284b(str, i2)) {
            aVar.m24313a('K');
        } else if (i2 == 0 && m24275a(str, i2, 6, "CAESAR")) {
            aVar.m24313a('S');
        } else {
            if (m24275a(str, i2, 2, "CH")) {
                return m24285c(str, aVar, i2);
            }
            if (m24275a(str, i2, 2, "CZ") && !m24275a(str, i2 - 2, 4, "WICZ")) {
                aVar.m24314a('S', 'X');
            } else {
                int i3 = i2 + 1;
                if (m24275a(str, i3, 3, "CIA")) {
                    aVar.m24313a('X');
                } else {
                    if (m24275a(str, i2, 2, "CC") && (i2 != 1 || m24305a(str, 0) != 'M')) {
                        return m24282b(str, aVar, i2);
                    }
                    if (m24277a(str, i2, 2, "CK", "CG", "CQ")) {
                        aVar.m24313a('K');
                    } else if (m24277a(str, i2, 2, "CI", "CE", "CY")) {
                        if (m24277a(str, i2, 3, "CIO", "CIE", "CIA")) {
                            aVar.m24314a('S', 'X');
                        } else {
                            aVar.m24313a('S');
                        }
                    } else {
                        aVar.m24313a('K');
                        if (!m24277a(str, i3, 2, " C", " Q", " G")) {
                            if (!m24277a(str, i3, 1, "C", "K", "Q") || m24276a(str, i3, 2, "CE", "CI")) {
                                return i3;
                            }
                        }
                    }
                }
                return i2 + 3;
            }
        }
        return i2 + 2;
    }

    /* renamed from: a */
    private int m24273a(String str, a aVar, int i2, boolean z) {
        int i3;
        int i4 = i2 + 1;
        if (m24305a(str, i4) == 'H') {
            return m24293e(str, aVar, i2);
        }
        if (m24305a(str, i4) == 'N') {
            if (i2 == 1 && m24274a(m24305a(str, 0)) && !z) {
                aVar.m24316a("KN", "N");
            } else if (!m24275a(str, i2 + 2, 2, "EY") && m24305a(str, i4) != 'Y' && !z) {
                aVar.m24316a("N", "KN");
            } else {
                aVar.m24315a("KN");
            }
        } else if (m24275a(str, i4, 2, "LI") && !z) {
            aVar.m24316a("KL", "L");
        } else if (i2 == 0 && (m24305a(str, i4) == 'Y' || m24281a(str, i4, 2, f20837e))) {
            aVar.m24314a('K', 'J');
        } else {
            if (m24275a(str, i4, 2, "ER") || m24305a(str, i4) == 'Y') {
                i3 = 3;
                if (!m24277a(str, 0, 6, "DANGER", "RANGER", "MANGER")) {
                    int i5 = i2 - 1;
                    if (!m24276a(str, i5, 1, ExifInterface.LONGITUDE_EAST, "I") && !m24276a(str, i5, 3, "RGY", "OGY")) {
                        aVar.m24314a('K', 'J');
                    }
                }
            } else {
                i3 = 3;
            }
            if (!m24277a(str, i4, 1, ExifInterface.LONGITUDE_EAST, "I", "Y") && !m24276a(str, i2 - 1, 4, "AGGI", "OGGI")) {
                if (m24305a(str, i4) == 'G') {
                    int i6 = i2 + 2;
                    aVar.m24313a('K');
                    return i6;
                }
                aVar.m24313a('K');
                return i4;
            }
            if (!m24276a(str, 0, 4, "VAN ", "VON ") && !m24275a(str, 0, i3, "SCH") && !m24275a(str, i4, 2, "ET")) {
                if (m24275a(str, i4, i3, "IER")) {
                    aVar.m24313a('J');
                } else {
                    aVar.m24314a('J', 'K');
                }
            } else {
                aVar.m24313a('K');
            }
        }
        return i2 + 2;
    }

    /* renamed from: a */
    private boolean m24274a(char c2) {
        return f20834b.indexOf(c2) != -1;
    }

    /* renamed from: a */
    protected char m24305a(String str, int i2) {
        if (i2 < 0 || i2 >= str.length()) {
            return (char) 0;
        }
        return str.charAt(i2);
    }

    /* renamed from: a */
    private static boolean m24275a(String str, int i2, int i3, String str2) {
        return m24281a(str, i2, i3, new String[]{str2});
    }

    /* renamed from: a */
    private static boolean m24276a(String str, int i2, int i3, String str2, String str3) {
        return m24281a(str, i2, i3, new String[]{str2, str3});
    }

    /* renamed from: a */
    private static boolean m24277a(String str, int i2, int i3, String str2, String str3, String str4) {
        return m24281a(str, i2, i3, new String[]{str2, str3, str4});
    }

    /* renamed from: a */
    private static boolean m24278a(String str, int i2, int i3, String str2, String str3, String str4, String str5) {
        return m24281a(str, i2, i3, new String[]{str2, str3, str4, str5});
    }

    /* renamed from: a */
    private static boolean m24279a(String str, int i2, int i3, String str2, String str3, String str4, String str5, String str6) {
        return m24281a(str, i2, i3, new String[]{str2, str3, str4, str5, str6});
    }

    /* renamed from: a */
    private static boolean m24280a(String str, int i2, int i3, String str2, String str3, String str4, String str5, String str6, String str7) {
        return m24281a(str, i2, i3, new String[]{str2, str3, str4, str5, str6, str7});
    }

    /* renamed from: a */
    protected static boolean m24281a(String str, int i2, int i3, String[] strArr) {
        int i4;
        if (i2 < 0 || (i4 = i3 + i2) > str.length()) {
            return false;
        }
        String substring = str.substring(i2, i4);
        for (String str2 : strArr) {
            if (substring.equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
