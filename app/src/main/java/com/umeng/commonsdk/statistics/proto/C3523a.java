package com.umeng.commonsdk.statistics.proto;

import anet.channel.strategy.dispatch.DispatchConstants;
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
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: IdJournal.java */
/* renamed from: com.umeng.commonsdk.statistics.proto.a */
/* loaded from: classes2.dex */
public class C3523a implements InterfaceC3360bq<C3523a, e>, Serializable, Cloneable {

    /* renamed from: e */
    public static final Map<e, C3373cc> f12830e;

    /* renamed from: f */
    private static final long f12831f = 9132678615281394583L;

    /* renamed from: g */
    private static final C3391cu f12832g = new C3391cu("IdJournal");

    /* renamed from: h */
    private static final C3381ck f12833h = new C3381ck(DispatchConstants.DOMAIN, (byte) 11, 1);

    /* renamed from: i */
    private static final C3381ck f12834i = new C3381ck("old_id", (byte) 11, 2);

    /* renamed from: j */
    private static final C3381ck f12835j = new C3381ck("new_id", (byte) 11, 3);

    /* renamed from: k */
    private static final C3381ck f12836k = new C3381ck("ts", (byte) 10, 4);

    /* renamed from: l */
    private static final Map<Class<? extends InterfaceC3394cx>, InterfaceC3395cy> f12837l = new HashMap();

    /* renamed from: m */
    private static final int f12838m = 0;

    /* renamed from: a */
    public String f12839a;

    /* renamed from: b */
    public String f12840b;

    /* renamed from: c */
    public String f12841c;

    /* renamed from: d */
    public long f12842d;

    /* renamed from: n */
    private byte f12843n;

    /* renamed from: o */
    private e[] f12844o;

