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

/* compiled from: QuotedPrintableCodec.java */
/* renamed from: i.a.a.a.n.c */
/* loaded from: classes2.dex */
public class C5799c implements InterfaceC5757b, InterfaceC5756a, InterfaceC5764i, InterfaceC5763h {

    /* renamed from: b */
    private static final BitSet f20925b = new BitSet(256);

    /* renamed from: c */
    private static final byte f20926c = 61;

    /* renamed from: d */
    private static final byte f20927d = 9;

    /* renamed from: e */
    private static final byte f20928e = 32;

    /* renamed from: a */
    private final String f20929a;

    static {
        for (int i2 = 33; i2 <= 60; i2++) {
            f20925b.set(i2);
        }
        for (int i3 = 62; i3 <= 126; i3++) {
            f20925b.set(i3);
        }
        f20925b.set(9);
        f20925b.set(32);
    }

    public C5799c() {
        this("UTF-8");
    }

    /* renamed from: a */
    private static final void m24425a(int i2, ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.write(61);
        char upperCase = Character.toUpperCase(Character.forDigit((i2 >> 4) & 15, 16));
        char upperCase2 = Character.toUpperCase(Character.forDigit(i2 & 15, 16));
        byteArrayOutputStream.write(upperCase);
        byteArrayOutputStream.write(upperCase2);
    }

    /* renamed from: b */
    public String m24430b(String str, String str2) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return C5777l.m24209b(encode(str.getBytes(str2)));
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5756a
    public byte[] decode(byte[] bArr) throws C5760e {
        return m24427a(bArr);
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5757b
    public byte[] encode(byte[] bArr) {
        return m24426a(f20925b, bArr);
    }

    public C5799c(String str) {
        this.f20929a = str;
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5763h
    public String decode(String str) throws C5760e {
        if (str == null) {
            return null;
        }
        try {
            return m24429a(str, m24428a());
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
        throw new C5762g("Objects of type " + obj.getClass().getName() + " cannot be quoted-printable encoded");
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
        throw new C5760e("Objects of type " + obj.getClass().getName() + " cannot be quoted-printable decoded");
    }

    /* renamed from: a */
    public static final byte[] m24426a(BitSet bitSet, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bitSet == null) {
            bitSet = f20925b;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = bArr[i2];
            if (i3 < 0) {
                i3 += 256;
            }
            if (bitSet.get(i3)) {
                byteArrayOutputStream.write(i3);
            } else {
                m24425a(i3, byteArrayOutputStream);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    public static final byte[] m24427a(byte[] bArr) throws C5760e {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 < bArr.length) {
            byte b2 = bArr[i2];
            if (b2 == 61) {
                int i3 = i2 + 1;
                try {
                    int m24439a = C5802f.m24439a(bArr[i3]);
                    i2 = i3 + 1;
                    byteArrayOutputStream.write((char) ((m24439a << 4) + C5802f.m24439a(bArr[i2])));
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new C5760e("Invalid quoted-printable encoding", e2);
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
            return m24430b(str, m24428a());
        } catch (UnsupportedEncodingException e2) {
            throw new C5762g(e2.getMessage(), e2);
        }
    }

    /* renamed from: a */
    public String m24429a(String str, String str2) throws C5760e, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return new String(decode(C5777l.m24210b(str)), str2);
    }

    /* renamed from: a */
    public String m24428a() {
        return this.f20929a;
    }
}
