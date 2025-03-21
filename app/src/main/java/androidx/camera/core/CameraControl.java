package androidx.camera.core;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import p031c.p035b.p040b.p041a.p042a.InterfaceFutureC0952a;

/* loaded from: classes.dex */
public interface CameraControl {

    public static final class OperationCanceledException extends Exception {
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public OperationCanceledException(@NonNull String str) {
            super(str);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public OperationCanceledException(@NonNull String str, @NonNull Throwable th) {
            super(str, th);
        }
    }

    @NonNull
    InterfaceFutureC0952a<Void> cancelFocusAndMetering();

    @NonNull
    InterfaceFutureC0952a<Void> enableTorch(boolean z);

    @NonNull
    InterfaceFutureC0952a<Void> setLinearZoom(@FloatRange(from = 0.0d, m293to = 1.0d) float f2);

    @NonNull
    InterfaceFutureC0952a<Void> setZoomRatio(float f2);

    @NonNull
    InterfaceFutureC0952a<FocusMeteringResult> startFocusAndMetering(@NonNull FocusMeteringAction focusMeteringAction);
}
