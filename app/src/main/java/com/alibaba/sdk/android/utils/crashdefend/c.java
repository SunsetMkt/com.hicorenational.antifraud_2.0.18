package com.alibaba.sdk.android.utils.crashdefend;

/* JADX INFO: compiled from: CrashDefendSDKInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements Cloneable {
    public int a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f50a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f52a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2631b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f53b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f54b;
    public int crashCount;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2632c = 0;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public volatile boolean f55c = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SDKMessageCallback f51a = null;

    public Object clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
