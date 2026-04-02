package com.google.gson;

/* JADX INFO: compiled from: JsonNull.java */
/* JADX INFO: loaded from: classes.dex */
public final class m extends k {
    public static final m a = new m();

    @Deprecated
    public m() {
    }

    public boolean equals(Object obj) {
        return obj instanceof m;
    }

    public int hashCode() {
        return m.class.hashCode();
    }

    @Override // com.google.gson.k
    public m deepCopy() {
        return a;
    }
}
