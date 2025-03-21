package com.google.gson.p147b0.p148q;

import com.google.gson.AbstractC2077y;
import com.google.gson.C2051e;
import com.google.gson.C2064l;
import com.google.gson.C2066n;
import com.google.gson.C2072t;
import com.google.gson.InterfaceC2048d;
import com.google.gson.InterfaceC2074v;
import com.google.gson.InterfaceC2078z;
import com.google.gson.p146a0.InterfaceC2002b;
import com.google.gson.p146a0.InterfaceC2003c;
import com.google.gson.p147b0.C2009b;
import com.google.gson.p147b0.C2010c;
import com.google.gson.p147b0.C2011d;
import com.google.gson.p147b0.C2020m;
import com.google.gson.p147b0.C2021n;
import com.google.gson.p147b0.InterfaceC2018k;
import com.google.gson.p147b0.p150s.C2041a;
import com.google.gson.p152d0.C2049a;
import com.google.gson.p153e0.C2052a;
import com.google.gson.p153e0.C2055d;
import com.google.gson.p153e0.EnumC2054c;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ReflectiveTypeAdapterFactory.java */
/* renamed from: com.google.gson.b0.q.k */
/* loaded from: classes.dex */
public final class C2034k implements InterfaceC2078z {

    /* renamed from: a */
    private final C2010c f5760a;

    /* renamed from: b */
    private final InterfaceC2048d f5761b;

    /* renamed from: c */
    private final C2011d f5762c;

    /* renamed from: d */
    private final C2028e f5763d;

    /* renamed from: e */
    private final List<InterfaceC2074v> f5764e;

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* renamed from: com.google.gson.b0.q.k$b */
    public static abstract class b<T, A> extends AbstractC2077y<T> {

        /* renamed from: a */
        final Map<String, c> f5774a;

        b(Map<String, c> map) {
            this.f5774a = map;
        }

        /* renamed from: a */
        abstract A mo5469a();

        /* renamed from: a */
        abstract T mo5470a(A a2);

        /* renamed from: a */
        abstract void mo5471a(A a2, C2052a c2052a, c cVar) throws IllegalAccessException, IOException;

        @Override // com.google.gson.AbstractC2077y
        /* renamed from: read */
        public T read2(C2052a c2052a) throws IOException {
            if (c2052a.peek() == EnumC2054c.NULL) {
                c2052a.mo5429r();
                return null;
            }
            A mo5469a = mo5469a();
            try {
                c2052a.mo5418d();
                while (c2052a.mo5423j()) {
                    c cVar = this.f5774a.get(c2052a.mo5428q());
                    if (cVar != null && cVar.f5779e) {
                        mo5471a(mo5469a, c2052a, cVar);
                    }
                    c2052a.mo5431t();
                }
                c2052a.mo5420g();
                return mo5470a(mo5469a);
            } catch (IllegalAccessException e2) {
                throw C2041a.m5527a(e2);
            } catch (IllegalStateException e3) {
                throw new C2072t(e3);
            }
        }

        @Override // com.google.gson.AbstractC2077y
        public void write(C2055d c2055d, T t) throws IOException {
            if (t == null) {
                c2055d.mo5448j();
                return;
            }
            c2055d.mo5443d();
            try {
                Iterator<c> it = this.f5774a.values().iterator();
                while (it.hasNext()) {
                    it.next().mo5468a(c2055d, t);
                }
                c2055d.mo5447f();
            } catch (IllegalAccessException e2) {
                throw C2041a.m5527a(e2);
            }
        }
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* renamed from: com.google.gson.b0.q.k$c */
    static abstract class c {

        /* renamed from: a */
        final String f5775a;

        /* renamed from: b */
        final Field f5776b;

        /* renamed from: c */
        final String f5777c;

        /* renamed from: d */
        final boolean f5778d;

        /* renamed from: e */
        final boolean f5779e;

        protected c(String str, Field field, boolean z, boolean z2) {
            this.f5775a = str;
            this.f5776b = field;
            this.f5777c = field.getName();
            this.f5778d = z;
            this.f5779e = z2;
        }

        /* renamed from: a */
        abstract void mo5466a(C2052a c2052a, int i2, Object[] objArr) throws IOException, C2066n;

        /* renamed from: a */
        abstract void mo5467a(C2052a c2052a, Object obj) throws IOException, IllegalAccessException;

        /* renamed from: a */
        abstract void mo5468a(C2055d c2055d, Object obj) throws IOException, IllegalAccessException;
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* renamed from: com.google.gson.b0.q.k$d */
    private static final class d<T> extends b<T, T> {

        /* renamed from: b */
        private final InterfaceC2018k<T> f5780b;

        d(InterfaceC2018k<T> interfaceC2018k, Map<String, c> map) {
            super(map);
            this.f5780b = interfaceC2018k;
        }

