package p388ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class MaskView extends AppCompatImageView {

    /* renamed from: k */
    private static final String f24562k = MaskView.class.getSimpleName();

    /* renamed from: l */
    private static final int f24563l = -1;

    /* renamed from: m */
    private static final int f24564m = 1;

    /* renamed from: n */
    private static final int f24565n = 30;

    /* renamed from: o */
    private static final int f24566o = 16777215;

    /* renamed from: p */
    private static final int f24567p = 255;

    /* renamed from: a */
    private Paint f24568a;

    /* renamed from: b */
    private Paint f24569b;

    /* renamed from: c */
    private RectF f24570c;

    /* renamed from: d */
    private int f24571d;

    /* renamed from: e */
    private int f24572e;

    /* renamed from: f */
    private int f24573f;

    /* renamed from: g */
    private int f24574g;

    /* renamed from: h */
    private int f24575h;

    /* renamed from: i */
    private int f24576i;

    /* renamed from: j */
    private int f24577j;

    public MaskView(Context context) {
        super(context);
        this.f24570c = null;
        m25784a(context, null, 0);
    }

    /* renamed from: a */
    private void m25784a(Context context, AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2113R.styleable.cameView_MaskView, i2, 0);
        this.f24573f = obtainStyledAttributes.getColor(3, -1);
        this.f24574g = obtainStyledAttributes.getDimensionPixelOffset(4, 1);
        this.f24575h = obtainStyledAttributes.getInt(2, 30);
        this.f24576i = obtainStyledAttributes.getColor(1, 16777215);
        this.f24577j = obtainStyledAttributes.getInt(0, 255);
        m25783a();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.f24570c;
        if (rectF == null) {
            return;
        }
        float width = rectF.width();
        float height = this.f24570c.height();
        float min = Math.min(width, height) / 2.0f;
        RectF rectF2 = this.f24570c;
        float f2 = rectF2.left + (width / 2.0f);
        float f3 = rectF2.top + (height / 2.0f);
        float f4 = f3 - min;
        canvas.drawRect(0.0f, 0.0f, this.f24571d, f4, this.f24569b);
        float f5 = f2 - min;
        float f6 = f3 + min;
        canvas.drawRect(0.0f, f4, f5, f6, this.f24569b);
        canvas.drawRect(0.0f, f6, this.f24571d, this.f24572e, this.f24569b);
        float f7 = f2 + min;
        canvas.drawRect(f7, f4, this.f24571d, f6, this.f24569b);
        Paint paint = new Paint();
        paint.setStrokeWidth(min / 2.0f);
        paint.setFlags(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(this.f24576i);
        paint.setColor(getResources().getColor(C2113R.color.white));
        paint.setAlpha(this.f24577j);
        RectF rectF3 = new RectF();
        float f8 = 1.25f * min;
        rectF3.left = f2 - f8;
        rectF3.top = f3 - f8;
        rectF3.right = f2 + f8;
        rectF3.bottom = f8 + f3;
        canvas.drawArc(rectF3, 360.0f, 360.0f, false, paint);
        Paint paint2 = new Paint();
        paint2.setStrokeWidth(8);
        paint2.setColor(getResources().getColor(C2113R.color.circle_blue));
        paint2.setFlags(1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAlpha(this.f24577j);
        RectF rectF4 = new RectF();
        float f9 = 4;
        float f10 = 12;
        rectF4.left = (f5 - f9) - f10;
        rectF4.top = (f4 - f9) - f10;
        rectF4.right = f7 + f9 + f10;
        rectF4.bottom = f6 + f9 + f10;
        canvas.drawArc(rectF4, 360.0f, 360.0f, false, paint2);
        canvas.drawCircle(f2, f3, min, this.f24568a);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f24571d = getMeasuredWidth();
        this.f24572e = getMeasuredHeight();
    }

    public void setCenterRect(RectF rectF) {
        this.f24570c = rectF;
        postInvalidate();
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24570c = null;
        m25784a(context, attributeSet, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24570c = null;
        m25784a(context, attributeSet, i2);
    }

    /* renamed from: a */
    private void m25783a() {
        this.f24568a = new Paint(1);
        this.f24568a.setColor(this.f24573f);
        this.f24568a.setStyle(Paint.Style.STROKE);
        this.f24568a.setStrokeWidth(this.f24574g);
        this.f24568a.setAlpha(this.f24575h);
        this.f24569b = new Paint(1);
        this.f24569b.setColor(this.f24576i);
        this.f24569b.setStyle(Paint.Style.FILL);
        this.f24569b.setAlpha(this.f24577j);
    }
}
