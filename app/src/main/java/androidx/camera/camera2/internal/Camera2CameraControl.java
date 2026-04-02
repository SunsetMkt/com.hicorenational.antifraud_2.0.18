package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Rational;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
final class Camera2CameraControl implements CameraControlInternal {
    private final AeFpsRange mAeFpsRange;
    private final CameraCharacteristics mCameraCharacteristics;
    private final CameraControlInternal.ControlUpdateCallback mControlUpdateCallback;
    final Executor mExecutor;
    private final FocusMeteringControl mFocusMeteringControl;

    @VisibleForTesting
    final CameraControlSessionCallback mSessionCallback;
    private final TorchControl mTorchControl;
    private final ZoomControl mZoomControl;
    private final SessionConfig.Builder mSessionConfigBuilder = new SessionConfig.Builder();
    volatile Rational mPreviewAspectRatio = null;
    private volatile boolean mIsTorchOn = false;
    private volatile int mFlashMode = 2;
    private Rect mCropRect = null;

    static final class CameraControlSessionCallback extends CameraCaptureSession.CaptureCallback {
        private final Executor mExecutor;
        final Set<CaptureResultListener> mResultListeners = new HashSet();

        CameraControlSessionCallback(@NonNull Executor executor) {
            this.mExecutor = executor;
        }

        public /* synthetic */ void a(TotalCaptureResult totalCaptureResult) {
            HashSet hashSet = new HashSet();
            for (CaptureResultListener captureResultListener : this.mResultListeners) {
                if (captureResultListener.onCaptureResult(totalCaptureResult)) {
                    hashSet.add(captureResultListener);
                }
            }
            if (hashSet.isEmpty()) {
                return;
            }
            this.mResultListeners.removeAll(hashSet);
        }

