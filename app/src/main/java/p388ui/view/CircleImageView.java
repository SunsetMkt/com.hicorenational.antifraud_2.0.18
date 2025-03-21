package p388ui.view;

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

/* loaded from: classes2.dex */
public class CircleImageView extends AppCompatImageView {

    /* renamed from: a */
    private Paint f24468a;

    /* renamed from: b */
    private Bitmap f24469b;

    /* renamed from: c */
    private BitmapShader f24470c;

    /* renamed from: d */
    private Matrix f24471d;

    public CircleImageView(Context context) {
        super(context);
        this.f24468a = new Paint(1);
        this.f24471d = new Matrix();
    }

    /* renamed from: a */
    private Bitmap m25741a(Drawable drawable) {
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
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawARGB(Color.alpha(color), Color.red(color), Color.green(color), Color.blue(color));
        return createBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap m25741a = m25741a(getDrawable());
        if (m25741a == null) {
            super.onDraw(canvas);
            return;
        }
        float min = Math.min(getWidth(), getHeight());
        if (this.f24470c == null || !m25741a.equals(this.f24469b)) {
            this.f24469b = m25741a;
            Bitmap bitmap = this.f24469b;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f24470c = new BitmapShader(bitmap, tileMode, tileMode);
        }
        if (this.f24470c != null) {
            this.f24471d.setScale(min / m25741a.getWidth(), min / m25741a.getHeight());
            this.f24470c.setLocalMatrix(this.f24471d);
        }
        this.f24468a.setShader(this.f24470c);
        float f2 = min / 2.0f;
        canvas.drawCircle(f2, f2, f2, this.f24468a);
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24468a = new Paint(1);
        this.f24471d = new Matrix();
    }
}
