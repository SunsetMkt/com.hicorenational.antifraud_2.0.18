package d.c.a.d;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: TaskExecutors.java */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final l f10100d = new l();
    private final Executor a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExecutorService f10101b = com.hihonor.cloudservice.tasks.q.g.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f10102c = com.hihonor.cloudservice.tasks.q.g.a();

    /* JADX INFO: compiled from: TaskExecutors.java */
    static final class a implements Executor {
        a() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    }

    private l() {
    }

    static ExecutorService a() {
        return f10100d.f10101b;
    }

    public static Executor b() {
        return f10100d.a;
    }

    public static Executor c() {
        return f10100d.f10102c;
    }
}
