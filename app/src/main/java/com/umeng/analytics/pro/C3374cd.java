package com.umeng.analytics.pro;

import java.io.Serializable;

/* compiled from: FieldValueMetaData.java */
/* renamed from: com.umeng.analytics.pro.cd */
/* loaded from: classes2.dex */
public class C3374cd implements Serializable {

    /* renamed from: a */
    private final boolean f11776a;

    /* renamed from: b */
    public final byte f11777b;

    /* renamed from: c */
    private final String f11778c;

    /* renamed from: d */
    private final boolean f11779d;

    public C3374cd(byte b2, boolean z) {
        this.f11777b = b2;
        this.f11776a = false;
        this.f11778c = null;
        this.f11779d = z;
    }

    /* renamed from: a */
    public boolean m11104a() {
        return this.f11776a;
    }

    /* renamed from: b */
    public String m11105b() {
        return this.f11778c;
    }

    /* renamed from: c */
    public boolean m11106c() {
        return this.f11777b == 12;
    }

    /* renamed from: d */
    public boolean m11107d() {
        byte b2 = this.f11777b;
        return b2 == 15 || b2 == 13 || b2 == 14;
    }

    /* renamed from: e */
    public boolean m11108e() {
        return this.f11779d;
    }

    public C3374cd(byte b2) {
        this(b2, false);
    }

    public C3374cd(byte b2, String str) {
        this.f11777b = b2;
        this.f11776a = true;
        this.f11778c = str;
        this.f11779d = false;
    }
}
