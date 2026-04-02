package ui.view;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CompoundButton;
import androidx.core.content.ContextCompat;
import com.umeng.commonsdk.framework.UMModuleRegister;
import util.d1;

/* JADX INFO: loaded from: classes2.dex */
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
    private Drawable a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Drawable f14637b;
    private Layout b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ColorStateList f14638c;
    private float c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ColorStateList f14639d;
    private float d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f14640e;
    private float e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f14641f;
    private boolean f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private RectF f14642g;
    private CompoundButton.OnCheckedChangeListener g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f14643h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f14644i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f14645j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f14646k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private PointF f14647l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f14648m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f14649n;
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
        CharSequence a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        CharSequence f14650b;

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
            TextUtils.writeToParcel(this.a, parcel, i2);
            TextUtils.writeToParcel(this.f14650b, parcel, i2);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f14650b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.B = false;
        this.f0 = true;
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        float fMax;
        float fMax2;
        float f2;
        float f3;
        boolean z;
        String string;
        String str;
        int i2;
        Drawable drawable;
        ColorStateList colorStateList;
        float dimension;
        float dimension2;
        float f4;
        Drawable drawable2;
        ColorStateList colorStateList2;
        float f5;
        float f6;
        int i3;
        boolean z2;
        float f7;
        TypedArray typedArrayObtainStyledAttributes;
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
        this.f14647l = new PointF();
        this.f14642g = new RectF();
        this.w = new RectF();
        this.x = new RectF();
        this.C = ObjectAnimator.ofFloat(this, UMModuleRegister.PROCESS, 0.0f, 0.0f).setDuration(250L);
        this.C.setInterpolator(new AccelerateDecelerateInterpolator());
        this.E = new RectF();
        float f8 = getResources().getDisplayMetrics().density;
        float dimension3 = f8 * 2.0f;
        float f9 = f8 * 20.0f;
        float f10 = f9 / 2.0f;
        TypedArray typedArrayObtainStyledAttributes2 = attributeSet == null ? null : getContext().obtainStyledAttributes(attributeSet, com.hicorenational.antifraud.R.styleable.SwitchButton);
        if (typedArrayObtainStyledAttributes2 != null) {
            drawable = typedArrayObtainStyledAttributes2.getDrawable(11);
            colorStateList2 = typedArrayObtainStyledAttributes2.getColorStateList(10);
            float dimension4 = typedArrayObtainStyledAttributes2.getDimension(13, dimension3);
            float dimension5 = typedArrayObtainStyledAttributes2.getDimension(15, dimension4);
            dimension2 = typedArrayObtainStyledAttributes2.getDimension(16, dimension4);
            float dimension6 = typedArrayObtainStyledAttributes2.getDimension(17, dimension4);
            dimension = typedArrayObtainStyledAttributes2.getDimension(14, dimension4);
            fMax2 = typedArrayObtainStyledAttributes2.getDimension(19, f9);
            float dimension7 = typedArrayObtainStyledAttributes2.getDimension(12, f9);
            float dimension8 = typedArrayObtainStyledAttributes2.getDimension(18, Math.min(fMax2, dimension7) / 2.0f);
            float dimension9 = typedArrayObtainStyledAttributes2.getDimension(5, dimension8 + dimension3);
            drawable2 = typedArrayObtainStyledAttributes2.getDrawable(3);
            ColorStateList colorStateList3 = typedArrayObtainStyledAttributes2.getColorStateList(2);
            float f11 = typedArrayObtainStyledAttributes2.getFloat(4, 1.8f);
            int integer = typedArrayObtainStyledAttributes2.getInteger(0, 250);
            boolean z4 = typedArrayObtainStyledAttributes2.getBoolean(6, true);
            int color = typedArrayObtainStyledAttributes2.getColor(20, 0);
            string = typedArrayObtainStyledAttributes2.getString(9);
            String string2 = typedArrayObtainStyledAttributes2.getString(8);
            dimension3 = typedArrayObtainStyledAttributes2.getDimension(7, Math.max(dimension3, dimension9 / 2.0f));
            boolean z5 = typedArrayObtainStyledAttributes2.getBoolean(1, true);
            typedArrayObtainStyledAttributes2.recycle();
            fMax = dimension7;
            f3 = dimension9;
            f2 = dimension8;
            f6 = f11;
            z = z5;
            i3 = integer;
            f4 = dimension6;
            z2 = z4;
            i2 = color;
            str = string2;
            f5 = dimension5;
            colorStateList = colorStateList3;
        } else {
            fMax = f9;
            fMax2 = fMax;
            f2 = f10;
            f3 = f2;
            z = true;
            string = null;
            str = null;
            i2 = 0;
            drawable = null;
            colorStateList = null;
            dimension = 0.0f;
            dimension2 = 0.0f;
            f4 = 0.0f;
            drawable2 = null;
            colorStateList2 = null;
            f5 = 0.0f;
            f6 = 1.8f;
            i3 = 250;
            z2 = true;
        }
        float f12 = dimension;
        if (attributeSet == null) {
            f7 = dimension2;
            typedArrayObtainStyledAttributes = null;
        } else {
            f7 = dimension2;
            typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.focusable, R.attr.clickable});
        }
        float f13 = f4;
        if (typedArrayObtainStyledAttributes != null) {
            boolean z6 = typedArrayObtainStyledAttributes.getBoolean(0, true);
            boolean z7 = typedArrayObtainStyledAttributes.getBoolean(1, z6);
            setFocusable(z6);
            setClickable(z7);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.L = string;
        this.M = str;
        this.e0 = dimension3;
        this.f0 = z;
        this.a = drawable;
        this.f14639d = colorStateList2;
        this.z = this.a != null;
        this.f14646k = i2;
        if (this.f14646k == 0) {
            TypedValue typedValue = new TypedValue();
            z3 = true;
            if (getContext().getTheme().resolveAttribute(com.hicorenational.antifraud.R.attr.colorAccent, typedValue, true)) {
                this.f14646k = typedValue.data;
            } else {
                this.f14646k = m0;
            }
        } else {
            z3 = true;
        }
        if (!this.z && this.f14639d == null) {
            this.f14639d = d1.b(this.f14646k);
            this.f14648m = this.f14639d.getDefaultColor();
        }
        if (this.z) {
            fMax2 = Math.max(fMax2, this.a.getMinimumWidth());
            fMax = Math.max(fMax, this.a.getMinimumHeight());
        }
        this.f14647l.set(fMax2, fMax);
        this.f14637b = drawable2;
        this.f14638c = colorStateList;
        if (this.f14637b == null) {
            z3 = false;
        }
        this.A = z3;
        if (!this.A && this.f14638c == null) {
            this.f14638c = d1.a(this.f14646k);
            this.f14649n = this.f14638c.getDefaultColor();
            this.o = this.f14638c.getColorForState(n0, this.f14649n);
        }
        this.f14642g.set(f5, f13, f7, f12);
        float fMax3 = f6;
        if (this.f14642g.width() >= 0.0f) {
            fMax3 = Math.max(fMax3, 1.0f);
        }
        this.f14643h = fMax3;
        this.f14640e = f2;
        this.f14641f = f3;
        this.f14644i = i3;
        this.f14645j = z2;
        this.C.setDuration(this.f14644i);
        if (isChecked()) {
            setProcess(1.0f);
        }
    }

    private int b(int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int iA = a(this.f14647l.x * this.f14643h);
        if (this.A) {
            iA = Math.max(iA, this.f14637b.getMinimumWidth());
        }
        float width = this.O != null ? r2.getWidth() : 0.0f;
        float width2 = this.b0 != null ? r4.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.c0 = 0.0f;
        } else {
            this.c0 = Math.max(width, width2) + (this.e0 * 2.0f);
            float f2 = iA;
            float f3 = f2 - this.f14647l.x;
            float f4 = this.c0;
            if (f3 < f4) {
                iA = (int) (f2 + (f4 - f3));
            }
        }
        RectF rectF = this.f14642g;
        int iMax = Math.max(iA, a(iA + rectF.left + rectF.right));
        int iMax2 = Math.max(Math.max(iMax, getPaddingLeft() + iMax + getPaddingRight()), getSuggestedMinimumWidth());
        return mode == 1073741824 ? Math.max(iMax2, size) : mode == Integer.MIN_VALUE ? Math.min(iMax2, size) : iMax2;
    }

    private void f() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private void g() {
        float paddingTop = getPaddingTop() + Math.max(0.0f, this.f14642g.top);
        float paddingLeft = getPaddingLeft() + Math.max(0.0f, this.f14642g.left);
        if (this.O != null && this.b0 != null) {
            RectF rectF = this.f14642g;
            if (rectF.top + rectF.bottom > 0.0f) {
                float measuredHeight = ((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.f14647l.y;
                RectF rectF2 = this.f14642g;
                paddingTop += ((measuredHeight - rectF2.top) - rectF2.bottom) / 2.0f;
            }
        }
        if (this.z) {
            PointF pointF = this.f14647l;
            pointF.x = Math.max(pointF.x, this.a.getMinimumWidth());
            PointF pointF2 = this.f14647l;
            pointF2.y = Math.max(pointF2.y, this.a.getMinimumHeight());
        }
        RectF rectF3 = this.t;
        PointF pointF3 = this.f14647l;
        rectF3.set(paddingLeft, paddingTop, pointF3.x + paddingLeft, pointF3.y + paddingTop);
        float f2 = this.t.left - this.f14642g.left;
        float f3 = this.f14647l.x;
        float fMin = Math.min(0.0f, ((Math.max(this.f14643h * f3, f3 + this.c0) - this.t.width()) - this.c0) / 2.0f);
        float fHeight = this.t.height();
        RectF rectF4 = this.f14642g;
        float fMin2 = Math.min(0.0f, (((fHeight + rectF4.top) + rectF4.bottom) - this.d0) / 2.0f);
        RectF rectF5 = this.u;
        float f4 = f2 + fMin;
        float f5 = this.t.top;
        RectF rectF6 = this.f14642g;
        float f6 = (f5 - rectF6.top) + fMin2;
        float f7 = f2 + rectF6.left;
        float f8 = this.f14647l.x;
        float fMax = f7 + Math.max(this.f14643h * f8, f8 + this.c0);
        RectF rectF7 = this.f14642g;
        rectF5.set(f4, f6, (fMax + rectF7.right) - fMin, (this.t.bottom + rectF7.bottom) - fMin2);
        RectF rectF8 = this.v;
        RectF rectF9 = this.t;
        rectF8.set(rectF9.left, 0.0f, (this.u.right - this.f14642g.right) - rectF9.width(), 0.0f);
        this.f14641f = Math.min(Math.min(this.u.width(), this.u.height()) / 2.0f, this.f14641f);
        Drawable drawable = this.f14637b;
        if (drawable != null) {
            RectF rectF10 = this.u;
            drawable.setBounds((int) rectF10.left, (int) rectF10.top, a(rectF10.right), a(this.u.bottom));
        }
        if (this.O != null) {
            RectF rectF11 = this.u;
            float fWidth = rectF11.left + ((((rectF11.width() - this.t.width()) - this.f14642g.right) - this.O.getWidth()) / 2.0f);
            float f9 = this.f14642g.left;
            float f10 = fWidth + (f9 < 0.0f ? f9 * (-0.5f) : 0.0f);
            if (!this.A && this.f0) {
                f10 += this.f14641f / 4.0f;
            }
            RectF rectF12 = this.u;
            float fHeight2 = rectF12.top + ((rectF12.height() - this.O.getHeight()) / 2.0f);
            this.w.set(f10, fHeight2, this.O.getWidth() + f10, this.O.getHeight() + fHeight2);
        }
        if (this.b0 != null) {
            RectF rectF13 = this.u;
            float fWidth2 = (rectF13.right - ((((rectF13.width() - this.t.width()) - this.f14642g.left) - this.b0.getWidth()) / 2.0f)) - this.b0.getWidth();
            float f11 = this.f14642g.right;
            float f12 = fWidth2 + (f11 < 0.0f ? 0.5f * f11 : 0.0f);
            if (!this.A && this.f0) {
                f12 -= this.f14641f / 4.0f;
            }
            RectF rectF14 = this.u;
            float fHeight3 = rectF14.top + ((rectF14.height() - this.b0.getHeight()) / 2.0f);
            this.x.set(f12, fHeight3, this.b0.getWidth() + f12, this.b0.getHeight() + fHeight3);
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
        if (this.z || (colorStateList2 = this.f14639d) == null) {
            setDrawableState(this.a);
        } else {
            this.f14648m = colorStateList2.getColorForState(getDrawableState(), this.f14648m);
        }
        int[] iArr = isChecked() ? o0 : n0;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.p = textColors.getColorForState(n0, defaultColor);
            this.q = textColors.getColorForState(o0, defaultColor);
        }
        if (!this.A && (colorStateList = this.f14638c) != null) {
            this.f14649n = colorStateList.getColorForState(getDrawableState(), this.f14649n);
            this.o = this.f14638c.getColorForState(iArr, this.f14649n);
            return;
        }
        Drawable drawable = this.f14637b;
        if ((drawable instanceof StateListDrawable) && this.f14645j) {
            drawable.setState(iArr);
            this.s = this.f14637b.getCurrent().mutate();
        } else {
            this.s = null;
        }
        setDrawableState(this.f14637b);
        Drawable drawable2 = this.f14637b;
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
        return this.f14644i;
    }

    public ColorStateList getBackColor() {
        return this.f14638c;
    }

    public Drawable getBackDrawable() {
        return this.f14637b;
    }

    public float getBackMeasureRatio() {
        return this.f14643h;
    }

    public float getBackRadius() {
        return this.f14641f;
    }

    public PointF getBackSizeF() {
        return new PointF(this.u.width(), this.u.height());
    }

    public final float getProcess() {
        return this.D;
    }

    public ColorStateList getThumbColor() {
        return this.f14639d;
    }

    public Drawable getThumbDrawable() {
        return this.a;
    }

    public float getThumbHeight() {
        return this.f14647l.y;
    }

    public RectF getThumbMargin() {
        return this.f14642g;
    }

    public float getThumbRadius() {
        return this.f14640e;
    }

    public PointF getThumbSizeF() {
        return this.f14647l;
    }

    public float getThumbWidth() {
        return this.f14647l.x;
    }

    public int getTintColor() {
        return this.f14646k;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012f  */
    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onDraw(Canvas canvas) {
        float f2;
        float process;
        super.onDraw(canvas);
        float process2 = 1.0f;
        if (this.A) {
            if (!this.f14645j || this.r == null || this.s == null) {
                this.f14637b.setAlpha(255);
                this.f14637b.draw(canvas);
            } else {
                int process3 = (int) ((isChecked() ? getProcess() : 1.0f - getProcess()) * 255.0f);
                this.r.setAlpha(process3);
                this.r.draw(canvas);
                this.s.setAlpha(255 - process3);
                this.s.draw(canvas);
            }
        } else if (this.f14645j) {
            int process4 = (int) ((isChecked() ? getProcess() : 1.0f - getProcess()) * 255.0f);
            this.y.setARGB((Color.alpha(this.f14649n) * process4) / 255, Color.red(this.f14649n), Color.green(this.f14649n), Color.blue(this.f14649n));
            RectF rectF = this.u;
            float f3 = this.f14641f;
            canvas.drawRoundRect(rectF, f3, f3, this.y);
            this.y.setARGB((Color.alpha(this.o) * (255 - process4)) / 255, Color.red(this.o), Color.green(this.o), Color.blue(this.o));
            RectF rectF2 = this.u;
            float f4 = this.f14641f;
            canvas.drawRoundRect(rectF2, f4, f4, this.y);
            this.y.setAlpha(255);
        } else {
            this.y.setColor(this.f14649n);
            RectF rectF3 = this.u;
            float f5 = this.f14641f;
            canvas.drawRoundRect(rectF3, f5, f5, this.y);
        }
        Layout layout = ((double) getProcess()) > 0.5d ? this.O : this.b0;
        RectF rectF4 = ((double) getProcess()) > 0.5d ? this.w : this.x;
        if (layout != null && rectF4 != null) {
            if (getProcess() >= 0.75d) {
                process2 = getProcess() * 4.0f;
                process = 3.0f;
            } else if (getProcess() < 0.25d) {
                process = getProcess() * 4.0f;
            } else {
                f2 = 0.0f;
                int i2 = (int) (f2 * 255.0f);
                int i3 = ((double) getProcess()) <= 0.5d ? this.p : this.q;
                layout.getPaint().setARGB((Color.alpha(i3) * i2) / 255, Color.red(i3), Color.green(i3), Color.blue(i3));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            f2 = process2 - process;
            int i22 = (int) (f2 * 255.0f);
            if (((double) getProcess()) <= 0.5d) {
            }
            layout.getPaint().setARGB((Color.alpha(i3) * i22) / 255, Color.red(i3), Color.green(i3), Color.blue(i3));
            canvas.save();
            canvas.translate(rectF4.left, rectF4.top);
            layout.draw(canvas);
            canvas.restore();
        }
        this.E.set(this.t);
        this.E.offset(this.D * this.v.width(), 0.0f);
        if (this.z) {
            Drawable drawable = this.a;
            RectF rectF5 = this.E;
            drawable.setBounds((int) rectF5.left, (int) rectF5.top, a(rectF5.right), a(this.E.bottom));
            this.a.draw(canvas);
        } else {
            this.y.setColor(this.f14648m);
            RectF rectF6 = this.E;
            float f6 = this.f14640e;
            canvas.drawRoundRect(rectF6, f6, f6, this.y);
        }
        if (this.B) {
            this.K.setColor(Color.parseColor("#AA0000"));
            canvas.drawRect(this.u, this.K);
            this.K.setColor(Color.parseColor("#0000FF"));
            canvas.drawRect(this.E, this.K);
            this.K.setColor(Color.parseColor("#00CC00"));
            canvas.drawRect(((double) getProcess()) > 0.5d ? this.w : this.x, this.K);
        }
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
        a(savedState.a, savedState.f14650b);
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.L;
        savedState.f14650b = this.M;
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

    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !isClickable() || !isFocusable()) {
            return false;
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX() - this.F;
        float y = motionEvent.getY() - this.G;
        if (action == 0) {
            f();
            this.F = motionEvent.getX();
            this.G = motionEvent.getY();
            this.H = this.F;
            setPressed(true);
        } else if (action == 1) {
            setPressed(false);
            boolean statusBasedOnPos = getStatusBasedOnPos();
            float eventTime = motionEvent.getEventTime() - motionEvent.getDownTime();
            int i2 = this.I;
            if (x < i2 && y < i2 && eventTime < this.J) {
                performClick();
            } else if (statusBasedOnPos != isChecked()) {
                playSoundEffect(0);
                setChecked(statusBasedOnPos);
            } else {
                a(statusBasedOnPos);
            }
        } else if (action == 2) {
            float x2 = motionEvent.getX();
            setProcess(getProcess() + ((x2 - this.H) / this.v.width()));
            this.H = x2;
        } else if (action == 3) {
        }
        return true;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void setAnimationDuration(long j2) {
        this.f14644i = j2;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.f14638c = colorStateList;
        if (this.f14638c != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i2) {
        setBackColor(ContextCompat.getColorStateList(getContext(), i2));
    }

    public void setBackDrawable(Drawable drawable) {
        this.f14637b = drawable;
        this.A = this.f14637b != null;
        g();
        refreshDrawableState();
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i2) {
        setBackDrawable(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setBackMeasureRatio(float f2) {
        this.f14643h = f2;
        requestLayout();
    }

    public void setBackRadius(float f2) {
        this.f14641f = f2;
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
        this.f14645j = z;
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
        this.f14639d = colorStateList;
        if (this.f14639d != null) {
            setThumbDrawable(null);
        }
    }

    public void setThumbColorRes(int i2) {
        setThumbColor(ContextCompat.getColorStateList(getContext(), i2));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.a = drawable;
        this.z = this.a != null;
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
        this.f14640e = f2;
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
        this.f14646k = i2;
        this.f14639d = d1.b(this.f14646k);
        this.f14638c = d1.a(this.f14646k);
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
        return this.f14645j;
    }

    private Layout a(CharSequence charSequence) {
        return new StaticLayout(charSequence, this.N, (int) Math.ceil(Layout.getDesiredWidth(charSequence, r2)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    private int a(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        float f2 = this.f14647l.y;
        RectF rectF = this.f14642g;
        int iA = a(Math.max(f2, rectF.top + f2 + rectF.right));
        float height = this.O != null ? r2.getHeight() : 0.0f;
        float height2 = this.b0 != null ? r4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.d0 = 0.0f;
        } else {
            this.d0 = Math.max(height, height2);
            iA = a(Math.max(iA, this.d0));
        }
        int iMax = Math.max(iA, getSuggestedMinimumHeight());
        int iMax2 = Math.max(iMax, getPaddingTop() + iMax + getPaddingBottom());
        if (mode == 1073741824) {
            return Math.max(iMax2, size);
        }
        return mode == Integer.MIN_VALUE ? Math.min(iMax2, size) : iMax2;
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
        this.C.setDuration(this.f14644i);
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
        this.f14642g.set(f2, f3, f4, f5);
        requestLayout();
    }

    public void a(float f2, float f3) {
        this.f14647l.set(f2, f3);
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
