package com.umeng.analytics.pro;

/* compiled from: TMessage.java */
/* renamed from: com.umeng.analytics.pro.cn */
/* loaded from: classes2.dex */
public final class C3384cn {

    /* renamed from: a */
    public final String f11841a;

    /* renamed from: b */
    public final byte f11842b;

    /* renamed from: c */
    public final int f11843c;

    public C3384cn() {
        this("", (byte) 0, 0);
    }

    /* renamed from: a */
    public boolean m11177a(C3384cn c3384cn) {
        return this.f11841a.equals(c3384cn.f11841a) && this.f11842b == c3384cn.f11842b && this.f11843c == c3384cn.f11843c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C3384cn) {
            return m11177a((C3384cn) obj);
        }
        return false;
    }

    public String toString() {
        return "<TMessage name:'" + this.f11841a + "' type: " + ((int) this.f11842b) + " seqid:" + this.f11843c + ">";
    }

    public C3384cn(String str, byte b2, int i2) {
        this.f11841a = str;
        this.f11842b = b2;
        this.f11843c = i2;
    }
}
