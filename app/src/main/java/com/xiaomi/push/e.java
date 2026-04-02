package com.xiaomi.push;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    public abstract int a();

    public abstract e a(b bVar);

    public abstract void a(c cVar);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m372a() {
        byte[] bArr = new byte[b()];
        m371a(bArr, 0, bArr.length);
        return bArr;
    }

    public abstract int b();

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m371a(byte[] bArr, int i2, int i3) {
        try {
            c cVarA = c.a(bArr, i2, i3);
            a(cVarA);
            cVarA.b();
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    public e a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public e a(byte[] bArr, int i2, int i3) throws d {
        try {
            b bVarA = b.a(bArr, i2, i3);
            a(bVarA);
            bVarA.m165a(0);
            return this;
        } catch (d e2) {
            throw e2;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    protected boolean a(b bVar, int i2) {
        return bVar.m167a(i2);
    }
}
