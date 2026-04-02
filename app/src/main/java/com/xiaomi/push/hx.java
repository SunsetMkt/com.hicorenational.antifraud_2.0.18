package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public class hx {
    public final byte a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f897a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final short f898a;

    public hx() {
        this("", (byte) 0, (short) 0);
    }

    public String toString() {
        return "<TField name:'" + this.f897a + "' type:" + ((int) this.a) + " field-id:" + ((int) this.f898a) + ">";
    }

    public hx(String str, byte b2, short s) {
        this.f897a = str;
        this.a = b2;
        this.f898a = s;
    }
}
