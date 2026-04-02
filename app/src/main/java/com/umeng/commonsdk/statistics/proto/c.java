package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cf;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cj;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cl;
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
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: IdTracking.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements bq<c, e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d */
    public static final Map<e, cc> f7781d;

    /* JADX INFO: renamed from: e */
    private static final long f7782e = -5764118265293965743L;

    /* JADX INFO: renamed from: f */
    private static final cu f7783f = new cu("IdTracking");

    /* JADX INFO: renamed from: g */
    private static final ck f7784g = new ck("snapshots", cw.f7203k, 1);

    /* JADX INFO: renamed from: h */
    private static final ck f7785h = new ck("journals", cw.f7205m, 2);

    /* JADX INFO: renamed from: i */
    private static final ck f7786i = new ck("checksum", (byte) 11, 3);

    /* JADX INFO: renamed from: j */
    private static final Map<Class<? extends cx>, cy> f7787j = new HashMap();
    public Map<String, com.umeng.commonsdk.statistics.proto.b> a;

    /* JADX INFO: renamed from: b */
    public List<com.umeng.commonsdk.statistics.proto.a> f7788b;

    /* JADX INFO: renamed from: c */
    public String f7789c;

    /* JADX INFO: renamed from: k */
    private e[] f7790k;

    /* JADX INFO: compiled from: IdTracking.java */
    private static class a extends cz<c> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cx
        /* JADX INFO: renamed from: a */
        public void b(cp cpVar, c cVar) throws bw {
            cpVar.j();
            while (true) {
                ck ckVarL = cpVar.l();
                byte b2 = ckVarL.f7175b;
                if (b2 == 0) {
                    cpVar.k();
                    cVar.n();
                    return;
                }
                short s = ckVarL.f7176c;
                int i2 = 0;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            cs.a(cpVar, b2);
                        } else if (b2 == 11) {
                            cVar.f7789c = cpVar.z();
                            cVar.c(true);
                        } else {
                            cs.a(cpVar, b2);
                        }
                    } else if (b2 == 15) {
                        cl clVarP = cpVar.p();
                        cVar.f7788b = new ArrayList(clVarP.f7177b);
                        while (i2 < clVarP.f7177b) {
                            com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                            aVar.read(cpVar);
                            cVar.f7788b.add(aVar);
                            i2++;
                        }
                        cpVar.q();
                        cVar.b(true);
                    } else {
                        cs.a(cpVar, b2);
                    }
                } else if (b2 == 13) {
                    cm cmVarN = cpVar.n();
                    cVar.a = new HashMap(cmVarN.f7179c * 2);
                    while (i2 < cmVarN.f7179c) {
                        String strZ = cpVar.z();
                        com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                        bVar.read(cpVar);
                        cVar.a.put(strZ, bVar);
                        i2++;
                    }
                    cpVar.o();
                    cVar.a(true);
                } else {
                    cs.a(cpVar, b2);
                }
                cpVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cx
        /* JADX INFO: renamed from: b */
        public void a(cp cpVar, c cVar) throws bw {
            cVar.n();
            cpVar.a(c.f7783f);
            if (cVar.a != null) {
                cpVar.a(c.f7784g);
                cpVar.a(new cm((byte) 11, (byte) 12, cVar.a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                    cpVar.a(entry.getKey());
                    entry.getValue().write(cpVar);
                }
                cpVar.e();
                cpVar.c();
            }
            if (cVar.f7788b != null && cVar.j()) {
                cpVar.a(c.f7785h);
                cpVar.a(new cl((byte) 12, cVar.f7788b.size()));
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f7788b.iterator();
                while (it.hasNext()) {
                    it.next().write(cpVar);
                }
                cpVar.f();
                cpVar.c();
            }
            if (cVar.f7789c != null && cVar.m()) {
                cpVar.a(c.f7786i);
                cpVar.a(cVar.f7789c);
                cpVar.c();
            }
            cpVar.d();
            cpVar.b();
        }
    }

    /* JADX INFO: compiled from: IdTracking.java */
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

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.c$c */
    /* JADX INFO: compiled from: IdTracking.java */
    private static class C0135c extends da<c> {
        private C0135c() {
        }

        /* synthetic */ C0135c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cx
        public void a(cp cpVar, c cVar) throws bw {
            cv cvVar = (cv) cpVar;
            cvVar.a(cVar.a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                cvVar.a(entry.getKey());
                entry.getValue().write(cvVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            cvVar.a(bitSet, 2);
            if (cVar.j()) {
                cvVar.a(cVar.f7788b.size());
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f7788b.iterator();
                while (it.hasNext()) {
                    it.next().write(cvVar);
                }
            }
            if (cVar.m()) {
                cvVar.a(cVar.f7789c);
            }
        }

        @Override // com.umeng.analytics.pro.cx
        public void b(cp cpVar, c cVar) throws bw {
            cv cvVar = (cv) cpVar;
            cm cmVar = new cm((byte) 11, (byte) 12, cvVar.w());
            cVar.a = new HashMap(cmVar.f7179c * 2);
            for (int i2 = 0; i2 < cmVar.f7179c; i2++) {
                String strZ = cvVar.z();
                com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                bVar.read(cvVar);
                cVar.a.put(strZ, bVar);
            }
            cVar.a(true);
            BitSet bitSetB = cvVar.b(2);
            if (bitSetB.get(0)) {
                cl clVar = new cl((byte) 12, cvVar.w());
                cVar.f7788b = new ArrayList(clVar.f7177b);
                for (int i3 = 0; i3 < clVar.f7177b; i3++) {
                    com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                    aVar.read(cvVar);
                    cVar.f7788b.add(aVar);
                }
                cVar.b(true);
            }
            if (bitSetB.get(1)) {
                cVar.f7789c = cvVar.z();
                cVar.c(true);
            }
        }
    }

    /* JADX INFO: compiled from: IdTracking.java */
    private static class d implements cy {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* JADX INFO: renamed from: a */
        public C0135c b() {
            return new C0135c();
        }

        /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        f7787j.put(cz.class, new b());
        f7787j.put(da.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.SNAPSHOTS, new cc("snapshots", (byte) 1, new cf(cw.f7203k, new cd((byte) 11), new ch((byte) 12, com.umeng.commonsdk.statistics.proto.b.class))));
        enumMap.put(e.JOURNALS, new cc("journals", (byte) 2, new ce(cw.f7205m, new ch((byte) 12, com.umeng.commonsdk.statistics.proto.a.class))));
        enumMap.put(e.CHECKSUM, new cc("checksum", (byte) 2, new cd((byte) 11)));
        f7781d = Collections.unmodifiableMap(enumMap);
        cc.a(c.class, f7781d);
    }

    public c() {
        this.f7790k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    @Override // com.umeng.analytics.pro.bq
    /* JADX INFO: renamed from: a */
    public c deepCopy() {
        return new c(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.b> c() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.bq
    public void clear() {
        this.a = null;
        this.f7788b = null;
        this.f7789c = null;
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f7788b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Iterator<com.umeng.commonsdk.statistics.proto.a> g() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f7788b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public List<com.umeng.commonsdk.statistics.proto.a> h() {
        return this.f7788b;
    }

    public void i() {
        this.f7788b = null;
    }

    public boolean j() {
        return this.f7788b != null;
    }

    public String k() {
        return this.f7789c;
    }

    public void l() {
        this.f7789c = null;
    }

    public boolean m() {
        return this.f7789c != null;
    }

    public void n() throws bw {
        if (this.a != null) {
            return;
        }
        throw new cq("Required field 'snapshots' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.bq
    public void read(cp cpVar) throws bw {
        f7787j.get(cpVar.D()).b().b(cpVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.a;
        if (map == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(map);
        }
        if (j()) {
            sb.append(", ");
            sb.append("journals:");
            List<com.umeng.commonsdk.statistics.proto.a> list = this.f7788b;
            if (list == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(list);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("checksum:");
            String str = this.f7789c;
            if (str == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bq
    public void write(cp cpVar) throws bw {
        f7787j.get(cpVar.D()).b().a(cpVar, this);
    }

    /* JADX INFO: compiled from: IdTracking.java */
    public enum e implements bx {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");


        /* JADX INFO: renamed from: d */
        private static final Map<String, e> f7793d = new HashMap();

        /* JADX INFO: renamed from: e */
        private final short f7795e;

        /* JADX INFO: renamed from: f */
        private final String f7796f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f7793d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f7795e = s;
            this.f7796f = str;
        }

        public static e a(int i2) {
            if (i2 == 1) {
                return SNAPSHOTS;
            }
            if (i2 == 2) {
                return JOURNALS;
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
            return this.f7796f;
        }

        public static e a(String str) {
            return f7793d.get(str);
        }

        @Override // com.umeng.analytics.pro.bx
        public short a() {
            return this.f7795e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.b bVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, bVar);
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.f7788b = null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f7789c = null;
    }

    public c(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this();
        this.a = map;
    }

    public c(c cVar) {
        this.f7790k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                map.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.b(entry.getValue()));
            }
            this.a = map;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.f7788b.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.umeng.commonsdk.statistics.proto.a(it.next()));
            }
            this.f7788b = arrayList;
        }
        if (cVar.m()) {
            this.f7789c = cVar.f7789c;
        }
    }

    public c a(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this.a = map;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public void a(com.umeng.commonsdk.statistics.proto.a aVar) {
        if (this.f7788b == null) {
            this.f7788b = new ArrayList();
        }
        this.f7788b.add(aVar);
    }

    public c a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f7788b = list;
        return this;
    }

    public c a(String str) {
        this.f7789c = str;
        return this;
    }

    @Override // com.umeng.analytics.pro.bq
    /* JADX INFO: renamed from: a */
    public e fieldForId(int i2) {
        return e.a(i2);
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
            read(new cj(new db(objectInputStream)));
        } catch (bw e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
