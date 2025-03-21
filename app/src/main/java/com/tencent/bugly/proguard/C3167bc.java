package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bc */
/* loaded from: classes2.dex */
public final class C3167bc extends AbstractC3188m implements Cloneable {

    /* renamed from: a */
    public String f10616a = "";

    /* renamed from: b */
    public String f10617b = "";

    /* renamed from: c */
    public String f10618c = "";

    /* renamed from: d */
    public String f10619d = "";

    /* renamed from: e */
    public String f10620e = "";

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9794a(C3187l c3187l) {
        c3187l.m10106a(this.f10616a, 0);
        String str = this.f10617b;
        if (str != null) {
            c3187l.m10106a(str, 1);
        }
        String str2 = this.f10618c;
        if (str2 != null) {
            c3187l.m10106a(str2, 2);
        }
        String str3 = this.f10619d;
        if (str3 != null) {
            c3187l.m10106a(str3, 3);
        }
        String str4 = this.f10620e;
        if (str4 != null) {
            c3187l.m10106a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9795a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9793a(C3186k c3186k) {
        this.f10616a = c3186k.m10078a(0, true);
        this.f10617b = c3186k.m10078a(1, false);
        this.f10618c = c3186k.m10078a(2, false);
        this.f10619d = c3186k.m10078a(3, false);
        this.f10620e = c3186k.m10078a(4, false);
    }
}
