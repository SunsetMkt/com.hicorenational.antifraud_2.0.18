package com.umeng.analytics.pro;

/* compiled from: DelayedStartCondition.java */
/* renamed from: com.umeng.analytics.pro.ac */
/* loaded from: classes2.dex */
public class C3319ac implements InterfaceC3317aa {

    /* renamed from: a */
    private long f11423a;

    public C3319ac(long j2) {
        this.f11423a = 0L;
        this.f11423a = j2;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3317aa
    /* renamed from: a */
    public boolean mo10809a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3317aa
    /* renamed from: b */
    public boolean mo10810b() {
        return !mo10809a();
    }

    @Override // com.umeng.analytics.pro.InterfaceC3317aa
    /* renamed from: c */
    public long mo10811c() {
        return this.f11423a;
    }
}
