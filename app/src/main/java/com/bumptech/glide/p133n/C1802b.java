package com.bumptech.glide.p133n;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader.java */
/* renamed from: com.bumptech.glide.n.b */
/* loaded from: classes.dex */
class C1802b implements Closeable {

    /* renamed from: f */
    private static final byte f5143f = 13;

    /* renamed from: g */
    private static final byte f5144g = 10;

    /* renamed from: a */
    private final InputStream f5145a;

    /* renamed from: b */
    private final Charset f5146b;

    /* renamed from: c */
    private byte[] f5147c;

    /* renamed from: d */
    private int f5148d;

    /* renamed from: e */
    private int f5149e;

    /* compiled from: StrictLineReader.java */
    /* renamed from: com.bumptech.glide.n.b$a */
    class a extends ByteArrayOutputStream {
        a(int i2) {
            super(i2);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i2 = ((ByteArrayOutputStream) this).count;
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, (i2 <= 0 || ((ByteArrayOutputStream) this).buf[i2 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i2 - 1, C1802b.this.f5146b.name());
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public C1802b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    /* renamed from: e */
    private void m4628e() throws IOException {
        InputStream inputStream = this.f5145a;
        byte[] bArr = this.f5147c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f5148d = 0;
        this.f5149e = read;
    }

    /* renamed from: c */
    public boolean m4629c() {
        return this.f5149e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f5145a) {
            if (this.f5147c != null) {
                this.f5147c = null;
                this.f5145a.close();
            }
        }
    }

    /* renamed from: d */
    public String m4630d() throws IOException {
        int i2;
        int i3;
        synchronized (this.f5145a) {
            if (this.f5147c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f5148d >= this.f5149e) {
                m4628e();
            }
            for (int i4 = this.f5148d; i4 != this.f5149e; i4++) {
                if (this.f5147c[i4] == 10) {
                    if (i4 != this.f5148d) {
                        i3 = i4 - 1;
                        if (this.f5147c[i3] == 13) {
                            String str = new String(this.f5147c, this.f5148d, i3 - this.f5148d, this.f5146b.name());
                            this.f5148d = i4 + 1;
                            return str;
                        }
                    }
                    i3 = i4;
                    String str2 = new String(this.f5147c, this.f5148d, i3 - this.f5148d, this.f5146b.name());
                    this.f5148d = i4 + 1;
                    return str2;
                }
            }
            a aVar = new a((this.f5149e - this.f5148d) + 80);
            loop1: while (true) {
                aVar.write(this.f5147c, this.f5148d, this.f5149e - this.f5148d);
                this.f5149e = -1;
                m4628e();
                i2 = this.f5148d;
                while (i2 != this.f5149e) {
                    if (this.f5147c[i2] == 10) {
                        break loop1;
                    }
                    i2++;
                }
            }
            if (i2 != this.f5148d) {
                aVar.write(this.f5147c, this.f5148d, i2 - this.f5148d);
            }
            this.f5148d = i2 + 1;
            return aVar.toString();
        }
    }

    public C1802b(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(C1803c.f5151a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f5145a = inputStream;
        this.f5146b = charset;
        this.f5147c = new byte[i2];
    }
}
