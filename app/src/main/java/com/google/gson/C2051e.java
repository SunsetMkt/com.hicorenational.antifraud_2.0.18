package com.google.gson;

import com.google.gson.p147b0.C2010c;
import com.google.gson.p147b0.C2011d;
import com.google.gson.p147b0.C2015h;
import com.google.gson.p147b0.C2020m;
import com.google.gson.p147b0.C2022o;
import com.google.gson.p147b0.p148q.AbstractC2035l;
import com.google.gson.p147b0.p148q.C2024a;
import com.google.gson.p147b0.p148q.C2025b;
import com.google.gson.p147b0.p148q.C2026c;
import com.google.gson.p147b0.p148q.C2028e;
import com.google.gson.p147b0.p148q.C2029f;
import com.google.gson.p147b0.p148q.C2030g;
import com.google.gson.p147b0.p148q.C2031h;
import com.google.gson.p147b0.p148q.C2032i;
import com.google.gson.p147b0.p148q.C2033j;
import com.google.gson.p147b0.p148q.C2034k;
import com.google.gson.p147b0.p148q.C2038o;
import com.google.gson.p147b0.p151t.C2045d;
import com.google.gson.p152d0.C2049a;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2055d;
import com.google.gson.p153e0.C2056e;
import com.google.gson.p153e0.EnumC2054c;
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
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: Gson.java */
/* renamed from: com.google.gson.e */
/* loaded from: classes.dex */
public final class C2051e {

    /* renamed from: A */
    static final boolean f5898A = false;

    /* renamed from: B */
    static final boolean f5899B = false;

    /* renamed from: C */
    static final boolean f5900C = true;

    /* renamed from: D */
    static final boolean f5901D = false;

    /* renamed from: E */
    static final boolean f5902E = false;

    /* renamed from: F */
    static final boolean f5903F = false;

    /* renamed from: G */
    static final boolean f5904G = true;

    /* renamed from: H */
    static final String f5905H = null;

    /* renamed from: I */
    static final InterfaceC2048d f5906I = EnumC2046c.IDENTITY;

    /* renamed from: J */
    static final InterfaceC2076x f5907J = EnumC2075w.DOUBLE;

    /* renamed from: K */
    static final InterfaceC2076x f5908K = EnumC2075w.LAZILY_PARSED_NUMBER;

    /* renamed from: L */
    private static final String f5909L = ")]}'\n";

    /* renamed from: z */
    static final boolean f5910z = false;

    /* renamed from: a */
    private final ThreadLocal<Map<C2049a<?>, AbstractC2077y<?>>> f5911a;

    /* renamed from: b */
    private final ConcurrentMap<C2049a<?>, AbstractC2077y<?>> f5912b;

    /* renamed from: c */
    private final C2010c f5913c;

    /* renamed from: d */
    private final C2028e f5914d;

    /* renamed from: e */
    final List<InterfaceC2078z> f5915e;

    /* renamed from: f */
    final C2011d f5916f;

    /* renamed from: g */
    final InterfaceC2048d f5917g;

    /* renamed from: h */
    final Map<Type, InterfaceC2059g<?>> f5918h;

    /* renamed from: i */
    final boolean f5919i;

    /* renamed from: j */
    final boolean f5920j;

    /* renamed from: k */
    final boolean f5921k;

    /* renamed from: l */
    final boolean f5922l;

    /* renamed from: m */
    final boolean f5923m;

    /* renamed from: n */
    final boolean f5924n;

    /* renamed from: o */
    final boolean f5925o;

    /* renamed from: p */
    final boolean f5926p;

    /* renamed from: q */
    final String f5927q;

    /* renamed from: r */
    final int f5928r;

    /* renamed from: s */
    final int f5929s;

    /* renamed from: t */
    final EnumC2073u f5930t;

    /* renamed from: u */
    final List<InterfaceC2078z> f5931u;

    /* renamed from: v */
    final List<InterfaceC2078z> f5932v;

    /* renamed from: w */
    final InterfaceC2076x f5933w;

    /* renamed from: x */
    final InterfaceC2076x f5934x;

    /* renamed from: y */
    final List<InterfaceC2074v> f5935y;

    /* compiled from: Gson.java */
    /* renamed from: com.google.gson.e$a */
    class a extends AbstractC2077y<Number> {
        a() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(C2055d c2055d, Number number) throws IOException {
            if (number == null) {
                c2055d.mo5448j();
                return;
            }
            double doubleValue = number.doubleValue();
            C2051e.m5550a(doubleValue);
            c2055d.mo5435a(doubleValue);
        }

