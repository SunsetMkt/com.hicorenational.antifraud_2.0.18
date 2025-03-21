package com.vivo.push.p232b;

import com.vivo.push.AbstractC4016v;
import com.vivo.push.C3862d;

/* compiled from: DefaultCommand.java */
/* renamed from: com.vivo.push.b.f */
/* loaded from: classes2.dex */
public final class C3834f extends AbstractC4016v {

    /* renamed from: a */
    private int f13920a;

    public C3834f() {
        super(0);
    }

    @Override // com.vivo.push.AbstractC4016v
    /* renamed from: c */
    protected final void mo12833c(C3862d c3862d) {
        if (c3862d != null) {
            c3862d.m12914a("APP_CLIENT_SWITCH_FLAG", this.f13920a);
        }
    }

    /* renamed from: d */
    public final void m12845d() {
        this.f13920a = 3;
    }

    @Override // com.vivo.push.AbstractC4016v
    public final String toString() {
        return "DefaultCommand";
    }

    @Override // com.vivo.push.AbstractC4016v
    /* renamed from: d */
    protected final void mo12834d(C3862d c3862d) {
        if (c3862d != null) {
            this.f13920a = c3862d.m12921b("APP_CLIENT_SWITCH_FLAG", 0);
        }
    }
}
