package com.tencent.bugly.beta.global;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.bugly.proguard.an;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class c implements View.OnTouchListener {
    final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object[] f6016b;

    public c(int i2, Object... objArr) {
        this.a = i2;
        this.f6016b = objArr;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
        } catch (Exception e2) {
            if (!an.b(e2)) {
                e2.printStackTrace();
            }
        }
        if (this.a != 1) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0 || action == 2) {
            view.setBackgroundDrawable((Drawable) this.f6016b[0]);
        } else {
            view.setBackgroundDrawable((Drawable) this.f6016b[1]);
        }
        return false;
    }
}
