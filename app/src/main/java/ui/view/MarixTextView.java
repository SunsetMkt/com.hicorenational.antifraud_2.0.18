package ui.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class MarixTextView extends TextView {
    private Paint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f14559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f14560c;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            MarixTextView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            int measuredWidth = MarixTextView.this.getMeasuredWidth();
            MarixTextView marixTextView = MarixTextView.this;
            marixTextView.a(marixTextView.getText().toString(), measuredWidth);
        }
    }

    public MarixTextView(Context context) {
        super(context);
        a();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        a(getText().toString(), getWidth());
    }

    private void a() {
        this.a = new Paint();
        this.a.set(getPaint());
        this.f14560c = getTextSize();
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public MarixTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public MarixTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2) {
        if (i2 > 0) {
            int paddingLeft = (i2 - getPaddingLeft()) - getPaddingRight();
            float f2 = this.f14560c;
            float f3 = getContext().getResources().getDisplayMetrics().scaledDensity;
            this.a.setTextSize(f2 * f3);
            while (true) {
                if (f2 <= this.f14559b) {
                    break;
                }
                float f4 = paddingLeft;
                if (this.a.measureText(str) <= f4) {
                    break;
                }
                f2 -= 2.0f;
                Paint.FontMetrics fontMetrics = this.a.getFontMetrics();
                if (((double) (this.a.measureText(str) / f4)) * (Math.ceil(fontMetrics.descent - fontMetrics.top) + 2.0d) * 1.9d < getHeight()) {
                    break;
                }
                float f5 = this.f14559b;
                if (f2 <= f5) {
                    f2 = f5;
                    break;
                }
                this.a.setTextSize(f2 * f3);
            }
            setTextSize(f2);
        }
    }
}
