package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.AbstractC3386cp;
import com.umeng.analytics.pro.AbstractC3396cz;
import com.umeng.analytics.pro.AbstractC3398da;
import com.umeng.analytics.pro.C3366bw;
import com.umeng.analytics.pro.C3373cc;
import com.umeng.analytics.pro.C3374cd;
import com.umeng.analytics.pro.C3375ce;
import com.umeng.analytics.pro.C3376cf;
import com.umeng.analytics.pro.C3378ch;
import com.umeng.analytics.pro.C3380cj;
import com.umeng.analytics.pro.C3381ck;
import com.umeng.analytics.pro.C3382cl;
import com.umeng.analytics.pro.C3383cm;
import com.umeng.analytics.pro.C3387cq;
import com.umeng.analytics.pro.C3389cs;
import com.umeng.analytics.pro.C3391cu;
import com.umeng.analytics.pro.C3392cv;
import com.umeng.analytics.pro.C3393cw;
import com.umeng.analytics.pro.C3399db;
import com.umeng.analytics.pro.InterfaceC3360bq;
import com.umeng.analytics.pro.InterfaceC3367bx;
import com.umeng.analytics.pro.InterfaceC3394cx;
import com.umeng.analytics.pro.InterfaceC3395cy;
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
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: IdTracking.java */
/* renamed from: com.umeng.commonsdk.statistics.proto.c */
/* loaded from: classes2.dex */
public class C3525c implements InterfaceC3360bq<C3525c, e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<e, C3373cc> f12873d;

    /* renamed from: e */
    private static final long f12874e = -5764118265293965743L;

    /* renamed from: f */
    private static final C3391cu f12875f = new C3391cu("IdTracking");

    /* renamed from: g */
    private static final C3381ck f12876g = new C3381ck("snapshots", C3393cw.f11871k, 1);

    /* renamed from: h */
    private static final C3381ck f12877h = new C3381ck("journals", C3393cw.f11873m, 2);

    /* renamed from: i */
    private static final C3381ck f12878i = new C3381ck("checksum", (byte) 11, 3);

    /* renamed from: j */
    private static final Map<Class<? extends InterfaceC3394cx>, InterfaceC3395cy> f12879j = new HashMap();

    /* renamed from: a */
    public Map<String, C3524b> f12880a;

    /* renamed from: b */
    public List<C3523a> f12881b;

    /* renamed from: c */
    public String f12882c;

    /* renamed from: k */
    private e[] f12883k;

    /* compiled from: IdTracking.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.c$a */
    private static class a extends AbstractC3396cz<C3525c> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo10975b(AbstractC3386cp abstractC3386cp, C3525c c3525c) throws C3366bw {
            abstractC3386cp.mo11137j();
            while (true) {
                C3381ck mo11139l = abstractC3386cp.mo11139l();
                byte b2 = mo11139l.f11834b;
                if (b2 == 0) {
                    abstractC3386cp.mo11138k();
                    c3525c.m12005n();
                    return;
                }
                short s = mo11139l.f11835c;
                int i2 = 0;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            C3389cs.m11183a(abstractC3386cp, b2);
                        } else if (b2 == 11) {
                            c3525c.f12882c = abstractC3386cp.mo11153z();
                            c3525c.m11994c(true);
                        } else {
                            C3389cs.m11183a(abstractC3386cp, b2);
                        }
                    } else if (b2 == 15) {
                        C3382cl mo11143p = abstractC3386cp.mo11143p();
                        c3525c.f12881b = new ArrayList(mo11143p.f11837b);
                        while (i2 < mo11143p.f11837b) {
                            C3523a c3523a = new C3523a();
                            c3523a.read(abstractC3386cp);
                            c3525c.f12881b.add(c3523a);
                            i2++;
                        }
                        abstractC3386cp.mo11144q();
                        c3525c.m11992b(true);
                    } else {
                        C3389cs.m11183a(abstractC3386cp, b2);
                    }
                } else if (b2 == 13) {
                    C3383cm mo11141n = abstractC3386cp.mo11141n();
                    c3525c.f12880a = new HashMap(mo11141n.f11840c * 2);
                    while (i2 < mo11141n.f11840c) {
                        String mo11153z = abstractC3386cp.mo11153z();
                        C3524b c3524b = new C3524b();
                        c3524b.read(abstractC3386cp);
                        c3525c.f12880a.put(mo11153z, c3524b);
                        i2++;
                    }
                    abstractC3386cp.mo11142o();
                    c3525c.m11990a(true);
                } else {
                    C3389cs.m11183a(abstractC3386cp, b2);
                }
                abstractC3386cp.mo11140m();
            }
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo10973a(AbstractC3386cp abstractC3386cp, C3525c c3525c) throws C3366bw {
            c3525c.m12005n();
            abstractC3386cp.mo11121a(C3525c.f12875f);
            if (c3525c.f12880a != null) {
                abstractC3386cp.mo11116a(C3525c.f12876g);
                abstractC3386cp.mo11118a(new C3383cm((byte) 11, (byte) 12, c3525c.f12880a.size()));
                for (Map.Entry<String, C3524b> entry : c3525c.f12880a.entrySet()) {
                    abstractC3386cp.mo11122a(entry.getKey());
                    entry.getValue().write(abstractC3386cp);
                }
                abstractC3386cp.mo11132e();
                abstractC3386cp.mo11128c();
            }
            if (c3525c.f12881b != null && c3525c.m12001j()) {
                abstractC3386cp.mo11116a(C3525c.f12877h);
                abstractC3386cp.mo11117a(new C3382cl((byte) 12, c3525c.f12881b.size()));
                Iterator<C3523a> it = c3525c.f12881b.iterator();
                while (it.hasNext()) {
                    it.next().write(abstractC3386cp);
                }
                abstractC3386cp.mo11133f();
                abstractC3386cp.mo11128c();
            }
            if (c3525c.f12882c != null && c3525c.m12004m()) {
                abstractC3386cp.mo11116a(C3525c.f12878i);
                abstractC3386cp.mo11122a(c3525c.f12882c);
                abstractC3386cp.mo11128c();
            }
            abstractC3386cp.mo11130d();
            abstractC3386cp.mo11127b();
        }
    }

    /* compiled from: IdTracking.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.c$b */
    private static class b implements InterfaceC3395cy {
        private b() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3395cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a mo10977b() {
            return new a();
        }
    }

    /* compiled from: IdTracking.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.c$c */
    private static class c extends AbstractC3398da<C3525c> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo10973a(AbstractC3386cp abstractC3386cp, C3525c c3525c) throws C3366bw {
            C3392cv c3392cv = (C3392cv) abstractC3386cp;
            c3392cv.mo11114a(c3525c.f12880a.size());
            for (Map.Entry<String, C3524b> entry : c3525c.f12880a.entrySet()) {
                c3392cv.mo11122a(entry.getKey());
                entry.getValue().write(c3392cv);
            }
            BitSet bitSet = new BitSet();
            if (c3525c.m12001j()) {
                bitSet.set(0);
            }
            if (c3525c.m12004m()) {
                bitSet.set(1);
            }
            c3392cv.m11187a(bitSet, 2);
            if (c3525c.m12001j()) {
                c3392cv.mo11114a(c3525c.f12881b.size());
                Iterator<C3523a> it = c3525c.f12881b.iterator();
                while (it.hasNext()) {
                    it.next().write(c3392cv);
                }
            }
            if (c3525c.m12004m()) {
                c3392cv.mo11122a(c3525c.f12882c);
            }
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo10975b(AbstractC3386cp abstractC3386cp, C3525c c3525c) throws C3366bw {
            C3392cv c3392cv = (C3392cv) abstractC3386cp;
            C3383cm c3383cm = new C3383cm((byte) 11, (byte) 12, c3392cv.mo11150w());
            c3525c.f12880a = new HashMap(c3383cm.f11840c * 2);
            for (int i2 = 0; i2 < c3383cm.f11840c; i2++) {
                String mo11153z = c3392cv.mo11153z();
                C3524b c3524b = new C3524b();
                c3524b.read(c3392cv);
                c3525c.f12880a.put(mo11153z, c3524b);
            }
            c3525c.m11990a(true);
            BitSet m11188b = c3392cv.m11188b(2);
            if (m11188b.get(0)) {
                C3382cl c3382cl = new C3382cl((byte) 12, c3392cv.mo11150w());
                c3525c.f12881b = new ArrayList(c3382cl.f11837b);
                for (int i3 = 0; i3 < c3382cl.f11837b; i3++) {
                    C3523a c3523a = new C3523a();
                    c3523a.read(c3392cv);
                    c3525c.f12881b.add(c3523a);
                }
                c3525c.m11992b(true);
            }
            if (m11188b.get(1)) {
                c3525c.f12882c = c3392cv.mo11153z();
                c3525c.m11994c(true);
            }
        }
    }

    /* compiled from: IdTracking.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.c$d */
    private static class d implements InterfaceC3395cy {
        private d() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3395cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c mo10977b() {
            return new c();
        }
    }

    static {
        f12879j.put(AbstractC3396cz.class, new b());
        f12879j.put(AbstractC3398da.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.SNAPSHOTS, (e) new C3373cc("snapshots", (byte) 1, new C3376cf(C3393cw.f11871k, new C3374cd((byte) 11), new C3378ch((byte) 12, C3524b.class))));
        enumMap.put((EnumMap) e.JOURNALS, (e) new C3373cc("journals", (byte) 2, new C3375ce(C3393cw.f11873m, new C3378ch((byte) 12, C3523a.class))));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new C3373cc("checksum", (byte) 2, new C3374cd((byte) 11)));
        f12873d = Collections.unmodifiableMap(enumMap);
        C3373cc.m11103a(C3525c.class, f12873d);
    }

    public C3525c() {
        this.f12883k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C3525c deepCopy() {
        return new C3525c(this);
    }

    /* renamed from: b */
    public int m11991b() {
        Map<String, C3524b> map = this.f12880a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    /* renamed from: c */
    public Map<String, C3524b> m11993c() {
        return this.f12880a;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void clear() {
        this.f12880a = null;
        this.f12881b = null;
        this.f12882c = null;
    }

    /* renamed from: d */
    public void m11995d() {
        this.f12880a = null;
    }

    /* renamed from: e */
    public boolean m11996e() {
        return this.f12880a != null;
    }

    /* renamed from: f */
    public int m11997f() {
        List<C3523a> list = this.f12881b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: g */
    public Iterator<C3523a> m11998g() {
        List<C3523a> list = this.f12881b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    /* renamed from: h */
    public List<C3523a> m11999h() {
        return this.f12881b;
    }

    /* renamed from: i */
    public void m12000i() {
        this.f12881b = null;
    }

    /* renamed from: j */
    public boolean m12001j() {
        return this.f12881b != null;
    }

    /* renamed from: k */
    public String m12002k() {
        return this.f12882c;
    }

    /* renamed from: l */
    public void m12003l() {
        this.f12882c = null;
    }

    /* renamed from: m */
    public boolean m12004m() {
        return this.f12882c != null;
    }

    /* renamed from: n */
    public void m12005n() throws C3366bw {
        if (this.f12880a != null) {
            return;
        }
        throw new C3387cq("Required field 'snapshots' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void read(AbstractC3386cp abstractC3386cp) throws C3366bw {
        f12879j.get(abstractC3386cp.mo11179D()).mo10977b().mo10975b(abstractC3386cp, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        Map<String, C3524b> map = this.f12880a;
        if (map == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(map);
        }
        if (m12001j()) {
            sb.append(", ");
            sb.append("journals:");
            List<C3523a> list = this.f12881b;
            if (list == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(list);
            }
        }
        if (m12004m()) {
            sb.append(", ");
            sb.append("checksum:");
            String str = this.f12882c;
            if (str == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void write(AbstractC3386cp abstractC3386cp) throws C3366bw {
        f12879j.get(abstractC3386cp.mo11179D()).mo10977b().mo10973a(abstractC3386cp, this);
    }

    /* compiled from: IdTracking.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.c$e */
    public enum e implements InterfaceC3367bx {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");


        /* renamed from: d */
        private static final Map<String, e> f12887d = new HashMap();

        /* renamed from: e */
        private final short f12889e;

        /* renamed from: f */
        private final String f12890f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f12887d.put(eVar.mo10985b(), eVar);
            }
        }

        e(short s, String str) {
            this.f12889e = s;
            this.f12890f = str;
        }

        /* renamed from: a */
        public static e m12012a(int i2) {
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

        /* renamed from: b */
        public static e m12014b(int i2) {
            e m12012a = m12012a(i2);
            if (m12012a != null) {
                return m12012a;
            }
            throw new IllegalArgumentException("Field " + i2 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.InterfaceC3367bx
        /* renamed from: b */
        public String mo10985b() {
            return this.f12890f;
        }

        /* renamed from: a */
        public static e m12013a(String str) {
            return f12887d.get(str);
        }

        @Override // com.umeng.analytics.pro.InterfaceC3367bx
        /* renamed from: a */
        public short mo10984a() {
            return this.f12889e;
        }
    }

    /* renamed from: a */
    public void m11989a(String str, C3524b c3524b) {
        if (this.f12880a == null) {
            this.f12880a = new HashMap();
        }
        this.f12880a.put(str, c3524b);
    }

    /* renamed from: b */
    public void m11992b(boolean z) {
        if (z) {
            return;
        }
        this.f12881b = null;
    }

    /* renamed from: c */
    public void m11994c(boolean z) {
        if (z) {
            return;
        }
        this.f12882c = null;
    }

    public C3525c(Map<String, C3524b> map) {
        this();
        this.f12880a = map;
    }

    public C3525c(C3525c c3525c) {
        this.f12883k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (c3525c.m11996e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, C3524b> entry : c3525c.f12880a.entrySet()) {
                hashMap.put(entry.getKey(), new C3524b(entry.getValue()));
            }
            this.f12880a = hashMap;
        }
        if (c3525c.m12001j()) {
            ArrayList arrayList = new ArrayList();
            Iterator<C3523a> it = c3525c.f12881b.iterator();
            while (it.hasNext()) {
                arrayList.add(new C3523a(it.next()));
            }
            this.f12881b = arrayList;
        }
        if (c3525c.m12004m()) {
            this.f12882c = c3525c.f12882c;
        }
    }

    /* renamed from: a */
    public C3525c m11987a(Map<String, C3524b> map) {
        this.f12880a = map;
        return this;
    }

    /* renamed from: a */
    public void m11990a(boolean z) {
        if (z) {
            return;
        }
        this.f12880a = null;
    }

    /* renamed from: a */
    public void m11988a(C3523a c3523a) {
        if (this.f12881b == null) {
            this.f12881b = new ArrayList();
        }
        this.f12881b.add(c3523a);
    }

    /* renamed from: a */
    public C3525c m11986a(List<C3523a> list) {
        this.f12881b = list;
        return this;
    }

    /* renamed from: a */
    public C3525c m11985a(String str) {
        this.f12882c = str;
        return this;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.m12012a(i2);
    }

    /* renamed from: a */
    private void m11978a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new C3380cj(new C3399db(objectOutputStream)));
        } catch (C3366bw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* renamed from: a */
    private void m11977a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            read(new C3380cj(new C3399db(objectInputStream)));
        } catch (C3366bw e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
