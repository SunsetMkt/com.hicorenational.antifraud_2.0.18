package com.bumptech.glide.p137r.p138l;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* compiled from: BitmapThumbnailImageViewTarget.java */
/* renamed from: com.bumptech.glide.r.l.d */
/* loaded from: classes.dex */
public class C1836d extends AbstractC1849q<Bitmap> {
    public C1836d(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.p137r.p138l.AbstractC1849q
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Drawable mo4877b(Bitmap bitmap) {
        return new BitmapDrawable(((ImageView) this.f5422b).getResources(), bitmap);
    }

    @Deprecated
    public C1836d(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
