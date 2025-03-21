package p388ui.view;

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
import com.hicorenational.antifraud.C2113R;
import com.umeng.commonsdk.framework.UMModuleRegister;
import util.C7339z0;

/* loaded from: classes2.dex */
public class SwitchButton extends CompoundButton {

    /* renamed from: h0 */
    public static final float f24683h0 = 1.8f;

    /* renamed from: i0 */
    public static final int f24684i0 = 20;

    /* renamed from: j0 */
    public static final int f24685j0 = 2;

    /* renamed from: k0 */
    public static final int f24686k0 = 2;

    /* renamed from: l0 */
    public static final int f24687l0 = 250;

    /* renamed from: m0 */
    public static final int f24688m0 = 3309506;

    /* renamed from: n0 */
    private static int[] f24689n0 = {R.attr.state_checked, R.attr.state_enabled, R.attr.state_pressed};

    /* renamed from: o0 */
    private static int[] f24690o0 = {-16842912, R.attr.state_enabled, R.attr.state_pressed};

    /* renamed from: A */
    private boolean f24691A;

    /* renamed from: B */
    private boolean f24692B;

    /* renamed from: C */
    private ObjectAnimator f24693C;

    /* renamed from: D */
    private float f24694D;

    /* renamed from: E */
    private RectF f24695E;

    /* renamed from: F */
    private float f24696F;

    /* renamed from: G */
    private float f24697G;

    /* renamed from: H */
    private float f24698H;

    /* renamed from: I */
    private int f24699I;

    /* renamed from: J */
    private int f24700J;

    /* renamed from: K */
    private Paint f24701K;

    /* renamed from: L */
    private CharSequence f24702L;

    /* renamed from: M */
    private CharSequence f24703M;

    /* renamed from: N */
    private TextPaint f24704N;

    /* renamed from: O */
    private Layout f24705O;

    /* renamed from: a */
    private Drawable f24706a;

    /* renamed from: b */
    private Drawable f24707b;

    /* renamed from: b0 */
    private Layout f24708b0;

    /* renamed from: c */
    private ColorStateList f24709c;

    /* renamed from: c0 */
    private float f24710c0;

    /* renamed from: d */
    private ColorStateList f24711d;

    /* renamed from: d0 */
    private float f24712d0;

    /* renamed from: e */
    private float f24713e;

    /* renamed from: e0 */
    private float f24714e0;

    /* renamed from: f */
    private float f24715f;

    /* renamed from: f0 */
    private boolean f24716f0;

    /* renamed from: g */
    private RectF f24717g;

    /* renamed from: g0 */
    private CompoundButton.OnCheckedChangeListener f24718g0;

    /* renamed from: h */
    private float f24719h;

    /* renamed from: i */
    private long f24720i;

    /* renamed from: j */
    private boolean f24721j;

    /* renamed from: k */
    private int f24722k;

    /* renamed from: l */
    private PointF f24723l;

    /* renamed from: m */
    private int f24724m;

    /* renamed from: n */
    private int f24725n;

    /* renamed from: o */
    private int f24726o;

    /* renamed from: p */
    private int f24727p;

    /* renamed from: q */
    private int f24728q;

    /* renamed from: r */
    private Drawable f24729r;

    /* renamed from: s */
    private Drawable f24730s;

    /* renamed from: t */
    private RectF f24731t;

    /* renamed from: u */
    private RectF f24732u;

    /* renamed from: v */
    private RectF f24733v;

    /* renamed from: w */
    private RectF f24734w;

    /* renamed from: x */
    private RectF f24735x;

    /* renamed from: y */
    private Paint f24736y;

    /* renamed from: z */
    private boolean f24737z;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C7198a();

        /* renamed from: a */
        CharSequence f24738a;

        /* renamed from: b */
        CharSequence f24739b;

        /* renamed from: ui.view.SwitchButton$SavedState$a */
        static class C7198a implements Parcelable.Creator<SavedState> {
            C7198a() {
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
            TextUtils.writeToParcel(this.f24738a, parcel, i2);
            TextUtils.writeToParcel(this.f24739b, parcel, i2);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f24738a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f24739b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24692B = false;
        this.f24716f0 = true;
        m25849a(attributeSet);
    }

