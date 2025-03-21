package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: ExceptionCatchingInputStream.java */
/* renamed from: com.bumptech.glide.util.c */
/* loaded from: classes.dex */
public class C1869c extends InputStream {

    /* renamed from: c */
    private static final Queue<C1869c> f5478c = C1878l.m5002a(0);

    /* renamed from: a */
    private InputStream f5479a;

    /* renamed from: b */
    private IOException f5480b;

    C1869c() {
    }

    @NonNull
    /* renamed from: b */
    public static C1869c m4961b(@NonNull InputStream inputStream) {
        C1869c poll;
        synchronized (f5478c) {
            poll = f5478c.poll();
        }
        if (poll == null) {
            poll = new C1869c();
        }
        poll.m4963a(inputStream);
        return poll;
    }

    /* renamed from: e */
    static void m4962e() {
        while (!f5478c.isEmpty()) {
            f5478c.remove();
        }
    }

    /* renamed from: a */
    void m4963a(@NonNull InputStream inputStream) {
        this.f5479a = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f5479a.available();
    }

    @Nullable
    /* renamed from: c */
    public IOException m4964c() {
        return this.f5480b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5479a.close();
    }

    /* renamed from: d */
    public void m4965d() {
        this.f5480b = null;
        this.f5479a = null;
        synchronized (f5478c) {
            f5478c.offer(this);
        }
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        this.f5479a.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f5479a.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f5479a.read(bArr);
        } catch (IOException e2) {
            this.f5480b = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f5479a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j2) {
        try {
            return this.f5479a.skip(j2);
        } catch (IOException e2) {
            this.f5480b = e2;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        try {
            return this.f5479a.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.f5480b = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f5479a.read();
        } catch (IOException e2) {
            this.f5480b = e2;
            return -1;
        }
    }
}
