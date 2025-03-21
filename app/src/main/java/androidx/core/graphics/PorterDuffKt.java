package androidx.core.graphics;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import com.huawei.hms.push.constant.RemoteMessageConst;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: PorterDuff.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b\u001a\r\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0086\b¨\u0006\u0007"}, m23546d2 = {"toColorFilter", "Landroid/graphics/PorterDuffColorFilter;", "Landroid/graphics/PorterDuff$Mode;", RemoteMessageConst.Notification.COLOR, "", "toXfermode", "Landroid/graphics/PorterDuffXfermode;", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class PorterDuffKt {
    @InterfaceC5816d
    public static final PorterDuffColorFilter toColorFilter(@InterfaceC5816d PorterDuff.Mode mode, int i2) {
        C5544i0.m22546f(mode, "$receiver");
        return new PorterDuffColorFilter(i2, mode);
    }

    @InterfaceC5816d
    public static final PorterDuffXfermode toXfermode(@InterfaceC5816d PorterDuff.Mode mode) {
        C5544i0.m22546f(mode, "$receiver");
        return new PorterDuffXfermode(mode);
    }
}
