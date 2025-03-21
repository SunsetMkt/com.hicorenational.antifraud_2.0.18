package com.bumptech.glide.load.p118p;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.p118p.C1671p;
import com.bumptech.glide.load.p118p.RunnableC1663h;
import com.bumptech.glide.load.p118p.p121c0.ExecutorServiceC1653a;
import com.bumptech.glide.p137r.InterfaceC1830i;
import com.bumptech.glide.util.C1870d;
import com.bumptech.glide.util.C1876j;
import com.bumptech.glide.util.p141n.AbstractC1882c;
import com.bumptech.glide.util.p141n.C1880a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: EngineJob.java */
/* renamed from: com.bumptech.glide.load.p.l */
/* loaded from: classes.dex */
class C1667l<R> implements RunnableC1663h.b<R>, C1880a.f {

    /* renamed from: y */
    private static final c f4570y = new c();

    /* renamed from: a */
    final e f4571a;

    /* renamed from: b */
    private final AbstractC1882c f4572b;

    /* renamed from: c */
    private final C1671p.a f4573c;

    /* renamed from: d */
    private final Pools.Pool<C1667l<?>> f4574d;

    /* renamed from: e */
    private final c f4575e;

    /* renamed from: f */
    private final InterfaceC1668m f4576f;

    /* renamed from: g */
    private final ExecutorServiceC1653a f4577g;

    /* renamed from: h */
    private final ExecutorServiceC1653a f4578h;

    /* renamed from: i */
    private final ExecutorServiceC1653a f4579i;

    /* renamed from: j */
    private final ExecutorServiceC1653a f4580j;

    /* renamed from: k */
    private final AtomicInteger f4581k;

    /* renamed from: l */
    private InterfaceC1593g f4582l;

    /* renamed from: m */
    private boolean f4583m;

    /* renamed from: n */
    private boolean f4584n;

    /* renamed from: o */
    private boolean f4585o;

    /* renamed from: p */
    private boolean f4586p;

    /* renamed from: q */
    private InterfaceC1677v<?> f4587q;

    /* renamed from: r */
    EnumC1587a f4588r;

    /* renamed from: s */
    private boolean f4589s;

    /* renamed from: t */
    C1672q f4590t;

    /* renamed from: u */
    private boolean f4591u;

    /* renamed from: v */
    C1671p<?> f4592v;

    /* renamed from: w */
    private RunnableC1663h<R> f4593w;

    /* renamed from: x */
    private volatile boolean f4594x;

    /* compiled from: EngineJob.java */
    /* renamed from: com.bumptech.glide.load.p.l$a */
    private class a implements Runnable {

        /* renamed from: a */
        private final InterfaceC1830i f4595a;

