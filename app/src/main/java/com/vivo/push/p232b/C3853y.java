package com.vivo.push.p232b;

import com.vivo.push.AbstractC4016v;
import com.vivo.push.C3862d;

/* compiled from: StopServiceCommand.java */
/* renamed from: com.vivo.push.b.y */
/* loaded from: classes2.dex */
public final class C3853y extends AbstractC4016v {

    /* renamed from: a */
    private String f13959a;

    public C3853y(String str) {
        super(2008);
        this.f13959a = str;
    }

    @Override // com.vivo.push.AbstractC4016v
    /* renamed from: c */
    protected final void mo12833c(C3862d c3862d) {
        c3862d.m12917a("package_name", this.f13959a);
    }

    @Override // com.vivo.push.AbstractC4016v
    /* renamed from: d */
    protected final void mo12834d(C3862d c3862d) {
        this.f13959a = c3862d.m12913a("package_name");
    }

    @Override // com.vivo.push.AbstractC4016v
    public final String toString() {
        return "StopServiceCommand";
    }

    public C3853y() {
        super(2008);
    }
}
