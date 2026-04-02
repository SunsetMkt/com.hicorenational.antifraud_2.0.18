package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.b.d;
import com.scwang.smartrefresh.layout.b.g;
import com.scwang.smartrefresh.layout.b.h;
import com.scwang.smartrefresh.layout.b.i;
import com.scwang.smartrefresh.layout.b.j;
import com.scwang.smartrefresh.layout.c.b;
import com.scwang.smartrefresh.layout.c.c;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;

/* JADX INFO: loaded from: classes2.dex */
public class TwoLevelHeader extends InternalAbstract implements g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f5642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected float f5643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected float f5644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected float f5645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected float f5646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected boolean f5647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected boolean f5648j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f5649k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected int f5650l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected h f5651m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected i f5652n;
    protected d o;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f5653b = new int[c.values().length];

        static {
            try {
                f5653b[c.Translate.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5653b[c.Scale.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = new int[b.values().length];
            try {
                a[b.TwoLevelReleased.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.TwoLevel.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.TwoLevelFinish.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.PullDownToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public TwoLevelHeader(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public void a(@NonNull i iVar, int i2, int i3) {
        h hVar = this.f5651m;
        if (hVar == null) {
            return;
        }
        if (((i3 + i2) * 1.0f) / i2 != this.f5644f && this.f5650l == 0) {
            this.f5650l = i2;
            this.f5651m = null;
            iVar.c().d(this.f5644f);
            this.f5651m = hVar;
        }
        if (this.f5652n == null && hVar.getSpinnerStyle() == c.Translate && !isInEditMode()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) hVar.getView().getLayoutParams();
            marginLayoutParams.topMargin -= i2;
            hVar.getView().setLayoutParams(marginLayoutParams);
        }
        this.f5650l = i2;
        this.f5652n = iVar;
        iVar.b(this.f5649k);
        iVar.b(this, !this.f5648j);
        hVar.a(iVar, i2, i3);
    }

    public TwoLevelHeader b(float f2) {
        if (this.f5644f != f2) {
            this.f5644f = f2;
            i iVar = this.f5652n;
            if (iVar != null) {
                this.f5650l = 0;
                iVar.c().d(this.f5644f);
            }
        }
        return this;
    }

    public TwoLevelHeader c(float f2) {
        this.f5646h = f2;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract
    public boolean equals(Object obj) {
        h hVar = this.f5651m;
        return (hVar != null && hVar.equals(obj)) || super.equals(obj);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f5664b = c.MatchLayout;
        if (this.f5651m == null) {
            a(new ClassicsHeader(getContext()));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f5664b = c.FixedBehind;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            if (childAt instanceof g) {
                this.f5651m = (g) childAt;
                this.f5665c = (h) childAt;
                bringChildToFront(childAt);
                break;
            }
            i2++;
        }
        if (this.f5651m == null) {
            a(new ClassicsHeader(getContext()));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        h hVar = this.f5651m;
        if (hVar == null) {
            super.onMeasure(i2, i3);
        } else {
            if (View.MeasureSpec.getMode(i3) != Integer.MIN_VALUE) {
                super.onMeasure(i2, i3);
                return;
            }
            hVar.getView().measure(i2, i3);
            super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i2), hVar.getView().getMeasuredHeight());
        }
    }

    public TwoLevelHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TwoLevelHeader c(boolean z) {
        this.f5647i = z;
        return this;
    }

    public TwoLevelHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5643e = 0.0f;
        this.f5644f = 2.5f;
        this.f5645g = 1.9f;
        this.f5646h = 1.0f;
        this.f5647i = true;
        this.f5648j = true;
        this.f5649k = 1000;
        this.f5664b = c.FixedBehind;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TwoLevelHeader);
        this.f5644f = typedArrayObtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlMaxRage, this.f5644f);
        this.f5645g = typedArrayObtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlFloorRage, this.f5645g);
        this.f5646h = typedArrayObtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlRefreshRage, this.f5646h);
        this.f5649k = typedArrayObtainStyledAttributes.getInt(R.styleable.TwoLevelHeader_srlFloorDuration, this.f5649k);
        this.f5647i = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TwoLevelHeader_srlEnableTwoLevel, this.f5647i);
        this.f5648j = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TwoLevelHeader_srlEnablePullToCloseTwoLevel, this.f5648j);
        typedArrayObtainStyledAttributes.recycle();
    }

    public TwoLevelHeader b(boolean z) {
        i iVar = this.f5652n;
        this.f5648j = z;
        if (iVar != null) {
            iVar.b(this, !z);
        }
        return this;
    }

    public TwoLevelHeader b(int i2) {
        this.f5649k = i2;
        return this;
    }

    public TwoLevelHeader b() {
        i iVar = this.f5652n;
        if (iVar != null) {
            iVar.b();
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.d.f
    public void a(@NonNull j jVar, @NonNull b bVar, @NonNull b bVar2) {
        h hVar = this.f5651m;
        if (hVar != null) {
            hVar.a(jVar, bVar, bVar2);
            int i2 = a.a[bVar2.ordinal()];
            boolean z = true;
            if (i2 == 1) {
                if (hVar.getView() != this) {
                    hVar.getView().animate().alpha(0.0f).setDuration(this.f5649k / 2);
                }
                i iVar = this.f5652n;
                if (iVar != null) {
                    d dVar = this.o;
                    if (dVar != null && !dVar.a(jVar)) {
                        z = false;
                    }
                    iVar.a(z);
                    return;
                }
                return;
            }
            if (i2 != 2) {
                if (i2 == 3) {
                    if (hVar.getView() != this) {
                        hVar.getView().animate().alpha(1.0f).setDuration(this.f5649k / 2);
                    }
                } else if (i2 == 4 && hVar.getView().getAlpha() == 0.0f && hVar.getView() != this) {
                    hVar.getView().setAlpha(1.0f);
                }
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public void a(boolean z, float f2, int i2, int i3, int i4) {
        a(i2);
        h hVar = this.f5651m;
        i iVar = this.f5652n;
        if (hVar != null) {
            hVar.a(z, f2, i2, i3, i4);
        }
        if (z) {
            float f3 = this.f5643e;
            float f4 = this.f5645g;
            if (f3 < f4 && f2 >= f4 && this.f5647i) {
                iVar.a(b.ReleaseToTwoLevel);
            } else if (this.f5643e >= this.f5645g && f2 < this.f5646h) {
                iVar.a(b.PullDownToRefresh);
            } else {
                float f5 = this.f5643e;
                float f6 = this.f5645g;
                if (f5 >= f6 && f2 < f6) {
                    iVar.a(b.ReleaseToRefresh);
                }
            }
            this.f5643e = f2;
        }
    }

    protected void a(int i2) {
        h hVar = this.f5651m;
        if (this.f5642d == i2 || hVar == null) {
            return;
        }
        this.f5642d = i2;
        int i3 = a.f5653b[hVar.getSpinnerStyle().ordinal()];
        if (i3 == 1) {
            hVar.getView().setTranslationY(i2);
        } else {
            if (i3 != 2) {
                return;
            }
            View view = hVar.getView();
            view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getTop() + Math.max(0, i2));
        }
    }

    public TwoLevelHeader a(g gVar) {
        return a(gVar, -1, -2);
    }

    public TwoLevelHeader a(g gVar, int i2, int i3) {
        if (gVar != null) {
            h hVar = this.f5651m;
            if (hVar != null) {
                removeView(hVar.getView());
            }
            if (gVar.getSpinnerStyle() == c.FixedBehind) {
                addView(gVar.getView(), 0, new RelativeLayout.LayoutParams(i2, i3));
            } else {
                addView(gVar.getView(), i2, i3);
            }
            this.f5651m = gVar;
            this.f5665c = gVar;
        }
        return this;
    }

    public TwoLevelHeader a(float f2) {
        this.f5645g = f2;
        return this;
    }

    public TwoLevelHeader a(d dVar) {
        this.o = dVar;
        return this;
    }
}
