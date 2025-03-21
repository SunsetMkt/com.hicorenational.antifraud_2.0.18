package com.tencent.bugly.crashreport.crash;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.a */
/* loaded from: classes2.dex */
public class C3119a implements Comparable<C3119a> {

    /* renamed from: a */
    public long f10315a = -1;

    /* renamed from: b */
    public long f10316b = -1;

    /* renamed from: c */
    public String f10317c = null;

    /* renamed from: d */
    public boolean f10318d = false;

    /* renamed from: e */
    public boolean f10319e = false;

    /* renamed from: f */
    public int f10320f = 0;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C3119a c3119a) {
        if (c3119a == null) {
            return 1;
        }
        long j2 = this.f10316b - c3119a.f10316b;
        if (j2 > 0) {
            return 1;
        }
        return j2 < 0 ? -1 : 0;
    }
}
