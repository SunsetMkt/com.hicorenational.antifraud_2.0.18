package util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import ui.Hicore;

/* JADX INFO: compiled from: WatermarkTransformation.java */
/* JADX INFO: loaded from: classes2.dex */
public class l2 extends com.bumptech.glide.load.r.d.h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f14954f = "jarchie.glide.WatermarkTransformation";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final byte[] f14955g = f14954f.getBytes(StandardCharsets.UTF_8);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f14956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f14957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f14958e;

    public l2(int i2, float f2, float f3) {
        this.f14956c = i2;
        this.f14957d = f2;
        this.f14958e = f3;
    }

    @Override // com.bumptech.glide.load.r.d.h
    protected Bitmap a(com.bumptech.glide.load.p.a0.e eVar, Bitmap bitmap, int i2, int i3) {
        int width = bitmap.getWidth();
        Bitmap bitmapA = eVar.a(width, bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        bitmapA.setHasAlpha(true);
        Canvas canvas = new Canvas(bitmapA);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Bitmap bitmapA2 = a(eVar);
        if (bitmapA2 == null) {
            return bitmapA;
        }
        int i4 = (int) (width * this.f14958e);
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapA2, i4, (int) (bitmapA2.getHeight() * (i4 / bitmapA2.getWidth())), true);
        float fA = a(this.f14957d);
        float width2 = (width - bitmapCreateScaledBitmap.getWidth()) - fA;
        float height = (r11 - bitmapCreateScaledBitmap.getHeight()) - fA;
        Paint paint = new Paint();
        paint.setAlpha(180);
        paint.setAntiAlias(true);
        canvas.drawBitmap(bitmapCreateScaledBitmap, width2, height, paint);
        if (bitmapCreateScaledBitmap != bitmapA2) {
            eVar.a(bitmapCreateScaledBitmap);
        }
        eVar.a(bitmapA2);
        return bitmapA;
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l2.class != obj.getClass()) {
            return false;
        }
        l2 l2Var = (l2) obj;
        return this.f14956c == l2Var.f14956c && Float.compare(l2Var.f14957d, this.f14957d) == 0 && Float.compare(l2Var.f14958e, this.f14958e) == 0;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return com.bumptech.glide.util.l.a(this.f14956c, com.bumptech.glide.util.l.a(this.f14957d, Float.valueOf(this.f14958e).hashCode()));
    }

    private Bitmap a(com.bumptech.glide.load.p.a0.e eVar) {
        try {
            Drawable drawable = ContextCompat.getDrawable(Hicore.getApp().getApplicationContext(), this.f14956c);
            if (drawable == null) {
                return null;
            }
            Bitmap bitmapA = eVar.a(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapA);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapA;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private float a(float f2) {
        return f2 * (Hicore.getApp().getResources().getDisplayMetrics().densityDpi / 160.0f);
    }

    @Override // com.bumptech.glide.load.g
    public void a(MessageDigest messageDigest) {
        messageDigest.update(f14955g);
        messageDigest.update(String.valueOf(this.f14956c).getBytes());
        messageDigest.update(String.valueOf(this.f14957d).getBytes());
        messageDigest.update(String.valueOf(this.f14958e).getBytes());
    }
}
