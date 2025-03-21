package com.xiaomi.push;

import com.umeng.analytics.pro.C3393cw;
import com.xiaomi.push.service.C4358aj;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.hf */
/* loaded from: classes2.dex */
public class C4266hf implements InterfaceC4277hq<C4266hf, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public int f16075a;

    /* renamed from: a */
    public long f16076a;

    /* renamed from: a */
    public EnumC4253gt f16077a;

    /* renamed from: a */
    public C4254gu f16078a;

    /* renamed from: a */
    public String f16079a;

    /* renamed from: a */
    public Map<String, String> f16081a;

    /* renamed from: b */
    public int f16083b;

    /* renamed from: b */
    public long f16084b;

    /* renamed from: b */
    public String f16085b;

    /* renamed from: c */
    public int f16087c;

    /* renamed from: c */
    public String f16088c;

    /* renamed from: d */
    public String f16090d;

    /* renamed from: e */
    public String f16091e;

    /* renamed from: f */
    public String f16092f;

    /* renamed from: g */
    public String f16093g;

    /* renamed from: h */
    public String f16094h;

    /* renamed from: i */
    public String f16095i;

    /* renamed from: j */
    public String f16096j;

    /* renamed from: k */
    public String f16097k;

    /* renamed from: l */
    public String f16098l;

    /* renamed from: m */
    public String f16099m;

    /* renamed from: n */
    public String f16100n;

    /* renamed from: o */
    public String f16101o;

    /* renamed from: p */
    public String f16102p;

    /* renamed from: q */
    public String f16103q;

    /* renamed from: r */
    public String f16104r;

    /* renamed from: a */
    private static final C4293if f16049a = new C4293if("XmPushActionRegistration");

    /* renamed from: a */
    private static final C4284hx f16048a = new C4284hx("", (byte) 11, 1);

    /* renamed from: b */
    private static final C4284hx f16050b = new C4284hx("", (byte) 12, 2);

    /* renamed from: c */
    private static final C4284hx f16051c = new C4284hx("", (byte) 11, 3);

    /* renamed from: d */
    private static final C4284hx f16052d = new C4284hx("", (byte) 11, 4);

    /* renamed from: e */
    private static final C4284hx f16053e = new C4284hx("", (byte) 11, 5);

    /* renamed from: f */
    private static final C4284hx f16054f = new C4284hx("", (byte) 11, 6);

    /* renamed from: g */
    private static final C4284hx f16055g = new C4284hx("", (byte) 11, 7);

    /* renamed from: h */
    private static final C4284hx f16056h = new C4284hx("", (byte) 11, 8);

    /* renamed from: i */
    private static final C4284hx f16057i = new C4284hx("", (byte) 11, 9);

    /* renamed from: j */
    private static final C4284hx f16058j = new C4284hx("", (byte) 11, 10);

    /* renamed from: k */
    private static final C4284hx f16059k = new C4284hx("", (byte) 11, 11);

    /* renamed from: l */
    private static final C4284hx f16060l = new C4284hx("", (byte) 11, 12);

    /* renamed from: m */
    private static final C4284hx f16061m = new C4284hx("", (byte) 8, 13);

    /* renamed from: n */
    private static final C4284hx f16062n = new C4284hx("", (byte) 8, 14);

    /* renamed from: o */
    private static final C4284hx f16063o = new C4284hx("", (byte) 11, 15);

    /* renamed from: p */
    private static final C4284hx f16064p = new C4284hx("", (byte) 11, 16);

    /* renamed from: q */
    private static final C4284hx f16065q = new C4284hx("", (byte) 11, 17);

    /* renamed from: r */
    private static final C4284hx f16066r = new C4284hx("", (byte) 11, 18);

    /* renamed from: s */
    private static final C4284hx f16067s = new C4284hx("", (byte) 8, 19);

    /* renamed from: t */
    private static final C4284hx f16068t = new C4284hx("", (byte) 8, 20);

    /* renamed from: u */
    private static final C4284hx f16069u = new C4284hx("", (byte) 2, 21);

    /* renamed from: v */
    private static final C4284hx f16070v = new C4284hx("", (byte) 10, 22);

    /* renamed from: w */
    private static final C4284hx f16071w = new C4284hx("", (byte) 10, 23);

    /* renamed from: x */
    private static final C4284hx f16072x = new C4284hx("", (byte) 11, 24);

    /* renamed from: y */
    private static final C4284hx f16073y = new C4284hx("", (byte) 11, 25);

    /* renamed from: z */
    private static final C4284hx f16074z = new C4284hx("", (byte) 2, 26);

    /* renamed from: A */
    private static final C4284hx f16045A = new C4284hx("", C3393cw.f11871k, 100);

    /* renamed from: B */
    private static final C4284hx f16046B = new C4284hx("", (byte) 2, 101);

    /* renamed from: C */
    private static final C4284hx f16047C = new C4284hx("", (byte) 11, 102);

    /* renamed from: a */
    private BitSet f16080a = new BitSet(8);

    /* renamed from: a */
    public boolean f16082a = true;

    /* renamed from: c */
    public boolean f16089c = false;

    /* renamed from: b */
    public boolean f16086b = false;

    /* renamed from: A */
    public boolean m15336A() {
        return this.f16081a != null;
    }

    /* renamed from: B */
    public boolean m15337B() {
        return this.f16080a.get(7);
    }

    /* renamed from: C */
    public boolean m15338C() {
        return this.f16104r != null;
    }

    /* renamed from: a */
    public boolean m15346a() {
        return this.f16079a != null;
    }

    /* renamed from: b */
    public boolean m15352b() {
        return this.f16078a != null;
    }

    /* renamed from: c */
    public boolean m15357c() {
        return this.f16085b != null;
    }

    /* renamed from: d */
    public boolean m15360d() {
        return this.f16088c != null;
    }

    /* renamed from: e */
    public boolean m15363e() {
        return this.f16090d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4266hf)) {
            return m15347a((C4266hf) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean m15366f() {
        return this.f16091e != null;
    }

    /* renamed from: g */
    public boolean m15369g() {
        return this.f16092f != null;
    }

    /* renamed from: h */
    public boolean m15372h() {
        return this.f16093g != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean m15374i() {
        return this.f16094h != null;
    }

    /* renamed from: j */
    public boolean m15375j() {
        return this.f16095i != null;
    }

    /* renamed from: k */
    public boolean m15376k() {
        return this.f16096j != null;
    }

    /* renamed from: l */
    public boolean m15377l() {
        return this.f16097k != null;
    }

    /* renamed from: m */
    public boolean m15378m() {
        return this.f16080a.get(0);
    }

    /* renamed from: n */
    public boolean m15379n() {
        return this.f16080a.get(1);
    }

    /* renamed from: o */
    public boolean m15380o() {
        return this.f16098l != null;
    }

    /* renamed from: p */
    public boolean m15381p() {
        return this.f16099m != null;
    }

    /* renamed from: q */
    public boolean m15382q() {
        return this.f16100n != null;
    }

    /* renamed from: r */
    public boolean m15383r() {
        return this.f16101o != null;
    }

    /* renamed from: s */
    public boolean m15384s() {
        return this.f16080a.get(2);
    }

    /* renamed from: t */
    public boolean m15385t() {
        return this.f16077a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        if (m15346a()) {
            sb.append("debug:");
            String str = this.f16079a;
            if (str == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m15352b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            C4254gu c4254gu = this.f16078a;
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
        String str2 = this.f16085b;
        if (str2 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(C4358aj.m15942a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f16088c;
        if (str3 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str3);
        }
        if (m15363e()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str4 = this.f16090d;
            if (str4 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str4);
            }
        }
        if (m15366f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f16091e;
            if (str5 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str5);
            }
        }
        sb.append(", ");
        sb.append("token:");
        String str6 = this.f16092f;
        if (str6 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str6);
        }
        if (m15372h()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str7 = this.f16093g;
            if (str7 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str7);
            }
        }
        if (m15374i()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str8 = this.f16094h;
            if (str8 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str8);
            }
        }
        if (m15375j()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            String str9 = this.f16095i;
            if (str9 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str9);
            }
        }
        if (m15376k()) {
            sb.append(", ");
            sb.append("regId:");
            String str10 = this.f16096j;
            if (str10 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str10);
            }
        }
        if (m15377l()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            String str11 = this.f16097k;
            if (str11 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str11);
            }
        }
        if (m15378m()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f16075a);
        }
        if (m15379n()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f16083b);
        }
        if (m15380o()) {
            sb.append(", ");
            sb.append("androidId:");
            String str12 = this.f16098l;
            if (str12 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str12);
            }
        }
        if (m15381p()) {
            sb.append(", ");
            sb.append("imei:");
            String str13 = this.f16099m;
            if (str13 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str13);
            }
        }
        if (m15382q()) {
            sb.append(", ");
            sb.append("serial:");
            String str14 = this.f16100n;
            if (str14 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str14);
            }
        }
        if (m15383r()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str15 = this.f16101o;
            if (str15 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str15);
            }
        }
        if (m15384s()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.f16087c);
        }
        if (m15385t()) {
            sb.append(", ");
            sb.append("reason:");
            EnumC4253gt enumC4253gt = this.f16077a;
            if (enumC4253gt == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(enumC4253gt);
            }
        }
        if (m15386u()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.f16082a);
        }
        if (m15387v()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f16076a);
        }
        if (m15388w()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f16084b);
        }
        if (m15389x()) {
            sb.append(", ");
            sb.append("subImei:");
            String str16 = this.f16102p;
            if (str16 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str16);
            }
        }
        if (m15390y()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            String str17 = this.f16103q;
            if (str17 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str17);
            }
        }
        if (m15391z()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f16086b);
        }
        if (m15336A()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            Map<String, String> map = this.f16081a;
            if (map == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(map);
            }
        }
        if (m15337B()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.f16089c);
        }
        if (m15338C()) {
            sb.append(", ");
            sb.append("oldRegId:");
            String str18 = this.f16104r;
            if (str18 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str18);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: u */
    public boolean m15386u() {
        return this.f16080a.get(3);
    }

    /* renamed from: v */
    public boolean m15387v() {
        return this.f16080a.get(4);
    }

    /* renamed from: w */
    public boolean m15388w() {
        return this.f16080a.get(5);
    }

    /* renamed from: x */
    public boolean m15389x() {
        return this.f16102p != null;
    }

    /* renamed from: y */
    public boolean m15390y() {
        return this.f16103q != null;
    }

    /* renamed from: z */
    public boolean m15391z() {
        return this.f16080a.get(6);
    }

    /* renamed from: a */
    public String m15343a() {
        return this.f16085b;
    }

    /* renamed from: b */
    public String m15350b() {
        return this.f16088c;
    }

    /* renamed from: c */
    public C4266hf m15354c(String str) {
        this.f16090d = str;
        return this;
    }

    /* renamed from: d */
    public C4266hf m15358d(String str) {
        this.f16091e = str;
        return this;
    }

    /* renamed from: e */
    public C4266hf m15361e(String str) {
        this.f16092f = str;
        return this;
    }

    /* renamed from: f */
    public C4266hf m15364f(String str) {
        this.f16093g = str;
        return this;
    }

    /* renamed from: g */
    public C4266hf m15367g(String str) {
        this.f16094h = str;
        return this;
    }

    /* renamed from: h */
    public C4266hf m15370h(String str) {
        this.f16097k = str;
        return this;
    }

    /* renamed from: i */
    public C4266hf m15373i(String str) {
        this.f16101o = str;
        return this;
    }

    /* renamed from: a */
    public C4266hf m15342a(String str) {
        this.f16085b = str;
        return this;
    }

    /* renamed from: b */
    public C4266hf m15349b(String str) {
        this.f16088c = str;
        return this;
    }

    /* renamed from: c */
    public String m15355c() {
        return this.f16092f;
    }

    /* renamed from: d */
    public void m15359d(boolean z) {
        this.f16080a.set(3, z);
    }

    /* renamed from: e */
    public void m15362e(boolean z) {
        this.f16080a.set(4, z);
    }

    /* renamed from: f */
    public void m15365f(boolean z) {
        this.f16080a.set(5, z);
    }

    /* renamed from: g */
    public void m15368g(boolean z) {
        this.f16080a.set(6, z);
    }

    /* renamed from: h */
    public void m15371h(boolean z) {
        this.f16080a.set(7, z);
    }

    /* renamed from: a */
    public C4266hf m15340a(int i2) {
        this.f16075a = i2;
        m15345a(true);
        return this;
    }

    /* renamed from: b */
    public C4266hf m15348b(int i2) {
        this.f16083b = i2;
        m15351b(true);
        return this;
    }

    /* renamed from: c */
    public C4266hf m15353c(int i2) {
        this.f16087c = i2;
        m15356c(true);
        return this;
    }

    /* renamed from: a */
    public void m15345a(boolean z) {
        this.f16080a.set(0, z);
    }

    /* renamed from: b */
    public void m15351b(boolean z) {
        this.f16080a.set(1, z);
    }

    /* renamed from: c */
    public void m15356c(boolean z) {
        this.f16080a.set(2, z);
    }

    /* renamed from: a */
    public C4266hf m15341a(EnumC4253gt enumC4253gt) {
        this.f16077a = enumC4253gt;
        return this;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15344a();
        abstractC4288ia.mo15610a(f16049a);
        if (this.f16079a != null && m15346a()) {
            abstractC4288ia.mo15607a(f16048a);
            abstractC4288ia.mo15611a(this.f16079a);
            abstractC4288ia.mo15616b();
        }
        if (this.f16078a != null && m15352b()) {
            abstractC4288ia.mo15607a(f16050b);
            this.f16078a.mo14612b(abstractC4288ia);
            abstractC4288ia.mo15616b();
        }
        if (this.f16085b != null) {
            abstractC4288ia.mo15607a(f16051c);
            abstractC4288ia.mo15611a(this.f16085b);
            abstractC4288ia.mo15616b();
        }
        if (this.f16088c != null) {
            abstractC4288ia.mo15607a(f16052d);
            abstractC4288ia.mo15611a(this.f16088c);
            abstractC4288ia.mo15616b();
        }
        if (this.f16090d != null && m15363e()) {
            abstractC4288ia.mo15607a(f16053e);
            abstractC4288ia.mo15611a(this.f16090d);
            abstractC4288ia.mo15616b();
        }
        if (this.f16091e != null && m15366f()) {
            abstractC4288ia.mo15607a(f16054f);
            abstractC4288ia.mo15611a(this.f16091e);
            abstractC4288ia.mo15616b();
        }
        if (this.f16092f != null) {
            abstractC4288ia.mo15607a(f16055g);
            abstractC4288ia.mo15611a(this.f16092f);
            abstractC4288ia.mo15616b();
        }
        if (this.f16093g != null && m15372h()) {
            abstractC4288ia.mo15607a(f16056h);
            abstractC4288ia.mo15611a(this.f16093g);
            abstractC4288ia.mo15616b();
        }
        if (this.f16094h != null && m15374i()) {
            abstractC4288ia.mo15607a(f16057i);
            abstractC4288ia.mo15611a(this.f16094h);
            abstractC4288ia.mo15616b();
        }
        if (this.f16095i != null && m15375j()) {
            abstractC4288ia.mo15607a(f16058j);
            abstractC4288ia.mo15611a(this.f16095i);
            abstractC4288ia.mo15616b();
        }
        if (this.f16096j != null && m15376k()) {
            abstractC4288ia.mo15607a(f16059k);
            abstractC4288ia.mo15611a(this.f16096j);
            abstractC4288ia.mo15616b();
        }
        if (this.f16097k != null && m15377l()) {
            abstractC4288ia.mo15607a(f16060l);
            abstractC4288ia.mo15611a(this.f16097k);
            abstractC4288ia.mo15616b();
        }
        if (m15378m()) {
            abstractC4288ia.mo15607a(f16061m);
            abstractC4288ia.mo15605a(this.f16075a);
            abstractC4288ia.mo15616b();
        }
        if (m15379n()) {
            abstractC4288ia.mo15607a(f16062n);
            abstractC4288ia.mo15605a(this.f16083b);
            abstractC4288ia.mo15616b();
        }
        if (this.f16098l != null && m15380o()) {
            abstractC4288ia.mo15607a(f16063o);
            abstractC4288ia.mo15611a(this.f16098l);
            abstractC4288ia.mo15616b();
        }
        if (this.f16099m != null && m15381p()) {
            abstractC4288ia.mo15607a(f16064p);
            abstractC4288ia.mo15611a(this.f16099m);
            abstractC4288ia.mo15616b();
        }
        if (this.f16100n != null && m15382q()) {
            abstractC4288ia.mo15607a(f16065q);
            abstractC4288ia.mo15611a(this.f16100n);
            abstractC4288ia.mo15616b();
        }
        if (this.f16101o != null && m15383r()) {
            abstractC4288ia.mo15607a(f16066r);
            abstractC4288ia.mo15611a(this.f16101o);
            abstractC4288ia.mo15616b();
        }
        if (m15384s()) {
            abstractC4288ia.mo15607a(f16067s);
            abstractC4288ia.mo15605a(this.f16087c);
            abstractC4288ia.mo15616b();
        }
        if (this.f16077a != null && m15385t()) {
            abstractC4288ia.mo15607a(f16068t);
            abstractC4288ia.mo15605a(this.f16077a.m15133a());
            abstractC4288ia.mo15616b();
        }
        if (m15386u()) {
            abstractC4288ia.mo15607a(f16069u);
            abstractC4288ia.mo15614a(this.f16082a);
            abstractC4288ia.mo15616b();
        }
        if (m15387v()) {
            abstractC4288ia.mo15607a(f16070v);
            abstractC4288ia.mo15606a(this.f16076a);
            abstractC4288ia.mo15616b();
        }
        if (m15388w()) {
            abstractC4288ia.mo15607a(f16071w);
            abstractC4288ia.mo15606a(this.f16084b);
            abstractC4288ia.mo15616b();
        }
        if (this.f16102p != null && m15389x()) {
            abstractC4288ia.mo15607a(f16072x);
            abstractC4288ia.mo15611a(this.f16102p);
            abstractC4288ia.mo15616b();
        }
        if (this.f16103q != null && m15390y()) {
            abstractC4288ia.mo15607a(f16073y);
            abstractC4288ia.mo15611a(this.f16103q);
            abstractC4288ia.mo15616b();
        }
        if (m15391z()) {
            abstractC4288ia.mo15607a(f16074z);
            abstractC4288ia.mo15614a(this.f16086b);
            abstractC4288ia.mo15616b();
        }
        if (this.f16081a != null && m15336A()) {
            abstractC4288ia.mo15607a(f16045A);
            abstractC4288ia.mo15609a(new C4286hz((byte) 11, (byte) 11, this.f16081a.size()));
            for (Map.Entry<String, String> entry : this.f16081a.entrySet()) {
                abstractC4288ia.mo15611a(entry.getKey());
                abstractC4288ia.mo15611a(entry.getValue());
            }
            abstractC4288ia.mo15620d();
            abstractC4288ia.mo15616b();
        }
        if (m15337B()) {
            abstractC4288ia.mo15607a(f16046B);
            abstractC4288ia.mo15614a(this.f16089c);
            abstractC4288ia.mo15616b();
        }
        if (this.f16104r != null && m15338C()) {
            abstractC4288ia.mo15607a(f16047C);
            abstractC4288ia.mo15611a(this.f16104r);
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    /* renamed from: a */
    public boolean m15347a(C4266hf c4266hf) {
        if (c4266hf == null) {
            return false;
        }
        boolean m15346a = m15346a();
        boolean m15346a2 = c4266hf.m15346a();
        if ((m15346a || m15346a2) && !(m15346a && m15346a2 && this.f16079a.equals(c4266hf.f16079a))) {
            return false;
        }
        boolean m15352b = m15352b();
        boolean m15352b2 = c4266hf.m15352b();
        if ((m15352b || m15352b2) && !(m15352b && m15352b2 && this.f16078a.m15138a(c4266hf.f16078a))) {
            return false;
        }
        boolean m15357c = m15357c();
        boolean m15357c2 = c4266hf.m15357c();
        if ((m15357c || m15357c2) && !(m15357c && m15357c2 && this.f16085b.equals(c4266hf.f16085b))) {
            return false;
        }
        boolean m15360d = m15360d();
        boolean m15360d2 = c4266hf.m15360d();
        if ((m15360d || m15360d2) && !(m15360d && m15360d2 && this.f16088c.equals(c4266hf.f16088c))) {
            return false;
        }
        boolean m15363e = m15363e();
        boolean m15363e2 = c4266hf.m15363e();
        if ((m15363e || m15363e2) && !(m15363e && m15363e2 && this.f16090d.equals(c4266hf.f16090d))) {
            return false;
        }
        boolean m15366f = m15366f();
        boolean m15366f2 = c4266hf.m15366f();
        if ((m15366f || m15366f2) && !(m15366f && m15366f2 && this.f16091e.equals(c4266hf.f16091e))) {
            return false;
        }
        boolean m15369g = m15369g();
        boolean m15369g2 = c4266hf.m15369g();
        if ((m15369g || m15369g2) && !(m15369g && m15369g2 && this.f16092f.equals(c4266hf.f16092f))) {
            return false;
        }
        boolean m15372h = m15372h();
        boolean m15372h2 = c4266hf.m15372h();
        if ((m15372h || m15372h2) && !(m15372h && m15372h2 && this.f16093g.equals(c4266hf.f16093g))) {
            return false;
        }
        boolean m15374i = m15374i();
        boolean m15374i2 = c4266hf.m15374i();
        if ((m15374i || m15374i2) && !(m15374i && m15374i2 && this.f16094h.equals(c4266hf.f16094h))) {
            return false;
        }
        boolean m15375j = m15375j();
        boolean m15375j2 = c4266hf.m15375j();
        if ((m15375j || m15375j2) && !(m15375j && m15375j2 && this.f16095i.equals(c4266hf.f16095i))) {
            return false;
        }
        boolean m15376k = m15376k();
        boolean m15376k2 = c4266hf.m15376k();
        if ((m15376k || m15376k2) && !(m15376k && m15376k2 && this.f16096j.equals(c4266hf.f16096j))) {
            return false;
        }
        boolean m15377l = m15377l();
        boolean m15377l2 = c4266hf.m15377l();
        if ((m15377l || m15377l2) && !(m15377l && m15377l2 && this.f16097k.equals(c4266hf.f16097k))) {
            return false;
        }
        boolean m15378m = m15378m();
        boolean m15378m2 = c4266hf.m15378m();
        if ((m15378m || m15378m2) && !(m15378m && m15378m2 && this.f16075a == c4266hf.f16075a)) {
            return false;
        }
        boolean m15379n = m15379n();
        boolean m15379n2 = c4266hf.m15379n();
        if ((m15379n || m15379n2) && !(m15379n && m15379n2 && this.f16083b == c4266hf.f16083b)) {
            return false;
        }
        boolean m15380o = m15380o();
        boolean m15380o2 = c4266hf.m15380o();
        if ((m15380o || m15380o2) && !(m15380o && m15380o2 && this.f16098l.equals(c4266hf.f16098l))) {
            return false;
        }
        boolean m15381p = m15381p();
        boolean m15381p2 = c4266hf.m15381p();
        if ((m15381p || m15381p2) && !(m15381p && m15381p2 && this.f16099m.equals(c4266hf.f16099m))) {
            return false;
        }
        boolean m15382q = m15382q();
        boolean m15382q2 = c4266hf.m15382q();
        if ((m15382q || m15382q2) && !(m15382q && m15382q2 && this.f16100n.equals(c4266hf.f16100n))) {
            return false;
        }
        boolean m15383r = m15383r();
        boolean m15383r2 = c4266hf.m15383r();
        if ((m15383r || m15383r2) && !(m15383r && m15383r2 && this.f16101o.equals(c4266hf.f16101o))) {
            return false;
        }
        boolean m15384s = m15384s();
        boolean m15384s2 = c4266hf.m15384s();
        if ((m15384s || m15384s2) && !(m15384s && m15384s2 && this.f16087c == c4266hf.f16087c)) {
            return false;
        }
        boolean m15385t = m15385t();
        boolean m15385t2 = c4266hf.m15385t();
        if ((m15385t || m15385t2) && !(m15385t && m15385t2 && this.f16077a.equals(c4266hf.f16077a))) {
            return false;
        }
        boolean m15386u = m15386u();
        boolean m15386u2 = c4266hf.m15386u();
        if ((m15386u || m15386u2) && !(m15386u && m15386u2 && this.f16082a == c4266hf.f16082a)) {
            return false;
        }
        boolean m15387v = m15387v();
        boolean m15387v2 = c4266hf.m15387v();
        if ((m15387v || m15387v2) && !(m15387v && m15387v2 && this.f16076a == c4266hf.f16076a)) {
            return false;
        }
        boolean m15388w = m15388w();
        boolean m15388w2 = c4266hf.m15388w();
        if ((m15388w || m15388w2) && !(m15388w && m15388w2 && this.f16084b == c4266hf.f16084b)) {
            return false;
        }
        boolean m15389x = m15389x();
        boolean m15389x2 = c4266hf.m15389x();
        if ((m15389x || m15389x2) && !(m15389x && m15389x2 && this.f16102p.equals(c4266hf.f16102p))) {
            return false;
        }
        boolean m15390y = m15390y();
        boolean m15390y2 = c4266hf.m15390y();
        if ((m15390y || m15390y2) && !(m15390y && m15390y2 && this.f16103q.equals(c4266hf.f16103q))) {
            return false;
        }
        boolean m15391z = m15391z();
        boolean m15391z2 = c4266hf.m15391z();
        if ((m15391z || m15391z2) && !(m15391z && m15391z2 && this.f16086b == c4266hf.f16086b)) {
            return false;
        }
        boolean m15336A = m15336A();
        boolean m15336A2 = c4266hf.m15336A();
        if ((m15336A || m15336A2) && !(m15336A && m15336A2 && this.f16081a.equals(c4266hf.f16081a))) {
            return false;
        }
        boolean m15337B = m15337B();
        boolean m15337B2 = c4266hf.m15337B();
        if ((m15337B || m15337B2) && !(m15337B && m15337B2 && this.f16089c == c4266hf.f16089c)) {
            return false;
        }
        boolean m15338C = m15338C();
        boolean m15338C2 = c4266hf.m15338C();
        if (m15338C || m15338C2) {
            return m15338C && m15338C2 && this.f16104r.equals(c4266hf.f16104r);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4266hf c4266hf) {
        int m15572a;
        int m15578a;
        int m15575a;
        int m15578a2;
        int m15572a2;
        int m15572a3;
        int m15570a;
        int m15570a2;
        int m15578a3;
        int m15571a;
        int m15569a;
        int m15572a4;
        int m15572a5;
        int m15572a6;
        int m15572a7;
        int m15569a2;
        int m15569a3;
        int m15572a8;
        int m15572a9;
        int m15572a10;
        int m15572a11;
        int m15572a12;
        int m15572a13;
        int m15572a14;
        int m15572a15;
        int m15572a16;
        int m15572a17;
        int m15571a2;
        int m15572a18;
        if (!C4266hf.class.equals(c4266hf.getClass())) {
            return C4266hf.class.getName().compareTo(c4266hf.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15346a()).compareTo(Boolean.valueOf(c4266hf.m15346a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15346a() && (m15572a18 = C4278hr.m15572a(this.f16079a, c4266hf.f16079a)) != 0) {
            return m15572a18;
        }
        int compareTo2 = Boolean.valueOf(m15352b()).compareTo(Boolean.valueOf(c4266hf.m15352b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m15352b() && (m15571a2 = C4278hr.m15571a(this.f16078a, c4266hf.f16078a)) != 0) {
            return m15571a2;
        }
        int compareTo3 = Boolean.valueOf(m15357c()).compareTo(Boolean.valueOf(c4266hf.m15357c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (m15357c() && (m15572a17 = C4278hr.m15572a(this.f16085b, c4266hf.f16085b)) != 0) {
            return m15572a17;
        }
        int compareTo4 = Boolean.valueOf(m15360d()).compareTo(Boolean.valueOf(c4266hf.m15360d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (m15360d() && (m15572a16 = C4278hr.m15572a(this.f16088c, c4266hf.f16088c)) != 0) {
            return m15572a16;
        }
        int compareTo5 = Boolean.valueOf(m15363e()).compareTo(Boolean.valueOf(c4266hf.m15363e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (m15363e() && (m15572a15 = C4278hr.m15572a(this.f16090d, c4266hf.f16090d)) != 0) {
            return m15572a15;
        }
        int compareTo6 = Boolean.valueOf(m15366f()).compareTo(Boolean.valueOf(c4266hf.m15366f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (m15366f() && (m15572a14 = C4278hr.m15572a(this.f16091e, c4266hf.f16091e)) != 0) {
            return m15572a14;
        }
        int compareTo7 = Boolean.valueOf(m15369g()).compareTo(Boolean.valueOf(c4266hf.m15369g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (m15369g() && (m15572a13 = C4278hr.m15572a(this.f16092f, c4266hf.f16092f)) != 0) {
            return m15572a13;
        }
        int compareTo8 = Boolean.valueOf(m15372h()).compareTo(Boolean.valueOf(c4266hf.m15372h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (m15372h() && (m15572a12 = C4278hr.m15572a(this.f16093g, c4266hf.f16093g)) != 0) {
            return m15572a12;
        }
        int compareTo9 = Boolean.valueOf(m15374i()).compareTo(Boolean.valueOf(c4266hf.m15374i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (m15374i() && (m15572a11 = C4278hr.m15572a(this.f16094h, c4266hf.f16094h)) != 0) {
            return m15572a11;
        }
        int compareTo10 = Boolean.valueOf(m15375j()).compareTo(Boolean.valueOf(c4266hf.m15375j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (m15375j() && (m15572a10 = C4278hr.m15572a(this.f16095i, c4266hf.f16095i)) != 0) {
            return m15572a10;
        }
        int compareTo11 = Boolean.valueOf(m15376k()).compareTo(Boolean.valueOf(c4266hf.m15376k()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (m15376k() && (m15572a9 = C4278hr.m15572a(this.f16096j, c4266hf.f16096j)) != 0) {
            return m15572a9;
        }
        int compareTo12 = Boolean.valueOf(m15377l()).compareTo(Boolean.valueOf(c4266hf.m15377l()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (m15377l() && (m15572a8 = C4278hr.m15572a(this.f16097k, c4266hf.f16097k)) != 0) {
            return m15572a8;
        }
        int compareTo13 = Boolean.valueOf(m15378m()).compareTo(Boolean.valueOf(c4266hf.m15378m()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (m15378m() && (m15569a3 = C4278hr.m15569a(this.f16075a, c4266hf.f16075a)) != 0) {
            return m15569a3;
        }
        int compareTo14 = Boolean.valueOf(m15379n()).compareTo(Boolean.valueOf(c4266hf.m15379n()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (m15379n() && (m15569a2 = C4278hr.m15569a(this.f16083b, c4266hf.f16083b)) != 0) {
            return m15569a2;
        }
        int compareTo15 = Boolean.valueOf(m15380o()).compareTo(Boolean.valueOf(c4266hf.m15380o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (m15380o() && (m15572a7 = C4278hr.m15572a(this.f16098l, c4266hf.f16098l)) != 0) {
            return m15572a7;
        }
        int compareTo16 = Boolean.valueOf(m15381p()).compareTo(Boolean.valueOf(c4266hf.m15381p()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (m15381p() && (m15572a6 = C4278hr.m15572a(this.f16099m, c4266hf.f16099m)) != 0) {
            return m15572a6;
        }
        int compareTo17 = Boolean.valueOf(m15382q()).compareTo(Boolean.valueOf(c4266hf.m15382q()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (m15382q() && (m15572a5 = C4278hr.m15572a(this.f16100n, c4266hf.f16100n)) != 0) {
            return m15572a5;
        }
        int compareTo18 = Boolean.valueOf(m15383r()).compareTo(Boolean.valueOf(c4266hf.m15383r()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (m15383r() && (m15572a4 = C4278hr.m15572a(this.f16101o, c4266hf.f16101o)) != 0) {
            return m15572a4;
        }
        int compareTo19 = Boolean.valueOf(m15384s()).compareTo(Boolean.valueOf(c4266hf.m15384s()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (m15384s() && (m15569a = C4278hr.m15569a(this.f16087c, c4266hf.f16087c)) != 0) {
            return m15569a;
        }
        int compareTo20 = Boolean.valueOf(m15385t()).compareTo(Boolean.valueOf(c4266hf.m15385t()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (m15385t() && (m15571a = C4278hr.m15571a(this.f16077a, c4266hf.f16077a)) != 0) {
            return m15571a;
        }
        int compareTo21 = Boolean.valueOf(m15386u()).compareTo(Boolean.valueOf(c4266hf.m15386u()));
        if (compareTo21 != 0) {
            return compareTo21;
        }
        if (m15386u() && (m15578a3 = C4278hr.m15578a(this.f16082a, c4266hf.f16082a)) != 0) {
            return m15578a3;
        }
        int compareTo22 = Boolean.valueOf(m15387v()).compareTo(Boolean.valueOf(c4266hf.m15387v()));
        if (compareTo22 != 0) {
            return compareTo22;
        }
        if (m15387v() && (m15570a2 = C4278hr.m15570a(this.f16076a, c4266hf.f16076a)) != 0) {
            return m15570a2;
        }
        int compareTo23 = Boolean.valueOf(m15388w()).compareTo(Boolean.valueOf(c4266hf.m15388w()));
        if (compareTo23 != 0) {
            return compareTo23;
        }
        if (m15388w() && (m15570a = C4278hr.m15570a(this.f16084b, c4266hf.f16084b)) != 0) {
            return m15570a;
        }
        int compareTo24 = Boolean.valueOf(m15389x()).compareTo(Boolean.valueOf(c4266hf.m15389x()));
        if (compareTo24 != 0) {
            return compareTo24;
        }
        if (m15389x() && (m15572a3 = C4278hr.m15572a(this.f16102p, c4266hf.f16102p)) != 0) {
            return m15572a3;
        }
        int compareTo25 = Boolean.valueOf(m15390y()).compareTo(Boolean.valueOf(c4266hf.m15390y()));
        if (compareTo25 != 0) {
            return compareTo25;
        }
        if (m15390y() && (m15572a2 = C4278hr.m15572a(this.f16103q, c4266hf.f16103q)) != 0) {
            return m15572a2;
        }
        int compareTo26 = Boolean.valueOf(m15391z()).compareTo(Boolean.valueOf(c4266hf.m15391z()));
        if (compareTo26 != 0) {
            return compareTo26;
        }
        if (m15391z() && (m15578a2 = C4278hr.m15578a(this.f16086b, c4266hf.f16086b)) != 0) {
            return m15578a2;
        }
        int compareTo27 = Boolean.valueOf(m15336A()).compareTo(Boolean.valueOf(c4266hf.m15336A()));
        if (compareTo27 != 0) {
            return compareTo27;
        }
        if (m15336A() && (m15575a = C4278hr.m15575a(this.f16081a, c4266hf.f16081a)) != 0) {
            return m15575a;
        }
        int compareTo28 = Boolean.valueOf(m15337B()).compareTo(Boolean.valueOf(c4266hf.m15337B()));
        if (compareTo28 != 0) {
            return compareTo28;
        }
        if (m15337B() && (m15578a = C4278hr.m15578a(this.f16089c, c4266hf.f16089c)) != 0) {
            return m15578a;
        }
        int compareTo29 = Boolean.valueOf(m15338C()).compareTo(Boolean.valueOf(c4266hf.m15338C()));
        if (compareTo29 != 0) {
            return compareTo29;
        }
        if (!m15338C() || (m15572a = C4278hr.m15572a(this.f16104r, c4266hf.f16104r)) == 0) {
            return 0;
        }
        return m15572a;
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
                m15344a();
                return;
            }
            short s = mo15594a.f16333a;
            switch (s) {
                case 1:
                    if (b2 == 11) {
                        this.f16079a = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        this.f16078a = new C4254gu();
                        this.f16078a.mo14606a(abstractC4288ia);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f16085b = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f16088c = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f16090d = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f16091e = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f16092f = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f16093g = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f16094h = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f16095i = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 11:
                    if (b2 == 11) {
                        this.f16096j = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 12:
                    if (b2 == 11) {
                        this.f16097k = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 13:
                    if (b2 == 8) {
                        this.f16075a = abstractC4288ia.mo15592a();
                        m15345a(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 14:
                    if (b2 == 8) {
                        this.f16083b = abstractC4288ia.mo15592a();
                        m15351b(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 15:
                    if (b2 == 11) {
                        this.f16098l = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 16:
                    if (b2 == 11) {
                        this.f16099m = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 17:
                    if (b2 == 11) {
                        this.f16100n = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 18:
                    if (b2 == 11) {
                        this.f16101o = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 19:
                    if (b2 == 8) {
                        this.f16087c = abstractC4288ia.mo15592a();
                        m15356c(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 20:
                    if (b2 == 8) {
                        this.f16077a = EnumC4253gt.m15132a(abstractC4288ia.mo15592a());
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 21:
                    if (b2 == 2) {
                        this.f16082a = abstractC4288ia.mo15615a();
                        m15359d(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 22:
                    if (b2 == 10) {
                        this.f16076a = abstractC4288ia.mo15593a();
                        m15362e(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 23:
                    if (b2 == 10) {
                        this.f16084b = abstractC4288ia.mo15593a();
                        m15365f(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 24:
                    if (b2 == 11) {
                        this.f16102p = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 25:
                    if (b2 == 11) {
                        this.f16103q = abstractC4288ia.mo15599a();
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                case 26:
                    if (b2 == 2) {
                        this.f16086b = abstractC4288ia.mo15615a();
                        m15368g(true);
                        break;
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                        break;
                    }
                default:
                    switch (s) {
                        case 100:
                            if (b2 == 13) {
                                C4286hz mo15596a = abstractC4288ia.mo15596a();
                                this.f16081a = new HashMap(mo15596a.f16337a * 2);
                                for (int i2 = 0; i2 < mo15596a.f16337a; i2++) {
                                    this.f16081a.put(abstractC4288ia.mo15599a(), abstractC4288ia.mo15599a());
                                }
                                abstractC4288ia.mo15624h();
                                break;
                            } else {
                                C4291id.m15660a(abstractC4288ia, b2);
                                break;
                            }
                        case 101:
                            if (b2 == 2) {
                                this.f16089c = abstractC4288ia.mo15615a();
                                m15371h(true);
                                break;
                            } else {
                                C4291id.m15660a(abstractC4288ia, b2);
                                break;
                            }
                        case 102:
                            if (b2 == 11) {
                                this.f16104r = abstractC4288ia.mo15599a();
                                break;
                            } else {
                                C4291id.m15660a(abstractC4288ia, b2);
                                break;
                            }
                        default:
                            C4291id.m15660a(abstractC4288ia, b2);
                            break;
                    }
            }
            abstractC4288ia.mo15623g();
        }
    }

    /* renamed from: a */
    public void m15344a() {
        if (this.f16085b != null) {
            if (this.f16088c != null) {
                if (this.f16092f != null) {
                    return;
                }
                throw new C4289ib("Required field 'token' was not present! Struct: " + toString());
            }
            throw new C4289ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new C4289ib("Required field 'id' was not present! Struct: " + toString());
    }
}
