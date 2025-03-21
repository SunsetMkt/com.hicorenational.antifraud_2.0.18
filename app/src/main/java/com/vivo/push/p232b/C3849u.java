package com.vivo.push.p232b;

import com.vivo.push.C3862d;

/* compiled from: OnUndoMsgReceiveCommand.java */
/* renamed from: com.vivo.push.b.u */
/* loaded from: classes2.dex */
public final class C3849u extends AbstractC3850v {

    /* renamed from: a */
    private long f13952a;

    /* renamed from: b */
    private int f13953b;

    public C3849u() {
        super(20);
        this.f13952a = -1L;
    }

    @Override // com.vivo.push.p232b.AbstractC3850v, com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    /* renamed from: c */
    protected final void mo12833c(C3862d c3862d) {
        super.mo12833c(c3862d);
        c3862d.m12915a("undo_msg_v1", this.f13952a);
        c3862d.m12914a("undo_msg_type_v1", this.f13953b);
    }

    /* renamed from: d */
    public final long m12880d() {
        return this.f13952a;
    }

    /* renamed from: e */
    public final String m12881e() {
        long j2 = this.f13952a;
        if (j2 != -1) {
            return String.valueOf(j2);
        }
        return null;
    }

    @Override // com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    public final String toString() {
        return "OnUndoMsgCommand";
    }

    @Override // com.vivo.push.p232b.AbstractC3850v, com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    /* renamed from: d */
    protected final void mo12834d(C3862d c3862d) {
        super.mo12834d(c3862d);
        this.f13952a = c3862d.m12922b("undo_msg_v1", this.f13952a);
        this.f13953b = c3862d.m12921b("undo_msg_type_v1", 0);
    }
}
