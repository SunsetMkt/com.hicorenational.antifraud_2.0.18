package com.bumptech.glide.load.p125r.p128f;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.p118p.InterfaceC1673r;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.C1876j;

/* compiled from: DrawableResource.java */
/* renamed from: com.bumptech.glide.load.r.f.b */
/* loaded from: classes.dex */
public abstract class AbstractC1755b<T extends Drawable> implements InterfaceC1677v<T>, InterfaceC1673r {

    /* renamed from: a */
    protected final T f4970a;

    public AbstractC1755b(T t) {
        this.f4970a = (T) C1876j.m4985a(t);
    }

    /* renamed from: c */
    public void mo4195c() {
        T t = this.f4970a;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof GifDrawable) {
            ((GifDrawable) t).m4451c().prepareToDraw();
        }
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    @NonNull
    public final T get() {
        Drawable.ConstantState constantState = this.f4970a.getConstantState();
        return constantState == null ? this.f4970a : (T) constantState.newDrawable();
    }
}
