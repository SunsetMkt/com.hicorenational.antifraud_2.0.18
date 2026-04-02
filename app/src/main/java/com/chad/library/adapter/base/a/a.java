package com.chad.library.adapter.base.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/* JADX INFO: compiled from: AlphaInAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f3611b = 0.0f;
    private final float a;

    public a() {
        this(0.0f);
    }

    @Override // com.chad.library.adapter.base.a.b
    public Animator[] a(View view) {
        return new Animator[]{ObjectAnimator.ofFloat(view, "alpha", this.a, 1.0f)};
    }

    public a(float f2) {
        this.a = f2;
    }
}
