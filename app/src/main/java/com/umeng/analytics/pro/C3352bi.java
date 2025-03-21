package com.umeng.analytics.pro;

import com.hihonor.honorid.core.data.UserInfo;
import com.tencent.open.SocialOperation;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: UMEnvelope.java */
/* renamed from: com.umeng.analytics.pro.bi */
/* loaded from: classes2.dex */
public class C3352bi implements InterfaceC3360bq<C3352bi, e>, Serializable, Cloneable {

    /* renamed from: A */
    private static final int f11673A = 2;

    /* renamed from: B */
    private static final int f11674B = 3;

    /* renamed from: k */
    public static final Map<e, C3373cc> f11675k;

    /* renamed from: l */
    private static final long f11676l = 420342210744516016L;

    /* renamed from: m */
    private static final C3391cu f11677m = new C3391cu("UMEnvelope");

    /* renamed from: n */
    private static final C3381ck f11678n = new C3381ck("version", (byte) 11, 1);

    /* renamed from: o */
    private static final C3381ck f11679o = new C3381ck(UserInfo.ADDRESS, (byte) 11, 2);

    /* renamed from: p */
    private static final C3381ck f11680p = new C3381ck(SocialOperation.GAME_SIGNATURE, (byte) 11, 3);

    /* renamed from: q */
    private static final C3381ck f11681q = new C3381ck("serial_num", (byte) 8, 4);

    /* renamed from: r */
    private static final C3381ck f11682r = new C3381ck("ts_secs", (byte) 8, 5);

    /* renamed from: s */
    private static final C3381ck f11683s = new C3381ck("length", (byte) 8, 6);

    /* renamed from: t */
    private static final C3381ck f11684t = new C3381ck("entity", (byte) 11, 7);

    /* renamed from: u */
    private static final C3381ck f11685u = new C3381ck("guid", (byte) 11, 8);

    /* renamed from: v */
    private static final C3381ck f11686v = new C3381ck("checksum", (byte) 11, 9);

    /* renamed from: w */
    private static final C3381ck f11687w = new C3381ck("codex", (byte) 8, 10);

    /* renamed from: x */
    private static final Map<Class<? extends InterfaceC3394cx>, InterfaceC3395cy> f11688x = new HashMap();

    /* renamed from: y */
    private static final int f11689y = 0;

    /* renamed from: z */
    private static final int f11690z = 1;

    /* renamed from: C */
    private byte f11691C;

    /* renamed from: D */
    private e[] f11692D;

    /* renamed from: a */
    public String f11693a;

    /* renamed from: b */
    public String f11694b;

    /* renamed from: c */
    public String f11695c;

    /* renamed from: d */
    public int f11696d;

    /* renamed from: e */
    public int f11697e;

    /* renamed from: f */
    public int f11698f;

    /* renamed from: g */
    public ByteBuffer f11699g;

    /* renamed from: h */
    public String f11700h;

    /* renamed from: i */
    public String f11701i;

    /* renamed from: j */
    public int f11702j;

