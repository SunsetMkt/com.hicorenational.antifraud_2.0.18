package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class hc implements hq<hc, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public List<gq> f727a;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f726a = new Cif("XmPushActionCustomConfig");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13096a = new hx("", com.umeng.analytics.pro.cw.f10303m, 1);

    public List<gq> a() {
        return this.f727a;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        m538a();
        iaVar.a(f726a);
        if (this.f727a != null) {
            iaVar.a(f13096a);
            iaVar.a(new hy((byte) 12, this.f727a.size()));
            Iterator<gq> it = this.f727a.iterator();
            while (it.hasNext()) {
                it.next().b(iaVar);
            }
            iaVar.e();
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hc)) {
            return m540a((hc) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        List<gq> list = this.f727a;
        if (list == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m539a() {
        return this.f727a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m540a(hc hcVar) {
        if (hcVar == null) {
            return false;
        }
        boolean m539a = m539a();
        boolean m539a2 = hcVar.m539a();
        if (m539a || m539a2) {
            return m539a && m539a2 && this.f727a.equals(hcVar.f727a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hc hcVar) {
        int a2;
        if (!hc.class.equals(hcVar.getClass())) {
            return hc.class.getName().compareTo(hcVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m539a()).compareTo(Boolean.valueOf(hcVar.m539a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m539a() || (a2 = hr.a(this.f727a, hcVar.f727a)) == 0) {
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
                iaVar.f();
                m538a();
                return;
            }
            if (mo603a.f898a != 1) {
                id.a(iaVar, b2);
            } else if (b2 == 15) {
                hy mo604a = iaVar.mo604a();
                this.f727a = new ArrayList(mo604a.f899a);
                for (int i2 = 0; i2 < mo604a.f899a; i2++) {
                    gq gqVar = new gq();
                    gqVar.a(iaVar);
                    this.f727a.add(gqVar);
                }
                iaVar.i();
            } else {
                id.a(iaVar, b2);
            }
            iaVar.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m538a() {
        if (this.f727a != null) {
            return;
        }
        throw new ib("Required field 'customConfigs' was not present! Struct: " + toString());
    }
}
