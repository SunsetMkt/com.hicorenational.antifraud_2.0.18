package com.chad.library.adapter.base.p142a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/* compiled from: SlideInRightAnimation.java */
/* renamed from: com.chad.library.adapter.base.a.f */
/* loaded from: classes.dex */
public class C1909f implements InterfaceC1905b {
    @Override // com.chad.library.adapter.base.p142a.InterfaceC1905b
    /* renamed from: a */
    public Animator[] mo5235a(View view) {
        return new Animator[]{ObjectAnimator.ofFloat(view, "translationX", view.getRootView().getWidth(), 0.0f)};
    }
}
