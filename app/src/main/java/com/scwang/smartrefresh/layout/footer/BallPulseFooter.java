package com.scwang.smartrefresh.layout.footer;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import com.scwang.smartrefresh.layout.C2851R;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2872f;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2876j;
import com.scwang.smartrefresh.layout.p190c.EnumC2880c;
import com.scwang.smartrefresh.layout.p192e.C2889b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class BallPulseFooter extends InternalAbstract implements InterfaceC2872f {

    /* renamed from: n */
    public static final int f9121n = 50;

    /* renamed from: d */
    protected boolean f9122d;

    /* renamed from: e */
    protected boolean f9123e;

    /* renamed from: f */
    protected Paint f9124f;

    /* renamed from: g */
    protected int f9125g;

    /* renamed from: h */
    protected int f9126h;

    /* renamed from: i */
    protected float f9127i;

    /* renamed from: j */
    protected float[] f9128j;

    /* renamed from: k */
    protected boolean f9129k;

    /* renamed from: l */
    protected ArrayList<ValueAnimator> f9130l;

    /* renamed from: m */
    protected Map<ValueAnimator, ValueAnimator.AnimatorUpdateListener> f9131m;

    /* renamed from: com.scwang.smartrefresh.layout.footer.BallPulseFooter$a */
    class C2894a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ int f9132a;

        /* renamed from: b */
        final /* synthetic */ View f9133b;

        C2894a(int i2, View view) {
            this.f9132a = i2;
            this.f9133b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BallPulseFooter.this.f9128j[this.f9132a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f9133b.postInvalidate();
        }
    }

    public BallPulseFooter(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    /* renamed from: a */
    public void mo8716a(@NonNull InterfaceC2876j interfaceC2876j, int i2, int i3) {
        if (this.f9129k) {
            return;
        }
        for (int i4 = 0; i4 < this.f9130l.size(); i4++) {
            ValueAnimator valueAnimator = this.f9130l.get(i4);
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f9131m.get(valueAnimator);
            if (animatorUpdateListener != null) {
                valueAnimator.addUpdateListener(animatorUpdateListener);
            }
            valueAnimator.start();
        }
        this.f9129k = true;
        this.f9124f.setColor(this.f9126h);
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2872f
    /* renamed from: a */
    public boolean mo8712a(boolean z) {
        return false;
    }

    /* renamed from: b */
    public BallPulseFooter m8754b(@ColorInt int i2) {
        this.f9125g = i2;
        this.f9122d = true;
        if (!this.f9129k) {
            this.f9124f.setColor(i2);
        }
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float min = Math.min(width, height);
        float f2 = this.f9127i;
        float f3 = (min - (f2 * 2.0f)) / 6.0f;
        float f4 = 2.0f * f3;
        float f5 = (width / 2) - (f2 + f4);
        float f6 = height / 2;
        for (int i2 = 0; i2 < 3; i2++) {
            canvas.save();
            float f7 = i2;
            canvas.translate((f4 * f7) + f5 + (this.f9127i * f7), f6);
            float[] fArr = this.f9128j;
            canvas.scale(fArr[i2], fArr[i2]);
            canvas.drawCircle(0.0f, 0.0f, f3, this.f9124f);
            canvas.restore();
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f9130l != null) {
            for (int i2 = 0; i2 < this.f9130l.size(); i2++) {
                this.f9130l.get(i2).cancel();
                this.f9130l.get(i2).removeAllListeners();
                this.f9130l.get(i2).removeAllUpdateListeners();
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (!this.f9123e && iArr.length > 1) {
            m8752a(iArr[0]);
            this.f9123e = false;
        }
        if (this.f9122d) {
            return;
        }
        if (iArr.length > 1) {
            m8754b(iArr[1]);
        } else if (iArr.length > 0) {
            m8754b(ColorUtils.compositeColors(-1711276033, iArr[0]));
        }
        this.f9122d = false;
    }

    public BallPulseFooter(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BallPulseFooter(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        this.f9125g = -1118482;
        this.f9126h = -1615546;
        this.f9128j = new float[]{1.0f, 1.0f, 1.0f};
        this.f9129k = false;
        this.f9131m = new HashMap();
        setMinimumHeight(C2889b.m8735b(60.0f));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2851R.styleable.BallPulseFooter);
        this.f9124f = new Paint();
        this.f9124f.setColor(-1);
        this.f9124f.setStyle(Paint.Style.FILL);
        this.f9124f.setAntiAlias(true);
        this.f9233b = EnumC2880c.Translate;
        this.f9233b = EnumC2880c.values()[obtainStyledAttributes.getInt(C2851R.styleable.BallPulseFooter_srlClassicsSpinnerStyle, this.f9233b.ordinal())];
        if (obtainStyledAttributes.hasValue(C2851R.styleable.BallPulseFooter_srlNormalColor)) {
            m8754b(obtainStyledAttributes.getColor(C2851R.styleable.BallPulseFooter_srlNormalColor, 0));
        }
        if (obtainStyledAttributes.hasValue(C2851R.styleable.BallPulseFooter_srlAnimatingColor)) {
            m8752a(obtainStyledAttributes.getColor(C2851R.styleable.BallPulseFooter_srlAnimatingColor, 0));
        }
        obtainStyledAttributes.recycle();
        this.f9127i = C2889b.m8735b(4.0f);
        this.f9130l = new ArrayList<>();
        int[] iArr = {120, 240, 360};
        for (int i3 = 0; i3 < 3; i3++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.3f, 1.0f);
            ofFloat.setDuration(750L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setTarget(Integer.valueOf(i3));
            ofFloat.setStartDelay(iArr[i3]);
            this.f9131m.put(ofFloat, new C2894a(i3, this));
            this.f9130l.add(ofFloat);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
    /* renamed from: a */
    public int mo8713a(@NonNull InterfaceC2876j interfaceC2876j, boolean z) {
        ArrayList<ValueAnimator> arrayList = this.f9130l;
        if (arrayList != null && this.f9129k) {
            this.f9129k = false;
            this.f9128j = new float[]{1.0f, 1.0f, 1.0f};
            Iterator<ValueAnimator> it = arrayList.iterator();
            while (it.hasNext()) {
                ValueAnimator next = it.next();
                if (next != null) {
                    next.removeAllUpdateListeners();
                    next.end();
                }
            }
        }
        this.f9124f.setColor(this.f9125g);
        return 0;
    }

    /* renamed from: a */
    public BallPulseFooter m8753a(EnumC2880c enumC2880c) {
        this.f9233b = enumC2880c;
        return this;
    }

    /* renamed from: a */
    public BallPulseFooter m8752a(@ColorInt int i2) {
        this.f9126h = i2;
        this.f9123e = true;
        if (this.f9129k) {
            this.f9124f.setColor(i2);
        }
        return this;
    }
}
