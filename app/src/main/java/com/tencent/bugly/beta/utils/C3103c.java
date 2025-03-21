package com.tencent.bugly.beta.utils;

import com.tencent.bugly.proguard.C3151an;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.utils.c */
/* loaded from: classes2.dex */
public class C3103c {

    /* renamed from: u */
    private static HashMap<Long, String> f10035u = new HashMap<>();

    /* renamed from: b */
    private String f10037b;

    /* renamed from: a */
    private C3101a f10036a = null;

    /* renamed from: c */
    private long f10038c = 0;

    /* renamed from: d */
    private long f10039d = 0;

    /* renamed from: e */
    private HashMap<String, b> f10040e = null;

    /* renamed from: f */
    private byte[] f10041f = new byte[16];

    /* renamed from: g */
    private long f10042g = 0;

    /* renamed from: h */
    private long f10043h = 0;

    /* renamed from: i */
    private String f10044i = null;

    /* renamed from: j */
    private long f10045j = 0;

    /* renamed from: k */
    private long f10046k = 0;

    /* renamed from: l */
    private long f10047l = 0;

    /* renamed from: m */
    private long f10048m = 0;

    /* renamed from: n */
    private long f10049n = 0;

    /* renamed from: o */
    private long f10050o = 0;

    /* renamed from: p */
    private long f10051p = 0;

    /* renamed from: q */
    private long f10052q = 0;

    /* renamed from: r */
    private long f10053r = 0;

    /* renamed from: s */
    private long f10054s = 0;

    /* renamed from: t */
    private long f10055t = 0;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.beta.utils.c$a */
    public static class a {

        /* renamed from: a */
        private long f10056a = -1;

        /* renamed from: b */
        private long f10057b = 0;

        /* renamed from: c */
        private long f10058c = 0;

        /* renamed from: d */
        private long f10059d = -1;

        /* renamed from: e */
        private long f10060e = -1;

        /* renamed from: f */
        private long f10061f = 0;

        /* renamed from: g */
        private long f10062g = 0;

        /* renamed from: h */
        private long f10063h = 0;

        /* renamed from: i */
        private long f10064i = 0;

        /* renamed from: j */
        private long f10065j = 0;

        /* renamed from: a */
        public long m9434a() {
            return this.f10056a;
        }

        /* renamed from: b */
        public long m9436b() {
            return this.f10059d;
        }

        /* renamed from: c */
        public long m9438c() {
            return this.f10060e;
        }

        /* renamed from: d */
        public long m9440d() {
            return this.f10061f;
        }

        /* renamed from: e */
        public long m9442e() {
            return this.f10065j;
        }

        /* renamed from: f */
        public synchronized void m9444f(long j2) {
            this.f10061f = j2;
        }

        /* renamed from: g */
        public synchronized void m9445g(long j2) {
            this.f10062g = j2;
        }

        /* renamed from: h */
        public synchronized void m9446h(long j2) {
            this.f10063h = j2;
        }

        /* renamed from: i */
        public synchronized void m9447i(long j2) {
            this.f10064i = j2;
        }

        /* renamed from: j */
        public synchronized void m9448j(long j2) {
            this.f10065j = j2;
        }

        /* renamed from: a */
        public synchronized void m9435a(long j2) {
            this.f10056a = j2;
        }

        /* renamed from: b */
        public synchronized void m9437b(long j2) {
            this.f10057b = j2;
        }

        /* renamed from: c */
        public synchronized void m9439c(long j2) {
            this.f10058c = j2;
        }

        /* renamed from: d */
        public synchronized void m9441d(long j2) {
            this.f10060e = j2;
        }

