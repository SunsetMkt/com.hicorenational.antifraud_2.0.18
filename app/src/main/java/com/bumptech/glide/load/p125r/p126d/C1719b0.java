package com.bumptech.glide.load.p125r.p126d;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import p286h.C5230f1;

/* compiled from: RecyclableBufferedInputStream.java */
/* renamed from: com.bumptech.glide.load.r.d.b0 */
/* loaded from: classes.dex */
public class C1719b0 extends FilterInputStream {

    /* renamed from: a */
    private volatile byte[] f4817a;

    /* renamed from: b */
    private int f4818b;

    /* renamed from: c */
    private int f4819c;

    /* renamed from: d */
    private int f4820d;

    /* renamed from: e */
    private int f4821e;

    /* renamed from: f */
    private final InterfaceC1623b f4822f;

    /* compiled from: RecyclableBufferedInputStream.java */
    /* renamed from: com.bumptech.glide.load.r.d.b0$a */
    static class a extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        a(String str) {
            super(str);
        }
    }

    public C1719b0(@NonNull InputStream inputStream, @NonNull InterfaceC1623b interfaceC1623b) {
        this(inputStream, interfaceC1623b, 65536);
    }

    /* renamed from: a */
    private int m4304a(InputStream inputStream, byte[] bArr) throws IOException {
        int i2 = this.f4820d;
        if (i2 != -1) {
            int i3 = this.f4821e - i2;
            int i4 = this.f4819c;
            if (i3 < i4) {
                if (i2 == 0 && i4 > bArr.length && this.f4818b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length > i4) {
                        length = i4;
                    }
                    byte[] bArr2 = (byte[]) this.f4822f.mo3907b(length, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f4817a = bArr2;
                    this.f4822f.put(bArr);
                    bArr = bArr2;
                } else {
                    int i5 = this.f4820d;
                    if (i5 > 0) {
                        System.arraycopy(bArr, i5, bArr, 0, bArr.length - i5);
                    }
                }
                this.f4821e -= this.f4820d;
                this.f4820d = 0;
                this.f4818b = 0;
                int i6 = this.f4821e;
                int read = inputStream.read(bArr, i6, bArr.length - i6);
                int i7 = this.f4821e;
                if (read > 0) {
                    i7 += read;
                }
                this.f4818b = i7;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f4820d = -1;
            this.f4821e = 0;
            this.f4818b = read2;
        }
        return read2;
    }

    /* renamed from: e */
    private static IOException m4305e() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f4817a == null || inputStream == null) {
            throw m4305e();
        }
        return (this.f4818b - this.f4821e) + inputStream.available();
    }

    /* renamed from: c */
    public synchronized void m4306c() {
        this.f4819c = this.f4817a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f4817a != null) {
            this.f4822f.put(this.f4817a);
            this.f4817a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    /* renamed from: d */
    public synchronized void m4307d() {
        if (this.f4817a != null) {
            this.f4822f.put(this.f4817a);
            this.f4817a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        this.f4819c = Math.max(this.f4819c, i2);
        this.f4820d = this.f4821e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f4817a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw m4305e();
        }
        if (this.f4821e >= this.f4818b && m4304a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f4817a && (bArr = this.f4817a) == null) {
            throw m4305e();
        }
        if (this.f4818b - this.f4821e <= 0) {
            return -1;
        }
        int i2 = this.f4821e;
        this.f4821e = i2 + 1;
        return bArr[i2] & C5230f1.f20085c;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f4817a == null) {
            throw new IOException("Stream is closed");
        }
        if (-1 == this.f4820d) {
            throw new a("Mark has been invalidated, pos: " + this.f4821e + " markLimit: " + this.f4819c);
        }
        this.f4821e = this.f4820d;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j2) throws IOException {
        if (j2 < 1) {
            return 0L;
        }
        byte[] bArr = this.f4817a;
        if (bArr == null) {
            throw m4305e();
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw m4305e();
        }
        if (this.f4818b - this.f4821e >= j2) {
            this.f4821e = (int) (this.f4821e + j2);
            return j2;
        }
        long j3 = this.f4818b - this.f4821e;
        this.f4821e = this.f4818b;
        if (this.f4820d == -1 || j2 > this.f4819c) {
            return j3 + inputStream.skip(j2 - j3);
        }
        if (m4304a(inputStream, bArr) == -1) {
            return j3;
        }
        if (this.f4818b - this.f4821e >= j2 - j3) {
            this.f4821e = (int) ((this.f4821e + j2) - j3);
            return j2;
        }
        long j4 = (j3 + this.f4818b) - this.f4821e;
        this.f4821e = this.f4818b;
        return j4;
    }

    @VisibleForTesting
    C1719b0(@NonNull InputStream inputStream, @NonNull InterfaceC1623b interfaceC1623b, int i2) {
        super(inputStream);
        this.f4820d = -1;
        this.f4822f = interfaceC1623b;
        this.f4817a = (byte[]) interfaceC1623b.mo3907b(i2, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5;
        byte[] bArr2 = this.f4817a;
        if (bArr2 == null) {
            throw m4305e();
        }
        if (i3 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            if (this.f4821e < this.f4818b) {
                int i6 = this.f4818b - this.f4821e >= i3 ? i3 : this.f4818b - this.f4821e;
                System.arraycopy(bArr2, this.f4821e, bArr, i2, i6);
                this.f4821e += i6;
                if (i6 == i3 || inputStream.available() == 0) {
                    return i6;
                }
                i2 += i6;
                i4 = i3 - i6;
            } else {
                i4 = i3;
            }
            while (true) {
                if (this.f4820d == -1 && i4 >= bArr2.length) {
                    i5 = inputStream.read(bArr, i2, i4);
                    if (i5 == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    }
                } else {
                    if (m4304a(inputStream, bArr2) == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    }
                    if (bArr2 != this.f4817a && (bArr2 = this.f4817a) == null) {
                        throw m4305e();
                    }
                    i5 = this.f4818b - this.f4821e >= i4 ? i4 : this.f4818b - this.f4821e;
                    System.arraycopy(bArr2, this.f4821e, bArr, i2, i5);
                    this.f4821e += i5;
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
            throw m4305e();
        }
    }
}
