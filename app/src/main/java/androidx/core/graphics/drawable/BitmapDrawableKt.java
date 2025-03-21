package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: BitmapDrawable.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¨\u0006\u0005"}, m23546d2 = {"toDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "Landroid/graphics/Bitmap;", "resources", "Landroid/content/res/Resources;", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class BitmapDrawableKt {
    @InterfaceC5816d
    public static final BitmapDrawable toDrawable(@InterfaceC5816d Bitmap bitmap, @InterfaceC5816d Resources resources) {
        C5544i0.m22546f(bitmap, "$receiver");
        C5544i0.m22546f(resources, "resources");
        return new BitmapDrawable(resources, bitmap);
    }
}
