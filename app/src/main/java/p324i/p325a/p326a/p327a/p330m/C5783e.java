package p324i.p325a.p326a.p327a.p330m;

import java.util.Locale;
import p324i.p325a.p326a.p327a.C5762g;
import p324i.p325a.p326a.p327a.InterfaceC5764i;

/* compiled from: ColognePhonetic.java */
/* renamed from: i.a.a.a.m.e */
/* loaded from: classes2.dex */
public class C5783e implements InterfaceC5764i {

    /* renamed from: a */
    private static final char[][] f20828a = {new char[]{196, 'A'}, new char[]{220, 'U'}, new char[]{214, 'O'}, new char[]{223, 'S'}};

    /* renamed from: a */
    private static boolean m24260a(char[] cArr, char c2) {
        for (char c3 : cArr) {
            if (c3 == c2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private String m24261c(String str) {
        char[] charArray = str.toUpperCase(Locale.GERMAN).toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (charArray[i2] > 'Z') {
                char[][] cArr = f20828a;
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

    /* renamed from: b */
    public String m24263b(String str) {
        char c2;
        if (str == null) {
            return null;
        }
        String m24261c = m24261c(str);
        c cVar = new c(m24261c.length() * 2);
        b bVar = new b(m24261c.toCharArray());
        int m24264a = bVar.m24264a();
        char c3 = '/';
        char c4 = '-';
        while (m24264a > 0) {
            char m24269d = bVar.m24269d();
            int m24264a2 = bVar.m24264a();
            char m24267b = m24264a2 > 0 ? bVar.m24267b() : '-';
            if (m24260a(new char[]{'A', 'E', 'I', 'J', 'O', 'U', 'Y'}, m24269d)) {
                c2 = '0';
            } else if (m24269d == 'H' || m24269d < 'A' || m24269d > 'Z') {
                if (c3 == '/') {
                    m24264a = m24264a2;
                } else {
                    c2 = '-';
                }
            } else if (m24269d == 'B' || (m24269d == 'P' && m24267b != 'H')) {
                c2 = '1';
            } else if ((m24269d == 'D' || m24269d == 'T') && !m24260a(new char[]{'S', 'C', 'Z'}, m24267b)) {
                c2 = '2';
            } else if (m24260a(new char[]{'W', 'F', 'P', 'V'}, m24269d)) {
                c2 = '3';
            } else {
                if (!m24260a(new char[]{'G', 'K', 'Q'}, m24269d)) {
                    if (m24269d != 'X' || m24260a(new char[]{'C', 'K', 'Q'}, c4)) {
                        if (m24269d != 'S' && m24269d != 'Z') {
                            if (m24269d == 'C') {
                                if (c3 != '/') {
                                }
                            } else if (!m24260a(new char[]{'T', 'D', 'X'}, m24269d)) {
                                c2 = m24269d == 'R' ? '7' : m24269d == 'L' ? '5' : (m24269d == 'M' || m24269d == 'N') ? '6' : m24269d;
                            }
                        }
                        c2 = '8';
                    } else {
                        bVar.m24266a('S');
                        m24264a2++;
                    }
                }
                c2 = '4';
            }
            if (c2 != '-' && ((c3 != c2 && (c2 != '0' || c3 == '/')) || c2 < '0' || c2 > '8')) {
                cVar.m24270a(c2);
            }
            c3 = c2;
            c4 = m24269d;
            m24264a = m24264a2;
        }
        return cVar.toString();
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5761f
    public Object encode(Object obj) throws C5762g {
        if (obj instanceof String) {
            return mo24152a((String) obj);
        }
        throw new C5762g("This method's parameter was expected to be of the type " + String.class.getName() + ". But actually it was of the type " + obj.getClass().getName() + ".");
    }

    /* compiled from: ColognePhonetic.java */
    /* renamed from: i.a.a.a.m.e$b */
    private class b extends a {
        public b(char[] cArr) {
            super(cArr);
        }

        /* renamed from: a */
        public void m24266a(char c2) {
            this.f20830b++;
            this.f20829a[m24268c()] = c2;
        }

        /* renamed from: b */
        public char m24267b() {
            return this.f20829a[m24268c()];
        }

        /* renamed from: c */
        protected int m24268c() {
            return this.f20829a.length - this.f20830b;
        }

        /* renamed from: d */
        public char m24269d() {
            this.f20830b--;
            return m24267b();
        }

        @Override // p324i.p325a.p326a.p327a.p330m.C5783e.a
        /* renamed from: a */
        protected char[] mo24265a(int i2, int i3) {
            char[] cArr = new char[i3];
            char[] cArr2 = this.f20829a;
            System.arraycopy(cArr2, (cArr2.length - this.f20830b) + i2, cArr, 0, i3);
            return cArr;
        }
    }

    /* compiled from: ColognePhonetic.java */
    /* renamed from: i.a.a.a.m.e$c */
    private class c extends a {
        public c(int i2) {
            super(i2);
        }

        /* renamed from: a */
        public void m24270a(char c2) {
            char[] cArr = this.f20829a;
            int i2 = this.f20830b;
            cArr[i2] = c2;
            this.f20830b = i2 + 1;
        }

        @Override // p324i.p325a.p326a.p327a.p330m.C5783e.a
        /* renamed from: a */
        protected char[] mo24265a(int i2, int i3) {
            char[] cArr = new char[i3];
            System.arraycopy(this.f20829a, i2, cArr, 0, i3);
            return cArr;
        }
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5764i
    /* renamed from: a */
    public String mo24152a(String str) {
        return m24263b(str);
    }

    /* renamed from: a */
    public boolean m24262a(String str, String str2) {
        return m24263b(str).equals(m24263b(str2));
    }

    /* compiled from: ColognePhonetic.java */
    /* renamed from: i.a.a.a.m.e$a */
    private abstract class a {

        /* renamed from: a */
        protected final char[] f20829a;

        /* renamed from: b */
        protected int f20830b;

        public a(char[] cArr) {
            this.f20830b = 0;
            this.f20829a = cArr;
            this.f20830b = cArr.length;
        }

        /* renamed from: a */
        public int m24264a() {
            return this.f20830b;
        }

        /* renamed from: a */
        protected abstract char[] mo24265a(int i2, int i3);

        public String toString() {
            return new String(mo24265a(0, this.f20830b));
        }

        public a(int i2) {
            this.f20830b = 0;
            this.f20829a = new char[i2];
            this.f20830b = 0;
        }
    }
}
