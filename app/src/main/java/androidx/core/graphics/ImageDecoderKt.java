package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5511q;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ImageDecoder.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u00020\u0001*\u00020\u00022C\b\u0004\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0002\b\fH\u0087\b\u001aR\u0010\r\u001a\u00020\u000e*\u00020\u00022C\b\u0004\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0002\b\fH\u0087\b¨\u0006\u000f"}, m23546d2 = {"decodeBitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/ImageDecoder$Source;", "action", "Lkotlin/Function3;", "Landroid/graphics/ImageDecoder;", "Landroid/graphics/ImageDecoder$ImageInfo;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "info", "source", "", "Lkotlin/ExtensionFunctionType;", "decodeDrawable", "Landroid/graphics/drawable/Drawable;", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class ImageDecoderKt {
    @RequiresApi(28)
    @InterfaceC5816d
    public static final Bitmap decodeBitmap(@InterfaceC5816d ImageDecoder.Source source, @InterfaceC5816d final InterfaceC5511q<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, C5715y1> interfaceC5511q) {
        C5544i0.m22546f(source, "$receiver");
        C5544i0.m22546f(interfaceC5511q, "action");
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt$decodeBitmap$1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source2) {
                InterfaceC5511q interfaceC5511q2 = InterfaceC5511q.this;
                C5544i0.m22521a((Object) imageDecoder, "decoder");
                C5544i0.m22521a((Object) imageInfo, "info");
                C5544i0.m22521a((Object) source2, "source");
                interfaceC5511q2.invoke(imageDecoder, imageInfo, source2);
            }
        });
        C5544i0.m22521a((Object) decodeBitmap, "ImageDecoder.decodeBitma…ction(info, source)\n    }");
        return decodeBitmap;
    }

    @RequiresApi(28)
    @InterfaceC5816d
    public static final Drawable decodeDrawable(@InterfaceC5816d ImageDecoder.Source source, @InterfaceC5816d final InterfaceC5511q<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, C5715y1> interfaceC5511q) {
        C5544i0.m22546f(source, "$receiver");
        C5544i0.m22546f(interfaceC5511q, "action");
        Drawable decodeDrawable = ImageDecoder.decodeDrawable(source, new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt$decodeDrawable$1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source2) {
                InterfaceC5511q interfaceC5511q2 = InterfaceC5511q.this;
                C5544i0.m22521a((Object) imageDecoder, "decoder");
                C5544i0.m22521a((Object) imageInfo, "info");
                C5544i0.m22521a((Object) source2, "source");
                interfaceC5511q2.invoke(imageDecoder, imageInfo, source2);
            }
        });
        C5544i0.m22521a((Object) decodeDrawable, "ImageDecoder.decodeDrawa…ction(info, source)\n    }");
        return decodeDrawable;
    }
}
