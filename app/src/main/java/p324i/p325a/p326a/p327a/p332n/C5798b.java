package p324i.p325a.p326a.p327a.p332n;

import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import p324i.p325a.p326a.p327a.C5760e;
import p324i.p325a.p326a.p327a.C5762g;
import p324i.p325a.p326a.p327a.InterfaceC5763h;
import p324i.p325a.p326a.p327a.InterfaceC5764i;

/* compiled from: QCodec.java */
/* renamed from: i.a.a.a.n.b */
/* loaded from: classes2.dex */
public class C5798b extends AbstractC5800d implements InterfaceC5764i, InterfaceC5763h {

    /* renamed from: f */
    private static final BitSet f20920f = new BitSet(256);

    /* renamed from: g */
    private static final byte f20921g = 32;

    /* renamed from: h */
    private static final byte f20922h = 95;

    /* renamed from: d */
    private final String f20923d;

    /* renamed from: e */
    private boolean f20924e;

    static {
        f20920f.set(32);
        f20920f.set(33);
        f20920f.set(34);
        f20920f.set(35);
        f20920f.set(36);
        f20920f.set(37);
        f20920f.set(38);
        f20920f.set(39);
        f20920f.set(40);
        f20920f.set(41);
        f20920f.set(42);
        f20920f.set(43);
        f20920f.set(44);
        f20920f.set(45);
        f20920f.set(46);
        f20920f.set(47);
        for (int i2 = 48; i2 <= 57; i2++) {
            f20920f.set(i2);
        }
        f20920f.set(58);
        f20920f.set(59);
        f20920f.set(60);
        f20920f.set(62);
        f20920f.set(64);
        for (int i3 = 65; i3 <= 90; i3++) {
            f20920f.set(i3);
        }
        f20920f.set(91);
        f20920f.set(92);
        f20920f.set(93);
        f20920f.set(94);
        f20920f.set(96);
        for (int i4 = 97; i4 <= 122; i4++) {
            f20920f.set(i4);
        }
        f20920f.set(123);
        f20920f.set(124);
        f20920f.set(125);
        f20920f.set(126);
    }

    public C5798b() {
        this("UTF-8");
    }

    @Override // p324i.p325a.p326a.p327a.p332n.AbstractC5800d
    /* renamed from: a */
    protected String mo24416a() {
        return "Q";
    }

    @Override // p324i.p325a.p326a.p327a.p332n.AbstractC5800d
    /* renamed from: a */
    protected byte[] mo24417a(byte[] bArr) throws C5760e {
        boolean z;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            }
            if (bArr[i2] == 95) {
                z = true;
                break;
            }
            i2++;
        }
        if (!z) {
            return C5799c.m24427a(bArr);
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            byte b2 = bArr[i3];
            if (b2 != 95) {
                bArr2[i3] = b2;
            } else {
                bArr2[i3] = f20921g;
            }
        }
        return C5799c.m24427a(bArr2);
    }

    @Override // p324i.p325a.p326a.p327a.p332n.AbstractC5800d
    /* renamed from: b */
    protected byte[] mo24420b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] m24426a = C5799c.m24426a(f20920f, bArr);
        if (this.f20924e) {
            for (int i2 = 0; i2 < m24426a.length; i2++) {
                if (m24426a[i2] == 32) {
                    m24426a[i2] = f20922h;
                }
            }
        }
        return m24426a;
    }

    /* renamed from: c */
    public boolean m24424c() {
        return this.f20924e;
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5763h
    public String decode(String str) throws C5760e {
        if (str == null) {
            return null;
        }
        try {
            return m24432b(str);
        } catch (UnsupportedEncodingException e2) {
            throw new C5760e(e2.getMessage(), e2);
        }
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5761f
    public Object encode(Object obj) throws C5762g {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return mo24152a((String) obj);
        }
        throw new C5762g("Objects of type " + obj.getClass().getName() + " cannot be encoded using Q codec");
    }

    public C5798b(String str) {
        this.f20924e = false;
        this.f20923d = str;
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5759d
    public Object decode(Object obj) throws C5760e {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new C5760e("Objects of type " + obj.getClass().getName() + " cannot be decoded using Q codec");
    }

    /* renamed from: b */
    public String m24423b(String str, String str2) throws C5762g {
        if (str == null) {
            return null;
        }
        try {
            return m24431a(str, str2);
        } catch (UnsupportedEncodingException e2) {
            throw new C5762g(e2.getMessage(), e2);
        }
    }

    /* renamed from: b */
    public String m24422b() {
        return this.f20923d;
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5764i
    /* renamed from: a */
    public String mo24152a(String str) throws C5762g {
        if (str == null) {
            return null;
        }
        return m24423b(str, m24422b());
    }

    /* renamed from: a */
    public void m24421a(boolean z) {
        this.f20924e = z;
    }
}
