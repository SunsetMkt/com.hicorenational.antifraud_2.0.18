package i.a.a.a.m;

import androidx.exifinterface.media.ExifInterface;
import java.util.Locale;

/* compiled from: DoubleMetaphone.java */
/* loaded from: classes2.dex */
public class f implements i.a.a.a.i {

    /* renamed from: b, reason: collision with root package name */
    private static final String f16780b = "AEIOUY";

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f16781c = {"GN", "KN", "PN", "WR", "PS"};

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f16782d = {"L", "R", "N", "M", "B", "H", "F", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, c.c.a.b.a.a.f3100g};

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f16783e = {"ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", "ER"};

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f16784f = {"L", ExifInterface.GPS_DIRECTION_TRUE, "K", ExifInterface.LATITUDE_SOUTH, "N", "M", "B", "Z"};

    /* renamed from: a, reason: collision with root package name */
    private int f16785a = 4;

    private int c(String str, a aVar, int i2) {
        if (i2 > 0 && a(str, i2, 4, "CHAE")) {
            aVar.a('K', 'X');
        } else if (c(str, i2)) {
            aVar.a('K');
        } else {
            if (!d(str, i2)) {
                if (i2 <= 0) {
                    aVar.a('X');
                } else if (a(str, 0, 2, "MC")) {
                    aVar.a('K');
                } else {
                    aVar.a('X', 'K');
                }
                return i2 + 2;
            }
            aVar.a('K');
        }
        return i2 + 2;
    }

    private int d(String str, a aVar, int i2) {
        if (!a(str, i2, 2, "DG")) {
            if (a(str, i2, 2, "DT", "DD")) {
                aVar.a('T');
                return 2 + i2;
            }
            aVar.a('T');
            return i2 + 1;
        }
        int i3 = i2 + 2;
        if (a(str, i3, 1, "I", ExifInterface.LONGITUDE_EAST, "Y")) {
            aVar.a('J');
            return i2 + 3;
        }
        aVar.a("TK");
        return i3;
    }

    private int e(String str, a aVar, int i2) {
        if (i2 > 0 && !a(a(str, i2 - 1))) {
            aVar.a('K');
        } else {
            if (i2 == 0) {
                int i3 = i2 + 2;
                if (a(str, i3) == 'I') {
                    aVar.a('J');
                    return i3;
                }
                aVar.a('K');
                return i3;
            }
            if ((i2 <= 1 || !a(str, i2 - 2, 1, "B", "H", "D")) && ((i2 <= 2 || !a(str, i2 - 3, 1, "B", "H", "D")) && (i2 <= 3 || !a(str, i2 - 4, 1, "B", "H")))) {
                if (i2 > 2 && a(str, i2 - 1) == 'U' && a(str, i2 - 3, 1, "C", "G", "L", "R", ExifInterface.GPS_DIRECTION_TRUE)) {
                    aVar.a('F');
                } else if (i2 > 0 && a(str, i2 - 1) != 'I') {
                    aVar.a('K');
                }
            }
        }
        return i2 + 2;
    }

    private int f(String str, a aVar, int i2) {
        if ((i2 != 0 && !a(a(str, i2 - 1))) || !a(a(str, i2 + 1))) {
            return i2 + 1;
        }
        aVar.a('H');
        return i2 + 2;
    }

    private int g(String str, a aVar, int i2) {
        int i3 = i2 + 1;
        if (a(str, i3) != 'L') {
            aVar.a('L');
            return i3;
        }
        if (e(str, i2)) {
            aVar.c('L');
        } else {
            aVar.a('L');
        }
        return i2 + 2;
    }

    private int h(String str, a aVar, int i2) {
        int i3 = i2 + 1;
        if (a(str, i3) == 'H') {
            aVar.a('F');
            return i2 + 2;
        }
        aVar.a('P');
        if (a(str, i3, 1, "P", "B")) {
            i3 = i2 + 2;
        }
        return i3;
    }

