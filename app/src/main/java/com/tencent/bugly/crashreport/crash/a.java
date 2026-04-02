package com.tencent.bugly.crashreport.crash;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class a implements Comparable<a> {
    public long a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f6229b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6230c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6231d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6232e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6233f = 0;

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        if (aVar == null) {
            return 1;
        }
        long j2 = this.f6229b - aVar.f6229b;
        if (j2 > 0) {
            return 1;
        }
        return j2 < 0 ? -1 : 0;
    }
}
