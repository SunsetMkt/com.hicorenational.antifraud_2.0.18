package p251g.p252a.p268y0.p273e.p277d;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.C4453a0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4517k;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p267x0.InterfaceC4571b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p270b.C4600a;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p273e.p279f.C5096r0;
import p251g.p252a.p285z0.AbstractC5187a;

/* compiled from: ObservableInternalHelper.java */
/* renamed from: g.a.y0.e.d.m1 */
/* loaded from: classes2.dex */
public final class C4977m1 {

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: g.a.y0.e.d.m1$a */
    static final class a<T> implements Callable<AbstractC5187a<T>> {

        /* renamed from: a */
        private final AbstractC4469b0<T> f19142a;

        /* renamed from: b */
        private final int f19143b;

        a(AbstractC4469b0<T> abstractC4469b0, int i2) {
            this.f19142a = abstractC4469b0;
            this.f19143b = i2;
        }

        @Override // java.util.concurrent.Callable
        public AbstractC5187a<T> call() {
            return this.f19142a.m16852d(this.f19143b);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: g.a.y0.e.d.m1$b */
    static final class b<T> implements Callable<AbstractC5187a<T>> {

        /* renamed from: a */
        private final AbstractC4469b0<T> f19144a;

        /* renamed from: b */
        private final int f19145b;

        /* renamed from: c */
        private final long f19146c;

        /* renamed from: d */
        private final TimeUnit f19147d;

        /* renamed from: e */
        private final AbstractC4516j0 f19148e;

        b(AbstractC4469b0<T> abstractC4469b0, int i2, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
            this.f19144a = abstractC4469b0;
            this.f19145b = i2;
            this.f19146c = j2;
            this.f19147d = timeUnit;
            this.f19148e = abstractC4516j0;
        }

        @Override // java.util.concurrent.Callable
        public AbstractC5187a<T> call() {
            return this.f19144a.m16766a(this.f19145b, this.f19146c, this.f19147d, this.f19148e);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: g.a.y0.e.d.m1$c */
    enum c implements InterfaceC4584o<C4453a0<Object>, Throwable>, InterfaceC4587r<C4453a0<Object>> {
        INSTANCE;

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public Throwable apply(C4453a0<Object> c4453a0) throws Exception {
            return c4453a0.m16438a();
        }

        @Override // p251g.p252a.p267x0.InterfaceC4587r
        public boolean test(C4453a0<Object> c4453a0) throws Exception {
            return c4453a0.m16441d();
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: g.a.y0.e.d.m1$d */
    static final class d<T, U> implements InterfaceC4584o<T, InterfaceC4504g0<U>> {

        /* renamed from: a */
        private final InterfaceC4584o<? super T, ? extends Iterable<? extends U>> f19150a;

        d(InterfaceC4584o<? super T, ? extends Iterable<? extends U>> interfaceC4584o) {
            this.f19150a = interfaceC4584o;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((d<T, U>) obj);
        }

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public InterfaceC4504g0<U> apply(T t) throws Exception {
            return new C4927d1((Iterable) C4601b.m18284a(this.f19150a.apply(t), "The mapper returned a null Iterable"));
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: g.a.y0.e.d.m1$e */
    static final class e<U, R, T> implements InterfaceC4584o<U, R> {

        /* renamed from: a */
        private final InterfaceC4572c<? super T, ? super U, ? extends R> f19151a;

        /* renamed from: b */
        private final T f19152b;

        e(InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c, T t) {
            this.f19151a = interfaceC4572c;
            this.f19152b = t;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public R apply(U u) throws Exception {
            return this.f19151a.apply(this.f19152b, u);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: g.a.y0.e.d.m1$f */
    static final class f<T, R, U> implements InterfaceC4584o<T, InterfaceC4504g0<R>> {

        /* renamed from: a */
        private final InterfaceC4572c<? super T, ? super U, ? extends R> f19153a;

        /* renamed from: b */
        private final InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends U>> f19154b;

        f(InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends U>> interfaceC4584o) {
            this.f19153a = interfaceC4572c;
            this.f19154b = interfaceC4584o;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((f<T, R, U>) obj);
        }

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public InterfaceC4504g0<R> apply(T t) throws Exception {
            return new C5017u1((InterfaceC4504g0) C4601b.m18284a(this.f19154b.apply(t), "The mapper returned a null ObservableSource"), new e(this.f19153a, t));
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: g.a.y0.e.d.m1$g */
    static final class g<T, U> implements InterfaceC4584o<T, InterfaceC4504g0<T>> {

        /* renamed from: a */
        final InterfaceC4584o<? super T, ? extends InterfaceC4504g0<U>> f19155a;

        g(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<U>> interfaceC4584o) {
            this.f19155a = interfaceC4584o;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((g<T, U>) obj);
        }

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public InterfaceC4504g0<T> apply(T t) throws Exception {
            return new C4959i3((InterfaceC4504g0) C4601b.m18284a(this.f19155a.apply(t), "The itemDelay returned a null ObservableSource"), 1L).m16941p(C4600a.m18255c(t)).m16882f((AbstractC4469b0<R>) t);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: g.a.y0.e.d.m1$h */
    enum h implements InterfaceC4584o<Object, Object> {
        INSTANCE;

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public Object apply(Object obj) throws Exception {
            return 0;
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: g.a.y0.e.d.m1$i */
    static final class i<T, R> implements InterfaceC4584o<T, AbstractC4469b0<R>> {

        /* renamed from: a */
        final InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> f19157a;

        i(InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> interfaceC4584o) {
            this.f19157a = interfaceC4584o;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((i<T, R>) obj);
        }

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public AbstractC4469b0<R> apply(T t) throws Exception {
            return C4476a.m17119a(new C5096r0((InterfaceC4530q0) C4601b.m18284a(this.f19157a.apply(t), "The mapper returned a null SingleSource")));
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: g.a.y0.e.d.m1$j */
    static final class j<T> implements InterfaceC4570a {

        /* renamed from: a */
        final InterfaceC4514i0<T> f19158a;

        j(InterfaceC4514i0<T> interfaceC4514i0) {
            this.f19158a = interfaceC4514i0;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4570a
        public void run() throws Exception {
            this.f19158a.onComplete();
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: g.a.y0.e.d.m1$k */
    static final class k<T> implements InterfaceC4576g<Throwable> {

        /* renamed from: a */
        final InterfaceC4514i0<T> f19159a;

        k(InterfaceC4514i0<T> interfaceC4514i0) {
            this.f19159a = interfaceC4514i0;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4576g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            this.f19159a.onError(th);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: g.a.y0.e.d.m1$l */
    static final class l<T> implements InterfaceC4576g<T> {

        /* renamed from: a */
        final InterfaceC4514i0<T> f19160a;

        l(InterfaceC4514i0<T> interfaceC4514i0) {
            this.f19160a = interfaceC4514i0;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4576g
        public void accept(T t) throws Exception {
            this.f19160a.onNext(t);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: g.a.y0.e.d.m1$m */
    static final class m implements InterfaceC4584o<AbstractC4469b0<C4453a0<Object>>, InterfaceC4504g0<?>> {

        /* renamed from: a */
        private final InterfaceC4584o<? super AbstractC4469b0<Object>, ? extends InterfaceC4504g0<?>> f19161a;

        m(InterfaceC4584o<? super AbstractC4469b0<Object>, ? extends InterfaceC4504g0<?>> interfaceC4584o) {
            this.f19161a = interfaceC4584o;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC4504g0<?> apply(AbstractC4469b0<C4453a0<Object>> abstractC4469b0) throws Exception {
            return this.f19161a.apply(abstractC4469b0.m16941p(h.INSTANCE));
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: g.a.y0.e.d.m1$n */
    static final class n<T> implements Callable<AbstractC5187a<T>> {

        /* renamed from: a */
        private final AbstractC4469b0<T> f19162a;

        n(AbstractC4469b0<T> abstractC4469b0) {
            this.f19162a = abstractC4469b0;
        }

        @Override // java.util.concurrent.Callable
        public AbstractC5187a<T> call() {
            return this.f19162a.m16958x();
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: g.a.y0.e.d.m1$o */
    static final class o<T, R> implements InterfaceC4584o<AbstractC4469b0<T>, InterfaceC4504g0<R>> {

        /* renamed from: a */
        private final InterfaceC4584o<? super AbstractC4469b0<T>, ? extends InterfaceC4504g0<R>> f19163a;

        /* renamed from: b */
        private final AbstractC4516j0 f19164b;

        o(InterfaceC4584o<? super AbstractC4469b0<T>, ? extends InterfaceC4504g0<R>> interfaceC4584o, AbstractC4516j0 abstractC4516j0) {
            this.f19163a = interfaceC4584o;
            this.f19164b = abstractC4516j0;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC4504g0<R> apply(AbstractC4469b0<T> abstractC4469b0) throws Exception {
            return AbstractC4469b0.m16646v((InterfaceC4504g0) C4601b.m18284a(this.f19163a.apply(abstractC4469b0), "The selector returned a null ObservableSource")).m16706a(this.f19164b);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: g.a.y0.e.d.m1$p */
    static final class p implements InterfaceC4584o<AbstractC4469b0<C4453a0<Object>>, InterfaceC4504g0<?>> {

        /* renamed from: a */
        private final InterfaceC4584o<? super AbstractC4469b0<Throwable>, ? extends InterfaceC4504g0<?>> f19165a;

        p(InterfaceC4584o<? super AbstractC4469b0<Throwable>, ? extends InterfaceC4504g0<?>> interfaceC4584o) {
            this.f19165a = interfaceC4584o;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC4504g0<?> apply(AbstractC4469b0<C4453a0<Object>> abstractC4469b0) throws Exception {
            return this.f19165a.apply(abstractC4469b0.m16900h((InterfaceC4587r<? super C4453a0<Object>>) c.INSTANCE).m16941p(c.INSTANCE));
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: g.a.y0.e.d.m1$q */
    static final class q<T, S> implements InterfaceC4572c<S, InterfaceC4517k<T>, S> {

        /* renamed from: a */
        final InterfaceC4571b<S, InterfaceC4517k<T>> f19166a;

        q(InterfaceC4571b<S, InterfaceC4517k<T>> interfaceC4571b) {
            this.f19166a = interfaceC4571b;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4572c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public S apply(S s, InterfaceC4517k<T> interfaceC4517k) throws Exception {
            this.f19166a.mo18209a(s, interfaceC4517k);
            return s;
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: g.a.y0.e.d.m1$r */
    static final class r<T, S> implements InterfaceC4572c<S, InterfaceC4517k<T>, S> {

        /* renamed from: a */
        final InterfaceC4576g<InterfaceC4517k<T>> f19167a;

        r(InterfaceC4576g<InterfaceC4517k<T>> interfaceC4576g) {
            this.f19167a = interfaceC4576g;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4572c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public S apply(S s, InterfaceC4517k<T> interfaceC4517k) throws Exception {
            this.f19167a.accept(interfaceC4517k);
            return s;
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: g.a.y0.e.d.m1$s */
    static final class s<T> implements Callable<AbstractC5187a<T>> {

        /* renamed from: a */
        private final AbstractC4469b0<T> f19168a;

        /* renamed from: b */
        private final long f19169b;

        /* renamed from: c */
        private final TimeUnit f19170c;

        /* renamed from: d */
        private final AbstractC4516j0 f19171d;

        s(AbstractC4469b0<T> abstractC4469b0, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
            this.f19168a = abstractC4469b0;
            this.f19169b = j2;
            this.f19170c = timeUnit;
            this.f19171d = abstractC4516j0;
        }

        @Override // java.util.concurrent.Callable
        public AbstractC5187a<T> call() {
            return this.f19168a.m16869e(this.f19169b, this.f19170c, this.f19171d);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: g.a.y0.e.d.m1$t */
    static final class t<T, R> implements InterfaceC4584o<List<InterfaceC4504g0<? extends T>>, InterfaceC4504g0<? extends R>> {

        /* renamed from: a */
        private final InterfaceC4584o<? super Object[], ? extends R> f19172a;

        t(InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o) {
            this.f19172a = interfaceC4584o;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC4504g0<? extends R> apply(List<InterfaceC4504g0<? extends T>> list) {
            return AbstractC4469b0.m16551a((Iterable) list, (InterfaceC4584o) this.f19172a, false, AbstractC4469b0.m16521L());
        }
    }

    private C4977m1() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static <T, S> InterfaceC4572c<S, InterfaceC4517k<T>, S> m18464a(InterfaceC4576g<InterfaceC4517k<T>> interfaceC4576g) {
        return new r(interfaceC4576g);
    }

    /* renamed from: b */
    public static <T> InterfaceC4576g<Throwable> m18473b(InterfaceC4514i0<T> interfaceC4514i0) {
        return new k(interfaceC4514i0);
    }

    /* renamed from: c */
    public static <T, U> InterfaceC4584o<T, InterfaceC4504g0<T>> m18476c(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<U>> interfaceC4584o) {
        return new g(interfaceC4584o);
    }

    /* renamed from: d */
    public static InterfaceC4584o<AbstractC4469b0<C4453a0<Object>>, InterfaceC4504g0<?>> m18477d(InterfaceC4584o<? super AbstractC4469b0<Object>, ? extends InterfaceC4504g0<?>> interfaceC4584o) {
        return new m(interfaceC4584o);
    }

    /* renamed from: e */
    public static <T> InterfaceC4584o<AbstractC4469b0<C4453a0<Object>>, InterfaceC4504g0<?>> m18478e(InterfaceC4584o<? super AbstractC4469b0<Throwable>, ? extends InterfaceC4504g0<?>> interfaceC4584o) {
        return new p(interfaceC4584o);
    }

    /* renamed from: f */
    public static <T, R> InterfaceC4584o<List<InterfaceC4504g0<? extends T>>, InterfaceC4504g0<? extends R>> m18479f(InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o) {
        return new t(interfaceC4584o);
    }

    /* renamed from: a */
    public static <T, S> InterfaceC4572c<S, InterfaceC4517k<T>, S> m18463a(InterfaceC4571b<S, InterfaceC4517k<T>> interfaceC4571b) {
        return new q(interfaceC4571b);
    }

    /* renamed from: b */
    public static <T, U> InterfaceC4584o<T, InterfaceC4504g0<U>> m18474b(InterfaceC4584o<? super T, ? extends Iterable<? extends U>> interfaceC4584o) {
        return new d(interfaceC4584o);
    }

    /* renamed from: c */
    public static <T> InterfaceC4576g<T> m18475c(InterfaceC4514i0<T> interfaceC4514i0) {
        return new l(interfaceC4514i0);
    }

    /* renamed from: a */
    public static <T> InterfaceC4570a m18462a(InterfaceC4514i0<T> interfaceC4514i0) {
        return new j(interfaceC4514i0);
    }

    /* renamed from: b */
    public static <T, R> AbstractC4469b0<R> m18472b(AbstractC4469b0<T> abstractC4469b0, InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> interfaceC4584o) {
        return abstractC4469b0.m16890g(m18465a(interfaceC4584o), 1);
    }

    /* renamed from: a */
    public static <T, U, R> InterfaceC4584o<T, InterfaceC4504g0<R>> m18467a(InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends U>> interfaceC4584o, InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c) {
        return new f(interfaceC4572c, interfaceC4584o);
    }

    /* renamed from: a */
    public static <T> Callable<AbstractC5187a<T>> m18468a(AbstractC4469b0<T> abstractC4469b0) {
        return new n(abstractC4469b0);
    }

    /* renamed from: a */
    public static <T> Callable<AbstractC5187a<T>> m18469a(AbstractC4469b0<T> abstractC4469b0, int i2) {
        return new a(abstractC4469b0, i2);
    }

    /* renamed from: a */
    public static <T> Callable<AbstractC5187a<T>> m18470a(AbstractC4469b0<T> abstractC4469b0, int i2, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return new b(abstractC4469b0, i2, j2, timeUnit, abstractC4516j0);
    }

    /* renamed from: a */
    public static <T> Callable<AbstractC5187a<T>> m18471a(AbstractC4469b0<T> abstractC4469b0, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return new s(abstractC4469b0, j2, timeUnit, abstractC4516j0);
    }

    /* renamed from: a */
    public static <T, R> InterfaceC4584o<AbstractC4469b0<T>, InterfaceC4504g0<R>> m18466a(InterfaceC4584o<? super AbstractC4469b0<T>, ? extends InterfaceC4504g0<R>> interfaceC4584o, AbstractC4516j0 abstractC4516j0) {
        return new o(interfaceC4584o, abstractC4516j0);
    }

    /* renamed from: a */
    public static <T, R> AbstractC4469b0<R> m18461a(AbstractC4469b0<T> abstractC4469b0, InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> interfaceC4584o) {
        return abstractC4469b0.m16879f(m18465a(interfaceC4584o), 1);
    }

    /* renamed from: a */
    private static <T, R> InterfaceC4584o<T, AbstractC4469b0<R>> m18465a(InterfaceC4584o<? super T, ? extends InterfaceC4530q0<? extends R>> interfaceC4584o) {
        C4601b.m18284a(interfaceC4584o, "mapper is null");
        return new i(interfaceC4584o);
    }
}