    /* compiled from: IdJournal.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.a$a */
    private static class a extends AbstractC3396cz<C3523a> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo10975b(AbstractC3386cp abstractC3386cp, C3523a c3523a) throws C3366bw {
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
                            if (s != 4) {
                                C3389cs.m11183a(abstractC3386cp, b2);
                            } else if (b2 == 10) {
                                c3523a.f12842d = abstractC3386cp.mo11151x();
                                c3523a.m11923d(true);
                            } else {
                                C3389cs.m11183a(abstractC3386cp, b2);
                            }
                        } else if (b2 == 11) {
                            c3523a.f12841c = abstractC3386cp.mo11153z();
                            c3523a.m11922c(true);
                        } else {
                            C3389cs.m11183a(abstractC3386cp, b2);
                        }
                    } else if (b2 == 11) {
                        c3523a.f12840b = abstractC3386cp.mo11153z();
                        c3523a.m11919b(true);
                    } else {
                        C3389cs.m11183a(abstractC3386cp, b2);
                    }
                } else if (b2 == 11) {
                    c3523a.f12839a = abstractC3386cp.mo11153z();
                    c3523a.m11916a(true);
                } else {
                    C3389cs.m11183a(abstractC3386cp, b2);
                }
                abstractC3386cp.mo11140m();
            }
            abstractC3386cp.mo11138k();
            if (c3523a.m11933m()) {
                c3523a.m11934n();
                return;
            }
            throw new C3387cq("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo10973a(AbstractC3386cp abstractC3386cp, C3523a c3523a) throws C3366bw {
            c3523a.m11934n();
            abstractC3386cp.mo11121a(C3523a.f12832g);
            if (c3523a.f12839a != null) {
                abstractC3386cp.mo11116a(C3523a.f12833h);
                abstractC3386cp.mo11122a(c3523a.f12839a);
                abstractC3386cp.mo11128c();
            }
            if (c3523a.f12840b != null && c3523a.m11927g()) {
                abstractC3386cp.mo11116a(C3523a.f12834i);
                abstractC3386cp.mo11122a(c3523a.f12840b);
                abstractC3386cp.mo11128c();
            }
            if (c3523a.f12841c != null) {
                abstractC3386cp.mo11116a(C3523a.f12835j);
                abstractC3386cp.mo11122a(c3523a.f12841c);
                abstractC3386cp.mo11128c();
            }
            abstractC3386cp.mo11116a(C3523a.f12836k);
            abstractC3386cp.mo11115a(c3523a.f12842d);
            abstractC3386cp.mo11128c();
            abstractC3386cp.mo11130d();
            abstractC3386cp.mo11127b();
        }
    }

    /* compiled from: IdJournal.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.a$b */
    private static class b implements InterfaceC3395cy {
        private b() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3395cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a mo10977b() {
            return new a();
        }
    }

    /* compiled from: IdJournal.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.a$c */
    private static class c extends AbstractC3398da<C3523a> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo10973a(AbstractC3386cp abstractC3386cp, C3523a c3523a) throws C3366bw {
            C3392cv c3392cv = (C3392cv) abstractC3386cp;
            c3392cv.mo11122a(c3523a.f12839a);
            c3392cv.mo11122a(c3523a.f12841c);
            c3392cv.mo11115a(c3523a.f12842d);
            BitSet bitSet = new BitSet();
            if (c3523a.m11927g()) {
                bitSet.set(0);
            }
            c3392cv.m11187a(bitSet, 1);
            if (c3523a.m11927g()) {
                c3392cv.mo11122a(c3523a.f12840b);
            }
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo10975b(AbstractC3386cp abstractC3386cp, C3523a c3523a) throws C3366bw {
            C3392cv c3392cv = (C3392cv) abstractC3386cp;
            c3523a.f12839a = c3392cv.mo11153z();
            c3523a.m11916a(true);
            c3523a.f12841c = c3392cv.mo11153z();
            c3523a.m11922c(true);
            c3523a.f12842d = c3392cv.mo11151x();
            c3523a.m11923d(true);
            if (c3392cv.m11188b(1).get(0)) {
                c3523a.f12840b = c3392cv.mo11153z();
                c3523a.m11919b(true);
            }
        }
    }

    /* compiled from: IdJournal.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.a$d */
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
        f12837l.put(AbstractC3396cz.class, new b());
        f12837l.put(AbstractC3398da.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.DOMAIN, (e) new C3373cc(DispatchConstants.DOMAIN, (byte) 1, new C3374cd((byte) 11)));
        enumMap.put((EnumMap) e.OLD_ID, (e) new C3373cc("old_id", (byte) 2, new C3374cd((byte) 11)));
        enumMap.put((EnumMap) e.NEW_ID, (e) new C3373cc("new_id", (byte) 1, new C3374cd((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new C3373cc("ts", (byte) 1, new C3374cd((byte) 10)));
        f12830e = Collections.unmodifiableMap(enumMap);
        C3373cc.m11103a(C3523a.class, f12830e);
    }

    public C3523a() {
        this.f12843n = (byte) 0;
        this.f12844o = new e[]{e.OLD_ID};
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C3523a deepCopy() {
        return new C3523a(this);
    }

    /* renamed from: b */
    public String m11918b() {
        return this.f12839a;
    }

    /* renamed from: c */
    public void m11921c() {
        this.f12839a = null;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void clear() {
        this.f12839a = null;
        this.f12840b = null;
        this.f12841c = null;
        m11923d(false);
        this.f12842d = 0L;
    }

    /* renamed from: d */
    public boolean m11924d() {
        return this.f12839a != null;
    }

    /* renamed from: e */
    public String m11925e() {
        return this.f12840b;
    }

    /* renamed from: f */
    public void m11926f() {
        this.f12840b = null;
    }

    /* renamed from: g */
    public boolean m11927g() {
        return this.f12840b != null;
    }

    /* renamed from: h */
    public String m11928h() {
        return this.f12841c;
    }

    /* renamed from: i */
    public void m11929i() {
        this.f12841c = null;
    }

    /* renamed from: j */
    public boolean m11930j() {
        return this.f12841c != null;
    }

    /* renamed from: k */
    public long m11931k() {
        return this.f12842d;
    }

    /* renamed from: l */
    public void m11932l() {
        this.f12843n = C3357bn.m11021b(this.f12843n, 0);
    }

    /* renamed from: m */
    public boolean m11933m() {
        return C3357bn.m11017a(this.f12843n, 0);
    }

    /* renamed from: n */
    public void m11934n() throws C3366bw {
        if (this.f12839a == null) {
            throw new C3387cq("Required field 'domain' was not present! Struct: " + toString());
        }
        if (this.f12841c != null) {
            return;
        }
        throw new C3387cq("Required field 'new_id' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void read(AbstractC3386cp abstractC3386cp) throws C3366bw {
        f12837l.get(abstractC3386cp.mo11179D()).mo10977b().mo10975b(abstractC3386cp, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        String str = this.f12839a;
        if (str == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str);
        }
        if (m11927g()) {
            sb.append(", ");
            sb.append("old_id:");
            String str2 = this.f12840b;
            if (str2 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        String str3 = this.f12841c;
        if (str3 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f12842d);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void write(AbstractC3386cp abstractC3386cp) throws C3366bw {
        f12837l.get(abstractC3386cp.mo11179D()).mo10977b().mo10973a(abstractC3386cp, this);
    }

    /* compiled from: IdJournal.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.a$e */
    public enum e implements InterfaceC3367bx {
        DOMAIN(1, DispatchConstants.DOMAIN),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");


        /* renamed from: e */
        private static final Map<String, e> f12849e = new HashMap();

        /* renamed from: f */
        private final short f12851f;

        /* renamed from: g */
        private final String f12852g;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f12849e.put(eVar.mo10985b(), eVar);
            }
        }

        e(short s, String str) {
            this.f12851f = s;
            this.f12852g = str;
        }

        /* renamed from: a */
        public static e m11941a(int i2) {
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

        /* renamed from: b */
        public static e m11943b(int i2) {
            e m11941a = m11941a(i2);
            if (m11941a != null) {
                return m11941a;
            }
            throw new IllegalArgumentException("Field " + i2 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.InterfaceC3367bx
        /* renamed from: b */
        public String mo10985b() {
            return this.f12852g;
        }

        /* renamed from: a */
        public static e m11942a(String str) {
            return f12849e.get(str);
        }

        @Override // com.umeng.analytics.pro.InterfaceC3367bx
        /* renamed from: a */
        public short mo10984a() {
            return this.f12851f;
        }
    }

    /* renamed from: a */
    public C3523a m11915a(String str) {
        this.f12839a = str;
        return this;
    }

    /* renamed from: b */
    public C3523a m11917b(String str) {
        this.f12840b = str;
        return this;
    }

    /* renamed from: c */
    public C3523a m11920c(String str) {
        this.f12841c = str;
        return this;
    }

    /* renamed from: d */
    public void m11923d(boolean z) {
        this.f12843n = C3357bn.m11009a(this.f12843n, 0, z);
    }

    /* renamed from: a */
    public void m11916a(boolean z) {
        if (z) {
            return;
        }
        this.f12839a = null;
    }

    /* renamed from: b */
    public void m11919b(boolean z) {
        if (z) {
            return;
        }
        this.f12840b = null;
    }

    /* renamed from: c */
    public void m11922c(boolean z) {
        if (z) {
            return;
        }
        this.f12841c = null;
    }

    public C3523a(String str, String str2, long j2) {
        this();
        this.f12839a = str;
        this.f12841c = str2;
        this.f12842d = j2;
        m11923d(true);
    }

    /* renamed from: a */
    public C3523a m11914a(long j2) {
        this.f12842d = j2;
        m11923d(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.m11941a(i2);
    }

    /* renamed from: a */
    private void m11906a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new C3380cj(new C3399db(objectOutputStream)));
        } catch (C3366bw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public C3523a(C3523a c3523a) {
        this.f12843n = (byte) 0;
        this.f12844o = new e[]{e.OLD_ID};
        this.f12843n = c3523a.f12843n;
        if (c3523a.m11924d()) {
            this.f12839a = c3523a.f12839a;
        }
        if (c3523a.m11927g()) {
            this.f12840b = c3523a.f12840b;
        }
        if (c3523a.m11930j()) {
            this.f12841c = c3523a.f12841c;
        }
        this.f12842d = c3523a.f12842d;
    }

    /* renamed from: a */
    private void m11905a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f12843n = (byte) 0;
            read(new C3380cj(new C3399db(objectInputStream)));
        } catch (C3366bw e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
