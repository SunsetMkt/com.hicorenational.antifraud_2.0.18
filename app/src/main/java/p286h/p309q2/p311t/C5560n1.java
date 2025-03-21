package p286h.p309q2.p311t;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p286h.InterfaceC5418m;
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
import p286h.p309q2.p311t.p312q1.InterfaceC5569a;
import p286h.p309q2.p311t.p312q1.InterfaceC5570b;
import p286h.p309q2.p311t.p312q1.InterfaceC5571c;
import p286h.p309q2.p311t.p312q1.InterfaceC5572d;
import p286h.p309q2.p311t.p312q1.InterfaceC5573e;
import p286h.p309q2.p311t.p312q1.InterfaceC5574f;
import p286h.p309q2.p311t.p312q1.InterfaceC5575g;
import p286h.p309q2.p311t.p312q1.InterfaceC5576h;

/* compiled from: TypeIntrinsics.java */
/* renamed from: h.q2.t.n1 */
/* loaded from: classes2.dex */
public class C5560n1 {
    /* renamed from: a */
    private static <T extends Throwable> T m22588a(T t) {
        return (T) C5544i0.m22516a((Throwable) t, C5560n1.class.getName());
    }

    /* renamed from: b */
    public static Iterable m22592b(Object obj) {
        if ((obj instanceof InterfaceC5569a) && !(obj instanceof InterfaceC5571c)) {
            m22608i(obj, "kotlin.collections.MutableIterable");
        }
        return m22609j(obj);
    }

    /* renamed from: c */
    public static Iterator m22595c(Object obj) {
        if ((obj instanceof InterfaceC5569a) && !(obj instanceof InterfaceC5572d)) {
            m22608i(obj, "kotlin.collections.MutableIterator");
        }
        return m22610k(obj);
    }

    /* renamed from: d */
    public static List m22597d(Object obj) {
        if ((obj instanceof InterfaceC5569a) && !(obj instanceof InterfaceC5573e)) {
            m22608i(obj, "kotlin.collections.MutableList");
        }
        return m22611l(obj);
    }

    /* renamed from: e */
    public static ListIterator m22599e(Object obj) {
        if ((obj instanceof InterfaceC5569a) && !(obj instanceof InterfaceC5574f)) {
            m22608i(obj, "kotlin.collections.MutableListIterator");
        }
        return m22612m(obj);
    }

    /* renamed from: f */
    public static Map m22601f(Object obj) {
        if ((obj instanceof InterfaceC5569a) && !(obj instanceof InterfaceC5575g)) {
            m22608i(obj, "kotlin.collections.MutableMap");
        }
        return m22613n(obj);
    }

    /* renamed from: g */
    public static Map.Entry m22603g(Object obj) {
        if ((obj instanceof InterfaceC5569a) && !(obj instanceof InterfaceC5575g.a)) {
            m22608i(obj, "kotlin.collections.MutableMap.MutableEntry");
        }
        return m22614o(obj);
    }

    /* renamed from: h */
    public static Set m22605h(Object obj) {
        if ((obj instanceof InterfaceC5569a) && !(obj instanceof InterfaceC5576h)) {
            m22608i(obj, "kotlin.collections.MutableSet");
        }
        return m22615p(obj);
    }

    /* renamed from: i */
    public static void m22608i(Object obj, String str) {
        m22591a((obj == null ? AbstractC1191a.f2571h : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    /* renamed from: j */
    public static Iterable m22609j(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e2) {
            throw m22585a(e2);
        }
    }

    /* renamed from: k */
    public static Iterator m22610k(Object obj) {
        try {
            return (Iterator) obj;
        } catch (ClassCastException e2) {
            throw m22585a(e2);
        }
    }

    /* renamed from: l */
    public static List m22611l(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e2) {
            throw m22585a(e2);
        }
    }

    /* renamed from: m */
    public static ListIterator m22612m(Object obj) {
        try {
            return (ListIterator) obj;
        } catch (ClassCastException e2) {
            throw m22585a(e2);
        }
    }

    /* renamed from: n */
    public static Map m22613n(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e2) {
            throw m22585a(e2);
        }
    }

    /* renamed from: o */
    public static Map.Entry m22614o(Object obj) {
        try {
            return (Map.Entry) obj;
        } catch (ClassCastException e2) {
            throw m22585a(e2);
        }
    }

    /* renamed from: p */
    public static Set m22615p(Object obj) {
        try {
            return (Set) obj;
        } catch (ClassCastException e2) {
            throw m22585a(e2);
        }
    }

    /* renamed from: q */
    public static int m22616q(Object obj) {
        if (obj instanceof InterfaceC5523b0) {
            return ((InterfaceC5523b0) obj).getArity();
        }
        if (obj instanceof InterfaceC5495a) {
            return 0;
        }
        if (obj instanceof InterfaceC5506l) {
            return 1;
        }
        if (obj instanceof InterfaceC5510p) {
            return 2;
        }
        if (obj instanceof InterfaceC5511q) {
            return 3;
        }
        if (obj instanceof InterfaceC5512r) {
            return 4;
        }
        if (obj instanceof InterfaceC5513s) {
            return 5;
        }
        if (obj instanceof InterfaceC5514t) {
            return 6;
        }
        if (obj instanceof InterfaceC5515u) {
            return 7;
        }
        if (obj instanceof InterfaceC5516v) {
            return 8;
        }
        if (obj instanceof InterfaceC5517w) {
            return 9;
        }
        if (obj instanceof InterfaceC5496b) {
            return 10;
        }
        if (obj instanceof InterfaceC5497c) {
            return 11;
        }
        if (obj instanceof InterfaceC5498d) {
            return 12;
        }
        if (obj instanceof InterfaceC5499e) {
            return 13;
        }
        if (obj instanceof InterfaceC5500f) {
            return 14;
        }
        if (obj instanceof InterfaceC5501g) {
            return 15;
        }
        if (obj instanceof InterfaceC5502h) {
            return 16;
        }
        if (obj instanceof InterfaceC5503i) {
            return 17;
        }
        if (obj instanceof InterfaceC5504j) {
            return 18;
        }
        if (obj instanceof InterfaceC5505k) {
            return 19;
        }
        if (obj instanceof InterfaceC5507m) {
            return 20;
        }
        if (obj instanceof InterfaceC5508n) {
            return 21;
        }
        return obj instanceof InterfaceC5509o ? 22 : -1;
    }

