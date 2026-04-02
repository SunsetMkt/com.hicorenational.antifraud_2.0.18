package anet.channel.util;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class a extends InputStream {
    private InputStream a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1648b = 0;

    public a(InputStream inputStream) {
        this.a = null;
        if (inputStream == null) {
            throw new NullPointerException("input stream cannot be null");
        }
        this.a = inputStream;
    }

    public long a() {
        return this.f1648b;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        this.f1648b++;
        return this.a.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.a.read(bArr, i2, i3);
        if (i4 != -1) {
            this.f1648b += (long) i4;
        }
        return i4;
    }
}
