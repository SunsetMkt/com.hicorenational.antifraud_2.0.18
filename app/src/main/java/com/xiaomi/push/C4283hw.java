package com.xiaomi.push;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import p286h.C5230f1;

/* renamed from: com.xiaomi.push.hw */
/* loaded from: classes2.dex */
public class C4283hw extends AbstractC4288ia {

    /* renamed from: a */
    private static final C4293if f16315a = new C4293if();

    /* renamed from: a */
    protected int f16316a;

    /* renamed from: a */
    protected boolean f16317a;

    /* renamed from: a */
    private byte[] f16318a;

    /* renamed from: b */
    protected boolean f16319b;

    /* renamed from: b */
    private byte[] f16320b;

    /* renamed from: c */
    protected boolean f16321c;

    /* renamed from: c */
    private byte[] f16322c;

    /* renamed from: d */
    private byte[] f16323d;

    /* renamed from: e */
    private byte[] f16324e;

    /* renamed from: f */
    private byte[] f16325f;

    /* renamed from: g */
    private byte[] f16326g;

    /* renamed from: h */
    private byte[] f16327h;

    /* renamed from: com.xiaomi.push.hw$a */
    public static class a implements InterfaceC4290ic {

        /* renamed from: a */
        protected int f16328a;

        /* renamed from: a */
        protected boolean f16329a;

        /* renamed from: b */
        protected boolean f16330b;

        public a() {
            this(false, true);
        }

        @Override // com.xiaomi.push.InterfaceC4290ic
        /* renamed from: a */
        public AbstractC4288ia mo15627a(AbstractC4298ik abstractC4298ik) {
            C4283hw c4283hw = new C4283hw(abstractC4298ik, this.f16329a, this.f16330b);
            int i2 = this.f16328a;
            if (i2 != 0) {
                c4283hw.m15617b(i2);
            }
            return c4283hw;
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i2) {
            this.f16329a = false;
            this.f16330b = true;
            this.f16329a = z;
            this.f16330b = z2;
            this.f16328a = i2;
        }
    }