        @Override // com.google.gson.AbstractC2077y
        public Number read(C2052a c2052a) throws IOException {
            if (c2052a.peek() != EnumC2054c.NULL) {
                return Double.valueOf(c2052a.mo5425n());
            }
            c2052a.mo5429r();
            return null;
        }
    }

    /* compiled from: Gson.java */
    /* renamed from: com.google.gson.e$b */
    class b extends AbstractC2077y<Number> {
        b() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(C2055d c2055d, Number number) throws IOException {
            if (number == null) {
                c2055d.mo5448j();
                return;
            }
            float floatValue = number.floatValue();
            C2051e.m5550a(floatValue);
            if (!(number instanceof Float)) {
                number = Float.valueOf(floatValue);
            }
            c2055d.mo5439a(number);
        }

        @Override // com.google.gson.AbstractC2077y
        public Number read(C2052a c2052a) throws IOException {
            if (c2052a.peek() != EnumC2054c.NULL) {
                return Float.valueOf((float) c2052a.mo5425n());
            }
            c2052a.mo5429r();
            return null;
        }
    }

    /* compiled from: Gson.java */
    /* renamed from: com.google.gson.e$c */
    class c extends AbstractC2077y<Number> {
        c() {
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(C2055d c2055d, Number number) throws IOException {
            if (number == null) {
                c2055d.mo5448j();
            } else {
                c2055d.mo5444d(number.toString());
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.AbstractC2077y
        public Number read(C2052a c2052a) throws IOException {
            if (c2052a.peek() != EnumC2054c.NULL) {
                return Long.valueOf(c2052a.mo5427p());
            }
            c2052a.mo5429r();
            return null;
        }
    }

    /* compiled from: Gson.java */
    /* renamed from: com.google.gson.e$d */
    class d extends AbstractC2077y<AtomicLong> {

        /* renamed from: a */
        final /* synthetic */ AbstractC2077y f5938a;

        d(AbstractC2077y abstractC2077y) {
            this.f5938a = abstractC2077y;
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(C2055d c2055d, AtomicLong atomicLong) throws IOException {
            this.f5938a.write(c2055d, Long.valueOf(atomicLong.get()));
        }

        @Override // com.google.gson.AbstractC2077y
        public AtomicLong read(C2052a c2052a) throws IOException {
            return new AtomicLong(((Number) this.f5938a.read(c2052a)).longValue());
        }
    }

    /* compiled from: Gson.java */
    /* renamed from: com.google.gson.e$e */
    class e extends AbstractC2077y<AtomicLongArray> {

        /* renamed from: a */
        final /* synthetic */ AbstractC2077y f5939a;

        e(AbstractC2077y abstractC2077y) {
            this.f5939a = abstractC2077y;
        }

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(C2055d c2055d, AtomicLongArray atomicLongArray) throws IOException {
            c2055d.mo5442c();
            int length = atomicLongArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                this.f5939a.write(c2055d, Long.valueOf(atomicLongArray.get(i2)));
            }
            c2055d.mo5446e();
        }

        @Override // com.google.gson.AbstractC2077y
        public AtomicLongArray read(C2052a c2052a) throws IOException {
            ArrayList arrayList = new ArrayList();
            c2052a.mo5417c();
            while (c2052a.mo5423j()) {
                arrayList.add(Long.valueOf(((Number) this.f5939a.read(c2052a)).longValue()));
            }
            c2052a.mo5419f();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
            }
            return atomicLongArray;
        }
    }

    public C2051e() {
        this(C2011d.f5672h, f5906I, Collections.emptyMap(), false, false, false, true, false, false, false, true, EnumC2073u.DEFAULT, f5905H, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), f5907J, f5908K, Collections.emptyList());
    }

    @Deprecated
    /* renamed from: a */
    public C2011d m5554a() {
        return this.f5916f;
    }

    /* renamed from: b */
    public InterfaceC2048d m5579b() {
        return this.f5917g;
    }

    /* renamed from: c */
    public boolean m5582c() {
        return this.f5922l;
    }

    /* renamed from: d */
    public C2058f m5583d() {
        return new C2058f(this);
    }

    /* renamed from: e */
    public boolean m5584e() {
        return this.f5919i;
    }

    public String toString() {
        return "{serializeNulls:" + this.f5919i + ",factories:" + this.f5915e + ",instanceCreators:" + this.f5913c + "}";
    }

