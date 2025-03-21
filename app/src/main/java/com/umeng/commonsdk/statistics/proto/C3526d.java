package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.AbstractC3386cp;
import com.umeng.analytics.pro.AbstractC3396cz;
import com.umeng.analytics.pro.AbstractC3398da;
import com.umeng.analytics.pro.C3357bn;
import com.umeng.analytics.pro.C3366bw;
import com.umeng.analytics.pro.C3373cc;
import com.umeng.analytics.pro.C3374cd;
import com.umeng.analytics.pro.C3376cf;
import com.umeng.analytics.pro.C3378ch;
import com.umeng.analytics.pro.C3380cj;
import com.umeng.analytics.pro.C3381ck;
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
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: Imprint.java */
/* renamed from: com.umeng.commonsdk.statistics.proto.d */
/* loaded from: classes2.dex */
public class C3526d implements InterfaceC3360bq<C3526d, e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<e, C3373cc> f12891d;

    /* renamed from: e */
    private static final long f12892e = 2846460275012375038L;

    /* renamed from: f */
    private static final C3391cu f12893f = new C3391cu("Imprint");

    /* renamed from: g */
    private static final C3381ck f12894g = new C3381ck("property", C3393cw.f11871k, 1);

    /* renamed from: h */
    private static final C3381ck f12895h = new C3381ck("version", (byte) 8, 2);

    /* renamed from: i */
    private static final C3381ck f12896i = new C3381ck("checksum", (byte) 11, 3);

    /* renamed from: j */
    private static final Map<Class<? extends InterfaceC3394cx>, InterfaceC3395cy> f12897j = new HashMap();

    /* renamed from: k */
    private static final int f12898k = 0;

    /* renamed from: a */
    public Map<String, C3527e> f12899a;

    /* renamed from: b */
    public int f12900b;

    /* renamed from: c */
    public String f12901c;

    /* renamed from: l */
    private byte f12902l;

    /* compiled from: Imprint.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.d$a */
    private static class a extends AbstractC3396cz<C3526d> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo10975b(AbstractC3386cp abstractC3386cp, C3526d c3526d) throws C3366bw {
            abstractC3386cp.mo11137j();
            while (true) {
                C3381ck mo11139l = abstractC3386cp.mo11139l();
                byte b2 = mo11139l.f11834b;
                if (b2 == 0) {
                    break;
                }
                short s = mo11139l.f11835c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            C3389cs.m11183a(abstractC3386cp, b2);
                        } else if (b2 == 11) {
                            c3526d.f12901c = abstractC3386cp.mo11153z();
                            c3526d.m12031c(true);
                        } else {
                            C3389cs.m11183a(abstractC3386cp, b2);
                        }
                    } else if (b2 == 8) {
                        c3526d.f12900b = abstractC3386cp.mo11150w();
                        c3526d.m12029b(true);
                    } else {
                        C3389cs.m11183a(abstractC3386cp, b2);
                    }
                } else if (b2 == 13) {
                    C3383cm mo11141n = abstractC3386cp.mo11141n();
                    c3526d.f12899a = new HashMap(mo11141n.f11840c * 2);
                    for (int i2 = 0; i2 < mo11141n.f11840c; i2++) {
                        String mo11153z = abstractC3386cp.mo11153z();
                        C3527e c3527e = new C3527e();
                        c3527e.read(abstractC3386cp);
                        c3526d.f12899a.put(mo11153z, c3527e);
                    }
                    abstractC3386cp.mo11142o();
                    c3526d.m12026a(true);
                } else {
                    C3389cs.m11183a(abstractC3386cp, b2);
                }
                abstractC3386cp.mo11140m();
            }
            abstractC3386cp.mo11138k();
            if (c3526d.m12036h()) {
                c3526d.m12040l();
                return;
            }
            throw new C3387cq("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo10973a(AbstractC3386cp abstractC3386cp, C3526d c3526d) throws C3366bw {
            c3526d.m12040l();
            abstractC3386cp.mo11121a(C3526d.f12893f);
            if (c3526d.f12899a != null) {
                abstractC3386cp.mo11116a(C3526d.f12894g);
                abstractC3386cp.mo11118a(new C3383cm((byte) 11, (byte) 12, c3526d.f12899a.size()));
                for (Map.Entry<String, C3527e> entry : c3526d.f12899a.entrySet()) {
                    abstractC3386cp.mo11122a(entry.getKey());
                    entry.getValue().write(abstractC3386cp);
                }
                abstractC3386cp.mo11132e();
                abstractC3386cp.mo11128c();
            }
            abstractC3386cp.mo11116a(C3526d.f12895h);
            abstractC3386cp.mo11114a(c3526d.f12900b);
            abstractC3386cp.mo11128c();
            if (c3526d.f12901c != null) {
                abstractC3386cp.mo11116a(C3526d.f12896i);
                abstractC3386cp.mo11122a(c3526d.f12901c);
                abstractC3386cp.mo11128c();
            }
            abstractC3386cp.mo11130d();
            abstractC3386cp.mo11127b();
        }
    }

    /* compiled from: Imprint.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.d$b */
    private static class b implements InterfaceC3395cy {
        private b() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3395cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a mo10977b() {
            return new a();
        }
    }

    /* compiled from: Imprint.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.d$c */
    private static class c extends AbstractC3398da<C3526d> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo10973a(AbstractC3386cp abstractC3386cp, C3526d c3526d) throws C3366bw {
            C3392cv c3392cv = (C3392cv) abstractC3386cp;
            c3392cv.mo11114a(c3526d.f12899a.size());
            for (Map.Entry<String, C3527e> entry : c3526d.f12899a.entrySet()) {
                c3392cv.mo11122a(entry.getKey());
                entry.getValue().write(c3392cv);
            }
            c3392cv.mo11114a(c3526d.f12900b);
            c3392cv.mo11122a(c3526d.f12901c);
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo10975b(AbstractC3386cp abstractC3386cp, C3526d c3526d) throws C3366bw {
            C3392cv c3392cv = (C3392cv) abstractC3386cp;
            C3383cm c3383cm = new C3383cm((byte) 11, (byte) 12, c3392cv.mo11150w());
            c3526d.f12899a = new HashMap(c3383cm.f11840c * 2);
            for (int i2 = 0; i2 < c3383cm.f11840c; i2++) {
                String mo11153z = c3392cv.mo11153z();
                C3527e c3527e = new C3527e();
                c3527e.read(c3392cv);
                c3526d.f12899a.put(mo11153z, c3527e);
            }
            c3526d.m12026a(true);
            c3526d.f12900b = c3392cv.mo11150w();
            c3526d.m12029b(true);
            c3526d.f12901c = c3392cv.mo11153z();
            c3526d.m12031c(true);
        }
    }

    /* compiled from: Imprint.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.d$d */
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
        f12897j.put(AbstractC3396cz.class, new b());
        f12897j.put(AbstractC3398da.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.PROPERTY, (e) new C3373cc("property", (byte) 1, new C3376cf(C3393cw.f11871k, new C3374cd((byte) 11), new C3378ch((byte) 12, C3527e.class))));
        enumMap.put((EnumMap) e.VERSION, (e) new C3373cc("version", (byte) 1, new C3374cd((byte) 8)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new C3373cc("checksum", (byte) 1, new C3374cd((byte) 11)));
        f12891d = Collections.unmodifiableMap(enumMap);
        C3373cc.m11103a(C3526d.class, f12891d);
    }

    public C3526d() {
        this.f12902l = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C3526d deepCopy() {
        return new C3526d(this);
    }

    /* renamed from: b */
    public int m12027b() {
        Map<String, C3527e> map = this.f12899a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    /* renamed from: c */
    public Map<String, C3527e> m12030c() {
        return this.f12899a;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void clear() {
        this.f12899a = null;
        m12029b(false);
        this.f12900b = 0;
        this.f12901c = null;
    }

    /* renamed from: d */
    public void m12032d() {
        this.f12899a = null;
    }

    /* renamed from: e */
    public boolean m12033e() {
        return this.f12899a != null;
    }

    /* renamed from: f */
    public int m12034f() {
        return this.f12900b;
    }

    /* renamed from: g */
    public void m12035g() {
        this.f12902l = C3357bn.m11021b(this.f12902l, 0);
    }

    /* renamed from: h */
    public boolean m12036h() {
        return C3357bn.m11017a(this.f12902l, 0);
    }

    /* renamed from: i */
    public String m12037i() {
        return this.f12901c;
    }

    /* renamed from: j */
    public void m12038j() {
        this.f12901c = null;
    }

    /* renamed from: k */
    public boolean m12039k() {
        return this.f12901c != null;
    }

    /* renamed from: l */
    public void m12040l() throws C3366bw {
        if (this.f12899a == null) {
            throw new C3387cq("Required field 'property' was not present! Struct: " + toString());
        }
        if (this.f12901c != null) {
            return;
        }
        throw new C3387cq("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void read(AbstractC3386cp abstractC3386cp) throws C3366bw {
        f12897j.get(abstractC3386cp.mo11179D()).mo10977b().mo10975b(abstractC3386cp, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        Map<String, C3527e> map = this.f12899a;
        if (map == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f12900b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.f12901c;
        if (str == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void write(AbstractC3386cp abstractC3386cp) throws C3366bw {
        f12897j.get(abstractC3386cp.mo11179D()).mo10977b().mo10973a(abstractC3386cp, this);
    }

    /* compiled from: Imprint.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.d$e */
    public enum e implements InterfaceC3367bx {
        PROPERTY(1, "property"),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");


        /* renamed from: d */
        private static final Map<String, e> f12906d = new HashMap();

        /* renamed from: e */
        private final short f12908e;

        /* renamed from: f */
        private final String f12909f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f12906d.put(eVar.mo10985b(), eVar);
            }
        }

        e(short s, String str) {
            this.f12908e = s;
            this.f12909f = str;
        }

        /* renamed from: a */
        public static e m12047a(int i2) {
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

        /* renamed from: b */
        public static e m12049b(int i2) {
            e m12047a = m12047a(i2);
            if (m12047a != null) {
                return m12047a;
            }
            throw new IllegalArgumentException("Field " + i2 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.InterfaceC3367bx
        /* renamed from: b */
        public String mo10985b() {
            return this.f12909f;
        }

        /* renamed from: a */
        public static e m12048a(String str) {
            return f12906d.get(str);
        }

        @Override // com.umeng.analytics.pro.InterfaceC3367bx
        /* renamed from: a */
        public short mo10984a() {
            return this.f12908e;
        }
    }

    /* renamed from: a */
    public void m12025a(String str, C3527e c3527e) {
        if (this.f12899a == null) {
            this.f12899a = new HashMap();
        }
        this.f12899a.put(str, c3527e);
    }

    /* renamed from: b */
    public void m12029b(boolean z) {
        this.f12902l = C3357bn.m11009a(this.f12902l, 0, z);
    }

    /* renamed from: c */
    public void m12031c(boolean z) {
        if (z) {
            return;
        }
        this.f12901c = null;
    }

    public C3526d(Map<String, C3527e> map, int i2, String str) {
        this();
        this.f12899a = map;
        this.f12900b = i2;
        m12029b(true);
        this.f12901c = str;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.m12047a(i2);
    }

    /* renamed from: a */
    public C3526d m12024a(Map<String, C3527e> map) {
        this.f12899a = map;
        return this;
    }

    /* renamed from: a */
    public void m12026a(boolean z) {
        if (z) {
            return;
        }
        this.f12899a = null;
    }

    /* renamed from: a */
    public C3526d m12022a(int i2) {
        this.f12900b = i2;
        m12029b(true);
        return this;
    }

    public C3526d(C3526d c3526d) {
        this.f12902l = (byte) 0;
        this.f12902l = c3526d.f12902l;
        if (c3526d.m12033e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, C3527e> entry : c3526d.f12899a.entrySet()) {
                hashMap.put(entry.getKey(), new C3527e(entry.getValue()));
            }
            this.f12899a = hashMap;
        }
        this.f12900b = c3526d.f12900b;
        if (c3526d.m12039k()) {
            this.f12901c = c3526d.f12901c;
        }
    }

    /* renamed from: a */
    public C3526d m12023a(String str) {
        this.f12901c = str;
        return this;
    }

    /* renamed from: a */
    private void m12016a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new C3380cj(new C3399db(objectOutputStream)));
        } catch (C3366bw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* renamed from: a */
    private void m12015a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f12902l = (byte) 0;
            read(new C3380cj(new C3399db(objectInputStream)));
        } catch (C3366bw e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
