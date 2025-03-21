package p324i.p325a.p326a.p327a.p330m;

import p324i.p325a.p326a.p327a.C5762g;
import p324i.p325a.p326a.p327a.InterfaceC5764i;

/* compiled from: Soundex.java */
/* renamed from: i.a.a.a.m.i */
/* loaded from: classes2.dex */
public class C5787i implements InterfaceC5764i {

    /* renamed from: c */
    public static final String f20852c = "01230120022455012623010202";

    /* renamed from: d */
    private static final char[] f20853d = f20852c.toCharArray();

    /* renamed from: e */
    public static final C5787i f20854e = new C5787i();

    /* renamed from: a */
    private int f20855a;

    /* renamed from: b */
    private final char[] f20856b;

    public C5787i() {
        this.f20855a = 4;
        this.f20856b = f20853d;
    }

    /* renamed from: b */
    private char[] m24337b() {
        return this.f20856b;
    }

    /* renamed from: a */
    public int m24339a(String str, String str2) throws C5762g {
        return C5788j.m24342a(this, str, str2);
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5761f
    public Object encode(Object obj) throws C5762g {
        if (obj instanceof String) {
            return m24341b((String) obj);
        }
        throw new C5762g("Parameter supplied to Soundex encode is not of type java.lang.String");
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5764i
    /* renamed from: a */
    public String mo24152a(String str) {
        return m24341b(str);
    }

    /* renamed from: b */
    public String m24341b(String str) {
        if (str == null) {
            return null;
        }
        String m24344a = C5788j.m24344a(str);
        if (m24344a.length() == 0) {
            return m24344a;
        }
        char[] cArr = {'0', '0', '0', '0'};
        cArr[0] = m24344a.charAt(0);
        int i2 = 1;
        char m24336a = m24336a(m24344a, 0);
        int i3 = 1;
        while (i2 < m24344a.length() && i3 < cArr.length) {
            int i4 = i2 + 1;
            char m24336a2 = m24336a(m24344a, i2);
            if (m24336a2 != 0) {
                if (m24336a2 != '0' && m24336a2 != m24336a) {
                    cArr[i3] = m24336a2;
                    i3++;
                }
                m24336a = m24336a2;
            }
            i2 = i4;
        }
        return new String(cArr);
    }

    /* renamed from: a */
    private char m24336a(String str, int i2) {
        char charAt;
        char m24335a = m24335a(str.charAt(i2));
        if (i2 > 1 && m24335a != '0' && ('H' == (charAt = str.charAt(i2 - 1)) || 'W' == charAt)) {
            char charAt2 = str.charAt(i2 - 2);
            if (m24335a(charAt2) == m24335a || 'H' == charAt2 || 'W' == charAt2) {
                return (char) 0;
            }
        }
        return m24335a;
    }

    public C5787i(char[] cArr) {
        this.f20855a = 4;
        this.f20856b = new char[cArr.length];
        System.arraycopy(cArr, 0, this.f20856b, 0, cArr.length);
    }

    /* renamed from: a */
    public int m24338a() {
        return this.f20855a;
    }

    public C5787i(String str) {
        this.f20855a = 4;
        this.f20856b = str.toCharArray();
    }

    /* renamed from: a */
    private char m24335a(char c2) {
        int i2 = c2 - 'A';
        if (i2 >= 0 && i2 < m24337b().length) {
            return m24337b()[i2];
        }
        throw new IllegalArgumentException("The character is not mapped: " + c2);
    }

    /* renamed from: a */
    public void m24340a(int i2) {
        this.f20855a = i2;
    }
}
