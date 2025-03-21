package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import p286h.C5230f1;

/* compiled from: TBinaryProtocol.java */
/* renamed from: com.umeng.analytics.pro.ci */
/* loaded from: classes2.dex */
public class C3379ci extends AbstractC3386cp {

    /* renamed from: a */
    protected static final int f11785a = -65536;

    /* renamed from: b */
    protected static final int f11786b = -2147418112;

    /* renamed from: h */
    private static final C3391cu f11787h = new C3391cu();

    /* renamed from: c */
    protected boolean f11788c;

    /* renamed from: d */
    protected boolean f11789d;

    /* renamed from: e */
    protected int f11790e;

    /* renamed from: f */
    protected boolean f11791f;

    /* renamed from: i */
    private byte[] f11792i;

    /* renamed from: j */
    private byte[] f11793j;

    /* renamed from: k */
    private byte[] f11794k;

    /* renamed from: l */
    private byte[] f11795l;

    /* renamed from: m */
    private byte[] f11796m;

    /* renamed from: n */
    private byte[] f11797n;

    /* renamed from: o */
    private byte[] f11798o;

    /* renamed from: p */
    private byte[] f11799p;

    /* compiled from: TBinaryProtocol.java */
    /* renamed from: com.umeng.analytics.pro.ci$a */
    public static class a implements InterfaceC3388cr {

        /* renamed from: a */
        protected boolean f11800a;

        /* renamed from: b */
        protected boolean f11801b;

        /* renamed from: c */
        protected int f11802c;

        public a() {
            this(false, true);
        }

        @Override // com.umeng.analytics.pro.InterfaceC3388cr
        /* renamed from: a */
        public AbstractC3386cp mo11154a(AbstractC3401dd abstractC3401dd) {
            C3379ci c3379ci = new C3379ci(abstractC3401dd, this.f11800a, this.f11801b);
            int i2 = this.f11802c;
            if (i2 != 0) {
                c3379ci.m11129c(i2);
            }
            return c3379ci;
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i2) {
            this.f11800a = false;
            this.f11801b = true;
            this.f11800a = z;
            this.f11801b = z2;
            this.f11802c = i2;
        }
    }

