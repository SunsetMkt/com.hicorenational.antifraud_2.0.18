package p031c.p075c.p076a.p090d;

import com.hihonor.cloudservice.tasks.p161q.C2148i;

/* compiled from: TaskCompletionSource.java */
/* renamed from: c.c.a.d.k */
/* loaded from: classes.dex */
public class C1214k<TResult> {

    /* renamed from: a */
    private final C2148i<TResult> f2656a = new C2148i<>();

    /* compiled from: TaskCompletionSource.java */
    /* renamed from: c.c.a.d.k$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C1214k.this.f2656a.m6081f();
        }
    }

    public C1214k() {
    }

    /* renamed from: a */
    public AbstractC1213j<TResult> m2345a() {
        return this.f2656a;
    }

    public C1214k(AbstractC1204a abstractC1204a) {
        abstractC1204a.mo2313a(new a());
    }

    /* renamed from: a */
    public void m2346a(Exception exc) {
        this.f2656a.m6079a(exc);
    }

    /* renamed from: a */
    public void m2347a(TResult tresult) {
        this.f2656a.m6080a((C2148i<TResult>) tresult);
    }
}
