package b.a.t;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class f implements Future<b.a.i> {
    private m a;

    /* JADX INFO: renamed from: b */
    private boolean f1863b;

    public f(m mVar) {
        this.a = mVar;
    }

    @Override // java.util.concurrent.Future
    /* JADX INFO: renamed from: a */
    public b.a.i get() throws ExecutionException, InterruptedException {
        throw new RuntimeException("NOT SUPPORT!");
    }

    public b.a.i b() throws ExecutionException, InterruptedException, TimeoutException {
        throw new RuntimeException("NOT SUPPORT!");
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        if (!this.f1863b) {
            this.a.b();
            this.f1863b = true;
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f1863b;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        throw new RuntimeException("NOT SUPPORT!");
    }

    @Override // java.util.concurrent.Future
    public /* synthetic */ b.a.i get(long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return b();
    }
}