        @WorkerThread
        void addListener(@NonNull CaptureResultListener captureResultListener) {
            this.mResultListeners.add(captureResultListener);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull final TotalCaptureResult totalCaptureResult) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(totalCaptureResult);
                }
            });
        }

        @WorkerThread
        void removeListener(@NonNull CaptureResultListener captureResultListener) {
            this.mResultListeners.remove(captureResultListener);
        }
    }

    interface CaptureResultListener {
        boolean onCaptureResult(@NonNull TotalCaptureResult totalCaptureResult);
    }

    Camera2CameraControl(@NonNull CameraCharacteristics cameraCharacteristics, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Executor executor, @NonNull CameraControlInternal.ControlUpdateCallback controlUpdateCallback) {
        this.mCameraCharacteristics = cameraCharacteristics;
        this.mControlUpdateCallback = controlUpdateCallback;
        this.mExecutor = executor;
        this.mSessionCallback = new CameraControlSessionCallback(this.mExecutor);
        this.mSessionConfigBuilder.setTemplateType(getDefaultTemplate());
        this.mSessionConfigBuilder.addRepeatingCameraCaptureCallback(CaptureCallbackContainer.create(this.mSessionCallback));
        this.mFocusMeteringControl = new FocusMeteringControl(this, scheduledExecutorService, this.mExecutor);
        this.mZoomControl = new ZoomControl(this, this.mCameraCharacteristics);
        this.mTorchControl = new TorchControl(this, this.mCameraCharacteristics);
        this.mAeFpsRange = new AeFpsRange(this.mCameraCharacteristics);
        this.mExecutor.execute(new c0(this));
    }

    @WorkerThread
    private int getSupportedAeMode(int i2) {
        int[] iArr = (int[]) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        return isModeInList(i2, iArr) ? i2 : isModeInList(1, iArr) ? 1 : 0;
    }

    @WorkerThread
    private int getSupportedAwbMode(int i2) {
        int[] iArr = (int[]) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        return isModeInList(i2, iArr) ? i2 : isModeInList(1, iArr) ? 1 : 0;
    }

    @WorkerThread
    private boolean isModeInList(int i2, int[] iArr) {
        for (int i3 : iArr) {
            if (i2 == i3) {
                return true;
            }
        }
        return false;
    }

    @WorkerThread
    void addCaptureResultListener(@NonNull CaptureResultListener captureResultListener) {
        this.mSessionCallback.addListener(captureResultListener);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void cancelAfAeTrigger(final boolean z, final boolean z2) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.e
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(z, z2);
            }
        });
    }

    @Override // androidx.camera.core.CameraControl
    @NonNull
    public d.b.b.a.a.a<Void> cancelFocusAndMetering() {
        return this.mFocusMeteringControl.cancelFocusAndMetering();
    }

    @Override // androidx.camera.core.CameraControl
    @NonNull
    public d.b.b.a.a.a<Void> enableTorch(boolean z) {
        return this.mTorchControl.enableTorch(z);
    }

    void enableTorchInternal(final boolean z) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.b
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(z);
            }
        });
    }

    @NonNull
    @WorkerThread
    Rect getCropSensorRegion() {
        Rect rect = this.mCropRect;
        return rect == null ? getSensorRect() : rect;
    }

    int getDefaultTemplate() {
        return 1;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public int getFlashMode() {
        return this.mFlashMode;
    }

    int getMaxAeRegionCount() {
        Integer num = (Integer) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    int getMaxAfRegionCount() {
        Integer num = (Integer) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    int getMaxAwbRegionCount() {
        Integer num = (Integer) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @NonNull
    @WorkerThread
    Rect getSensorRect() {
        return (Rect) Preconditions.checkNotNull(this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0051  */
    @VisibleForTesting
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    Config getSessionOptions() {
        int i2;
        Rect rect;
        Camera2ImplConfig.Builder builder = new Camera2ImplConfig.Builder();
        builder.setCaptureRequestOption(CaptureRequest.CONTROL_MODE, 1);
        this.mFocusMeteringControl.addFocusMeteringOptions(builder);
        this.mAeFpsRange.addAeFpsRangeOptions(builder);
        if (!this.mIsTorchOn) {
            int i3 = this.mFlashMode;
            if (i3 == 0) {
                i2 = 2;
            } else if (i3 == 1) {
                i2 = 3;
            }
            builder.setCaptureRequestOption(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(getSupportedAeMode(i2)));
            builder.setCaptureRequestOption(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(getSupportedAwbMode(1)));
            rect = this.mCropRect;
            if (rect != null) {
                builder.setCaptureRequestOption(CaptureRequest.SCALER_CROP_REGION, rect);
            }
            return builder.build();
        }
        builder.setCaptureRequestOption(CaptureRequest.FLASH_MODE, 2);
        i2 = 1;
        builder.setCaptureRequestOption(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(getSupportedAeMode(i2)));
        builder.setCaptureRequestOption(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(getSupportedAwbMode(1)));
        rect = this.mCropRect;
        if (rect != null) {
        }
        return builder.build();
    }

    @WorkerThread
    int getSupportedAfMode(int i2) {
        int[] iArr = (int[]) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        if (isModeInList(i2, iArr)) {
            return i2;
        }
        if (isModeInList(4, iArr)) {
            return 4;
        }
        return isModeInList(1, iArr) ? 1 : 0;
    }

    @NonNull
    public TorchControl getTorchControl() {
        return this.mTorchControl;
    }

    @NonNull
    public ZoomControl getZoomControl() {
        return this.mZoomControl;
    }

    @WorkerThread
    void removeCaptureResultListener(@NonNull CaptureResultListener captureResultListener) {
        this.mSessionCallback.removeListener(captureResultListener);
    }

    void setActive(boolean z) {
        this.mFocusMeteringControl.setActive(z);
        this.mZoomControl.setActive(z);
        this.mTorchControl.setActive(z);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void setCropRegion(@Nullable final Rect rect) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.f
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(rect);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    /* JADX INFO: renamed from: setCropRegionInternal, reason: merged with bridge method [inline-methods] */
    public void a(Rect rect) {
        this.mCropRect = rect;
        updateSessionConfig();
    }

    public void setDefaultRequestBuilder(@NonNull CaptureRequest.Builder builder) {
        this.mFocusMeteringControl.setDefaultRequestBuilder(builder);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void setFlashMode(int i2) {
        this.mFlashMode = i2;
        this.mExecutor.execute(new c0(this));
    }

    @Override // androidx.camera.core.CameraControl
    @NonNull
    public d.b.b.a.a.a<Void> setLinearZoom(float f2) {
        return this.mZoomControl.setLinearZoom(f2);
    }

    @WorkerThread
    public void setPreviewAspectRatio(@Nullable Rational rational) {
        this.mPreviewAspectRatio = rational;
    }

    @Override // androidx.camera.core.CameraControl
    @NonNull
    public d.b.b.a.a.a<Void> setZoomRatio(float f2) {
        return this.mZoomControl.setZoomRatio(f2);
    }

    @Override // androidx.camera.core.CameraControl
    @NonNull
    public d.b.b.a.a.a<FocusMeteringResult> startFocusAndMetering(@NonNull FocusMeteringAction focusMeteringAction) {
        return this.mFocusMeteringControl.startFocusAndMetering(focusMeteringAction, this.mPreviewAspectRatio);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void submitCaptureRequests(@NonNull final List<CaptureConfig> list) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.d
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    /* JADX INFO: renamed from: submitCaptureRequestsInternal, reason: merged with bridge method [inline-methods] */
    public void a(List<CaptureConfig> list) {
        this.mControlUpdateCallback.onCameraControlCaptureRequests(list);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void triggerAePrecapture() {
        Executor executor = this.mExecutor;
        final FocusMeteringControl focusMeteringControl = this.mFocusMeteringControl;
        focusMeteringControl.getClass();
        executor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.a
            @Override // java.lang.Runnable
            public final void run() {
                focusMeteringControl.triggerAePrecapture();
            }
        });
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void triggerAf() {
        Executor executor = this.mExecutor;
        final FocusMeteringControl focusMeteringControl = this.mFocusMeteringControl;
        focusMeteringControl.getClass();
        executor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.b0
            @Override // java.lang.Runnable
            public final void run() {
                focusMeteringControl.triggerAf();
            }
        });
    }

    @WorkerThread
    void updateSessionConfig() {
        this.mSessionConfigBuilder.setImplementationOptions(getSessionOptions());
        this.mControlUpdateCallback.onCameraControlUpdateSessionConfig(this.mSessionConfigBuilder.build());
    }

    public /* synthetic */ void a(boolean z, boolean z2) {
        this.mFocusMeteringControl.cancelAfAeTrigger(z, z2);
    }

    public /* synthetic */ void a(boolean z) {
        this.mIsTorchOn = z;
        if (!z) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setTemplateType(getDefaultTemplate());
            builder.setUseRepeatingSurface(true);
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(getSupportedAeMode(1)));
            builder2.setCaptureRequestOption(CaptureRequest.FLASH_MODE, 0);
            builder.addImplementationOptions(builder2.build());
            a(Collections.singletonList(builder.build()));
        }
        updateSessionConfig();
    }
}
