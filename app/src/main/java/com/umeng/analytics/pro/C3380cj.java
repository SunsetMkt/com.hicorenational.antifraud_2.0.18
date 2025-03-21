package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import p286h.p309q2.p311t.C5558n;

/* compiled from: TCompactProtocol.java */
/* renamed from: com.umeng.analytics.pro.cj */
/* loaded from: classes2.dex */
public class C3380cj extends AbstractC3386cp {

    /* renamed from: d */
    private static final C3391cu f11803d = new C3391cu("");

    /* renamed from: e */
    private static final C3381ck f11804e = new C3381ck("", (byte) 0, 0);

    /* renamed from: f */
    private static final byte[] f11805f = new byte[16];

    /* renamed from: h */
    private static final byte f11806h = -126;

    /* renamed from: i */
    private static final byte f11807i = 1;

    /* renamed from: j */
    private static final byte f11808j = 31;

    /* renamed from: k */
    private static final byte f11809k = -32;

    /* renamed from: l */
    private static final int f11810l = 5;

    /* renamed from: a */
    byte[] f11811a;

    /* renamed from: b */
    byte[] f11812b;

    /* renamed from: c */
    byte[] f11813c;

    /* renamed from: m */
    private C3358bo f11814m;

    /* renamed from: n */
    private short f11815n;

    /* renamed from: o */
    private C3381ck f11816o;

    /* renamed from: p */
    private Boolean f11817p;

    /* renamed from: q */
    private final long f11818q;

    /* renamed from: r */
    private byte[] f11819r;

    /* compiled from: TCompactProtocol.java */
    /* renamed from: com.umeng.analytics.pro.cj$b */
    private static class b {

        /* renamed from: a */
        public static final byte f11821a = 1;

        /* renamed from: b */
        public static final byte f11822b = 2;

        /* renamed from: c */
        public static final byte f11823c = 3;

        /* renamed from: d */
        public static final byte f11824d = 4;

        /* renamed from: e */
        public static final byte f11825e = 5;

        /* renamed from: f */
        public static final byte f11826f = 6;

        /* renamed from: g */
        public static final byte f11827g = 7;

        /* renamed from: h */
        public static final byte f11828h = 8;

        /* renamed from: i */
        public static final byte f11829i = 9;

        /* renamed from: j */
        public static final byte f11830j = 10;

        /* renamed from: k */
        public static final byte f11831k = 11;

        /* renamed from: l */
        public static final byte f11832l = 12;

        private b() {
        }
    }

    static {
        byte[] bArr = f11805f;
        bArr[0] = 0;
        bArr[2] = 1;
        bArr[3] = 3;
        bArr[6] = 4;
        bArr[8] = 5;
        bArr[10] = 6;
        bArr[4] = 7;
        bArr[11] = 8;
        bArr[15] = 9;
        bArr[14] = 10;
        bArr[13] = 11;
        bArr[12] = 12;
    }

    public C3380cj(AbstractC3401dd abstractC3401dd, long j2) {
        super(abstractC3401dd);
        this.f11814m = new C3358bo(15);
        this.f11815n = (short) 0;
        this.f11816o = null;
        this.f11817p = null;
        this.f11811a = new byte[5];
        this.f11812b = new byte[10];
        this.f11819r = new byte[1];
        this.f11813c = new byte[1];
        this.f11818q = j2;
    }

