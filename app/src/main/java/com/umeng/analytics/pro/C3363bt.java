package com.umeng.analytics.pro;

import com.umeng.analytics.pro.C3380cj;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: TDeserializer.java */
/* renamed from: com.umeng.analytics.pro.bt */
/* loaded from: classes2.dex */
public class C3363bt {

    /* renamed from: a */
    private final AbstractC3386cp f11758a;

    /* renamed from: b */
    private final C3400dc f11759b;

    public C3363bt() {
        this(new C3380cj.a());
    }

    /* renamed from: j */
    private C3381ck m11057j(byte[] bArr, InterfaceC3367bx interfaceC3367bx, InterfaceC3367bx... interfaceC3367bxArr) throws C3366bw {
        this.f11759b.m11196a(bArr);
        InterfaceC3367bx[] interfaceC3367bxArr2 = new InterfaceC3367bx[interfaceC3367bxArr.length + 1];
        int i2 = 0;
        interfaceC3367bxArr2[0] = interfaceC3367bx;
        int i3 = 0;
        while (i3 < interfaceC3367bxArr.length) {
            int i4 = i3 + 1;
            interfaceC3367bxArr2[i4] = interfaceC3367bxArr[i3];
            i3 = i4;
        }
        this.f11758a.mo11137j();
        C3381ck c3381ck = null;
        while (i2 < interfaceC3367bxArr2.length) {
            c3381ck = this.f11758a.mo11139l();
            if (c3381ck.f11834b == 0 || c3381ck.f11835c > interfaceC3367bxArr2[i2].mo10984a()) {
                return null;
            }
            if (c3381ck.f11835c != interfaceC3367bxArr2[i2].mo10984a()) {
                C3389cs.m11183a(this.f11758a, c3381ck.f11834b);
                this.f11758a.mo11140m();
            } else {
                i2++;
                if (i2 < interfaceC3367bxArr2.length) {
                    this.f11758a.mo11137j();
                }
            }
        }
        return c3381ck;
    }

    /* renamed from: a */
    public void m11061a(InterfaceC3360bq interfaceC3360bq, byte[] bArr) throws C3366bw {
        try {
            this.f11759b.m11196a(bArr);
            interfaceC3360bq.read(this.f11758a);
        } finally {
            this.f11759b.m11198e();
            this.f11758a.mo11174B();
        }
    }

    /* renamed from: b */
    public Byte m11063b(byte[] bArr, InterfaceC3367bx interfaceC3367bx, InterfaceC3367bx... interfaceC3367bxArr) throws C3366bw {
        return (Byte) m11056a((byte) 3, bArr, interfaceC3367bx, interfaceC3367bxArr);
    }

    /* renamed from: c */
    public Double m11064c(byte[] bArr, InterfaceC3367bx interfaceC3367bx, InterfaceC3367bx... interfaceC3367bxArr) throws C3366bw {
        return (Double) m11056a((byte) 4, bArr, interfaceC3367bx, interfaceC3367bxArr);
    }

    /* renamed from: d */
    public Short m11065d(byte[] bArr, InterfaceC3367bx interfaceC3367bx, InterfaceC3367bx... interfaceC3367bxArr) throws C3366bw {
        return (Short) m11056a((byte) 6, bArr, interfaceC3367bx, interfaceC3367bxArr);
    }

    /* renamed from: e */
    public Integer m11066e(byte[] bArr, InterfaceC3367bx interfaceC3367bx, InterfaceC3367bx... interfaceC3367bxArr) throws C3366bw {
        return (Integer) m11056a((byte) 8, bArr, interfaceC3367bx, interfaceC3367bxArr);
    }

    /* renamed from: f */
    public Long m11067f(byte[] bArr, InterfaceC3367bx interfaceC3367bx, InterfaceC3367bx... interfaceC3367bxArr) throws C3366bw {
        return (Long) m11056a((byte) 10, bArr, interfaceC3367bx, interfaceC3367bxArr);
    }

    /* renamed from: g */
    public String m11068g(byte[] bArr, InterfaceC3367bx interfaceC3367bx, InterfaceC3367bx... interfaceC3367bxArr) throws C3366bw {
        return (String) m11056a((byte) 11, bArr, interfaceC3367bx, interfaceC3367bxArr);
    }

    /* renamed from: h */
    public ByteBuffer m11069h(byte[] bArr, InterfaceC3367bx interfaceC3367bx, InterfaceC3367bx... interfaceC3367bxArr) throws C3366bw {
        return (ByteBuffer) m11056a((byte) 100, bArr, interfaceC3367bx, interfaceC3367bxArr);
    }

