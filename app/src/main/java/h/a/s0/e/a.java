package h.a.s0.e;

import android.os.Handler;
import android.os.Looper;
import h.a.j0;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: AndroidSchedulers.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final j0 a = h.a.s0.d.a.b(new CallableC0178a());

    /* JADX INFO: renamed from: h.a.s0.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AndroidSchedulers.java */
    static class CallableC0178a implements Callable<j0> {
        CallableC0178a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public j0 call() throws Exception {
            return b.a;
        }
    }

    /* JADX INFO: compiled from: AndroidSchedulers.java */
    private static final class b {
        static final j0 a = new h.a.s0.e.b(new Handler(Looper.getMainLooper()));

        private b() {
        }
    }

    private a() {
        throw new AssertionError("No instances.");
    }

    public static j0 a() {
        return h.a.s0.d.a.a(a);
    }

    public static j0 a(Looper looper) {
        if (looper != null) {
            return new h.a.s0.e.b(new Handler(looper));
        }
        throw new NullPointerException("looper == null");
    }
}
