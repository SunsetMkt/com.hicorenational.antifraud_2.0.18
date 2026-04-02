package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class hd implements hq<hd, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<go> f729a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f728a = new Cif("XmPushActionNormalConfig");
    private static final hx a = new hx("", com.umeng.analytics.pro.cw.f7205m, 1);

    public List<go> a() {
        return this.f729a;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m539a();
        iaVar.a(f728a);
        if (this.f729a != null) {
            iaVar.a(a);
            iaVar.a(new hy((byte) 12, this.f729a.size()));
            Iterator<go> it = this.f729a.iterator();
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
        if (obj != null && (obj instanceof hd)) {
            return m541a((hd) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        List<go> list = this.f729a;
        if (list == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m540a() {
        return this.f729a != null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m541a(hd hdVar) {
        if (hdVar == null) {
            return false;
        }
        boolean zM540a = m540a();
        boolean zM540a2 = hdVar.m540a();
        if (zM540a || zM540a2) {
            return zM540a && zM540a2 && this.f729a.equals(hdVar.f729a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hd hdVar) {
        int iA;
        if (!hd.class.equals(hdVar.getClass())) {
            return hd.class.getName().compareTo(hdVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m540a()).compareTo(Boolean.valueOf(hdVar.m540a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (!m540a() || (iA = hr.a(this.f729a, hdVar.f729a)) == 0) {
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
                m539a();
                return;
            }
            if (hxVarMo601a.f898a != 1) {
                id.a(iaVar, b2);
            } else if (b2 == 15) {
                hy hyVarMo602a = iaVar.mo602a();
                this.f729a = new ArrayList(hyVarMo602a.f899a);
                for (int i2 = 0; i2 < hyVarMo602a.f899a; i2++) {
                    go goVar = new go();
                    goVar.a(iaVar);
                    this.f729a.add(goVar);
                }
                iaVar.i();
            } else {
                id.a(iaVar, b2);
            }
            iaVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m539a() throws ib {
        if (this.f729a != null) {
            return;
        }
        throw new ib("Required field 'normalConfigs' was not present! Struct: " + toString());
    }
}
