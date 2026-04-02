package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.io.IOException;

/* JADX INFO: compiled from: BitmapImageDecoderResourceDecoder.java */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 28)
public final class f extends com.bumptech.glide.load.r.a<Bitmap> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f3156d = "BitmapImageDecoder";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.e f3157c = new com.bumptech.glide.load.p.a0.f();

    @Override // com.bumptech.glide.load.r.a
    protected com.bumptech.glide.load.p.v<Bitmap> a(ImageDecoder.Source source, int i2, int i3, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (Log.isLoggable(f3156d, 2)) {
            String str = "Decoded [" + bitmapDecodeBitmap.getWidth() + "x" + bitmapDecodeBitmap.getHeight() + "] for [" + i2 + "x" + i3 + "]";
        }
        return new g(bitmapDecodeBitmap, this.f3157c);
    }
}
