package ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.hicorenational.antifraud.R;

/* JADX INFO: loaded from: classes2.dex */
public class ShadowLinearLayout extends LinearLayout {
    private Paint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RectF f14631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f14632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14634e;

    public ShadowLinearLayout(Context context) {
        this(context, null);
    }

    public void a() {
        int i2 = (int) this.f14632c;
        setPadding(i2, i2, i2, i2);
        setBackgroundColor(this.f14634e);
        this.a = new Paint();
        setLayerType(1, this.a);
        this.a.setColor(-1);
        this.a.setShadowLayer(this.f14632c, 5.0f, 5.0f, this.f14633d);
        this.a.setAntiAlias(true);
        this.f14631b = new RectF();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.f14631b;
        float f2 = this.f14632c + 0.0f;
        rectF.top = f2;
        rectF.left = f2;
        rectF.bottom = getMeasuredHeight() - this.f14632c;
        RectF rectF2 = this.f14631b;
        float measuredWidth = getMeasuredWidth();
        float f3 = this.f14632c;
        rectF2.right = measuredWidth - f3;
        canvas.drawRoundRect(this.f14631b, f3, f3, this.a);
    }

    public ShadowLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.shadowlayout);
        this.f14633d = typedArrayObtainStyledAttributes.getColor(1, -16776961);
        this.f14634e = typedArrayObtainStyledAttributes.getColor(0, ViewCompat.MEASURED_STATE_MASK);
        this.f14632c = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 3);
        a();
    }
}
