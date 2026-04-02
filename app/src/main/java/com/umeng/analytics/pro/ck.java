package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TField.java */
/* JADX INFO: loaded from: classes2.dex */
public class ck {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f7175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final short f7176c;

    public ck() {
        this("", (byte) 0, (short) 0);
    }

    public boolean a(ck ckVar) {
        return this.f7175b == ckVar.f7175b && this.f7176c == ckVar.f7176c;
    }

    public String toString() {
        return "<TField name:'" + this.a + "' type:" + ((int) this.f7175b) + " field-id:" + ((int) this.f7176c) + ">";
    }

    public ck(String str, byte b2, short s) {
        this.a = str;
        this.f7175b = b2;
        this.f7176c = s;
    }
}
