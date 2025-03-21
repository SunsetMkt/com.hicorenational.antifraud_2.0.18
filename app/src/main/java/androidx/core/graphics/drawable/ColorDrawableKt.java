package androidx.core.graphics.drawable;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ColorDrawable.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0087\b¨\u0006\u0004"}, m23546d2 = {"toDrawable", "Landroid/graphics/drawable/ColorDrawable;", "", "Landroid/graphics/Color;", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class ColorDrawableKt {
    @InterfaceC5816d
    public static final ColorDrawable toDrawable(@ColorInt int i2) {
        return new ColorDrawable(i2);
    }

    @RequiresApi(26)
    @InterfaceC5816d
    public static final ColorDrawable toDrawable(@InterfaceC5816d Color color) {
        C5544i0.m22546f(color, "$receiver");
        return new ColorDrawable(color.toArgb());
    }
}
