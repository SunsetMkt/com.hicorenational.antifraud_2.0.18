package p251g.p252a;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p251g.p252a.p253a1.C4467n;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p257e1.C4488a;
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
import p251g.p252a.p268y0.p271c.InterfaceC4603b;
import p251g.p252a.p268y0.p271c.InterfaceC4604c;
import p251g.p252a.p268y0.p271c.InterfaceC4605d;
import p251g.p252a.p268y0.p272d.C4622d;
import p251g.p252a.p268y0.p272d.C4626h;
import p251g.p252a.p268y0.p272d.C4629k;
import p251g.p252a.p268y0.p272d.FutureC4637s;
import p251g.p252a.p268y0.p273e.p274a.C4668l0;
import p251g.p252a.p268y0.p273e.p274a.C4680u;
import p251g.p252a.p268y0.p273e.p275b.C4688a1;
import p251g.p252a.p268y0.p273e.p275b.C4756l3;
import p251g.p252a.p268y0.p273e.p275b.C4816w;
import p251g.p252a.p268y0.p273e.p275b.C4831z;
import p251g.p252a.p268y0.p273e.p276c.C4873m0;
import p251g.p252a.p268y0.p273e.p276c.C4903y;
import p251g.p252a.p268y0.p273e.p277d.C5020v;
import p251g.p252a.p268y0.p273e.p277d.C5043z2;
import p251g.p252a.p268y0.p273e.p279f.C5061a;
import p251g.p252a.p268y0.p273e.p279f.C5062a0;
import p251g.p252a.p268y0.p273e.p279f.C5063b;
import p251g.p252a.p268y0.p273e.p279f.C5064b0;
import p251g.p252a.p268y0.p273e.p279f.C5065c;
import p251g.p252a.p268y0.p273e.p279f.C5066c0;
import p251g.p252a.p268y0.p273e.p279f.C5067d;
import p251g.p252a.p268y0.p273e.p279f.C5068d0;
import p251g.p252a.p268y0.p273e.p279f.C5069e;
import p251g.p252a.p268y0.p273e.p279f.C5070e0;
import p251g.p252a.p268y0.p273e.p279f.C5071f;
import p251g.p252a.p268y0.p273e.p279f.C5072f0;
import p251g.p252a.p268y0.p273e.p279f.C5073g;
import p251g.p252a.p268y0.p273e.p279f.C5074g0;
import p251g.p252a.p268y0.p273e.p279f.C5075h;
import p251g.p252a.p268y0.p273e.p279f.C5076h0;
import p251g.p252a.p268y0.p273e.p279f.C5077i;
import p251g.p252a.p268y0.p273e.p279f.C5078i0;
import p251g.p252a.p268y0.p273e.p279f.C5079j;
import p251g.p252a.p268y0.p273e.p279f.C5080j0;
import p251g.p252a.p268y0.p273e.p279f.C5081k;
import p251g.p252a.p268y0.p273e.p279f.C5082k0;
import p251g.p252a.p268y0.p273e.p279f.C5083l;
import p251g.p252a.p268y0.p273e.p279f.C5084l0;
import p251g.p252a.p268y0.p273e.p279f.C5085m;
import p251g.p252a.p268y0.p273e.p279f.C5086m0;
import p251g.p252a.p268y0.p273e.p279f.C5087n;
import p251g.p252a.p268y0.p273e.p279f.C5088n0;
import p251g.p252a.p268y0.p273e.p279f.C5089o;
import p251g.p252a.p268y0.p273e.p279f.C5090o0;
import p251g.p252a.p268y0.p273e.p279f.C5091p;
import p251g.p252a.p268y0.p273e.p279f.C5092p0;
import p251g.p252a.p268y0.p273e.p279f.C5093q;
import p251g.p252a.p268y0.p273e.p279f.C5094q0;
import p251g.p252a.p268y0.p273e.p279f.C5095r;
import p251g.p252a.p268y0.p273e.p279f.C5096r0;
import p251g.p252a.p268y0.p273e.p279f.C5097s;
import p251g.p252a.p268y0.p273e.p279f.C5098s0;
import p251g.p252a.p268y0.p273e.p279f.C5099t;
import p251g.p252a.p268y0.p273e.p279f.C5100t0;
import p251g.p252a.p268y0.p273e.p279f.C5101u;
import p251g.p252a.p268y0.p273e.p279f.C5102u0;
import p251g.p252a.p268y0.p273e.p279f.C5103v;
import p251g.p252a.p268y0.p273e.p279f.C5104v0;
import p251g.p252a.p268y0.p273e.p279f.C5105w;
import p251g.p252a.p268y0.p273e.p279f.C5106x;
import p251g.p252a.p268y0.p273e.p279f.C5107y;
import p251g.p252a.p268y0.p273e.p279f.C5108z;
import p251g.p252a.p268y0.p284j.C5171k;
import p251g.p252a.p268y0.p284j.EnumC5170j;
import p324i.p338d.InterfaceC5821b;

