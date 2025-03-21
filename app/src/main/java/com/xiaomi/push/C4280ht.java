package com.xiaomi.push;

import com.xiaomi.push.C4283hw;

/* renamed from: com.xiaomi.push.ht */
/* loaded from: classes2.dex */
public class C4280ht {

    /* renamed from: a */
    private final AbstractC4288ia f16310a;

    /* renamed from: a */
    private final C4297ij f16311a;

    public C4280ht() {
        this(new C4283hw.a());
    }

    /* renamed from: a */
    public void m15587a(InterfaceC4277hq interfaceC4277hq, byte[] bArr) {
        try {
            this.f16311a.m15666a(bArr);
            interfaceC4277hq.mo14606a(this.f16310a);
        } finally {
            this.f16310a.m15659k();
        }
    }

    public C4280ht(InterfaceC4290ic interfaceC4290ic) {
        this.f16311a = new C4297ij();
        this.f16310a = interfaceC4290ic.mo15627a(this.f16311a);
    }
}
