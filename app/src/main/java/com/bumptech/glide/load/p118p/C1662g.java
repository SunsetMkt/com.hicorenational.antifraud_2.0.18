package com.bumptech.glide.load.p118p;

import com.bumptech.glide.C1578d;
import com.bumptech.glide.C1583i;
import com.bumptech.glide.EnumC1582h;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.InterfaceC1590d;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.InterfaceC1599m;
import com.bumptech.glide.load.InterfaceC1600n;
import com.bumptech.glide.load.p118p.RunnableC1663h;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b;
import com.bumptech.glide.load.p118p.p120b0.InterfaceC1639a;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import com.bumptech.glide.load.p125r.C1715c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: DecodeHelper.java */
/* renamed from: com.bumptech.glide.load.p.g */
/* loaded from: classes.dex */
final class C1662g<Transcode> {

    /* renamed from: a */
    private final List<InterfaceC1695n.a<?>> f4468a = new ArrayList();

    /* renamed from: b */
    private final List<InterfaceC1593g> f4469b = new ArrayList();

    /* renamed from: c */
    private C1578d f4470c;

    /* renamed from: d */
    private Object f4471d;

    /* renamed from: e */
    private int f4472e;

    /* renamed from: f */
    private int f4473f;

    /* renamed from: g */
    private Class<?> f4474g;

    /* renamed from: h */
    private RunnableC1663h.e f4475h;

    /* renamed from: i */
    private C1596j f4476i;

    /* renamed from: j */
    private Map<Class<?>, InterfaceC1600n<?>> f4477j;

    /* renamed from: k */
    private Class<Transcode> f4478k;

    /* renamed from: l */
    private boolean f4479l;

    /* renamed from: m */
    private boolean f4480m;

    /* renamed from: n */
    private InterfaceC1593g f4481n;

    /* renamed from: o */
    private EnumC1582h f4482o;

    /* renamed from: p */
    private AbstractC1665j f4483p;

    /* renamed from: q */
    private boolean f4484q;

    /* renamed from: r */
    private boolean f4485r;

    C1662g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    <R> void m4077a(C1578d c1578d, Object obj, InterfaceC1593g interfaceC1593g, int i2, int i3, AbstractC1665j abstractC1665j, Class<?> cls, Class<R> cls2, EnumC1582h enumC1582h, C1596j c1596j, Map<Class<?>, InterfaceC1600n<?>> map, boolean z, boolean z2, RunnableC1663h.e eVar) {
        this.f4470c = c1578d;
        this.f4471d = obj;
        this.f4481n = interfaceC1593g;
        this.f4472e = i2;
        this.f4473f = i3;
        this.f4483p = abstractC1665j;
        this.f4474g = cls;
        this.f4475h = eVar;
        this.f4478k = cls2;
        this.f4482o = enumC1582h;
        this.f4476i = c1596j;
        this.f4477j = map;
        this.f4484q = z;
        this.f4485r = z2;
    }

