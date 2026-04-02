package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Px;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import i.q2.t.i0;
import i.y;
import j.c.a.d;
import j.c.a.e;

/* JADX INFO: compiled from: Drawable.kt */
/* JADX INFO: loaded from: classes.dex */
@y(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a2\u0010\b\u001a\u00020\t*\u00020\u00022\b\b\u0003\u0010\n\u001a\u00020\u00042\b\b\u0003\u0010\u000b\u001a\u00020\u00042\b\b\u0003\u0010\f\u001a\u00020\u00042\b\b\u0003\u0010\r\u001a\u00020\u0004\u00a8\u0006\u000e"}, d2 = {"toBitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", SocializeProtocolConstants.WIDTH, "", SocializeProtocolConstants.HEIGHT, "config", "Landroid/graphics/Bitmap$Config;", "updateBounds", "", "left", "top", "right", "bottom", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
public final class DrawableKt {
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r0.getConfig() == r9) goto L7;
     */
    @d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Bitmap toBitmap(@d Drawable drawable, @Px int i2, @Px int i3, @e Bitmap.Config config) {
        i0.f(drawable, "$receiver");
        if (drawable instanceof BitmapDrawable) {
            if (config != null) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                i0.a((Object) bitmap, "bitmap");
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (i2 == bitmapDrawable.getIntrinsicWidth() && i3 == bitmapDrawable.getIntrinsicHeight()) {
                Bitmap bitmap2 = bitmapDrawable.getBitmap();
                i0.a((Object) bitmap2, "bitmap");
                return bitmap2;
            }
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), i2, i3, true);
            i0.a((Object) bitmapCreateScaledBitmap, "Bitmap.createScaledBitma\u2026map, width, height, true)");
            return bitmapCreateScaledBitmap;
        }
        Rect bounds = drawable.getBounds();
        int i4 = bounds.left;
        int i5 = bounds.top;
        int i6 = bounds.right;
        int i7 = bounds.bottom;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, config);
        drawable.setBounds(0, 0, i2, i3);
        drawable.draw(new Canvas(bitmapCreateBitmap));
        drawable.setBounds(i4, i5, i6, i7);
        i0.a((Object) bitmapCreateBitmap, "bitmap");
        return bitmapCreateBitmap;
    }

    @d
    public static /* bridge */ /* synthetic */ Bitmap toBitmap$default(Drawable drawable, int i2, int i3, Bitmap.Config config, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = drawable.getIntrinsicWidth();
        }
        if ((i4 & 2) != 0) {
            i3 = drawable.getIntrinsicHeight();
        }
        if ((i4 & 4) != 0) {
            config = null;
        }
        return toBitmap(drawable, i2, i3, config);
    }

    public static final void updateBounds(@d Drawable drawable, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        i0.f(drawable, "$receiver");
        drawable.setBounds(i2, i3, i4, i5);
    }

    public static /* bridge */ /* synthetic */ void updateBounds$default(Drawable drawable, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = drawable.getBounds().left;
        }
        if ((i6 & 2) != 0) {
            i3 = drawable.getBounds().top;
        }
        if ((i6 & 4) != 0) {
            i4 = drawable.getBounds().right;
        }
        if ((i6 & 8) != 0) {
            i5 = drawable.getBounds().bottom;
        }
        updateBounds(drawable, i2, i3, i4, i5);
    }
}
