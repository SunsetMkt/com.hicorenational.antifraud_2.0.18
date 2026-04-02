package com.hihonor.cloudservice.tasks.q;

import android.os.Looper;
import d.c.a.d.k;
import d.c.a.d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: TaskManager.java */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: compiled from: TaskManager.java */
    class a implements Runnable {
        final /* synthetic */ k a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Callable f4098b;

        a(j jVar, k kVar, Callable callable) {
            this.a = kVar;
            this.f4098b = callable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.a.a(this.f4098b.call());
            } catch (Exception e2) {
                this.a.a(e2);
            }
        }
    }

    /* JADX INFO: compiled from: TaskManager.java */
    class b implements d.c.a.d.c<Void, List<d.c.a.d.j<?>>> {
        b() {
        }

        @Override // d.c.a.d.c
        public List<d.c.a.d.j<?>> a(d.c.a.d.j<Void> jVar) {
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [TResult] */
    /* JADX INFO: compiled from: TaskManager.java */
    class c<TResult> implements d.c.a.d.c<Void, List<TResult>> {
        c() {
        }

        @Override // d.c.a.d.c
        public List<TResult> a(d.c.a.d.j<Void> jVar) {
            return null;
        }
    }

    /* JADX INFO: compiled from: TaskManager.java */
    public static class d<TResult> implements d.c.a.d.e, d.c.a.d.g, d.c.a.d.h<TResult> {
        public final CountDownLatch a = new CountDownLatch(1);

        @Override // d.c.a.d.e
        public final void onCanceled() {
            this.a.countDown();
        }

        @Override // d.c.a.d.g
        public final void onFailure(Exception exc) {
            this.a.countDown();
        }

        @Override // d.c.a.d.h
        public final void onSuccess(TResult tresult) {
            this.a.countDown();
        }
    }

    public static <TResult> d.c.a.d.j<List<TResult>> b(Collection<? extends d.c.a.d.j<?>> collection) {
        return (d.c.a.d.j<List<TResult>>) c(collection).a(new c());
    }

    public static d.c.a.d.j<Void> c(Collection<? extends d.c.a.d.j<?>> collection) {
        if (collection.isEmpty()) {
            return a((Object) null);
        }
        Iterator<? extends d.c.a.d.j<?>> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("task can not is null");
            }
        }
        i iVar = new i();
        h hVar = new h(collection.size(), iVar);
        for (d.c.a.d.j<?> jVar : collection) {
            jVar.a(l.b(), (d.c.a.d.h<?>) hVar);
            jVar.a(l.b(), (d.c.a.d.g) hVar);
            jVar.a(l.b(), (d.c.a.d.e) hVar);
        }
        return iVar;
    }

    public final <TResult> d.c.a.d.j<TResult> a(Executor executor, Callable<TResult> callable) {
        k kVar = new k();
        try {
            executor.execute(new a(this, kVar, callable));
        } catch (Exception e2) {
            kVar.a(e2);
        }
        return kVar.a();
    }

    public static <TResult> d.c.a.d.j<TResult> a(TResult tresult) {
        k kVar = new k();
        kVar.a(tresult);
        return kVar.a();
    }

    public static d.c.a.d.j<List<d.c.a.d.j<?>>> a(Collection<? extends d.c.a.d.j<?>> collection) {
        return c(collection).a(new b());
    }

    public static <TResult> TResult a(d.c.a.d.j<TResult> jVar) throws ExecutionException {
        if (jVar.e()) {
            return jVar.b();
        }
        throw new ExecutionException(jVar.a());
    }

    public static void a(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }
}
