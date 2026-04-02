package j.a.a.a.m;

import java.util.Locale;

/* JADX INFO: compiled from: ColognePhonetic.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements j.a.a.a.i {
    private static final char[][] a = {new char[]{'\u00c4', 'A'}, new char[]{'\u00dc', 'U'}, new char[]{'\u00d6', 'O'}, new char[]{'\u00df', 'S'}};

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
                char[][] cArr = a;
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
        String strC = c(str);
        c cVar = new c(strC.length() * 2);
        b bVar = new b(strC.toCharArray());
        int iA = bVar.a();
        char c3 = '/';
        char c4 = '-';
        while (iA > 0) {
            char cD = bVar.d();
            int iA2 = bVar.a();
            char cB = iA2 > 0 ? bVar.b() : '-';
            if (a(new char[]{'A', 'E', 'I', 'J', 'O', 'U', 'Y'}, cD)) {
                c2 = '0';
            } else if (cD == 'H' || cD < 'A' || cD > 'Z') {
                if (c3 == '/') {
                    iA = iA2;
                } else {
                    c2 = '-';
                }
            } else if (cD == 'B' || (cD == 'P' && cB != 'H')) {
                c2 = '1';
            } else if ((cD == 'D' || cD == 'T') && !a(new char[]{'S', 'C', 'Z'}, cB)) {
                c2 = '2';
            } else if (a(new char[]{'W', 'F', 'P', 'V'}, cD)) {
                c2 = '3';
            } else {
                if (a(new char[]{'G', 'K', 'Q'}, cD)) {
                    c2 = '4';
                } else {
                    if (cD == 'X' && !a(new char[]{'C', 'K', 'Q'}, c4)) {
                        bVar.a('S');
                        iA2++;
                    } else if (cD == 'S' || cD == 'Z') {
                        c2 = '8';
                    } else {
                        if (cD == 'C') {
                            if (c3 != '/' ? a(new char[]{'S', 'Z'}, c4) || !a(new char[]{'A', 'H', 'O', 'U', 'K', 'Q', 'X'}, cB) : !a(new char[]{'A', 'H', 'K', 'L', 'O', 'Q', 'R', 'U', 'X'}, cB)) {
                            }
                        } else if (!a(new char[]{'T', 'D', 'X'}, cD)) {
                            c2 = cD == 'R' ? '7' : cD == 'L' ? '5' : (cD == 'M' || cD == 'N') ? '6' : cD;
                        }
                        c2 = '8';
                    }
                    c2 = '4';
                }
                iA = iA2;
            }
            if (c2 != '-' && ((c3 != c2 && (c2 != '0' || c3 == '/')) || c2 < '0' || c2 > '8')) {
                cVar.a(c2);
            }
            c3 = c2;
            c4 = cD;
            iA = iA2;
        }
        return cVar.toString();
    }

    @Override // j.a.a.a.f
    public Object encode(Object obj) throws j.a.a.a.g {
        if (obj instanceof String) {
            return a((String) obj);
        }
        throw new j.a.a.a.g("This method's parameter was expected to be of the type " + String.class.getName() + ". But actually it was of the type " + obj.getClass().getName() + ".");
    }

    /* JADX INFO: compiled from: ColognePhonetic.java */
    private class b extends a {
        public b(char[] cArr) {
            super(cArr);
        }

        public void a(char c2) {
            this.f12475b++;
            this.a[c()] = c2;
        }

        public char b() {
            return this.a[c()];
        }

        protected int c() {
            return this.a.length - this.f12475b;
        }

        public char d() {
            this.f12475b--;
            return b();
        }

        @Override // j.a.a.a.m.e.a
        protected char[] a(int i2, int i3) {
            char[] cArr = new char[i3];
            char[] cArr2 = this.a;
            System.arraycopy(cArr2, (cArr2.length - this.f12475b) + i2, cArr, 0, i3);
            return cArr;
        }
    }

    /* JADX INFO: compiled from: ColognePhonetic.java */
    private class c extends a {
        public c(int i2) {
            super(i2);
        }

        public void a(char c2) {
            char[] cArr = this.a;
            int i2 = this.f12475b;
            cArr[i2] = c2;
            this.f12475b = i2 + 1;
        }

        @Override // j.a.a.a.m.e.a
        protected char[] a(int i2, int i3) {
            char[] cArr = new char[i3];
            System.arraycopy(this.a, i2, cArr, 0, i3);
            return cArr;
        }
    }

    @Override // j.a.a.a.i
    public String a(String str) {
        return b(str);
    }

    public boolean a(String str, String str2) {
        return b(str).equals(b(str2));
    }

    /* JADX INFO: compiled from: ColognePhonetic.java */
    private abstract class a {
        protected final char[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected int f12475b;

        public a(char[] cArr) {
            this.f12475b = 0;
            this.a = cArr;
            this.f12475b = cArr.length;
        }

        public int a() {
            return this.f12475b;
        }

        protected abstract char[] a(int i2, int i3);

        public String toString() {
            return new String(a(0, this.f12475b));
        }

        public a(int i2) {
            this.f12475b = 0;
            this.a = new char[i2];
            this.f12475b = 0;
        }
    }
}
