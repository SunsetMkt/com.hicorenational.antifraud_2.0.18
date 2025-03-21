package com.google.android.material.card;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RestrictTo;
import com.google.android.material.C1921R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
class MaterialCardViewHelper {
    private static final int DEFAULT_STROKE_VALUE = -1;
    private final MaterialCardView materialCardView;
    private int strokeColor;
    private int strokeWidth;

    public MaterialCardViewHelper(MaterialCardView materialCardView) {
        this.materialCardView = materialCardView;
    }

    private void adjustContentPadding() {
        this.materialCardView.setContentPadding(this.materialCardView.getContentPaddingLeft() + this.strokeWidth, this.materialCardView.getContentPaddingTop() + this.strokeWidth, this.materialCardView.getContentPaddingRight() + this.strokeWidth, this.materialCardView.getContentPaddingBottom() + this.strokeWidth);
    }

    private Drawable createForegroundDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.materialCardView.getRadius());
        int i2 = this.strokeColor;
        if (i2 != -1) {
            gradientDrawable.setStroke(this.strokeWidth, i2);
        }
        return gradientDrawable;
    }

    @ColorInt
    int getStrokeColor() {
        return this.strokeColor;
    }

    @Dimension
    int getStrokeWidth() {
        return this.strokeWidth;
    }

    public void loadFromAttributes(TypedArray typedArray) {
        this.strokeColor = typedArray.getColor(C1921R.styleable.MaterialCardView_strokeColor, -1);
        this.strokeWidth = typedArray.getDimensionPixelSize(C1921R.styleable.MaterialCardView_strokeWidth, 0);
        updateForeground();
        adjustContentPadding();
    }

    void setStrokeColor(@ColorInt int i2) {
        this.strokeColor = i2;
        updateForeground();
    }

    void setStrokeWidth(@Dimension int i2) {
        this.strokeWidth = i2;
        updateForeground();
        adjustContentPadding();
    }

    void updateForeground() {
        this.materialCardView.setForeground(createForegroundDrawable());
    }
}
