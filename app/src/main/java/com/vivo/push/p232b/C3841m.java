package com.vivo.push.p232b;

import com.vivo.push.C3862d;
import java.util.ArrayList;

/* compiled from: OnListTagReceiveCommand.java */
/* renamed from: com.vivo.push.b.m */
/* loaded from: classes2.dex */
public final class C3841m extends C3847s {

    /* renamed from: a */
    private ArrayList<String> f13931a;

    public C3841m() {
        super(8);
    }

    @Override // com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    /* renamed from: c */
    protected final void mo12833c(C3862d c3862d) {
        super.mo12833c(c3862d);
        c3862d.m12918a("tags_list", this.f13931a);
    }

    /* renamed from: d */
    public final ArrayList<String> m12852d() {
        return this.f13931a;
    }

    @Override // com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    public final String toString() {
        return "OnListTagCommand";
    }

    @Override // com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    /* renamed from: d */
    protected final void mo12834d(C3862d c3862d) {
        super.mo12834d(c3862d);
        this.f13931a = c3862d.m12925c("tags_list");
    }
}
