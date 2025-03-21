package com.xiaomi.push;

import com.umeng.analytics.pro.C3393cw;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.gv */
/* loaded from: classes2.dex */
public class C4255gv implements InterfaceC4277hq<C4255gv, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public int f15892a;

    /* renamed from: a */
    public long f15893a;

    /* renamed from: a */
    public C4254gu f15894a;

    /* renamed from: a */
    public C4269hi f15895a;

    /* renamed from: a */
    public String f15896a;

    /* renamed from: a */
    public Map<String, String> f15898a;

    /* renamed from: a */
    public short f15899a;

    /* renamed from: b */
    public String f15901b;

    /* renamed from: b */
    public short f15902b;

    /* renamed from: c */
    public String f15903c;

    /* renamed from: d */
    public String f15904d;

    /* renamed from: e */
    public String f15905e;

    /* renamed from: f */
    public String f15906f;

    /* renamed from: g */
    public String f15907g;

    /* renamed from: h */
    public String f15908h;

    /* renamed from: i */
    public String f15909i;

    /* renamed from: j */
    public String f15910j;

    /* renamed from: k */
    public String f15911k;

    /* renamed from: l */
    public String f15912l;

    /* renamed from: a */
    private static final C4293if f15872a = new C4293if("XmPushActionAckMessage");

    /* renamed from: a */
    private static final C4284hx f15871a = new C4284hx("", (byte) 11, 1);

    /* renamed from: b */
    private static final C4284hx f15873b = new C4284hx("", (byte) 12, 2);

    /* renamed from: c */
    private static final C4284hx f15874c = new C4284hx("", (byte) 11, 3);

    /* renamed from: d */
    private static final C4284hx f15875d = new C4284hx("", (byte) 11, 4);

    /* renamed from: e */
    private static final C4284hx f15876e = new C4284hx("", (byte) 10, 5);

    /* renamed from: f */
    private static final C4284hx f15877f = new C4284hx("", (byte) 11, 6);

    /* renamed from: g */
    private static final C4284hx f15878g = new C4284hx("", (byte) 11, 7);

    /* renamed from: h */
    private static final C4284hx f15879h = new C4284hx("", (byte) 12, 8);

    /* renamed from: i */
    private static final C4284hx f15880i = new C4284hx("", (byte) 11, 9);

    /* renamed from: j */
    private static final C4284hx f15881j = new C4284hx("", (byte) 11, 10);

    /* renamed from: k */
    private static final C4284hx f15882k = new C4284hx("", (byte) 2, 11);

    /* renamed from: l */
    private static final C4284hx f15883l = new C4284hx("", (byte) 11, 12);

    /* renamed from: m */
    private static final C4284hx f15884m = new C4284hx("", (byte) 11, 13);

    /* renamed from: n */
    private static final C4284hx f15885n = new C4284hx("", (byte) 11, 14);

    /* renamed from: o */
    private static final C4284hx f15886o = new C4284hx("", (byte) 6, 15);

    /* renamed from: p */
    private static final C4284hx f15887p = new C4284hx("", (byte) 6, 16);

    /* renamed from: q */
    private static final C4284hx f15888q = new C4284hx("", (byte) 11, 20);

    /* renamed from: r */
    private static final C4284hx f15889r = new C4284hx("", (byte) 11, 21);

    /* renamed from: s */
    private static final C4284hx f15890s = new C4284hx("", (byte) 8, 22);

    /* renamed from: t */
    private static final C4284hx f15891t = new C4284hx("", C3393cw.f11871k, 23);

    /* renamed from: a */
    private BitSet f15897a = new BitSet(5);

    /* renamed from: a */
    public boolean f15900a = false;

    /* renamed from: a */
    public boolean m15151a() {
        return this.f15896a != null;
    }

    /* renamed from: b */
    public boolean m15155b() {
        return this.f15894a != null;
    }

    /* renamed from: c */
    public boolean m15158c() {
        return this.f15901b != null;
    }

    /* renamed from: d */
    public boolean m15161d() {
        return this.f15903c != null;
    }

    /* renamed from: e */
    public boolean m15163e() {
        return this.f15897a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4255gv)) {
            return m15152a((C4255gv) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m15164f() {
        return this.f15904d != null;
    }

    /* renamed from: g */
    public boolean m15165g() {
        return this.f15905e != null;
    }

    /* renamed from: h */
    public boolean m15166h() {
        return this.f15895a != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m15167i() {
        return this.f15906f != null;
    }

    /* renamed from: j */
    public boolean m15168j() {
        return this.f15907g != null;
    }

    /* renamed from: k */
    public boolean m15169k() {
        return this.f15897a.get(1);
    }

    /* renamed from: l */
    public boolean m15170l() {
        return this.f15908h != null;
    }

    /* renamed from: m */
    public boolean m15171m() {
        return this.f15909i != null;
    }

    /* renamed from: n */
    public boolean m15172n() {
        return this.f15910j != null;
    }

    /* renamed from: o */
    public boolean m15173o() {
        return this.f15897a.get(2);
    }

    /* renamed from: p */
    public boolean m15174p() {
        return this.f15897a.get(3);
    }

    /* renamed from: q */
    public boolean m15175q() {
        return this.f15911k != null;
    }

    /* renamed from: r */
    public boolean m15176r() {
        return this.f15912l != null;
    }

    /* renamed from: s */
    public boolean m15177s() {
        return this.f15897a.get(4);
    }

    /* renamed from: t */
    public boolean m15178t() {
        return this.f15898a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        if (m15151a()) {
            sb.append("debug:");
            String str = this.f15896a;
            if (str == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m15155b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C4254gu c4254gu = this.f15894a;
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
        String str2 = this.f15901b;
        if (str2 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f15903c;
        if (str3 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f15893a);
        if (m15164f()) {
            sb.append(", ");
            sb.append("topic:");
            String str4 = this.f15904d;
            if (str4 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str4);
            }
        }
        if (m15165g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str5 = this.f15905e;
            if (str5 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str5);
            }
        }
        if (m15166h()) {
            sb.append(", ");
            sb.append("request:");
            C4269hi c4269hi = this.f15895a;
            if (c4269hi == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(c4269hi);
            }
        }
        if (m15167i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f15906f;
            if (str6 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str6);
            }
        }
        if (m15168j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f15907g;
            if (str7 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str7);
            }
        }
        if (m15169k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f15900a);
        }
        if (m15170l()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f15908h;
            if (str8 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str8);
            }
        }
        if (m15171m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            String str9 = this.f15909i;
            if (str9 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str9);
            }
        }
        if (m15172n()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f15910j;
            if (str10 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str10);
            }
        }
        if (m15173o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.f15899a);
        }
        if (m15174p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.f15902b);
        }
        if (m15175q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f15911k;
            if (str11 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str11);
            }
        }
        if (m15176r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f15912l;
            if (str12 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str12);
            }
        }
        if (m15177s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f15892a);
        }
        if (m15178t()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f15898a;
            if (map == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(map);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public C4255gv m15147a(String str) {
        this.f15901b = str;
        return this;
    }

    /* renamed from: b */
    public C4255gv m15153b(String str) {
        this.f15903c = str;
        return this;
    }

    /* renamed from: c */
    public C4255gv m15156c(String str) {
        this.f15904d = str;
        return this;
    }

    /* renamed from: d */
    public C4255gv m15159d(String str) {
        this.f15905e = str;
        return this;
    }

    /* renamed from: e */
    public void m15162e(boolean z) {
        this.f15897a.set(4, z);
    }

    /* renamed from: a */
    public C4255gv m15146a(long j2) {
        this.f15893a = j2;
        m15150a(true);
        return this;
    }

    /* renamed from: b */
    public void m15154b(boolean z) {
        this.f15897a.set(1, z);
    }

    /* renamed from: c */
    public void m15157c(boolean z) {
        this.f15897a.set(2, z);
    }

    /* renamed from: d */
    public void m15160d(boolean z) {
        this.f15897a.set(3, z);
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15149a();
        abstractC4288ia.mo15610a(f15872a);
        if (this.f15896a != null && m15151a()) {
            abstractC4288ia.mo15607a(f15871a);
            abstractC4288ia.mo15611a(this.f15896a);
            abstractC4288ia.mo15616b();
        }
        if (this.f15894a != null && m15155b()) {
            abstractC4288ia.mo15607a(f15873b);
            this.f15894a.mo14612b(abstractC4288ia);
            abstractC4288ia.mo15616b();
        }
        if (this.f15901b != null) {
            abstractC4288ia.mo15607a(f15874c);
            abstractC4288ia.mo15611a(this.f15901b);
            abstractC4288ia.mo15616b();
        }
        if (this.f15903c != null) {
            abstractC4288ia.mo15607a(f15875d);
            abstractC4288ia.mo15611a(this.f15903c);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15607a(f15876e);
        abstractC4288ia.mo15606a(this.f15893a);
        abstractC4288ia.mo15616b();
        if (this.f15904d != null && m15164f()) {
            abstractC4288ia.mo15607a(f15877f);
            abstractC4288ia.mo15611a(this.f15904d);
            abstractC4288ia.mo15616b();
        }
        if (this.f15905e != null && m15165g()) {
            abstractC4288ia.mo15607a(f15878g);
            abstractC4288ia.mo15611a(this.f15905e);
            abstractC4288ia.mo15616b();
        }
        if (this.f15895a != null && m15166h()) {
            abstractC4288ia.mo15607a(f15879h);
            this.f15895a.mo14612b(abstractC4288ia);
            abstractC4288ia.mo15616b();
        }
        if (this.f15906f != null && m15167i()) {
            abstractC4288ia.mo15607a(f15880i);
            abstractC4288ia.mo15611a(this.f15906f);
            abstractC4288ia.mo15616b();
        }
        if (this.f15907g != null && m15168j()) {
            abstractC4288ia.mo15607a(f15881j);
            abstractC4288ia.mo15611a(this.f15907g);
            abstractC4288ia.mo15616b();
        }
        if (m15169k()) {
            abstractC4288ia.mo15607a(f15882k);
            abstractC4288ia.mo15614a(this.f15900a);
            abstractC4288ia.mo15616b();
        }
        if (this.f15908h != null && m15170l()) {
            abstractC4288ia.mo15607a(f15883l);
            abstractC4288ia.mo15611a(this.f15908h);
            abstractC4288ia.mo15616b();
        }
        if (this.f15909i != null && m15171m()) {
            abstractC4288ia.mo15607a(f15884m);
            abstractC4288ia.mo15611a(this.f15909i);
            abstractC4288ia.mo15616b();
        }
        if (this.f15910j != null && m15172n()) {
            abstractC4288ia.mo15607a(f15885n);
            abstractC4288ia.mo15611a(this.f15910j);
            abstractC4288ia.mo15616b();
        }
        if (m15173o()) {
            abstractC4288ia.mo15607a(f15886o);
            abstractC4288ia.mo15613a(this.f15899a);
            abstractC4288ia.mo15616b();
        }
        if (m15174p()) {
            abstractC4288ia.mo15607a(f15887p);
            abstractC4288ia.mo15613a(this.f15902b);
            abstractC4288ia.mo15616b();
        }
        if (this.f15911k != null && m15175q()) {
            abstractC4288ia.mo15607a(f15888q);
            abstractC4288ia.mo15611a(this.f15911k);
            abstractC4288ia.mo15616b();
        }
        if (this.f15912l != null && m15176r()) {
            abstractC4288ia.mo15607a(f15889r);
            abstractC4288ia.mo15611a(this.f15912l);
            abstractC4288ia.mo15616b();
        }
        if (m15177s()) {
            abstractC4288ia.mo15607a(f15890s);
            abstractC4288ia.mo15605a(this.f15892a);
            abstractC4288ia.mo15616b();
        }
        if (this.f15898a != null && m15178t()) {
            abstractC4288ia.mo15607a(f15891t);
            abstractC4288ia.mo15609a(new C4286hz((byte) 11, (byte) 11, this.f15898a.size()));
            for (Map.Entry<String, String> entry : this.f15898a.entrySet()) {
                abstractC4288ia.mo15611a(entry.getKey());
                abstractC4288ia.mo15611a(entry.getValue());
            }
            abstractC4288ia.mo15620d();
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    /* renamed from: a */
    public void m15150a(boolean z) {
        this.f15897a.set(0, z);
    }

    /* renamed from: a */
    public C4255gv m15148a(short s) {
        this.f15899a = s;
        m15157c(true);
        return this;
    }

    /* renamed from: a */
    public boolean m15152a(C4255gv c4255gv) {
        if (c4255gv == null) {
            return false;
        }
        boolean m15151a = m15151a();
        boolean m15151a2 = c4255gv.m15151a();
        if ((m15151a || m15151a2) && !(m15151a && m15151a2 && this.f15896a.equals(c4255gv.f15896a))) {
            return false;
        }
        boolean m15155b = m15155b();
        boolean m15155b2 = c4255gv.m15155b();
        if ((m15155b || m15155b2) && !(m15155b && m15155b2 && this.f15894a.m15138a(c4255gv.f15894a))) {
            return false;
        }
        boolean m15158c = m15158c();
        boolean m15158c2 = c4255gv.m15158c();
        if ((m15158c || m15158c2) && !(m15158c && m15158c2 && this.f15901b.equals(c4255gv.f15901b))) {
            return false;
        }
        boolean m15161d = m15161d();
        boolean m15161d2 = c4255gv.m15161d();
        if (((m15161d || m15161d2) && !(m15161d && m15161d2 && this.f15903c.equals(c4255gv.f15903c))) || this.f15893a != c4255gv.f15893a) {
            return false;
        }
        boolean m15164f = m15164f();
        boolean m15164f2 = c4255gv.m15164f();
        if ((m15164f || m15164f2) && !(m15164f && m15164f2 && this.f15904d.equals(c4255gv.f15904d))) {
            return false;
        }
        boolean m15165g = m15165g();
        boolean m15165g2 = c4255gv.m15165g();
        if ((m15165g || m15165g2) && !(m15165g && m15165g2 && this.f15905e.equals(c4255gv.f15905e))) {
            return false;
        }
        boolean m15166h = m15166h();
        boolean m15166h2 = c4255gv.m15166h();
        if ((m15166h || m15166h2) && !(m15166h && m15166h2 && this.f15895a.m15443a(c4255gv.f15895a))) {
            return false;
        }
        boolean m15167i = m15167i();
        boolean m15167i2 = c4255gv.m15167i();
        if ((m15167i || m15167i2) && !(m15167i && m15167i2 && this.f15906f.equals(c4255gv.f15906f))) {
            return false;
        }
        boolean m15168j = m15168j();
        boolean m15168j2 = c4255gv.m15168j();
        if ((m15168j || m15168j2) && !(m15168j && m15168j2 && this.f15907g.equals(c4255gv.f15907g))) {
            return false;
        }
        boolean m15169k = m15169k();
        boolean m15169k2 = c4255gv.m15169k();
        if ((m15169k || m15169k2) && !(m15169k && m15169k2 && this.f15900a == c4255gv.f15900a)) {
            return false;
        }
        boolean m15170l = m15170l();
        boolean m15170l2 = c4255gv.m15170l();
        if ((m15170l || m15170l2) && !(m15170l && m15170l2 && this.f15908h.equals(c4255gv.f15908h))) {
            return false;
        }
        boolean m15171m = m15171m();
        boolean m15171m2 = c4255gv.m15171m();
        if ((m15171m || m15171m2) && !(m15171m && m15171m2 && this.f15909i.equals(c4255gv.f15909i))) {
            return false;
        }
        boolean m15172n = m15172n();
        boolean m15172n2 = c4255gv.m15172n();
        if ((m15172n || m15172n2) && !(m15172n && m15172n2 && this.f15910j.equals(c4255gv.f15910j))) {
            return false;
        }
        boolean m15173o = m15173o();
        boolean m15173o2 = c4255gv.m15173o();
        if ((m15173o || m15173o2) && !(m15173o && m15173o2 && this.f15899a == c4255gv.f15899a)) {
            return false;
        }
        boolean m15174p = m15174p();
        boolean m15174p2 = c4255gv.m15174p();
        if ((m15174p || m15174p2) && !(m15174p && m15174p2 && this.f15902b == c4255gv.f15902b)) {
            return false;
        }
        boolean m15175q = m15175q();
        boolean m15175q2 = c4255gv.m15175q();
        if ((m15175q || m15175q2) && !(m15175q && m15175q2 && this.f15911k.equals(c4255gv.f15911k))) {
            return false;
        }
        boolean m15176r = m15176r();
        boolean m15176r2 = c4255gv.m15176r();
        if ((m15176r || m15176r2) && !(m15176r && m15176r2 && this.f15912l.equals(c4255gv.f15912l))) {
            return false;
        }
        boolean m15177s = m15177s();
        boolean m15177s2 = c4255gv.m15177s();
        if ((m15177s || m15177s2) && !(m15177s && m15177s2 && this.f15892a == c4255gv.f15892a)) {
            return false;
        }
        boolean m15178t = m15178t();
        boolean m15178t2 = c4255gv.m15178t();
        if (m15178t || m15178t2) {
            return m15178t && m15178t2 && this.f15898a.equals(c4255gv.f15898a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4255gv c4255gv) {
        int m15575a;
        int m15569a;
        int m15572a;
        int m15572a2;
        int m15577a;
        int m15577a2;
        int m15572a3;
        int m15572a4;
        int m15572a5;
        int m15578a;
        int m15572a6;
        int m15572a7;
        int m15571a;
        int m15572a8;
        int m15572a9;
        int m15570a;
        int m15572a10;
        int m15572a11;
        int m15571a2;
        int m15572a12;
        if (!C4255gv.class.equals(c4255gv.getClass())) {
            return C4255gv.class.getName().compareTo(c4255gv.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15151a()).compareTo(Boolean.valueOf(c4255gv.m15151a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15151a() && (m15572a12 = C4278hr.m15572a(this.f15896a, c4255gv.f15896a)) != 0) {
            return m15572a12;
        }
        int compareTo2 = Boolean.valueOf(m15155b()).compareTo(Boolean.valueOf(c4255gv.m15155b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m15155b() && (m15571a2 = C4278hr.m15571a(this.f15894a, c4255gv.f15894a)) != 0) {
            return m15571a2;
        }
        int compareTo3 = Boolean.valueOf(m15158c()).compareTo(Boolean.valueOf(c4255gv.m15158c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m15158c() && (m15572a11 = C4278hr.m15572a(this.f15901b, c4255gv.f15901b)) != 0) {
            return m15572a11;
        }
        int compareTo4 = Boolean.valueOf(m15161d()).compareTo(Boolean.valueOf(c4255gv.m15161d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m15161d() && (m15572a10 = C4278hr.m15572a(this.f15903c, c4255gv.f15903c)) != 0) {
            return m15572a10;
        }
        int compareTo5 = Boolean.valueOf(m15163e()).compareTo(Boolean.valueOf(c4255gv.m15163e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m15163e() && (m15570a = C4278hr.m15570a(this.f15893a, c4255gv.f15893a)) != 0) {
            return m15570a;
        }
        int compareTo6 = Boolean.valueOf(m15164f()).compareTo(Boolean.valueOf(c4255gv.m15164f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m15164f() && (m15572a9 = C4278hr.m15572a(this.f15904d, c4255gv.f15904d)) != 0) {
            return m15572a9;
        }
        int compareTo7 = Boolean.valueOf(m15165g()).compareTo(Boolean.valueOf(c4255gv.m15165g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m15165g() && (m15572a8 = C4278hr.m15572a(this.f15905e, c4255gv.f15905e)) != 0) {
            return m15572a8;
        }
        int compareTo8 = Boolean.valueOf(m15166h()).compareTo(Boolean.valueOf(c4255gv.m15166h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m15166h() && (m15571a = C4278hr.m15571a(this.f15895a, c4255gv.f15895a)) != 0) {
            return m15571a;
        }
        int compareTo9 = Boolean.valueOf(m15167i()).compareTo(Boolean.valueOf(c4255gv.m15167i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m15167i() && (m15572a7 = C4278hr.m15572a(this.f15906f, c4255gv.f15906f)) != 0) {
            return m15572a7;
        }
        int compareTo10 = Boolean.valueOf(m15168j()).compareTo(Boolean.valueOf(c4255gv.m15168j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m15168j() && (m15572a6 = C4278hr.m15572a(this.f15907g, c4255gv.f15907g)) != 0) {
            return m15572a6;
        }
        int compareTo11 = Boolean.valueOf(m15169k()).compareTo(Boolean.valueOf(c4255gv.m15169k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m15169k() && (m15578a = C4278hr.m15578a(this.f15900a, c4255gv.f15900a)) != 0) {
            return m15578a;
        }
        int compareTo12 = Boolean.valueOf(m15170l()).compareTo(Boolean.valueOf(c4255gv.m15170l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m15170l() && (m15572a5 = C4278hr.m15572a(this.f15908h, c4255gv.f15908h)) != 0) {
            return m15572a5;
        }
        int compareTo13 = Boolean.valueOf(m15171m()).compareTo(Boolean.valueOf(c4255gv.m15171m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m15171m() && (m15572a4 = C4278hr.m15572a(this.f15909i, c4255gv.f15909i)) != 0) {
            return m15572a4;
        }
        int compareTo14 = Boolean.valueOf(m15172n()).compareTo(Boolean.valueOf(c4255gv.m15172n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (m15172n() && (m15572a3 = C4278hr.m15572a(this.f15910j, c4255gv.f15910j)) != 0) {
            return m15572a3;
        }
        int compareTo15 = Boolean.valueOf(m15173o()).compareTo(Boolean.valueOf(c4255gv.m15173o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (m15173o() && (m15577a2 = C4278hr.m15577a(this.f15899a, c4255gv.f15899a)) != 0) {
            return m15577a2;
        }
        int compareTo16 = Boolean.valueOf(m15174p()).compareTo(Boolean.valueOf(c4255gv.m15174p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (m15174p() && (m15577a = C4278hr.m15577a(this.f15902b, c4255gv.f15902b)) != 0) {
            return m15577a;
        }
        int compareTo17 = Boolean.valueOf(m15175q()).compareTo(Boolean.valueOf(c4255gv.m15175q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (m15175q() && (m15572a2 = C4278hr.m15572a(this.f15911k, c4255gv.f15911k)) != 0) {
            return m15572a2;
        }
        int compareTo18 = Boolean.valueOf(m15176r()).compareTo(Boolean.valueOf(c4255gv.m15176r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (m15176r() && (m15572a = C4278hr.m15572a(this.f15912l, c4255gv.f15912l)) != 0) {
            return m15572a;
        }
        int compareTo19 = Boolean.valueOf(m15177s()).compareTo(Boolean.valueOf(c4255gv.m15177s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (m15177s() && (m15569a = C4278hr.m15569a(this.f15892a, c4255gv.f15892a)) != 0) {
            return m15569a;
        }
        int compareTo20 = Boolean.valueOf(m15178t()).compareTo(Boolean.valueOf(c4255gv.m15178t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (!m15178t() || (m15575a = C4278hr.m15575a(this.f15898a, c4255gv.f15898a)) == 0) {
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
                if (m15163e()) {
                    m15149a();
                    return;
                }
                throw new C4289ib("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (mo15594a.f16333a) {
                case 1:
                    if (b2 == 11) {
                        this.f15896a = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f15894a = new C4254gu();
                        this.f15894a.mo14606a(abstractC4288ia);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f15901b = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f15903c = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 5:
                    if (b2 == 10) {
                        this.f15893a = abstractC4288ia.mo15593a();
                        m15150a(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f15904d = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f15905e = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 8:
                    if (b2 == 12) {
                        this.f15895a = new C4269hi();
                        this.f15895a.mo14606a(abstractC4288ia);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f15906f = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f15907g = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 11:
                    if (b2 == 2) {
                        this.f15900a = abstractC4288ia.mo15615a();
                        m15154b(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 12:
                    if (b2 == 11) {
                        this.f15908h = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 13:
                    if (b2 == 11) {
                        this.f15909i = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 14:
                    if (b2 == 11) {
                        this.f15910j = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 15:
                    if (b2 == 6) {
                        this.f15899a = abstractC4288ia.mo15602a();
                        m15157c(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 16:
                    if (b2 == 6) {
                        this.f15902b = abstractC4288ia.mo15602a();
                        m15160d(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    C4291id.m15660a(abstractC4288ia, b2);
                    break;
                case 20:
                    if (b2 == 11) {
                        this.f15911k = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 21:
                    if (b2 == 11) {
                        this.f15912l = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 22:
                    if (b2 == 8) {
                        this.f15892a = abstractC4288ia.mo15592a();
                        m15162e(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 23:
                    if (b2 == 13) {
                        C4286hz mo15596a = abstractC4288ia.mo15596a();
                        this.f15898a = new HashMap(mo15596a.f16337a * 2);
                        for (int i2 = 0; i2 < mo15596a.f16337a; i2++) {
                            this.f15898a.put(abstractC4288ia.mo15599a(), abstractC4288ia.mo15599a());
                        }
                        abstractC4288ia.mo15624h();
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
    public void m15149a() {
        if (this.f15901b != null) {
            if (this.f15903c != null) {
                return;
            }
            throw new C4289ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new C4289ib("Required field 'id' was not present! Struct: " + toString());
    }
}
