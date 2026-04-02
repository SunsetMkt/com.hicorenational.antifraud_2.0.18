package com.google.gson;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: compiled from: Gson.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    static final boolean A = false;
    static final boolean B = false;
    static final boolean C = true;
    static final boolean D = false;
    static final boolean E = false;
    static final boolean F = false;
    static final boolean G = true;
    static final String H = null;
    static final com.google.gson.d I = com.google.gson.c.IDENTITY;
    static final x J = w.DOUBLE;
    static final x K = w.LAZILY_PARSED_NUMBER;
    private static final String L = ")]}'\n";
    static final boolean z = false;
    private final ThreadLocal<Map<com.google.gson.d0.a<?>, y<?>>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentMap<com.google.gson.d0.a<?>, y<?>> f3772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.gson.b0.c f3773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.gson.b0.q.e f3774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List<z> f3775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final com.google.gson.b0.d f3776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final com.google.gson.d f3777g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Map<Type, g<?>> f3778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f3779i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final boolean f3780j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final boolean f3781k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final boolean f3782l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final boolean f3783m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final boolean f3784n;
    final boolean o;
    final boolean p;
    final String q;
    final int r;
    final int s;
    final u t;
    final List<z> u;
    final List<z> v;
    final x w;
    final x x;
    final List<v> y;

    /* JADX INFO: compiled from: Gson.java */
    class a extends y<Number> {
        a() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.j();
                return;
            }
            double dDoubleValue = number.doubleValue();
            e.a(dDoubleValue);
            dVar.a(dDoubleValue);
        }

        @Override // com.google.gson.y
        public Number read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() != com.google.gson.e0.c.NULL) {
                return Double.valueOf(aVar.n());
            }
            aVar.r();
            return null;
        }
    }

    /* JADX INFO: compiled from: Gson.java */
    class b extends y<Number> {
        b() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.j();
                return;
            }
            float fFloatValue = number.floatValue();
            e.a(fFloatValue);
            if (!(number instanceof Float)) {
                number = Float.valueOf(fFloatValue);
            }
            dVar.a(number);
        }

        @Override // com.google.gson.y
        public Number read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() != com.google.gson.e0.c.NULL) {
                return Float.valueOf((float) aVar.n());
            }
            aVar.r();
            return null;
        }
    }

    /* JADX INFO: compiled from: Gson.java */
    class c extends y<Number> {
        c() {
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.j();
            } else {
                dVar.d(number.toString());
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.y
        public Number read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() != com.google.gson.e0.c.NULL) {
                return Long.valueOf(aVar.p());
            }
            aVar.r();
            return null;
        }
    }

    /* JADX INFO: compiled from: Gson.java */
    class d extends y<AtomicLong> {
        final /* synthetic */ y a;

        d(y yVar) {
            this.a = yVar;
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, AtomicLong atomicLong) throws IOException {
            this.a.write(dVar, Long.valueOf(atomicLong.get()));
        }

        @Override // com.google.gson.y
        public AtomicLong read(com.google.gson.e0.a aVar) throws IOException {
            return new AtomicLong(((Number) this.a.read(aVar)).longValue());
        }
    }

    /* JADX INFO: renamed from: com.google.gson.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Gson.java */
    class C0079e extends y<AtomicLongArray> {
        final /* synthetic */ y a;

        C0079e(y yVar) {
            this.a = yVar;
        }

        @Override // com.google.gson.y
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.e0.d dVar, AtomicLongArray atomicLongArray) throws IOException {
            dVar.c();
            int length = atomicLongArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                this.a.write(dVar, Long.valueOf(atomicLongArray.get(i2)));
            }
            dVar.e();
        }

        @Override // com.google.gson.y
        public AtomicLongArray read(com.google.gson.e0.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.c();
            while (aVar.j()) {
                arrayList.add(Long.valueOf(((Number) this.a.read(aVar)).longValue()));
            }
            aVar.f();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
            }
            return atomicLongArray;
        }
    }

    public e() {
        this(com.google.gson.b0.d.f3648h, I, Collections.emptyMap(), false, false, false, true, false, false, false, true, u.DEFAULT, H, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), J, K, Collections.emptyList());
    }

    @Deprecated
    public com.google.gson.b0.d a() {
        return this.f3776f;
    }

    public com.google.gson.d b() {
        return this.f3777g;
    }

    public boolean c() {
        return this.f3782l;
    }

    public com.google.gson.f d() {
        return new com.google.gson.f(this);
    }

    public boolean e() {
        return this.f3779i;
    }

    public String toString() {
        return "{serializeNulls:" + this.f3779i + ",factories:" + this.f3775e + ",instanceCreators:" + this.f3773c + "}";
    }

    private y<Number> a(boolean z2) {
        return z2 ? com.google.gson.b0.q.o.v : new a();
    }

    private y<Number> b(boolean z2) {
        return z2 ? com.google.gson.b0.q.o.u : new b();
    }

    /* JADX INFO: compiled from: Gson.java */
    static class f<T> extends com.google.gson.b0.q.l<T> {
        private y<T> a = null;

        f() {
        }

        private y<T> b() {
            y<T> yVar = this.a;
            if (yVar != null) {
                return yVar;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        public void a(y<T> yVar) {
            if (this.a != null) {
                throw new AssertionError("Delegate is already set");
            }
            this.a = yVar;
        }

        @Override // com.google.gson.y
        public T read(com.google.gson.e0.a aVar) throws IOException {
            return b().read(aVar);
        }

        @Override // com.google.gson.y
        public void write(com.google.gson.e0.d dVar, T t) throws IOException {
            b().write(dVar, t);
        }

        @Override // com.google.gson.b0.q.l
        public y<T> a() {
            return b();
        }
    }

    static void a(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static y<AtomicLongArray> b(y<Number> yVar) {
        return new C0079e(yVar).nullSafe();
    }

    private static y<Number> a(u uVar) {
        if (uVar == u.DEFAULT) {
            return com.google.gson.b0.q.o.t;
        }
        return new c();
    }

    public k b(Object obj) {
        if (obj == null) {
            return m.a;
        }
        return b(obj, obj.getClass());
    }

    e(com.google.gson.b0.d dVar, com.google.gson.d dVar2, Map<Type, g<?>> map, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, u uVar, String str, int i2, int i3, List<z> list, List<z> list2, List<z> list3, x xVar, x xVar2, List<v> list4) {
        this.a = new ThreadLocal<>();
        this.f3772b = new ConcurrentHashMap();
        this.f3776f = dVar;
        this.f3777g = dVar2;
        this.f3778h = map;
        this.f3773c = new com.google.gson.b0.c(map, z9, list4);
        this.f3779i = z2;
        this.f3780j = z3;
        this.f3781k = z4;
        this.f3782l = z5;
        this.f3783m = z6;
        this.f3784n = z7;
        this.o = z8;
        this.p = z9;
        this.t = uVar;
        this.q = str;
        this.r = i2;
        this.s = i3;
        this.u = list;
        this.v = list2;
        this.w = xVar;
        this.x = xVar2;
        this.y = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.b0.q.o.W);
        arrayList.add(com.google.gson.b0.q.j.a(xVar));
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(com.google.gson.b0.q.o.C);
        arrayList.add(com.google.gson.b0.q.o.f3742m);
        arrayList.add(com.google.gson.b0.q.o.f3736g);
        arrayList.add(com.google.gson.b0.q.o.f3738i);
        arrayList.add(com.google.gson.b0.q.o.f3740k);
        y<Number> yVarA = a(uVar);
        arrayList.add(com.google.gson.b0.q.o.a(Long.TYPE, Long.class, yVarA));
        arrayList.add(com.google.gson.b0.q.o.a(Double.TYPE, Double.class, a(z8)));
        arrayList.add(com.google.gson.b0.q.o.a(Float.TYPE, Float.class, b(z8)));
        arrayList.add(com.google.gson.b0.q.i.a(xVar2));
        arrayList.add(com.google.gson.b0.q.o.o);
        arrayList.add(com.google.gson.b0.q.o.q);
        arrayList.add(com.google.gson.b0.q.o.a(AtomicLong.class, a(yVarA)));
        arrayList.add(com.google.gson.b0.q.o.a(AtomicLongArray.class, b(yVarA)));
        arrayList.add(com.google.gson.b0.q.o.s);
        arrayList.add(com.google.gson.b0.q.o.x);
        arrayList.add(com.google.gson.b0.q.o.E);
        arrayList.add(com.google.gson.b0.q.o.G);
        arrayList.add(com.google.gson.b0.q.o.a(BigDecimal.class, com.google.gson.b0.q.o.z));
        arrayList.add(com.google.gson.b0.q.o.a(BigInteger.class, com.google.gson.b0.q.o.A));
        arrayList.add(com.google.gson.b0.q.o.a(com.google.gson.b0.h.class, com.google.gson.b0.q.o.B));
        arrayList.add(com.google.gson.b0.q.o.I);
        arrayList.add(com.google.gson.b0.q.o.K);
        arrayList.add(com.google.gson.b0.q.o.O);
        arrayList.add(com.google.gson.b0.q.o.Q);
        arrayList.add(com.google.gson.b0.q.o.U);
        arrayList.add(com.google.gson.b0.q.o.M);
        arrayList.add(com.google.gson.b0.q.o.f3733d);
        arrayList.add(com.google.gson.b0.q.c.f3683b);
        arrayList.add(com.google.gson.b0.q.o.S);
        if (com.google.gson.b0.t.d.a) {
            arrayList.add(com.google.gson.b0.t.d.f3770e);
            arrayList.add(com.google.gson.b0.t.d.f3769d);
            arrayList.add(com.google.gson.b0.t.d.f3771f);
        }
        arrayList.add(com.google.gson.b0.q.a.f3680c);
        arrayList.add(com.google.gson.b0.q.o.f3731b);
        arrayList.add(new com.google.gson.b0.q.b(this.f3773c));
        arrayList.add(new com.google.gson.b0.q.h(this.f3773c, z3));
        this.f3774d = new com.google.gson.b0.q.e(this.f3773c);
        arrayList.add(this.f3774d);
        arrayList.add(com.google.gson.b0.q.o.X);
        arrayList.add(new com.google.gson.b0.q.k(this.f3773c, dVar2, dVar, this.f3774d, list4));
        this.f3775e = Collections.unmodifiableList(arrayList);
    }

    public k b(Object obj, Type type) {
        com.google.gson.b0.q.g gVar = new com.google.gson.b0.q.g();
        a(obj, type, gVar);
        return gVar.k();
    }

    private static y<AtomicLong> a(y<Number> yVar) {
        return new d(yVar).nullSafe();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
    
        r3.a(r2);
        r0.put(r7, r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> y<T> a(com.google.gson.d0.a<T> aVar) {
        Objects.requireNonNull(aVar, "type must not be null");
        y<T> yVar = (y) this.f3772b.get(aVar);
        if (yVar != null) {
            return yVar;
        }
        Map<? extends com.google.gson.d0.a<?>, ? extends y<?>> map = this.a.get();
        boolean z2 = false;
        if (map == null) {
            map = new HashMap<>();
            this.a.set((Map<com.google.gson.d0.a<?>, y<?>>) map);
            z2 = true;
        } else {
            y<T> yVar2 = (y) map.get(aVar);
            if (yVar2 != null) {
                return yVar2;
            }
        }
        y<T> yVarCreate = null;
        try {
            f fVar = new f();
            map.put(aVar, fVar);
            Iterator<z> it = this.f3775e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                yVarCreate = it.next().create(this, aVar);
                if (yVarCreate != null) {
                    break;
                }
            }
            if (yVarCreate != null) {
                if (z2) {
                    this.f3772b.putAll(map);
                }
                return yVarCreate;
            }
            throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + aVar);
        } finally {
            if (z2) {
                this.a.remove();
            }
        }
    }

    public <T> y<T> a(z zVar, com.google.gson.d0.a<T> aVar) {
        if (!this.f3775e.contains(zVar)) {
            zVar = this.f3774d;
        }
        boolean z2 = false;
        for (z zVar2 : this.f3775e) {
            if (z2) {
                y<T> yVarCreate = zVar2.create(this, aVar);
                if (yVarCreate != null) {
                    return yVarCreate;
                }
            } else if (zVar2 == zVar) {
                z2 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public <T> y<T> a(Class<T> cls) {
        return a((com.google.gson.d0.a) com.google.gson.d0.a.get((Class) cls));
    }

    public String a(Object obj) {
        if (obj == null) {
            return a((k) m.a);
        }
        return a(obj, obj.getClass());
    }

    public String a(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void a(Object obj, Appendable appendable) throws l {
        if (obj != null) {
            a(obj, obj.getClass(), appendable);
        } else {
            a((k) m.a, appendable);
        }
    }

    public void a(Object obj, Type type, Appendable appendable) throws l {
        try {
            a(obj, type, a(com.google.gson.b0.o.a(appendable)));
        } catch (IOException e2) {
            throw new l(e2);
        }
    }

    public void a(Object obj, Type type, com.google.gson.e0.d dVar) throws l {
        y yVarA = a((com.google.gson.d0.a) com.google.gson.d0.a.get(type));
        boolean zI = dVar.i();
        dVar.b(true);
        boolean zH = dVar.h();
        dVar.a(this.f3782l);
        boolean zG = dVar.g();
        dVar.c(this.f3779i);
        try {
            try {
                yVarA.write(dVar, obj);
            } catch (IOException e2) {
                throw new l(e2);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e3.getMessage(), e3);
            }
        } finally {
            dVar.b(zI);
            dVar.a(zH);
            dVar.c(zG);
        }
    }

    public String a(k kVar) {
        StringWriter stringWriter = new StringWriter();
        a(kVar, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public void a(k kVar, Appendable appendable) throws l {
        try {
            a(kVar, a(com.google.gson.b0.o.a(appendable)));
        } catch (IOException e2) {
            throw new l(e2);
        }
    }

    public com.google.gson.e0.d a(Writer writer) throws IOException {
        if (this.f3781k) {
            writer.write(L);
        }
        com.google.gson.e0.d dVar = new com.google.gson.e0.d(writer);
        if (this.f3783m) {
            dVar.c("  ");
        }
        dVar.a(this.f3782l);
        dVar.b(this.f3784n);
        dVar.c(this.f3779i);
        return dVar;
    }

    public com.google.gson.e0.a a(Reader reader) {
        com.google.gson.e0.a aVar = new com.google.gson.e0.a(reader);
        aVar.a(this.f3784n);
        return aVar;
    }

    public void a(k kVar, com.google.gson.e0.d dVar) throws l {
        boolean zI = dVar.i();
        dVar.b(true);
        boolean zH = dVar.h();
        dVar.a(this.f3782l);
        boolean zG = dVar.g();
        dVar.c(this.f3779i);
        try {
            try {
                com.google.gson.b0.o.a(kVar, dVar);
            } catch (IOException e2) {
                throw new l(e2);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e3.getMessage(), e3);
            }
        } finally {
            dVar.b(zI);
            dVar.a(zH);
            dVar.c(zG);
        }
    }

    public <T> T a(String str, Class<T> cls) throws t {
        return (T) com.google.gson.b0.m.b((Class) cls).cast(a(str, com.google.gson.d0.a.get((Class) cls)));
    }

    public <T> T a(String str, Type type) throws t {
        return (T) a(str, com.google.gson.d0.a.get(type));
    }

    public <T> T a(String str, com.google.gson.d0.a<T> aVar) throws t {
        if (str == null) {
            return null;
        }
        return (T) a(new StringReader(str), aVar);
    }

    public <T> T a(Reader reader, Class<T> cls) throws t, l {
        return (T) com.google.gson.b0.m.b((Class) cls).cast(a(reader, com.google.gson.d0.a.get((Class) cls)));
    }

    public <T> T a(Reader reader, Type type) throws t, l {
        return (T) a(reader, com.google.gson.d0.a.get(type));
    }

    public <T> T a(Reader reader, com.google.gson.d0.a<T> aVar) throws t, l {
        com.google.gson.e0.a aVarA = a(reader);
        T t = (T) a(aVarA, aVar);
        a(t, aVarA);
        return t;
    }

    private static void a(Object obj, com.google.gson.e0.a aVar) {
        if (obj != null) {
            try {
                if (aVar.peek() == com.google.gson.e0.c.END_DOCUMENT) {
                } else {
                    throw new t("JSON document was not fully consumed.");
                }
            } catch (com.google.gson.e0.e e2) {
                throw new t(e2);
            } catch (IOException e3) {
                throw new l(e3);
            }
        }
    }

    public <T> T a(com.google.gson.e0.a aVar, Type type) throws t, l {
        return (T) a(aVar, com.google.gson.d0.a.get(type));
    }

    public <T> T a(com.google.gson.e0.a aVar, com.google.gson.d0.a<T> aVar2) throws t, l {
        boolean zK = aVar.k();
        boolean z2 = true;
        aVar.a(true);
        try {
            try {
                try {
                    aVar.peek();
                    z2 = false;
                    T t = a((com.google.gson.d0.a) aVar2).read(aVar);
                    aVar.a(zK);
                    return t;
                } catch (IOException e2) {
                    throw new t(e2);
                } catch (IllegalStateException e3) {
                    throw new t(e3);
                }
            } catch (EOFException e4) {
                if (z2) {
                    aVar.a(zK);
                    return null;
                }
                throw new t(e4);
            } catch (AssertionError e5) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e5.getMessage(), e5);
            }
        } catch (Throwable th) {
            aVar.a(zK);
            throw th;
        }
    }

    public <T> T a(k kVar, Class<T> cls) throws t {
        return (T) com.google.gson.b0.m.b((Class) cls).cast(a(kVar, com.google.gson.d0.a.get((Class) cls)));
    }

    public <T> T a(k kVar, Type type) throws t {
        return (T) a(kVar, com.google.gson.d0.a.get(type));
    }

    public <T> T a(k kVar, com.google.gson.d0.a<T> aVar) throws t {
        if (kVar == null) {
            return null;
        }
        return (T) a(new com.google.gson.b0.q.f(kVar), aVar);
    }
}
