package com.bumptech.glide.load.o;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: BufferedOutputStream.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends OutputStream {

    @NonNull
    private final OutputStream a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f2725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.load.p.a0.b f2726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2727d;

    public c(@NonNull OutputStream outputStream, @NonNull com.bumptech.glide.load.p.a0.b bVar) {
        this(outputStream, bVar, 65536);
    }

    private void c() throws IOException {
        int i2 = this.f2727d;
        if (i2 > 0) {
            this.a.write(this.f2725b, 0, i2);
            this.f2727d = 0;
        }
    }

    private void d() throws IOException {
        if (this.f2727d == this.f2725b.length) {
            c();
        }
    }

    private void e() {
        byte[] bArr = this.f2725b;
        if (bArr != null) {
            this.f2726c.put(bArr);
            this.f2725b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.a.close();
            e();
        } catch (Throwable th) {
            this.a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        c();
        this.a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        byte[] bArr = this.f2725b;
        int i3 = this.f2727d;
        this.f2727d = i3 + 1;
        bArr[i3] = (byte) i2;
        d();
    }

    @VisibleForTesting
    c(@NonNull OutputStream outputStream, com.bumptech.glide.load.p.a0.b bVar, int i2) {
        this.a = outputStream;
        this.f2726c = bVar;
        this.f2725b = (byte[]) bVar.b(i2, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        do {
            int i5 = i3 - i4;
            int i6 = i2 + i4;
            if (this.f2727d == 0 && i5 >= this.f2725b.length) {
                this.a.write(bArr, i6, i5);
                return;
            }
            int iMin = Math.min(i5, this.f2725b.length - this.f2727d);
            System.arraycopy(bArr, i6, this.f2725b, this.f2727d, iMin);
            this.f2727d += iMin;
            i4 += iMin;
            d();
        } while (i4 < i3);
    }
}
