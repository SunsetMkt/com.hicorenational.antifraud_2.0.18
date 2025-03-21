package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: MarkEnforcingInputStream.java */
/* renamed from: com.bumptech.glide.util.h */
/* loaded from: classes.dex */
public class C1874h extends FilterInputStream {

    /* renamed from: b */
    private static final int f5490b = Integer.MIN_VALUE;

    /* renamed from: c */
    private static final int f5491c = -1;

    /* renamed from: a */
    private int f5492a;

    public C1874h(@NonNull InputStream inputStream) {
        super(inputStream);
        this.f5492a = Integer.MIN_VALUE;
    }

    /* renamed from: a */
    private long m4981a(long j2) {
        int i2 = this.f5492a;
        if (i2 == 0) {
            return -1L;
        }
        return (i2 == Integer.MIN_VALUE || j2 <= ((long) i2)) ? j2 : i2;
    }

    /* renamed from: b */
    private void m4982b(long j2) {
        int i2 = this.f5492a;
        if (i2 == Integer.MIN_VALUE || j2 == -1) {
            return;
        }
        this.f5492a = (int) (i2 - j2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i2 = this.f5492a;
        return i2 == Integer.MIN_VALUE ? super.available() : Math.min(i2, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        super.mark(i2);
        this.f5492a = i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (m4981a(1L) == -1) {
            return -1;
        }
        int read = super.read();
        m4982b(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.f5492a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        long m4981a = m4981a(j2);
        if (m4981a == -1) {
            return 0L;
        }
        long skip = super.skip(m4981a);
        m4982b(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int m4981a = (int) m4981a(i3);
        if (m4981a == -1) {
            return -1;
        }
        int read = super.read(bArr, i2, m4981a);
        m4982b(read);
        return read;
    }
}
