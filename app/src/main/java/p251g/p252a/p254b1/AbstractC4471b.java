package p251g.p252a.p254b1;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.EnumC4541a;
import p251g.p252a.p263t0.InterfaceC4542b;
import p251g.p252a.p263t0.InterfaceC4543c;
import p251g.p252a.p263t0.InterfaceC4544d;
import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p263t0.InterfaceC4548h;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p267x0.InterfaceC4571b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p267x0.InterfaceC4586q;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p270b.C4600a;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p273e.p278e.C5045a;
import p251g.p252a.p268y0.p273e.p278e.C5046b;
import p251g.p252a.p268y0.p273e.p278e.C5047c;
import p251g.p252a.p268y0.p273e.p278e.C5048d;
import p251g.p252a.p268y0.p273e.p278e.C5049e;
import p251g.p252a.p268y0.p273e.p278e.C5050f;
import p251g.p252a.p268y0.p273e.p278e.C5051g;
import p251g.p252a.p268y0.p273e.p278e.C5052h;
import p251g.p252a.p268y0.p273e.p278e.C5053i;
import p251g.p252a.p268y0.p273e.p278e.C5054j;
import p251g.p252a.p268y0.p273e.p278e.C5055k;
import p251g.p252a.p268y0.p273e.p278e.C5056l;
import p251g.p252a.p268y0.p273e.p278e.C5057m;
import p251g.p252a.p268y0.p273e.p278e.C5058n;
import p251g.p252a.p268y0.p273e.p278e.C5059o;
import p251g.p252a.p268y0.p273e.p278e.C5060p;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p284j.C5171k;
import p251g.p252a.p268y0.p284j.C5176p;
import p251g.p252a.p268y0.p284j.C5183w;
import p251g.p252a.p268y0.p284j.EnumC5170j;
import p251g.p252a.p268y0.p284j.EnumC5175o;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: ParallelFlowable.java */
@InterfaceC4543c
/* renamed from: g.a.b1.b */
/* loaded from: classes2.dex */
public abstract class AbstractC4471b<T> {
    @InterfaceC4544d
    /* renamed from: a */
    public static <T> AbstractC4471b<T> m16963a(@InterfaceC4546f InterfaceC5821b<? extends T> interfaceC5821b) {
        return m16965a(interfaceC5821b, Runtime.getRuntime().availableProcessors(), AbstractC4519l.m17539Q());
    }

    /* renamed from: a */
    public abstract int mo16967a();

    /* renamed from: a */
    public abstract void mo16994a(@InterfaceC4546f InterfaceC5822c<? super T>[] interfaceC5822cArr);

