package com.alibaba.sdk.android.httpdns.probe;

/* JADX INFO: loaded from: classes.dex */
class c {
    private String hostName;
    private String[] ips;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f2597k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f2598l;
    private String r;
    private String s;

    c(String str, String[] strArr, String str2, String str3, long j2, long j3) {
        this.hostName = str;
        this.ips = strArr;
        this.r = str2;
        this.s = str3;
        this.f2597k = j2;
        this.f2598l = j3;
    }

    public long c() {
        return this.f2597k;
    }

    public long d() {
        return this.f2598l;
    }

    public String getHostName() {
        return this.hostName;
    }

    public String[] getIps() {
        return this.ips;
    }

    public String j() {
        return this.r;
    }

    public String k() {
        return this.s;
    }
}