    private int i(String str, a aVar, int i2) {
        int i3 = i2 + 2;
        if (a(str, i3) == 'H') {
            int i4 = i2 + 3;
            if (a(str, i4, 2, "OO", "ER", "EN", "UY", "ED", "EM")) {
                if (a(str, i4, 2, "ER", "EN")) {
                    aVar.a("X", "SK");
                } else {
                    aVar.a("SK");
                }
            } else if (i2 != 0 || a(a(str, 3)) || a(str, 3) == 'W') {
                aVar.a('X');
            } else {
                aVar.a('X', 'S');
            }
        } else if (a(str, i3, 1, "I", ExifInterface.LONGITUDE_EAST, "Y")) {
            aVar.a('S');
        } else {
            aVar.a("SK");
        }
        return i2 + 3;
    }

    private int j(String str, a aVar, int i2) {
        if (a(str, i2, 4, "TION")) {
            aVar.a('X');
        } else {
            if (!a(str, i2, 3, "TIA", "TCH")) {
                if (!a(str, i2, 2, "TH") && !a(str, i2, 3, "TTH")) {
                    aVar.a('T');
                    int i3 = i2 + 1;
                    return a(str, i3, 1, ExifInterface.GPS_DIRECTION_TRUE, "D") ? i2 + 2 : i3;
                }
                int i4 = i2 + 2;
                if (a(str, i4, 2, "OM", "AM") || a(str, 0, 4, "VAN ", "VON ") || a(str, 0, 3, "SCH")) {
                    aVar.a('T');
                    return i4;
                }
                aVar.a('0', 'T');
                return i4;
            }
            aVar.a('X');
        }
        return i2 + 3;
    }

    private int k(String str, a aVar, int i2) {
        int i3 = 2;
        if (!a(str, i2, 2, "WR")) {
            if (i2 == 0) {
                int i4 = i2 + 1;
                if (a(a(str, i4)) || a(str, i2, 2, "WH")) {
                    if (a(a(str, i4))) {
                        aVar.a('A', 'F');
                    } else {
                        aVar.a('A');
                    }
                    return i4;
                }
            }
            if ((i2 == str.length() - 1 && a(a(str, i2 - 1))) || a(str, i2 - 1, 5, "EWSKI", "EWSKY", "OWSKI", "OWSKY") || a(str, 0, 3, "SCH")) {
                aVar.b('F');
            } else {
                i3 = 4;
                if (a(str, i2, 4, "WICZ", "WITZ")) {
                    aVar.a("TS", "FX");
                }
            }
            return i2 + 1;
        }
        aVar.a('R');
        return i2 + i3;
    }

