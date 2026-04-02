package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: UnitBitmapDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class h0 implements com.bumptech.glide.load.l<Bitmap, Bitmap> {

    /* JADX INFO: compiled from: UnitBitmapDecoder.java */
    private static final class a implements com.bumptech.glide.load.p.v<Bitmap> {
        private final Bitmap a;

        a(@NonNull Bitmap bitmap) {
            this.a = bitmap;
        }

        @Override // com.bumptech.glide.load.p.v
        public int a() {
            return com.bumptech.glide.util.l.a(this.a);
        }

        @Override // com.bumptech.glide.load.p.v
        @NonNull
        public Class<Bitmap> b() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.p.v
        public void recycle() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.p.v
        @NonNull
        public Bitmap get() {
            return this.a;
        }
    }

    @Override // com.bumptech.glide.load.l
    public boolean a(@NonNull Bitmap bitmap, @NonNull com.bumptech.glide.load.j jVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.l
    public com.bumptech.glide.load.p.v<Bitmap> a(@NonNull Bitmap bitmap, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        return new a(bitmap);
    }
}
