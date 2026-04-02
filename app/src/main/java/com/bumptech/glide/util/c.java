package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: compiled from: ExceptionCatchingInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends InputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Queue<c> f3561c = l.a(0);
    private InputStream a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IOException f3562b;

    c() {
    }

    @NonNull
    public static c b(@NonNull InputStream inputStream) {
        c cVarPoll;
        synchronized (f3561c) {
            cVarPoll = f3561c.poll();
        }
        if (cVarPoll == null) {
            cVarPoll = new c();
        }
        cVarPoll.a(inputStream);
        return cVarPoll;
    }

    static void e() {
        while (!f3561c.isEmpty()) {
            f3561c.remove();
        }
    }

    void a(@NonNull InputStream inputStream) {
        this.a = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.a.available();
    }

    @Nullable
    public IOException c() {
        return this.f3562b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    public void d() {
        this.f3562b = null;
        this.a = null;
        synchronized (f3561c) {
            f3561c.offer(this);
        }
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        this.a.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.a.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.a.read(bArr);
        } catch (IOException e2) {
            this.f3562b = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j2) {
        try {
            return this.a.skip(j2);
        } catch (IOException e2) {
            this.f3562b = e2;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        try {
            return this.a.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.f3562b = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.a.read();
        } catch (IOException e2) {
            this.f3562b = e2;
            return -1;
        }
    }
}