    /* renamed from: E */
    private int m11155E() throws C3366bw {
        int i2 = 0;
        if (this.f11848g.mo11201h() >= 5) {
            byte[] mo11199f = this.f11848g.mo11199f();
            int mo11200g = this.f11848g.mo11200g();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                byte b2 = mo11199f[mo11200g + i2];
                i3 |= (b2 & C5558n.f20402b) << i4;
                if ((b2 & C5558n.f20401a) != 128) {
                    this.f11848g.mo11195a(i2 + 1);
                    return i3;
                }
                i4 += 7;
                i2++;
            }
        } else {
            int i5 = 0;
            while (true) {
                byte mo11148u = mo11148u();
                i2 |= (mo11148u & C5558n.f20402b) << i5;
                if ((mo11148u & C5558n.f20401a) != 128) {
                    return i2;
                }
                i5 += 7;
            }
        }
    }

    /* renamed from: F */
    private long m11156F() throws C3366bw {
        int i2 = 0;
        long j2 = 0;
        if (this.f11848g.mo11201h() >= 10) {
            byte[] mo11199f = this.f11848g.mo11199f();
            int mo11200g = this.f11848g.mo11200g();
            int i3 = 0;
            while (true) {
                j2 |= (r7 & C5558n.f20402b) << i3;
                if ((mo11199f[mo11200g + i2] & C5558n.f20401a) != 128) {
                    break;
                }
                i3 += 7;
                i2++;
            }
            this.f11848g.mo11195a(i2 + 1);
        } else {
            while (true) {
                j2 |= (r0 & C5558n.f20402b) << i2;
                if ((mo11148u() & C5558n.f20401a) != 128) {
                    break;
                }
                i2 += 7;
            }
        }
        return j2;
    }

    /* renamed from: c */
    private int m11164c(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    /* renamed from: c */
    private long m11165c(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    /* renamed from: c */
    private boolean m11166c(byte b2) {
        int i2 = b2 & C3393cw.f11873m;
        return i2 == 1 || i2 == 2;
    }

    /* renamed from: d */
    private long m11168d(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    /* renamed from: e */
    private byte[] m11171e(int i2) throws C3366bw {
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        this.f11848g.m11203d(bArr, 0, i2);
        return bArr;
    }

    /* renamed from: f */
    private void m11172f(int i2) throws C3387cq {
        if (i2 < 0) {
            throw new C3387cq("Negative length: " + i2);
        }
        long j2 = this.f11818q;
        if (j2 == -1 || i2 <= j2) {
            return;
        }
        throw new C3387cq("Length exceeded max allowed: " + i2);
    }

    /* renamed from: g */
    private int m11173g(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: A */
    public ByteBuffer mo11110A() throws C3366bw {
        int m11155E = m11155E();
        m11172f(m11155E);
        if (m11155E == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[m11155E];
        this.f11848g.m11203d(bArr, 0, m11155E);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: B */
    public void mo11174B() {
        this.f11814m.m11029c();
        this.f11815n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11111a() throws C3366bw {
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11119a(C3384cn c3384cn) throws C3366bw {
        m11161b(f11806h);
        m11169d(((c3384cn.f11842b << 5) & (-32)) | 1);
        m11162b(c3384cn.f11843c);
        mo11122a(c3384cn.f11841a);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: b */
    public void mo11127b() throws C3366bw {
        this.f11815n = this.f11814m.m11026a();
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: c */
    public void mo11128c() throws C3366bw {
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: d */
    public void mo11130d() throws C3366bw {
        m11161b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: e */
    public void mo11132e() throws C3366bw {
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: f */
    public void mo11133f() throws C3366bw {
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: g */
    public void mo11134g() throws C3366bw {
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: h */
    public C3384cn mo11135h() throws C3366bw {
        byte mo11148u = mo11148u();
        if (mo11148u != -126) {
            throw new C3387cq("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(mo11148u));
        }
        byte mo11148u2 = mo11148u();
        byte b2 = (byte) (mo11148u2 & f11808j);
        if (b2 == 1) {
            return new C3384cn(mo11153z(), (byte) ((mo11148u2 >> 5) & 3), m11155E());
        }
        throw new C3387cq("Expected version 1 but got " + ((int) b2));
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: i */
    public void mo11136i() throws C3366bw {
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: j */
    public C3391cu mo11137j() throws C3366bw {
        this.f11814m.m11027a(this.f11815n);
        this.f11815n = (short) 0;
        return f11803d;
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: k */
    public void mo11138k() throws C3366bw {
        this.f11815n = this.f11814m.m11026a();
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: l */
    public C3381ck mo11139l() throws C3366bw {
        byte mo11148u = mo11148u();
        if (mo11148u == 0) {
            return f11804e;
        }
        short s = (short) ((mo11148u & 240) >> 4);
        short mo11149v = s == 0 ? mo11149v() : (short) (this.f11815n + s);
        byte b2 = (byte) (mo11148u & C3393cw.f11873m);
        C3381ck c3381ck = new C3381ck("", m11167d(b2), mo11149v);
        if (m11166c(mo11148u)) {
            this.f11817p = b2 == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.f11815n = c3381ck.f11835c;
        return c3381ck;
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: m */
    public void mo11140m() throws C3366bw {
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: n */
    public C3383cm mo11141n() throws C3366bw {
        int m11155E = m11155E();
        byte mo11148u = m11155E == 0 ? (byte) 0 : mo11148u();
        return new C3383cm(m11167d((byte) (mo11148u >> 4)), m11167d((byte) (mo11148u & C3393cw.f11873m)), m11155E);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: o */
    public void mo11142o() throws C3366bw {
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: p */
    public C3382cl mo11143p() throws C3366bw {
        byte mo11148u = mo11148u();
        int i2 = (mo11148u >> 4) & 15;
        if (i2 == 15) {
            i2 = m11155E();
        }
        return new C3382cl(m11167d(mo11148u), i2);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: q */
    public void mo11144q() throws C3366bw {
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: r */
    public C3390ct mo11145r() throws C3366bw {
        return new C3390ct(mo11143p());
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: s */
    public void mo11146s() throws C3366bw {
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: t */
    public boolean mo11147t() throws C3366bw {
        Boolean bool = this.f11817p;
        if (bool == null) {
            return mo11148u() == 1;
        }
        boolean booleanValue = bool.booleanValue();
        this.f11817p = null;
        return booleanValue;
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: u */
    public byte mo11148u() throws C3366bw {
        if (this.f11848g.mo11201h() <= 0) {
            this.f11848g.m11203d(this.f11813c, 0, 1);
            return this.f11813c[0];
        }
        byte b2 = this.f11848g.mo11199f()[this.f11848g.mo11200g()];
        this.f11848g.mo11195a(1);
        return b2;
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: v */
    public short mo11149v() throws C3366bw {
        return (short) m11173g(m11155E());
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: w */
    public int mo11150w() throws C3366bw {
        return m11173g(m11155E());
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: x */
    public long mo11151x() throws C3366bw {
        return m11168d(m11156F());
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: y */
    public double mo11152y() throws C3366bw {
        byte[] bArr = new byte[8];
        this.f11848g.m11203d(bArr, 0, 8);
        return Double.longBitsToDouble(m11157a(bArr));
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: z */
    public String mo11153z() throws C3366bw {
        int m11155E = m11155E();
        m11172f(m11155E);
        if (m11155E == 0) {
            return "";
        }
        try {
            if (this.f11848g.mo11201h() < m11155E) {
                return new String(m11171e(m11155E), "UTF-8");
            }
            String str = new String(this.f11848g.mo11199f(), this.f11848g.mo11200g(), m11155E, "UTF-8");
            this.f11848g.mo11195a(m11155E);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new C3366bw("UTF-8 not supported!");
        }
    }

    /* compiled from: TCompactProtocol.java */
    /* renamed from: com.umeng.analytics.pro.cj$a */
    public static class a implements InterfaceC3388cr {

        /* renamed from: a */
        private final long f11820a;

        public a() {
            this.f11820a = -1L;
        }

        @Override // com.umeng.analytics.pro.InterfaceC3388cr
        /* renamed from: a */
        public AbstractC3386cp mo11154a(AbstractC3401dd abstractC3401dd) {
            return new C3380cj(abstractC3401dd, this.f11820a);
        }

        public a(int i2) {
            this.f11820a = i2;
        }
    }

    /* renamed from: b */
    private void m11162b(int i2) throws C3366bw {
        int i3 = 0;
        while ((i2 & (-128)) != 0) {
            this.f11811a[i3] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i3++;
        }
        byte[] bArr = this.f11811a;
        bArr[i3] = (byte) i2;
        this.f11848g.mo11192b(bArr, 0, i3 + 1);
    }

    /* renamed from: d */
    private void m11169d(int i2) throws C3366bw {
        m11161b((byte) i2);
    }

    /* renamed from: d */
    private byte m11167d(byte b2) throws C3387cq {
        byte b3 = (byte) (b2 & C3393cw.f11873m);
        switch (b3) {
            case 0:
                return (byte) 0;
            case 1:
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 6;
            case 5:
                return (byte) 8;
            case 6:
                return (byte) 10;
            case 7:
                return (byte) 4;
            case 8:
                return (byte) 11;
            case 9:
                return C3393cw.f11873m;
            case 10:
                return C3393cw.f11872l;
            case 11:
                return C3393cw.f11871k;
            case 12:
                return (byte) 12;
            default:
                throw new C3387cq("don't know what type: " + ((int) b3));
        }
    }

    /* renamed from: e */
    private byte m11170e(byte b2) {
        return f11805f[b2];
    }

    /* renamed from: b */
    private void m11163b(long j2) throws C3366bw {
        int i2 = 0;
        while (((-128) & j2) != 0) {
            this.f11812b[i2] = (byte) ((127 & j2) | 128);
            j2 >>>= 7;
            i2++;
        }
        byte[] bArr = this.f11812b;
        bArr[i2] = (byte) j2;
        this.f11848g.mo11192b(bArr, 0, i2 + 1);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11121a(C3391cu c3391cu) throws C3366bw {
        this.f11814m.m11027a(this.f11815n);
        this.f11815n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11116a(C3381ck c3381ck) throws C3366bw {
        if (c3381ck.f11834b == 2) {
            this.f11816o = c3381ck;
        } else {
            m11159a(c3381ck, (byte) -1);
        }
    }

    /* renamed from: b */
    private void m11161b(byte b2) throws C3366bw {
        byte[] bArr = this.f11819r;
        bArr[0] = b2;
        this.f11848g.m11202b(bArr);
    }

    /* renamed from: a */
    private void m11159a(C3381ck c3381ck, byte b2) throws C3366bw {
        if (b2 == -1) {
            b2 = m11170e(c3381ck.f11834b);
        }
        short s = c3381ck.f11835c;
        short s2 = this.f11815n;
        if (s > s2 && s - s2 <= 15) {
            m11169d(b2 | ((s - s2) << 4));
        } else {
            m11161b(b2);
            mo11124a(c3381ck.f11835c);
        }
        this.f11815n = c3381ck.f11835c;
    }

    public C3380cj(AbstractC3401dd abstractC3401dd) {
        this(abstractC3401dd, -1L);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11118a(C3383cm c3383cm) throws C3366bw {
        int i2 = c3383cm.f11840c;
        if (i2 == 0) {
            m11169d(0);
            return;
        }
        m11162b(i2);
        m11169d(m11170e(c3383cm.f11839b) | (m11170e(c3383cm.f11838a) << 4));
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11117a(C3382cl c3382cl) throws C3366bw {
        m11175a(c3382cl.f11836a, c3382cl.f11837b);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11120a(C3390ct c3390ct) throws C3366bw {
        m11175a(c3390ct.f11858a, c3390ct.f11859b);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11125a(boolean z) throws C3366bw {
        C3381ck c3381ck = this.f11816o;
        if (c3381ck != null) {
            m11159a(c3381ck, z ? (byte) 1 : (byte) 2);
            this.f11816o = null;
        } else {
            m11161b(z ? (byte) 1 : (byte) 2);
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11112a(byte b2) throws C3366bw {
        m11161b(b2);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11124a(short s) throws C3366bw {
        m11162b(m11164c((int) s));
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11114a(int i2) throws C3366bw {
        m11162b(m11164c(i2));
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11115a(long j2) throws C3366bw {
        m11163b(m11165c(j2));
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11113a(double d2) throws C3366bw {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        m11158a(Double.doubleToLongBits(d2), bArr, 0);
        this.f11848g.m11202b(bArr);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11122a(String str) throws C3366bw {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            m11160a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new C3366bw("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11123a(ByteBuffer byteBuffer) throws C3366bw {
        m11160a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    /* renamed from: a */
    private void m11160a(byte[] bArr, int i2, int i3) throws C3366bw {
        m11162b(i3);
        this.f11848g.mo11192b(bArr, i2, i3);
    }

    /* renamed from: a */
    protected void m11175a(byte b2, int i2) throws C3366bw {
        if (i2 <= 14) {
            m11169d(m11170e(b2) | (i2 << 4));
        } else {
            m11169d(m11170e(b2) | 240);
            m11162b(i2);
        }
    }

    /* renamed from: a */
    private void m11158a(long j2, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) (j2 & 255);
        bArr[i2 + 1] = (byte) ((j2 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((j2 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((j2 >> 24) & 255);
        bArr[i2 + 4] = (byte) ((j2 >> 32) & 255);
        bArr[i2 + 5] = (byte) ((j2 >> 40) & 255);
        bArr[i2 + 6] = (byte) ((j2 >> 48) & 255);
        bArr[i2 + 7] = (byte) ((j2 >> 56) & 255);
    }

    /* renamed from: a */
    private long m11157a(byte[] bArr) {
        return ((bArr[7] & 255) << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8) | (255 & bArr[0]);
    }
}
