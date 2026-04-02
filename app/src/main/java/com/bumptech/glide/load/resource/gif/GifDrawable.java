package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.load.n;
import com.bumptech.glide.load.resource.gif.f;
import com.bumptech.glide.util.j;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GifDrawable extends Drawable implements f.b, Animatable, Animatable2Compat {

    /* JADX INFO: renamed from: l */
    public static final int f3260l = -1;

    /* JADX INFO: renamed from: m */
    public static final int f3261m = 0;

    /* JADX INFO: renamed from: n */
    private static final int f3262n = 119;
    private final a a;

    /* JADX INFO: renamed from: b */
    private boolean f3263b;

    /* JADX INFO: renamed from: c */
    private boolean f3264c;

    /* JADX INFO: renamed from: d */
    private boolean f3265d;

    /* JADX INFO: renamed from: e */
    private boolean f3266e;

    /* JADX INFO: renamed from: f */
    private int f3267f;

    /* JADX INFO: renamed from: g */
    private int f3268g;

    /* JADX INFO: renamed from: h */
    private boolean f3269h;

    /* JADX INFO: renamed from: i */
    private Paint f3270i;

    /* JADX INFO: renamed from: j */
    private Rect f3271j;

    /* JADX INFO: renamed from: k */
    private List<Animatable2Compat.AnimationCallback> f3272k;

    static final class a extends Drawable.ConstantState {

        @VisibleForTesting
        final f a;

        a(f fVar) {
            this.a = fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }
    }

    @Deprecated
    public GifDrawable(Context context, com.bumptech.glide.o.a aVar, com.bumptech.glide.load.p.a0.e eVar, n<Bitmap> nVar, int i2, int i3, Bitmap bitmap) {
        this(context, aVar, nVar, i2, i3, bitmap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable.Callback k() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect l() {
        if (this.f3271j == null) {
            this.f3271j = new Rect();
        }
        return this.f3271j;
    }

    private Paint m() {
        if (this.f3270i == null) {
            this.f3270i = new Paint(2);
        }
        return this.f3270i;
    }

    private void n() {
        List<Animatable2Compat.AnimationCallback> list = this.f3272k;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f3272k.get(i2).onAnimationEnd(this);
            }
        }
    }

    private void o() {
        this.f3267f = 0;
    }

    private void p() {
        j.a(!this.f3265d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.a.a.f() == 1) {
            invalidateSelf();
        } else {
            if (this.f3263b) {
                return;
            }
            this.f3263b = true;
            this.a.a.a(this);
            invalidateSelf();
        }
    }

    private void q() {
        this.f3263b = false;
        this.a.a.b(this);
    }

    public void a(n<Bitmap> nVar, Bitmap bitmap) {
        this.a.a.a(nVar, bitmap);
    }

    public ByteBuffer b() {
        return this.a.a.b();
    }

    public Bitmap c() {
        return this.a.a.e();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.f3272k;
        if (list != null) {
            list.clear();
        }
    }

    public int d() {
        return this.a.a.f();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f3265d) {
            return;
        }
        if (this.f3269h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), l());
            this.f3269h = false;
        }
        canvas.drawBitmap(this.a.a.c(), (Rect) null, l(), m());
    }

    public int e() {
        return this.a.a.d();
    }

    public n<Bitmap> f() {
        return this.a.a.g();
    }

    public int g() {
        return this.a.a.j();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.a.a.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.a.a.k();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    boolean h() {
        return this.f3265d;
    }

    public void i() {
        this.f3265d = true;
        this.a.a.a();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f3263b;
    }

    public void j() {
        j.a(!this.f3263b, "You cannot restart a currently running animation.");
        this.a.a.l();
        start();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f3269h = true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.f3272k == null) {
            this.f3272k = new ArrayList();
        }
        this.f3272k.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        m().setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        m().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        j.a(!this.f3265d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f3266e = z;
        if (!z) {
            q();
        } else if (this.f3264c) {
            p();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f3264c = true;
        o();
        if (this.f3266e) {
            p();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f3264c = false;
        q();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.f3272k;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }

    public GifDrawable(Context context, com.bumptech.glide.o.a aVar, n<Bitmap> nVar, int i2, int i3, Bitmap bitmap) {
        this(new a(new f(com.bumptech.glide.b.a(context), aVar, i2, i3, nVar, bitmap)));
    }

    void a(boolean z) {
        this.f3263b = z;
    }

    @Override // com.bumptech.glide.load.resource.gif.f.b
    public void a() {
        if (k() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (e() == d() - 1) {
            this.f3267f++;
        }
        int i2 = this.f3268g;
        if (i2 == -1 || this.f3267f < i2) {
            return;
        }
        n();
        stop();
    }

    GifDrawable(a aVar) {
        this.f3266e = true;
        this.f3268g = -1;
        this.a = (a) j.a(aVar);
    }

    @VisibleForTesting
    GifDrawable(f fVar, Paint paint) {
        this(new a(fVar));
        this.f3270i = paint;
    }

    public void a(int i2) {
        if (i2 <= 0 && i2 != -1 && i2 != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i2 == 0) {
            int i3 = this.a.a.i();
            if (i3 == 0) {
                i3 = -1;
            }
            this.f3268g = i3;
            return;
        }
        this.f3268g = i2;
    }
}
