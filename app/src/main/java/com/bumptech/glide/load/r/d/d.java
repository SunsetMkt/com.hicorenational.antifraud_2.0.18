package com.bumptech.glide.load.r.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: compiled from: BitmapDrawableTransformation.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class d implements com.bumptech.glide.load.n<BitmapDrawable> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.n<Drawable> f3146c;

    public d(com.bumptech.glide.load.n<Bitmap> nVar) {
        this.f3146c = (com.bumptech.glide.load.n) com.bumptech.glide.util.j.a(new s(nVar, false));
    }

    private static com.bumptech.glide.load.p.v<Drawable> b(com.bumptech.glide.load.p.v<BitmapDrawable> vVar) {
        return vVar;
    }

    @Override // com.bumptech.glide.load.n
    @NonNull
    public com.bumptech.glide.load.p.v<BitmapDrawable> a(@NonNull Context context, @NonNull com.bumptech.glide.load.p.v<BitmapDrawable> vVar, int i2, int i3) {
        return a(this.f3146c.a(context, b(vVar), i2, i3));
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f3146c.equals(((d) obj).f3146c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return this.f3146c.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static com.bumptech.glide.load.p.v<BitmapDrawable> a(com.bumptech.glide.load.p.v<Drawable> vVar) {
        if (vVar.get() instanceof BitmapDrawable) {
            return vVar;
        }
        throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + vVar.get());
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        this.f3146c.a(messageDigest);
    }
}
