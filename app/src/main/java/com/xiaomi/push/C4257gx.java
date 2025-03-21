package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* renamed from: com.xiaomi.push.gx */
/* loaded from: classes2.dex */
public class C4257gx implements InterfaceC4277hq<C4257gx, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public int f15938a;

    /* renamed from: a */
    private BitSet f15939a = new BitSet(2);

    /* renamed from: b */
    public int f15940b;

    /* renamed from: a */
    private static final C4293if f15936a = new C4293if("XmPushActionCheckClientInfo");

    /* renamed from: a */
    private static final C4284hx f15935a = new C4284hx("", (byte) 8, 1);

    /* renamed from: b */
    private static final C4284hx f15937b = new C4284hx("", (byte) 8, 2);

    /* renamed from: a */
    public C4257gx m15204a(int i2) {
        this.f15938a = i2;
        m15206a(true);
        return this;
    }

    /* renamed from: a */
    public void m15205a() {
    }

    /* renamed from: b */
    public C4257gx m15209b(int i2) {
        this.f15940b = i2;
        m15210b(true);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4257gx)) {
            return m15208a((C4257gx) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f15938a + ", pluginConfigVersion:" + this.f15940b + ")";
    }

    /* renamed from: a */
    public boolean m15207a() {
        return this.f15939a.get(0);
    }

    /* renamed from: b */
    public boolean m15211b() {
        return this.f15939a.get(1);
    }

    /* renamed from: a */
    public void m15206a(boolean z) {
        this.f15939a.set(0, z);
    }

    /* renamed from: b */
    public void m15210b(boolean z) {
        this.f15939a.set(1, z);
    }

    /* renamed from: a */
    public boolean m15208a(C4257gx c4257gx) {
        return c4257gx != null && this.f15938a == c4257gx.f15938a && this.f15940b == c4257gx.f15940b;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m15205a();
        abstractC4288ia.mo15610a(f15936a);
        abstractC4288ia.mo15607a(f15935a);
        abstractC4288ia.mo15605a(this.f15938a);
        abstractC4288ia.mo15616b();
        abstractC4288ia.mo15607a(f15937b);
        abstractC4288ia.mo15605a(this.f15940b);
        abstractC4288ia.mo15616b();
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4257gx c4257gx) {
        int m15569a;
        int m15569a2;
        if (!C4257gx.class.equals(c4257gx.getClass())) {
            return C4257gx.class.getName().compareTo(c4257gx.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m15207a()).compareTo(Boolean.valueOf(c4257gx.m15207a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m15207a() && (m15569a2 = C4278hr.m15569a(this.f15938a, c4257gx.f15938a)) != 0) {
            return m15569a2;
        }
        int compareTo2 = Boolean.valueOf(m15211b()).compareTo(Boolean.valueOf(c4257gx.m15211b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (!m15211b() || (m15569a = C4278hr.m15569a(this.f15940b, c4257gx.f15940b)) == 0) {
            return 0;
        }
        return m15569a;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: a */
    public void mo14606a(AbstractC4288ia abstractC4288ia) {
        abstractC4288ia.mo15598a();
        while (true) {
            C4284hx mo15594a = abstractC4288ia.mo15594a();
            byte b2 = mo15594a.f16331a;
            if (b2 == 0) {
                break;
            }
            short s = mo15594a.f16333a;
            if (s != 1) {
                if (s != 2) {
                    C4291id.m15660a(abstractC4288ia, b2);
                } else if (b2 == 8) {
                    this.f15940b = abstractC4288ia.mo15592a();
                    m15210b(true);
                } else {
                    C4291id.m15660a(abstractC4288ia, b2);
                }
            } else if (b2 == 8) {
                this.f15938a = abstractC4288ia.mo15592a();
                m15206a(true);
            } else {
                C4291id.m15660a(abstractC4288ia, b2);
            }
            abstractC4288ia.mo15623g();
        }
        abstractC4288ia.mo15622f();
        if (m15207a()) {
            if (m15211b()) {
                m15205a();
                return;
            }
            throw new C4289ib("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
        }
        throw new C4289ib("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
    }
}
