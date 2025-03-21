package p324i.p325a.p326a.p327a.p328k;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: BaseNCodecInputStream.java */
/* renamed from: i.a.a.a.k.h */
/* loaded from: classes2.dex */
public class C5773h extends FilterInputStream {

    /* renamed from: a */
    private final boolean f20803a;

    /* renamed from: b */
    private final AbstractC5772g f20804b;

    /* renamed from: c */
    private final byte[] f20805c;

    protected C5773h(InputStream inputStream, AbstractC5772g abstractC5772g, boolean z) {
        super(inputStream);
        this.f20805c = new byte[1];
        this.f20803a = z;
        this.f20804b = abstractC5772g;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = read(this.f20805c, 0, 1);
        while (read == 0) {
            read = read(this.f20805c, 0, 1);
        }
        if (read <= 0) {
            return -1;
        }
        byte[] bArr = this.f20805c;
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
            int i4 = 0;
            while (i4 == 0) {
                if (!this.f20804b.m24187c()) {
                    byte[] bArr2 = new byte[this.f20803a ? 4096 : 8192];
                    int read = ((FilterInputStream) this).in.read(bArr2);
                    if (this.f20803a) {
                        this.f20804b.mo24155b(bArr2, 0, read);
                    } else {
                        this.f20804b.mo24153a(bArr2, 0, read);
                    }
                }
                i4 = this.f20804b.m24185c(bArr, i2, i3);
            }
            return i4;
        }
        throw new IndexOutOfBoundsException();
    }
}
