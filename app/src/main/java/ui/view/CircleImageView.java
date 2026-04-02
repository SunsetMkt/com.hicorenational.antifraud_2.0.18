package ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes2.dex */
public class CircleImageView extends AppCompatImageView {
    private Paint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bitmap f14502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BitmapShader f14503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Matrix f14504d;

    public CircleImageView(Context context) {
        super(context);
        this.a = new Paint(1);
        this.f14504d = new Matrix();
    }

    private Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (!(drawable instanceof ColorDrawable)) {
            return null;
        }
        Rect bounds = drawable.getBounds();
        int i2 = bounds.right - bounds.left;
        int i3 = bounds.bottom - bounds.top;
        int color = ((ColorDrawable) drawable).getColor();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        new Canvas(bitmapCreateBitmap).drawARGB(Color.alpha(color), Color.red(color), Color.green(color), Color.blue(color));
        return bitmapCreateBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmapA = a(getDrawable());
        if (bitmapA == null) {
            super.onDraw(canvas);
            return;
        }
        float fMin = Math.min(getWidth(), getHeight());
        if (this.f14503c == null || !bitmapA.equals(this.f14502b)) {
            this.f14502b = bitmapA;
            Bitmap bitmap = this.f14502b;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f14503c = new BitmapShader(bitmap, tileMode, tileMode);
        }
        if (this.f14503c != null) {
            this.f14504d.setScale(fMin / bitmapA.getWidth(), fMin / bitmapA.getHeight());
            this.f14503c.setLocalMatrix(this.f14504d);
        }
        this.a.setShader(this.f14503c);
        float f2 = fMin / 2.0f;
        canvas.drawCircle(f2, f2, f2, this.a);
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Paint(1);
        this.f14504d = new Matrix();
    }
}