        /* renamed from: e */
        public synchronized void m9443e(long j2) {
            this.f10059d = j2;
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.beta.utils.c$b */
    public static class b {

        /* renamed from: a */
        private String f10066a = null;

        /* renamed from: b */
        private long f10067b = -1;

        /* renamed from: c */
        private long f10068c = -1;

        /* renamed from: d */
        private long f10069d = 0;

        /* renamed from: e */
        private long f10070e = 0;

        /* renamed from: a */
        public long m9449a() {
            return this.f10068c;
        }

        /* renamed from: b */
        public synchronized void m9452b(long j2) {
            this.f10068c = j2;
        }

        /* renamed from: c */
        public synchronized void m9453c(long j2) {
            this.f10069d = j2;
        }

        /* renamed from: d */
        public synchronized void m9454d(long j2) {
            this.f10070e = j2;
        }

        /* renamed from: a */
        public synchronized void m9451a(String str) {
            this.f10066a = str;
        }

        /* renamed from: a */
        public synchronized void m9450a(long j2) {
            this.f10067b = j2;
        }
    }

    public C3103c(String str) {
        this.f10037b = null;
        this.f10037b = str;
        f10035u.put(3L, "x86");
        f10035u.put(7L, "x86");
        f10035u.put(8L, "mips");
        f10035u.put(10L, "mips");
        f10035u.put(40L, "armeabi");
        f10035u.put(62L, "x86_64");
        f10035u.put(183L, "arm64-v8a");
    }

    /* renamed from: a */
    private long m9415a(byte b2) {
        if (1 == b2) {
            return 32L;
        }
        return 2 == b2 ? 64L : 0L;
    }

    /* renamed from: b */
    private String m9420b() {
        return this.f10044i;
    }

    /* renamed from: c */
    private long m9422c() {
        return this.f10048m;
    }

    /* renamed from: d */
    private long m9423d() {
        return this.f10054s;
    }

    /* renamed from: e */
    private long m9424e() {
        return this.f10055t;
    }

    /* renamed from: f */
    private boolean m9425f() {
        if (!m9431l()) {
            return false;
        }
        if (m9426g()) {
            m9429j();
            return true;
        }
        m9429j();
        return false;
    }

    /* renamed from: g */
    private synchronized boolean m9426g() {
        if (!m9427h()) {
            return false;
        }
        try {
            this.f10042g = this.f10036a.m9402g();
            this.f10043h = this.f10036a.m9402g();
            this.f10044i = m9416a(this.f10043h, this.f10038c);
            this.f10045j = this.f10036a.m9403h();
            if (32 == this.f10038c) {
                long m9403h = this.f10036a.m9403h();
                this.f10045j = m9403h;
                this.f10046k = m9403h;
                this.f10047l = this.f10036a.m9403h();
                this.f10048m = this.f10036a.m9403h();
            } else {
                if (64 != this.f10038c) {
                    return false;
                }
                long m9404i = this.f10036a.m9404i();
                this.f10045j = m9404i;
                this.f10046k = m9404i;
                this.f10047l = this.f10036a.m9404i();
                this.f10048m = this.f10036a.m9404i();
            }
            this.f10049n = this.f10036a.m9403h();
            this.f10050o = this.f10036a.m9402g();
            this.f10051p = this.f10036a.m9402g();
            this.f10052q = this.f10036a.m9402g();
            this.f10053r = this.f10036a.m9402g();
            this.f10054s = this.f10036a.m9402g();
            this.f10055t = this.f10036a.m9402g();
            return true;
        } catch (IOException e2) {
            e2.getMessage();
            return false;
        }
    }

    /* renamed from: h */
    private synchronized boolean m9427h() {
        if (!this.f10036a.m9395a(this.f10041f)) {
            return false;
        }
        if (!m9418a(this.f10041f)) {
            String str = "Not a elf file: " + this.f10037b;
            return false;
        }
        this.f10038c = m9415a(this.f10041f[4]);
        if (0 == this.f10038c) {
            String str2 = "File format error: " + ((int) this.f10041f[4]);
            return false;
        }
        this.f10039d = m9419b(this.f10041f[5]);
        if (C3101a.f10018a != this.f10039d) {
            this.f10036a.m9393a(this.f10039d);
            return true;
        }
        String str3 = "Endian error: " + ((int) this.f10041f[5]);
        return false;
    }

    /* renamed from: i */
    private synchronized boolean m9428i() {
        this.f10040e = m9417a(m9422c(), m9423d(), m9424e());
        return this.f10040e != null;
    }

    /* renamed from: j */
    private synchronized void m9429j() {
        if (this.f10036a == null) {
            return;
        }
        if (this.f10036a.m9394a()) {
            this.f10036a = null;
        }
    }

    /* renamed from: k */
    private synchronized boolean m9430k() {
        if (this.f10036a != null) {
            m9429j();
        }
        try {
            this.f10036a = new C3101a(this.f10037b, this.f10039d);
        } catch (Exception e2) {
            e2.getMessage();
            return false;
        }
        return true;
    }

    /* renamed from: l */
    private synchronized boolean m9431l() {
        if (this.f10036a != null) {
            m9429j();
        }
        try {
            this.f10036a = new C3101a(this.f10037b);
        } catch (Exception e2) {
            e2.getMessage();
            return false;
        }
        return true;
    }

    /* renamed from: m */
    private synchronized a m9432m() {
        a aVar = new a();
        try {
            aVar.m9435a(this.f10036a.m9403h());
            aVar.m9437b(this.f10036a.m9403h());
            if (32 == this.f10038c) {
                aVar.m9439c(this.f10036a.m9403h());
                aVar.m9443e(this.f10036a.m9403h());
                aVar.m9441d(this.f10036a.m9403h());
                aVar.m9444f(this.f10036a.m9403h());
            } else {
                if (64 != this.f10038c) {
                    return null;
                }
                aVar.m9439c(this.f10036a.m9404i());
                aVar.m9443e(this.f10036a.m9404i());
                aVar.m9441d(this.f10036a.m9404i());
                aVar.m9444f(this.f10036a.m9404i());
            }
            aVar.m9445g(this.f10036a.m9403h());
            aVar.m9446h(this.f10036a.m9403h());
            if (32 == this.f10038c) {
                aVar.m9447i(this.f10036a.m9403h());
                aVar.m9448j(this.f10036a.m9403h());
            } else {
                if (64 != this.f10038c) {
                    return null;
                }
                aVar.m9447i(this.f10036a.m9404i());
                aVar.m9448j(this.f10036a.m9404i());
            }
            return aVar;
        } catch (IOException e2) {
            e2.getMessage();
            return null;
        }
    }

    /* renamed from: a */
    public synchronized String m9433a() {
        if (!m9425f()) {
            return null;
        }
        String m9420b = m9420b();
        if (!m9420b.equals("armeabi")) {
            return m9420b;
        }
        if (!m9428i()) {
            return m9420b;
        }
        b bVar = this.f10040e.get(".ARM.attributes");
        if (bVar == null) {
            return m9420b;
        }
        return C3102b.m9406a(this.f10037b, this.f10039d, bVar.m9449a());
    }

    /* renamed from: b */
    private long m9419b(byte b2) {
        return 1 == b2 ? C3101a.f10020c : 2 == b2 ? C3101a.f10019b : C3101a.f10018a;
    }

    /* renamed from: b */
    private synchronized HashMap<String, b> m9421b(long j2, long j3) {
        if (j2 > 0 && j3 > 0) {
            Vector vector = new Vector();
            for (int i2 = 0; i2 < j2; i2++) {
                vector.add(m9432m());
            }
            a aVar = (a) vector.get((int) j3);
            long length = new File(this.f10037b).length();
            C3151an.m9921c("File length = %d", Long.valueOf(length));
            if (aVar.m9438c() >= length) {
                C3151an.m9922d("The SO file is invalid or has a shell.", new Object[0]);
                return null;
            }
            C3104d c3104d = new C3104d(this.f10037b, aVar.m9438c(), aVar.m9440d());
            HashMap<String, b> hashMap = new HashMap<>();
            Iterator it = vector.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                String m9458a = c3104d.m9458a(aVar2.m9434a());
                b bVar = new b();
                bVar.m9451a(m9458a);
                bVar.m9450a(aVar2.m9436b());
                bVar.m9452b(aVar2.m9438c());
                bVar.m9453c(aVar2.m9440d());
                bVar.m9454d(aVar2.m9442e());
                hashMap.put(m9458a, bVar);
            }
            c3104d.m9459a();
            return hashMap;
        }
        C3151an.m9922d("The SO file is invalid or has a shell.", new Object[0]);
        return null;
    }

    /* renamed from: a */
    private static String m9416a(long j2, long j3) {
        String str = f10035u.get(Long.valueOf(j2));
        return (64 == j3 && str.equals("mips")) ? "mips64" : str;
    }

    /* renamed from: a */
    private static boolean m9418a(byte[] bArr) {
        return bArr.length >= 3 && Byte.MAX_VALUE == bArr[0] && 69 == bArr[1] && 76 == bArr[2] && 70 == bArr[3];
    }

    /* renamed from: a */
    private synchronized HashMap<String, b> m9417a(long j2, long j3, long j4) {
        if (!m9430k()) {
            m9429j();
            return null;
        }
        if (!this.f10036a.m9397b(j2)) {
            m9429j();
            return null;
        }
        HashMap<String, b> m9421b = m9421b(j3, j4);
        m9429j();
        return m9421b;
    }
}
