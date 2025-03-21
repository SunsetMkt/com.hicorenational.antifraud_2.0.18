package ui.view;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CompoundButton;
import androidx.core.content.ContextCompat;
import com.umeng.commonsdk.framework.UMModuleRegister;
import util.z0;

/* loaded from: classes2.dex */
public class SwitchButton extends CompoundButton {
    public static final float h0 = 1.8f;
    public static final int i0 = 20;
    public static final int j0 = 2;
    public static final int k0 = 2;
    public static final int l0 = 250;
    public static final int m0 = 3309506;
    private static int[] n0 = {R.attr.state_checked, R.attr.state_enabled, R.attr.state_pressed};
    private static int[] o0 = {-16842912, R.attr.state_enabled, R.attr.state_pressed};
    private boolean A;
    private boolean B;
    private ObjectAnimator C;
    private float D;
    private RectF E;
    private float F;
    private float G;
    private float H;
    private int I;
    private int J;
    private Paint K;
    private CharSequence L;
    private CharSequence M;
    private TextPaint N;
    private Layout O;

    /* renamed from: a, reason: collision with root package name */
    private Drawable f20441a;

    /* renamed from: b, reason: collision with root package name */
    private Drawable f20442b;
    private Layout b0;

    /* renamed from: c, reason: collision with root package name */
    private ColorStateList f20443c;
    private float c0;

    /* renamed from: d, reason: collision with root package name */
    private ColorStateList f20444d;
    private float d0;

    /* renamed from: e, reason: collision with root package name */
    private float f20445e;
    private float e0;

    /* renamed from: f, reason: collision with root package name */
    private float f20446f;
    private boolean f0;

    /* renamed from: g, reason: collision with root package name */
    private RectF f20447g;
    private CompoundButton.OnCheckedChangeListener g0;

    /* renamed from: h, reason: collision with root package name */
    private float f20448h;

    /* renamed from: i, reason: collision with root package name */
    private long f20449i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f20450j;

    /* renamed from: k, reason: collision with root package name */
    private int f20451k;

    /* renamed from: l, reason: collision with root package name */
    private PointF f20452l;

    /* renamed from: m, reason: collision with root package name */
    private int f20453m;
    private int n;
    private int o;
    private int p;
    private int q;
    private Drawable r;
    private Drawable s;
    private RectF t;
    private RectF u;
    private RectF v;
    private RectF w;
    private RectF x;
    private Paint y;
    private boolean z;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        CharSequence f20454a;

