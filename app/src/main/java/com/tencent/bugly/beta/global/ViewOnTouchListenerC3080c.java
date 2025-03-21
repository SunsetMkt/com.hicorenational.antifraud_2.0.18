package com.tencent.bugly.beta.global;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.bugly.proguard.C3151an;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.global.c */
/* loaded from: classes2.dex */
public class ViewOnTouchListenerC3080c implements View.OnTouchListener {

    /* renamed from: a */
    final int f9863a;

    /* renamed from: b */
    final Object[] f9864b;

    public ViewOnTouchListenerC3080c(int i2, Object... objArr) {
        this.f9863a = i2;
        this.f9864b = objArr;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
        } catch (Exception e2) {
            if (!C3151an.m9919b(e2)) {
                e2.printStackTrace();
            }
        }
        if (this.f9863a != 1) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0 || action == 2) {
            view.setBackgroundDrawable((Drawable) this.f9864b[0]);
        } else {
            view.setBackgroundDrawable((Drawable) this.f9864b[1]);
        }
        return false;
    }
}
