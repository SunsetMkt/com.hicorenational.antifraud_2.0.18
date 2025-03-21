package com.bumptech.glide.p137r.p138l;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.p137r.p139m.InterfaceC1856f;

/* compiled from: ImageViewTarget.java */
/* renamed from: com.bumptech.glide.r.l.j */
/* loaded from: classes.dex */
public abstract class AbstractC1842j<Z> extends AbstractC1850r<ImageView, Z> implements InterfaceC1856f.a {

    /* renamed from: j */
    @Nullable
    private Animatable f5406j;

    public AbstractC1842j(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.p137r.p138l.AbstractC1834b, com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: a */
    public void mo3706a(@Nullable Drawable drawable) {
        super.mo3706a(drawable);
        m4904c((AbstractC1842j<Z>) null);
        mo4906d(drawable);
    }

    /* renamed from: a */
    protected abstract void mo4875a(@Nullable Z z);

    @Override // com.bumptech.glide.p137r.p139m.InterfaceC1856f.a
    @Nullable
    /* renamed from: b */
    public Drawable mo4905b() {
        return ((ImageView) this.f5422b).getDrawable();
    }

    @Override // com.bumptech.glide.p137r.p138l.AbstractC1850r, com.bumptech.glide.p137r.p138l.AbstractC1834b, com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: c */
    public void mo3712c(@Nullable Drawable drawable) {
        super.mo3712c(drawable);
        Animatable animatable = this.f5406j;
        if (animatable != null) {
            animatable.stop();
        }
        m4904c((AbstractC1842j<Z>) null);
        mo4906d(drawable);
    }

    @Override // com.bumptech.glide.p137r.p139m.InterfaceC1856f.a
    /* renamed from: d */
    public void mo4906d(Drawable drawable) {
        ((ImageView) this.f5422b).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.p137r.p138l.AbstractC1834b, com.bumptech.glide.manager.InterfaceC1795i
    public void onStart() {
        Animatable animatable = this.f5406j;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.bumptech.glide.p137r.p138l.AbstractC1834b, com.bumptech.glide.manager.InterfaceC1795i
    public void onStop() {
        Animatable animatable = this.f5406j;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Deprecated
    public AbstractC1842j(ImageView imageView, boolean z) {
        super(imageView, z);
    }

    @Override // com.bumptech.glide.p137r.p138l.AbstractC1850r, com.bumptech.glide.p137r.p138l.AbstractC1834b, com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: b */
    public void mo3710b(@Nullable Drawable drawable) {
        super.mo3710b(drawable);
        m4904c((AbstractC1842j<Z>) null);
        mo4906d(drawable);
    }

    @Override // com.bumptech.glide.p137r.p138l.InterfaceC1848p
    /* renamed from: a */
    public void mo3709a(@NonNull Z z, @Nullable InterfaceC1856f<? super Z> interfaceC1856f) {
        if (interfaceC1856f != null && interfaceC1856f.mo4935a(z, this)) {
            m4903b((AbstractC1842j<Z>) z);
        } else {
            m4904c((AbstractC1842j<Z>) z);
        }
    }

    /* renamed from: b */
    private void m4903b(@Nullable Z z) {
        if (z instanceof Animatable) {
            this.f5406j = (Animatable) z;
            this.f5406j.start();
        } else {
            this.f5406j = null;
        }
    }

    /* renamed from: c */
    private void m4904c(@Nullable Z z) {
        mo4875a((AbstractC1842j<Z>) z);
        m4903b((AbstractC1842j<Z>) z);
    }
}
