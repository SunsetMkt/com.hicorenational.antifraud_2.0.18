package com.umeng.analytics.pro;

/* compiled from: TField.java */
/* renamed from: com.umeng.analytics.pro.ck */
/* loaded from: classes2.dex */
public class C3381ck {

    /* renamed from: a */
    public final String f11833a;

    /* renamed from: b */
    public final byte f11834b;

    /* renamed from: c */
    public final short f11835c;

    public C3381ck() {
        this("", (byte) 0, (short) 0);
    }

    /* renamed from: a */
    public boolean m11176a(C3381ck c3381ck) {
        return this.f11834b == c3381ck.f11834b && this.f11835c == c3381ck.f11835c;
    }

    public String toString() {
        return "<TField name:'" + this.f11833a + "' type:" + ((int) this.f11834b) + " field-id:" + ((int) this.f11835c) + ">";
    }

    public C3381ck(String str, byte b2, short s) {
        this.f11833a = str;
        this.f11834b = b2;
        this.f11835c = s;
    }
}
