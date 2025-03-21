package p251g.p252a.p260s0.p262e;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.p260s0.p261d.C4537a;

/* compiled from: AndroidSchedulers.java */
/* renamed from: g.a.s0.e.a */
/* loaded from: classes2.dex */
public final class C4538a {

    /* renamed from: a */
    private static final AbstractC4516j0 f17451a = C4537a.m18171b(new a());

    /* compiled from: AndroidSchedulers.java */
    /* renamed from: g.a.s0.e.a$a */
    static class a implements Callable<AbstractC4516j0> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public AbstractC4516j0 call() throws Exception {
            return b.f17452a;
        }
    }

    /* compiled from: AndroidSchedulers.java */
    /* renamed from: g.a.s0.e.a$b */
    private static final class b {

        /* renamed from: a */
        static final AbstractC4516j0 f17452a = new C4539b(new Handler(Looper.getMainLooper()));

        private b() {
        }
    }

    private C4538a() {
        throw new AssertionError("No instances.");
    }

    /* renamed from: a */
    public static AbstractC4516j0 m18173a() {
        return C4537a.m18165a(f17451a);
    }

    /* renamed from: a */
    public static AbstractC4516j0 m18174a(Looper looper) {
        if (looper != null) {
            return new C4539b(new Handler(looper));
        }
        throw new NullPointerException("looper == null");
    }
}
