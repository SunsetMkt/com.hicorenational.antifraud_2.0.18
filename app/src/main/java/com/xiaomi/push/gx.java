package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
public class gx implements hq<gx, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f687a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f688a = new BitSet(2);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f689b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f686a = new Cif("XmPushActionCheckClientInfo");
    private static final hx a = new hx("", (byte) 8, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hx f9177b = new hx("", (byte) 8, 2);

    public gx a(int i2) {
        this.f687a = i2;
        a(true);
        return this;
    }

    public void a() {
    }

    public gx b(int i2) {
        this.f689b = i2;
        b(true);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gx)) {
            return m514a((gx) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f687a + ", pluginConfigVersion:" + this.f689b + ")";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m513a() {
        return this.f688a.get(0);
    }

    public boolean b() {
        return this.f688a.get(1);
    }

    public void a(boolean z) {
        this.f688a.set(0, z);
    }

    public void b(boolean z) {
        this.f688a.set(1, z);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m514a(gx gxVar) {
        return gxVar != null && this.f687a == gxVar.f687a && this.f689b == gxVar.f689b;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        a();
        iaVar.a(f686a);
        iaVar.a(a);
        iaVar.mo610a(this.f687a);
        iaVar.b();
        iaVar.a(f9177b);
        iaVar.mo610a(this.f689b);
        iaVar.b();
        iaVar.c();
        iaVar.mo609a();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gx gxVar) {
        int iA;
        int iA2;
        if (!gx.class.equals(gxVar.getClass())) {
            return gx.class.getName().compareTo(gxVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m513a()).compareTo(Boolean.valueOf(gxVar.m513a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m513a() && (iA2 = hr.a(this.f687a, gxVar.f687a)) != 0) {
            return iA2;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gxVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (!b() || (iA = hr.a(this.f689b, gxVar.f689b)) == 0) {
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
                    id.a(iaVar, b2);
                } else if (b2 == 8) {
                    this.f689b = iaVar.mo599a();
                    b(true);
                } else {
                    id.a(iaVar, b2);
                }
            } else if (b2 == 8) {
                this.f687a = iaVar.mo599a();
                a(true);
            } else {
                id.a(iaVar, b2);
            }
            iaVar.g();
        }
        iaVar.f();
        if (m513a()) {
            if (b()) {
                a();
                return;
            }
            throw new ib("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
        }
        throw new ib("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
    }
}
