package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Looper;
import androidx.annotation.FloatRange;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.camera.camera2.internal.Camera2CameraControl;
import androidx.camera.core.CameraControl;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.ImmutableZoomState;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import p031c.p035b.p040b.p041a.p042a.InterfaceFutureC0952a;

/* loaded from: classes.dex */
final class ZoomControl {
    public static final float DEFAULT_ZOOM_RATIO = 1.0f;
    public static final float MIN_ZOOM = 1.0f;
    private static final String TAG = "ZoomControl";
    private final Camera2CameraControl mCamera2CameraControl;

    @GuardedBy("mActiveLock")
    private final ZoomStateImpl mCurrentZoomState;

    @GuardedBy("mCompleterLock")
    CallbackToFutureAdapter.Completer<Void> mPendingZoomRatioCompleter;
    private final MutableLiveData<ZoomState> mZoomStateLiveData;
    final Object mCompleterLock = new Object();

    @GuardedBy("mCompleterLock")
    Rect mPendingZoomCropRegion = null;
    final Object mActiveLock = new Object();

    @GuardedBy("mActiveLock")
    private boolean mIsActive = false;
    private Camera2CameraControl.CaptureResultListener mCaptureResultListener = new Camera2CameraControl.CaptureResultListener() { // from class: androidx.camera.camera2.internal.ZoomControl.1
        @Override // androidx.camera.camera2.internal.Camera2CameraControl.CaptureResultListener
        @WorkerThread
        public boolean onCaptureResult(@NonNull TotalCaptureResult totalCaptureResult) {
            CallbackToFutureAdapter.Completer<Void> completer;
            synchronized (ZoomControl.this.mCompleterLock) {
                if (ZoomControl.this.mPendingZoomRatioCompleter != null) {
                    CaptureRequest request = totalCaptureResult.getRequest();
                    Rect rect = request == null ? null : (Rect) request.get(CaptureRequest.SCALER_CROP_REGION);
                    if (ZoomControl.this.mPendingZoomCropRegion != null && ZoomControl.this.mPendingZoomCropRegion.equals(rect)) {
                        completer = ZoomControl.this.mPendingZoomRatioCompleter;
                        ZoomControl.this.mPendingZoomRatioCompleter = null;
                        ZoomControl.this.mPendingZoomCropRegion = null;
                    }
                }
                completer = null;
            }
            if (completer == null) {
                return false;
            }
            completer.set(null);
            return false;
        }
    };

    ZoomControl(@NonNull Camera2CameraControl camera2CameraControl, @NonNull CameraCharacteristics cameraCharacteristics) {
        this.mCamera2CameraControl = camera2CameraControl;
        this.mCurrentZoomState = new ZoomStateImpl(getMaxDigitalZoom(cameraCharacteristics), 1.0f);
        this.mCurrentZoomState.setZoomRatio(1.0f);
        this.mZoomStateLiveData = new MutableLiveData<>(ImmutableZoomState.create(this.mCurrentZoomState));
        camera2CameraControl.addCaptureResultListener(this.mCaptureResultListener);
    }

    @NonNull
    @VisibleForTesting
    static Rect getCropRectByRatio(@NonNull Rect rect, float f2) {
        float width = rect.width() / f2;
        float height = rect.height() / f2;
        float width2 = (rect.width() - width) / 2.0f;
        float height2 = (rect.height() - height) / 2.0f;
        return new Rect((int) width2, (int) height2, (int) (width2 + width), (int) (height2 + height));
    }

    private static float getMaxDigitalZoom(CameraCharacteristics cameraCharacteristics) {
        Float f2 = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f2 == null) {
            return 1.0f;
        }
        return f2.floatValue();
    }

    @NonNull
    @GuardedBy("mActiveLock")
    private InterfaceFutureC0952a<Void> submitCameraZoomRatio(float f2) {
        final Rect cropRectByRatio = getCropRectByRatio(this.mCamera2CameraControl.getSensorRect(), f2);
        this.mCamera2CameraControl.setCropRegion(cropRectByRatio);
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.a0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return ZoomControl.this.m320a(cropRectByRatio, completer);
            }
        });
    }

    private void updateLiveData(ZoomState zoomState) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.mZoomStateLiveData.setValue(zoomState);
        } else {
            this.mZoomStateLiveData.postValue(zoomState);
        }
    }

    /* renamed from: a */
    public /* synthetic */ Object m320a(Rect rect, CallbackToFutureAdapter.Completer completer) throws Exception {
        CallbackToFutureAdapter.Completer<Void> completer2;
        synchronized (this.mCompleterLock) {
            if (this.mPendingZoomRatioCompleter != null) {
                completer2 = this.mPendingZoomRatioCompleter;
                this.mPendingZoomRatioCompleter = null;
            } else {
                completer2 = null;
            }
            this.mPendingZoomCropRegion = rect;
            this.mPendingZoomRatioCompleter = completer;
        }
        if (completer2 == null) {
            return "setZoomRatio";
        }
        completer2.setException(new CameraControl.OperationCanceledException("There is a new zoomRatio being set"));
        return "setZoomRatio";
    }

    LiveData<ZoomState> getZoomState() {
        return this.mZoomStateLiveData;
    }

    @WorkerThread
    void setActive(boolean z) {
        boolean z2;
        CallbackToFutureAdapter.Completer<Void> completer;
        synchronized (this.mActiveLock) {
            if (this.mIsActive == z) {
                return;
            }
            this.mIsActive = z;
            if (this.mIsActive) {
                z2 = false;
                completer = null;
            } else {
                synchronized (this.mCompleterLock) {
                    if (this.mPendingZoomRatioCompleter != null) {
                        completer = this.mPendingZoomRatioCompleter;
                        this.mPendingZoomRatioCompleter = null;
                        this.mPendingZoomCropRegion = null;
                    } else {
                        completer = null;
                    }
                }
                z2 = true;
                this.mCurrentZoomState.setZoomRatio(1.0f);
                updateLiveData(ImmutableZoomState.create(this.mCurrentZoomState));
            }
            if (z2) {
                this.mCamera2CameraControl.setCropRegion(null);
            }
            if (completer != null) {
                completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
            }
        }
    }

    @NonNull
    InterfaceFutureC0952a<Void> setLinearZoom(@FloatRange(from = 0.0d, m293to = 1.0d) float f2) {
        synchronized (this.mActiveLock) {
            if (!this.mIsActive) {
                return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
            }
            try {
                this.mCurrentZoomState.setLinearZoom(f2);
                updateLiveData(ImmutableZoomState.create(this.mCurrentZoomState));
                return submitCameraZoomRatio(this.mCurrentZoomState.getZoomRatio());
            } catch (IllegalArgumentException e2) {
                return Futures.immediateFailedFuture(e2);
            }
        }
    }

    @NonNull
    InterfaceFutureC0952a<Void> setZoomRatio(float f2) {
        synchronized (this.mActiveLock) {
            if (!this.mIsActive) {
                return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
            }
            try {
                this.mCurrentZoomState.setZoomRatio(f2);
                updateLiveData(ImmutableZoomState.create(this.mCurrentZoomState));
                return submitCameraZoomRatio(f2);
            } catch (IllegalArgumentException e2) {
                return Futures.immediateFailedFuture(e2);
            }
        }
    }
}
