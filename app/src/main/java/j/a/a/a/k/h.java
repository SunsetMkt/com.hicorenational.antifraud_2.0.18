package j.a.a.a.k;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: BaseNCodecInputStream.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends FilterInputStream {
    private final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f12458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f12459c;

    protected h(InputStream inputStream, g gVar, boolean z) {
        super(inputStream);
        this.f12459c = new byte[1];
        this.a = z;
        this.f12458b = gVar;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i2 = read(this.f12459c, 0, 1);
        while (i2 == 0) {
            i2 = read(this.f12459c, 0, 1);
        }
        if (i2 <= 0) {
            return -1;
        }
        byte[] bArr = this.f12459c;
        return bArr[0] < 0 ? bArr[0] + 256 : bArr[0];
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (bArr == null) {
            throw new NullPointerException();
        }
        if (i2 >= 0 && i3 >= 0) {
            if (i2 > bArr.length || i2 + i3 > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            if (i3 == 0) {
                return 0;
            }
            int iC = 0;
            while (iC == 0) {
                if (!this.f12458b.c()) {
                    byte[] bArr2 = new byte[this.a ? 4096 : 8192];
                    int i4 = ((FilterInputStream) this).in.read(bArr2);
                    if (this.a) {
                        this.f12458b.b(bArr2, 0, i4);
                    } else {
                        this.f12458b.a(bArr2, 0, i4);
                    }
                }
                iC = this.f12458b.c(bArr, i2, i3);
            }
            return iC;
        }
        throw new IndexOutOfBoundsException();
    }
}
