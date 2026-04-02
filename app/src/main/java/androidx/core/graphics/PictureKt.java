package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import com.umeng.analytics.pro.bh;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import i.q2.s.l;
import i.q2.t.f0;
import i.q2.t.i0;
import i.y;
import i.y1;
import j.c.a.d;

/* JADX INFO: compiled from: Picture.kt */
/* JADX INFO: loaded from: classes.dex */
@y(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\u0002\b\tH\u0086\b\u00a8\u0006\n"}, d2 = {"record", "Landroid/graphics/Picture;", SocializeProtocolConstants.WIDTH, "", SocializeProtocolConstants.HEIGHT, "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
public final class PictureKt {
    @d
    public static final Picture record(@d Picture picture, int i2, int i3, @d l<? super Canvas, y1> lVar) {
        i0.f(picture, "$receiver");
        i0.f(lVar, "block");
        Canvas canvasBeginRecording = picture.beginRecording(i2, i3);
        try {
            i0.a((Object) canvasBeginRecording, bh.aI);
            lVar.invoke(canvasBeginRecording);
            return picture;
        } finally {
            f0.b(1);
            picture.endRecording();
            f0.a(1);
        }
    }
}
