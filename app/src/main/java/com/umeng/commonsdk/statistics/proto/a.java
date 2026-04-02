package com.umeng.commonsdk.statistics.proto;

import anet.channel.strategy.dispatch.DispatchConstants;
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
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: IdJournal.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements bq<a, e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: e */
    public static final Map<e, cc> f7743e;

    /* JADX INFO: renamed from: f */
    private static final long f7744f = 9132678615281394583L;

    /* JADX INFO: renamed from: g */
    private static final cu f7745g = new cu("IdJournal");

    /* JADX INFO: renamed from: h */
    private static final ck f7746h = new ck(DispatchConstants.DOMAIN, (byte) 11, 1);

    /* JADX INFO: renamed from: i */
    private static final ck f7747i = new ck("old_id", (byte) 11, 2);

    /* JADX INFO: renamed from: j */
    private static final ck f7748j = new ck("new_id", (byte) 11, 3);

    /* JADX INFO: renamed from: k */
    private static final ck f7749k = new ck("ts", (byte) 10, 4);

    /* JADX INFO: renamed from: l */
    private static final Map<Class<? extends cx>, cy> f7750l = new HashMap();

    /* JADX INFO: renamed from: m */
    private static final int f7751m = 0;
    public String a;

    /* JADX INFO: renamed from: b */
    public String f7752b;

    /* JADX INFO: renamed from: c */
    public String f7753c;

    /* JADX INFO: renamed from: d */
    public long f7754d;

    /* JADX INFO: renamed from: n */
    private byte f7755n;
    private e[] o;

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.a$a */
    /* JADX INFO: compiled from: IdJournal.java */
    private static class C0133a extends cz<a> {
        private C0133a() {
        }

        /* synthetic */ C0133a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cx
        /* JADX INFO: renamed from: a */
        public void b(cp cpVar, a aVar) throws bw {
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
                            if (s != 4) {
                                cs.a(cpVar, b2);
                            } else if (b2 == 10) {
                                aVar.f7754d = cpVar.x();
                                aVar.d(true);
                            } else {
                                cs.a(cpVar, b2);
                            }
                        } else if (b2 == 11) {
                            aVar.f7753c = cpVar.z();
                            aVar.c(true);
                        } else {
                            cs.a(cpVar, b2);
                        }
                    } else if (b2 == 11) {
                        aVar.f7752b = cpVar.z();
                        aVar.b(true);
                    } else {
                        cs.a(cpVar, b2);
                    }
                } else if (b2 == 11) {
                    aVar.a = cpVar.z();
                    aVar.a(true);
                } else {
                    cs.a(cpVar, b2);
                }
                cpVar.m();
            }
            cpVar.k();
            if (aVar.m()) {
                aVar.n();
                return;
            }
            throw new cq("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cx
        /* JADX INFO: renamed from: b */
        public void a(cp cpVar, a aVar) throws bw {
            aVar.n();
            cpVar.a(a.f7745g);
            if (aVar.a != null) {
                cpVar.a(a.f7746h);
                cpVar.a(aVar.a);
                cpVar.c();
            }
            if (aVar.f7752b != null && aVar.g()) {
                cpVar.a(a.f7747i);
                cpVar.a(aVar.f7752b);
                cpVar.c();
            }
            if (aVar.f7753c != null) {
                cpVar.a(a.f7748j);
                cpVar.a(aVar.f7753c);
                cpVar.c();
            }
            cpVar.a(a.f7749k);
            cpVar.a(aVar.f7754d);
            cpVar.c();
            cpVar.d();
            cpVar.b();
        }
    }

    /* JADX INFO: compiled from: IdJournal.java */
    private static class b implements cy {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* JADX INFO: renamed from: a */
        public C0133a b() {
            return new C0133a();
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: compiled from: IdJournal.java */
    private static class c extends da<a> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cx
        public void a(cp cpVar, a aVar) throws bw {
            cv cvVar = (cv) cpVar;
            cvVar.a(aVar.a);
            cvVar.a(aVar.f7753c);
            cvVar.a(aVar.f7754d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            cvVar.a(bitSet, 1);
            if (aVar.g()) {
                cvVar.a(aVar.f7752b);
            }
        }

        @Override // com.umeng.analytics.pro.cx
        public void b(cp cpVar, a aVar) throws bw {
            cv cvVar = (cv) cpVar;
            aVar.a = cvVar.z();
            aVar.a(true);
            aVar.f7753c = cvVar.z();
            aVar.c(true);
            aVar.f7754d = cvVar.x();
            aVar.d(true);
            if (cvVar.b(1).get(0)) {
                aVar.f7752b = cvVar.z();
                aVar.b(true);
            }
        }
    }

    /* JADX INFO: compiled from: IdJournal.java */
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
        f7750l.put(cz.class, new b());
        f7750l.put(da.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.DOMAIN, new cc(DispatchConstants.DOMAIN, (byte) 1, new cd((byte) 11)));
        enumMap.put(e.OLD_ID, new cc("old_id", (byte) 2, new cd((byte) 11)));
        enumMap.put(e.NEW_ID, new cc("new_id", (byte) 1, new cd((byte) 11)));
        enumMap.put(e.TS, new cc("ts", (byte) 1, new cd((byte) 10)));
        f7743e = Collections.unmodifiableMap(enumMap);
        cc.a(a.class, f7743e);
    }

    public a() {
        this.f7755n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
    }

    @Override // com.umeng.analytics.pro.bq
    /* JADX INFO: renamed from: a */
    public a deepCopy() {
        return new a(this);
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
        this.f7752b = null;
        this.f7753c = null;
        d(false);
        this.f7754d = 0L;
    }

    public boolean d() {
        return this.a != null;
    }

    public String e() {
        return this.f7752b;
    }

    public void f() {
        this.f7752b = null;
    }

    public boolean g() {
        return this.f7752b != null;
    }

    public String h() {
        return this.f7753c;
    }

    public void i() {
        this.f7753c = null;
    }

    public boolean j() {
        return this.f7753c != null;
    }

    public long k() {
        return this.f7754d;
    }

    public void l() {
        this.f7755n = bn.b(this.f7755n, 0);
    }

    public boolean m() {
        return bn.a(this.f7755n, 0);
    }

    public void n() throws bw {
        if (this.a == null) {
            throw new cq("Required field 'domain' was not present! Struct: " + toString());
        }
        if (this.f7753c != null) {
            return;
        }
        throw new cq("Required field 'new_id' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.bq
    public void read(cp cpVar) throws bw {
        f7750l.get(cpVar.D()).b().b(cpVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        String str = this.a;
        if (str == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str);
        }
        if (g()) {
            sb.append(", ");
            sb.append("old_id:");
            String str2 = this.f7752b;
            if (str2 == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        String str3 = this.f7753c;
        if (str3 == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f7754d);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bq
    public void write(cp cpVar) throws bw {
        f7750l.get(cpVar.D()).b().a(cpVar, this);
    }

    /* JADX INFO: compiled from: IdJournal.java */
    public enum e implements bx {
        DOMAIN(1, DispatchConstants.DOMAIN),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");


        /* JADX INFO: renamed from: e */
        private static final Map<String, e> f7759e = new HashMap();

        /* JADX INFO: renamed from: f */
        private final short f7761f;

        /* JADX INFO: renamed from: g */
        private final String f7762g;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f7759e.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f7761f = s;
            this.f7762g = str;
        }

        public static e a(int i2) {
            if (i2 == 1) {
                return DOMAIN;
            }
            if (i2 == 2) {
                return OLD_ID;
            }
            if (i2 == 3) {
                return NEW_ID;
            }
            if (i2 != 4) {
                return null;
            }
            return TS;
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
            return this.f7762g;
        }

        public static e a(String str) {
            return f7759e.get(str);
        }

        @Override // com.umeng.analytics.pro.bx
        public short a() {
            return this.f7761f;
        }
    }

    public a a(String str) {
        this.a = str;
        return this;
    }

    public a b(String str) {
        this.f7752b = str;
        return this;
    }

    public a c(String str) {
        this.f7753c = str;
        return this;
    }

    public void d(boolean z) {
        this.f7755n = bn.a(this.f7755n, 0, z);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.f7752b = null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f7753c = null;
    }

    public a(String str, String str2, long j2) {
        this();
        this.a = str;
        this.f7753c = str2;
        this.f7754d = j2;
        d(true);
    }

    public a a(long j2) {
        this.f7754d = j2;
        d(true);
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

    public a(a aVar) {
        this.f7755n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
        this.f7755n = aVar.f7755n;
        if (aVar.d()) {
            this.a = aVar.a;
        }
        if (aVar.g()) {
            this.f7752b = aVar.f7752b;
        }
        if (aVar.j()) {
            this.f7753c = aVar.f7753c;
        }
        this.f7754d = aVar.f7754d;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f7755n = (byte) 0;
            read(new cj(new db(objectInputStream)));
        } catch (bw e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
