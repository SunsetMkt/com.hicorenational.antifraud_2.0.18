package com.yalantis.ucrop.view.widget;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.C4415R;
import com.yalantis.ucrop.model.AspectRatio;
import java.util.Locale;

/* loaded from: classes2.dex */
public class AspectRatioTextView extends AppCompatTextView {
    private final float MARGIN_MULTIPLIER;
    private float mAspectRatio;
    private String mAspectRatioTitle;
    private float mAspectRatioX;
    private float mAspectRatioY;
    private final Rect mCanvasClipBounds;
    private Paint mDotPaint;
    private int mDotSize;

    public AspectRatioTextView(Context context) {
        this(context, null);
    }

    private void applyActiveColor(@ColorInt int i2) {
        Paint paint = this.mDotPaint;
        if (paint != null) {
            paint.setColor(i2);
        }
        setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[]{0}}, new int[]{i2, ContextCompat.getColor(getContext(), C4415R.color.ucrop_color_widget)}));
    }

    private void init(@NonNull TypedArray typedArray) {
        setGravity(1);
        this.mAspectRatioTitle = typedArray.getString(C4415R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_title);
        this.mAspectRatioX = typedArray.getFloat(C4415R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_x, 0.0f);
        this.mAspectRatioY = typedArray.getFloat(C4415R.styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_y, 0.0f);
        float f2 = this.mAspectRatioX;
        if (f2 != 0.0f) {
            float f3 = this.mAspectRatioY;
            if (f3 != 0.0f) {
                this.mAspectRatio = f2 / f3;
                this.mDotSize = getContext().getResources().getDimensionPixelSize(C4415R.dimen.ucrop_size_dot_scale_text_view);
                this.mDotPaint = new Paint(1);
                this.mDotPaint.setStyle(Paint.Style.FILL);
                setTitle();
                applyActiveColor(getResources().getColor(C4415R.color.ucrop_color_widget_active));
                typedArray.recycle();
            }
        }
        this.mAspectRatio = 0.0f;
        this.mDotSize = getContext().getResources().getDimensionPixelSize(C4415R.dimen.ucrop_size_dot_scale_text_view);
        this.mDotPaint = new Paint(1);
        this.mDotPaint.setStyle(Paint.Style.FILL);
        setTitle();
        applyActiveColor(getResources().getColor(C4415R.color.ucrop_color_widget_active));
        typedArray.recycle();
    }

    private void setTitle() {
        if (TextUtils.isEmpty(this.mAspectRatioTitle)) {
            setText(String.format(Locale.US, "%d:%d", Integer.valueOf((int) this.mAspectRatioX), Integer.valueOf((int) this.mAspectRatioY)));
        } else {
            setText(this.mAspectRatioTitle);
        }
    }

    private void toggleAspectRatio() {
        if (this.mAspectRatio != 0.0f) {
            float f2 = this.mAspectRatioX;
            this.mAspectRatioX = this.mAspectRatioY;
            this.mAspectRatioY = f2;
            this.mAspectRatio = this.mAspectRatioX / this.mAspectRatioY;
        }
    }

    public float getAspectRatio(boolean z) {
        if (z) {
            toggleAspectRatio();
            setTitle();
        }
        return this.mAspectRatio;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected()) {
            canvas.getClipBounds(this.mCanvasClipBounds);
            Rect rect = this.mCanvasClipBounds;
            float f2 = (rect.right - rect.left) / 2.0f;
            float f3 = rect.bottom - (rect.top / 2.0f);
            int i2 = this.mDotSize;
            canvas.drawCircle(f2, f3 - (i2 * 1.5f), i2 / 2.0f, this.mDotPaint);
        }
    }

    public void setActiveColor(@ColorInt int i2) {
        applyActiveColor(i2);
        invalidate();
    }

    public void setAspectRatio(@NonNull AspectRatio aspectRatio) {
        this.mAspectRatioTitle = aspectRatio.getAspectRatioTitle();
        this.mAspectRatioX = aspectRatio.getAspectRatioX();
        this.mAspectRatioY = aspectRatio.getAspectRatioY();
        float f2 = this.mAspectRatioX;
        if (f2 != 0.0f) {
            float f3 = this.mAspectRatioY;
            if (f3 != 0.0f) {
                this.mAspectRatio = f2 / f3;
                setTitle();
            }
        }
        this.mAspectRatio = 0.0f;
        setTitle();
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.MARGIN_MULTIPLIER = 1.5f;
        this.mCanvasClipBounds = new Rect();
        init(context.obtainStyledAttributes(attributeSet, C4415R.styleable.ucrop_AspectRatioTextView));
    }

    @TargetApi(21)
    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        this.MARGIN_MULTIPLIER = 1.5f;
        this.mCanvasClipBounds = new Rect();
        init(context.obtainStyledAttributes(attributeSet, C4415R.styleable.ucrop_AspectRatioTextView));
    }
}
