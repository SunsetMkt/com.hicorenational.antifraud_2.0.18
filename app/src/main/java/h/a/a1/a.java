package h.a.a1;

import h.a.a0;
import h.a.a1.a;
import h.a.x0.r;
import h.a.y0.j.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: BaseTestConsumer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T, U extends a<T, U>> implements h.a.u0.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected long f10230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Thread f10231e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f10232f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f10233g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f10234h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected CharSequence f10235i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected boolean f10236j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final List<T> f10228b = new y();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final List<Throwable> f10229c = new y();
    protected final CountDownLatch a = new CountDownLatch(1);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: BaseTestConsumer.java */
    public static abstract class b implements Runnable {
        public static final b SPIN = new C0169a("SPIN", 0);
        public static final b YIELD = new C0170b("YIELD", 1);
        public static final b SLEEP_1MS = new c("SLEEP_1MS", 2);
        public static final b SLEEP_10MS = new d("SLEEP_10MS", 3);
        public static final b SLEEP_100MS = new e("SLEEP_100MS", 4);
        public static final b SLEEP_1000MS = new f("SLEEP_1000MS", 5);
        private static final /* synthetic */ b[] a = {SPIN, YIELD, SLEEP_1MS, SLEEP_10MS, SLEEP_100MS, SLEEP_1000MS};

        /* JADX INFO: renamed from: h.a.a1.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BaseTestConsumer.java */
        enum C0169a extends b {
            C0169a(String str, int i2) {
                super(str, i2);
            }

            @Override // h.a.a1.a.b, java.lang.Runnable
            public void run() {
            }
        }

        /* JADX INFO: renamed from: h.a.a1.a$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BaseTestConsumer.java */
        enum C0170b extends b {
            C0170b(String str, int i2) {
                super(str, i2);
            }

            @Override // h.a.a1.a.b, java.lang.Runnable
            public void run() {
                Thread.yield();
            }
        }

        /* JADX INFO: compiled from: BaseTestConsumer.java */
        enum c extends b {
            c(String str, int i2) {
                super(str, i2);
            }

            @Override // h.a.a1.a.b, java.lang.Runnable
            public void run() {
                b.sleep(1);
            }
        }

        /* JADX INFO: compiled from: BaseTestConsumer.java */
        enum d extends b {
            d(String str, int i2) {
                super(str, i2);
            }

            @Override // h.a.a1.a.b, java.lang.Runnable
            public void run() {
                b.sleep(10);
            }
        }

        /* JADX INFO: compiled from: BaseTestConsumer.java */
        enum e extends b {
            e(String str, int i2) {
                super(str, i2);
            }

            @Override // h.a.a1.a.b, java.lang.Runnable
            public void run() {
                b.sleep(100);
            }
        }

        /* JADX INFO: compiled from: BaseTestConsumer.java */
        enum f extends b {
            f(String str, int i2) {
                super(str, i2);
            }

            @Override // h.a.a1.a.b, java.lang.Runnable
            public void run() {
                b.sleep(1000);
            }
        }

        private b(String str, int i2) {
        }

        static void sleep(int i2) {
            try {
                Thread.sleep(i2);
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
            }
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) a.clone();
        }

        @Override // java.lang.Runnable
        public abstract void run();
    }

    public final boolean a(long j2, TimeUnit timeUnit) throws InterruptedException {
        boolean z = this.a.getCount() == 0 || this.a.await(j2, timeUnit);
        this.f10236j = !z;
        return z;
    }

    protected final AssertionError b(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 64);
        sb.append(str);
        sb.append(" (");
        sb.append("latch = ");
        sb.append(this.a.getCount());
        sb.append(", ");
        sb.append("values = ");
        sb.append(this.f10228b.size());
        sb.append(", ");
        sb.append("errors = ");
        sb.append(this.f10229c.size());
        sb.append(", ");
        sb.append("completions = ");
        sb.append(this.f10230d);
        if (this.f10236j) {
            sb.append(", timeout!");
        }
        if (isDisposed()) {
            sb.append(", disposed!");
        }
        CharSequence charSequence = this.f10235i;
        if (charSequence != null) {
            sb.append(", tag = ");
            sb.append(charSequence);
        }
        sb.append(')');
        AssertionError assertionError = new AssertionError(sb.toString());
        if (!this.f10229c.isEmpty()) {
            if (this.f10229c.size() == 1) {
                assertionError.initCause(this.f10229c.get(0));
            } else {
                assertionError.initCause(new h.a.v0.a(this.f10229c));
            }
        }
        return assertionError;
    }

    public final U c() {
        if (this.f10229c.size() == 0) {
            return this;
        }
        throw b("Error(s) present: " + this.f10229c);
    }

    public final U d() {
        if (this.f10236j) {
            throw b("Timeout?!");
        }
        return this;
    }

    public final U e() {
        return (U) a(0);
    }

    public final U f() {
        long j2 = this.f10230d;
        if (j2 == 1) {
            throw b("Completed!");
        }
        if (j2 <= 1) {
            return this;
        }
        throw b("Multiple completions: " + j2);
    }

    public abstract U g();

    public final U h() {
        if (this.a.getCount() != 0) {
            return this;
        }
        throw b("Subscriber terminated!");
    }

    public abstract U i();

    public final U j() {
        if (this.a.getCount() != 0) {
            throw b("Subscriber still running!");
        }
        long j2 = this.f10230d;
        if (j2 > 1) {
            throw b("Terminated with multiple completions: " + j2);
        }
        int size = this.f10229c.size();
        if (size > 1) {
            throw b("Terminated with multiple errors: " + size);
        }
        if (j2 == 0 || size == 0) {
            return this;
        }
        throw b("Terminated with multiple completions and errors: " + j2);
    }

    public final U k() {
        if (this.f10236j) {
            return this;
        }
        throw b("No timeout?!");
    }

    public final U l() throws InterruptedException {
        if (this.a.getCount() == 0) {
            return this;
        }
        this.a.await();
        return this;
    }

    public final boolean m() {
        try {
            l();
            return true;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final U n() {
        this.f10236j = false;
        return this;
    }

    public final long o() {
        return this.f10230d;
    }

    public final int p() {
        return this.f10229c.size();
    }

    public final List<Throwable> q() {
        return this.f10229c;
    }

    public final List<List<Object>> r() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(w());
        arrayList.add(q());
        ArrayList arrayList2 = new ArrayList();
        for (long j2 = 0; j2 < this.f10230d; j2++) {
            arrayList2.add(a0.f());
        }
        arrayList.add(arrayList2);
        return arrayList;
    }

    public final boolean s() {
        return this.a.getCount() == 0;
    }

    public final boolean t() {
        return this.f10236j;
    }

    public final Thread u() {
        return this.f10231e;
    }

    public final int v() {
        return this.f10228b.size();
    }

    public final List<T> w() {
        return this.f10228b;
    }

    public final U a() {
        long j2 = this.f10230d;
        if (j2 == 0) {
            throw b("Not completed");
        }
        if (j2 <= 1) {
            return this;
        }
        throw b("Multiple completions: " + j2);
    }

    public final U c(r<T> rVar) {
        a(0, (r) rVar);
        if (this.f10228b.size() <= 1) {
            return this;
        }
        throw b("Value present but other values as well");
    }

    public static String c(Object obj) {
        if (obj == null) {
            return d.c.a.b.a.a.f10075h;
        }
        return obj + " (class: " + obj.getClass().getSimpleName() + ")";
    }

    public final U a(Throwable th) {
        return (U) a(h.a.y0.b.a.a(th));
    }

    public final U a(Class<? extends Throwable> cls) {
        return (U) a(h.a.y0.b.a.b((Class) cls));
    }

    @h.a.t0.e
    public final U c(T... tArr) {
        return (U) i().b((Object[]) tArr).c().f();
    }

    public final U a(r<Throwable> rVar) {
        int size = this.f10229c.size();
        if (size != 0) {
            boolean z = false;
            Iterator<Throwable> it = this.f10229c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                try {
                    if (rVar.test(it.next())) {
                        z = true;
                        break;
                    }
                } catch (Exception e2) {
                    throw h.a.y0.j.k.c(e2);
                }
            }
            if (!z) {
                throw b("Error not present");
            }
            if (size == 1) {
                return this;
            }
            throw b("Error present but other errors as well");
        }
        throw b("No errors");
    }

    public final boolean c(long j2, TimeUnit timeUnit) {
        try {
            return a(j2, timeUnit);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final U a(T t) {
        int size = this.f10228b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (h.a.y0.b.b.a(this.f10228b.get(i2), t)) {
                throw b("Value at position " + i2 + " is equal to " + c(t) + "; Expected them to be different");
            }
        }
        return this;
    }

    @h.a.t0.e
    public final U a(int i2, T t) {
        int size = this.f10228b.size();
        if (size == 0) {
            throw b("No values");
        }
        if (i2 < size) {
            T t2 = this.f10228b.get(i2);
            if (h.a.y0.b.b.a(t, t2)) {
                return this;
            }
            throw b("Expected: " + c(t) + ", Actual: " + c(t2));
        }
        throw b("Invalid index: " + i2);
    }

    public final U b(T t) {
        if (this.f10228b.size() == 1) {
            T t2 = this.f10228b.get(0);
            if (h.a.y0.b.b.a(t, t2)) {
                return this;
            }
            throw b("Expected: " + c(t) + ", Actual: " + c(t2));
        }
        throw b("Expected: " + c(t) + ", Actual: " + this.f10228b);
    }

    public final U a(int i2, r<T> rVar) {
        if (this.f10228b.size() != 0) {
            if (i2 < this.f10228b.size()) {
                try {
                    if (rVar.test(this.f10228b.get(i2))) {
                        return this;
                    }
                    throw b("Value not present");
                } catch (Exception e2) {
                    throw h.a.y0.j.k.c(e2);
                }
            }
            throw b("Invalid index: " + i2);
        }
        throw b("No values");
    }

    public final U b(r<? super T> rVar) {
        int size = this.f10228b.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                if (rVar.test(this.f10228b.get(i2))) {
                    throw b("Value at position " + i2 + " matches predicate " + rVar.toString() + ", which was not expected.");
                }
            } catch (Exception e2) {
                throw h.a.y0.j.k.c(e2);
            }
        }
        return this;
    }

    public final U a(int i2) {
        int size = this.f10228b.size();
        if (size == i2) {
            return this;
        }
        throw b("Value counts differ; Expected: " + i2 + ", Actual: " + size);
    }

    public final U b(T... tArr) {
        int size = this.f10228b.size();
        if (size != tArr.length) {
            throw b("Value count differs; Expected: " + tArr.length + d.c.a.b.a.a.f10074g + Arrays.toString(tArr) + ", Actual: " + size + d.c.a.b.a.a.f10074g + this.f10228b);
        }
        for (int i2 = 0; i2 < size; i2++) {
            T t = this.f10228b.get(i2);
            T t2 = tArr[i2];
            if (!h.a.y0.b.b.a(t2, t)) {
                throw b("Values at position " + i2 + " differ; Expected: " + c(t2) + ", Actual: " + c(t));
            }
        }
        return this;
    }

    public final U a(Collection<? extends T> collection) {
        if (collection.isEmpty()) {
            e();
            return this;
        }
        for (T t : this.f10228b) {
            if (!collection.contains(t)) {
                throw b("Value not in the expected collection: " + c(t));
            }
        }
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0059, code lost:
    
        if (r3 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005b, code lost:
    
        if (r2 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005d, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0076, code lost:
    
        throw b("Fewer values received than expected (" + r1 + ")");
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008f, code lost:
    
        throw b("More values received than expected (" + r1 + ")");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final U a(Iterable<? extends T> iterable) {
        Iterator<T> it = this.f10228b.iterator();
        Iterator<? extends T> it2 = iterable.iterator();
        int i2 = 0;
        while (true) {
            boolean zHasNext = it2.hasNext();
            boolean zHasNext2 = it.hasNext();
            if (!zHasNext2 || !zHasNext) {
                break;
            }
            T next = it2.next();
            T next2 = it.next();
            if (!h.a.y0.b.b.a(next, next2)) {
                throw b("Values at position " + i2 + " differ; Expected: " + c(next) + ", Actual: " + c(next2));
            }
            i2++;
        }
    }

    public final U b(long j2, TimeUnit timeUnit) {
        try {
            if (!this.a.await(j2, timeUnit)) {
                this.f10236j = true;
                dispose();
            }
            return this;
        } catch (InterruptedException e2) {
            dispose();
            throw h.a.y0.j.k.c(e2);
        }
    }

    public final U b() {
        return (U) i().e().c().f();
    }

    public final U b(int i2) {
        return (U) a(i2, b.SLEEP_10MS, com.heytap.mcssdk.constant.a.r);
    }

    public final U a(String str) {
        int size = this.f10229c.size();
        if (size == 0) {
            throw b("No errors");
        }
        if (size == 1) {
            String message = this.f10229c.get(0).getMessage();
            if (h.a.y0.b.b.a((Object) str, (Object) message)) {
                return this;
            }
            throw b("Error message differs; Expected: " + str + ", Actual: " + message);
        }
        throw b("Multiple errors");
    }

    public final U a(T... tArr) {
        return (U) i().b((Object[]) tArr).c().a();
    }

    public final U a(Class<? extends Throwable> cls, T... tArr) {
        return (U) i().b((Object[]) tArr).a(cls).f();
    }

    public final U a(r<Throwable> rVar, T... tArr) {
        return (U) i().b((Object[]) tArr).a(rVar).f();
    }

    public final U a(Class<? extends Throwable> cls, String str, T... tArr) {
        return (U) i().b((Object[]) tArr).a(cls).a(str).f();
    }

    public final U a(CharSequence charSequence) {
        this.f10235i = charSequence;
        return this;
    }

    public final U a(int i2, Runnable runnable) {
        return (U) a(i2, runnable, com.heytap.mcssdk.constant.a.r);
    }

    public final U a(int i2, Runnable runnable, long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        while (true) {
            if (j2 > 0 && System.currentTimeMillis() - jCurrentTimeMillis >= j2) {
                this.f10236j = true;
                break;
            }
            if (this.a.getCount() == 0 || this.f10228b.size() >= i2) {
                break;
            }
            runnable.run();
        }
        return this;
    }
}
