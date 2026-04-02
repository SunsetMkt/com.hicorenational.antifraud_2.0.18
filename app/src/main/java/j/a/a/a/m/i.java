package j.a.a.a.m;

/* JADX INFO: compiled from: Soundex.java */
/* JADX INFO: loaded from: classes2.dex */
public class i implements j.a.a.a.i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12493c = "01230120022455012623010202";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char[] f12494d = f12493c.toCharArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final i f12495e = new i();
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char[] f12496b;

    public i() {
        this.a = 4;
        this.f12496b = f12494d;
    }

    private char[] b() {
        return this.f12496b;
    }

    public int a(String str, String str2) throws j.a.a.a.g {
        return j.a(this, str, str2);
    }

    @Override // j.a.a.a.f
    public Object encode(Object obj) throws j.a.a.a.g {
        if (obj instanceof String) {
            return b((String) obj);
        }
        throw new j.a.a.a.g("Parameter supplied to Soundex encode is not of type java.lang.String");
    }

    @Override // j.a.a.a.i
    public String a(String str) {
        return b(str);
    }

    public String b(String str) {
        if (str == null) {
            return null;
        }
        String strA = j.a(str);
        if (strA.length() == 0) {
            return strA;
        }
        char[] cArr = {'0', '0', '0', '0'};
        cArr[0] = strA.charAt(0);
        int i2 = 1;
        char cA = a(strA, 0);
        int i3 = 1;
        while (i2 < strA.length() && i3 < cArr.length) {
            int i4 = i2 + 1;
            char cA2 = a(strA, i2);
            if (cA2 != 0) {
                if (cA2 != '0' && cA2 != cA) {
                    cArr[i3] = cA2;
                    i3++;
                }
                cA = cA2;
            }
            i2 = i4;
        }
        return new String(cArr);
    }

    private char a(String str, int i2) {
        char cCharAt;
        char cA = a(str.charAt(i2));
        if (i2 > 1 && cA != '0' && ('H' == (cCharAt = str.charAt(i2 - 1)) || 'W' == cCharAt)) {
            char cCharAt2 = str.charAt(i2 - 2);
            if (a(cCharAt2) == cA || 'H' == cCharAt2 || 'W' == cCharAt2) {
                return (char) 0;
            }
        }
        return cA;
    }

    public i(char[] cArr) {
        this.a = 4;
        this.f12496b = new char[cArr.length];
        System.arraycopy(cArr, 0, this.f12496b, 0, cArr.length);
    }

    public int a() {
        return this.a;
    }

    public i(String str) {
        this.a = 4;
        this.f12496b = str.toCharArray();
    }

    private char a(char c2) {
        int i2 = c2 - 'A';
        if (i2 >= 0 && i2 < b().length) {
            return b()[i2];
        }
        throw new IllegalArgumentException("The character is not mapped: " + c2);
    }

    public void a(int i2) {
        this.a = i2;
    }
}
