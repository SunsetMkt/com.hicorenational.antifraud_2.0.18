package androidx.camera.core;

import androidx.annotation.Nullable;
import p031c.p035b.p036a.p037a.InterfaceC0950c;

@InterfaceC0950c
/* loaded from: classes.dex */
abstract class ImmutableImageInfo implements ImageInfo {
    ImmutableImageInfo() {
    }

    public static ImageInfo create(@Nullable Object obj, long j2, int i2) {
        return new AutoValue_ImmutableImageInfo(obj, j2, i2);
    }

    @Override // androidx.camera.core.ImageInfo
    public abstract int getRotationDegrees();

    @Override // androidx.camera.core.ImageInfo
    @Nullable
    public abstract Object getTag();

    @Override // androidx.camera.core.ImageInfo
    public abstract long getTimestamp();
}
