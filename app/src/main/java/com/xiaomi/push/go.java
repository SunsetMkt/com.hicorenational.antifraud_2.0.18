package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class go implements hq<go, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f592a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gl f593a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f594a = new BitSet(1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<gq> f595a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f591a = new Cif("NormalConfig");
    private static final hx a = new hx("", (byte) 8, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hx f9102b = new hx("", com.umeng.analytics.pro.cw.f7205m, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hx f9103c = new hx("", (byte) 8, 3);

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
            return m477a((go) obj);
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
            sb.append(d.c.a.b.a.a.f10075h);
        } else {
            sb.append(list);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            gl glVar = this.f593a;
            if (glVar == null) {
                sb.append(d.c.a.b.a.a.f10075h);
            } else {
                sb.append(glVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m476a() {
        return this.f594a.get(0);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m475a();
        iaVar.a(f591a);
        iaVar.a(a);
        iaVar.mo610a(this.f592a);
        iaVar.b();
        if (this.f595a != null) {
            iaVar.a(f9102b);
            iaVar.a(new hy((byte) 12, this.f595a.size()));
            Iterator<gq> it = this.f595a.iterator();
            while (it.hasNext()) {
                it.next().b(iaVar);
            }
            iaVar.e();
            iaVar.b();
        }
        if (this.f593a != null && c()) {
            iaVar.a(f9103c);
            iaVar.mo610a(this.f593a.a());
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo609a();
    }

    public void a(boolean z) {
        this.f594a.set(0, z);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public gl m474a() {
        return this.f593a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m477a(go goVar) {
        if (goVar == null || this.f592a != goVar.f592a) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = goVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f595a.equals(goVar.f595a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = goVar.c();
        if (zC || zC2) {
            return zC && zC2 && this.f593a.equals(goVar.f593a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(go goVar) {
        int iA;
        int iA2;
        int iA3;
        if (!go.class.equals(goVar.getClass())) {
            return go.class.getName().compareTo(goVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m476a()).compareTo(Boolean.valueOf(goVar.m476a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m476a() && (iA3 = hr.a(this.f592a, goVar.f592a)) != 0) {
            return iA3;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(goVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA2 = hr.a(this.f595a, goVar.f595a)) != 0) {
            return iA2;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(goVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (!c() || (iA = hr.a(this.f593a, goVar.f593a)) == 0) {
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
                break;
            }
            short s = hxVarMo601a.f898a;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        id.a(iaVar, b2);
                    } else if (b2 == 8) {
                        this.f593a = gl.a(iaVar.mo599a());
                    } else {
                        id.a(iaVar, b2);
                    }
                } else if (b2 == 15) {
                    hy hyVarMo602a = iaVar.mo602a();
                    this.f595a = new ArrayList(hyVarMo602a.f899a);
                    for (int i2 = 0; i2 < hyVarMo602a.f899a; i2++) {
                        gq gqVar = new gq();
                        gqVar.a(iaVar);
                        this.f595a.add(gqVar);
                    }
                    iaVar.i();
                } else {
                    id.a(iaVar, b2);
                }
            } else if (b2 == 8) {
                this.f592a = iaVar.mo599a();
                a(true);
            } else {
                id.a(iaVar, b2);
            }
            iaVar.g();
        }
        iaVar.f();
        if (m476a()) {
            m475a();
            return;
        }
        throw new ib("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m475a() throws ib {
        if (this.f595a != null) {
            return;
        }
        throw new ib("Required field 'configItems' was not present! Struct: " + toString());
    }
}
