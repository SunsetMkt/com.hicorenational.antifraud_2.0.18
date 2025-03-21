package com.bumptech.glide.load.p116o;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import p286h.C5230f1;

/* compiled from: ExifOrientationStream.java */
/* renamed from: com.bumptech.glide.load.o.g */
/* loaded from: classes.dex */
public final class C1607g extends FilterInputStream {

    /* renamed from: c */
    private static final int f4211c = 2;

    /* renamed from: d */
    private static final byte[] f4212d = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};

    /* renamed from: e */
    private static final int f4213e = f4212d.length;

    /* renamed from: f */
    private static final int f4214f = f4213e + 2;

    /* renamed from: a */
    private final byte f4215a;

    /* renamed from: b */
    private int f4216b;

    public C1607g(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 >= -1 && i2 <= 8) {
            this.f4215a = (byte) i2;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i2;
        int i3 = this.f4216b;
        int read = (i3 < 2 || i3 > (i2 = f4214f)) ? super.read() : i3 == i2 ? this.f4215a : f4212d[i3 - 2] & C5230f1.f20085c;
        if (read != -1) {
            this.f4216b++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        long skip = super.skip(j2);
        if (skip > 0) {
            this.f4216b = (int) (this.f4216b + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5 = this.f4216b;
        int i6 = f4214f;
        if (i5 > i6) {
            i4 = super.read(bArr, i2, i3);
        } else if (i5 == i6) {
            bArr[i2] = this.f4215a;
            i4 = 1;
        } else if (i5 < 2) {
            i4 = super.read(bArr, i2, 2 - i5);
        } else {
            int min = Math.min(i6 - i5, i3);
            System.arraycopy(f4212d, this.f4216b - 2, bArr, i2, min);
            i4 = min;
        }
        if (i4 > 0) {
            this.f4216b += i4;
        }
        return i4;
    }
}
