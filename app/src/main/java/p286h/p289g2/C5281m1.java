package p286h.p289g2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import p286h.C5715y1;
import p286h.InterfaceC5212b;
import p286h.InterfaceC5339j;
import p286h.InterfaceC5610t0;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sets.kt */
/* renamed from: h.g2.m1 */
/* loaded from: classes2.dex */
public class C5281m1 extends C5278l1 {
    @InterfaceC5816d
    /* renamed from: a */
    public static <T> Set<T> m20016a() {
        return C5277l0.INSTANCE;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    private static final <T> HashSet<T> m20020b() {
        return new HashSet<>();
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: c */
    private static final <T> LinkedHashSet<T> m20023c() {
        return new LinkedHashSet<>();
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: d */
    private static final <T> Set<T> m20025d() {
        return new LinkedHashSet();
    }

    @InterfaceC5816d
    /* renamed from: e */
    public static final <T> Set<T> m20028e(@InterfaceC5816d T... tArr) {
        Set<T> m20016a;
        C5544i0.m22546f(tArr, "elements");
        if (tArr.length > 0) {
            return C5294r.m20577M(tArr);
        }
        m20016a = m20016a();
        return m20016a;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: a */
    private static final <E> Set<E> m20018a(@InterfaceC5212b InterfaceC5506l<? super Set<E>, C5715y1> interfaceC5506l) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        interfaceC5506l.invoke(linkedHashSet);
        return linkedHashSet;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final <T> HashSet<T> m20021b(@InterfaceC5816d T... tArr) {
        int m19562b;
        C5544i0.m22546f(tArr, "elements");
        m19562b = C5248b1.m19562b(tArr.length);
        return (HashSet) C5294r.m21231e((Object[]) tArr, new HashSet(m19562b));
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final <T> LinkedHashSet<T> m20024c(@InterfaceC5816d T... tArr) {
        int m19562b;
        C5544i0.m22546f(tArr, "elements");
        m19562b = C5248b1.m19562b(tArr.length);
        return (LinkedHashSet) C5294r.m21231e((Object[]) tArr, new LinkedHashSet(m19562b));
    }

    @InterfaceC5816d
    /* renamed from: d */
    public static final <T> Set<T> m20026d(@InterfaceC5816d T... tArr) {
        int m19562b;
        C5544i0.m22546f(tArr, "elements");
        m19562b = C5248b1.m19562b(tArr.length);
        return (Set) C5294r.m21231e((Object[]) tArr, new LinkedHashSet(m19562b));
    }

    @InterfaceC5426f
    /* renamed from: e */
    private static final <T> Set<T> m20027e() {
        Set<T> m20016a;
        m20016a = m20016a();
        return m20016a;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: a */
    private static final <E> Set<E> m20017a(int i2, @InterfaceC5212b InterfaceC5506l<? super Set<E>, C5715y1> interfaceC5506l) {
        int m19562b;
        m19562b = C5248b1.m19562b(i2);
        LinkedHashSet linkedHashSet = new LinkedHashSet(m19562b);
        interfaceC5506l.invoke(linkedHashSet);
        return linkedHashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5426f
    /* renamed from: b */
    private static final <T> Set<T> m20022b(@InterfaceC5817e Set<? extends T> set) {
        Set<T> m20016a;
        if (set != 0) {
            return set;
        }
        m20016a = m20016a();
        return m20016a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5816d
    /* renamed from: a */
    public static <T> Set<T> m20019a(@InterfaceC5816d Set<? extends T> set) {
        Set<T> m20016a;
        Set<T> m20010a;
        C5544i0.m22546f(set, "$this$optimizeReadOnlySet");
        int size = set.size();
        if (size == 0) {
            m20016a = m20016a();
            return m20016a;
        }
        if (size != 1) {
            return set;
        }
        m20010a = C5278l1.m20010a(set.iterator().next());
        return m20010a;
    }
}
