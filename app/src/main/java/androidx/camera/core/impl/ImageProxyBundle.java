package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageProxy;
import java.util.List;
import p031c.p035b.p040b.p041a.p042a.InterfaceFutureC0952a;

/* loaded from: classes.dex */
public interface ImageProxyBundle {
    @NonNull
    List<Integer> getCaptureIds();

    @NonNull
    InterfaceFutureC0952a<ImageProxy> getImageProxy(int i2);
}
