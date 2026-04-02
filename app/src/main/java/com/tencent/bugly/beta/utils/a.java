package com.tencent.bugly.beta.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static long a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f6091b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f6092c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f6093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f6094e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f6095f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f6096g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f6097h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private BufferedInputStream f6098i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f6099j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f6100k;

    public a(String str) throws Exception {
        this.f6093d = new byte[2];
        this.f6094e = new byte[4];
        this.f6095f = new byte[8];
        this.f6096g = f6092c;
        this.f6097h = null;
        this.f6098i = null;
        this.f6099j = 0L;
        this.f6100k = 0L;
        this.f6097h = str;
        this.f6098i = new BufferedInputStream(new FileInputStream(this.f6097h));
        this.f6099j = 0L;
        this.f6100k = 0L;
    }

    public synchronized void a(long j2) {
        this.f6096g = j2;
    }

    public synchronized boolean b(long j2) {
        if (this.f6098i == null) {
            return false;
        }
        if (j2 == 0) {
            return true;
        }
        long jSkip = j2;
        while (jSkip > 0) {
            try {
                jSkip -= this.f6098i.skip(jSkip);
            } catch (IOException unused) {
                return false;
            }
        }
        this.f6099j += j2;
        return true;
    }

    public synchronized short c() throws IOException {
        if (this.f6098i == null) {
            return (short) 0;
        }
        this.f6098i.read(this.f6093d);
        short sA = a(this.f6093d, this.f6096g);
        this.f6099j += 2;
        this.f6100k += 2;
        return sA;
    }

    public synchronized int d() throws IOException {
        if (this.f6098i == null) {
            return 0;
        }
        this.f6098i.read(this.f6094e);
        int iB = b(this.f6094e, this.f6096g);
        this.f6099j += 4;
        this.f6100k += 4;
        return iB;
    }

    public synchronized long e() throws IOException {
        if (this.f6098i == null) {
            return 0L;
        }
        this.f6098i.read(this.f6095f);
        long jC = c(this.f6095f, this.f6096g);
        this.f6099j += 8;
        this.f6100k += 8;
        return jC;
    }

    public synchronized long f() throws IOException {
        return ((long) b()) & 255;
    }

    public synchronized long g() throws IOException {
        return ((long) c()) & 65535;
    }

    public synchronized long h() throws IOException {
        return ((long) d()) & 4294967295L;
    }

    public synchronized long i() throws IOException {
        return e();
    }

    private static int f(byte[] bArr) {
        if (bArr == null || bArr.length > 4) {
            return -1;
        }
        return (int) g(bArr);
    }

    private static long g(byte[] bArr) {
        if (bArr == null || bArr.length > 8) {
            return -1L;
        }
        long j2 = 0;
        for (byte b2 : bArr) {
            j2 = (j2 << 8) | (((long) b2) & 255);
        }
        return j2;
    }

    public synchronized boolean a() {
        try {
            if (this.f6098i != null) {
                this.f6098i.close();
            }
            this.f6098i = null;
            this.f6097h = null;
            this.f6099j = 0L;
            this.f6100k = 0L;
        } catch (IOException e2) {
            e2.getMessage();
            return false;
        }
        return true;
    }

    private static int c(byte[] bArr) {
        if (bArr == null || bArr.length > 4) {
            return -1;
        }
        return (int) d(bArr);
    }

    private static long d(byte[] bArr) {
        if (bArr == null || bArr.length > 8) {
            return -1L;
        }
        long j2 = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            j2 = (j2 << 8) | (((long) bArr[length]) & 255);
        }
        return j2;
    }

    private static short e(byte[] bArr) {
        if (bArr == null || bArr.length > 2) {
            return (short) -1;
        }
        return (short) f(bArr);
    }

    public synchronized byte b() throws IOException {
        if (this.f6098i == null) {
            return (byte) 0;
        }
        byte b2 = (byte) this.f6098i.read();
        this.f6099j++;
        this.f6100k++;
        return b2;
    }

    public static long c(byte[] bArr, long j2) {
        if (j2 == f6092c) {
            return d(bArr);
        }
        return g(bArr);
    }

    public synchronized boolean a(byte[] bArr) {
        try {
            this.f6098i.read(bArr);
            this.f6099j += (long) bArr.length;
            this.f6100k += (long) bArr.length;
        } catch (IOException e2) {
            e2.getMessage();
            return false;
        }
        return true;
    }

    public a(String str, long j2) throws Exception {
        this.f6093d = new byte[2];
        this.f6094e = new byte[4];
        this.f6095f = new byte[8];
        this.f6096g = f6092c;
        this.f6097h = null;
        this.f6098i = null;
        this.f6099j = 0L;
        this.f6100k = 0L;
        this.f6097h = str;
        this.f6096g = j2;
        this.f6098i = new BufferedInputStream(new FileInputStream(this.f6097h));
        this.f6099j = 0L;
        this.f6100k = 0L;
    }

    private static short b(byte[] bArr) {
        if (bArr == null || bArr.length > 2) {
            return (short) -1;
        }
        return (short) c(bArr);
    }

    public static int b(byte[] bArr, long j2) {
        if (j2 == f6092c) {
            return c(bArr);
        }
        return f(bArr);
    }

    public static short a(byte[] bArr, long j2) {
        if (j2 == f6092c) {
            return b(bArr);
        }
        return e(bArr);
    }
}
