package com.hihonor.cloudservice.tasks.q;

import android.app.Activity;
import d.c.a.d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: TaskImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class i<TResult> extends d.c.a.d.j<TResult> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f4091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TResult f4092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Exception f4093e;
    private final Object a = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<d.c.a.d.d<TResult>> f4094f = new ArrayList();

    /* JADX INFO: compiled from: TaskImpl.java */
    class a implements d.c.a.d.h<TResult> {
        final /* synthetic */ d.c.a.d.i a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f4095b;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        /* JADX INFO: renamed from: com.hihonor.cloudservice.tasks.q.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: TaskImpl.java */
        class C0088a<TContinuationResult> implements d.c.a.d.f<TContinuationResult> {
            C0088a() {
            }

            @Override // d.c.a.d.f
            public final void a(d.c.a.d.j<TContinuationResult> jVar) {
                if (jVar.e()) {
                    a.this.f4095b.a(jVar.b());
                } else if (jVar.c()) {
                    a.this.f4095b.f();
                } else {
                    a.this.f4095b.a(jVar.a());
                }
            }
        }

        a(i iVar, d.c.a.d.i iVar2, i iVar3) {
            this.a = iVar2;
            this.f4095b = iVar3;
        }

        @Override // d.c.a.d.h
        public final void onSuccess(TResult tresult) {
            try {
                d.c.a.d.j jVarThen = this.a.then(tresult);
                if (jVarThen == null) {
                    this.f4095b.a((Exception) new NullPointerException("SuccessContinuation returned null"));
                } else {
                    jVarThen.a(new C0088a());
                }
            } catch (Exception e2) {
                this.f4095b.a(e2);
            }
        }
    }

    /* JADX INFO: compiled from: TaskImpl.java */
    class b implements d.c.a.d.g {
        final /* synthetic */ i a;

        b(i iVar, i iVar2) {
            this.a = iVar2;
        }

        @Override // d.c.a.d.g
        public final void onFailure(Exception exc) {
            this.a.a(exc);
        }
    }

    /* JADX INFO: compiled from: TaskImpl.java */
    class c implements d.c.a.d.e {
        final /* synthetic */ i a;

        c(i iVar, i iVar2) {
            this.a = iVar2;
        }

        @Override // d.c.a.d.e
        public final void onCanceled() {
            this.a.f();
        }
    }

    /* JADX INFO: compiled from: TaskImpl.java */
    class d implements d.c.a.d.f<TResult> {
        final /* synthetic */ d.c.a.d.c a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f4096b;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        /* JADX INFO: compiled from: TaskImpl.java */
        class a<TContinuationResult> implements d.c.a.d.f<TContinuationResult> {
            a() {
            }

            @Override // d.c.a.d.f
            public final void a(d.c.a.d.j<TContinuationResult> jVar) {
                if (jVar.e()) {
                    d.this.f4096b.a(jVar.b());
                } else if (jVar.c()) {
                    d.this.f4096b.f();
                } else {
                    d.this.f4096b.a(jVar.a());
                }
            }
        }

        d(i iVar, d.c.a.d.c cVar, i iVar2) {
            this.a = cVar;
            this.f4096b = iVar2;
        }

        @Override // d.c.a.d.f
        public final void a(d.c.a.d.j<TResult> jVar) {
            try {
                d.c.a.d.j jVar2 = (d.c.a.d.j) this.a.a(jVar);
                if (jVar2 == null) {
                    this.f4096b.a((Exception) new NullPointerException("Continuation returned null"));
                } else {
                    jVar2.a(new a());
                }
            } catch (Exception e2) {
                this.f4096b.a(e2);
            }
        }
    }

    /* JADX INFO: compiled from: TaskImpl.java */
    class e implements d.c.a.d.f<TResult> {
        final /* synthetic */ i a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.c.a.d.c f4097b;

        e(i iVar, i iVar2, d.c.a.d.c cVar) {
            this.a = iVar2;
            this.f4097b = cVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.c.a.d.f
        public final void a(d.c.a.d.j<TResult> jVar) {
            if (jVar.c()) {
                this.a.f();
                return;
            }
            try {
                this.a.a(this.f4097b.a(jVar));
            } catch (Exception e2) {
                this.a.a(e2);
            }
        }
    }

    private void g() {
        synchronized (this.a) {
            Iterator<d.c.a.d.d<TResult>> it = this.f4094f.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.f4094f = null;
        }
    }

    public final void a(TResult tresult) {
        synchronized (this.a) {
            if (!this.f4090b) {
                this.f4090b = true;
                this.f4092d = tresult;
                this.a.notifyAll();
                g();
            }
        }
    }

    @Override // d.c.a.d.j
    public final <TContinuationResult> d.c.a.d.j<TContinuationResult> b(d.c.a.d.c<TResult, d.c.a.d.j<TContinuationResult>> cVar) {
        return b(l.c(), cVar);
    }

    @Override // d.c.a.d.j
    public boolean c() {
        return this.f4091c;
    }

    @Override // d.c.a.d.j
    public boolean d() {
        boolean z;
        synchronized (this.a) {
            z = this.f4090b;
        }
        return z;
    }

    @Override // d.c.a.d.j
    public boolean e() {
        boolean z;
        synchronized (this.a) {
            z = this.f4090b && !c() && this.f4093e == null;
        }
        return z;
    }

    public final boolean f() {
        synchronized (this.a) {
            if (this.f4090b) {
                return false;
            }
            this.f4090b = true;
            this.f4091c = true;
            this.a.notifyAll();
            g();
            return true;
        }
    }

    @Override // d.c.a.d.j
    public TResult b() {
        TResult tresult;
        synchronized (this.a) {
            if (this.f4093e != null) {
                throw new RuntimeException(this.f4093e);
            }
            tresult = this.f4092d;
        }
        return tresult;
    }

    @Override // d.c.a.d.j
    public final <TContinuationResult> d.c.a.d.j<TContinuationResult> b(Executor executor, d.c.a.d.c<TResult, d.c.a.d.j<TContinuationResult>> cVar) {
        i iVar = new i();
        a(executor, new d(this, cVar, iVar));
        return iVar;
    }

    @Override // d.c.a.d.j
    public final d.c.a.d.j<TResult> a(d.c.a.d.e eVar) {
        return a(l.c(), eVar);
    }

    @Override // d.c.a.d.j
    public final d.c.a.d.j<TResult> a(d.c.a.d.f<TResult> fVar) {
        return a(l.c(), fVar);
    }

    @Override // d.c.a.d.j
    public d.c.a.d.j<TResult> a(d.c.a.d.g gVar) {
        return a(l.c(), gVar);
    }

    @Override // d.c.a.d.j
    public d.c.a.d.j<TResult> a(d.c.a.d.h<TResult> hVar) {
        return a(l.c(), hVar);
    }

    @Override // d.c.a.d.j
    public final <TContinuationResult> d.c.a.d.j<TContinuationResult> a(d.c.a.d.c<TResult, TContinuationResult> cVar) {
        return a(l.c(), cVar);
    }

    @Override // d.c.a.d.j
    public Exception a() {
        Exception exc;
        synchronized (this.a) {
            exc = this.f4093e;
        }
        return exc;
    }

    @Override // d.c.a.d.j
    public final <E extends Throwable> TResult a(Class<E> cls) {
        TResult tresult;
        synchronized (this.a) {
            if (cls != null) {
                if (cls.isInstance(this.f4093e)) {
                    throw cls.cast(this.f4093e);
                }
            }
            if (this.f4093e == null) {
                tresult = this.f4092d;
            } else {
                throw new RuntimeException(this.f4093e);
            }
        }
        return tresult;
    }

    @Override // d.c.a.d.j
    public final <TContinuationResult> d.c.a.d.j<TContinuationResult> a(d.c.a.d.i<TResult, TContinuationResult> iVar) {
        return a(l.c(), iVar);
    }

    @Override // d.c.a.d.j
    public final d.c.a.d.j<TResult> a(Executor executor, d.c.a.d.e eVar) {
        return a((d.c.a.d.d) new com.hihonor.cloudservice.tasks.q.b(executor, eVar));
    }

    @Override // d.c.a.d.j
    public final d.c.a.d.j<TResult> a(Executor executor, d.c.a.d.f<TResult> fVar) {
        return a((d.c.a.d.d) new com.hihonor.cloudservice.tasks.q.c(executor, fVar));
    }

    @Override // d.c.a.d.j
    public d.c.a.d.j<TResult> a(Executor executor, d.c.a.d.g gVar) {
        return a((d.c.a.d.d) new com.hihonor.cloudservice.tasks.q.d(executor, gVar));
    }

    @Override // d.c.a.d.j
    public d.c.a.d.j<TResult> a(Executor executor, d.c.a.d.h<TResult> hVar) {
        return a((d.c.a.d.d) new com.hihonor.cloudservice.tasks.q.e(executor, hVar));
    }

    @Override // d.c.a.d.j
    public final <TContinuationResult> d.c.a.d.j<TContinuationResult> a(Executor executor, d.c.a.d.c<TResult, TContinuationResult> cVar) {
        i iVar = new i();
        a(executor, new e(this, iVar, cVar));
        return iVar;
    }

    @Override // d.c.a.d.j
    public final <TContinuationResult> d.c.a.d.j<TContinuationResult> a(Executor executor, d.c.a.d.i<TResult, TContinuationResult> iVar) {
        i iVar2 = new i();
        a(executor, new a(this, iVar, iVar2));
        a((d.c.a.d.g) new b(this, iVar2));
        a((d.c.a.d.e) new c(this, iVar2));
        return iVar2;
    }

    @Override // d.c.a.d.j
    public final d.c.a.d.j<TResult> a(Activity activity, d.c.a.d.e eVar) {
        com.hihonor.cloudservice.tasks.q.b bVar = new com.hihonor.cloudservice.tasks.q.b(l.c(), eVar);
        f.a(activity, bVar);
        return a((d.c.a.d.d) bVar);
    }

    @Override // d.c.a.d.j
    public final d.c.a.d.j<TResult> a(Activity activity, d.c.a.d.f<TResult> fVar) {
        com.hihonor.cloudservice.tasks.q.c cVar = new com.hihonor.cloudservice.tasks.q.c(l.c(), fVar);
        f.a(activity, cVar);
        return a((d.c.a.d.d) cVar);
    }

    @Override // d.c.a.d.j
    public d.c.a.d.j<TResult> a(Activity activity, d.c.a.d.g gVar) {
        com.hihonor.cloudservice.tasks.q.d dVar = new com.hihonor.cloudservice.tasks.q.d(l.c(), gVar);
        f.a(activity, dVar);
        return a((d.c.a.d.d) dVar);
    }

    @Override // d.c.a.d.j
    public d.c.a.d.j<TResult> a(Activity activity, d.c.a.d.h<TResult> hVar) {
        com.hihonor.cloudservice.tasks.q.e eVar = new com.hihonor.cloudservice.tasks.q.e(l.c(), hVar);
        f.a(activity, eVar);
        return a((d.c.a.d.d) eVar);
    }

    public final void a(Exception exc) {
        synchronized (this.a) {
            if (!this.f4090b) {
                this.f4090b = true;
                this.f4093e = exc;
                this.a.notifyAll();
                g();
            }
        }
    }

    private d.c.a.d.j<TResult> a(d.c.a.d.d<TResult> dVar) {
        boolean zD;
        synchronized (this.a) {
            zD = d();
            if (!zD) {
                this.f4094f.add(dVar);
            }
        }
        if (zD) {
            dVar.a(this);
        }
        return this;
    }
}
