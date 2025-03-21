package com.sina.weibo.sdk.p193a;

import com.sina.weibo.sdk.p193a.AbstractC2909c;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.sina.weibo.sdk.a.a */
/* loaded from: classes.dex */
public final class C2907a {

    /* renamed from: E */
    private static final int f9262E;

    /* renamed from: F */
    private static final int f9263F;

    /* renamed from: G */
    private static final int f9264G;

    /* renamed from: I */
    private static final Comparator<Runnable> f9265I;

    /* renamed from: H */
    private ThreadPoolExecutor f9266H;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f9262E = availableProcessors;
        f9263F = availableProcessors + 1;
        f9264G = (f9262E * 2) + 1;
        f9265I = new Comparator<Runnable>() { // from class: com.sina.weibo.sdk.a.a.1
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(Runnable runnable, Runnable runnable2) {
                return 0;
            }
        };
    }

    public C2907a() {
        if (this.f9266H == null) {
            this.f9266H = new ThreadPoolExecutor(f9263F, f9264G, 1L, TimeUnit.SECONDS, new PriorityBlockingQueue(5, f9265I));
        }
    }

    /* renamed from: a */
    public final void m8805a(AbstractC2909c abstractC2909c) {
        ThreadPoolExecutor threadPoolExecutor = this.f9266H;
        if (abstractC2909c.f9269L != AbstractC2909c.b.f9281U) {
            int i2 = AbstractC2909c.AnonymousClass4.f9278R[abstractC2909c.f9269L - 1];
            if (i2 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            if (i2 == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        abstractC2909c.f9269L = AbstractC2909c.b.f9282V;
        AbstractC2909c.d<Params, Result> dVar = abstractC2909c.f9270M;
        dVar.f9286Y = abstractC2909c.f9273P;
        dVar.priority = abstractC2909c.f9272O;
        threadPoolExecutor.execute(abstractC2909c.f9271N);
    }
}
