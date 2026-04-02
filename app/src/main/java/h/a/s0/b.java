package h.a.s0;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: MainThreadDisposable.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements h.a.u0.c {
    private final AtomicBoolean a = new AtomicBoolean();

    /* JADX INFO: compiled from: MainThreadDisposable.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a();
        }
    }

    public static void b() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        throw new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName());
    }

    protected abstract void a();

    @Override // h.a.u0.c
    public final void dispose() {
        if (this.a.compareAndSet(false, true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                a();
            } else {
                h.a.s0.e.a.a().a(new a());
            }
        }
    }

    @Override // h.a.u0.c
    public final boolean isDisposed() {
        return this.a.get();
    }
}
