package anet.channel.util;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
/* renamed from: anet.channel.util.a */
/* loaded from: classes.dex */
public class C0855a extends InputStream {

    /* renamed from: a */
    private InputStream f1169a;

    /* renamed from: b */
    private long f1170b = 0;

    public C0855a(InputStream inputStream) {
        this.f1169a = null;
        if (inputStream == null) {
            throw new NullPointerException("input stream cannot be null");
        }
        this.f1169a = inputStream;
    }

    /* renamed from: a */
    public long m719a() {
        return this.f1170b;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        this.f1170b++;
        return this.f1169a.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = this.f1169a.read(bArr, i2, i3);
        if (read != -1) {
            this.f1170b += read;
        }
        return read;
    }
}
