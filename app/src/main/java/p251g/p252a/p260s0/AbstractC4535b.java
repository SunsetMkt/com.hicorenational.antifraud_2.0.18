package p251g.p252a.p260s0;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;
import p251g.p252a.p260s0.p262e.C4538a;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: MainThreadDisposable.java */
/* renamed from: g.a.s0.b */
/* loaded from: classes2.dex */
public abstract class AbstractC4535b implements InterfaceC4552c {

    /* renamed from: a */
    private final AtomicBoolean f17447a = new AtomicBoolean();

    /* compiled from: MainThreadDisposable.java */
    /* renamed from: g.a.s0.b$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC4535b.this.m18164a();
        }
    }

    /* renamed from: b */
    public static void m18163b() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        throw new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName());
    }

    /* renamed from: a */
    protected abstract void m18164a();

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final void dispose() {
        if (this.f17447a.compareAndSet(false, true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                m18164a();
            } else {
                C4538a.m18173a().mo17407a(new a());
            }
        }
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final boolean isDisposed() {
        return this.f17447a.get();
    }
}
