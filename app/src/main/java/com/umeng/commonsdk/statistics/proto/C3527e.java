package com.umeng.commonsdk.statistics.proto;

import bean.SurveyH5Bean;
import com.umeng.analytics.pro.AbstractC3386cp;
import com.umeng.analytics.pro.AbstractC3396cz;
import com.umeng.analytics.pro.AbstractC3398da;
import com.umeng.analytics.pro.C3357bn;
import com.umeng.analytics.pro.C3366bw;
import com.umeng.analytics.pro.C3373cc;
import com.umeng.analytics.pro.C3374cd;
import com.umeng.analytics.pro.C3380cj;
import com.umeng.analytics.pro.C3381ck;
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

/* compiled from: ImprintValue.java */
/* renamed from: com.umeng.commonsdk.statistics.proto.e */
/* loaded from: classes2.dex */
public class C3527e implements InterfaceC3360bq<C3527e, e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<e, C3373cc> f12910d;

    /* renamed from: e */
    private static final long f12911e = 7501688097813630241L;

    /* renamed from: f */
    private static final C3391cu f12912f = new C3391cu("ImprintValue");

    /* renamed from: g */
    private static final C3381ck f12913g = new C3381ck(SurveyH5Bean.VALUE, (byte) 11, 1);

    /* renamed from: h */
    private static final C3381ck f12914h = new C3381ck("ts", (byte) 10, 2);

    /* renamed from: i */
    private static final C3381ck f12915i = new C3381ck("guid", (byte) 11, 3);

    /* renamed from: j */
    private static final Map<Class<? extends InterfaceC3394cx>, InterfaceC3395cy> f12916j = new HashMap();

    /* renamed from: k */
    private static final int f12917k = 0;

    /* renamed from: a */
    public String f12918a;

    /* renamed from: b */
    public long f12919b;

    /* renamed from: c */
    public String f12920c;

    /* renamed from: l */
    private byte f12921l;

    /* renamed from: m */
    private e[] f12922m;

    /* compiled from: ImprintValue.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.e$a */
    private static class a extends AbstractC3396cz<C3527e> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo10975b(AbstractC3386cp abstractC3386cp, C3527e c3527e) throws C3366bw {
            abstractC3386cp.mo11137j();
            while (true) {
                C3381ck mo11139l = abstractC3386cp.mo11139l();
                byte b2 = mo11139l.f11834b;
                if (b2 == 0) {
                    abstractC3386cp.mo11138k();
                    c3527e.m12073k();
                    return;
                }
                short s = mo11139l.f11835c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            C3389cs.m11183a(abstractC3386cp, b2);
                        } else if (b2 == 11) {
                            c3527e.f12920c = abstractC3386cp.mo11153z();
                            c3527e.m12065c(true);
                        } else {
                            C3389cs.m11183a(abstractC3386cp, b2);
                        }
                    } else if (b2 == 10) {
                        c3527e.f12919b = abstractC3386cp.mo11151x();
                        c3527e.m12063b(true);
                    } else {
                        C3389cs.m11183a(abstractC3386cp, b2);
                    }
                } else if (b2 == 11) {
                    c3527e.f12918a = abstractC3386cp.mo11153z();
                    c3527e.m12060a(true);
                } else {
                    C3389cs.m11183a(abstractC3386cp, b2);
                }
                abstractC3386cp.mo11140m();
            }
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo10973a(AbstractC3386cp abstractC3386cp, C3527e c3527e) throws C3366bw {
            c3527e.m12073k();
            abstractC3386cp.mo11121a(C3527e.f12912f);
            if (c3527e.f12918a != null && c3527e.m12066d()) {
                abstractC3386cp.mo11116a(C3527e.f12913g);
                abstractC3386cp.mo11122a(c3527e.f12918a);
                abstractC3386cp.mo11128c();
            }
            if (c3527e.m12069g()) {
                abstractC3386cp.mo11116a(C3527e.f12914h);
                abstractC3386cp.mo11115a(c3527e.f12919b);
                abstractC3386cp.mo11128c();
            }
            if (c3527e.f12920c != null && c3527e.m12072j()) {
                abstractC3386cp.mo11116a(C3527e.f12915i);
                abstractC3386cp.mo11122a(c3527e.f12920c);
                abstractC3386cp.mo11128c();
            }
            abstractC3386cp.mo11130d();
            abstractC3386cp.mo11127b();
        }
    }

    /* compiled from: ImprintValue.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.e$b */
    private static class b implements InterfaceC3395cy {
        private b() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3395cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a mo10977b() {
            return new a();
        }
    }

    /* compiled from: ImprintValue.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.e$c */
    private static class c extends AbstractC3398da<C3527e> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo10973a(AbstractC3386cp abstractC3386cp, C3527e c3527e) throws C3366bw {
            C3392cv c3392cv = (C3392cv) abstractC3386cp;
            BitSet bitSet = new BitSet();
            if (c3527e.m12066d()) {
                bitSet.set(0);
            }
            if (c3527e.m12069g()) {
                bitSet.set(1);
            }
            if (c3527e.m12072j()) {
                bitSet.set(2);
            }
            c3392cv.m11187a(bitSet, 3);
            if (c3527e.m12066d()) {
                c3392cv.mo11122a(c3527e.f12918a);
            }
            if (c3527e.m12069g()) {
                c3392cv.mo11115a(c3527e.f12919b);
            }
            if (c3527e.m12072j()) {
                c3392cv.mo11122a(c3527e.f12920c);
            }
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo10975b(AbstractC3386cp abstractC3386cp, C3527e c3527e) throws C3366bw {
            C3392cv c3392cv = (C3392cv) abstractC3386cp;
            BitSet m11188b = c3392cv.m11188b(3);
            if (m11188b.get(0)) {
                c3527e.f12918a = c3392cv.mo11153z();
                c3527e.m12060a(true);
            }
            if (m11188b.get(1)) {
                c3527e.f12919b = c3392cv.mo11151x();
                c3527e.m12063b(true);
            }
            if (m11188b.get(2)) {
                c3527e.f12920c = c3392cv.mo11153z();
                c3527e.m12065c(true);
            }
        }
    }

    /* compiled from: ImprintValue.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.e$d */
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
        f12916j.put(AbstractC3396cz.class, new b());
        f12916j.put(AbstractC3398da.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.VALUE, (e) new C3373cc(SurveyH5Bean.VALUE, (byte) 2, new C3374cd((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new C3373cc("ts", (byte) 2, new C3374cd((byte) 10)));
        enumMap.put((EnumMap) e.GUID, (e) new C3373cc("guid", (byte) 2, new C3374cd((byte) 11)));
        f12910d = Collections.unmodifiableMap(enumMap);
        C3373cc.m11103a(C3527e.class, f12910d);
    }

    public C3527e() {
        this.f12921l = (byte) 0;
        this.f12922m = new e[]{e.VALUE, e.TS, e.GUID};
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C3527e deepCopy() {
        return new C3527e(this);
    }

    /* renamed from: b */
    public String m12062b() {
        return this.f12918a;
    }

    /* renamed from: c */
    public void m12064c() {
        this.f12918a = null;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void clear() {
        this.f12918a = null;
        m12063b(false);
        this.f12919b = 0L;
        this.f12920c = null;
    }

    /* renamed from: d */
    public boolean m12066d() {
        return this.f12918a != null;
    }

    /* renamed from: e */
    public long m12067e() {
        return this.f12919b;
    }

    /* renamed from: f */
    public void m12068f() {
        this.f12921l = C3357bn.m11021b(this.f12921l, 0);
    }

    /* renamed from: g */
    public boolean m12069g() {
        return C3357bn.m11017a(this.f12921l, 0);
    }

    /* renamed from: h */
    public String m12070h() {
        return this.f12920c;
    }

    /* renamed from: i */
    public void m12071i() {
        this.f12920c = null;
    }

    /* renamed from: j */
    public boolean m12072j() {
        return this.f12920c != null;
    }

    /* renamed from: k */
    public void m12073k() throws C3366bw {
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void read(AbstractC3386cp abstractC3386cp) throws C3366bw {
        f12916j.get(abstractC3386cp.mo11179D()).mo10977b().mo10975b(abstractC3386cp, this);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (m12066d()) {
            sb.append("value:");
            String str = this.f12918a;
            if (str == null) {
                sb.append(AbstractC1191a.f2571h);
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
        sb.append(this.f12919b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.f12920c;
        if (str2 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void write(AbstractC3386cp abstractC3386cp) throws C3366bw {
        f12916j.get(abstractC3386cp.mo11179D()).mo10977b().mo10973a(abstractC3386cp, this);
    }

    /* compiled from: ImprintValue.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.e$e */
    public enum e implements InterfaceC3367bx {
        VALUE(1, SurveyH5Bean.VALUE),
        TS(2, "ts"),
        GUID(3, "guid");


        /* renamed from: d */
        private static final Map<String, e> f12926d = new HashMap();

        /* renamed from: e */
        private final short f12928e;

        /* renamed from: f */
        private final String f12929f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f12926d.put(eVar.mo10985b(), eVar);
            }
        }

        e(short s, String str) {
            this.f12928e = s;
            this.f12929f = str;
        }

        /* renamed from: a */
        public static e m12080a(int i2) {
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

        /* renamed from: b */
        public static e m12082b(int i2) {
            e m12080a = m12080a(i2);
            if (m12080a != null) {
                return m12080a;
            }
            throw new IllegalArgumentException("Field " + i2 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.InterfaceC3367bx
        /* renamed from: b */
        public String mo10985b() {
            return this.f12929f;
        }

        /* renamed from: a */
        public static e m12081a(String str) {
            return f12926d.get(str);
        }

        @Override // com.umeng.analytics.pro.InterfaceC3367bx
        /* renamed from: a */
        public short mo10984a() {
            return this.f12928e;
        }
    }

    /* renamed from: a */
    public C3527e m12059a(String str) {
        this.f12918a = str;
        return this;
    }

    /* renamed from: b */
    public void m12063b(boolean z) {
        this.f12921l = C3357bn.m11009a(this.f12921l, 0, z);
    }

    /* renamed from: c */
    public void m12065c(boolean z) {
        if (z) {
            return;
        }
        this.f12920c = null;
    }

    /* renamed from: a */
    public void m12060a(boolean z) {
        if (z) {
            return;
        }
        this.f12918a = null;
    }

    /* renamed from: b */
    public C3527e m12061b(String str) {
        this.f12920c = str;
        return this;
    }

    public C3527e(long j2, String str) {
        this();
        this.f12919b = j2;
        m12063b(true);
        this.f12920c = str;
    }

    /* renamed from: a */
    public C3527e m12058a(long j2) {
        this.f12919b = j2;
        m12063b(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.m12080a(i2);
    }

    /* renamed from: a */
    private void m12051a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new C3380cj(new C3399db(objectOutputStream)));
        } catch (C3366bw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public C3527e(C3527e c3527e) {
        this.f12921l = (byte) 0;
        this.f12922m = new e[]{e.VALUE, e.TS, e.GUID};
        this.f12921l = c3527e.f12921l;
        if (c3527e.m12066d()) {
            this.f12918a = c3527e.f12918a;
        }
        this.f12919b = c3527e.f12919b;
        if (c3527e.m12072j()) {
            this.f12920c = c3527e.f12920c;
        }
    }

    /* renamed from: a */
    private void m12050a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f12921l = (byte) 0;
            read(new C3380cj(new C3399db(objectInputStream)));
        } catch (C3366bw e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
