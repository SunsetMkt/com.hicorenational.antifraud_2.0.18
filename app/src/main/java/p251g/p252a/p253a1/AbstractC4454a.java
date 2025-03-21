package p251g.p252a.p253a1;

import com.heytap.mcssdk.constant.C2084a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p251g.p252a.C4453a0;
import p251g.p252a.p253a1.AbstractC4454a;
import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p270b.C4600a;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p284j.C5171k;
import p251g.p252a.p268y0.p284j.C5185y;

/* compiled from: BaseTestConsumer.java */
/* renamed from: g.a.a1.a */
/* loaded from: classes2.dex */
public abstract class AbstractC4454a<T, U extends AbstractC4454a<T, U>> implements InterfaceC4552c {

    /* renamed from: d */
    protected long f17195d;

    /* renamed from: e */
    protected Thread f17196e;

    /* renamed from: f */
    protected boolean f17197f;

    /* renamed from: g */
    protected int f17198g;

    /* renamed from: h */
    protected int f17199h;

    /* renamed from: i */
    protected CharSequence f17200i;

    /* renamed from: j */
    protected boolean f17201j;

    /* renamed from: b */
    protected final List<T> f17193b = new C5185y();

    /* renamed from: c */
    protected final List<Throwable> f17194c = new C5185y();

    /* renamed from: a */
    protected final CountDownLatch f17192a = new CountDownLatch(1);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: BaseTestConsumer.java */
    /* renamed from: g.a.a1.a$b */
    public static abstract class b implements Runnable {
        public static final b SPIN = new a("SPIN", 0);
        public static final b YIELD = new C7381b("YIELD", 1);
        public static final b SLEEP_1MS = new c("SLEEP_1MS", 2);
        public static final b SLEEP_10MS = new d("SLEEP_10MS", 3);
        public static final b SLEEP_100MS = new e("SLEEP_100MS", 4);
        public static final b SLEEP_1000MS = new f("SLEEP_1000MS", 5);

        /* renamed from: a */
        private static final /* synthetic */ b[] f17202a = {SPIN, YIELD, SLEEP_1MS, SLEEP_10MS, SLEEP_100MS, SLEEP_1000MS};

        /* compiled from: BaseTestConsumer.java */
        /* renamed from: g.a.a1.a$b$a */
        enum a extends b {
            a(String str, int i2) {
                super(str, i2);
            }

            @Override // p251g.p252a.p253a1.AbstractC4454a.b, java.lang.Runnable
            public void run() {
            }
        }

        /* compiled from: BaseTestConsumer.java */
        /* renamed from: g.a.a1.a$b$b, reason: collision with other inner class name */
        enum C7381b extends b {
            C7381b(String str, int i2) {
                super(str, i2);
            }

            @Override // p251g.p252a.p253a1.AbstractC4454a.b, java.lang.Runnable
            public void run() {
                Thread.yield();
            }
        }

        /* compiled from: BaseTestConsumer.java */
        /* renamed from: g.a.a1.a$b$c */
        enum c extends b {
            c(String str, int i2) {
                super(str, i2);
            }

            @Override // p251g.p252a.p253a1.AbstractC4454a.b, java.lang.Runnable
            public void run() {
                b.sleep(1);
            }
        }

        /* compiled from: BaseTestConsumer.java */
        /* renamed from: g.a.a1.a$b$d */
        enum d extends b {
            d(String str, int i2) {
                super(str, i2);
            }

            @Override // p251g.p252a.p253a1.AbstractC4454a.b, java.lang.Runnable
            public void run() {
                b.sleep(10);
            }
        }

        /* compiled from: BaseTestConsumer.java */
        /* renamed from: g.a.a1.a$b$e */
        enum e extends b {
            e(String str, int i2) {
                super(str, i2);
            }

            @Override // p251g.p252a.p253a1.AbstractC4454a.b, java.lang.Runnable
            public void run() {
                b.sleep(100);
            }
        }

        /* compiled from: BaseTestConsumer.java */
        /* renamed from: g.a.a1.a$b$f */
        enum f extends b {
            f(String str, int i2) {
                super(str, i2);
            }

            @Override // p251g.p252a.p253a1.AbstractC4454a.b, java.lang.Runnable
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
            return (b[]) f17202a.clone();
        }

        @Override // java.lang.Runnable
        public abstract void run();
    }

    /* renamed from: a */
    public final boolean m16462a(long j2, TimeUnit timeUnit) throws InterruptedException {
        boolean z = this.f17192a.getCount() == 0 || this.f17192a.await(j2, timeUnit);
        this.f17201j = !z;
        return z;
    }

