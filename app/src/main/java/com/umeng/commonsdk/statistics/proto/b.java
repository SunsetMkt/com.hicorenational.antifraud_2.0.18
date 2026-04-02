package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bn;
import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.cj;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cp;
import com.umeng.analytics.pro.cq;
import com.umeng.analytics.pro.cs;
import com.umeng.analytics.pro.cu;
import com.umeng.analytics.pro.cv;
import com.umeng.analytics.pro.cx;
import com.umeng.analytics.pro.cy;
import com.umeng.analytics.pro.cz;
import com.umeng.analytics.pro.da;
import com.umeng.analytics.pro.db;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: IdSnapshot.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements bq<b, e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d */
    public static final Map<e, cc> f7763d;

    /* JADX INFO: renamed from: e */
    private static final long f7764e = -6496538196005191531L;

    /* JADX INFO: renamed from: f */
    private static final cu f7765f = new cu("IdSnapshot");

    /* JADX INFO: renamed from: g */
    private static final ck f7766g = new ck("identity", (byte) 11, 1);

    /* JADX INFO: renamed from: h */
    private static final ck f7767h = new ck("ts", (byte) 10, 2);

    /* JADX INFO: renamed from: i */
    private static final ck f7768i = new ck("version", (byte) 8, 3);

    /* JADX INFO: renamed from: j */
    private static final Map<Class<? extends cx>, cy> f7769j = new HashMap();

    /* JADX INFO: renamed from: k */
    private static final int f7770k = 0;

    /* JADX INFO: renamed from: l */
    private static final int f7771l = 1;
    public String a;

    /* JADX INFO: renamed from: b */
    public long f7772b;

    /* JADX INFO: renamed from: c */
    public int f7773c;

    /* JADX INFO: renamed from: m */
    private byte f7774m;

    /* JADX INFO: compiled from: IdSnapshot.java */
    private static class a extends cz<b> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cx
        /* JADX INFO: renamed from: a */
        public void b(cp cpVar, b bVar) throws bw {
            cpVar.j();
            while (true) {
                ck ckVarL = cpVar.l();
                byte b2 = ckVarL.f7175b;
                if (b2 == 0) {
                    break;
                }
                short s = ckVarL.f7176c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            cs.a(cpVar, b2);
                        } else if (b2 == 8) {
                            bVar.f7773c = cpVar.w();
                            bVar.c(true);
                        } else {
                            cs.a(cpVar, b2);
                        }
                    } else if (b2 == 10) {
                        bVar.f7772b = cpVar.x();
                        bVar.b(true);
                    } else {
                        cs.a(cpVar, b2);
                    }
                } else if (b2 == 11) {
                    bVar.a = cpVar.z();
                    bVar.a(true);
                } else {
                    cs.a(cpVar, b2);
                }
                cpVar.m();
            }
            cpVar.k();
            if (!bVar.g()) {
                throw new cq("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            if (bVar.j()) {
                bVar.k();
                return;
            }
            throw new cq("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cx
        /* JADX INFO: renamed from: b */
        public void a(cp cpVar, b bVar) throws bw {
            bVar.k();
            cpVar.a(b.f7765f);
            if (bVar.a != null) {
                cpVar.a(b.f7766g);
                cpVar.a(bVar.a);
                cpVar.c();
            }
            cpVar.a(b.f7767h);
            cpVar.a(bVar.f7772b);
            cpVar.c();
            cpVar.a(b.f7768i);
            cpVar.a(bVar.f7773c);
            cpVar.c();
            cpVar.d();
            cpVar.b();
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.b$b */
    /* JADX INFO: compiled from: IdSnapshot.java */
    private static class C0134b implements cy {
        private C0134b() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* JADX INFO: renamed from: a */
        public a b() {
            return new a();
        }

        /* synthetic */ C0134b(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: compiled from: IdSnapshot.java */
    private static class c extends da<b> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cx
        public void a(cp cpVar, b bVar) throws bw {
            cv cvVar = (cv) cpVar;
            cvVar.a(bVar.a);
            cvVar.a(bVar.f7772b);
            cvVar.a(bVar.f7773c);
        }

        @Override // com.umeng.analytics.pro.cx
        public void b(cp cpVar, b bVar) throws bw {
            cv cvVar = (cv) cpVar;
            bVar.a = cvVar.z();
            bVar.a(true);
            bVar.f7772b = cvVar.x();
            bVar.b(true);
            bVar.f7773c = cvVar.w();
            bVar.c(true);
        }
    }

    /* JADX INFO: compiled from: IdSnapshot.java */
    private static class d implements cy {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* JADX INFO: renamed from: a */
        public c b() {
            return new c();
        }

        /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        f7769j.put(cz.class, new C0134b());
        f7769j.put(da.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.IDENTITY, new cc("identity", (byte) 1, new cd((byte) 11)));
        enumMap.put(e.TS, new cc("ts", (byte) 1, new cd((byte) 10)));
        enumMap.put(e.VERSION, new cc("version", (byte) 1, new cd((byte) 8)));
        f7763d = Collections.unmodifiableMap(enumMap);
        cc.a(b.class, f7763d);
    }

    public b() {
        this.f7774m = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.bq
    /* JADX INFO: renamed from: a */
    public b deepCopy() {
        return new b(this);
    }

    public String b() {
        return this.a;
    }

    public void c() {
        this.a = null;
    }

    @Override // com.umeng.analytics.pro.bq
    public void clear() {
        this.a = null;
        b(false);
        this.f7772b = 0L;
        c(false);
        this.f7773c = 0;
    }

    public boolean d() {
        return this.a != null;
    }

    public long e() {
        return this.f7772b;
    }

    public void f() {
        this.f7774m = bn.b(this.f7774m, 0);
    }

    public boolean g() {
        return bn.a(this.f7774m, 0);
    }

    public int h() {
        return this.f7773c;
    }

    public void i() {
        this.f7774m = bn.b(this.f7774m, 1);
    }

    public boolean j() {
        return bn.a(this.f7774m, 1);
    }

    public void k() throws bw {
        if (this.a != null) {
            return;
        }
        throw new cq("Required field 'identity' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.bq
    public void read(cp cpVar) throws bw {
        f7769j.get(cpVar.D()).b().b(cpVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        String str = this.a;
        if (str == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f7772b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f7773c);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bq
    public void write(cp cpVar) throws bw {
        f7769j.get(cpVar.D()).b().a(cpVar, this);
    }

    /* JADX INFO: compiled from: IdSnapshot.java */
    public enum e implements bx {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, "version");


        /* JADX INFO: renamed from: d */
        private static final Map<String, e> f7777d = new HashMap();

        /* JADX INFO: renamed from: e */
        private final short f7779e;

        /* JADX INFO: renamed from: f */
        private final String f7780f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f7777d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f7779e = s;
            this.f7780f = str;
        }

        public static e a(int i2) {
            if (i2 == 1) {
                return IDENTITY;
            }
            if (i2 == 2) {
                return TS;
            }
            if (i2 != 3) {
                return null;
            }
            return VERSION;
        }

        public static e b(int i2) {
            e eVarA = a(i2);
            if (eVarA != null) {
                return eVarA;
            }
            throw new IllegalArgumentException("Field " + i2 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.bx
        public String b() {
            return this.f7780f;
        }

        public static e a(String str) {
            return f7777d.get(str);
        }

        @Override // com.umeng.analytics.pro.bx
        public short a() {
            return this.f7779e;
        }
    }

    public b a(String str) {
        this.a = str;
        return this;
    }

    public void b(boolean z) {
        this.f7774m = bn.a(this.f7774m, 0, z);
    }

    public void c(boolean z) {
        this.f7774m = bn.a(this.f7774m, 1, z);
    }

    public b(String str, long j2, int i2) {
        this();
        this.a = str;
        this.f7772b = j2;
        b(true);
        this.f7773c = i2;
        c(true);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    @Override // com.umeng.analytics.pro.bq
    /* JADX INFO: renamed from: b */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public b a(long j2) {
        this.f7772b = j2;
        b(true);
        return this;
    }

    public b a(int i2) {
        this.f7773c = i2;
        c(true);
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new cj(new db(objectOutputStream)));
        } catch (bw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public b(b bVar) {
        this.f7774m = (byte) 0;
        this.f7774m = bVar.f7774m;
        if (bVar.d()) {
            this.a = bVar.a;
        }
        this.f7772b = bVar.f7772b;
        this.f7773c = bVar.f7773c;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f7774m = (byte) 0;
            read(new cj(new db(objectInputStream)));
        } catch (bw e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
