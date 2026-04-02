package com.bumptech.glide.load.r.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: compiled from: DrawableTransformation.java */
/* JADX INFO: loaded from: classes.dex */
public class s implements com.bumptech.glide.load.n<Drawable> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.n<Bitmap> f3222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f3223d;

    public s(com.bumptech.glide.load.n<Bitmap> nVar, boolean z) {
        this.f3222c = nVar;
        this.f3223d = z;
    }

    public com.bumptech.glide.load.n<BitmapDrawable> a() {
        return this;
    }

    @Override // com.bumptech.glide.load.n
    @NonNull
    public com.bumptech.glide.load.p.v<Drawable> a(@NonNull Context context, @NonNull com.bumptech.glide.load.p.v<Drawable> vVar, int i2, int i3) {
        com.bumptech.glide.load.p.a0.e eVarD = com.bumptech.glide.b.a(context).d();
        Drawable drawable = vVar.get();
        com.bumptech.glide.load.p.v<Bitmap> vVarA = r.a(eVarD, drawable, i2, i3);
        if (vVarA != null) {
            com.bumptech.glide.load.p.v<Bitmap> vVarA2 = this.f3222c.a(context, vVarA, i2, i3);
            if (!vVarA2.equals(vVarA)) {
                return a(context, vVarA2);
            }
            vVarA2.recycle();
            return vVar;
        }
        if (!this.f3223d) {
            return vVar;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (obj instanceof s) {
            return this.f3222c.equals(((s) obj).f3222c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return this.f3222c.hashCode();
    }

    private com.bumptech.glide.load.p.v<Drawable> a(Context context, com.bumptech.glide.load.p.v<Bitmap> vVar) {
        return z.a(context.getResources(), vVar);
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        this.f3222c.a(messageDigest);
    }
}
