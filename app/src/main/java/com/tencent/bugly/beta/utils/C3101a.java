package com.tencent.bugly.beta.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.utils.a */
/* loaded from: classes2.dex */
public class C3101a {

    /* renamed from: a */
    public static long f10018a = -1;

    /* renamed from: b */
    public static long f10019b = 0;

    /* renamed from: c */
    public static long f10020c = 1;

    /* renamed from: d */
    private byte[] f10021d;

    /* renamed from: e */
    private byte[] f10022e;

    /* renamed from: f */
    private byte[] f10023f;

    /* renamed from: g */
    private long f10024g;

    /* renamed from: h */
    private String f10025h;

    /* renamed from: i */
    private BufferedInputStream f10026i;

    /* renamed from: j */
    private long f10027j;

    /* renamed from: k */
    private long f10028k;

    public C3101a(String str) throws Exception {
        this.f10021d = new byte[2];
        this.f10022e = new byte[4];
        this.f10023f = new byte[8];
        this.f10024g = f10020c;
        this.f10025h = null;
        this.f10026i = null;
        this.f10027j = 0L;
        this.f10028k = 0L;
        this.f10025h = str;
        this.f10026i = new BufferedInputStream(new FileInputStream(this.f10025h));
        this.f10027j = 0L;
        this.f10028k = 0L;
    }

    /* renamed from: a */
    public synchronized void m9393a(long j2) {
        this.f10024g = j2;
    }

    /* renamed from: b */
    public synchronized boolean m9397b(long j2) {
        if (this.f10026i == null) {
            return false;
        }
        if (j2 == 0) {
            return true;
        }
        long j3 = j2;
        while (j3 > 0) {
            try {
                j3 -= this.f10026i.skip(j3);
            } catch (IOException unused) {
                return false;
            }
        }
        this.f10027j += j2;
        return true;
    }

    /* renamed from: c */
    public synchronized short m9398c() throws IOException {
        if (this.f10026i == null) {
            return (short) 0;
        }
        this.f10026i.read(this.f10021d);
        short m9384a = m9384a(this.f10021d, this.f10024g);
        this.f10027j += 2;
        this.f10028k += 2;
        return m9384a;
    }

    /* renamed from: d */
    public synchronized int m9399d() throws IOException {
        if (this.f10026i == null) {
            return 0;
        }
        this.f10026i.read(this.f10022e);
        int m9385b = m9385b(this.f10022e, this.f10024g);
        this.f10027j += 4;
        this.f10028k += 4;
        return m9385b;
    }

    /* renamed from: e */
    public synchronized long m9400e() throws IOException {
        if (this.f10026i == null) {
            return 0L;
        }
        this.f10026i.read(this.f10023f);
        long m9388c = m9388c(this.f10023f, this.f10024g);
        this.f10027j += 8;
        this.f10028k += 8;
        return m9388c;
    }

    /* renamed from: f */
    public synchronized long m9401f() throws IOException {
        return m9396b() & 255;
    }

    /* renamed from: g */
    public synchronized long m9402g() throws IOException {
        return m9398c() & 65535;
    }

    /* renamed from: h */
    public synchronized long m9403h() throws IOException {
        return m9399d() & 4294967295L;
    }

    /* renamed from: i */
    public synchronized long m9404i() throws IOException {
        return m9400e();
    }

    /* renamed from: f */
    private static int m9391f(byte[] bArr) {
        if (bArr == null || bArr.length > 4) {
            return -1;
        }
        return (int) m9392g(bArr);
    }

    /* renamed from: g */
    private static long m9392g(byte[] bArr) {
        if (bArr == null || bArr.length > 8) {
            return -1L;
        }
        long j2 = 0;
        for (byte b2 : bArr) {
            j2 = (j2 << 8) | (b2 & 255);
        }
        return j2;
    }

    /* renamed from: a */
    public synchronized boolean m9394a() {
        try {
            if (this.f10026i != null) {
                this.f10026i.close();
            }
            this.f10026i = null;
            this.f10025h = null;
            this.f10027j = 0L;
            this.f10028k = 0L;
        } catch (IOException e2) {
            e2.getMessage();
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private static int m9387c(byte[] bArr) {
        if (bArr == null || bArr.length > 4) {
            return -1;
        }
        return (int) m9389d(bArr);
    }

    /* renamed from: d */
    private static long m9389d(byte[] bArr) {
        if (bArr == null || bArr.length > 8) {
            return -1L;
        }
        long j2 = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            j2 = (j2 << 8) | (bArr[length] & 255);
        }
        return j2;
    }

    /* renamed from: e */
    private static short m9390e(byte[] bArr) {
        if (bArr == null || bArr.length > 2) {
            return (short) -1;
        }
        return (short) m9391f(bArr);
    }

    /* renamed from: b */
    public synchronized byte m9396b() throws IOException {
        if (this.f10026i == null) {
            return (byte) 0;
        }
        byte read = (byte) this.f10026i.read();
        this.f10027j++;
        this.f10028k++;
        return read;
    }

    /* renamed from: c */
    public static long m9388c(byte[] bArr, long j2) {
        if (j2 == f10020c) {
            return m9389d(bArr);
        }
        return m9392g(bArr);
    }

    /* renamed from: a */
    public synchronized boolean m9395a(byte[] bArr) {
        try {
            this.f10026i.read(bArr);
            this.f10027j += bArr.length;
            this.f10028k += bArr.length;
        } catch (IOException e2) {
            e2.getMessage();
            return false;
        }
        return true;
    }

    public C3101a(String str, long j2) throws Exception {
        this.f10021d = new byte[2];
        this.f10022e = new byte[4];
        this.f10023f = new byte[8];
        this.f10024g = f10020c;
        this.f10025h = null;
        this.f10026i = null;
        this.f10027j = 0L;
        this.f10028k = 0L;
        this.f10025h = str;
        this.f10024g = j2;
        this.f10026i = new BufferedInputStream(new FileInputStream(this.f10025h));
        this.f10027j = 0L;
        this.f10028k = 0L;
    }

    /* renamed from: b */
    private static short m9386b(byte[] bArr) {
        if (bArr == null || bArr.length > 2) {
            return (short) -1;
        }
        return (short) m9387c(bArr);
    }

    /* renamed from: b */
    public static int m9385b(byte[] bArr, long j2) {
        if (j2 == f10020c) {
            return m9387c(bArr);
        }
        return m9391f(bArr);
    }

    /* renamed from: a */
    public static short m9384a(byte[] bArr, long j2) {
        if (j2 == f10020c) {
            return m9386b(bArr);
        }
        return m9390e(bArr);
    }
}
