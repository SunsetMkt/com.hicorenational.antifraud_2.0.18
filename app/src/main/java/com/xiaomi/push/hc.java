package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class hc implements hq<hc, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<gq> f727a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f726a = new Cif("XmPushActionCustomConfig");
    private static final hx a = new hx("", com.umeng.analytics.pro.cw.f7205m, 1);

    public List<gq> a() {
        return this.f727a;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m536a();
        iaVar.a(f726a);
        if (this.f727a != null) {
            iaVar.a(a);
            iaVar.a(new hy((byte) 12, this.f727a.size()));
            Iterator<gq> it = this.f727a.iterator();
            while (it.hasNext()) {
                it.next().b(iaVar);
            }
            iaVar.e();
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo609a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hc)) {
            return m538a((hc) obj);
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
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m537a() {
        return this.f727a != null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m538a(hc hcVar) {
        if (hcVar == null) {
            return false;
        }
        boolean zM537a = m537a();
        boolean zM537a2 = hcVar.m537a();
        if (zM537a || zM537a2) {
            return zM537a && zM537a2 && this.f727a.equals(hcVar.f727a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hc hcVar) {
        int iA;
        if (!hc.class.equals(hcVar.getClass())) {
            return hc.class.getName().compareTo(hcVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m537a()).compareTo(Boolean.valueOf(hcVar.m537a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (!m537a() || (iA = hr.a(this.f727a, hcVar.f727a)) == 0) {
            return 0;
        }
        return iA;
    }

    @Override // com.xiaomi.push.hq
    public void a(ia iaVar) throws ib {
        iaVar.mo605a();
        while (true) {
            hx hxVarMo601a = iaVar.mo601a();
            byte b2 = hxVarMo601a.a;
            if (b2 == 0) {
                iaVar.f();
                m536a();
                return;
            }
            if (hxVarMo601a.f898a != 1) {
                id.a(iaVar, b2);
            } else if (b2 == 15) {
                hy hyVarMo602a = iaVar.mo602a();
                this.f727a = new ArrayList(hyVarMo602a.f899a);
                for (int i2 = 0; i2 < hyVarMo602a.f899a; i2++) {
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

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m536a() throws ib {
        if (this.f727a != null) {
            return;
        }
        throw new ib("Required field 'customConfigs' was not present! Struct: " + toString());
    }
}