    private int l(String str, a aVar, int i2) {
        if (i2 == 0) {
            aVar.a('S');
            return i2 + 1;
        }
        if (i2 != str.length() - 1 || (!a(str, i2 - 3, 3, "IAU", "EAU") && !a(str, i2 - 2, 2, "AU", "OU"))) {
            aVar.a("KS");
        }
        int i3 = i2 + 1;
        return a(str, i3, 1, "C", "X") ? i2 + 2 : i3;
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
    public String a(String str, boolean z) {
        int i2;
        ?? c2 = c(str);
        if (c2 == 0) {
            return null;
        }
        boolean e2 = e(c2);
        ?? d2 = d(c2);
        a aVar = new a(a());
        while (!aVar.c() && d2 <= c2.length() - 1) {
            char charAt = c2.charAt(d2);
            if (charAt == 199) {
                aVar.a('S');
            } else if (charAt != 209) {
                switch (charAt) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                    case 'Y':
                        d2 = a(aVar, d2);
                        break;
                    case 'B':
                        aVar.a('P');
                        i2 = d2 + 1;
                        if (a(c2, i2) != 'B') {
                            d2 = i2;
                            break;
                        } else {
                            d2 += 2;
                            break;
                        }
                    case 'C':
                        d2 = a(c2, aVar, d2);
                        break;
                    case 'D':
                        d2 = d(c2, aVar, d2);
                        break;
                    case 'F':
                        aVar.a('F');
                        i2 = d2 + 1;
                        if (a(c2, i2) != 'F') {
                            d2 = i2;
                            break;
                        } else {
                            d2 += 2;
                            break;
                        }
                    case 'G':
                        d2 = a(c2, aVar, d2, e2);
                        break;
                    case 'H':
                        d2 = f(c2, aVar, d2);
                        break;
                    case 'J':
                        d2 = b(c2, aVar, d2, e2);
                        break;
                    case 'K':
                        aVar.a('K');
                        i2 = d2 + 1;
                        if (a(c2, i2) != 'K') {
                            d2 = i2;
                            break;
                        } else {
                            d2 += 2;
                            break;
                        }
                    case 'L':
                        d2 = g(c2, aVar, d2);
                        break;
                    case 'M':
                        aVar.a('M');
                        if (!f(c2, d2)) {
                            break;
                        } else {
                            d2 += 2;
                            break;
                        }
                    case 'N':
                        aVar.a('N');
                        i2 = d2 + 1;
                        if (a(c2, i2) != 'N') {
                            d2 = i2;
                            break;
                        } else {
                            d2 += 2;
                            break;
                        }
                    case 'P':
                        d2 = h(c2, aVar, d2);
                        break;
                    case 'Q':
                        aVar.a('K');
                        i2 = d2 + 1;
                        if (a(c2, i2) != 'Q') {
                            d2 = i2;
                            break;
                        } else {
                            d2 += 2;
                            break;
                        }
                    case 'R':
                        d2 = c(c2, aVar, d2, e2);
                        break;
                    case 'S':
                        d2 = d(c2, aVar, d2, e2);
                        break;
                    case 'T':
                        d2 = j(c2, aVar, d2);
                        break;
                    case 'V':
                        aVar.a('F');
                        i2 = d2 + 1;
                        if (a(c2, i2) != 'V') {
                            d2 = i2;
                            break;
                        } else {
                            d2 += 2;
                            break;
                        }
                    case 'W':
                        d2 = k(c2, aVar, d2);
                        break;
                    case 'X':
                        d2 = l(c2, aVar, d2);
                        break;
                    case 'Z':
                        d2 = e(c2, aVar, d2, e2);
                        break;
                }
            } else {
                aVar.a('N');
            }
            d2++;
        }
        return z ? aVar.a() : aVar.b();
    }

    public String b(String str) {
        return a(str, false);
    }

    @Override // i.a.a.a.f
    public Object encode(Object obj) throws i.a.a.a.g {
        if (obj instanceof String) {
            return b((String) obj);
        }
        throw new i.a.a.a.g("DoubleMetaphone encode parameter is not of type String");
    }

    /* compiled from: DoubleMetaphone.java */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private final StringBuffer f16786a;

        /* renamed from: b, reason: collision with root package name */
        private final StringBuffer f16787b;

        /* renamed from: c, reason: collision with root package name */
        private final int f16788c;

        public a(int i2) {
            this.f16786a = new StringBuffer(f.this.a());
            this.f16787b = new StringBuffer(f.this.a());
            this.f16788c = i2;
        }

        public void a(char c2) {
            c(c2);
            b(c2);
        }

        public void b(char c2) {
            if (this.f16787b.length() < this.f16788c) {
                this.f16787b.append(c2);
            }
        }

        public void c(char c2) {
            if (this.f16786a.length() < this.f16788c) {
                this.f16786a.append(c2);
            }
        }

        public void a(char c2, char c3) {
            c(c2);
            b(c3);
        }

        public void b(String str) {
            int length = this.f16788c - this.f16787b.length();
            if (str.length() <= length) {
                this.f16787b.append(str);
            } else {
                this.f16787b.append(str.substring(0, length));
            }
        }

        public void c(String str) {
            int length = this.f16788c - this.f16786a.length();
            if (str.length() <= length) {
                this.f16786a.append(str);
            } else {
                this.f16786a.append(str.substring(0, length));
            }
        }

        public void a(String str) {
            c(str);
            b(str);
        }

        public void a(String str, String str2) {
            c(str);
            b(str2);
        }

        public String b() {
            return this.f16786a.toString();
        }

