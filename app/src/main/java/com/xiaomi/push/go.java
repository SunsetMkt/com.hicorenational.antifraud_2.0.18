package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class go implements hq<go, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public int f592a;

    /* renamed from: a, reason: collision with other field name */
    public gl f593a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f594a = new BitSet(1);

    /* renamed from: a, reason: collision with other field name */
    public List<gq> f595a;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f591a = new Cif("NormalConfig");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f12983a = new hx("", (byte) 8, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f12984b = new hx("", com.umeng.analytics.pro.cw.f10303m, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f12985c = new hx("", (byte) 8, 3);

    public int a() {
        return this.f592a;
    }

    public boolean b() {
        return this.f595a != null;
    }

    public boolean c() {
        return this.f593a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof go)) {
            return m479a((go) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f592a);
        sb.append(", ");
        sb.append("configItems:");
        List<gq> list = this.f595a;
        if (list == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(list);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            gl glVar = this.f593a;
            if (glVar == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(glVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m478a() {
        return this.f594a.get(0);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        m477a();
        iaVar.a(f591a);
        iaVar.a(f12983a);
        iaVar.mo612a(this.f592a);
        iaVar.b();
        if (this.f595a != null) {
            iaVar.a(f12984b);
            iaVar.a(new hy((byte) 12, this.f595a.size()));
            Iterator<gq> it = this.f595a.iterator();
            while (it.hasNext()) {
                it.next().b(iaVar);
            }
            iaVar.e();
            iaVar.b();
        }
        if (this.f593a != null && c()) {
            iaVar.a(f12985c);
            iaVar.mo612a(this.f593a.a());
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    public void a(boolean z) {
        this.f594a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public gl m476a() {
        return this.f593a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m479a(go goVar) {
        if (goVar == null || this.f592a != goVar.f592a) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = goVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f595a.equals(goVar.f595a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = goVar.c();
        if (c2 || c3) {
            return c2 && c3 && this.f593a.equals(goVar.f593a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(go goVar) {
        int a2;
        int a3;
        int a4;
        if (!go.class.equals(goVar.getClass())) {
            return go.class.getName().compareTo(goVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m478a()).compareTo(Boolean.valueOf(goVar.m478a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m478a() && (a4 = hr.a(this.f592a, goVar.f592a)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(goVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a3 = hr.a(this.f595a, goVar.f595a)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(goVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (a2 = hr.a(this.f593a, goVar.f593a)) == 0) {
            return 0;
        }
        return a2;
    }

    @Override // com.xiaomi.push.hq
    public void a(ia iaVar) {
        iaVar.mo607a();
        while (true) {
            hx mo603a = iaVar.mo603a();
            byte b2 = mo603a.f13224a;
            if (b2 == 0) {
                break;
            }
            short s = mo603a.f898a;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        id.a(iaVar, b2);
                    } else if (b2 == 8) {
                        this.f593a = gl.a(iaVar.mo601a());
                    } else {
                        id.a(iaVar, b2);
                    }
                } else if (b2 == 15) {
                    hy mo604a = iaVar.mo604a();
                    this.f595a = new ArrayList(mo604a.f899a);
                    for (int i2 = 0; i2 < mo604a.f899a; i2++) {
                        gq gqVar = new gq();
                        gqVar.a(iaVar);
                        this.f595a.add(gqVar);
                    }
                    iaVar.i();
                } else {
                    id.a(iaVar, b2);
                }
            } else if (b2 == 8) {
                this.f592a = iaVar.mo601a();
                a(true);
            } else {
                id.a(iaVar, b2);
            }
            iaVar.g();
        }
        iaVar.f();
        if (m478a()) {
            m477a();
            return;
        }
        throw new ib("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m477a() {
        if (this.f595a != null) {
            return;
        }
        throw new ib("Required field 'configItems' was not present! Struct: " + toString());
    }
}
