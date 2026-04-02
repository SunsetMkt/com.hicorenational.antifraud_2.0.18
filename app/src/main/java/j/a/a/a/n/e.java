package j.a.a.a.n;

import j.a.a.a.g;
import j.a.a.a.h;
import j.a.a.a.i;
import j.a.a.a.k.l;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;

/* JADX INFO: compiled from: URLCodec.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements j.a.a.a.b, j.a.a.a.a, i, h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int f12548b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final byte f12549c = 37;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final BitSet f12550d = new BitSet(256);
    protected String a;

    static {
        for (int i2 = 97; i2 <= 122; i2++) {
            f12550d.set(i2);
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            f12550d.set(i3);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            f12550d.set(i4);
        }
        f12550d.set(45);
        f12550d.set(95);
        f12550d.set(46);
        f12550d.set(42);
        f12550d.set(32);
    }

    public e() {
        this("UTF-8");
    }

    public static final byte[] a(BitSet bitSet, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bitSet == null) {
            bitSet = f12550d;
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

    public String b(String str, String str2) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return l.b(encode(str.getBytes(str2)));
    }

    @Override // j.a.a.a.a
    public byte[] decode(byte[] bArr) throws j.a.a.a.e {
        return a(bArr);
    }

    @Override // j.a.a.a.b
    public byte[] encode(byte[] bArr) {
        return a(f12550d, bArr);
    }

    public e(String str) {
        this.a = str;
    }

    public String b() {
        return this.a;
    }

    @Override // j.a.a.a.h
    public String decode(String str) throws j.a.a.a.e {
        if (str == null) {
            return null;
        }
        try {
            return a(str, a());
        } catch (UnsupportedEncodingException e2) {
            throw new j.a.a.a.e(e2.getMessage(), e2);
        }
    }

    @Override // j.a.a.a.f
    public Object encode(Object obj) throws g {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        if (obj instanceof String) {
            return a((String) obj);
        }
        throw new g("Objects of type " + obj.getClass().getName() + " cannot be URL encoded");
    }

    @Override // j.a.a.a.d
    public Object decode(Object obj) throws j.a.a.a.e {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new j.a.a.a.e("Objects of type " + obj.getClass().getName() + " cannot be URL decoded");
    }

    public static final byte[] a(byte[] bArr) throws j.a.a.a.e {
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
                    int iA = f.a(bArr[i3]);
                    i2 = i3 + 1;
                    byteArrayOutputStream.write((char) ((iA << 4) + f.a(bArr[i2])));
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new j.a.a.a.e("Invalid URL encoding: ", e2);
                }
            } else {
                byteArrayOutputStream.write(b2);
            }
            i2++;
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // j.a.a.a.i
    public String a(String str) throws g {
        if (str == null) {
            return null;
        }
        try {
            return b(str, a());
        } catch (UnsupportedEncodingException e2) {
            throw new g(e2.getMessage(), e2);
        }
    }

    public String a(String str, String str2) throws UnsupportedEncodingException, j.a.a.a.e {
        if (str == null) {
            return null;
        }
        return new String(decode(l.b(str)), str2);
    }

    public String a() {
        return this.a;
    }
}
