package com.bumptech.glide.load.p116o;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: BufferedOutputStream.java */
/* renamed from: com.bumptech.glide.load.o.c */
/* loaded from: classes.dex */
public final class C1603c extends OutputStream {

    /* renamed from: a */
    @NonNull
    private final OutputStream f4204a;

    /* renamed from: b */
    private byte[] f4205b;

    /* renamed from: c */
    private InterfaceC1623b f4206c;

    /* renamed from: d */
    private int f4207d;

    public C1603c(@NonNull OutputStream outputStream, @NonNull InterfaceC1623b interfaceC1623b) {
        this(outputStream, interfaceC1623b, 65536);
    }

    /* renamed from: c */
    private void m3853c() throws IOException {
        int i2 = this.f4207d;
        if (i2 > 0) {
            this.f4204a.write(this.f4205b, 0, i2);
            this.f4207d = 0;
        }
    }

    /* renamed from: d */
    private void m3854d() throws IOException {
        if (this.f4207d == this.f4205b.length) {
            m3853c();
        }
    }

    /* renamed from: e */
    private void m3855e() {
        byte[] bArr = this.f4205b;
        if (bArr != null) {
            this.f4206c.put(bArr);
            this.f4205b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f4204a.close();
            m3855e();
        } catch (Throwable th) {
            this.f4204a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        m3853c();
        this.f4204a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        byte[] bArr = this.f4205b;
        int i3 = this.f4207d;
        this.f4207d = i3 + 1;
        bArr[i3] = (byte) i2;
        m3854d();
    }

    @VisibleForTesting
    C1603c(@NonNull OutputStream outputStream, InterfaceC1623b interfaceC1623b, int i2) {
        this.f4204a = outputStream;
        this.f4206c = interfaceC1623b;
        this.f4205b = (byte[]) interfaceC1623b.mo3907b(i2, byte[].class);
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
            if (this.f4207d == 0 && i5 >= this.f4205b.length) {
                this.f4204a.write(bArr, i6, i5);
                return;
            }
            int min = Math.min(i5, this.f4205b.length - this.f4207d);
            System.arraycopy(bArr, i6, this.f4205b, this.f4207d, min);
            this.f4207d += min;
            i4 += min;
            m3854d();
        } while (i4 < i3);
    }
}
