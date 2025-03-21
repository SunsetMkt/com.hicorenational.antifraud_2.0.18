package androidx.camera.camera2.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class Camera2ImplConfig implements Config {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String CAPTURE_REQUEST_ID_STEM = "camera2.captureRequest.option.";
    private final Config mConfig;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Config.Option<Integer> TEMPLATE_TYPE_OPTION = Config.Option.create("camera2.captureRequest.templateType", Integer.TYPE);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Config.Option<CameraDevice.StateCallback> DEVICE_STATE_CALLBACK_OPTION = Config.Option.create("camera2.cameraDevice.stateCallback", CameraDevice.StateCallback.class);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Config.Option<CameraCaptureSession.StateCallback> SESSION_STATE_CALLBACK_OPTION = Config.Option.create("camera2.cameraCaptureSession.stateCallback", CameraCaptureSession.StateCallback.class);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Config.Option<CameraCaptureSession.CaptureCallback> SESSION_CAPTURE_CALLBACK_OPTION = Config.Option.create("camera2.cameraCaptureSession.captureCallback", CameraCaptureSession.CaptureCallback.class);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Config.Option<CameraEventCallbacks> CAMERA_EVENT_CALLBACK_OPTION = Config.Option.create("camera2.cameraEvent.callback", CameraEventCallbacks.class);

    public static final class Builder implements ExtendableBuilder<Camera2ImplConfig> {
        private final MutableOptionsBundle mMutableOptionsBundle = MutableOptionsBundle.create();

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        public MutableConfig getMutableConfig() {
            return this.mMutableOptionsBundle;
        }

        @NonNull
        public Builder insertAllOptions(@NonNull Config config) {
            for (Config.Option<?> option : config.listOptions()) {
                this.mMutableOptionsBundle.insertOption(option, config.retrieveOption(option));
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NonNull
        public <ValueT> Builder setCaptureRequestOption(@NonNull CaptureRequest.Key<ValueT> key, @NonNull ValueT valuet) {
            this.mMutableOptionsBundle.insertOption(Camera2ImplConfig.createCaptureRequestOption(key), valuet);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        public Camera2ImplConfig build() {
            return new Camera2ImplConfig(OptionsBundle.from(this.mMutableOptionsBundle));
        }
    }

    public static final class Extender<T> {
        ExtendableBuilder<T> mBaseBuilder;

        public Extender(@NonNull ExtendableBuilder<T> extendableBuilder) {
            this.mBaseBuilder = extendableBuilder;
        }

        @NonNull
        public Extender<T> setCameraEventCallback(@NonNull CameraEventCallbacks cameraEventCallbacks) {
            this.mBaseBuilder.getMutableConfig().insertOption(Camera2ImplConfig.CAMERA_EVENT_CALLBACK_OPTION, cameraEventCallbacks);
            return this;
        }
    }

    public Camera2ImplConfig(@NonNull Config config) {
        this.mConfig = config;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Config.Option<Object> createCaptureRequestOption(@NonNull CaptureRequest.Key<?> key) {
        return Config.Option.create(CAPTURE_REQUEST_ID_STEM + key.getName(), Object.class, key);
    }

    @Override // androidx.camera.core.impl.Config
    public boolean containsOption(@NonNull Config.Option<?> option) {
        return this.mConfig.containsOption(option);
    }

    @Override // androidx.camera.core.impl.Config
    public void findOptions(@NonNull String str, @NonNull Config.OptionMatcher optionMatcher) {
        this.mConfig.findOptions(str, optionMatcher);
    }

    @Nullable
    public CameraEventCallbacks getCameraEventCallback(@Nullable CameraEventCallbacks cameraEventCallbacks) {
        return (CameraEventCallbacks) this.mConfig.retrieveOption(CAMERA_EVENT_CALLBACK_OPTION, cameraEventCallbacks);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public <ValueT> ValueT getCaptureRequestOption(@NonNull CaptureRequest.Key<ValueT> key, @Nullable ValueT valuet) {
        return (ValueT) this.mConfig.retrieveOption(createCaptureRequestOption(key), valuet);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Set<Config.Option<?>> getCaptureRequestOptions() {
        final HashSet hashSet = new HashSet();
        findOptions(CAPTURE_REQUEST_ID_STEM, new Config.OptionMatcher() { // from class: androidx.camera.camera2.impl.Camera2ImplConfig.1
            @Override // androidx.camera.core.impl.Config.OptionMatcher
            public boolean onOptionMatched(@NonNull Config.Option<?> option) {
                hashSet.add(option);
                return true;
            }
        });
        return hashSet;
    }

    public int getCaptureRequestTemplate(int i2) {
        return ((Integer) this.mConfig.retrieveOption(TEMPLATE_TYPE_OPTION, Integer.valueOf(i2))).intValue();
    }

    @Nullable
    public CameraDevice.StateCallback getDeviceStateCallback(@Nullable CameraDevice.StateCallback stateCallback) {
        return (CameraDevice.StateCallback) this.mConfig.retrieveOption(DEVICE_STATE_CALLBACK_OPTION, stateCallback);
    }

    @Nullable
    public CameraCaptureSession.CaptureCallback getSessionCaptureCallback(@Nullable CameraCaptureSession.CaptureCallback captureCallback) {
        return (CameraCaptureSession.CaptureCallback) this.mConfig.retrieveOption(SESSION_CAPTURE_CALLBACK_OPTION, captureCallback);
    }

    @Nullable
    public CameraCaptureSession.StateCallback getSessionStateCallback(@Nullable CameraCaptureSession.StateCallback stateCallback) {
        return (CameraCaptureSession.StateCallback) this.mConfig.retrieveOption(SESSION_STATE_CALLBACK_OPTION, stateCallback);
    }

    @Override // androidx.camera.core.impl.Config
    @NonNull
    public Set<Config.Option<?>> listOptions() {
        return this.mConfig.listOptions();
    }

    @Override // androidx.camera.core.impl.Config
    @Nullable
    public <ValueT> ValueT retrieveOption(@NonNull Config.Option<ValueT> option) {
        return (ValueT) this.mConfig.retrieveOption(option);
    }

    @Override // androidx.camera.core.impl.Config
    @Nullable
    public <ValueT> ValueT retrieveOption(@NonNull Config.Option<ValueT> option, @Nullable ValueT valuet) {
        return (ValueT) this.mConfig.retrieveOption(option, valuet);
    }
}
