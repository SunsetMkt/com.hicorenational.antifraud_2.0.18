package p286h.p289g2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import p286h.C5190a0;
import p286h.EnumC5220d;
import p286h.InterfaceC5216c;
import p286h.InterfaceC5467o0;
import p286h.InterfaceC5610t0;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MutableCollectionsJVM.kt */
/* renamed from: h.g2.c0 */
/* loaded from: classes2.dex */
public class C5250c0 extends C5247b0 {
    @InterfaceC5426f
    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "Use sortWith(comparator) instead.", replaceWith = @InterfaceC5467o0(expression = "this.sortWith(comparator)", imports = {}))
    /* renamed from: a */
    private static final <T> void m19573a(@InterfaceC5816d List<T> list, Comparator<? super T> comparator) {
        throw new C5190a0(null, 1, null);
    }

    /* renamed from: b */
    public static <T> void m19575b(@InterfaceC5816d List<T> list, @InterfaceC5816d Comparator<? super T> comparator) {
        C5544i0.m22546f(list, "$this$sortWith");
        C5544i0.m22546f(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: c */
    private static final <T> void m19576c(@InterfaceC5816d List<T> list) {
        Collections.shuffle(list);
    }

    /* renamed from: d */
    public static <T extends Comparable<? super T>> void m19577d(@InterfaceC5816d List<T> list) {
        C5544i0.m22546f(list, "$this$sort");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    @InterfaceC5610t0(version = "1.2")
    @InterfaceC5816d
    /* renamed from: e */
    public static final <T> List<T> m19578e(@InterfaceC5816d Iterable<? extends T> iterable) {
        C5544i0.m22546f(iterable, "$this$shuffled");
        List<T> m19768O = C5262g0.m19768O(iterable);
        Collections.shuffle(m19768O);
        return m19768O;
    }

    @InterfaceC5426f
    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "Use sortWith(Comparator(comparison)) instead.", replaceWith = @InterfaceC5467o0(expression = "this.sortWith(Comparator(comparison))", imports = {}))
    /* renamed from: a */
    private static final <T> void m19571a(@InterfaceC5816d List<T> list, InterfaceC5510p<? super T, ? super T, Integer> interfaceC5510p) {
        throw new C5190a0(null, 1, null);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final <T> void m19572a(@InterfaceC5816d List<T> list, T t) {
        Collections.fill(list, t);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: a */
    private static final <T> void m19574a(@InterfaceC5816d List<T> list, Random random) {
        Collections.shuffle(list, random);
    }

    @InterfaceC5610t0(version = "1.2")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> List<T> m19570a(@InterfaceC5816d Iterable<? extends T> iterable, @InterfaceC5816d Random random) {
        C5544i0.m22546f(iterable, "$this$shuffled");
        C5544i0.m22546f(random, "random");
        List<T> m19768O = C5262g0.m19768O(iterable);
        Collections.shuffle(m19768O, random);
        return m19768O;
    }
}
