package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.p100b0.C1354d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* compiled from: LottieTask.java */
/* renamed from: com.airbnb.lottie.q */
/* loaded from: classes.dex */
public class C1386q<T> {

    /* renamed from: e */
    public static Executor f3358e = Executors.newCachedThreadPool();

    /* renamed from: a */
    private final Set<InterfaceC1381l<T>> f3359a;

    /* renamed from: b */
    private final Set<InterfaceC1381l<Throwable>> f3360b;

    /* renamed from: c */
    private final Handler f3361c;

    /* renamed from: d */
    @Nullable
    private volatile C1385p<T> f3362d;

    /* compiled from: LottieTask.java */
    /* renamed from: com.airbnb.lottie.q$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C1386q.this.f3362d == null) {
                return;
            }
            C1385p c1385p = C1386q.this.f3362d;
            if (c1385p.m3061b() != null) {
                C1386q.this.m3068a((C1386q) c1385p.m3061b());
            } else {
                C1386q.this.m3069a(c1385p.m3060a());
            }
        }
    }

    /* compiled from: LottieTask.java */
    /* renamed from: com.airbnb.lottie.q$b */
    private class b extends FutureTask<C1385p<T>> {
        b(Callable<C1385p<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                C1386q.this.m3064a((C1385p) get());
            } catch (InterruptedException | ExecutionException e2) {
                C1386q.this.m3064a(new C1385p(e2));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public C1386q(Callable<C1385p<T>> callable) {
        this(callable, false);
    }

    /* renamed from: b */
    public synchronized C1386q<T> m3071b(InterfaceC1381l<T> interfaceC1381l) {
        if (this.f3362d != null && this.f3362d.m3061b() != null) {
            interfaceC1381l.onResult(this.f3362d.m3061b());
        }
        this.f3359a.add(interfaceC1381l);
        return this;
    }

    /* renamed from: c */
    public synchronized C1386q<T> m3072c(InterfaceC1381l<Throwable> interfaceC1381l) {
        this.f3360b.remove(interfaceC1381l);
        return this;
    }

    /* renamed from: d */
    public synchronized C1386q<T> m3073d(InterfaceC1381l<T> interfaceC1381l) {
        this.f3359a.remove(interfaceC1381l);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    C1386q(Callable<C1385p<T>> callable, boolean z) {
        this.f3359a = new LinkedHashSet(1);
        this.f3360b = new LinkedHashSet(1);
        this.f3361c = new Handler(Looper.getMainLooper());
        this.f3362d = null;
        if (!z) {
            f3358e.execute(new b(callable));
            return;
        }
        try {
            m3064a((C1385p) callable.call());
        } catch (Throwable th) {
            m3064a((C1385p) new C1385p<>(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3064a(@Nullable C1385p<T> c1385p) {
        if (this.f3362d == null) {
            this.f3362d = c1385p;
            m3063a();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    /* renamed from: a */
    public synchronized C1386q<T> m3070a(InterfaceC1381l<Throwable> interfaceC1381l) {
        if (this.f3362d != null && this.f3362d.m3060a() != null) {
            interfaceC1381l.onResult(this.f3362d.m3060a());
        }
        this.f3360b.add(interfaceC1381l);
        return this;
    }

    /* renamed from: a */
    private void m3063a() {
        this.f3361c.post(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m3068a(T t) {
        Iterator it = new ArrayList(this.f3359a).iterator();
        while (it.hasNext()) {
            ((InterfaceC1381l) it.next()).onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m3069a(Throwable th) {
        ArrayList arrayList = new ArrayList(this.f3360b);
        if (arrayList.isEmpty()) {
            C1354d.m2793c("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((InterfaceC1381l) it.next()).onResult(th);
        }
    }
}
