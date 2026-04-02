package com.lxj.xpopup.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.lxj.xpopup.e.b;
import com.lxj.xpopup.f.c;

/* JADX INFO: loaded from: classes2.dex */
public class PartShadowContainer extends FrameLayout {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f5530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f5531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f5532d;

    public PartShadowContainer(@NonNull Context context) {
        super(context);
        this.a = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        View childAt = getChildAt(0);
        int[] iArr = new int[2];
        childAt.getLocationInWindow(iArr);
        if (!c.a(motionEvent.getRawX(), motionEvent.getRawY(), new Rect(iArr[0], iArr[1], iArr[0] + childAt.getMeasuredWidth(), iArr[1] + childAt.getMeasuredHeight()))) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f5530b = motionEvent.getX();
                this.f5531c = motionEvent.getY();
            } else if (action == 1) {
                if (((float) Math.sqrt(Math.pow(motionEvent.getX() - this.f5530b, 2.0d) + Math.pow(motionEvent.getY() - this.f5531c, 2.0d))) < ViewConfiguration.get(getContext()).getScaledTouchSlop() && this.a && (bVar = this.f5532d) != null) {
                    bVar.a();
                }
                this.f5530b = 0.0f;
                this.f5531c = 0.0f;
            }
        }
        return true;
    }

    public void setOnClickOutsideListener(b bVar) {
        this.f5532d = bVar;
    }

    public PartShadowContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PartShadowContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = true;
    }
}
