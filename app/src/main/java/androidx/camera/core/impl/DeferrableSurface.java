package androidx.camera.core.impl;

import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicInteger;
import p031c.p035b.p040b.p041a.p042a.InterfaceFutureC0952a;

/* loaded from: classes.dex */
public abstract class DeferrableSurface {
    private static final boolean DEBUG = false;
    protected static final String TAG = "DeferrableSurface";

    @GuardedBy("mLock")
    private CallbackToFutureAdapter.Completer<Void> mTerminationCompleter;
    private static AtomicInteger sUsedCount = new AtomicInteger(0);
    private static AtomicInteger sTotalCount = new AtomicInteger(0);
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private int mUseCount = 0;

    @GuardedBy("mLock")
    private boolean mClosed = false;
    private final InterfaceFutureC0952a<Void> mTerminationFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.impl.c
        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
        public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
            return DeferrableSurface.this.m366a(completer);
        }
    });

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SurfaceClosedException extends Exception {
        DeferrableSurface mDeferrableSurface;

        public SurfaceClosedException(@NonNull String str, @NonNull DeferrableSurface deferrableSurface) {
            super(str);
            this.mDeferrableSurface = deferrableSurface;
        }

        @NonNull
        public DeferrableSurface getDeferrableSurface() {
            return this.mDeferrableSurface;
        }
    }

    public static final class SurfaceUnavailableException extends Exception {
        public SurfaceUnavailableException(@NonNull String str) {
            super(str);
        }
    }

    private /* synthetic */ void lambda$new$1(String str) {
        try {
            this.mTerminationFuture.get();
            printGlobalDebugCounts("Surface terminated", sTotalCount.decrementAndGet(), sUsedCount.get());
        } catch (Exception e2) {
            String str2 = "Unexpected surface termination for " + this + "\nStack Trace:\n" + str;
            throw new IllegalArgumentException("DeferrableSurface terminated with unexpected exception.", e2);
        }
    }

    private void printGlobalDebugCounts(@NonNull String str, int i2, int i3) {
        String str2 = str + "[total_surfaces=" + i2 + ", used_surfaces=" + i3 + "](" + this + "}";
    }

    /* renamed from: a */
    public /* synthetic */ Object m366a(CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.mLock) {
            this.mTerminationCompleter = completer;
        }
        return "DeferrableSurface-termination(" + this + ")";
    }

    public final void close() {
        CallbackToFutureAdapter.Completer<Void> completer;
        synchronized (this.mLock) {
            if (!this.mClosed) {
                this.mClosed = true;
                if (this.mUseCount == 0) {
                    completer = this.mTerminationCompleter;
                    this.mTerminationCompleter = null;
                }
            }
            completer = null;
        }
        if (completer != null) {
            completer.set(null);
        }
    }

    public void decrementUseCount() {
        CallbackToFutureAdapter.Completer<Void> completer;
        synchronized (this.mLock) {
            if (this.mUseCount == 0) {
                throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
            }
            this.mUseCount--;
            if (this.mUseCount == 0 && this.mClosed) {
                completer = this.mTerminationCompleter;
                this.mTerminationCompleter = null;
            } else {
                completer = null;
            }
        }
        if (completer != null) {
            completer.set(null);
        }
    }

    @NonNull
    public final InterfaceFutureC0952a<Surface> getSurface() {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return Futures.immediateFailedFuture(new SurfaceClosedException("DeferrableSurface already closed.", this));
            }
            return provideSurface();
        }
    }

    @NonNull
    public InterfaceFutureC0952a<Void> getTerminationFuture() {
        return Futures.nonCancellationPropagating(this.mTerminationFuture);
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public int getUseCount() {
        int i2;
        synchronized (this.mLock) {
            i2 = this.mUseCount;
        }
        return i2;
    }

    public void incrementUseCount() throws SurfaceClosedException {
        synchronized (this.mLock) {
            if (this.mUseCount == 0 && this.mClosed) {
                throw new SurfaceClosedException("Cannot begin use on a closed surface.", this);
            }
            this.mUseCount++;
        }
    }

    @NonNull
    protected abstract InterfaceFutureC0952a<Surface> provideSurface();
}
