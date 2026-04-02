package com.bumptech.glide.load.r.d;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import i.f1;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: RecyclableBufferedInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class b0 extends FilterInputStream {
    private volatile byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.b f3143f;

    /* JADX INFO: compiled from: RecyclableBufferedInputStream.java */
    static class a extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        a(String str) {
            super(str);
        }
    }

    public b0(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.p.a0.b bVar) {
        this(inputStream, bVar, 65536);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i2 = this.f3141d;
        if (i2 != -1) {
            int i3 = this.f3142e - i2;
            int i4 = this.f3140c;
            if (i3 < i4) {
                if (i2 == 0 && i4 > bArr.length && this.f3139b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length > i4) {
                        length = i4;
                    }
                    byte[] bArr2 = (byte[]) this.f3143f.b(length, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.a = bArr2;
                    this.f3143f.put(bArr);
                    bArr = bArr2;
                } else {
                    int i5 = this.f3141d;
                    if (i5 > 0) {
                        System.arraycopy(bArr, i5, bArr, 0, bArr.length - i5);
                    }
                }
                this.f3142e -= this.f3141d;
                this.f3141d = 0;
                this.f3139b = 0;
                int i6 = this.f3142e;
                int i7 = inputStream.read(bArr, i6, bArr.length - i6);
                int i8 = this.f3142e;
                if (i7 > 0) {
                    i8 += i7;
                }
                this.f3139b = i8;
                return i7;
            }
        }
        int i9 = inputStream.read(bArr);
        if (i9 > 0) {
            this.f3141d = -1;
            this.f3142e = 0;
            this.f3139b = i9;
        }
        return i9;
    }

    private static IOException e() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.a == null || inputStream == null) {
            throw e();
        }
        return (this.f3139b - this.f3142e) + inputStream.available();
    }

    public synchronized void c() {
        this.f3140c = this.a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.a != null) {
            this.f3143f.put(this.a);
            this.a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void d() {
        if (this.a != null) {
            this.f3143f.put(this.a);
            this.a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        this.f3140c = Math.max(this.f3140c, i2);
        this.f3141d = this.f3142e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw e();
        }
        if (this.f3142e >= this.f3139b && a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.a && (bArr = this.a) == null) {
            throw e();
        }
        if (this.f3139b - this.f3142e <= 0) {
            return -1;
        }
        int i2 = this.f3142e;
        this.f3142e = i2 + 1;
        return bArr[i2] & f1.f12066c;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.a == null) {
            throw new IOException("Stream is closed");
        }
        if (-1 == this.f3141d) {
            throw new a("Mark has been invalidated, pos: " + this.f3142e + " markLimit: " + this.f3140c);
        }
        this.f3142e = this.f3141d;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j2) throws IOException {
        if (j2 < 1) {
            return 0L;
        }
        byte[] bArr = this.a;
        if (bArr == null) {
            throw e();
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw e();
        }
        if (this.f3139b - this.f3142e >= j2) {
            this.f3142e = (int) (((long) this.f3142e) + j2);
            return j2;
        }
        long j3 = ((long) this.f3139b) - ((long) this.f3142e);
        this.f3142e = this.f3139b;
        if (this.f3141d == -1 || j2 > this.f3140c) {
            return j3 + inputStream.skip(j2 - j3);
        }
        if (a(inputStream, bArr) == -1) {
            return j3;
        }
        if (this.f3139b - this.f3142e >= j2 - j3) {
            this.f3142e = (int) ((((long) this.f3142e) + j2) - j3);
            return j2;
        }
        long j4 = (j3 + ((long) this.f3139b)) - ((long) this.f3142e);
        this.f3142e = this.f3139b;
        return j4;
    }

    @VisibleForTesting
    b0(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.p.a0.b bVar, int i2) {
        super(inputStream);
        this.f3141d = -1;
        this.f3143f = bVar;
        this.a = (byte[]) bVar.b(i2, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5;
        byte[] bArr2 = this.a;
        if (bArr2 == null) {
            throw e();
        }
        if (i3 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            if (this.f3142e < this.f3139b) {
                int i6 = this.f3139b - this.f3142e >= i3 ? i3 : this.f3139b - this.f3142e;
                System.arraycopy(bArr2, this.f3142e, bArr, i2, i6);
                this.f3142e += i6;
                if (i6 == i3 || inputStream.available() == 0) {
                    return i6;
                }
                i2 += i6;
                i4 = i3 - i6;
            } else {
                i4 = i3;
            }
            while (true) {
                if (this.f3141d == -1 && i4 >= bArr2.length) {
                    i5 = inputStream.read(bArr, i2, i4);
                    if (i5 == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    }
                    if (bArr2 != this.a && (bArr2 = this.a) == null) {
                        throw e();
                    }
                    i5 = this.f3139b - this.f3142e >= i4 ? i4 : this.f3139b - this.f3142e;
                    System.arraycopy(bArr2, this.f3142e, bArr, i2, i5);
                    this.f3142e += i5;
                }
                i4 -= i5;
                if (i4 == 0) {
                    return i3;
                }
                if (inputStream.available() == 0) {
                    return i3 - i4;
                }
                i2 += i5;
            }
        } else {
            throw e();
        }
    }
}
