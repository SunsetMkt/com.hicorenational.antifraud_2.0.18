package p000a.p001a.p013t;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p000a.p001a.InterfaceC0008i;

/* compiled from: Taobao */
/* renamed from: a.a.t.f */
/* loaded from: classes.dex */
class FutureC0041f implements Future<InterfaceC0008i> {

    /* renamed from: a */
    private C0048m f98a;

    /* renamed from: b */
    private boolean f99b;

    public FutureC0041f(C0048m c0048m) {
        this.f98a = c0048m;
    }

    @Override // java.util.concurrent.Future
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterfaceC0008i get() throws InterruptedException, ExecutionException {
        throw new RuntimeException("NOT SUPPORT!");
    }

    /* renamed from: b */
    public InterfaceC0008i m185b() throws InterruptedException, ExecutionException, TimeoutException {
        throw new RuntimeException("NOT SUPPORT!");
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        if (!this.f99b) {
            this.f98a.m202b();
            this.f99b = true;
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f99b;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        throw new RuntimeException("NOT SUPPORT!");
    }

    @Override // java.util.concurrent.Future
    public /* synthetic */ InterfaceC0008i get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return m185b();
    }
}
