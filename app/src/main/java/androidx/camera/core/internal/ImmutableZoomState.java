package androidx.camera.core.internal;

import androidx.annotation.NonNull;
import androidx.camera.core.ZoomState;
import p031c.p035b.p036a.p037a.InterfaceC0950c;

@InterfaceC0950c
/* loaded from: classes.dex */
public abstract class ImmutableZoomState implements ZoomState {
    @NonNull
    public static ZoomState create(float f2, float f3, float f4, float f5) {
        return new AutoValue_ImmutableZoomState(f2, f3, f4, f5);
    }

    @Override // androidx.camera.core.ZoomState
    public abstract float getLinearZoom();

    @Override // androidx.camera.core.ZoomState
    public abstract float getMaxZoomRatio();

    @Override // androidx.camera.core.ZoomState
    public abstract float getMinZoomRatio();

    @Override // androidx.camera.core.ZoomState
    public abstract float getZoomRatio();

    @NonNull
    public static ZoomState create(@NonNull ZoomState zoomState) {
        return new AutoValue_ImmutableZoomState(zoomState.getZoomRatio(), zoomState.getMaxZoomRatio(), zoomState.getMinZoomRatio(), zoomState.getLinearZoom());
    }
}
