package p375l;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import okhttp3.ResponseBody;
import okio.Buffer;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: Utils.java */
/* renamed from: l.p */
/* loaded from: classes2.dex */
final class C5887p {

    /* renamed from: a */
    static final Type[] f21325a = new Type[0];

    /* compiled from: Utils.java */
    /* renamed from: l.p$a */
    private static final class a implements GenericArrayType {

        /* renamed from: a */
        private final Type f21326a;

        a(Type type) {
            this.f21326a = type;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && C5887p.m24854a(this, (GenericArrayType) obj);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f21326a;
        }

        public int hashCode() {
            return this.f21326a.hashCode();
        }

        public String toString() {
            return C5887p.m24860e(this.f21326a) + "[]";
        }
    }

    /* compiled from: Utils.java */
    /* renamed from: l.p$b */
    private static final class b implements ParameterizedType {

        /* renamed from: a */
        private final Type f21327a;

        /* renamed from: b */
        private final Type f21328b;

        /* renamed from: c */
        private final Type[] f21329c;

        b(@Nullable Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                if ((type == null) != (((Class) type2).getEnclosingClass() == null)) {
                    throw new IllegalArgumentException();
                }
            }
            for (Type type3 : typeArr) {
                C5887p.m24845a(type3, "typeArgument == null");
                C5887p.m24853a(type3);
            }
            this.f21327a = type;
            this.f21328b = type2;
            this.f21329c = (Type[]) typeArr.clone();
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && C5887p.m24854a(this, (ParameterizedType) obj);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f21329c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f21327a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f21328b;
        }

        public int hashCode() {
            int hashCode = Arrays.hashCode(this.f21329c) ^ this.f21328b.hashCode();
            Type type = this.f21327a;
            return hashCode ^ (type != null ? type.hashCode() : 0);
        }

