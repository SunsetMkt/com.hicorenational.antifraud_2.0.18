package androidx.camera.core.impl.utils.executor;

import androidx.annotation.GuardedBy;
import androidx.core.util.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
final class SequentialExecutor implements Executor {
    private static final String TAG = "SequentialExecutor";
    private final Executor mExecutor;

    @GuardedBy("mQueue")
    final Deque<Runnable> mQueue = new ArrayDeque();
    private final QueueWorker mWorker = new QueueWorker();

    @GuardedBy("mQueue")
    WorkerRunningState mWorkerRunningState = WorkerRunningState.IDLE;

    @GuardedBy("mQueue")
    long mWorkerRunCount = 0;

    final class QueueWorker implements Runnable {
        QueueWorker() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x004f, code lost:
        
            r3.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0053, code lost:
        
            r0 = "Exception while executing runnable " + r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void workOnQueue() {
            boolean z = false;
            boolean zInterrupted = false;
            while (true) {
                try {
                    synchronized (SequentialExecutor.this.mQueue) {
                        if (!z) {
                            if (SequentialExecutor.this.mWorkerRunningState != WorkerRunningState.RUNNING) {
                                SequentialExecutor.this.mWorkerRunCount++;
                                SequentialExecutor.this.mWorkerRunningState = WorkerRunningState.RUNNING;
                                z = true;
                            }
                        }
                        Runnable runnablePoll = SequentialExecutor.this.mQueue.poll();
                        if (runnablePoll == null) {
                            SequentialExecutor.this.mWorkerRunningState = WorkerRunningState.IDLE;
                        }
                    }
                    if (zInterrupted) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                } finally {
                    if (zInterrupted) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                workOnQueue();
            } catch (Error e2) {
                synchronized (SequentialExecutor.this.mQueue) {
                    SequentialExecutor.this.mWorkerRunningState = WorkerRunningState.IDLE;
                    throw e2;
                }
            }
        }
    }

    enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    SequentialExecutor(Executor executor) {
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        synchronized (this.mQueue) {
            if (this.mWorkerRunningState != WorkerRunningState.RUNNING && this.mWorkerRunningState != WorkerRunningState.QUEUED) {
                long j2 = this.mWorkerRunCount;
                Runnable runnable2 = new Runnable() { // from class: androidx.camera.core.impl.utils.executor.SequentialExecutor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        runnable.run();
                    }
                };
                this.mQueue.add(runnable2);
                this.mWorkerRunningState = WorkerRunningState.QUEUING;
                try {
                    this.mExecutor.execute(this.mWorker);
                    if (this.mWorkerRunningState != WorkerRunningState.QUEUING) {
                        return;
                    }
                    synchronized (this.mQueue) {
                        if (this.mWorkerRunCount == j2 && this.mWorkerRunningState == WorkerRunningState.QUEUING) {
                            this.mWorkerRunningState = WorkerRunningState.QUEUED;
                        }
                    }
                    return;
                } catch (Error | RuntimeException e2) {
                    synchronized (this.mQueue) {
                        if ((this.mWorkerRunningState != WorkerRunningState.IDLE && this.mWorkerRunningState != WorkerRunningState.QUEUING) || !this.mQueue.removeLastOccurrence(runnable2)) {
                            z = false;
                        }
                        if (!(e2 instanceof RejectedExecutionException) || z) {
                            throw e2;
                        }
                    }
                    return;
                }
            }
            this.mQueue.add(runnable);
        }
    }
}
