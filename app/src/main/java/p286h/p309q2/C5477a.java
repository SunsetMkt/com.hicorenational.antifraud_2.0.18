package p286h.p309q2;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Annotation;
import p286h.C5226e1;
import p286h.EnumC5220d;
import p286h.InterfaceC5216c;
import p286h.InterfaceC5467o0;
import p286h.p309q2.p311t.C5542h1;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.InterfaceC5580s;
import p286h.p320w2.InterfaceC5662c;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: JvmClassMapping.kt */
@InterfaceC5481e(name = "JvmClassMappingKt")
/* renamed from: h.q2.a */
/* loaded from: classes2.dex */
public final class C5477a {
    @InterfaceC5481e(name = "getJavaClass")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> Class<T> m22455a(@InterfaceC5816d InterfaceC5662c<T> interfaceC5662c) {
        C5544i0.m22546f(interfaceC5662c, "$this$java");
        Class<T> cls = (Class<T>) ((InterfaceC5580s) interfaceC5662c).mo22654m();
        if (cls != null) {
            return cls;
        }
        throw new C5226e1("null cannot be cast to non-null type java.lang.Class<T>");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @InterfaceC5816d
    /* renamed from: b */
    public static final <T> Class<T> m22458b(@InterfaceC5816d InterfaceC5662c<T> interfaceC5662c) {
        C5544i0.m22546f(interfaceC5662c, "$this$javaObjectType");
        Class<T> cls = (Class<T>) ((InterfaceC5580s) interfaceC5662c).mo22654m();
        if (!cls.isPrimitive()) {
            if (cls != null) {
                return cls;
            }
            throw new C5226e1("null cannot be cast to non-null type java.lang.Class<T>");
        }
        String name = cls.getName();
        if (name != null) {
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        cls = (Class<T>) Double.class;
                        break;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        cls = (Class<T>) Integer.class;
                        break;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        cls = (Class<T>) Byte.class;
                        break;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        cls = (Class<T>) Character.class;
                        break;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        cls = (Class<T>) Long.class;
                        break;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        cls = (Class<T>) Void.class;
                        break;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        cls = (Class<T>) Boolean.class;
                        break;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        cls = (Class<T>) Float.class;
                        break;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        cls = (Class<T>) Short.class;
                        break;
                    }
                    break;
            }
        }
        if (cls != null) {
            return cls;
        }
        throw new C5226e1("null cannot be cast to non-null type java.lang.Class<T>");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @InterfaceC5817e
    /* renamed from: c */
    public static final <T> Class<T> m22459c(@InterfaceC5816d InterfaceC5662c<T> interfaceC5662c) {
        C5544i0.m22546f(interfaceC5662c, "$this$javaPrimitiveType");
        Class<T> cls = (Class<T>) ((InterfaceC5580s) interfaceC5662c).mo22654m();
        if (cls.isPrimitive()) {
            if (cls != null) {
                return cls;
            }
            throw new C5226e1("null cannot be cast to non-null type java.lang.Class<T>");
        }
        String name = cls.getName();
        if (name != null) {
            switch (name.hashCode()) {
                case -2056817302:
                    if (name.equals("java.lang.Integer")) {
                        return Integer.TYPE;
                    }
                    break;
                case -527879800:
                    if (name.equals("java.lang.Float")) {
                        return Float.TYPE;
                    }
                    break;
                case -515992664:
                    if (name.equals("java.lang.Short")) {
                        return Short.TYPE;
                    }
                    break;
                case 155276373:
                    if (name.equals("java.lang.Character")) {
                        return Character.TYPE;
                    }
                    break;
                case 344809556:
                    if (name.equals("java.lang.Boolean")) {
                        return Boolean.TYPE;
                    }
                    break;
                case 398507100:
                    if (name.equals("java.lang.Byte")) {
                        return Byte.TYPE;
                    }
                    break;
                case 398795216:
                    if (name.equals("java.lang.Long")) {
                        return Long.TYPE;
                    }
                    break;
                case 399092968:
                    if (name.equals("java.lang.Void")) {
                        return Void.TYPE;
                    }
                    break;
                case 761287205:
                    if (name.equals("java.lang.Double")) {
                        return Double.TYPE;
                    }
                    break;
            }
        }
        return null;
    }

    @InterfaceC5481e(name = "getRuntimeClassOfKClassInstance")
    @InterfaceC5816d
    /* renamed from: d */
    public static final <T> Class<InterfaceC5662c<T>> m22460d(@InterfaceC5816d InterfaceC5662c<T> interfaceC5662c) {
        C5544i0.m22546f(interfaceC5662c, "$this$javaClass");
        Class<InterfaceC5662c<T>> cls = (Class<InterfaceC5662c<T>>) interfaceC5662c.getClass();
        if (cls != null) {
            return cls;
        }
        throw new C5226e1("null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T>>");
    }

    /* renamed from: e */
    public static /* synthetic */ void m22461e(InterfaceC5662c interfaceC5662c) {
    }

    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @InterfaceC5467o0(expression = "(this as Any).javaClass", imports = {}))
    /* renamed from: f */
    public static /* synthetic */ void m22462f(InterfaceC5662c interfaceC5662c) {
    }

    @InterfaceC5481e(name = "getKotlinClass")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> InterfaceC5662c<T> m22453a(@InterfaceC5816d Class<T> cls) {
        C5544i0.m22546f(cls, "$this$kotlin");
        return C5542h1.m22496b(cls);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> Class<T> m22456a(@InterfaceC5816d T t) {
        C5544i0.m22546f(t, "$this$javaClass");
        Class<T> cls = (Class<T>) t.getClass();
        if (cls != null) {
            return cls;
        }
        throw new C5226e1("null cannot be cast to non-null type java.lang.Class<T>");
    }

    /* renamed from: a */
    public static final /* synthetic */ <T> boolean m22457a(@InterfaceC5816d Object[] objArr) {
        C5544i0.m22546f(objArr, "$this$isArrayOf");
        C5544i0.m22518a(4, ExifInterface.GPS_DIRECTION_TRUE);
        return Object.class.isAssignableFrom(objArr.getClass().getComponentType());
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T extends Annotation> InterfaceC5662c<? extends T> m22454a(@InterfaceC5816d T t) {
        C5544i0.m22546f(t, "$this$annotationClass");
        Class<? extends Annotation> annotationType = t.annotationType();
        C5544i0.m22521a((Object) annotationType, "(this as java.lang.annot…otation).annotationType()");
        InterfaceC5662c<? extends T> m22453a = m22453a((Class) annotationType);
        if (m22453a != null) {
            return m22453a;
        }
        throw new C5226e1("null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
    }
}
