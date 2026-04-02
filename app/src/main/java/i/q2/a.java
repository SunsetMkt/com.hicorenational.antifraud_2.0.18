package i.q2;

import androidx.exifinterface.media.ExifInterface;
import i.e1;
import i.o0;
import i.q2.t.h1;
import i.q2.t.i0;
import i.q2.t.s;
import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: JvmClassMapping.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(name = "JvmClassMappingKt")
public final class a {
    @e(name = "getJavaClass")
    @j.c.a.d
    public static final <T> Class<T> a(@j.c.a.d i.w2.c<T> cVar) {
        i0.f(cVar, "$this$java");
        Class<T> cls = (Class<T>) ((s) cVar).m();
        if (cls != null) {
            return cls;
        }
        throw new e1("null cannot be cast to non-null type java.lang.Class<T>");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @j.c.a.d
    public static final <T> Class<T> b(@j.c.a.d i.w2.c<T> cVar) {
        i0.f(cVar, "$this$javaObjectType");
        Class<T> cls = (Class<T>) ((s) cVar).m();
        if (!cls.isPrimitive()) {
            if (cls != null) {
                return cls;
            }
            throw new e1("null cannot be cast to non-null type java.lang.Class<T>");
        }
        String name = cls.getName();
        if (name != null) {
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        cls = (Class<T>) Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        cls = (Class<T>) Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        cls = (Class<T>) Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        cls = (Class<T>) Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        cls = (Class<T>) Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        cls = (Class<T>) Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        cls = (Class<T>) Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        cls = (Class<T>) Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        cls = (Class<T>) Short.class;
                    }
                    break;
            }
        }
        if (cls != null) {
            return cls;
        }
        throw new e1("null cannot be cast to non-null type java.lang.Class<T>");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @j.c.a.e
    public static final <T> Class<T> c(@j.c.a.d i.w2.c<T> cVar) {
        i0.f(cVar, "$this$javaPrimitiveType");
        Class<T> cls = (Class<T>) ((s) cVar).m();
        if (cls.isPrimitive()) {
            if (cls != null) {
                return cls;
            }
            throw new e1("null cannot be cast to non-null type java.lang.Class<T>");
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

    @e(name = "getRuntimeClassOfKClassInstance")
    @j.c.a.d
    public static final <T> Class<i.w2.c<T>> d(@j.c.a.d i.w2.c<T> cVar) {
        i0.f(cVar, "$this$javaClass");
        Class<i.w2.c<T>> cls = (Class<i.w2.c<T>>) cVar.getClass();
        if (cls != null) {
            return cls;
        }
        throw new e1("null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T>>");
    }

    public static /* synthetic */ void e(i.w2.c cVar) {
    }

    @i.c(level = i.d.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @o0(expression = "(this as Any).javaClass", imports = {}))
    public static /* synthetic */ void f(i.w2.c cVar) {
    }

    @e(name = "getKotlinClass")
    @j.c.a.d
    public static final <T> i.w2.c<T> a(@j.c.a.d Class<T> cls) {
        i0.f(cls, "$this$kotlin");
        return h1.b(cls);
    }

    @j.c.a.d
    public static final <T> Class<T> a(@j.c.a.d T t) {
        i0.f(t, "$this$javaClass");
        Class<T> cls = (Class<T>) t.getClass();
        if (cls != null) {
            return cls;
        }
        throw new e1("null cannot be cast to non-null type java.lang.Class<T>");
    }

    public static final /* synthetic */ <T> boolean a(@j.c.a.d Object[] objArr) {
        i0.f(objArr, "$this$isArrayOf");
        i0.a(4, ExifInterface.GPS_DIRECTION_TRUE);
        return Object.class.isAssignableFrom(objArr.getClass().getComponentType());
    }

    @j.c.a.d
    public static final <T extends Annotation> i.w2.c<? extends T> a(@j.c.a.d T t) {
        i0.f(t, "$this$annotationClass");
        Class<? extends Annotation> clsAnnotationType = t.annotationType();
        i0.a((Object) clsAnnotationType, "(this as java.lang.annot\u2026otation).annotationType()");
        i.w2.c<? extends T> cVarA = a((Class) clsAnnotationType);
        if (cVarA != null) {
            return cVarA;
        }
        throw new e1("null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
    }
}
