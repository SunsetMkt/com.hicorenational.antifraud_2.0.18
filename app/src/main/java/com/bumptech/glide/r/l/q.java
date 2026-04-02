package com.bumptech.glide.r.l;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: ThumbnailImageViewTarget.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class q<T> extends j<T> {
    public q(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.r.l.j
    protected void a(@Nullable T t) {
        int i2;
        int i3;
        ViewGroup.LayoutParams layoutParams = ((ImageView) this.f3526b).getLayoutParams();
        Drawable drawableB = b((Object) t);
        if (layoutParams != null && (i2 = layoutParams.width) > 0 && (i3 = layoutParams.height) > 0) {
            drawableB = new i(drawableB, i2, i3);
        }
        ((ImageView) this.f3526b).setImageDrawable(drawableB);
    }

    protected abstract Drawable b(T t);

    @Deprecated
    public q(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
