package androidx.camera.camera2.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.MultiValueSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class CameraEventCallbacks extends MultiValueSet<CameraEventCallback> {

    public static final class ComboCameraEventCallback {
        private final List<CameraEventCallback> mCallbacks = new ArrayList();

        ComboCameraEventCallback(List<CameraEventCallback> list) {
            Iterator<CameraEventCallback> it = list.iterator();
            while (it.hasNext()) {
                this.mCallbacks.add(it.next());
            }
        }

        @NonNull
        public List<CameraEventCallback> getCallbacks() {
            return this.mCallbacks;
        }

        @NonNull
        public List<CaptureConfig> onDisableSession() {
            LinkedList linkedList = new LinkedList();
            Iterator<CameraEventCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                CaptureConfig onDisableSession = it.next().onDisableSession();
                if (onDisableSession != null) {
                    linkedList.add(onDisableSession);
                }
            }
            return linkedList;
        }

        @NonNull
        public List<CaptureConfig> onEnableSession() {
            LinkedList linkedList = new LinkedList();
            Iterator<CameraEventCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                CaptureConfig onEnableSession = it.next().onEnableSession();
                if (onEnableSession != null) {
                    linkedList.add(onEnableSession);
                }
            }
            return linkedList;
        }

        @NonNull
        public List<CaptureConfig> onPresetSession() {
            LinkedList linkedList = new LinkedList();
            Iterator<CameraEventCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                CaptureConfig onPresetSession = it.next().onPresetSession();
                if (onPresetSession != null) {
                    linkedList.add(onPresetSession);
                }
            }
            return linkedList;
        }

        @NonNull
        public List<CaptureConfig> onRepeating() {
            LinkedList linkedList = new LinkedList();
            Iterator<CameraEventCallback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                CaptureConfig onRepeating = it.next().onRepeating();
                if (onRepeating != null) {
                    linkedList.add(onRepeating);
                }
            }
            return linkedList;
        }
    }

    public CameraEventCallbacks(@NonNull CameraEventCallback... cameraEventCallbackArr) {
        addAll(Arrays.asList(cameraEventCallbackArr));
    }

    @NonNull
    public static CameraEventCallbacks createEmptyCallback() {
        return new CameraEventCallbacks(new CameraEventCallback[0]);
    }

    @NonNull
    public ComboCameraEventCallback createComboCallback() {
        return new ComboCameraEventCallback(getAllItems());
    }

    @Override // androidx.camera.core.impl.MultiValueSet
    @NonNull
    /* renamed from: clone */
    public MultiValueSet<CameraEventCallback> mo26841clone() {
        CameraEventCallbacks createEmptyCallback = createEmptyCallback();
        createEmptyCallback.addAll(getAllItems());
        return createEmptyCallback;
    }
}
