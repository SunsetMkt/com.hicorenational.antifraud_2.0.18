package com.hihonor.honorid.d.b;

/* JADX INFO: compiled from: TokenInvalidatedException.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends Exception {
    private String a;

    public a(String str) {
        super(str);
        this.a = str;
    }

    public String getErrorDesc() {
        return this.a;
    }

    public void setErrorDesc(String str) {
        this.a = str;
    }
}
