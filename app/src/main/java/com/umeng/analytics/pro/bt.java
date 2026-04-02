package com.umeng.analytics.pro;

import com.umeng.analytics.pro.cj;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: TDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class bt {
    private final cp a;

    /* JADX INFO: renamed from: b */
    private final dc f7124b;

    public bt() {
        this(new cj.a());
    }

    private ck j(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        this.f7124b.a(bArr);
        bx[] bxVarArr2 = new bx[bxVarArr.length + 1];
        int i2 = 0;
        bxVarArr2[0] = bxVar;
        int i3 = 0;
        while (i3 < bxVarArr.length) {
            int i4 = i3 + 1;
            bxVarArr2[i4] = bxVarArr[i3];
            i3 = i4;
        }
        this.a.j();
        ck ckVarL = null;
        while (i2 < bxVarArr2.length) {
            ckVarL = this.a.l();
            if (ckVarL.f7175b == 0 || ckVarL.f7176c > bxVarArr2[i2].a()) {
                return null;
            }
            if (ckVarL.f7176c != bxVarArr2[i2].a()) {
                cs.a(this.a, ckVarL.f7175b);
                this.a.m();
            } else {
                i2++;
                if (i2 < bxVarArr2.length) {
                    this.a.j();
                }
            }
        }
        return ckVarL;
    }

    public void a(bq bqVar, byte[] bArr) throws bw {
        try {
            this.f7124b.a(bArr);
            bqVar.read(this.a);
        } finally {
            this.f7124b.e();
            this.a.B();
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
        Short shValueOf;
        try {
            try {
                if (j(bArr, bxVar, bxVarArr) != null) {
                    this.a.j();
                    shValueOf = Short.valueOf(this.a.l().f7176c);
                } else {
                    shValueOf = null;
                }
                return shValueOf;
            } catch (Exception e2) {
                throw new bw(e2);
            }
        } finally {
            this.f7124b.e();
            this.a.B();
        }
    }

    public bt(cr crVar) {
        this.f7124b = new dc();
        this.a = crVar.a(this.f7124b);
    }

    public void a(bq bqVar, String str, String str2) throws bw {
        try {
            try {
                a(bqVar, str.getBytes(str2));
            } catch (UnsupportedEncodingException unused) {
                throw new bw("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.a.B();
        }
    }

    public void a(bq bqVar, byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        try {
            try {
                if (j(bArr, bxVar, bxVarArr) != null) {
                    bqVar.read(this.a);
                }
            } catch (Exception e2) {
                throw new bw(e2);
            }
        } finally {
            this.f7124b.e();
            this.a.B();
        }
    }

    public Boolean a(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (Boolean) a((byte) 2, bArr, bxVar, bxVarArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Object a(byte b2, byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        Object objValueOf;
        try {
            try {
                ck ckVarJ = j(bArr, bxVar, bxVarArr);
                if (ckVarJ == null) {
                    objValueOf = null;
                } else if (b2 != 2) {
                    if (b2 != 3) {
                        if (b2 != 4) {
                            if (b2 != 6) {
                                if (b2 != 8) {
                                    if (b2 != 100) {
                                        if (b2 != 10) {
                                            if (b2 == 11 && ckVarJ.f7175b == 11) {
                                                objValueOf = this.a.z();
                                            }
                                        } else if (ckVarJ.f7175b == 10) {
                                            objValueOf = Long.valueOf(this.a.x());
                                        }
                                    } else if (ckVarJ.f7175b == 11) {
                                        objValueOf = this.a.A();
                                    }
                                } else if (ckVarJ.f7175b == 8) {
                                    objValueOf = Integer.valueOf(this.a.w());
                                }
                            } else if (ckVarJ.f7175b == 6) {
                                objValueOf = Short.valueOf(this.a.v());
                            }
                        } else if (ckVarJ.f7175b == 4) {
                            objValueOf = Double.valueOf(this.a.y());
                        }
                    } else if (ckVarJ.f7175b == 3) {
                        objValueOf = Byte.valueOf(this.a.u());
                    }
                } else if (ckVarJ.f7175b == 2) {
                    objValueOf = Boolean.valueOf(this.a.t());
                }
                return objValueOf;
            } catch (Exception e2) {
                throw new bw(e2);
            }
        } finally {
            this.f7124b.e();
            this.a.B();
        }
    }

    public void a(bq bqVar, String str) throws bw {
        a(bqVar, str.getBytes());
    }
}
