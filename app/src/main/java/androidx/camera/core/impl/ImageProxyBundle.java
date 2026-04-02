package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageProxy;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ImageProxyBundle {
    @NonNull
    List<Integer> getCaptureIds();

    @NonNull
    d.b.b.a.a.a<ImageProxy> getImageProxy(int i2);
}
