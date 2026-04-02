package com.bumptech.glide.r.m;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.r.m.f;

/* JADX INFO: compiled from: DrawableCrossFadeTransition.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements f<Drawable> {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f3541b;

    public d(int i2, boolean z) {
        this.a = i2;
        this.f3541b = z;
    }

    @Override // com.bumptech.glide.r.m.f
    public boolean a(Drawable drawable, f.a aVar) {
        Drawable drawableB = aVar.b();
        if (drawableB == null) {
            drawableB = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawableB, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f3541b);
        transitionDrawable.startTransition(this.a);
        aVar.d(transitionDrawable);
        return true;
    }
}
