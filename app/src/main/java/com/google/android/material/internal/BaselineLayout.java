package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class BaselineLayout extends ViewGroup {
    private int baseline;

    public BaselineLayout(Context context) {
        super(context, null, 0);
        this.baseline = -1;
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.baseline;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = ((i4 - i2) - getPaddingRight()) - paddingLeft;
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = ((paddingRight - measuredWidth) / 2) + paddingLeft;
                int baseline = (this.baseline == -1 || childAt.getBaseline() == -1) ? paddingTop : (this.baseline + paddingTop) - childAt.getBaseline();
                childAt.layout(i7, baseline, measuredWidth + i7, measuredHeight + baseline);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int childCount = getChildCount();
        int i4 = -1;
        int i5 = -1;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i2, i3);
                int baseline = childAt.getBaseline();
                if (baseline != -1) {
                    i4 = Math.max(i4, baseline);
                    i5 = Math.max(i5, childAt.getMeasuredHeight() - baseline);
                }
                i7 = Math.max(i7, childAt.getMeasuredWidth());
                i6 = Math.max(i6, childAt.getMeasuredHeight());
                i8 = View.combineMeasuredStates(i8, childAt.getMeasuredState());
            }
        }
        if (i4 != -1) {
            i6 = Math.max(i6, Math.max(i5, getPaddingBottom()) + i4);
            this.baseline = i4;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i7, getSuggestedMinimumWidth()), i2, i8), View.resolveSizeAndState(Math.max(i6, getSuggestedMinimumHeight()), i3, i8 << 16));
    }

    public BaselineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.baseline = -1;
    }

    public BaselineLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.baseline = -1;
    }
}
