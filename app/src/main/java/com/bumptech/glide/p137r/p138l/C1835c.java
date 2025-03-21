package com.bumptech.glide.p137r.p138l;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* compiled from: BitmapImageViewTarget.java */
/* renamed from: com.bumptech.glide.r.l.c */
/* loaded from: classes.dex */
public class C1835c extends AbstractC1842j<Bitmap> {
    public C1835c(ImageView imageView) {
        super(imageView);
    }

    @Deprecated
    public C1835c(ImageView imageView, boolean z) {
        super(imageView, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.p137r.p138l.AbstractC1842j
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo4875a(Bitmap bitmap) {
        ((ImageView) this.f5422b).setImageBitmap(bitmap);
    }
}
