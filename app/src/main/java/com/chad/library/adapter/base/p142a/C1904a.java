package com.chad.library.adapter.base.p142a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/* compiled from: AlphaInAnimation.java */
/* renamed from: com.chad.library.adapter.base.a.a */
/* loaded from: classes.dex */
public class C1904a implements InterfaceC1905b {

    /* renamed from: b */
    private static final float f5606b = 0.0f;

    /* renamed from: a */
    private final float f5607a;

    public C1904a() {
        this(0.0f);
    }

    @Override // com.chad.library.adapter.base.p142a.InterfaceC1905b
    /* renamed from: a */
    public Animator[] mo5235a(View view) {
        return new Animator[]{ObjectAnimator.ofFloat(view, "alpha", this.f5607a, 1.0f)};
    }

    public C1904a(float f2) {
        this.f5607a = f2;
    }
}
