package p324i.p325a.p326a.p327a.p328k;

import p324i.p325a.p326a.p327a.C5760e;
import p324i.p325a.p326a.p327a.C5762g;
import p324i.p325a.p326a.p327a.InterfaceC5756a;
import p324i.p325a.p326a.p327a.InterfaceC5757b;

/* compiled from: BinaryCodec.java */
/* renamed from: i.a.a.a.k.j */
/* loaded from: classes2.dex */
public class C5775j implements InterfaceC5756a, InterfaceC5757b {

    /* renamed from: c */
    private static final int f20811c = 1;

    /* renamed from: d */
    private static final int f20812d = 2;

    /* renamed from: e */
    private static final int f20813e = 4;

    /* renamed from: f */
    private static final int f20814f = 8;

    /* renamed from: g */
    private static final int f20815g = 16;

    /* renamed from: h */
    private static final int f20816h = 32;

    /* renamed from: i */
    private static final int f20817i = 64;

    /* renamed from: j */
    private static final int f20818j = 128;

    /* renamed from: a */
    private static final char[] f20809a = new char[0];

    /* renamed from: b */
    private static final byte[] f20810b = new byte[0];

    /* renamed from: k */
    private static final int[] f20819k = {1, 2, 4, 8, 16, 32, 64, 128};

    /* renamed from: b */
    private static boolean m24192b(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    /* renamed from: c */
    public static byte[] m24193c(byte[] bArr) {
        if (m24192b(bArr)) {
            return f20810b;
        }
        byte[] bArr2 = new byte[bArr.length << 3];
        int length = bArr2.length - 1;
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = 0;
            while (true) {
                int[] iArr = f20819k;
                if (i3 < iArr.length) {
                    if ((iArr[i3] & bArr[i2]) == 0) {
                        bArr2[length - i3] = 48;
                    } else {
                        bArr2[length - i3] = 49;
                    }
                    i3++;
                }
            }
            i2++;
            length -= 8;
        }
        return bArr2;
    }

    /* renamed from: d */
    public static char[] m24194d(byte[] bArr) {
        if (m24192b(bArr)) {
            return f20809a;
        }
        char[] cArr = new char[bArr.length << 3];
        int length = cArr.length - 1;
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = 0;
            while (true) {
                int[] iArr = f20819k;
                if (i3 < iArr.length) {
                    if ((iArr[i3] & bArr[i2]) == 0) {
                        cArr[length - i3] = '0';
                    } else {
                        cArr[length - i3] = '1';
                    }
                    i3++;
                }
            }
            i2++;
            length -= 8;
        }
        return cArr;
    }

    /* renamed from: e */
    public static String m24195e(byte[] bArr) {
        return new String(m24194d(bArr));
    }

    /* renamed from: a */
    public byte[] m24196a(String str) {
        return str == null ? f20810b : m24191a(str.toCharArray());
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5759d
    public Object decode(Object obj) throws C5760e {
        if (obj == null) {
            return f20810b;
        }
        if (obj instanceof byte[]) {
            return m24190a((byte[]) obj);
        }
        if (obj instanceof char[]) {
            return m24191a((char[]) obj);
        }
        if (obj instanceof String) {
            return m24191a(((String) obj).toCharArray());
        }
        throw new C5760e("argument not a byte array");
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5757b
    public byte[] encode(byte[] bArr) {
        return m24193c(bArr);
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5761f
    public Object encode(Object obj) throws C5762g {
        if (obj instanceof byte[]) {
            return m24194d((byte[]) obj);
        }
        throw new C5762g("argument not a byte array");
    }

    /* renamed from: a */
    public static byte[] m24191a(char[] cArr) {
        if (cArr != null && cArr.length != 0) {
            byte[] bArr = new byte[cArr.length >> 3];
            int length = cArr.length - 1;
            int i2 = 0;
            while (i2 < bArr.length) {
                int i3 = 0;
                while (true) {
                    int[] iArr = f20819k;
                    if (i3 < iArr.length) {
                        if (cArr[length - i3] == '1') {
                            bArr[i2] = (byte) (iArr[i3] | bArr[i2]);
                        }
                        i3++;
                    }
                }
                i2++;
                length -= 8;
            }
            return bArr;
        }
        return f20810b;
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5756a
    public byte[] decode(byte[] bArr) {
        return m24190a(bArr);
    }

    /* renamed from: a */
    public static byte[] m24190a(byte[] bArr) {
        if (m24192b(bArr)) {
            return f20810b;
        }
        byte[] bArr2 = new byte[bArr.length >> 3];
        int length = bArr.length - 1;
        int i2 = 0;
        while (i2 < bArr2.length) {
            int i3 = 0;
            while (true) {
                int[] iArr = f20819k;
                if (i3 < iArr.length) {
                    if (bArr[length - i3] == 49) {
                        bArr2[i2] = (byte) (iArr[i3] | bArr2[i2]);
                    }
                    i3++;
                }
            }
            i2++;
            length -= 8;
        }
        return bArr2;
    }
}
