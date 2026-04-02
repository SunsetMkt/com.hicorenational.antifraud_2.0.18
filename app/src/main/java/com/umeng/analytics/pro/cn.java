package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TMessage.java */
/* JADX INFO: loaded from: classes2.dex */
public final class cn {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f7180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7181c;

    public cn() {
        this("", (byte) 0, 0);
    }

    public boolean a(cn cnVar) {
        return this.a.equals(cnVar.a) && this.f7180b == cnVar.f7180b && this.f7181c == cnVar.f7181c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof cn) {
            return a((cn) obj);
        }
        return false;
    }

    public String toString() {
        return "<TMessage name:'" + this.a + "' type: " + ((int) this.f7180b) + " seqid:" + this.f7181c + ">";
    }

    public cn(String str, byte b2, int i2) {
        this.a = str;
        this.f7180b = b2;
        this.f7181c = i2;
    }
}
