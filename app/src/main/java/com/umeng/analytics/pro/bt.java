package com.umeng.analytics.pro;

import com.umeng.analytics.pro.cj;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: TDeserializer.java */
/* loaded from: classes2.dex */
public class bt {

    /* renamed from: a, reason: collision with root package name */
    private final cp f10196a;

    /* renamed from: b, reason: collision with root package name */
    private final dc f10197b;

    public bt() {
        this(new cj.a());
    }

    private ck j(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        this.f10197b.a(bArr);
        bx[] bxVarArr2 = new bx[bxVarArr.length + 1];
        int i2 = 0;
        bxVarArr2[0] = bxVar;
        int i3 = 0;
        while (i3 < bxVarArr.length) {
            int i4 = i3 + 1;
            bxVarArr2[i4] = bxVarArr[i3];
            i3 = i4;
        }
        this.f10196a.j();
        ck ckVar = null;
        while (i2 < bxVarArr2.length) {
            ckVar = this.f10196a.l();
            if (ckVar.f10264b == 0 || ckVar.f10265c > bxVarArr2[i2].a()) {
                return null;
            }
            if (ckVar.f10265c != bxVarArr2[i2].a()) {
                cs.a(this.f10196a, ckVar.f10264b);
                this.f10196a.m();
            } else {
                i2++;
                if (i2 < bxVarArr2.length) {
                    this.f10196a.j();
                }
            }
        }
        return ckVar;
    }

    public void a(bq bqVar, byte[] bArr) throws bw {
        try {
            this.f10197b.a(bArr);
            bqVar.read(this.f10196a);
        } finally {
            this.f10197b.e();
            this.f10196a.B();
        }
    }

    public Byte b(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (Byte) a((byte) 3, bArr, bxVar, bxVarArr);
    }

    public Double c(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (Double) a((byte) 4, bArr, bxVar, bxVarArr);
    }

    public Short d(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (Short) a((byte) 6, bArr, bxVar, bxVarArr);
    }

    public Integer e(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (Integer) a((byte) 8, bArr, bxVar, bxVarArr);
    }

    public Long f(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (Long) a((byte) 10, bArr, bxVar, bxVarArr);
    }

    public String g(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (String) a((byte) 11, bArr, bxVar, bxVarArr);
    }

    public ByteBuffer h(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (ByteBuffer) a((byte) 100, bArr, bxVar, bxVarArr);
    }

    public Short i(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        Short sh;
        try {
            try {
                if (j(bArr, bxVar, bxVarArr) != null) {
                    this.f10196a.j();
                    sh = Short.valueOf(this.f10196a.l().f10265c);
                } else {
                    sh = null;
                }
                return sh;
            } catch (Exception e2) {
                throw new bw(e2);
            }
        } finally {
            this.f10197b.e();
            this.f10196a.B();
        }
    }

    public bt(cr crVar) {
        this.f10197b = new dc();
        this.f10196a = crVar.a(this.f10197b);
    }

    public void a(bq bqVar, String str, String str2) throws bw {
        try {
            try {
                a(bqVar, str.getBytes(str2));
            } catch (UnsupportedEncodingException unused) {
                throw new bw("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.f10196a.B();
        }
    }

    public void a(bq bqVar, byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        try {
            try {
                if (j(bArr, bxVar, bxVarArr) != null) {
                    bqVar.read(this.f10196a);
                }
            } catch (Exception e2) {
                throw new bw(e2);
            }
        } finally {
            this.f10197b.e();
            this.f10196a.B();
        }
    }

    public Boolean a(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (Boolean) a((byte) 2, bArr, bxVar, bxVarArr);
    }

    private Object a(byte b2, byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        Object obj;
        try {
            try {
                ck j2 = j(bArr, bxVar, bxVarArr);
                if (j2 != null) {
                    if (b2 != 2) {
                        if (b2 != 3) {
                            if (b2 != 4) {
                                if (b2 != 6) {
                                    if (b2 != 8) {
                                        if (b2 != 100) {
                                            if (b2 != 10) {
                                                if (b2 == 11 && j2.f10264b == 11) {
                                                    obj = this.f10196a.z();
                                                }
                                            } else if (j2.f10264b == 10) {
                                                obj = Long.valueOf(this.f10196a.x());
                                            }
                                        } else if (j2.f10264b == 11) {
                                            obj = this.f10196a.A();
                                        }
                                    } else if (j2.f10264b == 8) {
                                        obj = Integer.valueOf(this.f10196a.w());
                                    }
                                } else if (j2.f10264b == 6) {
                                    obj = Short.valueOf(this.f10196a.v());
                                }
                            } else if (j2.f10264b == 4) {
                                obj = Double.valueOf(this.f10196a.y());
                            }
                        } else if (j2.f10264b == 3) {
                            obj = Byte.valueOf(this.f10196a.u());
                        }
                    } else if (j2.f10264b == 2) {
                        obj = Boolean.valueOf(this.f10196a.t());
                    }
                    return obj;
                }
                obj = null;
                return obj;
            } catch (Exception e2) {
                throw new bw(e2);
            }
        } finally {
            this.f10197b.e();
            this.f10196a.B();
        }
    }

    public void a(bq bqVar, String str) throws bw {
        a(bqVar, str.getBytes());
    }
}
