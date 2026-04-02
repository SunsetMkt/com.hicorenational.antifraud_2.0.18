package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public final class bg extends m implements Cloneable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static ArrayList<bf> f6464b;
    public ArrayList<bf> a = null;

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a((Collection) this.a, 0);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        if (f6464b == null) {
            f6464b = new ArrayList<>();
            f6464b.add(new bf());
        }
        this.a = (ArrayList) kVar.a(f6464b, 0, true);
    }
}
