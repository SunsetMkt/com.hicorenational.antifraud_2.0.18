package com.xiaomi.push;

import com.umeng.analytics.pro.C3393cw;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.ek */
/* loaded from: classes2.dex */
public class C4190ek implements InterfaceC4277hq<C4190ek, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public String f15172a;

    /* renamed from: a */
    public List<C4189ej> f15173a;

    /* renamed from: b */
    public String f15174b;

    /* renamed from: a */
    private static final C4293if f15169a = new C4293if("StatsEvents");

    /* renamed from: a */
    private static final C4284hx f15168a = new C4284hx("", (byte) 11, 1);

    /* renamed from: b */
    private static final C4284hx f15170b = new C4284hx("", (byte) 11, 2);

    /* renamed from: c */
    private static final C4284hx f15171c = new C4284hx("", C3393cw.f11873m, 3);

    public C4190ek() {
    }

    /* renamed from: a */
    public boolean m14634a() {
        return this.f15172a != null;
    }

    /* renamed from: b */
    public boolean m14636b() {
        return this.f15174b != null;
    }

    /* renamed from: c */
    public boolean m14637c() {
        return this.f15173a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4190ek)) {
            return m14635a((C4190ek) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        String str = this.f15172a;
        if (str == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(str);
        }
        if (m14636b()) {
            sb.append(", ");
            sb.append("operator:");
            String str2 = this.f15174b;
            if (str2 == null) {
                sb.append(AbstractC1191a.f2571h);
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("events:");
        List<C4189ej> list = this.f15173a;
        if (list == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    public C4190ek(String str, List<C4189ej> list) {
        this();
        this.f15172a = str;
        this.f15173a = list;
    }

    /* renamed from: a */
    public C4190ek m14632a(String str) {
        this.f15174b = str;
        return this;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m14633a();
        abstractC4288ia.mo15610a(f15169a);
        if (this.f15172a != null) {
            abstractC4288ia.mo15607a(f15168a);
            abstractC4288ia.mo15611a(this.f15172a);
            abstractC4288ia.mo15616b();
        }
        if (this.f15174b != null && m14636b()) {
            abstractC4288ia.mo15607a(f15170b);
            abstractC4288ia.mo15611a(this.f15174b);
            abstractC4288ia.mo15616b();
        }
        if (this.f15173a != null) {
            abstractC4288ia.mo15607a(f15171c);
            abstractC4288ia.mo15608a(new C4285hy((byte) 12, this.f15173a.size()));
            Iterator<C4189ej> it = this.f15173a.iterator();
            while (it.hasNext()) {
                it.next().mo14612b(abstractC4288ia);
            }
            abstractC4288ia.mo15621e();
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    /* renamed from: a */
    public boolean m14635a(C4190ek c4190ek) {
        if (c4190ek == null) {
            return false;
        }
        boolean m14634a = m14634a();
        boolean m14634a2 = c4190ek.m14634a();
        if ((m14634a || m14634a2) && !(m14634a && m14634a2 && this.f15172a.equals(c4190ek.f15172a))) {
            return false;
        }
        boolean m14636b = m14636b();
        boolean m14636b2 = c4190ek.m14636b();
        if ((m14636b || m14636b2) && !(m14636b && m14636b2 && this.f15174b.equals(c4190ek.f15174b))) {
            return false;
        }
        boolean m14637c = m14637c();
        boolean m14637c2 = c4190ek.m14637c();
        if (m14637c || m14637c2) {
            return m14637c && m14637c2 && this.f15173a.equals(c4190ek.f15173a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4190ek c4190ek) {
        int m15574a;
        int m15572a;
        int m15572a2;
        if (!C4190ek.class.equals(c4190ek.getClass())) {
            return C4190ek.class.getName().compareTo(c4190ek.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m14634a()).compareTo(Boolean.valueOf(c4190ek.m14634a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m14634a() && (m15572a2 = C4278hr.m15572a(this.f15172a, c4190ek.f15172a)) != 0) {
            return m15572a2;
        }
        int compareTo2 = Boolean.valueOf(m14636b()).compareTo(Boolean.valueOf(c4190ek.m14636b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (m14636b() && (m15572a = C4278hr.m15572a(this.f15174b, c4190ek.f15174b)) != 0) {
            return m15572a;
        }
        int compareTo3 = Boolean.valueOf(m14637c()).compareTo(Boolean.valueOf(c4190ek.m14637c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!m14637c() || (m15574a = C4278hr.m15574a(this.f15173a, c4190ek.f15173a)) == 0) {
            return 0;
        }
        return m15574a;
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: a */
    public void mo14606a(AbstractC4288ia abstractC4288ia) {
        abstractC4288ia.mo15598a();
        while (true) {
            C4284hx mo15594a = abstractC4288ia.mo15594a();
            byte b2 = mo15594a.f16331a;
            if (b2 == 0) {
                abstractC4288ia.mo15622f();
                m14633a();
                return;
            }
            short s = mo15594a.f16333a;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        C4291id.m15660a(abstractC4288ia, b2);
                    } else if (b2 == 15) {
                        C4285hy mo15595a = abstractC4288ia.mo15595a();
                        this.f15173a = new ArrayList(mo15595a.f16335a);
                        for (int i2 = 0; i2 < mo15595a.f16335a; i2++) {
                            C4189ej c4189ej = new C4189ej();
                            c4189ej.mo14606a(abstractC4288ia);
                            this.f15173a.add(c4189ej);
                        }
                        abstractC4288ia.mo15625i();
                    } else {
                        C4291id.m15660a(abstractC4288ia, b2);
                    }
                } else if (b2 == 11) {
                    this.f15174b = abstractC4288ia.mo15599a();
                } else {
                    C4291id.m15660a(abstractC4288ia, b2);
                }
            } else if (b2 == 11) {
                this.f15172a = abstractC4288ia.mo15599a();
            } else {
                C4291id.m15660a(abstractC4288ia, b2);
            }
            abstractC4288ia.mo15623g();
        }
    }

    /* renamed from: a */
    public void m14633a() {
        if (this.f15172a != null) {
            if (this.f15173a != null) {
                return;
            }
            throw new C4289ib("Required field 'events' was not present! Struct: " + toString());
        }
        throw new C4289ib("Required field 'uuid' was not present! Struct: " + toString());
    }
}
