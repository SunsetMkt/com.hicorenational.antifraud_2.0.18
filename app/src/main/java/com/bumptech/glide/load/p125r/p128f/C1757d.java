package com.bumptech.glide.load.p125r.p128f;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.p118p.InterfaceC1677v;

/* compiled from: NonOwnedDrawableResource.java */
/* renamed from: com.bumptech.glide.load.r.f.d */
/* loaded from: classes.dex */
final class C1757d extends AbstractC1755b<Drawable> {
    private C1757d(Drawable drawable) {
        super(drawable);
    }

    @Nullable
    /* renamed from: a */
    static InterfaceC1677v<Drawable> m4427a(@Nullable Drawable drawable) {
        if (drawable != null) {
            return new C1757d(drawable);
        }
        return null;
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    @NonNull
    /* renamed from: b */
    public Class<Drawable> mo4184b() {
        return this.f4970a.getClass();
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    public void recycle() {
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    /* renamed from: a */
    public int mo4183a() {
        return Math.max(1, this.f4970a.getIntrinsicWidth() * this.f4970a.getIntrinsicHeight() * 4);
    }
}
