package androidx.camera.core;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
final class SettableImageProxy extends ForwardingImageProxy {
    private final ImageInfo mImageInfo;

    SettableImageProxy(ImageProxy imageProxy, ImageInfo imageInfo) {
        super(imageProxy);
        this.mImageInfo = imageInfo;
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
    @NonNull
    public ImageInfo getImageInfo() {
        return this.mImageInfo;
    }
}
