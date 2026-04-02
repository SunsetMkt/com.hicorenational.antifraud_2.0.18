package com.google.gson.b0.q;

import com.google.gson.t;
import com.google.gson.v;
import com.google.gson.y;
import com.google.gson.z;
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

/* JADX INFO: compiled from: ReflectiveTypeAdapterFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class k implements z {
    private final com.google.gson.b0.c a;

    /* JADX INFO: renamed from: b */
    private final com.google.gson.d f3696b;

    /* JADX INFO: renamed from: c */
    private final com.google.gson.b0.d f3697c;

    /* JADX INFO: renamed from: d */
    private final com.google.gson.b0.q.e f3698d;

    /* JADX INFO: renamed from: e */
    private final List<v> f3699e;

    /* JADX INFO: compiled from: ReflectiveTypeAdapterFactory.java */
    public static abstract class b<T, A> extends y<T> {
        final Map<String, c> a;

        b(Map<String, c> map) {
            this.a = map;
        }

        abstract A a();

        abstract T a(A a);

        abstract void a(A a, com.google.gson.e0.a aVar, c cVar) throws IllegalAccessException, IOException;

        @Override // com.google.gson.y
        public T read(com.google.gson.e0.a aVar) throws IOException {
            if (aVar.peek() == com.google.gson.e0.c.NULL) {
                aVar.r();
                return null;
            }
            A a = a();
            try {
                aVar.d();
                while (aVar.j()) {
                    c cVar = this.a.get(aVar.q());
                    if (cVar == null || !cVar.f3712e) {
                        aVar.t();
                    } else {
                        a(a, aVar, cVar);
                    }
                }
                aVar.g();
                return a(a);
            } catch (IllegalAccessException e2) {
                throw com.google.gson.b0.s.a.a(e2);
            } catch (IllegalStateException e3) {
                throw new t(e3);
            }
        }

        @Override // com.google.gson.y
        public void write(com.google.gson.e0.d dVar, T t) throws IOException {
            if (t == null) {
                dVar.j();
                return;
            }
            dVar.d();
            try {
                Iterator<c> it = this.a.values().iterator();
                while (it.hasNext()) {
                    it.next().a(dVar, t);
                }
                dVar.f();
            } catch (IllegalAccessException e2) {
                throw com.google.gson.b0.s.a.a(e2);
            }
        }
    }

    /* JADX INFO: compiled from: ReflectiveTypeAdapterFactory.java */
    static abstract class c {
        final String a;

        /* JADX INFO: renamed from: b */
        final Field f3709b;

        /* JADX INFO: renamed from: c */
        final String f3710c;

        /* JADX INFO: renamed from: d */
        final boolean f3711d;

        /* JADX INFO: renamed from: e */
        final boolean f3712e;

        protected c(String str, Field field, boolean z, boolean z2) {
            this.a = str;
            this.f3709b = field;
            this.f3710c = field.getName();
            this.f3711d = z;
            this.f3712e = z2;
        }

        abstract void a(com.google.gson.e0.a aVar, int i2, Object[] objArr) throws com.google.gson.n, IOException;

        abstract void a(com.google.gson.e0.a aVar, Object obj) throws IllegalAccessException, IOException;

        abstract void a(com.google.gson.e0.d dVar, Object obj) throws IllegalAccessException, IOException;
    }

    /* JADX INFO: compiled from: ReflectiveTypeAdapterFactory.java */
    private static final class d<T> extends b<T, T> {

        /* JADX INFO: renamed from: b */
        private final com.google.gson.b0.k<T> f3713b;

        d(com.google.gson.b0.k<T> kVar, Map<String, c> map) {
            super(map);
            this.f3713b = kVar;
        }

        @Override // com.google.gson.b0.q.k.b
        T a() {
            return this.f3713b.a();
        }

        @Override // com.google.gson.b0.q.k.b
        T a(T t) {
            return t;
        }

        @Override // com.google.gson.b0.q.k.b
        void a(T t, com.google.gson.e0.a aVar, c cVar) throws IllegalAccessException, IOException {
            cVar.a(aVar, t);
        }
    }

    public k(com.google.gson.b0.c cVar, com.google.gson.d dVar, com.google.gson.b0.d dVar2, com.google.gson.b0.q.e eVar, List<v> list) {
        this.a = cVar;
        this.f3696b = dVar;
        this.f3697c = dVar2;
        this.f3698d = eVar;
        this.f3699e = list;
    }

    public static <M extends AccessibleObject & Member> void b(Object obj, M m2) {
        if (Modifier.isStatic(m2.getModifiers())) {
            obj = null;
        }
        if (com.google.gson.b0.n.a(m2, obj)) {
            return;
        }
        throw new com.google.gson.l(com.google.gson.b0.s.a.a((AccessibleObject) m2, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    @Override // com.google.gson.z
    public <T> y<T> create(com.google.gson.e eVar, com.google.gson.d0.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        v.e eVarA = com.google.gson.b0.n.a(this.f3699e, rawType);
        if (eVarA != v.e.BLOCK_ALL) {
            boolean z = eVarA == v.e.BLOCK_INACCESSIBLE;
            return com.google.gson.b0.s.a.c(rawType) ? new e(rawType, a(eVar, aVar, rawType, z, true), z) : new d(this.a.a(aVar), a(eVar, aVar, rawType, z, false));
        }
        throw new com.google.gson.l("ReflectionAccessFilter does not permit using reflection for " + rawType + ". Register a TypeAdapter for this type or adjust the access filter.");
    }

    private boolean a(Field field, boolean z) {
        return (this.f3697c.a(field.getType(), z) || this.f3697c.a(field, z)) ? false : true;
    }

    /* JADX INFO: compiled from: ReflectiveTypeAdapterFactory.java */
    private static final class e<T> extends b<T, Object[]> {

        /* JADX INFO: renamed from: e */
        static final Map<Class<?>, Object> f3714e = b();

        /* JADX INFO: renamed from: b */
        private final Constructor<T> f3715b;

        /* JADX INFO: renamed from: c */
        private final Object[] f3716c;

        /* JADX INFO: renamed from: d */
        private final Map<String, Integer> f3717d;

        e(Class<T> cls, Map<String, c> map, boolean z) {
            super(map);
            this.f3717d = new HashMap();
            this.f3715b = com.google.gson.b0.s.a.a(cls);
            if (z) {
                k.b(null, this.f3715b);
            } else {
                com.google.gson.b0.s.a.a(this.f3715b);
            }
            String[] strArrB = com.google.gson.b0.s.a.b((Class<?>) cls);
            for (int i2 = 0; i2 < strArrB.length; i2++) {
                this.f3717d.put(strArrB[i2], Integer.valueOf(i2));
            }
            Class<?>[] parameterTypes = this.f3715b.getParameterTypes();
            this.f3716c = new Object[parameterTypes.length];
            for (int i3 = 0; i3 < parameterTypes.length; i3++) {
                this.f3716c[i3] = f3714e.get(parameterTypes[i3]);
            }
        }

        private static Map<Class<?>, Object> b() {
            HashMap map = new HashMap();
            map.put(Byte.TYPE, (byte) 0);
            map.put(Short.TYPE, (short) 0);
            map.put(Integer.TYPE, 0);
            map.put(Long.TYPE, 0L);
            map.put(Float.TYPE, Float.valueOf(0.0f));
            map.put(Double.TYPE, Double.valueOf(0.0d));
            map.put(Character.TYPE, (char) 0);
            map.put(Boolean.TYPE, false);
            return map;
        }

        @Override // com.google.gson.b0.q.k.b
        public Object[] a() {
            return (Object[]) this.f3716c.clone();
        }

        @Override // com.google.gson.b0.q.k.b
        public void a(Object[] objArr, com.google.gson.e0.a aVar, c cVar) throws IOException {
            Integer num = this.f3717d.get(cVar.f3710c);
            if (num != null) {
                cVar.a(aVar, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + com.google.gson.b0.s.a.a((Constructor<?>) this.f3715b) + "' for field with name '" + cVar.f3710c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }

        @Override // com.google.gson.b0.q.k.b
        public T a(Object[] objArr) {
            try {
                return this.f3715b.newInstance(objArr);
            } catch (IllegalAccessException e2) {
                throw com.google.gson.b0.s.a.a(e2);
            } catch (IllegalArgumentException e3) {
                e = e3;
                throw new RuntimeException("Failed to invoke constructor '" + com.google.gson.b0.s.a.a((Constructor<?>) this.f3715b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InstantiationException e4) {
                e = e4;
                throw new RuntimeException("Failed to invoke constructor '" + com.google.gson.b0.s.a.a((Constructor<?>) this.f3715b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Failed to invoke constructor '" + com.google.gson.b0.s.a.a((Constructor<?>) this.f3715b) + "' with args " + Arrays.toString(objArr), e5.getCause());
            }
        }
    }

    private List<String> a(Field field) {
        com.google.gson.a0.c cVar = (com.google.gson.a0.c) field.getAnnotation(com.google.gson.a0.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f3696b.translateName(field));
        }
        String strValue = cVar.value();
        String[] strArrAlternate = cVar.alternate();
        if (strArrAlternate.length == 0) {
            return Collections.singletonList(strValue);
        }
        ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        Collections.addAll(arrayList, strArrAlternate);
        return arrayList;
    }

    private c a(com.google.gson.e eVar, Field field, Method method, String str, com.google.gson.d0.a<?> aVar, boolean z, boolean z2, boolean z3) {
        boolean zA = com.google.gson.b0.m.a((Type) aVar.getRawType());
        int modifiers = field.getModifiers();
        boolean z4 = Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
        com.google.gson.a0.b bVar = (com.google.gson.a0.b) field.getAnnotation(com.google.gson.a0.b.class);
        y<?> yVarA = bVar != null ? this.f3698d.a(this.a, eVar, aVar, bVar) : null;
        return new a(str, field, z, z2, z3, method, yVarA != null, yVarA == null ? eVar.a((com.google.gson.d0.a) aVar) : yVarA, eVar, aVar, zA, z4);
    }

    /* JADX INFO: compiled from: ReflectiveTypeAdapterFactory.java */
    class a extends c {

        /* JADX INFO: renamed from: f */
        final /* synthetic */ boolean f3700f;

        /* JADX INFO: renamed from: g */
        final /* synthetic */ Method f3701g;

        /* JADX INFO: renamed from: h */
        final /* synthetic */ boolean f3702h;

        /* JADX INFO: renamed from: i */
        final /* synthetic */ y f3703i;

        /* JADX INFO: renamed from: j */
        final /* synthetic */ com.google.gson.e f3704j;

        /* JADX INFO: renamed from: k */
        final /* synthetic */ com.google.gson.d0.a f3705k;

        /* JADX INFO: renamed from: l */
        final /* synthetic */ boolean f3706l;

        /* JADX INFO: renamed from: m */
        final /* synthetic */ boolean f3707m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Field field, boolean z, boolean z2, boolean z3, Method method, boolean z4, y yVar, com.google.gson.e eVar, com.google.gson.d0.a aVar, boolean z5, boolean z6) {
            super(str, field, z, z2);
            this.f3700f = z3;
            this.f3701g = method;
            this.f3702h = z4;
            this.f3703i = yVar;
            this.f3704j = eVar;
            this.f3705k = aVar;
            this.f3706l = z5;
            this.f3707m = z6;
        }

        @Override // com.google.gson.b0.q.k.c
        void a(com.google.gson.e0.d dVar, Object obj) throws IllegalAccessException, IOException {
            Object objInvoke;
            if (this.f3711d) {
                if (this.f3700f) {
                    Method method = this.f3701g;
                    if (method == null) {
                        k.b(obj, this.f3709b);
                    } else {
                        k.b(obj, method);
                    }
                }
                Method method2 = this.f3701g;
                if (method2 != null) {
                    try {
                        objInvoke = method2.invoke(obj, new Object[0]);
                    } catch (InvocationTargetException e2) {
                        throw new com.google.gson.l("Accessor " + com.google.gson.b0.s.a.a((AccessibleObject) this.f3701g, false) + " threw exception", e2.getCause());
                    }
                } else {
                    objInvoke = this.f3709b.get(obj);
                }
                if (objInvoke == obj) {
                    return;
                }
                dVar.b(this.a);
                (this.f3702h ? this.f3703i : new n(this.f3704j, this.f3703i, this.f3705k.getType())).write(dVar, objInvoke);
            }
        }

        @Override // com.google.gson.b0.q.k.c
        void a(com.google.gson.e0.a aVar, int i2, Object[] objArr) throws com.google.gson.n, IOException {
            Object obj = this.f3703i.read(aVar);
            if (obj == null && this.f3706l) {
                throw new com.google.gson.n("null is not allowed as value for record component '" + this.f3710c + "' of primitive type; at path " + aVar.h());
            }
            objArr[i2] = obj;
        }

        @Override // com.google.gson.b0.q.k.c
        void a(com.google.gson.e0.a aVar, Object obj) throws IllegalAccessException, IOException {
            Object obj2 = this.f3703i.read(aVar);
            if (obj2 == null && this.f3706l) {
                return;
            }
            if (this.f3700f) {
                k.b(obj, this.f3709b);
            } else if (this.f3707m) {
                throw new com.google.gson.l("Cannot set value of 'static final' " + com.google.gson.b0.s.a.a((AccessibleObject) this.f3709b, false));
            }
            this.f3709b.set(obj, obj2);
        }
    }

    private Map<String, c> a(com.google.gson.e eVar, com.google.gson.d0.a<?> aVar, Class<?> cls, boolean z, boolean z2) {
        boolean z3;
        Method method;
        int i2;
        int i3;
        k kVar = this;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        com.google.gson.d0.a<?> aVar2 = aVar;
        boolean z4 = z;
        Class<?> rawType = cls;
        while (rawType != Object.class) {
            Field[] declaredFields = rawType.getDeclaredFields();
            boolean z5 = true;
            boolean z6 = false;
            if (rawType != cls && declaredFields.length > 0) {
                v.e eVarA = com.google.gson.b0.n.a(kVar.f3699e, rawType);
                if (eVarA != v.e.BLOCK_ALL) {
                    z4 = eVarA == v.e.BLOCK_INACCESSIBLE;
                } else {
                    throw new com.google.gson.l("ReflectionAccessFilter does not permit using reflection for " + rawType + " (supertype of " + cls + "). Register a TypeAdapter for this type or adjust the access filter.");
                }
            }
            boolean z7 = z4;
            int length = declaredFields.length;
            int i4 = 0;
            while (i4 < length) {
                Field field = declaredFields[i4];
                boolean zA = kVar.a(field, z5);
                boolean zA2 = kVar.a(field, z6);
                if (zA || zA2) {
                    if (!z2) {
                        z3 = zA2;
                        method = null;
                    } else if (Modifier.isStatic(field.getModifiers())) {
                        method = null;
                        z3 = false;
                    } else {
                        Method methodA = com.google.gson.b0.s.a.a(rawType, field);
                        if (!z7) {
                            com.google.gson.b0.s.a.a(methodA);
                        }
                        if (methodA.getAnnotation(com.google.gson.a0.c.class) != null && field.getAnnotation(com.google.gson.a0.c.class) == null) {
                            throw new com.google.gson.l("@SerializedName on " + com.google.gson.b0.s.a.a(methodA, z6) + " is not supported");
                        }
                        z3 = zA2;
                        method = methodA;
                    }
                    if (!z7 && method == null) {
                        com.google.gson.b0.s.a.a((AccessibleObject) field);
                    }
                    Type typeA = com.google.gson.b0.b.a(aVar2.getType(), rawType, field.getGenericType());
                    List<String> listA = kVar.a(field);
                    int size = listA.size();
                    c cVar = null;
                    int i5 = 0;
                    while (i5 < size) {
                        String str = listA.get(i5);
                        boolean z8 = i5 != 0 ? false : zA;
                        c cVar2 = cVar;
                        int i6 = i5;
                        int i7 = size;
                        List<String> list = listA;
                        Field field2 = field;
                        int i8 = i4;
                        int i9 = length;
                        cVar = cVar2 == null ? (c) linkedHashMap.put(str, a(eVar, field, method, str, com.google.gson.d0.a.get(typeA), z8, z3, z7)) : cVar2;
                        i5 = i6 + 1;
                        zA = z8;
                        i4 = i8;
                        size = i7;
                        listA = list;
                        field = field2;
                        length = i9;
                    }
                    c cVar3 = cVar;
                    Field field3 = field;
                    i2 = i4;
                    i3 = length;
                    if (cVar3 != null) {
                        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + cVar3.a + "'; conflict is caused by fields " + com.google.gson.b0.s.a.a(cVar3.f3709b) + " and " + com.google.gson.b0.s.a.a(field3));
                    }
                } else {
                    i2 = i4;
                    i3 = length;
                }
                i4 = i2 + 1;
                z6 = false;
                z5 = true;
                kVar = this;
                length = i3;
            }
            aVar2 = com.google.gson.d0.a.get(com.google.gson.b0.b.a(aVar2.getType(), rawType, rawType.getGenericSuperclass()));
            rawType = aVar2.getRawType();
            kVar = this;
            z4 = z7;
        }
        return linkedHashMap;
    }
}
