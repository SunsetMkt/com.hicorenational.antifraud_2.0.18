package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.UseCaseConfig;

/* loaded from: classes.dex */
class Camera2CaptureOptionUnpacker implements CaptureConfig.OptionUnpacker {
    static final Camera2CaptureOptionUnpacker INSTANCE = new Camera2CaptureOptionUnpacker();

    Camera2CaptureOptionUnpacker() {
    }

    @Override // androidx.camera.core.impl.CaptureConfig.OptionUnpacker
    public void unpack(@NonNull UseCaseConfig<?> useCaseConfig, @NonNull CaptureConfig.Builder builder) {
        CaptureConfig defaultCaptureConfig = useCaseConfig.getDefaultCaptureConfig(null);
        Config emptyBundle = OptionsBundle.emptyBundle();
        int templateType = CaptureConfig.defaultEmptyCaptureConfig().getTemplateType();
        if (defaultCaptureConfig != null) {
            templateType = defaultCaptureConfig.getTemplateType();
            builder.addAllCameraCaptureCallbacks(defaultCaptureConfig.getCameraCaptureCallbacks());
            emptyBundle = defaultCaptureConfig.getImplementationOptions();
        }
        builder.setImplementationOptions(emptyBundle);
        Camera2ImplConfig camera2ImplConfig = new Camera2ImplConfig(useCaseConfig);
        builder.setTemplateType(camera2ImplConfig.getCaptureRequestTemplate(templateType));
        builder.addCameraCaptureCallback(CaptureCallbackContainer.create(camera2ImplConfig.getSessionCaptureCallback(Camera2CaptureCallbacks.createNoOpCallback())));
        Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
        for (Config.Option<?> option : camera2ImplConfig.getCaptureRequestOptions()) {
            builder2.setCaptureRequestOption((CaptureRequest.Key) option.getToken(), camera2ImplConfig.retrieveOption(option));
        }
        builder.addImplementationOptions(builder2.build());
    }
}
