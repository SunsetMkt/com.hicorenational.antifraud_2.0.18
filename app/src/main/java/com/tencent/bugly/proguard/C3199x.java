package com.tencent.bugly.proguard;

import com.umeng.analytics.pro.C3397d;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.x */
/* loaded from: classes2.dex */
public final class C3199x extends AbstractC3188m implements Cloneable {

    /* renamed from: b */
    static ArrayList<C3198w> f10824b;

    /* renamed from: c */
    static final /* synthetic */ boolean f10825c = !C3199x.class.desiredAssertionStatus();

    /* renamed from: a */
    public ArrayList<C3198w> f10826a;

    public C3199x() {
        this.f10826a = null;
    }

    /* renamed from: a */
    public ArrayList<C3198w> m10149a() {
        return this.f10826a;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f10825c) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return C3189n.m10123a(this.f10826a, ((C3199x) obj).f10826a);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9794a(C3187l c3187l) {
        c3187l.m10107a((Collection) this.f10826a, 0);
    }

    public C3199x(ArrayList<C3198w> arrayList) {
        this.f10826a = null;
        this.f10826a = arrayList;
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9793a(C3186k c3186k) {
        if (f10824b == null) {
            f10824b = new ArrayList<>();
            f10824b.add(new C3198w());
        }
        this.f10826a = (ArrayList) c3186k.m10077a((C3186k) f10824b, 0, true);
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9795a(StringBuilder sb, int i2) {
        new C3184i(sb, i2).m10052a((Collection) this.f10826a, C3397d.f11927ar);
    }
}
