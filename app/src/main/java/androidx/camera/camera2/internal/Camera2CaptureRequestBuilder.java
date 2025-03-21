package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class Camera2CaptureRequestBuilder {
    private static final String TAG = "CaptureRequestBuilder";

    private Camera2CaptureRequestBuilder() {
    }

    private static void applyImplementationOptionToCaptureBuilder(CaptureRequest.Builder builder, Config config) {
        Camera2ImplConfig camera2ImplConfig = new Camera2ImplConfig(config);
        for (Config.Option<?> option : camera2ImplConfig.getCaptureRequestOptions()) {
            CaptureRequest.Key key = (CaptureRequest.Key) option.getToken();
            try {
                builder.set(key, camera2ImplConfig.retrieveOption(option));
            } catch (IllegalArgumentException unused) {
                String str = "CaptureRequest.Key is not supported: " + key;
            }
        }
    }

    @Nullable
    public static CaptureRequest build(@NonNull CaptureConfig captureConfig, @Nullable CameraDevice cameraDevice, @NonNull Map<DeferrableSurface, Surface> map) throws CameraAccessException {
        if (cameraDevice == null) {
            return null;
        }
        List<Surface> configuredSurfaces = getConfiguredSurfaces(captureConfig.getSurfaces(), map);
        if (configuredSurfaces.isEmpty()) {
            return null;
        }
        CaptureRequest.Builder createCaptureRequest = cameraDevice.createCaptureRequest(captureConfig.getTemplateType());
        applyImplementationOptionToCaptureBuilder(createCaptureRequest, captureConfig.getImplementationOptions());
        if (captureConfig.getImplementationOptions().containsOption(CaptureConfig.OPTION_ROTATION)) {
            createCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, captureConfig.getImplementationOptions().retrieveOption(CaptureConfig.OPTION_ROTATION));
        }
        Iterator<Surface> it = configuredSurfaces.iterator();
        while (it.hasNext()) {
            createCaptureRequest.addTarget(it.next());
        }
        createCaptureRequest.setTag(captureConfig.getTag());
        return createCaptureRequest.build();
    }

    @Nullable
    public static CaptureRequest buildWithoutTarget(@NonNull CaptureConfig captureConfig, @Nullable CameraDevice cameraDevice) throws CameraAccessException {
        if (cameraDevice == null) {
            return null;
        }
        CaptureRequest.Builder createCaptureRequest = cameraDevice.createCaptureRequest(captureConfig.getTemplateType());
        applyImplementationOptionToCaptureBuilder(createCaptureRequest, captureConfig.getImplementationOptions());
        return createCaptureRequest.build();
    }

    @NonNull
    private static List<Surface> getConfiguredSurfaces(List<DeferrableSurface> list, Map<DeferrableSurface, Surface> map) {
        ArrayList arrayList = new ArrayList();
        Iterator<DeferrableSurface> it = list.iterator();
        while (it.hasNext()) {
            Surface surface = map.get(it.next());
            if (surface == null) {
                throw new IllegalArgumentException("DeferrableSurface not in configuredSurfaceMap");
            }
            arrayList.add(surface);
        }
        return arrayList;
    }
}
