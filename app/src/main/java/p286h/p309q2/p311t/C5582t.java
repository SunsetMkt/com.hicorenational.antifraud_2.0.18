package p286h.p309q2.p311t;

import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p286h.C5218c1;
import p286h.C5226e1;
import p286h.C5334i0;
import p286h.InterfaceC5418m;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p289g2.C5248b1;
import p286h.p289g2.C5251c1;
import p286h.p289g2.C5315y;
import p286h.p289g2.C5318z;
import p286h.p309q2.C5477a;
import p286h.p309q2.C5488l;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p310s.InterfaceC5496b;
import p286h.p309q2.p310s.InterfaceC5497c;
import p286h.p309q2.p310s.InterfaceC5498d;
import p286h.p309q2.p310s.InterfaceC5499e;
import p286h.p309q2.p310s.InterfaceC5500f;
import p286h.p309q2.p310s.InterfaceC5501g;
import p286h.p309q2.p310s.InterfaceC5502h;
import p286h.p309q2.p310s.InterfaceC5503i;
import p286h.p309q2.p310s.InterfaceC5504j;
import p286h.p309q2.p310s.InterfaceC5505k;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p310s.InterfaceC5507m;
import p286h.p309q2.p310s.InterfaceC5508n;
import p286h.p309q2.p310s.InterfaceC5509o;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p310s.InterfaceC5511q;
import p286h.p309q2.p310s.InterfaceC5512r;
import p286h.p309q2.p310s.InterfaceC5513s;
import p286h.p309q2.p310s.InterfaceC5514t;
import p286h.p309q2.p310s.InterfaceC5515u;
import p286h.p309q2.p310s.InterfaceC5516v;
import p286h.p309q2.p310s.InterfaceC5517w;
import p286h.p320w2.EnumC5680u;
import p286h.p320w2.InterfaceC5661b;
import p286h.p320w2.InterfaceC5662c;
import p286h.p320w2.InterfaceC5666g;
import p286h.p320w2.InterfaceC5676q;
import p286h.p320w2.InterfaceC5677r;
import p286h.p323z2.C5726c0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: ClassReference.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 K2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001KB\u0011\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010B\u001a\u00020\u00122\b\u0010C\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020GH\u0016J\u0012\u0010H\u001a\u00020\u00122\b\u0010I\u001a\u0004\u0018\u00010\u0002H\u0017J\b\u0010J\u001a\u00020-H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010 \u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0014\u001a\u0004\b \u0010\u0015R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001e\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030%0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0010R\u001e\u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0010R\u0016\u0010)\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0016\u0010,\u001a\u0004\u0018\u00010-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R(\u00100\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b1\u0010\u0014\u001a\u0004\b2\u0010\u000bR\u0016\u00103\u001a\u0004\u0018\u00010-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010/R \u00105\u001a\b\u0012\u0004\u0012\u0002060\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0014\u001a\u0004\b8\u0010\u000bR \u00109\u001a\b\u0012\u0004\u0012\u00020:0\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0014\u001a\u0004\b<\u0010\u000bR\u001c\u0010=\u001a\u0004\u0018\u00010>8VX\u0097\u0004¢\u0006\f\u0012\u0004\b?\u0010\u0014\u001a\u0004\b@\u0010A¨\u0006L"}, m23546d2 = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "sealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "supertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "typeParameters$annotations", "getTypeParameters", RemoteMessageConst.Notification.VISIBILITY, "Lkotlin/reflect/KVisibility;", "visibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", DispatchConstants.OTHER, "error", "", "hashCode", "", "isInstance", SurveyH5Bean.VALUE, "toString", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.q2.t.t */
/* loaded from: classes2.dex */
public final class C5582t implements InterfaceC5662c<Object>, InterfaceC5580s {

    /* renamed from: b */
    private static final Map<Class<? extends InterfaceC5418m<?>>, Integer> f20426b;

    /* renamed from: c */
    private static final HashMap<String, String> f20427c;

    /* renamed from: d */
    private static final HashMap<String, String> f20428d;

    /* renamed from: e */
    private static final HashMap<String, String> f20429e;

    /* renamed from: f */
    private static final Map<String, String> f20430f;

    /* renamed from: g */
    public static final a f20431g = new a(null);

    /* renamed from: a */
    @InterfaceC5816d
    private final Class<?> f20432a;

    /* compiled from: ClassReference.kt */
    /* renamed from: h.q2.t.t$a */
    public static final class a {
        private a() {
        }

        @InterfaceC5817e
        /* renamed from: a */
        public final String m22683a(@InterfaceC5816d Class<?> cls) {
            String str;
            C5544i0.m22546f(cls, "jClass");
            String str2 = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (!cls.isArray()) {
                String str3 = (String) C5582t.f20429e.get(cls.getName());
                return str3 != null ? str3 : cls.getCanonicalName();
            }
            Class<?> componentType = cls.getComponentType();
            C5544i0.m22521a((Object) componentType, "componentType");
            if (componentType.isPrimitive() && (str = (String) C5582t.f20429e.get(componentType.getName())) != null) {
                str2 = str + "Array";
            }
            return str2 != null ? str2 : "kotlin.Array";
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
        
            if (r1 != null) goto L16;
         */
        @p324i.p336c.p337a.InterfaceC5817e
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String m22685b(@p324i.p336c.p337a.InterfaceC5816d java.lang.Class<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "jClass"
                p286h.p309q2.p311t.C5544i0.m22546f(r8, r0)
                boolean r0 = r8.isAnonymousClass()
                java.lang.String r1 = "Array"
                r2 = 0
                if (r0 == 0) goto L11
            Le:
                r1 = r2
                goto Lc2
            L11:
                boolean r0 = r8.isLocalClass()
                if (r0 == 0) goto L73
                java.lang.String r0 = r8.getSimpleName()
                java.lang.reflect.Method r1 = r8.getEnclosingMethod()
                java.lang.String r3 = "$"
                r4 = 2
                java.lang.String r5 = "name"
                if (r1 == 0) goto L43
                p286h.p309q2.p311t.C5544i0.m22521a(r0, r5)
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r1 = r1.getName()
                r6.append(r1)
                r6.append(r3)
                java.lang.String r1 = r6.toString()
                java.lang.String r1 = p286h.p323z2.C5748s.m24067b(r0, r1, r2, r4, r2)
                if (r1 == 0) goto L43
                goto L66
            L43:
                java.lang.reflect.Constructor r8 = r8.getEnclosingConstructor()
                if (r8 == 0) goto L65
                p286h.p309q2.p311t.C5544i0.m22521a(r0, r5)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r8 = r8.getName()
                r1.append(r8)
                r1.append(r3)
                java.lang.String r8 = r1.toString()
                java.lang.String r8 = p286h.p323z2.C5748s.m24067b(r0, r8, r2, r4, r2)
                r1 = r8
                goto L66
            L65:
                r1 = r2
            L66:
                if (r1 == 0) goto L69
                goto Lc2
            L69:
                p286h.p309q2.p311t.C5544i0.m22521a(r0, r5)
                r8 = 36
                java.lang.String r1 = p286h.p323z2.C5748s.m24060a(r0, r8, r2, r4, r2)
                goto Lc2
            L73:
                boolean r0 = r8.isArray()
                if (r0 == 0) goto Lac
                java.lang.Class r8 = r8.getComponentType()
                java.lang.String r0 = "componentType"
                p286h.p309q2.p311t.C5544i0.m22521a(r8, r0)
                boolean r0 = r8.isPrimitive()
                if (r0 == 0) goto La8
                java.util.Map r0 = p286h.p309q2.p311t.C5582t.m22659p()
                java.lang.String r8 = r8.getName()
                java.lang.Object r8 = r0.get(r8)
                java.lang.String r8 = (java.lang.String) r8
                if (r8 == 0) goto La8
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r8)
                r0.append(r1)
                java.lang.String r8 = r0.toString()
                r2 = r8
            La8:
                if (r2 == 0) goto Lc2
                goto Le
            Lac:
                java.util.Map r0 = p286h.p309q2.p311t.C5582t.m22659p()
                java.lang.String r1 = r8.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 == 0) goto Lbe
                goto Lc2
            Lbe:
                java.lang.String r1 = r8.getSimpleName()
            Lc2:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p286h.p309q2.p311t.C5582t.a.m22685b(java.lang.Class):java.lang.String");
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }

        /* renamed from: a */
        public final boolean m22684a(@InterfaceC5817e Object obj, @InterfaceC5816d Class<?> cls) {
            C5544i0.m22546f(cls, "jClass");
            Map map = C5582t.f20426b;
            if (map == null) {
                throw new C5226e1("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
            }
            Integer num = (Integer) map.get(cls);
            if (num != null) {
                return C5560n1.m22594b(obj, num.intValue());
            }
            if (cls.isPrimitive()) {
                cls = C5477a.m22458b(C5477a.m22453a((Class) cls));
            }
            return cls.isInstance(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List m21783c;
        Map<Class<? extends InterfaceC5418m<?>>, Integer> m19587a;
        int m19562b;
        String m23735b;
        String m23735b2;
        int i2 = 0;
        m21783c = C5315y.m21783c(InterfaceC5495a.class, InterfaceC5506l.class, InterfaceC5510p.class, InterfaceC5511q.class, InterfaceC5512r.class, InterfaceC5513s.class, InterfaceC5514t.class, InterfaceC5515u.class, InterfaceC5516v.class, InterfaceC5517w.class, InterfaceC5496b.class, InterfaceC5497c.class, InterfaceC5498d.class, InterfaceC5499e.class, InterfaceC5500f.class, InterfaceC5501g.class, InterfaceC5502h.class, InterfaceC5503i.class, InterfaceC5504j.class, InterfaceC5505k.class, InterfaceC5507m.class, InterfaceC5508n.class, InterfaceC5509o.class);
        ArrayList arrayList = new ArrayList(C5318z.m21796a(m21783c, 10));
        for (Object obj : m21783c) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                C5315y.m21790f();
            }
            arrayList.add(C5218c1.m18838a((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        m19587a = C5251c1.m19587a(arrayList);
        f20426b = m19587a;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f20427c = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f20428d = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(f20427c);
        hashMap3.putAll(f20428d);
        Collection<String> values = f20427c.values();
        C5544i0.m22521a((Object) values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            C5544i0.m22521a((Object) str, "kotlinName");
            m23735b2 = C5726c0.m23735b(str, '.', (String) null, 2, (Object) null);
            sb.append(m23735b2);
            sb.append("CompanionObject");
            C5334i0 m18838a = C5218c1.m18838a(sb.toString(), str + ".Companion");
            hashMap3.put(m18838a.getFirst(), m18838a.getSecond());
        }
        for (Map.Entry<Class<? extends InterfaceC5418m<?>>, Integer> entry : f20426b.entrySet()) {
            hashMap3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f20429e = hashMap3;
        HashMap<String, String> hashMap4 = f20429e;
        m19562b = C5248b1.m19562b(hashMap4.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(m19562b);
        Iterator<T> it = hashMap4.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            Object key = entry2.getKey();
            m23735b = C5726c0.m23735b((String) entry2.getValue(), '.', (String) null, 2, (Object) null);
            linkedHashMap.put(key, m23735b);
        }
        f20430f = linkedHashMap;
    }

    public C5582t(@InterfaceC5816d Class<?> cls) {
        C5544i0.m22546f(cls, "jClass");
        this.f20432a = cls;
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: A */
    public static /* synthetic */ void m22655A() {
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: B */
    public static /* synthetic */ void m22656B() {
    }

    /* renamed from: q */
    private final Void m22660q() {
        throw new C5488l();
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: r */
    public static /* synthetic */ void m22661r() {
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: s */
    public static /* synthetic */ void m22662s() {
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: t */
    public static /* synthetic */ void m22663t() {
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: u */
    public static /* synthetic */ void m22664u() {
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: v */
    public static /* synthetic */ void m22665v() {
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: w */
    public static /* synthetic */ void m22666w() {
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: x */
    public static /* synthetic */ void m22667x() {
    }

    @InterfaceC5610t0(version = "1.3")
    /* renamed from: y */
    public static /* synthetic */ void m22668y() {
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: z */
    public static /* synthetic */ void m22669z() {
    }

    @Override // p286h.p320w2.InterfaceC5662c, p286h.p320w2.InterfaceC5665f
    @InterfaceC5816d
    /* renamed from: a */
    public Collection<InterfaceC5661b<?>> mo22670a() {
        m22660q();
        throw null;
    }

    @Override // p286h.p320w2.InterfaceC5662c
    @InterfaceC5817e
    /* renamed from: b */
    public String mo22672b() {
        return f20431g.m22683a(mo22654m());
    }

    @Override // p286h.p320w2.InterfaceC5662c
    @InterfaceC5816d
    /* renamed from: c */
    public Collection<InterfaceC5662c<?>> mo22673c() {
        m22660q();
        throw null;
    }

    @Override // p286h.p320w2.InterfaceC5662c
    @InterfaceC5816d
    /* renamed from: d */
    public Collection<InterfaceC5666g<Object>> mo22674d() {
        m22660q();
        throw null;
    }

    @Override // p286h.p320w2.InterfaceC5662c
    @InterfaceC5816d
    /* renamed from: e */
    public List<InterfaceC5662c<? extends Object>> mo22675e() {
        m22660q();
        throw null;
    }

    @Override // p286h.p320w2.InterfaceC5662c
    public boolean equals(@InterfaceC5817e Object obj) {
        return (obj instanceof C5582t) && C5544i0.m22531a(C5477a.m22458b(this), C5477a.m22458b((InterfaceC5662c) obj));
    }

    @Override // p286h.p320w2.InterfaceC5662c
    /* renamed from: f */
    public boolean mo22676f() {
        m22660q();
        throw null;
    }

    @Override // p286h.p320w2.InterfaceC5662c
    @InterfaceC5817e
    /* renamed from: g */
    public String mo22677g() {
        return f20431g.m22685b(mo22654m());
    }

    @Override // p286h.p320w2.InterfaceC5660a
    @InterfaceC5816d
    public List<Annotation> getAnnotations() {
        m22660q();
        throw null;
    }

    @Override // p286h.p320w2.InterfaceC5662c
    @InterfaceC5816d
    public List<InterfaceC5677r> getTypeParameters() {
        m22660q();
        throw null;
    }

    @Override // p286h.p320w2.InterfaceC5662c
    @InterfaceC5817e
    public EnumC5680u getVisibility() {
        m22660q();
        throw null;
    }

    @Override // p286h.p320w2.InterfaceC5662c
    @InterfaceC5816d
    /* renamed from: h */
    public List<InterfaceC5676q> mo22678h() {
        m22660q();
        throw null;
    }

    @Override // p286h.p320w2.InterfaceC5662c
    public int hashCode() {
        return C5477a.m22458b(this).hashCode();
    }

    @Override // p286h.p320w2.InterfaceC5662c
    @InterfaceC5817e
    /* renamed from: i */
    public Object mo22679i() {
        m22660q();
        throw null;
    }

    @Override // p286h.p320w2.InterfaceC5662c
    public boolean isAbstract() {
        m22660q();
        throw null;
    }

    @Override // p286h.p320w2.InterfaceC5662c
    public boolean isFinal() {
        m22660q();
        throw null;
    }

    @Override // p286h.p320w2.InterfaceC5662c
    public boolean isOpen() {
        m22660q();
        throw null;
    }

    @Override // p286h.p320w2.InterfaceC5662c
    /* renamed from: j */
    public boolean mo22680j() {
        m22660q();
        throw null;
    }

    @Override // p286h.p320w2.InterfaceC5662c
    /* renamed from: k */
    public boolean mo22681k() {
        m22660q();
        throw null;
    }

    @Override // p286h.p320w2.InterfaceC5662c
    /* renamed from: l */
    public boolean mo22682l() {
        m22660q();
        throw null;
    }

    @Override // p286h.p309q2.p311t.InterfaceC5580s
    @InterfaceC5816d
    /* renamed from: m */
    public Class<?> mo22654m() {
        return this.f20432a;
    }

    @InterfaceC5816d
    public String toString() {
        return mo22654m().toString() + " (Kotlin reflection is not available)";
    }

    @Override // p286h.p320w2.InterfaceC5662c
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    public boolean mo22671a(@InterfaceC5817e Object obj) {
        return f20431g.m22684a(obj, mo22654m());
    }
}