    public C3379ci(AbstractC3401dd abstractC3401dd) {
        this(abstractC3401dd, false, true);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: A */
    public ByteBuffer mo11110A() throws C3366bw {
        int mo11150w = mo11150w();
        m11131d(mo11150w);
        if (this.f11848g.mo11201h() >= mo11150w) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f11848g.mo11199f(), this.f11848g.mo11200g(), mo11150w);
            this.f11848g.mo11195a(mo11150w);
            return wrap;
        }
        byte[] bArr = new byte[mo11150w];
        this.f11848g.m11203d(bArr, 0, mo11150w);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11111a() {
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11119a(C3384cn c3384cn) throws C3366bw {
        if (this.f11789d) {
            mo11114a(f11786b | c3384cn.f11842b);
            mo11122a(c3384cn.f11841a);
            mo11114a(c3384cn.f11843c);
        } else {
            mo11122a(c3384cn.f11841a);
            mo11112a(c3384cn.f11842b);
            mo11114a(c3384cn.f11843c);
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11121a(C3391cu c3391cu) {
    }

    /* renamed from: b */
    public String m11126b(int i2) throws C3366bw {
        try {
            m11131d(i2);
            byte[] bArr = new byte[i2];
            this.f11848g.m11203d(bArr, 0, i2);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new C3366bw("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: b */
    public void mo11127b() {
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: c */
    public void mo11128c() {
    }

    /* renamed from: c */
    public void m11129c(int i2) {
        this.f11790e = i2;
        this.f11791f = true;
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: d */
    public void mo11130d() throws C3366bw {
        mo11112a((byte) 0);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: e */
    public void mo11132e() {
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: f */
    public void mo11133f() {
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: g */
    public void mo11134g() {
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: h */
    public C3384cn mo11135h() throws C3366bw {
        int mo11150w = mo11150w();
        if (mo11150w < 0) {
            if (((-65536) & mo11150w) == f11786b) {
                return new C3384cn(mo11153z(), (byte) (mo11150w & 255), mo11150w());
            }
            throw new C3387cq(4, "Bad version in readMessageBegin");
        }
        if (this.f11788c) {
            throw new C3387cq(4, "Missing version in readMessageBegin, old client?");
        }
        return new C3384cn(m11126b(mo11150w), mo11148u(), mo11150w());
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: i */
    public void mo11136i() {
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: j */
    public C3391cu mo11137j() {
        return f11787h;
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: k */
    public void mo11138k() {
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: l */
    public C3381ck mo11139l() throws C3366bw {
        byte mo11148u = mo11148u();
        return new C3381ck("", mo11148u, mo11148u == 0 ? (short) 0 : mo11149v());
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: m */
    public void mo11140m() {
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: n */
    public C3383cm mo11141n() throws C3366bw {
        return new C3383cm(mo11148u(), mo11148u(), mo11150w());
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: o */
    public void mo11142o() {
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: p */
    public C3382cl mo11143p() throws C3366bw {
        return new C3382cl(mo11148u(), mo11150w());
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: q */
    public void mo11144q() {
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: r */
    public C3390ct mo11145r() throws C3366bw {
        return new C3390ct(mo11148u(), mo11150w());
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: s */
    public void mo11146s() {
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: t */
    public boolean mo11147t() throws C3366bw {
        return mo11148u() == 1;
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: u */
    public byte mo11148u() throws C3366bw {
        if (this.f11848g.mo11201h() < 1) {
            m11109a(this.f11796m, 0, 1);
            return this.f11796m[0];
        }
        byte b2 = this.f11848g.mo11199f()[this.f11848g.mo11200g()];
        this.f11848g.mo11195a(1);
        return b2;
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: v */
    public short mo11149v() throws C3366bw {
        byte[] bArr = this.f11797n;
        int i2 = 0;
        if (this.f11848g.mo11201h() >= 2) {
            bArr = this.f11848g.mo11199f();
            i2 = this.f11848g.mo11200g();
            this.f11848g.mo11195a(2);
        } else {
            m11109a(this.f11797n, 0, 2);
        }
        return (short) ((bArr[i2 + 1] & C5230f1.f20085c) | ((bArr[i2] & C5230f1.f20085c) << 8));
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: w */
    public int mo11150w() throws C3366bw {
        byte[] bArr = this.f11798o;
        int i2 = 0;
        if (this.f11848g.mo11201h() >= 4) {
            bArr = this.f11848g.mo11199f();
            i2 = this.f11848g.mo11200g();
            this.f11848g.mo11195a(4);
        } else {
            m11109a(this.f11798o, 0, 4);
        }
        return (bArr[i2 + 3] & C5230f1.f20085c) | ((bArr[i2] & C5230f1.f20085c) << 24) | ((bArr[i2 + 1] & C5230f1.f20085c) << 16) | ((bArr[i2 + 2] & C5230f1.f20085c) << 8);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: x */
    public long mo11151x() throws C3366bw {
        byte[] bArr = this.f11799p;
        int i2 = 0;
        if (this.f11848g.mo11201h() >= 8) {
            bArr = this.f11848g.mo11199f();
            i2 = this.f11848g.mo11200g();
            this.f11848g.mo11195a(8);
        } else {
            m11109a(this.f11799p, 0, 8);
        }
        return (bArr[i2 + 7] & C5230f1.f20085c) | ((bArr[i2] & C5230f1.f20085c) << 56) | ((bArr[i2 + 1] & C5230f1.f20085c) << 48) | ((bArr[i2 + 2] & C5230f1.f20085c) << 40) | ((bArr[i2 + 3] & C5230f1.f20085c) << 32) | ((bArr[i2 + 4] & C5230f1.f20085c) << 24) | ((bArr[i2 + 5] & C5230f1.f20085c) << 16) | ((bArr[i2 + 6] & C5230f1.f20085c) << 8);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: y */
    public double mo11152y() throws C3366bw {
        return Double.longBitsToDouble(mo11151x());
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: z */
    public String mo11153z() throws C3366bw {
        int mo11150w = mo11150w();
        if (this.f11848g.mo11201h() < mo11150w) {
            return m11126b(mo11150w);
        }
        try {
            String str = new String(this.f11848g.mo11199f(), this.f11848g.mo11200g(), mo11150w, "UTF-8");
            this.f11848g.mo11195a(mo11150w);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new C3366bw("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public C3379ci(AbstractC3401dd abstractC3401dd, boolean z, boolean z2) {
        super(abstractC3401dd);
        this.f11788c = false;
        this.f11789d = true;
        this.f11791f = false;
        this.f11792i = new byte[1];
        this.f11793j = new byte[2];
        this.f11794k = new byte[4];
        this.f11795l = new byte[8];
        this.f11796m = new byte[1];
        this.f11797n = new byte[2];
        this.f11798o = new byte[4];
        this.f11799p = new byte[8];
        this.f11788c = z;
        this.f11789d = z2;
    }

    /* renamed from: d */
    protected void m11131d(int i2) throws C3366bw {
        if (i2 < 0) {
            throw new C3387cq("Negative length: " + i2);
        }
        if (this.f11791f) {
            this.f11790e -= i2;
            if (this.f11790e >= 0) {
                return;
            }
            throw new C3387cq("Message length exceeded: " + i2);
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11116a(C3381ck c3381ck) throws C3366bw {
        mo11112a(c3381ck.f11834b);
        mo11124a(c3381ck.f11835c);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11118a(C3383cm c3383cm) throws C3366bw {
        mo11112a(c3383cm.f11838a);
        mo11112a(c3383cm.f11839b);
        mo11114a(c3383cm.f11840c);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11117a(C3382cl c3382cl) throws C3366bw {
        mo11112a(c3382cl.f11836a);
        mo11114a(c3382cl.f11837b);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11120a(C3390ct c3390ct) throws C3366bw {
        mo11112a(c3390ct.f11858a);
        mo11114a(c3390ct.f11859b);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11125a(boolean z) throws C3366bw {
        mo11112a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11112a(byte b2) throws C3366bw {
        byte[] bArr = this.f11792i;
        bArr[0] = b2;
        this.f11848g.mo11192b(bArr, 0, 1);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11124a(short s) throws C3366bw {
        byte[] bArr = this.f11793j;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.f11848g.mo11192b(bArr, 0, 2);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11114a(int i2) throws C3366bw {
        byte[] bArr = this.f11794k;
        bArr[0] = (byte) ((i2 >> 24) & 255);
        bArr[1] = (byte) ((i2 >> 16) & 255);
        bArr[2] = (byte) ((i2 >> 8) & 255);
        bArr[3] = (byte) (i2 & 255);
        this.f11848g.mo11192b(bArr, 0, 4);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11115a(long j2) throws C3366bw {
        byte[] bArr = this.f11795l;
        bArr[0] = (byte) ((j2 >> 56) & 255);
        bArr[1] = (byte) ((j2 >> 48) & 255);
        bArr[2] = (byte) ((j2 >> 40) & 255);
        bArr[3] = (byte) ((j2 >> 32) & 255);
        bArr[4] = (byte) ((j2 >> 24) & 255);
        bArr[5] = (byte) ((j2 >> 16) & 255);
        bArr[6] = (byte) ((j2 >> 8) & 255);
        bArr[7] = (byte) (j2 & 255);
        this.f11848g.mo11192b(bArr, 0, 8);
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11113a(double d2) throws C3366bw {
        mo11115a(Double.doubleToLongBits(d2));
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11122a(String str) throws C3366bw {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            mo11114a(bytes.length);
            this.f11848g.mo11192b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new C3366bw("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.AbstractC3386cp
    /* renamed from: a */
    public void mo11123a(ByteBuffer byteBuffer) throws C3366bw {
        int limit = byteBuffer.limit() - byteBuffer.position();
        mo11114a(limit);
        this.f11848g.mo11192b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    /* renamed from: a */
    private int m11109a(byte[] bArr, int i2, int i3) throws C3366bw {
        m11131d(i3);
        return this.f11848g.m11203d(bArr, i2, i3);
    }
}
