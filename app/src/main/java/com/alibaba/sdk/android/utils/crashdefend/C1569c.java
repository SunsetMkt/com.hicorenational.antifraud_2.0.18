package com.alibaba.sdk.android.utils.crashdefend;

/* compiled from: CrashDefendSDKInfo.java */
/* renamed from: com.alibaba.sdk.android.utils.crashdefend.c */
/* loaded from: classes.dex */
public class C1569c implements Cloneable {

    /* renamed from: a */
    public int f4048a;

    /* renamed from: a */
    public long f4049a;

    /* renamed from: a */
    public String f4051a;

    /* renamed from: b */
    public int f4052b;

    /* renamed from: b */
    public long f4053b;

    /* renamed from: b */
    public String f4054b;
    public int crashCount;

    /* renamed from: c */
    public int f4055c = 0;

    /* renamed from: c */
    public volatile boolean f4056c = false;

    /* renamed from: a */
    public SDKMessageCallback f4050a = null;

    public Object clone() {
        try {
            return (C1569c) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
