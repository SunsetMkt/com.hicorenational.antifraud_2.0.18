package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class CameraDeviceCompat {
    private static final CameraDeviceCompatImpl IMPL = chooseImplementation();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int SESSION_OPERATION_MODE_CONSTRAINED_HIGH_SPEED = 1;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int SESSION_OPERATION_MODE_NORMAL = 0;

    interface CameraDeviceCompatImpl {
        void createCaptureSession(@NonNull CameraDevice cameraDevice, @NonNull SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessException;
    }

    static final class StateCallbackExecutorWrapper extends CameraDevice.StateCallback {
        private final Executor mExecutor;
        final CameraDevice.StateCallback mWrappedCallback;

        /* JADX INFO: renamed from: androidx.camera.camera2.internal.compat.CameraDeviceCompat$StateCallbackExecutorWrapper$1 */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ CameraDevice val$camera;

            AnonymousClass1(CameraDevice cameraDevice) {
                cameraDevice = cameraDevice;
            }

            @Override // java.lang.Runnable
            public void run() {
                StateCallbackExecutorWrapper.this.mWrappedCallback.onOpened(cameraDevice);
            }
        }

        /* JADX INFO: renamed from: androidx.camera.camera2.internal.compat.CameraDeviceCompat$StateCallbackExecutorWrapper$2 */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ CameraDevice val$camera;

            AnonymousClass2(CameraDevice cameraDevice) {
                cameraDevice = cameraDevice;
            }

            @Override // java.lang.Runnable
            public void run() {
                StateCallbackExecutorWrapper.this.mWrappedCallback.onDisconnected(cameraDevice);
            }
        }

        /* JADX INFO: renamed from: androidx.camera.camera2.internal.compat.CameraDeviceCompat$StateCallbackExecutorWrapper$3 */
        class AnonymousClass3 implements Runnable {
            final /* synthetic */ CameraDevice val$camera;
            final /* synthetic */ int val$error;

            AnonymousClass3(CameraDevice cameraDevice, int i2) {
                cameraDevice = cameraDevice;
                i = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                StateCallbackExecutorWrapper.this.mWrappedCallback.onError(cameraDevice, i);
            }
        }

        /* JADX INFO: renamed from: androidx.camera.camera2.internal.compat.CameraDeviceCompat$StateCallbackExecutorWrapper$4 */
        class AnonymousClass4 implements Runnable {
            final /* synthetic */ CameraDevice val$camera;

            AnonymousClass4(CameraDevice cameraDevice) {
                cameraDevice = cameraDevice;
            }

            @Override // java.lang.Runnable
            public void run() {
                StateCallbackExecutorWrapper.this.mWrappedCallback.onClosed(cameraDevice);
            }
        }

        StateCallbackExecutorWrapper(@NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) {
            this.mExecutor = executor;
            this.mWrappedCallback = stateCallback;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(@NonNull CameraDevice cameraDevice) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraDeviceCompat.StateCallbackExecutorWrapper.4
                final /* synthetic */ CameraDevice val$camera;

                AnonymousClass4(CameraDevice cameraDevice2) {
                    cameraDevice = cameraDevice2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onClosed(cameraDevice);
                }
            });
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraDeviceCompat.StateCallbackExecutorWrapper.2
                final /* synthetic */ CameraDevice val$camera;

                AnonymousClass2(CameraDevice cameraDevice2) {
                    cameraDevice = cameraDevice2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onDisconnected(cameraDevice);
                }
            });
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull CameraDevice cameraDevice, int i2) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraDeviceCompat.StateCallbackExecutorWrapper.3
                final /* synthetic */ CameraDevice val$camera;
                final /* synthetic */ int val$error;

                AnonymousClass3(CameraDevice cameraDevice2, int i22) {
                    cameraDevice = cameraDevice2;
                    i = i22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onError(cameraDevice, i);
                }
            });
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull CameraDevice cameraDevice) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraDeviceCompat.StateCallbackExecutorWrapper.1
                final /* synthetic */ CameraDevice val$camera;

                AnonymousClass1(CameraDevice cameraDevice2) {
                    cameraDevice = cameraDevice2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onOpened(cameraDevice);
                }
            });
        }
    }

    private CameraDeviceCompat() {
    }

    private static CameraDeviceCompatImpl chooseImplementation() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 >= 28 ? new CameraDeviceCompatApi28Impl() : i2 >= 24 ? new CameraDeviceCompatApi24Impl() : i2 >= 23 ? new CameraDeviceCompatApi23Impl() : new CameraDeviceCompatBaseImpl();
    }

    public static void createCaptureSession(@NonNull CameraDevice cameraDevice, @NonNull SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessException {
        IMPL.createCaptureSession(cameraDevice, sessionConfigurationCompat);
    }
}
