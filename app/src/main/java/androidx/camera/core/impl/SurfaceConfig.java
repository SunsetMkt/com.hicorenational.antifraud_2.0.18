package androidx.camera.core.impl;

import p031c.p035b.p036a.p037a.InterfaceC0950c;

@InterfaceC0950c
/* loaded from: classes.dex */
public abstract class SurfaceConfig {

    public enum ConfigSize {
        ANALYSIS(0),
        PREVIEW(1),
        RECORD(2),
        MAXIMUM(3),
        NOT_SUPPORT(4);

        final int mId;

        ConfigSize(int i2) {
            this.mId = i2;
        }

        int getId() {
            return this.mId;
        }
    }

    public enum ConfigType {
        PRIV,
        YUV,
        JPEG,
        RAW
    }

    SurfaceConfig() {
    }

    public static SurfaceConfig create(ConfigType configType, ConfigSize configSize) {
        return new AutoValue_SurfaceConfig(configType, configSize);
    }

    public abstract ConfigSize getConfigSize();

    public abstract ConfigType getConfigType();

    public final boolean isSupported(SurfaceConfig surfaceConfig) {
        return surfaceConfig.getConfigSize().getId() <= getConfigSize().getId() && surfaceConfig.getConfigType() == getConfigType();
    }
}
