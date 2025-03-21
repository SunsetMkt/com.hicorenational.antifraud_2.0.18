package i.a.a.a.m;

/* compiled from: Soundex.java */
/* loaded from: classes2.dex */
public class i implements i.a.a.a.i {

    /* renamed from: c, reason: collision with root package name */
    public static final String f16798c = "01230120022455012623010202";

    /* renamed from: d, reason: collision with root package name */
    private static final char[] f16799d = f16798c.toCharArray();

    /* renamed from: e, reason: collision with root package name */
    public static final i f16800e = new i();

    /* renamed from: a, reason: collision with root package name */
    private int f16801a;

    /* renamed from: b, reason: collision with root package name */
    private final char[] f16802b;

    public i() {
        this.f16801a = 4;
        this.f16802b = f16799d;
    }

    private char[] b() {
        return this.f16802b;
    }

    public int a(String str, String str2) throws i.a.a.a.g {
        return j.a(this, str, str2);
    }

    @Override // i.a.a.a.f
    public Object encode(Object obj) throws i.a.a.a.g {
        if (obj instanceof String) {
            return b((String) obj);
        }
        throw new i.a.a.a.g("Parameter supplied to Soundex encode is not of type java.lang.String");
    }

    @Override // i.a.a.a.i
    public String a(String str) {
        return b(str);
    }

    public String b(String str) {
        if (str == null) {
            return null;
        }
        String a2 = j.a(str);
        if (a2.length() == 0) {
            return a2;
        }
        char[] cArr = {'0', '0', '0', '0'};
        cArr[0] = a2.charAt(0);
        int i2 = 1;
        char a3 = a(a2, 0);
        int i3 = 1;
        while (i2 < a2.length() && i3 < cArr.length) {
            int i4 = i2 + 1;
            char a4 = a(a2, i2);
            if (a4 != 0) {
                if (a4 != '0' && a4 != a3) {
                    cArr[i3] = a4;
                    i3++;
                }
                a3 = a4;
            }
            i2 = i4;
        }
        return new String(cArr);
    }

    private char a(String str, int i2) {
        char charAt;
        char a2 = a(str.charAt(i2));
        if (i2 > 1 && a2 != '0' && ('H' == (charAt = str.charAt(i2 - 1)) || 'W' == charAt)) {
            char charAt2 = str.charAt(i2 - 2);
            if (a(charAt2) == a2 || 'H' == charAt2 || 'W' == charAt2) {
                return (char) 0;
            }
        }
        return a2;
    }

    public i(char[] cArr) {
        this.f16801a = 4;
        this.f16802b = new char[cArr.length];
        System.arraycopy(cArr, 0, this.f16802b, 0, cArr.length);
    }

    public int a() {
        return this.f16801a;
    }

    public i(String str) {
        this.f16801a = 4;
        this.f16802b = str.toCharArray();
    }

    private char a(char c2) {
        int i2 = c2 - 'A';
        if (i2 >= 0 && i2 < b().length) {
            return b()[i2];
        }
        throw new IllegalArgumentException("The character is not mapped: " + c2);
    }

    public void a(int i2) {
        this.f16801a = i2;
    }
}
