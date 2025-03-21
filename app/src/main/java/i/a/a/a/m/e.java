package i.a.a.a.m;

import java.util.Locale;

/* compiled from: ColognePhonetic.java */
/* loaded from: classes2.dex */
public class e implements i.a.a.a.i {

    /* renamed from: a, reason: collision with root package name */
    private static final char[][] f16774a = {new char[]{196, 'A'}, new char[]{220, 'U'}, new char[]{214, 'O'}, new char[]{223, 'S'}};

    private static boolean a(char[] cArr, char c2) {
        for (char c3 : cArr) {
            if (c3 == c2) {
                return true;
            }
        }
        return false;
    }

    private String c(String str) {
        char[] charArray = str.toUpperCase(Locale.GERMAN).toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (charArray[i2] > 'Z') {
                char[][] cArr = f16774a;
                int length = cArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        char[] cArr2 = cArr[i3];
                        if (charArray[i2] == cArr2[0]) {
                            charArray[i2] = cArr2[1];
                            break;
                        }
                        i3++;
                    }
                }
            }
        }
        return new String(charArray);
    }

    public String b(String str) {
        char c2;
        if (str == null) {
            return null;
        }
        String c3 = c(str);
        c cVar = new c(c3.length() * 2);
        b bVar = new b(c3.toCharArray());
        int a2 = bVar.a();
        char c4 = '/';
        char c5 = '-';
        while (a2 > 0) {
            char d2 = bVar.d();
            int a3 = bVar.a();
            char b2 = a3 > 0 ? bVar.b() : '-';
            if (a(new char[]{'A', 'E', 'I', 'J', 'O', 'U', 'Y'}, d2)) {
                c2 = '0';
            } else if (d2 == 'H' || d2 < 'A' || d2 > 'Z') {
                if (c4 == '/') {
                    a2 = a3;
                } else {
                    c2 = '-';
                }
            } else if (d2 == 'B' || (d2 == 'P' && b2 != 'H')) {
                c2 = '1';
            } else if ((d2 == 'D' || d2 == 'T') && !a(new char[]{'S', 'C', 'Z'}, b2)) {
                c2 = '2';
            } else if (a(new char[]{'W', 'F', 'P', 'V'}, d2)) {
                c2 = '3';
            } else {
                if (!a(new char[]{'G', 'K', 'Q'}, d2)) {
                    if (d2 != 'X' || a(new char[]{'C', 'K', 'Q'}, c5)) {
                        if (d2 != 'S' && d2 != 'Z') {
                            if (d2 == 'C') {
                                if (c4 != '/') {
                                }
                            } else if (!a(new char[]{'T', 'D', 'X'}, d2)) {
                                c2 = d2 == 'R' ? '7' : d2 == 'L' ? '5' : (d2 == 'M' || d2 == 'N') ? '6' : d2;
                            }
                        }
                        c2 = '8';
                    } else {
                        bVar.a('S');
                        a3++;
                    }
                }
                c2 = '4';
            }
            if (c2 != '-' && ((c4 != c2 && (c2 != '0' || c4 == '/')) || c2 < '0' || c2 > '8')) {
                cVar.a(c2);
            }
            c4 = c2;
            c5 = d2;
            a2 = a3;
        }
        return cVar.toString();
    }

    @Override // i.a.a.a.f
    public Object encode(Object obj) throws i.a.a.a.g {
        if (obj instanceof String) {
            return a((String) obj);
        }
        throw new i.a.a.a.g("This method's parameter was expected to be of the type " + String.class.getName() + ". But actually it was of the type " + obj.getClass().getName() + ".");
    }

    /* compiled from: ColognePhonetic.java */
    private class b extends a {
        public b(char[] cArr) {
            super(cArr);
        }

        public void a(char c2) {
            this.f16776b++;
            this.f16775a[c()] = c2;
        }

        public char b() {
            return this.f16775a[c()];
        }

        protected int c() {
            return this.f16775a.length - this.f16776b;
        }

        public char d() {
            this.f16776b--;
            return b();
        }

        @Override // i.a.a.a.m.e.a
        protected char[] a(int i2, int i3) {
            char[] cArr = new char[i3];
            char[] cArr2 = this.f16775a;
            System.arraycopy(cArr2, (cArr2.length - this.f16776b) + i2, cArr, 0, i3);
            return cArr;
        }
    }

    /* compiled from: ColognePhonetic.java */
    private class c extends a {
        public c(int i2) {
            super(i2);
        }

        public void a(char c2) {
            char[] cArr = this.f16775a;
            int i2 = this.f16776b;
            cArr[i2] = c2;
            this.f16776b = i2 + 1;
        }

        @Override // i.a.a.a.m.e.a
        protected char[] a(int i2, int i3) {
            char[] cArr = new char[i3];
            System.arraycopy(this.f16775a, i2, cArr, 0, i3);
            return cArr;
        }
    }

    @Override // i.a.a.a.i
    public String a(String str) {
        return b(str);
    }

    public boolean a(String str, String str2) {
        return b(str).equals(b(str2));
    }

    /* compiled from: ColognePhonetic.java */
    private abstract class a {

        /* renamed from: a, reason: collision with root package name */
        protected final char[] f16775a;

        /* renamed from: b, reason: collision with root package name */
        protected int f16776b;

        public a(char[] cArr) {
            this.f16776b = 0;
            this.f16775a = cArr;
            this.f16776b = cArr.length;
        }

        public int a() {
            return this.f16776b;
        }

        protected abstract char[] a(int i2, int i3);

        public String toString() {
            return new String(a(0, this.f16776b));
        }

        public a(int i2) {
            this.f16776b = 0;
            this.f16775a = new char[i2];
            this.f16776b = 0;
        }
    }
}
