package ui.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.r.d.g0;
import java.security.MessageDigest;

/* JADX INFO: compiled from: GlideRoundTransform.java */
/* JADX INFO: loaded from: classes2.dex */
public class t extends com.bumptech.glide.load.r.d.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static float f14830c;

    public t() {
        this(4);
    }

    @Override // com.bumptech.glide.load.r.d.h
    protected Bitmap a(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        return a(eVar, g0.a(eVar, bitmap, i2, i3));
    }

    @Override // com.bumptech.glide.load.g
    public void a(MessageDigest messageDigest) {
    }

    public t(int i2) {
        f14830c = Resources.getSystem().getDisplayMetrics().density * i2;
    }

    private static Bitmap a(com.bumptech.glide.load.p.a0.e eVar, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap bitmapA = eVar.a(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        if (bitmapA == null) {
            bitmapA = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmapA);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        float f2 = f14830c;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        return bitmapA;
    }
}