    /* renamed from: r */
    public static boolean m22617r(Object obj) {
        return (obj instanceof Collection) && (!(obj instanceof InterfaceC5569a) || (obj instanceof InterfaceC5570b));
    }

    /* renamed from: s */
    public static boolean m22618s(Object obj) {
        return (obj instanceof Iterable) && (!(obj instanceof InterfaceC5569a) || (obj instanceof InterfaceC5571c));
    }

    /* renamed from: t */
    public static boolean m22619t(Object obj) {
        return (obj instanceof Iterator) && (!(obj instanceof InterfaceC5569a) || (obj instanceof InterfaceC5572d));
    }

    /* renamed from: u */
    public static boolean m22620u(Object obj) {
        return (obj instanceof List) && (!(obj instanceof InterfaceC5569a) || (obj instanceof InterfaceC5573e));
    }

    /* renamed from: v */
    public static boolean m22621v(Object obj) {
        return (obj instanceof ListIterator) && (!(obj instanceof InterfaceC5569a) || (obj instanceof InterfaceC5574f));
    }

    /* renamed from: w */
    public static boolean m22622w(Object obj) {
        return (obj instanceof Map) && (!(obj instanceof InterfaceC5569a) || (obj instanceof InterfaceC5575g));
    }

    /* renamed from: x */
    public static boolean m22623x(Object obj) {
        return (obj instanceof Map.Entry) && (!(obj instanceof InterfaceC5569a) || (obj instanceof InterfaceC5575g.a));
    }

    /* renamed from: y */
    public static boolean m22624y(Object obj) {
        return (obj instanceof Set) && (!(obj instanceof InterfaceC5569a) || (obj instanceof InterfaceC5576h));
    }

    /* renamed from: a */
    public static void m22591a(String str) {
        throw m22585a(new ClassCastException(str));
    }

    /* renamed from: a */
    public static ClassCastException m22585a(ClassCastException classCastException) {
        throw ((ClassCastException) m22588a(classCastException));
    }

    /* renamed from: i */
    public static Collection m22607i(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e2) {
            throw m22585a(e2);
        }
    }

    /* renamed from: a */
    public static Collection m22589a(Object obj) {
        if ((obj instanceof InterfaceC5569a) && !(obj instanceof InterfaceC5570b)) {
            m22608i(obj, "kotlin.collections.MutableCollection");
        }
        return m22607i(obj);
    }

    /* renamed from: b */
    public static Iterable m22593b(Object obj, String str) {
        if ((obj instanceof InterfaceC5569a) && !(obj instanceof InterfaceC5571c)) {
            m22591a(str);
        }
        return m22609j(obj);
    }

    /* renamed from: c */
    public static Iterator m22596c(Object obj, String str) {
        if ((obj instanceof InterfaceC5569a) && !(obj instanceof InterfaceC5572d)) {
            m22591a(str);
        }
        return m22610k(obj);
    }

    /* renamed from: d */
    public static List m22598d(Object obj, String str) {
        if ((obj instanceof InterfaceC5569a) && !(obj instanceof InterfaceC5573e)) {
            m22591a(str);
        }
        return m22611l(obj);
    }

    /* renamed from: e */
    public static ListIterator m22600e(Object obj, String str) {
        if ((obj instanceof InterfaceC5569a) && !(obj instanceof InterfaceC5574f)) {
            m22591a(str);
        }
        return m22612m(obj);
    }

    /* renamed from: f */
    public static Map m22602f(Object obj, String str) {
        if ((obj instanceof InterfaceC5569a) && !(obj instanceof InterfaceC5575g)) {
            m22591a(str);
        }
        return m22613n(obj);
    }

    /* renamed from: g */
    public static Map.Entry m22604g(Object obj, String str) {
        if ((obj instanceof InterfaceC5569a) && !(obj instanceof InterfaceC5575g.a)) {
            m22591a(str);
        }
        return m22614o(obj);
    }

    /* renamed from: h */
    public static Set m22606h(Object obj, String str) {
        if ((obj instanceof InterfaceC5569a) && !(obj instanceof InterfaceC5576h)) {
            m22591a(str);
        }
        return m22615p(obj);
    }

    /* renamed from: a */
    public static Collection m22590a(Object obj, String str) {
        if ((obj instanceof InterfaceC5569a) && !(obj instanceof InterfaceC5570b)) {
            m22591a(str);
        }
        return m22607i(obj);
    }

    /* renamed from: b */
    public static boolean m22594b(Object obj, int i2) {
        return (obj instanceof InterfaceC5418m) && m22616q(obj) == i2;
    }

    /* renamed from: a */
    public static Object m22586a(Object obj, int i2) {
        if (obj != null && !m22594b(obj, i2)) {
            m22608i(obj, "kotlin.jvm.functions.Function" + i2);
        }
        return obj;
    }

    /* renamed from: a */
    public static Object m22587a(Object obj, int i2, String str) {
        if (obj != null && !m22594b(obj, i2)) {
            m22591a(str);
        }
        return obj;
    }
}
