package p251g.p252a.p268y0.p270b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.C4453a0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p257e1.C4490c;
import p251g.p252a.p265v0.C4563d;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p267x0.InterfaceC4571b;
import p251g.p252a.p267x0.InterfaceC4572c;
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
import p251g.p252a.p267x0.InterfaceC4586q;
import p251g.p252a.p267x0.InterfaceC4587r;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5823d;

/* compiled from: Functions.java */
/* renamed from: g.a.y0.b.a */
/* loaded from: classes2.dex */
public final class C4600a {

    /* renamed from: a */
    static final InterfaceC4584o<Object, Object> f17513a = new w();

    /* renamed from: b */
    public static final Runnable f17514b = new q();

    /* renamed from: c */
    public static final InterfaceC4570a f17515c = new n();

    /* renamed from: d */
    static final InterfaceC4576g<Object> f17516d = new o();

    /* renamed from: e */
    public static final InterfaceC4576g<Throwable> f17517e = new s();

    /* renamed from: f */
    public static final InterfaceC4576g<Throwable> f17518f = new g0();

    /* renamed from: g */
    public static final InterfaceC4586q f17519g = new p();

    /* renamed from: h */
    static final InterfaceC4587r<Object> f17520h = new l0();

    /* renamed from: i */
    static final InterfaceC4587r<Object> f17521i = new t();

    /* renamed from: j */
    static final Callable<Object> f17522j = new f0();

    /* renamed from: k */
    static final Comparator<Object> f17523k = new b0();

    /* renamed from: l */
    public static final InterfaceC4576g<InterfaceC5823d> f17524l = new z();

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$a */
    static final class a<T> implements InterfaceC4576g<T> {

        /* renamed from: a */
        final InterfaceC4570a f17525a;

