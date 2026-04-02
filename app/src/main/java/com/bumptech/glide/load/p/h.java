package com.bumptech.glide.load.p;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.i;
import com.bumptech.glide.load.p.f;
import com.bumptech.glide.load.p.i;
import com.bumptech.glide.util.n.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DecodeJob.java */
/* JADX INFO: loaded from: classes.dex */
class h<R> implements f.a, Runnable, Comparable<h<?>>, a.f {
    private static final String F = "DecodeJob";
    private com.bumptech.glide.load.a A;
    private com.bumptech.glide.load.o.d<?> B;
    private volatile com.bumptech.glide.load.p.f C;
    private volatile boolean D;
    private volatile boolean E;

    /* JADX INFO: renamed from: d */
    private final e f2938d;

    /* JADX INFO: renamed from: e */
    private final Pools.Pool<h<?>> f2939e;

    /* JADX INFO: renamed from: h */
    private com.bumptech.glide.d f2942h;

    /* JADX INFO: renamed from: i */
    private com.bumptech.glide.load.g f2943i;

    /* JADX INFO: renamed from: j */
    private com.bumptech.glide.h f2944j;

    /* JADX INFO: renamed from: k */
    private n f2945k;

    /* JADX INFO: renamed from: l */
    private int f2946l;

    /* JADX INFO: renamed from: m */
    private int f2947m;

    /* JADX INFO: renamed from: n */
    private j f2948n;
    private com.bumptech.glide.load.j o;
    private b<R> p;
    private int q;
    private EnumC0052h r;
    private g s;
    private long t;
    private boolean u;
    private Object v;
    private Thread w;
    private com.bumptech.glide.load.g x;
    private com.bumptech.glide.load.g y;
    private Object z;
    private final com.bumptech.glide.load.p.g<R> a = new com.bumptech.glide.load.p.g<>();

    /* JADX INFO: renamed from: b */
    private final List<Throwable> f2936b = new ArrayList();

    /* JADX INFO: renamed from: c */
    private final com.bumptech.glide.util.n.c f2937c = com.bumptech.glide.util.n.c.b();

    /* JADX INFO: renamed from: f */
    private final d<?> f2940f = new d<>();

    /* JADX INFO: renamed from: g */
    private final f f2941g = new f();

    /* JADX INFO: compiled from: DecodeJob.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b */
        static final /* synthetic */ int[] f2949b;

        /* JADX INFO: renamed from: c */
        static final /* synthetic */ int[] f2950c = new int[com.bumptech.glide.load.c.values().length];

