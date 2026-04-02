package i.q2.t;

import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ClassReference.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 K2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001KB\u0011\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\u0013\u0010B\u001a\u00020\u00122\b\u0010C\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020GH\u0016J\u0012\u0010H\u001a\u00020\u00122\b\u0010I\u001a\u0004\u0018\u00010\u0002H\u0017J\b\u0010J\u001a\u00020-H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00128VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00128VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00128VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00128VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00128VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u00128VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010 \u001a\u00020\u00128VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b!\u0010\u0014\u001a\u0004\b \u0010\u0015R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001e\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030%0\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u0010R\u001e\u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010\u0010R\u0016\u0010)\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010+R\u0016\u0010,\u001a\u0004\u0018\u00010-8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010/R(\u00100\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\b8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b1\u0010\u0014\u001a\u0004\b2\u0010\u000bR\u0016\u00103\u001a\u0004\u0018\u00010-8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u0010/R \u00105\u001a\b\u0012\u0004\u0012\u0002060\b8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b7\u0010\u0014\u001a\u0004\b8\u0010\u000bR \u00109\u001a\b\u0012\u0004\u0012\u00020:0\b8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b;\u0010\u0014\u001a\u0004\b<\u0010\u000bR\u001c\u0010=\u001a\u0004\u0018\u00010>8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b?\u0010\u0014\u001a\u0004\b@\u0010A\u00a8\u0006L"}, d2 = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "sealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "supertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "typeParameters$annotations", "getTypeParameters", RemoteMessageConst.Notification.VISIBILITY, "Lkotlin/reflect/KVisibility;", "visibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", DispatchConstants.OTHER, "error", "", "hashCode", "", "isInstance", SurveyH5Bean.VALUE, "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
public final class t implements i.w2.c<Object>, s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Class<? extends i.m<?>>, Integer> f12246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final HashMap<String, String> f12247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final HashMap<String, String> f12248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final HashMap<String, String> f12249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Map<String, String> f12250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f12251g = new a(null);

    @j.c.a.d
    private final Class<?> a;

    /* JADX INFO: compiled from: ClassReference.kt */
    public static final class a {
        private a() {
        }

        @j.c.a.e
        public final String a(@j.c.a.d Class<?> cls) {
            String str;
            i0.f(cls, "jClass");
            String str2 = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (!cls.isArray()) {
                String str3 = (String) t.f12249e.get(cls.getName());
                return str3 != null ? str3 : cls.getCanonicalName();
            }
            Class<?> componentType = cls.getComponentType();
            i0.a((Object) componentType, "componentType");
            if (componentType.isPrimitive() && (str = (String) t.f12249e.get(componentType.getName())) != null) {
                str2 = str + "Array";
            }
            return str2 != null ? str2 : "kotlin.Array";
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
        @j.c.a.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String b(@j.c.a.d Class<?> cls) {
            String str;
            String strB;
            i0.f(cls, "jClass");
            String str2 = null;
            if (!cls.isAnonymousClass()) {
                if (cls.isLocalClass()) {
                    String simpleName = cls.getSimpleName();
                    Method enclosingMethod = cls.getEnclosingMethod();
                    if (enclosingMethod != null) {
                        i0.a((Object) simpleName, CommonNetImpl.NAME);
                        strB = i.z2.c0.b(simpleName, enclosingMethod.getName() + "$", (String) null, 2, (Object) null);
                        if (strB == null) {
                            Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
                            if (enclosingConstructor != null) {
                                i0.a((Object) simpleName, CommonNetImpl.NAME);
                                strB = i.z2.c0.b(simpleName, enclosingConstructor.getName() + "$", (String) null, 2, (Object) null);
                            } else {
                                strB = null;
                            }
                        }
                    }
                    if (strB != null) {
                        return strB;
                    }
                    i0.a((Object) simpleName, CommonNetImpl.NAME);
                    return i.z2.c0.a(simpleName, i.z2.h0.f12422b, (String) null, 2, (Object) null);
                }
                if (!cls.isArray()) {
                    String str3 = (String) t.f12250f.get(cls.getName());
                    return str3 != null ? str3 : cls.getSimpleName();
                }
                Class<?> componentType = cls.getComponentType();
                i0.a((Object) componentType, "componentType");
                if (componentType.isPrimitive() && (str = (String) t.f12250f.get(componentType.getName())) != null) {
                    str2 = str + "Array";
                }
                if (str2 == null) {
                    return "Array";
                }
            }
            return str2;
        }

        public /* synthetic */ a(v vVar) {
            this();
        }

        public final boolean a(@j.c.a.e Object obj, @j.c.a.d Class<?> cls) {
            i0.f(cls, "jClass");
            Map map = t.f12246b;
            if (map == null) {
                throw new i.e1("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
            }
            Integer num = (Integer) map.get(cls);
            if (num != null) {
                return n1.b(obj, num.intValue());
            }
            if (cls.isPrimitive()) {
                cls = i.q2.a.b(i.q2.a.a((Class) cls));
            }
            return cls.isInstance(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i2 = 0;
        List listC = i.g2.y.c(i.q2.s.a.class, i.q2.s.l.class, i.q2.s.p.class, i.q2.s.q.class, i.q2.s.r.class, i.q2.s.s.class, i.q2.s.t.class, i.q2.s.u.class, i.q2.s.v.class, i.q2.s.w.class, i.q2.s.b.class, i.q2.s.c.class, i.q2.s.d.class, i.q2.s.e.class, i.q2.s.f.class, i.q2.s.g.class, i.q2.s.h.class, i.q2.s.i.class, i.q2.s.j.class, i.q2.s.k.class, i.q2.s.m.class, i.q2.s.n.class, i.q2.s.o.class);
        ArrayList arrayList = new ArrayList(i.g2.z.a(listC, 10));
        for (Object obj : listC) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                i.g2.y.f();
            }
            arrayList.add(i.c1.a((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        f12246b = i.g2.c1.a(arrayList);
        HashMap<String, String> map = new HashMap<>();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        f12247c = map;
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        f12248d = map2;
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(f12247c);
        map3.putAll(f12248d);
        Collection<String> collectionValues = f12247c.values();
        i0.a((Object) collectionValues, "primitiveFqNames.values");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            i0.a((Object) str, "kotlinName");
            sb.append(i.z2.c0.b(str, '.', (String) null, 2, (Object) null));
            sb.append("CompanionObject");
            i.i0 i0VarA = i.c1.a(sb.toString(), str + ".Companion");
            map3.put(i0VarA.getFirst(), i0VarA.getSecond());
        }
        for (Map.Entry<Class<? extends i.m<?>>, Integer> entry : f12246b.entrySet()) {
            map3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f12249e = map3;
        HashMap<String, String> map4 = f12249e;
        LinkedHashMap linkedHashMap = new LinkedHashMap(i.g2.b1.b(map4.size()));
        Iterator<T> it = map4.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            linkedHashMap.put(entry2.getKey(), i.z2.c0.b((String) entry2.getValue(), '.', (String) null, 2, (Object) null));
        }
        f12250f = linkedHashMap;
    }

    public t(@j.c.a.d Class<?> cls) {
        i0.f(cls, "jClass");
        this.a = cls;
    }

    @i.t0(version = "1.1")
    public static /* synthetic */ void A() {
    }

    @i.t0(version = "1.1")
    public static /* synthetic */ void B() {
    }

    private final Void q() {
        throw new i.q2.l();
    }

    @i.t0(version = "1.1")
    public static /* synthetic */ void r() {
    }

    @i.t0(version = "1.1")
    public static /* synthetic */ void s() {
    }

    @i.t0(version = "1.1")
    public static /* synthetic */ void t() {
    }

    @i.t0(version = "1.1")
    public static /* synthetic */ void u() {
    }

    @i.t0(version = "1.1")
    public static /* synthetic */ void v() {
    }

    @i.t0(version = "1.1")
    public static /* synthetic */ void w() {
    }

    @i.t0(version = "1.1")
    public static /* synthetic */ void x() {
    }

    @i.t0(version = "1.3")
    public static /* synthetic */ void y() {
    }

    @i.t0(version = "1.1")
    public static /* synthetic */ void z() {
    }

    @Override // i.w2.c, i.w2.f
    @j.c.a.d
    public Collection<i.w2.b<?>> a() {
        q();
        throw null;
    }

    @Override // i.w2.c
    @j.c.a.e
    public String b() {
        return f12251g.a(m());
    }

    @Override // i.w2.c
    @j.c.a.d
    public Collection<i.w2.c<?>> c() {
        q();
        throw null;
    }

    @Override // i.w2.c
    @j.c.a.d
    public Collection<i.w2.g<Object>> d() {
        q();
        throw null;
    }

    @Override // i.w2.c
    @j.c.a.d
    public List<i.w2.c<? extends Object>> e() {
        q();
        throw null;
    }

    @Override // i.w2.c
    public boolean equals(@j.c.a.e Object obj) {
        return (obj instanceof t) && i0.a(i.q2.a.b(this), i.q2.a.b((i.w2.c) obj));
    }

    @Override // i.w2.c
    public boolean f() {
        q();
        throw null;
    }

    @Override // i.w2.c
    @j.c.a.e
    public String g() {
        return f12251g.b(m());
    }

    @Override // i.w2.a
    @j.c.a.d
    public List<Annotation> getAnnotations() {
        q();
        throw null;
    }

    @Override // i.w2.c
    @j.c.a.d
    public List<i.w2.r> getTypeParameters() {
        q();
        throw null;
    }

    @Override // i.w2.c
    @j.c.a.e
    public i.w2.u getVisibility() {
        q();
        throw null;
    }

    @Override // i.w2.c
    @j.c.a.d
    public List<i.w2.q> h() {
        q();
        throw null;
    }

    @Override // i.w2.c
    public int hashCode() {
        return i.q2.a.b(this).hashCode();
    }

    @Override // i.w2.c
    @j.c.a.e
    public Object i() {
        q();
        throw null;
    }

    @Override // i.w2.c
    public boolean isAbstract() {
        q();
        throw null;
    }

    @Override // i.w2.c
    public boolean isFinal() {
        q();
        throw null;
    }

    @Override // i.w2.c
    public boolean isOpen() {
        q();
        throw null;
    }

    @Override // i.w2.c
    public boolean j() {
        q();
        throw null;
    }

    @Override // i.w2.c
    public boolean k() {
        q();
        throw null;
    }

    @Override // i.w2.c
    public boolean l() {
        q();
        throw null;
    }

    @Override // i.q2.t.s
    @j.c.a.d
    public Class<?> m() {
        return this.a;
    }

    @j.c.a.d
    public String toString() {
        return m().toString() + " (Kotlin reflection is not available)";
    }

    @Override // i.w2.c
    @i.t0(version = "1.1")
    public boolean a(@j.c.a.e Object obj) {
        return f12251g.a(obj, m());
    }
}
