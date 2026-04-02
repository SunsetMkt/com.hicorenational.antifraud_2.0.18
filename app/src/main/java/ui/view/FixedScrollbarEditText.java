package ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatEditText;

/* JADX INFO: loaded from: classes2.dex */
public class FixedScrollbarEditText extends AppCompatEditText {
    private Paint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f14526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f14527d;

    public FixedScrollbarEditText(Context context) {
        super(context);
        this.f14525b = 8;
        this.f14526c = 0.0f;
        this.f14527d = 0.0f;
        b();
    }

    private void b() {
        this.f14525b = a(8.0f);
        this.a = new Paint(1);
        this.a.setColor(Color.parseColor("#FF4081"));
        this.a.setStyle(Paint.Style.FILL);
        setVerticalScrollBarEnabled(false);
        getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: ui.view.e
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                this.a.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a() {
        if (getLayout() == null) {
            return;
        }
        int height = getLayout().getHeight();
        int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (height <= height2) {
            this.f14527d = 0.0f;
        } else {
            float f2 = height2;
            this.f14527d = (f2 / height) * f2;
            this.f14526c = getPaddingTop() + ((f2 - this.f14527d) * (getScrollY() / (height - height2)));
        }
        invalidate();
    }

    private Paint getTrackPaint() {
        Paint paint = new Paint(1);
        paint.setColor(Color.parseColor("#E0E0E0"));
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getLineCount() > getMaxLines()) {
            int width = getWidth() - getPaddingRight();
            float f2 = width - this.f14525b;
            float f3 = width;
            canvas.drawRect(f2, getPaddingTop(), f3, getHeight() - getPaddingBottom(), getTrackPaint());
            float f4 = this.f14526c;
            float f5 = f4 + this.f14527d;
            int i2 = this.f14525b;
            canvas.drawRoundRect(f2, f4, f3, f5, i2 / 2, i2 / 2, this.a);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a();
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        post(new Runnable() { // from class: ui.view.d
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a();
            }
        });
    }

    public void setScrollbarColor(int i2) {
        this.a.setColor(i2);
        invalidate();
    }

    public void setScrollbarWidth(int i2) {
        this.f14525b = a(i2);
        invalidate();
    }

    private int a(float f2) {
        return (int) ((f2 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public FixedScrollbarEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14525b = 8;
        this.f14526c = 0.0f;
        this.f14527d = 0.0f;
        b();
    }

    public FixedScrollbarEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14525b = 8;
        this.f14526c = 0.0f;
        this.f14527d = 0.0f;
        b();
    }
}
