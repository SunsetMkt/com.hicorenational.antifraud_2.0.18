package p251g.p252a.p268y0.p281g;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: DisposeOnCancel.java */
/* renamed from: g.a.y0.g.c */
/* loaded from: classes2.dex */
final class FutureC5114c implements Future<Object> {

    /* renamed from: a */
    final InterfaceC4552c f19856a;

    FutureC5114c(InterfaceC4552c interfaceC4552c) {
        this.f19856a = interfaceC4552c;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        this.f19856a.dispose();
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get() throws InterruptedException, ExecutionException {
        return null;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return false;
    }
}
