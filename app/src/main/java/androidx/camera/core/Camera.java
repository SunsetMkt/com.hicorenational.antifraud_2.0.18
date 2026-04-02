package androidx.camera.core;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface Camera {
    @NonNull
    CameraControl getCameraControl();

    @NonNull
    CameraInfo getCameraInfo();
}
