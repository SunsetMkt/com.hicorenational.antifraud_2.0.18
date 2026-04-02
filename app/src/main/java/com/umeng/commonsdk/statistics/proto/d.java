package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bn;
import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.cf;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cj;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cm;
import com.umeng.analytics.pro.cp;
import com.umeng.analytics.pro.cq;
import com.umeng.analytics.pro.cs;
import com.umeng.analytics.pro.cu;
import com.umeng.analytics.pro.cv;
import com.umeng.analytics.pro.cw;
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

/* JADX INFO: compiled from: Imprint.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements bq<d, e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d */
    public static final Map<e, cc> f7797d;

    /* JADX INFO: renamed from: e */
    private static final long f7798e = 2846460275012375038L;

    /* JADX INFO: renamed from: f */
    private static final cu f7799f = new cu("Imprint");

    /* JADX INFO: renamed from: g */
    private static final ck f7800g = new ck("property", cw.f7203k, 1);

    /* JADX INFO: renamed from: h */
    private static final ck f7801h = new ck("version", (byte) 8, 2);

    /* JADX INFO: renamed from: i */
    private static final ck f7802i = new ck("checksum", (byte) 11, 3);

    /* JADX INFO: renamed from: j */
    private static final Map<Class<? extends cx>, cy> f7803j = new HashMap();

    /* JADX INFO: renamed from: k */
    private static final int f7804k = 0;
    public Map<String, com.umeng.commonsdk.statistics.proto.e> a;

    /* JADX INFO: renamed from: b */
    public int f7805b;

    /* JADX INFO: renamed from: c */
    public String f7806c;

    /* JADX INFO: renamed from: l */
    private byte f7807l;

    /* JADX INFO: compiled from: Imprint.java */
    private static class a extends cz<d> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cx
        /* JADX INFO: renamed from: a */
        public void b(cp cpVar, d dVar) throws bw {
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
                        } else if (b2 == 11) {
                            dVar.f7806c = cpVar.z();
                            dVar.c(true);
                        } else {
                            cs.a(cpVar, b2);
                        }
                    } else if (b2 == 8) {
                        dVar.f7805b = cpVar.w();
                        dVar.b(true);
                    } else {
                        cs.a(cpVar, b2);
                    }
                } else if (b2 == 13) {
                    cm cmVarN = cpVar.n();
                    dVar.a = new HashMap(cmVarN.f7179c * 2);
                    for (int i2 = 0; i2 < cmVarN.f7179c; i2++) {
                        String strZ = cpVar.z();
                        com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                        eVar.read(cpVar);
                        dVar.a.put(strZ, eVar);
                    }
                    cpVar.o();
                    dVar.a(true);
                } else {
                    cs.a(cpVar, b2);
                }
                cpVar.m();
            }
            cpVar.k();
            if (dVar.h()) {
                dVar.l();
                return;
            }
            throw new cq("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cx
        /* JADX INFO: renamed from: b */
        public void a(cp cpVar, d dVar) throws bw {
            dVar.l();
            cpVar.a(d.f7799f);
            if (dVar.a != null) {
                cpVar.a(d.f7800g);
                cpVar.a(new cm((byte) 11, (byte) 12, dVar.a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                    cpVar.a(entry.getKey());
                    entry.getValue().write(cpVar);
                }
                cpVar.e();
                cpVar.c();
            }
            cpVar.a(d.f7801h);
            cpVar.a(dVar.f7805b);
            cpVar.c();
            if (dVar.f7806c != null) {
                cpVar.a(d.f7802i);
                cpVar.a(dVar.f7806c);
                cpVar.c();
            }
            cpVar.d();
            cpVar.b();
        }
    }

    /* JADX INFO: compiled from: Imprint.java */
    private static class b implements cy {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* JADX INFO: renamed from: a */
        public a b() {
            return new a();
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: compiled from: Imprint.java */
    private static class c extends da<d> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cx
        public void a(cp cpVar, d dVar) throws bw {
            cv cvVar = (cv) cpVar;
            cvVar.a(dVar.a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                cvVar.a(entry.getKey());
                entry.getValue().write(cvVar);
            }
            cvVar.a(dVar.f7805b);
            cvVar.a(dVar.f7806c);
        }

        @Override // com.umeng.analytics.pro.cx
        public void b(cp cpVar, d dVar) throws bw {
            cv cvVar = (cv) cpVar;
            cm cmVar = new cm((byte) 11, (byte) 12, cvVar.w());
            dVar.a = new HashMap(cmVar.f7179c * 2);
            for (int i2 = 0; i2 < cmVar.f7179c; i2++) {
                String strZ = cvVar.z();
                com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                eVar.read(cvVar);
                dVar.a.put(strZ, eVar);
            }
            dVar.a(true);
            dVar.f7805b = cvVar.w();
            dVar.b(true);
            dVar.f7806c = cvVar.z();
            dVar.c(true);
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.d$d */
    /* JADX INFO: compiled from: Imprint.java */
    private static class C0136d implements cy {
        private C0136d() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* JADX INFO: renamed from: a */
        public c b() {
            return new c();
        }

        /* synthetic */ C0136d(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        f7803j.put(cz.class, new b());
        f7803j.put(da.class, new C0136d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.PROPERTY, new cc("property", (byte) 1, new cf(cw.f7203k, new cd((byte) 11), new ch((byte) 12, com.umeng.commonsdk.statistics.proto.e.class))));
        enumMap.put(e.VERSION, new cc("version", (byte) 1, new cd((byte) 8)));
        enumMap.put(e.CHECKSUM, new cc("checksum", (byte) 1, new cd((byte) 11)));
        f7797d = Collections.unmodifiableMap(enumMap);
        cc.a(d.class, f7797d);
    }

    public d() {
        this.f7807l = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.bq
    /* JADX INFO: renamed from: a */
    public d deepCopy() {
        return new d(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.e> c() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.bq
    public void clear() {
        this.a = null;
        b(false);
        this.f7805b = 0;
        this.f7806c = null;
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        return this.f7805b;
    }

    public void g() {
        this.f7807l = bn.b(this.f7807l, 0);
    }

    public boolean h() {
        return bn.a(this.f7807l, 0);
    }

    public String i() {
        return this.f7806c;
    }

    public void j() {
        this.f7806c = null;
    }

    public boolean k() {
        return this.f7806c != null;
    }

    public void l() throws bw {
        if (this.a == null) {
            throw new cq("Required field 'property' was not present! Struct: " + toString());
        }
        if (this.f7806c != null) {
            return;
        }
        throw new cq("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.bq
    public void read(cp cpVar) throws bw {
        f7803j.get(cpVar.D()).b().b(cpVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.a;
        if (map == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f7805b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.f7806c;
        if (str == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bq
    public void write(cp cpVar) throws bw {
        f7803j.get(cpVar.D()).b().a(cpVar, this);
    }

    /* JADX INFO: compiled from: Imprint.java */
    public enum e implements bx {
        PROPERTY(1, "property"),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");


        /* JADX INFO: renamed from: d */
        private static final Map<String, e> f7810d = new HashMap();

        /* JADX INFO: renamed from: e */
        private final short f7812e;

        /* JADX INFO: renamed from: f */
        private final String f7813f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f7810d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f7812e = s;
            this.f7813f = str;
        }

        public static e a(int i2) {
            if (i2 == 1) {
                return PROPERTY;
            }
            if (i2 == 2) {
                return VERSION;
            }
            if (i2 != 3) {
                return null;
            }
            return CHECKSUM;
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
            return this.f7813f;
        }

        public static e a(String str) {
            return f7810d.get(str);
        }

        @Override // com.umeng.analytics.pro.bx
        public short a() {
            return this.f7812e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.e eVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, eVar);
    }

    public void b(boolean z) {
        this.f7807l = bn.a(this.f7807l, 0, z);
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f7806c = null;
    }

    public d(Map<String, com.umeng.commonsdk.statistics.proto.e> map, int i2, String str) {
        this();
        this.a = map;
        this.f7805b = i2;
        b(true);
        this.f7806c = str;
    }

    @Override // com.umeng.analytics.pro.bq
    /* JADX INFO: renamed from: b */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public d a(Map<String, com.umeng.commonsdk.statistics.proto.e> map) {
        this.a = map;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public d a(int i2) {
        this.f7805b = i2;
        b(true);
        return this;
    }

    public d(d dVar) {
        this.f7807l = (byte) 0;
        this.f7807l = dVar.f7807l;
        if (dVar.e()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                map.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.e(entry.getValue()));
            }
            this.a = map;
        }
        this.f7805b = dVar.f7805b;
        if (dVar.k()) {
            this.f7806c = dVar.f7806c;
        }
    }

    public d a(String str) {
        this.f7806c = str;
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new cj(new db(objectOutputStream)));
        } catch (bw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f7807l = (byte) 0;
            read(new cj(new db(objectInputStream)));
        } catch (bw e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
