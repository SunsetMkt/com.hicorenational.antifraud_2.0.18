package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.AbstractC3386cp;
import com.umeng.analytics.pro.AbstractC3396cz;
import com.umeng.analytics.pro.AbstractC3398da;
import com.umeng.analytics.pro.C3357bn;
import com.umeng.analytics.pro.C3366bw;
import com.umeng.analytics.pro.C3373cc;
import com.umeng.analytics.pro.C3374cd;
import com.umeng.analytics.pro.C3380cj;
import com.umeng.analytics.pro.C3381ck;
import com.umeng.analytics.pro.C3387cq;
import com.umeng.analytics.pro.C3389cs;
import com.umeng.analytics.pro.C3391cu;
import com.umeng.analytics.pro.C3392cv;
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

/* compiled from: IdSnapshot.java */
/* renamed from: com.umeng.commonsdk.statistics.proto.b */
/* loaded from: classes2.dex */
public class C3524b implements InterfaceC3360bq<C3524b, e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<e, C3373cc> f12853d;

    /* renamed from: e */
    private static final long f12854e = -6496538196005191531L;

    /* renamed from: f */
    private static final C3391cu f12855f = new C3391cu("IdSnapshot");

    /* renamed from: g */
    private static final C3381ck f12856g = new C3381ck("identity", (byte) 11, 1);

    /* renamed from: h */
    private static final C3381ck f12857h = new C3381ck("ts", (byte) 10, 2);

    /* renamed from: i */
    private static final C3381ck f12858i = new C3381ck("version", (byte) 8, 3);

    /* renamed from: j */
    private static final Map<Class<? extends InterfaceC3394cx>, InterfaceC3395cy> f12859j = new HashMap();

    /* renamed from: k */
    private static final int f12860k = 0;

    /* renamed from: l */
    private static final int f12861l = 1;

    /* renamed from: a */
    public String f12862a;

    /* renamed from: b */
    public long f12863b;

    /* renamed from: c */
    public int f12864c;

    /* renamed from: m */
    private byte f12865m;

    /* compiled from: IdSnapshot.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.b$a */
    private static class a extends AbstractC3396cz<C3524b> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo10975b(AbstractC3386cp abstractC3386cp, C3524b c3524b) throws C3366bw {
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
                        } else if (b2 == 8) {
                            c3524b.f12864c = abstractC3386cp.mo11150w();
                            c3524b.m11959c(true);
                        } else {
                            C3389cs.m11183a(abstractC3386cp, b2);
                        }
                    } else if (b2 == 10) {
                        c3524b.f12863b = abstractC3386cp.mo11151x();
                        c3524b.m11957b(true);
                    } else {
                        C3389cs.m11183a(abstractC3386cp, b2);
                    }
                } else if (b2 == 11) {
                    c3524b.f12862a = abstractC3386cp.mo11153z();
                    c3524b.m11954a(true);
                } else {
                    C3389cs.m11183a(abstractC3386cp, b2);
                }
                abstractC3386cp.mo11140m();
            }
            abstractC3386cp.mo11138k();
            if (!c3524b.m11963g()) {
                throw new C3387cq("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            if (c3524b.m11966j()) {
                c3524b.m11967k();
                return;
            }
            throw new C3387cq("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo10973a(AbstractC3386cp abstractC3386cp, C3524b c3524b) throws C3366bw {
            c3524b.m11967k();
            abstractC3386cp.mo11121a(C3524b.f12855f);
            if (c3524b.f12862a != null) {
                abstractC3386cp.mo11116a(C3524b.f12856g);
                abstractC3386cp.mo11122a(c3524b.f12862a);
                abstractC3386cp.mo11128c();
            }
            abstractC3386cp.mo11116a(C3524b.f12857h);
            abstractC3386cp.mo11115a(c3524b.f12863b);
            abstractC3386cp.mo11128c();
            abstractC3386cp.mo11116a(C3524b.f12858i);
            abstractC3386cp.mo11114a(c3524b.f12864c);
            abstractC3386cp.mo11128c();
            abstractC3386cp.mo11130d();
            abstractC3386cp.mo11127b();
        }
    }

    /* compiled from: IdSnapshot.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.b$b */
    private static class b implements InterfaceC3395cy {
        private b() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3395cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a mo10977b() {
            return new a();
        }
    }

    /* compiled from: IdSnapshot.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.b$c */
    private static class c extends AbstractC3398da<C3524b> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo10973a(AbstractC3386cp abstractC3386cp, C3524b c3524b) throws C3366bw {
            C3392cv c3392cv = (C3392cv) abstractC3386cp;
            c3392cv.mo11122a(c3524b.f12862a);
            c3392cv.mo11115a(c3524b.f12863b);
            c3392cv.mo11114a(c3524b.f12864c);
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo10975b(AbstractC3386cp abstractC3386cp, C3524b c3524b) throws C3366bw {
            C3392cv c3392cv = (C3392cv) abstractC3386cp;
            c3524b.f12862a = c3392cv.mo11153z();
            c3524b.m11954a(true);
            c3524b.f12863b = c3392cv.mo11151x();
            c3524b.m11957b(true);
            c3524b.f12864c = c3392cv.mo11150w();
            c3524b.m11959c(true);
        }
    }

    /* compiled from: IdSnapshot.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.b$d */
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
        f12859j.put(AbstractC3396cz.class, new b());
        f12859j.put(AbstractC3398da.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.IDENTITY, (e) new C3373cc("identity", (byte) 1, new C3374cd((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new C3373cc("ts", (byte) 1, new C3374cd((byte) 10)));
        enumMap.put((EnumMap) e.VERSION, (e) new C3373cc("version", (byte) 1, new C3374cd((byte) 8)));
        f12853d = Collections.unmodifiableMap(enumMap);
        C3373cc.m11103a(C3524b.class, f12853d);
    }

    public C3524b() {
        this.f12865m = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C3524b deepCopy() {
        return new C3524b(this);
    }

    /* renamed from: b */
    public String m11956b() {
        return this.f12862a;
    }

    /* renamed from: c */
    public void m11958c() {
        this.f12862a = null;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void clear() {
        this.f12862a = null;
        m11957b(false);
        this.f12863b = 0L;
        m11959c(false);
        this.f12864c = 0;
    }

    /* renamed from: d */
    public boolean m11960d() {
        return this.f12862a != null;
    }

    /* renamed from: e */
    public long m11961e() {
        return this.f12863b;
    }

    /* renamed from: f */
    public void m11962f() {
        this.f12865m = C3357bn.m11021b(this.f12865m, 0);
    }

    /* renamed from: g */
    public boolean m11963g() {
        return C3357bn.m11017a(this.f12865m, 0);
    }

    /* renamed from: h */
    public int m11964h() {
        return this.f12864c;
    }

    /* renamed from: i */
    public void m11965i() {
        this.f12865m = C3357bn.m11021b(this.f12865m, 1);
    }

    /* renamed from: j */
    public boolean m11966j() {
        return C3357bn.m11017a(this.f12865m, 1);
    }

    /* renamed from: k */
    public void m11967k() throws C3366bw {
        if (this.f12862a != null) {
            return;
        }
        throw new C3387cq("Required field 'identity' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void read(AbstractC3386cp abstractC3386cp) throws C3366bw {
        f12859j.get(abstractC3386cp.mo11179D()).mo10977b().mo10975b(abstractC3386cp, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        String str = this.f12862a;
        if (str == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f12863b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f12864c);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void write(AbstractC3386cp abstractC3386cp) throws C3366bw {
        f12859j.get(abstractC3386cp.mo11179D()).mo10977b().mo10973a(abstractC3386cp, this);
    }

    /* compiled from: IdSnapshot.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.b$e */
    public enum e implements InterfaceC3367bx {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, "version");


        /* renamed from: d */
        private static final Map<String, e> f12869d = new HashMap();

        /* renamed from: e */
        private final short f12871e;

        /* renamed from: f */
        private final String f12872f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f12869d.put(eVar.mo10985b(), eVar);
            }
        }

        e(short s, String str) {
            this.f12871e = s;
            this.f12872f = str;
        }

        /* renamed from: a */
        public static e m11974a(int i2) {
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

        /* renamed from: b */
        public static e m11976b(int i2) {
            e m11974a = m11974a(i2);
            if (m11974a != null) {
                return m11974a;
            }
            throw new IllegalArgumentException("Field " + i2 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.InterfaceC3367bx
        /* renamed from: b */
        public String mo10985b() {
            return this.f12872f;
        }

        /* renamed from: a */
        public static e m11975a(String str) {
            return f12869d.get(str);
        }

        @Override // com.umeng.analytics.pro.InterfaceC3367bx
        /* renamed from: a */
        public short mo10984a() {
            return this.f12871e;
        }
    }

    /* renamed from: a */
    public C3524b m11953a(String str) {
        this.f12862a = str;
        return this;
    }

    /* renamed from: b */
    public void m11957b(boolean z) {
        this.f12865m = C3357bn.m11009a(this.f12865m, 0, z);
    }

    /* renamed from: c */
    public void m11959c(boolean z) {
        this.f12865m = C3357bn.m11009a(this.f12865m, 1, z);
    }

    public C3524b(String str, long j2, int i2) {
        this();
        this.f12862a = str;
        this.f12863b = j2;
        m11957b(true);
        this.f12864c = i2;
        m11959c(true);
    }

    /* renamed from: a */
    public void m11954a(boolean z) {
        if (z) {
            return;
        }
        this.f12862a = null;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.m11974a(i2);
    }

    /* renamed from: a */
    public C3524b m11952a(long j2) {
        this.f12863b = j2;
        m11957b(true);
        return this;
    }

    /* renamed from: a */
    public C3524b m11951a(int i2) {
        this.f12864c = i2;
        m11959c(true);
        return this;
    }

    /* renamed from: a */
    private void m11945a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new C3380cj(new C3399db(objectOutputStream)));
        } catch (C3366bw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public C3524b(C3524b c3524b) {
        this.f12865m = (byte) 0;
        this.f12865m = c3524b.f12865m;
        if (c3524b.m11960d()) {
            this.f12862a = c3524b.f12862a;
        }
        this.f12863b = c3524b.f12863b;
        this.f12864c = c3524b.f12864c;
    }

    /* renamed from: a */
    private void m11944a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f12865m = (byte) 0;
            read(new C3380cj(new C3399db(objectInputStream)));
        } catch (C3366bw e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
