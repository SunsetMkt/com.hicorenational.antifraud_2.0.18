package p251g.p252a;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p251g.p252a.p253a1.C4465l;
import p251g.p252a.p253a1.C4467n;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p257e1.C4488a;
import p251g.p252a.p257e1.C4490c;
import p251g.p252a.p263t0.EnumC4541a;
import p251g.p252a.p263t0.InterfaceC4542b;
import p251g.p252a.p263t0.InterfaceC4544d;
import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p263t0.InterfaceC4548h;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p267x0.InterfaceC4571b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p267x0.InterfaceC4573d;
import p251g.p252a.p267x0.InterfaceC4574e;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p267x0.InterfaceC4577h;
import p251g.p252a.p267x0.InterfaceC4578i;
import p251g.p252a.p267x0.InterfaceC4579j;
import p251g.p252a.p267x0.InterfaceC4580k;
import p251g.p252a.p267x0.InterfaceC4581l;
import p251g.p252a.p267x0.InterfaceC4582m;
import p251g.p252a.p267x0.InterfaceC4583n;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p270b.C4600a;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceCallableC4614m;
import p251g.p252a.p268y0.p272d.C4624f;
import p251g.p252a.p268y0.p272d.C4625g;
import p251g.p252a.p268y0.p272d.C4634p;
import p251g.p252a.p268y0.p272d.C4640v;
import p251g.p252a.p268y0.p272d.FutureC4636r;
import p251g.p252a.p268y0.p273e.p275b.C4730h1;
import p251g.p252a.p268y0.p273e.p275b.C4731h2;
import p251g.p252a.p268y0.p273e.p277d.C4908a0;
import p251g.p252a.p268y0.p273e.p277d.C4909a1;
import p251g.p252a.p268y0.p273e.p277d.C4910a2;
import p251g.p252a.p268y0.p273e.p277d.C4911a3;
import p251g.p252a.p268y0.p273e.p277d.C4912a4;
import p251g.p252a.p268y0.p273e.p277d.C4913b;
import p251g.p252a.p268y0.p273e.p277d.C4914b0;
import p251g.p252a.p268y0.p273e.p277d.C4916b2;
import p251g.p252a.p268y0.p273e.p277d.C4917b3;
import p251g.p252a.p268y0.p273e.p277d.C4918b4;
import p251g.p252a.p268y0.p273e.p277d.C4919c;
import p251g.p252a.p268y0.p273e.p277d.C4920c0;
import p251g.p252a.p268y0.p273e.p277d.C4921c1;
import p251g.p252a.p268y0.p273e.p277d.C4922c2;
import p251g.p252a.p268y0.p273e.p277d.C4923c3;
import p251g.p252a.p268y0.p273e.p277d.C4924c4;
import p251g.p252a.p268y0.p273e.p277d.C4925d;
import p251g.p252a.p268y0.p273e.p277d.C4926d0;
import p251g.p252a.p268y0.p273e.p277d.C4927d1;
import p251g.p252a.p268y0.p273e.p277d.C4928d2;
import p251g.p252a.p268y0.p273e.p277d.C4929d3;
import p251g.p252a.p268y0.p273e.p277d.C4930d4;
import p251g.p252a.p268y0.p273e.p277d.C4931e;
import p251g.p252a.p268y0.p273e.p277d.C4932e0;
import p251g.p252a.p268y0.p273e.p277d.C4933e1;
import p251g.p252a.p268y0.p273e.p277d.C4934e2;
import p251g.p252a.p268y0.p273e.p277d.C4935e3;
import p251g.p252a.p268y0.p273e.p277d.C4936e4;
import p251g.p252a.p268y0.p273e.p277d.C4938f0;
import p251g.p252a.p268y0.p273e.p277d.C4939f1;
import p251g.p252a.p268y0.p273e.p277d.C4940f2;
import p251g.p252a.p268y0.p273e.p277d.C4941f3;
import p251g.p252a.p268y0.p273e.p277d.C4942f4;
import p251g.p252a.p268y0.p273e.p277d.C4943g;
import p251g.p252a.p268y0.p273e.p277d.C4944g0;
import p251g.p252a.p268y0.p273e.p277d.C4945g1;
import p251g.p252a.p268y0.p273e.p277d.C4946g2;
import p251g.p252a.p268y0.p273e.p277d.C4947g3;
import p251g.p252a.p268y0.p273e.p277d.C4948g4;
import p251g.p252a.p268y0.p273e.p277d.C4949h;
import p251g.p252a.p268y0.p273e.p277d.C4950h0;
import p251g.p252a.p268y0.p273e.p277d.C4951h1;
import p251g.p252a.p268y0.p273e.p277d.C4952h2;
import p251g.p252a.p268y0.p273e.p277d.C4953h3;
import p251g.p252a.p268y0.p273e.p277d.C4956i0;
import p251g.p252a.p268y0.p273e.p277d.C4957i1;
import p251g.p252a.p268y0.p273e.p277d.C4959i3;
import p251g.p252a.p268y0.p273e.p277d.C4960j;
import p251g.p252a.p268y0.p273e.p277d.C4961j0;
import p251g.p252a.p268y0.p273e.p277d.C4962j1;
import p251g.p252a.p268y0.p273e.p277d.C4963j2;
import p251g.p252a.p268y0.p273e.p277d.C4964j3;
import p251g.p252a.p268y0.p273e.p277d.C4966k0;
import p251g.p252a.p268y0.p273e.p277d.C4967k1;
import p251g.p252a.p268y0.p273e.p277d.C4968k2;
import p251g.p252a.p268y0.p273e.p277d.C4969k3;
import p251g.p252a.p268y0.p273e.p277d.C4970l;
import p251g.p252a.p268y0.p273e.p277d.C4971l0;
import p251g.p252a.p268y0.p273e.p277d.C4972l1;
import p251g.p252a.p268y0.p273e.p277d.C4973l2;
import p251g.p252a.p268y0.p273e.p277d.C4974l3;
import p251g.p252a.p268y0.p273e.p277d.C4975m;
import p251g.p252a.p268y0.p273e.p277d.C4976m0;
import p251g.p252a.p268y0.p273e.p277d.C4977m1;
import p251g.p252a.p268y0.p273e.p277d.C4978m2;
import p251g.p252a.p268y0.p273e.p277d.C4979m3;
import p251g.p252a.p268y0.p273e.p277d.C4980n;
import p251g.p252a.p268y0.p273e.p277d.C4981n0;
import p251g.p252a.p268y0.p273e.p277d.C4982n1;
import p251g.p252a.p268y0.p273e.p277d.C4983n2;
import p251g.p252a.p268y0.p273e.p277d.C4984n3;
import p251g.p252a.p268y0.p273e.p277d.C4985o;
import p251g.p252a.p268y0.p273e.p277d.C4987o1;
import p251g.p252a.p268y0.p273e.p277d.C4988o2;
import p251g.p252a.p268y0.p273e.p277d.C4989o3;
import p251g.p252a.p268y0.p273e.p277d.C4990p;
import p251g.p252a.p268y0.p273e.p277d.C4991p0;
import p251g.p252a.p268y0.p273e.p277d.C4992p1;
import p251g.p252a.p268y0.p273e.p277d.C4993p2;
import p251g.p252a.p268y0.p273e.p277d.C4994p3;
import p251g.p252a.p268y0.p273e.p277d.C4995q;
import p251g.p252a.p268y0.p273e.p277d.C4996q0;
import p251g.p252a.p268y0.p273e.p277d.C4997q1;
import p251g.p252a.p268y0.p273e.p277d.C4998q2;
import p251g.p252a.p268y0.p273e.p277d.C4999q3;
import p251g.p252a.p268y0.p273e.p277d.C5000r;
import p251g.p252a.p268y0.p273e.p277d.C5001r0;
import p251g.p252a.p268y0.p273e.p277d.C5002r1;
import p251g.p252a.p268y0.p273e.p277d.C5003r2;
import p251g.p252a.p268y0.p273e.p277d.C5004r3;
import p251g.p252a.p268y0.p273e.p277d.C5006s0;
import p251g.p252a.p268y0.p273e.p277d.C5007s1;
import p251g.p252a.p268y0.p273e.p277d.C5008s2;
import p251g.p252a.p268y0.p273e.p277d.C5009s3;
import p251g.p252a.p268y0.p273e.p277d.C5010t;
import p251g.p252a.p268y0.p273e.p277d.C5011t0;
import p251g.p252a.p268y0.p273e.p277d.C5012t1;
import p251g.p252a.p268y0.p273e.p277d.C5013t2;
import p251g.p252a.p268y0.p273e.p277d.C5014t3;
import p251g.p252a.p268y0.p273e.p277d.C5015u;
import p251g.p252a.p268y0.p273e.p277d.C5016u0;
import p251g.p252a.p268y0.p273e.p277d.C5017u1;
import p251g.p252a.p268y0.p273e.p277d.C5018u2;
import p251g.p252a.p268y0.p273e.p277d.C5019u3;
import p251g.p252a.p268y0.p273e.p277d.C5020v;
import p251g.p252a.p268y0.p273e.p277d.C5022v1;
import p251g.p252a.p268y0.p273e.p277d.C5024v3;
import p251g.p252a.p268y0.p273e.p277d.C5025w;
import p251g.p252a.p268y0.p273e.p277d.C5026w0;
import p251g.p252a.p268y0.p273e.p277d.C5027w1;
import p251g.p252a.p268y0.p273e.p277d.C5028w2;
import p251g.p252a.p268y0.p273e.p277d.C5029w3;
import p251g.p252a.p268y0.p273e.p277d.C5030x;
import p251g.p252a.p268y0.p273e.p277d.C5031x0;
import p251g.p252a.p268y0.p273e.p277d.C5032x1;
import p251g.p252a.p268y0.p273e.p277d.C5033x2;
import p251g.p252a.p268y0.p273e.p277d.C5034x3;
import p251g.p252a.p268y0.p273e.p277d.C5036y0;
import p251g.p252a.p268y0.p273e.p277d.C5037y1;
import p251g.p252a.p268y0.p273e.p277d.C5038y2;
import p251g.p252a.p268y0.p273e.p277d.C5039y3;
import p251g.p252a.p268y0.p273e.p277d.C5040z;
import p251g.p252a.p268y0.p273e.p277d.C5041z0;
import p251g.p252a.p268y0.p273e.p277d.C5042z1;
import p251g.p252a.p268y0.p273e.p277d.C5043z2;
import p251g.p252a.p268y0.p273e.p277d.C5044z3;
import p251g.p252a.p268y0.p273e.p277d.CallableC4915b1;
import p251g.p252a.p268y0.p284j.C5171k;
import p251g.p252a.p268y0.p284j.EnumC5162b;
import p251g.p252a.p268y0.p284j.EnumC5170j;
import p251g.p252a.p268y0.p284j.EnumC5173m;
import p251g.p252a.p285z0.AbstractC5187a;
import p251g.p252a.p285z0.AbstractC5188b;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;

/* compiled from: Observable.java */
/* renamed from: g.a.b0 */
/* loaded from: classes2.dex */
public abstract class AbstractC4469b0<T> implements InterfaceC4504g0<T> {

