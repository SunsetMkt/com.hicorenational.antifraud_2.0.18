package com.umeng.analytics.pro;

import com.hihonor.honorid.core.data.UserInfo;
import com.tencent.open.SocialOperation;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: UMEnvelope.java */
/* JADX INFO: loaded from: classes2.dex */
public class bi implements bq<bi, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;

    /* JADX INFO: renamed from: k */
    public static final Map<e, cc> f7063k;

    /* JADX INFO: renamed from: l */
    private static final long f7064l = 420342210744516016L;

    /* JADX INFO: renamed from: m */
    private static final cu f7065m = new cu("UMEnvelope");

    /* JADX INFO: renamed from: n */
    private static final ck f7066n = new ck("version", (byte) 11, 1);
    private static final ck o = new ck(UserInfo.ADDRESS, (byte) 11, 2);
    private static final ck p = new ck(SocialOperation.GAME_SIGNATURE, (byte) 11, 3);
    private static final ck q = new ck("serial_num", (byte) 8, 4);
    private static final ck r = new ck("ts_secs", (byte) 8, 5);
    private static final ck s = new ck("length", (byte) 8, 6);
    private static final ck t = new ck("entity", (byte) 11, 7);
    private static final ck u = new ck("guid", (byte) 11, 8);
    private static final ck v = new ck("checksum", (byte) 11, 9);
    private static final ck w = new ck("codex", (byte) 8, 10);
    private static final Map<Class<? extends cx>, cy> x = new HashMap();
    private static final int y = 0;
    private static final int z = 1;
    private byte C;
    private e[] D;
    public String a;

    /* JADX INFO: renamed from: b */
    public String f7067b;

    /* JADX INFO: renamed from: c */
    public String f7068c;

    /* JADX INFO: renamed from: d */
    public int f7069d;

    /* JADX INFO: renamed from: e */
    public int f7070e;

    /* JADX INFO: renamed from: f */
    public int f7071f;

    /* JADX INFO: renamed from: g */
    public ByteBuffer f7072g;

    /* JADX INFO: renamed from: h */
    public String f7073h;

    /* JADX INFO: renamed from: i */
    public String f7074i;

    /* JADX INFO: renamed from: j */
    public int f7075j;

    /* JADX INFO: compiled from: UMEnvelope.java */
    private static class a extends cz<bi> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cx
        /* JADX INFO: renamed from: a */
        public void b(cp cpVar, bi biVar) throws bw {
            cpVar.j();
            while (true) {
                ck ckVarL = cpVar.l();
                byte b2 = ckVarL.f7175b;
                if (b2 == 0) {
                    cpVar.k();
                    if (!biVar.m()) {
                        throw new cq("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    }
                    if (!biVar.p()) {
                        throw new cq("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    }
                    if (biVar.s()) {
                        biVar.G();
                        return;
                    }
                    throw new cq("Required field 'length' was not found in serialized data! Struct: " + toString());
                }
                switch (ckVarL.f7176c) {
                    case 1:
                        if (b2 != 11) {
                            cs.a(cpVar, b2);
                        } else {
                            biVar.a = cpVar.z();
                            biVar.a(true);
                        }
                        break;
                    case 2:
                        if (b2 != 11) {
                            cs.a(cpVar, b2);
                        } else {
                            biVar.f7067b = cpVar.z();
                            biVar.b(true);
                        }
                        break;
                    case 3:
                        if (b2 != 11) {
                            cs.a(cpVar, b2);
                        } else {
                            biVar.f7068c = cpVar.z();
                            biVar.c(true);
                        }
                        break;
                    case 4:
                        if (b2 != 8) {
                            cs.a(cpVar, b2);
                        } else {
                            biVar.f7069d = cpVar.w();
                            biVar.d(true);
                        }
                        break;
                    case 5:
                        if (b2 != 8) {
                            cs.a(cpVar, b2);
                        } else {
                            biVar.f7070e = cpVar.w();
                            biVar.e(true);
                        }
                        break;
                    case 6:
                        if (b2 != 8) {
                            cs.a(cpVar, b2);
                        } else {
                            biVar.f7071f = cpVar.w();
                            biVar.f(true);
                        }
                        break;
                    case 7:
                        if (b2 != 11) {
                            cs.a(cpVar, b2);
                        } else {
                            biVar.f7072g = cpVar.A();
                            biVar.g(true);
                        }
                        break;
                    case 8:
                        if (b2 != 11) {
                            cs.a(cpVar, b2);
                        } else {
                            biVar.f7073h = cpVar.z();
                            biVar.h(true);
                        }
                        break;
                    case 9:
                        if (b2 != 11) {
                            cs.a(cpVar, b2);
                        } else {
                            biVar.f7074i = cpVar.z();
                            biVar.i(true);
                        }
                        break;
                    case 10:
                        if (b2 != 8) {
                            cs.a(cpVar, b2);
                        } else {
                            biVar.f7075j = cpVar.w();
                            biVar.j(true);
                        }
                        break;
                    default:
                        cs.a(cpVar, b2);
                        break;
                }
                cpVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cx
        /* JADX INFO: renamed from: b */
        public void a(cp cpVar, bi biVar) throws bw {
            biVar.G();
            cpVar.a(bi.f7065m);
            if (biVar.a != null) {
                cpVar.a(bi.f7066n);
                cpVar.a(biVar.a);
                cpVar.c();
            }
            if (biVar.f7067b != null) {
                cpVar.a(bi.o);
                cpVar.a(biVar.f7067b);
                cpVar.c();
            }
            if (biVar.f7068c != null) {
                cpVar.a(bi.p);
                cpVar.a(biVar.f7068c);
                cpVar.c();
            }
            cpVar.a(bi.q);
            cpVar.a(biVar.f7069d);
            cpVar.c();
            cpVar.a(bi.r);
            cpVar.a(biVar.f7070e);
            cpVar.c();
            cpVar.a(bi.s);
            cpVar.a(biVar.f7071f);
            cpVar.c();
            if (biVar.f7072g != null) {
                cpVar.a(bi.t);
                cpVar.a(biVar.f7072g);
                cpVar.c();
            }
            if (biVar.f7073h != null) {
                cpVar.a(bi.u);
                cpVar.a(biVar.f7073h);
                cpVar.c();
            }
            if (biVar.f7074i != null) {
                cpVar.a(bi.v);
                cpVar.a(biVar.f7074i);
                cpVar.c();
            }
            if (biVar.F()) {
                cpVar.a(bi.w);
                cpVar.a(biVar.f7075j);
                cpVar.c();
            }
            cpVar.d();
            cpVar.b();
        }
    }

    /* JADX INFO: compiled from: UMEnvelope.java */
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

    /* JADX INFO: compiled from: UMEnvelope.java */
    private static class c extends da<bi> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cx
        public void a(cp cpVar, bi biVar) throws bw {
            cv cvVar = (cv) cpVar;
            cvVar.a(biVar.a);
            cvVar.a(biVar.f7067b);
            cvVar.a(biVar.f7068c);
            cvVar.a(biVar.f7069d);
            cvVar.a(biVar.f7070e);
            cvVar.a(biVar.f7071f);
            cvVar.a(biVar.f7072g);
            cvVar.a(biVar.f7073h);
            cvVar.a(biVar.f7074i);
            BitSet bitSet = new BitSet();
            if (biVar.F()) {
                bitSet.set(0);
            }
            cvVar.a(bitSet, 1);
            if (biVar.F()) {
                cvVar.a(biVar.f7075j);
            }
        }

        @Override // com.umeng.analytics.pro.cx
        public void b(cp cpVar, bi biVar) throws bw {
            cv cvVar = (cv) cpVar;
            biVar.a = cvVar.z();
            biVar.a(true);
            biVar.f7067b = cvVar.z();
            biVar.b(true);
            biVar.f7068c = cvVar.z();
            biVar.c(true);
            biVar.f7069d = cvVar.w();
            biVar.d(true);
            biVar.f7070e = cvVar.w();
            biVar.e(true);
            biVar.f7071f = cvVar.w();
            biVar.f(true);
            biVar.f7072g = cvVar.A();
            biVar.g(true);
            biVar.f7073h = cvVar.z();
            biVar.h(true);
            biVar.f7074i = cvVar.z();
            biVar.i(true);
            if (cvVar.b(1).get(0)) {
                biVar.f7075j = cvVar.w();
                biVar.j(true);
            }
        }
    }

    /* JADX INFO: compiled from: UMEnvelope.java */
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
        x.put(cz.class, new b());
        x.put(da.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.VERSION, new cc("version", (byte) 1, new cd((byte) 11)));
        enumMap.put(e.ADDRESS, new cc(UserInfo.ADDRESS, (byte) 1, new cd((byte) 11)));
        enumMap.put(e.SIGNATURE, new cc(SocialOperation.GAME_SIGNATURE, (byte) 1, new cd((byte) 11)));
        enumMap.put(e.SERIAL_NUM, new cc("serial_num", (byte) 1, new cd((byte) 8)));
        enumMap.put(e.TS_SECS, new cc("ts_secs", (byte) 1, new cd((byte) 8)));
        enumMap.put(e.LENGTH, new cc("length", (byte) 1, new cd((byte) 8)));
        enumMap.put(e.ENTITY, new cc("entity", (byte) 1, new cd((byte) 11, true)));
        enumMap.put(e.GUID, new cc("guid", (byte) 1, new cd((byte) 11)));
        enumMap.put(e.CHECKSUM, new cc("checksum", (byte) 1, new cd((byte) 11)));
        enumMap.put(e.CODEX, new cc("codex", (byte) 2, new cd((byte) 8)));
        f7063k = Collections.unmodifiableMap(enumMap);
        cc.a(bi.class, f7063k);
    }

    public bi() {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
    }

    public String A() {
        return this.f7074i;
    }

    public void B() {
        this.f7074i = null;
    }

    public boolean C() {
        return this.f7074i != null;
    }

    public int D() {
        return this.f7075j;
    }

    public void E() {
        this.C = bn.b(this.C, 3);
    }

    public boolean F() {
        return bn.a(this.C, 3);
    }

    public void G() throws bw {
        if (this.a == null) {
            throw new cq("Required field 'version' was not present! Struct: " + toString());
        }
        if (this.f7067b == null) {
            throw new cq("Required field 'address' was not present! Struct: " + toString());
        }
        if (this.f7068c == null) {
            throw new cq("Required field 'signature' was not present! Struct: " + toString());
        }
        if (this.f7072g == null) {
            throw new cq("Required field 'entity' was not present! Struct: " + toString());
        }
        if (this.f7073h == null) {
            throw new cq("Required field 'guid' was not present! Struct: " + toString());
        }
        if (this.f7074i != null) {
            return;
        }
        throw new cq("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.bq
    /* JADX INFO: renamed from: a */
    public bi deepCopy() {
        return new bi(this);
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
        this.f7067b = null;
        this.f7068c = null;
        d(false);
        this.f7069d = 0;
        e(false);
        this.f7070e = 0;
        f(false);
        this.f7071f = 0;
        this.f7072g = null;
        this.f7073h = null;
        this.f7074i = null;
        j(false);
        this.f7075j = 0;
    }

    public boolean d() {
        return this.a != null;
    }

    public String e() {
        return this.f7067b;
    }

    public void f() {
        this.f7067b = null;
    }

    public boolean g() {
        return this.f7067b != null;
    }

    public String h() {
        return this.f7068c;
    }

    public void i() {
        this.f7068c = null;
    }

    public boolean j() {
        return this.f7068c != null;
    }

    public int k() {
        return this.f7069d;
    }

    public void l() {
        this.C = bn.b(this.C, 0);
    }

    public boolean m() {
        return bn.a(this.C, 0);
    }

    public int n() {
        return this.f7070e;
    }

    public void o() {
        this.C = bn.b(this.C, 1);
    }

    public boolean p() {
        return bn.a(this.C, 1);
    }

    public int q() {
        return this.f7071f;
    }

    public void r() {
        this.C = bn.b(this.C, 2);
    }

    @Override // com.umeng.analytics.pro.bq
    public void read(cp cpVar) throws bw {
        x.get(cpVar.D()).b().b(cpVar, this);
    }

    public boolean s() {
        return bn.a(this.C, 2);
    }

    public byte[] t() {
        a(br.c(this.f7072g));
        ByteBuffer byteBuffer = this.f7072g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        String str = this.a;
        if (str == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.f7067b;
        if (str2 == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.f7068c;
        if (str3 == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.f7069d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.f7070e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f7071f);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.f7072g;
        if (byteBuffer == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            br.a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.f7073h;
        if (str4 == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        String str5 = this.f7074i;
        if (str5 == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(str5);
        }
        if (F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.f7075j);
        }
        sb.append(")");
        return sb.toString();
    }

    public ByteBuffer u() {
        return this.f7072g;
    }

    public void v() {
        this.f7072g = null;
    }

    public boolean w() {
        return this.f7072g != null;
    }

    @Override // com.umeng.analytics.pro.bq
    public void write(cp cpVar) throws bw {
        x.get(cpVar.D()).b().a(cpVar, this);
    }

    public String x() {
        return this.f7073h;
    }

    public void y() {
        this.f7073h = null;
    }

    public boolean z() {
        return this.f7073h != null;
    }

    /* JADX INFO: compiled from: UMEnvelope.java */
    public enum e implements bx {
        VERSION(1, "version"),
        ADDRESS(2, UserInfo.ADDRESS),
        SIGNATURE(3, SocialOperation.GAME_SIGNATURE),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");


        /* JADX INFO: renamed from: k */
        private static final Map<String, e> f7085k = new HashMap();

        /* JADX INFO: renamed from: l */
        private final short f7087l;

        /* JADX INFO: renamed from: m */
        private final String f7088m;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f7085k.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f7087l = s;
            this.f7088m = str;
        }

        public static e a(int i2) {
            switch (i2) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
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
            return this.f7088m;
        }

        public static e a(String str) {
            return f7085k.get(str);
        }

        @Override // com.umeng.analytics.pro.bx
        public short a() {
            return this.f7087l;
        }
    }

    public bi a(String str) {
        this.a = str;
        return this;
    }

    public bi b(String str) {
        this.f7067b = str;
        return this;
    }

    public bi c(String str) {
        this.f7068c = str;
        return this;
    }

    public void d(boolean z2) {
        this.C = bn.a(this.C, 0, z2);
    }

    public void e(boolean z2) {
        this.C = bn.a(this.C, 1, z2);
    }

    public void f(boolean z2) {
        this.C = bn.a(this.C, 2, z2);
    }

    public void g(boolean z2) {
        if (z2) {
            return;
        }
        this.f7072g = null;
    }

    public void h(boolean z2) {
        if (z2) {
            return;
        }
        this.f7073h = null;
    }

    public void i(boolean z2) {
        if (z2) {
            return;
        }
        this.f7074i = null;
    }

    public void j(boolean z2) {
        this.C = bn.a(this.C, 3, z2);
    }

    public void a(boolean z2) {
        if (z2) {
            return;
        }
        this.a = null;
    }

    public void b(boolean z2) {
        if (z2) {
            return;
        }
        this.f7067b = null;
    }

    public void c(boolean z2) {
        if (z2) {
            return;
        }
        this.f7068c = null;
    }

    public bi d(String str) {
        this.f7073h = str;
        return this;
    }

    public bi e(String str) {
        this.f7074i = str;
        return this;
    }

    public bi(String str, String str2, String str3, int i2, int i3, int i4, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.a = str;
        this.f7067b = str2;
        this.f7068c = str3;
        this.f7069d = i2;
        d(true);
        this.f7070e = i3;
        e(true);
        this.f7071f = i4;
        f(true);
        this.f7072g = byteBuffer;
        this.f7073h = str4;
        this.f7074i = str5;
    }

    public bi a(int i2) {
        this.f7069d = i2;
        d(true);
        return this;
    }

    public bi b(int i2) {
        this.f7070e = i2;
        e(true);
        return this;
    }

    public bi c(int i2) {
        this.f7071f = i2;
        f(true);
        return this;
    }

    public bi d(int i2) {
        this.f7075j = i2;
        j(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.bq
    /* JADX INFO: renamed from: e */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public bi a(byte[] bArr) {
        a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    public bi a(ByteBuffer byteBuffer) {
        this.f7072g = byteBuffer;
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
            this.C = (byte) 0;
            read(new cj(new db(objectInputStream)));
        } catch (bw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public bi(bi biVar) {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
        this.C = biVar.C;
        if (biVar.d()) {
            this.a = biVar.a;
        }
        if (biVar.g()) {
            this.f7067b = biVar.f7067b;
        }
        if (biVar.j()) {
            this.f7068c = biVar.f7068c;
        }
        this.f7069d = biVar.f7069d;
        this.f7070e = biVar.f7070e;
        this.f7071f = biVar.f7071f;
        if (biVar.w()) {
            this.f7072g = br.d(biVar.f7072g);
        }
        if (biVar.z()) {
            this.f7073h = biVar.f7073h;
        }
        if (biVar.C()) {
            this.f7074i = biVar.f7074i;
        }
        this.f7075j = biVar.f7075j;
    }
}
