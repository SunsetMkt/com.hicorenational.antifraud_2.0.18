package com.bumptech.glide.load.p125r.p126d;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.p118p.p119a0.C1627f;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.load.p125r.AbstractC1713a;
import java.io.IOException;

/* compiled from: BitmapImageDecoderResourceDecoder.java */
@RequiresApi(api = 28)
/* renamed from: com.bumptech.glide.load.r.d.f */
/* loaded from: classes.dex */
public final class C1726f extends AbstractC1713a<Bitmap> {

    /* renamed from: d */
    private static final String f4837d = "BitmapImageDecoder";

    /* renamed from: c */
    private final InterfaceC1626e f4838c = new C1627f();

    @Override // com.bumptech.glide.load.p125r.AbstractC1713a
    /* renamed from: a */
    protected InterfaceC1677v<Bitmap> mo4301a(ImageDecoder.Source source, int i2, int i3, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException {
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (Log.isLoggable(f4837d, 2)) {
            String str = "Decoded [" + decodeBitmap.getWidth() + "x" + decodeBitmap.getHeight() + "] for [" + i2 + "x" + i3 + "]";
        }
        return new C1728g(decodeBitmap, this.f4838c);
    }
}
