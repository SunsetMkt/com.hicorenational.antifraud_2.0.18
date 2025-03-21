package p286h.p304m2;

import androidx.exifinterface.media.ExifInterface;
import p286h.C5226e1;
import p286h.C5474q;
import p286h.InterfaceC5440n0;
import p286h.InterfaceC5610t0;
import p286h.p309q2.InterfaceC5479c;
import p286h.p309q2.p311t.C5544i0;
import p286h.p323z2.C5726c0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: PlatformImplementations.kt */
/* renamed from: h.m2.l */
/* loaded from: classes2.dex */
public final class C5432l {

    /* renamed from: a */
    @InterfaceC5479c
    @InterfaceC5816d
    public static final C5431k f20299a;

    static {
        C5431k c5431k;
        Object newInstance;
        Object newInstance2;
        int m22179a = m22179a();
        if (m22179a >= 65544) {
            try {
                newInstance2 = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                C5544i0.m22521a(newInstance2, "Class.forName(\"kotlin.in…entations\").newInstance()");
            } catch (ClassNotFoundException unused) {
                try {
                    Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                    C5544i0.m22521a(newInstance3, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    try {
                        if (newInstance3 == null) {
                            throw new C5226e1("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        c5431k = (C5431k) newInstance3;
                    } catch (ClassCastException e2) {
                        Throwable initCause = new ClassCastException("Instance classloader: " + newInstance3.getClass().getClassLoader() + ", base type classloader: " + C5431k.class.getClassLoader()).initCause(e2);
                        C5544i0.m22521a((Object) initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw initCause;
                    }
                } catch (ClassNotFoundException unused2) {
                }
            }
            try {
                if (newInstance2 == null) {
                    throw new C5226e1("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
                c5431k = (C5431k) newInstance2;
                f20299a = c5431k;
            } catch (ClassCastException e3) {
                Throwable initCause2 = new ClassCastException("Instance classloader: " + newInstance2.getClass().getClassLoader() + ", base type classloader: " + C5431k.class.getClassLoader()).initCause(e3);
                C5544i0.m22521a((Object) initCause2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                throw initCause2;
            }
        }
        if (m22179a >= 65543) {
            try {
                newInstance = Class.forName("h.m2.r.a").newInstance();
                C5544i0.m22521a(newInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                } catch (ClassCastException e4) {
                    Throwable initCause3 = new ClassCastException("Instance classloader: " + newInstance.getClass().getClassLoader() + ", base type classloader: " + C5431k.class.getClassLoader()).initCause(e4);
                    C5544i0.m22521a((Object) initCause3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                    throw initCause3;
                }
            } catch (ClassNotFoundException unused3) {
                try {
                    Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    C5544i0.m22521a(newInstance4, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    try {
                        if (newInstance4 == null) {
                            throw new C5226e1("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        c5431k = (C5431k) newInstance4;
                    } catch (ClassCastException e5) {
                        Throwable initCause4 = new ClassCastException("Instance classloader: " + newInstance4.getClass().getClassLoader() + ", base type classloader: " + C5431k.class.getClassLoader()).initCause(e5);
                        C5544i0.m22521a((Object) initCause4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw initCause4;
                    }
                } catch (ClassNotFoundException unused4) {
                }
            }
            if (newInstance == null) {
                throw new C5226e1("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            c5431k = (C5431k) newInstance;
            f20299a = c5431k;
        }
        c5431k = new C5431k();
        f20299a = c5431k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5426f
    /* renamed from: a */
    private static final /* synthetic */ <T> T m22180a(Object obj) {
        try {
            C5544i0.m22518a(1, ExifInterface.GPS_DIRECTION_TRUE);
            return obj;
        } catch (ClassCastException e2) {
            ClassLoader classLoader = obj.getClass().getClassLoader();
            C5544i0.m22518a(4, ExifInterface.GPS_DIRECTION_TRUE);
            Throwable initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + Object.class.getClassLoader()).initCause(e2);
            C5544i0.m22521a((Object) initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
            throw initCause;
        }
    }

    /* renamed from: a */
    private static final int m22179a() {
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        int m23650a = C5726c0.m23650a((CharSequence) property, '.', 0, false, 6, (Object) null);
        if (m23650a < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return 65542;
            }
        }
        int i2 = m23650a + 1;
        int m23650a2 = C5726c0.m23650a((CharSequence) property, '.', i2, false, 4, (Object) null);
        if (m23650a2 < 0) {
            m23650a2 = property.length();
        }
        if (property != null) {
            String substring = property.substring(0, m23650a);
            C5544i0.m22521a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (property != null) {
                String substring2 = property.substring(i2, m23650a2);
                C5544i0.m22521a((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                try {
                    return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
                } catch (NumberFormatException unused2) {
                    return 65542;
                }
            }
            throw new C5226e1("null cannot be cast to non-null type java.lang.String");
        }
        throw new C5226e1("null cannot be cast to non-null type java.lang.String");
    }

    @InterfaceC5610t0(version = "1.2")
    @InterfaceC5440n0
    /* renamed from: a */
    public static final boolean m22181a(int i2, int i3, int i4) {
        return C5474q.f20351f.m22441a(i2, i3, i4);
    }
}
