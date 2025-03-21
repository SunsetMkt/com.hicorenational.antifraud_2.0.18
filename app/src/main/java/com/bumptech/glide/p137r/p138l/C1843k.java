package com.bumptech.glide.p137r.p138l;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;

/* compiled from: ImageViewTargetFactory.java */
/* renamed from: com.bumptech.glide.r.l.k */
/* loaded from: classes.dex */
public class C1843k {
    @NonNull
    /* renamed from: a */
    public <Z> AbstractC1850r<ImageView, Z> m4907a(@NonNull ImageView imageView, @NonNull Class<Z> cls) {
        if (Bitmap.class.equals(cls)) {
            return new C1835c(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new C1839g(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
