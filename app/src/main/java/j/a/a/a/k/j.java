package j.a.a.a.k;

/* JADX INFO: compiled from: BinaryCodec.java */
/* JADX INFO: loaded from: classes2.dex */
public class j implements j.a.a.a.a, j.a.a.a.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f12463c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f12464d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f12465e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f12466f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f12467g = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f12468h = 32;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f12469i = 64;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f12470j = 128;
    private static final char[] a = new char[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f12462b = new byte[0];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f12471k = {1, 2, 4, 8, 16, 32, 64, 128};

    private static boolean b(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static byte[] c(byte[] bArr) {
        if (b(bArr)) {
            return f12462b;
        }
        byte[] bArr2 = new byte[bArr.length << 3];
        int length = bArr2.length - 1;
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = 0;
            while (true) {
                int[] iArr = f12471k;
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

    public static char[] d(byte[] bArr) {
        if (b(bArr)) {
            return a;
        }
        char[] cArr = new char[bArr.length << 3];
        int length = cArr.length - 1;
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = 0;
            while (true) {
                int[] iArr = f12471k;
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

    public static String e(byte[] bArr) {
        return new String(d(bArr));
    }

    public byte[] a(String str) {
        return str == null ? f12462b : a(str.toCharArray());
    }

    @Override // j.a.a.a.d
    public Object decode(Object obj) throws j.a.a.a.e {
        if (obj == null) {
            return f12462b;
        }
        if (obj instanceof byte[]) {
            return a((byte[]) obj);
        }
        if (obj instanceof char[]) {
            return a((char[]) obj);
        }
        if (obj instanceof String) {
            return a(((String) obj).toCharArray());
        }
        throw new j.a.a.a.e("argument not a byte array");
    }

    @Override // j.a.a.a.b
    public byte[] encode(byte[] bArr) {
        return c(bArr);
    }

    @Override // j.a.a.a.f
    public Object encode(Object obj) throws j.a.a.a.g {
        if (obj instanceof byte[]) {
            return d((byte[]) obj);
        }
        throw new j.a.a.a.g("argument not a byte array");
    }

    public static byte[] a(char[] cArr) {
        if (cArr != null && cArr.length != 0) {
            byte[] bArr = new byte[cArr.length >> 3];
            int length = cArr.length - 1;
            int i2 = 0;
            while (i2 < bArr.length) {
                int i3 = 0;
                while (true) {
                    int[] iArr = f12471k;
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
        return f12462b;
    }

    @Override // j.a.a.a.a
    public byte[] decode(byte[] bArr) {
        return a(bArr);
    }

    public static byte[] a(byte[] bArr) {
        if (b(bArr)) {
            return f12462b;
        }
        byte[] bArr2 = new byte[bArr.length >> 3];
        int length = bArr.length - 1;
        int i2 = 0;
        while (i2 < bArr2.length) {
            int i3 = 0;
            while (true) {
                int[] iArr = f12471k;
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
