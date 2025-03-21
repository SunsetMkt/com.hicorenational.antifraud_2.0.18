package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.Camera;
import androidx.camera.core.UseCase;
import java.util.Collection;
import p031c.p035b.p040b.p041a.p042a.InterfaceFutureC0952a;

/* loaded from: classes.dex */
public interface CameraInternal extends Camera, UseCase.StateChangeCallback {

    public enum State {
        PENDING_OPEN,
        OPENING,
        OPEN,
        CLOSING,
        CLOSED,
        RELEASING,
        RELEASED
    }

    void addOnlineUseCase(@NonNull Collection<UseCase> collection);

    void close();

    @NonNull
    CameraControlInternal getCameraControlInternal();

    @NonNull
    CameraInfoInternal getCameraInfoInternal();

    @NonNull
    Observable<State> getCameraState();

    void open();

    @NonNull
    InterfaceFutureC0952a<Void> release();

    void removeOnlineUseCase(@NonNull Collection<UseCase> collection);
}
