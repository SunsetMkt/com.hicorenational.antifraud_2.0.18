package j.a.a.a.n;

import j.a.a.a.g;
import j.a.a.a.h;
import j.a.a.a.i;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;

/* JADX INFO: compiled from: QCodec.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends d implements i, h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final BitSet f12537f = new BitSet(256);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final byte f12538g = 32;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final byte f12539h = 95;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f12540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f12541e;

    static {
        f12537f.set(32);
        f12537f.set(33);
        f12537f.set(34);
        f12537f.set(35);
        f12537f.set(36);
        f12537f.set(37);
        f12537f.set(38);
        f12537f.set(39);
        f12537f.set(40);
        f12537f.set(41);
        f12537f.set(42);
        f12537f.set(43);
        f12537f.set(44);
        f12537f.set(45);
        f12537f.set(46);
        f12537f.set(47);
        for (int i2 = 48; i2 <= 57; i2++) {
            f12537f.set(i2);
        }
        f12537f.set(58);
        f12537f.set(59);
        f12537f.set(60);
        f12537f.set(62);
        f12537f.set(64);
        for (int i3 = 65; i3 <= 90; i3++) {
            f12537f.set(i3);
        }
        f12537f.set(91);
        f12537f.set(92);
        f12537f.set(93);
        f12537f.set(94);
        f12537f.set(96);
        for (int i4 = 97; i4 <= 122; i4++) {
            f12537f.set(i4);
        }
        f12537f.set(123);
        f12537f.set(124);
        f12537f.set(125);
        f12537f.set(126);
    }

    public b() {
        this("UTF-8");
    }

    @Override // j.a.a.a.n.d
    protected String a() {
        return "Q";
    }

    @Override // j.a.a.a.n.d
    protected byte[] a(byte[] bArr) throws j.a.a.a.e {
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
            return c.a(bArr);
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            byte b2 = bArr[i3];
            if (b2 != 95) {
                bArr2[i3] = b2;
            } else {
                bArr2[i3] = f12538g;
            }
        }
        return c.a(bArr2);
    }

    @Override // j.a.a.a.n.d
    protected byte[] b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArrA = c.a(f12537f, bArr);
        if (this.f12541e) {
            for (int i2 = 0; i2 < bArrA.length; i2++) {
                if (bArrA[i2] == 32) {
                    bArrA[i2] = f12539h;
                }
            }
        }
        return bArrA;
    }

    public boolean c() {
        return this.f12541e;
    }

    @Override // j.a.a.a.h
    public String decode(String str) throws j.a.a.a.e {
        if (str == null) {
            return null;
        }
        try {
            return b(str);
        } catch (UnsupportedEncodingException e2) {
            throw new j.a.a.a.e(e2.getMessage(), e2);
        }
    }

    @Override // j.a.a.a.f
    public Object encode(Object obj) throws g {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return a((String) obj);
        }
        throw new g("Objects of type " + obj.getClass().getName() + " cannot be encoded using Q codec");
    }

    public b(String str) {
        this.f12541e = false;
        this.f12540d = str;
    }

    @Override // j.a.a.a.d
    public Object decode(Object obj) throws j.a.a.a.e {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new j.a.a.a.e("Objects of type " + obj.getClass().getName() + " cannot be decoded using Q codec");
    }

    public String b(String str, String str2) throws g {
        if (str == null) {
            return null;
        }
        try {
            return a(str, str2);
        } catch (UnsupportedEncodingException e2) {
            throw new g(e2.getMessage(), e2);
        }
    }

    public String b() {
        return this.f12540d;
    }

    @Override // j.a.a.a.i
    public String a(String str) throws g {
        if (str == null) {
            return null;
        }
        return b(str, b());
    }

    public void a(boolean z) {
        this.f12541e = z;
    }
}
