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
import com.lxj.xpopup.p186e.InterfaceC2808b;
import com.lxj.xpopup.p187f.C2819c;

/* loaded from: classes.dex */
public class PartShadowContainer extends FrameLayout {

    /* renamed from: a */
    public boolean f8910a;

    /* renamed from: b */
    private float f8911b;

    /* renamed from: c */
    private float f8912c;

    /* renamed from: d */
    private InterfaceC2808b f8913d;

    public PartShadowContainer(@NonNull Context context) {
        super(context);
        this.f8910a = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterfaceC2808b interfaceC2808b;
        View childAt = getChildAt(0);
        int[] iArr = new int[2];
        childAt.getLocationInWindow(iArr);
        if (!C2819c.m8462a(motionEvent.getRawX(), motionEvent.getRawY(), new Rect(iArr[0], iArr[1], iArr[0] + childAt.getMeasuredWidth(), iArr[1] + childAt.getMeasuredHeight()))) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f8911b = motionEvent.getX();
                this.f8912c = motionEvent.getY();
            } else if (action == 1) {
                if (((float) Math.sqrt(Math.pow(motionEvent.getX() - this.f8911b, 2.0d) + Math.pow(motionEvent.getY() - this.f8912c, 2.0d))) < ViewConfiguration.get(getContext()).getScaledTouchSlop() && this.f8910a && (interfaceC2808b = this.f8913d) != null) {
                    interfaceC2808b.mo8428a();
                }
                this.f8911b = 0.0f;
                this.f8912c = 0.0f;
            }
        }
        return true;
    }

    public void setOnClickOutsideListener(InterfaceC2808b interfaceC2808b) {
        this.f8913d = interfaceC2808b;
    }

    public PartShadowContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PartShadowContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8910a = true;
    }
}
