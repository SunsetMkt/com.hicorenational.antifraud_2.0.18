package com.umeng.analytics.pro;

import java.io.Serializable;

/* JADX INFO: compiled from: FieldValueMetaData.java */
/* JADX INFO: loaded from: classes2.dex */
public class cd implements Serializable {
    private final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f7134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f7135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f7136d;

    public cd(byte b2, boolean z) {
        this.f7134b = b2;
        this.a = false;
        this.f7135c = null;
        this.f7136d = z;
    }

    public boolean a() {
        return this.a;
    }

    public String b() {
        return this.f7135c;
    }

    public boolean c() {
        return this.f7134b == 12;
    }

    public boolean d() {
        byte b2 = this.f7134b;
        return b2 == 15 || b2 == 13 || b2 == 14;
    }

    public boolean e() {
        return this.f7136d;
    }

    public cd(byte b2) {
        this(b2, false);
    }

    public cd(byte b2, String str) {
        this.f7134b = b2;
        this.a = true;
        this.f7135c = str;
        this.f7136d = false;
    }
}
