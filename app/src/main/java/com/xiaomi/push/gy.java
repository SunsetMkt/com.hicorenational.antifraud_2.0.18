package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class gy implements hq<gy, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public List<gn> f691a;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f690a = new Cif("XmPushActionCollectData");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13066a = new hx("", com.umeng.analytics.pro.cw.f10303m, 1);

    public gy a(List<gn> list) {
        this.f691a = list;
        return this;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        a();
        iaVar.a(f690a);
        if (this.f691a != null) {
            iaVar.a(f13066a);
            iaVar.a(new hy((byte) 12, this.f691a.size()));
            Iterator<gn> it = this.f691a.iterator();
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
        if (obj != null && (obj instanceof gy)) {
            return m518a((gy) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        List<gn> list = this.f691a;
        if (list == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m517a() {
        return this.f691a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m518a(gy gyVar) {
        if (gyVar == null) {
            return false;
        }
        boolean m517a = m517a();
        boolean m517a2 = gyVar.m517a();
        if (m517a || m517a2) {
            return m517a && m517a2 && this.f691a.equals(gyVar.f691a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gy gyVar) {
        int a2;
        if (!gy.class.equals(gyVar.getClass())) {
            return gy.class.getName().compareTo(gyVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m517a()).compareTo(Boolean.valueOf(gyVar.m517a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m517a() || (a2 = hr.a(this.f691a, gyVar.f691a)) == 0) {
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
                a();
                return;
            }
            if (mo603a.f898a != 1) {
                id.a(iaVar, b2);
            } else if (b2 == 15) {
                hy mo604a = iaVar.mo604a();
                this.f691a = new ArrayList(mo604a.f899a);
                for (int i2 = 0; i2 < mo604a.f899a; i2++) {
                    gn gnVar = new gn();
                    gnVar.a(iaVar);
                    this.f691a.add(gnVar);
                }
                iaVar.i();
            } else {
                id.a(iaVar, b2);
            }
            iaVar.g();
        }
    }

    public void a() {
        if (this.f691a != null) {
            return;
        }
        throw new ib("Required field 'dataCollectionItems' was not present! Struct: " + toString());
    }
}
