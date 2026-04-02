package h.a.y0.b;

import i.q2.t.m0;
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

/* JADX INFO: compiled from: Functions.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    static final h.a.x0.o<Object, Object> a = new w();

    /* JADX INFO: renamed from: b */
    public static final Runnable f10446b = new q();

    /* JADX INFO: renamed from: c */
    public static final h.a.x0.a f10447c = new n();

    /* JADX INFO: renamed from: d */
    static final h.a.x0.g<Object> f10448d = new o();

    /* JADX INFO: renamed from: e */
    public static final h.a.x0.g<Throwable> f10449e = new s();

    /* JADX INFO: renamed from: f */
    public static final h.a.x0.g<Throwable> f10450f = new g0();

    /* JADX INFO: renamed from: g */
    public static final h.a.x0.q f10451g = new p();

    /* JADX INFO: renamed from: h */
    static final h.a.x0.r<Object> f10452h = new l0();

    /* JADX INFO: renamed from: i */
    static final h.a.x0.r<Object> f10453i = new t();

    /* JADX INFO: renamed from: j */
    static final Callable<Object> f10454j = new f0();

    /* JADX INFO: renamed from: k */
    static final Comparator<Object> f10455k = new b0();

    /* JADX INFO: renamed from: l */
    public static final h.a.x0.g<j.d.d> f10456l = new z();

    /* JADX INFO: renamed from: h.a.y0.b.a$a */
    /* JADX INFO: compiled from: Functions.java */
    static final class C0181a<T> implements h.a.x0.g<T> {
        final h.a.x0.a a;

        C0181a(h.a.x0.a aVar) {
            this.a = aVar;
        }

        @Override // h.a.x0.g
        public void accept(T t) throws Exception {
            this.a.run();
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    enum a0 implements Comparator<Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class b<T1, T2, R> implements h.a.x0.o<Object[], R> {
        final h.a.x0.c<? super T1, ? super T2, ? extends R> a;

        b(h.a.x0.c<? super T1, ? super T2, ? extends R> cVar) {
            this.a = cVar;
        }

        @Override // h.a.x0.o
        /* JADX INFO: renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 2) {
                return this.a.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class b0 implements Comparator<Object> {
        b0() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class c<T1, T2, T3, R> implements h.a.x0.o<Object[], R> {
        final h.a.x0.h<T1, T2, T3, R> a;

        c(h.a.x0.h<T1, T2, T3, R> hVar) {
            this.a = hVar;
        }

        @Override // h.a.x0.o
        /* JADX INFO: renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 3) {
                return this.a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class c0<T> implements h.a.x0.a {
        final h.a.x0.g<? super h.a.a0<T>> a;

        c0(h.a.x0.g<? super h.a.a0<T>> gVar) {
            this.a = gVar;
        }

        @Override // h.a.x0.a
        public void run() throws Exception {
            this.a.accept(h.a.a0.f());
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class d<T1, T2, T3, T4, R> implements h.a.x0.o<Object[], R> {
        final h.a.x0.i<T1, T2, T3, T4, R> a;

        d(h.a.x0.i<T1, T2, T3, T4, R> iVar) {
            this.a = iVar;
        }

        @Override // h.a.x0.o
        /* JADX INFO: renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 4) {
                throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
            }
            return this.a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2], (T4) objArr[3]);
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class d0<T> implements h.a.x0.g<Throwable> {
        final h.a.x0.g<? super h.a.a0<T>> a;

        d0(h.a.x0.g<? super h.a.a0<T>> gVar) {
            this.a = gVar;
        }

        @Override // h.a.x0.g
        /* JADX INFO: renamed from: a */
        public void accept(Throwable th) throws Exception {
            this.a.accept(h.a.a0.a(th));
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class e<T1, T2, T3, T4, T5, R> implements h.a.x0.o<Object[], R> {
        private final h.a.x0.j<T1, T2, T3, T4, T5, R> a;

        e(h.a.x0.j<T1, T2, T3, T4, T5, R> jVar) {
            this.a = jVar;
        }

        @Override // h.a.x0.o
        /* JADX INFO: renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 5) {
                throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
            }
            return this.a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2], (T4) objArr[3], (T5) objArr[4]);
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class e0<T> implements h.a.x0.g<T> {
        final h.a.x0.g<? super h.a.a0<T>> a;

        e0(h.a.x0.g<? super h.a.a0<T>> gVar) {
            this.a = gVar;
        }

        @Override // h.a.x0.g
        public void accept(T t) throws Exception {
            this.a.accept(h.a.a0.a(t));
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class f<T1, T2, T3, T4, T5, T6, R> implements h.a.x0.o<Object[], R> {
        final h.a.x0.k<T1, T2, T3, T4, T5, T6, R> a;

        f(h.a.x0.k<T1, T2, T3, T4, T5, T6, R> kVar) {
            this.a = kVar;
        }

        @Override // h.a.x0.o
        /* JADX INFO: renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 6) {
                throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
            }
            return this.a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2], (T4) objArr[3], (T5) objArr[4], (T6) objArr[5]);
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class f0 implements Callable<Object> {
        f0() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class g<T1, T2, T3, T4, T5, T6, T7, R> implements h.a.x0.o<Object[], R> {
        final h.a.x0.l<T1, T2, T3, T4, T5, T6, T7, R> a;

        g(h.a.x0.l<T1, T2, T3, T4, T5, T6, T7, R> lVar) {
            this.a = lVar;
        }

        @Override // h.a.x0.o
        /* JADX INFO: renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 7) {
                throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
            }
            return this.a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2], (T4) objArr[3], (T5) objArr[4], (T6) objArr[5], (T7) objArr[6]);
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class g0 implements h.a.x0.g<Throwable> {
        g0() {
        }

        @Override // h.a.x0.g
        /* JADX INFO: renamed from: a */
        public void accept(Throwable th) {
            h.a.c1.a.b(new h.a.v0.d(th));
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class h<T1, T2, T3, T4, T5, T6, T7, T8, R> implements h.a.x0.o<Object[], R> {
        final h.a.x0.m<T1, T2, T3, T4, T5, T6, T7, T8, R> a;

        h(h.a.x0.m<T1, T2, T3, T4, T5, T6, T7, T8, R> mVar) {
            this.a = mVar;
        }

        @Override // h.a.x0.o
        /* JADX INFO: renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 8) {
                throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
            }
            return this.a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2], (T4) objArr[3], (T5) objArr[4], (T6) objArr[5], (T7) objArr[6], (T8) objArr[7]);
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class h0<T> implements h.a.x0.o<T, h.a.e1.c<T>> {
        final TimeUnit a;

        /* JADX INFO: renamed from: b */
        final h.a.j0 f10457b;

        h0(TimeUnit timeUnit, h.a.j0 j0Var) {
            this.a = timeUnit;
            this.f10457b = j0Var;
        }

        @Override // h.a.x0.o
        public h.a.e1.c<T> apply(T t) throws Exception {
            return new h.a.e1.c<>(t, this.f10457b.a(this.a), this.a);
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class i<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements h.a.x0.o<Object[], R> {
        final h.a.x0.n<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> a;

        i(h.a.x0.n<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> nVar) {
            this.a = nVar;
        }

        @Override // h.a.x0.o
        /* JADX INFO: renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 9) {
                throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
            }
            return this.a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2], (T4) objArr[3], (T5) objArr[4], (T6) objArr[5], (T7) objArr[6], (T8) objArr[7], (T9) objArr[8]);
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class i0<K, T> implements h.a.x0.b<Map<K, T>, T> {
        private final h.a.x0.o<? super T, ? extends K> a;

        i0(h.a.x0.o<? super T, ? extends K> oVar) {
            this.a = oVar;
        }

        @Override // h.a.x0.b
        public void a(Map<K, T> map, T t) throws Exception {
            map.put(this.a.apply(t), t);
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class j<T> implements Callable<List<T>> {
        final int a;

        j(int i2) {
            this.a = i2;
        }

        @Override // java.util.concurrent.Callable
        public List<T> call() throws Exception {
            return new ArrayList(this.a);
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class j0<K, V, T> implements h.a.x0.b<Map<K, V>, T> {
        private final h.a.x0.o<? super T, ? extends V> a;

        /* JADX INFO: renamed from: b */
        private final h.a.x0.o<? super T, ? extends K> f10458b;

        j0(h.a.x0.o<? super T, ? extends V> oVar, h.a.x0.o<? super T, ? extends K> oVar2) {
            this.a = oVar;
            this.f10458b = oVar2;
        }

        @Override // h.a.x0.b
        public void a(Map<K, V> map, T t) throws Exception {
            map.put(this.f10458b.apply(t), this.a.apply(t));
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class k<T> implements h.a.x0.r<T> {
        final h.a.x0.e a;

        k(h.a.x0.e eVar) {
            this.a = eVar;
        }

        @Override // h.a.x0.r
        public boolean test(T t) throws Exception {
            return !this.a.getAsBoolean();
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class k0<K, V, T> implements h.a.x0.b<Map<K, Collection<V>>, T> {
        private final h.a.x0.o<? super K, ? extends Collection<? super V>> a;

        /* JADX INFO: renamed from: b */
        private final h.a.x0.o<? super T, ? extends V> f10459b;

        /* JADX INFO: renamed from: c */
        private final h.a.x0.o<? super T, ? extends K> f10460c;

        k0(h.a.x0.o<? super K, ? extends Collection<? super V>> oVar, h.a.x0.o<? super T, ? extends V> oVar2, h.a.x0.o<? super T, ? extends K> oVar3) {
            this.a = oVar;
            this.f10459b = oVar2;
            this.f10460c = oVar3;
        }

        @Override // h.a.x0.b
        public void a(Map<K, Collection<V>> map, T t) throws Exception {
            K kApply = this.f10460c.apply(t);
            Collection<? super V> collectionApply = (Collection) map.get(kApply);
            if (collectionApply == null) {
                collectionApply = this.a.apply(kApply);
                map.put(kApply, collectionApply);
            }
            collectionApply.add(this.f10459b.apply(t));
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class l<T, U> implements h.a.x0.o<T, U> {
        final Class<U> a;

        l(Class<U> cls) {
            this.a = cls;
        }

        @Override // h.a.x0.o
        public U apply(T t) throws Exception {
            return this.a.cast(t);
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class l0 implements h.a.x0.r<Object> {
        l0() {
        }

        @Override // h.a.x0.r
        public boolean test(Object obj) {
            return true;
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class m<T, U> implements h.a.x0.r<T> {
        final Class<U> a;

        m(Class<U> cls) {
            this.a = cls;
        }

        @Override // h.a.x0.r
        public boolean test(T t) throws Exception {
            return this.a.isInstance(t);
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class n implements h.a.x0.a {
        n() {
        }

        @Override // h.a.x0.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class o implements h.a.x0.g<Object> {
        o() {
        }

        @Override // h.a.x0.g
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class p implements h.a.x0.q {
        p() {
        }

        @Override // h.a.x0.q
        public void a(long j2) {
        }
    }

    /* JADX INFO: compiled from: Functions.java */
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

    /* JADX INFO: compiled from: Functions.java */
    static final class r<T> implements h.a.x0.r<T> {
        final T a;

        r(T t) {
            this.a = t;
        }

        @Override // h.a.x0.r
        public boolean test(T t) throws Exception {
            return h.a.y0.b.b.a(t, this.a);
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class s implements h.a.x0.g<Throwable> {
        s() {
        }

        @Override // h.a.x0.g
        /* JADX INFO: renamed from: a */
        public void accept(Throwable th) {
            h.a.c1.a.b(th);
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class t implements h.a.x0.r<Object> {
        t() {
        }

        @Override // h.a.x0.r
        public boolean test(Object obj) {
            return false;
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class u implements h.a.x0.a {
        final Future<?> a;

        u(Future<?> future) {
            this.a = future;
        }

        @Override // h.a.x0.a
        public void run() throws Exception {
            this.a.get();
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    enum v implements Callable<Set<Object>> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        public Set<Object> call() throws Exception {
            return new HashSet();
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class w implements h.a.x0.o<Object, Object> {
        w() {
        }

        @Override // h.a.x0.o
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class x<T, U> implements Callable<U>, h.a.x0.o<T, U> {
        final U a;

        x(U u) {
            this.a = u;
        }

        @Override // h.a.x0.o
        public U apply(T t) throws Exception {
            return this.a;
        }

        @Override // java.util.concurrent.Callable
        public U call() throws Exception {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class y<T> implements h.a.x0.o<List<T>, List<T>> {
        final Comparator<? super T> a;

        y(Comparator<? super T> comparator) {
            this.a = comparator;
        }

        @Override // h.a.x0.o
        /* JADX INFO: renamed from: a */
        public List<T> apply(List<T> list) {
            Collections.sort(list, this.a);
            return list;
        }
    }

    /* JADX INFO: compiled from: Functions.java */
    static final class z implements h.a.x0.g<j.d.d> {
        z() {
        }

        @Override // h.a.x0.g
        /* JADX INFO: renamed from: a */
        public void accept(j.d.d dVar) throws Exception {
            dVar.request(m0.f12222b);
        }
    }

    private a() {
        throw new IllegalStateException("No instances!");
    }

    public static <T1, T2, R> h.a.x0.o<Object[], R> a(h.a.x0.c<? super T1, ? super T2, ? extends R> cVar) {
        h.a.y0.b.b.a(cVar, "f is null");
        return new b(cVar);
    }

    public static <T> h.a.x0.r<T> b() {
        return (h.a.x0.r<T>) f10452h;
    }

    public static <T, U> h.a.x0.o<T, U> c(U u2) {
        return new x(u2);
    }

    public static <T> h.a.x0.g<T> d() {
        return (h.a.x0.g<T>) f10448d;
    }

    public static <T> h.a.x0.o<T, T> e() {
        return (h.a.x0.o<T, T>) a;
    }

    public static <T> Comparator<T> f() {
        return a0.INSTANCE;
    }

    public static <T> Comparator<T> g() {
        return (Comparator<T>) f10455k;
    }

    public static <T> Callable<T> h() {
        return (Callable<T>) f10454j;
    }

    public static <T> Callable<T> b(T t2) {
        return new x(t2);
    }

    public static <T> Callable<Set<T>> c() {
        return v.INSTANCE;
    }

    public static <T1, T2, T3, R> h.a.x0.o<Object[], R> a(h.a.x0.h<T1, T2, T3, R> hVar) {
        h.a.y0.b.b.a(hVar, "f is null");
        return new c(hVar);
    }

    public static <T> h.a.x0.g<Throwable> b(h.a.x0.g<? super h.a.a0<T>> gVar) {
        return new d0(gVar);
    }

    public static <T> h.a.x0.g<T> c(h.a.x0.g<? super h.a.a0<T>> gVar) {
        return new e0(gVar);
    }

    public static <T, U> h.a.x0.r<T> b(Class<U> cls) {
        return new m(cls);
    }

    public static <T1, T2, T3, T4, R> h.a.x0.o<Object[], R> a(h.a.x0.i<T1, T2, T3, T4, R> iVar) {
        h.a.y0.b.b.a(iVar, "f is null");
        return new d(iVar);
    }

    public static <T1, T2, T3, T4, T5, R> h.a.x0.o<Object[], R> a(h.a.x0.j<T1, T2, T3, T4, T5, R> jVar) {
        h.a.y0.b.b.a(jVar, "f is null");
        return new e(jVar);
    }

    public static <T1, T2, T3, T4, T5, T6, R> h.a.x0.o<Object[], R> a(h.a.x0.k<T1, T2, T3, T4, T5, T6, R> kVar) {
        h.a.y0.b.b.a(kVar, "f is null");
        return new f(kVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> h.a.x0.o<Object[], R> a(h.a.x0.l<T1, T2, T3, T4, T5, T6, T7, R> lVar) {
        h.a.y0.b.b.a(lVar, "f is null");
        return new g(lVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> h.a.x0.o<Object[], R> a(h.a.x0.m<T1, T2, T3, T4, T5, T6, T7, T8, R> mVar) {
        h.a.y0.b.b.a(mVar, "f is null");
        return new h(mVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> h.a.x0.o<Object[], R> a(h.a.x0.n<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> nVar) {
        h.a.y0.b.b.a(nVar, "f is null");
        return new i(nVar);
    }

    public static <T> h.a.x0.r<T> a() {
        return (h.a.x0.r<T>) f10453i;
    }

    public static h.a.x0.a a(Future<?> future) {
        return new u(future);
    }

    public static <T, U> h.a.x0.o<T, U> a(Class<U> cls) {
        return new l(cls);
    }

    public static <T> Callable<List<T>> a(int i2) {
        return new j(i2);
    }

    public static <T> h.a.x0.r<T> a(T t2) {
        return new r(t2);
    }

    public static <T> h.a.x0.a a(h.a.x0.g<? super h.a.a0<T>> gVar) {
        return new c0(gVar);
    }

    public static <T> h.a.x0.g<T> a(h.a.x0.a aVar) {
        return new C0181a(aVar);
    }

    public static <T> h.a.x0.r<T> a(h.a.x0.e eVar) {
        return new k(eVar);
    }

    public static <T> h.a.x0.o<T, h.a.e1.c<T>> a(TimeUnit timeUnit, h.a.j0 j0Var) {
        return new h0(timeUnit, j0Var);
    }

    public static <T, K> h.a.x0.b<Map<K, T>, T> a(h.a.x0.o<? super T, ? extends K> oVar) {
        return new i0(oVar);
    }

    public static <T, K, V> h.a.x0.b<Map<K, V>, T> a(h.a.x0.o<? super T, ? extends K> oVar, h.a.x0.o<? super T, ? extends V> oVar2) {
        return new j0(oVar2, oVar);
    }

    public static <T, K, V> h.a.x0.b<Map<K, Collection<V>>, T> a(h.a.x0.o<? super T, ? extends K> oVar, h.a.x0.o<? super T, ? extends V> oVar2, h.a.x0.o<? super K, ? extends Collection<? super V>> oVar3) {
        return new k0(oVar3, oVar2, oVar);
    }

    public static <T> h.a.x0.o<List<T>, List<T>> a(Comparator<? super T> comparator) {
        return new y(comparator);
    }
}
