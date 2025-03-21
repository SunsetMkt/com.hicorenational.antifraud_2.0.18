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
import com.lxj.xpopup.C2768b;
import com.lxj.xpopup.p184c.C2773e;
import com.lxj.xpopup.p185d.EnumC2802b;
import com.lxj.xpopup.p185d.EnumC2804d;
import com.lxj.xpopup.p187f.C2819c;

/* loaded from: classes.dex */
public class PopupDrawerLayout extends FrameLayout {

    /* renamed from: a */
    EnumC2802b f8926a;

    /* renamed from: b */
    ViewDragHelper f8927b;

    /* renamed from: c */
    View f8928c;

    /* renamed from: d */
    View f8929d;

    /* renamed from: e */
    public EnumC2804d f8930e;

    /* renamed from: f */
    C2773e f8931f;

    /* renamed from: g */
    ArgbEvaluator f8932g;

    /* renamed from: h */
    int f8933h;

    /* renamed from: i */
    public boolean f8934i;

    /* renamed from: j */
    float f8935j;

    /* renamed from: k */
    public boolean f8936k;

    /* renamed from: l */
    float f8937l;

    /* renamed from: m */
    boolean f8938m;

    /* renamed from: n */
    boolean f8939n;

    /* renamed from: o */
    float f8940o;

    /* renamed from: p */
    float f8941p;

    /* renamed from: q */
    boolean f8942q;

    /* renamed from: r */
    boolean f8943r;

    /* renamed from: s */
    ViewDragHelper.Callback f8944s;

    /* renamed from: t */
    Paint f8945t;

    /* renamed from: u */
    Rect f8946u;

    /* renamed from: v */
    private InterfaceC2846d f8947v;

    /* renamed from: com.lxj.xpopup.widget.PopupDrawerLayout$a */
    class C2843a extends ViewDragHelper.Callback {
        C2843a() {
        }

