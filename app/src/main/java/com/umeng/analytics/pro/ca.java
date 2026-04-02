package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.ca;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: TUnion.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ca<T extends ca<?, ?>, F extends bx> implements bq<T, F> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<Class<? extends cx>, cy> f7129c = new HashMap();
    protected Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected F f7130b;

    /* JADX INFO: compiled from: TUnion.java */
    private static class a extends cz<ca> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cx
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cp cpVar, ca caVar) throws bw {
            caVar.f7130b = null;
            caVar.a = null;
            cpVar.j();
            ck ckVarL = cpVar.l();
            caVar.a = caVar.a(cpVar, ckVarL);
            if (caVar.a != null) {
                caVar.f7130b = (F) caVar.a(ckVarL.f7176c);
            }
            cpVar.m();
            cpVar.l();
            cpVar.k();
        }

        @Override // com.umeng.analytics.pro.cx
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cp cpVar, ca caVar) throws bw {
            if (caVar.a() == null || caVar.b() == null) {
                throw new cq("Cannot write a TUnion with no set value!");
            }
            cpVar.a(caVar.d());
            cpVar.a(caVar.c(caVar.f7130b));
            caVar.a(cpVar);
            cpVar.c();
            cpVar.d();
            cpVar.b();
        }
    }

    /* JADX INFO: compiled from: TUnion.java */
    private static class b implements cy {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: TUnion.java */
    private static class c extends da<ca> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cx
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cp cpVar, ca caVar) throws bw {
            caVar.f7130b = null;
            caVar.a = null;
            short sV = cpVar.v();
            caVar.a = caVar.a(cpVar, sV);
            if (caVar.a != null) {
                caVar.f7130b = (F) caVar.a(sV);
            }
        }

        @Override // com.umeng.analytics.pro.cx
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cp cpVar, ca caVar) throws bw {
            if (caVar.a() == null || caVar.b() == null) {
                throw new cq("Cannot write a TUnion with no set value!");
            }
            cpVar.a(caVar.f7130b.a());
            caVar.b(cpVar);
        }
    }

    /* JADX INFO: compiled from: TUnion.java */
    private static class d implements cy {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        f7129c.put(cz.class, new b());
        f7129c.put(da.class, new d());
    }

    protected ca() {
        this.f7130b = null;
        this.a = null;
    }

    private static Object a(Object obj) {
        return obj instanceof bq ? ((bq) obj).deepCopy() : obj instanceof ByteBuffer ? br.d((ByteBuffer) obj) : obj instanceof List ? a((List) obj) : obj instanceof Set ? a((Set) obj) : obj instanceof Map ? a((Map<Object, Object>) obj) : obj;
    }

    protected abstract F a(short s);

    protected abstract Object a(cp cpVar, ck ckVar) throws bw;

    protected abstract Object a(cp cpVar, short s) throws bw;

    protected abstract void a(cp cpVar) throws bw;

    public Object b() {
        return this.a;
    }

    protected abstract void b(F f2, Object obj) throws ClassCastException;

    protected abstract void b(cp cpVar) throws bw;

    protected abstract ck c(F f2);

    public boolean c() {
        return this.f7130b != null;
    }

    @Override // com.umeng.analytics.pro.bq
    public final void clear() {
        this.f7130b = null;
        this.a = null;
    }

    protected abstract cu d();

    @Override // com.umeng.analytics.pro.bq
    public void read(cp cpVar) throws bw {
        f7129c.get(cpVar.D()).b().b(cpVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(ca.class.getSimpleName());
        sb.append(d.c.a.b.a.a.f10074g);
        if (a() != null) {
            Object objB = b();
            sb.append(c(a()).a);
            sb.append(Constants.COLON_SEPARATOR);
            if (objB instanceof ByteBuffer) {
                br.a((ByteBuffer) objB, sb);
            } else {
                sb.append(objB.toString());
            }
        }
        sb.append(">");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bq
    public void write(cp cpVar) throws bw {
        f7129c.get(cpVar.D()).b().a(cpVar, this);
    }

    public boolean b(F f2) {
        return this.f7130b == f2;
    }

    public boolean b(int i2) {
        return b(a((short) i2));
    }

    protected ca(F f2, Object obj) {
        a(f2, obj);
    }

    protected ca(ca<T, F> caVar) {
        if (caVar.getClass().equals(ca.class)) {
            this.f7130b = caVar.f7130b;
            this.a = a(caVar.a);
            return;
        }
        throw new ClassCastException();
    }

    private static Map a(Map<Object, Object> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            map2.put(a(entry.getKey()), a(entry.getValue()));
        }
        return map2;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(a(it.next()));
        }
        return hashSet;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    public F a() {
        return this.f7130b;
    }

    public Object a(F f2) {
        if (f2 == this.f7130b) {
            return b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f2 + " because union's set field is " + this.f7130b);
    }

    public Object a(int i2) {
        return a(a((short) i2));
    }

    public void a(F f2, Object obj) {
        b(f2, obj);
        this.f7130b = f2;
        this.a = obj;
    }

    public void a(int i2, Object obj) {
        a(a((short) i2), obj);
    }
}
