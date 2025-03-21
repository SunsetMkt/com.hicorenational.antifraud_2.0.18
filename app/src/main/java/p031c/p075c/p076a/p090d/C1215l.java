package p031c.p075c.p076a.p090d;

import com.hihonor.cloudservice.tasks.p161q.C2146g;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: TaskExecutors.java */
/* renamed from: c.c.a.d.l */
/* loaded from: classes.dex */
public final class C1215l {

    /* renamed from: d */
    private static final C1215l f2658d = new C1215l();

    /* renamed from: a */
    private final Executor f2659a = new a();

    /* renamed from: b */
    private final ExecutorService f2660b = C2146g.m6075b();

    /* renamed from: c */
    private final Executor f2661c = C2146g.m6074a();

    /* compiled from: TaskExecutors.java */
    /* renamed from: c.c.a.d.l$a */
    static final class a implements Executor {
        a() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    }

    private C1215l() {
    }

    /* renamed from: a */
    static ExecutorService m2348a() {
        return f2658d.f2660b;
    }

    /* renamed from: b */
    public static Executor m2349b() {
        return f2658d.f2659a;
    }

    /* renamed from: c */
    public static Executor m2350c() {
        return f2658d.f2661c;
    }
}
