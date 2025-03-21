package p388ui.view.signature;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;

/* loaded from: classes2.dex */
public class SignatureView extends View {

    /* renamed from: h */
    private static final float f24991h = 5.0f;

    /* renamed from: i */
    private static final float f24992i = 2.5f;

    /* renamed from: a */
    private Paint f24993a;

    /* renamed from: b */
    private Path f24994b;

    /* renamed from: c */
    private float f24995c;

    /* renamed from: d */
    private float f24996d;

    /* renamed from: e */
    private final RectF f24997e;

    /* renamed from: f */
    private Bitmap f24998f;

    /* renamed from: g */
    private Canvas f24999g;

    public SignatureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24993a = new Paint();
        this.f24994b = new Path();
        this.f24997e = new RectF();
        this.f24993a.setAntiAlias(true);
        this.f24993a.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f24993a.setStyle(Paint.Style.STROKE);
        this.f24993a.setStrokeJoin(Paint.Join.ROUND);
        this.f24993a.setStrokeWidth(f24991h);
        this.f24993a.setDither(true);
    }

    /* renamed from: b */
    private void m26042b(float f2, float f3) {
        this.f24997e.left = Math.min(this.f24995c, f2);
        this.f24997e.right = Math.max(this.f24995c, f2);
        this.f24997e.top = Math.min(this.f24996d, f3);
        this.f24997e.bottom = Math.max(this.f24996d, f3);
    }

    /* renamed from: a */
    public void m26043a() {
        this.f24994b.reset();
        invalidate();
    }

    public Bitmap getPaintBitmap() {
        return m26040a(this.f24998f, 320, 480);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f24999g.drawPath(this.f24994b, this.f24993a);
        canvas.drawBitmap(this.f24998f, 0.0f, 0.0f, this.f24993a);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f24998f = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.f24999g = new Canvas(this.f24998f);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f24994b.moveTo(x, y);
            this.f24995c = x;
            this.f24996d = y;
            return true;
        }
        if (action != 1 && action != 2) {
            return false;
        }
        m26042b(x, y);
        int historySize = motionEvent.getHistorySize();
        for (int i2 = 0; i2 < historySize; i2++) {
            float historicalX = motionEvent.getHistoricalX(i2);
            float historicalY = motionEvent.getHistoricalY(i2);
            m26041a(historicalX, historicalY);
            this.f24994b.lineTo(historicalX, historicalY);
        }
        this.f24994b.quadTo(x, y, this.f24995c, this.f24996d);
        RectF rectF = this.f24997e;
        invalidate((int) (rectF.left - f24992i), (int) (rectF.top - f24992i), (int) (rectF.right + f24992i), (int) (rectF.bottom + f24992i));
        this.f24995c = x;
        this.f24996d = y;
        return true;
    }

    /* renamed from: a */
    private void m26041a(float f2, float f3) {
        RectF rectF = this.f24997e;
        if (f2 < rectF.left) {
            rectF.left = f2;
        } else if (f2 > rectF.right) {
            rectF.right = f2;
        }
        RectF rectF2 = this.f24997e;
        if (f3 < rectF2.top) {
            rectF2.top = f3;
        } else if (f3 > rectF2.bottom) {
            rectF2.bottom = f3;
        }
    }

    /* renamed from: a */
    public static Bitmap m26040a(Bitmap bitmap, int i2, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i2 / width, i3 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}
