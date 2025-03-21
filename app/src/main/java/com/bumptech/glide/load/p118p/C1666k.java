package com.bumptech.glide.load.p118p;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.C1578d;
import com.bumptech.glide.EnumC1582h;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.load.InterfaceC1600n;
import com.bumptech.glide.load.p118p.C1671p;
import com.bumptech.glide.load.p118p.RunnableC1663h;
import com.bumptech.glide.load.p118p.p120b0.C1640b;
import com.bumptech.glide.load.p118p.p120b0.InterfaceC1639a;
import com.bumptech.glide.load.p118p.p120b0.InterfaceC1648j;
import com.bumptech.glide.load.p118p.p121c0.ExecutorServiceC1653a;
import com.bumptech.glide.p137r.InterfaceC1830i;
import com.bumptech.glide.util.C1870d;
import com.bumptech.glide.util.C1872f;
import com.bumptech.glide.util.C1876j;
import com.bumptech.glide.util.p141n.C1880a;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: Engine.java */
/* renamed from: com.bumptech.glide.load.p.k */
/* loaded from: classes.dex */
public class C1666k implements InterfaceC1668m, InterfaceC1648j.a, C1671p.a {

    /* renamed from: j */
    private static final int f4543j = 150;

    /* renamed from: a */
    private final C1674s f4545a;

    /* renamed from: b */
    private final C1670o f4546b;

    /* renamed from: c */
    private final InterfaceC1648j f4547c;

    /* renamed from: d */
    private final b f4548d;

    /* renamed from: e */
    private final C1680y f4549e;

    /* renamed from: f */
    private final c f4550f;

    /* renamed from: g */
    private final a f4551g;

    /* renamed from: h */
    private final C1621a f4552h;

    /* renamed from: i */
    private static final String f4542i = "Engine";

    /* renamed from: k */
    private static final boolean f4544k = Log.isLoggable(f4542i, 2);

    /* compiled from: Engine.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.p.k$a */
    static class a {

        /* renamed from: a */
        final RunnableC1663h.e f4553a;

        /* renamed from: b */
        final Pools.Pool<RunnableC1663h<?>> f4554b = C1880a.m5020b(150, new C7360a());

        /* renamed from: c */
        private int f4555c;

        /* compiled from: Engine.java */
        /* renamed from: com.bumptech.glide.load.p.k$a$a, reason: collision with other inner class name */
        class C7360a implements C1880a.d<RunnableC1663h<?>> {
            C7360a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.util.p141n.C1880a.d
            public RunnableC1663h<?> create() {
                a aVar = a.this;
                return new RunnableC1663h<>(aVar.f4553a, aVar.f4554b);
            }
        }

        a(RunnableC1663h.e eVar) {
            this.f4553a = eVar;
        }

        /* renamed from: a */
        <R> RunnableC1663h<R> m4155a(C1578d c1578d, Object obj, C1669n c1669n, InterfaceC1593g interfaceC1593g, int i2, int i3, Class<?> cls, Class<R> cls2, EnumC1582h enumC1582h, AbstractC1665j abstractC1665j, Map<Class<?>, InterfaceC1600n<?>> map, boolean z, boolean z2, boolean z3, C1596j c1596j, RunnableC1663h.b<R> bVar) {
            RunnableC1663h runnableC1663h = (RunnableC1663h) C1876j.m4985a(this.f4554b.acquire());
            int i4 = this.f4555c;
            this.f4555c = i4 + 1;
            return runnableC1663h.m4116a(c1578d, obj, c1669n, interfaceC1593g, i2, i3, cls, cls2, enumC1582h, abstractC1665j, map, z, z2, z3, c1596j, bVar, i4);
        }
    }

    /* compiled from: Engine.java */
    /* renamed from: com.bumptech.glide.load.p.k$c */
    private static class c implements RunnableC1663h.e {

        /* renamed from: a */
        private final InterfaceC1639a.a f4565a;

        /* renamed from: b */
        private volatile InterfaceC1639a f4566b;

