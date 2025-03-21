package com.scwang.smartrefresh.layout.header;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import com.scwang.smartrefresh.layout.C2851R;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2873g;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2876j;
import com.scwang.smartrefresh.layout.p190c.EnumC2879b;
import com.scwang.smartrefresh.layout.p190c.EnumC2880c;
import com.scwang.smartrefresh.layout.p192e.AbstractC2892e;
import com.scwang.smartrefresh.layout.p192e.C2889b;

/* loaded from: classes.dex */
public class BezierRadarHeader extends InternalAbstract implements InterfaceC2873g {

    /* renamed from: A */
    protected static final byte f9152A = 2;

    /* renamed from: B */
    protected static final byte f9153B = 3;

    /* renamed from: C */
    protected static final byte f9154C = 4;

    /* renamed from: y */
    protected static final byte f9155y = 0;

    /* renamed from: z */
    protected static final byte f9156z = 1;

    /* renamed from: d */
    protected int f9157d;

    /* renamed from: e */
    protected int f9158e;

    /* renamed from: f */
    protected boolean f9159f;

    /* renamed from: g */
    protected boolean f9160g;

    /* renamed from: h */
    protected boolean f9161h;

    /* renamed from: i */
    protected boolean f9162i;

    /* renamed from: j */
    protected Path f9163j;

    /* renamed from: k */
    protected Paint f9164k;

    /* renamed from: l */
    protected int f9165l;

    /* renamed from: m */
    protected int f9166m;

    /* renamed from: n */
    protected int f9167n;

    /* renamed from: o */
    protected float f9168o;

    /* renamed from: p */
    protected float f9169p;

    /* renamed from: q */
    protected float f9170q;

    /* renamed from: r */
    protected float f9171r;

    /* renamed from: s */
    protected int f9172s;

    /* renamed from: t */
    protected float f9173t;

    /* renamed from: u */
    protected float f9174u;

    /* renamed from: v */
    protected float f9175v;

    /* renamed from: w */
    protected Animator f9176w;

    /* renamed from: x */
    protected RectF f9177x;

