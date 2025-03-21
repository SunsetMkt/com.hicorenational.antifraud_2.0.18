package com.tencent.open.p213c;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import java.util.List;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.c.c */
/* loaded from: classes2.dex */
public class C3270c extends FrameLayout {
    public C3270c(Context context) {
        super(context);
    }

    /* renamed from: a */
    private void m10483a(WindowInsets windowInsets) {
        DisplayCutout displayCutout;
        List<Rect> boundingRects;
        if (Build.VERSION.SDK_INT < 28 || windowInsets == null || (displayCutout = windowInsets.getDisplayCutout()) == null || (boundingRects = displayCutout.getBoundingRects()) == null || boundingRects.isEmpty()) {
            return;
        }
        setPadding(Math.max(displayCutout.getSafeInsetLeft(), 0), Math.max(displayCutout.getSafeInsetTop(), 0), Math.max(displayCutout.getSafeInsetRight(), 0), Math.max(displayCutout.getSafeInsetBottom(), 0));
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        m10483a(windowInsets);
        return super.onApplyWindowInsets(windowInsets);
    }
}