        c(InterfaceC1639a.a aVar) {
            this.f4565a = aVar;
        }

        @Override // com.bumptech.glide.load.p118p.RunnableC1663h.e
        /* renamed from: a */
        public InterfaceC1639a mo4129a() {
            if (this.f4566b == null) {
                synchronized (this) {
                    if (this.f4566b == null) {
                        this.f4566b = this.f4565a.build();
                    }
                    if (this.f4566b == null) {
                        this.f4566b = new C1640b();
                    }
                }
            }
            return this.f4566b;
        }

        @VisibleForTesting
        /* renamed from: b */
        synchronized void m4158b() {
            if (this.f4566b == null) {
                return;
            }
            this.f4566b.clear();
        }
    }

    /* compiled from: Engine.java */
    /* renamed from: com.bumptech.glide.load.p.k$d */
    public class d {

        /* renamed from: a */
        private final C1667l<?> f4567a;

        /* renamed from: b */
        private final InterfaceC1830i f4568b;

        d(InterfaceC1830i interfaceC1830i, C1667l<?> c1667l) {
            this.f4568b = interfaceC1830i;
            this.f4567a = c1667l;
        }

        /* renamed from: a */
        public void m4159a() {
            synchronized (C1666k.this) {
                this.f4567a.m4171c(this.f4568b);
            }
        }
    }

    public C1666k(InterfaceC1648j interfaceC1648j, InterfaceC1639a.a aVar, ExecutorServiceC1653a executorServiceC1653a, ExecutorServiceC1653a executorServiceC1653a2, ExecutorServiceC1653a executorServiceC1653a3, ExecutorServiceC1653a executorServiceC1653a4, boolean z) {
        this(interfaceC1648j, aVar, executorServiceC1653a, executorServiceC1653a2, executorServiceC1653a3, executorServiceC1653a4, null, null, null, null, null, null, z);
    }

    @Nullable
    /* renamed from: b */
    private C1671p<?> m4146b(InterfaceC1593g interfaceC1593g) {
        C1671p<?> m3897b = this.f4552h.m3897b(interfaceC1593g);
        if (m3897b != null) {
            m3897b.m4185c();
        }
        return m3897b;
    }

    /* renamed from: c */
    private C1671p<?> m4147c(InterfaceC1593g interfaceC1593g) {
        C1671p<?> m4143a = m4143a(interfaceC1593g);
        if (m4143a != null) {
            m4143a.m4185c();
            this.f4552h.m3893a(interfaceC1593g, m4143a);
        }
        return m4143a;
    }

    /* renamed from: a */
    public <R> d m4148a(C1578d c1578d, Object obj, InterfaceC1593g interfaceC1593g, int i2, int i3, Class<?> cls, Class<R> cls2, EnumC1582h enumC1582h, AbstractC1665j abstractC1665j, Map<Class<?>, InterfaceC1600n<?>> map, boolean z, boolean z2, C1596j c1596j, boolean z3, boolean z4, boolean z5, boolean z6, InterfaceC1830i interfaceC1830i, Executor executor) {
        long m4970a = f4544k ? C1872f.m4970a() : 0L;
        C1669n m4182a = this.f4546b.m4182a(obj, interfaceC1593g, i2, i3, map, cls, cls2, c1596j);
        synchronized (this) {
            C1671p<?> m4144a = m4144a(m4182a, z3, m4970a);
            if (m4144a == null) {
                return m4142a(c1578d, obj, interfaceC1593g, i2, i3, cls, cls2, enumC1582h, abstractC1665j, map, z, z2, c1596j, z3, z4, z5, z6, interfaceC1830i, executor, m4182a, m4970a);
            }
            interfaceC1830i.mo4847a(m4144a, EnumC1587a.MEMORY_CACHE);
            return null;
        }
    }

