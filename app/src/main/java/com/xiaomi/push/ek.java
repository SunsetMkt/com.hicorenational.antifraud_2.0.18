package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ek implements hq<ek, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public String f441a;

    /* renamed from: a, reason: collision with other field name */
    public List<ej> f442a;

    /* renamed from: b, reason: collision with other field name */
    public String f443b;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f440a = new Cif("StatsEvents");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f12766a = new hx("", (byte) 11, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f12767b = new hx("", (byte) 11, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f12768c = new hx("", com.umeng.analytics.pro.cw.f10303m, 3);

    public ek() {
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m377a() {
        return this.f441a != null;
    }

    public boolean b() {
        return this.f443b != null;
    }

    public boolean c() {
        return this.f442a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ek)) {
            return m378a((ek) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        String str = this.f441a;
        if (str == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            String str2 = this.f443b;
            if (str2 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("events:");
        List<ej> list = this.f442a;
        if (list == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    public ek(String str, List<ej> list) {
        this();
        this.f441a = str;
        this.f442a = list;
    }

    public ek a(String str) {
        this.f443b = str;
        return this;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        a();
        iaVar.a(f440a);
        if (this.f441a != null) {
            iaVar.a(f12766a);
            iaVar.a(this.f441a);
            iaVar.b();
        }
        if (this.f443b != null && b()) {
            iaVar.a(f12767b);
            iaVar.a(this.f443b);
            iaVar.b();
        }
        if (this.f442a != null) {
            iaVar.a(f12768c);
            iaVar.a(new hy((byte) 12, this.f442a.size()));
            Iterator<ej> it = this.f442a.iterator();
            while (it.hasNext()) {
                it.next().b(iaVar);
            }
            iaVar.e();
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m378a(ek ekVar) {
        if (ekVar == null) {
            return false;
        }
        boolean m377a = m377a();
        boolean m377a2 = ekVar.m377a();
        if ((m377a || m377a2) && !(m377a && m377a2 && this.f441a.equals(ekVar.f441a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ekVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f443b.equals(ekVar.f443b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ekVar.c();
        if (c2 || c3) {
            return c2 && c3 && this.f442a.equals(ekVar.f442a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ek ekVar) {
        int a2;
        int a3;
        int a4;
        if (!ek.class.equals(ekVar.getClass())) {
            return ek.class.getName().compareTo(ekVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m377a()).compareTo(Boolean.valueOf(ekVar.m377a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m377a() && (a4 = hr.a(this.f441a, ekVar.f441a)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ekVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a3 = hr.a(this.f443b, ekVar.f443b)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ekVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (a2 = hr.a(this.f442a, ekVar.f442a)) == 0) {
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
            short s = mo603a.f898a;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        id.a(iaVar, b2);
                    } else if (b2 == 15) {
                        hy mo604a = iaVar.mo604a();
                        this.f442a = new ArrayList(mo604a.f899a);
                        for (int i2 = 0; i2 < mo604a.f899a; i2++) {
                            ej ejVar = new ej();
                            ejVar.a(iaVar);
                            this.f442a.add(ejVar);
                        }
                        iaVar.i();
                    } else {
                        id.a(iaVar, b2);
                    }
                } else if (b2 == 11) {
                    this.f443b = iaVar.mo608a();
                } else {
                    id.a(iaVar, b2);
                }
            } else if (b2 == 11) {
                this.f441a = iaVar.mo608a();
            } else {
                id.a(iaVar, b2);
            }
            iaVar.g();
        }
    }

    public void a() {
        if (this.f441a != null) {
            if (this.f442a != null) {
                return;
            }
            throw new ib("Required field 'events' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'uuid' was not present! Struct: " + toString());
    }
}
