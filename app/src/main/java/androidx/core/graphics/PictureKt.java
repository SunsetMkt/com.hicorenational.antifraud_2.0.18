package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5535f0;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Picture.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0086\b¨\u0006\n"}, m23546d2 = {"record", "Landroid/graphics/Picture;", SocializeProtocolConstants.WIDTH, "", SocializeProtocolConstants.HEIGHT, "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class PictureKt {
    @InterfaceC5816d
    public static final Picture record(@InterfaceC5816d Picture picture, int i2, int i3, @InterfaceC5816d InterfaceC5506l<? super Canvas, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(picture, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "block");
        Canvas beginRecording = picture.beginRecording(i2, i3);
        try {
            C5544i0.m22521a((Object) beginRecording, C3351bh.f11584aI);
            interfaceC5506l.invoke(beginRecording);
            return picture;
        } finally {
            C5535f0.m22474b(1);
            picture.endRecording();
            C5535f0.m22471a(1);
        }
    }
}
