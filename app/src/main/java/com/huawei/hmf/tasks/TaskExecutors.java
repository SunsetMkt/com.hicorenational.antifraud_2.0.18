package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.p170a.C2271a;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public final class TaskExecutors {
    private static final TaskExecutors INSTANCE = new TaskExecutors();
    private final ExecutorService mBackground = C2271a.m6471a();
    private final Executor mImmediate = new ImmediateExecutor();
    private final Executor mUiThread = C2271a.m6472b();

    static final class ImmediateExecutor implements Executor {
        ImmediateExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    }

    private TaskExecutors() {
    }

    static ExecutorService background() {
        return INSTANCE.mBackground;
    }

    public static Executor immediate() {
        return INSTANCE.mImmediate;
    }

    public static Executor uiThread() {
        return INSTANCE.mUiThread;
    }
}
