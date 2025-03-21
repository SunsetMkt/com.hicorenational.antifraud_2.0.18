package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.Camera2CameraControl;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import p031c.p035b.p040b.p041a.p042a.InterfaceFutureC0952a;

/* loaded from: classes.dex */
final class TorchControl {
    private static final String TAG = "TorchControl";
    private final Camera2CameraControl mCamera2CameraControl;

    @GuardedBy("mEnableTorchLock")
    CallbackToFutureAdapter.Completer<Void> mEnableTorchCompleter;
    private final boolean mHasFlashUnit;

    @GuardedBy("mActiveLock")
    private boolean mIsActive;

    @GuardedBy("mEnableTorchLock")
    boolean mTargetTorchEnabled;
    private final MutableLiveData<Integer> mTorchState;
    final Object mEnableTorchLock = new Object();
    private final Object mActiveLock = new Object();
    private final Camera2CameraControl.CaptureResultListener mCaptureResultListener = new Camera2CameraControl.CaptureResultListener() { // from class: androidx.camera.camera2.internal.TorchControl.1
        @Override // androidx.camera.camera2.internal.Camera2CameraControl.CaptureResultListener
        public boolean onCaptureResult(@NonNull TotalCaptureResult totalCaptureResult) {
            CallbackToFutureAdapter.Completer<Void> completer;
            synchronized (TorchControl.this.mEnableTorchLock) {
                if (TorchControl.this.mEnableTorchCompleter != null) {
                    Integer num = (Integer) totalCaptureResult.getRequest().get(CaptureRequest.FLASH_MODE);
                    if ((num != null && num.intValue() == 2) == TorchControl.this.mTargetTorchEnabled) {
                        completer = TorchControl.this.mEnableTorchCompleter;
                        TorchControl.this.mEnableTorchCompleter = null;
                    }
                }
                completer = null;
            }
            if (completer != null) {
                completer.set(null);
            }
            return false;
        }
    };

    TorchControl(@NonNull Camera2CameraControl camera2CameraControl, @NonNull CameraCharacteristics cameraCharacteristics) {
        this.mCamera2CameraControl = camera2CameraControl;
        Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        this.mHasFlashUnit = bool != null && bool.booleanValue();
        this.mTorchState = new MutableLiveData<>(0);
        this.mCamera2CameraControl.addCaptureResultListener(this.mCaptureResultListener);
    }

    private <T> void setLiveDataValue(@NonNull MutableLiveData<T> mutableLiveData, T t) {
        if (Threads.isMainThread()) {
            mutableLiveData.setValue(t);
        } else {
            mutableLiveData.postValue(t);
        }
    }

    /* renamed from: a */
    public /* synthetic */ Object m319a(boolean z, CallbackToFutureAdapter.Completer completer) throws Exception {
        CallbackToFutureAdapter.Completer<Void> completer2;
        synchronized (this.mEnableTorchLock) {
            completer2 = this.mEnableTorchCompleter != null ? this.mEnableTorchCompleter : null;
            this.mEnableTorchCompleter = completer;
            this.mTargetTorchEnabled = z;
            this.mCamera2CameraControl.enableTorchInternal(z);
        }
        setLiveDataValue(this.mTorchState, Integer.valueOf(z ? 1 : 0));
        if (completer2 != null) {
            completer2.setException(new CameraControl.OperationCanceledException("There is a new enableTorch being set"));
        }
        return "enableTorch: " + z;
    }

    InterfaceFutureC0952a<Void> enableTorch(final boolean z) {
        if (!this.mHasFlashUnit) {
            return Futures.immediateFailedFuture(new IllegalStateException("No flash unit"));
        }
        synchronized (this.mActiveLock) {
            if (this.mIsActive) {
                return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.y
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                        return TorchControl.this.m319a(z, completer);
                    }
                });
            }
            return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
        }
    }

    @NonNull
    LiveData<Integer> getTorchState() {
        return this.mTorchState;
    }

    void setActive(boolean z) {
        CallbackToFutureAdapter.Completer<Void> completer;
        boolean z2;
        synchronized (this.mActiveLock) {
            if (this.mIsActive == z) {
                return;
            }
            this.mIsActive = z;
            synchronized (this.mEnableTorchLock) {
                completer = null;
                if (!z) {
                    if (this.mEnableTorchCompleter != null) {
                        CallbackToFutureAdapter.Completer<Void> completer2 = this.mEnableTorchCompleter;
                        this.mEnableTorchCompleter = null;
                        completer = completer2;
                    }
                    if (this.mTargetTorchEnabled) {
                        z2 = true;
                        this.mTargetTorchEnabled = false;
                        this.mCamera2CameraControl.enableTorchInternal(false);
                    }
                }
                z2 = false;
            }
            if (z2) {
                setLiveDataValue(this.mTorchState, 0);
            }
            if (completer != null) {
                completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
            }
        }
    }
}
