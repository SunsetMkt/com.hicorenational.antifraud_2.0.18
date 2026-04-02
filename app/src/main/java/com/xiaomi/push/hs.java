package com.xiaomi.push;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class hs extends ByteArrayOutputStream {
    public hs(int i2) {
        super(i2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m597a() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public hs() {
    }

    public int a() {
        return ((ByteArrayOutputStream) this).count;
    }
}
