package com.umeng.analytics.pro;

import com.umeng.analytics.pro.AbstractC3371ca;
import com.umeng.analytics.pro.InterfaceC3367bx;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: TUnion.java */
/* renamed from: com.umeng.analytics.pro.ca */
/* loaded from: classes2.dex */
public abstract class AbstractC3371ca<T extends AbstractC3371ca<?, ?>, F extends InterfaceC3367bx> implements InterfaceC3360bq<T, F> {

    /* renamed from: c */
    private static final Map<Class<? extends InterfaceC3394cx>, InterfaceC3395cy> f11768c = new HashMap();

    /* renamed from: a */
    protected Object f11769a;

    /* renamed from: b */
    protected F f11770b;

    /* compiled from: TUnion.java */
    /* renamed from: com.umeng.analytics.pro.ca$a */
    private static class a extends AbstractC3396cz<AbstractC3371ca> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo10975b(AbstractC3386cp abstractC3386cp, AbstractC3371ca abstractC3371ca) throws C3366bw {
            abstractC3371ca.f11770b = null;
            abstractC3371ca.f11769a = null;
            abstractC3386cp.mo11137j();
            C3381ck mo11139l = abstractC3386cp.mo11139l();
            abstractC3371ca.f11769a = abstractC3371ca.m11083a(abstractC3386cp, mo11139l);
            if (abstractC3371ca.f11769a != null) {
                abstractC3371ca.f11770b = (F) abstractC3371ca.m11080a(mo11139l.f11835c);
            }
            abstractC3386cp.mo11140m();
            abstractC3386cp.mo11139l();
            abstractC3386cp.mo11138k();
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo10973a(AbstractC3386cp abstractC3386cp, AbstractC3371ca abstractC3371ca) throws C3366bw {
            if (abstractC3371ca.m11079a() == null || abstractC3371ca.m11088b() == null) {
                throw new C3387cq("Cannot write a TUnion with no set value!");
            }
            abstractC3386cp.mo11121a(abstractC3371ca.m11095d());
            abstractC3386cp.mo11116a(abstractC3371ca.m11093c(abstractC3371ca.f11770b));
            abstractC3371ca.m11087a(abstractC3386cp);
            abstractC3386cp.mo11128c();
            abstractC3386cp.mo11130d();
            abstractC3386cp.mo11127b();
        }
    }

    /* compiled from: TUnion.java */
    /* renamed from: com.umeng.analytics.pro.ca$b */
    private static class b implements InterfaceC3395cy {
        private b() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3395cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a mo10977b() {
            return new a();
        }
    }

    /* compiled from: TUnion.java */
    /* renamed from: com.umeng.analytics.pro.ca$c */
    private static class c extends AbstractC3398da<AbstractC3371ca> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo10975b(AbstractC3386cp abstractC3386cp, AbstractC3371ca abstractC3371ca) throws C3366bw {
            abstractC3371ca.f11770b = null;
            abstractC3371ca.f11769a = null;
            short mo11149v = abstractC3386cp.mo11149v();
            abstractC3371ca.f11769a = abstractC3371ca.m11084a(abstractC3386cp, mo11149v);
            if (abstractC3371ca.f11769a != null) {
                abstractC3371ca.f11770b = (F) abstractC3371ca.m11080a(mo11149v);
            }
        }

