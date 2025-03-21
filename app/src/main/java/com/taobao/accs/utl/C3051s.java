package com.taobao.accs.utl;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.utl.s */
/* loaded from: classes2.dex */
public class C3051s extends ByteArrayInputStream {
    public C3051s(byte[] bArr) {
        super(bArr);
    }

    /* renamed from: a */
    public int m9269a() {
        return read() & 255;
    }

    /* renamed from: b */
    public int m9271b() {
        return (m9269a() << 8) | m9269a();
    }

    /* renamed from: c */
    public byte[] m9272c() throws IOException {
        byte[] bArr = new byte[available()];
        read(bArr);
        return bArr;
    }

    /* renamed from: a */
    public String m9270a(int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int read = read(bArr);
        if (read == i2) {
            return new String(bArr, "utf-8");
        }
        throw new IOException("read len not match. ask for " + i2 + " but read for " + read);
    }
}