    /* renamed from: a */
    private void m25849a(AttributeSet attributeSet) {
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
        this.f24699I = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f24700J = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.f24736y = new Paint(1);
        this.f24701K = new Paint(1);
        this.f24701K.setStyle(Paint.Style.STROKE);
        this.f24701K.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.f24704N = getPaint();
        this.f24731t = new RectF();
        this.f24732u = new RectF();
        this.f24733v = new RectF();
        this.f24723l = new PointF();
        this.f24717g = new RectF();
        this.f24734w = new RectF();
        this.f24735x = new RectF();
        this.f24693C = ObjectAnimator.ofFloat(this, UMModuleRegister.PROCESS, 0.0f, 0.0f).setDuration(250L);
        this.f24693C.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f24695E = new RectF();
        float f12 = getResources().getDisplayMetrics().density;
        float f13 = f12 * 2.0f;
        float f14 = f12 * 20.0f;
        float f15 = f14 / 2.0f;
        TypedArray obtainStyledAttributes2 = attributeSet == null ? null : getContext().obtainStyledAttributes(attributeSet, C2113R.styleable.SwitchButton);
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
        this.f24702L = str;
        this.f24703M = str2;
        this.f24714e0 = f13;
        this.f24716f0 = z;
        this.f24706a = drawable;
        this.f24711d = colorStateList2;
        this.f24737z = this.f24706a != null;
        this.f24722k = i2;
        if (this.f24722k == 0) {
            TypedValue typedValue = new TypedValue();
            z3 = true;
            if (getContext().getTheme().resolveAttribute(C2113R.attr.colorAccent, typedValue, true)) {
                this.f24722k = typedValue.data;
            } else {
                this.f24722k = f24688m0;
            }
        } else {
            z3 = true;
        }
        if (!this.f24737z && this.f24711d == null) {
            this.f24711d = C7339z0.m26803b(this.f24722k);
            this.f24724m = this.f24711d.getDefaultColor();
        }
        if (this.f24737z) {
            f3 = Math.max(f3, this.f24706a.getMinimumWidth());
            f2 = Math.max(f2, this.f24706a.getMinimumHeight());
        }
        this.f24723l.set(f3, f2);
        this.f24707b = drawable2;
        this.f24709c = colorStateList;
        if (this.f24707b == null) {
            z3 = false;
        }
        this.f24691A = z3;
        if (!this.f24691A && this.f24709c == null) {
            this.f24709c = C7339z0.m26802a(this.f24722k);
            this.f24725n = this.f24709c.getDefaultColor();
            this.f24726o = this.f24709c.getColorForState(f24689n0, this.f24725n);
        }
        this.f24717g.set(f9, f18, f11, f17);
        float f19 = f10;
        if (this.f24717g.width() >= 0.0f) {
            f19 = Math.max(f19, 1.0f);
        }
        this.f24719h = f19;
        this.f24713e = f4;
        this.f24715f = f5;
        this.f24720i = i3;
        this.f24721j = z2;
        this.f24693C.setDuration(this.f24720i);
        if (isChecked()) {
            setProcess(1.0f);
        }
    }

    /* renamed from: b */
    private int m25850b(int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int m25846a = m25846a(this.f24723l.x * this.f24719h);
        if (this.f24691A) {
            m25846a = Math.max(m25846a, this.f24707b.getMinimumWidth());
        }
        float width = this.f24705O != null ? r2.getWidth() : 0.0f;
        float width2 = this.f24708b0 != null ? r4.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.f24710c0 = 0.0f;
        } else {
            this.f24710c0 = Math.max(width, width2) + (this.f24714e0 * 2.0f);
            float f2 = m25846a;
            float f3 = f2 - this.f24723l.x;
            float f4 = this.f24710c0;
            if (f3 < f4) {
                m25846a = (int) (f2 + (f4 - f3));
            }
        }
        RectF rectF = this.f24717g;
        int max = Math.max(m25846a, m25846a(m25846a + rectF.left + rectF.right));
        int max2 = Math.max(Math.max(max, getPaddingLeft() + max + getPaddingRight()), getSuggestedMinimumWidth());
        return mode == 1073741824 ? Math.max(max2, size) : mode == Integer.MIN_VALUE ? Math.min(max2, size) : max2;
    }