        /* renamed from: a */
        private void m8601a(int i2) {
            PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
            EnumC2804d enumC2804d = popupDrawerLayout.f8930e;
            if (enumC2804d == EnumC2804d.Left) {
                popupDrawerLayout.f8935j = ((popupDrawerLayout.f8929d.getMeasuredWidth() + i2) * 1.0f) / PopupDrawerLayout.this.f8929d.getMeasuredWidth();
                if (i2 == (-PopupDrawerLayout.this.f8929d.getMeasuredWidth()) && PopupDrawerLayout.this.f8947v != null) {
                    PopupDrawerLayout popupDrawerLayout2 = PopupDrawerLayout.this;
                    EnumC2802b enumC2802b = popupDrawerLayout2.f8926a;
                    EnumC2802b enumC2802b2 = EnumC2802b.Close;
                    if (enumC2802b != enumC2802b2) {
                        popupDrawerLayout2.f8926a = enumC2802b2;
                        popupDrawerLayout2.f8947v.onClose();
                    }
                }
            } else if (enumC2804d == EnumC2804d.Right) {
                popupDrawerLayout.f8935j = ((popupDrawerLayout.getMeasuredWidth() - i2) * 1.0f) / PopupDrawerLayout.this.f8929d.getMeasuredWidth();
                if (i2 == PopupDrawerLayout.this.getMeasuredWidth() && PopupDrawerLayout.this.f8947v != null) {
                    PopupDrawerLayout popupDrawerLayout3 = PopupDrawerLayout.this;
                    EnumC2802b enumC2802b3 = popupDrawerLayout3.f8926a;
                    EnumC2802b enumC2802b4 = EnumC2802b.Close;
                    if (enumC2802b3 != enumC2802b4) {
                        popupDrawerLayout3.f8926a = enumC2802b4;
                        popupDrawerLayout3.f8947v.onClose();
                    }
                }
            }
            PopupDrawerLayout popupDrawerLayout4 = PopupDrawerLayout.this;
            if (popupDrawerLayout4.f8936k) {
                popupDrawerLayout4.setBackgroundColor(popupDrawerLayout4.f8931f.m8361a(popupDrawerLayout4.f8935j));
            }
            if (PopupDrawerLayout.this.f8947v != null) {
                PopupDrawerLayout.this.f8947v.mo8401a(PopupDrawerLayout.this.f8935j);
                PopupDrawerLayout popupDrawerLayout5 = PopupDrawerLayout.this;
                if (popupDrawerLayout5.f8935j == 1.0f) {
                    EnumC2802b enumC2802b5 = popupDrawerLayout5.f8926a;
                    EnumC2802b enumC2802b6 = EnumC2802b.Open;
                    if (enumC2802b5 != enumC2802b6) {
                        popupDrawerLayout5.f8926a = enumC2802b6;
                        popupDrawerLayout5.f8947v.mo8400a();
                    }
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@NonNull View view, int i2, int i3) {
            PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
            return view == popupDrawerLayout.f8928c ? i2 : popupDrawerLayout.m8594a(i2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(@NonNull View view) {
            return 1;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i2, int i3, int i4, int i5) {
            super.onViewPositionChanged(view, i2, i3, i4, i5);
            View view2 = PopupDrawerLayout.this.f8928c;
            if (view != view2) {
                m8601a(i2);
                return;
            }
            view2.layout(0, 0, view2.getMeasuredWidth(), PopupDrawerLayout.this.f8928c.getMeasuredHeight());
            PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
            int m8594a = popupDrawerLayout.m8594a(popupDrawerLayout.f8929d.getLeft() + i4);
            View view3 = PopupDrawerLayout.this.f8929d;
            view3.layout(m8594a, view3.getTop(), PopupDrawerLayout.this.f8929d.getMeasuredWidth() + m8594a, PopupDrawerLayout.this.f8929d.getBottom());
            m8601a(m8594a);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@NonNull View view, float f2, float f3) {
            int measuredWidth;
            int measuredWidth2;
            super.onViewReleased(view, f2, f3);
            PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
            if (view == popupDrawerLayout.f8928c && f2 == 0.0f) {
                popupDrawerLayout.m8599a();
                return;
            }
            PopupDrawerLayout popupDrawerLayout2 = PopupDrawerLayout.this;
            if (view == popupDrawerLayout2.f8929d && popupDrawerLayout2.f8942q && !popupDrawerLayout2.f8943r && f2 < -500.0f) {
                popupDrawerLayout2.m8599a();
                return;
            }
            PopupDrawerLayout popupDrawerLayout3 = PopupDrawerLayout.this;
            if (popupDrawerLayout3.f8930e == EnumC2804d.Left) {
                if (f2 < -1000.0f) {
                    measuredWidth2 = popupDrawerLayout3.f8929d.getMeasuredWidth();
                } else {
                    if (PopupDrawerLayout.this.f8929d.getLeft() < (-popupDrawerLayout3.f8929d.getMeasuredWidth()) / 2) {
                        measuredWidth2 = PopupDrawerLayout.this.f8929d.getMeasuredWidth();
                    } else {
                        measuredWidth = 0;
                    }
                }
                measuredWidth = -measuredWidth2;
            } else if (f2 > 1000.0f) {
                measuredWidth = popupDrawerLayout3.getMeasuredWidth();
            } else {
                measuredWidth = view.getLeft() < popupDrawerLayout3.getMeasuredWidth() - (PopupDrawerLayout.this.f8929d.getMeasuredWidth() / 2) ? PopupDrawerLayout.this.getMeasuredWidth() - PopupDrawerLayout.this.f8929d.getMeasuredWidth() : PopupDrawerLayout.this.getMeasuredWidth();
            }
            PopupDrawerLayout popupDrawerLayout4 = PopupDrawerLayout.this;
            popupDrawerLayout4.f8927b.smoothSlideViewTo(popupDrawerLayout4.f8929d, measuredWidth, view.getTop());
            ViewCompat.postInvalidateOnAnimation(PopupDrawerLayout.this);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(@NonNull View view, int i2) {
            return !PopupDrawerLayout.this.f8927b.continueSettling(true);
        }
    }

    /* renamed from: com.lxj.xpopup.widget.PopupDrawerLayout$b */
    class RunnableC2844b implements Runnable {
        RunnableC2844b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
            ViewDragHelper viewDragHelper = popupDrawerLayout.f8927b;
            View view = popupDrawerLayout.f8929d;
            viewDragHelper.smoothSlideViewTo(view, popupDrawerLayout.f8930e == EnumC2804d.Left ? 0 : view.getLeft() - PopupDrawerLayout.this.f8929d.getMeasuredWidth(), 0);
            ViewCompat.postInvalidateOnAnimation(PopupDrawerLayout.this);
        }
    }

    /* renamed from: com.lxj.xpopup.widget.PopupDrawerLayout$c */
    class RunnableC2845c implements Runnable {
        RunnableC2845c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
            ViewDragHelper viewDragHelper = popupDrawerLayout.f8927b;
            View view = popupDrawerLayout.f8929d;
            viewDragHelper.smoothSlideViewTo(view, popupDrawerLayout.f8930e == EnumC2804d.Left ? -view.getMeasuredWidth() : popupDrawerLayout.getMeasuredWidth(), 0);
            ViewCompat.postInvalidateOnAnimation(PopupDrawerLayout.this);
        }
    }

    /* renamed from: com.lxj.xpopup.widget.PopupDrawerLayout$d */
    public interface InterfaceC2846d {
        /* renamed from: a */
        void mo8400a();

        /* renamed from: a */
        void mo8401a(float f2);

        void onClose();
    }

    public PopupDrawerLayout(Context context) {
        this(context, null);
    }

    /* renamed from: b */
    public void m8600b() {
        post(new RunnableC2844b());
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f8927b.continueSettling(false)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f8934i) {
            if (this.f8945t == null) {
                this.f8945t = new Paint();
                this.f8946u = new Rect(0, 0, getMeasuredHeight(), C2819c.m8471c());
            }
            this.f8945t.setColor(((Integer) this.f8932g.evaluate(this.f8935j, Integer.valueOf(this.f8933h), Integer.valueOf(C2768b.f8564c))).intValue());
            canvas.drawRect(this.f8946u, this.f8945t);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f8937l = getTranslationY();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8926a = null;
        this.f8935j = 0.0f;
        setTranslationY(this.f8937l);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f8928c = getChildAt(0);
        this.f8929d = getChildAt(1);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f8942q = motionEvent.getX() < this.f8940o;
        this.f8940o = motionEvent.getX();
        this.f8941p = motionEvent.getY();
        this.f8943r = m8598a(this, motionEvent.getX(), motionEvent.getY(), 1);
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.f8940o = 0.0f;
            this.f8941p = 0.0f;
        }
        this.f8939n = this.f8927b.shouldInterceptTouchEvent(motionEvent);
        return (!this.f8942q || this.f8943r) ? !m8597a(this, motionEvent.getX(), motionEvent.getY()) ? this.f8939n : super.onInterceptTouchEvent(motionEvent) : this.f8939n;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View view = this.f8928c;
        view.layout(0, 0, view.getMeasuredWidth(), this.f8928c.getMeasuredHeight());
        if (this.f8938m) {
            View view2 = this.f8929d;
            view2.layout(view2.getLeft(), this.f8929d.getTop(), this.f8929d.getRight(), this.f8929d.getBottom());
            return;
        }
        if (this.f8930e == EnumC2804d.Left) {
            View view3 = this.f8929d;
            view3.layout(-view3.getMeasuredWidth(), 0, 0, getMeasuredHeight());
        } else {
            this.f8929d.layout(getMeasuredWidth(), 0, getMeasuredWidth() + this.f8929d.getMeasuredWidth(), getMeasuredHeight());
        }
        this.f8938m = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f8927b.continueSettling(true)) {
            return true;
        }
        this.f8927b.processTouchEvent(motionEvent);
        return true;
    }

