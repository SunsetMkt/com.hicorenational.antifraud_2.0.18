package j.a.a.a.m;

/* JADX INFO: compiled from: RefinedSoundex.java */
/* JADX INFO: loaded from: classes2.dex */
public class h implements j.a.a.a.i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12490b = "01360240043788015936020505";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f12491c = f12490b.toCharArray();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f12492d = new h();
    private final char[] a;

    public h() {
        this.a = f12491c;
    }

    public int a(String str, String str2) throws j.a.a.a.g {
        return j.a(this, str, str2);
    }

    public String b(String str) {
        if (str == null) {
            return null;
        }
        String strA = j.a(str);
        if (strA.length() == 0) {
            return strA;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strA.charAt(0));
        char c2 = '*';
        for (int i2 = 0; i2 < strA.length(); i2++) {
            char cA = a(strA.charAt(i2));
            if (cA != c2) {
                if (cA != 0) {
                    stringBuffer.append(cA);
                }
                c2 = cA;
            }
        }
        return stringBuffer.toString();
    }

    @Override // j.a.a.a.f
    public Object encode(Object obj) throws j.a.a.a.g {
        if (obj instanceof String) {
            return b((String) obj);
        }
        throw new j.a.a.a.g("Parameter supplied to RefinedSoundex encode is not of type java.lang.String");
    }

    @Override // j.a.a.a.i
    public String a(String str) {
        return b(str);
    }

    public h(char[] cArr) {
        this.a = new char[cArr.length];
        System.arraycopy(cArr, 0, this.a, 0, cArr.length);
    }

    char a(char c2) {
        if (Character.isLetter(c2)) {
            return this.a[Character.toUpperCase(c2) - 'A'];
        }
        return (char) 0;
    }

    public h(String str) {
        this.a = str.toCharArray();
    }
}
