package com.hihonor.cloudservice.tasks.p161q;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import p031c.p075c.p076a.p090d.AbstractC1213j;
import p031c.p075c.p076a.p090d.C1215l;
import p031c.p075c.p076a.p090d.InterfaceC1206c;
import p031c.p075c.p076a.p090d.InterfaceC1207d;
import p031c.p075c.p076a.p090d.InterfaceC1208e;
import p031c.p075c.p076a.p090d.InterfaceC1209f;
import p031c.p075c.p076a.p090d.InterfaceC1210g;
import p031c.p075c.p076a.p090d.InterfaceC1211h;
import p031c.p075c.p076a.p090d.InterfaceC1212i;

/* compiled from: TaskImpl.java */
/* renamed from: com.hihonor.cloudservice.tasks.q.i */
/* loaded from: classes.dex */
public final class C2148i<TResult> extends AbstractC1213j<TResult> {

    /* renamed from: b */
    private boolean f6469b;

    /* renamed from: c */
    private volatile boolean f6470c;

    /* renamed from: d */
    private TResult f6471d;

    /* renamed from: e */
    private Exception f6472e;

    /* renamed from: a */
    private final Object f6468a = new Object();

    /* renamed from: f */
    private List<InterfaceC1207d<TResult>> f6473f = new ArrayList();

    /* compiled from: TaskImpl.java */
    /* renamed from: com.hihonor.cloudservice.tasks.q.i$a */
    class a implements InterfaceC1211h<TResult> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC1212i f6474a;

        /* renamed from: b */
        final /* synthetic */ C2148i f6475b;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        /* compiled from: TaskImpl.java */
        /* renamed from: com.hihonor.cloudservice.tasks.q.i$a$a, reason: collision with other inner class name */
        class C7366a<TContinuationResult> implements InterfaceC1209f<TContinuationResult> {
            C7366a() {
            }

            @Override // p031c.p075c.p076a.p090d.InterfaceC1209f
            /* renamed from: a */
            public final void mo2319a(AbstractC1213j<TContinuationResult> abstractC1213j) {
                if (abstractC1213j.mo2343e()) {
                    a.this.f6475b.m6080a((C2148i) abstractC1213j.mo2340b());
                } else if (abstractC1213j.mo2341c()) {
                    a.this.f6475b.m6081f();
                } else {
                    a.this.f6475b.m6079a(abstractC1213j.mo2336a());
                }
            }
        }

        a(C2148i c2148i, InterfaceC1212i interfaceC1212i, C2148i c2148i2) {
            this.f6474a = interfaceC1212i;
            this.f6475b = c2148i2;
        }

