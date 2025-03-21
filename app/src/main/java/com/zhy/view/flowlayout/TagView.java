package com.zhy.view.flowlayout;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;

/* loaded from: classes2.dex */
public class TagView extends FrameLayout implements Checkable {

    /* renamed from: b */
    private static final int[] f16868b = {android.R.attr.state_checked};

    /* renamed from: a */
    private boolean f16869a;

    public TagView(Context context) {
        super(context);
    }

    public View getTagView() {
        return getChildAt(0);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f16869a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, f16868b);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f16869a != z) {
            this.f16869a = z;
            refreshDrawableState();
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f16869a);
    }
}
