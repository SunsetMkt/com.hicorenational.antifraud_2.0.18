package androidx.camera.camera2.interop;

import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.Camera2CameraInfoImpl;
import androidx.camera.core.CameraInfo;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalCamera2Interop
public final class Camera2CameraInfo {
    private Camera2CameraInfo() {
    }

    @NonNull
    public static String extractCameraId(@NonNull CameraInfo cameraInfo) {
        Preconditions.checkState(cameraInfo instanceof Camera2CameraInfoImpl, "CameraInfo does not contain any Camera2 information.");
        return ((Camera2CameraInfoImpl) cameraInfo).getCameraId();
    }
}
