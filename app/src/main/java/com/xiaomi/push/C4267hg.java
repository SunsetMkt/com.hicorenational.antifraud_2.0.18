package com.xiaomi.push;

import com.umeng.analytics.pro.C3393cw;
import com.xiaomi.push.service.C4358aj;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.hg */
/* loaded from: classes2.dex */
public class C4267hg implements InterfaceC4277hq<C4267hg, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public int f16126a;

    /* renamed from: a */
    public long f16127a;

    /* renamed from: a */
    public C4254gu f16128a;

    /* renamed from: a */
    public String f16129a;

    /* renamed from: a */
    public List<String> f16131a;

    /* renamed from: b */
    public int f16133b;

    /* renamed from: b */
    public long f16134b;

    /* renamed from: b */
    public String f16135b;

    /* renamed from: c */
    public long f16136c;

    /* renamed from: c */
    public String f16137c;

    /* renamed from: d */
    public String f16138d;

    /* renamed from: e */
    public String f16139e;

    /* renamed from: f */
    public String f16140f;

    /* renamed from: g */
    public String f16141g;

    /* renamed from: h */
    public String f16142h;

    /* renamed from: i */
    public String f16143i;

    /* renamed from: j */
    public String f16144j;

    /* renamed from: k */
    public String f16145k;

    /* renamed from: l */
    public String f16146l;

    /* renamed from: a */
    private static final C4293if f16106a = new C4293if("XmPushActionRegistrationResult");

    /* renamed from: a */
    private static final C4284hx f16105a = new C4284hx("", (byte) 11, 1);

    /* renamed from: b */
    private static final C4284hx f16107b = new C4284hx("", (byte) 12, 2);

    /* renamed from: c */
    private static final C4284hx f16108c = new C4284hx("", (byte) 11, 3);

    /* renamed from: d */
    private static final C4284hx f16109d = new C4284hx("", (byte) 11, 4);

    /* renamed from: e */
    private static final C4284hx f16110e = new C4284hx("", (byte) 10, 6);

    /* renamed from: f */
    private static final C4284hx f16111f = new C4284hx("", (byte) 11, 7);

    /* renamed from: g */
    private static final C4284hx f16112g = new C4284hx("", (byte) 11, 8);

    /* renamed from: h */
    private static final C4284hx f16113h = new C4284hx("", (byte) 11, 9);

    /* renamed from: i */
    private static final C4284hx f16114i = new C4284hx("", (byte) 11, 10);

    /* renamed from: j */
    private static final C4284hx f16115j = new C4284hx("", (byte) 10, 11);

    /* renamed from: k */
    private static final C4284hx f16116k = new C4284hx("", (byte) 11, 12);

    /* renamed from: l */
    private static final C4284hx f16117l = new C4284hx("", (byte) 11, 13);

    /* renamed from: m */
    private static final C4284hx f16118m = new C4284hx("", (byte) 10, 14);

    /* renamed from: n */
    private static final C4284hx f16119n = new C4284hx("", (byte) 11, 15);

    /* renamed from: o */
    private static final C4284hx f16120o = new C4284hx("", (byte) 8, 16);

    /* renamed from: p */
    private static final C4284hx f16121p = new C4284hx("", (byte) 11, 17);

    /* renamed from: q */
    private static final C4284hx f16122q = new C4284hx("", (byte) 8, 18);

    /* renamed from: r */
    private static final C4284hx f16123r = new C4284hx("", (byte) 11, 19);

    /* renamed from: s */
    private static final C4284hx f16124s = new C4284hx("", (byte) 2, 20);

    /* renamed from: t */
    private static final C4284hx f16125t = new C4284hx("", C3393cw.f11873m, 21);

    /* renamed from: a */
    private BitSet f16130a = new BitSet(6);

    /* renamed from: a */
    public boolean f16132a = false;

    /* renamed from: a */
    public boolean m15398a() {
        return this.f16129a != null;
    }

    /* renamed from: b */
    public boolean m15402b() {
        return this.f16128a != null;
    }

    /* renamed from: c */
    public boolean m15405c() {
        return this.f16135b != null;
    }

    /* renamed from: d */
    public boolean m15407d() {
        return this.f16137c != null;
    }

    /* renamed from: e */
    public boolean m15409e() {
        return this.f16130a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4267hg)) {
            return m15399a((C4267hg) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m15411f() {
        return this.f16138d != null;
    }

    /* renamed from: g */
    public boolean m15412g() {
        return this.f16139e != null;
    }

    /* renamed from: h */
    public boolean m15413h() {
        return this.f16140f != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m15414i() {
        return this.f16141g != null;
    }

    /* renamed from: j */
    public boolean m15415j() {
        return this.f16130a.get(1);
    }

    /* renamed from: k */
    public boolean m15416k() {
        return this.f16142h != null;
    }

    /* renamed from: l */
    public boolean m15417l() {
        return this.f16143i != null;
    }

    /* renamed from: m */
    public boolean m15418m() {
        return this.f16130a.get(2);
    }

    /* renamed from: n */
    public boolean m15419n() {
        return this.f16144j != null;
    }

    /* renamed from: o */
    public boolean m15420o() {
        return this.f16130a.get(3);
    }

    /* renamed from: p */
    public boolean m15421p() {
        return this.f16145k != null;
    }

    /* renamed from: q */
    public boolean m15422q() {
        return this.f16130a.get(4);
    }

    /* renamed from: r */
    public boolean m15423r() {
        return this.f16146l != null;
    }

    /* renamed from: s */
    public boolean m15424s() {
        return this.f16130a.get(5);
    }

    /* renamed from: t */
    public boolean m15425t() {
        return this.f16131a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        if (m15398a()) {
            sb.append("debug:");
            String str = this.f16129a;
            if (str == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m15402b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C4254gu c4254gu = this.f16128a;
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
        String str2 = this.f16135b;
        if (str2 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(C4358aj.m15942a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f16137c;
        if (str3 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f16127a);
        if (m15411f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f16138d;
            if (str4 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str4);
            }
        }
        if (m15412g()) {
            sb.append(", ");
            sb.append("regId:");
            String str5 = this.f16139e;
            if (str5 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str5);
            }
        }
        if (m15414i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f16141g;
            if (str6 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str6);
            }
        }
        if (m15415j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f16134b);
        }
        if (m15416k()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str7 = this.f16142h;
            if (str7 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str7);
            }
        }
        if (m15417l()) {
            sb.append(", ");
            sb.append("clientId:");
            String str8 = this.f16143i;
            if (str8 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str8);
            }
        }
        if (m15418m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f16136c);
        }
        if (m15419n()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str9 = this.f16144j;
            if (str9 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str9);
            }
        }
        if (m15420o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f16126a);
        }
        if (m15421p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            String str10 = this.f16145k;
            if (str10 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str10);
            }
        }
        if (m15422q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f16133b);
        }
        if (m15423r()) {
            sb.append(", ");
            sb.append("region:");
            String str11 = this.f16146l;
            if (str11 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str11);
            }
        }
        if (m15424s()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f16132a);
        }
        if (m15425t()) {
            sb.append(", ");
            sb.append("autoMarkPkgs:");
            List<String> list = this.f16131a;
            if (list == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public String m15394a() {
        return this.f16135b;
    }

    /* renamed from: b */
    public String m15400b() {
        return this.f16140f;
    }

    /* renamed from: c */
    public String m15403c() {
        return this.f16141g;
    }

    /* renamed from: d */
    public void m15406d(boolean z) {
        this.f16130a.set(3, z);
    }

    /* renamed from: e */
    public void m15408e(boolean z) {
        this.f16130a.set(4, z);
    }

    /* renamed from: f */
    public void m15410f(boolean z) {
        this.f16130a.set(5, z);
    }

    /* renamed from: a */
    public long m15393a() {
        return this.f16127a;
    }

    /* renamed from: b */
    public void m15401b(boolean z) {
        this.f16130a.set(1, z);
    }

    /* renamed from: c */
    public void m15404c(boolean z) {
        this.f16130a.set(2, z);
    }

    /* renamed from: a */
    public void m15397a(boolean z) {
        this.f16130a.set(0, z);
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15396a();
        abstractC4288ia.mo15610a(f16106a);
        if (this.f16129a != null && m15398a()) {
            abstractC4288ia.mo15607a(f16105a);
            abstractC4288ia.mo15611a(this.f16129a);
            abstractC4288ia.mo15616b();
        }
        if (this.f16128a != null && m15402b()) {
            abstractC4288ia.mo15607a(f16107b);
            this.f16128a.mo14612b(abstractC4288ia);
            abstractC4288ia.mo15616b();
        }
        if (this.f16135b != null) {
            abstractC4288ia.mo15607a(f16108c);
            abstractC4288ia.mo15611a(this.f16135b);
            abstractC4288ia.mo15616b();
        }
        if (this.f16137c != null) {
            abstractC4288ia.mo15607a(f16109d);
            abstractC4288ia.mo15611a(this.f16137c);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15607a(f16110e);
        abstractC4288ia.mo15606a(this.f16127a);
        abstractC4288ia.mo15616b();
        if (this.f16138d != null && m15411f()) {
            abstractC4288ia.mo15607a(f16111f);
            abstractC4288ia.mo15611a(this.f16138d);
            abstractC4288ia.mo15616b();
        }
        if (this.f16139e != null && m15412g()) {
            abstractC4288ia.mo15607a(f16112g);
            abstractC4288ia.mo15611a(this.f16139e);
            abstractC4288ia.mo15616b();
        }
        if (this.f16140f != null && m15413h()) {
            abstractC4288ia.mo15607a(f16113h);
            abstractC4288ia.mo15611a(this.f16140f);
            abstractC4288ia.mo15616b();
        }
        if (this.f16141g != null && m15414i()) {
            abstractC4288ia.mo15607a(f16114i);
            abstractC4288ia.mo15611a(this.f16141g);
            abstractC4288ia.mo15616b();
        }
        if (m15415j()) {
            abstractC4288ia.mo15607a(f16115j);
            abstractC4288ia.mo15606a(this.f16134b);
            abstractC4288ia.mo15616b();
        }
        if (this.f16142h != null && m15416k()) {
            abstractC4288ia.mo15607a(f16116k);
            abstractC4288ia.mo15611a(this.f16142h);
            abstractC4288ia.mo15616b();
        }
        if (this.f16143i != null && m15417l()) {
            abstractC4288ia.mo15607a(f16117l);
            abstractC4288ia.mo15611a(this.f16143i);
            abstractC4288ia.mo15616b();
        }
        if (m15418m()) {
            abstractC4288ia.mo15607a(f16118m);
            abstractC4288ia.mo15606a(this.f16136c);
            abstractC4288ia.mo15616b();
        }
        if (this.f16144j != null && m15419n()) {
            abstractC4288ia.mo15607a(f16119n);
            abstractC4288ia.mo15611a(this.f16144j);
            abstractC4288ia.mo15616b();
        }
        if (m15420o()) {
            abstractC4288ia.mo15607a(f16120o);
            abstractC4288ia.mo15605a(this.f16126a);
            abstractC4288ia.mo15616b();
        }
        if (this.f16145k != null && m15421p()) {
            abstractC4288ia.mo15607a(f16121p);
            abstractC4288ia.mo15611a(this.f16145k);
            abstractC4288ia.mo15616b();
        }
        if (m15422q()) {
            abstractC4288ia.mo15607a(f16122q);
            abstractC4288ia.mo15605a(this.f16133b);
            abstractC4288ia.mo15616b();
        }
        if (this.f16146l != null && m15423r()) {
            abstractC4288ia.mo15607a(f16123r);
            abstractC4288ia.mo15611a(this.f16146l);
            abstractC4288ia.mo15616b();
        }
        if (m15424s()) {
            abstractC4288ia.mo15607a(f16124s);
            abstractC4288ia.mo15614a(this.f16132a);
            abstractC4288ia.mo15616b();
        }
        if (this.f16131a != null && m15425t()) {
            abstractC4288ia.mo15607a(f16125t);
            abstractC4288ia.mo15608a(new C4285hy((byte) 11, this.f16131a.size()));
            Iterator<String> it = this.f16131a.iterator();
            while (it.hasNext()) {
                abstractC4288ia.mo15611a(it.next());
            }
            abstractC4288ia.mo15621e();
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    /* renamed from: a */
    public List<String> m15395a() {
        return this.f16131a;
    }

    /* renamed from: a */
    public boolean m15399a(C4267hg c4267hg) {
        if (c4267hg == null) {
            return false;
        }
        boolean m15398a = m15398a();
        boolean m15398a2 = c4267hg.m15398a();
        if ((m15398a || m15398a2) && !(m15398a && m15398a2 && this.f16129a.equals(c4267hg.f16129a))) {
            return false;
        }
        boolean m15402b = m15402b();
        boolean m15402b2 = c4267hg.m15402b();
        if ((m15402b || m15402b2) && !(m15402b && m15402b2 && this.f16128a.m15138a(c4267hg.f16128a))) {
            return false;
        }
        boolean m15405c = m15405c();
        boolean m15405c2 = c4267hg.m15405c();
        if ((m15405c || m15405c2) && !(m15405c && m15405c2 && this.f16135b.equals(c4267hg.f16135b))) {
            return false;
        }
        boolean m15407d = m15407d();
        boolean m15407d2 = c4267hg.m15407d();
        if (((m15407d || m15407d2) && !(m15407d && m15407d2 && this.f16137c.equals(c4267hg.f16137c))) || this.f16127a != c4267hg.f16127a) {
            return false;
        }
        boolean m15411f = m15411f();
        boolean m15411f2 = c4267hg.m15411f();
        if ((m15411f || m15411f2) && !(m15411f && m15411f2 && this.f16138d.equals(c4267hg.f16138d))) {
            return false;
        }
        boolean m15412g = m15412g();
        boolean m15412g2 = c4267hg.m15412g();
        if ((m15412g || m15412g2) && !(m15412g && m15412g2 && this.f16139e.equals(c4267hg.f16139e))) {
            return false;
        }
        boolean m15413h = m15413h();
        boolean m15413h2 = c4267hg.m15413h();
        if ((m15413h || m15413h2) && !(m15413h && m15413h2 && this.f16140f.equals(c4267hg.f16140f))) {
            return false;
        }
        boolean m15414i = m15414i();
        boolean m15414i2 = c4267hg.m15414i();
        if ((m15414i || m15414i2) && !(m15414i && m15414i2 && this.f16141g.equals(c4267hg.f16141g))) {
            return false;
        }
        boolean m15415j = m15415j();
        boolean m15415j2 = c4267hg.m15415j();
        if ((m15415j || m15415j2) && !(m15415j && m15415j2 && this.f16134b == c4267hg.f16134b)) {
            return false;
        }
        boolean m15416k = m15416k();
        boolean m15416k2 = c4267hg.m15416k();
        if ((m15416k || m15416k2) && !(m15416k && m15416k2 && this.f16142h.equals(c4267hg.f16142h))) {
            return false;
        }
        boolean m15417l = m15417l();
        boolean m15417l2 = c4267hg.m15417l();
        if ((m15417l || m15417l2) && !(m15417l && m15417l2 && this.f16143i.equals(c4267hg.f16143i))) {
            return false;
        }
        boolean m15418m = m15418m();
        boolean m15418m2 = c4267hg.m15418m();
        if ((m15418m || m15418m2) && !(m15418m && m15418m2 && this.f16136c == c4267hg.f16136c)) {
            return false;
        }
        boolean m15419n = m15419n();
        boolean m15419n2 = c4267hg.m15419n();
        if ((m15419n || m15419n2) && !(m15419n && m15419n2 && this.f16144j.equals(c4267hg.f16144j))) {
            return false;
        }
        boolean m15420o = m15420o();
        boolean m15420o2 = c4267hg.m15420o();
        if ((m15420o || m15420o2) && !(m15420o && m15420o2 && this.f16126a == c4267hg.f16126a)) {
            return false;
        }
        boolean m15421p = m15421p();
        boolean m15421p2 = c4267hg.m15421p();
        if ((m15421p || m15421p2) && !(m15421p && m15421p2 && this.f16145k.equals(c4267hg.f16145k))) {
            return false;
        }
        boolean m15422q = m15422q();
        boolean m15422q2 = c4267hg.m15422q();
        if ((m15422q || m15422q2) && !(m15422q && m15422q2 && this.f16133b == c4267hg.f16133b)) {
            return false;
        }
        boolean m15423r = m15423r();
        boolean m15423r2 = c4267hg.m15423r();
        if ((m15423r || m15423r2) && !(m15423r && m15423r2 && this.f16146l.equals(c4267hg.f16146l))) {
            return false;
        }
        boolean m15424s = m15424s();
        boolean m15424s2 = c4267hg.m15424s();
        if ((m15424s || m15424s2) && !(m15424s && m15424s2 && this.f16132a == c4267hg.f16132a)) {
            return false;
        }
        boolean m15425t = m15425t();
        boolean m15425t2 = c4267hg.m15425t();
        if (m15425t || m15425t2) {
            return m15425t && m15425t2 && this.f16131a.equals(c4267hg.f16131a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4267hg c4267hg) {
        int m15574a;
        int m15578a;
        int m15572a;
        int m15569a;
        int m15572a2;
        int m15569a2;
        int m15572a3;
        int m15570a;
        int m15572a4;
        int m15572a5;
        int m15570a2;
        int m15572a6;
        int m15572a7;
        int m15572a8;
        int m15572a9;
        int m15570a3;
        int m15572a10;
        int m15572a11;
        int m15571a;
        int m15572a12;
        if (!C4267hg.class.equals(c4267hg.getClass())) {
            return C4267hg.class.getName().compareTo(c4267hg.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15398a()).compareTo(Boolean.valueOf(c4267hg.m15398a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15398a() && (m15572a12 = C4278hr.m15572a(this.f16129a, c4267hg.f16129a)) != 0) {
            return m15572a12;
        }
        int compareTo2 = Boolean.valueOf(m15402b()).compareTo(Boolean.valueOf(c4267hg.m15402b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m15402b() && (m15571a = C4278hr.m15571a(this.f16128a, c4267hg.f16128a)) != 0) {
            return m15571a;
        }
        int compareTo3 = Boolean.valueOf(m15405c()).compareTo(Boolean.valueOf(c4267hg.m15405c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m15405c() && (m15572a11 = C4278hr.m15572a(this.f16135b, c4267hg.f16135b)) != 0) {
            return m15572a11;
        }
        int compareTo4 = Boolean.valueOf(m15407d()).compareTo(Boolean.valueOf(c4267hg.m15407d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m15407d() && (m15572a10 = C4278hr.m15572a(this.f16137c, c4267hg.f16137c)) != 0) {
            return m15572a10;
        }
        int compareTo5 = Boolean.valueOf(m15409e()).compareTo(Boolean.valueOf(c4267hg.m15409e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m15409e() && (m15570a3 = C4278hr.m15570a(this.f16127a, c4267hg.f16127a)) != 0) {
            return m15570a3;
        }
        int compareTo6 = Boolean.valueOf(m15411f()).compareTo(Boolean.valueOf(c4267hg.m15411f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m15411f() && (m15572a9 = C4278hr.m15572a(this.f16138d, c4267hg.f16138d)) != 0) {
            return m15572a9;
        }
        int compareTo7 = Boolean.valueOf(m15412g()).compareTo(Boolean.valueOf(c4267hg.m15412g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m15412g() && (m15572a8 = C4278hr.m15572a(this.f16139e, c4267hg.f16139e)) != 0) {
            return m15572a8;
        }
        int compareTo8 = Boolean.valueOf(m15413h()).compareTo(Boolean.valueOf(c4267hg.m15413h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m15413h() && (m15572a7 = C4278hr.m15572a(this.f16140f, c4267hg.f16140f)) != 0) {
            return m15572a7;
        }
        int compareTo9 = Boolean.valueOf(m15414i()).compareTo(Boolean.valueOf(c4267hg.m15414i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m15414i() && (m15572a6 = C4278hr.m15572a(this.f16141g, c4267hg.f16141g)) != 0) {
            return m15572a6;
        }
        int compareTo10 = Boolean.valueOf(m15415j()).compareTo(Boolean.valueOf(c4267hg.m15415j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m15415j() && (m15570a2 = C4278hr.m15570a(this.f16134b, c4267hg.f16134b)) != 0) {
            return m15570a2;
        }
        int compareTo11 = Boolean.valueOf(m15416k()).compareTo(Boolean.valueOf(c4267hg.m15416k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m15416k() && (m15572a5 = C4278hr.m15572a(this.f16142h, c4267hg.f16142h)) != 0) {
            return m15572a5;
        }
        int compareTo12 = Boolean.valueOf(m15417l()).compareTo(Boolean.valueOf(c4267hg.m15417l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m15417l() && (m15572a4 = C4278hr.m15572a(this.f16143i, c4267hg.f16143i)) != 0) {
            return m15572a4;
        }
        int compareTo13 = Boolean.valueOf(m15418m()).compareTo(Boolean.valueOf(c4267hg.m15418m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m15418m() && (m15570a = C4278hr.m15570a(this.f16136c, c4267hg.f16136c)) != 0) {
            return m15570a;
        }
        int compareTo14 = Boolean.valueOf(m15419n()).compareTo(Boolean.valueOf(c4267hg.m15419n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (m15419n() && (m15572a3 = C4278hr.m15572a(this.f16144j, c4267hg.f16144j)) != 0) {
            return m15572a3;
        }
        int compareTo15 = Boolean.valueOf(m15420o()).compareTo(Boolean.valueOf(c4267hg.m15420o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (m15420o() && (m15569a2 = C4278hr.m15569a(this.f16126a, c4267hg.f16126a)) != 0) {
            return m15569a2;
        }
        int compareTo16 = Boolean.valueOf(m15421p()).compareTo(Boolean.valueOf(c4267hg.m15421p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (m15421p() && (m15572a2 = C4278hr.m15572a(this.f16145k, c4267hg.f16145k)) != 0) {
            return m15572a2;
        }
        int compareTo17 = Boolean.valueOf(m15422q()).compareTo(Boolean.valueOf(c4267hg.m15422q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (m15422q() && (m15569a = C4278hr.m15569a(this.f16133b, c4267hg.f16133b)) != 0) {
            return m15569a;
        }
        int compareTo18 = Boolean.valueOf(m15423r()).compareTo(Boolean.valueOf(c4267hg.m15423r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (m15423r() && (m15572a = C4278hr.m15572a(this.f16146l, c4267hg.f16146l)) != 0) {
            return m15572a;
        }
        int compareTo19 = Boolean.valueOf(m15424s()).compareTo(Boolean.valueOf(c4267hg.m15424s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (m15424s() && (m15578a = C4278hr.m15578a(this.f16132a, c4267hg.f16132a)) != 0) {
            return m15578a;
        }
        int compareTo20 = Boolean.valueOf(m15425t()).compareTo(Boolean.valueOf(c4267hg.m15425t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (!m15425t() || (m15574a = C4278hr.m15574a(this.f16131a, c4267hg.f16131a)) == 0) {
            return 0;
        }
        return m15574a;
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
                if (m15409e()) {
                    m15396a();
                    return;
                }
                throw new C4289ib("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo15594a.f16333a) {
                case 1:
                    if (b2 == 11) {
                        this.f16129a = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f16128a = new C4254gu();
                        this.f16128a.mo14606a(abstractC4288ia);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f16135b = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f16137c = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 5:
                default:
                    C4291id.m15660a(abstractC4288ia, b2);
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f16127a = abstractC4288ia.mo15593a();
                        m15397a(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f16138d = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f16139e = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f16140f = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f16141g = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 11:
                    if (b2 == 10) {
                        this.f16134b = abstractC4288ia.mo15593a();
                        m15401b(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 12:
                    if (b2 == 11) {
                        this.f16142h = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 13:
                    if (b2 == 11) {
                        this.f16143i = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 14:
                    if (b2 == 10) {
                        this.f16136c = abstractC4288ia.mo15593a();
                        m15404c(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 15:
                    if (b2 == 11) {
                        this.f16144j = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 16:
                    if (b2 == 8) {
                        this.f16126a = abstractC4288ia.mo15592a();
                        m15406d(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 17:
                    if (b2 == 11) {
                        this.f16145k = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 18:
                    if (b2 == 8) {
                        this.f16133b = abstractC4288ia.mo15592a();
                        m15408e(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 19:
                    if (b2 == 11) {
                        this.f16146l = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 20:
                    if (b2 == 2) {
                        this.f16132a = abstractC4288ia.mo15615a();
                        m15410f(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 21:
                    if (b2 == 15) {
                        C4285hy mo15595a = abstractC4288ia.mo15595a();
                        this.f16131a = new ArrayList(mo15595a.f16335a);
                        for (int i2 = 0; i2 < mo15595a.f16335a; i2++) {
                            this.f16131a.add(abstractC4288ia.mo15599a());
                        }
                        abstractC4288ia.mo15625i();
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
    public void m15396a() {
        if (this.f16135b != null) {
            if (this.f16137c != null) {
                return;
            }
            throw new C4289ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new C4289ib("Required field 'id' was not present! Struct: " + toString());
    }
}
