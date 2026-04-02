package j.a.a.a.k;

/* JADX INFO: compiled from: BaseNCodec.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class g implements j.a.a.a.b, j.a.a.a.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f12445l = 76;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f12446m = 64;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f12447n = 2;
    private static final int o = 8192;
    protected static final int p = 255;
    protected static final byte q = 61;
    protected final byte a = q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f12449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final int f12450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f12451e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected byte[] f12452f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f12453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f12454h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected boolean f12455i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f12456j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f12457k;

    protected g(int i2, int i3, int i4, int i5) {
        this.f12448b = i2;
        this.f12449c = i3;
        this.f12450d = (i4 <= 0 || i5 <= 0) ? 0 : (i4 / i3) * i3;
        this.f12451e = i5;
    }

    protected static boolean b(byte b2) {
        return b2 == 9 || b2 == 10 || b2 == 13 || b2 == 32;
    }

    private void d() {
        this.f12452f = null;
        this.f12453g = 0;
        this.f12454h = 0;
        this.f12456j = 0;
        this.f12457k = 0;
        this.f12455i = false;
    }

    private void e() {
        byte[] bArr = this.f12452f;
        if (bArr == null) {
            this.f12452f = new byte[b()];
            this.f12453g = 0;
            this.f12454h = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f12452f = bArr2;
        }
    }

    int a() {
        if (this.f12452f != null) {
            return this.f12453g - this.f12454h;
        }
        return 0;
    }

    abstract void a(byte[] bArr, int i2, int i3);

    protected abstract boolean a(byte b2);

    protected int b() {
        return 8192;
    }

    public String b(byte[] bArr) {
        return l.f(encode(bArr));
    }

    abstract void b(byte[] bArr, int i2, int i3);

    boolean c() {
        return this.f12452f != null;
    }

    @Override // j.a.a.a.d
    public Object decode(Object obj) throws j.a.a.a.e {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return a((String) obj);
        }
        throw new j.a.a.a.e("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    @Override // j.a.a.a.f
    public Object encode(Object obj) throws j.a.a.a.g {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new j.a.a.a.g("Parameter supplied to Base-N encode is not a byte[]");
    }

    protected void a(int i2) {
        byte[] bArr = this.f12452f;
        if (bArr == null || bArr.length < this.f12453g + i2) {
            e();
        }
    }

    public boolean b(String str) {
        return a(l.f(str), true);
    }

    int c(byte[] bArr, int i2, int i3) {
        if (this.f12452f == null) {
            return this.f12455i ? -1 : 0;
        }
        int iMin = Math.min(a(), i3);
        System.arraycopy(this.f12452f, this.f12454h, bArr, i2, iMin);
        this.f12454h += iMin;
        if (this.f12454h >= this.f12453g) {
            this.f12452f = null;
        }
        return iMin;
    }

    public byte[] a(String str) {
        return decode(l.f(str));
    }

    @Override // j.a.a.a.b
    public byte[] encode(byte[] bArr) {
        d();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        b(bArr, 0, bArr.length);
        b(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f12453g - this.f12454h];
        c(bArr2, 0, bArr2.length);
        return bArr2;
    }

    public boolean a(byte[] bArr, boolean z) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!a(bArr[i2]) && (!z || (bArr[i2] != 61 && !b(bArr[i2])))) {
                return false;
            }
        }
        return true;
    }

    @Override // j.a.a.a.a
    public byte[] decode(byte[] bArr) {
        d();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a(bArr, 0, bArr.length);
        a(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f12453g];
        c(bArr2, 0, bArr2.length);
        return bArr2;
    }

    protected boolean a(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (61 == b2 || a(b2)) {
                return true;
            }
        }
        return false;
    }

    public long d(byte[] bArr) {
        int length = bArr.length;
        long j2 = ((long) (((length + r0) - 1) / this.f12448b)) * ((long) this.f12449c);
        int i2 = this.f12450d;
        return i2 > 0 ? j2 + ((((((long) i2) + j2) - 1) / ((long) i2)) * ((long) this.f12451e)) : j2;
    }

    public String c(byte[] bArr) {
        return l.f(encode(bArr));
    }
}
