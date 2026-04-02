package com.xiaomi.push;

import i.f1;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class hw extends ia {
    private static final Cif a = new Cif();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected int f891a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected boolean f892a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[] f893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f9308b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private byte[] f894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f9309c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private byte[] f895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f9310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f9311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f9312f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte[] f9313g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte[] f9314h;

    public static class a implements ic {
        protected int a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        protected boolean f896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected boolean f9315b;

        public a() {
            this(false, true);
        }

        @Override // com.xiaomi.push.ic
        public ia a(ik ikVar) {
            hw hwVar = new hw(ikVar, this.f896a, this.f9315b);
            int i2 = this.a;
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
            this.f9315b = true;
            this.f896a = z;
            this.f9315b = z2;
            this.a = i2;
        }
    }

    public hw(ik ikVar, boolean z, boolean z2) {
        super(ikVar);
        this.f892a = false;
        this.f9308b = true;
        this.f9309c = false;
        this.f893a = new byte[1];
        this.f894b = new byte[2];
        this.f895c = new byte[4];
        this.f9310d = new byte[8];
        this.f9311e = new byte[1];
        this.f9312f = new byte[2];
        this.f9313g = new byte[4];
        this.f9314h = new byte[8];
        this.f892a = z;
        this.f9308b = z2;
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo609a() {
    }

    @Override // com.xiaomi.push.ia
    public void a(hx hxVar) {
        a(hxVar.a);
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
        this.f9309c = true;
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

    protected void c(int i2) throws hu {
        if (i2 < 0) {
            throw new hu("Negative length: " + i2);
        }
        if (this.f9309c) {
            this.f891a -= i2;
            if (this.f891a >= 0) {
                return;
            }
            throw new hu("Message length exceeded: " + i2);
        }
    }

    @Override // com.xiaomi.push.ia
    public void a(hz hzVar) {
        a(hzVar.a);
        a(hzVar.f9316b);
        mo610a(hzVar.f900a);
    }

    @Override // com.xiaomi.push.ia
    public void a(hy hyVar) {
        a(hyVar.a);
        mo610a(hyVar.f899a);
    }

    @Override // com.xiaomi.push.ia
    public void a(boolean z) {
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.xiaomi.push.ia
    public void a(byte b2) {
        byte[] bArr = this.f893a;
        bArr[0] = b2;
        ((ia) this).a.mo620a(bArr, 0, 1);
    }

    @Override // com.xiaomi.push.ia
    public void a(short s) {
        byte[] bArr = this.f894b;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        ((ia) this).a.mo620a(bArr, 0, 2);
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo610a(int i2) {
        byte[] bArr = this.f895c;
        bArr[0] = (byte) ((i2 >> 24) & 255);
        bArr[1] = (byte) ((i2 >> 16) & 255);
        bArr[2] = (byte) ((i2 >> 8) & 255);
        bArr[3] = (byte) (i2 & 255);
        ((ia) this).a.mo620a(bArr, 0, 4);
    }

    @Override // com.xiaomi.push.ia
    public void a(long j2) {
        byte[] bArr = this.f9310d;
        bArr[0] = (byte) ((j2 >> 56) & 255);
        bArr[1] = (byte) ((j2 >> 48) & 255);
        bArr[2] = (byte) ((j2 >> 40) & 255);
        bArr[3] = (byte) ((j2 >> 32) & 255);
        bArr[4] = (byte) ((j2 >> 24) & 255);
        bArr[5] = (byte) ((j2 >> 16) & 255);
        bArr[6] = (byte) ((j2 >> 8) & 255);
        bArr[7] = (byte) (j2 & 255);
        ((ia) this).a.mo620a(bArr, 0, 8);
    }

    @Override // com.xiaomi.push.ia
    public void a(String str) throws hu {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            mo610a(bytes.length);
            ((ia) this).a.mo620a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new hu("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.ia
    public void a(ByteBuffer byteBuffer) {
        int iLimit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        mo610a(iLimit);
        ((ia) this).a.mo620a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), iLimit);
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Cif mo605a() {
        return a;
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public hx mo601a() throws hu {
        byte bA = a();
        return new hx("", bA, bA == 0 ? (short) 0 : mo608a());
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public hz mo603a() {
        return new hz(a(), a(), mo599a());
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public hy mo602a() {
        return new hy(a(), mo599a());
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ie mo604a() {
        return new ie(a(), mo599a());
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo611a() {
        return a() == 1;
    }

    @Override // com.xiaomi.push.ia
    public byte a() throws hu {
        if (((ia) this).a.b() >= 1) {
            byte b2 = ((ia) this).a.a()[((ia) this).a.a_()];
            ((ia) this).a.a(1);
            return b2;
        }
        a(this.f9311e, 0, 1);
        return this.f9311e[0];
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public short mo608a() throws hu {
        byte[] bArrA = this.f9312f;
        int iA_ = 0;
        if (((ia) this).a.b() >= 2) {
            bArrA = ((ia) this).a.a();
            iA_ = ((ia) this).a.a_();
            ((ia) this).a.a(2);
        } else {
            a(this.f9312f, 0, 2);
        }
        return (short) ((bArrA[iA_ + 1] & f1.f12066c) | ((bArrA[iA_] & f1.f12066c) << 8));
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public int mo599a() throws hu {
        byte[] bArrA = this.f9313g;
        int iA_ = 0;
        if (((ia) this).a.b() >= 4) {
            bArrA = ((ia) this).a.a();
            iA_ = ((ia) this).a.a_();
            ((ia) this).a.a(4);
        } else {
            a(this.f9313g, 0, 4);
        }
        return (bArrA[iA_ + 3] & f1.f12066c) | ((bArrA[iA_] & f1.f12066c) << 24) | ((bArrA[iA_ + 1] & f1.f12066c) << 16) | ((bArrA[iA_ + 2] & f1.f12066c) << 8);
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long mo600a() throws hu {
        byte[] bArrA = this.f9314h;
        int iA_ = 0;
        if (((ia) this).a.b() >= 8) {
            bArrA = ((ia) this).a.a();
            iA_ = ((ia) this).a.a_();
            ((ia) this).a.a(8);
        } else {
            a(this.f9314h, 0, 8);
        }
        return ((long) (bArrA[iA_ + 7] & f1.f12066c)) | (((long) (bArrA[iA_] & f1.f12066c)) << 56) | (((long) (bArrA[iA_ + 1] & f1.f12066c)) << 48) | (((long) (bArrA[iA_ + 2] & f1.f12066c)) << 40) | (((long) (bArrA[iA_ + 3] & f1.f12066c)) << 32) | (((long) (bArrA[iA_ + 4] & f1.f12066c)) << 24) | (((long) (bArrA[iA_ + 5] & f1.f12066c)) << 16) | (((long) (bArrA[iA_ + 6] & f1.f12066c)) << 8);
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public double mo598a() {
        return Double.longBitsToDouble(mo600a());
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String mo606a() throws hu {
        int iMo599a = mo599a();
        if (((ia) this).a.b() >= iMo599a) {
            try {
                String str = new String(((ia) this).a.a(), ((ia) this).a.a_(), iMo599a, "UTF-8");
                ((ia) this).a.a(iMo599a);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new hu("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return a(iMo599a);
    }

    public String a(int i2) throws hu {
        try {
            c(i2);
            byte[] bArr = new byte[i2];
            ((ia) this).a.b(bArr, 0, i2);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new hu("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ByteBuffer mo607a() throws hu {
        int iMo599a = mo599a();
        c(iMo599a);
        if (((ia) this).a.b() >= iMo599a) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(((ia) this).a.a(), ((ia) this).a.a_(), iMo599a);
            ((ia) this).a.a(iMo599a);
            return byteBufferWrap;
        }
        byte[] bArr = new byte[iMo599a];
        ((ia) this).a.b(bArr, 0, iMo599a);
        return ByteBuffer.wrap(bArr);
    }

    private int a(byte[] bArr, int i2, int i3) throws hu {
        c(i3);
        return ((ia) this).a.b(bArr, i2, i3);
    }
}
