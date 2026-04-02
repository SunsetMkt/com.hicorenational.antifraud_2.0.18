package com.xiaomi.push;

import com.xiaomi.push.hw;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class hv {
    private ia a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ih f889a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ByteArrayOutputStream f890a;

    public hv() {
        this(new hw.a());
    }

    public byte[] a(hq hqVar) {
        this.f890a.reset();
        hqVar.b(this.a);
        return this.f890a.toByteArray();
    }

    public hv(ic icVar) {
        this.f890a = new ByteArrayOutputStream();
        this.f889a = new ih(this.f890a);
        this.a = icVar.a(this.f889a);
    }
}
