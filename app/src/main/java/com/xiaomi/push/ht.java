package com.xiaomi.push;

import com.xiaomi.push.hw;

/* JADX INFO: loaded from: classes2.dex */
public class ht {
    private final ia a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ij f888a;

    public ht() {
        this(new hw.a());
    }

    public void a(hq hqVar, byte[] bArr) {
        try {
            this.f888a.a(bArr);
            hqVar.a(this.a);
        } finally {
            this.a.k();
        }
    }

    public ht(ic icVar) {
        this.f888a = new ij();
        this.a = icVar.a(this.f888a);
    }
}