    /* renamed from: a */
    private AbstractC2077y<Number> m5549a(boolean z) {
        return z ? C2038o.f5847v : new a();
    }

    /* renamed from: b */
    private AbstractC2077y<Number> m5553b(boolean z) {
        return z ? C2038o.f5846u : new b();
    }

    /* compiled from: Gson.java */
    /* renamed from: com.google.gson.e$f */
    static class f<T> extends AbstractC2035l<T> {

        /* renamed from: a */
        private AbstractC2077y<T> f5940a = null;

        f() {
        }

        /* renamed from: b */
        private AbstractC2077y<T> m5590b() {
            AbstractC2077y<T> abstractC2077y = this.f5940a;
            if (abstractC2077y != null) {
                return abstractC2077y;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        /* renamed from: a */
        public void m5591a(AbstractC2077y<T> abstractC2077y) {
            if (this.f5940a != null) {
                throw new AssertionError("Delegate is already set");
            }
            this.f5940a = abstractC2077y;
        }

        @Override // com.google.gson.AbstractC2077y
        public T read(C2052a c2052a) throws IOException {
            return m5590b().read(c2052a);
        }

        @Override // com.google.gson.AbstractC2077y
        public void write(C2055d c2055d, T t) throws IOException {
            m5590b().write(c2055d, t);
        }

        @Override // com.google.gson.p147b0.p148q.AbstractC2035l
        /* renamed from: a */
        public AbstractC2077y<T> mo5473a() {
            return m5590b();
        }
    }

    /* renamed from: a */
    static void m5550a(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    /* renamed from: b */
    private static AbstractC2077y<AtomicLongArray> m5552b(AbstractC2077y<Number> abstractC2077y) {
        return new e(abstractC2077y).nullSafe();
    }

    /* renamed from: a */
    private static AbstractC2077y<Number> m5547a(EnumC2073u enumC2073u) {
        if (enumC2073u == EnumC2073u.DEFAULT) {
            return C2038o.f5845t;
        }
        return new c();
    }

    /* renamed from: b */
    public AbstractC2063k m5580b(Object obj) {
        if (obj == null) {
            return C2065m.f6026a;
        }
        return m5581b(obj, obj.getClass());
    }

    C2051e(C2011d c2011d, InterfaceC2048d interfaceC2048d, Map<Type, InterfaceC2059g<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, EnumC2073u enumC2073u, String str, int i2, int i3, List<InterfaceC2078z> list, List<InterfaceC2078z> list2, List<InterfaceC2078z> list3, InterfaceC2076x interfaceC2076x, InterfaceC2076x interfaceC2076x2, List<InterfaceC2074v> list4) {
        this.f5911a = new ThreadLocal<>();
        this.f5912b = new ConcurrentHashMap();
        this.f5916f = c2011d;
        this.f5917g = interfaceC2048d;
        this.f5918h = map;
        this.f5913c = new C2010c(map, z8, list4);
        this.f5919i = z;
        this.f5920j = z2;
        this.f5921k = z3;
        this.f5922l = z4;
        this.f5923m = z5;
        this.f5924n = z6;
        this.f5925o = z7;
        this.f5926p = z8;
        this.f5930t = enumC2073u;
        this.f5927q = str;
        this.f5928r = i2;
        this.f5929s = i3;
        this.f5931u = list;
        this.f5932v = list2;
        this.f5933w = interfaceC2076x;
        this.f5934x = interfaceC2076x2;
        this.f5935y = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(C2038o.f5824W);
        arrayList.add(C2033j.m5456a(interfaceC2076x));
        arrayList.add(c2011d);
        arrayList.addAll(list3);
        arrayList.add(C2038o.f5804C);
        arrayList.add(C2038o.f5838m);
        arrayList.add(C2038o.f5832g);
        arrayList.add(C2038o.f5834i);
        arrayList.add(C2038o.f5836k);
        AbstractC2077y<Number> m5547a = m5547a(enumC2073u);
        arrayList.add(C2038o.m5485a(Long.TYPE, Long.class, m5547a));
        arrayList.add(C2038o.m5485a(Double.TYPE, Double.class, m5549a(z7)));
        arrayList.add(C2038o.m5485a(Float.TYPE, Float.class, m5553b(z7)));
        arrayList.add(C2032i.m5453a(interfaceC2076x2));
        arrayList.add(C2038o.f5840o);
        arrayList.add(C2038o.f5842q);
        arrayList.add(C2038o.m5484a(AtomicLong.class, m5548a(m5547a)));
        arrayList.add(C2038o.m5484a(AtomicLongArray.class, m5552b(m5547a)));
        arrayList.add(C2038o.f5844s);
        arrayList.add(C2038o.f5849x);
        arrayList.add(C2038o.f5806E);
        arrayList.add(C2038o.f5808G);
        arrayList.add(C2038o.m5484a(BigDecimal.class, C2038o.f5851z));
        arrayList.add(C2038o.m5484a(BigInteger.class, C2038o.f5802A));
        arrayList.add(C2038o.m5484a(C2015h.class, C2038o.f5803B));
        arrayList.add(C2038o.f5810I);
        arrayList.add(C2038o.f5812K);
        arrayList.add(C2038o.f5816O);
        arrayList.add(C2038o.f5818Q);
        arrayList.add(C2038o.f5822U);
        arrayList.add(C2038o.f5814M);
        arrayList.add(C2038o.f5829d);
        arrayList.add(C2026c.f5725b);
        arrayList.add(C2038o.f5820S);
        if (C2045d.f5891a) {
            arrayList.add(C2045d.f5895e);
            arrayList.add(C2045d.f5894d);
            arrayList.add(C2045d.f5896f);
        }
        arrayList.add(C2024a.f5719c);
        arrayList.add(C2038o.f5827b);
        arrayList.add(new C2025b(this.f5913c));
        arrayList.add(new C2031h(this.f5913c, z2));
        this.f5914d = new C2028e(this.f5913c);
        arrayList.add(this.f5914d);
        arrayList.add(C2038o.f5825X);
        arrayList.add(new C2034k(this.f5913c, interfaceC2048d, c2011d, this.f5914d, list4));
        this.f5915e = Collections.unmodifiableList(arrayList);
    }

    /* renamed from: b */
    public AbstractC2063k m5581b(Object obj, Type type) {
        C2030g c2030g = new C2030g();
        m5577a(obj, type, c2030g);
        return c2030g.m5449k();
    }

    /* renamed from: a */
    private static AbstractC2077y<AtomicLong> m5548a(AbstractC2077y<Number> abstractC2077y) {
        return new d(abstractC2077y).nullSafe();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
    
        r3.m5591a(r2);
        r0.put(r7, r2);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> com.google.gson.AbstractC2077y<T> m5557a(com.google.gson.p152d0.C2049a<T> r7) {
        /*
            r6 = this;
            java.lang.String r0 = "type must not be null"
            java.util.Objects.requireNonNull(r7, r0)
            java.util.concurrent.ConcurrentMap<com.google.gson.d0.a<?>, com.google.gson.y<?>> r0 = r6.f5912b
            java.lang.Object r0 = r0.get(r7)
            com.google.gson.y r0 = (com.google.gson.AbstractC2077y) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            java.lang.ThreadLocal<java.util.Map<com.google.gson.d0.a<?>, com.google.gson.y<?>>> r0 = r6.f5911a
            java.lang.Object r0 = r0.get()
            java.util.Map r0 = (java.util.Map) r0
            r1 = 0
            if (r0 != 0) goto L27
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.ThreadLocal<java.util.Map<com.google.gson.d0.a<?>, com.google.gson.y<?>>> r1 = r6.f5911a
            r1.set(r0)
            r1 = 1
            goto L30
        L27:
            java.lang.Object r2 = r0.get(r7)
            com.google.gson.y r2 = (com.google.gson.AbstractC2077y) r2
            if (r2 == 0) goto L30
            return r2
        L30:
            r2 = 0
            com.google.gson.e$f r3 = new com.google.gson.e$f     // Catch: java.lang.Throwable -> L7f
            r3.<init>()     // Catch: java.lang.Throwable -> L7f
            r0.put(r7, r3)     // Catch: java.lang.Throwable -> L7f
            java.util.List<com.google.gson.z> r4 = r6.f5915e     // Catch: java.lang.Throwable -> L7f
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L7f
        L3f:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> L7f
            if (r5 == 0) goto L57
            java.lang.Object r2 = r4.next()     // Catch: java.lang.Throwable -> L7f
            com.google.gson.z r2 = (com.google.gson.InterfaceC2078z) r2     // Catch: java.lang.Throwable -> L7f
            com.google.gson.y r2 = r2.create(r6, r7)     // Catch: java.lang.Throwable -> L7f
            if (r2 == 0) goto L3f
            r3.m5591a(r2)     // Catch: java.lang.Throwable -> L7f
            r0.put(r7, r2)     // Catch: java.lang.Throwable -> L7f
        L57:
            if (r1 == 0) goto L5e
            java.lang.ThreadLocal<java.util.Map<com.google.gson.d0.a<?>, com.google.gson.y<?>>> r3 = r6.f5911a
            r3.remove()
        L5e:
            if (r2 == 0) goto L68
            if (r1 == 0) goto L67
            java.util.concurrent.ConcurrentMap<com.google.gson.d0.a<?>, com.google.gson.y<?>> r7 = r6.f5912b
            r7.putAll(r0)
        L67:
            return r2
        L68:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "GSON (2.10.1) cannot handle "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L7f:
            r7 = move-exception
            if (r1 == 0) goto L87
            java.lang.ThreadLocal<java.util.Map<com.google.gson.d0.a<?>, com.google.gson.y<?>>> r0 = r6.f5911a
            r0.remove()
        L87:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.C2051e.m5557a(com.google.gson.d0.a):com.google.gson.y");
    }

    /* renamed from: a */
    public <T> AbstractC2077y<T> m5558a(InterfaceC2078z interfaceC2078z, C2049a<T> c2049a) {
        if (!this.f5915e.contains(interfaceC2078z)) {
            interfaceC2078z = this.f5914d;
        }
        boolean z = false;
        for (InterfaceC2078z interfaceC2078z2 : this.f5915e) {
            if (z) {
                AbstractC2077y<T> create = interfaceC2078z2.create(this, c2049a);
                if (create != null) {
                    return create;
                }
            } else if (interfaceC2078z2 == interfaceC2078z) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + c2049a);
    }

    /* renamed from: a */
    public <T> AbstractC2077y<T> m5559a(Class<T> cls) {
        return m5557a((C2049a) C2049a.get((Class) cls));
    }

    /* renamed from: a */
    public String m5572a(Object obj) {
        if (obj == null) {
            return m5571a((AbstractC2063k) C2065m.f6026a);
        }
        return m5573a(obj, obj.getClass());
    }

    /* renamed from: a */
    public String m5573a(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        m5578a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    /* renamed from: a */
    public void m5576a(Object obj, Appendable appendable) throws C2064l {
        if (obj != null) {
            m5578a(obj, obj.getClass(), appendable);
        } else {
            m5575a((AbstractC2063k) C2065m.f6026a, appendable);
        }
    }

    /* renamed from: a */
    public void m5578a(Object obj, Type type, Appendable appendable) throws C2064l {
        try {
            m5577a(obj, type, m5556a(C2022o.m5391a(appendable)));
        } catch (IOException e2) {
            throw new C2064l(e2);
        }
    }

    /* renamed from: a */
    public void m5577a(Object obj, Type type, C2055d c2055d) throws C2064l {
        AbstractC2077y m5557a = m5557a((C2049a) C2049a.get(type));
        boolean m5629i = c2055d.m5629i();
        c2055d.m5624b(true);
        boolean m5628h = c2055d.m5628h();
        c2055d.m5623a(this.f5922l);
        boolean m5627g = c2055d.m5627g();
        c2055d.m5626c(this.f5919i);
        try {
            try {
                m5557a.write(c2055d, obj);
            } catch (IOException e2) {
                throw new C2064l(e2);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e3.getMessage(), e3);
            }
        } finally {
            c2055d.m5624b(m5629i);
            c2055d.m5623a(m5628h);
            c2055d.m5626c(m5627g);
        }
    }

    /* renamed from: a */
    public String m5571a(AbstractC2063k abstractC2063k) {
        StringWriter stringWriter = new StringWriter();
        m5575a(abstractC2063k, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    /* renamed from: a */
    public void m5575a(AbstractC2063k abstractC2063k, Appendable appendable) throws C2064l {
        try {
            m5574a(abstractC2063k, m5556a(C2022o.m5391a(appendable)));
        } catch (IOException e2) {
            throw new C2064l(e2);
        }
    }

    /* renamed from: a */
    public C2055d m5556a(Writer writer) throws IOException {
        if (this.f5921k) {
            writer.write(f5909L);
        }
        C2055d c2055d = new C2055d(writer);
        if (this.f5923m) {
            c2055d.m5625c("  ");
        }
        c2055d.m5623a(this.f5922l);
        c2055d.m5624b(this.f5924n);
        c2055d.m5626c(this.f5919i);
        return c2055d;
    }

    /* renamed from: a */
    public C2052a m5555a(Reader reader) {
        C2052a c2052a = new C2052a(reader);
        c2052a.m5609a(this.f5924n);
        return c2052a;
    }

    /* renamed from: a */
    public void m5574a(AbstractC2063k abstractC2063k, C2055d c2055d) throws C2064l {
        boolean m5629i = c2055d.m5629i();
        c2055d.m5624b(true);
        boolean m5628h = c2055d.m5628h();
        c2055d.m5623a(this.f5922l);
        boolean m5627g = c2055d.m5627g();
        c2055d.m5626c(this.f5919i);
        try {
            try {
                C2022o.m5392a(abstractC2063k, c2055d);
            } catch (IOException e2) {
                throw new C2064l(e2);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e3.getMessage(), e3);
            }
        } finally {
            c2055d.m5624b(m5629i);
            c2055d.m5623a(m5628h);
            c2055d.m5626c(m5627g);
        }
    }

    /* renamed from: a */
    public <T> T m5569a(String str, Class<T> cls) throws C2072t {
        return (T) C2020m.m5380b((Class) cls).cast(m5568a(str, C2049a.get((Class) cls)));
    }

    /* renamed from: a */
    public <T> T m5570a(String str, Type type) throws C2072t {
        return (T) m5568a(str, C2049a.get(type));
    }

    /* renamed from: a */
    public <T> T m5568a(String str, C2049a<T> c2049a) throws C2072t {
        if (str == null) {
            return null;
        }
        return (T) m5565a(new StringReader(str), c2049a);
    }

    /* renamed from: a */
    public <T> T m5566a(Reader reader, Class<T> cls) throws C2072t, C2064l {
        return (T) C2020m.m5380b((Class) cls).cast(m5565a(reader, C2049a.get((Class) cls)));
    }

    /* renamed from: a */
    public <T> T m5567a(Reader reader, Type type) throws C2064l, C2072t {
        return (T) m5565a(reader, C2049a.get(type));
    }

    /* renamed from: a */
    public <T> T m5565a(Reader reader, C2049a<T> c2049a) throws C2064l, C2072t {
        C2052a m5555a = m5555a(reader);
        T t = (T) m5560a(m5555a, c2049a);
        m5551a(t, m5555a);
        return t;
    }

    /* renamed from: a */
    private static void m5551a(Object obj, C2052a c2052a) {
        if (obj != null) {
            try {
                if (c2052a.peek() == EnumC2054c.END_DOCUMENT) {
                } else {
                    throw new C2072t("JSON document was not fully consumed.");
                }
            } catch (C2056e e2) {
                throw new C2072t(e2);
            } catch (IOException e3) {
                throw new C2064l(e3);
            }
        }
    }

    /* renamed from: a */
    public <T> T m5561a(C2052a c2052a, Type type) throws C2064l, C2072t {
        return (T) m5560a(c2052a, C2049a.get(type));
    }

    /* renamed from: a */
    public <T> T m5560a(C2052a c2052a, C2049a<T> c2049a) throws C2064l, C2072t {
        boolean m5611k = c2052a.m5611k();
        boolean z = true;
        c2052a.m5609a(true);
        try {
            try {
                try {
                    c2052a.peek();
                    z = false;
                    T read = m5557a((C2049a) c2049a).read(c2052a);
                    c2052a.m5609a(m5611k);
                    return read;
                } catch (IOException e2) {
                    throw new C2072t(e2);
                } catch (IllegalStateException e3) {
                    throw new C2072t(e3);
                }
            } catch (EOFException e4) {
                if (z) {
                    c2052a.m5609a(m5611k);
                    return null;
                }
                throw new C2072t(e4);
            } catch (AssertionError e5) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e5.getMessage(), e5);
            }
        } catch (Throwable th) {
            c2052a.m5609a(m5611k);
            throw th;
        }
    }

    /* renamed from: a */
    public <T> T m5563a(AbstractC2063k abstractC2063k, Class<T> cls) throws C2072t {
        return (T) C2020m.m5380b((Class) cls).cast(m5562a(abstractC2063k, C2049a.get((Class) cls)));
    }

    /* renamed from: a */
    public <T> T m5564a(AbstractC2063k abstractC2063k, Type type) throws C2072t {
        return (T) m5562a(abstractC2063k, C2049a.get(type));
    }

    /* renamed from: a */
    public <T> T m5562a(AbstractC2063k abstractC2063k, C2049a<T> c2049a) throws C2072t {
        if (abstractC2063k == null) {
            return null;
        }
        return (T) m5560a(new C2029f(abstractC2063k), c2049a);
    }
}