        @Override // com.umeng.analytics.pro.InterfaceC3394cx
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo10973a(AbstractC3386cp abstractC3386cp, AbstractC3371ca abstractC3371ca) throws C3366bw {
            if (abstractC3371ca.m11079a() == null || abstractC3371ca.m11088b() == null) {
                throw new C3387cq("Cannot write a TUnion with no set value!");
            }
            abstractC3386cp.mo11124a(abstractC3371ca.f11770b.mo10984a());
            abstractC3371ca.m11090b(abstractC3386cp);
        }
    }

    /* compiled from: TUnion.java */
    /* renamed from: com.umeng.analytics.pro.ca$d */
    private static class d implements InterfaceC3395cy {
        private d() {
        }

        @Override // com.umeng.analytics.pro.InterfaceC3395cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c mo10977b() {
            return new c();
        }
    }

    static {
        f11768c.put(AbstractC3396cz.class, new b());
        f11768c.put(AbstractC3398da.class, new d());
    }

    protected AbstractC3371ca() {
        this.f11770b = null;
        this.f11769a = null;
    }

    /* renamed from: a */
    private static Object m11075a(Object obj) {
        return obj instanceof InterfaceC3360bq ? ((InterfaceC3360bq) obj).deepCopy() : obj instanceof ByteBuffer ? C3361br.m11053d((ByteBuffer) obj) : obj instanceof List ? m11076a((List) obj) : obj instanceof Set ? m11078a((Set) obj) : obj instanceof Map ? m11077a((Map<Object, Object>) obj) : obj;
    }

    /* renamed from: a */
    protected abstract F m11080a(short s);

    /* renamed from: a */
    protected abstract Object m11083a(AbstractC3386cp abstractC3386cp, C3381ck c3381ck) throws C3366bw;

    /* renamed from: a */
    protected abstract Object m11084a(AbstractC3386cp abstractC3386cp, short s) throws C3366bw;

    /* renamed from: a */
    protected abstract void m11087a(AbstractC3386cp abstractC3386cp) throws C3366bw;

    /* renamed from: b */
    public Object m11088b() {
        return this.f11769a;
    }

    /* renamed from: b */
    protected abstract void m11089b(F f2, Object obj) throws ClassCastException;

    /* renamed from: b */
    protected abstract void m11090b(AbstractC3386cp abstractC3386cp) throws C3366bw;

    /* renamed from: c */
    protected abstract C3381ck m11093c(F f2);

    /* renamed from: c */
    public boolean m11094c() {
        return this.f11770b != null;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public final void clear() {
        this.f11770b = null;
        this.f11769a = null;
    }

    /* renamed from: d */
    protected abstract C3391cu m11095d();

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void read(AbstractC3386cp abstractC3386cp) throws C3366bw {
        f11768c.get(abstractC3386cp.mo11179D()).mo10977b().mo10975b(abstractC3386cp, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(AbstractC3371ca.class.getSimpleName());
        sb.append(AbstractC1191a.f2568g);
        if (m11079a() != null) {
            Object m11088b = m11088b();
            sb.append(m11093c(m11079a()).f11833a);
            sb.append(Constants.COLON_SEPARATOR);
            if (m11088b instanceof ByteBuffer) {
                C3361br.m11048a((ByteBuffer) m11088b, sb);
            } else {
                sb.append(m11088b.toString());
            }
        }
        sb.append(">");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.InterfaceC3360bq
    public void write(AbstractC3386cp abstractC3386cp) throws C3366bw {
        f11768c.get(abstractC3386cp.mo11179D()).mo10977b().mo10973a(abstractC3386cp, this);
    }

    /* renamed from: b */
    public boolean m11092b(F f2) {
        return this.f11770b == f2;
    }

    /* renamed from: b */
    public boolean m11091b(int i2) {
        return m11092b((AbstractC3371ca<T, F>) m11080a((short) i2));
    }

    protected AbstractC3371ca(F f2, Object obj) {
        m11086a((AbstractC3371ca<T, F>) f2, obj);
    }

    protected AbstractC3371ca(AbstractC3371ca<T, F> abstractC3371ca) {
        if (abstractC3371ca.getClass().equals(AbstractC3371ca.class)) {
            this.f11770b = abstractC3371ca.f11770b;
            this.f11769a = m11075a(abstractC3371ca.f11769a);
            return;
        }
        throw new ClassCastException();
    }

    /* renamed from: a */
    private static Map m11077a(Map<Object, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            hashMap.put(m11075a(entry.getKey()), m11075a(entry.getValue()));
        }
        return hashMap;
    }

    /* renamed from: a */
    private static Set m11078a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(m11075a(it.next()));
        }
        return hashSet;
    }

    /* renamed from: a */
    private static List m11076a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(m11075a(it.next()));
        }
        return arrayList;
    }

    /* renamed from: a */
    public F m11079a() {
        return this.f11770b;
    }

    /* renamed from: a */
    public Object m11082a(F f2) {
        if (f2 == this.f11770b) {
            return m11088b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f2 + " because union's set field is " + this.f11770b);
    }

    /* renamed from: a */
    public Object m11081a(int i2) {
        return m11082a((AbstractC3371ca<T, F>) m11080a((short) i2));
    }

    /* renamed from: a */
    public void m11086a(F f2, Object obj) {
        m11089b(f2, obj);
        this.f11770b = f2;
        this.f11769a = obj;
    }

    /* renamed from: a */
    public void m11085a(int i2, Object obj) {
        m11086a((AbstractC3371ca<T, F>) m11080a((short) i2), obj);
    }
}
