package com.hihonor.push.sdk;

/* JADX INFO: loaded from: classes.dex */
public class HonorPushDataMsg {
    public int a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4230b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4232d;

    public String getData() {
        return this.f4232d;
    }

    public long getMsgId() {
        return this.f4231c;
    }

    public int getType() {
        return this.f4230b;
    }

    public int getVersion() {
        return this.a;
    }

    public void setData(String str) {
        this.f4232d = str;
    }

    public void setMsgId(long j2) {
        this.f4231c = j2;
    }

    public void setType(int i2) {
        this.f4230b = i2;
    }

    public void setVersion(int i2) {
        this.a = i2;
    }
}
