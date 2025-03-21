package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bg */
/* loaded from: classes2.dex */
public final class C3171bg extends AbstractC3188m implements Cloneable {

    /* renamed from: b */
    static ArrayList<C3170bf> f10657b;

    /* renamed from: a */
    public ArrayList<C3170bf> f10658a = null;

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9794a(C3187l c3187l) {
        c3187l.m10107a((Collection) this.f10658a, 0);
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9795a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9793a(C3186k c3186k) {
        if (f10657b == null) {
            f10657b = new ArrayList<>();
            f10657b.add(new C3170bf());
        }
        this.f10658a = (ArrayList) c3186k.m10077a((C3186k) f10657b, 0, true);
    }
}
