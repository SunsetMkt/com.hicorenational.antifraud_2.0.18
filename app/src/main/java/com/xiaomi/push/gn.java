package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class gn implements hq<gn, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f587a;

    /* renamed from: a, reason: collision with other field name */
    public gh f588a;

    /* renamed from: a, reason: collision with other field name */
    public String f589a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f590a = new BitSet(1);

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f586a = new Cif("DataCollectionItem");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f12980a = new hx("", (byte) 10, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f12981b = new hx("", (byte) 8, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f12982c = new hx("", (byte) 11, 3);

    public gn a(long j2) {
        this.f587a = j2;
        a(true);
        return this;
    }

    public boolean b() {
        return this.f588a != null;
    }

    public boolean c() {
        return this.f589a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gn)) {
            return m475a((gn) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f587a);
        sb.append(", ");
        sb.append("collectionType:");
        gh ghVar = this.f588a;
        if (ghVar == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(ghVar);
        }
        sb.append(", ");
        sb.append("content:");
        String str = this.f589a;
        if (str == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        m473a();
        iaVar.a(f586a);
        iaVar.a(f12980a);
        iaVar.a(this.f587a);
        iaVar.b();
        if (this.f588a != null) {
            iaVar.a(f12981b);
            iaVar.mo612a(this.f588a.a());
            iaVar.b();
        }
        if (this.f589a != null) {
            iaVar.a(f12982c);
            iaVar.a(this.f589a);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m474a() {
        return this.f590a.get(0);
    }

    public void a(boolean z) {
        this.f590a.set(0, z);
    }

    public gn a(gh ghVar) {
        this.f588a = ghVar;
        return this;
    }

    public String a() {
        return this.f589a;
    }

    public gn a(String str) {
        this.f589a = str;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m475a(gn gnVar) {
        if (gnVar == null || this.f587a != gnVar.f587a) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = gnVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f588a.equals(gnVar.f588a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = gnVar.c();
        if (c2 || c3) {
            return c2 && c3 && this.f589a.equals(gnVar.f589a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gn gnVar) {
        int a2;
        int a3;
        int a4;
        if (!gn.class.equals(gnVar.getClass())) {
            return gn.class.getName().compareTo(gnVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m474a()).compareTo(Boolean.valueOf(gnVar.m474a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m474a() && (a4 = hr.a(this.f587a, gnVar.f587a)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gnVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a3 = hr.a(this.f588a, gnVar.f588a)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gnVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!c() || (a2 = hr.a(this.f589a, gnVar.f589a)) == 0) {
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
                    } else if (b2 == 11) {
                        this.f589a = iaVar.mo608a();
                    } else {
                        id.a(iaVar, b2);
                    }
                } else if (b2 == 8) {
                    this.f588a = gh.a(iaVar.mo601a());
                } else {
                    id.a(iaVar, b2);
                }
            } else if (b2 == 10) {
                this.f587a = iaVar.mo602a();
                a(true);
            } else {
                id.a(iaVar, b2);
            }
            iaVar.g();
        }
        iaVar.f();
        if (m474a()) {
            m473a();
            return;
        }
        throw new ib("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m473a() {
        if (this.f588a != null) {
            if (this.f589a != null) {
                return;
            }
            throw new ib("Required field 'content' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'collectionType' was not present! Struct: " + toString());
    }
}