    /* compiled from: Observable.java */
    /* renamed from: g.a.b0$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f17231a = new int[EnumC4468b.values().length];

        static {
            try {
                f17231a[EnumC4468b.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17231a[EnumC4468b.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17231a[EnumC4468b.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17231a[EnumC4468b.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: L */
    public static int m16521L() {
        return AbstractC4519l.m17539Q();
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: M */
    public static <T> AbstractC4469b0<T> m16522M() {
        return C4476a.m17119a(C5001r0.f19348a);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: N */
    public static <T> AbstractC4469b0<T> m16523N() {
        return C4476a.m17119a(C5032x1.f19500a);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16570a(InterfaceC4504g0<? extends T>... interfaceC4504g0Arr) {
        C4601b.m18284a(interfaceC4504g0Arr, "sources is null");
        int length = interfaceC4504g0Arr.length;
        return length == 0 ? m16522M() : length == 1 ? m16646v(interfaceC4504g0Arr[0]) : C4476a.m17119a(new C4949h(interfaceC4504g0Arr, null));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T> AbstractC4469b0<T> m16591b(Iterable<? extends InterfaceC4504g0<? extends T>> iterable) {
        C4601b.m18284a(iterable, "sources is null");
        return C4476a.m17119a(new C4949h(null, iterable));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public static <T, R> AbstractC4469b0<R> m16611c(InterfaceC4504g0<? extends T>[] interfaceC4504g0Arr, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o) {
        return m16599b(interfaceC4504g0Arr, interfaceC4584o, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public static <T> AbstractC4469b0<T> m16618d(InterfaceC4504g0<? extends T>... interfaceC4504g0Arr) {
        return m16524a(m16521L(), m16521L(), interfaceC4504g0Arr);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public static <T> AbstractC4469b0<T> m16622e(Iterable<? extends InterfaceC4504g0<? extends T>> iterable) {
        return m16549a(iterable, m16521L(), m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: f */
    public static <T> AbstractC4469b0<T> m16627f(Callable<? extends T> callable) {
        C4601b.m18284a(callable, "supplier is null");
        return C4476a.m17119a((AbstractC4469b0) new CallableC4915b1(callable));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: g */
    public static <T> AbstractC4469b0<T> m16630g(Iterable<? extends InterfaceC4504g0<? extends T>> iterable) {
        return m16626f((Iterable) iterable).m16915j(C4600a.m18258e());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: h */
    public static <T> AbstractC4469b0<T> m16631h(Iterable<? extends InterfaceC4504g0<? extends T>> iterable) {
        return m16626f((Iterable) iterable).m16795b(C4600a.m18258e(), true);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: j */
    public static <T> AbstractC4469b0<T> m16632j(InterfaceC4576g<InterfaceC4517k<T>> interfaceC4576g) {
        C4601b.m18284a(interfaceC4576g, "generator  is null");
        return m16563a(C4600a.m18261h(), C4977m1.m18464a(interfaceC4576g), C4600a.m18257d());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: l */
    public static <T> AbstractC4469b0<T> m16633l(T t) {
        C4601b.m18284a((Object) t, "The item is null");
        return C4476a.m17119a((AbstractC4469b0) new C4997q1(t));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: n */
    public static <T> AbstractC4469b0<T> m16634n(InterfaceC4504g0<? extends InterfaceC4504g0<? extends T>> interfaceC4504g0) {
        return m16602c(interfaceC4504g0, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: o */
    public static <T> AbstractC4469b0<T> m16635o(InterfaceC4504g0<? extends InterfaceC4504g0<? extends T>> interfaceC4504g0) {
        return m16530a((InterfaceC4504g0) interfaceC4504g0, m16521L(), true);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: p */
    public static <T> AbstractC4469b0<T> m16638p(InterfaceC4504g0<? extends InterfaceC4504g0<? extends T>> interfaceC4504g0) {
        return m16529a(interfaceC4504g0, m16521L(), m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: q */
    public static <T> AbstractC4469b0<T> m16641q(InterfaceC4504g0<? extends InterfaceC4504g0<? extends T>> interfaceC4504g0) {
        C4601b.m18284a(interfaceC4504g0, "sources is null");
        return C4476a.m17119a(new C5016u0(interfaceC4504g0, C4600a.m18258e(), false, Integer.MAX_VALUE, m16521L()));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: r */
    public static <T> AbstractC4469b0<T> m16642r(InterfaceC4504g0<? extends InterfaceC4504g0<? extends T>> interfaceC4504g0) {
        C4601b.m18284a(interfaceC4504g0, "sources is null");
        return C4476a.m17119a(new C5016u0(interfaceC4504g0, C4600a.m18258e(), true, Integer.MAX_VALUE, m16521L()));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: s */
    public static <T> AbstractC4469b0<T> m16643s(InterfaceC4504g0<? extends InterfaceC4504g0<? extends T>> interfaceC4504g0) {
        return m16625f(interfaceC4504g0, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: t */
    public static <T> AbstractC4469b0<T> m16644t(InterfaceC4504g0<? extends InterfaceC4504g0<? extends T>> interfaceC4504g0) {
        return m16629g(interfaceC4504g0, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: u */
    public static <T> AbstractC4469b0<T> m16645u(InterfaceC4504g0<T> interfaceC4504g0) {
        C4601b.m18284a(interfaceC4504g0, "source is null");
        C4601b.m18284a(interfaceC4504g0, "onSubscribe is null");
        if (interfaceC4504g0 instanceof AbstractC4469b0) {
            throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
        }
        return C4476a.m17119a(new C4939f1(interfaceC4504g0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: v */
    public static <T> AbstractC4469b0<T> m16646v(InterfaceC4504g0<T> interfaceC4504g0) {
        C4601b.m18284a(interfaceC4504g0, "source is null");
        return interfaceC4504g0 instanceof AbstractC4469b0 ? C4476a.m17119a((AbstractC4469b0) interfaceC4504g0) : C4476a.m17119a(new C4939f1(interfaceC4504g0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: A */
    public final AbstractC4469b0<T> m16647A() {
        return m16954v().m18660Q();
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: B */
    public final AbstractC4533s<T> m16649B() {
        return C4476a.m17131a(new C5038y2(this));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: C */
    public final AbstractC4518k0<T> m16651C() {
        return C4476a.m17128a(new C5043z2(this, null));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: D */
    public final AbstractC4469b0<T> m16653D() {
        return m16660J().m17538p().m16941p(C4600a.m18244a(C4600a.m18259f())).m16927l((InterfaceC4584o<? super R, ? extends Iterable<? extends U>>) C4600a.m18258e());
    }

    @InterfaceC4548h("none")
    /* renamed from: E */
    public final InterfaceC4552c m16655E() {
        return m16762a((InterfaceC4576g) C4600a.m18257d(), (InterfaceC4576g<? super Throwable>) C4600a.f17518f, C4600a.f17515c, C4600a.m18257d());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: F */
    public final C4467n<T> m16656F() {
        C4467n<T> c4467n = new C4467n<>();
        subscribe(c4467n);
        return c4467n;
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: G */
    public final AbstractC4469b0<C4490c<T>> m16657G() {
        return m16748a(TimeUnit.MILLISECONDS, C4488a.m17267a());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: H */
    public final AbstractC4469b0<C4490c<T>> m16658H() {
        return m16800b(TimeUnit.MILLISECONDS, C4488a.m17267a());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: I */
    public final Future<T> m16659I() {
        return (Future) m16866e((AbstractC4469b0<T>) new FutureC4636r());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: J */
    public final AbstractC4518k0<List<T>> m16660J() {
        return m16892g(16);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: K */
    public final AbstractC4518k0<List<T>> m16661K() {
        return m16807b((Comparator) C4600a.m18260g());
    }

    /* renamed from: d */
    protected abstract void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0);

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: i */
    public final AbstractC4518k0<Long> m16909i() {
        return C4476a.m17128a(new C5040z(this));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: k */
    public final AbstractC4469b0<T> m16917k() {
        return m16735a((InterfaceC4584o) C4600a.m18258e(), (Callable) C4600a.m18256c());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: m */
    public final AbstractC4533s<T> m16932m() {
        return m16760a(0L);
    }

    @Override // p251g.p252a.InterfaceC4504g0
    @InterfaceC4548h("none")
    public final void subscribe(InterfaceC4514i0<? super T> interfaceC4514i0) {
        C4601b.m18284a(interfaceC4514i0, "observer is null");
        try {
            InterfaceC4514i0<? super T> m17123a = C4476a.m17123a(this, interfaceC4514i0);
            C4601b.m18284a(m17123a, "Plugin returned null Observer");
            mo16855d((InterfaceC4514i0) m17123a);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            C4561b.m18199b(th);
            C4476a.m17152b(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: w */
    public final AbstractC4469b0<T> m16955w() {
        return m16816c(C5556m0.f20396b);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: x */
    public final AbstractC5187a<T> m16958x() {
        return C4978m2.m18493w(this);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: y */
    public final AbstractC4469b0<T> m16959y() {
        return m16673a(C5556m0.f20396b, C4600a.m18251b());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: z */
    public final AbstractC4469b0<T> m16961z() {
        return C4476a.m17119a(new C5033x2(this));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public static <T, R> AbstractC4469b0<R> m16608c(Iterable<? extends InterfaceC4504g0<? extends T>> iterable, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o) {
        return m16595b(iterable, interfaceC4584o, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public static <T> AbstractC4469b0<T> m16615d(Iterable<? extends InterfaceC4504g0<? extends T>> iterable) {
        C4601b.m18284a(iterable, "sources is null");
        return m16635o(m16626f((Iterable) iterable));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public static <T> AbstractC4469b0<T> m16623e(Callable<? extends Throwable> callable) {
        C4601b.m18284a(callable, "errorSupplier is null");
        return C4476a.m17119a(new C5006s0(callable));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: g */
    public static <T> AbstractC4469b0<T> m16629g(InterfaceC4504g0<? extends InterfaceC4504g0<? extends T>> interfaceC4504g0, int i2) {
        C4601b.m18284a(interfaceC4504g0, "sources is null");
        C4601b.m18279a(i2, "prefetch");
        return C4476a.m17119a(new C4953h3(interfaceC4504g0, C4600a.m18258e(), i2, true));
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: p */
    public static AbstractC4469b0<Long> m16636p(long j2, TimeUnit timeUnit) {
        return m16613d(j2, j2, timeUnit, C4488a.m17267a());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: A */
    public final <V> AbstractC4469b0<T> m16648A(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<V>> interfaceC4584o) {
        return m16589b((InterfaceC4504g0) null, interfaceC4584o, (InterfaceC4504g0) null);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: B */
    public final <R> R m16650B(InterfaceC4584o<? super AbstractC4469b0<T>, R> interfaceC4584o) {
        try {
            return (R) ((InterfaceC4584o) C4601b.m18284a(interfaceC4584o, "converter is null")).apply(this);
        } catch (Throwable th) {
            C4561b.m18199b(th);
            throw C5171k.m18626c(th);
        }
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: C */
    public final <K> AbstractC4518k0<Map<K, T>> m16652C(InterfaceC4584o<? super T, ? extends K> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "keySelector is null");
        return (AbstractC4518k0<Map<K, T>>) m16757a((Callable) EnumC5173m.asCallable(), (InterfaceC4571b) C4600a.m18231a((InterfaceC4584o) interfaceC4584o));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: D */
    public final <K> AbstractC4518k0<Map<K, Collection<T>>> m16654D(InterfaceC4584o<? super T, ? extends K> interfaceC4584o) {
        return (AbstractC4518k0<Map<K, Collection<T>>>) m16752a((InterfaceC4584o) interfaceC4584o, (InterfaceC4584o) C4600a.m18258e(), (Callable) EnumC5173m.asCallable(), (InterfaceC4584o) EnumC5162b.asFunction());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: h */
    public final AbstractC4469b0<T> m16895h() {
        return C5000r.m18511a((AbstractC4469b0) this);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: i */
    public final <K> AbstractC4469b0<T> m16907i(InterfaceC4584o<? super T, K> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "keySelector is null");
        return C4476a.m17119a(new C4961j0(this, interfaceC4584o, C4601b.m18283a()));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: k */
    public final AbstractC4474c m16922k(InterfaceC4584o<? super T, ? extends InterfaceC4513i> interfaceC4584o) {
        return m16832c((InterfaceC4584o) interfaceC4584o, false);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: m */
    public final <R> AbstractC4469b0<R> m16931m(InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends R>> interfaceC4584o) {
        return m16850d((InterfaceC4584o) interfaceC4584o, false);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: n */
    public final AbstractC4518k0<T> m16936n() {
        return m16803b(0L);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: o */
    public final <K> AbstractC4469b0<AbstractC5188b<K, T>> m16940o(InterfaceC4584o<? super T, ? extends K> interfaceC4584o) {
        return (AbstractC4469b0<AbstractC5188b<K, T>>) m16734a((InterfaceC4584o) interfaceC4584o, (InterfaceC4584o) C4600a.m18258e(), false, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: s */
    public final AbstractC4518k0<T> m16948s() {
        return C4476a.m17128a(new C5007s1(this, null));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: t */
    public final AbstractC4469b0<C4453a0<T>> m16949t() {
        return C4476a.m17119a(new C5027w1(this));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: w */
    public final <R> AbstractC4469b0<R> m16956w(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o) {
        return m16879f(interfaceC4584o, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: x */
    public final <R> AbstractC4469b0<R> m16957x(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o) {
        return m16890g(interfaceC4584o, m16521L());
    }

    @InterfaceC4546f
    @InterfaceC4545e
    @InterfaceC4548h("none")
    @InterfaceC4544d
    /* renamed from: y */
    public final <R> AbstractC4469b0<R> m16960y(@InterfaceC4546f InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> interfaceC4584o) {
        return C4977m1.m18461a(this, interfaceC4584o);
    }

    @InterfaceC4546f
    @InterfaceC4545e
    @InterfaceC4548h("none")
    @InterfaceC4544d
    /* renamed from: z */
    public final <R> AbstractC4469b0<R> m16962z(@InterfaceC4546f InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> interfaceC4584o) {
        return C4977m1.m18472b(this, interfaceC4584o);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T, R> AbstractC4469b0<R> m16594b(Iterable<? extends InterfaceC4504g0<? extends T>> iterable, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o) {
        return m16550a(iterable, interfaceC4584o, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public static <T> AbstractC4469b0<T> m16606c(Iterable<? extends InterfaceC4504g0<? extends T>> iterable) {
        C4601b.m18284a(iterable, "sources is null");
        return m16626f((Iterable) iterable).m16720a(C4600a.m18258e(), m16521L(), false);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: f */
    public static <T> AbstractC4469b0<T> m16626f(Iterable<? extends T> iterable) {
        C4601b.m18284a(iterable, "source is null");
        return C4476a.m17119a(new C4927d1(iterable));
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: p */
    public static AbstractC4469b0<Long> m16637p(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return m16613d(j2, j2, timeUnit, abstractC4516j0);
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: q */
    public static AbstractC4469b0<Long> m16639q(long j2, TimeUnit timeUnit) {
        return m16640q(j2, timeUnit, C4488a.m17267a());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: h */
    public final <K> AbstractC4469b0<T> m16899h(InterfaceC4584o<? super T, K> interfaceC4584o) {
        return m16735a((InterfaceC4584o) interfaceC4584o, (Callable) C4600a.m18256c());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: k */
    public final AbstractC4469b0<T> m16921k(T t) {
        C4601b.m18284a((Object) t, "item is null");
        return m16597b(m16633l(t), this);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: l */
    public final AbstractC4469b0<T> m16923l() {
        return m16907i((InterfaceC4584o) C4600a.m18258e());
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: m */
    public final AbstractC4469b0<T> m16928m(long j2, TimeUnit timeUnit) {
        return m16779b(j2, timeUnit);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: n */
    public final <R> AbstractC4469b0<R> m16935n(InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> interfaceC4584o) {
        return m16864e((InterfaceC4584o) interfaceC4584o, false);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: o */
    public final AbstractC4469b0<T> m16937o() {
        return C4476a.m17119a(new C4962j1(this));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: r */
    public final AbstractC4533s<T> m16946r() {
        return C4476a.m17131a(new C5002r1(this));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: s */
    public final <R> AbstractC4469b0<R> m16947s(InterfaceC4584o<? super AbstractC4469b0<T>, ? extends InterfaceC4504g0<R>> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "selector is null");
        return C4476a.m17119a(new C4922c2(this, interfaceC4584o));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: t */
    public final AbstractC4469b0<T> m16950t(InterfaceC4584o<? super AbstractC4469b0<Object>, ? extends InterfaceC4504g0<?>> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "handler is null");
        return C4476a.m17119a(new C4973l2(this, interfaceC4584o));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T, R> AbstractC4469b0<R> m16598b(InterfaceC4504g0<? extends T>[] interfaceC4504g0Arr, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o) {
        return m16571a(interfaceC4504g0Arr, interfaceC4584o, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public static <T> AbstractC4469b0<T> m16617d(Callable<? extends InterfaceC4504g0<? extends T>> callable) {
        C4601b.m18284a(callable, "supplier is null");
        return C4476a.m17119a(new C4926d0(callable));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public static <T> AbstractC4469b0<T> m16624e(InterfaceC4504g0<? extends T>... interfaceC4504g0Arr) {
        return m16600b((Object[]) interfaceC4504g0Arr).m16849d(C4600a.m18258e(), interfaceC4504g0Arr.length);
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: q */
    public static AbstractC4469b0<Long> m16640q(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        C4601b.m18284a(timeUnit, "unit is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4476a.m17119a(new C5014t3(Math.max(j2, 0L), timeUnit, abstractC4516j0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: h */
    public final InterfaceC4552c m16903h(InterfaceC4576g<? super T> interfaceC4576g) {
        return m16910i((InterfaceC4576g) interfaceC4576g);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: i */
    public final AbstractC4469b0<T> m16908i(T t) {
        C4601b.m18284a((Object) t, "item is null");
        return m16945r(C4600a.m18255c(t));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: l */
    public final <U> AbstractC4469b0<U> m16927l(InterfaceC4584o<? super T, ? extends Iterable<? extends U>> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        return C4476a.m17119a(new C5041z0(this, interfaceC4584o));
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: m */
    public final AbstractC4469b0<T> m16929m(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return m16780b(j2, timeUnit, abstractC4516j0);
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: n */
    public final AbstractC4469b0<T> m16933n(long j2, TimeUnit timeUnit) {
        return m16527a(j2, timeUnit, (InterfaceC4504g0) null, C4488a.m17267a());
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: o */
    public final AbstractC4469b0<AbstractC4469b0<T>> m16938o(long j2, TimeUnit timeUnit) {
        return m16683a(j2, timeUnit, C4488a.m17267a(), C5556m0.f20396b, false);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: p */
    public final AbstractC4474c m16942p() {
        return C4476a.m17121a(new C4972l1(this));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: r */
    public final AbstractC4469b0<T> m16945r(InterfaceC4584o<? super Throwable, ? extends T> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "valueSupplier is null");
        return C4476a.m17119a(new C4910a2(this, interfaceC4584o));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T, R> AbstractC4469b0<R> m16590b(InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o, int i2, InterfaceC4504g0<? extends T>... interfaceC4504g0Arr) {
        return m16599b(interfaceC4504g0Arr, interfaceC4584o, i2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public static <T> AbstractC4469b0<T> m16602c(InterfaceC4504g0<? extends InterfaceC4504g0<? extends T>> interfaceC4504g0, int i2) {
        C4601b.m18284a(interfaceC4504g0, "sources is null");
        C4601b.m18279a(i2, "prefetch");
        return C4476a.m17119a(new C5020v(interfaceC4504g0, C4600a.m18258e(), i2, EnumC5170j.IMMEDIATE));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public static <T> AbstractC4469b0<T> m16620e(InterfaceC4504g0<? extends InterfaceC4504g0<? extends T>> interfaceC4504g0, int i2) {
        C4601b.m18284a(interfaceC4504g0, "sources is null");
        C4601b.m18279a(i2, "maxConcurrency");
        return C4476a.m17119a(new C5016u0(interfaceC4504g0, C4600a.m18258e(), true, i2, m16521L()));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: f */
    public static <T> AbstractC4469b0<T> m16628f(InterfaceC4504g0<? extends T>... interfaceC4504g0Arr) {
        return m16600b((Object[]) interfaceC4504g0Arr).m16737a(C4600a.m18258e(), true, interfaceC4504g0Arr.length);
    }

    @InterfaceC4548h("none")
    /* renamed from: g */
    public final void m16894g() {
        C4970l.m18457a(this);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: h */
    public final AbstractC4518k0<T> m16902h(T t) {
        C4601b.m18284a((Object) t, "defaultItem is null");
        return C4476a.m17128a(new C5007s1(this, t));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: j */
    public final <T2> AbstractC4469b0<T2> m16911j() {
        return C4476a.m17119a(new C4944g0(this));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: k */
    public final AbstractC4469b0<T> m16920k(InterfaceC4504g0<? extends T> interfaceC4504g0) {
        C4601b.m18284a(interfaceC4504g0, "other is null");
        return C4476a.m17119a(new C4947g3(this, interfaceC4504g0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: m */
    public final <B> AbstractC4469b0<AbstractC4469b0<T>> m16930m(InterfaceC4504g0<B> interfaceC4504g0) {
        return m16785b(interfaceC4504g0, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: n */
    public final AbstractC4469b0<T> m16934n(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return m16527a(j2, timeUnit, (InterfaceC4504g0) null, abstractC4516j0);
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: o */
    public final AbstractC4469b0<AbstractC4469b0<T>> m16939o(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return m16683a(j2, timeUnit, abstractC4516j0, C5556m0.f20396b, false);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: p */
    public final <R> AbstractC4469b0<R> m16941p(InterfaceC4584o<? super T, ? extends R> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        return C4476a.m17119a(new C5017u1(this, interfaceC4584o));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: v */
    public final AbstractC5187a<T> m16954v() {
        return C4916b2.m18421w(this);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T, R> AbstractC4469b0<R> m16545a(InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o, int i2, InterfaceC4504g0<? extends T>... interfaceC4504g0Arr) {
        return m16571a(interfaceC4504g0Arr, interfaceC4584o, i2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T, R> AbstractC4469b0<R> m16599b(InterfaceC4504g0<? extends T>[] interfaceC4504g0Arr, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o, int i2) {
        C4601b.m18279a(i2, "bufferSize");
        C4601b.m18284a(interfaceC4584o, "combiner is null");
        if (interfaceC4504g0Arr.length == 0) {
            return m16522M();
        }
        return C4476a.m17119a(new C5015u(interfaceC4504g0Arr, null, interfaceC4584o, i2 << 1, true));
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: d */
    public static AbstractC4469b0<Long> m16612d(long j2, long j3, TimeUnit timeUnit) {
        return m16613d(j2, j3, timeUnit, C4488a.m17267a());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: f */
    public static <T> AbstractC4469b0<T> m16625f(InterfaceC4504g0<? extends InterfaceC4504g0<? extends T>> interfaceC4504g0, int i2) {
        C4601b.m18284a(interfaceC4504g0, "sources is null");
        C4601b.m18279a(i2, "bufferSize");
        return C4476a.m17119a(new C4953h3(interfaceC4504g0, C4600a.m18258e(), i2, false));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: g */
    public final <U> AbstractC4469b0<T> m16889g(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<U>> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "itemDelay is null");
        return (AbstractC4469b0<T>) m16915j((InterfaceC4584o) C4977m1.m18476c(interfaceC4584o));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: i */
    public final <U> AbstractC4469b0<T> m16906i(InterfaceC4504g0<U> interfaceC4504g0) {
        C4601b.m18284a(interfaceC4504g0, "other is null");
        return C4476a.m17119a(new C4929d3(this, interfaceC4504g0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: j */
    public final <R> AbstractC4469b0<R> m16915j(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o) {
        return m16795b((InterfaceC4584o) interfaceC4584o, false);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: l */
    public final <U> AbstractC4469b0<T> m16926l(InterfaceC4504g0<U> interfaceC4504g0) {
        C4601b.m18284a(interfaceC4504g0, "other is null");
        return C4476a.m17119a(new C4979m3(this, interfaceC4504g0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: u */
    public final AbstractC4469b0<T> m16951u() {
        return C4476a.m17119a(new C4950h0(this));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: v */
    public final AbstractC4469b0<T> m16953v(InterfaceC4584o<? super AbstractC4469b0<Throwable>, ? extends InterfaceC4504g0<?>> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "handler is null");
        return C4476a.m17119a(new C4993p2(this, interfaceC4584o));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T, R> AbstractC4469b0<R> m16550a(Iterable<? extends InterfaceC4504g0<? extends T>> iterable, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o, int i2) {
        C4601b.m18284a(iterable, "sources is null");
        C4601b.m18284a(interfaceC4584o, "combiner is null");
        C4601b.m18279a(i2, "bufferSize");
        return C4476a.m17119a(new C5015u(null, iterable, interfaceC4584o, i2 << 1, false));
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: d */
    public static AbstractC4469b0<Long> m16613d(long j2, long j3, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        C4601b.m18284a(timeUnit, "unit is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4476a.m17119a(new C4982n1(Math.max(0L, j2), Math.max(0L, j3), timeUnit, abstractC4516j0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: h */
    public final <U> AbstractC4469b0<T> m16898h(InterfaceC4504g0<U> interfaceC4504g0) {
        C4601b.m18284a(interfaceC4504g0, "sampler is null");
        return C4476a.m17119a(new C5003r2(this, interfaceC4504g0, false));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: j */
    public final AbstractC4518k0<T> m16916j(T t) {
        C4601b.m18284a((Object) t, "defaultItem is null");
        return C4476a.m17128a(new C5043z2(this, t));
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: k */
    public final AbstractC4469b0<T> m16918k(long j2, TimeUnit timeUnit) {
        return m16919k(j2, timeUnit, C4488a.m17267a());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: q */
    public final AbstractC4518k0<Boolean> m16944q() {
        return m16753a((InterfaceC4587r) C4600a.m18246a());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: u */
    public final <R> AbstractC4469b0<R> m16952u(InterfaceC4584o<? super AbstractC4469b0<T>, ? extends InterfaceC4504g0<R>> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "selector is null");
        return C4978m2.m18487a(C4977m1.m18468a(this), (InterfaceC4584o) interfaceC4584o);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public static <T> AbstractC4469b0<T> m16610c(InterfaceC4504g0<? extends T>... interfaceC4504g0Arr) {
        if (interfaceC4504g0Arr.length == 0) {
            return m16522M();
        }
        if (interfaceC4504g0Arr.length == 1) {
            return m16646v(interfaceC4504g0Arr[0]);
        }
        return m16635o(m16600b((Object[]) interfaceC4504g0Arr));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public static <T, R> AbstractC4469b0<R> m16621e(InterfaceC4504g0<? extends InterfaceC4504g0<? extends T>> interfaceC4504g0, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "zipper is null");
        C4601b.m18284a(interfaceC4504g0, "sources is null");
        return C4476a.m17119a(new C5019u3(interfaceC4504g0, 16).m16915j((InterfaceC4584o) C4977m1.m18479f(interfaceC4584o)));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: g */
    public final AbstractC4469b0<T> m16888g(InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g) {
        return m16712a(interfaceC4576g, C4600a.f17515c);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: i */
    public final InterfaceC4552c m16910i(InterfaceC4576g<? super T> interfaceC4576g) {
        return m16762a((InterfaceC4576g) interfaceC4576g, (InterfaceC4576g<? super Throwable>) C4600a.f17518f, C4600a.f17515c, C4600a.m18257d());
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: k */
    public final AbstractC4469b0<T> m16919k(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        C4601b.m18284a(timeUnit, "unit is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4476a.m17119a(new C4994p3(this, j2, timeUnit, abstractC4516j0));
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: l */
    public final AbstractC4469b0<T> m16924l(long j2, TimeUnit timeUnit) {
        return m16873f(j2, timeUnit);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: q */
    public final AbstractC4469b0<T> m16943q(InterfaceC4584o<? super Throwable, ? extends InterfaceC4504g0<? extends T>> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "resumeFunction is null");
        return C4476a.m17119a(new C5042z1(this, interfaceC4584o, false));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: f */
    public final T m16883f() {
        T m18125c = m16649B().m18125c();
        if (m18125c != null) {
            return m18125c;
        }
        throw new NoSuchElementException();
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: g */
    public final AbstractC4518k0<T> m16893g(T t) {
        return m16751a(0L, (long) t);
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17465m)
    /* renamed from: h */
    public final AbstractC4469b0<T> m16896h(long j2, TimeUnit timeUnit) {
        return m16687a(j2, timeUnit, C4488a.m17274g(), false, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: i */
    public final AbstractC4469b0<T> m16904i(long j2, TimeUnit timeUnit) {
        return m16926l((InterfaceC4504g0) m16639q(j2, timeUnit));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: j */
    public final AbstractC4469b0<T> m16914j(InterfaceC4504g0<? extends T> interfaceC4504g0) {
        C4601b.m18284a(interfaceC4504g0, "other is null");
        return m16597b(interfaceC4504g0, this);
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: l */
    public final AbstractC4469b0<T> m16925l(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return m16874f(j2, timeUnit, abstractC4516j0);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public static <T> AbstractC4469b0<T> m16614d(InterfaceC4504g0<? extends InterfaceC4504g0<? extends T>> interfaceC4504g0, int i2) {
        C4601b.m18284a(interfaceC4504g0, "sources is null");
        C4601b.m18279a(i2, "maxConcurrency");
        return C4476a.m17119a(new C5016u0(interfaceC4504g0, C4600a.m18258e(), false, i2, m16521L()));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: g */
    public final AbstractC4469b0<T> m16887g(InterfaceC4504g0<? extends T> interfaceC4504g0) {
        C4601b.m18284a(interfaceC4504g0, "next is null");
        return C4476a.m17119a(new C5042z1(this, C4600a.m18255c(interfaceC4504g0), true));
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: h */
    public final AbstractC4469b0<T> m16897h(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return m16687a(j2, timeUnit, abstractC4516j0, false, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: i */
    public final AbstractC4469b0<T> m16905i(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return m16926l((InterfaceC4504g0) m16640q(j2, timeUnit, abstractC4516j0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T, R> AbstractC4469b0<R> m16571a(InterfaceC4504g0<? extends T>[] interfaceC4504g0Arr, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o, int i2) {
        C4601b.m18284a(interfaceC4504g0Arr, "sources is null");
        if (interfaceC4504g0Arr.length == 0) {
            return m16522M();
        }
        C4601b.m18284a(interfaceC4584o, "combiner is null");
        C4601b.m18279a(i2, "bufferSize");
        return C4476a.m17119a(new C5015u(interfaceC4504g0Arr, null, interfaceC4584o, i2 << 1, false));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T, R> AbstractC4469b0<R> m16595b(Iterable<? extends InterfaceC4504g0<? extends T>> iterable, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o, int i2) {
        C4601b.m18284a(iterable, "sources is null");
        C4601b.m18284a(interfaceC4584o, "combiner is null");
        C4601b.m18279a(i2, "bufferSize");
        return C4476a.m17119a(new C5015u(null, iterable, interfaceC4584o, i2 << 1, true));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: f */
    public final <U> AbstractC4469b0<T> m16878f(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<U>> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "debounceSelector is null");
        return C4476a.m17119a(new C4914b0(this, interfaceC4584o));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: h */
    public final AbstractC4469b0<T> m16900h(InterfaceC4587r<? super T> interfaceC4587r) {
        C4601b.m18284a(interfaceC4587r, "predicate is null");
        return C4476a.m17119a(new C4989o3(this, interfaceC4587r));
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17465m)
    /* renamed from: j */
    public final AbstractC4469b0<T> m16912j(long j2, TimeUnit timeUnit) {
        return m16782b(j2, timeUnit, C4488a.m17274g(), false, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: g */
    public final AbstractC4469b0<T> m16885g(long j2, TimeUnit timeUnit) {
        return m16906i((InterfaceC4504g0) m16639q(j2, timeUnit));
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: j */
    public final AbstractC4469b0<T> m16913j(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return m16782b(j2, timeUnit, abstractC4516j0, false, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public static <T, S> AbstractC4469b0<T> m16609c(Callable<S> callable, InterfaceC4572c<S, InterfaceC4517k<T>, S> interfaceC4572c) {
        return m16563a((Callable) callable, (InterfaceC4572c) interfaceC4572c, C4600a.m18257d());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public static <T> AbstractC4518k0<Boolean> m16619d(InterfaceC4504g0<? extends T> interfaceC4504g0, InterfaceC4504g0<? extends T> interfaceC4504g02) {
        return m16574a(interfaceC4504g0, interfaceC4504g02, C4601b.m18283a(), m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public final Iterable<T> m16870e() {
        return new C4931e(this);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: f */
    public final AbstractC4469b0<T> m16882f(T t) {
        C4601b.m18284a((Object) t, "defaultItem is null");
        return m16920k((InterfaceC4504g0) m16633l(t));
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: g */
    public final AbstractC4469b0<T> m16886g(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return m16906i((InterfaceC4504g0) m16640q(j2, timeUnit, abstractC4516j0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: h */
    public final AbstractC4518k0<List<T>> m16901h(int i2) {
        return m16756a(C4600a.m18260g(), i2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public static <T> AbstractC4469b0<T> m16607c(Iterable<? extends InterfaceC4504g0<? extends T>> iterable, int i2, int i3) {
        return m16626f((Iterable) iterable).m16738a(C4600a.m18258e(), true, i2, i3);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public static <T, R> AbstractC4469b0<R> m16616d(Iterable<? extends InterfaceC4504g0<? extends T>> iterable, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "zipper is null");
        C4601b.m18284a(iterable, "sources is null");
        return C4476a.m17119a(new C4942f4(null, iterable, interfaceC4584o, m16521L(), false));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public final <U> AbstractC4469b0<U> m16862e(InterfaceC4584o<? super T, ? extends Iterable<? extends U>> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        return C4476a.m17119a(new C5041z0(this, interfaceC4584o));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: g */
    public final <R> AbstractC4469b0<R> m16890g(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o, int i2) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        C4601b.m18279a(i2, "bufferSize");
        if (this instanceof InterfaceCallableC4614m) {
            Object call = ((InterfaceCallableC4614m) this).call();
            if (call == null) {
                return m16522M();
            }
            return C5008s2.m18519a(call, interfaceC4584o);
        }
        return C4476a.m17119a(new C4953h3(this, interfaceC4584o, i2, true));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T> AbstractC4469b0<T> m16597b(InterfaceC4504g0<? extends T>... interfaceC4504g0Arr) {
        if (interfaceC4504g0Arr.length == 0) {
            return m16522M();
        }
        if (interfaceC4504g0Arr.length == 1) {
            return m16646v(interfaceC4504g0Arr[0]);
        }
        return C4476a.m17119a(new C5020v(m16600b((Object[]) interfaceC4504g0Arr), C4600a.m18258e(), m16521L(), EnumC5170j.BOUNDARY));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public static <T> AbstractC4469b0<T> m16601c(int i2, int i3, InterfaceC4504g0<? extends T>... interfaceC4504g0Arr) {
        return m16600b((Object[]) interfaceC4504g0Arr).m16738a(C4600a.m18258e(), true, i2, i3);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: f */
    public final AbstractC4469b0<T> m16877f(InterfaceC4576g<? super T> interfaceC4576g) {
        InterfaceC4576g<? super Throwable> m18257d = C4600a.m18257d();
        InterfaceC4570a interfaceC4570a = C4600a.f17515c;
        return m16544a((InterfaceC4576g) interfaceC4576g, m18257d, interfaceC4570a, interfaceC4570a);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public static <T> AbstractC4469b0<T> m16603c(InterfaceC4504g0<? extends T> interfaceC4504g0, InterfaceC4504g0<? extends T> interfaceC4504g02) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        return m16600b((Object[]) new InterfaceC4504g0[]{interfaceC4504g0, interfaceC4504g02}).m16737a(C4600a.m18258e(), true, 2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public final AbstractC4518k0<Boolean> m16867e(Object obj) {
        C4601b.m18284a(obj, "element is null");
        return m16806b((InterfaceC4587r) C4600a.m18248a(obj));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: f */
    public final <K> AbstractC4469b0<AbstractC5188b<K, T>> m16880f(InterfaceC4584o<? super T, ? extends K> interfaceC4584o, boolean z) {
        return (AbstractC4469b0<AbstractC5188b<K, T>>) m16734a(interfaceC4584o, C4600a.m18258e(), z, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T1, T2, R> AbstractC4469b0<R> m16541a(InterfaceC4504g0<? extends T1> interfaceC4504g0, InterfaceC4504g0<? extends T2> interfaceC4504g02, InterfaceC4572c<? super T1, ? super T2, ? extends R> interfaceC4572c) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        return m16545a(C4600a.m18235a((InterfaceC4572c) interfaceC4572c), m16521L(), interfaceC4504g0, interfaceC4504g02);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public final Iterable<T> m16853d() {
        return new C4919c(this);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: f */
    public final AbstractC4469b0<T> m16875f(InterfaceC4504g0<? extends T> interfaceC4504g0) {
        C4601b.m18284a(interfaceC4504g0, "next is null");
        return m16943q(C4600a.m18255c(interfaceC4504g0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public final T m16854d(T t) {
        return m16916j((AbstractC4469b0<T>) t).m17515d();
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public final AbstractC4469b0<T> m16861e(InterfaceC4576g<? super Throwable> interfaceC4576g) {
        InterfaceC4576g<? super T> m18257d = C4600a.m18257d();
        InterfaceC4570a interfaceC4570a = C4600a.f17515c;
        return m16544a((InterfaceC4576g) m18257d, interfaceC4576g, interfaceC4570a, interfaceC4570a);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public static <T> AbstractC4469b0<T> m16604c(InterfaceC4504g0<? extends T> interfaceC4504g0, InterfaceC4504g0<? extends T> interfaceC4504g02, InterfaceC4504g0<? extends T> interfaceC4504g03) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        C4601b.m18284a(interfaceC4504g03, "source3 is null");
        return m16600b((Object[]) new InterfaceC4504g0[]{interfaceC4504g0, interfaceC4504g02, interfaceC4504g03}).m16737a(C4600a.m18258e(), true, 3);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public final <R> AbstractC4469b0<R> m16848d(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o) {
        return m16715a(interfaceC4584o, Integer.MAX_VALUE, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public final AbstractC4469b0<T> m16860e(InterfaceC4570a interfaceC4570a) {
        C4601b.m18284a(interfaceC4570a, "onTerminate is null");
        return m16544a((InterfaceC4576g) C4600a.m18257d(), C4600a.m18234a(interfaceC4570a), interfaceC4570a, C4600a.f17515c);
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: f */
    public final AbstractC4469b0<T> m16873f(long j2, TimeUnit timeUnit) {
        return m16874f(j2, timeUnit, C4488a.m17267a());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T1, T2, T3, R> AbstractC4469b0<R> m16540a(InterfaceC4504g0<? extends T1> interfaceC4504g0, InterfaceC4504g0<? extends T2> interfaceC4504g02, InterfaceC4504g0<? extends T3> interfaceC4504g03, InterfaceC4577h<? super T1, ? super T2, ? super T3, ? extends R> interfaceC4577h) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        C4601b.m18284a(interfaceC4504g03, "source3 is null");
        return m16545a(C4600a.m18236a((InterfaceC4577h) interfaceC4577h), m16521L(), interfaceC4504g0, interfaceC4504g02, interfaceC4504g03);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T> AbstractC4469b0<T> m16600b(T... tArr) {
        C4601b.m18284a(tArr, "items is null");
        if (tArr.length == 0) {
            return m16522M();
        }
        if (tArr.length == 1) {
            return m16633l(tArr[0]);
        }
        return C4476a.m17119a(new C4909a1(tArr));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public final <U> AbstractC4469b0<T> m16843d(InterfaceC4504g0<U> interfaceC4504g0) {
        C4601b.m18284a(interfaceC4504g0, "other is null");
        return C4476a.m17119a(new C4938f0(this, interfaceC4504g0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: f */
    public final AbstractC4469b0<T> m16874f(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        C4601b.m18284a(timeUnit, "unit is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4476a.m17119a(new C4998q2(this, j2, timeUnit, abstractC4516j0, false));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: g */
    public final AbstractC4469b0<T> m16891g(InterfaceC4587r<? super T> interfaceC4587r) {
        C4601b.m18284a(interfaceC4587r, "predicate is null");
        return C4476a.m17119a(new C4984n3(this, interfaceC4587r));
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: d */
    public final AbstractC4469b0<T> m16839d(long j2, TimeUnit timeUnit) {
        return m16840d(j2, timeUnit, C4488a.m17267a());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public static <T> AbstractC4469b0<T> m16605c(InterfaceC4504g0<? extends T> interfaceC4504g0, InterfaceC4504g0<? extends T> interfaceC4504g02, InterfaceC4504g0<? extends T> interfaceC4504g03, InterfaceC4504g0<? extends T> interfaceC4504g04) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        C4601b.m18284a(interfaceC4504g03, "source3 is null");
        C4601b.m18284a(interfaceC4504g04, "source4 is null");
        return m16600b((Object[]) new InterfaceC4504g0[]{interfaceC4504g0, interfaceC4504g02, interfaceC4504g03, interfaceC4504g04}).m16737a(C4600a.m18258e(), true, 4);
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: d */
    public final AbstractC4469b0<T> m16840d(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return m16843d((InterfaceC4504g0) m16640q(j2, timeUnit, abstractC4516j0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public final <R> AbstractC4469b0<R> m16864e(InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> interfaceC4584o, boolean z) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        return C4476a.m17119a(new C5036y0(this, interfaceC4584o, z));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: f */
    public final AbstractC4469b0<T> m16881f(InterfaceC4587r<? super T> interfaceC4587r) {
        C4601b.m18284a(interfaceC4587r, "predicate is null");
        return C4476a.m17119a(new C4935e3(this, interfaceC4587r));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: g */
    public final AbstractC4518k0<List<T>> m16892g(int i2) {
        C4601b.m18279a(i2, "capacityHint");
        return C4476a.m17128a(new C5024v3(this, i2));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T1, T2, T3, T4, R> AbstractC4469b0<R> m16539a(InterfaceC4504g0<? extends T1> interfaceC4504g0, InterfaceC4504g0<? extends T2> interfaceC4504g02, InterfaceC4504g0<? extends T3> interfaceC4504g03, InterfaceC4504g0<? extends T4> interfaceC4504g04, InterfaceC4578i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> interfaceC4578i) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        C4601b.m18284a(interfaceC4504g03, "source3 is null");
        C4601b.m18284a(interfaceC4504g04, "source4 is null");
        return m16545a(C4600a.m18237a((InterfaceC4578i) interfaceC4578i), m16521L(), interfaceC4504g0, interfaceC4504g02, interfaceC4504g03, interfaceC4504g04);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public final AbstractC4469b0<T> m16846d(InterfaceC4570a interfaceC4570a) {
        return m16712a(C4600a.m18257d(), interfaceC4570a);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public final AbstractC4469b0<T> m16847d(InterfaceC4576g<? super C4453a0<T>> interfaceC4576g) {
        C4601b.m18284a(interfaceC4576g, "consumer is null");
        return m16544a((InterfaceC4576g) C4600a.m18254c((InterfaceC4576g) interfaceC4576g), (InterfaceC4576g<? super Throwable>) C4600a.m18250b((InterfaceC4576g) interfaceC4576g), C4600a.m18229a((InterfaceC4576g) interfaceC4576g), C4600a.f17515c);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public final AbstractC4469b0<T> m16858e(InterfaceC4504g0<? extends T> interfaceC4504g0) {
        C4601b.m18284a(interfaceC4504g0, "other is null");
        return m16578b(this, interfaceC4504g0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: f */
    public final <R> AbstractC4469b0<R> m16879f(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o, int i2) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        C4601b.m18279a(i2, "bufferSize");
        if (this instanceof InterfaceCallableC4614m) {
            Object call = ((InterfaceCallableC4614m) this).call();
            if (call == null) {
                return m16522M();
            }
            return C5008s2.m18519a(call, interfaceC4584o);
        }
        return C4476a.m17119a(new C4953h3(this, interfaceC4584o, i2, false));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: g */
    public final AbstractC4469b0<AbstractC4469b0<T>> m16884g(long j2) {
        return m16667a(j2, j2, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T, S> AbstractC4469b0<T> m16596b(Callable<S> callable, InterfaceC4571b<S, InterfaceC4517k<T>> interfaceC4571b) {
        C4601b.m18284a(interfaceC4571b, "generator  is null");
        return m16563a((Callable) callable, C4977m1.m18463a(interfaceC4571b), C4600a.m18257d());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public final <R> AbstractC4469b0<R> m16863e(InterfaceC4584o<? super AbstractC4469b0<T>, ? extends InterfaceC4504g0<R>> interfaceC4584o, int i2) {
        C4601b.m18284a(interfaceC4584o, "selector is null");
        C4601b.m18279a(i2, "bufferSize");
        return C4978m2.m18487a(C4977m1.m18469a(this, i2), (InterfaceC4584o) interfaceC4584o);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T> AbstractC4469b0<T> m16593b(Iterable<? extends InterfaceC4504g0<? extends T>> iterable, int i2, int i3) {
        return m16626f((Iterable) iterable).m16738a(C4600a.m18258e(), false, i2, i3);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public final T m16836c() {
        C4625g c4625g = new C4625g();
        subscribe(c4625g);
        T m18293a = c4625g.m18293a();
        if (m18293a != null) {
            return m18293a;
        }
        throw new NoSuchElementException();
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, R> AbstractC4469b0<R> m16538a(InterfaceC4504g0<? extends T1> interfaceC4504g0, InterfaceC4504g0<? extends T2> interfaceC4504g02, InterfaceC4504g0<? extends T3> interfaceC4504g03, InterfaceC4504g0<? extends T4> interfaceC4504g04, InterfaceC4504g0<? extends T5> interfaceC4504g05, InterfaceC4579j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> interfaceC4579j) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        C4601b.m18284a(interfaceC4504g03, "source3 is null");
        C4601b.m18284a(interfaceC4504g04, "source4 is null");
        C4601b.m18284a(interfaceC4504g05, "source5 is null");
        return m16545a(C4600a.m18238a((InterfaceC4579j) interfaceC4579j), m16521L(), interfaceC4504g0, interfaceC4504g02, interfaceC4504g03, interfaceC4504g04, interfaceC4504g05);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T> AbstractC4469b0<T> m16576b(int i2, int i3, InterfaceC4504g0<? extends T>... interfaceC4504g0Arr) {
        return m16600b((Object[]) interfaceC4504g0Arr).m16738a(C4600a.m18258e(), false, i2, i3);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T> AbstractC4469b0<T> m16578b(InterfaceC4504g0<? extends T> interfaceC4504g0, InterfaceC4504g0<? extends T> interfaceC4504g02) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        return m16600b((Object[]) new InterfaceC4504g0[]{interfaceC4504g0, interfaceC4504g02}).m16737a(C4600a.m18258e(), false, 2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public final <R> AbstractC4469b0<R> m16849d(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o, int i2) {
        return m16738a((InterfaceC4584o) interfaceC4584o, false, i2, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: e */
    public final AbstractC5187a<T> m16868e(long j2, TimeUnit timeUnit) {
        return m16869e(j2, timeUnit, C4488a.m17267a());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public final <R> AbstractC4469b0<R> m16850d(InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends R>> interfaceC4584o, boolean z) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        return C4476a.m17119a(new C5031x0(this, interfaceC4584o, z));
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: e */
    public final AbstractC5187a<T> m16869e(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        C4601b.m18284a(timeUnit, "unit is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4978m2.m18488a(this, j2, timeUnit, abstractC4516j0);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public final Iterable<T> m16835c(T t) {
        return new C4925d(this, t);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: f */
    public final AbstractC4469b0<T> m16872f(long j2) {
        if (j2 >= 0) {
            return C4476a.m17119a(new C4959i3(this, j2));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T> AbstractC4469b0<T> m16579b(InterfaceC4504g0<? extends T> interfaceC4504g0, InterfaceC4504g0<? extends T> interfaceC4504g02, InterfaceC4504g0<? extends T> interfaceC4504g03) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        C4601b.m18284a(interfaceC4504g03, "source3 is null");
        return m16600b((Object[]) new InterfaceC4504g0[]{interfaceC4504g0, interfaceC4504g02, interfaceC4504g03}).m16737a(C4600a.m18258e(), false, 3);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public final AbstractC4469b0<T> m16815c(int i2) {
        return C5000r.m18512a((AbstractC4469b0) this, i2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public final InterfaceC4552c m16851d(InterfaceC4587r<? super T> interfaceC4587r) {
        return m16764a((InterfaceC4587r) interfaceC4587r, (InterfaceC4576g<? super Throwable>) C4600a.f17518f, C4600a.f17515c);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public final <R> AbstractC4469b0<R> m16828c(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o) {
        return m16720a((InterfaceC4584o) interfaceC4584o, m16521L(), true);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public final AbstractC5187a<T> m16852d(int i2) {
        C4601b.m18279a(i2, "bufferSize");
        return C4978m2.m18492h(this, i2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public final AbstractC4469b0<T> m16865e(InterfaceC4587r<? super Throwable> interfaceC4587r) {
        return m16673a(C5556m0.f20396b, interfaceC4587r);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: f */
    public final AbstractC4469b0<T> m16871f(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + i2);
        }
        if (i2 == 0) {
            return C4476a.m17119a(new C4967k1(this));
        }
        if (i2 == 1) {
            return C4476a.m17119a(new C4969k3(this));
        }
        return C4476a.m17119a(new C4964j3(this, i2));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, T6, R> AbstractC4469b0<R> m16537a(InterfaceC4504g0<? extends T1> interfaceC4504g0, InterfaceC4504g0<? extends T2> interfaceC4504g02, InterfaceC4504g0<? extends T3> interfaceC4504g03, InterfaceC4504g0<? extends T4> interfaceC4504g04, InterfaceC4504g0<? extends T5> interfaceC4504g05, InterfaceC4504g0<? extends T6> interfaceC4504g06, InterfaceC4580k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> interfaceC4580k) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        C4601b.m18284a(interfaceC4504g03, "source3 is null");
        C4601b.m18284a(interfaceC4504g04, "source4 is null");
        C4601b.m18284a(interfaceC4504g05, "source5 is null");
        C4601b.m18284a(interfaceC4504g06, "source6 is null");
        return m16545a(C4600a.m18239a((InterfaceC4580k) interfaceC4580k), m16521L(), interfaceC4504g0, interfaceC4504g02, interfaceC4504g03, interfaceC4504g04, interfaceC4504g05, interfaceC4504g06);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public final <U> AbstractC4469b0<U> m16829c(InterfaceC4584o<? super T, ? extends Iterable<? extends U>> interfaceC4584o, int i2) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        C4601b.m18279a(i2, "prefetch");
        return (AbstractC4469b0<U>) m16714a(C4977m1.m18474b(interfaceC4584o), i2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public final AbstractC4469b0<T> m16857e(long j2) {
        if (j2 <= 0) {
            return C4476a.m17119a(this);
        }
        return C4476a.m17119a(new C4911a3(this, j2));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public final AbstractC4469b0<T> m16838d(long j2) {
        return m16673a(j2, C4600a.m18251b());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T> AbstractC4469b0<T> m16580b(InterfaceC4504g0<? extends T> interfaceC4504g0, InterfaceC4504g0<? extends T> interfaceC4504g02, InterfaceC4504g0<? extends T> interfaceC4504g03, InterfaceC4504g0<? extends T> interfaceC4504g04) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        C4601b.m18284a(interfaceC4504g03, "source3 is null");
        C4601b.m18284a(interfaceC4504g04, "source4 is null");
        return m16600b((Object[]) new InterfaceC4504g0[]{interfaceC4504g0, interfaceC4504g02, interfaceC4504g03, interfaceC4504g04}).m16737a(C4600a.m18258e(), false, 4);
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17465m)
    /* renamed from: d */
    public final AbstractC4469b0<T> m16842d(long j2, TimeUnit timeUnit, boolean z) {
        return m16782b(j2, timeUnit, C4488a.m17274g(), z, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public final AbstractC4469b0<T> m16856e(int i2) {
        if (i2 >= 0) {
            if (i2 == 0) {
                return C4476a.m17119a(this);
            }
            return C4476a.m17119a(new C4917b3(this, i2));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + i2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public final AbstractC4469b0<T> m16823c(InterfaceC4504g0<? extends T> interfaceC4504g0) {
        C4601b.m18284a(interfaceC4504g0, "other is null");
        return m16531a((InterfaceC4504g0) this, (InterfaceC4504g0) interfaceC4504g0);
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: d */
    public final AbstractC4469b0<T> m16841d(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, boolean z) {
        return m16782b(j2, timeUnit, abstractC4516j0, z, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: f */
    public final AbstractC4469b0<T> m16876f(AbstractC4516j0 abstractC4516j0) {
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4476a.m17119a(new C5029w3(this, abstractC4516j0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public final AbstractC4469b0<C4490c<T>> m16845d(AbstractC4516j0 abstractC4516j0) {
        return m16748a(TimeUnit.MILLISECONDS, abstractC4516j0);
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: c */
    public final AbstractC4469b0<T> m16819c(long j2, TimeUnit timeUnit) {
        return m16686a(j2, timeUnit, C4488a.m17267a(), false);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public final <U, V> AbstractC4469b0<AbstractC4469b0<T>> m16844d(InterfaceC4504g0<U> interfaceC4504g0, InterfaceC4584o<? super U, ? extends InterfaceC4504g0<V>> interfaceC4584o) {
        return m16699a(interfaceC4504g0, interfaceC4584o, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public final <E extends InterfaceC4514i0<? super T>> E m16866e(E e2) {
        subscribe(e2);
        return e2;
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: c */
    public final AbstractC4469b0<T> m16820c(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return m16686a(j2, timeUnit, abstractC4516j0, false);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public final AbstractC4469b0<C4490c<T>> m16859e(AbstractC4516j0 abstractC4516j0) {
        return m16800b(TimeUnit.MILLISECONDS, abstractC4516j0);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, T6, T7, R> AbstractC4469b0<R> m16536a(InterfaceC4504g0<? extends T1> interfaceC4504g0, InterfaceC4504g0<? extends T2> interfaceC4504g02, InterfaceC4504g0<? extends T3> interfaceC4504g03, InterfaceC4504g0<? extends T4> interfaceC4504g04, InterfaceC4504g0<? extends T5> interfaceC4504g05, InterfaceC4504g0<? extends T6> interfaceC4504g06, InterfaceC4504g0<? extends T7> interfaceC4504g07, InterfaceC4581l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> interfaceC4581l) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        C4601b.m18284a(interfaceC4504g03, "source3 is null");
        C4601b.m18284a(interfaceC4504g04, "source4 is null");
        C4601b.m18284a(interfaceC4504g05, "source5 is null");
        C4601b.m18284a(interfaceC4504g06, "source6 is null");
        C4601b.m18284a(interfaceC4504g07, "source7 is null");
        return m16545a(C4600a.m18240a((InterfaceC4581l) interfaceC4581l), m16521L(), interfaceC4504g0, interfaceC4504g02, interfaceC4504g03, interfaceC4504g04, interfaceC4504g05, interfaceC4504g06, interfaceC4504g07);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T> AbstractC4469b0<T> m16592b(Iterable<? extends InterfaceC4504g0<? extends T>> iterable, int i2) {
        return m16626f((Iterable) iterable).m16737a(C4600a.m18258e(), true, i2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public final AbstractC4469b0<T> m16827c(InterfaceC4576g<? super T> interfaceC4576g) {
        C4601b.m18284a(interfaceC4576g, "onAfterNext is null");
        return C4476a.m17119a(new C4966k0(this, interfaceC4576g));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static AbstractC4469b0<Integer> m16575b(int i2, int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i3);
        }
        if (i3 == 0) {
            return m16522M();
        }
        if (i3 == 1) {
            return m16633l(Integer.valueOf(i2));
        }
        if (i2 + (i3 - 1) <= 2147483647L) {
            return C4476a.m17119a(new C4928d2(i2, i3));
        }
        throw new IllegalArgumentException("Integer overflow");
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public final AbstractC4469b0<T> m16826c(InterfaceC4570a interfaceC4570a) {
        return m16544a((InterfaceC4576g) C4600a.m18257d(), C4600a.m18257d(), interfaceC4570a, C4600a.f17515c);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public final AbstractC4469b0<T> m16830c(InterfaceC4587r<? super T> interfaceC4587r) {
        C4601b.m18284a(interfaceC4587r, "predicate is null");
        return C4476a.m17119a(new C5011t0(this, interfaceC4587r));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public final AbstractC4474c m16832c(InterfaceC4584o<? super T, ? extends InterfaceC4513i> interfaceC4584o, boolean z) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        return C4476a.m17121a(new C5026w0(this, interfaceC4584o, z));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static AbstractC4469b0<Long> m16577b(long j2, long j3) {
        if (j3 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j3);
        }
        if (j3 == 0) {
            return m16522M();
        }
        if (j3 == 1) {
            return m16633l(Long.valueOf(j2));
        }
        long j4 = (j3 - 1) + j2;
        if (j2 > 0 && j4 < 0) {
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        return C4476a.m17119a(new C4934e2(j2, j3));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public final AbstractC4469b0<T> m16816c(long j2) {
        if (j2 >= 0) {
            if (j2 == 0) {
                return m16522M();
            }
            return C4476a.m17119a(new C4963j2(this, j2));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> AbstractC4469b0<R> m16535a(InterfaceC4504g0<? extends T1> interfaceC4504g0, InterfaceC4504g0<? extends T2> interfaceC4504g02, InterfaceC4504g0<? extends T3> interfaceC4504g03, InterfaceC4504g0<? extends T4> interfaceC4504g04, InterfaceC4504g0<? extends T5> interfaceC4504g05, InterfaceC4504g0<? extends T6> interfaceC4504g06, InterfaceC4504g0<? extends T7> interfaceC4504g07, InterfaceC4504g0<? extends T8> interfaceC4504g08, InterfaceC4582m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> interfaceC4582m) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        C4601b.m18284a(interfaceC4504g03, "source3 is null");
        C4601b.m18284a(interfaceC4504g04, "source4 is null");
        C4601b.m18284a(interfaceC4504g05, "source5 is null");
        C4601b.m18284a(interfaceC4504g06, "source6 is null");
        C4601b.m18284a(interfaceC4504g07, "source7 is null");
        C4601b.m18284a(interfaceC4504g08, "source8 is null");
        return m16545a(C4600a.m18241a((InterfaceC4582m) interfaceC4582m), m16521L(), interfaceC4504g0, interfaceC4504g02, interfaceC4504g03, interfaceC4504g04, interfaceC4504g05, interfaceC4504g06, interfaceC4504g07, interfaceC4504g08);
    }

    @InterfaceC4548h("none")
    /* renamed from: c */
    public final void m16837c(InterfaceC4514i0<? super T> interfaceC4514i0) {
        C4601b.m18284a(interfaceC4514i0, "s is null");
        if (interfaceC4514i0 instanceof C4465l) {
            subscribe(interfaceC4514i0);
        } else {
            subscribe(new C4465l(interfaceC4514i0));
        }
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T1, T2, R> AbstractC4469b0<R> m16588b(InterfaceC4504g0<? extends T1> interfaceC4504g0, InterfaceC4504g0<? extends T2> interfaceC4504g02, InterfaceC4572c<? super T1, ? super T2, ? extends R> interfaceC4572c) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        return m16546a(C4600a.m18235a((InterfaceC4572c) interfaceC4572c), false, m16521L(), interfaceC4504g0, interfaceC4504g02);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T1, T2, T3, R> AbstractC4469b0<R> m16587b(InterfaceC4504g0<? extends T1> interfaceC4504g0, InterfaceC4504g0<? extends T2> interfaceC4504g02, InterfaceC4504g0<? extends T3> interfaceC4504g03, InterfaceC4577h<? super T1, ? super T2, ? super T3, ? extends R> interfaceC4577h) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        C4601b.m18284a(interfaceC4504g03, "source3 is null");
        return m16546a(C4600a.m18236a((InterfaceC4577h) interfaceC4577h), false, m16521L(), interfaceC4504g0, interfaceC4504g02, interfaceC4504g03);
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17465m)
    /* renamed from: c */
    public final AbstractC4469b0<T> m16822c(long j2, TimeUnit timeUnit, boolean z) {
        return m16687a(j2, timeUnit, C4488a.m17274g(), z, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: c */
    public final AbstractC4469b0<T> m16821c(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, boolean z) {
        return m16687a(j2, timeUnit, abstractC4516j0, z, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: c */
    public final AbstractC4469b0<T> m16825c(AbstractC4516j0 abstractC4516j0) {
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4476a.m17119a(new C4941f3(this, abstractC4516j0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> AbstractC4469b0<R> m16534a(InterfaceC4504g0<? extends T1> interfaceC4504g0, InterfaceC4504g0<? extends T2> interfaceC4504g02, InterfaceC4504g0<? extends T3> interfaceC4504g03, InterfaceC4504g0<? extends T4> interfaceC4504g04, InterfaceC4504g0<? extends T5> interfaceC4504g05, InterfaceC4504g0<? extends T6> interfaceC4504g06, InterfaceC4504g0<? extends T7> interfaceC4504g07, InterfaceC4504g0<? extends T8> interfaceC4504g08, InterfaceC4504g0<? extends T9> interfaceC4504g09, InterfaceC4583n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> interfaceC4583n) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        C4601b.m18284a(interfaceC4504g03, "source3 is null");
        C4601b.m18284a(interfaceC4504g04, "source4 is null");
        C4601b.m18284a(interfaceC4504g05, "source5 is null");
        C4601b.m18284a(interfaceC4504g06, "source6 is null");
        C4601b.m18284a(interfaceC4504g07, "source7 is null");
        C4601b.m18284a(interfaceC4504g08, "source8 is null");
        C4601b.m18284a(interfaceC4504g09, "source9 is null");
        return m16545a(C4600a.m18242a((InterfaceC4583n) interfaceC4583n), m16521L(), interfaceC4504g0, interfaceC4504g02, interfaceC4504g03, interfaceC4504g04, interfaceC4504g05, interfaceC4504g06, interfaceC4504g07, interfaceC4504g08, interfaceC4504g09);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T1, T2, T3, T4, R> AbstractC4469b0<R> m16586b(InterfaceC4504g0<? extends T1> interfaceC4504g0, InterfaceC4504g0<? extends T2> interfaceC4504g02, InterfaceC4504g0<? extends T3> interfaceC4504g03, InterfaceC4504g0<? extends T4> interfaceC4504g04, InterfaceC4578i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> interfaceC4578i) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        C4601b.m18284a(interfaceC4504g03, "source3 is null");
        C4601b.m18284a(interfaceC4504g04, "source4 is null");
        return m16546a(C4600a.m18237a((InterfaceC4578i) interfaceC4578i), false, m16521L(), interfaceC4504g0, interfaceC4504g02, interfaceC4504g03, interfaceC4504g04);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public final <U, V> AbstractC4469b0<T> m16824c(InterfaceC4504g0<U> interfaceC4504g0, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<V>> interfaceC4584o) {
        C4601b.m18284a(interfaceC4504g0, "firstTimeoutIndicator is null");
        return m16589b(interfaceC4504g0, interfaceC4584o, (InterfaceC4504g0) null);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public final <K, V> AbstractC4518k0<Map<K, Collection<V>>> m16833c(InterfaceC4584o<? super T, ? extends K> interfaceC4584o, InterfaceC4584o<? super T, ? extends V> interfaceC4584o2) {
        return m16752a((InterfaceC4584o) interfaceC4584o, (InterfaceC4584o) interfaceC4584o2, (Callable) EnumC5173m.asCallable(), (InterfaceC4584o) EnumC5162b.asFunction());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T1, T2, T3, T4, T5, R> AbstractC4469b0<R> m16585b(InterfaceC4504g0<? extends T1> interfaceC4504g0, InterfaceC4504g0<? extends T2> interfaceC4504g02, InterfaceC4504g0<? extends T3> interfaceC4504g03, InterfaceC4504g0<? extends T4> interfaceC4504g04, InterfaceC4504g0<? extends T5> interfaceC4504g05, InterfaceC4579j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> interfaceC4579j) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        C4601b.m18284a(interfaceC4504g03, "source3 is null");
        C4601b.m18284a(interfaceC4504g04, "source4 is null");
        C4601b.m18284a(interfaceC4504g05, "source5 is null");
        return m16546a(C4600a.m18238a((InterfaceC4579j) interfaceC4579j), false, m16521L(), interfaceC4504g0, interfaceC4504g02, interfaceC4504g03, interfaceC4504g04, interfaceC4504g05);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public final <K, V> AbstractC4518k0<Map<K, Collection<V>>> m16834c(InterfaceC4584o<? super T, ? extends K> interfaceC4584o, InterfaceC4584o<? super T, ? extends V> interfaceC4584o2, Callable<Map<K, Collection<V>>> callable) {
        return m16752a((InterfaceC4584o) interfaceC4584o, (InterfaceC4584o) interfaceC4584o2, (Callable) callable, (InterfaceC4584o) EnumC5162b.asFunction());
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: c */
    public final AbstractC4469b0<AbstractC4469b0<T>> m16817c(long j2, long j3, TimeUnit timeUnit) {
        return m16670a(j2, j3, timeUnit, C4488a.m17267a(), m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: c */
    public final AbstractC4469b0<AbstractC4469b0<T>> m16818c(long j2, long j3, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return m16670a(j2, j3, timeUnit, abstractC4516j0, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public final <B> AbstractC4469b0<AbstractC4469b0<T>> m16831c(Callable<? extends InterfaceC4504g0<B>> callable) {
        return m16745a(callable, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16531a(InterfaceC4504g0<? extends T> interfaceC4504g0, InterfaceC4504g0<? extends T> interfaceC4504g02) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        return m16597b(interfaceC4504g0, interfaceC4504g02);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T1, T2, T3, T4, T5, T6, R> AbstractC4469b0<R> m16584b(InterfaceC4504g0<? extends T1> interfaceC4504g0, InterfaceC4504g0<? extends T2> interfaceC4504g02, InterfaceC4504g0<? extends T3> interfaceC4504g03, InterfaceC4504g0<? extends T4> interfaceC4504g04, InterfaceC4504g0<? extends T5> interfaceC4504g05, InterfaceC4504g0<? extends T6> interfaceC4504g06, InterfaceC4580k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> interfaceC4580k) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        C4601b.m18284a(interfaceC4504g03, "source3 is null");
        C4601b.m18284a(interfaceC4504g04, "source4 is null");
        C4601b.m18284a(interfaceC4504g05, "source5 is null");
        C4601b.m18284a(interfaceC4504g06, "source6 is null");
        return m16546a(C4600a.m18239a((InterfaceC4580k) interfaceC4580k), false, m16521L(), interfaceC4504g0, interfaceC4504g02, interfaceC4504g03, interfaceC4504g04, interfaceC4504g05, interfaceC4504g06);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16532a(InterfaceC4504g0<? extends T> interfaceC4504g0, InterfaceC4504g0<? extends T> interfaceC4504g02, InterfaceC4504g0<? extends T> interfaceC4504g03) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        C4601b.m18284a(interfaceC4504g03, "source3 is null");
        return m16597b(interfaceC4504g0, interfaceC4504g02, interfaceC4504g03);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16533a(InterfaceC4504g0<? extends T> interfaceC4504g0, InterfaceC4504g0<? extends T> interfaceC4504g02, InterfaceC4504g0<? extends T> interfaceC4504g03, InterfaceC4504g0<? extends T> interfaceC4504g04) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        C4601b.m18284a(interfaceC4504g03, "source3 is null");
        C4601b.m18284a(interfaceC4504g04, "source4 is null");
        return m16597b(interfaceC4504g0, interfaceC4504g02, interfaceC4504g03, interfaceC4504g04);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T1, T2, T3, T4, T5, T6, T7, R> AbstractC4469b0<R> m16583b(InterfaceC4504g0<? extends T1> interfaceC4504g0, InterfaceC4504g0<? extends T2> interfaceC4504g02, InterfaceC4504g0<? extends T3> interfaceC4504g03, InterfaceC4504g0<? extends T4> interfaceC4504g04, InterfaceC4504g0<? extends T5> interfaceC4504g05, InterfaceC4504g0<? extends T6> interfaceC4504g06, InterfaceC4504g0<? extends T7> interfaceC4504g07, InterfaceC4581l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> interfaceC4581l) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        C4601b.m18284a(interfaceC4504g03, "source3 is null");
        C4601b.m18284a(interfaceC4504g04, "source4 is null");
        C4601b.m18284a(interfaceC4504g05, "source5 is null");
        C4601b.m18284a(interfaceC4504g06, "source6 is null");
        C4601b.m18284a(interfaceC4504g07, "source7 is null");
        return m16546a(C4600a.m18240a((InterfaceC4581l) interfaceC4581l), false, m16521L(), interfaceC4504g0, interfaceC4504g02, interfaceC4504g03, interfaceC4504g04, interfaceC4504g05, interfaceC4504g06, interfaceC4504g07);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16524a(int i2, int i3, InterfaceC4504g0<? extends T>... interfaceC4504g0Arr) {
        return m16600b((Object[]) interfaceC4504g0Arr).m16716a(C4600a.m18258e(), i2, i3, false);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16530a(InterfaceC4504g0<? extends InterfaceC4504g0<? extends T>> interfaceC4504g0, int i2, boolean z) {
        C4601b.m18284a(interfaceC4504g0, "sources is null");
        C4601b.m18279a(i2, "prefetch is null");
        return C4476a.m17119a(new C5020v(interfaceC4504g0, C4600a.m18258e(), i2, z ? EnumC5170j.END : EnumC5170j.BOUNDARY));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16529a(InterfaceC4504g0<? extends InterfaceC4504g0<? extends T>> interfaceC4504g0, int i2, int i3) {
        C4601b.m18284a(Integer.valueOf(i2), "maxConcurrency is null");
        C4601b.m18284a(Integer.valueOf(i3), "prefetch is null");
        return m16646v(interfaceC4504g0).m16715a(C4600a.m18258e(), i2, i3);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> AbstractC4469b0<R> m16582b(InterfaceC4504g0<? extends T1> interfaceC4504g0, InterfaceC4504g0<? extends T2> interfaceC4504g02, InterfaceC4504g0<? extends T3> interfaceC4504g03, InterfaceC4504g0<? extends T4> interfaceC4504g04, InterfaceC4504g0<? extends T5> interfaceC4504g05, InterfaceC4504g0<? extends T6> interfaceC4504g06, InterfaceC4504g0<? extends T7> interfaceC4504g07, InterfaceC4504g0<? extends T8> interfaceC4504g08, InterfaceC4582m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> interfaceC4582m) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        C4601b.m18284a(interfaceC4504g03, "source3 is null");
        C4601b.m18284a(interfaceC4504g04, "source4 is null");
        C4601b.m18284a(interfaceC4504g05, "source5 is null");
        C4601b.m18284a(interfaceC4504g06, "source6 is null");
        C4601b.m18284a(interfaceC4504g07, "source7 is null");
        C4601b.m18284a(interfaceC4504g08, "source8 is null");
        return m16546a(C4600a.m18241a((InterfaceC4582m) interfaceC4582m), false, m16521L(), interfaceC4504g0, interfaceC4504g02, interfaceC4504g03, interfaceC4504g04, interfaceC4504g05, interfaceC4504g06, interfaceC4504g07, interfaceC4504g08);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16549a(Iterable<? extends InterfaceC4504g0<? extends T>> iterable, int i2, int i3) {
        C4601b.m18284a(Integer.valueOf(i2), "maxConcurrency is null");
        C4601b.m18284a(Integer.valueOf(i3), "prefetch is null");
        return m16626f((Iterable) iterable).m16716a(C4600a.m18258e(), i2, i3, false);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16528a(InterfaceC4487e0<T> interfaceC4487e0) {
        C4601b.m18284a(interfaceC4487e0, "source is null");
        return C4476a.m17119a(new C4908a0(interfaceC4487e0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16561a(Throwable th) {
        C4601b.m18284a(th, "e is null");
        return m16623e((Callable<? extends Throwable>) C4600a.m18253b(th));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16566a(Future<? extends T> future) {
        C4601b.m18284a(future, "future is null");
        return C4476a.m17119a(new C4921c1(future, 0L, null));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> AbstractC4469b0<R> m16581b(InterfaceC4504g0<? extends T1> interfaceC4504g0, InterfaceC4504g0<? extends T2> interfaceC4504g02, InterfaceC4504g0<? extends T3> interfaceC4504g03, InterfaceC4504g0<? extends T4> interfaceC4504g04, InterfaceC4504g0<? extends T5> interfaceC4504g05, InterfaceC4504g0<? extends T6> interfaceC4504g06, InterfaceC4504g0<? extends T7> interfaceC4504g07, InterfaceC4504g0<? extends T8> interfaceC4504g08, InterfaceC4504g0<? extends T9> interfaceC4504g09, InterfaceC4583n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> interfaceC4583n) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        C4601b.m18284a(interfaceC4504g03, "source3 is null");
        C4601b.m18284a(interfaceC4504g04, "source4 is null");
        C4601b.m18284a(interfaceC4504g05, "source5 is null");
        C4601b.m18284a(interfaceC4504g06, "source6 is null");
        C4601b.m18284a(interfaceC4504g07, "source7 is null");
        C4601b.m18284a(interfaceC4504g08, "source8 is null");
        C4601b.m18284a(interfaceC4504g09, "source9 is null");
        return m16546a(C4600a.m18242a((InterfaceC4583n) interfaceC4583n), false, m16521L(), interfaceC4504g0, interfaceC4504g02, interfaceC4504g03, interfaceC4504g04, interfaceC4504g05, interfaceC4504g06, interfaceC4504g07, interfaceC4504g08, interfaceC4504g09);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16567a(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        C4601b.m18284a(future, "future is null");
        C4601b.m18284a(timeUnit, "unit is null");
        return C4476a.m17119a(new C4921c1(future, j2, timeUnit));
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16568a(Future<? extends T> future, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return m16567a(future, j2, timeUnit).m16825c(abstractC4516j0);
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16569a(Future<? extends T> future, AbstractC4516j0 abstractC4516j0) {
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return m16566a((Future) future).m16825c(abstractC4516j0);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final AbstractC4518k0<Boolean> m16806b(InterfaceC4587r<? super T> interfaceC4587r) {
        C4601b.m18284a(interfaceC4587r, "predicate is null");
        return C4476a.m17128a(new C4960j(this, interfaceC4587r));
    }

    @InterfaceC4542b(EnumC4541a.UNBOUNDED_IN)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16547a(InterfaceC5821b<? extends T> interfaceC5821b) {
        C4601b.m18284a(interfaceC5821b, "publisher is null");
        return C4476a.m17119a(new C4933e1(interfaceC5821b));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final Iterable<T> m16812b() {
        return m16768a(m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T, S> AbstractC4469b0<T> m16562a(Callable<S> callable, InterfaceC4571b<S, InterfaceC4517k<T>> interfaceC4571b, InterfaceC4576g<? super S> interfaceC4576g) {
        C4601b.m18284a(interfaceC4571b, "generator  is null");
        return m16563a((Callable) callable, C4977m1.m18463a(interfaceC4571b), (InterfaceC4576g) interfaceC4576g);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final T m16813b(T t) {
        C4625g c4625g = new C4625g();
        subscribe(c4625g);
        T m18293a = c4625g.m18293a();
        return m18293a != null ? m18293a : t;
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T, S> AbstractC4469b0<T> m16563a(Callable<S> callable, InterfaceC4572c<S, InterfaceC4517k<T>, S> interfaceC4572c, InterfaceC4576g<? super S> interfaceC4576g) {
        C4601b.m18284a(callable, "initialState is null");
        C4601b.m18284a(interfaceC4572c, "generator  is null");
        C4601b.m18284a(interfaceC4576g, "disposeState is null");
        return C4476a.m17119a(new C4945g1(callable, interfaceC4572c, interfaceC4576g));
    }

    @InterfaceC4548h("none")
    /* renamed from: b */
    public final void m16814b(InterfaceC4576g<? super T> interfaceC4576g) {
        C4970l.m18459a(this, interfaceC4576g, C4600a.f17518f, C4600a.f17515c);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final AbstractC4469b0<List<T>> m16776b(int i2) {
        return m16663a(i2, i2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final <B> AbstractC4469b0<List<T>> m16784b(InterfaceC4504g0<B> interfaceC4504g0) {
        return (AbstractC4469b0<List<T>>) m16703a((InterfaceC4504g0) interfaceC4504g0, (Callable) EnumC5162b.asCallable());
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: a */
    public static AbstractC4469b0<Long> m16525a(long j2, long j3, long j4, long j5, TimeUnit timeUnit) {
        return m16526a(j2, j3, j4, j5, timeUnit, C4488a.m17267a());
    }

    @InterfaceC4545e
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final AbstractC4474c m16801b(InterfaceC4584o<? super T, ? extends InterfaceC4513i> interfaceC4584o) {
        return m16802b(interfaceC4584o, 2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public static AbstractC4469b0<Long> m16526a(long j2, long j3, long j4, long j5, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        if (j3 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j3);
        }
        if (j3 == 0) {
            return m16522M().m16820c(j4, timeUnit, abstractC4516j0);
        }
        long j6 = j2 + (j3 - 1);
        if (j2 > 0 && j6 < 0) {
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        C4601b.m18284a(timeUnit, "unit is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4476a.m17119a(new C4987o1(j2, j6, Math.max(0L, j4), Math.max(0L, j5), timeUnit, abstractC4516j0));
    }

    @InterfaceC4545e
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final AbstractC4474c m16802b(InterfaceC4584o<? super T, ? extends InterfaceC4513i> interfaceC4584o, int i2) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        C4601b.m18279a(i2, "capacityHint");
        return C4476a.m17121a(new C5025w(this, interfaceC4584o, i2));
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: b */
    public final AbstractC4469b0<T> m16779b(long j2, TimeUnit timeUnit) {
        return m16780b(j2, timeUnit, C4488a.m17267a());
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: b */
    public final AbstractC4469b0<T> m16780b(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        C4601b.m18284a(timeUnit, "unit is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4476a.m17119a(new C4920c0(this, j2, timeUnit, abstractC4516j0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16552a(T t, T t2) {
        C4601b.m18284a((Object) t, "The first item is null");
        C4601b.m18284a((Object) t2, "The second item is null");
        return m16600b(t, t2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final <U, V> AbstractC4469b0<T> m16787b(InterfaceC4504g0<U> interfaceC4504g0, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<V>> interfaceC4584o) {
        return m16843d((InterfaceC4504g0) interfaceC4504g0).m16889g((InterfaceC4584o) interfaceC4584o);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final AbstractC4469b0<T> m16790b(InterfaceC4570a interfaceC4570a) {
        C4601b.m18284a(interfaceC4570a, "onFinally is null");
        return C4476a.m17119a(new C4971l0(this, interfaceC4570a));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16553a(T t, T t2, T t3) {
        C4601b.m18284a((Object) t, "The first item is null");
        C4601b.m18284a((Object) t2, "The second item is null");
        C4601b.m18284a((Object) t3, "The third item is null");
        return m16600b(t, t2, t3);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final AbstractC4469b0<T> m16789b(InterfaceC4514i0<? super T> interfaceC4514i0) {
        C4601b.m18284a(interfaceC4514i0, "observer is null");
        return m16544a((InterfaceC4576g) C4977m1.m18475c(interfaceC4514i0), (InterfaceC4576g<? super Throwable>) C4977m1.m18473b(interfaceC4514i0), C4977m1.m18462a(interfaceC4514i0), C4600a.f17515c);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16554a(T t, T t2, T t3, T t4) {
        C4601b.m18284a((Object) t, "The first item is null");
        C4601b.m18284a((Object) t2, "The second item is null");
        C4601b.m18284a((Object) t3, "The third item is null");
        C4601b.m18284a((Object) t4, "The fourth item is null");
        return m16600b(t, t2, t3, t4);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final AbstractC4518k0<T> m16803b(long j2) {
        if (j2 >= 0) {
            return C4476a.m17128a(new C4996q0(this, j2, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final <R> AbstractC4469b0<R> m16795b(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o, boolean z) {
        return m16737a(interfaceC4584o, z, Integer.MAX_VALUE);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16555a(T t, T t2, T t3, T t4, T t5) {
        C4601b.m18284a((Object) t, "The first item is null");
        C4601b.m18284a((Object) t2, "The second item is null");
        C4601b.m18284a((Object) t3, "The third item is null");
        C4601b.m18284a((Object) t4, "The fourth item is null");
        C4601b.m18284a((Object) t5, "The fifth item is null");
        return m16600b(t, t2, t3, t4, t5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final <U, V> AbstractC4469b0<V> m16794b(InterfaceC4584o<? super T, ? extends Iterable<? extends U>> interfaceC4584o, InterfaceC4572c<? super T, ? super U, ? extends V> interfaceC4572c) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        C4601b.m18284a(interfaceC4572c, "resultSelector is null");
        return (AbstractC4469b0<V>) m16729a((InterfaceC4584o) C4977m1.m18474b(interfaceC4584o), (InterfaceC4572c) interfaceC4572c, false, m16521L(), m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final <TRight, TLeftEnd, TRightEnd, R> AbstractC4469b0<R> m16788b(InterfaceC4504g0<? extends TRight> interfaceC4504g0, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<TLeftEnd>> interfaceC4584o, InterfaceC4584o<? super TRight, ? extends InterfaceC4504g0<TRightEnd>> interfaceC4584o2, InterfaceC4572c<? super T, ? super TRight, ? extends R> interfaceC4572c) {
        C4601b.m18284a(interfaceC4504g0, "other is null");
        C4601b.m18284a(interfaceC4584o, "leftEnd is null");
        C4601b.m18284a(interfaceC4584o2, "rightEnd is null");
        C4601b.m18284a(interfaceC4572c, "resultSelector is null");
        return C4476a.m17119a(new C4992p1(this, interfaceC4504g0, interfaceC4584o, interfaceC4584o2, interfaceC4572c));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16556a(T t, T t2, T t3, T t4, T t5, T t6) {
        C4601b.m18284a((Object) t, "The first item is null");
        C4601b.m18284a((Object) t2, "The second item is null");
        C4601b.m18284a((Object) t3, "The third item is null");
        C4601b.m18284a((Object) t4, "The fourth item is null");
        C4601b.m18284a((Object) t5, "The fifth item is null");
        C4601b.m18284a((Object) t6, "The sixth item is null");
        return m16600b(t, t2, t3, t4, t5, t6);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final <U> AbstractC4469b0<U> m16796b(Class<U> cls) {
        C4601b.m18284a(cls, "clazz is null");
        return m16830c((InterfaceC4587r) C4600a.m18252b((Class) cls)).m16739a((Class) cls);
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: b */
    public final AbstractC5187a<T> m16811b(AbstractC4516j0 abstractC4516j0) {
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4978m2.m18491a((AbstractC5187a) m16958x(), abstractC4516j0);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final AbstractC4469b0<T> m16792b(InterfaceC4573d<? super Integer, ? super Throwable> interfaceC4573d) {
        C4601b.m18284a(interfaceC4573d, "predicate is null");
        return C4476a.m17119a(new C4983n2(this, interfaceC4573d));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16557a(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        C4601b.m18284a((Object) t, "The first item is null");
        C4601b.m18284a((Object) t2, "The second item is null");
        C4601b.m18284a((Object) t3, "The third item is null");
        C4601b.m18284a((Object) t4, "The fourth item is null");
        C4601b.m18284a((Object) t5, "The fifth item is null");
        C4601b.m18284a((Object) t6, "The sixth item is null");
        C4601b.m18284a((Object) t7, "The seventh item is null");
        return m16600b(t, t2, t3, t4, t5, t6, t7);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final AbstractC4469b0<T> m16793b(InterfaceC4574e interfaceC4574e) {
        C4601b.m18284a(interfaceC4574e, "stop is null");
        return m16673a(C5556m0.f20396b, C4600a.m18247a(interfaceC4574e));
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: b */
    public final AbstractC4469b0<T> m16783b(long j2, TimeUnit timeUnit, boolean z) {
        return m16781b(j2, timeUnit, C4488a.m17267a(), z);
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: b */
    public final AbstractC4469b0<T> m16781b(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, boolean z) {
        C4601b.m18284a(timeUnit, "unit is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4476a.m17119a(new C4998q2(this, j2, timeUnit, abstractC4516j0, z));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final AbstractC4469b0<T> m16791b(InterfaceC4572c<T, T, T> interfaceC4572c) {
        C4601b.m18284a(interfaceC4572c, "accumulator is null");
        return C4476a.m17119a(new C5013t2(this, interfaceC4572c));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16558a(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        C4601b.m18284a((Object) t, "The first item is null");
        C4601b.m18284a((Object) t2, "The second item is null");
        C4601b.m18284a((Object) t3, "The third item is null");
        C4601b.m18284a((Object) t4, "The fourth item is null");
        C4601b.m18284a((Object) t5, "The fifth item is null");
        C4601b.m18284a((Object) t6, "The sixth item is null");
        C4601b.m18284a((Object) t7, "The seventh item is null");
        C4601b.m18284a((Object) t8, "The eighth item is null");
        return m16600b(t, t2, t3, t4, t5, t6, t7, t8);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final <R> AbstractC4469b0<R> m16797b(R r, InterfaceC4572c<R, ? super T, R> interfaceC4572c) {
        C4601b.m18284a(r, "seed is null");
        return m16798b((Callable) C4600a.m18253b(r), (InterfaceC4572c) interfaceC4572c);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final <R> AbstractC4469b0<R> m16798b(Callable<R> callable, InterfaceC4572c<R, ? super T, R> interfaceC4572c) {
        C4601b.m18284a(callable, "seedSupplier is null");
        C4601b.m18284a(interfaceC4572c, "accumulator is null");
        return C4476a.m17119a(new C5018u2(this, callable, interfaceC4572c));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final InterfaceC4552c m16809b(InterfaceC4576g<? super T> interfaceC4576g, InterfaceC4576g<? super Throwable> interfaceC4576g2) {
        return m16762a((InterfaceC4576g) interfaceC4576g, interfaceC4576g2, C4600a.f17515c, C4600a.m18257d());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final InterfaceC4552c m16810b(InterfaceC4576g<? super T> interfaceC4576g, InterfaceC4576g<? super Throwable> interfaceC4576g2, InterfaceC4570a interfaceC4570a) {
        return m16762a((InterfaceC4576g) interfaceC4576g, interfaceC4576g2, interfaceC4570a, C4600a.m18257d());
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17465m)
    /* renamed from: b */
    public final AbstractC4469b0<T> m16777b(long j2, long j3, TimeUnit timeUnit) {
        return m16672a(j2, j3, timeUnit, C4488a.m17274g(), false, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16559a(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        C4601b.m18284a((Object) t, "The first item is null");
        C4601b.m18284a((Object) t2, "The second item is null");
        C4601b.m18284a((Object) t3, "The third item is null");
        C4601b.m18284a((Object) t4, "The fourth item is null");
        C4601b.m18284a((Object) t5, "The fifth item is null");
        C4601b.m18284a((Object) t6, "The sixth item is null");
        C4601b.m18284a((Object) t7, "The seventh item is null");
        C4601b.m18284a((Object) t8, "The eighth item is null");
        C4601b.m18284a((Object) t9, "The ninth item is null");
        return m16600b(t, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: b */
    public final AbstractC4469b0<T> m16778b(long j2, long j3, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return m16672a(j2, j3, timeUnit, abstractC4516j0, false, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: b */
    public final AbstractC4469b0<T> m16782b(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, boolean z, int i2) {
        return m16672a(C5556m0.f20396b, j2, timeUnit, abstractC4516j0, z, i2);
    }

    /* renamed from: b */
    private <U, V> AbstractC4469b0<T> m16589b(InterfaceC4504g0<U> interfaceC4504g0, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<V>> interfaceC4584o, InterfaceC4504g0<? extends T> interfaceC4504g02) {
        C4601b.m18284a(interfaceC4584o, "itemTimeoutIndicator is null");
        return C4476a.m17119a(new C5004r3(this, interfaceC4504g0, interfaceC4584o, interfaceC4504g02));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final AbstractC4469b0<C4490c<T>> m16799b(TimeUnit timeUnit) {
        return m16800b(timeUnit, C4488a.m17267a());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final AbstractC4469b0<C4490c<T>> m16800b(TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        C4601b.m18284a(timeUnit, "unit is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return (AbstractC4469b0<C4490c<T>>) m16941p(C4600a.m18245a(timeUnit, abstractC4516j0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final <U extends Collection<? super T>> AbstractC4518k0<U> m16808b(Callable<U> callable) {
        C4601b.m18284a(callable, "collectionSupplier is null");
        return C4476a.m17128a(new C5024v3(this, callable));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16560a(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        C4601b.m18284a((Object) t, "The first item is null");
        C4601b.m18284a((Object) t2, "The second item is null");
        C4601b.m18284a((Object) t3, "The third item is null");
        C4601b.m18284a((Object) t4, "The fourth item is null");
        C4601b.m18284a((Object) t5, "The fifth item is null");
        C4601b.m18284a((Object) t6, "The sixth item is null");
        C4601b.m18284a((Object) t7, "The seventh item is null");
        C4601b.m18284a((Object) t8, "The eighth item is null");
        C4601b.m18284a((Object) t9, "The ninth item is null");
        C4601b.m18284a((Object) t10, "The tenth item is null");
        return m16600b(t, t2, t3, t4, t5, t6, t7, t8, t9, t10);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final <K, V> AbstractC4518k0<Map<K, V>> m16804b(InterfaceC4584o<? super T, ? extends K> interfaceC4584o, InterfaceC4584o<? super T, ? extends V> interfaceC4584o2) {
        C4601b.m18284a(interfaceC4584o, "keySelector is null");
        C4601b.m18284a(interfaceC4584o2, "valueSelector is null");
        return (AbstractC4518k0<Map<K, V>>) m16757a((Callable) EnumC5173m.asCallable(), (InterfaceC4571b) C4600a.m18232a(interfaceC4584o, interfaceC4584o2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final <K, V> AbstractC4518k0<Map<K, V>> m16805b(InterfaceC4584o<? super T, ? extends K> interfaceC4584o, InterfaceC4584o<? super T, ? extends V> interfaceC4584o2, Callable<? extends Map<K, V>> callable) {
        C4601b.m18284a(interfaceC4584o, "keySelector is null");
        C4601b.m18284a(interfaceC4584o2, "valueSelector is null");
        C4601b.m18284a(callable, "mapSupplier is null");
        return (AbstractC4518k0<Map<K, V>>) m16757a((Callable) callable, (InterfaceC4571b) C4600a.m18232a(interfaceC4584o, interfaceC4584o2));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final AbstractC4518k0<List<T>> m16807b(Comparator<? super T> comparator) {
        C4601b.m18284a(comparator, "comparator is null");
        return (AbstractC4518k0<List<T>>) m16660J().m17524h(C4600a.m18244a((Comparator) comparator));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final <B> AbstractC4469b0<AbstractC4469b0<T>> m16785b(InterfaceC4504g0<B> interfaceC4504g0, int i2) {
        C4601b.m18284a(interfaceC4504g0, "boundary is null");
        C4601b.m18279a(i2, "bufferSize");
        return C4476a.m17119a(new C5044z3(this, interfaceC4504g0, i2));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4469b0<T> m16548a(Iterable<? extends InterfaceC4504g0<? extends T>> iterable, int i2) {
        return m16626f((Iterable) iterable).m16849d(C4600a.m18258e(), i2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4518k0<Boolean> m16573a(InterfaceC4504g0<? extends T> interfaceC4504g0, InterfaceC4504g0<? extends T> interfaceC4504g02, InterfaceC4573d<? super T, ? super T> interfaceC4573d) {
        return m16574a(interfaceC4504g0, interfaceC4504g02, interfaceC4573d, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final <U, R> AbstractC4469b0<R> m16786b(InterfaceC4504g0<? extends U> interfaceC4504g0, InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c) {
        C4601b.m18284a(interfaceC4504g0, "other is null");
        return m16588b(this, interfaceC4504g0, interfaceC4572c);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4518k0<Boolean> m16574a(InterfaceC4504g0<? extends T> interfaceC4504g0, InterfaceC4504g0<? extends T> interfaceC4504g02, InterfaceC4573d<? super T, ? super T> interfaceC4573d, int i2) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        C4601b.m18284a(interfaceC4573d, "isEqual is null");
        C4601b.m18279a(i2, "bufferSize");
        return C4476a.m17128a(new C5028w2(interfaceC4504g0, interfaceC4504g02, interfaceC4573d, i2));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4518k0<Boolean> m16572a(InterfaceC4504g0<? extends T> interfaceC4504g0, InterfaceC4504g0<? extends T> interfaceC4504g02, int i2) {
        return m16574a(interfaceC4504g0, interfaceC4504g02, C4601b.m18283a(), i2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T, D> AbstractC4469b0<T> m16564a(Callable<? extends D> callable, InterfaceC4584o<? super D, ? extends InterfaceC4504g0<? extends T>> interfaceC4584o, InterfaceC4576g<? super D> interfaceC4576g) {
        return m16565a((Callable) callable, (InterfaceC4584o) interfaceC4584o, (InterfaceC4576g) interfaceC4576g, true);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T, D> AbstractC4469b0<T> m16565a(Callable<? extends D> callable, InterfaceC4584o<? super D, ? extends InterfaceC4504g0<? extends T>> interfaceC4584o, InterfaceC4576g<? super D> interfaceC4576g, boolean z) {
        C4601b.m18284a(callable, "resourceSupplier is null");
        C4601b.m18284a(interfaceC4584o, "sourceSupplier is null");
        C4601b.m18284a(interfaceC4576g, "disposer is null");
        return C4476a.m17119a(new C5034x3(callable, interfaceC4584o, interfaceC4576g, z));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T1, T2, R> AbstractC4469b0<R> m16542a(InterfaceC4504g0<? extends T1> interfaceC4504g0, InterfaceC4504g0<? extends T2> interfaceC4504g02, InterfaceC4572c<? super T1, ? super T2, ? extends R> interfaceC4572c, boolean z) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        return m16546a(C4600a.m18235a((InterfaceC4572c) interfaceC4572c), z, m16521L(), interfaceC4504g0, interfaceC4504g02);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T1, T2, R> AbstractC4469b0<R> m16543a(InterfaceC4504g0<? extends T1> interfaceC4504g0, InterfaceC4504g0<? extends T2> interfaceC4504g02, InterfaceC4572c<? super T1, ? super T2, ? extends R> interfaceC4572c, boolean z, int i2) {
        C4601b.m18284a(interfaceC4504g0, "source1 is null");
        C4601b.m18284a(interfaceC4504g02, "source2 is null");
        return m16546a(C4600a.m18235a((InterfaceC4572c) interfaceC4572c), z, i2, interfaceC4504g0, interfaceC4504g02);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T, R> AbstractC4469b0<R> m16546a(InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o, boolean z, int i2, InterfaceC4504g0<? extends T>... interfaceC4504g0Arr) {
        if (interfaceC4504g0Arr.length == 0) {
            return m16522M();
        }
        C4601b.m18284a(interfaceC4584o, "zipper is null");
        C4601b.m18279a(i2, "bufferSize");
        return C4476a.m17119a(new C4942f4(interfaceC4504g0Arr, null, interfaceC4584o, i2, z));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T, R> AbstractC4469b0<R> m16551a(Iterable<? extends InterfaceC4504g0<? extends T>> iterable, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o, boolean z, int i2) {
        C4601b.m18284a(interfaceC4584o, "zipper is null");
        C4601b.m18284a(iterable, "sources is null");
        C4601b.m18279a(i2, "bufferSize");
        return C4476a.m17119a(new C4942f4(null, iterable, interfaceC4584o, i2, z));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4518k0<Boolean> m16753a(InterfaceC4587r<? super T> interfaceC4587r) {
        C4601b.m18284a(interfaceC4587r, "predicate is null");
        return C4476a.m17128a(new C4943g(this, interfaceC4587r));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4469b0<T> m16690a(InterfaceC4504g0<? extends T> interfaceC4504g0) {
        C4601b.m18284a(interfaceC4504g0, "other is null");
        return m16570a(this, interfaceC4504g0);
    }

    @InterfaceC4545e
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <R> R m16770a(@InterfaceC4546f InterfaceC4475c0<T, ? extends R> interfaceC4475c0) {
        return (R) ((InterfaceC4475c0) C4601b.m18284a(interfaceC4475c0, "converter is null")).m17114a(this);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final T m16769a() {
        C4624f c4624f = new C4624f();
        subscribe(c4624f);
        T m18293a = c4624f.m18293a();
        if (m18293a != null) {
            return m18293a;
        }
        throw new NoSuchElementException();
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final T m16771a(T t) {
        C4624f c4624f = new C4624f();
        subscribe(c4624f);
        T m18293a = c4624f.m18293a();
        return m18293a != null ? m18293a : t;
    }

    @InterfaceC4548h("none")
    /* renamed from: a */
    public final void m16773a(InterfaceC4576g<? super T> interfaceC4576g) {
        Iterator<T> it = m16812b().iterator();
        while (it.hasNext()) {
            try {
                interfaceC4576g.accept(it.next());
            } catch (Throwable th) {
                C4561b.m18199b(th);
                ((InterfaceC4552c) it).dispose();
                throw C5171k.m18626c(th);
            }
        }
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final Iterable<T> m16768a(int i2) {
        C4601b.m18279a(i2, "bufferSize");
        return new C4913b(this, i2);
    }

    @InterfaceC4548h("none")
    /* renamed from: a */
    public final void m16774a(InterfaceC4576g<? super T> interfaceC4576g, InterfaceC4576g<? super Throwable> interfaceC4576g2) {
        C4970l.m18459a(this, interfaceC4576g, interfaceC4576g2, C4600a.f17515c);
    }

    @InterfaceC4548h("none")
    /* renamed from: a */
    public final void m16775a(InterfaceC4576g<? super T> interfaceC4576g, InterfaceC4576g<? super Throwable> interfaceC4576g2, InterfaceC4570a interfaceC4570a) {
        C4970l.m18459a(this, interfaceC4576g, interfaceC4576g2, interfaceC4570a);
    }

    @InterfaceC4548h("none")
    /* renamed from: a */
    public final void m16772a(InterfaceC4514i0<? super T> interfaceC4514i0) {
        C4970l.m18458a(this, interfaceC4514i0);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4469b0<List<T>> m16663a(int i2, int i3) {
        return (AbstractC4469b0<List<T>>) m16664a(i2, i3, EnumC5162b.asCallable());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <U extends Collection<? super T>> AbstractC4469b0<U> m16664a(int i2, int i3, Callable<U> callable) {
        C4601b.m18279a(i2, "count");
        C4601b.m18279a(i3, "skip");
        C4601b.m18284a(callable, "bufferSupplier is null");
        return C4476a.m17119a(new C4975m(this, i2, i3, callable));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <U extends Collection<? super T>> AbstractC4469b0<U> m16665a(int i2, Callable<U> callable) {
        return m16664a(i2, i2, callable);
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: a */
    public final AbstractC4469b0<List<T>> m16668a(long j2, long j3, TimeUnit timeUnit) {
        return (AbstractC4469b0<List<T>>) m16671a(j2, j3, timeUnit, C4488a.m17267a(), EnumC5162b.asCallable());
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final AbstractC4469b0<List<T>> m16669a(long j2, long j3, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return (AbstractC4469b0<List<T>>) m16671a(j2, j3, timeUnit, abstractC4516j0, EnumC5162b.asCallable());
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final <U extends Collection<? super T>> AbstractC4469b0<U> m16671a(long j2, long j3, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, Callable<U> callable) {
        C4601b.m18284a(timeUnit, "unit is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        C4601b.m18284a(callable, "bufferSupplier is null");
        return C4476a.m17119a(new C4995q(this, j2, j3, timeUnit, abstractC4516j0, callable, Integer.MAX_VALUE, false));
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: a */
    public final AbstractC4469b0<List<T>> m16674a(long j2, TimeUnit timeUnit) {
        return m16680a(j2, timeUnit, C4488a.m17267a(), Integer.MAX_VALUE);
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: a */
    public final AbstractC4469b0<List<T>> m16675a(long j2, TimeUnit timeUnit, int i2) {
        return m16680a(j2, timeUnit, C4488a.m17267a(), i2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final AbstractC4469b0<List<T>> m16680a(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, int i2) {
        return (AbstractC4469b0<List<T>>) m16681a(j2, timeUnit, abstractC4516j0, i2, (Callable) EnumC5162b.asCallable(), false);
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final <U extends Collection<? super T>> AbstractC4469b0<U> m16681a(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, int i2, Callable<U> callable, boolean z) {
        C4601b.m18284a(timeUnit, "unit is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        C4601b.m18284a(callable, "bufferSupplier is null");
        C4601b.m18279a(i2, "count");
        return C4476a.m17119a(new C4995q(this, j2, j2, timeUnit, abstractC4516j0, callable, i2, z));
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final AbstractC4469b0<List<T>> m16679a(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return (AbstractC4469b0<List<T>>) m16681a(j2, timeUnit, abstractC4516j0, Integer.MAX_VALUE, (Callable) EnumC5162b.asCallable(), false);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <TOpening, TClosing> AbstractC4469b0<List<T>> m16698a(InterfaceC4504g0<? extends TOpening> interfaceC4504g0, InterfaceC4584o<? super TOpening, ? extends InterfaceC4504g0<? extends TClosing>> interfaceC4584o) {
        return (AbstractC4469b0<List<T>>) m16702a((InterfaceC4504g0) interfaceC4504g0, (InterfaceC4584o) interfaceC4584o, (Callable) EnumC5162b.asCallable());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <TOpening, TClosing, U extends Collection<? super T>> AbstractC4469b0<U> m16702a(InterfaceC4504g0<? extends TOpening> interfaceC4504g0, InterfaceC4584o<? super TOpening, ? extends InterfaceC4504g0<? extends TClosing>> interfaceC4584o, Callable<U> callable) {
        C4601b.m18284a(interfaceC4504g0, "openingIndicator is null");
        C4601b.m18284a(interfaceC4584o, "closingIndicator is null");
        C4601b.m18284a(callable, "bufferSupplier is null");
        return C4476a.m17119a(new C4980n(this, interfaceC4504g0, interfaceC4584o, callable));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <B> AbstractC4469b0<List<T>> m16691a(InterfaceC4504g0<B> interfaceC4504g0, int i2) {
        C4601b.m18279a(i2, "initialCapacity");
        return (AbstractC4469b0<List<T>>) m16703a((InterfaceC4504g0) interfaceC4504g0, (Callable) C4600a.m18249a(i2));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <B, U extends Collection<? super T>> AbstractC4469b0<U> m16703a(InterfaceC4504g0<B> interfaceC4504g0, Callable<U> callable) {
        C4601b.m18284a(interfaceC4504g0, "boundary is null");
        C4601b.m18284a(callable, "bufferSupplier is null");
        return C4476a.m17119a(new C4990p(this, interfaceC4504g0, callable));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <B> AbstractC4469b0<List<T>> m16744a(Callable<? extends InterfaceC4504g0<B>> callable) {
        return (AbstractC4469b0<List<T>>) m16746a((Callable) callable, (Callable) EnumC5162b.asCallable());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <B, U extends Collection<? super T>> AbstractC4469b0<U> m16746a(Callable<? extends InterfaceC4504g0<B>> callable, Callable<U> callable2) {
        C4601b.m18284a(callable, "boundarySupplier is null");
        C4601b.m18284a(callable2, "bufferSupplier is null");
        return C4476a.m17119a(new C4985o(this, callable, callable2));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <U> AbstractC4469b0<U> m16739a(Class<U> cls) {
        C4601b.m18284a(cls, "clazz is null");
        return (AbstractC4469b0<U>) m16941p(C4600a.m18243a((Class) cls));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <U> AbstractC4518k0<U> m16757a(Callable<? extends U> callable, InterfaceC4571b<? super U, ? super T> interfaceC4571b) {
        C4601b.m18284a(callable, "initialValueSupplier is null");
        C4601b.m18284a(interfaceC4571b, "collector is null");
        return C4476a.m17128a(new C5010t(this, callable, interfaceC4571b));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <U> AbstractC4518k0<U> m16754a(U u, InterfaceC4571b<? super U, ? super T> interfaceC4571b) {
        C4601b.m18284a(u, "initialValue is null");
        return m16757a((Callable) C4600a.m18253b(u), (InterfaceC4571b) interfaceC4571b);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <R> AbstractC4469b0<R> m16705a(InterfaceC4512h0<? super T, ? extends R> interfaceC4512h0) {
        return m16646v(((InterfaceC4512h0) C4601b.m18284a(interfaceC4512h0, "composer is null")).m17403a(this));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <R> AbstractC4469b0<R> m16713a(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o) {
        return m16714a(interfaceC4584o, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <R> AbstractC4469b0<R> m16714a(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o, int i2) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        C4601b.m18279a(i2, "prefetch");
        if (this instanceof InterfaceCallableC4614m) {
            Object call = ((InterfaceCallableC4614m) this).call();
            if (call == null) {
                return m16522M();
            }
            return C5008s2.m18519a(call, interfaceC4584o);
        }
        return C4476a.m17119a(new C5020v(this, interfaceC4584o, i2, EnumC5170j.IMMEDIATE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <R> AbstractC4469b0<R> m16720a(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o, int i2, boolean z) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        C4601b.m18279a(i2, "prefetch");
        if (this instanceof InterfaceCallableC4614m) {
            Object call = ((InterfaceCallableC4614m) this).call();
            if (call == null) {
                return m16522M();
            }
            return C5008s2.m18519a(call, interfaceC4584o);
        }
        return C4476a.m17119a(new C5020v(this, interfaceC4584o, i2, z ? EnumC5170j.END : EnumC5170j.BOUNDARY));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <R> AbstractC4469b0<R> m16715a(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o, int i2, int i3) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        C4601b.m18279a(i2, "maxConcurrency");
        C4601b.m18279a(i3, "prefetch");
        return C4476a.m17119a(new C5030x(this, interfaceC4584o, EnumC5170j.IMMEDIATE, i2, i3));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <R> AbstractC4469b0<R> m16736a(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o, boolean z) {
        return m16716a(interfaceC4584o, Integer.MAX_VALUE, m16521L(), z);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <R> AbstractC4469b0<R> m16716a(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o, int i2, int i3, boolean z) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        C4601b.m18279a(i2, "maxConcurrency");
        C4601b.m18279a(i3, "prefetch");
        return C4476a.m17119a(new C5030x(this, interfaceC4584o, z ? EnumC5170j.END : EnumC5170j.BOUNDARY, i2, i3));
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: a */
    public final AbstractC4469b0<T> m16688a(long j2, TimeUnit timeUnit, boolean z) {
        return m16686a(j2, timeUnit, C4488a.m17267a(), z);
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final AbstractC4469b0<T> m16686a(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, boolean z) {
        C4601b.m18284a(timeUnit, "unit is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4476a.m17119a(new C4932e0(this, j2, timeUnit, abstractC4516j0, z));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <K> AbstractC4469b0<T> m16735a(InterfaceC4584o<? super T, K> interfaceC4584o, Callable<? extends Collection<? super K>> callable) {
        C4601b.m18284a(interfaceC4584o, "keySelector is null");
        C4601b.m18284a(callable, "collectionSupplier is null");
        return C4476a.m17119a(new C4956i0(this, interfaceC4584o, callable));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4469b0<T> m16710a(InterfaceC4573d<? super T, ? super T> interfaceC4573d) {
        C4601b.m18284a(interfaceC4573d, "comparer is null");
        return C4476a.m17119a(new C4961j0(this, C4600a.m18258e(), interfaceC4573d));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4469b0<T> m16709a(InterfaceC4570a interfaceC4570a) {
        C4601b.m18284a(interfaceC4570a, "onFinally is null");
        return m16544a((InterfaceC4576g) C4600a.m18257d(), C4600a.m18257d(), C4600a.f17515c, interfaceC4570a);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    private AbstractC4469b0<T> m16544a(InterfaceC4576g<? super T> interfaceC4576g, InterfaceC4576g<? super Throwable> interfaceC4576g2, InterfaceC4570a interfaceC4570a, InterfaceC4570a interfaceC4570a2) {
        C4601b.m18284a(interfaceC4576g, "onNext is null");
        C4601b.m18284a(interfaceC4576g2, "onError is null");
        C4601b.m18284a(interfaceC4570a, "onComplete is null");
        C4601b.m18284a(interfaceC4570a2, "onAfterTerminate is null");
        return C4476a.m17119a(new C4976m0(this, interfaceC4576g, interfaceC4576g2, interfaceC4570a, interfaceC4570a2));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4469b0<T> m16712a(InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g, InterfaceC4570a interfaceC4570a) {
        C4601b.m18284a(interfaceC4576g, "onSubscribe is null");
        C4601b.m18284a(interfaceC4570a, "onDispose is null");
        return C4476a.m17119a(new C4981n0(this, interfaceC4576g, interfaceC4570a));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4533s<T> m16760a(long j2) {
        if (j2 >= 0) {
            return C4476a.m17131a(new C4991p0(this, j2));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4518k0<T> m16751a(long j2, T t) {
        if (j2 >= 0) {
            C4601b.m18284a((Object) t, "defaultItem is null");
            return C4476a.m17128a(new C4996q0(this, j2, t));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <R> AbstractC4469b0<R> m16737a(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o, boolean z, int i2) {
        return m16738a(interfaceC4584o, z, i2, m16521L());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <R> AbstractC4469b0<R> m16738a(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o, boolean z, int i2, int i3) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        C4601b.m18279a(i2, "maxConcurrency");
        C4601b.m18279a(i3, "bufferSize");
        if (this instanceof InterfaceCallableC4614m) {
            Object call = ((InterfaceCallableC4614m) this).call();
            if (call == null) {
                return m16522M();
            }
            return C5008s2.m18519a(call, interfaceC4584o);
        }
        return C4476a.m17119a(new C5016u0(this, interfaceC4584o, z, i2, i3));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <R> AbstractC4469b0<R> m16731a(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o, InterfaceC4584o<? super Throwable, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o2, Callable<? extends InterfaceC4504g0<? extends R>> callable) {
        C4601b.m18284a(interfaceC4584o, "onNextMapper is null");
        C4601b.m18284a(interfaceC4584o2, "onErrorMapper is null");
        C4601b.m18284a(callable, "onCompleteSupplier is null");
        return m16641q(new C5022v1(this, interfaceC4584o, interfaceC4584o2, callable));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <R> AbstractC4469b0<R> m16732a(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o, InterfaceC4584o<Throwable, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o2, Callable<? extends InterfaceC4504g0<? extends R>> callable, int i2) {
        C4601b.m18284a(interfaceC4584o, "onNextMapper is null");
        C4601b.m18284a(interfaceC4584o2, "onErrorMapper is null");
        C4601b.m18284a(callable, "onCompleteSupplier is null");
        return m16614d(new C5022v1(this, interfaceC4584o, interfaceC4584o2, callable), i2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <U, R> AbstractC4469b0<R> m16725a(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends U>> interfaceC4584o, InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c) {
        return m16729a((InterfaceC4584o) interfaceC4584o, (InterfaceC4572c) interfaceC4572c, false, m16521L(), m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <U, R> AbstractC4469b0<R> m16727a(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends U>> interfaceC4584o, InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c, boolean z) {
        return m16729a(interfaceC4584o, interfaceC4572c, z, m16521L(), m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <U, R> AbstractC4469b0<R> m16728a(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends U>> interfaceC4584o, InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c, boolean z, int i2) {
        return m16729a(interfaceC4584o, interfaceC4572c, z, i2, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <U, R> AbstractC4469b0<R> m16729a(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends U>> interfaceC4584o, InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c, boolean z, int i2, int i3) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        C4601b.m18284a(interfaceC4572c, "combiner is null");
        return m16738a(C4977m1.m18467a(interfaceC4584o, interfaceC4572c), z, i2, i3);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <U, R> AbstractC4469b0<R> m16726a(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends U>> interfaceC4584o, InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c, int i2) {
        return m16729a((InterfaceC4584o) interfaceC4584o, (InterfaceC4572c) interfaceC4572c, false, i2, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final InterfaceC4552c m16763a(InterfaceC4587r<? super T> interfaceC4587r, InterfaceC4576g<? super Throwable> interfaceC4576g) {
        return m16764a((InterfaceC4587r) interfaceC4587r, interfaceC4576g, C4600a.f17515c);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final InterfaceC4552c m16764a(InterfaceC4587r<? super T> interfaceC4587r, InterfaceC4576g<? super Throwable> interfaceC4576g, InterfaceC4570a interfaceC4570a) {
        C4601b.m18284a(interfaceC4587r, "onNext is null");
        C4601b.m18284a(interfaceC4576g, "onError is null");
        C4601b.m18284a(interfaceC4570a, "onComplete is null");
        C4634p c4634p = new C4634p(interfaceC4587r, interfaceC4576g, interfaceC4570a);
        subscribe(c4634p);
        return c4634p;
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <K, V> AbstractC4469b0<AbstractC5188b<K, V>> m16730a(InterfaceC4584o<? super T, ? extends K> interfaceC4584o, InterfaceC4584o<? super T, ? extends V> interfaceC4584o2) {
        return m16734a((InterfaceC4584o) interfaceC4584o, (InterfaceC4584o) interfaceC4584o2, false, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <K, V> AbstractC4469b0<AbstractC5188b<K, V>> m16733a(InterfaceC4584o<? super T, ? extends K> interfaceC4584o, InterfaceC4584o<? super T, ? extends V> interfaceC4584o2, boolean z) {
        return m16734a(interfaceC4584o, interfaceC4584o2, z, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <K, V> AbstractC4469b0<AbstractC5188b<K, V>> m16734a(InterfaceC4584o<? super T, ? extends K> interfaceC4584o, InterfaceC4584o<? super T, ? extends V> interfaceC4584o2, boolean z, int i2) {
        C4601b.m18284a(interfaceC4584o, "keySelector is null");
        C4601b.m18284a(interfaceC4584o2, "valueSelector is null");
        C4601b.m18279a(i2, "bufferSize");
        return C4476a.m17119a(new C4951h1(this, interfaceC4584o, interfaceC4584o2, i2, z));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <TRight, TLeftEnd, TRightEnd, R> AbstractC4469b0<R> m16701a(InterfaceC4504g0<? extends TRight> interfaceC4504g0, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<TLeftEnd>> interfaceC4584o, InterfaceC4584o<? super TRight, ? extends InterfaceC4504g0<TRightEnd>> interfaceC4584o2, InterfaceC4572c<? super T, ? super AbstractC4469b0<TRight>, ? extends R> interfaceC4572c) {
        C4601b.m18284a(interfaceC4504g0, "other is null");
        C4601b.m18284a(interfaceC4584o, "leftEnd is null");
        C4601b.m18284a(interfaceC4584o2, "rightEnd is null");
        C4601b.m18284a(interfaceC4572c, "resultSelector is null");
        return C4476a.m17119a(new C4957i1(this, interfaceC4504g0, interfaceC4584o, interfaceC4584o2, interfaceC4572c));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <R> AbstractC4469b0<R> m16689a(InterfaceC4492f0<? extends R, ? super T> interfaceC4492f0) {
        C4601b.m18284a(interfaceC4492f0, "onLift is null");
        return C4476a.m17119a(new C5012t1(this, interfaceC4492f0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final AbstractC4469b0<T> m16706a(AbstractC4516j0 abstractC4516j0) {
        return m16708a(abstractC4516j0, false, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final AbstractC4469b0<T> m16707a(AbstractC4516j0 abstractC4516j0, boolean z) {
        return m16708a(abstractC4516j0, z, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final AbstractC4469b0<T> m16708a(AbstractC4516j0 abstractC4516j0, boolean z, int i2) {
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        C4601b.m18279a(i2, "bufferSize");
        return C4476a.m17119a(new C5037y1(this, abstractC4516j0, z, i2));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4533s<T> m16761a(InterfaceC4572c<T, T, T> interfaceC4572c) {
        C4601b.m18284a(interfaceC4572c, "reducer is null");
        return C4476a.m17131a(new C4940f2(this, interfaceC4572c));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <R> AbstractC4518k0<R> m16755a(R r, InterfaceC4572c<R, ? super T, R> interfaceC4572c) {
        C4601b.m18284a(r, "seed is null");
        C4601b.m18284a(interfaceC4572c, "reducer is null");
        return C4476a.m17128a(new C4946g2(this, r, interfaceC4572c));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <R> AbstractC4518k0<R> m16758a(Callable<R> callable, InterfaceC4572c<R, ? super T, R> interfaceC4572c) {
        C4601b.m18284a(callable, "seedSupplier is null");
        C4601b.m18284a(interfaceC4572c, "reducer is null");
        return C4476a.m17128a(new C4952h2(this, callable, interfaceC4572c));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4469b0<T> m16711a(InterfaceC4574e interfaceC4574e) {
        C4601b.m18284a(interfaceC4574e, "stop is null");
        return C4476a.m17119a(new C4968k2(this, interfaceC4574e));
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: a */
    public final <R> AbstractC4469b0<R> m16717a(InterfaceC4584o<? super AbstractC4469b0<T>, ? extends InterfaceC4504g0<R>> interfaceC4584o, int i2, long j2, TimeUnit timeUnit) {
        return m16718a(interfaceC4584o, i2, j2, timeUnit, C4488a.m17267a());
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final <R> AbstractC4469b0<R> m16718a(InterfaceC4584o<? super AbstractC4469b0<T>, ? extends InterfaceC4504g0<R>> interfaceC4584o, int i2, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        C4601b.m18284a(interfaceC4584o, "selector is null");
        C4601b.m18279a(i2, "bufferSize");
        C4601b.m18284a(timeUnit, "unit is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4978m2.m18487a(C4977m1.m18470a(this, i2, j2, timeUnit, abstractC4516j0), (InterfaceC4584o) interfaceC4584o);
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final <R> AbstractC4469b0<R> m16719a(InterfaceC4584o<? super AbstractC4469b0<T>, ? extends InterfaceC4504g0<R>> interfaceC4584o, int i2, AbstractC4516j0 abstractC4516j0) {
        C4601b.m18284a(interfaceC4584o, "selector is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        C4601b.m18279a(i2, "bufferSize");
        return C4978m2.m18487a(C4977m1.m18469a(this, i2), C4977m1.m18466a(interfaceC4584o, abstractC4516j0));
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: a */
    public final <R> AbstractC4469b0<R> m16721a(InterfaceC4584o<? super AbstractC4469b0<T>, ? extends InterfaceC4504g0<R>> interfaceC4584o, long j2, TimeUnit timeUnit) {
        return m16722a(interfaceC4584o, j2, timeUnit, C4488a.m17267a());
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final <R> AbstractC4469b0<R> m16722a(InterfaceC4584o<? super AbstractC4469b0<T>, ? extends InterfaceC4504g0<R>> interfaceC4584o, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        C4601b.m18284a(interfaceC4584o, "selector is null");
        C4601b.m18284a(timeUnit, "unit is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4978m2.m18487a(C4977m1.m18471a(this, j2, timeUnit, abstractC4516j0), (InterfaceC4584o) interfaceC4584o);
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final <R> AbstractC4469b0<R> m16724a(InterfaceC4584o<? super AbstractC4469b0<T>, ? extends InterfaceC4504g0<R>> interfaceC4584o, AbstractC4516j0 abstractC4516j0) {
        C4601b.m18284a(interfaceC4584o, "selector is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4978m2.m18487a(C4977m1.m18468a(this), C4977m1.m18466a(interfaceC4584o, abstractC4516j0));
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: a */
    public final AbstractC5187a<T> m16765a(int i2, long j2, TimeUnit timeUnit) {
        return m16766a(i2, j2, timeUnit, C4488a.m17267a());
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final AbstractC5187a<T> m16766a(int i2, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        C4601b.m18279a(i2, "bufferSize");
        C4601b.m18284a(timeUnit, "unit is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4978m2.m18489a(this, j2, timeUnit, abstractC4516j0, i2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final AbstractC5187a<T> m16767a(int i2, AbstractC4516j0 abstractC4516j0) {
        C4601b.m18279a(i2, "bufferSize");
        return C4978m2.m18491a((AbstractC5187a) m16852d(i2), abstractC4516j0);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4469b0<T> m16673a(long j2, InterfaceC4587r<? super Throwable> interfaceC4587r) {
        if (j2 >= 0) {
            C4601b.m18284a(interfaceC4587r, "predicate is null");
            return C4476a.m17119a(new C4988o2(this, j2, interfaceC4587r));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <U> AbstractC4469b0<T> m16704a(InterfaceC4504g0<U> interfaceC4504g0, boolean z) {
        C4601b.m18284a(interfaceC4504g0, "sampler is null");
        return C4476a.m17119a(new C5003r2(this, interfaceC4504g0, z));
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final AbstractC4469b0<T> m16687a(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, boolean z, int i2) {
        C4601b.m18284a(timeUnit, "unit is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        C4601b.m18279a(i2, "bufferSize");
        return C4476a.m17119a(new C4923c3(this, j2, timeUnit, abstractC4516j0, i2 << 1, z));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4469b0<T> m16743a(Comparator<? super T> comparator) {
        C4601b.m18284a(comparator, "sortFunction is null");
        return m16660J().m17538p().m16941p(C4600a.m18244a((Comparator) comparator)).m16927l((InterfaceC4584o<? super R, ? extends Iterable<? extends U>>) C4600a.m18258e());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4469b0<T> m16740a(Iterable<? extends T> iterable) {
        return m16597b(m16626f((Iterable) iterable), this);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4469b0<T> m16750a(T... tArr) {
        AbstractC4469b0 m16600b = m16600b((Object[]) tArr);
        if (m16600b == m16522M()) {
            return C4476a.m17119a(this);
        }
        return m16597b(m16600b, this);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final InterfaceC4552c m16762a(InterfaceC4576g<? super T> interfaceC4576g, InterfaceC4576g<? super Throwable> interfaceC4576g2, InterfaceC4570a interfaceC4570a, InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g3) {
        C4601b.m18284a(interfaceC4576g, "onNext is null");
        C4601b.m18284a(interfaceC4576g2, "onError is null");
        C4601b.m18284a(interfaceC4570a, "onComplete is null");
        C4601b.m18284a(interfaceC4576g3, "onSubscribe is null");
        C4640v c4640v = new C4640v(interfaceC4576g, interfaceC4576g2, interfaceC4570a, interfaceC4576g3);
        subscribe(c4640v);
        return c4640v;
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final AbstractC4469b0<T> m16672a(long j2, long j3, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, boolean z, int i2) {
        C4601b.m18284a(timeUnit, "unit is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        C4601b.m18279a(i2, "bufferSize");
        if (j2 >= 0) {
            return C4476a.m17119a(new C4974l3(this, j2, j3, timeUnit, abstractC4516j0, i2, z));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + j2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4469b0<C4490c<T>> m16747a(TimeUnit timeUnit) {
        return m16748a(timeUnit, C4488a.m17267a());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4469b0<C4490c<T>> m16748a(TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        C4601b.m18284a(timeUnit, "unit is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4476a.m17119a(new C4999q3(this, timeUnit, abstractC4516j0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <V> AbstractC4469b0<T> m16723a(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<V>> interfaceC4584o, InterfaceC4504g0<? extends T> interfaceC4504g0) {
        C4601b.m18284a(interfaceC4504g0, "other is null");
        return m16589b((InterfaceC4504g0) null, interfaceC4584o, interfaceC4504g0);
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: a */
    public final AbstractC4469b0<T> m16678a(long j2, TimeUnit timeUnit, InterfaceC4504g0<? extends T> interfaceC4504g0) {
        C4601b.m18284a(interfaceC4504g0, "other is null");
        return m16527a(j2, timeUnit, interfaceC4504g0, C4488a.m17267a());
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final AbstractC4469b0<T> m16685a(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, InterfaceC4504g0<? extends T> interfaceC4504g0) {
        C4601b.m18284a(interfaceC4504g0, "other is null");
        return m16527a(j2, timeUnit, interfaceC4504g0, abstractC4516j0);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <U, V> AbstractC4469b0<T> m16700a(InterfaceC4504g0<U> interfaceC4504g0, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<V>> interfaceC4584o, InterfaceC4504g0<? extends T> interfaceC4504g02) {
        C4601b.m18284a(interfaceC4504g0, "firstTimeoutIndicator is null");
        C4601b.m18284a(interfaceC4504g02, "other is null");
        return m16589b(interfaceC4504g0, interfaceC4584o, interfaceC4504g02);
    }

    /* renamed from: a */
    private AbstractC4469b0<T> m16527a(long j2, TimeUnit timeUnit, InterfaceC4504g0<? extends T> interfaceC4504g0, AbstractC4516j0 abstractC4516j0) {
        C4601b.m18284a(timeUnit, "timeUnit is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4476a.m17119a(new C5009s3(this, j2, timeUnit, abstractC4516j0, interfaceC4504g0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <K, V> AbstractC4518k0<Map<K, Collection<V>>> m16752a(InterfaceC4584o<? super T, ? extends K> interfaceC4584o, InterfaceC4584o<? super T, ? extends V> interfaceC4584o2, Callable<? extends Map<K, Collection<V>>> callable, InterfaceC4584o<? super K, ? extends Collection<? super V>> interfaceC4584o3) {
        C4601b.m18284a(interfaceC4584o, "keySelector is null");
        C4601b.m18284a(interfaceC4584o2, "valueSelector is null");
        C4601b.m18284a(callable, "mapSupplier is null");
        C4601b.m18284a(interfaceC4584o3, "collectionFactory is null");
        return (AbstractC4518k0<Map<K, Collection<V>>>) m16757a((Callable) callable, (InterfaceC4571b) C4600a.m18233a(interfaceC4584o, interfaceC4584o2, interfaceC4584o3));
    }

    @InterfaceC4542b(EnumC4541a.SPECIAL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4519l<T> m16759a(EnumC4468b enumC4468b) {
        C4730h1 c4730h1 = new C4730h1(this);
        int i2 = a.f17231a[enumC4468b.ordinal()];
        if (i2 == 1) {
            return c4730h1.m17991v();
        }
        if (i2 == 2) {
            return c4730h1.m17993w();
        }
        if (i2 == 3) {
            return c4730h1;
        }
        if (i2 != 4) {
            return c4730h1.m17989u();
        }
        return C4476a.m17129a(new C4731h2(c4730h1));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4518k0<List<T>> m16756a(Comparator<? super T> comparator, int i2) {
        C4601b.m18284a(comparator, "comparator is null");
        return (AbstractC4518k0<List<T>>) m16892g(i2).m17524h(C4600a.m18244a((Comparator) comparator));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4469b0<AbstractC4469b0<T>> m16666a(long j2, long j3) {
        return m16667a(j2, j3, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4469b0<AbstractC4469b0<T>> m16667a(long j2, long j3, int i2) {
        C4601b.m18282a(j2, "count");
        C4601b.m18282a(j3, "skip");
        C4601b.m18279a(i2, "bufferSize");
        return C4476a.m17119a(new C5039y3(this, j2, j3, i2));
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final AbstractC4469b0<AbstractC4469b0<T>> m16670a(long j2, long j3, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, int i2) {
        C4601b.m18282a(j2, "timespan");
        C4601b.m18282a(j3, "timeskip");
        C4601b.m18279a(i2, "bufferSize");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        C4601b.m18284a(timeUnit, "unit is null");
        return C4476a.m17119a(new C4924c4(this, j2, j3, timeUnit, abstractC4516j0, C5556m0.f20396b, i2, false));
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: a */
    public final AbstractC4469b0<AbstractC4469b0<T>> m16676a(long j2, TimeUnit timeUnit, long j3) {
        return m16683a(j2, timeUnit, C4488a.m17267a(), j3, false);
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: a */
    public final AbstractC4469b0<AbstractC4469b0<T>> m16677a(long j2, TimeUnit timeUnit, long j3, boolean z) {
        return m16683a(j2, timeUnit, C4488a.m17267a(), j3, z);
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final AbstractC4469b0<AbstractC4469b0<T>> m16682a(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, long j3) {
        return m16683a(j2, timeUnit, abstractC4516j0, j3, false);
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final AbstractC4469b0<AbstractC4469b0<T>> m16683a(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, long j3, boolean z) {
        return m16684a(j2, timeUnit, abstractC4516j0, j3, z, m16521L());
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final AbstractC4469b0<AbstractC4469b0<T>> m16684a(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, long j3, boolean z, int i2) {
        C4601b.m18279a(i2, "bufferSize");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        C4601b.m18284a(timeUnit, "unit is null");
        C4601b.m18282a(j3, "count");
        return C4476a.m17119a(new C4924c4(this, j2, j2, timeUnit, abstractC4516j0, j3, i2, z));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <U, V> AbstractC4469b0<AbstractC4469b0<T>> m16699a(InterfaceC4504g0<U> interfaceC4504g0, InterfaceC4584o<? super U, ? extends InterfaceC4504g0<V>> interfaceC4584o, int i2) {
        C4601b.m18284a(interfaceC4504g0, "openingIndicator is null");
        C4601b.m18284a(interfaceC4584o, "closingIndicator is null");
        C4601b.m18279a(i2, "bufferSize");
        return C4476a.m17119a(new C4912a4(this, interfaceC4504g0, interfaceC4584o, i2));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <B> AbstractC4469b0<AbstractC4469b0<T>> m16745a(Callable<? extends InterfaceC4504g0<B>> callable, int i2) {
        C4601b.m18284a(callable, "boundary is null");
        C4601b.m18279a(i2, "bufferSize");
        return C4476a.m17119a(new C4918b4(this, callable, i2));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <U, R> AbstractC4469b0<R> m16695a(InterfaceC4504g0<? extends U> interfaceC4504g0, InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c) {
        C4601b.m18284a(interfaceC4504g0, "other is null");
        C4601b.m18284a(interfaceC4572c, "combiner is null");
        return C4476a.m17119a(new C4930d4(this, interfaceC4572c, interfaceC4504g0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <T1, T2, R> AbstractC4469b0<R> m16694a(InterfaceC4504g0<T1> interfaceC4504g0, InterfaceC4504g0<T2> interfaceC4504g02, InterfaceC4577h<? super T, ? super T1, ? super T2, R> interfaceC4577h) {
        C4601b.m18284a(interfaceC4504g0, "o1 is null");
        C4601b.m18284a(interfaceC4504g02, "o2 is null");
        C4601b.m18284a(interfaceC4577h, "combiner is null");
        return m16749a((InterfaceC4504g0<?>[]) new InterfaceC4504g0[]{interfaceC4504g0, interfaceC4504g02}, C4600a.m18236a((InterfaceC4577h) interfaceC4577h));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <T1, T2, T3, R> AbstractC4469b0<R> m16693a(InterfaceC4504g0<T1> interfaceC4504g0, InterfaceC4504g0<T2> interfaceC4504g02, InterfaceC4504g0<T3> interfaceC4504g03, InterfaceC4578i<? super T, ? super T1, ? super T2, ? super T3, R> interfaceC4578i) {
        C4601b.m18284a(interfaceC4504g0, "o1 is null");
        C4601b.m18284a(interfaceC4504g02, "o2 is null");
        C4601b.m18284a(interfaceC4504g03, "o3 is null");
        C4601b.m18284a(interfaceC4578i, "combiner is null");
        return m16749a((InterfaceC4504g0<?>[]) new InterfaceC4504g0[]{interfaceC4504g0, interfaceC4504g02, interfaceC4504g03}, C4600a.m18237a((InterfaceC4578i) interfaceC4578i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <T1, T2, T3, T4, R> AbstractC4469b0<R> m16692a(InterfaceC4504g0<T1> interfaceC4504g0, InterfaceC4504g0<T2> interfaceC4504g02, InterfaceC4504g0<T3> interfaceC4504g03, InterfaceC4504g0<T4> interfaceC4504g04, InterfaceC4579j<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> interfaceC4579j) {
        C4601b.m18284a(interfaceC4504g0, "o1 is null");
        C4601b.m18284a(interfaceC4504g02, "o2 is null");
        C4601b.m18284a(interfaceC4504g03, "o3 is null");
        C4601b.m18284a(interfaceC4504g04, "o4 is null");
        C4601b.m18284a(interfaceC4579j, "combiner is null");
        return m16749a((InterfaceC4504g0<?>[]) new InterfaceC4504g0[]{interfaceC4504g0, interfaceC4504g02, interfaceC4504g03, interfaceC4504g04}, C4600a.m18238a((InterfaceC4579j) interfaceC4579j));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <R> AbstractC4469b0<R> m16749a(InterfaceC4504g0<?>[] interfaceC4504g0Arr, InterfaceC4584o<? super Object[], R> interfaceC4584o) {
        C4601b.m18284a(interfaceC4504g0Arr, "others is null");
        C4601b.m18284a(interfaceC4584o, "combiner is null");
        return C4476a.m17119a(new C4936e4(this, interfaceC4504g0Arr, interfaceC4584o));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <R> AbstractC4469b0<R> m16742a(Iterable<? extends InterfaceC4504g0<?>> iterable, InterfaceC4584o<? super Object[], R> interfaceC4584o) {
        C4601b.m18284a(iterable, "others is null");
        C4601b.m18284a(interfaceC4584o, "combiner is null");
        return C4476a.m17119a(new C4936e4(this, iterable, interfaceC4584o));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <U, R> AbstractC4469b0<R> m16741a(Iterable<U> iterable, InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c) {
        C4601b.m18284a(iterable, "other is null");
        C4601b.m18284a(interfaceC4572c, "zipper is null");
        return C4476a.m17119a(new C4948g4(this, iterable, interfaceC4572c));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <U, R> AbstractC4469b0<R> m16696a(InterfaceC4504g0<? extends U> interfaceC4504g0, InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c, boolean z) {
        return m16542a(this, interfaceC4504g0, interfaceC4572c, z);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <U, R> AbstractC4469b0<R> m16697a(InterfaceC4504g0<? extends U> interfaceC4504g0, InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c, boolean z, int i2) {
        return m16543a(this, interfaceC4504g0, interfaceC4572c, z, i2);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final C4467n<T> m16662a(boolean z) {
        C4467n<T> c4467n = new C4467n<>();
        if (z) {
            c4467n.dispose();
        }
        subscribe(c4467n);
        return c4467n;
    }
}
