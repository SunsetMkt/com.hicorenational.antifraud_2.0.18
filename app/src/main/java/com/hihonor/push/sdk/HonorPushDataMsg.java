package com.hihonor.push.sdk;

/* loaded from: classes.dex */
public class HonorPushDataMsg {

    /* renamed from: a */
    public int f6743a = 1;

    /* renamed from: b */
    public int f6744b = 0;

    /* renamed from: c */
    public long f6745c;

    /* renamed from: d */
    public String f6746d;

    public String getData() {
        return this.f6746d;
    }

    public long getMsgId() {
        return this.f6745c;
    }

    public int getType() {
        return this.f6744b;
    }

    public int getVersion() {
        return this.f6743a;
    }

    public void setData(String str) {
        this.f6746d = str;
    }

    public void setMsgId(long j2) {
        this.f6745c = j2;
    }

    public void setType(int i2) {
        this.f6744b = i2;
    }

    public void setVersion(int i2) {
        this.f6743a = i2;
    }
}
