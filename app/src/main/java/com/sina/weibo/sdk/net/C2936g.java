package com.sina.weibo.sdk.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.sina.weibo.sdk.net.g */
/* loaded from: classes.dex */
public final class C2936g implements InterfaceC2935f {
    private int code;

    /* renamed from: p */
    private InputStream f9323p;

    public C2936g(int i2, InputStream inputStream) {
        this.code = i2;
        this.f9323p = inputStream;
    }

    @Override // com.sina.weibo.sdk.net.InterfaceC2935f
    /* renamed from: f */
    public final String mo8859f() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = this.f9323p.read(bArr);
                if (read == -1) {
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream2;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e2) {
            throw e2;
        }
    }
}
