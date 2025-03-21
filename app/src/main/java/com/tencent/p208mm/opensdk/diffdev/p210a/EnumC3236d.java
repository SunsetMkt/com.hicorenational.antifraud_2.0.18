package com.tencent.p208mm.opensdk.diffdev.p210a;

import com.tencent.bugly.beta.tinker.TinkerReport;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.d */
/* loaded from: classes2.dex */
public enum EnumC3236d {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(TinkerReport.KEY_LOADED_SUCC_COST_OTHER),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(500);


    /* renamed from: a */
    private int f11088a;

    EnumC3236d(int i2) {
        this.f11088a = i2;
    }

    /* renamed from: a */
    public int m10357a() {
        return this.f11088a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UUIDStatusCode:" + this.f11088a;
    }
}
