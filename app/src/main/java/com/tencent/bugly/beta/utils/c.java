package com.tencent.bugly.beta.utils;

import com.tencent.bugly.proguard.an;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static HashMap<Long, String> u = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6106b;
    private com.tencent.bugly.beta.utils.a a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f6107c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f6108d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap<String, b> f6109e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f6110f = new byte[16];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f6111g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f6112h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f6113i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f6114j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f6115k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f6116l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f6117m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f6118n = 0;
    private long o = 0;
    private long p = 0;
    private long q = 0;
    private long r = 0;
    private long s = 0;
    private long t = 0;

    /* JADX INFO: compiled from: BUGLY */
    public static class a {
        private long a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f6119b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f6120c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f6121d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f6122e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f6123f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f6124g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f6125h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f6126i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f6127j = 0;

        public long a() {
            return this.a;
        }

        public long b() {
            return this.f6121d;
        }

        public long c() {
            return this.f6122e;
        }

        public long d() {
            return this.f6123f;
        }

        public long e() {
            return this.f6127j;
        }

        public synchronized void f(long j2) {
            this.f6123f = j2;
        }

        public synchronized void g(long j2) {
            this.f6124g = j2;
        }

        public synchronized void h(long j2) {
            this.f6125h = j2;
        }

        public synchronized void i(long j2) {
            this.f6126i = j2;
        }

        public synchronized void j(long j2) {
            this.f6127j = j2;
        }

        public synchronized void a(long j2) {
            this.a = j2;
        }

        public synchronized void b(long j2) {
            this.f6119b = j2;
        }

        public synchronized void c(long j2) {
            this.f6120c = j2;
        }

        public synchronized void d(long j2) {
            this.f6122e = j2;
        }

        public synchronized void e(long j2) {
            this.f6121d = j2;
        }
    }

    /* JADX INFO: compiled from: BUGLY */
    public static class b {
        private String a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f6128b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f6129c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f6130d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f6131e = 0;

        public long a() {
            return this.f6129c;
        }

        public synchronized void b(long j2) {
            this.f6129c = j2;
        }

        public synchronized void c(long j2) {
            this.f6130d = j2;
        }

        public synchronized void d(long j2) {
            this.f6131e = j2;
        }

        public synchronized void a(String str) {
            this.a = str;
        }

        public synchronized void a(long j2) {
            this.f6128b = j2;
        }
    }

    public c(String str) {
        this.f6106b = null;
        this.f6106b = str;
        u.put(3L, "x86");
        u.put(7L, "x86");
        u.put(8L, "mips");
        u.put(10L, "mips");
        u.put(40L, "armeabi");
        u.put(62L, "x86_64");
        u.put(183L, "arm64-v8a");
    }

    private long a(byte b2) {
        if (1 == b2) {
            return 32L;
        }
        return 2 == b2 ? 64L : 0L;
    }

    private String b() {
        return this.f6113i;
    }

    private long c() {
        return this.f6117m;
    }

    private long d() {
        return this.s;
    }

    private long e() {
        return this.t;
    }

    private boolean f() {
        if (!l()) {
            return false;
        }
        if (g()) {
            j();
            return true;
        }
        j();
        return false;
    }

    private synchronized boolean g() {
        if (!h()) {
            return false;
        }
        try {
            this.f6111g = this.a.g();
            this.f6112h = this.a.g();
            this.f6113i = a(this.f6112h, this.f6107c);
            this.f6114j = this.a.h();
            if (32 == this.f6107c) {
                long jH = this.a.h();
                this.f6114j = jH;
                this.f6115k = jH;
                this.f6116l = this.a.h();
                this.f6117m = this.a.h();
            } else {
                if (64 != this.f6107c) {
                    return false;
                }
                long jI = this.a.i();
                this.f6114j = jI;
                this.f6115k = jI;
                this.f6116l = this.a.i();
                this.f6117m = this.a.i();
            }
            this.f6118n = this.a.h();
            this.o = this.a.g();
            this.p = this.a.g();
            this.q = this.a.g();
            this.r = this.a.g();
            this.s = this.a.g();
            this.t = this.a.g();
            return true;
        } catch (IOException e2) {
            e2.getMessage();
            return false;
        }
    }

    private synchronized boolean h() {
        if (!this.a.a(this.f6110f)) {
            return false;
        }
        if (!a(this.f6110f)) {
            String str = "Not a elf file: " + this.f6106b;
            return false;
        }
        this.f6107c = a(this.f6110f[4]);
        if (0 == this.f6107c) {
            String str2 = "File format error: " + ((int) this.f6110f[4]);
            return false;
        }
        this.f6108d = b(this.f6110f[5]);
        if (com.tencent.bugly.beta.utils.a.a != this.f6108d) {
            this.a.a(this.f6108d);
            return true;
        }
        String str3 = "Endian error: " + ((int) this.f6110f[5]);
        return false;
    }

    private synchronized boolean i() {
        this.f6109e = a(c(), d(), e());
        return this.f6109e != null;
    }

    private synchronized void j() {
        if (this.a == null) {
            return;
        }
        if (this.a.a()) {
            this.a = null;
        }
    }

    private synchronized boolean k() {
        if (this.a != null) {
            j();
        }
        try {
            this.a = new com.tencent.bugly.beta.utils.a(this.f6106b, this.f6108d);
        } catch (Exception e2) {
            e2.getMessage();
            return false;
        }
        return true;
    }

    private synchronized boolean l() {
        if (this.a != null) {
            j();
        }
        try {
            this.a = new com.tencent.bugly.beta.utils.a(this.f6106b);
        } catch (Exception e2) {
            e2.getMessage();
            return false;
        }
        return true;
    }

    private synchronized a m() {
        a aVar = new a();
        try {
            aVar.a(this.a.h());
            aVar.b(this.a.h());
            if (32 == this.f6107c) {
                aVar.c(this.a.h());
                aVar.e(this.a.h());
                aVar.d(this.a.h());
                aVar.f(this.a.h());
            } else {
                if (64 != this.f6107c) {
                    return null;
                }
                aVar.c(this.a.i());
                aVar.e(this.a.i());
                aVar.d(this.a.i());
                aVar.f(this.a.i());
            }
            aVar.g(this.a.h());
            aVar.h(this.a.h());
            if (32 == this.f6107c) {
                aVar.i(this.a.h());
                aVar.j(this.a.h());
            } else {
                if (64 != this.f6107c) {
                    return null;
                }
                aVar.i(this.a.i());
                aVar.j(this.a.i());
            }
            return aVar;
        } catch (IOException e2) {
            e2.getMessage();
            return null;
        }
    }

    public synchronized String a() {
        if (!f()) {
            return null;
        }
        String strB = b();
        if (!strB.equals("armeabi")) {
            return strB;
        }
        if (!i()) {
            return strB;
        }
        b bVar = this.f6109e.get(".ARM.attributes");
        if (bVar == null) {
            return strB;
        }
        return com.tencent.bugly.beta.utils.b.a(this.f6106b, this.f6108d, bVar.a());
    }

    private long b(byte b2) {
        return 1 == b2 ? com.tencent.bugly.beta.utils.a.f6092c : 2 == b2 ? com.tencent.bugly.beta.utils.a.f6091b : com.tencent.bugly.beta.utils.a.a;
    }

    private synchronized HashMap<String, b> b(long j2, long j3) {
        if (j2 > 0 && j3 > 0) {
            Vector<a> vector = new Vector();
            for (int i2 = 0; i2 < j2; i2++) {
                vector.add(m());
            }
            a aVar = (a) vector.get((int) j3);
            long length = new File(this.f6106b).length();
            an.c("File length = %d", Long.valueOf(length));
            if (aVar.c() >= length) {
                an.d("The SO file is invalid or has a shell.", new Object[0]);
                return null;
            }
            d dVar = new d(this.f6106b, aVar.c(), aVar.d());
            HashMap<String, b> map = new HashMap<>();
            for (a aVar2 : vector) {
                String strA = dVar.a(aVar2.a());
                b bVar = new b();
                bVar.a(strA);
                bVar.a(aVar2.b());
                bVar.b(aVar2.c());
                bVar.c(aVar2.d());
                bVar.d(aVar2.e());
                map.put(strA, bVar);
            }
            dVar.a();
            return map;
        }
        an.d("The SO file is invalid or has a shell.", new Object[0]);
        return null;
    }

    private static String a(long j2, long j3) {
        String str = u.get(Long.valueOf(j2));
        return (64 == j3 && str.equals("mips")) ? "mips64" : str;
    }

    private static boolean a(byte[] bArr) {
        return bArr.length >= 3 && 127 == bArr[0] && 69 == bArr[1] && 76 == bArr[2] && 70 == bArr[3];
    }

    private synchronized HashMap<String, b> a(long j2, long j3, long j4) {
        if (!k()) {
            j();
            return null;
        }
        if (!this.a.b(j2)) {
            j();
            return null;
        }
        HashMap<String, b> mapB = b(j3, j4);
        j();
        return mapB;
    }
}
