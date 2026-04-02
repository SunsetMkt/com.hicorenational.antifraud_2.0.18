package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public final class x extends m implements Cloneable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static ArrayList<w> f6593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final /* synthetic */ boolean f6594c = !x.class.desiredAssertionStatus();
    public ArrayList<w> a;

    public x() {
        this.a = null;
    }

    public ArrayList<w> a() {
        return this.a;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f6594c) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return n.a(this.a, ((x) obj).a);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a((Collection) this.a, 0);
    }

    public x(ArrayList<w> arrayList) {
        this.a = null;
        this.a = arrayList;
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        if (f6593b == null) {
            f6593b = new ArrayList<>();
            f6593b.add(new w());
        }
        this.a = (ArrayList) kVar.a(f6593b, 0, true);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
        new i(sb, i2).a((Collection) this.a, com.umeng.analytics.pro.d.ar);
    }
}
