package com.bumptech.glide.load.r.f;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.p.r;
import com.bumptech.glide.load.p.v;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.j;

/* JADX INFO: compiled from: DrawableResource.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b<T extends Drawable> implements v<T>, r {
    protected final T a;

    public b(T t) {
        this.a = (T) j.a(t);
    }

    public void initialize() {
        T t = this.a;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof GifDrawable) {
            ((GifDrawable) t).c().prepareToDraw();
        }
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public final T get() {
        Drawable.ConstantState constantState = this.a.getConstantState();
        return constantState == null ? this.a : (T) constantState.newDrawable();
    }
}