    /* renamed from: b */
    protected final AssertionError m16469b(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 64);
        sb.append(str);
        sb.append(" (");
        sb.append("latch = ");
        sb.append(this.f17192a.getCount());
        sb.append(", ");
        sb.append("values = ");
        sb.append(this.f17193b.size());
        sb.append(", ");
        sb.append("errors = ");
        sb.append(this.f17194c.size());
        sb.append(", ");
        sb.append("completions = ");
        sb.append(this.f17195d);
        if (this.f17201j) {
            sb.append(", timeout!");
        }
        if (isDisposed()) {
            sb.append(", disposed!");
        }
        CharSequence charSequence = this.f17200i;
        if (charSequence != null) {
            sb.append(", tag = ");
            sb.append(charSequence);
        }
        sb.append(')');
        AssertionError assertionError = new AssertionError(sb.toString());
        if (!this.f17194c.isEmpty()) {
            if (this.f17194c.size() == 1) {
                assertionError.initCause(this.f17194c.get(0));
            } else {
                assertionError.initCause(new C4560a(this.f17194c));
            }
        }
        return assertionError;
    }

    /* renamed from: c */
    public final U m16470c() {
        if (this.f17194c.size() == 0) {
            return this;
        }
        throw m16469b("Error(s) present: " + this.f17194c);
    }

    /* renamed from: d */
    public final U m16474d() {
        if (this.f17201j) {
            throw m16469b("Timeout?!");
        }
        return this;
    }

    /* renamed from: e */
    public final U m16475e() {
        return m16445a(0);
    }

    /* renamed from: f */
    public final U m16476f() {
        long j2 = this.f17195d;
        if (j2 == 1) {
            throw m16469b("Completed!");
        }
        if (j2 <= 1) {
            return this;
        }
        throw m16469b("Multiple completions: " + j2);
    }

    /* renamed from: g */
    public abstract U mo16477g();

    /* renamed from: h */
    public final U m16478h() {
        if (this.f17192a.getCount() != 0) {
            return this;
        }
        throw m16469b("Subscriber terminated!");
    }

    /* renamed from: i */
    public abstract U mo16479i();

    /* renamed from: j */
    public final U m16480j() {
        if (this.f17192a.getCount() != 0) {
            throw m16469b("Subscriber still running!");
        }
        long j2 = this.f17195d;
        if (j2 > 1) {
            throw m16469b("Terminated with multiple completions: " + j2);
        }
        int size = this.f17194c.size();
        if (size > 1) {
            throw m16469b("Terminated with multiple errors: " + size);
        }
        if (j2 == 0 || size == 0) {
            return this;
        }
        throw m16469b("Terminated with multiple completions and errors: " + j2);
    }

    /* renamed from: k */
    public final U m16481k() {
        if (this.f17201j) {
            return this;
        }
        throw m16469b("No timeout?!");
    }

    /* renamed from: l */
    public final U m16482l() throws InterruptedException {
        if (this.f17192a.getCount() == 0) {
            return this;
        }
        this.f17192a.await();
        return this;
    }

    /* renamed from: m */
    public final boolean m16483m() {
        try {
            m16482l();
            return true;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    /* renamed from: n */
    public final U m16484n() {
        this.f17201j = false;
        return this;
    }

    /* renamed from: o */
    public final long m16485o() {
        return this.f17195d;
    }

    /* renamed from: p */
    public final int m16486p() {
        return this.f17194c.size();
    }

    /* renamed from: q */
    public final List<Throwable> m16487q() {
        return this.f17194c;
    }

    /* renamed from: r */
    public final List<List<Object>> m16488r() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(m16493w());
        arrayList.add(m16487q());
        ArrayList arrayList2 = new ArrayList();
        for (long j2 = 0; j2 < this.f17195d; j2++) {
            arrayList2.add(C4453a0.m16437f());
        }
        arrayList.add(arrayList2);
        return arrayList;
    }

    /* renamed from: s */
    public final boolean m16489s() {
        return this.f17192a.getCount() == 0;
    }

    /* renamed from: t */
    public final boolean m16490t() {
        return this.f17201j;
    }

    /* renamed from: u */
    public final Thread m16491u() {
        return this.f17196e;
    }

    /* renamed from: v */
    public final int m16492v() {
        return this.f17193b.size();
    }

    /* renamed from: w */
    public final List<T> m16493w() {
        return this.f17193b;
    }

    /* renamed from: a */
    public final U m16444a() {
        long j2 = this.f17195d;
        if (j2 == 0) {
            throw m16469b("Not completed");
        }
        if (j2 <= 1) {
            return this;
        }
        throw m16469b("Multiple completions: " + j2);
    }

    /* renamed from: c */
    public final U m16471c(InterfaceC4587r<T> interfaceC4587r) {
        m16446a(0, (InterfaceC4587r) interfaceC4587r);
        if (this.f17193b.size() <= 1) {
            return this;
        }
        throw m16469b("Value present but other values as well");
    }

    /* renamed from: c */
    public static String m16443c(Object obj) {
        if (obj == null) {
            return AbstractC1191a.f2571h;
        }
        return obj + " (class: " + obj.getClass().getSimpleName() + ")";
    }

    /* renamed from: a */
    public final U m16459a(Throwable th) {
        return m16450a(C4600a.m18248a(th));
    }

    /* renamed from: a */
    public final U m16453a(Class<? extends Throwable> cls) {
        return m16450a(C4600a.m18252b((Class) cls));
    }

    @InterfaceC4545e
    /* renamed from: c */
    public final U m16472c(T... tArr) {
        return (U) mo16479i().m16468b(tArr).m16470c().m16476f();
    }

    /* renamed from: a */
    public final U m16450a(InterfaceC4587r<Throwable> interfaceC4587r) {
        int size = this.f17194c.size();
        if (size != 0) {
            boolean z = false;
            Iterator<Throwable> it = this.f17194c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                try {
                    if (interfaceC4587r.test(it.next())) {
                        z = true;
                        break;
                    }
                } catch (Exception e2) {
                    throw C5171k.m18626c(e2);
                }
            }
            if (!z) {
                throw m16469b("Error not present");
            }
            if (size == 1) {
                return this;
            }
            throw m16469b("Error present but other errors as well");
        }
        throw m16469b("No errors");
    }

    /* renamed from: c */
    public final boolean m16473c(long j2, TimeUnit timeUnit) {
        try {
            return m16462a(j2, timeUnit);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    /* renamed from: a */
    public final U m16457a(T t) {
        int size = this.f17193b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (C4601b.m18285a(this.f17193b.get(i2), t)) {
                throw m16469b("Value at position " + i2 + " is equal to " + m16443c(t) + "; Expected them to be different");
            }
        }
        return this;
    }

    @InterfaceC4545e
    /* renamed from: a */
    public final U m16447a(int i2, T t) {
        int size = this.f17193b.size();
        if (size == 0) {
            throw m16469b("No values");
        }
        if (i2 < size) {
            T t2 = this.f17193b.get(i2);
            if (C4601b.m18285a(t, t2)) {
                return this;
            }
            throw m16469b("Expected: " + m16443c(t) + ", Actual: " + m16443c(t2));
        }
        throw m16469b("Invalid index: " + i2);
    }

    /* renamed from: b */
    public final U m16467b(T t) {
        if (this.f17193b.size() == 1) {
            T t2 = this.f17193b.get(0);
            if (C4601b.m18285a(t, t2)) {
                return this;
            }
            throw m16469b("Expected: " + m16443c(t) + ", Actual: " + m16443c(t2));
        }
        throw m16469b("Expected: " + m16443c(t) + ", Actual: " + this.f17193b);
    }

    /* renamed from: a */
    public final U m16446a(int i2, InterfaceC4587r<T> interfaceC4587r) {
        if (this.f17193b.size() != 0) {
            if (i2 < this.f17193b.size()) {
                try {
                    if (interfaceC4587r.test(this.f17193b.get(i2))) {
                        return this;
                    }
                    throw m16469b("Value not present");
                } catch (Exception e2) {
                    throw C5171k.m18626c(e2);
                }
            }
            throw m16469b("Invalid index: " + i2);
        }
        throw m16469b("No values");
    }

    /* renamed from: b */
    public final U m16466b(InterfaceC4587r<? super T> interfaceC4587r) {
        int size = this.f17193b.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                if (interfaceC4587r.test(this.f17193b.get(i2))) {
                    throw m16469b("Value at position " + i2 + " matches predicate " + interfaceC4587r.toString() + ", which was not expected.");
                }
            } catch (Exception e2) {
                throw C5171k.m18626c(e2);
            }
        }
        return this;
    }

    /* renamed from: a */
    public final U m16445a(int i2) {
        int size = this.f17193b.size();
        if (size == i2) {
            return this;
        }
        throw m16469b("Value counts differ; Expected: " + i2 + ", Actual: " + size);
    }

    /* renamed from: b */
    public final U m16468b(T... tArr) {
        int size = this.f17193b.size();
        if (size != tArr.length) {
            throw m16469b("Value count differs; Expected: " + tArr.length + AbstractC1191a.f2568g + Arrays.toString(tArr) + ", Actual: " + size + AbstractC1191a.f2568g + this.f17193b);
        }
        for (int i2 = 0; i2 < size; i2++) {
            T t = this.f17193b.get(i2);
            T t2 = tArr[i2];
            if (!C4601b.m18285a(t2, t)) {
                throw m16469b("Values at position " + i2 + " differ; Expected: " + m16443c(t2) + ", Actual: " + m16443c(t));
            }
        }
        return this;
    }

    /* renamed from: a */
    public final U m16460a(Collection<? extends T> collection) {
        if (collection.isEmpty()) {
            m16475e();
            return this;
        }
        for (T t : this.f17193b) {
            if (!collection.contains(t)) {
                throw m16469b("Value not in the expected collection: " + m16443c(t));
            }
        }
        return this;
    }

    /* renamed from: a */
    public final U m16456a(Iterable<? extends T> iterable) {
        boolean hasNext;
        boolean hasNext2;
        Iterator<T> it = this.f17193b.iterator();
        Iterator<? extends T> it2 = iterable.iterator();
        int i2 = 0;
        while (true) {
            hasNext = it2.hasNext();
            hasNext2 = it.hasNext();
            if (!hasNext2 || !hasNext) {
                break;
            }
            T next = it2.next();
            T next2 = it.next();
            if (!C4601b.m18285a(next, next2)) {
                throw m16469b("Values at position " + i2 + " differ; Expected: " + m16443c(next) + ", Actual: " + m16443c(next2));
            }
            i2++;
        }
        if (hasNext2) {
            throw m16469b("More values received than expected (" + i2 + ")");
        }
        if (!hasNext) {
            return this;
        }
        throw m16469b("Fewer values received than expected (" + i2 + ")");
    }

    /* renamed from: b */
    public final U m16465b(long j2, TimeUnit timeUnit) {
        try {
            if (!this.f17192a.await(j2, timeUnit)) {
                this.f17201j = true;
                dispose();
            }
            return this;
        } catch (InterruptedException e2) {
            dispose();
            throw C5171k.m18626c(e2);
        }
    }

    /* renamed from: b */
    public final U m16463b() {
        return (U) mo16479i().m16475e().m16470c().m16476f();
    }

    /* renamed from: b */
    public final U m16464b(int i2) {
        return m16449a(i2, b.SLEEP_10MS, C2084a.f6136r);
    }

    /* renamed from: a */
    public final U m16458a(String str) {
        int size = this.f17194c.size();
        if (size == 0) {
            throw m16469b("No errors");
        }
        if (size == 1) {
            String message = this.f17194c.get(0).getMessage();
            if (C4601b.m18285a((Object) str, (Object) message)) {
                return this;
            }
            throw m16469b("Error message differs; Expected: " + str + ", Actual: " + message);
        }
        throw m16469b("Multiple errors");
    }

    /* renamed from: a */
    public final U m16461a(T... tArr) {
        return (U) mo16479i().m16468b(tArr).m16470c().m16444a();
    }

    /* renamed from: a */
    public final U m16455a(Class<? extends Throwable> cls, T... tArr) {
        return (U) mo16479i().m16468b(tArr).m16453a(cls).m16476f();
    }

    /* renamed from: a */
    public final U m16451a(InterfaceC4587r<Throwable> interfaceC4587r, T... tArr) {
        return (U) mo16479i().m16468b(tArr).m16450a(interfaceC4587r).m16476f();
    }

    /* renamed from: a */
    public final U m16454a(Class<? extends Throwable> cls, String str, T... tArr) {
        return (U) mo16479i().m16468b(tArr).m16453a(cls).m16458a(str).m16476f();
    }

    /* renamed from: a */
    public final U m16452a(CharSequence charSequence) {
        this.f17200i = charSequence;
        return this;
    }

    /* renamed from: a */
    public final U m16448a(int i2, Runnable runnable) {
        return m16449a(i2, runnable, C2084a.f6136r);
    }

    /* renamed from: a */
    public final U m16449a(int i2, Runnable runnable, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            if (j2 > 0 && System.currentTimeMillis() - currentTimeMillis >= j2) {
                this.f17201j = true;
                break;
            }
            if (this.f17192a.getCount() == 0 || this.f17193b.size() >= i2) {
                break;
            }
            runnable.run();
        }
        return this;
    }
}
