package com.bumptech.glide.p137r.p138l;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.util.C1876j;

/* compiled from: FixedSizeDrawable.java */
/* renamed from: com.bumptech.glide.r.l.i */
/* loaded from: classes.dex */
public class C1841i extends Drawable {

    /* renamed from: a */
    private final Matrix f5397a;

    /* renamed from: b */
    private final RectF f5398b;

    /* renamed from: c */
    private final RectF f5399c;

    /* renamed from: d */
    private Drawable f5400d;

    /* renamed from: e */
    private a f5401e;

    /* renamed from: f */
    private boolean f5402f;

    /* compiled from: FixedSizeDrawable.java */
    /* renamed from: com.bumptech.glide.r.l.i$a */
    static final class a extends Drawable.ConstantState {

        /* renamed from: a */
        private final Drawable.ConstantState f5403a;

        /* renamed from: b */
        final int f5404b;

        /* renamed from: c */
        final int f5405c;

        a(a aVar) {
            this(aVar.f5403a, aVar.f5404b, aVar.f5405c);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new C1841i(this, this.f5403a.newDrawable());
        }

        a(Drawable.ConstantState constantState, int i2, int i3) {
            this.f5403a = constantState;
            this.f5404b = i2;
            this.f5405c = i3;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new C1841i(this, this.f5403a.newDrawable(resources));
        }
    }

    public C1841i(Drawable drawable, int i2, int i3) {
        this(new a(drawable.getConstantState(), i2, i3), drawable);
    }

    /* renamed from: a */
    private void m4902a() {
        this.f5397a.setRectToRect(this.f5398b, this.f5399c, Matrix.ScaleToFit.CENTER);
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.f5400d.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        canvas.concat(this.f5397a);
        this.f5400d.draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(19)
    public int getAlpha() {
        return this.f5400d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return this.f5400d.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f5400d.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f5401e;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable getCurrent() {
        return this.f5400d.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f5401e.f5405c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f5401e.f5404b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f5400d.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f5400d.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f5400d.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        return this.f5400d.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.f5400d.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.f5402f && super.mutate() == this) {
            this.f5400d = this.f5400d.mutate();
            this.f5401e = new a(this.f5401e);
            this.f5402f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(@NonNull Runnable runnable, long j2) {
        super.scheduleSelf(runnable, j2);
        this.f5400d.scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f5400d.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i2, int i3, int i4, int i5) {
        super.setBounds(i2, i3, i4, i5);
        this.f5399c.set(i2, i3, i4, i5);
        m4902a();
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i2) {
        this.f5400d.setChangingConfigurations(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i2, @NonNull PorterDuff.Mode mode) {
        this.f5400d.setColorFilter(i2, mode);
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public void setDither(boolean z) {
        this.f5400d.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f5400d.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.f5400d.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(@NonNull Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.f5400d.unscheduleSelf(runnable);
    }

    C1841i(a aVar, Drawable drawable) {
        this.f5401e = (a) C1876j.m4985a(aVar);
        this.f5400d = (Drawable) C1876j.m4985a(drawable);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f5397a = new Matrix();
        this.f5398b = new RectF(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f5399c = new RectF();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5400d.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(@NonNull Rect rect) {
        super.setBounds(rect);
        this.f5399c.set(rect);
        m4902a();
    }
}
