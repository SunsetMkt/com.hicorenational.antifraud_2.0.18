package com.bumptech.glide.n;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: StrictLineReader.java */
/* JADX INFO: loaded from: classes.dex */
class b implements Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte f3370f = 13;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final byte f3371g = 10;
    private final InputStream a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Charset f3372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f3373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3375e;

    /* JADX INFO: compiled from: StrictLineReader.java */
    class a extends ByteArrayOutputStream {
        a(int i2) {
            super(i2);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i2 = ((ByteArrayOutputStream) this).count;
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, (i2 <= 0 || ((ByteArrayOutputStream) this).buf[i2 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i2 - 1, b.this.f3372b.name());
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void e() throws IOException {
        InputStream inputStream = this.a;
        byte[] bArr = this.f3373c;
        int i2 = inputStream.read(bArr, 0, bArr.length);
        if (i2 == -1) {
            throw new EOFException();
        }
        this.f3374d = 0;
        this.f3375e = i2;
    }

    public boolean c() {
        return this.f3375e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.a) {
            if (this.f3373c != null) {
                this.f3373c = null;
                this.a.close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String d() throws IOException {
        int i2;
        int i3;
        synchronized (this.a) {
            if (this.f3373c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f3374d >= this.f3375e) {
                e();
            }
            for (int i4 = this.f3374d; i4 != this.f3375e; i4++) {
                if (this.f3373c[i4] == 10) {
                    if (i4 != this.f3374d) {
                        i3 = i4 - 1;
                        if (this.f3373c[i3] != 13) {
                            i3 = i4;
                        }
                    }
                    String str = new String(this.f3373c, this.f3374d, i3 - this.f3374d, this.f3372b.name());
                    this.f3374d = i4 + 1;
                    return str;
                }
            }
            a aVar = new a((this.f3375e - this.f3374d) + 80);
            loop1: while (true) {
                aVar.write(this.f3373c, this.f3374d, this.f3375e - this.f3374d);
                this.f3375e = -1;
                e();
                i2 = this.f3374d;
                while (i2 != this.f3375e) {
                    if (this.f3373c[i2] == 10) {
                        break loop1;
                    }
                    i2++;
                }
            }
            if (i2 != this.f3374d) {
                aVar.write(this.f3373c, this.f3374d, i2 - this.f3374d);
            }
            this.f3374d = i2 + 1;
            return aVar.toString();
        }
    }

    public b(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.a = inputStream;
        this.f3372b = charset;
        this.f3373c = new byte[i2];
    }
}
