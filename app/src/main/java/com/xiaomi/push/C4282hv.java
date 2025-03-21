package com.xiaomi.push;

import com.xiaomi.push.C4283hw;
import java.io.ByteArrayOutputStream;

/* renamed from: com.xiaomi.push.hv */
/* loaded from: classes2.dex */
public class C4282hv {

    /* renamed from: a */
    private AbstractC4288ia f16312a;

    /* renamed from: a */
    private final C4295ih f16313a;

    /* renamed from: a */
    private final ByteArrayOutputStream f16314a;

    public C4282hv() {
        this(new C4283hw.a());
    }

    /* renamed from: a */
    public byte[] m15588a(InterfaceC4277hq interfaceC4277hq) {
        this.f16314a.reset();
        interfaceC4277hq.mo14612b(this.f16312a);
        return this.f16314a.toByteArray();
    }

    public C4282hv(InterfaceC4290ic interfaceC4290ic) {
        this.f16314a = new ByteArrayOutputStream();
        this.f16313a = new C4295ih(this.f16314a);
        this.f16312a = interfaceC4290ic.mo15627a(this.f16313a);
    }
}
