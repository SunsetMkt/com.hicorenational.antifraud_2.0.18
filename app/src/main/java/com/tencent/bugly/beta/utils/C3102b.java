package com.tencent.bugly.beta.utils;

import java.io.IOException;
import java.util.HashMap;
import p286h.p309q2.p311t.C5558n;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.utils.b */
/* loaded from: classes2.dex */
public class C3102b {

    /* renamed from: a */
    private String f10029a;

    /* renamed from: c */
    private long f10031c;

    /* renamed from: d */
    private long f10032d;

    /* renamed from: b */
    private C3101a f10030b = null;

    /* renamed from: e */
    private String f10033e = null;

    /* renamed from: f */
    private final HashMap<Long, String> f10034f = new HashMap<>();

    public C3102b(String str, long j2, long j3) {
        this.f10029a = null;
        this.f10031c = 0L;
        this.f10032d = 0L;
        this.f10034f.put(1L, "armeabi-v4");
        this.f10034f.put(2L, "armeabi-v4t");
        this.f10034f.put(3L, "armeabi-v5t");
        this.f10034f.put(4L, "armeabi-v5te");
        this.f10034f.put(5L, "armeabi-v5tej");
        this.f10034f.put(6L, "armeabi-v6");
        this.f10034f.put(7L, "armeabi-v6kz");
        this.f10034f.put(8L, "armeabi-v6t2");
        this.f10034f.put(9L, "armeabi-v6k");
        this.f10034f.put(10L, "armeabi-v7a");
        this.f10034f.put(11L, "armeabi-v6-m");
        this.f10034f.put(12L, "armeabi-v6s-m");
        this.f10034f.put(13L, "armeabi-v7e-m");
        this.f10034f.put(14L, "armeabi-v8a");
        this.f10029a = str;
        this.f10031c = j2;
        this.f10032d = j3;
    }

    /* renamed from: a */
    private boolean m9407a() {
        return 0 != this.f10032d;
    }

    /* renamed from: b */
    private synchronized void m9409b() {
        if (this.f10030b == null) {
            return;
        }
        if (this.f10030b.m9394a()) {
            this.f10030b = null;
        }
    }

    /* renamed from: c */
    private synchronized boolean m9410c() {
        if (!m9407a()) {
            return false;
        }
        if (this.f10030b != null) {
            m9409b();
        }
        try {
            this.f10030b = new C3101a(this.f10029a, this.f10031c);
            return this.f10030b.m9397b(this.f10032d);
        } catch (Exception e2) {
            e2.getMessage();
            return false;
        }
    }

    /* renamed from: d */
    private synchronized String m9411d() {
        StringBuilder sb;
        sb = new StringBuilder();
        while (true) {
            try {
                char m9396b = (char) this.f10030b.m9396b();
                if (m9396b != 0) {
                    sb.append(m9396b);
                }
            } catch (IOException e2) {
                e2.getMessage();
                return null;
            }
        }
        return sb.toString();
    }

    /* renamed from: e */
    private String m9412e() {
        return m9411d();
    }

    /* renamed from: f */
    private synchronized boolean m9413f() {
        try {
            if (65 != this.f10030b.m9401f()) {
                return false;
            }
            long m9403h = this.f10030b.m9403h();
            String m9412e = m9412e();
            if (m9412e != null && m9412e.equals("aeabi")) {
                long length = m9403h - m9412e.length();
                while (length > 0) {
                    long m9401f = this.f10030b.m9401f();
                    long m9403h2 = this.f10030b.m9403h() - 5;
                    if (1 == m9401f) {
                        return m9408a(m9403h2);
                    }
                    this.f10030b.m9397b(m9403h2);
                }
                return true;
            }
            return false;
        } catch (IOException e2) {
            e2.getMessage();
            return false;
        }
    }

    /* renamed from: g */
    private boolean m9414g() {
        if (!m9410c()) {
            m9409b();
            return false;
        }
        m9413f();
        m9409b();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x004c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0001 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean m9408a(long r5) {
        /*
            r4 = this;
            monitor-enter(r4)
        L1:
            r0 = 0
            r2 = 0
            int r3 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r3 <= 0) goto L63
            com.tencent.bugly.beta.utils.a r0 = r4.f10030b     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            long r0 = m9405a(r0)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            int r1 = (int) r0
            r0 = 34
            if (r1 == r0) goto L53
            r0 = 36
            if (r1 == r0) goto L53
            r0 = 38
            if (r1 == r0) goto L53
            r0 = 42
            if (r1 == r0) goto L53
            r0 = 44
            if (r1 == r0) goto L53
            r0 = 70
            if (r1 == r0) goto L53
            switch(r1) {
                case 4: goto L46;
                case 5: goto L46;
                case 6: goto L2f;
                case 7: goto L53;
                case 8: goto L53;
                case 9: goto L53;
                case 10: goto L53;
                case 11: goto L53;
                case 12: goto L53;
                case 13: goto L53;
                case 14: goto L53;
                case 15: goto L53;
                case 16: goto L53;
                case 17: goto L53;
                case 18: goto L53;
                case 19: goto L53;
                case 20: goto L53;
                case 21: goto L53;
                case 22: goto L53;
                case 23: goto L53;
                case 24: goto L53;
                case 25: goto L53;
                case 26: goto L53;
                case 27: goto L53;
                case 28: goto L53;
                case 29: goto L53;
                case 30: goto L53;
                case 31: goto L53;
                case 32: goto L46;
                default: goto L2a;
            }
        L2a:
            switch(r1) {
                case 64: goto L53;
                case 65: goto L46;
                case 66: goto L53;
                case 67: goto L46;
                case 68: goto L53;
                default: goto L2d;
            }
        L2d:
            monitor-exit(r4)
            return r2
        L2f:
            com.tencent.bugly.beta.utils.a r5 = r4.f10030b     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            long r5 = m9405a(r5)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            java.util.HashMap<java.lang.Long, java.lang.String> r0 = r4.f10034f     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            java.lang.Object r5 = r0.get(r5)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            r4.f10033e = r5     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            r5 = 1
            monitor-exit(r4)
            return r5
        L46:
            java.lang.String r0 = r4.m9411d()     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            if (r0 == 0) goto L1
            int r0 = r0.length()     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            long r0 = (long) r0     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            long r5 = r5 - r0
            goto L1
        L53:
            com.tencent.bugly.beta.utils.a r0 = r4.f10030b     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            m9405a(r0)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            goto L1
        L59:
            r5 = move-exception
            goto L61
        L5b:
            r5 = move-exception
            r5.getMessage()     // Catch: java.lang.Throwable -> L59
            monitor-exit(r4)
            return r2
        L61:
            monitor-exit(r4)
            throw r5
        L63:
            monitor-exit(r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.utils.C3102b.m9408a(long):boolean");
    }

    /* renamed from: a */
    public static String m9406a(String str, long j2, long j3) {
        C3102b c3102b = new C3102b(str, j2, j3);
        if (c3102b.m9414g()) {
            return c3102b.f10033e;
        }
        return null;
    }

    /* renamed from: a */
    public static synchronized long m9405a(C3101a c3101a) throws IOException {
        long j2;
        byte m9396b;
        synchronized (C3102b.class) {
            j2 = 0;
            long j3 = 0;
            do {
                m9396b = c3101a.m9396b();
                j2 |= (m9396b & 127) << ((int) j3);
                j3 += 7;
            } while ((m9396b & C5558n.f20401a) != 0);
        }
        return j2;
    }
}