    @VisibleForTesting
    C1666k(InterfaceC1648j interfaceC1648j, InterfaceC1639a.a aVar, ExecutorServiceC1653a executorServiceC1653a, ExecutorServiceC1653a executorServiceC1653a2, ExecutorServiceC1653a executorServiceC1653a3, ExecutorServiceC1653a executorServiceC1653a4, C1674s c1674s, C1670o c1670o, C1621a c1621a, b bVar, a aVar2, C1680y c1680y, boolean z) {
        this.f4547c = interfaceC1648j;
        this.f4550f = new c(aVar);
        C1621a c1621a2 = c1621a == null ? new C1621a(z) : c1621a;
        this.f4552h = c1621a2;
        c1621a2.m3896a(this);
        this.f4546b = c1670o == null ? new C1670o() : c1670o;
        this.f4545a = c1674s == null ? new C1674s() : c1674s;
        this.f4548d = bVar == null ? new b(executorServiceC1653a, executorServiceC1653a2, executorServiceC1653a3, executorServiceC1653a4, this, this) : bVar;
        this.f4551g = aVar2 == null ? new a(this.f4550f) : aVar2;
        this.f4549e = c1680y == null ? new C1680y() : c1680y;
        interfaceC1648j.mo3998a(this);
    }

    /* renamed from: b */
    public void m4154b(InterfaceC1677v<?> interfaceC1677v) {
        if (interfaceC1677v instanceof C1671p) {
            ((C1671p) interfaceC1677v).m4188f();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    /* compiled from: Engine.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.p.k$b */
    static class b {

        /* renamed from: a */
        final ExecutorServiceC1653a f4557a;

        /* renamed from: b */
        final ExecutorServiceC1653a f4558b;

        /* renamed from: c */
        final ExecutorServiceC1653a f4559c;

        /* renamed from: d */
        final ExecutorServiceC1653a f4560d;

        /* renamed from: e */
        final InterfaceC1668m f4561e;

        /* renamed from: f */
        final C1671p.a f4562f;

        /* renamed from: g */
        final Pools.Pool<C1667l<?>> f4563g = C1880a.m5020b(150, new a());

        /* compiled from: Engine.java */
        /* renamed from: com.bumptech.glide.load.p.k$b$a */
        class a implements C1880a.d<C1667l<?>> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.util.p141n.C1880a.d
            public C1667l<?> create() {
                b bVar = b.this;
                return new C1667l<>(bVar.f4557a, bVar.f4558b, bVar.f4559c, bVar.f4560d, bVar.f4561e, bVar.f4562f, bVar.f4563g);
            }
        }

        b(ExecutorServiceC1653a executorServiceC1653a, ExecutorServiceC1653a executorServiceC1653a2, ExecutorServiceC1653a executorServiceC1653a3, ExecutorServiceC1653a executorServiceC1653a4, InterfaceC1668m interfaceC1668m, C1671p.a aVar) {
            this.f4557a = executorServiceC1653a;
            this.f4558b = executorServiceC1653a2;
            this.f4559c = executorServiceC1653a3;
            this.f4560d = executorServiceC1653a4;
            this.f4561e = interfaceC1668m;
            this.f4562f = aVar;
        }

        @VisibleForTesting
        /* renamed from: a */
        void m4157a() {
            C1870d.m4967a(this.f4557a);
            C1870d.m4967a(this.f4558b);
            C1870d.m4967a(this.f4559c);
            C1870d.m4967a(this.f4560d);
        }

        /* renamed from: a */
        <R> C1667l<R> m4156a(InterfaceC1593g interfaceC1593g, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((C1667l) C1876j.m4985a(this.f4563g.acquire())).m4163a(interfaceC1593g, z, z2, z3, z4);
        }
    }

    @VisibleForTesting
    /* renamed from: b */
    public void m4153b() {
        this.f4548d.m4157a();
        this.f4550f.m4158b();
        this.f4552h.m3898b();
    }

    /* renamed from: a */
    private <R> d m4142a(C1578d c1578d, Object obj, InterfaceC1593g interfaceC1593g, int i2, int i3, Class<?> cls, Class<R> cls2, EnumC1582h enumC1582h, AbstractC1665j abstractC1665j, Map<Class<?>, InterfaceC1600n<?>> map, boolean z, boolean z2, C1596j c1596j, boolean z3, boolean z4, boolean z5, boolean z6, InterfaceC1830i interfaceC1830i, Executor executor, C1669n c1669n, long j2) {
        C1667l<?> m4197a = this.f4545a.m4197a(c1669n, z6);
        if (m4197a != null) {
            m4197a.m4167a(interfaceC1830i, executor);
            if (f4544k) {
                m4145a("Added to existing load", j2, c1669n);
            }
            return new d(interfaceC1830i, m4197a);
        }
        C1667l<R> m4156a = this.f4548d.m4156a(c1669n, z3, z4, z5, z6);
        RunnableC1663h<R> m4155a = this.f4551g.m4155a(c1578d, obj, c1669n, interfaceC1593g, i2, i3, cls, cls2, enumC1582h, abstractC1665j, map, z, z2, z6, c1596j, m4156a);
        this.f4545a.m4199a((InterfaceC1593g) c1669n, (C1667l<?>) m4156a);
        m4156a.m4167a(interfaceC1830i, executor);
        m4156a.m4169b(m4155a);
        if (f4544k) {
            m4145a("Started new load", j2, c1669n);
        }
        return new d(interfaceC1830i, m4156a);
    }

    @Nullable
    /* renamed from: a */
    private C1671p<?> m4144a(C1669n c1669n, boolean z, long j2) {
        if (!z) {
            return null;
        }
        C1671p<?> m4146b = m4146b(c1669n);
        if (m4146b != null) {
            if (f4544k) {
                m4145a("Loaded resource from active resources", j2, c1669n);
            }
            return m4146b;
        }
        C1671p<?> m4147c = m4147c(c1669n);
        if (m4147c == null) {
            return null;
        }
        if (f4544k) {
            m4145a("Loaded resource from cache", j2, c1669n);
        }
        return m4147c;
    }

    /* renamed from: a */
    private static void m4145a(String str, long j2, InterfaceC1593g interfaceC1593g) {
        String str2 = str + " in " + C1872f.m4969a(j2) + "ms, key: " + interfaceC1593g;
    }

    /* renamed from: a */
    private C1671p<?> m4143a(InterfaceC1593g interfaceC1593g) {
        InterfaceC1677v<?> mo3995a = this.f4547c.mo3995a(interfaceC1593g);
        if (mo3995a == null) {
            return null;
        }
        if (mo3995a instanceof C1671p) {
            return (C1671p) mo3995a;
        }
        return new C1671p<>(mo3995a, true, true, interfaceC1593g, this);
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1668m
    /* renamed from: a */
    public synchronized void mo4152a(C1667l<?> c1667l, InterfaceC1593g interfaceC1593g, C1671p<?> c1671p) {
        if (c1671p != null) {
            if (c1671p.m4187e()) {
                this.f4552h.m3893a(interfaceC1593g, c1671p);
            }
        }
        this.f4545a.m4200b(interfaceC1593g, c1667l);
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1668m
    /* renamed from: a */
    public synchronized void mo4151a(C1667l<?> c1667l, InterfaceC1593g interfaceC1593g) {
        this.f4545a.m4200b(interfaceC1593g, c1667l);
    }

    @Override // com.bumptech.glide.load.p118p.p120b0.InterfaceC1648j.a
    /* renamed from: a */
    public void mo4005a(@NonNull InterfaceC1677v<?> interfaceC1677v) {
        this.f4549e.m4210a(interfaceC1677v, true);
    }

    @Override // com.bumptech.glide.load.p118p.C1671p.a
    /* renamed from: a */
    public void mo4150a(InterfaceC1593g interfaceC1593g, C1671p<?> c1671p) {
        this.f4552h.m3892a(interfaceC1593g);
        if (c1671p.m4187e()) {
            this.f4547c.mo3996a(interfaceC1593g, c1671p);
        } else {
            this.f4549e.m4210a(c1671p, false);
        }
    }

    /* renamed from: a */
    public void m4149a() {
        this.f4550f.mo4129a().clear();
    }
}
