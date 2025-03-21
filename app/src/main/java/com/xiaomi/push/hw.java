package com.xiaomi.push;

import h.f1;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class hw extends ia {

    /* renamed from: a, reason: collision with root package name */
    private static final Cif f13214a = new Cif();

    /* renamed from: a, reason: collision with other field name */
    protected int f891a;

    /* renamed from: a, reason: collision with other field name */
    protected boolean f892a;

    /* renamed from: a, reason: collision with other field name */
    private byte[] f893a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f13215b;

    /* renamed from: b, reason: collision with other field name */
    private byte[] f894b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f13216c;

    /* renamed from: c, reason: collision with other field name */
    private byte[] f895c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f13217d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f13218e;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f13219f;

    /* renamed from: g, reason: collision with root package name */
    private byte[] f13220g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f13221h;

    public static class a implements ic {

        /* renamed from: a, reason: collision with root package name */
        protected int f13222a;

        /* renamed from: a, reason: collision with other field name */
        protected boolean f896a;

        /* renamed from: b, reason: collision with root package name */
        protected boolean f13223b;

        public a() {
            this(false, true);
        }

        @Override // com.xiaomi.push.ic
        public ia a(ik ikVar) {
            hw hwVar = new hw(ikVar, this.f896a, this.f13223b);
            int i2 = this.f13222a;
            if (i2 != 0) {
                hwVar.b(i2);
            }
            return hwVar;
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i2) {
            this.f896a = false;
            this.f13223b = true;
            this.f896a = z;
            this.f13223b = z2;
            this.f13222a = i2;
        }
    }

    public hw(ik ikVar, boolean z, boolean z2) {
        super(ikVar);
        this.f892a = false;
        this.f13215b = true;
        this.f13216c = false;
        this.f893a = new byte[1];
        this.f894b = new byte[2];
        this.f895c = new byte[4];
        this.f13217d = new byte[8];
        this.f13218e = new byte[1];
        this.f13219f = new byte[2];
        this.f13220g = new byte[4];
        this.f13221h = new byte[8];
        this.f892a = z;
        this.f13215b = z2;
    }

    @Override // com.xiaomi.push.ia
    /* renamed from: a, reason: collision with other method in class */
    public void mo611a() {
    }

    @Override // com.xiaomi.push.ia
    public void a(hx hxVar) {
        a(hxVar.f13224a);
        a(hxVar.f898a);
    }

    @Override // com.xiaomi.push.ia
    public void a(Cif cif) {
    }

    @Override // com.xiaomi.push.ia
    public void b() {
    }

    public void b(int i2) {
        this.f891a = i2;
        this.f13216c = true;
    }

    @Override // com.xiaomi.push.ia
    public void c() {
        a((byte) 0);
    }

    @Override // com.xiaomi.push.ia
    public void d() {
    }

    @Override // com.xiaomi.push.ia
    public void e() {
    }

    @Override // com.xiaomi.push.ia
    public void f() {
    }

    @Override // com.xiaomi.push.ia
    public void g() {
    }

    @Override // com.xiaomi.push.ia
    public void h() {
    }

    @Override // com.xiaomi.push.ia
    public void i() {
    }

    @Override // com.xiaomi.push.ia
    public void j() {
    }

    protected void c(int i2) {
        if (i2 < 0) {
            throw new hu("Negative length: " + i2);
        }
        if (this.f13216c) {
            this.f891a -= i2;
            if (this.f891a >= 0) {
                return;
            }
            throw new hu("Message length exceeded: " + i2);
        }
    }

    @Override // com.xiaomi.push.ia
    public void a(hz hzVar) {
        a(hzVar.f13226a);
        a(hzVar.f13227b);
        mo612a(hzVar.f900a);
    }

    @Override // com.xiaomi.push.ia
    public void a(hy hyVar) {
        a(hyVar.f13225a);
        mo612a(hyVar.f899a);
    }

    @Override // com.xiaomi.push.ia
    public void a(boolean z) {
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.xiaomi.push.ia
    public void a(byte b2) {
        byte[] bArr = this.f893a;
        bArr[0] = b2;
        ((ia) this).f13234a.mo622a(bArr, 0, 1);
    }

    @Override // com.xiaomi.push.ia
    public void a(short s) {
        byte[] bArr = this.f894b;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        ((ia) this).f13234a.mo622a(bArr, 0, 2);
    }

    @Override // com.xiaomi.push.ia
    /* renamed from: a, reason: collision with other method in class */
    public void mo612a(int i2) {
        byte[] bArr = this.f895c;
        bArr[0] = (byte) ((i2 >> 24) & 255);
        bArr[1] = (byte) ((i2 >> 16) & 255);
        bArr[2] = (byte) ((i2 >> 8) & 255);
        bArr[3] = (byte) (i2 & 255);
        ((ia) this).f13234a.mo622a(bArr, 0, 4);
    }

    @Override // com.xiaomi.push.ia
    public void a(long j2) {
        byte[] bArr = this.f13217d;
        bArr[0] = (byte) ((j2 >> 56) & 255);
        bArr[1] = (byte) ((j2 >> 48) & 255);
        bArr[2] = (byte) ((j2 >> 40) & 255);
        bArr[3] = (byte) ((j2 >> 32) & 255);
        bArr[4] = (byte) ((j2 >> 24) & 255);
        bArr[5] = (byte) ((j2 >> 16) & 255);
        bArr[6] = (byte) ((j2 >> 8) & 255);
        bArr[7] = (byte) (j2 & 255);
        ((ia) this).f13234a.mo622a(bArr, 0, 8);
    }

    @Override // com.xiaomi.push.ia
    public void a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            mo612a(bytes.length);
            ((ia) this).f13234a.mo622a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new hu("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.ia
    public void a(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        mo612a(limit);
        ((ia) this).f13234a.mo622a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // com.xiaomi.push.ia
    /* renamed from: a, reason: collision with other method in class */
    public Cif mo607a() {
        return f13214a;
    }

    @Override // com.xiaomi.push.ia
    /* renamed from: a, reason: collision with other method in class */
    public hx mo603a() {
        byte a2 = a();
        return new hx("", a2, a2 == 0 ? (short) 0 : mo610a());
    }

    @Override // com.xiaomi.push.ia
    /* renamed from: a, reason: collision with other method in class */
    public hz mo605a() {
        return new hz(a(), a(), mo601a());
    }

    @Override // com.xiaomi.push.ia
    /* renamed from: a, reason: collision with other method in class */
    public hy mo604a() {
        return new hy(a(), mo601a());
    }

    @Override // com.xiaomi.push.ia
    /* renamed from: a, reason: collision with other method in class */
    public ie mo606a() {
        return new ie(a(), mo601a());
    }

    @Override // com.xiaomi.push.ia
    /* renamed from: a, reason: collision with other method in class */
    public boolean mo613a() {
        return a() == 1;
    }

    @Override // com.xiaomi.push.ia
    public byte a() {
        if (((ia) this).f13234a.b() >= 1) {
            byte b2 = ((ia) this).f13234a.a()[((ia) this).f13234a.a_()];
            ((ia) this).f13234a.a(1);
            return b2;
        }
        a(this.f13218e, 0, 1);
        return this.f13218e[0];
    }

    @Override // com.xiaomi.push.ia
    /* renamed from: a, reason: collision with other method in class */
    public short mo610a() {
        byte[] bArr = this.f13219f;
        int i2 = 0;
        if (((ia) this).f13234a.b() >= 2) {
            bArr = ((ia) this).f13234a.a();
            i2 = ((ia) this).f13234a.a_();
            ((ia) this).f13234a.a(2);
        } else {
            a(this.f13219f, 0, 2);
        }
        return (short) ((bArr[i2 + 1] & f1.f16099c) | ((bArr[i2] & f1.f16099c) << 8));
    }

    @Override // com.xiaomi.push.ia
    /* renamed from: a, reason: collision with other method in class */
    public int mo601a() {
        byte[] bArr = this.f13220g;
        int i2 = 0;
        if (((ia) this).f13234a.b() >= 4) {
            bArr = ((ia) this).f13234a.a();
            i2 = ((ia) this).f13234a.a_();
            ((ia) this).f13234a.a(4);
        } else {
            a(this.f13220g, 0, 4);
        }
        return (bArr[i2 + 3] & f1.f16099c) | ((bArr[i2] & f1.f16099c) << 24) | ((bArr[i2 + 1] & f1.f16099c) << 16) | ((bArr[i2 + 2] & f1.f16099c) << 8);
    }

    @Override // com.xiaomi.push.ia
    /* renamed from: a, reason: collision with other method in class */
    public long mo602a() {
        byte[] bArr = this.f13221h;
        int i2 = 0;
        if (((ia) this).f13234a.b() >= 8) {
            bArr = ((ia) this).f13234a.a();
            i2 = ((ia) this).f13234a.a_();
            ((ia) this).f13234a.a(8);
        } else {
            a(this.f13221h, 0, 8);
        }
        return (bArr[i2 + 7] & f1.f16099c) | ((bArr[i2] & f1.f16099c) << 56) | ((bArr[i2 + 1] & f1.f16099c) << 48) | ((bArr[i2 + 2] & f1.f16099c) << 40) | ((bArr[i2 + 3] & f1.f16099c) << 32) | ((bArr[i2 + 4] & f1.f16099c) << 24) | ((bArr[i2 + 5] & f1.f16099c) << 16) | ((bArr[i2 + 6] & f1.f16099c) << 8);
    }

    @Override // com.xiaomi.push.ia
    /* renamed from: a, reason: collision with other method in class */
    public double mo600a() {
        return Double.longBitsToDouble(mo602a());
    }

    @Override // com.xiaomi.push.ia
    /* renamed from: a, reason: collision with other method in class */
    public String mo608a() {
        int mo601a = mo601a();
        if (((ia) this).f13234a.b() >= mo601a) {
            try {
                String str = new String(((ia) this).f13234a.a(), ((ia) this).f13234a.a_(), mo601a, "UTF-8");
                ((ia) this).f13234a.a(mo601a);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new hu("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return a(mo601a);
    }

    public String a(int i2) {
        try {
            c(i2);
            byte[] bArr = new byte[i2];
            ((ia) this).f13234a.b(bArr, 0, i2);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new hu("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.ia
    /* renamed from: a, reason: collision with other method in class */
    public ByteBuffer mo609a() {
        int mo601a = mo601a();
        c(mo601a);
        if (((ia) this).f13234a.b() >= mo601a) {
            ByteBuffer wrap = ByteBuffer.wrap(((ia) this).f13234a.a(), ((ia) this).f13234a.a_(), mo601a);
            ((ia) this).f13234a.a(mo601a);
            return wrap;
        }
        byte[] bArr = new byte[mo601a];
        ((ia) this).f13234a.b(bArr, 0, mo601a);
        return ByteBuffer.wrap(bArr);
    }

    private int a(byte[] bArr, int i2, int i3) {
        c(i3);
        return ((ia) this).f13234a.b(bArr, i2, i3);
    }
}
