package com.xiaomi.push;

import com.umeng.analytics.pro.C3393cw;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.he */
/* loaded from: classes2.dex */
public class C4265he implements InterfaceC4277hq<C4265he, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public long f16029a;

    /* renamed from: a */
    public C4254gu f16030a;

    /* renamed from: a */
    public String f16031a;

    /* renamed from: a */
    public ByteBuffer f16032a;

    /* renamed from: a */
    private BitSet f16033a;

    /* renamed from: a */
    public Map<String, String> f16034a;

    /* renamed from: a */
    public boolean f16035a;

    /* renamed from: b */
    public String f16036b;

    /* renamed from: b */
    public boolean f16037b;

    /* renamed from: c */
    public String f16038c;

    /* renamed from: d */
    public String f16039d;

    /* renamed from: e */
    public String f16040e;

    /* renamed from: f */
    public String f16041f;

    /* renamed from: g */
    public String f16042g;

    /* renamed from: h */
    public String f16043h;

    /* renamed from: i */
    public String f16044i;

    /* renamed from: a */
    private static final C4293if f16014a = new C4293if("XmPushActionNotification");

    /* renamed from: a */
    private static final C4284hx f16013a = new C4284hx("", (byte) 11, 1);

    /* renamed from: b */
    private static final C4284hx f16015b = new C4284hx("", (byte) 12, 2);

    /* renamed from: c */
    private static final C4284hx f16016c = new C4284hx("", (byte) 11, 3);

    /* renamed from: d */
    private static final C4284hx f16017d = new C4284hx("", (byte) 11, 4);

    /* renamed from: e */
    private static final C4284hx f16018e = new C4284hx("", (byte) 11, 5);

    /* renamed from: f */
    private static final C4284hx f16019f = new C4284hx("", (byte) 2, 6);

    /* renamed from: g */
    private static final C4284hx f16020g = new C4284hx("", (byte) 11, 7);

    /* renamed from: h */
    private static final C4284hx f16021h = new C4284hx("", C3393cw.f11871k, 8);

    /* renamed from: i */
    private static final C4284hx f16022i = new C4284hx("", (byte) 11, 9);

    /* renamed from: j */
    private static final C4284hx f16023j = new C4284hx("", (byte) 11, 10);

    /* renamed from: k */
    private static final C4284hx f16024k = new C4284hx("", (byte) 11, 12);

    /* renamed from: l */
    private static final C4284hx f16025l = new C4284hx("", (byte) 11, 13);

    /* renamed from: m */
    private static final C4284hx f16026m = new C4284hx("", (byte) 11, 14);

    /* renamed from: n */
    private static final C4284hx f16027n = new C4284hx("", (byte) 10, 15);

    /* renamed from: o */
    private static final C4284hx f16028o = new C4284hx("", (byte) 2, 20);

    public C4265he() {
        this.f16033a = new BitSet(3);
        this.f16035a = true;
        this.f16037b = false;
    }

    /* renamed from: a */
    public boolean m15311a() {
        return this.f16031a != null;
    }

    /* renamed from: b */
    public boolean m15317b() {
        return this.f16030a != null;
    }

    /* renamed from: c */
    public boolean m15321c() {
        return this.f16036b != null;
    }

    /* renamed from: d */
    public boolean m15324d() {
        return this.f16038c != null;
    }

    /* renamed from: e */
    public boolean m15325e() {
        return this.f16039d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4265he)) {
            return m15312a((C4265he) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m15326f() {
        return this.f16033a.get(0);
    }

    /* renamed from: g */
    public boolean m15327g() {
        return this.f16040e != null;
    }

    /* renamed from: h */
    public boolean m15328h() {
        return this.f16034a != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m15329i() {
        return this.f16041f != null;
    }

    /* renamed from: j */
    public boolean m15330j() {
        return this.f16042g != null;
    }

    /* renamed from: k */
    public boolean m15331k() {
        return this.f16043h != null;
    }

    /* renamed from: l */
    public boolean m15332l() {
        return this.f16044i != null;
    }

    /* renamed from: m */
    public boolean m15333m() {
        return this.f16032a != null;
    }

    /* renamed from: n */
    public boolean m15334n() {
        return this.f16033a.get(1);
    }

    /* renamed from: o */
    public boolean m15335o() {
        return this.f16033a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        if (m15311a()) {
            sb.append("debug:");
            String str = this.f16031a;
            if (str == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m15317b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C4254gu c4254gu = this.f16030a;
            if (c4254gu == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(c4254gu);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f16036b;
        if (str2 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str2);
        }
        if (m15324d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f16038c;
            if (str3 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str3);
            }
        }
        if (m15325e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f16039d;
            if (str4 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str4);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f16035a);
        if (m15327g()) {
            sb.append(", ");
            sb.append("payload:");
            String str5 = this.f16040e;
            if (str5 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str5);
            }
        }
        if (m15328h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f16034a;
            if (map == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(map);
            }
        }
        if (m15329i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f16041f;
            if (str6 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str6);
            }
        }
        if (m15330j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f16042g;
            if (str7 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str7);
            }
        }
        if (m15331k()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f16043h;
            if (str8 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str8);
            }
        }
        if (m15332l()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f16044i;
            if (str9 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str9);
            }
        }
        if (m15333m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f16032a;
            if (byteBuffer == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                C4278hr.m15582a(byteBuffer, sb);
            }
        }
        if (m15334n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f16029a);
        }
        if (m15335o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f16037b);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public C4254gu m15300a() {
        return this.f16030a;
    }

    /* renamed from: b */
    public String m15315b() {
        return this.f16038c;
    }

    /* renamed from: c */
    public String m15319c() {
        return this.f16039d;
    }

    /* renamed from: d */
    public String m15323d() {
        return this.f16041f;
    }

    /* renamed from: a */
    public String m15306a() {
        return this.f16036b;
    }

    /* renamed from: b */
    public C4265he m15314b(String str) {
        this.f16038c = str;
        return this;
    }

    /* renamed from: c */
    public C4265he m15318c(String str) {
        this.f16039d = str;
        return this;
    }

    /* renamed from: d */
    public C4265he m15322d(String str) {
        this.f16041f = str;
        return this;
    }

    /* renamed from: a */
    public C4265he m15301a(String str) {
        this.f16036b = str;
        return this;
    }

    /* renamed from: b */
    public void m15316b(boolean z) {
        this.f16033a.set(1, z);
    }

    /* renamed from: c */
    public void m15320c(boolean z) {
        this.f16033a.set(2, z);
    }

    public C4265he(String str, boolean z) {
        this();
        this.f16036b = str;
        this.f16035a = z;
        m15310a(true);
    }

    /* renamed from: a */
    public C4265he m15304a(boolean z) {
        this.f16035a = z;
        m15310a(true);
        return this;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15308a();
        abstractC4288ia.mo15610a(f16014a);
        if (this.f16031a != null && m15311a()) {
            abstractC4288ia.mo15607a(f16013a);
            abstractC4288ia.mo15611a(this.f16031a);
            abstractC4288ia.mo15616b();
        }
        if (this.f16030a != null && m15317b()) {
            abstractC4288ia.mo15607a(f16015b);
            this.f16030a.mo14612b(abstractC4288ia);
            abstractC4288ia.mo15616b();
        }
        if (this.f16036b != null) {
            abstractC4288ia.mo15607a(f16016c);
            abstractC4288ia.mo15611a(this.f16036b);
            abstractC4288ia.mo15616b();
        }
        if (this.f16038c != null && m15324d()) {
            abstractC4288ia.mo15607a(f16017d);
            abstractC4288ia.mo15611a(this.f16038c);
            abstractC4288ia.mo15616b();
        }
        if (this.f16039d != null && m15325e()) {
            abstractC4288ia.mo15607a(f16018e);
            abstractC4288ia.mo15611a(this.f16039d);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15607a(f16019f);
        abstractC4288ia.mo15614a(this.f16035a);
        abstractC4288ia.mo15616b();
        if (this.f16040e != null && m15327g()) {
            abstractC4288ia.mo15607a(f16020g);
            abstractC4288ia.mo15611a(this.f16040e);
            abstractC4288ia.mo15616b();
        }
        if (this.f16034a != null && m15328h()) {
            abstractC4288ia.mo15607a(f16021h);
            abstractC4288ia.mo15609a(new C4286hz((byte) 11, (byte) 11, this.f16034a.size()));
            for (Map.Entry<String, String> entry : this.f16034a.entrySet()) {
                abstractC4288ia.mo15611a(entry.getKey());
                abstractC4288ia.mo15611a(entry.getValue());
            }
            abstractC4288ia.mo15620d();
            abstractC4288ia.mo15616b();
        }
        if (this.f16041f != null && m15329i()) {
            abstractC4288ia.mo15607a(f16022i);
            abstractC4288ia.mo15611a(this.f16041f);
            abstractC4288ia.mo15616b();
        }
        if (this.f16042g != null && m15330j()) {
            abstractC4288ia.mo15607a(f16023j);
            abstractC4288ia.mo15611a(this.f16042g);
            abstractC4288ia.mo15616b();
        }
        if (this.f16043h != null && m15331k()) {
            abstractC4288ia.mo15607a(f16024k);
            abstractC4288ia.mo15611a(this.f16043h);
            abstractC4288ia.mo15616b();
        }
        if (this.f16044i != null && m15332l()) {
            abstractC4288ia.mo15607a(f16025l);
            abstractC4288ia.mo15611a(this.f16044i);
            abstractC4288ia.mo15616b();
        }
        if (this.f16032a != null && m15333m()) {
            abstractC4288ia.mo15607a(f16026m);
            abstractC4288ia.mo15612a(this.f16032a);
            abstractC4288ia.mo15616b();
        }
        if (m15334n()) {
            abstractC4288ia.mo15607a(f16027n);
            abstractC4288ia.mo15606a(this.f16029a);
            abstractC4288ia.mo15616b();
        }
        if (m15335o()) {
            abstractC4288ia.mo15607a(f16028o);
            abstractC4288ia.mo15614a(this.f16037b);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    /* renamed from: a */
    public void m15310a(boolean z) {
        this.f16033a.set(0, z);
    }

    /* renamed from: a */
    public void m15309a(String str, String str2) {
        if (this.f16034a == null) {
            this.f16034a = new HashMap();
        }
        this.f16034a.put(str, str2);
    }

    /* renamed from: a */
    public Map<String, String> m15307a() {
        return this.f16034a;
    }

    /* renamed from: a */
    public C4265he m15303a(Map<String, String> map) {
        this.f16034a = map;
        return this;
    }

    /* renamed from: a */
    public byte[] m15313a() {
        m15302a(C4278hr.m15581a(this.f16032a));
        return this.f16032a.array();
    }

    /* renamed from: a */
    public C4265he m15305a(byte[] bArr) {
        m15302a(ByteBuffer.wrap(bArr));
        return this;
    }

    /* renamed from: a */
    public C4265he m15302a(ByteBuffer byteBuffer) {
        this.f16032a = byteBuffer;
        return this;
    }

    /* renamed from: a */
    public boolean m15312a(C4265he c4265he) {
        if (c4265he == null) {
            return false;
        }
        boolean m15311a = m15311a();
        boolean m15311a2 = c4265he.m15311a();
        if ((m15311a || m15311a2) && !(m15311a && m15311a2 && this.f16031a.equals(c4265he.f16031a))) {
            return false;
        }
        boolean m15317b = m15317b();
        boolean m15317b2 = c4265he.m15317b();
        if ((m15317b || m15317b2) && !(m15317b && m15317b2 && this.f16030a.m15138a(c4265he.f16030a))) {
            return false;
        }
        boolean m15321c = m15321c();
        boolean m15321c2 = c4265he.m15321c();
        if ((m15321c || m15321c2) && !(m15321c && m15321c2 && this.f16036b.equals(c4265he.f16036b))) {
            return false;
        }
        boolean m15324d = m15324d();
        boolean m15324d2 = c4265he.m15324d();
        if ((m15324d || m15324d2) && !(m15324d && m15324d2 && this.f16038c.equals(c4265he.f16038c))) {
            return false;
        }
        boolean m15325e = m15325e();
        boolean m15325e2 = c4265he.m15325e();
        if (((m15325e || m15325e2) && !(m15325e && m15325e2 && this.f16039d.equals(c4265he.f16039d))) || this.f16035a != c4265he.f16035a) {
            return false;
        }
        boolean m15327g = m15327g();
        boolean m15327g2 = c4265he.m15327g();
        if ((m15327g || m15327g2) && !(m15327g && m15327g2 && this.f16040e.equals(c4265he.f16040e))) {
            return false;
        }
        boolean m15328h = m15328h();
        boolean m15328h2 = c4265he.m15328h();
        if ((m15328h || m15328h2) && !(m15328h && m15328h2 && this.f16034a.equals(c4265he.f16034a))) {
            return false;
        }
        boolean m15329i = m15329i();
        boolean m15329i2 = c4265he.m15329i();
        if ((m15329i || m15329i2) && !(m15329i && m15329i2 && this.f16041f.equals(c4265he.f16041f))) {
            return false;
        }
        boolean m15330j = m15330j();
        boolean m15330j2 = c4265he.m15330j();
        if ((m15330j || m15330j2) && !(m15330j && m15330j2 && this.f16042g.equals(c4265he.f16042g))) {
            return false;
        }
        boolean m15331k = m15331k();
        boolean m15331k2 = c4265he.m15331k();
        if ((m15331k || m15331k2) && !(m15331k && m15331k2 && this.f16043h.equals(c4265he.f16043h))) {
            return false;
        }
        boolean m15332l = m15332l();
        boolean m15332l2 = c4265he.m15332l();
        if ((m15332l || m15332l2) && !(m15332l && m15332l2 && this.f16044i.equals(c4265he.f16044i))) {
            return false;
        }
        boolean m15333m = m15333m();
        boolean m15333m2 = c4265he.m15333m();
        if ((m15333m || m15333m2) && !(m15333m && m15333m2 && this.f16032a.equals(c4265he.f16032a))) {
            return false;
        }
        boolean m15334n = m15334n();
        boolean m15334n2 = c4265he.m15334n();
        if ((m15334n || m15334n2) && !(m15334n && m15334n2 && this.f16029a == c4265he.f16029a)) {
            return false;
        }
        boolean m15335o = m15335o();
        boolean m15335o2 = c4265he.m15335o();
        if (m15335o || m15335o2) {
            return m15335o && m15335o2 && this.f16037b == c4265he.f16037b;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4265he c4265he) {
        int m15578a;
        int m15570a;
        int m15571a;
        int m15572a;
        int m15572a2;
        int m15572a3;
        int m15572a4;
        int m15575a;
        int m15572a5;
        int m15578a2;
        int m15572a6;
        int m15572a7;
        int m15572a8;
        int m15571a2;
        int m15572a9;
        if (!C4265he.class.equals(c4265he.getClass())) {
            return C4265he.class.getName().compareTo(c4265he.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15311a()).compareTo(Boolean.valueOf(c4265he.m15311a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15311a() && (m15572a9 = C4278hr.m15572a(this.f16031a, c4265he.f16031a)) != 0) {
            return m15572a9;
        }
        int compareTo2 = Boolean.valueOf(m15317b()).compareTo(Boolean.valueOf(c4265he.m15317b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m15317b() && (m15571a2 = C4278hr.m15571a(this.f16030a, c4265he.f16030a)) != 0) {
            return m15571a2;
        }
        int compareTo3 = Boolean.valueOf(m15321c()).compareTo(Boolean.valueOf(c4265he.m15321c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m15321c() && (m15572a8 = C4278hr.m15572a(this.f16036b, c4265he.f16036b)) != 0) {
            return m15572a8;
        }
        int compareTo4 = Boolean.valueOf(m15324d()).compareTo(Boolean.valueOf(c4265he.m15324d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m15324d() && (m15572a7 = C4278hr.m15572a(this.f16038c, c4265he.f16038c)) != 0) {
            return m15572a7;
        }
        int compareTo5 = Boolean.valueOf(m15325e()).compareTo(Boolean.valueOf(c4265he.m15325e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m15325e() && (m15572a6 = C4278hr.m15572a(this.f16039d, c4265he.f16039d)) != 0) {
            return m15572a6;
        }
        int compareTo6 = Boolean.valueOf(m15326f()).compareTo(Boolean.valueOf(c4265he.m15326f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m15326f() && (m15578a2 = C4278hr.m15578a(this.f16035a, c4265he.f16035a)) != 0) {
            return m15578a2;
        }
        int compareTo7 = Boolean.valueOf(m15327g()).compareTo(Boolean.valueOf(c4265he.m15327g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m15327g() && (m15572a5 = C4278hr.m15572a(this.f16040e, c4265he.f16040e)) != 0) {
            return m15572a5;
        }
        int compareTo8 = Boolean.valueOf(m15328h()).compareTo(Boolean.valueOf(c4265he.m15328h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m15328h() && (m15575a = C4278hr.m15575a(this.f16034a, c4265he.f16034a)) != 0) {
            return m15575a;
        }
        int compareTo9 = Boolean.valueOf(m15329i()).compareTo(Boolean.valueOf(c4265he.m15329i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m15329i() && (m15572a4 = C4278hr.m15572a(this.f16041f, c4265he.f16041f)) != 0) {
            return m15572a4;
        }
        int compareTo10 = Boolean.valueOf(m15330j()).compareTo(Boolean.valueOf(c4265he.m15330j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m15330j() && (m15572a3 = C4278hr.m15572a(this.f16042g, c4265he.f16042g)) != 0) {
            return m15572a3;
        }
        int compareTo11 = Boolean.valueOf(m15331k()).compareTo(Boolean.valueOf(c4265he.m15331k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m15331k() && (m15572a2 = C4278hr.m15572a(this.f16043h, c4265he.f16043h)) != 0) {
            return m15572a2;
        }
        int compareTo12 = Boolean.valueOf(m15332l()).compareTo(Boolean.valueOf(c4265he.m15332l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m15332l() && (m15572a = C4278hr.m15572a(this.f16044i, c4265he.f16044i)) != 0) {
            return m15572a;
        }
        int compareTo13 = Boolean.valueOf(m15333m()).compareTo(Boolean.valueOf(c4265he.m15333m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m15333m() && (m15571a = C4278hr.m15571a(this.f16032a, c4265he.f16032a)) != 0) {
            return m15571a;
        }
        int compareTo14 = Boolean.valueOf(m15334n()).compareTo(Boolean.valueOf(c4265he.m15334n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (m15334n() && (m15570a = C4278hr.m15570a(this.f16029a, c4265he.f16029a)) != 0) {
            return m15570a;
        }
        int compareTo15 = Boolean.valueOf(m15335o()).compareTo(Boolean.valueOf(c4265he.m15335o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (!m15335o() || (m15578a = C4278hr.m15578a(this.f16037b, c4265he.f16037b)) == 0) {
            return 0;
        }
        return m15578a;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: a */
    public void mo14606a(AbstractC4288ia abstractC4288ia) {
        abstractC4288ia.mo15598a();
        while (true) {
            C4284hx mo15594a = abstractC4288ia.mo15594a();
            byte b2 = mo15594a.f16331a;
            if (b2 == 0) {
                abstractC4288ia.mo15622f();
                if (m15326f()) {
                    m15308a();
                    return;
                }
                throw new C4289ib("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (mo15594a.f16333a) {
                case 1:
                    if (b2 == 11) {
                        this.f16031a = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f16030a = new C4254gu();
                        this.f16030a.mo14606a(abstractC4288ia);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f16036b = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f16038c = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f16039d = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 6:
                    if (b2 == 2) {
                        this.f16035a = abstractC4288ia.mo15615a();
                        m15310a(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f16040e = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 8:
                    if (b2 == 13) {
                        C4286hz mo15596a = abstractC4288ia.mo15596a();
                        this.f16034a = new HashMap(mo15596a.f16337a * 2);
                        for (int i2 = 0; i2 < mo15596a.f16337a; i2++) {
                            this.f16034a.put(abstractC4288ia.mo15599a(), abstractC4288ia.mo15599a());
                        }
                        abstractC4288ia.mo15624h();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f16041f = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f16042g = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 11:
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    C4291id.m15660a(abstractC4288ia, b2);
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f16043h = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 13:
                    if (b2 == 11) {
                        this.f16044i = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 14:
                    if (b2 == 11) {
                        this.f16032a = abstractC4288ia.mo15601a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 15:
                    if (b2 == 10) {
                        this.f16029a = abstractC4288ia.mo15593a();
                        m15316b(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 20:
                    if (b2 == 2) {
                        this.f16037b = abstractC4288ia.mo15615a();
                        m15320c(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
            }
            abstractC4288ia.mo15623g();
        }
    }

    /* renamed from: a */
    public void m15308a() {
        if (this.f16036b != null) {
            return;
        }
        throw new C4289ib("Required field 'id' was not present! Struct: " + toString());
    }
}