        @Override // com.google.gson.p147b0.p148q.C2034k.b
        /* renamed from: a */
        T mo5469a() {
            return this.f5780b.mo5339a();
        }

        @Override // com.google.gson.p147b0.p148q.C2034k.b
        /* renamed from: a */
        T mo5470a(T t) {
            return t;
        }

        @Override // com.google.gson.p147b0.p148q.C2034k.b
        /* renamed from: a */
        void mo5471a(T t, C2052a c2052a, c cVar) throws IllegalAccessException, IOException {
            cVar.mo5467a(c2052a, t);
        }
    }

    public C2034k(C2010c c2010c, InterfaceC2048d interfaceC2048d, C2011d c2011d, C2028e c2028e, List<InterfaceC2074v> list) {
        this.f5760a = c2010c;
        this.f5761b = interfaceC2048d;
        this.f5762c = c2011d;
        this.f5763d = c2028e;
        this.f5764e = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static <M extends AccessibleObject & Member> void m5465b(Object obj, M m2) {
        if (Modifier.isStatic(m2.getModifiers())) {
            obj = null;
        }
        if (C2021n.m5385a(m2, obj)) {
            return;
        }
        throw new C2064l(C2041a.m5529a((AccessibleObject) m2, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    @Override // com.google.gson.InterfaceC2078z
    public <T> AbstractC2077y<T> create(C2051e c2051e, C2049a<T> c2049a) {
        Class<? super T> rawType = c2049a.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        InterfaceC2074v.e m5382a = C2021n.m5382a(this.f5764e, rawType);
        if (m5382a != InterfaceC2074v.e.BLOCK_ALL) {
            boolean z = m5382a == InterfaceC2074v.e.BLOCK_INACCESSIBLE;
            return C2041a.m5539c(rawType) ? new e(rawType, m5462a(c2051e, c2049a, rawType, z, true), z) : new d(this.f5760a.m5338a(c2049a), m5462a(c2051e, c2049a, rawType, z, false));
        }
        throw new C2064l("ReflectionAccessFilter does not permit using reflection for " + rawType + ". Register a TypeAdapter for this type or adjust the access filter.");
    }

    /* renamed from: a */
    private boolean m5464a(Field field, boolean z) {
        return (this.f5762c.m5352a(field.getType(), z) || this.f5762c.m5353a(field, z)) ? false : true;
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* renamed from: com.google.gson.b0.q.k$e */
    private static final class e<T> extends b<T, Object[]> {

        /* renamed from: e */
        static final Map<Class<?>, Object> f5781e = m5472b();

        /* renamed from: b */
        private final Constructor<T> f5782b;

        /* renamed from: c */
        private final Object[] f5783c;

        /* renamed from: d */
        private final Map<String, Integer> f5784d;

        e(Class<T> cls, Map<String, c> map, boolean z) {
            super(map);
            this.f5784d = new HashMap();
            this.f5782b = C2041a.m5532a(cls);
            if (z) {
                C2034k.m5465b(null, this.f5782b);
            } else {
                C2041a.m5534a(this.f5782b);
            }
            String[] m5538b = C2041a.m5538b((Class<?>) cls);
            for (int i2 = 0; i2 < m5538b.length; i2++) {
                this.f5784d.put(m5538b[i2], Integer.valueOf(i2));
            }
            Class<?>[] parameterTypes = this.f5782b.getParameterTypes();
            this.f5783c = new Object[parameterTypes.length];
            for (int i3 = 0; i3 < parameterTypes.length; i3++) {
                this.f5783c[i3] = f5781e.get(parameterTypes[i3]);
            }
        }

        /* renamed from: b */
        private static Map<Class<?>, Object> m5472b() {
            HashMap hashMap = new HashMap();
            hashMap.put(Byte.TYPE, (byte) 0);
            hashMap.put(Short.TYPE, (short) 0);
            hashMap.put(Integer.TYPE, 0);
            hashMap.put(Long.TYPE, 0L);
            hashMap.put(Float.TYPE, Float.valueOf(0.0f));
            hashMap.put(Double.TYPE, Double.valueOf(0.0d));
            hashMap.put(Character.TYPE, (char) 0);
            hashMap.put(Boolean.TYPE, false);
            return hashMap;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.gson.p147b0.p148q.C2034k.b
        /* renamed from: a, reason: avoid collision after fix types in other method */
        public Object[] mo5469a() {
            return (Object[]) this.f5783c.clone();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.gson.p147b0.p148q.C2034k.b
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo5471a(Object[] objArr, C2052a c2052a, c cVar) throws IOException {
            Integer num = this.f5784d.get(cVar.f5777c);
            if (num != null) {
                cVar.mo5466a(c2052a, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + C2041a.m5530a((Constructor<?>) this.f5782b) + "' for field with name '" + cVar.f5777c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.gson.p147b0.p148q.C2034k.b
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public T mo5470a(Object[] objArr) {
            try {
                return this.f5782b.newInstance(objArr);
            } catch (IllegalAccessException e2) {
                throw C2041a.m5527a(e2);
            } catch (IllegalArgumentException e3) {
                e = e3;
                throw new RuntimeException("Failed to invoke constructor '" + C2041a.m5530a((Constructor<?>) this.f5782b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InstantiationException e4) {
                e = e4;
                throw new RuntimeException("Failed to invoke constructor '" + C2041a.m5530a((Constructor<?>) this.f5782b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Failed to invoke constructor '" + C2041a.m5530a((Constructor<?>) this.f5782b) + "' with args " + Arrays.toString(objArr), e5.getCause());
            }
        }
    }

    /* renamed from: a */
    private List<String> m5461a(Field field) {
        InterfaceC2003c interfaceC2003c = (InterfaceC2003c) field.getAnnotation(InterfaceC2003c.class);
        if (interfaceC2003c == null) {
            return Collections.singletonList(this.f5761b.translateName(field));
        }
        String value = interfaceC2003c.value();
        String[] alternate = interfaceC2003c.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        Collections.addAll(arrayList, alternate);
        return arrayList;
    }

    /* renamed from: a */
    private c m5460a(C2051e c2051e, Field field, Method method, String str, C2049a<?> c2049a, boolean z, boolean z2, boolean z3) {
        boolean m5379a = C2020m.m5379a((Type) c2049a.getRawType());
        int modifiers = field.getModifiers();
        boolean z4 = Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
        InterfaceC2002b interfaceC2002b = (InterfaceC2002b) field.getAnnotation(InterfaceC2002b.class);
        AbstractC2077y<?> m5409a = interfaceC2002b != null ? this.f5763d.m5409a(this.f5760a, c2051e, c2049a, interfaceC2002b) : null;
        return new a(str, field, z, z2, z3, method, m5409a != null, m5409a == null ? c2051e.m5557a((C2049a) c2049a) : m5409a, c2051e, c2049a, m5379a, z4);
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* renamed from: com.google.gson.b0.q.k$a */
    class a extends c {

        /* renamed from: f */
        final /* synthetic */ boolean f5765f;

        /* renamed from: g */
        final /* synthetic */ Method f5766g;

        /* renamed from: h */
        final /* synthetic */ boolean f5767h;

        /* renamed from: i */
        final /* synthetic */ AbstractC2077y f5768i;

        /* renamed from: j */
        final /* synthetic */ C2051e f5769j;

        /* renamed from: k */
        final /* synthetic */ C2049a f5770k;

        /* renamed from: l */
        final /* synthetic */ boolean f5771l;

        /* renamed from: m */
        final /* synthetic */ boolean f5772m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Field field, boolean z, boolean z2, boolean z3, Method method, boolean z4, AbstractC2077y abstractC2077y, C2051e c2051e, C2049a c2049a, boolean z5, boolean z6) {
            super(str, field, z, z2);
            this.f5765f = z3;
            this.f5766g = method;
            this.f5767h = z4;
            this.f5768i = abstractC2077y;
            this.f5769j = c2051e;
            this.f5770k = c2049a;
            this.f5771l = z5;
            this.f5772m = z6;
        }

        @Override // com.google.gson.p147b0.p148q.C2034k.c
        /* renamed from: a */
        void mo5468a(C2055d c2055d, Object obj) throws IOException, IllegalAccessException {
            Object obj2;
            if (this.f5778d) {
                if (this.f5765f) {
                    Method method = this.f5766g;
                    if (method == null) {
                        C2034k.m5465b(obj, this.f5776b);
                    } else {
                        C2034k.m5465b(obj, method);
                    }
                }
                Method method2 = this.f5766g;
                if (method2 != null) {
                    try {
                        obj2 = method2.invoke(obj, new Object[0]);
                    } catch (InvocationTargetException e2) {
                        throw new C2064l("Accessor " + C2041a.m5529a((AccessibleObject) this.f5766g, false) + " threw exception", e2.getCause());
                    }
                } else {
                    obj2 = this.f5776b.get(obj);
                }
                if (obj2 == obj) {
                    return;
                }
                c2055d.mo5441b(this.f5775a);
                (this.f5767h ? this.f5768i : new C2037n(this.f5769j, this.f5768i, this.f5770k.getType())).write(c2055d, obj2);
            }
        }

        @Override // com.google.gson.p147b0.p148q.C2034k.c
        /* renamed from: a */
        void mo5466a(C2052a c2052a, int i2, Object[] objArr) throws IOException, C2066n {
            Object read2 = this.f5768i.read2(c2052a);
            if (read2 == null && this.f5771l) {
                throw new C2066n("null is not allowed as value for record component '" + this.f5777c + "' of primitive type; at path " + c2052a.mo5421h());
            }
            objArr[i2] = read2;
        }

        @Override // com.google.gson.p147b0.p148q.C2034k.c
        /* renamed from: a */
        void mo5467a(C2052a c2052a, Object obj) throws IOException, IllegalAccessException {
            Object read2 = this.f5768i.read2(c2052a);
            if (read2 == null && this.f5771l) {
                return;
            }
            if (this.f5765f) {
                C2034k.m5465b(obj, this.f5776b);
            } else if (this.f5772m) {
                throw new C2064l("Cannot set value of 'static final' " + C2041a.m5529a((AccessibleObject) this.f5776b, false));
            }
            this.f5776b.set(obj, read2);
        }
    }

    /* renamed from: a */
    private Map<String, c> m5462a(C2051e c2051e, C2049a<?> c2049a, Class<?> cls, boolean z, boolean z2) {
        boolean z3;
        Method method;
        int i2;
        int i3;
        C2034k c2034k = this;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        C2049a<?> c2049a2 = c2049a;
        boolean z4 = z;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            boolean z5 = true;
            boolean z6 = false;
            if (cls2 != cls && declaredFields.length > 0) {
                InterfaceC2074v.e m5382a = C2021n.m5382a(c2034k.f5764e, cls2);
                if (m5382a != InterfaceC2074v.e.BLOCK_ALL) {
                    z4 = m5382a == InterfaceC2074v.e.BLOCK_INACCESSIBLE;
                } else {
                    throw new C2064l("ReflectionAccessFilter does not permit using reflection for " + cls2 + " (supertype of " + cls + "). Register a TypeAdapter for this type or adjust the access filter.");
                }
            }
            boolean z7 = z4;
            int length = declaredFields.length;
            int i4 = 0;
            while (i4 < length) {
                Field field = declaredFields[i4];
                boolean m5464a = c2034k.m5464a(field, z5);
                boolean m5464a2 = c2034k.m5464a(field, z6);
                if (m5464a || m5464a2) {
                    if (!z2) {
                        z3 = m5464a2;
                        method = null;
                    } else if (Modifier.isStatic(field.getModifiers())) {
                        method = null;
                        z3 = false;
                    } else {
                        Method m5533a = C2041a.m5533a(cls2, field);
                        if (!z7) {
                            C2041a.m5534a(m5533a);
                        }
                        if (m5533a.getAnnotation(InterfaceC2003c.class) != null && field.getAnnotation(InterfaceC2003c.class) == null) {
                            throw new C2064l("@SerializedName on " + C2041a.m5529a(m5533a, z6) + " is not supported");
                        }
                        z3 = m5464a2;
                        method = m5533a;
                    }
                    if (!z7 && method == null) {
                        C2041a.m5534a((AccessibleObject) field);
                    }
                    Type m5318a = C2009b.m5318a(c2049a2.getType(), cls2, field.getGenericType());
                    List<String> m5461a = c2034k.m5461a(field);
                    int size = m5461a.size();
                    c cVar = null;
                    int i5 = 0;
                    while (i5 < size) {
                        String str = m5461a.get(i5);
                        boolean z8 = i5 != 0 ? false : m5464a;
                        c cVar2 = cVar;
                        int i6 = i5;
                        int i7 = size;
                        List<String> list = m5461a;
                        Field field2 = field;
                        int i8 = i4;
                        int i9 = length;
                        cVar = cVar2 == null ? (c) linkedHashMap.put(str, m5460a(c2051e, field, method, str, C2049a.get(m5318a), z8, z3, z7)) : cVar2;
                        i5 = i6 + 1;
                        m5464a = z8;
                        i4 = i8;
                        size = i7;
                        m5461a = list;
                        field = field2;
                        length = i9;
                    }
                    c cVar3 = cVar;
                    Field field3 = field;
                    i2 = i4;
                    i3 = length;
                    if (cVar3 != null) {
                        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + cVar3.f5775a + "'; conflict is caused by fields " + C2041a.m5531a(cVar3.f5776b) + " and " + C2041a.m5531a(field3));
                    }
                } else {
                    i2 = i4;
                    i3 = length;
                }
                i4 = i2 + 1;
                z6 = false;
                z5 = true;
                c2034k = this;
                length = i3;
            }
            c2049a2 = C2049a.get(C2009b.m5318a(c2049a2.getType(), cls2, cls2.getGenericSuperclass()));
            cls2 = c2049a2.getRawType();
            c2034k = this;
            z4 = z7;
        }
        return linkedHashMap;
    }
}
