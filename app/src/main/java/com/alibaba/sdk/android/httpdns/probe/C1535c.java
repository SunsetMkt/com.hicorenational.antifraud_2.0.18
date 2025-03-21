package com.alibaba.sdk.android.httpdns.probe;

/* renamed from: com.alibaba.sdk.android.httpdns.probe.c */
/* loaded from: classes.dex */
class C1535c {
    private String hostName;
    private String[] ips;

    /* renamed from: k */
    private long f3975k;

    /* renamed from: l */
    private long f3976l;

    /* renamed from: r */
    private String f3977r;

    /* renamed from: s */
    private String f3978s;

    C1535c(String str, String[] strArr, String str2, String str3, long j2, long j3) {
        this.hostName = str;
        this.ips = strArr;
        this.f3977r = str2;
        this.f3978s = str3;
        this.f3975k = j2;
        this.f3976l = j3;
    }

    /* renamed from: c */
    public long m3564c() {
        return this.f3975k;
    }

    /* renamed from: d */
    public long m3565d() {
        return this.f3976l;
    }

    public String getHostName() {
        return this.hostName;
    }

    public String[] getIps() {
        return this.ips;
    }

    /* renamed from: j */
    public String m3566j() {
        return this.f3977r;
    }

    /* renamed from: k */
    public String m3567k() {
        return this.f3978s;
    }
}
