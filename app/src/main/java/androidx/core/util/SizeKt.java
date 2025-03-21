package androidx.core.util;

import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RequiresApi;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Size.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0087\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0087\n\u001a\r\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0087\n¨\u0006\u0006"}, m23546d2 = {"component1", "", "Landroid/util/Size;", "", "Landroid/util/SizeF;", "component2", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class SizeKt {
    @RequiresApi(21)
    public static final int component1(@InterfaceC5816d Size size) {
        C5544i0.m22546f(size, "$receiver");
        return size.getWidth();
    }

    @RequiresApi(21)
    public static final int component2(@InterfaceC5816d Size size) {
        C5544i0.m22546f(size, "$receiver");
        return size.getHeight();
    }

    @RequiresApi(21)
    public static final float component1(@InterfaceC5816d SizeF sizeF) {
        C5544i0.m22546f(sizeF, "$receiver");
        return sizeF.getWidth();
    }

    @RequiresApi(21)
    public static final float component2(@InterfaceC5816d SizeF sizeF) {
        C5544i0.m22546f(sizeF, "$receiver");
        return sizeF.getHeight();
    }
}