    /* renamed from: i */
    public Short m11070i(byte[] bArr, InterfaceC3367bx interfaceC3367bx, InterfaceC3367bx... interfaceC3367bxArr) throws C3366bw {
        Short sh;
        try {
            try {
                if (m11057j(bArr, interfaceC3367bx, interfaceC3367bxArr) != null) {
                    this.f11758a.mo11137j();
                    sh = Short.valueOf(this.f11758a.mo11139l().f11835c);
                } else {
                    sh = null;
                }
                return sh;
            } catch (Exception e2) {
                throw new C3366bw(e2);
            }
        } finally {
            this.f11759b.m11198e();
            this.f11758a.mo11174B();
        }
    }

    public C3363bt(InterfaceC3388cr interfaceC3388cr) {
        this.f11759b = new C3400dc();
        this.f11758a = interfaceC3388cr.mo11154a(this.f11759b);
    }

    /* renamed from: a */
    public void m11060a(InterfaceC3360bq interfaceC3360bq, String str, String str2) throws C3366bw {
        try {
            try {
                m11061a(interfaceC3360bq, str.getBytes(str2));
            } catch (UnsupportedEncodingException unused) {
                throw new C3366bw("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.f11758a.mo11174B();
        }
    }

    /* renamed from: a */
    public void m11062a(InterfaceC3360bq interfaceC3360bq, byte[] bArr, InterfaceC3367bx interfaceC3367bx, InterfaceC3367bx... interfaceC3367bxArr) throws C3366bw {
        try {
            try {
                if (m11057j(bArr, interfaceC3367bx, interfaceC3367bxArr) != null) {
                    interfaceC3360bq.read(this.f11758a);
                }
            } catch (Exception e2) {
                throw new C3366bw(e2);
            }
        } finally {
            this.f11759b.m11198e();
            this.f11758a.mo11174B();
        }
    }

    /* renamed from: a */
    public Boolean m11058a(byte[] bArr, InterfaceC3367bx interfaceC3367bx, InterfaceC3367bx... interfaceC3367bxArr) throws C3366bw {
        return (Boolean) m11056a((byte) 2, bArr, interfaceC3367bx, interfaceC3367bxArr);
    }

    /* renamed from: a */
    private Object m11056a(byte b2, byte[] bArr, InterfaceC3367bx interfaceC3367bx, InterfaceC3367bx... interfaceC3367bxArr) throws C3366bw {
        Object obj;
        try {
            try {
                C3381ck m11057j = m11057j(bArr, interfaceC3367bx, interfaceC3367bxArr);
                if (m11057j != null) {
                    if (b2 != 2) {
                        if (b2 != 3) {
                            if (b2 != 4) {
                                if (b2 != 6) {
                                    if (b2 != 8) {
                                        if (b2 != 100) {
                                            if (b2 != 10) {
                                                if (b2 == 11 && m11057j.f11834b == 11) {
                                                    obj = this.f11758a.mo11153z();
                                                }
                                            } else if (m11057j.f11834b == 10) {
                                                obj = Long.valueOf(this.f11758a.mo11151x());
                                            }
                                        } else if (m11057j.f11834b == 11) {
                                            obj = this.f11758a.mo11110A();
                                        }
                                    } else if (m11057j.f11834b == 8) {
                                        obj = Integer.valueOf(this.f11758a.mo11150w());
                                    }
                                } else if (m11057j.f11834b == 6) {
                                    obj = Short.valueOf(this.f11758a.mo11149v());
                                }
                            } else if (m11057j.f11834b == 4) {
                                obj = Double.valueOf(this.f11758a.mo11152y());
                            }
                        } else if (m11057j.f11834b == 3) {
                            obj = Byte.valueOf(this.f11758a.mo11148u());
                        }
                    } else if (m11057j.f11834b == 2) {
                        obj = Boolean.valueOf(this.f11758a.mo11147t());
                    }
                    return obj;
                }
                obj = null;
                return obj;
            } catch (Exception e2) {
                throw new C3366bw(e2);
            }
        } finally {
            this.f11759b.m11198e();
            this.f11758a.mo11174B();
        }
    }

    /* renamed from: a */
    public void m11059a(InterfaceC3360bq interfaceC3360bq, String str) throws C3366bw {
        m11061a(interfaceC3360bq, str.getBytes());
    }
}
