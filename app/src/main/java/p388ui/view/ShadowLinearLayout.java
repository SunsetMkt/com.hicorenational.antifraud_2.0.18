package p388ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.hicorenational.antifraud.C2113R;

/* loaded from: classes2.dex */
public class ShadowLinearLayout extends LinearLayout {

    /* renamed from: a */
    private Paint f24674a;

    /* renamed from: b */
    private RectF f24675b;

    /* renamed from: c */
    private float f24676c;

    /* renamed from: d */
    private int f24677d;

    /* renamed from: e */
    private int f24678e;

    public ShadowLinearLayout(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public void m25844a() {
        int i2 = (int) this.f24676c;
        setPadding(i2, i2, i2, i2);
        setBackgroundColor(this.f24678e);
        this.f24674a = new Paint();
        setLayerType(1, this.f24674a);
        this.f24674a.setColor(-1);
        this.f24674a.setShadowLayer(this.f24676c, 5.0f, 5.0f, this.f24677d);
        this.f24674a.setAntiAlias(true);
        this.f24675b = new RectF();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.f24675b;
        float f2 = this.f24676c + 0.0f;
        rectF.top = f2;
        rectF.left = f2;
        rectF.bottom = getMeasuredHeight() - this.f24676c;
        RectF rectF2 = this.f24675b;
        float measuredWidth = getMeasuredWidth();
        float f3 = this.f24676c;
        rectF2.right = measuredWidth - f3;
        canvas.drawRoundRect(this.f24675b, f3, f3, this.f24674a);
    }

    public ShadowLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2113R.styleable.shadowlayout);
        this.f24677d = obtainStyledAttributes.getColor(1, -16776961);
        this.f24678e = obtainStyledAttributes.getColor(0, ViewCompat.MEASURED_STATE_MASK);
        this.f24676c = obtainStyledAttributes.getDimensionPixelSize(2, 3);
        m25844a();
    }
}
