package com.xiaomi.push;

import com.umeng.analytics.pro.C3393cw;
import com.xiaomi.push.service.C4358aj;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.gs */
/* loaded from: classes2.dex */
public class C4252gs implements InterfaceC4277hq<C4252gs, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public int f15838a;

    /* renamed from: a */
    public long f15839a;

    /* renamed from: a */
    public String f15840a;

    /* renamed from: a */
    private BitSet f15841a;

    /* renamed from: a */
    public Map<String, String> f15842a;

    /* renamed from: a */
    public boolean f15843a;

    /* renamed from: b */
    public int f15844b;

    /* renamed from: b */
    public String f15845b;

    /* renamed from: b */
    public Map<String, String> f15846b;

    /* renamed from: c */
    public int f15847c;

    /* renamed from: c */
    public String f15848c;

    /* renamed from: c */
    public Map<String, String> f15849c;

    /* renamed from: d */
    public String f15850d;

    /* renamed from: e */
    public String f15851e;

    /* renamed from: a */
    private static final C4293if f15825a = new C4293if("PushMetaInfo");

    /* renamed from: a */
    private static final C4284hx f15824a = new C4284hx("", (byte) 11, 1);

    /* renamed from: b */
    private static final C4284hx f15826b = new C4284hx("", (byte) 10, 2);

    /* renamed from: c */
    private static final C4284hx f15827c = new C4284hx("", (byte) 11, 3);

    /* renamed from: d */
    private static final C4284hx f15828d = new C4284hx("", (byte) 11, 4);

    /* renamed from: e */
    private static final C4284hx f15829e = new C4284hx("", (byte) 11, 5);

    /* renamed from: f */
    private static final C4284hx f15830f = new C4284hx("", (byte) 8, 6);

    /* renamed from: g */
    private static final C4284hx f15831g = new C4284hx("", (byte) 11, 7);

    /* renamed from: h */
    private static final C4284hx f15832h = new C4284hx("", (byte) 8, 8);

    /* renamed from: i */
    private static final C4284hx f15833i = new C4284hx("", (byte) 8, 9);

    /* renamed from: j */
    private static final C4284hx f15834j = new C4284hx("", C3393cw.f11871k, 10);

    /* renamed from: k */
    private static final C4284hx f15835k = new C4284hx("", C3393cw.f11871k, 11);

    /* renamed from: l */
    private static final C4284hx f15836l = new C4284hx("", (byte) 2, 12);

    /* renamed from: m */
    private static final C4284hx f15837m = new C4284hx("", C3393cw.f11871k, 13);

    public C4252gs() {
        this.f15841a = new BitSet(5);
        this.f15843a = false;
    }

    /* renamed from: a */
    public C4252gs m15092a() {
        return new C4252gs(this);
    }

    /* renamed from: b */
    public boolean m15110b() {
        return this.f15841a.get(0);
    }

    /* renamed from: c */
    public boolean m15116c() {
        return this.f15845b != null;
    }

    /* renamed from: d */
    public boolean m15120d() {
        return this.f15848c != null;
    }

    /* renamed from: e */
    public boolean m15122e() {
        return this.f15850d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4252gs)) {
            return m15102a((C4252gs) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m15123f() {
        return this.f15841a.get(1);
    }

    /* renamed from: g */
    public boolean m15124g() {
        return this.f15851e != null;
    }

    /* renamed from: h */
    public boolean m15125h() {
        return this.f15841a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m15126i() {
        return this.f15841a.get(3);
    }

    /* renamed from: j */
    public boolean m15127j() {
        return this.f15842a != null;
    }

    /* renamed from: k */
    public boolean m15128k() {
        return this.f15846b != null;
    }

    /* renamed from: l */
    public boolean m15129l() {
        return this.f15843a;
    }

    /* renamed from: m */
    public boolean m15130m() {
        return this.f15841a.get(4);
    }

    /* renamed from: n */
    public boolean m15131n() {
        return this.f15849c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        String str = this.f15840a;
        if (str == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(C4358aj.m15942a(str));
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f15839a);
        if (m15116c()) {
            sb.append(", ");
            sb.append("topic:");
            String str2 = this.f15845b;
            if (str2 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str2);
            }
        }
        if (m15120d()) {
            sb.append(", ");
            sb.append("title:");
            String str3 = this.f15848c;
            if (str3 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str3);
            }
        }
        if (m15122e()) {
            sb.append(", ");
            sb.append("description:");
            String str4 = this.f15850d;
            if (str4 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str4);
            }
        }
        if (m15123f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f15838a);
        }
        if (m15124g()) {
            sb.append(", ");
            sb.append("url:");
            String str5 = this.f15851e;
            if (str5 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str5);
            }
        }
        if (m15125h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f15844b);
        }
        if (m15126i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f15847c);
        }
        if (m15127j()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f15842a;
            if (map == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(map);
            }
        }
        if (m15128k()) {
            sb.append(", ");
            sb.append("internal:");
            Map<String, String> map2 = this.f15846b;
            if (map2 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(map2);
            }
        }
        if (m15130m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f15843a);
        }
        if (m15131n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.f15849c;
            if (map3 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(map3);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public String m15096a() {
        return this.f15840a;
    }

    /* renamed from: b */
    public String m15106b() {
        return this.f15845b;
    }

    /* renamed from: c */
    public String m15114c() {
        return this.f15848c;
    }

    /* renamed from: d */
    public String m15118d() {
        return this.f15850d;
    }

    /* renamed from: e */
    public void m15121e(boolean z) {
        this.f15841a.set(4, z);
    }

    /* renamed from: a */
    public C4252gs m15094a(String str) {
        this.f15840a = str;
        return this;
    }

    /* renamed from: b */
    public C4252gs m15105b(String str) {
        this.f15845b = str;
        return this;
    }

    /* renamed from: c */
    public C4252gs m15113c(String str) {
        this.f15848c = str;
        return this;
    }

    /* renamed from: d */
    public C4252gs m15117d(String str) {
        this.f15850d = str;
        return this;
    }

    public C4252gs(C4252gs c4252gs) {
        this.f15841a = new BitSet(5);
        this.f15841a.clear();
        this.f15841a.or(c4252gs.f15841a);
        if (c4252gs.m15101a()) {
            this.f15840a = c4252gs.f15840a;
        }
        this.f15839a = c4252gs.f15839a;
        if (c4252gs.m15116c()) {
            this.f15845b = c4252gs.f15845b;
        }
        if (c4252gs.m15120d()) {
            this.f15848c = c4252gs.f15848c;
        }
        if (c4252gs.m15122e()) {
            this.f15850d = c4252gs.f15850d;
        }
        this.f15838a = c4252gs.f15838a;
        if (c4252gs.m15124g()) {
            this.f15851e = c4252gs.f15851e;
        }
        this.f15844b = c4252gs.f15844b;
        this.f15847c = c4252gs.f15847c;
        if (c4252gs.m15127j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : c4252gs.f15842a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f15842a = hashMap;
        }
        if (c4252gs.m15128k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : c4252gs.f15846b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f15846b = hashMap2;
        }
        this.f15843a = c4252gs.f15843a;
        if (c4252gs.m15131n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : c4252gs.f15849c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f15849c = hashMap3;
        }
    }

    /* renamed from: a */
    public boolean m15101a() {
        return this.f15840a != null;
    }

    /* renamed from: b */
    public void m15109b(boolean z) {
        this.f15841a.set(1, z);
    }

    /* renamed from: c */
    public void m15115c(boolean z) {
        this.f15841a.set(2, z);
    }

    /* renamed from: d */
    public void m15119d(boolean z) {
        this.f15841a.set(3, z);
    }

    /* renamed from: a */
    public long m15091a() {
        return this.f15839a;
    }

    /* renamed from: b */
    public int m15103b() {
        return this.f15844b;
    }

    /* renamed from: c */
    public int m15111c() {
        return this.f15847c;
    }

    /* renamed from: a */
    public void m15100a(boolean z) {
        this.f15841a.set(0, z);
    }

    /* renamed from: b */
    public C4252gs m15104b(int i2) {
        this.f15844b = i2;
        m15115c(true);
        return this;
    }

    /* renamed from: c */
    public C4252gs m15112c(int i2) {
        this.f15847c = i2;
        m15119d(true);
        return this;
    }

    /* renamed from: a */
    public int m15089a() {
        return this.f15838a;
    }

    /* renamed from: a */
    public C4252gs m15093a(int i2) {
        this.f15838a = i2;
        m15109b(true);
        return this;
    }

    /* renamed from: b */
    public void m15108b(String str, String str2) {
        if (this.f15846b == null) {
            this.f15846b = new HashMap();
        }
        this.f15846b.put(str, str2);
    }

    /* renamed from: a */
    public void m15099a(String str, String str2) {
        if (this.f15842a == null) {
            this.f15842a = new HashMap();
        }
        this.f15842a.put(str, str2);
    }

    /* renamed from: b */
    public Map<String, String> m15107b() {
        return this.f15846b;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15098a();
        abstractC4288ia.mo15610a(f15825a);
        if (this.f15840a != null) {
            abstractC4288ia.mo15607a(f15824a);
            abstractC4288ia.mo15611a(this.f15840a);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15607a(f15826b);
        abstractC4288ia.mo15606a(this.f15839a);
        abstractC4288ia.mo15616b();
        if (this.f15845b != null && m15116c()) {
            abstractC4288ia.mo15607a(f15827c);
            abstractC4288ia.mo15611a(this.f15845b);
            abstractC4288ia.mo15616b();
        }
        if (this.f15848c != null && m15120d()) {
            abstractC4288ia.mo15607a(f15828d);
            abstractC4288ia.mo15611a(this.f15848c);
            abstractC4288ia.mo15616b();
        }
        if (this.f15850d != null && m15122e()) {
            abstractC4288ia.mo15607a(f15829e);
            abstractC4288ia.mo15611a(this.f15850d);
            abstractC4288ia.mo15616b();
        }
        if (m15123f()) {
            abstractC4288ia.mo15607a(f15830f);
            abstractC4288ia.mo15605a(this.f15838a);
            abstractC4288ia.mo15616b();
        }
        if (this.f15851e != null && m15124g()) {
            abstractC4288ia.mo15607a(f15831g);
            abstractC4288ia.mo15611a(this.f15851e);
            abstractC4288ia.mo15616b();
        }
        if (m15125h()) {
            abstractC4288ia.mo15607a(f15832h);
            abstractC4288ia.mo15605a(this.f15844b);
            abstractC4288ia.mo15616b();
        }
        if (m15126i()) {
            abstractC4288ia.mo15607a(f15833i);
            abstractC4288ia.mo15605a(this.f15847c);
            abstractC4288ia.mo15616b();
        }
        if (this.f15842a != null && m15127j()) {
            abstractC4288ia.mo15607a(f15834j);
            abstractC4288ia.mo15609a(new C4286hz((byte) 11, (byte) 11, this.f15842a.size()));
            for (Map.Entry<String, String> entry : this.f15842a.entrySet()) {
                abstractC4288ia.mo15611a(entry.getKey());
                abstractC4288ia.mo15611a(entry.getValue());
            }
            abstractC4288ia.mo15620d();
            abstractC4288ia.mo15616b();
        }
        if (this.f15846b != null && m15128k()) {
            abstractC4288ia.mo15607a(f15835k);
            abstractC4288ia.mo15609a(new C4286hz((byte) 11, (byte) 11, this.f15846b.size()));
            for (Map.Entry<String, String> entry2 : this.f15846b.entrySet()) {
                abstractC4288ia.mo15611a(entry2.getKey());
                abstractC4288ia.mo15611a(entry2.getValue());
            }
            abstractC4288ia.mo15620d();
            abstractC4288ia.mo15616b();
        }
        if (m15130m()) {
            abstractC4288ia.mo15607a(f15836l);
            abstractC4288ia.mo15614a(this.f15843a);
            abstractC4288ia.mo15616b();
        }
        if (this.f15849c != null && m15131n()) {
            abstractC4288ia.mo15607a(f15837m);
            abstractC4288ia.mo15609a(new C4286hz((byte) 11, (byte) 11, this.f15849c.size()));
            for (Map.Entry<String, String> entry3 : this.f15849c.entrySet()) {
                abstractC4288ia.mo15611a(entry3.getKey());
                abstractC4288ia.mo15611a(entry3.getValue());
            }
            abstractC4288ia.mo15620d();
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    /* renamed from: a */
    public Map<String, String> m15097a() {
        return this.f15842a;
    }

    /* renamed from: a */
    public C4252gs m15095a(Map<String, String> map) {
        this.f15842a = map;
        return this;
    }

    /* renamed from: a */
    public boolean m15102a(C4252gs c4252gs) {
        if (c4252gs == null) {
            return false;
        }
        boolean m15101a = m15101a();
        boolean m15101a2 = c4252gs.m15101a();
        if (((m15101a || m15101a2) && !(m15101a && m15101a2 && this.f15840a.equals(c4252gs.f15840a))) || this.f15839a != c4252gs.f15839a) {
            return false;
        }
        boolean m15116c = m15116c();
        boolean m15116c2 = c4252gs.m15116c();
        if ((m15116c || m15116c2) && !(m15116c && m15116c2 && this.f15845b.equals(c4252gs.f15845b))) {
            return false;
        }
        boolean m15120d = m15120d();
        boolean m15120d2 = c4252gs.m15120d();
        if ((m15120d || m15120d2) && !(m15120d && m15120d2 && this.f15848c.equals(c4252gs.f15848c))) {
            return false;
        }
        boolean m15122e = m15122e();
        boolean m15122e2 = c4252gs.m15122e();
        if ((m15122e || m15122e2) && !(m15122e && m15122e2 && this.f15850d.equals(c4252gs.f15850d))) {
            return false;
        }
        boolean m15123f = m15123f();
        boolean m15123f2 = c4252gs.m15123f();
        if ((m15123f || m15123f2) && !(m15123f && m15123f2 && this.f15838a == c4252gs.f15838a)) {
            return false;
        }
        boolean m15124g = m15124g();
        boolean m15124g2 = c4252gs.m15124g();
        if ((m15124g || m15124g2) && !(m15124g && m15124g2 && this.f15851e.equals(c4252gs.f15851e))) {
            return false;
        }
        boolean m15125h = m15125h();
        boolean m15125h2 = c4252gs.m15125h();
        if ((m15125h || m15125h2) && !(m15125h && m15125h2 && this.f15844b == c4252gs.f15844b)) {
            return false;
        }
        boolean m15126i = m15126i();
        boolean m15126i2 = c4252gs.m15126i();
        if ((m15126i || m15126i2) && !(m15126i && m15126i2 && this.f15847c == c4252gs.f15847c)) {
            return false;
        }
        boolean m15127j = m15127j();
        boolean m15127j2 = c4252gs.m15127j();
        if ((m15127j || m15127j2) && !(m15127j && m15127j2 && this.f15842a.equals(c4252gs.f15842a))) {
            return false;
        }
        boolean m15128k = m15128k();
        boolean m15128k2 = c4252gs.m15128k();
        if ((m15128k || m15128k2) && !(m15128k && m15128k2 && this.f15846b.equals(c4252gs.f15846b))) {
            return false;
        }
        boolean m15130m = m15130m();
        boolean m15130m2 = c4252gs.m15130m();
        if ((m15130m || m15130m2) && !(m15130m && m15130m2 && this.f15843a == c4252gs.f15843a)) {
            return false;
        }
        boolean m15131n = m15131n();
        boolean m15131n2 = c4252gs.m15131n();
        if (m15131n || m15131n2) {
            return m15131n && m15131n2 && this.f15849c.equals(c4252gs.f15849c);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4252gs c4252gs) {
        int m15575a;
        int m15578a;
        int m15575a2;
        int m15575a3;
        int m15569a;
        int m15569a2;
        int m15572a;
        int m15569a3;
        int m15572a2;
        int m15572a3;
        int m15572a4;
        int m15570a;
        int m15572a5;
        if (!C4252gs.class.equals(c4252gs.getClass())) {
            return C4252gs.class.getName().compareTo(c4252gs.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15101a()).compareTo(Boolean.valueOf(c4252gs.m15101a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15101a() && (m15572a5 = C4278hr.m15572a(this.f15840a, c4252gs.f15840a)) != 0) {
            return m15572a5;
        }
        int compareTo2 = Boolean.valueOf(m15110b()).compareTo(Boolean.valueOf(c4252gs.m15110b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m15110b() && (m15570a = C4278hr.m15570a(this.f15839a, c4252gs.f15839a)) != 0) {
            return m15570a;
        }
        int compareTo3 = Boolean.valueOf(m15116c()).compareTo(Boolean.valueOf(c4252gs.m15116c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m15116c() && (m15572a4 = C4278hr.m15572a(this.f15845b, c4252gs.f15845b)) != 0) {
            return m15572a4;
        }
        int compareTo4 = Boolean.valueOf(m15120d()).compareTo(Boolean.valueOf(c4252gs.m15120d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m15120d() && (m15572a3 = C4278hr.m15572a(this.f15848c, c4252gs.f15848c)) != 0) {
            return m15572a3;
        }
        int compareTo5 = Boolean.valueOf(m15122e()).compareTo(Boolean.valueOf(c4252gs.m15122e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m15122e() && (m15572a2 = C4278hr.m15572a(this.f15850d, c4252gs.f15850d)) != 0) {
            return m15572a2;
        }
        int compareTo6 = Boolean.valueOf(m15123f()).compareTo(Boolean.valueOf(c4252gs.m15123f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m15123f() && (m15569a3 = C4278hr.m15569a(this.f15838a, c4252gs.f15838a)) != 0) {
            return m15569a3;
        }
        int compareTo7 = Boolean.valueOf(m15124g()).compareTo(Boolean.valueOf(c4252gs.m15124g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m15124g() && (m15572a = C4278hr.m15572a(this.f15851e, c4252gs.f15851e)) != 0) {
            return m15572a;
        }
        int compareTo8 = Boolean.valueOf(m15125h()).compareTo(Boolean.valueOf(c4252gs.m15125h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m15125h() && (m15569a2 = C4278hr.m15569a(this.f15844b, c4252gs.f15844b)) != 0) {
            return m15569a2;
        }
        int compareTo9 = Boolean.valueOf(m15126i()).compareTo(Boolean.valueOf(c4252gs.m15126i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m15126i() && (m15569a = C4278hr.m15569a(this.f15847c, c4252gs.f15847c)) != 0) {
            return m15569a;
        }
        int compareTo10 = Boolean.valueOf(m15127j()).compareTo(Boolean.valueOf(c4252gs.m15127j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m15127j() && (m15575a3 = C4278hr.m15575a(this.f15842a, c4252gs.f15842a)) != 0) {
            return m15575a3;
        }
        int compareTo11 = Boolean.valueOf(m15128k()).compareTo(Boolean.valueOf(c4252gs.m15128k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m15128k() && (m15575a2 = C4278hr.m15575a(this.f15846b, c4252gs.f15846b)) != 0) {
            return m15575a2;
        }
        int compareTo12 = Boolean.valueOf(m15130m()).compareTo(Boolean.valueOf(c4252gs.m15130m()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m15130m() && (m15578a = C4278hr.m15578a(this.f15843a, c4252gs.f15843a)) != 0) {
            return m15578a;
        }
        int compareTo13 = Boolean.valueOf(m15131n()).compareTo(Boolean.valueOf(c4252gs.m15131n()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (!m15131n() || (m15575a = C4278hr.m15575a(this.f15849c, c4252gs.f15849c)) == 0) {
            return 0;
        }
        return m15575a;
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
                if (m15110b()) {
                    m15098a();
                    return;
                }
                throw new C4289ib("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i2 = 0;
            switch (mo15594a.f16333a) {
                case 1:
                    if (b2 == 11) {
                        this.f15840a = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 2:
                    if (b2 == 10) {
                        this.f15839a = abstractC4288ia.mo15593a();
                        m15100a(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f15845b = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f15848c = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f15850d = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 6:
                    if (b2 == 8) {
                        this.f15838a = abstractC4288ia.mo15592a();
                        m15109b(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f15851e = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 8:
                    if (b2 == 8) {
                        this.f15844b = abstractC4288ia.mo15592a();
                        m15115c(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 9:
                    if (b2 == 8) {
                        this.f15847c = abstractC4288ia.mo15592a();
                        m15119d(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 10:
                    if (b2 == 13) {
                        C4286hz mo15596a = abstractC4288ia.mo15596a();
                        this.f15842a = new HashMap(mo15596a.f16337a * 2);
                        while (i2 < mo15596a.f16337a) {
                            this.f15842a.put(abstractC4288ia.mo15599a(), abstractC4288ia.mo15599a());
                            i2++;
                        }
                        abstractC4288ia.mo15624h();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 11:
                    if (b2 == 13) {
                        C4286hz mo15596a2 = abstractC4288ia.mo15596a();
                        this.f15846b = new HashMap(mo15596a2.f16337a * 2);
                        while (i2 < mo15596a2.f16337a) {
                            this.f15846b.put(abstractC4288ia.mo15599a(), abstractC4288ia.mo15599a());
                            i2++;
                        }
                        abstractC4288ia.mo15624h();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 12:
                    if (b2 == 2) {
                        this.f15843a = abstractC4288ia.mo15615a();
                        m15121e(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 13:
                    if (b2 == 13) {
                        C4286hz mo15596a3 = abstractC4288ia.mo15596a();
                        this.f15849c = new HashMap(mo15596a3.f16337a * 2);
                        while (i2 < mo15596a3.f16337a) {
                            this.f15849c.put(abstractC4288ia.mo15599a(), abstractC4288ia.mo15599a());
                            i2++;
                        }
                        abstractC4288ia.mo15624h();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                default:
                    C4291id.m15660a(abstractC4288ia, b2);
                    break;
            }
            abstractC4288ia.mo15623g();
        }
    }

    /* renamed from: a */
    public void m15098a() {
        if (this.f15840a != null) {
            return;
        }
        throw new C4289ib("Required field 'id' was not present! Struct: " + toString());
    }
}