        a(InterfaceC1830i interfaceC1830i) {
            this.f4595a = interfaceC1830i;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f4595a.mo4848e()) {
                synchronized (C1667l.this) {
                    if (C1667l.this.f4571a.m4180a(this.f4595a)) {
                        C1667l.this.m4166a(this.f4595a);
                    }
                    C1667l.this.m4168b();
                }
            }
        }
    }

    /* compiled from: EngineJob.java */
    /* renamed from: com.bumptech.glide.load.p.l$b */
    private class b implements Runnable {

        /* renamed from: a */
        private final InterfaceC1830i f4597a;

        b(InterfaceC1830i interfaceC1830i) {
            this.f4597a = interfaceC1830i;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f4597a.mo4848e()) {
                synchronized (C1667l.this) {
                    if (C1667l.this.f4571a.m4180a(this.f4597a)) {
                        C1667l.this.f4592v.m4185c();
                        C1667l.this.m4170b(this.f4597a);
                        C1667l.this.m4171c(this.f4597a);
                    }
                    C1667l.this.m4168b();
                }
            }
        }
    }

    /* compiled from: EngineJob.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.p.l$c */
    static class c {
        c() {
        }

        /* renamed from: a */
        public <R> C1671p<R> m4176a(InterfaceC1677v<R> interfaceC1677v, boolean z, InterfaceC1593g interfaceC1593g, C1671p.a aVar) {
            return new C1671p<>(interfaceC1677v, z, true, interfaceC1593g, aVar);
        }
    }

    /* compiled from: EngineJob.java */
    /* renamed from: com.bumptech.glide.load.p.l$d */
    static final class d {

        /* renamed from: a */
        final InterfaceC1830i f4599a;

        /* renamed from: b */
        final Executor f4600b;

        d(InterfaceC1830i interfaceC1830i, Executor executor) {
            this.f4599a = interfaceC1830i;
            this.f4600b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f4599a.equals(((d) obj).f4599a);
            }
            return false;
        }

        public int hashCode() {
            return this.f4599a.hashCode();
        }
    }

    /* compiled from: EngineJob.java */
    /* renamed from: com.bumptech.glide.load.p.l$e */
    static final class e implements Iterable<d> {

        /* renamed from: a */
        private final List<d> f4601a;

        e() {
            this(new ArrayList(2));
        }

        /* renamed from: c */
        private static d m4177c(InterfaceC1830i interfaceC1830i) {
            return new d(interfaceC1830i, C1870d.m4966a());
        }

        /* renamed from: a */
        void m4179a(InterfaceC1830i interfaceC1830i, Executor executor) {
            this.f4601a.add(new d(interfaceC1830i, executor));
        }

        /* renamed from: b */
        void m4181b(InterfaceC1830i interfaceC1830i) {
            this.f4601a.remove(m4177c(interfaceC1830i));
        }

        void clear() {
            this.f4601a.clear();
        }

        boolean isEmpty() {
            return this.f4601a.isEmpty();
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<d> iterator() {
            return this.f4601a.iterator();
        }

        int size() {
            return this.f4601a.size();
        }

        e(List<d> list) {
            this.f4601a = list;
        }

        /* renamed from: a */
        boolean m4180a(InterfaceC1830i interfaceC1830i) {
            return this.f4601a.contains(m4177c(interfaceC1830i));
        }

        /* renamed from: a */
        e m4178a() {
            return new e(new ArrayList(this.f4601a));
        }
    }

    C1667l(ExecutorServiceC1653a executorServiceC1653a, ExecutorServiceC1653a executorServiceC1653a2, ExecutorServiceC1653a executorServiceC1653a3, ExecutorServiceC1653a executorServiceC1653a4, InterfaceC1668m interfaceC1668m, C1671p.a aVar, Pools.Pool<C1667l<?>> pool) {
        this(executorServiceC1653a, executorServiceC1653a2, executorServiceC1653a3, executorServiceC1653a4, interfaceC1668m, aVar, pool, f4570y);
    }

    /* renamed from: h */
    private ExecutorServiceC1653a m4160h() {
        return this.f4584n ? this.f4579i : this.f4585o ? this.f4580j : this.f4578h;
    }

    /* renamed from: i */
    private boolean m4161i() {
        return this.f4591u || this.f4589s || this.f4594x;
    }

    /* renamed from: j */
    private synchronized void m4162j() {
        if (this.f4582l == null) {
            throw new IllegalArgumentException();
        }
        this.f4571a.clear();
        this.f4582l = null;
        this.f4592v = null;
        this.f4587q = null;
        this.f4591u = false;
        this.f4594x = false;
        this.f4589s = false;
        this.f4593w.m4119a(false);
        this.f4593w = null;
        this.f4590t = null;
        this.f4588r = null;
        this.f4574d.release(this);
    }

    @VisibleForTesting
    /* renamed from: a */
    synchronized C1667l<R> m4163a(InterfaceC1593g interfaceC1593g, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f4582l = interfaceC1593g;
        this.f4583m = z;
        this.f4584n = z2;
        this.f4585o = z3;
        this.f4586p = z4;
        return this;
    }

    /* renamed from: b */
    public synchronized void m4169b(RunnableC1663h<R> runnableC1663h) {
        this.f4593w = runnableC1663h;
        (runnableC1663h.m4120d() ? this.f4577g : m4160h()).execute(runnableC1663h);
    }

    /* renamed from: c */
    synchronized void m4171c(InterfaceC1830i interfaceC1830i) {
        boolean z;
        this.f4572b.mo5030a();
        this.f4571a.m4181b(interfaceC1830i);
        if (this.f4571a.isEmpty()) {
            m4164a();
            if (!this.f4589s && !this.f4591u) {
                z = false;
                if (z && this.f4581k.get() == 0) {
                    m4162j();
                }
            }
            z = true;
            if (z) {
                m4162j();
            }
        }
    }

    /* renamed from: d */
    synchronized boolean m4172d() {
        return this.f4594x;
    }

    /* renamed from: e */
    void m4173e() {
        synchronized (this) {
            this.f4572b.mo5030a();
            if (this.f4594x) {
                m4162j();
                return;
            }
            if (this.f4571a.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            if (this.f4591u) {
                throw new IllegalStateException("Already failed once");
            }
            this.f4591u = true;
            InterfaceC1593g interfaceC1593g = this.f4582l;
            e m4178a = this.f4571a.m4178a();
            m4165a(m4178a.size() + 1);
            this.f4576f.mo4152a(this, interfaceC1593g, null);
            Iterator<d> it = m4178a.iterator();
            while (it.hasNext()) {
                d next = it.next();
                next.f4600b.execute(new a(next.f4599a));
            }
            m4168b();
        }
    }

    /* renamed from: f */
    void m4174f() {
        synchronized (this) {
            this.f4572b.mo5030a();
            if (this.f4594x) {
                this.f4587q.recycle();
                m4162j();
                return;
            }
            if (this.f4571a.isEmpty()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
            if (this.f4589s) {
                throw new IllegalStateException("Already have resource");
            }
            this.f4592v = this.f4575e.m4176a(this.f4587q, this.f4583m, this.f4582l, this.f4573c);
            this.f4589s = true;
            e m4178a = this.f4571a.m4178a();
            m4165a(m4178a.size() + 1);
            this.f4576f.mo4152a(this, this.f4582l, this.f4592v);
            Iterator<d> it = m4178a.iterator();
            while (it.hasNext()) {
                d next = it.next();
                next.f4600b.execute(new b(next.f4599a));
            }
            m4168b();
        }
    }

    /* renamed from: g */
    boolean m4175g() {
        return this.f4586p;
    }

    @VisibleForTesting
    C1667l(ExecutorServiceC1653a executorServiceC1653a, ExecutorServiceC1653a executorServiceC1653a2, ExecutorServiceC1653a executorServiceC1653a3, ExecutorServiceC1653a executorServiceC1653a4, InterfaceC1668m interfaceC1668m, C1671p.a aVar, Pools.Pool<C1667l<?>> pool, c cVar) {
        this.f4571a = new e();
        this.f4572b = AbstractC1882c.m5029b();
        this.f4581k = new AtomicInteger();
        this.f4577g = executorServiceC1653a;
        this.f4578h = executorServiceC1653a2;
        this.f4579i = executorServiceC1653a3;
        this.f4580j = executorServiceC1653a4;
        this.f4576f = interfaceC1668m;
        this.f4573c = aVar;
        this.f4574d = pool;
        this.f4575e = cVar;
    }

    @GuardedBy("this")
    /* renamed from: b */
    void m4170b(InterfaceC1830i interfaceC1830i) {
        try {
            interfaceC1830i.mo4847a(this.f4592v, this.f4588r);
        } catch (Throwable th) {
            throw new C1638b(th);
        }
    }

    /* renamed from: a */
    synchronized void m4167a(InterfaceC1830i interfaceC1830i, Executor executor) {
        this.f4572b.mo5030a();
        this.f4571a.m4179a(interfaceC1830i, executor);
        boolean z = true;
        if (this.f4589s) {
            m4165a(1);
            executor.execute(new b(interfaceC1830i));
        } else if (this.f4591u) {
            m4165a(1);
            executor.execute(new a(interfaceC1830i));
        } else {
            if (this.f4594x) {
                z = false;
            }
            C1876j.m4989a(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    /* renamed from: b */
    void m4168b() {
        C1671p<?> c1671p;
        synchronized (this) {
            this.f4572b.mo5030a();
            C1876j.m4989a(m4161i(), "Not yet complete!");
            int decrementAndGet = this.f4581k.decrementAndGet();
            C1876j.m4989a(decrementAndGet >= 0, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                c1671p = this.f4592v;
                m4162j();
            } else {
                c1671p = null;
            }
        }
        if (c1671p != null) {
            c1671p.m4188f();
        }
    }

    @Override // com.bumptech.glide.util.p141n.C1880a.f
    @NonNull
    /* renamed from: c */
    public AbstractC1882c mo4024c() {
        return this.f4572b;
    }

    @GuardedBy("this")
    /* renamed from: a */
    void m4166a(InterfaceC1830i interfaceC1830i) {
        try {
            interfaceC1830i.mo4846a(this.f4590t);
        } catch (Throwable th) {
            throw new C1638b(th);
        }
    }

    /* renamed from: a */
    void m4164a() {
        if (m4161i()) {
            return;
        }
        this.f4594x = true;
        this.f4593w.m4118a();
        this.f4576f.mo4151a(this, this.f4582l);
    }

    /* renamed from: a */
    synchronized void m4165a(int i2) {
        C1876j.m4989a(m4161i(), "Not yet complete!");
        if (this.f4581k.getAndAdd(i2) == 0 && this.f4592v != null) {
            this.f4592v.m4185c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.p118p.RunnableC1663h.b
    /* renamed from: a */
    public void mo4123a(InterfaceC1677v<R> interfaceC1677v, EnumC1587a enumC1587a) {
        synchronized (this) {
            this.f4587q = interfaceC1677v;
            this.f4588r = enumC1587a;
        }
        m4174f();
    }

    @Override // com.bumptech.glide.load.p118p.RunnableC1663h.b
    /* renamed from: a */
    public void mo4122a(C1672q c1672q) {
        synchronized (this) {
            this.f4590t = c1672q;
        }
        m4173e();
    }

    @Override // com.bumptech.glide.load.p118p.RunnableC1663h.b
    /* renamed from: a */
    public void mo4121a(RunnableC1663h<?> runnableC1663h) {
        m4160h().execute(runnableC1663h);
    }
}
