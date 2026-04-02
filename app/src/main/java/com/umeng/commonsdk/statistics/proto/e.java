package com.umeng.commonsdk.statistics.proto;

import bean.SurveyH5Bean;
import com.umeng.analytics.pro.bn;
import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.cj;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cp;
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

/* JADX INFO: compiled from: ImprintValue.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements bq<e, EnumC0137e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d */
    public static final Map<EnumC0137e, cc> f7814d;

    /* JADX INFO: renamed from: e */
    private static final long f7815e = 7501688097813630241L;

    /* JADX INFO: renamed from: f */
    private static final cu f7816f = new cu("ImprintValue");

    /* JADX INFO: renamed from: g */
    private static final ck f7817g = new ck(SurveyH5Bean.VALUE, (byte) 11, 1);

    /* JADX INFO: renamed from: h */
    private static final ck f7818h = new ck("ts", (byte) 10, 2);

    /* JADX INFO: renamed from: i */
    private static final ck f7819i = new ck("guid", (byte) 11, 3);

    /* JADX INFO: renamed from: j */
    private static final Map<Class<? extends cx>, cy> f7820j = new HashMap();

    /* JADX INFO: renamed from: k */
    private static final int f7821k = 0;
    public String a;

    /* JADX INFO: renamed from: b */
    public long f7822b;

    /* JADX INFO: renamed from: c */
    public String f7823c;

    /* JADX INFO: renamed from: l */
    private byte f7824l;

    /* JADX INFO: renamed from: m */
    private EnumC0137e[] f7825m;

    /* JADX INFO: compiled from: ImprintValue.java */
    private static class a extends cz<e> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cx
        /* JADX INFO: renamed from: a */
        public void b(cp cpVar, e eVar) throws bw {
            cpVar.j();
            while (true) {
                ck ckVarL = cpVar.l();
                byte b2 = ckVarL.f7175b;
                if (b2 == 0) {
                    cpVar.k();
                    eVar.k();
                    return;
                }
                short s = ckVarL.f7176c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            cs.a(cpVar, b2);
                        } else if (b2 == 11) {
                            eVar.f7823c = cpVar.z();
                            eVar.c(true);
                        } else {
                            cs.a(cpVar, b2);
                        }
                    } else if (b2 == 10) {
                        eVar.f7822b = cpVar.x();
                        eVar.b(true);
                    } else {
                        cs.a(cpVar, b2);
                    }
                } else if (b2 == 11) {
                    eVar.a = cpVar.z();
                    eVar.a(true);
                } else {
                    cs.a(cpVar, b2);
                }
                cpVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cx
        /* JADX INFO: renamed from: b */
        public void a(cp cpVar, e eVar) throws bw {
            eVar.k();
            cpVar.a(e.f7816f);
            if (eVar.a != null && eVar.d()) {
                cpVar.a(e.f7817g);
                cpVar.a(eVar.a);
                cpVar.c();
            }
            if (eVar.g()) {
                cpVar.a(e.f7818h);
                cpVar.a(eVar.f7822b);
                cpVar.c();
            }
            if (eVar.f7823c != null && eVar.j()) {
                cpVar.a(e.f7819i);
                cpVar.a(eVar.f7823c);
                cpVar.c();
            }
            cpVar.d();
            cpVar.b();
        }
    }

    /* JADX INFO: compiled from: ImprintValue.java */
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

    /* JADX INFO: compiled from: ImprintValue.java */
    private static class c extends da<e> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cx
        public void a(cp cpVar, e eVar) throws bw {
            cv cvVar = (cv) cpVar;
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            if (eVar.g()) {
                bitSet.set(1);
            }
            if (eVar.j()) {
                bitSet.set(2);
            }
            cvVar.a(bitSet, 3);
            if (eVar.d()) {
                cvVar.a(eVar.a);
            }
            if (eVar.g()) {
                cvVar.a(eVar.f7822b);
            }
            if (eVar.j()) {
                cvVar.a(eVar.f7823c);
            }
        }

        @Override // com.umeng.analytics.pro.cx
        public void b(cp cpVar, e eVar) throws bw {
            cv cvVar = (cv) cpVar;
            BitSet bitSetB = cvVar.b(3);
            if (bitSetB.get(0)) {
                eVar.a = cvVar.z();
                eVar.a(true);
            }
            if (bitSetB.get(1)) {
                eVar.f7822b = cvVar.x();
                eVar.b(true);
            }
            if (bitSetB.get(2)) {
                eVar.f7823c = cvVar.z();
                eVar.c(true);
            }
        }
    }

    /* JADX INFO: compiled from: ImprintValue.java */
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
        f7820j.put(cz.class, new b());
        f7820j.put(da.class, new d());
        EnumMap enumMap = new EnumMap(EnumC0137e.class);
        enumMap.put(EnumC0137e.VALUE, new cc(SurveyH5Bean.VALUE, (byte) 2, new cd((byte) 11)));
        enumMap.put(EnumC0137e.TS, new cc("ts", (byte) 2, new cd((byte) 10)));
        enumMap.put(EnumC0137e.GUID, new cc("guid", (byte) 2, new cd((byte) 11)));
        f7814d = Collections.unmodifiableMap(enumMap);
        cc.a(e.class, f7814d);
    }

    public e() {
        this.f7824l = (byte) 0;
        this.f7825m = new EnumC0137e[]{EnumC0137e.VALUE, EnumC0137e.TS, EnumC0137e.GUID};
    }

    @Override // com.umeng.analytics.pro.bq
    /* JADX INFO: renamed from: a */
    public e deepCopy() {
        return new e(this);
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
        this.f7822b = 0L;
        this.f7823c = null;
    }

    public boolean d() {
        return this.a != null;
    }

    public long e() {
        return this.f7822b;
    }

    public void f() {
        this.f7824l = bn.b(this.f7824l, 0);
    }

    public boolean g() {
        return bn.a(this.f7824l, 0);
    }

    public String h() {
        return this.f7823c;
    }

    public void i() {
        this.f7823c = null;
    }

    public boolean j() {
        return this.f7823c != null;
    }

    public void k() throws bw {
    }

    @Override // com.umeng.analytics.pro.bq
    public void read(cp cpVar) throws bw {
        f7820j.get(cpVar.D()).b().b(cpVar, this);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            String str = this.a;
            if (str == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.f7822b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.f7823c;
        if (str2 == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bq
    public void write(cp cpVar) throws bw {
        f7820j.get(cpVar.D()).b().a(cpVar, this);
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.e$e */
    /* JADX INFO: compiled from: ImprintValue.java */
    public enum EnumC0137e implements bx {
        VALUE(1, SurveyH5Bean.VALUE),
        TS(2, "ts"),
        GUID(3, "guid");


        /* JADX INFO: renamed from: d */
        private static final Map<String, EnumC0137e> f7828d = new HashMap();

        /* JADX INFO: renamed from: e */
        private final short f7830e;

        /* JADX INFO: renamed from: f */
        private final String f7831f;

        static {
            for (EnumC0137e enumC0137e : EnumSet.allOf(EnumC0137e.class)) {
                f7828d.put(enumC0137e.b(), enumC0137e);
            }
        }

        EnumC0137e(short s, String str) {
            this.f7830e = s;
            this.f7831f = str;
        }

        public static EnumC0137e a(int i2) {
            if (i2 == 1) {
                return VALUE;
            }
            if (i2 == 2) {
                return TS;
            }
            if (i2 != 3) {
                return null;
            }
            return GUID;
        }

        public static EnumC0137e b(int i2) {
            EnumC0137e enumC0137eA = a(i2);
            if (enumC0137eA != null) {
                return enumC0137eA;
            }
            throw new IllegalArgumentException("Field " + i2 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.bx
        public String b() {
            return this.f7831f;
        }

        public static EnumC0137e a(String str) {
            return f7828d.get(str);
        }

        @Override // com.umeng.analytics.pro.bx
        public short a() {
            return this.f7830e;
        }
    }

    public e a(String str) {
        this.a = str;
        return this;
    }

    public void b(boolean z) {
        this.f7824l = bn.a(this.f7824l, 0, z);
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f7823c = null;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public e b(String str) {
        this.f7823c = str;
        return this;
    }

    public e(long j2, String str) {
        this();
        this.f7822b = j2;
        b(true);
        this.f7823c = str;
    }

    public e a(long j2) {
        this.f7822b = j2;
        b(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.bq
    /* JADX INFO: renamed from: a */
    public EnumC0137e fieldForId(int i2) {
        return EnumC0137e.a(i2);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new cj(new db(objectOutputStream)));
        } catch (bw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public e(e eVar) {
        this.f7824l = (byte) 0;
        this.f7825m = new EnumC0137e[]{EnumC0137e.VALUE, EnumC0137e.TS, EnumC0137e.GUID};
        this.f7824l = eVar.f7824l;
        if (eVar.d()) {
            this.a = eVar.a;
        }
        this.f7822b = eVar.f7822b;
        if (eVar.j()) {
            this.f7823c = eVar.f7823c;
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f7824l = (byte) 0;
            read(new cj(new db(objectInputStream)));
        } catch (bw e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
