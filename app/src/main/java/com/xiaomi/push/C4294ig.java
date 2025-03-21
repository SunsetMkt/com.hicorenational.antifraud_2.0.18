package com.xiaomi.push;

import com.xiaomi.push.C4283hw;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* renamed from: com.xiaomi.push.ig */
/* loaded from: classes2.dex */
public class C4294ig extends C4283hw {

    /* renamed from: b */
    private static int f16354b = 10000;

    /* renamed from: c */
    private static int f16355c = 10000;

    /* renamed from: d */
    private static int f16356d = 10000;

    /* renamed from: e */
    private static int f16357e = 10485760;

    /* renamed from: f */
    private static int f16358f = 104857600;

    /* renamed from: com.xiaomi.push.ig$a */
    public static class a extends C4283hw.a {
        public a() {
            super(false, true);
        }

        @Override // com.xiaomi.push.C4283hw.a, com.xiaomi.push.InterfaceC4290ic
        /* renamed from: a */
        public AbstractC4288ia mo15627a(AbstractC4298ik abstractC4298ik) {
            C4294ig c4294ig = new C4294ig(abstractC4298ik, ((C4283hw.a) this).f16329a, this.f16330b);
            int i2 = ((C4283hw.a) this).f16328a;
            if (i2 != 0) {
                c4294ig.m15617b(i2);
            }
            return c4294ig;
        }

        public a(boolean z, boolean z2, int i2) {
            super(z, z2, i2);
        }
    }

    public C4294ig(AbstractC4298ik abstractC4298ik, boolean z, boolean z2) {
        super(abstractC4298ik, z, z2);
    }

    @Override // com.xiaomi.push.C4283hw, com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public C4286hz mo15596a() {
        byte mo15590a = mo15590a();
        byte mo15590a2 = mo15590a();
        int mo15592a = mo15592a();
        if (mo15592a <= f16354b) {
            return new C4286hz(mo15590a, mo15590a2, mo15592a);
        }
        throw new C4289ib(3, "Thrift map size " + mo15592a + " out of range!");
    }

    @Override // com.xiaomi.push.C4283hw, com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public C4285hy mo15595a() {
        byte mo15590a = mo15590a();
        int mo15592a = mo15592a();
        if (mo15592a <= f16355c) {
            return new C4285hy(mo15590a, mo15592a);
        }
        throw new C4289ib(3, "Thrift list size " + mo15592a + " out of range!");
    }

    @Override // com.xiaomi.push.C4283hw, com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public C4292ie mo15597a() {
        byte mo15590a = mo15590a();
        int mo15592a = mo15592a();
        if (mo15592a <= f16356d) {
            return new C4292ie(mo15590a, mo15592a);
        }
        throw new C4289ib(3, "Thrift set size " + mo15592a + " out of range!");
    }

    @Override // com.xiaomi.push.C4283hw, com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public String mo15599a() {
        int mo15592a = mo15592a();
        if (mo15592a <= f16357e) {
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
        throw new C4289ib(3, "Thrift string size " + mo15592a + " out of range!");
    }

    @Override // com.xiaomi.push.C4283hw, com.xiaomi.push.AbstractC4288ia
    /* renamed from: a */
    public ByteBuffer mo15601a() {
        int mo15592a = mo15592a();
        if (mo15592a <= f16358f) {
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
        throw new C4289ib(3, "Thrift binary size " + mo15592a + " out of range!");
    }
}