    public void setDrawerPosition(EnumC2804d enumC2804d) {
        this.f8930e = enumC2804d;
    }

    public void setOnCloseListener(InterfaceC2846d interfaceC2846d) {
        this.f8947v = interfaceC2846d;
    }

    public PopupDrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PopupDrawerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8926a = null;
        this.f8930e = EnumC2804d.Left;
        this.f8931f = new C2773e();
        this.f8932g = new ArgbEvaluator();
        this.f8933h = 0;
        this.f8934i = false;
        this.f8935j = 0.0f;
        this.f8936k = true;
        this.f8938m = false;
        this.f8939n = false;
        this.f8944s = new C2843a();
        this.f8927b = ViewDragHelper.create(this, this.f8944s);
    }

    /* renamed from: a */
    private boolean m8598a(ViewGroup viewGroup, float f2, float f3, int i2) {
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
            int[] iArr = new int[2];
            childAt.getLocationInWindow(iArr);
            if (C2819c.m8462a(f2, f3, new Rect(iArr[0], iArr[1], iArr[0] + childAt.getWidth(), iArr[1] + childAt.getHeight())) && (childAt instanceof ViewGroup)) {
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
                return m8598a((ViewGroup) childAt, f2, f3, i2);
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m8597a(ViewGroup viewGroup, float f2, float f3) {
        return m8598a(viewGroup, f2, f3, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m8594a(int i2) {
        EnumC2804d enumC2804d = this.f8930e;
        if (enumC2804d == EnumC2804d.Left) {
            if (i2 < (-this.f8929d.getMeasuredWidth())) {
                i2 = -this.f8929d.getMeasuredWidth();
            }
            if (i2 > 0) {
                return 0;
            }
            return i2;
        }
        if (enumC2804d != EnumC2804d.Right) {
            return i2;
        }
        if (i2 < getMeasuredWidth() - this.f8929d.getMeasuredWidth()) {
            i2 = getMeasuredWidth() - this.f8929d.getMeasuredWidth();
        }
        return i2 > getMeasuredWidth() ? getMeasuredWidth() : i2;
    }

    /* renamed from: a */
    public void m8599a() {
        if (this.f8927b.continueSettling(true)) {
            return;
        }
        post(new RunnableC2845c());
    }
}
