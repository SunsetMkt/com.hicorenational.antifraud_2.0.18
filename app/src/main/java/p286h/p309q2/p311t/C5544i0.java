package p286h.p309q2.p311t;

import java.util.Arrays;
import p286h.C5470p;
import p286h.C5684x1;
import p286h.InterfaceC5610t0;

/* compiled from: Intrinsics.java */
/* renamed from: h.q2.t.i0 */
/* loaded from: classes2.dex */
public class C5544i0 {
    private C5544i0() {
    }

    /* renamed from: a */
    public static int m22512a(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    /* renamed from: a */
    public static int m22513a(long j2, long j3) {
        if (j2 < j3) {
            return -1;
        }
        return j2 == j3 ? 0 : 1;
    }

    /* renamed from: a */
    public static String m22514a(String str, Object obj) {
        return str + obj;
    }

    /* renamed from: b */
    public static void m22532b() {
        throw ((AssertionError) m22515a(new AssertionError()));
    }

    /* renamed from: c */
    public static void m22537c(Object obj, String str) {
        if (obj == null) {
            m22547f(str);
        }
    }

    /* renamed from: d */
    public static void m22541d(String str) {
        throw ((IllegalArgumentException) m22515a(new IllegalArgumentException(str)));
    }

    @InterfaceC5610t0(version = "1.4")
    /* renamed from: e */
    public static void m22542e() {
        throw ((NullPointerException) m22515a(new NullPointerException()));
    }

    /* renamed from: f */
    public static void m22545f() {
        throw ((C5470p) m22515a(new C5470p()));
    }

    /* renamed from: g */
    public static void m22550g(String str) {
        throw ((C5470p) m22515a(new C5470p(str)));
    }

    /* renamed from: h */
    private static void m22551h(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        throw ((IllegalArgumentException) m22515a(new IllegalArgumentException("Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str)));
    }

    /* renamed from: i */
    public static void m22552i(String str) {
        throw new UnsupportedOperationException(str);
    }

    /* renamed from: j */
    public static void m22553j(String str) {
        throw ((C5684x1) m22515a(new C5684x1(str)));
    }

    /* renamed from: k */
    public static void m22554k(String str) {
        m22553j("lateinit property " + str + " has not been initialized");
    }

    /* renamed from: a */
    public static void m22520a(Object obj) {
        if (obj == null) {
            m22542e();
        }
    }

    /* renamed from: b */
    public static void m22534b(Object obj, String str, String str2) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) m22515a(new IllegalStateException("Method specified as non-null returned null: " + str + "." + str2)));
    }

    /* renamed from: c */
    public static void m22538c(String str) {
        throw ((AssertionError) m22515a(new AssertionError(str)));
    }

    /* renamed from: d */
    public static void m22539d() {
        throw ((IllegalStateException) m22515a(new IllegalStateException()));
    }

    /* renamed from: e */
    public static void m22544e(String str) {
        throw ((IllegalStateException) m22515a(new IllegalStateException(str)));
    }

    @InterfaceC5610t0(version = "1.4")
    /* renamed from: f */
    public static void m22547f(String str) {
        throw ((NullPointerException) m22515a(new NullPointerException(str)));
    }

    /* renamed from: g */
    public static void m22549g(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) m22515a(new IllegalStateException(str)));
        }
    }

    /* renamed from: a */
    public static void m22521a(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) m22515a(new IllegalStateException(str + " must not be null")));
    }

    /* renamed from: b */
    public static void m22533b(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) m22515a(new IllegalStateException(str)));
        }
    }

    /* renamed from: c */
    public static void m22536c() {
        throw ((IllegalArgumentException) m22515a(new IllegalArgumentException()));
    }

    /* renamed from: d */
    public static void m22540d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) m22515a(new NullPointerException(str + " must not be null")));
    }

    /* renamed from: e */
    public static void m22543e(Object obj, String str) {
        if (obj == null) {
            throw ((NullPointerException) m22515a(new NullPointerException(str)));
        }
    }

    /* renamed from: f */
    public static void m22546f(Object obj, String str) {
        if (obj == null) {
            m22551h(str);
        }
    }

    /* renamed from: g */
    public static void m22548g() {
        m22552i("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    /* renamed from: a */
    public static void m22522a(Object obj, String str, String str2) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) m22515a(new IllegalStateException("Field specified as non-null is null: " + str + "." + str2)));
    }

    /* renamed from: b */
    public static void m22535b(String str) {
        m22552i(str);
    }

    /* renamed from: a */
    public static boolean m22531a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    public static boolean m22528a(Double d2, Double d3) {
        if (d2 == null) {
            if (d3 == null) {
                return true;
            }
        } else if (d3 != null && d2.doubleValue() == d3.doubleValue()) {
            return true;
        }
        return false;
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    public static boolean m22527a(Double d2, double d3) {
        return d2 != null && d2.doubleValue() == d3;
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    public static boolean m22525a(double d2, Double d3) {
        return d3 != null && d2 == d3.doubleValue();
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    public static boolean m22530a(Float f2, Float f3) {
        if (f2 == null) {
            if (f3 == null) {
                return true;
            }
        } else if (f3 != null && f2.floatValue() == f3.floatValue()) {
            return true;
        }
        return false;
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    public static boolean m22529a(Float f2, float f3) {
        return f2 != null && f2.floatValue() == f3;
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    public static boolean m22526a(float f2, Float f3) {
        return f3 != null && f2 == f3.floatValue();
    }

    /* renamed from: a */
    public static void m22518a(int i2, String str) {
        m22548g();
    }

    /* renamed from: a */
    public static void m22519a(int i2, String str, String str2) {
        m22552i(str2);
    }

    /* renamed from: a */
    public static void m22517a() {
        m22548g();
    }

    /* renamed from: a */
    public static void m22523a(String str) throws ClassNotFoundException {
        String replace = str.replace('/', '.');
        try {
            Class.forName(replace);
        } catch (ClassNotFoundException e2) {
            throw ((ClassNotFoundException) m22515a(new ClassNotFoundException("Class " + replace + " is not found. Please update the Kotlin runtime to the latest version", e2)));
        }
    }

    /* renamed from: a */
    public static void m22524a(String str, String str2) throws ClassNotFoundException {
        String replace = str.replace('/', '.');
        try {
            Class.forName(replace);
        } catch (ClassNotFoundException e2) {
            throw ((ClassNotFoundException) m22515a(new ClassNotFoundException("Class " + replace + " is not found: this code requires the Kotlin runtime of version at least " + str2, e2)));
        }
    }

    /* renamed from: a */
    private static <T extends Throwable> T m22515a(T t) {
        return (T) m22516a((Throwable) t, C5544i0.class.getName());
    }

    /* renamed from: a */
    static <T extends Throwable> T m22516a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(stackTrace[i3].getClassName())) {
                i2 = i3;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2 + 1, length));
        return t;
    }
}
