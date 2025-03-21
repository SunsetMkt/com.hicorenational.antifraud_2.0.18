package com.vivo.push.p232b;

import com.vivo.push.C3862d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: OnTagsReceiveCommand.java */
/* renamed from: com.vivo.push.b.t */
/* loaded from: classes2.dex */
public final class C3848t extends C3847s {

    /* renamed from: a */
    private ArrayList<String> f13950a;

    /* renamed from: b */
    private ArrayList<String> f13951b;

    public C3848t(int i2) {
        super(i2);
        this.f13950a = null;
        this.f13951b = null;
    }

    @Override // com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    /* renamed from: c */
    protected final void mo12833c(C3862d c3862d) {
        super.mo12833c(c3862d);
        c3862d.m12918a("content", this.f13950a);
        c3862d.m12918a("error_msg", this.f13951b);
    }

    /* renamed from: d */
    public final ArrayList<String> m12878d() {
        return this.f13950a;
    }

    /* renamed from: e */
    public final List<String> m12879e() {
        return this.f13951b;
    }

    @Override // com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    public final String toString() {
        return "OnSetTagsCommand";
    }

    @Override // com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    /* renamed from: d */
    protected final void mo12834d(C3862d c3862d) {
        super.mo12834d(c3862d);
        this.f13950a = c3862d.m12925c("content");
        this.f13951b = c3862d.m12925c("error_msg");
    }
}
