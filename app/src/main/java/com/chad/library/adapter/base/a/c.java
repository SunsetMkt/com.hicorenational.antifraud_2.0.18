package com.chad.library.adapter.base.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/* JADX INFO: compiled from: ScaleInAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f3612b = 0.5f;
    private final float a;

    public c() {
        this(0.5f);
    }

    @Override // com.chad.library.adapter.base.a.b
    public Animator[] a(View view) {
        return new ObjectAnimator[]{ObjectAnimator.ofFloat(view, "scaleX", this.a, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", this.a, 1.0f)};
    }

    public c(float f2) {
        this.a = f2;
    }
}
