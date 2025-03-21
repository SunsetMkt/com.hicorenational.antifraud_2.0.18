package p324i.p325a.p326a.p327a.p332n;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import p324i.p325a.p326a.p327a.C5760e;
import p324i.p325a.p326a.p327a.C5762g;
import p324i.p325a.p326a.p327a.InterfaceC5756a;
import p324i.p325a.p326a.p327a.InterfaceC5757b;
import p324i.p325a.p326a.p327a.InterfaceC5763h;
import p324i.p325a.p326a.p327a.InterfaceC5764i;
import p324i.p325a.p326a.p327a.p328k.C5777l;

/* compiled from: URLCodec.java */
/* renamed from: i.a.a.a.n.e */
/* loaded from: classes2.dex */
public class C5801e implements InterfaceC5757b, InterfaceC5756a, InterfaceC5764i, InterfaceC5763h {

    /* renamed from: b */
    static final int f20933b = 16;

    /* renamed from: c */
    protected static final byte f20934c = 37;

    /* renamed from: d */
    protected static final BitSet f20935d = new BitSet(256);

    /* renamed from: a */
    protected String f20936a;

    static {
        for (int i2 = 97; i2 <= 122; i2++) {
            f20935d.set(i2);
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            f20935d.set(i3);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            f20935d.set(i4);
        }
        f20935d.set(45);
        f20935d.set(95);
        f20935d.set(46);
        f20935d.set(42);
        f20935d.set(32);
    }

    public C5801e() {
        this("UTF-8");
    }

    /* renamed from: a */
    public static final byte[] m24433a(BitSet bitSet, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bitSet == null) {
            bitSet = f20935d;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = bArr[i2];
            if (i3 < 0) {
                i3 += 256;
            }
            if (bitSet.get(i3)) {
                if (i3 == 32) {
                    i3 = 43;
                }
                byteArrayOutputStream.write(i3);
            } else {
                byteArrayOutputStream.write(37);
                char upperCase = Character.toUpperCase(Character.forDigit((i3 >> 4) & 15, 16));
                char upperCase2 = Character.toUpperCase(Character.forDigit(i3 & 15, 16));
                byteArrayOutputStream.write(upperCase);
                byteArrayOutputStream.write(upperCase2);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: b */
    public String m24438b(String str, String str2) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return C5777l.m24209b(encode(str.getBytes(str2)));
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5756a
    public byte[] decode(byte[] bArr) throws C5760e {
        return m24434a(bArr);
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5757b
    public byte[] encode(byte[] bArr) {
        return m24433a(f20935d, bArr);
    }

    public C5801e(String str) {
        this.f20936a = str;
    }

    /* renamed from: b */
    public String m24437b() {
        return this.f20936a;
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5763h
    public String decode(String str) throws C5760e {
        if (str == null) {
            return null;
        }
        try {
            return m24436a(str, m24435a());
        } catch (UnsupportedEncodingException e2) {
            throw new C5760e(e2.getMessage(), e2);
        }
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5761f
    public Object encode(Object obj) throws C5762g {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        if (obj instanceof String) {
            return mo24152a((String) obj);
        }
        throw new C5762g("Objects of type " + obj.getClass().getName() + " cannot be URL encoded");
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5759d
    public Object decode(Object obj) throws C5760e {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new C5760e("Objects of type " + obj.getClass().getName() + " cannot be URL decoded");
    }

    /* renamed from: a */
    public static final byte[] m24434a(byte[] bArr) throws C5760e {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 < bArr.length) {
            byte b2 = bArr[i2];
            if (b2 == 43) {
                byteArrayOutputStream.write(32);
            } else if (b2 == 37) {
                int i3 = i2 + 1;
                try {
                    int m24439a = C5802f.m24439a(bArr[i3]);
                    i2 = i3 + 1;
                    byteArrayOutputStream.write((char) ((m24439a << 4) + C5802f.m24439a(bArr[i2])));
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new C5760e("Invalid URL encoding: ", e2);
                }
            } else {
                byteArrayOutputStream.write(b2);
            }
            i2++;
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5764i
    /* renamed from: a */
    public String mo24152a(String str) throws C5762g {
        if (str == null) {
            return null;
        }
        try {
            return m24438b(str, m24435a());
        } catch (UnsupportedEncodingException e2) {
            throw new C5762g(e2.getMessage(), e2);
        }
    }

    /* renamed from: a */
    public String m24436a(String str, String str2) throws C5760e, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return new String(decode(C5777l.m24210b(str)), str2);
    }

    /* renamed from: a */
    public String m24435a() {
        return this.f20936a;
    }
}
