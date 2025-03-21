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
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.bumptech.glide.load.InterfaceC1600n;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.load.resource.gif.C1775f;
import com.bumptech.glide.p134o.InterfaceC1804a;
import com.bumptech.glide.util.C1876j;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GifDrawable extends Drawable implements C1775f.b, Animatable, Animatable2Compat {

    /* renamed from: l */
    public static final int f4990l = -1;

    /* renamed from: m */
    public static final int f4991m = 0;

    /* renamed from: n */
    private static final int f4992n = 119;

    /* renamed from: a */
    private final C1769a f4993a;

    /* renamed from: b */
    private boolean f4994b;

    /* renamed from: c */
    private boolean f4995c;

    /* renamed from: d */
    private boolean f4996d;

    /* renamed from: e */
    private boolean f4997e;

    /* renamed from: f */
    private int f4998f;

    /* renamed from: g */
    private int f4999g;

    /* renamed from: h */
    private boolean f5000h;

    /* renamed from: i */
    private Paint f5001i;

    /* renamed from: j */
    private Rect f5002j;

    /* renamed from: k */
    private List<Animatable2Compat.AnimationCallback> f5003k;

    /* renamed from: com.bumptech.glide.load.resource.gif.GifDrawable$a */
    static final class C1769a extends Drawable.ConstantState {

        /* renamed from: a */
        @VisibleForTesting
        final C1775f f5004a;

        C1769a(C1775f c1775f) {
            this.f5004a = c1775f;
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
    public GifDrawable(Context context, InterfaceC1804a interfaceC1804a, InterfaceC1626e interfaceC1626e, InterfaceC1600n<Bitmap> interfaceC1600n, int i2, int i3, Bitmap bitmap) {
        this(context, interfaceC1804a, interfaceC1600n, i2, i3, bitmap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: k */
    private Drawable.Callback m4439k() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    /* renamed from: l */
    private Rect m4440l() {
        if (this.f5002j == null) {
            this.f5002j = new Rect();
        }
        return this.f5002j;
    }

    /* renamed from: m */
    private Paint m4441m() {
        if (this.f5001i == null) {
            this.f5001i = new Paint(2);
        }
        return this.f5001i;
    }

    /* renamed from: n */
    private void m4442n() {
        List<Animatable2Compat.AnimationCallback> list = this.f5003k;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f5003k.get(i2).onAnimationEnd(this);
            }
        }
    }

    /* renamed from: o */
    private void m4443o() {
        this.f4998f = 0;
    }

    /* renamed from: p */
    private void m4444p() {
        C1876j.m4989a(!this.f4996d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f4993a.f5004a.m4486f() == 1) {
            invalidateSelf();
        } else {
            if (this.f4994b) {
                return;
            }
            this.f4994b = true;
            this.f4993a.f5004a.m4480a(this);
            invalidateSelf();
        }
    }

    /* renamed from: q */
    private void m4445q() {
        this.f4994b = false;
        this.f4993a.f5004a.m4482b(this);
    }

    /* renamed from: a */
    public void m4448a(InterfaceC1600n<Bitmap> interfaceC1600n, Bitmap bitmap) {
        this.f4993a.f5004a.m4478a(interfaceC1600n, bitmap);
    }

    /* renamed from: b */
    public ByteBuffer m4450b() {
        return this.f4993a.f5004a.m4481b();
    }

    /* renamed from: c */
    public Bitmap m4451c() {
        return this.f4993a.f5004a.m4485e();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.f5003k;
        if (list != null) {
            list.clear();
        }
    }

    /* renamed from: d */
    public int m4452d() {
        return this.f4993a.f5004a.m4486f();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f4996d) {
            return;
        }
        if (this.f5000h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), m4440l());
            this.f5000h = false;
        }
        canvas.drawBitmap(this.f4993a.f5004a.m4483c(), (Rect) null, m4440l(), m4441m());
    }

    /* renamed from: e */
    public int m4453e() {
        return this.f4993a.f5004a.m4484d();
    }

    /* renamed from: f */
    public InterfaceC1600n<Bitmap> m4454f() {
        return this.f4993a.f5004a.m4487g();
    }

    /* renamed from: g */
    public int m4455g() {
        return this.f4993a.f5004a.m4490j();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f4993a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f4993a.f5004a.m4488h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f4993a.f5004a.m4491k();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    /* renamed from: h */
    boolean m4456h() {
        return this.f4996d;
    }

    /* renamed from: i */
    public void m4457i() {
        this.f4996d = true;
        this.f4993a.f5004a.m4477a();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f4994b;
    }

    /* renamed from: j */
    public void m4458j() {
        C1876j.m4989a(!this.f4994b, "You cannot restart a currently running animation.");
        this.f4993a.f5004a.m4492l();
        start();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f5000h = true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.f5003k == null) {
            this.f5003k = new ArrayList();
        }
        this.f5003k.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        m4441m().setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        m4441m().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        C1876j.m4989a(!this.f4996d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f4997e = z;
        if (!z) {
            m4445q();
        } else if (this.f4995c) {
            m4444p();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f4995c = true;
        m4443o();
        if (this.f4997e) {
            m4444p();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f4995c = false;
        m4445q();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.f5003k;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }

    public GifDrawable(Context context, InterfaceC1804a interfaceC1804a, InterfaceC1600n<Bitmap> interfaceC1600n, int i2, int i3, Bitmap bitmap) {
        this(new C1769a(new C1775f(ComponentCallbacks2C1576b.m3633a(context), interfaceC1804a, i2, i3, interfaceC1600n, bitmap)));
    }

    /* renamed from: a */
    void m4449a(boolean z) {
        this.f4994b = z;
    }

    @Override // com.bumptech.glide.load.resource.gif.C1775f.b
    /* renamed from: a */
    public void mo4446a() {
        if (m4439k() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (m4453e() == m4452d() - 1) {
            this.f4998f++;
        }
        int i2 = this.f4999g;
        if (i2 == -1 || this.f4998f < i2) {
            return;
        }
        m4442n();
        stop();
    }

    GifDrawable(C1769a c1769a) {
        this.f4997e = true;
        this.f4999g = -1;
        this.f4993a = (C1769a) C1876j.m4985a(c1769a);
    }

    @VisibleForTesting
    GifDrawable(C1775f c1775f, Paint paint) {
        this(new C1769a(c1775f));
        this.f5001i = paint;
    }

    /* renamed from: a */
    public void m4447a(int i2) {
        if (i2 <= 0 && i2 != -1 && i2 != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i2 == 0) {
            int m4489i = this.f4993a.f5004a.m4489i();
            if (m4489i == 0) {
                m4489i = -1;
            }
            this.f4999g = m4489i;
            return;
        }
        this.f4999g = i2;
    }
}
