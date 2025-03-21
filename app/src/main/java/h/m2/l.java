package h.m2;

import androidx.exifinterface.media.ExifInterface;
import h.e1;
import h.n0;
import h.q2.t.i0;
import h.t0;
import h.z2.c0;

/* compiled from: PlatformImplementations.kt */
/* loaded from: classes2.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @h.q2.c
    @i.c.a.d
    public static final k f16311a;

    static {
        k kVar;
        Object newInstance;
        Object newInstance2;
        int a2 = a();
        if (a2 >= 65544) {
            try {
                newInstance2 = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                i0.a(newInstance2, "Class.forName(\"kotlin.in…entations\").newInstance()");
            } catch (ClassNotFoundException unused) {
                try {
                    Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                    i0.a(newInstance3, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    try {
                        if (newInstance3 == null) {
                            throw new e1("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        kVar = (k) newInstance3;
                    } catch (ClassCastException e2) {
                        Throwable initCause = new ClassCastException("Instance classloader: " + newInstance3.getClass().getClassLoader() + ", base type classloader: " + k.class.getClassLoader()).initCause(e2);
                        i0.a((Object) initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw initCause;
                    }
                } catch (ClassNotFoundException unused2) {
                }
            }
            try {
                if (newInstance2 == null) {
                    throw new e1("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
                kVar = (k) newInstance2;
                f16311a = kVar;
            } catch (ClassCastException e3) {
                Throwable initCause2 = new ClassCastException("Instance classloader: " + newInstance2.getClass().getClassLoader() + ", base type classloader: " + k.class.getClassLoader()).initCause(e3);
                i0.a((Object) initCause2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                throw initCause2;
            }
        }
        if (a2 >= 65543) {
            try {
                newInstance = Class.forName("h.m2.r.a").newInstance();
                i0.a(newInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                } catch (ClassCastException e4) {
                    Throwable initCause3 = new ClassCastException("Instance classloader: " + newInstance.getClass().getClassLoader() + ", base type classloader: " + k.class.getClassLoader()).initCause(e4);
                    i0.a((Object) initCause3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                    throw initCause3;
                }
            } catch (ClassNotFoundException unused3) {
                try {
                    Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    i0.a(newInstance4, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    try {
                        if (newInstance4 == null) {
                            throw new e1("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        kVar = (k) newInstance4;
                    } catch (ClassCastException e5) {
                        Throwable initCause4 = new ClassCastException("Instance classloader: " + newInstance4.getClass().getClassLoader() + ", base type classloader: " + k.class.getClassLoader()).initCause(e5);
                        i0.a((Object) initCause4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw initCause4;
                    }
                } catch (ClassNotFoundException unused4) {
                }
            }
            if (newInstance == null) {
                throw new e1("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            kVar = (k) newInstance;
            f16311a = kVar;
        }
        kVar = new k();
        f16311a = kVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f
    private static final /* synthetic */ <T> T a(Object obj) {
        try {
            i0.a(1, ExifInterface.GPS_DIRECTION_TRUE);
            return obj;
        } catch (ClassCastException e2) {
            ClassLoader classLoader = obj.getClass().getClassLoader();
            i0.a(4, ExifInterface.GPS_DIRECTION_TRUE);
            Throwable initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + Object.class.getClassLoader()).initCause(e2);
            i0.a((Object) initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
            throw initCause;
        }
    }

    private static final int a() {
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        int a2 = c0.a((CharSequence) property, '.', 0, false, 6, (Object) null);
        if (a2 < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return 65542;
            }
        }
        int i2 = a2 + 1;
        int a3 = c0.a((CharSequence) property, '.', i2, false, 4, (Object) null);
        if (a3 < 0) {
            a3 = property.length();
        }
        if (property != null) {
            String substring = property.substring(0, a2);
            i0.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (property != null) {
                String substring2 = property.substring(i2, a3);
                i0.a((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                try {
                    return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
                } catch (NumberFormatException unused2) {
                    return 65542;
                }
            }
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        throw new e1("null cannot be cast to non-null type java.lang.String");
    }

    @t0(version = "1.2")
    @n0
    public static final boolean a(int i2, int i3, int i4) {
        return h.q.f16363f.a(i2, i3, i4);
    }
}
