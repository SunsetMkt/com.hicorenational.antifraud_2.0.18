package p324i.p325a.p326a.p327a.p330m;

import p324i.p325a.p326a.p327a.C5762g;
import p324i.p325a.p326a.p327a.InterfaceC5764i;

/* compiled from: RefinedSoundex.java */
/* renamed from: i.a.a.a.m.h */
/* loaded from: classes2.dex */
public class C5786h implements InterfaceC5764i {

    /* renamed from: b */
    public static final String f20848b = "01360240043788015936020505";

    /* renamed from: c */
    private static final char[] f20849c = f20848b.toCharArray();

    /* renamed from: d */
    public static final C5786h f20850d = new C5786h();

    /* renamed from: a */
    private final char[] f20851a;

    public C5786h() {
        this.f20851a = f20849c;
    }

    /* renamed from: a */
    public int m24333a(String str, String str2) throws C5762g {
        return C5788j.m24342a(this, str, str2);
    }

    /* renamed from: b */
    public String m24334b(String str) {
        if (str == null) {
            return null;
        }
        String m24344a = C5788j.m24344a(str);
        if (m24344a.length() == 0) {
            return m24344a;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(m24344a.charAt(0));
        char c2 = '*';
        for (int i2 = 0; i2 < m24344a.length(); i2++) {
            char m24332a = m24332a(m24344a.charAt(i2));
            if (m24332a != c2) {
                if (m24332a != 0) {
                    stringBuffer.append(m24332a);
                }
                c2 = m24332a;
            }
        }
        return stringBuffer.toString();
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5761f
    public Object encode(Object obj) throws C5762g {
        if (obj instanceof String) {
            return m24334b((String) obj);
        }
        throw new C5762g("Parameter supplied to RefinedSoundex encode is not of type java.lang.String");
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5764i
    /* renamed from: a */
    public String mo24152a(String str) {
        return m24334b(str);
    }

    public C5786h(char[] cArr) {
        this.f20851a = new char[cArr.length];
        System.arraycopy(cArr, 0, this.f20851a, 0, cArr.length);
    }

    /* renamed from: a */
    char m24332a(char c2) {
        if (Character.isLetter(c2)) {
            return this.f20851a[Character.toUpperCase(c2) - 'A'];
        }
        return (char) 0;
    }

    public C5786h(String str) {
        this.f20851a = str.toCharArray();
    }
}
