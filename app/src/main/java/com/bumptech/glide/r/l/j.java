package com.bumptech.glide.r.l;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.r.m.f;

/* JADX INFO: compiled from: ImageViewTarget.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class j<Z> extends r<ImageView, Z> implements f.a {

    /* JADX INFO: renamed from: j */
    @Nullable
    private Animatable f3511j;

    public j(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.r.l.b, com.bumptech.glide.r.l.p
    public void a(@Nullable Drawable drawable) {
        super.a(drawable);
        c((Object) null);
        d(drawable);
    }

    protected abstract void a(@Nullable Z z);

    @Override // com.bumptech.glide.r.m.f.a
    @Nullable
    public Drawable b() {
        return ((ImageView) this.f3526b).getDrawable();
    }

    @Override // com.bumptech.glide.r.l.r, com.bumptech.glide.r.l.b, com.bumptech.glide.r.l.p
    public void c(@Nullable Drawable drawable) {
        super.c(drawable);
        Animatable animatable = this.f3511j;
        if (animatable != null) {
            animatable.stop();
        }
        c((Object) null);
        d(drawable);
    }

    @Override // com.bumptech.glide.r.m.f.a
    public void d(Drawable drawable) {
        ((ImageView) this.f3526b).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.r.l.b, com.bumptech.glide.manager.i
    public void onStart() {
        Animatable animatable = this.f3511j;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.bumptech.glide.r.l.b, com.bumptech.glide.manager.i
    public void onStop() {
        Animatable animatable = this.f3511j;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Deprecated
    public j(ImageView imageView, boolean z) {
        super(imageView, z);
    }

    @Override // com.bumptech.glide.r.l.r, com.bumptech.glide.r.l.b, com.bumptech.glide.r.l.p
    public void b(@Nullable Drawable drawable) {
        super.b(drawable);
        c((Object) null);
        d(drawable);
    }

    @Override // com.bumptech.glide.r.l.p
    public void a(@NonNull Z z, @Nullable com.bumptech.glide.r.m.f<? super Z> fVar) {
        if (fVar != null && fVar.a(z, this)) {
            b(z);
        } else {
            c(z);
        }
    }

    private void b(@Nullable Z z) {
        if (z instanceof Animatable) {
            this.f3511j = (Animatable) z;
            this.f3511j.start();
        } else {
            this.f3511j = null;
        }
    }

    private void c(@Nullable Z z) {
        a(z);
        b(z);
    }
}
