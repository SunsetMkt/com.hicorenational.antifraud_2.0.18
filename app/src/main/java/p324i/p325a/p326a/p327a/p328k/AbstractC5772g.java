package p324i.p325a.p326a.p327a.p328k;

import p324i.p325a.p326a.p327a.C5760e;
import p324i.p325a.p326a.p327a.C5762g;
import p324i.p325a.p326a.p327a.InterfaceC5756a;
import p324i.p325a.p326a.p327a.InterfaceC5757b;

/* compiled from: BaseNCodec.java */
/* renamed from: i.a.a.a.k.g */
/* loaded from: classes2.dex */
public abstract class AbstractC5772g implements InterfaceC5757b, InterfaceC5756a {

    /* renamed from: l */
    public static final int f20786l = 76;

    /* renamed from: m */
    public static final int f20787m = 64;

    /* renamed from: n */
    private static final int f20788n = 2;

    /* renamed from: o */
    private static final int f20789o = 8192;

    /* renamed from: p */
    protected static final int f20790p = 255;

    /* renamed from: q */
    protected static final byte f20791q = 61;

    /* renamed from: a */
    protected final byte f20792a = f20791q;

    /* renamed from: b */
    private final int f20793b;

    /* renamed from: c */
    private final int f20794c;

    /* renamed from: d */
    protected final int f20795d;

    /* renamed from: e */
    private final int f20796e;

    /* renamed from: f */
    protected byte[] f20797f;

    /* renamed from: g */
    protected int f20798g;

    /* renamed from: h */
    private int f20799h;

    /* renamed from: i */
    protected boolean f20800i;

    /* renamed from: j */
    protected int f20801j;

    /* renamed from: k */
    protected int f20802k;

    protected AbstractC5772g(int i2, int i3, int i4, int i5) {
        this.f20793b = i2;
        this.f20794c = i3;
        this.f20795d = (i4 <= 0 || i5 <= 0) ? 0 : (i4 / i3) * i3;
        this.f20796e = i5;
    }

    /* renamed from: b */
    protected static boolean m24174b(byte b2) {
        return b2 == 9 || b2 == 10 || b2 == 13 || b2 == 32;
    }

    /* renamed from: d */
    private void m24175d() {
        this.f20797f = null;
        this.f20798g = 0;
        this.f20799h = 0;
        this.f20801j = 0;
        this.f20802k = 0;
        this.f20800i = false;
    }

    /* renamed from: e */
    private void m24176e() {
        byte[] bArr = this.f20797f;
        if (bArr == null) {
            this.f20797f = new byte[m24182b()];
            this.f20798g = 0;
            this.f20799h = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f20797f = bArr2;
        }
    }

    /* renamed from: a */
    int m24177a() {
        if (this.f20797f != null) {
            return this.f20798g - this.f20799h;
        }
        return 0;
    }

    /* renamed from: a */
    abstract void mo24153a(byte[] bArr, int i2, int i3);

    /* renamed from: a */
    protected abstract boolean mo24154a(byte b2);

    /* renamed from: b */
    protected int m24182b() {
        return 8192;
    }

    /* renamed from: b */
    public String m24183b(byte[] bArr) {
        return C5777l.m24217f(encode(bArr));
    }

    /* renamed from: b */
    abstract void mo24155b(byte[] bArr, int i2, int i3);

    /* renamed from: c */
    boolean m24187c() {
        return this.f20797f != null;
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5759d
    public Object decode(Object obj) throws C5760e {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return m24181a((String) obj);
        }
        throw new C5760e("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5761f
    public Object encode(Object obj) throws C5762g {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new C5762g("Parameter supplied to Base-N encode is not a byte[]");
    }

    /* renamed from: a */
    protected void m24178a(int i2) {
        byte[] bArr = this.f20797f;
        if (bArr == null || bArr.length < this.f20798g + i2) {
            m24176e();
        }
    }

    /* renamed from: b */
    public boolean m24184b(String str) {
        return m24180a(C5777l.m24218f(str), true);
    }

    /* renamed from: c */
    int m24185c(byte[] bArr, int i2, int i3) {
        if (this.f20797f == null) {
            return this.f20800i ? -1 : 0;
        }
        int min = Math.min(m24177a(), i3);
        System.arraycopy(this.f20797f, this.f20799h, bArr, i2, min);
        this.f20799h += min;
        if (this.f20799h >= this.f20798g) {
            this.f20797f = null;
        }
        return min;
    }

    /* renamed from: a */
    public byte[] m24181a(String str) {
        return decode(C5777l.m24218f(str));
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5757b
    public byte[] encode(byte[] bArr) {
        m24175d();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        mo24155b(bArr, 0, bArr.length);
        mo24155b(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f20798g - this.f20799h];
        m24185c(bArr2, 0, bArr2.length);
        return bArr2;
    }

    /* renamed from: a */
    public boolean m24180a(byte[] bArr, boolean z) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!mo24154a(bArr[i2]) && (!z || (bArr[i2] != 61 && !m24174b(bArr[i2])))) {
                return false;
            }
        }
        return true;
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5756a
    public byte[] decode(byte[] bArr) {
        m24175d();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        mo24153a(bArr, 0, bArr.length);
        mo24153a(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f20798g];
        m24185c(bArr2, 0, bArr2.length);
        return bArr2;
    }

    /* renamed from: a */
    protected boolean m24179a(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (61 == b2 || mo24154a(b2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public long m24188d(byte[] bArr) {
        int length = bArr.length;
        int i2 = this.f20793b;
        long j2 = (((length + i2) - 1) / i2) * this.f20794c;
        int i3 = this.f20795d;
        return i3 > 0 ? j2 + ((((i3 + j2) - 1) / i3) * this.f20796e) : j2;
    }

    /* renamed from: c */
    public String m24186c(byte[] bArr) {
        return C5777l.m24217f(encode(bArr));
    }
}
