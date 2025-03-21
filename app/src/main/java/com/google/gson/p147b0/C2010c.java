package com.google.gson.p147b0;

import com.google.gson.C2064l;
import com.google.gson.InterfaceC2059g;
import com.google.gson.InterfaceC2074v;
import com.google.gson.p147b0.p150s.C2041a;
import com.google.gson.p152d0.C2049a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* compiled from: ConstructorConstructor.java */
/* renamed from: com.google.gson.b0.c */
/* loaded from: classes.dex */
public final class C2010c {

    /* renamed from: a */
    private final Map<Type, InterfaceC2059g<?>> f5649a;

    /* renamed from: b */
    private final boolean f5650b;

    /* renamed from: c */
    private final List<InterfaceC2074v> f5651c;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.b0.c$a */
    class a<T> implements InterfaceC2018k<T> {
        a() {
        }

        @Override // com.google.gson.p147b0.InterfaceC2018k
        /* renamed from: a */
        public T mo5339a() {
            return (T) new TreeSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.b0.c$b */
    class b<T> implements InterfaceC2018k<T> {
        b() {
        }

        @Override // com.google.gson.p147b0.InterfaceC2018k
        /* renamed from: a */
        public T mo5339a() {
            return (T) new LinkedHashSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.b0.c$c */
    class c<T> implements InterfaceC2018k<T> {
        c() {
        }

        @Override // com.google.gson.p147b0.InterfaceC2018k
        /* renamed from: a */
        public T mo5339a() {
            return (T) new ArrayDeque();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.b0.c$d */
    class d<T> implements InterfaceC2018k<T> {
        d() {
        }

        @Override // com.google.gson.p147b0.InterfaceC2018k
        /* renamed from: a */
        public T mo5339a() {
            return (T) new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.b0.c$e */
    class e<T> implements InterfaceC2018k<T> {
        e() {
        }

        @Override // com.google.gson.p147b0.InterfaceC2018k
        /* renamed from: a */
        public T mo5339a() {
            return (T) new ConcurrentSkipListMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.b0.c$f */
    class f<T> implements InterfaceC2018k<T> {
        f() {
        }

        @Override // com.google.gson.p147b0.InterfaceC2018k
        /* renamed from: a */
        public T mo5339a() {
            return (T) new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.b0.c$g */
    class g<T> implements InterfaceC2018k<T> {
        g() {
        }

        @Override // com.google.gson.p147b0.InterfaceC2018k
        /* renamed from: a */
        public T mo5339a() {
            return (T) new TreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.b0.c$h */
    class h<T> implements InterfaceC2018k<T> {
        h() {
        }

        @Override // com.google.gson.p147b0.InterfaceC2018k
        /* renamed from: a */
        public T mo5339a() {
            return (T) new LinkedHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.b0.c$i */
    class i<T> implements InterfaceC2018k<T> {
        i() {
        }

        @Override // com.google.gson.p147b0.InterfaceC2018k
        /* renamed from: a */
        public T mo5339a() {
            return (T) new C2016i();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.b0.c$j */
    class j<T> implements InterfaceC2018k<T> {

        /* renamed from: a */
        final /* synthetic */ Class f5652a;

        j(Class cls) {
            this.f5652a = cls;
        }

        @Override // com.google.gson.p147b0.InterfaceC2018k
        /* renamed from: a */
        public T mo5339a() {
            try {
                return (T) AbstractC2023p.f5713a.mo5397a(this.f5652a);
            } catch (Exception e2) {
                throw new RuntimeException("Unable to create instance of " + this.f5652a + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e2);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.b0.c$k */
    class k<T> implements InterfaceC2018k<T> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC2059g f5654a;

        /* renamed from: b */
        final /* synthetic */ Type f5655b;

        k(InterfaceC2059g interfaceC2059g, Type type) {
            this.f5654a = interfaceC2059g;
            this.f5655b = type;
        }

        @Override // com.google.gson.p147b0.InterfaceC2018k
        /* renamed from: a */
        public T mo5339a() {
            return (T) this.f5654a.m5659a(this.f5655b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.b0.c$l */
    class l<T> implements InterfaceC2018k<T> {

        /* renamed from: a */
        final /* synthetic */ String f5657a;

        l(String str) {
            this.f5657a = str;
        }

        @Override // com.google.gson.p147b0.InterfaceC2018k
        /* renamed from: a */
        public T mo5339a() {
            throw new C2064l(this.f5657a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.b0.c$m */
    class m<T> implements InterfaceC2018k<T> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC2059g f5659a;

        /* renamed from: b */
        final /* synthetic */ Type f5660b;

        m(InterfaceC2059g interfaceC2059g, Type type) {
            this.f5659a = interfaceC2059g;
            this.f5660b = type;
        }

        @Override // com.google.gson.p147b0.InterfaceC2018k
        /* renamed from: a */
        public T mo5339a() {
            return (T) this.f5659a.m5659a(this.f5660b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.b0.c$n */
    class n<T> implements InterfaceC2018k<T> {

        /* renamed from: a */
        final /* synthetic */ String f5662a;

        n(String str) {
            this.f5662a = str;
        }

        @Override // com.google.gson.p147b0.InterfaceC2018k
        /* renamed from: a */
        public T mo5339a() {
            throw new C2064l(this.f5662a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.b0.c$o */
    class o<T> implements InterfaceC2018k<T> {

        /* renamed from: a */
        final /* synthetic */ String f5664a;

        o(String str) {
            this.f5664a = str;
        }

        @Override // com.google.gson.p147b0.InterfaceC2018k
        /* renamed from: a */
        public T mo5339a() {
            throw new C2064l(this.f5664a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.b0.c$p */
    class p<T> implements InterfaceC2018k<T> {

        /* renamed from: a */
        final /* synthetic */ Type f5666a;

        p(Type type) {
            this.f5666a = type;
        }

        @Override // com.google.gson.p147b0.InterfaceC2018k
        /* renamed from: a */
        public T mo5339a() {
            Type type = this.f5666a;
            if (!(type instanceof ParameterizedType)) {
                throw new C2064l("Invalid EnumSet type: " + this.f5666a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) EnumSet.noneOf((Class) type2);
            }
            throw new C2064l("Invalid EnumSet type: " + this.f5666a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.b0.c$q */
    class q<T> implements InterfaceC2018k<T> {

        /* renamed from: a */
        final /* synthetic */ Type f5667a;

        q(Type type) {
            this.f5667a = type;
        }

        @Override // com.google.gson.p147b0.InterfaceC2018k
        /* renamed from: a */
        public T mo5339a() {
            Type type = this.f5667a;
            if (!(type instanceof ParameterizedType)) {
                throw new C2064l("Invalid EnumMap type: " + this.f5667a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) new EnumMap((Class) type2);
            }
            throw new C2064l("Invalid EnumMap type: " + this.f5667a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.b0.c$r */
    class r<T> implements InterfaceC2018k<T> {

        /* renamed from: a */
        final /* synthetic */ String f5668a;

        r(String str) {
            this.f5668a = str;
        }

        @Override // com.google.gson.p147b0.InterfaceC2018k
        /* renamed from: a */
        public T mo5339a() {
            throw new C2064l(this.f5668a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.b0.c$s */
    class s<T> implements InterfaceC2018k<T> {

        /* renamed from: a */
        final /* synthetic */ String f5669a;

        s(String str) {
            this.f5669a = str;
        }

        @Override // com.google.gson.p147b0.InterfaceC2018k
        /* renamed from: a */
        public T mo5339a() {
            throw new C2064l(this.f5669a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.b0.c$t */
    class t<T> implements InterfaceC2018k<T> {

        /* renamed from: a */
        final /* synthetic */ Constructor f5670a;

        t(Constructor constructor) {
            this.f5670a = constructor;
        }

        @Override // com.google.gson.p147b0.InterfaceC2018k
        /* renamed from: a */
        public T mo5339a() {
            try {
                return (T) this.f5670a.newInstance(new Object[0]);
            } catch (IllegalAccessException e2) {
                throw C2041a.m5527a(e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Failed to invoke constructor '" + C2041a.m5530a((Constructor<?>) this.f5670a) + "' with no args", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to invoke constructor '" + C2041a.m5530a((Constructor<?>) this.f5670a) + "' with no args", e4.getCause());
            }
        }
    }

    public C2010c(Map<Type, InterfaceC2059g<?>> map, boolean z, List<InterfaceC2074v> list) {
        this.f5649a = map;
        this.f5650b = z;
        this.f5651c = list;
    }

    /* renamed from: a */
    static String m5335a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName();
    }

    /* renamed from: b */
    private static <T> InterfaceC2018k<T> m5337b(Type type, Class<? super T> cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new p(type);
        }
        if (cls == EnumMap.class) {
            return new q(type);
        }
        return null;
    }

    public String toString() {
        return this.f5649a.toString();
    }

    /* renamed from: b */
    private <T> InterfaceC2018k<T> m5336b(Class<? super T> cls) {
        if (this.f5650b) {
            return new j(cls);
        }
        return new l("Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    /* renamed from: a */
    public <T> InterfaceC2018k<T> m5338a(C2049a<T> c2049a) {
        Type type = c2049a.getType();
        Class<? super T> rawType = c2049a.getRawType();
        InterfaceC2059g<?> interfaceC2059g = this.f5649a.get(type);
        if (interfaceC2059g != null) {
            return new k(interfaceC2059g, type);
        }
        InterfaceC2059g<?> interfaceC2059g2 = this.f5649a.get(rawType);
        if (interfaceC2059g2 != null) {
            return new m(interfaceC2059g2, type);
        }
        InterfaceC2018k<T> m5337b = m5337b(type, rawType);
        if (m5337b != null) {
            return m5337b;
        }
        InterfaceC2074v.e m5382a = C2021n.m5382a(this.f5651c, rawType);
        InterfaceC2018k<T> m5333a = m5333a(rawType, m5382a);
        if (m5333a != null) {
            return m5333a;
        }
        InterfaceC2018k<T> m5334a = m5334a(type, rawType);
        if (m5334a != null) {
            return m5334a;
        }
        String m5335a = m5335a(rawType);
        if (m5335a != null) {
            return new n(m5335a);
        }
        if (m5382a == InterfaceC2074v.e.ALLOW) {
            return m5336b(rawType);
        }
        return new o("Unable to create instance of " + rawType + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    }

    /* renamed from: a */
    private static <T> InterfaceC2018k<T> m5333a(Class<? super T> cls, InterfaceC2074v.e eVar) {
        String m5537b;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        boolean z = false;
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (eVar == InterfaceC2074v.e.ALLOW || (C2021n.m5385a(declaredConstructor, (Object) null) && (eVar != InterfaceC2074v.e.BLOCK_ALL || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                z = true;
            }
            if (!z) {
                return new r("Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
            }
            if (eVar == InterfaceC2074v.e.ALLOW && (m5537b = C2041a.m5537b(declaredConstructor)) != null) {
                return new s(m5537b);
            }
            return new t(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static <T> InterfaceC2018k<T> m5334a(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new a();
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new b();
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new c();
            }
            return new d();
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new e();
        }
        if (ConcurrentMap.class.isAssignableFrom(cls)) {
            return new f();
        }
        if (SortedMap.class.isAssignableFrom(cls)) {
            return new g();
        }
        if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(C2049a.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
            return new h();
        }
        return new i();
    }
}
