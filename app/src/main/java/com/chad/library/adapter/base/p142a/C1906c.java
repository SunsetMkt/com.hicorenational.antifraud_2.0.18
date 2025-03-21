package com.chad.library.adapter.base.p142a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/* compiled from: ScaleInAnimation.java */
/* renamed from: com.chad.library.adapter.base.a.c */
/* loaded from: classes.dex */
public class C1906c implements InterfaceC1905b {

    /* renamed from: b */
    private static final float f5608b = 0.5f;

    /* renamed from: a */
    private final float f5609a;

    public C1906c() {
        this(f5608b);
    }

    @Override // com.chad.library.adapter.base.p142a.InterfaceC1905b
    /* renamed from: a */
    public Animator[] mo5235a(View view) {
        return new ObjectAnimator[]{ObjectAnimator.ofFloat(view, "scaleX", this.f5609a, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", this.f5609a, 1.0f)};
    }

    public C1906c(float f2) {
        this.f5609a = f2;
    }
}
