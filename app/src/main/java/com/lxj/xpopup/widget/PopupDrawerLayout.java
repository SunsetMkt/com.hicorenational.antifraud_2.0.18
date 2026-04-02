package com.lxj.xpopup.widget;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.viewpager.widget.ViewPager;
import com.lxj.xpopup.c.e;

/* JADX INFO: loaded from: classes2.dex */
public class PopupDrawerLayout extends FrameLayout {
    com.lxj.xpopup.d.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ViewDragHelper f5543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    View f5544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    View f5545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.lxj.xpopup.d.d f5546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    e f5547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ArgbEvaluator f5548g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f5549h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5550i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float f5551j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5552k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    float f5553l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f5554m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f5555n;
    float o;
    float p;
    boolean q;
    boolean r;
    ViewDragHelper.Callback s;
    Paint t;
    Rect u;
    private d v;

    class a extends ViewDragHelper.Callback {
        a() {
        }

        private void a(int i2) {
            PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
            com.lxj.xpopup.d.d dVar = popupDrawerLayout.f5546e;
            if (dVar == com.lxj.xpopup.d.d.Left) {
                popupDrawerLayout.f5551j = ((popupDrawerLayout.f5545d.getMeasuredWidth() + i2) * 1.0f) / PopupDrawerLayout.this.f5545d.getMeasuredWidth();
                if (i2 == (-PopupDrawerLayout.this.f5545d.getMeasuredWidth()) && PopupDrawerLayout.this.v != null) {
                    PopupDrawerLayout popupDrawerLayout2 = PopupDrawerLayout.this;
                    com.lxj.xpopup.d.b bVar = popupDrawerLayout2.a;
                    com.lxj.xpopup.d.b bVar2 = com.lxj.xpopup.d.b.Close;
                    if (bVar != bVar2) {
                        popupDrawerLayout2.a = bVar2;
                        popupDrawerLayout2.v.onClose();
                    }
                }
            } else if (dVar == com.lxj.xpopup.d.d.Right) {
                popupDrawerLayout.f5551j = ((popupDrawerLayout.getMeasuredWidth() - i2) * 1.0f) / PopupDrawerLayout.this.f5545d.getMeasuredWidth();
                if (i2 == PopupDrawerLayout.this.getMeasuredWidth() && PopupDrawerLayout.this.v != null) {
                    PopupDrawerLayout popupDrawerLayout3 = PopupDrawerLayout.this;
                    com.lxj.xpopup.d.b bVar3 = popupDrawerLayout3.a;
                    com.lxj.xpopup.d.b bVar4 = com.lxj.xpopup.d.b.Close;
                    if (bVar3 != bVar4) {
                        popupDrawerLayout3.a = bVar4;
                        popupDrawerLayout3.v.onClose();
                    }
                }
            }
            PopupDrawerLayout popupDrawerLayout4 = PopupDrawerLayout.this;
            if (popupDrawerLayout4.f5552k) {
                popupDrawerLayout4.setBackgroundColor(popupDrawerLayout4.f5547f.a(popupDrawerLayout4.f5551j));
            }
            if (PopupDrawerLayout.this.v != null) {
                PopupDrawerLayout.this.v.a(PopupDrawerLayout.this.f5551j);
                PopupDrawerLayout popupDrawerLayout5 = PopupDrawerLayout.this;
                if (popupDrawerLayout5.f5551j == 1.0f) {
                    com.lxj.xpopup.d.b bVar5 = popupDrawerLayout5.a;
                    com.lxj.xpopup.d.b bVar6 = com.lxj.xpopup.d.b.Open;
                    if (bVar5 != bVar6) {
                        popupDrawerLayout5.a = bVar6;
                        popupDrawerLayout5.v.a();
                    }
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@NonNull View view, int i2, int i3) {
            PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
            return view == popupDrawerLayout.f5544c ? i2 : popupDrawerLayout.a(i2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(@NonNull View view) {
            return 1;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i2, int i3, int i4, int i5) {
            super.onViewPositionChanged(view, i2, i3, i4, i5);
            View view2 = PopupDrawerLayout.this.f5544c;
            if (view != view2) {
                a(i2);
                return;
            }
            view2.layout(0, 0, view2.getMeasuredWidth(), PopupDrawerLayout.this.f5544c.getMeasuredHeight());
            PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
            int iA = popupDrawerLayout.a(popupDrawerLayout.f5545d.getLeft() + i4);
            View view3 = PopupDrawerLayout.this.f5545d;
            view3.layout(iA, view3.getTop(), PopupDrawerLayout.this.f5545d.getMeasuredWidth() + iA, PopupDrawerLayout.this.f5545d.getBottom());
            a(iA);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@NonNull View view, float f2, float f3) {
            int measuredWidth;
            int measuredWidth2;
            super.onViewReleased(view, f2, f3);
            PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
            if (view == popupDrawerLayout.f5544c && f2 == 0.0f) {
                popupDrawerLayout.a();
                return;
            }
            PopupDrawerLayout popupDrawerLayout2 = PopupDrawerLayout.this;
            if (view == popupDrawerLayout2.f5545d && popupDrawerLayout2.q && !popupDrawerLayout2.r && f2 < -500.0f) {
                popupDrawerLayout2.a();
                return;
            }
            PopupDrawerLayout popupDrawerLayout3 = PopupDrawerLayout.this;
            if (popupDrawerLayout3.f5546e == com.lxj.xpopup.d.d.Left) {
                if (f2 < -1000.0f) {
                    measuredWidth2 = popupDrawerLayout3.f5545d.getMeasuredWidth();
                } else {
                    if (PopupDrawerLayout.this.f5545d.getLeft() < (-popupDrawerLayout3.f5545d.getMeasuredWidth()) / 2) {
                        measuredWidth2 = PopupDrawerLayout.this.f5545d.getMeasuredWidth();
                    } else {
                        measuredWidth = 0;
                    }
                }
                measuredWidth = -measuredWidth2;
            } else if (f2 > 1000.0f) {
                measuredWidth = popupDrawerLayout3.getMeasuredWidth();
            } else {
                measuredWidth = view.getLeft() < popupDrawerLayout3.getMeasuredWidth() - (PopupDrawerLayout.this.f5545d.getMeasuredWidth() / 2) ? PopupDrawerLayout.this.getMeasuredWidth() - PopupDrawerLayout.this.f5545d.getMeasuredWidth() : PopupDrawerLayout.this.getMeasuredWidth();
            }
            PopupDrawerLayout popupDrawerLayout4 = PopupDrawerLayout.this;
            popupDrawerLayout4.f5543b.smoothSlideViewTo(popupDrawerLayout4.f5545d, measuredWidth, view.getTop());
            ViewCompat.postInvalidateOnAnimation(PopupDrawerLayout.this);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(@NonNull View view, int i2) {
            return !PopupDrawerLayout.this.f5543b.continueSettling(true);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
            ViewDragHelper viewDragHelper = popupDrawerLayout.f5543b;
            View view = popupDrawerLayout.f5545d;
            viewDragHelper.smoothSlideViewTo(view, popupDrawerLayout.f5546e == com.lxj.xpopup.d.d.Left ? 0 : view.getLeft() - PopupDrawerLayout.this.f5545d.getMeasuredWidth(), 0);
            ViewCompat.postInvalidateOnAnimation(PopupDrawerLayout.this);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
            ViewDragHelper viewDragHelper = popupDrawerLayout.f5543b;
            View view = popupDrawerLayout.f5545d;
            viewDragHelper.smoothSlideViewTo(view, popupDrawerLayout.f5546e == com.lxj.xpopup.d.d.Left ? -view.getMeasuredWidth() : popupDrawerLayout.getMeasuredWidth(), 0);
            ViewCompat.postInvalidateOnAnimation(PopupDrawerLayout.this);
        }
    }

    public interface d {
        void a();

        void a(float f2);

        void onClose();
    }

    public PopupDrawerLayout(Context context) {
        this(context, null);
    }

    public void b() {
        post(new b());
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f5543b.continueSettling(false)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f5550i) {
            if (this.t == null) {
                this.t = new Paint();
                this.u = new Rect(0, 0, getMeasuredHeight(), com.lxj.xpopup.f.c.c());
            }
            this.t.setColor(((Integer) this.f5548g.evaluate(this.f5551j, Integer.valueOf(this.f5549h), Integer.valueOf(com.lxj.xpopup.b.f5398c))).intValue());
            canvas.drawRect(this.u, this.t);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f5553l = getTranslationY();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a = null;
        this.f5551j = 0.0f;
        setTranslationY(this.f5553l);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f5544c = getChildAt(0);
        this.f5545d = getChildAt(1);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.q = motionEvent.getX() < this.o;
        this.o = motionEvent.getX();
        this.p = motionEvent.getY();
        this.r = a(this, motionEvent.getX(), motionEvent.getY(), 1);
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.o = 0.0f;
            this.p = 0.0f;
        }
        this.f5555n = this.f5543b.shouldInterceptTouchEvent(motionEvent);
        return (!this.q || this.r) ? !a(this, motionEvent.getX(), motionEvent.getY()) ? this.f5555n : super.onInterceptTouchEvent(motionEvent) : this.f5555n;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View view = this.f5544c;
        view.layout(0, 0, view.getMeasuredWidth(), this.f5544c.getMeasuredHeight());
        if (this.f5554m) {
            View view2 = this.f5545d;
            view2.layout(view2.getLeft(), this.f5545d.getTop(), this.f5545d.getRight(), this.f5545d.getBottom());
            return;
        }
        if (this.f5546e == com.lxj.xpopup.d.d.Left) {
            View view3 = this.f5545d;
            view3.layout(-view3.getMeasuredWidth(), 0, 0, getMeasuredHeight());
        } else {
            this.f5545d.layout(getMeasuredWidth(), 0, getMeasuredWidth() + this.f5545d.getMeasuredWidth(), getMeasuredHeight());
        }
        this.f5554m = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f5543b.continueSettling(true)) {
            return true;
        }
        this.f5543b.processTouchEvent(motionEvent);
        return true;
    }

    public void setDrawerPosition(com.lxj.xpopup.d.d dVar) {
        this.f5546e = dVar;
    }

    public void setOnCloseListener(d dVar) {
        this.v = dVar;
    }

    public PopupDrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PopupDrawerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = null;
        this.f5546e = com.lxj.xpopup.d.d.Left;
        this.f5547f = new e();
        this.f5548g = new ArgbEvaluator();
        this.f5549h = 0;
        this.f5550i = false;
        this.f5551j = 0.0f;
        this.f5552k = true;
        this.f5554m = false;
        this.f5555n = false;
        this.s = new a();
        this.f5543b = ViewDragHelper.create(this, this.s);
    }

    private boolean a(ViewGroup viewGroup, float f2, float f3, int i2) {
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
            int[] iArr = new int[2];
            childAt.getLocationInWindow(iArr);
            if (com.lxj.xpopup.f.c.a(f2, f3, new Rect(iArr[0], iArr[1], iArr[0] + childAt.getWidth(), iArr[1] + childAt.getHeight())) && (childAt instanceof ViewGroup)) {
                if (childAt instanceof ViewPager) {
                    ViewPager viewPager = (ViewPager) childAt;
                    if (i2 == 0) {
                        return viewPager.canScrollHorizontally(-1) || viewPager.canScrollHorizontally(1);
                    }
                    return viewPager.canScrollHorizontally(i2);
                }
                if (childAt instanceof HorizontalScrollView) {
                    HorizontalScrollView horizontalScrollView = (HorizontalScrollView) childAt;
                    if (i2 == 0) {
                        return horizontalScrollView.canScrollHorizontally(-1) || horizontalScrollView.canScrollHorizontally(1);
                    }
                    return horizontalScrollView.canScrollHorizontally(i2);
                }
                return a((ViewGroup) childAt, f2, f3, i2);
            }
        }
        return false;
    }

    private boolean a(ViewGroup viewGroup, float f2, float f3) {
        return a(viewGroup, f2, f3, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i2) {
        com.lxj.xpopup.d.d dVar = this.f5546e;
        if (dVar == com.lxj.xpopup.d.d.Left) {
            if (i2 < (-this.f5545d.getMeasuredWidth())) {
                i2 = -this.f5545d.getMeasuredWidth();
            }
            if (i2 > 0) {
                return 0;
            }
            return i2;
        }
        if (dVar != com.lxj.xpopup.d.d.Right) {
            return i2;
        }
        if (i2 < getMeasuredWidth() - this.f5545d.getMeasuredWidth()) {
            i2 = getMeasuredWidth() - this.f5545d.getMeasuredWidth();
        }
        return i2 > getMeasuredWidth() ? getMeasuredWidth() : i2;
    }

    public void a() {
        if (this.f5543b.continueSettling(true)) {
            return;
        }
        post(new c());
    }
}
