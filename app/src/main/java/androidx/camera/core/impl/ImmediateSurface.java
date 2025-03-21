package androidx.camera.core.impl;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.utils.futures.Futures;
import p031c.p035b.p040b.p041a.p042a.InterfaceFutureC0952a;

/* loaded from: classes.dex */
public final class ImmediateSurface extends DeferrableSurface {
    private final Surface mSurface;

    public ImmediateSurface(@NonNull Surface surface) {
        this.mSurface = surface;
    }

    @Override // androidx.camera.core.impl.DeferrableSurface
    @NonNull
    public InterfaceFutureC0952a<Surface> provideSurface() {
        return Futures.immediateFuture(this.mSurface);
    }
}
