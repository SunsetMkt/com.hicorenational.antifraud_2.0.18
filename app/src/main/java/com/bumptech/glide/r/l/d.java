package com.bumptech.glide.r.l;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: compiled from: BitmapThumbnailImageViewTarget.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends q<Bitmap> {
    public d(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.r.l.q
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Drawable b(Bitmap bitmap) {
        return new BitmapDrawable(((ImageView) this.f3526b).getResources(), bitmap);
    }

    @Deprecated
    public d(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
