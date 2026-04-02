package androidx.camera.camera2.internal.compat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import java.util.concurrent.Executor;
import util.permissionutil.a;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class CameraManagerCompat {
    private final CameraManagerCompatImpl mImpl;

    static final class AvailabilityCallbackExecutorWrapper extends CameraManager.AvailabilityCallback {
        private final Executor mExecutor;
        final CameraManager.AvailabilityCallback mWrappedCallback;

        /* JADX INFO: renamed from: androidx.camera.camera2.internal.compat.CameraManagerCompat$AvailabilityCallbackExecutorWrapper$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AvailabilityCallbackExecutorWrapper.this.mWrappedCallback.onCameraAccessPrioritiesChanged();
            }
        }

        /* JADX INFO: renamed from: androidx.camera.camera2.internal.compat.CameraManagerCompat$AvailabilityCallbackExecutorWrapper$2 */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ String val$cameraId;

            AnonymousClass2(String str) {
                str = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                AvailabilityCallbackExecutorWrapper.this.mWrappedCallback.onCameraAvailable(str);
            }
        }

        /* JADX INFO: renamed from: androidx.camera.camera2.internal.compat.CameraManagerCompat$AvailabilityCallbackExecutorWrapper$3 */
        class AnonymousClass3 implements Runnable {
            final /* synthetic */ String val$cameraId;

            AnonymousClass3(String str) {
                str = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                AvailabilityCallbackExecutorWrapper.this.mWrappedCallback.onCameraUnavailable(str);
            }
        }

        AvailabilityCallbackExecutorWrapper(@NonNull Executor executor, @NonNull CameraManager.AvailabilityCallback availabilityCallback) {
            this.mExecutor = executor;
            this.mWrappedCallback = availabilityCallback;
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        @RequiresApi(29)
        public void onCameraAccessPrioritiesChanged() {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraManagerCompat.AvailabilityCallbackExecutorWrapper.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    AvailabilityCallbackExecutorWrapper.this.mWrappedCallback.onCameraAccessPrioritiesChanged();
                }
            });
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(@NonNull String str) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraManagerCompat.AvailabilityCallbackExecutorWrapper.2
                final /* synthetic */ String val$cameraId;

                AnonymousClass2(String str2) {
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AvailabilityCallbackExecutorWrapper.this.mWrappedCallback.onCameraAvailable(str);
                }
            });
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraUnavailable(@NonNull String str) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraManagerCompat.AvailabilityCallbackExecutorWrapper.3
                final /* synthetic */ String val$cameraId;

                AnonymousClass3(String str2) {
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AvailabilityCallbackExecutorWrapper.this.mWrappedCallback.onCameraUnavailable(str);
                }
            });
        }
    }

    interface CameraManagerCompatImpl {
        @NonNull
        CameraManager getCameraManager();

        @RequiresPermission(a.f15026c)
        void openCamera(@NonNull String str, @NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) throws CameraAccessException;

        void registerAvailabilityCallback(@NonNull Executor executor, @NonNull CameraManager.AvailabilityCallback availabilityCallback);

        void unregisterAvailabilityCallback(@NonNull CameraManager.AvailabilityCallback availabilityCallback);
    }

    private CameraManagerCompat(CameraManagerCompatImpl cameraManagerCompatImpl) {
        this.mImpl = cameraManagerCompatImpl;
    }

    @NonNull
    public static CameraManagerCompat from(@NonNull Context context) {
        return Build.VERSION.SDK_INT >= 28 ? new CameraManagerCompat(new CameraManagerCompatApi28Impl(context)) : new CameraManagerCompat(new CameraManagerCompatBaseImpl(context));
    }

    @RequiresPermission(a.f15026c)
    public void openCamera(@NonNull String str, @NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) throws CameraAccessException {
        this.mImpl.openCamera(str, executor, stateCallback);
    }

    @SuppressLint({"LambdaLast"})
    public void registerAvailabilityCallback(@NonNull Executor executor, @NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        this.mImpl.registerAvailabilityCallback(executor, availabilityCallback);
    }

    public void unregisterAvailabilityCallback(@NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        this.mImpl.unregisterAvailabilityCallback(availabilityCallback);
    }

    @NonNull
    public CameraManager unwrap() {
        return this.mImpl.getCameraManager();
    }
}
