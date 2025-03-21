package com.bumptech.glide.p137r.p139m;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.p137r.p139m.InterfaceC1856f;

/* compiled from: DrawableCrossFadeTransition.java */
/* renamed from: com.bumptech.glide.r.m.d */
/* loaded from: classes.dex */
public class C1854d implements InterfaceC1856f<Drawable> {

    /* renamed from: a */
    private final int f5444a;

    /* renamed from: b */
    private final boolean f5445b;

    public C1854d(int i2, boolean z) {
        this.f5444a = i2;
        this.f5445b = z;
    }

    @Override // com.bumptech.glide.p137r.p139m.InterfaceC1856f
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo4935a(Drawable drawable, InterfaceC1856f.a aVar) {
        Drawable mo4905b = aVar.mo4905b();
        if (mo4905b == null) {
            mo4905b = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{mo4905b, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f5445b);
        transitionDrawable.startTransition(this.f5444a);
        aVar.mo4906d(transitionDrawable);
        return true;
    }
}
