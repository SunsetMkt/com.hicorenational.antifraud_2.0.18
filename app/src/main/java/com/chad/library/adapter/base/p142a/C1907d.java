package com.chad.library.adapter.base.p142a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/* compiled from: SlideInBottomAnimation.java */
/* renamed from: com.chad.library.adapter.base.a.d */
/* loaded from: classes.dex */
public class C1907d implements InterfaceC1905b {
    @Override // com.chad.library.adapter.base.p142a.InterfaceC1905b
    /* renamed from: a */
    public Animator[] mo5235a(View view) {
        return new Animator[]{ObjectAnimator.ofFloat(view, "translationY", view.getMeasuredHeight(), 0.0f)};
    }
}
