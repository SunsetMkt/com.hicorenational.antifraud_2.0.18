package com.tencent.bugly.beta.utils;

import i.q2.t.n;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private String a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f6102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f6103d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f6101b = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f6104e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashMap<Long, String> f6105f = new HashMap<>();

    public b(String str, long j2, long j3) {
        this.a = null;
        this.f6102c = 0L;
        this.f6103d = 0L;
        this.f6105f.put(1L, "armeabi-v4");
        this.f6105f.put(2L, "armeabi-v4t");
        this.f6105f.put(3L, "armeabi-v5t");
        this.f6105f.put(4L, "armeabi-v5te");
        this.f6105f.put(5L, "armeabi-v5tej");
        this.f6105f.put(6L, "armeabi-v6");
        this.f6105f.put(7L, "armeabi-v6kz");
        this.f6105f.put(8L, "armeabi-v6t2");
        this.f6105f.put(9L, "armeabi-v6k");
        this.f6105f.put(10L, "armeabi-v7a");
        this.f6105f.put(11L, "armeabi-v6-m");
        this.f6105f.put(12L, "armeabi-v6s-m");
        this.f6105f.put(13L, "armeabi-v7e-m");
        this.f6105f.put(14L, "armeabi-v8a");
        this.a = str;
        this.f6102c = j2;
        this.f6103d = j3;
    }

    private boolean a() {
        return 0 != this.f6103d;
    }

    private synchronized void b() {
        if (this.f6101b == null) {
            return;
        }
        if (this.f6101b.a()) {
            this.f6101b = null;
        }
    }

    private synchronized boolean c() {
        if (!a()) {
            return false;
        }
        if (this.f6101b != null) {
            b();
        }
        try {
            this.f6101b = new a(this.a, this.f6102c);
            return this.f6101b.b(this.f6103d);
        } catch (Exception e2) {
            e2.getMessage();
            return false;
        }
    }

    private synchronized String d() {
        StringBuilder sb;
        sb = new StringBuilder();
        while (true) {
            try {
                char cB = (char) this.f6101b.b();
                if (cB != 0) {
                    sb.append(cB);
                }
            } catch (IOException e2) {
                e2.getMessage();
                return null;
            }
        }
        return sb.toString();
    }

    private String e() {
        return d();
    }

    private synchronized boolean f() {
        try {
            if (65 != this.f6101b.f()) {
                return false;
            }
            long jH = this.f6101b.h();
            String strE = e();
            if (strE != null && strE.equals("aeabi")) {
                long length = jH - ((long) strE.length());
                while (length > 0) {
                    long jF = this.f6101b.f();
                    long jH2 = this.f6101b.h() - 5;
                    if (1 == jF) {
                        return a(jH2);
                    }
                    this.f6101b.b(jH2);
                }
                return true;
            }
            return false;
        } catch (IOException e2) {
            e2.getMessage();
            return false;
        }
    }

    private boolean g() {
        if (!c()) {
            b();
            return false;
        }
        f();
        b();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x004c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0001 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean a(long j2) {
        String strD;
        while (j2 > 0) {
            try {
                int iA = (int) a(this.f6101b);
                if (iA != 34 && iA != 36 && iA != 38 && iA != 42 && iA != 44 && iA != 70) {
                    switch (iA) {
                        case 4:
                        case 5:
                        case 32:
                            strD = d();
                            if (strD == null) {
                                j2 -= (long) strD.length();
                            }
                            break;
                        case 6:
                            this.f6104e = this.f6105f.get(Long.valueOf(a(this.f6101b)));
                            return true;
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                            break;
                        default:
                            switch (iA) {
                                case 64:
                                case 66:
                                case 68:
                                    break;
                                case 65:
                                case 67:
                                    strD = d();
                                    if (strD == null) {
                                    }
                                    break;
                                default:
                                    return false;
                            }
                            break;
                    }
                }
                a(this.f6101b);
            } catch (IOException e2) {
                e2.getMessage();
                return false;
            }
        }
        return false;
    }

    public static String a(String str, long j2, long j3) {
        b bVar = new b(str, j2, j3);
        if (bVar.g()) {
            return bVar.f6104e;
        }
        return null;
    }

    public static synchronized long a(a aVar) throws IOException {
        long j2;
        byte b2;
        j2 = 0;
        long j3 = 0;
        do {
            b2 = aVar.b();
            j2 |= (((long) b2) & 127) << ((int) j3);
            j3 += 7;
        } while ((b2 & n.a) != 0);
        return j2;
    }
}