        @Override // p031c.p075c.p076a.p090d.InterfaceC1211h
        public final void onSuccess(TResult tresult) {
            try {
                AbstractC1213j then = this.f6474a.then(tresult);
                if (then == null) {
                    this.f6475b.m6079a((Exception) new NullPointerException("SuccessContinuation returned null"));
                } else {
                    then.mo2326a(new C7366a());
                }
            } catch (Exception e2) {
                this.f6475b.m6079a(e2);
            }
        }
    }

    /* compiled from: TaskImpl.java */
    /* renamed from: com.hihonor.cloudservice.tasks.q.i$b */
    class b implements InterfaceC1210g {

        /* renamed from: a */
        final /* synthetic */ C2148i f6477a;

        b(C2148i c2148i, C2148i c2148i2) {
            this.f6477a = c2148i2;
        }

        @Override // p031c.p075c.p076a.p090d.InterfaceC1210g
        public final void onFailure(Exception exc) {
            this.f6477a.m6079a(exc);
        }
    }

    /* compiled from: TaskImpl.java */
    /* renamed from: com.hihonor.cloudservice.tasks.q.i$c */
    class c implements InterfaceC1208e {

        /* renamed from: a */
        final /* synthetic */ C2148i f6478a;

        c(C2148i c2148i, C2148i c2148i2) {
            this.f6478a = c2148i2;
        }

        @Override // p031c.p075c.p076a.p090d.InterfaceC1208e
        public final void onCanceled() {
            this.f6478a.m6081f();
        }
    }

    /* compiled from: TaskImpl.java */
    /* renamed from: com.hihonor.cloudservice.tasks.q.i$d */
    class d implements InterfaceC1209f<TResult> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC1206c f6479a;

        /* renamed from: b */
        final /* synthetic */ C2148i f6480b;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        /* compiled from: TaskImpl.java */
        /* renamed from: com.hihonor.cloudservice.tasks.q.i$d$a */
        class a<TContinuationResult> implements InterfaceC1209f<TContinuationResult> {
            a() {
            }

            @Override // p031c.p075c.p076a.p090d.InterfaceC1209f
            /* renamed from: a */
            public final void mo2319a(AbstractC1213j<TContinuationResult> abstractC1213j) {
                if (abstractC1213j.mo2343e()) {
                    d.this.f6480b.m6080a((C2148i) abstractC1213j.mo2340b());
                } else if (abstractC1213j.mo2341c()) {
                    d.this.f6480b.m6081f();
                } else {
                    d.this.f6480b.m6079a(abstractC1213j.mo2336a());
                }
            }
        }

        d(C2148i c2148i, InterfaceC1206c interfaceC1206c, C2148i c2148i2) {
            this.f6479a = interfaceC1206c;
            this.f6480b = c2148i2;
        }

        @Override // p031c.p075c.p076a.p090d.InterfaceC1209f
        /* renamed from: a */
        public final void mo2319a(AbstractC1213j<TResult> abstractC1213j) {
            try {
                AbstractC1213j abstractC1213j2 = (AbstractC1213j) this.f6479a.mo2317a(abstractC1213j);
                if (abstractC1213j2 == null) {
                    this.f6480b.m6079a((Exception) new NullPointerException("Continuation returned null"));
                } else {
                    abstractC1213j2.mo2326a(new a());
                }
            } catch (Exception e2) {
                this.f6480b.m6079a(e2);
            }
        }
    }

    /* compiled from: TaskImpl.java */
    /* renamed from: com.hihonor.cloudservice.tasks.q.i$e */
    class e implements InterfaceC1209f<TResult> {

        /* renamed from: a */
        final /* synthetic */ C2148i f6482a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC1206c f6483b;

        e(C2148i c2148i, C2148i c2148i2, InterfaceC1206c interfaceC1206c) {
            this.f6482a = c2148i2;
            this.f6483b = interfaceC1206c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p031c.p075c.p076a.p090d.InterfaceC1209f
        /* renamed from: a */
        public final void mo2319a(AbstractC1213j<TResult> abstractC1213j) {
            if (abstractC1213j.mo2341c()) {
                this.f6482a.m6081f();
                return;
            }
            try {
                this.f6482a.m6080a((C2148i) this.f6483b.mo2317a(abstractC1213j));
            } catch (Exception e2) {
                this.f6482a.m6079a(e2);
            }
        }
    }

    /* renamed from: g */
    private void m6078g() {
        synchronized (this.f6468a) {
            Iterator<InterfaceC1207d<TResult>> it = this.f6473f.iterator();
            while (it.hasNext()) {
                try {
                    it.next().mo2318a(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.f6473f = null;
        }
    }

    /* renamed from: a */
    public final void m6080a(TResult tresult) {
        synchronized (this.f6468a) {
            if (!this.f6469b) {
                this.f6469b = true;
                this.f6471d = tresult;
                this.f6468a.notifyAll();
                m6078g();
            }
        }
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: b */
    public final <TContinuationResult> AbstractC1213j<TContinuationResult> mo2338b(InterfaceC1206c<TResult, AbstractC1213j<TContinuationResult>> interfaceC1206c) {
        return mo2339b(C1215l.m2350c(), interfaceC1206c);
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: c */
    public boolean mo2341c() {
        return this.f6470c;
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: d */
    public boolean mo2342d() {
        boolean z;
        synchronized (this.f6468a) {
            z = this.f6469b;
        }
        return z;
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: e */
    public boolean mo2343e() {
        boolean z;
        synchronized (this.f6468a) {
            z = this.f6469b && !mo2341c() && this.f6472e == null;
        }
        return z;
    }

    /* renamed from: f */
    public final boolean m6081f() {
        synchronized (this.f6468a) {
            if (this.f6469b) {
                return false;
            }
            this.f6469b = true;
            this.f6470c = true;
            this.f6468a.notifyAll();
            m6078g();
            return true;
        }
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: b */
    public TResult mo2340b() {
        TResult tresult;
        synchronized (this.f6468a) {
            if (this.f6472e != null) {
                throw new RuntimeException(this.f6472e);
            }
            tresult = this.f6471d;
        }
        return tresult;
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: b */
    public final <TContinuationResult> AbstractC1213j<TContinuationResult> mo2339b(Executor executor, InterfaceC1206c<TResult, AbstractC1213j<TContinuationResult>> interfaceC1206c) {
        C2148i c2148i = new C2148i();
        mo2332a(executor, new d(this, interfaceC1206c, c2148i));
        return c2148i;
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: a */
    public final AbstractC1213j<TResult> mo2325a(InterfaceC1208e interfaceC1208e) {
        return mo2331a(C1215l.m2350c(), interfaceC1208e);
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: a */
    public final AbstractC1213j<TResult> mo2326a(InterfaceC1209f<TResult> interfaceC1209f) {
        return mo2332a(C1215l.m2350c(), interfaceC1209f);
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: a */
    public AbstractC1213j<TResult> mo2327a(InterfaceC1210g interfaceC1210g) {
        return mo2333a(C1215l.m2350c(), interfaceC1210g);
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: a */
    public AbstractC1213j<TResult> mo2328a(InterfaceC1211h<TResult> interfaceC1211h) {
        return mo2334a(C1215l.m2350c(), interfaceC1211h);
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: a */
    public final <TContinuationResult> AbstractC1213j<TContinuationResult> mo2324a(InterfaceC1206c<TResult, TContinuationResult> interfaceC1206c) {
        return mo2330a(C1215l.m2350c(), interfaceC1206c);
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: a */
    public Exception mo2336a() {
        Exception exc;
        synchronized (this.f6468a) {
            exc = this.f6472e;
        }
        return exc;
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: a */
    public final <E extends Throwable> TResult mo2337a(Class<E> cls) {
        TResult tresult;
        synchronized (this.f6468a) {
            if (cls != null) {
                if (cls.isInstance(this.f6472e)) {
                    throw cls.cast(this.f6472e);
                }
            }
            if (this.f6472e == null) {
                tresult = this.f6471d;
            } else {
                throw new RuntimeException(this.f6472e);
            }
        }
        return tresult;
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: a */
    public final <TContinuationResult> AbstractC1213j<TContinuationResult> mo2329a(InterfaceC1212i<TResult, TContinuationResult> interfaceC1212i) {
        return mo2335a(C1215l.m2350c(), interfaceC1212i);
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: a */
    public final AbstractC1213j<TResult> mo2331a(Executor executor, InterfaceC1208e interfaceC1208e) {
        return m6077a((InterfaceC1207d) new C2141b(executor, interfaceC1208e));
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: a */
    public final AbstractC1213j<TResult> mo2332a(Executor executor, InterfaceC1209f<TResult> interfaceC1209f) {
        return m6077a((InterfaceC1207d) new C2142c(executor, interfaceC1209f));
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: a */
    public AbstractC1213j<TResult> mo2333a(Executor executor, InterfaceC1210g interfaceC1210g) {
        return m6077a((InterfaceC1207d) new C2143d(executor, interfaceC1210g));
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: a */
    public AbstractC1213j<TResult> mo2334a(Executor executor, InterfaceC1211h<TResult> interfaceC1211h) {
        return m6077a((InterfaceC1207d) new C2144e(executor, interfaceC1211h));
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: a */
    public final <TContinuationResult> AbstractC1213j<TContinuationResult> mo2330a(Executor executor, InterfaceC1206c<TResult, TContinuationResult> interfaceC1206c) {
        C2148i c2148i = new C2148i();
        mo2332a(executor, new e(this, c2148i, interfaceC1206c));
        return c2148i;
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: a */
    public final <TContinuationResult> AbstractC1213j<TContinuationResult> mo2335a(Executor executor, InterfaceC1212i<TResult, TContinuationResult> interfaceC1212i) {
        C2148i c2148i = new C2148i();
        mo2334a(executor, new a(this, interfaceC1212i, c2148i));
        mo2327a((InterfaceC1210g) new b(this, c2148i));
        mo2325a((InterfaceC1208e) new c(this, c2148i));
        return c2148i;
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: a */
    public final AbstractC1213j<TResult> mo2320a(Activity activity, InterfaceC1208e interfaceC1208e) {
        C2141b c2141b = new C2141b(C1215l.m2350c(), interfaceC1208e);
        FragmentC2145f.m6073a(activity, c2141b);
        return m6077a((InterfaceC1207d) c2141b);
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: a */
    public final AbstractC1213j<TResult> mo2321a(Activity activity, InterfaceC1209f<TResult> interfaceC1209f) {
        C2142c c2142c = new C2142c(C1215l.m2350c(), interfaceC1209f);
        FragmentC2145f.m6073a(activity, c2142c);
        return m6077a((InterfaceC1207d) c2142c);
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: a */
    public AbstractC1213j<TResult> mo2322a(Activity activity, InterfaceC1210g interfaceC1210g) {
        C2143d c2143d = new C2143d(C1215l.m2350c(), interfaceC1210g);
        FragmentC2145f.m6073a(activity, c2143d);
        return m6077a((InterfaceC1207d) c2143d);
    }

    @Override // p031c.p075c.p076a.p090d.AbstractC1213j
    /* renamed from: a */
    public AbstractC1213j<TResult> mo2323a(Activity activity, InterfaceC1211h<TResult> interfaceC1211h) {
        C2144e c2144e = new C2144e(C1215l.m2350c(), interfaceC1211h);
        FragmentC2145f.m6073a(activity, c2144e);
        return m6077a((InterfaceC1207d) c2144e);
    }

    /* renamed from: a */
    public final void m6079a(Exception exc) {
        synchronized (this.f6468a) {
            if (!this.f6469b) {
                this.f6469b = true;
                this.f6472e = exc;
                this.f6468a.notifyAll();
                m6078g();
            }
        }
    }

    /* renamed from: a */
    private AbstractC1213j<TResult> m6077a(InterfaceC1207d<TResult> interfaceC1207d) {
        boolean mo2342d;
        synchronized (this.f6468a) {
            mo2342d = mo2342d();
            if (!mo2342d) {
                this.f6473f.add(interfaceC1207d);
            }
        }
        if (mo2342d) {
            interfaceC1207d.mo2318a(this);
        }
        return this;
    }
}