        a(InterfaceC4570a interfaceC4570a) {
            this.f17525a = interfaceC4570a;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4576g
        public void accept(T t) throws Exception {
            this.f17525a.run();
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$a0 */
    enum a0 implements Comparator<Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$b */
    static final class b<T1, T2, R> implements InterfaceC4584o<Object[], R> {

        /* renamed from: a */
        final InterfaceC4572c<? super T1, ? super T2, ? extends R> f17527a;

        b(InterfaceC4572c<? super T1, ? super T2, ? extends R> interfaceC4572c) {
            this.f17527a = interfaceC4572c;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 2) {
                return this.f17527a.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$b0 */
    static final class b0 implements Comparator<Object> {
        b0() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$c */
    static final class c<T1, T2, T3, R> implements InterfaceC4584o<Object[], R> {

        /* renamed from: a */
        final InterfaceC4577h<T1, T2, T3, R> f17528a;

        c(InterfaceC4577h<T1, T2, T3, R> interfaceC4577h) {
            this.f17528a = interfaceC4577h;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p267x0.InterfaceC4584o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 3) {
                return (R) this.f17528a.m18211a(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$c0 */
    static final class c0<T> implements InterfaceC4570a {

        /* renamed from: a */
        final InterfaceC4576g<? super C4453a0<T>> f17529a;

        c0(InterfaceC4576g<? super C4453a0<T>> interfaceC4576g) {
            this.f17529a = interfaceC4576g;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4570a
        public void run() throws Exception {
            this.f17529a.accept(C4453a0.m16437f());
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$d */
    static final class d<T1, T2, T3, T4, R> implements InterfaceC4584o<Object[], R> {

        /* renamed from: a */
        final InterfaceC4578i<T1, T2, T3, T4, R> f17530a;

        d(InterfaceC4578i<T1, T2, T3, T4, R> interfaceC4578i) {
            this.f17530a = interfaceC4578i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p267x0.InterfaceC4584o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 4) {
                return (R) this.f17530a.m18212a(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$d0 */
    static final class d0<T> implements InterfaceC4576g<Throwable> {

        /* renamed from: a */
        final InterfaceC4576g<? super C4453a0<T>> f17531a;

        d0(InterfaceC4576g<? super C4453a0<T>> interfaceC4576g) {
            this.f17531a = interfaceC4576g;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4576g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            this.f17531a.accept(C4453a0.m16436a(th));
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$e */
    static final class e<T1, T2, T3, T4, T5, R> implements InterfaceC4584o<Object[], R> {

        /* renamed from: a */
        private final InterfaceC4579j<T1, T2, T3, T4, T5, R> f17532a;

        e(InterfaceC4579j<T1, T2, T3, T4, T5, R> interfaceC4579j) {
            this.f17532a = interfaceC4579j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p267x0.InterfaceC4584o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 5) {
                return (R) this.f17532a.m18213a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
            throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$e0 */
    static final class e0<T> implements InterfaceC4576g<T> {

        /* renamed from: a */
        final InterfaceC4576g<? super C4453a0<T>> f17533a;

        e0(InterfaceC4576g<? super C4453a0<T>> interfaceC4576g) {
            this.f17533a = interfaceC4576g;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4576g
        public void accept(T t) throws Exception {
            this.f17533a.accept(C4453a0.m16435a(t));
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$f */
    static final class f<T1, T2, T3, T4, T5, T6, R> implements InterfaceC4584o<Object[], R> {

        /* renamed from: a */
        final InterfaceC4580k<T1, T2, T3, T4, T5, T6, R> f17534a;

        f(InterfaceC4580k<T1, T2, T3, T4, T5, T6, R> interfaceC4580k) {
            this.f17534a = interfaceC4580k;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p267x0.InterfaceC4584o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 6) {
                return (R) this.f17534a.m18214a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            }
            throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$f0 */
    static final class f0 implements Callable<Object> {
        f0() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$g */
    static final class g<T1, T2, T3, T4, T5, T6, T7, R> implements InterfaceC4584o<Object[], R> {

        /* renamed from: a */
        final InterfaceC4581l<T1, T2, T3, T4, T5, T6, T7, R> f17535a;

        g(InterfaceC4581l<T1, T2, T3, T4, T5, T6, T7, R> interfaceC4581l) {
            this.f17535a = interfaceC4581l;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p267x0.InterfaceC4584o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 7) {
                return (R) this.f17535a.m18215a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            }
            throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$g0 */
    static final class g0 implements InterfaceC4576g<Throwable> {
        g0() {
        }

        @Override // p251g.p252a.p267x0.InterfaceC4576g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            C4476a.m17152b(new C4563d(th));
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$h */
    static final class h<T1, T2, T3, T4, T5, T6, T7, T8, R> implements InterfaceC4584o<Object[], R> {

        /* renamed from: a */
        final InterfaceC4582m<T1, T2, T3, T4, T5, T6, T7, T8, R> f17536a;

        h(InterfaceC4582m<T1, T2, T3, T4, T5, T6, T7, T8, R> interfaceC4582m) {
            this.f17536a = interfaceC4582m;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p267x0.InterfaceC4584o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 8) {
                return (R) this.f17536a.m18216a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
            }
            throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$h0 */
    static final class h0<T> implements InterfaceC4584o<T, C4490c<T>> {

        /* renamed from: a */
        final TimeUnit f17537a;

        /* renamed from: b */
        final AbstractC4516j0 f17538b;

        h0(TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
            this.f17537a = timeUnit;
            this.f17538b = abstractC4516j0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            return apply((h0<T>) obj);
        }

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public C4490c<T> apply(T t) throws Exception {
            return new C4490c<>(t, this.f17538b.mo17276a(this.f17537a), this.f17537a);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$i */
    static final class i<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements InterfaceC4584o<Object[], R> {

        /* renamed from: a */
        final InterfaceC4583n<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f17539a;

        i(InterfaceC4583n<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> interfaceC4583n) {
            this.f17539a = interfaceC4583n;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p267x0.InterfaceC4584o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 9) {
                return (R) this.f17539a.m18217a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
            }
            throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$i0 */
    static final class i0<K, T> implements InterfaceC4571b<Map<K, T>, T> {

        /* renamed from: a */
        private final InterfaceC4584o<? super T, ? extends K> f17540a;

        i0(InterfaceC4584o<? super T, ? extends K> interfaceC4584o) {
            this.f17540a = interfaceC4584o;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p267x0.InterfaceC4571b
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo18209a(Object obj, Object obj2) throws Exception {
            m18272a((Map<K, Map<K, T>>) obj, (Map<K, T>) obj2);
        }

        /* renamed from: a */
        public void m18272a(Map<K, T> map, T t) throws Exception {
            map.put(this.f17540a.apply(t), t);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$j */
    static final class j<T> implements Callable<List<T>> {

        /* renamed from: a */
        final int f17541a;

        j(int i2) {
            this.f17541a = i2;
        }

        @Override // java.util.concurrent.Callable
        public List<T> call() throws Exception {
            return new ArrayList(this.f17541a);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$j0 */
    static final class j0<K, V, T> implements InterfaceC4571b<Map<K, V>, T> {

        /* renamed from: a */
        private final InterfaceC4584o<? super T, ? extends V> f17542a;

        /* renamed from: b */
        private final InterfaceC4584o<? super T, ? extends K> f17543b;

        j0(InterfaceC4584o<? super T, ? extends V> interfaceC4584o, InterfaceC4584o<? super T, ? extends K> interfaceC4584o2) {
            this.f17542a = interfaceC4584o;
            this.f17543b = interfaceC4584o2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p267x0.InterfaceC4571b
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo18209a(Object obj, Object obj2) throws Exception {
            m18273a((Map) obj, (Map<K, V>) obj2);
        }

        /* renamed from: a */
        public void m18273a(Map<K, V> map, T t) throws Exception {
            map.put(this.f17543b.apply(t), this.f17542a.apply(t));
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$k */
    static final class k<T> implements InterfaceC4587r<T> {

        /* renamed from: a */
        final InterfaceC4574e f17544a;

        k(InterfaceC4574e interfaceC4574e) {
            this.f17544a = interfaceC4574e;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4587r
        public boolean test(T t) throws Exception {
            return !this.f17544a.getAsBoolean();
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$k0 */
    static final class k0<K, V, T> implements InterfaceC4571b<Map<K, Collection<V>>, T> {

        /* renamed from: a */
        private final InterfaceC4584o<? super K, ? extends Collection<? super V>> f17545a;

        /* renamed from: b */
        private final InterfaceC4584o<? super T, ? extends V> f17546b;

        /* renamed from: c */
        private final InterfaceC4584o<? super T, ? extends K> f17547c;

        k0(InterfaceC4584o<? super K, ? extends Collection<? super V>> interfaceC4584o, InterfaceC4584o<? super T, ? extends V> interfaceC4584o2, InterfaceC4584o<? super T, ? extends K> interfaceC4584o3) {
            this.f17545a = interfaceC4584o;
            this.f17546b = interfaceC4584o2;
            this.f17547c = interfaceC4584o3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p251g.p252a.p267x0.InterfaceC4571b
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo18209a(Object obj, Object obj2) throws Exception {
            m18274a((Map) obj, (Map<K, Collection<V>>) obj2);
        }

        /* renamed from: a */
        public void m18274a(Map<K, Collection<V>> map, T t) throws Exception {
            K apply = this.f17547c.apply(t);
            Collection<? super V> collection = (Collection) map.get(apply);
            if (collection == null) {
                collection = this.f17545a.apply(apply);
                map.put(apply, collection);
            }
            collection.add(this.f17546b.apply(t));
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$l */
    static final class l<T, U> implements InterfaceC4584o<T, U> {

        /* renamed from: a */
        final Class<U> f17548a;

        l(Class<U> cls) {
            this.f17548a = cls;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public U apply(T t) throws Exception {
            return this.f17548a.cast(t);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$l0 */
    static final class l0 implements InterfaceC4587r<Object> {
        l0() {
        }

        @Override // p251g.p252a.p267x0.InterfaceC4587r
        public boolean test(Object obj) {
            return true;
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$m */
    static final class m<T, U> implements InterfaceC4587r<T> {

        /* renamed from: a */
        final Class<U> f17549a;

        m(Class<U> cls) {
            this.f17549a = cls;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4587r
        public boolean test(T t) throws Exception {
            return this.f17549a.isInstance(t);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$n */
    static final class n implements InterfaceC4570a {
        n() {
        }

        @Override // p251g.p252a.p267x0.InterfaceC4570a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$o */
    static final class o implements InterfaceC4576g<Object> {
        o() {
        }

        @Override // p251g.p252a.p267x0.InterfaceC4576g
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$p */
    static final class p implements InterfaceC4586q {
        p() {
        }

        @Override // p251g.p252a.p267x0.InterfaceC4586q
        /* renamed from: a */
        public void mo18219a(long j2) {
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$q */
    static final class q implements Runnable {
        q() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$r */
    static final class r<T> implements InterfaceC4587r<T> {

        /* renamed from: a */
        final T f17550a;

        r(T t) {
            this.f17550a = t;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4587r
        public boolean test(T t) throws Exception {
            return C4601b.m18285a(t, this.f17550a);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$s */
    static final class s implements InterfaceC4576g<Throwable> {
        s() {
        }

        @Override // p251g.p252a.p267x0.InterfaceC4576g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            C4476a.m17152b(th);
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$t */
    static final class t implements InterfaceC4587r<Object> {
        t() {
        }

        @Override // p251g.p252a.p267x0.InterfaceC4587r
        public boolean test(Object obj) {
            return false;
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$u */
    static final class u implements InterfaceC4570a {

        /* renamed from: a */
        final Future<?> f17551a;

        u(Future<?> future) {
            this.f17551a = future;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4570a
        public void run() throws Exception {
            this.f17551a.get();
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$v */
    enum v implements Callable<Set<Object>> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        public Set<Object> call() throws Exception {
            return new HashSet();
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$w */
    static final class w implements InterfaceC4584o<Object, Object> {
        w() {
        }

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$x */
    static final class x<T, U> implements Callable<U>, InterfaceC4584o<T, U> {

        /* renamed from: a */
        final U f17553a;

        x(U u) {
            this.f17553a = u;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public U apply(T t) throws Exception {
            return this.f17553a;
        }

        @Override // java.util.concurrent.Callable
        public U call() throws Exception {
            return this.f17553a;
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$y */
    static final class y<T> implements InterfaceC4584o<List<T>, List<T>> {

        /* renamed from: a */
        final Comparator<? super T> f17554a;

        y(Comparator<? super T> comparator) {
            this.f17554a = comparator;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<T> apply(List<T> list) {
            Collections.sort(list, this.f17554a);
            return list;
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: g.a.y0.b.a$z */
    static final class z implements InterfaceC4576g<InterfaceC5823d> {
        z() {
        }

        @Override // p251g.p252a.p267x0.InterfaceC4576g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(InterfaceC5823d interfaceC5823d) throws Exception {
            interfaceC5823d.request(C5556m0.f20396b);
        }
    }

    private C4600a() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static <T1, T2, R> InterfaceC4584o<Object[], R> m18235a(InterfaceC4572c<? super T1, ? super T2, ? extends R> interfaceC4572c) {
        C4601b.m18284a(interfaceC4572c, "f is null");
        return new b(interfaceC4572c);
    }

    /* renamed from: b */
    public static <T> InterfaceC4587r<T> m18251b() {
        return (InterfaceC4587r<T>) f17520h;
    }

    /* renamed from: c */
    public static <T, U> InterfaceC4584o<T, U> m18255c(U u2) {
        return new x(u2);
    }

    /* renamed from: d */
    public static <T> InterfaceC4576g<T> m18257d() {
        return (InterfaceC4576g<T>) f17516d;
    }

    /* renamed from: e */
    public static <T> InterfaceC4584o<T, T> m18258e() {
        return (InterfaceC4584o<T, T>) f17513a;
    }

    /* renamed from: f */
    public static <T> Comparator<T> m18259f() {
        return a0.INSTANCE;
    }

    /* renamed from: g */
    public static <T> Comparator<T> m18260g() {
        return (Comparator<T>) f17523k;
    }

    /* renamed from: h */
    public static <T> Callable<T> m18261h() {
        return (Callable<T>) f17522j;
    }

    /* renamed from: b */
    public static <T> Callable<T> m18253b(T t2) {
        return new x(t2);
    }

    /* renamed from: c */
    public static <T> Callable<Set<T>> m18256c() {
        return v.INSTANCE;
    }

    /* renamed from: a */
    public static <T1, T2, T3, R> InterfaceC4584o<Object[], R> m18236a(InterfaceC4577h<T1, T2, T3, R> interfaceC4577h) {
        C4601b.m18284a(interfaceC4577h, "f is null");
        return new c(interfaceC4577h);
    }

    /* renamed from: b */
    public static <T> InterfaceC4576g<Throwable> m18250b(InterfaceC4576g<? super C4453a0<T>> interfaceC4576g) {
        return new d0(interfaceC4576g);
    }

    /* renamed from: c */
    public static <T> InterfaceC4576g<T> m18254c(InterfaceC4576g<? super C4453a0<T>> interfaceC4576g) {
        return new e0(interfaceC4576g);
    }

    /* renamed from: b */
    public static <T, U> InterfaceC4587r<T> m18252b(Class<U> cls) {
        return new m(cls);
    }

    /* renamed from: a */
    public static <T1, T2, T3, T4, R> InterfaceC4584o<Object[], R> m18237a(InterfaceC4578i<T1, T2, T3, T4, R> interfaceC4578i) {
        C4601b.m18284a(interfaceC4578i, "f is null");
        return new d(interfaceC4578i);
    }

    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, R> InterfaceC4584o<Object[], R> m18238a(InterfaceC4579j<T1, T2, T3, T4, T5, R> interfaceC4579j) {
        C4601b.m18284a(interfaceC4579j, "f is null");
        return new e(interfaceC4579j);
    }

    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, T6, R> InterfaceC4584o<Object[], R> m18239a(InterfaceC4580k<T1, T2, T3, T4, T5, T6, R> interfaceC4580k) {
        C4601b.m18284a(interfaceC4580k, "f is null");
        return new f(interfaceC4580k);
    }

    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, T6, T7, R> InterfaceC4584o<Object[], R> m18240a(InterfaceC4581l<T1, T2, T3, T4, T5, T6, T7, R> interfaceC4581l) {
        C4601b.m18284a(interfaceC4581l, "f is null");
        return new g(interfaceC4581l);
    }

    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> InterfaceC4584o<Object[], R> m18241a(InterfaceC4582m<T1, T2, T3, T4, T5, T6, T7, T8, R> interfaceC4582m) {
        C4601b.m18284a(interfaceC4582m, "f is null");
        return new h(interfaceC4582m);
    }

    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> InterfaceC4584o<Object[], R> m18242a(InterfaceC4583n<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> interfaceC4583n) {
        C4601b.m18284a(interfaceC4583n, "f is null");
        return new i(interfaceC4583n);
    }

    /* renamed from: a */
    public static <T> InterfaceC4587r<T> m18246a() {
        return (InterfaceC4587r<T>) f17521i;
    }

    /* renamed from: a */
    public static InterfaceC4570a m18230a(Future<?> future) {
        return new u(future);
    }

    /* renamed from: a */
    public static <T, U> InterfaceC4584o<T, U> m18243a(Class<U> cls) {
        return new l(cls);
    }

    /* renamed from: a */
    public static <T> Callable<List<T>> m18249a(int i2) {
        return new j(i2);
    }

    /* renamed from: a */
    public static <T> InterfaceC4587r<T> m18248a(T t2) {
        return new r(t2);
    }

    /* renamed from: a */
    public static <T> InterfaceC4570a m18229a(InterfaceC4576g<? super C4453a0<T>> interfaceC4576g) {
        return new c0(interfaceC4576g);
    }

    /* renamed from: a */
    public static <T> InterfaceC4576g<T> m18234a(InterfaceC4570a interfaceC4570a) {
        return new a(interfaceC4570a);
    }

    /* renamed from: a */
    public static <T> InterfaceC4587r<T> m18247a(InterfaceC4574e interfaceC4574e) {
        return new k(interfaceC4574e);
    }

    /* renamed from: a */
    public static <T> InterfaceC4584o<T, C4490c<T>> m18245a(TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return new h0(timeUnit, abstractC4516j0);
    }

    /* renamed from: a */
    public static <T, K> InterfaceC4571b<Map<K, T>, T> m18231a(InterfaceC4584o<? super T, ? extends K> interfaceC4584o) {
        return new i0(interfaceC4584o);
    }

    /* renamed from: a */
    public static <T, K, V> InterfaceC4571b<Map<K, V>, T> m18232a(InterfaceC4584o<? super T, ? extends K> interfaceC4584o, InterfaceC4584o<? super T, ? extends V> interfaceC4584o2) {
        return new j0(interfaceC4584o2, interfaceC4584o);
    }

    /* renamed from: a */
    public static <T, K, V> InterfaceC4571b<Map<K, Collection<V>>, T> m18233a(InterfaceC4584o<? super T, ? extends K> interfaceC4584o, InterfaceC4584o<? super T, ? extends V> interfaceC4584o2, InterfaceC4584o<? super K, ? extends Collection<? super V>> interfaceC4584o3) {
        return new k0(interfaceC4584o3, interfaceC4584o2, interfaceC4584o);
    }

    /* renamed from: a */
    public static <T> InterfaceC4584o<List<T>, List<T>> m18244a(Comparator<? super T> comparator) {
        return new y(comparator);
    }
}
