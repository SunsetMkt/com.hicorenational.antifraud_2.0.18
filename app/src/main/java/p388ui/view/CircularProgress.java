package p388ui.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import androidx.core.view.MotionEventCompat;
import com.hicorenational.antifraud.C2113R;

@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class CircularProgress extends View {

    /* renamed from: p */
    private static final Interpolator f24472p = new LinearInterpolator();

    /* renamed from: q */
    private static final Interpolator f24473q = new AccelerateDecelerateInterpolator();

    /* renamed from: r */
    private static final int f24474r = 2000;

    /* renamed from: s */
    private static final int f24475s = 900;

    /* renamed from: t */
    private static final int f24476t = 30;

    /* renamed from: u */
    private static final int f24477u = 3;

    /* renamed from: a */
    private final RectF f24478a;

    /* renamed from: b */
    private ObjectAnimator f24479b;

    /* renamed from: c */
    private ObjectAnimator f24480c;

    /* renamed from: d */
    private boolean f24481d;

    /* renamed from: e */
    private Paint f24482e;

    /* renamed from: f */
    private float f24483f;

    /* renamed from: g */
    private float f24484g;

    /* renamed from: h */
    private float f24485h;

    /* renamed from: i */
    private float f24486i;

    /* renamed from: j */
    private boolean f24487j;

    /* renamed from: k */
    private int[] f24488k;

    /* renamed from: l */
    private int f24489l;

    /* renamed from: m */
    private int f24490m;

    /* renamed from: n */
    private Property<CircularProgress, Float> f24491n;

    /* renamed from: o */
    private Property<CircularProgress, Float> f24492o;

    /* renamed from: ui.view.CircularProgress$a */
    class C7165a extends Property<CircularProgress, Float> {
        C7165a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(CircularProgress circularProgress) {
            return Float.valueOf(circularProgress.getCurrentGlobalAngle());
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(CircularProgress circularProgress, Float f2) {
            circularProgress.setCurrentGlobalAngle(f2.floatValue());
        }
    }

    /* renamed from: ui.view.CircularProgress$b */
    class C7166b extends Property<CircularProgress, Float> {
        C7166b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(CircularProgress circularProgress) {
            return Float.valueOf(circularProgress.getCurrentSweepAngle());
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(CircularProgress circularProgress, Float f2) {
            circularProgress.setCurrentSweepAngle(f2.floatValue());
        }
    }

    /* renamed from: ui.view.CircularProgress$c */
    class C7167c implements Animator.AnimatorListener {
        C7167c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            CircularProgress.this.m25748e();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public CircularProgress(Context context) {
        this(context, null);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    private void m25745b() {
        this.f24480c = ObjectAnimator.ofFloat(this, this.f24491n, 360.0f);
        this.f24480c.setInterpolator(f24472p);
        this.f24480c.setDuration(2000L);
        this.f24480c.setRepeatMode(1);
        this.f24480c.setRepeatCount(-1);
        this.f24479b = ObjectAnimator.ofFloat(this, this.f24492o, 300.0f);
        this.f24479b.setInterpolator(f24473q);
        this.f24479b.setDuration(900L);
        this.f24479b.setRepeatMode(1);
        this.f24479b.setRepeatCount(-1);
        this.f24479b.addListener(new C7167c());
    }

    /* renamed from: c */
    private void m25746c() {
        if (m25744a()) {
            return;
        }
        this.f24487j = true;
        this.f24480c.start();
        this.f24479b.start();
        invalidate();
    }

    /* renamed from: d */
    private void m25747d() {
        if (m25744a()) {
            this.f24487j = false;
            this.f24480c.cancel();
            this.f24479b.cancel();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m25748e() {
        this.f24481d = !this.f24481d;
        if (this.f24481d) {
            int i2 = this.f24489l + 1;
            this.f24489l = i2;
            this.f24489l = i2 % 4;
            int i3 = this.f24490m + 1;
            this.f24490m = i3;
            this.f24490m = i3 % 4;
            this.f24483f = (this.f24483f + 60.0f) % 360.0f;
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        float f2;
        super.draw(canvas);
        float f3 = this.f24484g - this.f24483f;
        float f4 = this.f24485h;
        if (this.f24481d) {
            Paint paint = this.f24482e;
            int[] iArr = this.f24488k;
            paint.setColor(m25742a(iArr[this.f24489l], iArr[this.f24490m], f4 / 300.0f));
            f2 = f4 + 30.0f;
        } else {
            f3 += f4;
            f2 = (360.0f - f4) - 30.0f;
        }
        canvas.drawArc(this.f24478a, f3, f2, false, this.f24482e);
    }

    public float getCurrentGlobalAngle() {
        return this.f24484g;
    }

    public float getCurrentSweepAngle() {
        return this.f24485h;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        m25746c();
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        m25747d();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        RectF rectF = this.f24478a;
        float f2 = this.f24486i;
        rectF.left = (f2 / 2.0f) + 0.5f;
        rectF.right = (i2 - (f2 / 2.0f)) - 0.5f;
        rectF.top = (f2 / 2.0f) + 0.5f;
        rectF.bottom = (i3 - (f2 / 2.0f)) - 0.5f;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 == 0) {
            m25746c();
        } else {
            m25747d();
        }
    }

    public void setCurrentGlobalAngle(float f2) {
        this.f24484g = f2;
        invalidate();
    }

    public void setCurrentSweepAngle(float f2) {
        this.f24485h = f2;
        invalidate();
    }

    public CircularProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    private boolean m25744a() {
        return this.f24487j;
    }

    public CircularProgress(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24478a = new RectF();
        this.f24481d = true;
        this.f24491n = new C7165a(Float.class, "angle");
        this.f24492o = new C7166b(Float.class, "arc");
        float f2 = context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2113R.styleable.CircularProgress, i2, 0);
        this.f24486i = obtainStyledAttributes.getDimension(0, f2 * 3.0f);
        obtainStyledAttributes.recycle();
        this.f24488k = new int[4];
        this.f24488k[0] = ContextCompat.getColor(context, C2113R.color.blue);
        this.f24488k[1] = ContextCompat.getColor(context, C2113R.color.blue);
        this.f24488k[2] = ContextCompat.getColor(context, C2113R.color.blue);
        this.f24488k[3] = ContextCompat.getColor(context, C2113R.color.blue);
        this.f24489l = 0;
        this.f24490m = 1;
        this.f24482e = new Paint();
        this.f24482e.setAntiAlias(true);
        this.f24482e.setStyle(Paint.Style.STROKE);
        this.f24482e.setStrokeCap(Paint.Cap.ROUND);
        this.f24482e.setStrokeWidth(this.f24486i);
        this.f24482e.setColor(this.f24488k[this.f24489l]);
        m25745b();
    }

    /* renamed from: a */
    private static int m25742a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb(255, (int) ((((16711680 & i3) >> 16) * f2) + (((i2 & 16711680) >> 16) * f3)), (int) ((((65280 & i3) >> 8) * f2) + (((i2 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8) * f3)), (int) (((i3 & 255) * f2) + ((i2 & 255) * f3)));
    }
}
