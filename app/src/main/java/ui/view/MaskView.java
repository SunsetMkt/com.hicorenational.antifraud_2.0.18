package ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class MaskView extends AppCompatImageView {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f14561k = MaskView.class.getSimpleName();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f14562l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f14563m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f14564n = 30;
    private static final int o = 16777215;
    private static final int p = 255;
    private Paint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f14565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RectF f14566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f14570g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f14571h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f14572i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f14573j;

    public MaskView(Context context) {
        super(context);
        this.f14566c = null;
        a(context, null, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.cameView_MaskView, i2, 0);
        this.f14569f = typedArrayObtainStyledAttributes.getColor(3, -1);
        this.f14570g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(4, 1);
        this.f14571h = typedArrayObtainStyledAttributes.getInt(2, 30);
        this.f14572i = typedArrayObtainStyledAttributes.getColor(1, 16777215);
        this.f14573j = typedArrayObtainStyledAttributes.getInt(0, 255);
        a();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.f14566c;
        if (rectF == null) {
            return;
        }
        float fWidth = rectF.width();
        float fHeight = this.f14566c.height();
        float fMin = Math.min(fWidth, fHeight) / 2.0f;
        RectF rectF2 = this.f14566c;
        float f2 = rectF2.left + (fWidth / 2.0f);
        float f3 = rectF2.top + (fHeight / 2.0f);
        float f4 = f3 - fMin;
        canvas.drawRect(0.0f, 0.0f, this.f14567d, f4, this.f14565b);
        float f5 = f2 - fMin;
        float f6 = f3 + fMin;
        canvas.drawRect(0.0f, f4, f5, f6, this.f14565b);
        canvas.drawRect(0.0f, f6, this.f14567d, this.f14568e, this.f14565b);
        float f7 = f2 + fMin;
        canvas.drawRect(f7, f4, this.f14567d, f6, this.f14565b);
        Paint paint = new Paint();
        paint.setStrokeWidth(fMin / 2.0f);
        paint.setFlags(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(this.f14572i);
        paint.setColor(getResources().getColor(R.color.white));
        paint.setAlpha(this.f14573j);
        RectF rectF3 = new RectF();
        float f8 = 1.25f * fMin;
        rectF3.left = f2 - f8;
        rectF3.top = f3 - f8;
        rectF3.right = f2 + f8;
        rectF3.bottom = f8 + f3;
        canvas.drawArc(rectF3, 360.0f, 360.0f, false, paint);
        Paint paint2 = new Paint();
        paint2.setStrokeWidth(8);
        paint2.setColor(getResources().getColor(R.color.circle_blue));
        paint2.setFlags(1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAlpha(this.f14573j);
        RectF rectF4 = new RectF();
        float f9 = 4;
        float f10 = 12;
        rectF4.left = (f5 - f9) - f10;
        rectF4.top = (f4 - f9) - f10;
        rectF4.right = f7 + f9 + f10;
        rectF4.bottom = f6 + f9 + f10;
        canvas.drawArc(rectF4, 360.0f, 360.0f, false, paint2);
        canvas.drawCircle(f2, f3, fMin, this.a);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f14567d = getMeasuredWidth();
        this.f14568e = getMeasuredHeight();
    }

    public void setCenterRect(RectF rectF) {
        this.f14566c = rectF;
        postInvalidate();
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14566c = null;
        a(context, attributeSet, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14566c = null;
        a(context, attributeSet, i2);
    }

    private void a() {
        this.a = new Paint(1);
        this.a.setColor(this.f14569f);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.f14570g);
        this.a.setAlpha(this.f14571h);
        this.f14565b = new Paint(1);
        this.f14565b.setColor(this.f14572i);
        this.f14565b.setStyle(Paint.Style.FILL);
        this.f14565b.setAlpha(this.f14573j);
    }
}