        public boolean c() {
            return this.f16786a.length() >= this.f16788c && this.f16787b.length() >= this.f16788c;
        }

        public String a() {
            return this.f16787b.toString();
        }
    }

    private int b(String str, a aVar, int i2) {
        int i3 = i2 + 2;
        if (!a(str, i3, 1, "I", ExifInterface.LONGITUDE_EAST, "H") || a(str, i3, 2, "HU")) {
            aVar.a('K');
            return i3;
        }
        if ((i2 == 1 && a(str, i2 - 1) == 'A') || a(str, i2 - 1, 5, "UCCEE", "UCCES")) {
            aVar.a("KS");
        } else {
            aVar.a('X');
        }
        return i2 + 3;
    }

    private boolean f(String str, int i2) {
        int i3 = i2 + 1;
        if (a(str, i3) == 'M') {
            return true;
        }
        return a(str, i2 + (-1), 3, "UMB") && (i3 == str.length() - 1 || a(str, i2 + 2, 2, "ER"));
    }

    private int b(String str, a aVar, int i2, boolean z) {
        if (!a(str, i2, 4, "JOSE") && !a(str, 0, 4, "SAN ")) {
            if (i2 == 0 && !a(str, i2, 4, "JOSE")) {
                aVar.a('J', 'A');
            } else {
                int i3 = i2 - 1;
                if (a(a(str, i3)) && !z) {
                    int i4 = i2 + 1;
                    if (a(str, i4) == 'A' || a(str, i4) == 'O') {
                        aVar.a('J', 'H');
                    }
                }
                if (i2 == str.length() - 1) {
                    aVar.a('J', ' ');
                } else if (!a(str, i2 + 1, 1, f16784f) && !a(str, i3, 1, ExifInterface.LATITUDE_SOUTH, "K", "L")) {
                    aVar.a('J');
                }
            }
            int i5 = i2 + 1;
            return a(str, i5) == 'J' ? i2 + 2 : i5;
        }
        if ((i2 != 0 || a(str, i2 + 4) != ' ') && str.length() != 4 && !a(str, 0, 4, "SAN ")) {
            aVar.a('J', 'H');
        } else {
            aVar.a('H');
        }
        return i2 + 1;
    }

    private int d(String str, a aVar, int i2, boolean z) {
        if (!a(str, i2 - 1, 3, "ISL", "YSL")) {
            if (i2 == 0 && a(str, i2, 5, "SUGAR")) {
                aVar.a('X', 'S');
            } else {
                if (a(str, i2, 2, "SH")) {
                    if (a(str, i2 + 1, 4, "HEIM", "HOEK", "HOLM", "HOLZ")) {
                        aVar.a('S');
                    } else {
                        aVar.a('X');
                    }
                } else {
                    if (a(str, i2, 3, "SIO", "SIA") || a(str, i2, 4, "SIAN")) {
                        if (z) {
                            aVar.a('S');
                        } else {
                            aVar.a('S', 'X');
                        }
                        return i2 + 3;
                    }
                    if (i2 != 0 || !a(str, i2 + 1, 1, "M", "N", "L", ExifInterface.LONGITUDE_WEST)) {
                        int i3 = i2 + 1;
                        if (!a(str, i3, 1, "Z")) {
                            if (a(str, i2, 2, "SC")) {
                                return i(str, aVar, i2);
                            }
                            if (i2 == str.length() - 1 && a(str, i2 - 2, 2, "AI", "OI")) {
                                aVar.b('S');
                            } else {
                                aVar.a('S');
                            }
                            if (!a(str, i3, 1, ExifInterface.LATITUDE_SOUTH, "Z")) {
                                return i3;
                            }
                        }
                    }
                    aVar.a('S', 'X');
                    int i4 = i2 + 1;
                    if (!a(str, i4, 1, "Z")) {
                        return i4;
                    }
                }
                return i2 + 2;
            }
        }
        return i2 + 1;
    }

    private int c(String str, a aVar, int i2, boolean z) {
        if (i2 == str.length() - 1 && !z && a(str, i2 - 2, 2, "IE") && !a(str, i2 - 4, 2, "ME", "MA")) {
            aVar.b('R');
        } else {
            aVar.a('R');
        }
        int i3 = i2 + 1;
        return a(str, i3) == 'R' ? i2 + 2 : i3;
    }

    private int e(String str, a aVar, int i2, boolean z) {
        int i3 = i2 + 1;
        if (a(str, i3) == 'H') {
            aVar.a('J');
            return i2 + 2;
        }
        if (!a(str, i3, 2, "ZO", "ZI", "ZA") && (!z || i2 <= 0 || a(str, i2 - 1) == 'T')) {
            aVar.a('S');
        } else {
            aVar.a(ExifInterface.LATITUDE_SOUTH, "TS");
        }
        if (a(str, i3) == 'Z') {
            i3 = i2 + 2;
        }
        return i3;
    }

    private boolean c(String str, int i2) {
        if (i2 != 0) {
            return false;
        }
        int i3 = i2 + 1;
        return (a(str, i3, 5, "HARAC", "HARIS") || a(str, i3, 3, "HOR", "HYM", "HIA", "HEM")) && !a(str, 0, 5, "CHORE");
    }

    private String c(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        return trim.toUpperCase(Locale.ENGLISH);
    }

    private boolean e(String str, int i2) {
        if (i2 == str.length() - 3 && a(str, i2 - 1, 4, "ILLO", "ILLA", "ALLE")) {
            return true;
        }
        return (a(str, str.length() - 2, 2, "AS", "OS") || a(str, str.length() - 1, 1, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "O")) && a(str, i2 - 1, 4, "ALLE");
    }

    private boolean e(String str) {
        return str.indexOf(87) > -1 || str.indexOf(75) > -1 || str.indexOf("CZ") > -1 || str.indexOf("WITZ") > -1;
    }

    private boolean b(String str, int i2) {
        if (a(str, i2, 4, "CHIA")) {
            return true;
        }
        if (i2 <= 1) {
            return false;
        }
        int i3 = i2 - 2;
        if (a(a(str, i3)) || !a(str, i2 - 1, 3, "ACH")) {
            return false;
        }
        char a2 = a(str, i2 + 2);
        return !(a2 == 'I' || a2 == 'E') || a(str, i3, 6, "BACHER", "MACHER");
    }

    private boolean d(String str, int i2) {
        if (!a(str, 0, 4, "VAN ", "VON ") && !a(str, 0, 3, "SCH") && !a(str, i2 - 2, 6, "ORCHES", "ARCHIT", "ORCHID")) {
            int i3 = i2 + 2;
            if (!a(str, i3, 1, ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH)) {
                if (!a(str, i2 - 1, 1, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "O", "U", ExifInterface.LONGITUDE_EAST) && i2 != 0) {
                    return false;
                }
                if (!a(str, i3, 1, f16782d) && i2 + 1 != str.length() - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean d(String str) {
        for (String str2 : f16781c) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // i.a.a.a.i
    public String a(String str) {
        return b(str);
    }

    public boolean a(String str, String str2) {
        return a(str, str2, false);
    }

    public boolean a(String str, String str2, boolean z) {
        return a(str, z).equals(a(str2, z));
    }

    public int a() {
        return this.f16785a;
    }

    public void a(int i2) {
        this.f16785a = i2;
    }

    private int a(a aVar, int i2) {
        if (i2 == 0) {
            aVar.a('A');
        }
        return i2 + 1;
    }

    private int a(String str, a aVar, int i2) {
        if (b(str, i2)) {
            aVar.a('K');
        } else if (i2 == 0 && a(str, i2, 6, "CAESAR")) {
            aVar.a('S');
        } else {
            if (a(str, i2, 2, "CH")) {
                return c(str, aVar, i2);
            }
            if (a(str, i2, 2, "CZ") && !a(str, i2 - 2, 4, "WICZ")) {
                aVar.a('S', 'X');
            } else {
                int i3 = i2 + 1;
                if (a(str, i3, 3, "CIA")) {
                    aVar.a('X');
                } else {
                    if (a(str, i2, 2, "CC") && (i2 != 1 || a(str, 0) != 'M')) {
                        return b(str, aVar, i2);
                    }
                    if (a(str, i2, 2, "CK", "CG", "CQ")) {
                        aVar.a('K');
                    } else if (a(str, i2, 2, "CI", "CE", "CY")) {
                        if (a(str, i2, 3, "CIO", "CIE", "CIA")) {
                            aVar.a('S', 'X');
                        } else {
                            aVar.a('S');
                        }
                    } else {
                        aVar.a('K');
                        if (!a(str, i3, 2, " C", " Q", " G")) {
                            if (!a(str, i3, 1, "C", "K", "Q") || a(str, i3, 2, "CE", "CI")) {
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

    private int a(String str, a aVar, int i2, boolean z) {
        int i3;
        int i4 = i2 + 1;
        if (a(str, i4) == 'H') {
            return e(str, aVar, i2);
        }
        if (a(str, i4) == 'N') {
            if (i2 == 1 && a(a(str, 0)) && !z) {
                aVar.a("KN", "N");
            } else if (!a(str, i2 + 2, 2, "EY") && a(str, i4) != 'Y' && !z) {
                aVar.a("N", "KN");
            } else {
                aVar.a("KN");
            }
        } else if (a(str, i4, 2, "LI") && !z) {
            aVar.a("KL", "L");
        } else if (i2 == 0 && (a(str, i4) == 'Y' || a(str, i4, 2, f16783e))) {
            aVar.a('K', 'J');
        } else {
            if (a(str, i4, 2, "ER") || a(str, i4) == 'Y') {
                i3 = 3;
                if (!a(str, 0, 6, "DANGER", "RANGER", "MANGER")) {
                    int i5 = i2 - 1;
                    if (!a(str, i5, 1, ExifInterface.LONGITUDE_EAST, "I") && !a(str, i5, 3, "RGY", "OGY")) {
                        aVar.a('K', 'J');
                    }
                }
            } else {
                i3 = 3;
            }
            if (!a(str, i4, 1, ExifInterface.LONGITUDE_EAST, "I", "Y") && !a(str, i2 - 1, 4, "AGGI", "OGGI")) {
                if (a(str, i4) == 'G') {
                    int i6 = i2 + 2;
                    aVar.a('K');
                    return i6;
                }
                aVar.a('K');
                return i4;
            }
            if (!a(str, 0, 4, "VAN ", "VON ") && !a(str, 0, i3, "SCH") && !a(str, i4, 2, "ET")) {
                if (a(str, i4, i3, "IER")) {
                    aVar.a('J');
                } else {
                    aVar.a('J', 'K');
                }
            } else {
                aVar.a('K');
            }
        }
        return i2 + 2;
    }

    private boolean a(char c2) {
        return f16780b.indexOf(c2) != -1;
    }

    protected char a(String str, int i2) {
        if (i2 < 0 || i2 >= str.length()) {
            return (char) 0;
        }
        return str.charAt(i2);
    }

    private static boolean a(String str, int i2, int i3, String str2) {
        return a(str, i2, i3, new String[]{str2});
    }

    private static boolean a(String str, int i2, int i3, String str2, String str3) {
        return a(str, i2, i3, new String[]{str2, str3});
    }

    private static boolean a(String str, int i2, int i3, String str2, String str3, String str4) {
        return a(str, i2, i3, new String[]{str2, str3, str4});
    }

    private static boolean a(String str, int i2, int i3, String str2, String str3, String str4, String str5) {
        return a(str, i2, i3, new String[]{str2, str3, str4, str5});
    }

    private static boolean a(String str, int i2, int i3, String str2, String str3, String str4, String str5, String str6) {
        return a(str, i2, i3, new String[]{str2, str3, str4, str5, str6});
    }

    private static boolean a(String str, int i2, int i3, String str2, String str3, String str4, String str5, String str6, String str7) {
        return a(str, i2, i3, new String[]{str2, str3, str4, str5, str6, str7});
    }

    protected static boolean a(String str, int i2, int i3, String[] strArr) {
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
