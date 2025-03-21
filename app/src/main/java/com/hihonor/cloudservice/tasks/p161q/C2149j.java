package com.hihonor.cloudservice.tasks.p161q;

import android.os.Looper;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import p031c.p075c.p076a.p090d.AbstractC1213j;
import p031c.p075c.p076a.p090d.C1214k;
import p031c.p075c.p076a.p090d.C1215l;
import p031c.p075c.p076a.p090d.InterfaceC1206c;
import p031c.p075c.p076a.p090d.InterfaceC1208e;
import p031c.p075c.p076a.p090d.InterfaceC1210g;
import p031c.p075c.p076a.p090d.InterfaceC1211h;

/* compiled from: TaskManager.java */
/* renamed from: com.hihonor.cloudservice.tasks.q.j */
/* loaded from: classes.dex */
public class C2149j {

    /* compiled from: TaskManager.java */
    /* renamed from: com.hihonor.cloudservice.tasks.q.j$a */
    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C1214k f6484a;

        /* renamed from: b */
        final /* synthetic */ Callable f6485b;

        a(C2149j c2149j, C1214k c1214k, Callable callable) {
            this.f6484a = c1214k;
            this.f6485b = callable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f6484a.m2347a((C1214k) this.f6485b.call());
            } catch (Exception e2) {
                this.f6484a.m2346a(e2);
            }
        }
    }

    /* compiled from: TaskManager.java */
    /* renamed from: com.hihonor.cloudservice.tasks.q.j$b */
    class b implements InterfaceC1206c<Void, List<AbstractC1213j<?>>> {
        b() {
        }

        @Override // p031c.p075c.p076a.p090d.InterfaceC1206c
        /* renamed from: a, reason: avoid collision after fix types in other method */
        public List<AbstractC1213j<?>> mo2317a(AbstractC1213j<Void> abstractC1213j) {
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [TResult] */
    /* compiled from: TaskManager.java */
    /* renamed from: com.hihonor.cloudservice.tasks.q.j$c */
    class c<TResult> implements InterfaceC1206c<Void, List<TResult>> {
        c() {
        }

        @Override // p031c.p075c.p076a.p090d.InterfaceC1206c
        /* renamed from: a, reason: avoid collision after fix types in other method */
        public List<TResult> mo2317a(AbstractC1213j<Void> abstractC1213j) {
            return null;
        }
    }

    /* compiled from: TaskManager.java */
    /* renamed from: com.hihonor.cloudservice.tasks.q.j$d */
    public static class d<TResult> implements InterfaceC1208e, InterfaceC1210g, InterfaceC1211h<TResult> {

        /* renamed from: a */
        public final CountDownLatch f6486a = new CountDownLatch(1);

        @Override // p031c.p075c.p076a.p090d.InterfaceC1208e
        public final void onCanceled() {
            this.f6486a.countDown();
        }

        @Override // p031c.p075c.p076a.p090d.InterfaceC1210g
        public final void onFailure(Exception exc) {
            this.f6486a.countDown();
        }

        @Override // p031c.p075c.p076a.p090d.InterfaceC1211h
        public final void onSuccess(TResult tresult) {
            this.f6486a.countDown();
        }
    }

    /* renamed from: b */
    public static <TResult> AbstractC1213j<List<TResult>> m6086b(Collection<? extends AbstractC1213j<?>> collection) {
        return (AbstractC1213j<List<TResult>>) m6087c(collection).mo2324a(new c());
    }

    /* renamed from: c */
    public static AbstractC1213j<Void> m6087c(Collection<? extends AbstractC1213j<?>> collection) {
        if (collection.isEmpty()) {
            return m6082a((Object) null);
        }
        Iterator<? extends AbstractC1213j<?>> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("task can not is null");
            }
        }
        C2148i c2148i = new C2148i();
        C2147h c2147h = new C2147h(collection.size(), c2148i);
        for (AbstractC1213j<?> abstractC1213j : collection) {
            abstractC1213j.mo2334a(C1215l.m2349b(), (InterfaceC1211h<?>) c2147h);
            abstractC1213j.mo2333a(C1215l.m2349b(), (InterfaceC1210g) c2147h);
            abstractC1213j.mo2331a(C1215l.m2349b(), (InterfaceC1208e) c2147h);
        }
        return c2148i;
    }

    /* renamed from: a */
    public final <TResult> AbstractC1213j<TResult> m6088a(Executor executor, Callable<TResult> callable) {
        C1214k c1214k = new C1214k();
        try {
            executor.execute(new a(this, c1214k, callable));
        } catch (Exception e2) {
            c1214k.m2346a(e2);
        }
        return c1214k.m2345a();
    }

    /* renamed from: a */
    public static <TResult> AbstractC1213j<TResult> m6082a(TResult tresult) {
        C1214k c1214k = new C1214k();
        c1214k.m2347a((C1214k) tresult);
        return c1214k.m2345a();
    }

    /* renamed from: a */
    public static AbstractC1213j<List<AbstractC1213j<?>>> m6083a(Collection<? extends AbstractC1213j<?>> collection) {
        return m6087c(collection).mo2324a(new b());
    }

    /* renamed from: a */
    public static <TResult> TResult m6084a(AbstractC1213j<TResult> abstractC1213j) {
        if (abstractC1213j.mo2343e()) {
            return abstractC1213j.mo2340b();
        }
        throw new ExecutionException(abstractC1213j.mo2336a());
    }

    /* renamed from: a */
    public static void m6085a(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }
}
