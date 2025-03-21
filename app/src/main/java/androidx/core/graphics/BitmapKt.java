package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Bitmap.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0086\b\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a&\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\u0086\b\u001a\u001d\u0010\u0011\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0086\n\u001a'\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\bH\u0086\b\u001a'\u0010\u0016\u001a\u00020\u000f*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\b\b\u0001\u0010\u0017\u001a\u00020\u0003H\u0086\n¨\u0006\u0018"}, m23546d2 = {"createBitmap", "Landroid/graphics/Bitmap;", SocializeProtocolConstants.WIDTH, "", SocializeProtocolConstants.HEIGHT, "config", "Landroid/graphics/Bitmap$Config;", "hasAlpha", "", "colorSpace", "Landroid/graphics/ColorSpace;", "applyCanvas", "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "get", "x", "y", "scale", "filter", "set", RemoteMessageConst.Notification.COLOR, "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class BitmapKt {
    @InterfaceC5816d
    public static final Bitmap applyCanvas(@InterfaceC5816d Bitmap bitmap, @InterfaceC5816d InterfaceC5506l<? super Canvas, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(bitmap, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "block");
        interfaceC5506l.invoke(new Canvas(bitmap));
        return bitmap;
    }

    @InterfaceC5816d
    public static final Bitmap createBitmap(int i2, int i3, @InterfaceC5816d Bitmap.Config config) {
        C5544i0.m22546f(config, "config");
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, config);
        C5544i0.m22521a((Object) createBitmap, "Bitmap.createBitmap(width, height, config)");
        return createBitmap;
    }

    @InterfaceC5816d
    public static /* bridge */ /* synthetic */ Bitmap createBitmap$default(int i2, int i3, Bitmap.Config config, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        C5544i0.m22546f(config, "config");
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, config);
        C5544i0.m22521a((Object) createBitmap, "Bitmap.createBitmap(width, height, config)");
        return createBitmap;
    }

    public static final int get(@InterfaceC5816d Bitmap bitmap, int i2, int i3) {
        C5544i0.m22546f(bitmap, "$receiver");
        return bitmap.getPixel(i2, i3);
    }

    @InterfaceC5816d
    public static final Bitmap scale(@InterfaceC5816d Bitmap bitmap, int i2, int i3, boolean z) {
        C5544i0.m22546f(bitmap, "$receiver");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, z);
        C5544i0.m22521a((Object) createScaledBitmap, "Bitmap.createScaledBitma…s, width, height, filter)");
        return createScaledBitmap;
    }

    @InterfaceC5816d
    public static /* bridge */ /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z = true;
        }
        C5544i0.m22546f(bitmap, "$receiver");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, z);
        C5544i0.m22521a((Object) createScaledBitmap, "Bitmap.createScaledBitma…s, width, height, filter)");
        return createScaledBitmap;
    }

    public static final void set(@InterfaceC5816d Bitmap bitmap, int i2, int i3, @ColorInt int i4) {
        C5544i0.m22546f(bitmap, "$receiver");
        bitmap.setPixel(i2, i3, i4);
    }

    @RequiresApi(26)
    @InterfaceC5816d
    public static final Bitmap createBitmap(int i2, int i3, @InterfaceC5816d Bitmap.Config config, boolean z, @InterfaceC5816d ColorSpace colorSpace) {
        C5544i0.m22546f(config, "config");
        C5544i0.m22546f(colorSpace, "colorSpace");
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, config, z, colorSpace);
        C5544i0.m22521a((Object) createBitmap, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
        return createBitmap;
    }

    @RequiresApi(26)
    @InterfaceC5816d
    public static /* bridge */ /* synthetic */ Bitmap createBitmap$default(int i2, int i3, Bitmap.Config config, boolean z, ColorSpace colorSpace, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i4 & 8) != 0) {
            z = true;
        }
        if ((i4 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            C5544i0.m22521a((Object) colorSpace, "ColorSpace.get(ColorSpace.Named.SRGB)");
        }
        C5544i0.m22546f(config, "config");
        C5544i0.m22546f(colorSpace, "colorSpace");
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, config, z, colorSpace);
        C5544i0.m22521a((Object) createBitmap, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
        return createBitmap;
    }
}
