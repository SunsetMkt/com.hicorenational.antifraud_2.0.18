package com.bumptech.glide.p137r.p138l;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* compiled from: ThumbnailImageViewTarget.java */
/* renamed from: com.bumptech.glide.r.l.q */
/* loaded from: classes.dex */
public abstract class AbstractC1849q<T> extends AbstractC1842j<T> {
    public AbstractC1849q(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.p137r.p138l.AbstractC1842j
    /* renamed from: a */
    protected void mo4875a(@Nullable T t) {
        int i2;
        int i3;
        ViewGroup.LayoutParams layoutParams = ((ImageView) this.f5422b).getLayoutParams();
        Drawable mo4877b = mo4877b((AbstractC1849q<T>) t);
        if (layoutParams != null && (i2 = layoutParams.width) > 0 && (i3 = layoutParams.height) > 0) {
            mo4877b = new C1841i(mo4877b, i2, i3);
        }
        ((ImageView) this.f5422b).setImageDrawable(mo4877b);
    }

    /* renamed from: b */
    protected abstract Drawable mo4877b(T t);

    @Deprecated
    public AbstractC1849q(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