        /* renamed from: b, reason: collision with root package name */
        CharSequence f20455b;

        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            TextUtils.writeToParcel(this.f20454a, parcel, i2);
            TextUtils.writeToParcel(this.f20455b, parcel, i2);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f20454a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f20455b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.B = false;
        this.f0 = true;
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        float f2;
        float f3;
        float f4;
        float f5;
        boolean z;
        String str;
        String str2;
        int i2;
        Drawable drawable;
        ColorStateList colorStateList;
        float f6;
        float f7;
        float f8;
        Drawable drawable2;
        ColorStateList colorStateList2;
        float f9;
        float f10;
        int i3;
        boolean z2;
        float f11;
        TypedArray obtainStyledAttributes;
        boolean z3;
        this.I = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.J = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.y = new Paint(1);
        this.K = new Paint(1);
        this.K.setStyle(Paint.Style.STROKE);
        this.K.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.N = getPaint();
        this.t = new RectF();
        this.u = new RectF();
        this.v = new RectF();
        this.f20452l = new PointF();
        this.f20447g = new RectF();
        this.w = new RectF();
        this.x = new RectF();
        this.C = ObjectAnimator.ofFloat(this, UMModuleRegister.PROCESS, 0.0f, 0.0f).setDuration(250L);
        this.C.setInterpolator(new AccelerateDecelerateInterpolator());
        this.E = new RectF();
        float f12 = getResources().getDisplayMetrics().density;
        float f13 = f12 * 2.0f;
        float f14 = f12 * 20.0f;
        float f15 = f14 / 2.0f;
        TypedArray obtainStyledAttributes2 = attributeSet == null ? null : getContext().obtainStyledAttributes(attributeSet, com.hicorenational.antifraud.R.styleable.SwitchButton);
        if (obtainStyledAttributes2 != null) {
            drawable = obtainStyledAttributes2.getDrawable(11);
            colorStateList2 = obtainStyledAttributes2.getColorStateList(10);
            float dimension = obtainStyledAttributes2.getDimension(13, f13);
            float dimension2 = obtainStyledAttributes2.getDimension(15, dimension);
            f7 = obtainStyledAttributes2.getDimension(16, dimension);
            float dimension3 = obtainStyledAttributes2.getDimension(17, dimension);
            f6 = obtainStyledAttributes2.getDimension(14, dimension);
            f3 = obtainStyledAttributes2.getDimension(19, f14);
            float dimension4 = obtainStyledAttributes2.getDimension(12, f14);
            float dimension5 = obtainStyledAttributes2.getDimension(18, Math.min(f3, dimension4) / 2.0f);
            float dimension6 = obtainStyledAttributes2.getDimension(5, dimension5 + f13);
            drawable2 = obtainStyledAttributes2.getDrawable(3);
            ColorStateList colorStateList3 = obtainStyledAttributes2.getColorStateList(2);
            float f16 = obtainStyledAttributes2.getFloat(4, 1.8f);
            int integer = obtainStyledAttributes2.getInteger(0, 250);
            boolean z4 = obtainStyledAttributes2.getBoolean(6, true);
            int color = obtainStyledAttributes2.getColor(20, 0);
            str = obtainStyledAttributes2.getString(9);
            String string = obtainStyledAttributes2.getString(8);
            f13 = obtainStyledAttributes2.getDimension(7, Math.max(f13, dimension6 / 2.0f));
            boolean z5 = obtainStyledAttributes2.getBoolean(1, true);
            obtainStyledAttributes2.recycle();
            f2 = dimension4;
            f5 = dimension6;
            f4 = dimension5;
            f10 = f16;
            z = z5;
            i3 = integer;
            f8 = dimension3;
            z2 = z4;
            i2 = color;
            str2 = string;
            f9 = dimension2;
            colorStateList = colorStateList3;
        } else {
            f2 = f14;
            f3 = f2;
            f4 = f15;
            f5 = f4;
            z = true;
            str = null;
            str2 = null;
            i2 = 0;
            drawable = null;
            colorStateList = null;
            f6 = 0.0f;
            f7 = 0.0f;
            f8 = 0.0f;
            drawable2 = null;
            colorStateList2 = null;
            f9 = 0.0f;
            f10 = 1.8f;
            i3 = 250;
            z2 = true;
        }
        float f17 = f6;
        if (attributeSet == null) {
            f11 = f7;
            obtainStyledAttributes = null;
        } else {
            f11 = f7;
            obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.focusable, R.attr.clickable});
        }
        float f18 = f8;
        if (obtainStyledAttributes != null) {
            boolean z6 = obtainStyledAttributes.getBoolean(0, true);
            boolean z7 = obtainStyledAttributes.getBoolean(1, z6);
            setFocusable(z6);
            setClickable(z7);
            obtainStyledAttributes.recycle();
        }
        this.L = str;
        this.M = str2;
        this.e0 = f13;
        this.f0 = z;
        this.f20441a = drawable;
        this.f20444d = colorStateList2;
        this.z = this.f20441a != null;
        this.f20451k = i2;
        if (this.f20451k == 0) {
            TypedValue typedValue = new TypedValue();
            z3 = true;
            if (getContext().getTheme().resolveAttribute(com.hicorenational.antifraud.R.attr.colorAccent, typedValue, true)) {
                this.f20451k = typedValue.data;
            } else {
                this.f20451k = m0;
            }
        } else {
            z3 = true;
        }
        if (!this.z && this.f20444d == null) {
            this.f20444d = z0.b(this.f20451k);
            this.f20453m = this.f20444d.getDefaultColor();
        }
        if (this.z) {
            f3 = Math.max(f3, this.f20441a.getMinimumWidth());
            f2 = Math.max(f2, this.f20441a.getMinimumHeight());
        }
        this.f20452l.set(f3, f2);
        this.f20442b = drawable2;
        this.f20443c = colorStateList;
        if (this.f20442b == null) {
            z3 = false;
        }
        this.A = z3;
        if (!this.A && this.f20443c == null) {
            this.f20443c = z0.a(this.f20451k);
            this.n = this.f20443c.getDefaultColor();
            this.o = this.f20443c.getColorForState(n0, this.n);
        }
        this.f20447g.set(f9, f18, f11, f17);
        float f19 = f10;
        if (this.f20447g.width() >= 0.0f) {
            f19 = Math.max(f19, 1.0f);
        }
        this.f20448h = f19;
        this.f20445e = f4;
        this.f20446f = f5;
        this.f20449i = i3;
        this.f20450j = z2;
        this.C.setDuration(this.f20449i);
        if (isChecked()) {
            setProcess(1.0f);
        }
    }

    private int b(int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int a2 = a(this.f20452l.x * this.f20448h);
        if (this.A) {
            a2 = Math.max(a2, this.f20442b.getMinimumWidth());
        }
        float width = this.O != null ? r2.getWidth() : 0.0f;
        float width2 = this.b0 != null ? r4.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.c0 = 0.0f;
        } else {
            this.c0 = Math.max(width, width2) + (this.e0 * 2.0f);
            float f2 = a2;
            float f3 = f2 - this.f20452l.x;
            float f4 = this.c0;
            if (f3 < f4) {
                a2 = (int) (f2 + (f4 - f3));
            }
        }
        RectF rectF = this.f20447g;
        int max = Math.max(a2, a(a2 + rectF.left + rectF.right));
        int max2 = Math.max(Math.max(max, getPaddingLeft() + max + getPaddingRight()), getSuggestedMinimumWidth());
        return mode == 1073741824 ? Math.max(max2, size) : mode == Integer.MIN_VALUE ? Math.min(max2, size) : max2;
    }

    private void f() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private void g() {
        float paddingTop = getPaddingTop() + Math.max(0.0f, this.f20447g.top);
        float paddingLeft = getPaddingLeft() + Math.max(0.0f, this.f20447g.left);
        if (this.O != null && this.b0 != null) {
            RectF rectF = this.f20447g;
            if (rectF.top + rectF.bottom > 0.0f) {
                float measuredHeight = ((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.f20452l.y;
                RectF rectF2 = this.f20447g;
                paddingTop += ((measuredHeight - rectF2.top) - rectF2.bottom) / 2.0f;
            }
        }
        if (this.z) {
            PointF pointF = this.f20452l;
            pointF.x = Math.max(pointF.x, this.f20441a.getMinimumWidth());
            PointF pointF2 = this.f20452l;
            pointF2.y = Math.max(pointF2.y, this.f20441a.getMinimumHeight());
        }
        RectF rectF3 = this.t;
        PointF pointF3 = this.f20452l;
        rectF3.set(paddingLeft, paddingTop, pointF3.x + paddingLeft, pointF3.y + paddingTop);
        float f2 = this.t.left - this.f20447g.left;
        float f3 = this.f20452l.x;
        float min = Math.min(0.0f, ((Math.max(this.f20448h * f3, f3 + this.c0) - this.t.width()) - this.c0) / 2.0f);
        float height = this.t.height();
        RectF rectF4 = this.f20447g;
        float min2 = Math.min(0.0f, (((height + rectF4.top) + rectF4.bottom) - this.d0) / 2.0f);
        RectF rectF5 = this.u;
        float f4 = f2 + min;
        float f5 = this.t.top;
        RectF rectF6 = this.f20447g;
        float f6 = (f5 - rectF6.top) + min2;
        float f7 = f2 + rectF6.left;
        float f8 = this.f20452l.x;
        float max = f7 + Math.max(this.f20448h * f8, f8 + this.c0);
        RectF rectF7 = this.f20447g;
        rectF5.set(f4, f6, (max + rectF7.right) - min, (this.t.bottom + rectF7.bottom) - min2);
        RectF rectF8 = this.v;
        RectF rectF9 = this.t;
        rectF8.set(rectF9.left, 0.0f, (this.u.right - this.f20447g.right) - rectF9.width(), 0.0f);
        this.f20446f = Math.min(Math.min(this.u.width(), this.u.height()) / 2.0f, this.f20446f);
        Drawable drawable = this.f20442b;
        if (drawable != null) {
            RectF rectF10 = this.u;
            drawable.setBounds((int) rectF10.left, (int) rectF10.top, a(rectF10.right), a(this.u.bottom));
        }
        if (this.O != null) {
            RectF rectF11 = this.u;
            float width = rectF11.left + ((((rectF11.width() - this.t.width()) - this.f20447g.right) - this.O.getWidth()) / 2.0f);
            float f9 = this.f20447g.left;
            float f10 = width + (f9 < 0.0f ? f9 * (-0.5f) : 0.0f);
            if (!this.A && this.f0) {
                f10 += this.f20446f / 4.0f;
            }
            RectF rectF12 = this.u;
            float height2 = rectF12.top + ((rectF12.height() - this.O.getHeight()) / 2.0f);
            this.w.set(f10, height2, this.O.getWidth() + f10, this.O.getHeight() + height2);
        }
        if (this.b0 != null) {
            RectF rectF13 = this.u;
            float width2 = (rectF13.right - ((((rectF13.width() - this.t.width()) - this.f20447g.left) - this.b0.getWidth()) / 2.0f)) - this.b0.getWidth();
            float f11 = this.f20447g.right;
            float f12 = width2 + (f11 < 0.0f ? 0.5f * f11 : 0.0f);
            if (!this.A && this.f0) {
                f12 -= this.f20446f / 4.0f;
            }
            RectF rectF14 = this.u;
            float height3 = rectF14.top + ((rectF14.height() - this.b0.getHeight()) / 2.0f);
            this.x.set(f12, height3, this.b0.getWidth() + f12, this.b0.getHeight() + height3);
        }
    }

    private boolean getStatusBasedOnPos() {
        return getProcess() > 0.5f;
    }

    private void setDrawableState(Drawable drawable) {
        if (drawable != null) {
            drawable.setState(getDrawableState());
            invalidate();
        }
    }

    public void c() {
        setCheckedImmediately(!isChecked());
    }

    public void d() {
        if (this.g0 == null) {
            c();
            return;
        }
        super.setOnCheckedChangeListener(null);
        c();
        setOnCheckedChangeListener(this.g0);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (this.z || (colorStateList2 = this.f20444d) == null) {
            setDrawableState(this.f20441a);
        } else {
            this.f20453m = colorStateList2.getColorForState(getDrawableState(), this.f20453m);
        }
        int[] iArr = isChecked() ? o0 : n0;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.p = textColors.getColorForState(n0, defaultColor);
            this.q = textColors.getColorForState(o0, defaultColor);
        }
        if (!this.A && (colorStateList = this.f20443c) != null) {
            this.n = colorStateList.getColorForState(getDrawableState(), this.n);
            this.o = this.f20443c.getColorForState(iArr, this.n);
            return;
        }
        Drawable drawable = this.f20442b;
        if ((drawable instanceof StateListDrawable) && this.f20450j) {
            drawable.setState(iArr);
            this.s = this.f20442b.getCurrent().mutate();
        } else {
            this.s = null;
        }
        setDrawableState(this.f20442b);
        Drawable drawable2 = this.f20442b;
        if (drawable2 != null) {
            this.r = drawable2.getCurrent().mutate();
        }
    }

    public void e() {
        if (this.g0 == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        setOnCheckedChangeListener(this.g0);
    }

    public long getAnimationDuration() {
        return this.f20449i;
    }

    public ColorStateList getBackColor() {
        return this.f20443c;
    }

    public Drawable getBackDrawable() {
        return this.f20442b;
    }

    public float getBackMeasureRatio() {
        return this.f20448h;
    }

    public float getBackRadius() {
        return this.f20446f;
    }

    public PointF getBackSizeF() {
        return new PointF(this.u.width(), this.u.height());
    }

    public final float getProcess() {
        return this.D;
    }

    public ColorStateList getThumbColor() {
        return this.f20444d;
    }

    public Drawable getThumbDrawable() {
        return this.f20441a;
    }

    public float getThumbHeight() {
        return this.f20452l.y;
    }

    public RectF getThumbMargin() {
        return this.f20447g;
    }

    public float getThumbRadius() {
        return this.f20445e;
    }

    public PointF getThumbSizeF() {
        return this.f20452l;
    }

    public float getThumbWidth() {
        return this.f20452l.x;
    }

    public int getTintColor() {
        return this.f20451k;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x012f  */
    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onDraw(android.graphics.Canvas r15) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ui.view.SwitchButton.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        CharSequence charSequence;
        CharSequence charSequence2;
        if (this.O == null && (charSequence2 = this.L) != null) {
            this.O = a(charSequence2);
        }
        if (this.b0 == null && (charSequence = this.M) != null) {
            this.b0 = a(charSequence);
        }
        setMeasuredDimension(b(i2), a(i3));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        a(savedState.f20454a, savedState.f20455b);
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f20454a = this.L;
        savedState.f20455b = this.M;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        g();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
    
        if (r0 != 3) goto L30;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.isEnabled()
            r1 = 0
            if (r0 == 0) goto L9d
            boolean r0 = r9.isClickable()
            if (r0 == 0) goto L9d
            boolean r0 = r9.isFocusable()
            if (r0 != 0) goto L15
            goto L9d
        L15:
            int r0 = r10.getAction()
            float r2 = r10.getX()
            float r3 = r9.F
            float r2 = r2 - r3
            float r3 = r10.getY()
            float r4 = r9.G
            float r3 = r3 - r4
            r4 = 1
            if (r0 == 0) goto L86
            if (r0 == r4) goto L4d
            r5 = 2
            if (r0 == r5) goto L33
            r5 = 3
            if (r0 == r5) goto L4d
            goto L9c
        L33:
            float r10 = r10.getX()
            float r0 = r9.getProcess()
            float r1 = r9.H
            float r1 = r10 - r1
            android.graphics.RectF r2 = r9.v
            float r2 = r2.width()
            float r1 = r1 / r2
            float r0 = r0 + r1
            r9.setProcess(r0)
            r9.H = r10
            goto L9c
        L4d:
            r9.setPressed(r1)
            boolean r0 = r9.getStatusBasedOnPos()
            long r5 = r10.getEventTime()
            long r7 = r10.getDownTime()
            long r5 = r5 - r7
            float r10 = (float) r5
            int r5 = r9.I
            float r6 = (float) r5
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 >= 0) goto L75
            float r2 = (float) r5
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 >= 0) goto L75
            int r2 = r9.J
            float r2 = (float) r2
            int r10 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r10 >= 0) goto L75
            r9.performClick()
            goto L9c
        L75:
            boolean r10 = r9.isChecked()
            if (r0 == r10) goto L82
            r9.playSoundEffect(r1)
            r9.setChecked(r0)
            goto L9c
        L82:
            r9.a(r0)
            goto L9c
        L86:
            r9.f()
            float r0 = r10.getX()
            r9.F = r0
            float r10 = r10.getY()
            r9.G = r10
            float r10 = r9.F
            r9.H = r10
            r9.setPressed(r4)
        L9c:
            return r4
        L9d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ui.view.SwitchButton.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void setAnimationDuration(long j2) {
        this.f20449i = j2;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.f20443c = colorStateList;
        if (this.f20443c != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i2) {
        setBackColor(ContextCompat.getColorStateList(getContext(), i2));
    }

    public void setBackDrawable(Drawable drawable) {
        this.f20442b = drawable;
        this.A = this.f20442b != null;
        g();
        refreshDrawableState();
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i2) {
        setBackDrawable(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setBackMeasureRatio(float f2) {
        this.f20448h = f2;
        requestLayout();
    }

    public void setBackRadius(float f2) {
        this.f20446f = f2;
        if (this.A) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            a(z);
        }
        super.setChecked(z);
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.C;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.C.cancel();
        }
        setProcess(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.g0 == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        setOnCheckedChangeListener(this.g0);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.g0 == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        setOnCheckedChangeListener(this.g0);
    }

    public void setDrawDebugRect(boolean z) {
        this.B = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.f20450j = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.g0 = onCheckedChangeListener;
    }

    public final void setProcess(float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.D = f2;
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.f20444d = colorStateList;
        if (this.f20444d != null) {
            setThumbDrawable(null);
        }
    }

    public void setThumbColorRes(int i2) {
        setThumbColor(ContextCompat.getColorStateList(getContext(), i2));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.f20441a = drawable;
        this.z = this.f20441a != null;
        g();
        refreshDrawableState();
        requestLayout();
        invalidate();
    }

    public void setThumbDrawableRes(int i2) {
        setThumbDrawable(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setThumbMargin(RectF rectF) {
        if (rectF == null) {
            a(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            a(rectF.left, rectF.top, rectF.right, rectF.bottom);
        }
    }

    public void setThumbRadius(float f2) {
        this.f20445e = f2;
        if (this.z) {
            return;
        }
        invalidate();
    }

    public void setThumbSize(PointF pointF) {
        if (pointF != null) {
            a(pointF.x, pointF.y);
        } else {
            float f2 = getResources().getDisplayMetrics().density * 20.0f;
            a(f2, f2);
        }
    }

    public void setTintColor(int i2) {
        this.f20451k = i2;
        this.f20444d = z0.b(this.f20451k);
        this.f20443c = z0.a(this.f20451k);
        this.A = false;
        this.z = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.B = false;
        this.f0 = true;
        a(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.B = false;
        this.f0 = true;
        a((AttributeSet) null);
    }

    public boolean b() {
        return this.f20450j;
    }

    private Layout a(CharSequence charSequence) {
        return new StaticLayout(charSequence, this.N, (int) Math.ceil(Layout.getDesiredWidth(charSequence, r2)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    private int a(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        float f2 = this.f20452l.y;
        RectF rectF = this.f20447g;
        int a2 = a(Math.max(f2, rectF.top + f2 + rectF.right));
        float height = this.O != null ? r2.getHeight() : 0.0f;
        float height2 = this.b0 != null ? r4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.d0 = 0.0f;
        } else {
            this.d0 = Math.max(height, height2);
            a2 = a(Math.max(a2, this.d0));
        }
        int max = Math.max(a2, getSuggestedMinimumHeight());
        int max2 = Math.max(max, getPaddingTop() + max + getPaddingBottom());
        if (mode == 1073741824) {
            return Math.max(max2, size);
        }
        return mode == Integer.MIN_VALUE ? Math.min(max2, size) : max2;
    }

    private int a(double d2) {
        return (int) Math.ceil(d2);
    }

    protected void a(boolean z) {
        ObjectAnimator objectAnimator = this.C;
        if (objectAnimator == null) {
            return;
        }
        if (objectAnimator.isRunning()) {
            this.C.cancel();
        }
        this.C.setDuration(this.f20449i);
        if (z) {
            this.C.setFloatValues(this.D, 1.0f);
        } else {
            this.C.setFloatValues(this.D, 0.0f);
        }
        this.C.start();
    }

    public boolean a() {
        return this.B;
    }

    public void a(float f2, float f3, float f4, float f5) {
        this.f20447g.set(f2, f3, f4, f5);
        requestLayout();
    }

    public void a(float f2, float f3) {
        this.f20452l.set(f2, f3);
        g();
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.L = charSequence;
        this.M = charSequence2;
        this.O = null;
        this.b0 = null;
        requestLayout();
        invalidate();
    }
}
