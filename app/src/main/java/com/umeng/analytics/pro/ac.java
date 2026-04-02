package com.umeng.analytics.pro;

/* JADX INFO: compiled from: DelayedStartCondition.java */
/* JADX INFO: loaded from: classes2.dex */
public class ac implements aa {
    private long a;

    public ac(long j2) {
        this.a = 0L;
        this.a = j2;
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean b() {
        return !a();
    }

    @Override // com.umeng.analytics.pro.aa
    public long c() {
        return this.a;
    }
}