/* compiled from: Single.java */
/* renamed from: g.a.k0 */
/* loaded from: classes2.dex */
public abstract class AbstractC4518k0<T> implements InterfaceC4530q0<T> {
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4518k0<T> m17424a(Iterable<? extends InterfaceC4530q0<? extends T>> iterable) {
        C4601b.m18284a(iterable, "sources is null");
        return C4476a.m17128a(new C5061a(null, iterable));
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T> AbstractC4519l<T> m17445b(Iterable<? extends InterfaceC4530q0<? extends T>> iterable) {
        return m17451c((InterfaceC5821b) AbstractC4519l.m17644f((Iterable) iterable));
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public static <T> AbstractC4519l<T> m17451c(InterfaceC5821b<? extends InterfaceC4530q0<? extends T>> interfaceC5821b) {
        return m17438a(interfaceC5821b, 2);
    }

    @InterfaceC4542b(EnumC4541a.UNBOUNDED_IN)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public static <T> AbstractC4518k0<T> m17455d(InterfaceC5821b<? extends T> interfaceC5821b) {
        C4601b.m18284a(interfaceC5821b, "publisher is null");
        return C4476a.m17128a(new C5064b0(interfaceC5821b));
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public static <T> AbstractC4519l<T> m17456e(InterfaceC5821b<? extends InterfaceC4530q0<? extends T>> interfaceC5821b) {
        C4601b.m18284a(interfaceC5821b, "sources is null");
        return C4476a.m17129a(new C4688a1(interfaceC5821b, C5070e0.m18529b(), false, Integer.MAX_VALUE, AbstractC4519l.m17539Q()));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: f */
    public static <T> AbstractC4518k0<T> m17457f(InterfaceC4530q0<? extends InterfaceC4530q0<? extends T>> interfaceC4530q0) {
        C4601b.m18284a(interfaceC4530q0, "source is null");
        return C4476a.m17128a(new C5103v(interfaceC4530q0, C4600a.m18258e()));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: g */
    public static <T> AbstractC4518k0<T> m17458g(InterfaceC4530q0<T> interfaceC4530q0) {
        C4601b.m18284a(interfaceC4530q0, "onSubscribe is null");
        if (interfaceC4530q0 instanceof AbstractC4518k0) {
            throw new IllegalArgumentException("unsafeCreate(Single) should be upgraded");
        }
        return C4476a.m17128a(new C5066c0(interfaceC4530q0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: h */
    public static <T> AbstractC4518k0<T> m17459h(InterfaceC4530q0<T> interfaceC4530q0) {
        C4601b.m18284a(interfaceC4530q0, "source is null");
        return interfaceC4530q0 instanceof AbstractC4518k0 ? C4476a.m17128a((AbstractC4518k0) interfaceC4530q0) : C4476a.m17128a(new C5066c0(interfaceC4530q0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: q */
    public static <T> AbstractC4518k0<T> m17460q() {
        return C4476a.m17128a(C5078i0.f19721a);
    }

    /* renamed from: b */
    protected abstract void mo17357b(@InterfaceC4546f InterfaceC4524n0<? super T> interfaceC4524n0);

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: i */
    public final AbstractC4518k0<T> m17527i(InterfaceC4584o<? super Throwable, ? extends InterfaceC4530q0<? extends T>> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "resumeFunctionInCaseOfError is null");
        return C4476a.m17128a(new C5084l0(this, interfaceC4584o));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: j */
    public final AbstractC4518k0<T> m17528j(InterfaceC4584o<Throwable, ? extends T> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "resumeFunction is null");
        return C4476a.m17128a(new C5082k0(this, interfaceC4584o, null));
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: k */
    public final AbstractC4519l<T> m17531k(InterfaceC4584o<? super AbstractC4519l<Object>, ? extends InterfaceC5821b<?>> interfaceC4584o) {
        return m17534m().m17986s(interfaceC4584o);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: l */
    public final AbstractC4518k0<T> m17533l(InterfaceC4584o<? super AbstractC4519l<Throwable>, ? extends InterfaceC5821b<?>> interfaceC4584o) {
        return m17413a((AbstractC4519l) m17534m().m17990u(interfaceC4584o));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: m */
    public final <R> R m17535m(InterfaceC4584o<? super AbstractC4518k0<T>, R> interfaceC4584o) {
        try {
            return (R) ((InterfaceC4584o) C4601b.m18284a(interfaceC4584o, "convert is null")).apply(this);
        } catch (Throwable th) {
            C4561b.m18199b(th);
            throw C5171k.m18626c(th);
        }
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: n */
    public final Future<T> m17536n() {
        return (Future) m17510c((AbstractC4518k0<T>) new FutureC4637s());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: o */
    public final AbstractC4533s<T> m17537o() {
        return this instanceof InterfaceC4604c ? ((InterfaceC4604c) this).mo18287c() : C4476a.m17131a(new C4873m0(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: p */
    public final AbstractC4469b0<T> m17538p() {
        return this instanceof InterfaceC4605d ? ((InterfaceC4605d) this).mo18288a() : C4476a.m17119a(new C5096r0(this));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T> AbstractC4469b0<T> m17439b(InterfaceC4504g0<? extends InterfaceC4530q0<? extends T>> interfaceC4504g0) {
        C4601b.m18284a(interfaceC4504g0, "sources is null");
        return C4476a.m17119a(new C5020v(interfaceC4504g0, C5070e0.m18530c(), 2, EnumC5170j.IMMEDIATE));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public static <T> AbstractC4518k0<T> m17449c(Callable<? extends T> callable) {
        C4601b.m18284a(callable, "callable is null");
        return C4476a.m17128a(new C5062a0(callable));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: k */
    public final C4467n<T> m17530k() {
        C4467n<T> c4467n = new C4467n<>();
        mo17490a((InterfaceC4524n0) c4467n);
        return c4467n;
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: l */
    public final AbstractC4474c m17532l() {
        return C4476a.m17121a(new C4680u(this));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4518k0<T> m17434a(InterfaceC4530q0<? extends T>... interfaceC4530q0Arr) {
        if (interfaceC4530q0Arr.length == 0) {
            return m17442b((Callable<? extends Throwable>) C5070e0.m18528a());
        }
        if (interfaceC4530q0Arr.length == 1) {
            return m17459h(interfaceC4530q0Arr[0]);
        }
        return C4476a.m17128a(new C5061a(interfaceC4530q0Arr, null));
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: d */
    public static AbstractC4518k0<Long> m17453d(long j2, TimeUnit timeUnit) {
        return m17454d(j2, timeUnit, C4488a.m17267a());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public final AbstractC4518k0<T> m17516e() {
        return C4476a.m17128a(new C5063b(this));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: f */
    public final AbstractC4518k0<T> m17520f() {
        return C4476a.m17128a(new C5068d0(this));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: i */
    public final AbstractC4518k0<T> m17526i() {
        return m17413a((AbstractC4519l) m17534m().m17668C());
    }

    @InterfaceC4548h("none")
    /* renamed from: j */
    public final InterfaceC4552c m17529j() {
        return m17488a(C4600a.m18257d(), C4600a.f17518f);
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T> AbstractC4519l<T> m17446b(InterfaceC4530q0<? extends T>... interfaceC4530q0Arr) {
        return C4476a.m17129a(new C4816w(AbstractC4519l.m17617b((Object[]) interfaceC4530q0Arr), C5070e0.m18529b(), 2, EnumC5170j.BOUNDARY));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public static <T> AbstractC4518k0<T> m17447c(InterfaceC4504g0<? extends T> interfaceC4504g0) {
        C4601b.m18284a(interfaceC4504g0, "observableSource is null");
        return C4476a.m17128a(new C5043z2(interfaceC4504g0, null));
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: d */
    public static AbstractC4518k0<Long> m17454d(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        C4601b.m18284a(timeUnit, "unit is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4476a.m17128a(new C5092p0(j2, timeUnit, abstractC4516j0));
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public final <R> AbstractC4519l<R> m17518e(InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o) {
        return m17534m().m17942i((InterfaceC4584o) interfaceC4584o);
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: f */
    public final <U> AbstractC4519l<U> m17521f(InterfaceC4584o<? super T, ? extends Iterable<? extends U>> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        return C4476a.m17129a(new C5106x(this, interfaceC4584o));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: m */
    public final AbstractC4519l<T> m17534m() {
        if (this instanceof InterfaceC4603b) {
            return ((InterfaceC4603b) this).mo18286b();
        }
        return C4476a.m17129a(new C5094q0(this));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T> AbstractC4518k0<T> m17442b(Callable<? extends Throwable> callable) {
        C4601b.m18284a(callable, "errorSupplier is null");
        return C4476a.m17128a(new C5101u(callable));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public final InterfaceC4552c m17519e(InterfaceC4576g<? super T> interfaceC4576g) {
        return m17488a(interfaceC4576g, C4600a.f17518f);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: g */
    public final <U> AbstractC4469b0<U> m17522g(InterfaceC4584o<? super T, ? extends Iterable<? extends U>> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        return C4476a.m17119a(new C5107y(this, interfaceC4584o));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: h */
    public final <R> AbstractC4518k0<R> m17524h(InterfaceC4584o<? super T, ? extends R> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        return C4476a.m17128a(new C5076h0(this, interfaceC4584o));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public static <T> AbstractC4518k0<T> m17448c(T t) {
        C4601b.m18284a((Object) t, "value is null");
        return C4476a.m17128a(new C5072f0(t));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: e */
    public final <E> AbstractC4518k0<T> m17517e(InterfaceC4530q0<? extends E> interfaceC4530q0) {
        C4601b.m18284a(interfaceC4530q0, "other is null");
        return m17500b((InterfaceC5821b) new C5094q0(interfaceC4530q0));
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T> AbstractC4519l<T> m17443b(InterfaceC4530q0<? extends T> interfaceC4530q0, InterfaceC4530q0<? extends T> interfaceC4530q02, InterfaceC4530q0<? extends T> interfaceC4530q03) {
        C4601b.m18284a(interfaceC4530q0, "source1 is null");
        C4601b.m18284a(interfaceC4530q02, "source2 is null");
        C4601b.m18284a(interfaceC4530q03, "source3 is null");
        return m17456e(AbstractC4519l.m17617b((Object[]) new InterfaceC4530q0[]{interfaceC4530q0, interfaceC4530q02, interfaceC4530q03}));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public final AbstractC4518k0<T> m17513d(InterfaceC4576g<? super T> interfaceC4576g) {
        C4601b.m18284a(interfaceC4576g, "onSuccess is null");
        return C4476a.m17128a(new C5097s(this, interfaceC4576g));
    }

    @InterfaceC4545e
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: g */
    public final AbstractC4518k0<T> m17523g() {
        return C4476a.m17128a(new C5081k(this));
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: h */
    public final AbstractC4519l<T> m17525h() {
        return m17534m().m17666A();
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4519l<T> m17438a(InterfaceC5821b<? extends InterfaceC4530q0<? extends T>> interfaceC5821b, int i2) {
        C4601b.m18284a(interfaceC5821b, "sources is null");
        C4601b.m18279a(i2, "prefetch");
        return C4476a.m17129a(new C4831z(interfaceC5821b, C5070e0.m18529b(), i2, EnumC5170j.IMMEDIATE));
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public static <T> AbstractC4519l<T> m17452c(Iterable<? extends InterfaceC4530q0<? extends T>> iterable) {
        return m17456e(AbstractC4519l.m17644f((Iterable) iterable));
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public static <T> AbstractC4519l<T> m17450c(InterfaceC4530q0<? extends T> interfaceC4530q0, InterfaceC4530q0<? extends T> interfaceC4530q02) {
        C4601b.m18284a(interfaceC4530q0, "source1 is null");
        C4601b.m18284a(interfaceC4530q02, "source2 is null");
        return m17456e(AbstractC4519l.m17617b((Object[]) new InterfaceC4530q0[]{interfaceC4530q0, interfaceC4530q02}));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public final <R> AbstractC4469b0<R> m17512d(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o) {
        return m17538p().m16915j((InterfaceC4584o) interfaceC4584o);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public final T m17515d() {
        C4626h c4626h = new C4626h();
        mo17490a((InterfaceC4524n0) c4626h);
        return (T) c4626h.m18294a();
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4519l<T> m17435a(InterfaceC4530q0<? extends T> interfaceC4530q0, InterfaceC4530q0<? extends T> interfaceC4530q02) {
        C4601b.m18284a(interfaceC4530q0, "source1 is null");
        C4601b.m18284a(interfaceC4530q02, "source2 is null");
        return m17451c((InterfaceC5821b) AbstractC4519l.m17617b((Object[]) new InterfaceC4530q0[]{interfaceC4530q0, interfaceC4530q02}));
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T> AbstractC4519l<T> m17444b(InterfaceC4530q0<? extends T> interfaceC4530q0, InterfaceC4530q0<? extends T> interfaceC4530q02, InterfaceC4530q0<? extends T> interfaceC4530q03, InterfaceC4530q0<? extends T> interfaceC4530q04) {
        C4601b.m18284a(interfaceC4530q0, "source1 is null");
        C4601b.m18284a(interfaceC4530q02, "source2 is null");
        C4601b.m18284a(interfaceC4530q03, "source3 is null");
        C4601b.m18284a(interfaceC4530q04, "source4 is null");
        return m17456e(AbstractC4519l.m17617b((Object[]) new InterfaceC4530q0[]{interfaceC4530q0, interfaceC4530q02, interfaceC4530q03, interfaceC4530q04}));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public final <U> AbstractC4518k0<T> m17507c(InterfaceC4530q0<U> interfaceC4530q0) {
        C4601b.m18284a(interfaceC4530q0, "other is null");
        return C4476a.m17128a(new C5079j(this, interfaceC4530q0));
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: d */
    public final AbstractC4519l<T> m17514d(InterfaceC4530q0<? extends T> interfaceC4530q0) {
        return m17450c(this, interfaceC4530q0);
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4519l<T> m17436a(InterfaceC4530q0<? extends T> interfaceC4530q0, InterfaceC4530q0<? extends T> interfaceC4530q02, InterfaceC4530q0<? extends T> interfaceC4530q03) {
        C4601b.m18284a(interfaceC4530q0, "source1 is null");
        C4601b.m18284a(interfaceC4530q02, "source2 is null");
        C4601b.m18284a(interfaceC4530q03, "source3 is null");
        return m17451c((InterfaceC5821b) AbstractC4519l.m17617b((Object[]) new InterfaceC4530q0[]{interfaceC4530q0, interfaceC4530q02, interfaceC4530q03}));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public final AbstractC4518k0<T> m17509c(InterfaceC4576g<? super InterfaceC4552c> interfaceC4576g) {
        C4601b.m18284a(interfaceC4576g, "onSubscribe is null");
        return C4476a.m17128a(new C5095r(this, interfaceC4576g));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public static <T> AbstractC4518k0<Boolean> m17441b(InterfaceC4530q0<? extends T> interfaceC4530q0, InterfaceC4530q0<? extends T> interfaceC4530q02) {
        C4601b.m18284a(interfaceC4530q0, "first is null");
        C4601b.m18284a(interfaceC4530q02, "second is null");
        return C4476a.m17128a(new C5099t(interfaceC4530q0, interfaceC4530q02));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public final AbstractC4518k0<T> m17508c(InterfaceC4570a interfaceC4570a) {
        C4601b.m18284a(interfaceC4570a, "onDispose is null");
        return C4476a.m17128a(new C5089o(this, interfaceC4570a));
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4519l<T> m17437a(InterfaceC4530q0<? extends T> interfaceC4530q0, InterfaceC4530q0<? extends T> interfaceC4530q02, InterfaceC4530q0<? extends T> interfaceC4530q03, InterfaceC4530q0<? extends T> interfaceC4530q04) {
        C4601b.m18284a(interfaceC4530q0, "source1 is null");
        C4601b.m18284a(interfaceC4530q02, "source2 is null");
        C4601b.m18284a(interfaceC4530q03, "source3 is null");
        C4601b.m18284a(interfaceC4530q04, "source4 is null");
        return m17451c((InterfaceC5821b) AbstractC4519l.m17617b((Object[]) new InterfaceC4530q0[]{interfaceC4530q0, interfaceC4530q02, interfaceC4530q03, interfaceC4530q04}));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public final <R> AbstractC4533s<R> m17511c(InterfaceC4584o<? super T, ? extends InterfaceC4588y<? extends R>> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        return C4476a.m17131a(new C5108z(this, interfaceC4584o));
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final AbstractC4519l<T> m17502b(InterfaceC4530q0<? extends T> interfaceC4530q0) {
        return m17435a(this, interfaceC4530q0);
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: b */
    public final AbstractC4518k0<T> m17493b(long j2, TimeUnit timeUnit) {
        return m17494b(j2, timeUnit, C4488a.m17267a());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: c */
    public final <E extends InterfaceC4524n0<? super T>> E m17510c(E e2) {
        mo17490a((InterfaceC4524n0) e2);
        return e2;
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: b */
    public final AbstractC4518k0<T> m17494b(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return m17468a((InterfaceC4504g0) AbstractC4469b0.m16640q(j2, timeUnit, abstractC4516j0));
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: c */
    public final AbstractC4518k0<T> m17504c(long j2, TimeUnit timeUnit) {
        return m17440b(j2, timeUnit, C4488a.m17267a(), (InterfaceC4530q0) null);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final AbstractC4518k0<T> m17497b(InterfaceC4570a interfaceC4570a) {
        C4601b.m18284a(interfaceC4570a, "onFinally is null");
        return C4476a.m17128a(new C5087n(this, interfaceC4570a));
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: c */
    public final AbstractC4518k0<T> m17505c(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return m17440b(j2, timeUnit, abstractC4516j0, (InterfaceC4530q0) null);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4518k0<T> m17414a(InterfaceC4526o0<T> interfaceC4526o0) {
        C4601b.m18284a(interfaceC4526o0, "source is null");
        return C4476a.m17128a(new C5067d(interfaceC4526o0));
    }

    @InterfaceC4545e
    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: c */
    public final AbstractC4518k0<T> m17506c(AbstractC4516j0 abstractC4516j0) {
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4476a.m17128a(new C5098s0(this, abstractC4516j0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final AbstractC4518k0<T> m17498b(InterfaceC4576g<? super Throwable> interfaceC4576g) {
        C4601b.m18284a(interfaceC4576g, "onError is null");
        return C4476a.m17128a(new C5091p(this, interfaceC4576g));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4518k0<T> m17427a(Callable<? extends InterfaceC4530q0<? extends T>> callable) {
        C4601b.m18284a(callable, "singleSupplier is null");
        return C4476a.m17128a(new C5069e(callable));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final AbstractC4474c m17491b(InterfaceC4584o<? super T, ? extends InterfaceC4513i> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        return C4476a.m17121a(new C5105w(this, interfaceC4584o));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4518k0<T> m17426a(Throwable th) {
        C4601b.m18284a(th, "error is null");
        return m17442b((Callable<? extends Throwable>) C4600a.m18253b(th));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final AbstractC4518k0<T> m17501b(T t) {
        C4601b.m18284a((Object) t, "value is null");
        return C4476a.m17128a(new C5082k0(this, null, t));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4518k0<T> m17430a(Future<? extends T> future) {
        return m17413a(AbstractC4519l.m17587a((Future) future));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T> AbstractC4518k0<T> m17431a(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        return m17413a(AbstractC4519l.m17588a(future, j2, timeUnit));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final AbstractC4518k0<T> m17492b(long j2) {
        return m17413a((AbstractC4519l) m17534m().m17890e(j2));
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public static <T> AbstractC4518k0<T> m17432a(Future<? extends T> future, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return m17413a(AbstractC4519l.m17589a(future, j2, timeUnit, abstractC4516j0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final AbstractC4518k0<T> m17499b(InterfaceC4587r<? super Throwable> interfaceC4587r) {
        return m17413a((AbstractC4519l) m17534m().m17896e(interfaceC4587r));
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public static <T> AbstractC4518k0<T> m17433a(Future<? extends T> future, AbstractC4516j0 abstractC4516j0) {
        return m17413a(AbstractC4519l.m17590a((Future) future, abstractC4516j0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final InterfaceC4552c m17503b(InterfaceC4571b<? super T, ? super Throwable> interfaceC4571b) {
        C4601b.m18284a(interfaceC4571b, "onCallback is null");
        C4622d c4622d = new C4622d(interfaceC4571b);
        mo17490a((InterfaceC4524n0) c4622d);
        return c4622d;
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T, U> AbstractC4518k0<T> m17428a(Callable<U> callable, InterfaceC4584o<? super U, ? extends InterfaceC4530q0<? extends T>> interfaceC4584o, InterfaceC4576g<? super U> interfaceC4576g) {
        return m17429a((Callable) callable, (InterfaceC4584o) interfaceC4584o, (InterfaceC4576g) interfaceC4576g, true);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T, U> AbstractC4518k0<T> m17429a(Callable<U> callable, InterfaceC4584o<? super U, ? extends InterfaceC4530q0<? extends T>> interfaceC4584o, InterfaceC4576g<? super U> interfaceC4576g, boolean z) {
        C4601b.m18284a(callable, "resourceSupplier is null");
        C4601b.m18284a(interfaceC4584o, "singleFunction is null");
        C4601b.m18284a(interfaceC4576g, "disposer is null");
        return C4476a.m17128a(new C5100t0(callable, interfaceC4584o, interfaceC4576g, z));
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: b */
    public final AbstractC4518k0<T> m17496b(AbstractC4516j0 abstractC4516j0) {
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4476a.m17128a(new C5086m0(this, abstractC4516j0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final AbstractC4518k0<T> m17495b(InterfaceC4513i interfaceC4513i) {
        C4601b.m18284a(interfaceC4513i, "other is null");
        return m17500b((InterfaceC5821b) new C4668l0(interfaceC4513i));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T, R> AbstractC4518k0<R> m17425a(Iterable<? extends InterfaceC4530q0<? extends T>> iterable, InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "zipper is null");
        C4601b.m18284a(iterable, "sources is null");
        return C4476a.m17128a(new C5104v0(iterable, interfaceC4584o));
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final <E> AbstractC4518k0<T> m17500b(InterfaceC5821b<E> interfaceC5821b) {
        C4601b.m18284a(interfaceC5821b, "other is null");
        return C4476a.m17128a(new C5088n0(this, interfaceC5821b));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T1, T2, R> AbstractC4518k0<R> m17422a(InterfaceC4530q0<? extends T1> interfaceC4530q0, InterfaceC4530q0<? extends T2> interfaceC4530q02, InterfaceC4572c<? super T1, ? super T2, ? extends R> interfaceC4572c) {
        C4601b.m18284a(interfaceC4530q0, "source1 is null");
        C4601b.m18284a(interfaceC4530q02, "source2 is null");
        return m17423a(C4600a.m18235a((InterfaceC4572c) interfaceC4572c), interfaceC4530q0, interfaceC4530q02);
    }

    /* renamed from: b */
    private AbstractC4518k0<T> m17440b(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, InterfaceC4530q0<? extends T> interfaceC4530q0) {
        C4601b.m18284a(timeUnit, "unit is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4476a.m17128a(new C5090o0(this, j2, timeUnit, abstractC4516j0, interfaceC4530q0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T1, T2, T3, R> AbstractC4518k0<R> m17421a(InterfaceC4530q0<? extends T1> interfaceC4530q0, InterfaceC4530q0<? extends T2> interfaceC4530q02, InterfaceC4530q0<? extends T3> interfaceC4530q03, InterfaceC4577h<? super T1, ? super T2, ? super T3, ? extends R> interfaceC4577h) {
        C4601b.m18284a(interfaceC4530q0, "source1 is null");
        C4601b.m18284a(interfaceC4530q02, "source2 is null");
        C4601b.m18284a(interfaceC4530q03, "source3 is null");
        return m17423a(C4600a.m18236a((InterfaceC4577h) interfaceC4577h), interfaceC4530q0, interfaceC4530q02, interfaceC4530q03);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T1, T2, T3, T4, R> AbstractC4518k0<R> m17420a(InterfaceC4530q0<? extends T1> interfaceC4530q0, InterfaceC4530q0<? extends T2> interfaceC4530q02, InterfaceC4530q0<? extends T3> interfaceC4530q03, InterfaceC4530q0<? extends T4> interfaceC4530q04, InterfaceC4578i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> interfaceC4578i) {
        C4601b.m18284a(interfaceC4530q0, "source1 is null");
        C4601b.m18284a(interfaceC4530q02, "source2 is null");
        C4601b.m18284a(interfaceC4530q03, "source3 is null");
        C4601b.m18284a(interfaceC4530q04, "source4 is null");
        return m17423a(C4600a.m18237a((InterfaceC4578i) interfaceC4578i), interfaceC4530q0, interfaceC4530q02, interfaceC4530q03, interfaceC4530q04);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, R> AbstractC4518k0<R> m17419a(InterfaceC4530q0<? extends T1> interfaceC4530q0, InterfaceC4530q0<? extends T2> interfaceC4530q02, InterfaceC4530q0<? extends T3> interfaceC4530q03, InterfaceC4530q0<? extends T4> interfaceC4530q04, InterfaceC4530q0<? extends T5> interfaceC4530q05, InterfaceC4579j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> interfaceC4579j) {
        C4601b.m18284a(interfaceC4530q0, "source1 is null");
        C4601b.m18284a(interfaceC4530q02, "source2 is null");
        C4601b.m18284a(interfaceC4530q03, "source3 is null");
        C4601b.m18284a(interfaceC4530q04, "source4 is null");
        C4601b.m18284a(interfaceC4530q05, "source5 is null");
        return m17423a(C4600a.m18238a((InterfaceC4579j) interfaceC4579j), interfaceC4530q0, interfaceC4530q02, interfaceC4530q03, interfaceC4530q04, interfaceC4530q05);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, T6, R> AbstractC4518k0<R> m17418a(InterfaceC4530q0<? extends T1> interfaceC4530q0, InterfaceC4530q0<? extends T2> interfaceC4530q02, InterfaceC4530q0<? extends T3> interfaceC4530q03, InterfaceC4530q0<? extends T4> interfaceC4530q04, InterfaceC4530q0<? extends T5> interfaceC4530q05, InterfaceC4530q0<? extends T6> interfaceC4530q06, InterfaceC4580k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> interfaceC4580k) {
        C4601b.m18284a(interfaceC4530q0, "source1 is null");
        C4601b.m18284a(interfaceC4530q02, "source2 is null");
        C4601b.m18284a(interfaceC4530q03, "source3 is null");
        C4601b.m18284a(interfaceC4530q04, "source4 is null");
        C4601b.m18284a(interfaceC4530q05, "source5 is null");
        C4601b.m18284a(interfaceC4530q06, "source6 is null");
        return m17423a(C4600a.m18239a((InterfaceC4580k) interfaceC4580k), interfaceC4530q0, interfaceC4530q02, interfaceC4530q03, interfaceC4530q04, interfaceC4530q05, interfaceC4530q06);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, T6, T7, R> AbstractC4518k0<R> m17417a(InterfaceC4530q0<? extends T1> interfaceC4530q0, InterfaceC4530q0<? extends T2> interfaceC4530q02, InterfaceC4530q0<? extends T3> interfaceC4530q03, InterfaceC4530q0<? extends T4> interfaceC4530q04, InterfaceC4530q0<? extends T5> interfaceC4530q05, InterfaceC4530q0<? extends T6> interfaceC4530q06, InterfaceC4530q0<? extends T7> interfaceC4530q07, InterfaceC4581l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> interfaceC4581l) {
        C4601b.m18284a(interfaceC4530q0, "source1 is null");
        C4601b.m18284a(interfaceC4530q02, "source2 is null");
        C4601b.m18284a(interfaceC4530q03, "source3 is null");
        C4601b.m18284a(interfaceC4530q04, "source4 is null");
        C4601b.m18284a(interfaceC4530q05, "source5 is null");
        C4601b.m18284a(interfaceC4530q06, "source6 is null");
        C4601b.m18284a(interfaceC4530q07, "source7 is null");
        return m17423a(C4600a.m18240a((InterfaceC4581l) interfaceC4581l), interfaceC4530q0, interfaceC4530q02, interfaceC4530q03, interfaceC4530q04, interfaceC4530q05, interfaceC4530q06, interfaceC4530q07);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> AbstractC4518k0<R> m17416a(InterfaceC4530q0<? extends T1> interfaceC4530q0, InterfaceC4530q0<? extends T2> interfaceC4530q02, InterfaceC4530q0<? extends T3> interfaceC4530q03, InterfaceC4530q0<? extends T4> interfaceC4530q04, InterfaceC4530q0<? extends T5> interfaceC4530q05, InterfaceC4530q0<? extends T6> interfaceC4530q06, InterfaceC4530q0<? extends T7> interfaceC4530q07, InterfaceC4530q0<? extends T8> interfaceC4530q08, InterfaceC4582m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> interfaceC4582m) {
        C4601b.m18284a(interfaceC4530q0, "source1 is null");
        C4601b.m18284a(interfaceC4530q02, "source2 is null");
        C4601b.m18284a(interfaceC4530q03, "source3 is null");
        C4601b.m18284a(interfaceC4530q04, "source4 is null");
        C4601b.m18284a(interfaceC4530q05, "source5 is null");
        C4601b.m18284a(interfaceC4530q06, "source6 is null");
        C4601b.m18284a(interfaceC4530q07, "source7 is null");
        C4601b.m18284a(interfaceC4530q08, "source8 is null");
        return m17423a(C4600a.m18241a((InterfaceC4582m) interfaceC4582m), interfaceC4530q0, interfaceC4530q02, interfaceC4530q03, interfaceC4530q04, interfaceC4530q05, interfaceC4530q06, interfaceC4530q07, interfaceC4530q08);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> AbstractC4518k0<R> m17415a(InterfaceC4530q0<? extends T1> interfaceC4530q0, InterfaceC4530q0<? extends T2> interfaceC4530q02, InterfaceC4530q0<? extends T3> interfaceC4530q03, InterfaceC4530q0<? extends T4> interfaceC4530q04, InterfaceC4530q0<? extends T5> interfaceC4530q05, InterfaceC4530q0<? extends T6> interfaceC4530q06, InterfaceC4530q0<? extends T7> interfaceC4530q07, InterfaceC4530q0<? extends T8> interfaceC4530q08, InterfaceC4530q0<? extends T9> interfaceC4530q09, InterfaceC4583n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> interfaceC4583n) {
        C4601b.m18284a(interfaceC4530q0, "source1 is null");
        C4601b.m18284a(interfaceC4530q02, "source2 is null");
        C4601b.m18284a(interfaceC4530q03, "source3 is null");
        C4601b.m18284a(interfaceC4530q04, "source4 is null");
        C4601b.m18284a(interfaceC4530q05, "source5 is null");
        C4601b.m18284a(interfaceC4530q06, "source6 is null");
        C4601b.m18284a(interfaceC4530q07, "source7 is null");
        C4601b.m18284a(interfaceC4530q08, "source8 is null");
        C4601b.m18284a(interfaceC4530q09, "source9 is null");
        return m17423a(C4600a.m18242a((InterfaceC4583n) interfaceC4583n), interfaceC4530q0, interfaceC4530q02, interfaceC4530q03, interfaceC4530q04, interfaceC4530q05, interfaceC4530q06, interfaceC4530q07, interfaceC4530q08, interfaceC4530q09);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public static <T, R> AbstractC4518k0<R> m17423a(InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o, InterfaceC4530q0<? extends T>... interfaceC4530q0Arr) {
        C4601b.m18284a(interfaceC4584o, "zipper is null");
        C4601b.m18284a(interfaceC4530q0Arr, "sources is null");
        if (interfaceC4530q0Arr.length == 0) {
            return m17426a((Throwable) new NoSuchElementException());
        }
        return C4476a.m17128a(new C5102u0(interfaceC4530q0Arr, interfaceC4584o));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4518k0<T> m17473a(InterfaceC4530q0<? extends T> interfaceC4530q0) {
        C4601b.m18284a(interfaceC4530q0, "other is null");
        return m17434a(this, interfaceC4530q0);
    }

    @InterfaceC4545e
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <R> R m17489a(@InterfaceC4546f InterfaceC4520l0<T, ? extends R> interfaceC4520l0) {
        return (R) ((InterfaceC4520l0) C4601b.m18284a(interfaceC4520l0, "converter is null")).m18001a(this);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <R> AbstractC4518k0<R> m17475a(InterfaceC4532r0<? super T, ? extends R> interfaceC4532r0) {
        return m17459h(((InterfaceC4532r0) C4601b.m18284a(interfaceC4532r0, "transformer is null")).m18008a(this));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <U> AbstractC4518k0<U> m17482a(Class<? extends U> cls) {
        C4601b.m18284a(cls, "clazz is null");
        return (AbstractC4518k0<U>) m17524h(C4600a.m18243a((Class) cls));
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: a */
    public final AbstractC4518k0<T> m17462a(long j2, TimeUnit timeUnit) {
        return m17465a(j2, timeUnit, C4488a.m17267a(), false);
    }

    @InterfaceC4545e
    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: a */
    public final AbstractC4518k0<T> m17467a(long j2, TimeUnit timeUnit, boolean z) {
        return m17465a(j2, timeUnit, C4488a.m17267a(), z);
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final AbstractC4518k0<T> m17463a(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return m17465a(j2, timeUnit, abstractC4516j0, false);
    }

    @InterfaceC4545e
    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final AbstractC4518k0<T> m17465a(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, boolean z) {
        C4601b.m18284a(timeUnit, "unit is null");
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4476a.m17128a(new C5071f(this, j2, timeUnit, abstractC4516j0, z));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4518k0<T> m17469a(InterfaceC4513i interfaceC4513i) {
        C4601b.m18284a(interfaceC4513i, "other is null");
        return C4476a.m17128a(new C5073g(this, interfaceC4513i));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <U> AbstractC4518k0<T> m17468a(InterfaceC4504g0<U> interfaceC4504g0) {
        C4601b.m18284a(interfaceC4504g0, "other is null");
        return C4476a.m17128a(new C5075h(this, interfaceC4504g0));
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <U> AbstractC4518k0<T> m17481a(InterfaceC5821b<U> interfaceC5821b) {
        C4601b.m18284a(interfaceC5821b, "other is null");
        return C4476a.m17128a(new C5077i(this, interfaceC5821b));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4518k0<T> m17479a(InterfaceC4576g<? super T> interfaceC4576g) {
        C4601b.m18284a(interfaceC4576g, "doAfterSuccess is null");
        return C4476a.m17128a(new C5083l(this, interfaceC4576g));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4518k0<T> m17476a(InterfaceC4570a interfaceC4570a) {
        C4601b.m18284a(interfaceC4570a, "onAfterTerminate is null");
        return C4476a.m17128a(new C5085m(this, interfaceC4570a));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4518k0<T> m17477a(InterfaceC4571b<? super T, ? super Throwable> interfaceC4571b) {
        C4601b.m18284a(interfaceC4571b, "onEvent is null");
        return C4476a.m17128a(new C5093q(this, interfaceC4571b));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4533s<T> m17487a(InterfaceC4587r<? super T> interfaceC4587r) {
        C4601b.m18284a(interfaceC4587r, "predicate is null");
        return C4476a.m17131a(new C4903y(this, interfaceC4587r));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <R> AbstractC4518k0<R> m17480a(InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        return C4476a.m17128a(new C5103v(this, interfaceC4584o));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <R> AbstractC4518k0<R> m17472a(InterfaceC4528p0<? extends R, ? super T> interfaceC4528p0) {
        C4601b.m18284a(interfaceC4528p0, "onLift is null");
        return C4476a.m17128a(new C5074g0(this, interfaceC4528p0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4518k0<Boolean> m17483a(Object obj) {
        return m17484a(obj, C4601b.m18283a());
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4518k0<Boolean> m17484a(Object obj, InterfaceC4573d<Object, Object> interfaceC4573d) {
        C4601b.m18284a(obj, "value is null");
        C4601b.m18284a(interfaceC4573d, "comparer is null");
        return C4476a.m17128a(new C5065c(this, obj, interfaceC4573d));
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final AbstractC4518k0<T> m17470a(AbstractC4516j0 abstractC4516j0) {
        C4601b.m18284a(abstractC4516j0, "scheduler is null");
        return C4476a.m17128a(new C5080j0(this, abstractC4516j0));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4518k0<T> m17471a(AbstractC4518k0<? extends T> abstractC4518k0) {
        C4601b.m18284a(abstractC4518k0, "resumeSingleInCaseOfError is null");
        return m17527i(C4600a.m18255c(abstractC4518k0));
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4519l<T> m17485a(long j2) {
        return m17534m().m17873d(j2);
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4519l<T> m17486a(InterfaceC4574e interfaceC4574e) {
        return m17534m().m17731a(interfaceC4574e);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final AbstractC4518k0<T> m17478a(InterfaceC4573d<? super Integer, ? super Throwable> interfaceC4573d) {
        return m17413a((AbstractC4519l) m17534m().m17823b(interfaceC4573d));
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final InterfaceC4552c m17488a(InterfaceC4576g<? super T> interfaceC4576g, InterfaceC4576g<? super Throwable> interfaceC4576g2) {
        C4601b.m18284a(interfaceC4576g, "onSuccess is null");
        C4601b.m18284a(interfaceC4576g2, "onError is null");
        C4629k c4629k = new C4629k(interfaceC4576g, interfaceC4576g2);
        mo17490a((InterfaceC4524n0) c4629k);
        return c4629k;
    }

    @Override // p251g.p252a.InterfaceC4530q0
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final void mo17490a(InterfaceC4524n0<? super T> interfaceC4524n0) {
        C4601b.m18284a(interfaceC4524n0, "subscriber is null");
        InterfaceC4524n0<? super T> m17130a = C4476a.m17130a(this, interfaceC4524n0);
        C4601b.m18284a(m17130a, "subscriber returned by the RxJavaPlugins hook is null");
        try {
            mo17357b((InterfaceC4524n0) m17130a);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            C4561b.m18199b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @InterfaceC4544d
    @InterfaceC4548h("custom")
    /* renamed from: a */
    public final AbstractC4518k0<T> m17464a(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, InterfaceC4530q0<? extends T> interfaceC4530q0) {
        C4601b.m18284a(interfaceC4530q0, "other is null");
        return m17440b(j2, timeUnit, abstractC4516j0, interfaceC4530q0);
    }

    @InterfaceC4544d
    @InterfaceC4548h(InterfaceC4548h.f17462j)
    /* renamed from: a */
    public final AbstractC4518k0<T> m17466a(long j2, TimeUnit timeUnit, InterfaceC4530q0<? extends T> interfaceC4530q0) {
        C4601b.m18284a(interfaceC4530q0, "other is null");
        return m17440b(j2, timeUnit, C4488a.m17267a(), interfaceC4530q0);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final <U, R> AbstractC4518k0<R> m17474a(InterfaceC4530q0<U> interfaceC4530q0, InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c) {
        return m17422a(this, interfaceC4530q0, interfaceC4572c);
    }

    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: a */
    public final C4467n<T> m17461a(boolean z) {
        C4467n<T> c4467n = new C4467n<>();
        if (z) {
            c4467n.cancel();
        }
        mo17490a((InterfaceC4524n0) c4467n);
        return c4467n;
    }

    /* renamed from: a */
    private static <T> AbstractC4518k0<T> m17413a(AbstractC4519l<T> abstractC4519l) {
        return C4476a.m17128a(new C4756l3(abstractC4519l, null));
    }
}