    /* renamed from: b */
    protected final boolean m17003b(@InterfaceC4546f InterfaceC5822c<?>[] interfaceC5822cArr) {
        int mo16967a = mo16967a();
        if (interfaceC5822cArr.length == mo16967a) {
            return true;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("parallelism = " + mo16967a + ", subscribers = " + interfaceC5822cArr.length);
        for (InterfaceC5822c<?> interfaceC5822c : interfaceC5822cArr) {
            EnumC5157g.error(illegalArgumentException, interfaceC5822c);
        }
        return false;
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: c */
    public final <R> AbstractC4471b<R> m17006c(@InterfaceC4546f InterfaceC4584o<? super T, ? extends R> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "mapper");
        return C4476a.m17120a(new C5054j(this, interfaceC4584o));
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: d */
    public final AbstractC4471b<T> m17008d(@InterfaceC4546f InterfaceC4576g<? super InterfaceC5823d> interfaceC4576g) {
        C4601b.m18284a(interfaceC4576g, "onSubscribe is null");
        InterfaceC4576g m18257d = C4600a.m18257d();
        InterfaceC4576g m18257d2 = C4600a.m18257d();
        InterfaceC4576g m18257d3 = C4600a.m18257d();
        InterfaceC4570a interfaceC4570a = C4600a.f17515c;
        return C4476a.m17120a(new C5056l(this, m18257d, m18257d2, m18257d3, interfaceC4570a, interfaceC4570a, interfaceC4576g, C4600a.f17519g, C4600a.f17515c));
    }

    @InterfaceC4544d
    /* renamed from: a */
    public static <T> AbstractC4471b<T> m16964a(@InterfaceC4546f InterfaceC5821b<? extends T> interfaceC5821b, int i2) {
        return m16965a(interfaceC5821b, i2, AbstractC4519l.m17539Q());
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: a */
    public static <T> AbstractC4471b<T> m16965a(@InterfaceC4546f InterfaceC5821b<? extends T> interfaceC5821b, int i2, int i3) {
        C4601b.m18284a(interfaceC5821b, "source");
        C4601b.m18279a(i2, "parallelism");
        C4601b.m18279a(i3, "prefetch");
        return C4476a.m17120a(new C5052h(interfaceC5821b, i2, i3));
    }

    @InterfaceC4546f
    @InterfaceC4545e
    @InterfaceC4548h("none")
    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    /* renamed from: c */
    public final AbstractC4519l<T> m17007c() {
        return m17000b(AbstractC4519l.m17539Q());
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: c */
    public final AbstractC4471b<T> m17005c(@InterfaceC4546f InterfaceC4576g<? super T> interfaceC4576g) {
        C4601b.m18284a(interfaceC4576g, "onNext is null");
        InterfaceC4576g m18257d = C4600a.m18257d();
        InterfaceC4576g m18257d2 = C4600a.m18257d();
        InterfaceC4570a interfaceC4570a = C4600a.f17515c;
        return C4476a.m17120a(new C5056l(this, interfaceC4576g, m18257d, m18257d2, interfaceC4570a, interfaceC4570a, C4600a.m18257d(), C4600a.f17519g, C4600a.f17515c));
    }

    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    @InterfaceC4548h("none")
    /* renamed from: b */
    public final AbstractC4519l<T> m16999b() {
        return m16989a(AbstractC4519l.m17539Q());
    }

    @InterfaceC4546f
    @InterfaceC4545e
    @InterfaceC4544d
    /* renamed from: a */
    public final <R> R m16993a(@InterfaceC4546f InterfaceC4472c<T, R> interfaceC4472c) {
        return (R) ((InterfaceC4472c) C4601b.m18284a(interfaceC4472c, "converter is null")).m17010a(this);
    }

    @InterfaceC4546f
    @InterfaceC4548h("none")
    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    /* renamed from: b */
    public final AbstractC4519l<T> m17000b(int i2) {
        C4601b.m18279a(i2, "prefetch");
        return C4476a.m17129a(new C5053i(this, i2, true));
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: d */
    public final <U> U m17009d(@InterfaceC4546f InterfaceC4584o<? super AbstractC4471b<T>, U> interfaceC4584o) {
        try {
            return (U) ((InterfaceC4584o) C4601b.m18284a(interfaceC4584o, "converter is null")).apply(this);
        } catch (Throwable th) {
            C4561b.m18199b(th);
            throw C5171k.m18626c(th);
        }
    }

    @InterfaceC4546f
    @InterfaceC4545e
    @InterfaceC4544d
    /* renamed from: a */
    public final <R> AbstractC4471b<R> m16978a(@InterfaceC4546f InterfaceC4584o<? super T, ? extends R> interfaceC4584o, @InterfaceC4546f EnumC4470a enumC4470a) {
        C4601b.m18284a(interfaceC4584o, "mapper");
        C4601b.m18284a(enumC4470a, "errorHandler is null");
        return C4476a.m17120a(new C5055k(this, interfaceC4584o, enumC4470a));
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: b */
    public final AbstractC4519l<List<T>> m17001b(@InterfaceC4546f Comparator<? super T> comparator) {
        return m17002b(comparator, 16);
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: b */
    public final AbstractC4519l<List<T>> m17002b(@InterfaceC4546f Comparator<? super T> comparator, int i2) {
        C4601b.m18284a(comparator, "comparator is null");
        C4601b.m18279a(i2, "capacityHint");
        return C4476a.m17129a(m16988a(C4600a.m18249a((i2 / mo16967a()) + 1), EnumC5175o.instance()).m17006c(new C5183w(comparator)).m16990a(new C5176p(comparator)));
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: c */
    public final AbstractC4471b<T> m17004c(@InterfaceC4546f InterfaceC4570a interfaceC4570a) {
        C4601b.m18284a(interfaceC4570a, "onComplete is null");
        return C4476a.m17120a(new C5056l(this, C4600a.m18257d(), C4600a.m18257d(), C4600a.m18257d(), interfaceC4570a, C4600a.f17515c, C4600a.m18257d(), C4600a.f17519g, C4600a.f17515c));
    }

    @InterfaceC4546f
    @InterfaceC4545e
    @InterfaceC4544d
    /* renamed from: a */
    public final <R> AbstractC4471b<R> m16979a(@InterfaceC4546f InterfaceC4584o<? super T, ? extends R> interfaceC4584o, @InterfaceC4546f InterfaceC4572c<? super Long, ? super Throwable, EnumC4470a> interfaceC4572c) {
        C4601b.m18284a(interfaceC4584o, "mapper");
        C4601b.m18284a(interfaceC4572c, "errorHandler is null");
        return C4476a.m17120a(new C5055k(this, interfaceC4584o, interfaceC4572c));
    }

    @InterfaceC4544d
    /* renamed from: a */
    public final AbstractC4471b<T> m16984a(@InterfaceC4546f InterfaceC4587r<? super T> interfaceC4587r) {
        C4601b.m18284a(interfaceC4587r, "predicate");
        return C4476a.m17120a(new C5048d(this, interfaceC4587r));
    }

    @InterfaceC4545e
    @InterfaceC4544d
    /* renamed from: a */
    public final AbstractC4471b<T> m16985a(@InterfaceC4546f InterfaceC4587r<? super T> interfaceC4587r, @InterfaceC4546f EnumC4470a enumC4470a) {
        C4601b.m18284a(interfaceC4587r, "predicate");
        C4601b.m18284a(enumC4470a, "errorHandler is null");
        return C4476a.m17120a(new C5049e(this, interfaceC4587r, enumC4470a));
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: b */
    public final AbstractC4471b<T> m16996b(@InterfaceC4546f InterfaceC4576g<Throwable> interfaceC4576g) {
        C4601b.m18284a(interfaceC4576g, "onError is null");
        InterfaceC4576g m18257d = C4600a.m18257d();
        InterfaceC4576g m18257d2 = C4600a.m18257d();
        InterfaceC4570a interfaceC4570a = C4600a.f17515c;
        return C4476a.m17120a(new C5056l(this, m18257d, m18257d2, interfaceC4576g, interfaceC4570a, interfaceC4570a, C4600a.m18257d(), C4600a.f17519g, C4600a.f17515c));
    }

    @InterfaceC4545e
    @InterfaceC4544d
    /* renamed from: a */
    public final AbstractC4471b<T> m16986a(@InterfaceC4546f InterfaceC4587r<? super T> interfaceC4587r, @InterfaceC4546f InterfaceC4572c<? super Long, ? super Throwable, EnumC4470a> interfaceC4572c) {
        C4601b.m18284a(interfaceC4587r, "predicate");
        C4601b.m18284a(interfaceC4572c, "errorHandler is null");
        return C4476a.m17120a(new C5049e(this, interfaceC4587r, interfaceC4572c));
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: a */
    public final AbstractC4471b<T> m16969a(@InterfaceC4546f AbstractC4516j0 abstractC4516j0) {
        return m16970a(abstractC4516j0, AbstractC4519l.m17539Q());
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: a */
    public final AbstractC4471b<T> m16970a(@InterfaceC4546f AbstractC4516j0 abstractC4516j0, int i2) {
        C4601b.m18284a(abstractC4516j0, "scheduler");
        C4601b.m18279a(i2, "prefetch");
        return C4476a.m17120a(new C5059o(this, abstractC4516j0, i2));
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: b */
    public final AbstractC4471b<T> m16995b(@InterfaceC4546f InterfaceC4570a interfaceC4570a) {
        C4601b.m18284a(interfaceC4570a, "onCancel is null");
        InterfaceC4576g m18257d = C4600a.m18257d();
        InterfaceC4576g m18257d2 = C4600a.m18257d();
        InterfaceC4576g m18257d3 = C4600a.m18257d();
        InterfaceC4570a interfaceC4570a2 = C4600a.f17515c;
        return C4476a.m17120a(new C5056l(this, m18257d, m18257d2, m18257d3, interfaceC4570a2, interfaceC4570a2, C4600a.m18257d(), C4600a.f17519g, interfaceC4570a));
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: a */
    public final AbstractC4519l<T> m16990a(@InterfaceC4546f InterfaceC4572c<T, T, T> interfaceC4572c) {
        C4601b.m18284a(interfaceC4572c, "reducer");
        return C4476a.m17129a(new C5058n(this, interfaceC4572c));
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: a */
    public final <R> AbstractC4471b<R> m16988a(@InterfaceC4546f Callable<R> callable, @InterfaceC4546f InterfaceC4572c<R, ? super T, R> interfaceC4572c) {
        C4601b.m18284a(callable, "initialSupplier");
        C4601b.m18284a(interfaceC4572c, "reducer");
        return C4476a.m17120a(new C5057m(this, callable, interfaceC4572c));
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: b */
    public final <R> AbstractC4471b<R> m16997b(@InterfaceC4546f InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o) {
        return m16982a(interfaceC4584o, false, Integer.MAX_VALUE, AbstractC4519l.m17539Q());
    }

    @InterfaceC4546f
    @InterfaceC4548h("none")
    @InterfaceC4542b(EnumC4541a.FULL)
    @InterfaceC4544d
    /* renamed from: a */
    public final AbstractC4519l<T> m16989a(int i2) {
        C4601b.m18279a(i2, "prefetch");
        return C4476a.m17129a(new C5053i(this, i2, false));
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: b */
    public final <R> AbstractC4471b<R> m16998b(@InterfaceC4546f InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o, boolean z) {
        return m16982a(interfaceC4584o, z, Integer.MAX_VALUE, AbstractC4519l.m17539Q());
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: a */
    public final AbstractC4519l<T> m16991a(@InterfaceC4546f Comparator<? super T> comparator) {
        return m16992a(comparator, 16);
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: a */
    public final AbstractC4519l<T> m16992a(@InterfaceC4546f Comparator<? super T> comparator, int i2) {
        C4601b.m18284a(comparator, "comparator is null");
        C4601b.m18279a(i2, "capacityHint");
        return C4476a.m17129a(new C5060p(m16988a(C4600a.m18249a((i2 / mo16967a()) + 1), EnumC5175o.instance()).m17006c(new C5183w(comparator)), comparator));
    }

    @InterfaceC4546f
    @InterfaceC4545e
    @InterfaceC4544d
    /* renamed from: a */
    public final AbstractC4471b<T> m16973a(@InterfaceC4546f InterfaceC4576g<? super T> interfaceC4576g, @InterfaceC4546f EnumC4470a enumC4470a) {
        C4601b.m18284a(interfaceC4576g, "onNext is null");
        C4601b.m18284a(enumC4470a, "errorHandler is null");
        return C4476a.m17120a(new C5047c(this, interfaceC4576g, enumC4470a));
    }

    @InterfaceC4546f
    @InterfaceC4545e
    @InterfaceC4544d
    /* renamed from: a */
    public final AbstractC4471b<T> m16974a(@InterfaceC4546f InterfaceC4576g<? super T> interfaceC4576g, @InterfaceC4546f InterfaceC4572c<? super Long, ? super Throwable, EnumC4470a> interfaceC4572c) {
        C4601b.m18284a(interfaceC4576g, "onNext is null");
        C4601b.m18284a(interfaceC4572c, "errorHandler is null");
        return C4476a.m17120a(new C5047c(this, interfaceC4576g, interfaceC4572c));
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: a */
    public final AbstractC4471b<T> m16972a(@InterfaceC4546f InterfaceC4576g<? super T> interfaceC4576g) {
        C4601b.m18284a(interfaceC4576g, "onAfterNext is null");
        InterfaceC4576g m18257d = C4600a.m18257d();
        InterfaceC4576g m18257d2 = C4600a.m18257d();
        InterfaceC4570a interfaceC4570a = C4600a.f17515c;
        return C4476a.m17120a(new C5056l(this, m18257d, interfaceC4576g, m18257d2, interfaceC4570a, interfaceC4570a, C4600a.m18257d(), C4600a.f17519g, C4600a.f17515c));
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: a */
    public final AbstractC4471b<T> m16971a(@InterfaceC4546f InterfaceC4570a interfaceC4570a) {
        C4601b.m18284a(interfaceC4570a, "onAfterTerminate is null");
        return C4476a.m17120a(new C5056l(this, C4600a.m18257d(), C4600a.m18257d(), C4600a.m18257d(), C4600a.f17515c, interfaceC4570a, C4600a.m18257d(), C4600a.f17519g, C4600a.f17515c));
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: a */
    public final AbstractC4471b<T> m16983a(@InterfaceC4546f InterfaceC4586q interfaceC4586q) {
        C4601b.m18284a(interfaceC4586q, "onRequest is null");
        InterfaceC4576g m18257d = C4600a.m18257d();
        InterfaceC4576g m18257d2 = C4600a.m18257d();
        InterfaceC4576g m18257d3 = C4600a.m18257d();
        InterfaceC4570a interfaceC4570a = C4600a.f17515c;
        return C4476a.m17120a(new C5056l(this, m18257d, m18257d2, m18257d3, interfaceC4570a, interfaceC4570a, C4600a.m18257d(), interfaceC4586q, C4600a.f17515c));
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: a */
    public final <C> AbstractC4471b<C> m16987a(@InterfaceC4546f Callable<? extends C> callable, @InterfaceC4546f InterfaceC4571b<? super C, ? super T> interfaceC4571b) {
        C4601b.m18284a(callable, "collectionSupplier is null");
        C4601b.m18284a(interfaceC4571b, "collector is null");
        return C4476a.m17120a(new C5045a(this, callable, interfaceC4571b));
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: a */
    public static <T> AbstractC4471b<T> m16966a(@InterfaceC4546f InterfaceC5821b<T>... interfaceC5821bArr) {
        if (interfaceC5821bArr.length != 0) {
            return C4476a.m17120a(new C5051g(interfaceC5821bArr));
        }
        throw new IllegalArgumentException("Zero publishers not supported");
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: a */
    public final <U> AbstractC4471b<U> m16968a(@InterfaceC4546f InterfaceC4473d<T, U> interfaceC4473d) {
        return C4476a.m17120a(((InterfaceC4473d) C4601b.m18284a(interfaceC4473d, "composer is null")).m17011a(this));
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: a */
    public final <R> AbstractC4471b<R> m16981a(@InterfaceC4546f InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o, boolean z, int i2) {
        return m16982a(interfaceC4584o, z, i2, AbstractC4519l.m17539Q());
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: a */
    public final <R> AbstractC4471b<R> m16982a(@InterfaceC4546f InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o, boolean z, int i2, int i3) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        C4601b.m18279a(i2, "maxConcurrency");
        C4601b.m18279a(i3, "prefetch");
        return C4476a.m17120a(new C5050f(this, interfaceC4584o, z, i2, i3));
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: a */
    public final <R> AbstractC4471b<R> m16975a(@InterfaceC4546f InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o) {
        return m16976a(interfaceC4584o, 2);
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: a */
    public final <R> AbstractC4471b<R> m16976a(@InterfaceC4546f InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o, int i2) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        C4601b.m18279a(i2, "prefetch");
        return C4476a.m17120a(new C5046b(this, interfaceC4584o, i2, EnumC5170j.IMMEDIATE));
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: a */
    public final <R> AbstractC4471b<R> m16980a(@InterfaceC4546f InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o, boolean z) {
        return m16977a(interfaceC4584o, 2, z);
    }

    @InterfaceC4546f
    @InterfaceC4544d
    /* renamed from: a */
    public final <R> AbstractC4471b<R> m16977a(@InterfaceC4546f InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends R>> interfaceC4584o, int i2, boolean z) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        C4601b.m18279a(i2, "prefetch");
        return C4476a.m17120a(new C5046b(this, interfaceC4584o, i2, z ? EnumC5170j.END : EnumC5170j.BOUNDARY));
    }
}