        public String toString() {
            Type[] typeArr = this.f21329c;
            if (typeArr.length == 0) {
                return C5887p.m24860e(this.f21328b);
            }
            StringBuilder sb = new StringBuilder((typeArr.length + 1) * 30);
            sb.append(C5887p.m24860e(this.f21328b));
            sb.append("<");
            sb.append(C5887p.m24860e(this.f21329c[0]));
            for (int i2 = 1; i2 < this.f21329c.length; i2++) {
                sb.append(", ");
                sb.append(C5887p.m24860e(this.f21329c[i2]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* compiled from: Utils.java */
    /* renamed from: l.p$c */
    private static final class c implements WildcardType {

        /* renamed from: a */
        private final Type f21330a;

        /* renamed from: b */
        private final Type f21331b;

        c(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr2.length != 1) {
                if (typeArr[0] == null) {
                    throw new NullPointerException();
                }
                C5887p.m24853a(typeArr[0]);
                this.f21331b = null;
                this.f21330a = typeArr[0];
                return;
            }
            if (typeArr2[0] == null) {
                throw new NullPointerException();
            }
            C5887p.m24853a(typeArr2[0]);
            if (typeArr[0] != Object.class) {
                throw new IllegalArgumentException();
            }
            this.f21331b = typeArr2[0];
            this.f21330a = Object.class;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && C5887p.m24854a(this, (WildcardType) obj);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.f21331b;
            return type != null ? new Type[]{type} : C5887p.f21325a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f21330a};
        }

        public int hashCode() {
            Type type = this.f21331b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f21330a.hashCode() + 31);
        }

        public String toString() {
            if (this.f21331b != null) {
                return "? super " + C5887p.m24860e(this.f21331b);
            }
            if (this.f21330a == Object.class) {
                return "?";
            }
            return "? extends " + C5887p.m24860e(this.f21330a);
        }
    }

    private C5887p() {
    }

    /* renamed from: a */
    static boolean m24854a(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            Type ownerType = parameterizedType.getOwnerType();
            Type ownerType2 = parameterizedType2.getOwnerType();
            return (ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return m24854a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    /* renamed from: b */
    static Type m24857b(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return m24848a(type, cls, m24847a(type, cls, cls2));
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: c */
    static Class<?> m24858c(Type type) {
        m24845a(type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            throw new IllegalArgumentException();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(m24858c(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return m24858c(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
    }

    /* renamed from: d */
    static boolean m24859d(@Nullable Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (m24859d(type2)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            return m24859d(((GenericArrayType) type).getGenericComponentType());
        }
        if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
            return true;
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? AbstractC1191a.f2571h : type.getClass().getName()));
    }

    /* renamed from: e */
    static String m24860e(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    /* renamed from: b */
    static Type m24856b(Type type) {
        if (type instanceof ParameterizedType) {
            return m24846a(0, (ParameterizedType) type);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }

    /* renamed from: a */
    static Type m24847a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces2 = cls.getInterfaces();
            int length = interfaces2.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (interfaces2[i2] == cls2) {
                    return cls.getGenericInterfaces()[i2];
                }
                if (cls2.isAssignableFrom(interfaces2[i2])) {
                    return m24847a(cls.getGenericInterfaces()[i2], interfaces2[i2], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return m24847a(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    /* renamed from: a */
    private static int m24843a(Object[] objArr, Object obj) {
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (obj.equals(objArr[i2])) {
                return i2;
            }
        }
        throw new NoSuchElementException();
    }

    /* renamed from: a */
    static Type m24848a(Type type, Class<?> cls, Type type2) {
        Type type3 = type2;
        while (type3 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type3;
            Type m24849a = m24849a(type, cls, (TypeVariable<?>) typeVariable);
            if (m24849a == typeVariable) {
                return m24849a;
            }
            type3 = m24849a;
        }
        if (type3 instanceof Class) {
            Class cls2 = (Class) type3;
            if (cls2.isArray()) {
                Class<?> componentType = cls2.getComponentType();
                Type m24848a = m24848a(type, cls, (Type) componentType);
                return componentType == m24848a ? cls2 : new a(m24848a);
            }
        }
        if (type3 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type3;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            Type m24848a2 = m24848a(type, cls, genericComponentType);
            return genericComponentType == m24848a2 ? genericArrayType : new a(m24848a2);
        }
        if (type3 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type3;
            Type ownerType = parameterizedType.getOwnerType();
            Type m24848a3 = m24848a(type, cls, ownerType);
            boolean z = m24848a3 != ownerType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            for (int i2 = 0; i2 < length; i2++) {
                Type m24848a4 = m24848a(type, cls, actualTypeArguments[i2]);
                if (m24848a4 != actualTypeArguments[i2]) {
                    if (!z) {
                        actualTypeArguments = (Type[]) actualTypeArguments.clone();
                        z = true;
                    }
                    actualTypeArguments[i2] = m24848a4;
                }
            }
            return z ? new b(m24848a3, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
        }
        boolean z2 = type3 instanceof WildcardType;
        Type type4 = type3;
        if (z2) {
            WildcardType wildcardType = (WildcardType) type3;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length == 1) {
                Type m24848a5 = m24848a(type, cls, lowerBounds[0]);
                type4 = wildcardType;
                if (m24848a5 != lowerBounds[0]) {
                    return new c(new Type[]{Object.class}, new Type[]{m24848a5});
                }
            } else {
                type4 = wildcardType;
                if (upperBounds.length == 1) {
                    Type m24848a6 = m24848a(type, cls, upperBounds[0]);
                    type4 = wildcardType;
                    if (m24848a6 != upperBounds[0]) {
                        return new c(new Type[]{m24848a6}, f21325a);
                    }
                }
            }
        }
        return type4;
    }

    /* renamed from: a */
    private static Type m24849a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> m24844a = m24844a(typeVariable);
        if (m24844a == null) {
            return typeVariable;
        }
        Type m24847a = m24847a(type, cls, m24844a);
        if (!(m24847a instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) m24847a).getActualTypeArguments()[m24843a(m24844a.getTypeParameters(), typeVariable)];
    }

    /* renamed from: a */
    private static Class<?> m24844a(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    /* renamed from: a */
    static void m24853a(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    static <T> T m24845a(@Nullable T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: a */
    static boolean m24855a(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    static ResponseBody m24850a(ResponseBody responseBody) throws IOException {
        Buffer buffer = new Buffer();
        responseBody.source().readAll(buffer);
        return ResponseBody.create(responseBody.contentType(), responseBody.contentLength(), buffer);
    }

    /* renamed from: a */
    static <T> void m24851a(Class<T> cls) {
        if (cls.isInterface()) {
            if (cls.getInterfaces().length > 0) {
                throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
            }
            return;
        }
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    /* renamed from: a */
    static Type m24846a(int i2, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i2 >= 0 && i2 < actualTypeArguments.length) {
            Type type = actualTypeArguments[i2];
            return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
        }
        throw new IllegalArgumentException("Index " + i2 + " not in range [0," + actualTypeArguments.length + ") for " + parameterizedType);
    }

    /* renamed from: a */
    static void m24852a(Throwable th) {
        if (!(th instanceof VirtualMachineError)) {
            if (!(th instanceof ThreadDeath)) {
                if (th instanceof LinkageError) {
                    throw ((LinkageError) th);
                }
                return;
            }
            throw ((ThreadDeath) th);
        }
        throw ((VirtualMachineError) th);
    }
}