    /* compiled from: UMEnvelope.java */
    /* renamed from: com.umeng.analytics.pro.bi$a */
    private static class a extends AbstractC3396cz<C3352bi> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo10975b(AbstractC3386cp abstractC3386cp, C3352bi c3352bi) throws C3366bw {
            abstractC3386cp.mo11137j();
            while (true) {
                C3381ck mo11139l = abstractC3386cp.mo11139l();
                byte b2 = mo11139l.f11834b;
                if (b2 == 0) {
                    abstractC3386cp.mo11138k();
                    if (!c3352bi.m10958m()) {
                        throw new C3387cq("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    }
                    if (!c3352bi.m10961p()) {
                        throw new C3387cq("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    }
                    if (c3352bi.m10964s()) {
                        c3352bi.m10923G();
                        return;
                    }
                    throw new C3387cq("Required field 'length' was not found in serialized data! Struct: " + toString());
                }
                switch (mo11139l.f11835c) {
                    case 1:
                        if (b2 != 11) {
                            C3389cs.m11183a(abstractC3386cp, b2);
                            break;
                        } else {
                            c3352bi.f11693a = abstractC3386cp.mo11153z();
                            c3352bi.m10929a(true);
                            break;
                        }
                    case 2:
                        if (b2 != 11) {
                            C3389cs.m11183a(abstractC3386cp, b2);
                            break;
                        } else {
                            c3352bi.f11694b = abstractC3386cp.mo11153z();
                            c3352bi.m10933b(true);
                            break;
                        }
                    case 3:
                        if (b2 != 11) {
                            C3389cs.m11183a(abstractC3386cp, b2);
                            break;
                        } else {
                            c3352bi.f11695c = abstractC3386cp.mo11153z();
                            c3352bi.m10937c(true);
                            break;
                        }
                    case 4:
                        if (b2 != 8) {
                            C3389cs.m11183a(abstractC3386cp, b2);
                            break;
                        } else {
                            c3352bi.f11696d = abstractC3386cp.mo11150w();
                            c3352bi.m10940d(true);
                            break;
                        }
                    case 5:
                        if (b2 != 8) {
                            C3389cs.m11183a(abstractC3386cp, b2);
                            break;
                        } else {
                            c3352bi.f11697e = abstractC3386cp.mo11150w();
                            c3352bi.m10945e(true);
                            break;
                        }
                    case 6:
                        if (b2 != 8) {
                            C3389cs.m11183a(abstractC3386cp, b2);
                            break;
                        } else {
                            c3352bi.f11698f = abstractC3386cp.mo11150w();
                            c3352bi.m10947f(true);
                            break;
                        }
                    case 7:
                        if (b2 != 11) {
                            C3389cs.m11183a(abstractC3386cp, b2);
                            break;
                        } else {
                            c3352bi.f11699g = abstractC3386cp.mo11110A();
                            c3352bi.m10948g(true);
                            break;
                        }
                    case 8:
                        if (b2 != 11) {
                            C3389cs.m11183a(abstractC3386cp, b2);
                            break;
                        } else {
                            c3352bi.f11700h = abstractC3386cp.mo11153z();
                            c3352bi.m10951h(true);
                            break;
                        }
                    case 9:
                        if (b2 != 11) {
                            C3389cs.m11183a(abstractC3386cp, b2);
                            break;
                        } else {
                            c3352bi.f11701i = abstractC3386cp.mo11153z();
                            c3352bi.m10953i(true);
                            break;
                        }
                    case 10:
                        if (b2 != 8) {
                            C3389cs.m11183a(abstractC3386cp, b2);
                            break;
                        } else {
                            c3352bi.f11702j = abstractC3386cp.mo11150w();
                            c3352bi.m10954j(true);
                            break;
                        }
                    default:
                        C3389cs.m11183a(abstractC3386cp, b2);
                        break;
                }
                abstractC3386cp.mo11140m();
            }
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo10973a(AbstractC3386cp abstractC3386cp, C3352bi c3352bi) throws C3366bw {
            c3352bi.m10923G();
            abstractC3386cp.mo11121a(C3352bi.f11677m);
            if (c3352bi.f11693a != null) {
                abstractC3386cp.mo11116a(C3352bi.f11678n);
                abstractC3386cp.mo11122a(c3352bi.f11693a);
                abstractC3386cp.mo11128c();
            }
            if (c3352bi.f11694b != null) {
                abstractC3386cp.mo11116a(C3352bi.f11679o);
                abstractC3386cp.mo11122a(c3352bi.f11694b);
                abstractC3386cp.mo11128c();
            }
            if (c3352bi.f11695c != null) {
                abstractC3386cp.mo11116a(C3352bi.f11680p);
                abstractC3386cp.mo11122a(c3352bi.f11695c);
                abstractC3386cp.mo11128c();
            }
            abstractC3386cp.mo11116a(C3352bi.f11681q);
            abstractC3386cp.mo11114a(c3352bi.f11696d);
            abstractC3386cp.mo11128c();
            abstractC3386cp.mo11116a(C3352bi.f11682r);
            abstractC3386cp.mo11114a(c3352bi.f11697e);
            abstractC3386cp.mo11128c();
            abstractC3386cp.mo11116a(C3352bi.f11683s);
            abstractC3386cp.mo11114a(c3352bi.f11698f);
            abstractC3386cp.mo11128c();
            if (c3352bi.f11699g != null) {
                abstractC3386cp.mo11116a(C3352bi.f11684t);
                abstractC3386cp.mo11123a(c3352bi.f11699g);
                abstractC3386cp.mo11128c();
            }
            if (c3352bi.f11700h != null) {
                abstractC3386cp.mo11116a(C3352bi.f11685u);
                abstractC3386cp.mo11122a(c3352bi.f11700h);
                abstractC3386cp.mo11128c();
            }
            if (c3352bi.f11701i != null) {
                abstractC3386cp.mo11116a(C3352bi.f11686v);
                abstractC3386cp.mo11122a(c3352bi.f11701i);
                abstractC3386cp.mo11128c();
            }
            if (c3352bi.m10922F()) {
                abstractC3386cp.mo11116a(C3352bi.f11687w);
                abstractC3386cp.mo11114a(c3352bi.f11702j);
                abstractC3386cp.mo11128c();
            }
            abstractC3386cp.mo11130d();
            abstractC3386cp.mo11127b();
        }
    }

    /* compiled from: UMEnvelope.java */
    /* renamed from: com.umeng.analytics.pro.bi$b */
    private static class b implements InterfaceC3395cy {
        private b() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3395cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a mo10977b() {
            return new a();
        }
    }

    /* compiled from: UMEnvelope.java */
    /* renamed from: com.umeng.analytics.pro.bi$c */
    private static class c extends AbstractC3398da<C3352bi> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo10973a(AbstractC3386cp abstractC3386cp, C3352bi c3352bi) throws C3366bw {
            C3392cv c3392cv = (C3392cv) abstractC3386cp;
            c3392cv.mo11122a(c3352bi.f11693a);
            c3392cv.mo11122a(c3352bi.f11694b);
            c3392cv.mo11122a(c3352bi.f11695c);
            c3392cv.mo11114a(c3352bi.f11696d);
            c3392cv.mo11114a(c3352bi.f11697e);
            c3392cv.mo11114a(c3352bi.f11698f);
            c3392cv.mo11123a(c3352bi.f11699g);
            c3392cv.mo11122a(c3352bi.f11700h);
            c3392cv.mo11122a(c3352bi.f11701i);
            BitSet bitSet = new BitSet();
            if (c3352bi.m10922F()) {
                bitSet.set(0);
            }
            c3392cv.m11187a(bitSet, 1);
            if (c3352bi.m10922F()) {
                c3392cv.mo11114a(c3352bi.f11702j);
            }
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo10975b(AbstractC3386cp abstractC3386cp, C3352bi c3352bi) throws C3366bw {
            C3392cv c3392cv = (C3392cv) abstractC3386cp;
            c3352bi.f11693a = c3392cv.mo11153z();
            c3352bi.m10929a(true);
            c3352bi.f11694b = c3392cv.mo11153z();
            c3352bi.m10933b(true);
            c3352bi.f11695c = c3392cv.mo11153z();
            c3352bi.m10937c(true);
            c3352bi.f11696d = c3392cv.mo11150w();
            c3352bi.m10940d(true);
            c3352bi.f11697e = c3392cv.mo11150w();
            c3352bi.m10945e(true);
            c3352bi.f11698f = c3392cv.mo11150w();
            c3352bi.m10947f(true);
            c3352bi.f11699g = c3392cv.mo11110A();
            c3352bi.m10948g(true);
            c3352bi.f11700h = c3392cv.mo11153z();
            c3352bi.m10951h(true);
            c3352bi.f11701i = c3392cv.mo11153z();
            c3352bi.m10953i(true);
            if (c3392cv.m11188b(1).get(0)) {
                c3352bi.f11702j = c3392cv.mo11150w();
                c3352bi.m10954j(true);
            }
        }
    }

    /* compiled from: UMEnvelope.java */
    /* renamed from: com.umeng.analytics.pro.bi$d */
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
        f11688x.put(AbstractC3396cz.class, new b());
        f11688x.put(AbstractC3398da.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.VERSION, (e) new C3373cc("version", (byte) 1, new C3374cd((byte) 11)));
        enumMap.put((EnumMap) e.ADDRESS, (e) new C3373cc(UserInfo.ADDRESS, (byte) 1, new C3374cd((byte) 11)));
        enumMap.put((EnumMap) e.SIGNATURE, (e) new C3373cc(SocialOperation.GAME_SIGNATURE, (byte) 1, new C3374cd((byte) 11)));
        enumMap.put((EnumMap) e.SERIAL_NUM, (e) new C3373cc("serial_num", (byte) 1, new C3374cd((byte) 8)));
        enumMap.put((EnumMap) e.TS_SECS, (e) new C3373cc("ts_secs", (byte) 1, new C3374cd((byte) 8)));
        enumMap.put((EnumMap) e.LENGTH, (e) new C3373cc("length", (byte) 1, new C3374cd((byte) 8)));
        enumMap.put((EnumMap) e.ENTITY, (e) new C3373cc("entity", (byte) 1, new C3374cd((byte) 11, true)));
        enumMap.put((EnumMap) e.GUID, (e) new C3373cc("guid", (byte) 1, new C3374cd((byte) 11)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new C3373cc("checksum", (byte) 1, new C3374cd((byte) 11)));
        enumMap.put((EnumMap) e.CODEX, (e) new C3373cc("codex", (byte) 2, new C3374cd((byte) 8)));
        f11675k = Collections.unmodifiableMap(enumMap);
        C3373cc.m11103a(C3352bi.class, f11675k);
    }

    public C3352bi() {
        this.f11691C = (byte) 0;
        this.f11692D = new e[]{e.CODEX};
    }

    /* renamed from: A */
    public String m10917A() {
        return this.f11701i;
    }

    /* renamed from: B */
    public void m10918B() {
        this.f11701i = null;
    }

    /* renamed from: C */
    public boolean m10919C() {
        return this.f11701i != null;
    }

    /* renamed from: D */
    public int m10920D() {
        return this.f11702j;
    }

    /* renamed from: E */
    public void m10921E() {
        this.f11691C = C3357bn.m11021b(this.f11691C, 3);
    }

    /* renamed from: F */
    public boolean m10922F() {
        return C3357bn.m11017a(this.f11691C, 3);
    }

    /* renamed from: G */
    public void m10923G() throws C3366bw {
        if (this.f11693a == null) {
            throw new C3387cq("Required field 'version' was not present! Struct: " + toString());
        }
        if (this.f11694b == null) {
            throw new C3387cq("Required field 'address' was not present! Struct: " + toString());
        }
        if (this.f11695c == null) {
            throw new C3387cq("Required field 'signature' was not present! Struct: " + toString());
        }
        if (this.f11699g == null) {
            throw new C3387cq("Required field 'entity' was not present! Struct: " + toString());
        }
        if (this.f11700h == null) {
            throw new C3387cq("Required field 'guid' was not present! Struct: " + toString());
        }
        if (this.f11701i != null) {
            return;
        }
        throw new C3387cq("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C3352bi deepCopy() {
        return new C3352bi(this);
    }

    /* renamed from: b */
    public String m10932b() {
        return this.f11693a;
    }

    /* renamed from: c */
    public void m10936c() {
        this.f11693a = null;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void clear() {
        this.f11693a = null;
        this.f11694b = null;
        this.f11695c = null;
        m10940d(false);
        this.f11696d = 0;
        m10945e(false);
        this.f11697e = 0;
        m10947f(false);
        this.f11698f = 0;
        this.f11699g = null;
        this.f11700h = null;
        this.f11701i = null;
        m10954j(false);
        this.f11702j = 0;
    }

    /* renamed from: d */
    public boolean m10941d() {
        return this.f11693a != null;
    }

    /* renamed from: e */
    public String m10944e() {
        return this.f11694b;
    }

    /* renamed from: f */
    public void m10946f() {
        this.f11694b = null;
    }

    /* renamed from: g */
    public boolean m10949g() {
        return this.f11694b != null;
    }

    /* renamed from: h */
    public String m10950h() {
        return this.f11695c;
    }

    /* renamed from: i */
    public void m10952i() {
        this.f11695c = null;
    }

    /* renamed from: j */
    public boolean m10955j() {
        return this.f11695c != null;
    }

    /* renamed from: k */
    public int m10956k() {
        return this.f11696d;
    }

    /* renamed from: l */
    public void m10957l() {
        this.f11691C = C3357bn.m11021b(this.f11691C, 0);
    }

    /* renamed from: m */
    public boolean m10958m() {
        return C3357bn.m11017a(this.f11691C, 0);
    }

    /* renamed from: n */
    public int m10959n() {
        return this.f11697e;
    }

    /* renamed from: o */
    public void m10960o() {
        this.f11691C = C3357bn.m11021b(this.f11691C, 1);
    }

    /* renamed from: p */
    public boolean m10961p() {
        return C3357bn.m11017a(this.f11691C, 1);
    }

    /* renamed from: q */
    public int m10962q() {
        return this.f11698f;
    }

    /* renamed from: r */
    public void m10963r() {
        this.f11691C = C3357bn.m11021b(this.f11691C, 2);
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void read(AbstractC3386cp abstractC3386cp) throws C3366bw {
        f11688x.get(abstractC3386cp.mo11179D()).mo10977b().mo10975b(abstractC3386cp, this);
    }

    /* renamed from: s */
    public boolean m10964s() {
        return C3357bn.m11017a(this.f11691C, 2);
    }

    /* renamed from: t */
    public byte[] m10965t() {
        m10927a(C3361br.m11052c(this.f11699g));
        ByteBuffer byteBuffer = this.f11699g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        String str = this.f11693a;
        if (str == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.f11694b;
        if (str2 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.f11695c;
        if (str3 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.f11696d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.f11697e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f11698f);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.f11699g;
        if (byteBuffer == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            C3361br.m11048a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.f11700h;
        if (str4 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        String str5 = this.f11701i;
        if (str5 == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str5);
        }
        if (m10922F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.f11702j);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: u */
    public ByteBuffer m10966u() {
        return this.f11699g;
    }

    /* renamed from: v */
    public void m10967v() {
        this.f11699g = null;
    }

    /* renamed from: w */
    public boolean m10968w() {
        return this.f11699g != null;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void write(AbstractC3386cp abstractC3386cp) throws C3366bw {
        f11688x.get(abstractC3386cp.mo11179D()).mo10977b().mo10973a(abstractC3386cp, this);
    }

    /* renamed from: x */
    public String m10969x() {
        return this.f11700h;
    }

    /* renamed from: y */
    public void m10970y() {
        this.f11700h = null;
    }

    /* renamed from: z */
    public boolean m10971z() {
        return this.f11700h != null;
    }

    /* compiled from: UMEnvelope.java */
    /* renamed from: com.umeng.analytics.pro.bi$e */
    public enum e implements InterfaceC3367bx {
        VERSION(1, "version"),
        ADDRESS(2, UserInfo.ADDRESS),
        SIGNATURE(3, SocialOperation.GAME_SIGNATURE),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");


        /* renamed from: k */
        private static final Map<String, e> f11713k = new HashMap();

        /* renamed from: l */
        private final short f11715l;

        /* renamed from: m */
        private final String f11716m;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f11713k.put(eVar.mo10985b(), eVar);
            }
        }

        e(short s, String str) {
            this.f11715l = s;
            this.f11716m = str;
        }

        /* renamed from: a */
        public static e m10981a(int i2) {
            switch (i2) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static e m10983b(int i2) {
            e m10981a = m10981a(i2);
            if (m10981a != null) {
                return m10981a;
            }
            throw new IllegalArgumentException("Field " + i2 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.InterfaceC3367bx
        /* renamed from: b */
        public String mo10985b() {
            return this.f11716m;
        }

        /* renamed from: a */
        public static e m10982a(String str) {
            return f11713k.get(str);
        }

        @Override // com.umeng.analytics.pro.InterfaceC3367bx
        /* renamed from: a */
        public short mo10984a() {
            return this.f11715l;
        }
    }

    /* renamed from: a */
    public C3352bi m10926a(String str) {
        this.f11693a = str;
        return this;
    }

    /* renamed from: b */
    public C3352bi m10931b(String str) {
        this.f11694b = str;
        return this;
    }

    /* renamed from: c */
    public C3352bi m10935c(String str) {
        this.f11695c = str;
        return this;
    }

    /* renamed from: d */
    public void m10940d(boolean z) {
        this.f11691C = C3357bn.m11009a(this.f11691C, 0, z);
    }

    /* renamed from: e */
    public void m10945e(boolean z) {
        this.f11691C = C3357bn.m11009a(this.f11691C, 1, z);
    }

    /* renamed from: f */
    public void m10947f(boolean z) {
        this.f11691C = C3357bn.m11009a(this.f11691C, 2, z);
    }

    /* renamed from: g */
    public void m10948g(boolean z) {
        if (z) {
            return;
        }
        this.f11699g = null;
    }

    /* renamed from: h */
    public void m10951h(boolean z) {
        if (z) {
            return;
        }
        this.f11700h = null;
    }

    /* renamed from: i */
    public void m10953i(boolean z) {
        if (z) {
            return;
        }
        this.f11701i = null;
    }

    /* renamed from: j */
    public void m10954j(boolean z) {
        this.f11691C = C3357bn.m11009a(this.f11691C, 3, z);
    }

    /* renamed from: a */
    public void m10929a(boolean z) {
        if (z) {
            return;
        }
        this.f11693a = null;
    }

    /* renamed from: b */
    public void m10933b(boolean z) {
        if (z) {
            return;
        }
        this.f11694b = null;
    }

    /* renamed from: c */
    public void m10937c(boolean z) {
        if (z) {
            return;
        }
        this.f11695c = null;
    }

    /* renamed from: d */
    public C3352bi m10939d(String str) {
        this.f11700h = str;
        return this;
    }

    /* renamed from: e */
    public C3352bi m10943e(String str) {
        this.f11701i = str;
        return this;
    }

    public C3352bi(String str, String str2, String str3, int i2, int i3, int i4, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f11693a = str;
        this.f11694b = str2;
        this.f11695c = str3;
        this.f11696d = i2;
        m10940d(true);
        this.f11697e = i3;
        m10945e(true);
        this.f11698f = i4;
        m10947f(true);
        this.f11699g = byteBuffer;
        this.f11700h = str4;
        this.f11701i = str5;
    }

    /* renamed from: a */
    public C3352bi m10925a(int i2) {
        this.f11696d = i2;
        m10940d(true);
        return this;
    }

    /* renamed from: b */
    public C3352bi m10930b(int i2) {
        this.f11697e = i2;
        m10945e(true);
        return this;
    }

    /* renamed from: c */
    public C3352bi m10934c(int i2) {
        this.f11698f = i2;
        m10947f(true);
        return this;
    }

    /* renamed from: d */
    public C3352bi m10938d(int i2) {
        this.f11702j = i2;
        m10954j(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.m10981a(i2);
    }

    /* renamed from: a */
    public C3352bi m10928a(byte[] bArr) {
        m10927a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    /* renamed from: a */
    public C3352bi m10927a(ByteBuffer byteBuffer) {
        this.f11699g = byteBuffer;
        return this;
    }

    /* renamed from: a */
    private void m10916a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new C3380cj(new C3399db(objectOutputStream)));
        } catch (C3366bw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* renamed from: a */
    private void m10915a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f11691C = (byte) 0;
            read(new C3380cj(new C3399db(objectInputStream)));
        } catch (C3366bw e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public C3352bi(C3352bi c3352bi) {
        this.f11691C = (byte) 0;
        this.f11692D = new e[]{e.CODEX};
        this.f11691C = c3352bi.f11691C;
        if (c3352bi.m10941d()) {
            this.f11693a = c3352bi.f11693a;
        }
        if (c3352bi.m10949g()) {
            this.f11694b = c3352bi.f11694b;
        }
        if (c3352bi.m10955j()) {
            this.f11695c = c3352bi.f11695c;
        }
        this.f11696d = c3352bi.f11696d;
        this.f11697e = c3352bi.f11697e;
        this.f11698f = c3352bi.f11698f;
        if (c3352bi.m10968w()) {
            this.f11699g = C3361br.m11053d(c3352bi.f11699g);
        }
        if (c3352bi.m10971z()) {
            this.f11700h = c3352bi.f11700h;
        }
        if (c3352bi.m10919C()) {
            this.f11701i = c3352bi.f11701i;
        }
        this.f11702j = c3352bi.f11702j;
    }
}
