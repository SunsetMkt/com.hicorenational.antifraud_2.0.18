package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Icon.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0005H\u0087\b¨\u0006\u0006"}, m23546d2 = {"toAdaptiveIcon", "Landroid/graphics/drawable/Icon;", "Landroid/graphics/Bitmap;", "toIcon", "Landroid/net/Uri;", "", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class IconKt {
    @RequiresApi(26)
    @InterfaceC5816d
    public static final Icon toAdaptiveIcon(@InterfaceC5816d Bitmap bitmap) {
        C5544i0.m22546f(bitmap, "$receiver");
        Icon createWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
        C5544i0.m22521a((Object) createWithAdaptiveBitmap, "Icon.createWithAdaptiveBitmap(this)");
        return createWithAdaptiveBitmap;
    }

    @RequiresApi(26)
    @InterfaceC5816d
    public static final Icon toIcon(@InterfaceC5816d Bitmap bitmap) {
        C5544i0.m22546f(bitmap, "$receiver");
        Icon createWithBitmap = Icon.createWithBitmap(bitmap);
        C5544i0.m22521a((Object) createWithBitmap, "Icon.createWithBitmap(this)");
        return createWithBitmap;
    }

    @RequiresApi(26)
    @InterfaceC5816d
    public static final Icon toIcon(@InterfaceC5816d Uri uri) {
        C5544i0.m22546f(uri, "$receiver");
        Icon createWithContentUri = Icon.createWithContentUri(uri);
        C5544i0.m22521a((Object) createWithContentUri, "Icon.createWithContentUri(this)");
        return createWithContentUri;
    }

    @RequiresApi(26)
    @InterfaceC5816d
    public static final Icon toIcon(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "$receiver");
        Icon createWithData = Icon.createWithData(bArr, 0, bArr.length);
        C5544i0.m22521a((Object) createWithData, "Icon.createWithData(this, 0, size)");
        return createWithData;
    }
}
