package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bd */
/* loaded from: classes2.dex */
public final class C3168bd extends AbstractC3188m implements Cloneable {

    /* renamed from: c */
    static ArrayList<String> f10621c;

    /* renamed from: a */
    public String f10622a = "";

    /* renamed from: b */
    public ArrayList<String> f10623b = null;

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9794a(C3187l c3187l) {
        c3187l.m10106a(this.f10622a, 0);
        ArrayList<String> arrayList = this.f10623b;
        if (arrayList != null) {
            c3187l.m10107a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9795a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9793a(C3186k c3186k) {
        this.f10622a = c3186k.m10078a(0, true);
        if (f10621c == null) {
            f10621c = new ArrayList<>();
            f10621c.add("");
        }
        this.f10623b = (ArrayList) c3186k.m10077a((C3186k) f10621c, 1, false);
    }
}