    /* renamed from: f */
    private void m25851f() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    /* renamed from: g */
    private void m25852g() {
        float paddingTop = getPaddingTop() + Math.max(0.0f, this.f24717g.top);
        float paddingLeft = getPaddingLeft() + Math.max(0.0f, this.f24717g.left);
        if (this.f24705O != null && this.f24708b0 != null) {
            RectF rectF = this.f24717g;
            if (rectF.top + rectF.bottom > 0.0f) {
                float measuredHeight = ((getMeasuredHeight() - getPaddingBottom()) - getPaddingTop()) - this.f24723l.y;
                RectF rectF2 = this.f24717g;
                paddingTop += ((measuredHeight - rectF2.top) - rectF2.bottom) / 2.0f;
            }
        }
        if (this.f24737z) {
            PointF pointF = this.f24723l;
            pointF.x = Math.max(pointF.x, this.f24706a.getMinimumWidth());
            PointF pointF2 = this.f24723l;
            pointF2.y = Math.max(pointF2.y, this.f24706a.getMinimumHeight());
        }
        RectF rectF3 = this.f24731t;
        PointF pointF3 = this.f24723l;
        rectF3.set(paddingLeft, paddingTop, pointF3.x + paddingLeft, pointF3.y + paddingTop);
        float f2 = this.f24731t.left - this.f24717g.left;
        float f3 = this.f24723l.x;
        float min = Math.min(0.0f, ((Math.max(this.f24719h * f3, f3 + this.f24710c0) - this.f24731t.width()) - this.f24710c0) / 2.0f);
        float height = this.f24731t.height();
        RectF rectF4 = this.f24717g;
        float min2 = Math.min(0.0f, (((height + rectF4.top) + rectF4.bottom) - this.f24712d0) / 2.0f);
        RectF rectF5 = this.f24732u;
        float f4 = f2 + min;
        float f5 = this.f24731t.top;
        RectF rectF6 = this.f24717g;
        float f6 = (f5 - rectF6.top) + min2;
        float f7 = f2 + rectF6.left;
        float f8 = this.f24723l.x;
        float max = f7 + Math.max(this.f24719h * f8, f8 + this.f24710c0);
        RectF rectF7 = this.f24717g;
        rectF5.set(f4, f6, (max + rectF7.right) - min, (this.f24731t.bottom + rectF7.bottom) - min2);
        RectF rectF8 = this.f24733v;
        RectF rectF9 = this.f24731t;
        rectF8.set(rectF9.left, 0.0f, (this.f24732u.right - this.f24717g.right) - rectF9.width(), 0.0f);
        this.f24715f = Math.min(Math.min(this.f24732u.width(), this.f24732u.height()) / 2.0f, this.f24715f);
        Drawable drawable = this.f24707b;
        if (drawable != null) {
            RectF rectF10 = this.f24732u;
            drawable.setBounds((int) rectF10.left, (int) rectF10.top, m25846a(rectF10.right), m25846a(this.f24732u.bottom));
        }
        if (this.f24705O != null) {
            RectF rectF11 = this.f24732u;
            float width = rectF11.left + ((((rectF11.width() - this.f24731t.width()) - this.f24717g.right) - this.f24705O.getWidth()) / 2.0f);
            float f9 = this.f24717g.left;
            float f10 = width + (f9 < 0.0f ? f9 * (-0.5f) : 0.0f);
            if (!this.f24691A && this.f24716f0) {
                f10 += this.f24715f / 4.0f;
            }
            RectF rectF12 = this.f24732u;
            float height2 = rectF12.top + ((rectF12.height() - this.f24705O.getHeight()) / 2.0f);
            this.f24734w.set(f10, height2, this.f24705O.getWidth() + f10, this.f24705O.getHeight() + height2);
        }
        if (this.f24708b0 != null) {
            RectF rectF13 = this.f24732u;
            float width2 = (rectF13.right - ((((rectF13.width() - this.f24731t.width()) - this.f24717g.left) - this.f24708b0.getWidth()) / 2.0f)) - this.f24708b0.getWidth();
            float f11 = this.f24717g.right;
            float f12 = width2 + (f11 < 0.0f ? 0.5f * f11 : 0.0f);
            if (!this.f24691A && this.f24716f0) {
                f12 -= this.f24715f / 4.0f;
            }
            RectF rectF14 = this.f24732u;
            float height3 = rectF14.top + ((rectF14.height() - this.f24708b0.getHeight()) / 2.0f);
            this.f24735x.set(f12, height3, this.f24708b0.getWidth() + f12, this.f24708b0.getHeight() + height3);
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

    /* renamed from: c */
    public void m25859c() {
        setCheckedImmediately(!isChecked());
    }

    /* renamed from: d */
    public void m25860d() {
        if (this.f24718g0 == null) {
            m25859c();
            return;
        }
        super.setOnCheckedChangeListener(null);
        m25859c();
        setOnCheckedChangeListener(this.f24718g0);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (this.f24737z || (colorStateList2 = this.f24711d) == null) {
            setDrawableState(this.f24706a);
        } else {
            this.f24724m = colorStateList2.getColorForState(getDrawableState(), this.f24724m);
        }
        int[] iArr = isChecked() ? f24690o0 : f24689n0;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.f24727p = textColors.getColorForState(f24689n0, defaultColor);
            this.f24728q = textColors.getColorForState(f24690o0, defaultColor);
        }
        if (!this.f24691A && (colorStateList = this.f24709c) != null) {
            this.f24725n = colorStateList.getColorForState(getDrawableState(), this.f24725n);
            this.f24726o = this.f24709c.getColorForState(iArr, this.f24725n);
            return;
        }
        Drawable drawable = this.f24707b;
        if ((drawable instanceof StateListDrawable) && this.f24721j) {
            drawable.setState(iArr);
            this.f24730s = this.f24707b.getCurrent().mutate();
        } else {
            this.f24730s = null;
        }
        setDrawableState(this.f24707b);
        Drawable drawable2 = this.f24707b;
        if (drawable2 != null) {
            this.f24729r = drawable2.getCurrent().mutate();
        }
    }

    /* renamed from: e */
    public void m25861e() {
        if (this.f24718g0 == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        setOnCheckedChangeListener(this.f24718g0);
    }

    public long getAnimationDuration() {
        return this.f24720i;
    }

    public ColorStateList getBackColor() {
        return this.f24709c;
    }

    public Drawable getBackDrawable() {
        return this.f24707b;
    }

    public float getBackMeasureRatio() {
        return this.f24719h;
    }

    public float getBackRadius() {
        return this.f24715f;
    }

    public PointF getBackSizeF() {
        return new PointF(this.f24732u.width(), this.f24732u.height());
    }

    public final float getProcess() {
        return this.f24694D;
    }

    public ColorStateList getThumbColor() {
        return this.f24711d;
    }

    public Drawable getThumbDrawable() {
        return this.f24706a;
    }

    public float getThumbHeight() {
        return this.f24723l.y;
    }

    public RectF getThumbMargin() {
        return this.f24717g;
    }

    public float getThumbRadius() {
        return this.f24713e;
    }

    public PointF getThumbSizeF() {
        return this.f24723l;
    }

    public float getThumbWidth() {
        return this.f24723l.x;
    }

    public int getTintColor() {
        return this.f24722k;
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
        throw new UnsupportedOperationException("Method not decompiled: p388ui.view.SwitchButton.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        CharSequence charSequence;
        CharSequence charSequence2;
        if (this.f24705O == null && (charSequence2 = this.f24702L) != null) {
            this.f24705O = m25848a(charSequence2);
        }
        if (this.f24708b0 == null && (charSequence = this.f24703M) != null) {
            this.f24708b0 = m25848a(charSequence);
        }
        setMeasuredDimension(m25850b(i2), m25847a(i3));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        m25855a(savedState.f24738a, savedState.f24739b);
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f24738a = this.f24702L;
        savedState.f24739b = this.f24703M;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        m25852g();
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
            float r3 = r9.f24696F
            float r2 = r2 - r3
            float r3 = r10.getY()
            float r4 = r9.f24697G
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
            float r1 = r9.f24698H
            float r1 = r10 - r1
            android.graphics.RectF r2 = r9.f24733v
            float r2 = r2.width()
            float r1 = r1 / r2
            float r0 = r0 + r1
            r9.setProcess(r0)
            r9.f24698H = r10
            goto L9c
        L4d:
            r9.setPressed(r1)
            boolean r0 = r9.getStatusBasedOnPos()
            long r5 = r10.getEventTime()
            long r7 = r10.getDownTime()
            long r5 = r5 - r7
            float r10 = (float) r5
            int r5 = r9.f24699I
            float r6 = (float) r5
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 >= 0) goto L75
            float r2 = (float) r5
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 >= 0) goto L75
            int r2 = r9.f24700J
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
            r9.m25856a(r0)
            goto L9c
        L86:
            r9.m25851f()
            float r0 = r10.getX()
            r9.f24696F = r0
            float r10 = r10.getY()
            r9.f24697G = r10
            float r10 = r9.f24696F
            r9.f24698H = r10
            r9.setPressed(r4)
        L9c:
            return r4
        L9d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p388ui.view.SwitchButton.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void setAnimationDuration(long j2) {
        this.f24720i = j2;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.f24709c = colorStateList;
        if (this.f24709c != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i2) {
        setBackColor(ContextCompat.getColorStateList(getContext(), i2));
    }

    public void setBackDrawable(Drawable drawable) {
        this.f24707b = drawable;
        this.f24691A = this.f24707b != null;
        m25852g();
        refreshDrawableState();
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i2) {
        setBackDrawable(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setBackMeasureRatio(float f2) {
        this.f24719h = f2;
        requestLayout();
    }

    public void setBackRadius(float f2) {
        this.f24715f = f2;
        if (this.f24691A) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            m25856a(z);
        }
        super.setChecked(z);
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.f24693C;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f24693C.cancel();
        }
        setProcess(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.f24718g0 == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        setOnCheckedChangeListener(this.f24718g0);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.f24718g0 == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        setOnCheckedChangeListener(this.f24718g0);
    }

    public void setDrawDebugRect(boolean z) {
        this.f24692B = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.f24721j = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.f24718g0 = onCheckedChangeListener;
    }

    public final void setProcess(float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.f24694D = f2;
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.f24711d = colorStateList;
        if (this.f24711d != null) {
            setThumbDrawable(null);
        }
    }

    public void setThumbColorRes(int i2) {
        setThumbColor(ContextCompat.getColorStateList(getContext(), i2));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.f24706a = drawable;
        this.f24737z = this.f24706a != null;
        m25852g();
        refreshDrawableState();
        requestLayout();
        invalidate();
    }

    public void setThumbDrawableRes(int i2) {
        setThumbDrawable(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setThumbMargin(RectF rectF) {
        if (rectF == null) {
            m25854a(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            m25854a(rectF.left, rectF.top, rectF.right, rectF.bottom);
        }
    }

    public void setThumbRadius(float f2) {
        this.f24713e = f2;
        if (this.f24737z) {
            return;
        }
        invalidate();
    }

    public void setThumbSize(PointF pointF) {
        if (pointF != null) {
            m25853a(pointF.x, pointF.y);
        } else {
            float f2 = getResources().getDisplayMetrics().density * 20.0f;
            m25853a(f2, f2);
        }
    }

    public void setTintColor(int i2) {
        this.f24722k = i2;
        this.f24711d = C7339z0.m26803b(this.f24722k);
        this.f24709c = C7339z0.m26802a(this.f24722k);
        this.f24691A = false;
        this.f24737z = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24692B = false;
        this.f24716f0 = true;
        m25849a(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.f24692B = false;
        this.f24716f0 = true;
        m25849a((AttributeSet) null);
    }

    /* renamed from: b */
    public boolean m25858b() {
        return this.f24721j;
    }

    /* renamed from: a */
    private Layout m25848a(CharSequence charSequence) {
        return new StaticLayout(charSequence, this.f24704N, (int) Math.ceil(Layout.getDesiredWidth(charSequence, r2)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    /* renamed from: a */
    private int m25847a(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        float f2 = this.f24723l.y;
        RectF rectF = this.f24717g;
        int m25846a = m25846a(Math.max(f2, rectF.top + f2 + rectF.right));
        float height = this.f24705O != null ? r2.getHeight() : 0.0f;
        float height2 = this.f24708b0 != null ? r4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.f24712d0 = 0.0f;
        } else {
            this.f24712d0 = Math.max(height, height2);
            m25846a = m25846a(Math.max(m25846a, this.f24712d0));
        }
        int max = Math.max(m25846a, getSuggestedMinimumHeight());
        int max2 = Math.max(max, getPaddingTop() + max + getPaddingBottom());
        if (mode == 1073741824) {
            return Math.max(max2, size);
        }
        return mode == Integer.MIN_VALUE ? Math.min(max2, size) : max2;
    }

    /* renamed from: a */
    private int m25846a(double d2) {
        return (int) Math.ceil(d2);
    }

    /* renamed from: a */
    protected void m25856a(boolean z) {
        ObjectAnimator objectAnimator = this.f24693C;
        if (objectAnimator == null) {
            return;
        }
        if (objectAnimator.isRunning()) {
            this.f24693C.cancel();
        }
        this.f24693C.setDuration(this.f24720i);
        if (z) {
            this.f24693C.setFloatValues(this.f24694D, 1.0f);
        } else {
            this.f24693C.setFloatValues(this.f24694D, 0.0f);
        }
        this.f24693C.start();
    }

    /* renamed from: a */
    public boolean m25857a() {
        return this.f24692B;
    }

    /* renamed from: a */
    public void m25854a(float f2, float f3, float f4, float f5) {
        this.f24717g.set(f2, f3, f4, f5);
        requestLayout();
    }

    /* renamed from: a */
    public void m25853a(float f2, float f3) {
        this.f24723l.set(f2, f3);
        m25852g();
        requestLayout();
    }

    /* renamed from: a */
    public void m25855a(CharSequence charSequence, CharSequence charSequence2) {
        this.f24702L = charSequence;
        this.f24703M = charSequence2;
        this.f24705O = null;
        this.f24708b0 = null;
        requestLayout();
        invalidate();
    }
}
