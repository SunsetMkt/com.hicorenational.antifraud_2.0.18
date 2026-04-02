package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: LottieTask.java */
/* JADX INFO: loaded from: classes.dex */
public class q<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Executor f2235e = Executors.newCachedThreadPool();
    private final Set<l<T>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<l<Throwable>> f2236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f2237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private volatile p<T> f2238d;

    /* JADX INFO: compiled from: LottieTask.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q.this.f2238d == null) {
                return;
            }
            p pVar = q.this.f2238d;
            if (pVar.b() != null) {
                q.this.a(pVar.b());
            } else {
                q.this.a(pVar.a());
            }
        }
    }

    /* JADX INFO: compiled from: LottieTask.java */
    private class b extends FutureTask<p<T>> {
        b(Callable<p<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                q.this.a((p) get());
            } catch (InterruptedException | ExecutionException e2) {
                q.this.a(new p(e2));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public q(Callable<p<T>> callable) {
        this(callable, false);
    }

    public synchronized q<T> b(l<T> lVar) {
        if (this.f2238d != null && this.f2238d.b() != null) {
            lVar.onResult(this.f2238d.b());
        }
        this.a.add(lVar);
        return this;
    }

    public synchronized q<T> c(l<Throwable> lVar) {
        this.f2236b.remove(lVar);
        return this;
    }

    public synchronized q<T> d(l<T> lVar) {
        this.a.remove(lVar);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    q(Callable<p<T>> callable, boolean z) {
        this.a = new LinkedHashSet(1);
        this.f2236b = new LinkedHashSet(1);
        this.f2237c = new Handler(Looper.getMainLooper());
        this.f2238d = null;
        if (!z) {
            f2235e.execute(new b(callable));
            return;
        }
        try {
            a((p) callable.call());
        } catch (Throwable th) {
            a((p) new p<>(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable p<T> pVar) {
        if (this.f2238d == null) {
            this.f2238d = pVar;
            a();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized q<T> a(l<Throwable> lVar) {
        if (this.f2238d != null && this.f2238d.a() != null) {
            lVar.onResult(this.f2238d.a());
        }
        this.f2236b.add(lVar);
        return this;
    }

    private void a() {
        this.f2237c.post(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(T t) {
        Iterator it = new ArrayList(this.a).iterator();
        while (it.hasNext()) {
            ((l) it.next()).onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(Throwable th) {
        ArrayList arrayList = new ArrayList(this.f2236b);
        if (arrayList.isEmpty()) {
            com.airbnb.lottie.b0.d.c("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).onResult(th);
        }
    }
}
