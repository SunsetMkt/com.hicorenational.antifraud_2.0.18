package com.tencent.bugly.proguard;

import java.io.Serializable;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class ab implements Serializable, Comparable<ab> {
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f6337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f6339e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f6340f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f6341g;

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ab abVar) {
        return (int) (this.f6337c - abVar.f6337c);
    }
}
