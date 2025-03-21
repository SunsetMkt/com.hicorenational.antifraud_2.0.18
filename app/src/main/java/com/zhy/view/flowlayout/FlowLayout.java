package com.zhy.view.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: f, reason: collision with root package name */
    private static final String f13488f = "FlowLayout";

    /* renamed from: g, reason: collision with root package name */
    private static final int f13489g = -1;

    /* renamed from: h, reason: collision with root package name */
    private static final int f13490h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static final int f13491i = 1;

    /* renamed from: a, reason: collision with root package name */
    protected List<List<View>> f13492a;

    /* renamed from: b, reason: collision with root package name */
    protected List<Integer> f13493b;

    /* renamed from: c, reason: collision with root package name */
    protected List<Integer> f13494c;

    /* renamed from: d, reason: collision with root package name */
    private int f13495d;

    /* renamed from: e, reason: collision with root package name */
    private List<View> f13496e;

    public FlowLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13492a = new ArrayList();
        this.f13493b = new ArrayList();
        this.f13494c = new ArrayList();
        this.f13496e = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TagFlowLayout);
        this.f13495d = obtainStyledAttributes.getInt(R.styleable.TagFlowLayout_tag_gravity, -1);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int paddingLeft;
        this.f13492a.clear();
        this.f13493b.clear();
        this.f13494c.clear();
        this.f13496e.clear();
        int width = getWidth();
        int childCount = getChildCount();
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredWidth + i8 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin > (width - getPaddingLeft()) - getPaddingRight()) {
                    this.f13493b.add(Integer.valueOf(i7));
                    this.f13492a.add(this.f13496e);
                    this.f13494c.add(Integer.valueOf(i8));
                    i7 = marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin;
                    this.f13496e = new ArrayList();
                    i8 = 0;
                }
                i8 += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                i7 = Math.max(i7, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                this.f13496e.add(childAt);
            }
        }
        this.f13493b.add(Integer.valueOf(i7));
        this.f13494c.add(Integer.valueOf(i8));
        this.f13492a.add(this.f13496e);
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.f13492a.size();
        int i10 = paddingTop;
        int i11 = paddingLeft2;
        int i12 = 0;
        while (i12 < size) {
            this.f13496e = this.f13492a.get(i12);
            int intValue = this.f13493b.get(i12).intValue();
            int intValue2 = this.f13494c.get(i12).intValue();
            int i13 = this.f13495d;
            if (i13 != -1) {
                if (i13 == 0) {
                    i6 = (width - intValue2) / 2;
                    paddingLeft = getPaddingLeft();
                } else if (i13 == 1) {
                    i6 = width - intValue2;
                    paddingLeft = getPaddingLeft();
                }
                i11 = i6 + paddingLeft;
            } else {
                i11 = getPaddingLeft();
            }
            int i14 = i11;
            for (int i15 = 0; i15 < this.f13496e.size(); i15++) {
                View view = this.f13496e.get(i15);
                if (view.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i16 = marginLayoutParams2.leftMargin + i14;
                    int i17 = marginLayoutParams2.topMargin + i10;
                    view.layout(i16, i17, view.getMeasuredWidth() + i16, view.getMeasuredHeight() + i17);
                    i14 += view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                }
            }
            i10 += intValue;
            i12++;
            i11 = i14;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 8) {
                if (i5 == childCount - 1) {
                    i6 = Math.max(i7, i6);
                    i9 += i8;
                }
                i4 = size2;
            } else {
                measureChild(childAt, i2, i3);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                i4 = size2;
                int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                int i10 = i7 + measuredWidth;
                if (i10 > (size - getPaddingLeft()) - getPaddingRight()) {
                    i6 = Math.max(i6, i7);
                    i9 += i8;
                } else {
                    measuredHeight = Math.max(i8, measuredHeight);
                    measuredWidth = i10;
                }
                if (i5 == childCount - 1) {
                    i6 = Math.max(measuredWidth, i6);
                    i9 += measuredHeight;
                }
                i8 = measuredHeight;
                i7 = measuredWidth;
            }
            i5++;
            size2 = i4;
        }
        int i11 = size2;
        if (mode != 1073741824) {
            size = getPaddingRight() + i6 + getPaddingLeft();
        }
        setMeasuredDimension(size, mode2 == 1073741824 ? i11 : i9 + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context) {
        this(context, null);
    }
}