    /* renamed from: b */
    InterfaceC1623b m4080b() {
        return this.f4470c.m3689a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    boolean m4083c(Class<?> cls) {
        return m4074a((Class) cls) != null;
    }

    /* renamed from: d */
    InterfaceC1639a m4084d() {
        return this.f4475h.mo4129a();
    }

    /* renamed from: e */
    AbstractC1665j m4085e() {
        return this.f4483p;
    }

    /* renamed from: f */
    int m4086f() {
        return this.f4473f;
    }

    /* renamed from: g */
    List<InterfaceC1695n.a<?>> m4087g() {
        if (!this.f4479l) {
            this.f4479l = true;
            this.f4468a.clear();
            List m3736a = this.f4470c.m3695f().m3736a((C1583i) this.f4471d);
            int size = m3736a.size();
            for (int i2 = 0; i2 < size; i2++) {
                InterfaceC1695n.a<?> mo4217a = ((InterfaceC1695n) m3736a.get(i2)).mo4217a(this.f4471d, this.f4472e, this.f4473f, this.f4476i);
                if (mo4217a != null) {
                    this.f4468a.add(mo4217a);
                }
            }
        }
        return this.f4468a;
    }

    /* renamed from: h */
    Class<?> m4088h() {
        return this.f4471d.getClass();
    }

    /* renamed from: i */
    C1596j m4089i() {
        return this.f4476i;
    }

    /* renamed from: j */
    EnumC1582h m4090j() {
        return this.f4482o;
    }

    /* renamed from: k */
    List<Class<?>> m4091k() {
        return this.f4470c.m3695f().m3743b(this.f4471d.getClass(), this.f4474g, this.f4478k);
    }

    /* renamed from: l */
    InterfaceC1593g m4092l() {
        return this.f4481n;
    }

    /* renamed from: m */
    Class<?> m4093m() {
        return this.f4478k;
    }

    /* renamed from: n */
    int m4094n() {
        return this.f4472e;
    }

    /* renamed from: o */
    boolean m4095o() {
        return this.f4485r;
    }

    /* renamed from: b */
    <Z> InterfaceC1600n<Z> m4079b(Class<Z> cls) {
        InterfaceC1600n<Z> interfaceC1600n = (InterfaceC1600n) this.f4477j.get(cls);
        if (interfaceC1600n == null) {
            Iterator<Map.Entry<Class<?>, InterfaceC1600n<?>>> it = this.f4477j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, InterfaceC1600n<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    interfaceC1600n = (InterfaceC1600n) next.getValue();
                    break;
                }
            }
        }
        if (interfaceC1600n != null) {
            return interfaceC1600n;
        }
        if (!this.f4477j.isEmpty() || !this.f4484q) {
            return C1715c.m4302a();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    /* renamed from: c */
    List<InterfaceC1593g> m4082c() {
        if (!this.f4480m) {
            this.f4480m = true;
            this.f4469b.clear();
            List<InterfaceC1695n.a<?>> m4087g = m4087g();
            int size = m4087g.size();
            for (int i2 = 0; i2 < size; i2++) {
                InterfaceC1695n.a<?> aVar = m4087g.get(i2);
                if (!this.f4469b.contains(aVar.f4726a)) {
                    this.f4469b.add(aVar.f4726a);
                }
                for (int i3 = 0; i3 < aVar.f4727b.size(); i3++) {
                    if (!this.f4469b.contains(aVar.f4727b.get(i3))) {
                        this.f4469b.add(aVar.f4727b.get(i3));
                    }
                }
            }
        }
        return this.f4469b;
    }

    /* renamed from: b */
    boolean m4081b(InterfaceC1677v<?> interfaceC1677v) {
        return this.f4470c.m3695f().m3744b(interfaceC1677v);
    }

    /* renamed from: a */
    void m4076a() {
        this.f4470c = null;
        this.f4471d = null;
        this.f4481n = null;
        this.f4474g = null;
        this.f4478k = null;
        this.f4476i = null;
        this.f4482o = null;
        this.f4477j = null;
        this.f4483p = null;
        this.f4468a.clear();
        this.f4479l = false;
        this.f4469b.clear();
        this.f4480m = false;
    }

    /* renamed from: a */
    <Data> C1675t<Data, ?, Transcode> m4074a(Class<Data> cls) {
        return this.f4470c.m3695f().m3734a(cls, this.f4474g, this.f4478k);
    }

    /* renamed from: a */
    <Z> InterfaceC1599m<Z> m4073a(InterfaceC1677v<Z> interfaceC1677v) {
        return this.f4470c.m3695f().m3733a((InterfaceC1677v) interfaceC1677v);
    }

    /* renamed from: a */
    List<InterfaceC1695n<File, ?>> m4075a(File file) throws C1583i.c {
        return this.f4470c.m3695f().m3736a((C1583i) file);
    }

    /* renamed from: a */
    boolean m4078a(InterfaceC1593g interfaceC1593g) {
        List<InterfaceC1695n.a<?>> m4087g = m4087g();
        int size = m4087g.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (m4087g.get(i2).f4726a.equals(interfaceC1593g)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    <X> InterfaceC1590d<X> m4072a(X x) throws C1583i.e {
        return this.f4470c.m3695f().m3748c(x);
    }
}
