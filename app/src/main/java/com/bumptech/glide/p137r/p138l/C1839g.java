package com.bumptech.glide.p137r.p138l;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* compiled from: DrawableImageViewTarget.java */
/* renamed from: com.bumptech.glide.r.l.g */
/* loaded from: classes.dex */
public class C1839g extends AbstractC1842j<Drawable> {
    public C1839g(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.p137r.p138l.AbstractC1842j
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void mo4875a(@Nullable Drawable drawable) {
        ((ImageView) this.f5422b).setImageDrawable(drawable);
    }

    @Deprecated
    public C1839g(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
