package p388ui.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.TextView;

/* loaded from: classes2.dex */
public class MarixTextView extends TextView {

    /* renamed from: a */
    private Paint f24558a;

    /* renamed from: b */
    private float f24559b;

    /* renamed from: c */
    private float f24560c;

    /* renamed from: ui.view.MarixTextView$a */
    class ViewTreeObserverOnGlobalLayoutListenerC7177a implements ViewTreeObserver.OnGlobalLayoutListener {
        ViewTreeObserverOnGlobalLayoutListenerC7177a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            MarixTextView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            int measuredWidth = MarixTextView.this.getMeasuredWidth();
            MarixTextView marixTextView = MarixTextView.this;
            marixTextView.m25781a(marixTextView.getText().toString(), measuredWidth);
        }
    }

    public MarixTextView(Context context) {
        super(context);
        m25780a();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        m25781a(getText().toString(), getWidth());
    }

    /* renamed from: a */
    private void m25780a() {
        this.f24558a = new Paint();
        this.f24558a.set(getPaint());
        this.f24560c = getTextSize();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC7177a());
    }

    public MarixTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25780a();
    }

    public MarixTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        m25780a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m25781a(String str, int i2) {
        if (i2 > 0) {
            int paddingLeft = (i2 - getPaddingLeft()) - getPaddingRight();
            float f2 = this.f24560c;
            float f3 = getContext().getResources().getDisplayMetrics().scaledDensity;
            this.f24558a.setTextSize(f2 * f3);
            while (true) {
                if (f2 <= this.f24559b) {
                    break;
                }
                if (this.f24558a.measureText(str) <= paddingLeft) {
                    break;
                }
                f2 -= 2.0f;
                Paint.FontMetrics fontMetrics = this.f24558a.getFontMetrics();
                if ((this.f24558a.measureText(str) / r3) * (Math.ceil(fontMetrics.descent - fontMetrics.top) + 2.0d) * 1.9d < getHeight()) {
                    break;
                }
                float f4 = this.f24559b;
                if (f2 <= f4) {
                    f2 = f4;
                    break;
                }
                this.f24558a.setTextSize(f2 * f3);
            }
            setTextSize(f2);
        }
    }
}
