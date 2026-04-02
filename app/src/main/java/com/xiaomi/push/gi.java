package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class gi implements hq<gi, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<gj> f566a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f565a = new Cif("ClientUploadData");
    private static final hx a = new hx("", com.umeng.analytics.pro.cw.f7205m, 1);

    public int a() {
        List<gj> list = this.f566a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m458a();
        iaVar.a(f565a);
        if (this.f566a != null) {
            iaVar.a(a);
            iaVar.a(new hy((byte) 12, this.f566a.size()));
            Iterator<gj> it = this.f566a.iterator();
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
        if (obj != null && (obj instanceof gi)) {
            return m460a((gi) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        List<gj> list = this.f566a;
        if (list == null) {
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(gj gjVar) {
        if (this.f566a == null) {
            this.f566a = new ArrayList();
        }
        this.f566a.add(gjVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m459a() {
        return this.f566a != null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m460a(gi giVar) {
        if (giVar == null) {
            return false;
        }
        boolean zM459a = m459a();
        boolean zM459a2 = giVar.m459a();
        if (zM459a || zM459a2) {
            return zM459a && zM459a2 && this.f566a.equals(giVar.f566a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gi giVar) {
        int iA;
        if (!gi.class.equals(giVar.getClass())) {
            return gi.class.getName().compareTo(giVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m459a()).compareTo(Boolean.valueOf(giVar.m459a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (!m459a() || (iA = hr.a(this.f566a, giVar.f566a)) == 0) {
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
                m458a();
                return;
            }
            if (hxVarMo601a.f898a != 1) {
                id.a(iaVar, b2);
            } else if (b2 == 15) {
                hy hyVarMo602a = iaVar.mo602a();
                this.f566a = new ArrayList(hyVarMo602a.f899a);
                for (int i2 = 0; i2 < hyVarMo602a.f899a; i2++) {
                    gj gjVar = new gj();
                    gjVar.a(iaVar);
                    this.f566a.add(gjVar);
                }
                iaVar.i();
            } else {
                id.a(iaVar, b2);
            }
            iaVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m458a() throws ib {
        if (this.f566a != null) {
            return;
        }
        throw new ib("Required field 'uploadDataItems' was not present! Struct: " + toString());
    }
}
