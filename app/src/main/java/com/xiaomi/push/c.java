package com.xiaomi.push;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private final int a;

    /* JADX INFO: renamed from: a */
    private final OutputStream f244a;

    /* JADX INFO: renamed from: a */
    private final byte[] f245a;

    /* JADX INFO: renamed from: b */
    private int f8790b;

    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private c(byte[] bArr, int i2, int i3) {
        this.f244a = null;
        this.f245a = bArr;
        this.f8790b = i2;
        this.a = i2 + i3;
    }

    public static int a(boolean z) {
        return 1;
    }

    public static c a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    public static int c(long j2) {
        if (((-128) & j2) == 0) {
            return 1;
        }
        if (((-16384) & j2) == 0) {
            return 2;
        }
        if (((-2097152) & j2) == 0) {
            return 3;
        }
        if (((-268435456) & j2) == 0) {
            return 4;
        }
        if (((-34359738368L) & j2) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j2) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j2) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j2) == 0) {
            return 8;
        }
        return (j2 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private void c() throws IOException {
        OutputStream outputStream = this.f244a;
        if (outputStream == null) {
            throw new a();
        }
        outputStream.write(this.f245a, 0, this.f8790b);
        this.f8790b = 0;
    }

    public static int d(int i2) {
        if ((i2 & (-128)) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & (-268435456)) == 0 ? 4 : 5;
    }

    /* JADX INFO: renamed from: b */
    public void m210b(int i2, long j2) throws IOException {
        c(i2, 0);
        m211b(j2);
    }

    /* JADX INFO: renamed from: d */
    public void m214d(int i2) throws IOException {
        while ((i2 & (-128)) != 0) {
            m212c((i2 & 127) | 128);
            i2 >>>= 7;
        }
        m212c(i2);
    }

    public static c a(OutputStream outputStream, int i2) {
        return new c(outputStream, new byte[i2]);
    }

    public static c a(byte[] bArr, int i2, int i3) {
        return new c(bArr, i2, i3);
    }

    /* JADX INFO: renamed from: b */
    public void m209b(int i2, int i3) throws IOException {
        c(i2, 0);
        m208b(i3);
    }

    /* JADX INFO: renamed from: a */
    public void m197a(int i2, long j2) throws IOException {
        c(i2, 0);
        m202a(j2);
    }

    /* JADX INFO: renamed from: b */
    public void m211b(long j2) throws IOException {
        m213c(j2);
    }

    /* JADX INFO: renamed from: c */
    public void m212c(int i2) throws IOException {
        a((byte) i2);
    }

    private c(OutputStream outputStream, byte[] bArr) {
        this.f244a = outputStream;
        this.f245a = bArr;
        this.f8790b = 0;
        this.a = bArr.length;
    }

    /* JADX INFO: renamed from: a */
    public void m196a(int i2, int i3) throws IOException {
        c(i2, 0);
        m195a(i3);
    }

    /* JADX INFO: renamed from: b */
    public void m208b(int i2) throws IOException {
        m214d(i2);
    }

    public void c(int i2, int i3) throws IOException {
        m214d(f.a(i2, i3));
    }

    public static int b(int i2, long j2) {
        return c(i2) + b(j2);
    }

    public static int c(int i2) {
        return d(f.a(i2, 0));
    }

    public static int b(int i2, int i3) {
        return c(i2) + b(i3);
    }

    /* JADX INFO: renamed from: a */
    public void m201a(int i2, boolean z) throws IOException {
        c(i2, 0);
        m206a(z);
    }

    /* JADX INFO: renamed from: c */
    public void m213c(long j2) throws IOException {
        while (((-128) & j2) != 0) {
            m212c((((int) j2) & 127) | 128);
            j2 >>>= 7;
        }
        m212c((int) j2);
    }

    public static int b(long j2) {
        return c(j2);
    }

    public static int b(int i2) {
        return d(i2);
    }

    /* JADX INFO: renamed from: a */
    public void m200a(int i2, String str) throws IOException {
        c(i2, 2);
        m205a(str);
    }

    public void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* JADX INFO: renamed from: a */
    public void m199a(int i2, e eVar) throws IOException {
        c(i2, 2);
        m204a(eVar);
    }

    /* JADX INFO: renamed from: a */
    public void m198a(int i2, com.xiaomi.push.a aVar) throws IOException {
        c(i2, 2);
        m203a(aVar);
    }

    /* JADX INFO: renamed from: a */
    public void m202a(long j2) throws IOException {
        m213c(j2);
    }

    /* JADX INFO: renamed from: a */
    public void m195a(int i2) throws IOException {
        if (i2 >= 0) {
            m214d(i2);
        } else {
            m213c(i2);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m206a(boolean z) throws IOException {
        m212c(z ? 1 : 0);
    }

    /* JADX INFO: renamed from: a */
    public void m205a(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        m214d(bytes.length);
        a(bytes);
    }

    /* JADX INFO: renamed from: a */
    public void m204a(e eVar) throws IOException {
        m214d(eVar.a());
        eVar.a(this);
    }

    /* JADX INFO: renamed from: a */
    public void m203a(com.xiaomi.push.a aVar) throws IOException {
        byte[] bArrM125a = aVar.m125a();
        m214d(bArrM125a.length);
        a(bArrM125a);
    }

    public static int a(int i2, long j2) {
        return c(i2) + a(j2);
    }

    public static int a(int i2, int i3) {
        return c(i2) + a(i3);
    }

    public static int a(int i2, boolean z) {
        return c(i2) + a(z);
    }

    public static int a(int i2, String str) {
        return c(i2) + a(str);
    }

    public static int a(int i2, e eVar) {
        return c(i2) + a(eVar);
    }

    public static int a(int i2, com.xiaomi.push.a aVar) {
        return c(i2) + a(aVar);
    }

    public static int a(long j2) {
        return c(j2);
    }

    public static int a(int i2) {
        if (i2 >= 0) {
            return d(i2);
        }
        return 10;
    }

    public static int a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return d(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int a(e eVar) {
        int iB = eVar.b();
        return d(iB) + iB;
    }

    public static int a(com.xiaomi.push.a aVar) {
        return d(aVar.a()) + aVar.a();
    }

    /* JADX INFO: renamed from: a */
    public void m194a() throws IOException {
        if (this.f244a != null) {
            c();
        }
    }

    public int a() {
        if (this.f244a == null) {
            return this.a - this.f8790b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void a(byte b2) throws IOException {
        if (this.f8790b == this.a) {
            c();
        }
        byte[] bArr = this.f245a;
        int i2 = this.f8790b;
        this.f8790b = i2 + 1;
        bArr[i2] = b2;
    }

    public void a(byte[] bArr) throws IOException {
        m207a(bArr, 0, bArr.length);
    }

    /* JADX INFO: renamed from: a */
    public void m207a(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.a;
        int i5 = this.f8790b;
        if (i4 - i5 >= i3) {
            System.arraycopy(bArr, i2, this.f245a, i5, i3);
            this.f8790b += i3;
            return;
        }
        int i6 = i4 - i5;
        System.arraycopy(bArr, i2, this.f245a, i5, i6);
        int i7 = i2 + i6;
        int i8 = i3 - i6;
        this.f8790b = this.a;
        c();
        if (i8 <= this.a) {
            System.arraycopy(bArr, i7, this.f245a, 0, i8);
            this.f8790b = i8;
        } else {
            this.f244a.write(bArr, i7, i8);
        }
    }
}