    public C4283hw(AbstractC4298ik abstractC4298ik, boolean z, boolean z2) {
        super(abstractC4298ik);
        this.f16317a = false;
        this.f16319b = true;
        this.f16321c = false;
        this.f16318a = new byte[1];
        this.f16320b = new byte[2];
        this.f16322c = new byte[4];
        this.f16323d = new byte[8];
        this.f16324e = new byte[1];
        this.f16325f = new byte[2];
        this.f16326g = new byte[4];
        this.f16327h = new byte[8];
        this.f16317a = z;
        this.f16319b = z2;
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public void mo15603a() {
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public void mo15607a(C4284hx c4284hx) {
        mo15604a(c4284hx.f16331a);
        mo15613a(c4284hx.f16333a);
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public void mo15610a(C4293if c4293if) {
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: b */
    public void mo15616b() {
    }

    /* renamed from: b */
    public void m15617b(int i2) {
        this.f16316a = i2;
        this.f16321c = true;
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: c */
    public void mo15618c() {
        mo15604a((byte) 0);
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: d */
    public void mo15620d() {
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: e */
    public void mo15621e() {
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: f */
    public void mo15622f() {
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: g */
    public void mo15623g() {
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: h */
    public void mo15624h() {
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: i */
    public void mo15625i() {
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: j */
    public void mo15626j() {
    }

    /* renamed from: c */
    protected void m15619c(int i2) {
        if (i2 < 0) {
            throw new C4281hu("Negative length: " + i2);
        }
        if (this.f16321c) {
            this.f16316a -= i2;
            if (this.f16316a >= 0) {
                return;
            }
            throw new C4281hu("Message length exceeded: " + i2);
        }
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public void mo15609a(C4286hz c4286hz) {
        mo15604a(c4286hz.f16336a);
        mo15604a(c4286hz.f16338b);
        mo15605a(c4286hz.f16337a);
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public void mo15608a(C4285hy c4285hy) {
        mo15604a(c4285hy.f16334a);
        mo15605a(c4285hy.f16335a);
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public void mo15614a(boolean z) {
        mo15604a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public void mo15604a(byte b2) {
        byte[] bArr = this.f16318a;
        bArr[0] = b2;
        ((AbstractC4288ia) this).f16348a.mo15663a(bArr, 0, 1);
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public void mo15613a(short s) {
        byte[] bArr = this.f16320b;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        ((AbstractC4288ia) this).f16348a.mo15663a(bArr, 0, 2);
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public void mo15605a(int i2) {
        byte[] bArr = this.f16322c;
        bArr[0] = (byte) ((i2 >> 24) & 255);
        bArr[1] = (byte) ((i2 >> 16) & 255);
        bArr[2] = (byte) ((i2 >> 8) & 255);
        bArr[3] = (byte) (i2 & 255);
        ((AbstractC4288ia) this).f16348a.mo15663a(bArr, 0, 4);
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public void mo15606a(long j2) {
        byte[] bArr = this.f16323d;
        bArr[0] = (byte) ((j2 >> 56) & 255);
        bArr[1] = (byte) ((j2 >> 48) & 255);
        bArr[2] = (byte) ((j2 >> 40) & 255);
        bArr[3] = (byte) ((j2 >> 32) & 255);
        bArr[4] = (byte) ((j2 >> 24) & 255);
        bArr[5] = (byte) ((j2 >> 16) & 255);
        bArr[6] = (byte) ((j2 >> 8) & 255);
        bArr[7] = (byte) (j2 & 255);
        ((AbstractC4288ia) this).f16348a.mo15663a(bArr, 0, 8);
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public void mo15611a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            mo15605a(bytes.length);
            ((AbstractC4288ia) this).f16348a.mo15663a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new C4281hu("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public void mo15612a(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        mo15605a(limit);
        ((AbstractC4288ia) this).f16348a.mo15663a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public C4293if mo15598a() {
        return f16315a;
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public C4284hx mo15594a() {
        byte mo15590a = mo15590a();
        return new C4284hx("", mo15590a, mo15590a == 0 ? (short) 0 : mo15602a());
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public C4286hz mo15596a() {
        return new C4286hz(mo15590a(), mo15590a(), mo15592a());
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public C4285hy mo15595a() {
        return new C4285hy(mo15590a(), mo15592a());
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public C4292ie mo15597a() {
        return new C4292ie(mo15590a(), mo15592a());
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public boolean mo15615a() {
        return mo15590a() == 1;
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public byte mo15590a() {
        if (((AbstractC4288ia) this).f16348a.mo15669b() >= 1) {
            byte b2 = ((AbstractC4288ia) this).f16348a.mo15667a()[((AbstractC4288ia) this).f16348a.mo15668a_()];
            ((AbstractC4288ia) this).f16348a.mo15665a(1);
            return b2;
        }
        m15589a(this.f16324e, 0, 1);
        return this.f16324e[0];
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public short mo15602a() {
        byte[] bArr = this.f16325f;
        int i2 = 0;
        if (((AbstractC4288ia) this).f16348a.mo15669b() >= 2) {
            bArr = ((AbstractC4288ia) this).f16348a.mo15667a();
            i2 = ((AbstractC4288ia) this).f16348a.mo15668a_();
            ((AbstractC4288ia) this).f16348a.mo15665a(2);
        } else {
            m15589a(this.f16325f, 0, 2);
        }
        return (short) ((bArr[i2 + 1] & C5230f1.f20085c) | ((bArr[i2] & C5230f1.f20085c) << 8));
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public int mo15592a() {
        byte[] bArr = this.f16326g;
        int i2 = 0;
        if (((AbstractC4288ia) this).f16348a.mo15669b() >= 4) {
            bArr = ((AbstractC4288ia) this).f16348a.mo15667a();
            i2 = ((AbstractC4288ia) this).f16348a.mo15668a_();
            ((AbstractC4288ia) this).f16348a.mo15665a(4);
        } else {
            m15589a(this.f16326g, 0, 4);
        }
        return (bArr[i2 + 3] & C5230f1.f20085c) | ((bArr[i2] & C5230f1.f20085c) << 24) | ((bArr[i2 + 1] & C5230f1.f20085c) << 16) | ((bArr[i2 + 2] & C5230f1.f20085c) << 8);
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public long mo15593a() {
        byte[] bArr = this.f16327h;
        int i2 = 0;
        if (((AbstractC4288ia) this).f16348a.mo15669b() >= 8) {
            bArr = ((AbstractC4288ia) this).f16348a.mo15667a();
            i2 = ((AbstractC4288ia) this).f16348a.mo15668a_();
            ((AbstractC4288ia) this).f16348a.mo15665a(8);
        } else {
            m15589a(this.f16327h, 0, 8);
        }
        return (bArr[i2 + 7] & C5230f1.f20085c) | ((bArr[i2] & C5230f1.f20085c) << 56) | ((bArr[i2 + 1] & C5230f1.f20085c) << 48) | ((bArr[i2 + 2] & C5230f1.f20085c) << 40) | ((bArr[i2 + 3] & C5230f1.f20085c) << 32) | ((bArr[i2 + 4] & C5230f1.f20085c) << 24) | ((bArr[i2 + 5] & C5230f1.f20085c) << 16) | ((bArr[i2 + 6] & C5230f1.f20085c) << 8);
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public double mo15591a() {
        return Double.longBitsToDouble(mo15593a());
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public String mo15599a() {
        int mo15592a = mo15592a();
        if (((AbstractC4288ia) this).f16348a.mo15669b() >= mo15592a) {
            try {
                String str = new String(((AbstractC4288ia) this).f16348a.mo15667a(), ((AbstractC4288ia) this).f16348a.mo15668a_(), mo15592a, "UTF-8");
                ((AbstractC4288ia) this).f16348a.mo15665a(mo15592a);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new C4281hu("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return m15600a(mo15592a);
    }

    /* renamed from: a */
    public String m15600a(int i2) {
        try {
            m15619c(i2);
            byte[] bArr = new byte[i2];
            ((AbstractC4288ia) this).f16348a.m15671b(bArr, 0, i2);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new C4281hu("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public ByteBuffer mo15601a() {
        int mo15592a = mo15592a();
        m15619c(mo15592a);
        if (((AbstractC4288ia) this).f16348a.mo15669b() >= mo15592a) {
            ByteBuffer wrap = ByteBuffer.wrap(((AbstractC4288ia) this).f16348a.mo15667a(), ((AbstractC4288ia) this).f16348a.mo15668a_(), mo15592a);
            ((AbstractC4288ia) this).f16348a.mo15665a(mo15592a);
            return wrap;
        }
        byte[] bArr = new byte[mo15592a];
        ((AbstractC4288ia) this).f16348a.m15671b(bArr, 0, mo15592a);
        return ByteBuffer.wrap(bArr);
    }

    /* renamed from: a */
    private int m15589a(byte[] bArr, int i2, int i3) {
        m15619c(i3);
        return ((AbstractC4288ia) this).f16348a.m15671b(bArr, i2, i3);
    }
}
