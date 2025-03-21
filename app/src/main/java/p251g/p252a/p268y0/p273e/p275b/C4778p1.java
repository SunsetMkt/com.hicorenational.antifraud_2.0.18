package p251g.p252a.p268y0.p273e.p275b;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4517k;
import p251g.p252a.p266w0.AbstractC4567a;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p267x0.InterfaceC4571b;
import p251g.p252a.p267x0.InterfaceC4572c;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p270b.C4600a;
import p251g.p252a.p268y0.p270b.C4601b;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableInternalHelper.java */
/* renamed from: g.a.y0.e.b.p1 */
/* loaded from: classes2.dex */
public final class C4778p1 {

    /* compiled from: FlowableInternalHelper.java */
    /* renamed from: g.a.y0.e.b.p1$a */
    static final class a<T> implements Callable<AbstractC4567a<T>> {

        /* renamed from: a */
        private final AbstractC4519l<T> f18201a;

        /* renamed from: b */
        private final int f18202b;

        a(AbstractC4519l<T> abstractC4519l, int i2) {
            this.f18201a = abstractC4519l;
            this.f18202b = i2;
        }

        @Override // java.util.concurrent.Callable
        public AbstractC4567a<T> call() {
            return this.f18201a.m17935h(this.f18202b);
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    /* renamed from: g.a.y0.e.b.p1$b */
    static final class b<T> implements Callable<AbstractC4567a<T>> {

        /* renamed from: a */
        private final AbstractC4519l<T> f18203a;

        /* renamed from: b */
        private final int f18204b;

        /* renamed from: c */
        private final long f18205c;

        /* renamed from: d */
        private final TimeUnit f18206d;

        /* renamed from: e */
        private final AbstractC4516j0 f18207e;

        b(AbstractC4519l<T> abstractC4519l, int i2, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
            this.f18203a = abstractC4519l;
            this.f18204b = i2;
            this.f18205c = j2;
            this.f18206d = timeUnit;
            this.f18207e = abstractC4516j0;
        }

        @Override // java.util.concurrent.Callable
        public AbstractC4567a<T> call() {
            return this.f18203a.m17793a(this.f18204b, this.f18205c, this.f18206d, this.f18207e);
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    /* renamed from: g.a.y0.e.b.p1$c */
    static final class c<T, U> implements InterfaceC4584o<T, InterfaceC5821b<U>> {

        /* renamed from: a */
        private final InterfaceC4584o<? super T, ? extends Iterable<? extends U>> f18208a;

        c(InterfaceC4584o<? super T, ? extends Iterable<? extends U>> interfaceC4584o) {
            this.f18208a = interfaceC4584o;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((c<T, U>) obj);
        }

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public InterfaceC5821b<U> apply(T t) throws Exception {
            return new C4724g1((Iterable) C4601b.m18284a(this.f18208a.apply(t), "The mapper returned a null Iterable"));
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    /* renamed from: g.a.y0.e.b.p1$d */
    static final class d<U, R, T> implements InterfaceC4584o<U, R> {

        /* renamed from: a */
        private final InterfaceC4572c<? super T, ? super U, ? extends R> f18209a;

        /* renamed from: b */
        private final T f18210b;

        d(InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c, T t) {
            this.f18209a = interfaceC4572c;
            this.f18210b = t;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public R apply(U u) throws Exception {
            return this.f18209a.apply(this.f18210b, u);
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    /* renamed from: g.a.y0.e.b.p1$e */
    static final class e<T, R, U> implements InterfaceC4584o<T, InterfaceC5821b<R>> {

        /* renamed from: a */
        private final InterfaceC4572c<? super T, ? super U, ? extends R> f18211a;

        /* renamed from: b */
        private final InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends U>> f18212b;

        e(InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c, InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends U>> interfaceC4584o) {
            this.f18211a = interfaceC4572c;
            this.f18212b = interfaceC4584o;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((e<T, R, U>) obj);
        }

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public InterfaceC5821b<R> apply(T t) throws Exception {
            return new C4689a2((InterfaceC5821b) C4601b.m18284a(this.f18212b.apply(t), "The mapper returned a null Publisher"), new d(this.f18211a, t));
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    /* renamed from: g.a.y0.e.b.p1$f */
    static final class f<T, U> implements InterfaceC4584o<T, InterfaceC5821b<T>> {

        /* renamed from: a */
        final InterfaceC4584o<? super T, ? extends InterfaceC5821b<U>> f18213a;

        f(InterfaceC4584o<? super T, ? extends InterfaceC5821b<U>> interfaceC4584o) {
            this.f18213a = interfaceC4584o;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((f<T, U>) obj);
        }

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public InterfaceC5821b<T> apply(T t) throws Exception {
            return new C4830y3((InterfaceC5821b) C4601b.m18284a(this.f18213a.apply(t), "The itemDelay returned a null Publisher"), 1L).m17978o(C4600a.m18255c(t)).m17911f((AbstractC4519l<R>) t);
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    /* renamed from: g.a.y0.e.b.p1$g */
    static final class g<T> implements Callable<AbstractC4567a<T>> {

        /* renamed from: a */
        private final AbstractC4519l<T> f18214a;

        g(AbstractC4519l<T> abstractC4519l) {
            this.f18214a = abstractC4519l;
        }

        @Override // java.util.concurrent.Callable
        public AbstractC4567a<T> call() {
            return this.f18214a.m17667B();
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    /* renamed from: g.a.y0.e.b.p1$h */
    static final class h<T, R> implements InterfaceC4584o<AbstractC4519l<T>, InterfaceC5821b<R>> {

        /* renamed from: a */
        private final InterfaceC4584o<? super AbstractC4519l<T>, ? extends InterfaceC5821b<R>> f18215a;

        /* renamed from: b */
        private final AbstractC4516j0 f18216b;

        h(InterfaceC4584o<? super AbstractC4519l<T>, ? extends InterfaceC5821b<R>> interfaceC4584o, AbstractC4516j0 abstractC4516j0) {
            this.f18215a = interfaceC4584o;
            this.f18216b = abstractC4516j0;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC5821b<R> apply(AbstractC4519l<T> abstractC4519l) throws Exception {
            return AbstractC4519l.m17659q((InterfaceC5821b) C4601b.m18284a(this.f18215a.apply(abstractC4519l), "The selector returned a null Publisher")).m17722a(this.f18216b);
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    /* renamed from: g.a.y0.e.b.p1$i */
    public enum i implements InterfaceC4576g<InterfaceC5823d> {
        INSTANCE;

        @Override // p251g.p252a.p267x0.InterfaceC4576g
        public void accept(InterfaceC5823d interfaceC5823d) throws Exception {
            interfaceC5823d.request(C5556m0.f20396b);
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    /* renamed from: g.a.y0.e.b.p1$j */
    static final class j<T, S> implements InterfaceC4572c<S, InterfaceC4517k<T>, S> {

        /* renamed from: a */
        final InterfaceC4571b<S, InterfaceC4517k<T>> f18218a;

        j(InterfaceC4571b<S, InterfaceC4517k<T>> interfaceC4571b) {
            this.f18218a = interfaceC4571b;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4572c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public S apply(S s, InterfaceC4517k<T> interfaceC4517k) throws Exception {
            this.f18218a.mo18209a(s, interfaceC4517k);
            return s;
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    /* renamed from: g.a.y0.e.b.p1$k */
    static final class k<T, S> implements InterfaceC4572c<S, InterfaceC4517k<T>, S> {

        /* renamed from: a */
        final InterfaceC4576g<InterfaceC4517k<T>> f18219a;

        k(InterfaceC4576g<InterfaceC4517k<T>> interfaceC4576g) {
            this.f18219a = interfaceC4576g;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4572c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public S apply(S s, InterfaceC4517k<T> interfaceC4517k) throws Exception {
            this.f18219a.accept(interfaceC4517k);
            return s;
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    /* renamed from: g.a.y0.e.b.p1$l */
    static final class l<T> implements InterfaceC4570a {

        /* renamed from: a */
        final InterfaceC5822c<T> f18220a;

        l(InterfaceC5822c<T> interfaceC5822c) {
            this.f18220a = interfaceC5822c;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4570a
        public void run() throws Exception {
            this.f18220a.onComplete();
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    /* renamed from: g.a.y0.e.b.p1$m */
    static final class m<T> implements InterfaceC4576g<Throwable> {

        /* renamed from: a */
        final InterfaceC5822c<T> f18221a;

        m(InterfaceC5822c<T> interfaceC5822c) {
            this.f18221a = interfaceC5822c;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4576g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            this.f18221a.onError(th);
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    /* renamed from: g.a.y0.e.b.p1$n */
    static final class n<T> implements InterfaceC4576g<T> {

        /* renamed from: a */
        final InterfaceC5822c<T> f18222a;

        n(InterfaceC5822c<T> interfaceC5822c) {
            this.f18222a = interfaceC5822c;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4576g
        public void accept(T t) throws Exception {
            this.f18222a.onNext(t);
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    /* renamed from: g.a.y0.e.b.p1$o */
    static final class o<T> implements Callable<AbstractC4567a<T>> {

        /* renamed from: a */
        private final AbstractC4519l<T> f18223a;

        /* renamed from: b */
        private final long f18224b;

        /* renamed from: c */
        private final TimeUnit f18225c;

        /* renamed from: d */
        private final AbstractC4516j0 f18226d;

        o(AbstractC4519l<T> abstractC4519l, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
            this.f18223a = abstractC4519l;
            this.f18224b = j2;
            this.f18225c = timeUnit;
            this.f18226d = abstractC4516j0;
        }

        @Override // java.util.concurrent.Callable
        public AbstractC4567a<T> call() {
            return this.f18223a.m17899e(this.f18224b, this.f18225c, this.f18226d);
        }
    }

    /* compiled from: FlowableInternalHelper.java */
    /* renamed from: g.a.y0.e.b.p1$p */
    static final class p<T, R> implements InterfaceC4584o<List<InterfaceC5821b<? extends T>>, InterfaceC5821b<? extends R>> {

        /* renamed from: a */
        private final InterfaceC4584o<? super Object[], ? extends R> f18227a;

        p(InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o) {
            this.f18227a = interfaceC4584o;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC5821b<? extends R> apply(List<InterfaceC5821b<? extends T>> list) {
            return AbstractC4519l.m17572a((Iterable) list, (InterfaceC4584o) this.f18227a, false, AbstractC4519l.m17539Q());
        }
    }

    private C4778p1() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static <T, S> InterfaceC4572c<S, InterfaceC4517k<T>, S> m18358a(InterfaceC4576g<InterfaceC4517k<T>> interfaceC4576g) {
        return new k(interfaceC4576g);
    }

    /* renamed from: b */
    public static <T, U> InterfaceC4584o<T, InterfaceC5821b<T>> m18367b(InterfaceC4584o<? super T, ? extends InterfaceC5821b<U>> interfaceC4584o) {
        return new f(interfaceC4584o);
    }

    /* renamed from: c */
    public static <T> InterfaceC4576g<T> m18368c(InterfaceC5822c<T> interfaceC5822c) {
        return new n(interfaceC5822c);
    }

    /* renamed from: a */
    public static <T, S> InterfaceC4572c<S, InterfaceC4517k<T>, S> m18357a(InterfaceC4571b<S, InterfaceC4517k<T>> interfaceC4571b) {
        return new j(interfaceC4571b);
    }

    /* renamed from: b */
    public static <T> InterfaceC4576g<Throwable> m18366b(InterfaceC5822c<T> interfaceC5822c) {
        return new m(interfaceC5822c);
    }

    /* renamed from: c */
    public static <T, R> InterfaceC4584o<List<InterfaceC5821b<? extends T>>, InterfaceC5821b<? extends R>> m18369c(InterfaceC4584o<? super Object[], ? extends R> interfaceC4584o) {
        return new p(interfaceC4584o);
    }

    /* renamed from: a */
    public static <T> InterfaceC4570a m18356a(InterfaceC5822c<T> interfaceC5822c) {
        return new l(interfaceC5822c);
    }

    /* renamed from: a */
    public static <T, U, R> InterfaceC4584o<T, InterfaceC5821b<R>> m18361a(InterfaceC4584o<? super T, ? extends InterfaceC5821b<? extends U>> interfaceC4584o, InterfaceC4572c<? super T, ? super U, ? extends R> interfaceC4572c) {
        return new e(interfaceC4572c, interfaceC4584o);
    }

    /* renamed from: a */
    public static <T, U> InterfaceC4584o<T, InterfaceC5821b<U>> m18359a(InterfaceC4584o<? super T, ? extends Iterable<? extends U>> interfaceC4584o) {
        return new c(interfaceC4584o);
    }

    /* renamed from: a */
    public static <T> Callable<AbstractC4567a<T>> m18362a(AbstractC4519l<T> abstractC4519l) {
        return new g(abstractC4519l);
    }

    /* renamed from: a */
    public static <T> Callable<AbstractC4567a<T>> m18363a(AbstractC4519l<T> abstractC4519l, int i2) {
        return new a(abstractC4519l, i2);
    }

    /* renamed from: a */
    public static <T> Callable<AbstractC4567a<T>> m18364a(AbstractC4519l<T> abstractC4519l, int i2, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return new b(abstractC4519l, i2, j2, timeUnit, abstractC4516j0);
    }

    /* renamed from: a */
    public static <T> Callable<AbstractC4567a<T>> m18365a(AbstractC4519l<T> abstractC4519l, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return new o(abstractC4519l, j2, timeUnit, abstractC4516j0);
    }

    /* renamed from: a */
    public static <T, R> InterfaceC4584o<AbstractC4519l<T>, InterfaceC5821b<R>> m18360a(InterfaceC4584o<? super AbstractC4519l<T>, ? extends InterfaceC5821b<R>> interfaceC4584o, AbstractC4516j0 abstractC4516j0) {
        return new h(interfaceC4584o, abstractC4516j0);
    }
}
