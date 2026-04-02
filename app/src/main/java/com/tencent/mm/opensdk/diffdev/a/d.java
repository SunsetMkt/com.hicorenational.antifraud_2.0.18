package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.bugly.beta.tinker.TinkerReport;

/* JADX INFO: loaded from: classes2.dex */
public enum d {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(TinkerReport.KEY_LOADED_SUCC_COST_OTHER),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(500);

    private int a;

    d(int i2) {
        this.a = i2;
    }

    public int a() {
        return this.a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UUIDStatusCode:" + this.a;
    }
}