    /* renamed from: com.scwang.smartrefresh.layout.header.BezierRadarHeader$a */
    static /* synthetic */ class C2896a {

        /* renamed from: a */
        static final /* synthetic */ int[] f9178a = new int[EnumC2879b.values().length];

        static {
            try {
                f9178a[EnumC2879b.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9178a[EnumC2879b.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.header.BezierRadarHeader$b */
    protected class C2897b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        byte f9179a;

        C2897b(byte b2) {
            this.f9179a = b2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            byte b2 = this.f9179a;
            if (b2 == 0) {
                BezierRadarHeader.this.f9175v = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (1 == b2) {
                BezierRadarHeader bezierRadarHeader = BezierRadarHeader.this;
                if (bezierRadarHeader.f9161h) {
                    valueAnimator.cancel();
                    return;
                }
                bezierRadarHeader.f9166m = ((Integer) valueAnimator.getAnimatedValue()).intValue() / 2;
            } else if (2 == b2) {
                BezierRadarHeader.this.f9168o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (3 == b2) {
                BezierRadarHeader.this.f9171r = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (4 == b2) {
                BezierRadarHeader.this.f9172s = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
            BezierRadarHeader.this.invalidate();
        }
    }

    public BezierRadarHeader(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    protected void m8756a(Canvas canvas, int i2) {
        this.f9163j.reset();
        this.f9163j.lineTo(0.0f, this.f9165l);
        Path path = this.f9163j;
        int i3 = this.f9167n;
        if (i3 < 0) {
            i3 = i2 / 2;
        }
        float f2 = i2;
        path.quadTo(i3, this.f9166m + r3, f2, this.f9165l);
        this.f9163j.lineTo(f2, 0.0f);
        this.f9164k.setColor(this.f9158e);
        canvas.drawPath(this.f9163j, this.f9164k);
    }

    /* renamed from: b */
    protected void m8760b(Canvas canvas, int i2, int i3) {
        if (this.f9176w != null || isInEditMode()) {
            float f2 = this.f9173t;
            float f3 = this.f9175v;
            float f4 = f2 * f3;
            float f5 = this.f9174u * f3;
            this.f9164k.setColor(this.f9157d);
            this.f9164k.setStyle(Paint.Style.FILL);
            float f6 = i2 / 2;
            float f7 = i3 / 2;
            canvas.drawCircle(f6, f7, f4, this.f9164k);
            this.f9164k.setStyle(Paint.Style.STROKE);
            float f8 = f5 + f4;
            canvas.drawCircle(f6, f7, f8, this.f9164k);
            this.f9164k.setColor((this.f9158e & ViewCompat.MEASURED_SIZE_MASK) | 1426063360);
            this.f9164k.setStyle(Paint.Style.FILL);
            this.f9177x.set(f6 - f4, f7 - f4, f6 + f4, f4 + f7);
            canvas.drawArc(this.f9177x, 270.0f, this.f9172s, true, this.f9164k);
            this.f9164k.setStyle(Paint.Style.STROKE);
            this.f9177x.set(f6 - f8, f7 - f8, f6 + f8, f7 + f8);
            canvas.drawArc(this.f9177x, 270.0f, this.f9172s, false, this.f9164k);
            this.f9164k.setStyle(Paint.Style.FILL);
        }
    }

    /* renamed from: c */
    protected void m8762c(Canvas canvas, int i2, int i3) {
        if (this.f9171r > 0.0f) {
            this.f9164k.setColor(this.f9157d);
            canvas.drawCircle(i2 / 2, i3 / 2, this.f9171r, this.f9164k);
        }
    }

    /* renamed from: d */
    public BezierRadarHeader m8763d(@ColorRes int i2) {
        m8761c(AbstractC2892e.m8745a(getContext(), i2));
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        m8756a(canvas, width);
        m8757a(canvas, width, height);
        m8760b(canvas, width, height);
        m8762c(canvas, width, height);
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.f9176w;
        if (animator != null) {
            animator.removeAllListeners();
            this.f9176w.end();
            this.f9176w = null;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0 && !this.f9159f) {
            m8761c(iArr[0]);
            this.f9159f = false;
        }
        if (iArr.length <= 1 || this.f9160g) {
            return;
        }
        m8755a(iArr[1]);
        this.f9160g = false;
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9162i = false;
        this.f9167n = -1;
        this.f9172s = 0;
        this.f9173t = 0.0f;
        this.f9174u = 0.0f;
        this.f9175v = 0.0f;
        this.f9177x = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.f9233b = EnumC2880c.Scale;
        C2889b c2889b = new C2889b();
        this.f9163j = new Path();
        this.f9164k = new Paint();
        this.f9164k.setAntiAlias(true);
        this.f9170q = c2889b.m8737a(7.0f);
        this.f9173t = c2889b.m8737a(20.0f);
        this.f9174u = c2889b.m8737a(7.0f);
        this.f9164k.setStrokeWidth(c2889b.m8737a(3.0f));
        setMinimumHeight(c2889b.m8737a(100.0f));
        if (isInEditMode()) {
            this.f9165l = 1000;
            this.f9175v = 1.0f;
            this.f9172s = SubsamplingScaleImageView.ORIENTATION_270;
        } else {
            this.f9175v = 0.0f;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2851R.styleable.BezierRadarHeader);
        this.f9162i = obtainStyledAttributes.getBoolean(C2851R.styleable.BezierRadarHeader_srlEnableHorizontalDrag, this.f9162i);
        m8755a(obtainStyledAttributes.getColor(C2851R.styleable.BezierRadarHeader_srlAccentColor, -1));
        m8761c(obtainStyledAttributes.getColor(C2851R.styleable.BezierRadarHeader_srlPrimaryColor, -14540254));
        this.f9160g = obtainStyledAttributes.hasValue(C2851R.styleable.BezierRadarHeader_srlAccentColor);
        this.f9159f = obtainStyledAttributes.hasValue(C2851R.styleable.BezierRadarHeader_srlPrimaryColor);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: c */
    public BezierRadarHeader m8761c(@ColorInt int i2) {
        this.f9158e = i2;
        this.f9159f = true;
        return this;
    }

    /* renamed from: a */
    protected void m8757a(Canvas canvas, int i2, int i3) {
        if (this.f9168o > 0.0f) {
            this.f9164k.setColor(this.f9157d);
            float m8734b = C2889b.m8734b(i3);
            float f2 = i2 / 7;
            float f3 = this.f9169p;
            float f4 = 1.0f;
            float f5 = (f2 * f3) - (f3 > 1.0f ? ((f3 - 1.0f) * f2) / f3 : 0.0f);
            float f6 = i3;
            float f7 = this.f9169p;
            float f8 = 2.0f;
            float f9 = f6 - (f7 > 1.0f ? (((f7 - 1.0f) * f6) / 2.0f) / f7 : 0.0f);
            int i4 = 0;
            while (i4 < 7) {
                float f10 = (i4 + f4) - 4.0f;
                this.f9164k.setAlpha((int) (this.f9168o * (f4 - ((Math.abs(f10) / 7.0f) * f8)) * 255.0f * (1.0d - (1.0d / Math.pow((m8734b / 800.0d) + 1.0d, 15.0d)))));
                float f11 = this.f9170q * (1.0f - (1.0f / ((m8734b / 10.0f) + 1.0f)));
                canvas.drawCircle(((i2 / 2) - (f11 / 2.0f)) + (f10 * f5), f9 / 2.0f, f11, this.f9164k);
                i4++;
                f4 = 1.0f;
                f8 = 2.0f;
            }
            this.f9164k.setAlpha(255);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    /* renamed from: a */
    public void mo8717a(boolean z, float f2, int i2, int i3, int i4) {
        if (z || this.f9161h) {
            this.f9161h = true;
            this.f9165l = Math.min(i3, i2);
            this.f9166m = (int) (Math.max(0, i2 - i3) * 1.9f);
            this.f9169p = f2;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    /* renamed from: b */
    public void mo8719b(@NonNull InterfaceC2876j interfaceC2876j, int i2, int i3) {
        this.f9165l = i2;
        this.f9161h = false;
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 360);
        ofInt.setDuration(720L);
        ofInt.setRepeatCount(-1);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.addUpdateListener(new C2897b((byte) 4));
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setInterpolator(decelerateInterpolator);
        ofFloat.addUpdateListener(new C2897b((byte) 2));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(decelerateInterpolator);
        ofFloat2.addUpdateListener(new C2897b((byte) 0));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2, ofInt);
        animatorSet.start();
        int i4 = this.f9166m;
        ValueAnimator ofInt2 = ValueAnimator.ofInt(i4, 0, -((int) (i4 * 0.8f)), 0, -((int) (i4 * 0.4f)), 0);
        ofInt2.addUpdateListener(new C2897b((byte) 1));
        ofInt2.setInterpolator(decelerateInterpolator);
        ofInt2.setDuration(800L);
        ofInt2.start();
        this.f9176w = animatorSet;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    /* renamed from: a */
    public int mo8713a(@NonNull InterfaceC2876j interfaceC2876j, boolean z) {
        Animator animator = this.f9176w;
        if (animator != null) {
            animator.removeAllListeners();
            this.f9176w.end();
            this.f9176w = null;
        }
        int width = getWidth();
        int height = getHeight();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, (float) Math.sqrt((width * width) + (height * height)));
        ofFloat.setDuration(400L);
        ofFloat.addUpdateListener(new C2897b((byte) 3));
        ofFloat.start();
        return 400;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p191d.InterfaceC2886f
    /* renamed from: a */
    public void mo8733a(@NonNull InterfaceC2876j interfaceC2876j, @NonNull EnumC2879b enumC2879b, @NonNull EnumC2879b enumC2879b2) {
        int i2 = C2896a.f9178a[enumC2879b2.ordinal()];
        if (i2 == 1 || i2 == 2) {
            this.f9168o = 1.0f;
            this.f9175v = 0.0f;
            this.f9171r = 0.0f;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    /* renamed from: a */
    public boolean mo8718a() {
        return this.f9162i;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    /* renamed from: a */
    public void mo8714a(float f2, int i2, int i3) {
        this.f9167n = i2;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    /* renamed from: b */
    public BezierRadarHeader m8758b(@ColorRes int i2) {
        m8755a(AbstractC2892e.m8745a(getContext(), i2));
        return this;
    }

    /* renamed from: b */
    public BezierRadarHeader m8759b(boolean z) {
        this.f9162i = z;
        if (!z) {
            this.f9167n = -1;
        }
        return this;
    }

    /* renamed from: a */
    public BezierRadarHeader m8755a(@ColorInt int i2) {
        this.f9157d = i2;
        this.f9160g = true;
        return this;
    }
}
