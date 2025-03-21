package com.bumptech.glide.n;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader.java */
/* loaded from: classes.dex */
class b implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    private static final byte f5130f = 13;

    /* renamed from: g, reason: collision with root package name */
    private static final byte f5131g = 10;

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f5132a;

    /* renamed from: b, reason: collision with root package name */
    private final Charset f5133b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f5134c;

    /* renamed from: d, reason: collision with root package name */
    private int f5135d;

    /* renamed from: e, reason: collision with root package name */
    private int f5136e;

    /* compiled from: StrictLineReader.java */
    class a extends ByteArrayOutputStream {
        a(int i2) {
            super(i2);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i2 = ((ByteArrayOutputStream) this).count;
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, (i2 <= 0 || ((ByteArrayOutputStream) this).buf[i2 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i2 - 1, b.this.f5133b.name());
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void e() throws IOException {
        InputStream inputStream = this.f5132a;
        byte[] bArr = this.f5134c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f5135d = 0;
        this.f5136e = read;
    }

    public boolean c() {
        return this.f5136e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f5132a) {
            if (this.f5134c != null) {
                this.f5134c = null;
                this.f5132a.close();
            }
        }
    }

    public String d() throws IOException {
        int i2;
        int i3;
        synchronized (this.f5132a) {
            if (this.f5134c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f5135d >= this.f5136e) {
                e();
            }
            for (int i4 = this.f5135d; i4 != this.f5136e; i4++) {
                if (this.f5134c[i4] == 10) {
                    if (i4 != this.f5135d) {
                        i3 = i4 - 1;
                        if (this.f5134c[i3] == 13) {
                            String str = new String(this.f5134c, this.f5135d, i3 - this.f5135d, this.f5133b.name());
                            this.f5135d = i4 + 1;
                            return str;
                        }
                    }
                    i3 = i4;
                    String str2 = new String(this.f5134c, this.f5135d, i3 - this.f5135d, this.f5133b.name());
                    this.f5135d = i4 + 1;
                    return str2;
                }
            }
            a aVar = new a((this.f5136e - this.f5135d) + 80);
            loop1: while (true) {
                aVar.write(this.f5134c, this.f5135d, this.f5136e - this.f5135d);
                this.f5136e = -1;
                e();
                i2 = this.f5135d;
                while (i2 != this.f5136e) {
                    if (this.f5134c[i2] == 10) {
                        break loop1;
                    }
                    i2++;
                }
            }
            if (i2 != this.f5135d) {
                aVar.write(this.f5134c, this.f5135d, i2 - this.f5135d);
            }
            this.f5135d = i2 + 1;
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
        if (!charset.equals(c.f5138a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f5132a = inputStream;
        this.f5133b = charset;
        this.f5134c = new byte[i2];
    }
}
