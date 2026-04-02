package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public final class bd extends m implements Cloneable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static ArrayList<String> f6446c;
    public String a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<String> f6447b = null;

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.a, 0);
        ArrayList<String> arrayList = this.f6447b;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.a = kVar.a(0, true);
        if (f6446c == null) {
            f6446c = new ArrayList<>();
            f6446c.add("");
        }
        this.f6447b = (ArrayList) kVar.a(f6446c, 1, false);
    }
}
