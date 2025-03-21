package com.xiaomi.push;

import com.umeng.analytics.pro.C3393cw;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.gi */
/* loaded from: classes2.dex */
public class C4242gi implements InterfaceC4277hq<C4242gi, Object>, Serializable, Cloneable {

    /* renamed from: a */
    public List<C4243gj> f15524a;

    /* renamed from: a */
    private static final C4293if f15523a = new C4293if("ClientUploadData");

    /* renamed from: a */
    private static final C4284hx f15522a = new C4284hx("", C3393cw.f11873m, 1);

    /* renamed from: a */
    public int m14972a() {
        List<C4243gj> list = this.f15524a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.xiaomi.push.InterfaceC4277hq
    /* renamed from: b */
    public void mo14612b(AbstractC4288ia abstractC4288ia) {
        m14974a();
        abstractC4288ia.mo15610a(f15523a);
        if (this.f15524a != null) {
            abstractC4288ia.mo15607a(f15522a);
            abstractC4288ia.mo15608a(new C4285hy((byte) 12, this.f15524a.size()));
            Iterator<C4243gj> it = this.f15524a.iterator();
            while (it.hasNext()) {
                it.next().mo14612b(abstractC4288ia);
            }
            abstractC4288ia.mo15621e();
            abstractC4288ia.mo15616b();
        }
        abstractC4288ia.mo15618c();
        abstractC4288ia.mo15603a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4242gi)) {
            return m14977a((C4242gi) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        List<C4243gj> list = this.f15524a;
        if (list == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void m14975a(C4243gj c4243gj) {
        if (this.f15524a == null) {
            this.f15524a = new ArrayList();
        }
        this.f15524a.add(c4243gj);
    }

    /* renamed from: a */
    public boolean m14976a() {
        return this.f15524a != null;
    }

    /* renamed from: a */
    public boolean m14977a(C4242gi c4242gi) {
        if (c4242gi == null) {
            return false;
        }
        boolean m14976a = m14976a();
        boolean m14976a2 = c4242gi.m14976a();
        if (m14976a || m14976a2) {
            return m14976a && m14976a2 && this.f15524a.equals(c4242gi.f15524a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4242gi c4242gi) {
        int m15574a;
        if (!C4242gi.class.equals(c4242gi.getClass())) {
            return C4242gi.class.getName().compareTo(c4242gi.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m14976a()).compareTo(Boolean.valueOf(c4242gi.m14976a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!m14976a() || (m15574a = C4278hr.m15574a(this.f15524a, c4242gi.f15524a)) == 0) {
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
                m14974a();
                return;
            }
            if (mo15594a.f16333a != 1) {
                C4291id.m15660a(abstractC4288ia, b2);
            } else if (b2 == 15) {
                C4285hy mo15595a = abstractC4288ia.mo15595a();
                this.f15524a = new ArrayList(mo15595a.f16335a);
                for (int i2 = 0; i2 < mo15595a.f16335a; i2++) {
                    C4243gj c4243gj = new C4243gj();
                    c4243gj.mo14606a(abstractC4288ia);
                    this.f15524a.add(c4243gj);
                }
                abstractC4288ia.mo15625i();
            } else {
                C4291id.m15660a(abstractC4288ia, b2);
            }
            abstractC4288ia.mo15623g();
        }
    }

    /* renamed from: a */
    public void m14974a() {
        if (this.f15524a != null) {
            return;
        }
        throw new C4289ib("Required field 'uploadDataItems' was not present! Struct: " + toString());
    }
}