        static {
            try {
                f2950c[com.bumptech.glide.load.c.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2950c[com.bumptech.glide.load.c.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f2949b = new int[EnumC0052h.values().length];
            try {
                f2949b[EnumC0052h.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2949b[EnumC0052h.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2949b[EnumC0052h.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2949b[EnumC0052h.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2949b[EnumC0052h.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            a = new int[g.values().length];
            try {
                a[g.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[g.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    interface b<R> {
        void a(h<?> hVar);

        void a(q qVar);

        void a(v<R> vVar, com.bumptech.glide.load.a aVar);
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    private final class c<Z> implements i.a<Z> {
        private final com.bumptech.glide.load.a a;

        c(com.bumptech.glide.load.a aVar) {
            this.a = aVar;
        }

        @Override // com.bumptech.glide.load.p.i.a
        @NonNull
        public v<Z> a(@NonNull v<Z> vVar) {
            return h.this.a(this.a, vVar);
        }
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    interface e {
        com.bumptech.glide.load.p.b0.a a();
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    private enum g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.p.h$h */
    /* JADX INFO: compiled from: DecodeJob.java */
    private enum EnumC0052h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    h(e eVar, Pools.Pool<h<?>> pool) {
        this.f2938d = eVar;
        this.f2939e = pool;
    }

    private void e() {
        if (Log.isLoggable(F, 2)) {
            a("Retrieved data", this.t, "data: " + this.z + ", cache key: " + this.x + ", fetcher: " + this.B);
        }
        v<R> vVarA = null;
        try {
            vVarA = a(this.B, this.z, this.A);
        } catch (q e2) {
            e2.setLoggingDetails(this.y, this.A);
            this.f2936b.add(e2);
        }
        if (vVarA != null) {
            b(vVarA, this.A);
        } else {
            l();
        }
    }

    private com.bumptech.glide.load.p.f f() {
        int i2 = a.f2949b[this.r.ordinal()];
        if (i2 == 1) {
            return new w(this.a, this);
        }
        if (i2 == 2) {
            return new com.bumptech.glide.load.p.c(this.a, this);
        }
        if (i2 == 3) {
            return new z(this.a, this);
        }
        if (i2 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.r);
    }

    private int g() {
        return this.f2944j.ordinal();
    }

    private void h() {
        n();
        this.p.a(new q("Failed to load resource", new ArrayList(this.f2936b)));
        j();
    }

    private void i() {
        if (this.f2941g.a()) {
            k();
        }
    }

    private void j() {
        if (this.f2941g.b()) {
            k();
        }
    }

    private void k() {
        this.f2941g.c();
        this.f2940f.a();
        this.a.a();
        this.D = false;
        this.f2942h = null;
        this.f2943i = null;
        this.o = null;
        this.f2944j = null;
        this.f2945k = null;
        this.p = null;
        this.r = null;
        this.C = null;
        this.w = null;
        this.x = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.t = 0L;
        this.E = false;
        this.v = null;
        this.f2936b.clear();
        this.f2939e.release(this);
    }

    private void l() {
        this.w = Thread.currentThread();
        this.t = com.bumptech.glide.util.f.a();
        boolean zA = false;
        while (!this.E && this.C != null && !(zA = this.C.a())) {
            this.r = a(this.r);
            this.C = f();
            if (this.r == EnumC0052h.SOURCE) {
                b();
                return;
            }
        }
        if ((this.r == EnumC0052h.FINISHED || this.E) && !zA) {
            h();
        }
    }

    private void m() {
        int i2 = a.a[this.s.ordinal()];
        if (i2 == 1) {
            this.r = a(EnumC0052h.INITIALIZE);
            this.C = f();
            l();
        } else if (i2 == 2) {
            l();
        } else {
            if (i2 == 3) {
                e();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.s);
        }
    }

    private void n() {
        Throwable th;
        this.f2937c.a();
        if (!this.D) {
            this.D = true;
            return;
        }
        if (this.f2936b.isEmpty()) {
            th = null;
        } else {
            List<Throwable> list = this.f2936b;
            th = list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    h<R> a(com.bumptech.glide.d dVar, Object obj, n nVar, com.bumptech.glide.load.g gVar, int i2, int i3, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, j jVar, Map<Class<?>, com.bumptech.glide.load.n<?>> map, boolean z, boolean z2, boolean z3, com.bumptech.glide.load.j jVar2, b<R> bVar, int i4) {
        this.a.a(dVar, obj, gVar, i2, i3, jVar, cls, cls2, hVar, jVar2, map, z, z2, this.f2938d);
        this.f2942h = dVar;
        this.f2943i = gVar;
        this.f2944j = hVar;
        this.f2945k = nVar;
        this.f2946l = i2;
        this.f2947m = i3;
        this.f2948n = jVar;
        this.u = z3;
        this.o = jVar2;
        this.p = bVar;
        this.q = i4;
        this.s = g.INITIALIZE;
        this.v = obj;
        return this;
    }

    @Override // com.bumptech.glide.load.p.f.a
    public void b() {
        this.s = g.SWITCH_TO_SOURCE_SERVICE;
        this.p.a((h<?>) this);
    }

    @Override // com.bumptech.glide.util.n.a.f
    @NonNull
    public com.bumptech.glide.util.n.c c() {
        return this.f2937c;
    }

    boolean d() {
        EnumC0052h enumC0052hA = a(EnumC0052h.INITIALIZE);
        return enumC0052hA == EnumC0052h.RESOURCE_CACHE || enumC0052hA == EnumC0052h.DATA_CACHE;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bumptech.glide.util.n.b.a("DecodeJob#run(model=%s)", this.v);
        com.bumptech.glide.load.o.d<?> dVar = this.B;
        try {
            try {
                try {
                    if (this.E) {
                        h();
                        if (dVar != null) {
                            dVar.b();
                        }
                        com.bumptech.glide.util.n.b.a();
                        return;
                    }
                    m();
                    if (dVar != null) {
                        dVar.b();
                    }
                    com.bumptech.glide.util.n.b.a();
                } catch (com.bumptech.glide.load.p.b e2) {
                    throw e2;
                }
            } catch (Throwable th) {
                if (Log.isLoggable(F, 3)) {
                    String str = "DecodeJob threw unexpectedly, isCancelled: " + this.E + ", stage: " + this.r;
                }
                if (this.r != EnumC0052h.ENCODE) {
                    this.f2936b.add(th);
                    h();
                }
                if (!this.E) {
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th2) {
            if (dVar != null) {
                dVar.b();
            }
            com.bumptech.glide.util.n.b.a();
            throw th2;
        }
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    private static class f {
        private boolean a;

        /* JADX INFO: renamed from: b */
        private boolean f2954b;

        /* JADX INFO: renamed from: c */
        private boolean f2955c;

        f() {
        }

        synchronized boolean a(boolean z) {
            this.a = true;
            return b(z);
        }

        synchronized boolean b() {
            this.f2955c = true;
            return b(false);
        }

        synchronized void c() {
            this.f2954b = false;
            this.a = false;
            this.f2955c = false;
        }

        private boolean b(boolean z) {
            return (this.f2955c || z || this.f2954b) && this.a;
        }

        synchronized boolean a() {
            this.f2954b = true;
            return b(false);
        }
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    private static class d<Z> {
        private com.bumptech.glide.load.g a;

        /* JADX INFO: renamed from: b */
        private com.bumptech.glide.load.m<Z> f2952b;

        /* JADX INFO: renamed from: c */
        private u<Z> f2953c;

        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void a(com.bumptech.glide.load.g gVar, com.bumptech.glide.load.m<X> mVar, u<X> uVar) {
            this.a = gVar;
            this.f2952b = mVar;
            this.f2953c = uVar;
        }

        boolean b() {
            return this.f2953c != null;
        }

        void a(e eVar, com.bumptech.glide.load.j jVar) {
            com.bumptech.glide.util.n.b.a("DecodeJob.encode");
            try {
                eVar.a().a(this.a, new com.bumptech.glide.load.p.e(this.f2952b, this.f2953c, jVar));
            } finally {
                this.f2953c.d();
                com.bumptech.glide.util.n.b.a();
            }
        }

        void a() {
            this.a = null;
            this.f2952b = null;
            this.f2953c = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(v<R> vVar, com.bumptech.glide.load.a aVar) {
        if (vVar instanceof r) {
            ((r) vVar).initialize();
        }
        u uVar = 0;
        if (this.f2940f.b()) {
            vVar = u.b(vVar);
            uVar = vVar;
        }
        a((v) vVar, aVar);
        this.r = EnumC0052h.ENCODE;
        try {
            if (this.f2940f.b()) {
                this.f2940f.a(this.f2938d, this.o);
            }
            i();
        } finally {
            if (uVar != 0) {
                uVar.d();
            }
        }
    }

    void a(boolean z) {
        if (this.f2941g.a(z)) {
            k();
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a */
    public int compareTo(@NonNull h<?> hVar) {
        int iG = g() - hVar.g();
        return iG == 0 ? this.q - hVar.q : iG;
    }

    public void a() {
        this.E = true;
        com.bumptech.glide.load.p.f fVar = this.C;
        if (fVar != null) {
            fVar.cancel();
        }
    }

    private void a(v<R> vVar, com.bumptech.glide.load.a aVar) {
        n();
        this.p.a(vVar, aVar);
    }

    private EnumC0052h a(EnumC0052h enumC0052h) {
        int i2 = a.f2949b[enumC0052h.ordinal()];
        if (i2 == 1) {
            if (this.f2948n.a()) {
                return EnumC0052h.DATA_CACHE;
            }
            return a(EnumC0052h.DATA_CACHE);
        }
        if (i2 == 2) {
            return this.u ? EnumC0052h.FINISHED : EnumC0052h.SOURCE;
        }
        if (i2 == 3 || i2 == 4) {
            return EnumC0052h.FINISHED;
        }
        if (i2 == 5) {
            if (this.f2948n.b()) {
                return EnumC0052h.RESOURCE_CACHE;
            }
            return a(EnumC0052h.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + enumC0052h);
    }

    @Override // com.bumptech.glide.load.p.f.a
    public void a(com.bumptech.glide.load.g gVar, Object obj, com.bumptech.glide.load.o.d<?> dVar, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.g gVar2) {
        this.x = gVar;
        this.z = obj;
        this.B = dVar;
        this.A = aVar;
        this.y = gVar2;
        if (Thread.currentThread() != this.w) {
            this.s = g.DECODE_DATA;
            this.p.a((h<?>) this);
        } else {
            com.bumptech.glide.util.n.b.a("DecodeJob.decodeFromRetrievedData");
            try {
                e();
            } finally {
                com.bumptech.glide.util.n.b.a();
            }
        }
    }

    @Override // com.bumptech.glide.load.p.f.a
    public void a(com.bumptech.glide.load.g gVar, Exception exc, com.bumptech.glide.load.o.d<?> dVar, com.bumptech.glide.load.a aVar) {
        dVar.b();
        q qVar = new q("Fetching data failed", exc);
        qVar.setLoggingDetails(gVar, aVar, dVar.a());
        this.f2936b.add(qVar);
        if (Thread.currentThread() != this.w) {
            this.s = g.SWITCH_TO_SOURCE_SERVICE;
            this.p.a((h<?>) this);
        } else {
            l();
        }
    }

    private <Data> v<R> a(com.bumptech.glide.load.o.d<?> dVar, Data data, com.bumptech.glide.load.a aVar) throws q {
        if (data == null) {
            return null;
        }
        try {
            long jA = com.bumptech.glide.util.f.a();
            v<R> vVarA = a(data, aVar);
            if (Log.isLoggable(F, 2)) {
                a("Decoded result " + vVarA, jA);
            }
            return vVarA;
        } finally {
            dVar.b();
        }
    }

    private <Data> v<R> a(Data data, com.bumptech.glide.load.a aVar) throws q {
        return a(data, aVar, this.a.a((Class) data.getClass()));
    }

    @NonNull
    private com.bumptech.glide.load.j a(com.bumptech.glide.load.a aVar) {
        com.bumptech.glide.load.j jVar = this.o;
        if (Build.VERSION.SDK_INT < 26) {
            return jVar;
        }
        boolean z = aVar == com.bumptech.glide.load.a.RESOURCE_DISK_CACHE || this.a.o();
        Boolean bool = (Boolean) jVar.a(com.bumptech.glide.load.r.d.q.f3213k);
        if (bool != null && (!bool.booleanValue() || z)) {
            return jVar;
        }
        com.bumptech.glide.load.j jVar2 = new com.bumptech.glide.load.j();
        jVar2.a(this.o);
        jVar2.a(com.bumptech.glide.load.r.d.q.f3213k, Boolean.valueOf(z));
        return jVar2;
    }

    private <Data, ResourceType> v<R> a(Data data, com.bumptech.glide.load.a aVar, t<Data, ResourceType, R> tVar) throws q {
        com.bumptech.glide.load.j jVarA = a(aVar);
        com.bumptech.glide.load.o.e<Data> eVarB = this.f2942h.f().b(data);
        try {
            return tVar.a(eVarB, jVarA, this.f2946l, this.f2947m, new c(aVar));
        } finally {
            eVarB.b();
        }
    }

    private void a(String str, long j2) {
        a(str, j2, (String) null);
    }

    private void a(String str, long j2, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(com.bumptech.glide.util.f.a(j2));
        sb.append(", load key: ");
        sb.append(this.f2945k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        sb.toString();
    }

    @NonNull
    <Z> v<Z> a(com.bumptech.glide.load.a aVar, @NonNull v<Z> vVar) {
        v<Z> vVarA;
        com.bumptech.glide.load.n<Z> nVar;
        com.bumptech.glide.load.c cVarA;
        com.bumptech.glide.load.g dVar;
        Class<?> cls = vVar.get().getClass();
        com.bumptech.glide.load.m<Z> mVarA = null;
        if (aVar != com.bumptech.glide.load.a.RESOURCE_DISK_CACHE) {
            com.bumptech.glide.load.n<Z> nVarB = this.a.b(cls);
            nVar = nVarB;
            vVarA = nVarB.a(this.f2942h, vVar, this.f2946l, this.f2947m);
        } else {
            vVarA = vVar;
            nVar = null;
        }
        if (!vVar.equals(vVarA)) {
            vVar.recycle();
        }
        if (this.a.b((v<?>) vVarA)) {
            mVarA = this.a.a((v) vVarA);
            cVarA = mVarA.a(this.o);
        } else {
            cVarA = com.bumptech.glide.load.c.NONE;
        }
        com.bumptech.glide.load.m mVar = mVarA;
        if (!this.f2948n.a(!this.a.a(this.x), aVar, cVarA)) {
            return vVarA;
        }
        if (mVar != null) {
            int i2 = a.f2950c[cVarA.ordinal()];
            if (i2 == 1) {
                dVar = new com.bumptech.glide.load.p.d(this.x, this.f2943i);
            } else if (i2 == 2) {
                dVar = new x(this.a.b(), this.x, this.f2943i, this.f2946l, this.f2947m, nVar, cls, this.o);
            } else {
                throw new IllegalArgumentException("Unknown strategy: " + cVarA);
            }
            u uVarB = u.b(vVarA);
            this.f2940f.a(dVar, mVar, uVarB);
            return uVarB;
        }
        throw new i.d(vVarA.get().getClass());
    }
}
