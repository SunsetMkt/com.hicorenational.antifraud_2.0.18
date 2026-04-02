package ui.view.signature;

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

/* JADX INFO: loaded from: classes2.dex */
public class SignatureView extends View {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f14810h = 5.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f14811i = 2.5f;
    private Paint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Path f14812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f14813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f14814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RectF f14815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Bitmap f14816f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Canvas f14817g;

    public SignatureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Paint();
        this.f14812b = new Path();
        this.f14815e = new RectF();
        this.a.setAntiAlias(true);
        this.a.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeJoin(Paint.Join.ROUND);
        this.a.setStrokeWidth(f14810h);
        this.a.setDither(true);
    }

    private void b(float f2, float f3) {
        this.f14815e.left = Math.min(this.f14813c, f2);
        this.f14815e.right = Math.max(this.f14813c, f2);
        this.f14815e.top = Math.min(this.f14814d, f3);
        this.f14815e.bottom = Math.max(this.f14814d, f3);
    }

    public void a() {
        this.f14812b.reset();
        invalidate();
    }

    public Bitmap getPaintBitmap() {
        return a(this.f14816f, 320, 480);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f14817g.drawPath(this.f14812b, this.a);
        canvas.drawBitmap(this.f14816f, 0.0f, 0.0f, this.a);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f14816f = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.f14817g = new Canvas(this.f14816f);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f14812b.moveTo(x, y);
            this.f14813c = x;
            this.f14814d = y;
            return true;
        }
        if (action != 1 && action != 2) {
            return false;
        }
        b(x, y);
        int historySize = motionEvent.getHistorySize();
        for (int i2 = 0; i2 < historySize; i2++) {
            float historicalX = motionEvent.getHistoricalX(i2);
            float historicalY = motionEvent.getHistoricalY(i2);
            a(historicalX, historicalY);
            this.f14812b.lineTo(historicalX, historicalY);
        }
        this.f14812b.quadTo(x, y, this.f14813c, this.f14814d);
        RectF rectF = this.f14815e;
        invalidate((int) (rectF.left - f14811i), (int) (rectF.top - f14811i), (int) (rectF.right + f14811i), (int) (rectF.bottom + f14811i));
        this.f14813c = x;
        this.f14814d = y;
        return true;
    }

    private void a(float f2, float f3) {
        RectF rectF = this.f14815e;
        if (f2 < rectF.left) {
            rectF.left = f2;
        } else if (f2 > rectF.right) {
            rectF.right = f2;
        }
        RectF rectF2 = this.f14815e;
        if (f3 < rectF2.top) {
            rectF2.top = f3;
        } else if (f3 > rectF2.bottom) {
            rectF2.bottom = f3;
        }
    }

    public static Bitmap a(Bitmap bitmap, int i2, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i2 / width, i3 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }
}
