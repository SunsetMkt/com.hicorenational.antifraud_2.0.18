package com.lxj.xpopup.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ViewCompat;
import com.lxj.xpopup.C2768b;
import com.lxj.xpopup.p184c.C2773e;
import com.lxj.xpopup.p185d.EnumC2802b;

/* loaded from: classes.dex */
public class SmartDragLayout extends FrameLayout implements NestedScrollingParent {

    /* renamed from: q */
    private static final String f8951q = "SmartDragLayout";

    /* renamed from: a */
    private View f8952a;

    /* renamed from: b */
    OverScroller f8953b;

    /* renamed from: c */
    VelocityTracker f8954c;

    /* renamed from: d */
    C2773e f8955d;

    /* renamed from: e */
    boolean f8956e;

    /* renamed from: f */
    boolean f8957f;

    /* renamed from: g */
    boolean f8958g;

    /* renamed from: h */
    boolean f8959h;

    /* renamed from: i */
    EnumC2802b f8960i;

    /* renamed from: j */
    int f8961j;

    /* renamed from: k */
    int f8962k;

    /* renamed from: l */
    int f8963l;

    /* renamed from: m */
    float f8964m;

    /* renamed from: n */
    float f8965n;

    /* renamed from: o */
    boolean f8966o;

    /* renamed from: p */
    private InterfaceC2850d f8967p;

    /* renamed from: com.lxj.xpopup.widget.SmartDragLayout$a */
    class RunnableC2847a implements Runnable {
        RunnableC2847a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartDragLayout smartDragLayout = SmartDragLayout.this;
            smartDragLayout.m8604a(smartDragLayout.f8961j - smartDragLayout.getScrollY());
        }
    }

    /* renamed from: com.lxj.xpopup.widget.SmartDragLayout$b */
    class RunnableC2848b implements Runnable {
        RunnableC2848b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartDragLayout smartDragLayout = SmartDragLayout.this;
            smartDragLayout.m8604a(smartDragLayout.f8962k - smartDragLayout.getScrollY());
        }
    }

    /* renamed from: com.lxj.xpopup.widget.SmartDragLayout$c */
    class RunnableC2849c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f8970a;

        RunnableC2849c(int i2) {
            this.f8970a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartDragLayout smartDragLayout = SmartDragLayout.this;
            smartDragLayout.f8953b.startScroll(smartDragLayout.getScrollX(), SmartDragLayout.this.getScrollY(), 0, this.f8970a, C2768b.m8294a());
            ViewCompat.postInvalidateOnAnimation(SmartDragLayout.this);
        }
    }

    /* renamed from: com.lxj.xpopup.widget.SmartDragLayout$d */
    public interface InterfaceC2850d {
        /* renamed from: a */
        void mo8397a();

        void onClose();
    }

    public SmartDragLayout(Context context) {
        this(context, null);
    }

    /* renamed from: c */
    private void m8602c() {
        if (this.f8956e) {
            this.f8953b.startScroll(getScrollX(), getScrollY(), 0, (getScrollY() > (this.f8966o ? this.f8961j - this.f8962k : (this.f8961j - this.f8962k) * 2) / 3 ? this.f8961j : this.f8962k) - getScrollY(), C2768b.m8294a());
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* renamed from: a */
    public void m8603a() {
        this.f8959h = true;
        this.f8960i = EnumC2802b.Closing;
        post(new RunnableC2848b());
    }

    /* renamed from: b */
    public void m8606b() {
        this.f8960i = EnumC2802b.Opening;
        post(new RunnableC2847a());
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f8953b.computeScrollOffset()) {
            scrollTo(this.f8953b.getCurrX(), this.f8953b.getCurrY());
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.f8959h = true;
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return 2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8966o = false;
        this.f8959h = false;
        setTranslationY(0.0f);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.f8961j = this.f8952a.getMeasuredHeight();
        this.f8962k = 0;
        int measuredWidth = (getMeasuredWidth() / 2) - (this.f8952a.getMeasuredWidth() / 2);
        if (this.f8956e) {
            this.f8952a.layout(measuredWidth, getMeasuredHeight(), this.f8952a.getMeasuredWidth() + measuredWidth, getMeasuredHeight() + this.f8961j);
            if (this.f8960i == EnumC2802b.Open) {
                scrollTo(getScrollX(), getScrollY() - (this.f8963l - this.f8961j));
            }
        } else {
            this.f8952a.layout(measuredWidth, getMeasuredHeight() - this.f8952a.getMeasuredHeight(), this.f8952a.getMeasuredWidth() + measuredWidth, getMeasuredHeight());
        }
        this.f8963l = this.f8961j;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        if ((getScrollY() > this.f8962k && getScrollY() < this.f8961j) && f3 < -1500.0f) {
            m8603a();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            int scrollY = getScrollY() + i3;
            if (scrollY < this.f8961j) {
                iArr[1] = i3;
            }
            scrollTo(getScrollX(), scrollY);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        scrollTo(getScrollX(), getScrollY() + i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.f8953b.abortAnimation();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return i2 == 2 && this.f8956e;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        m8602c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        if (r0 != 3) goto L35;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            android.widget.OverScroller r0 = r8.f8953b
            boolean r0 = r0.computeScrollOffset()
            if (r0 == 0) goto Lf
            r9 = 0
            r8.f8964m = r9
            r8.f8965n = r9
            r9 = 0
            return r9
        Lf:
            int r0 = r9.getAction()
            r1 = 1
            if (r0 == 0) goto Lbf
            if (r0 == r1) goto L4c
            r2 = 2
            if (r0 == r2) goto L20
            r2 = 3
            if (r0 == r2) goto L4c
            goto Ld5
        L20:
            boolean r0 = r8.f8956e
            if (r0 == 0) goto Ld5
            android.view.VelocityTracker r0 = r8.f8954c
            r0.addMovement(r9)
            android.view.VelocityTracker r0 = r8.f8954c
            r2 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r2)
            float r0 = r9.getY()
            float r2 = r8.f8965n
            float r0 = r0 - r2
            int r0 = (int) r0
            int r2 = r8.getScrollX()
            int r3 = r8.getScrollY()
            int r3 = r3 - r0
            r8.scrollTo(r2, r3)
            float r9 = r9.getY()
            r8.f8965n = r9
            goto Ld5
        L4c:
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            android.view.View r2 = r8.f8952a
            r2.getGlobalVisibleRect(r0)
            float r2 = r9.getRawX()
            float r3 = r9.getRawY()
            boolean r0 = com.lxj.xpopup.p187f.C2819c.m8462a(r2, r3, r0)
            if (r0 != 0) goto L9c
            boolean r0 = r8.f8957f
            if (r0 == 0) goto L9c
            float r0 = r9.getX()
            float r2 = r8.f8964m
            float r0 = r0 - r2
            double r2 = (double) r0
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r2 = java.lang.Math.pow(r2, r4)
            float r9 = r9.getY()
            float r0 = r8.f8965n
            float r9 = r9 - r0
            double r6 = (double) r9
            double r4 = java.lang.Math.pow(r6, r4)
            double r2 = r2 + r4
            double r2 = java.lang.Math.sqrt(r2)
            float r9 = (float) r2
            android.content.Context r0 = r8.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            float r0 = (float) r0
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 >= 0) goto L9c
            r8.performClick()
        L9c:
            boolean r9 = r8.f8956e
            if (r9 == 0) goto Ld5
            android.view.VelocityTracker r9 = r8.f8954c
            float r9 = r9.getYVelocity()
            r0 = 1153138688(0x44bb8000, float:1500.0)
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 <= 0) goto Lb1
            r8.m8603a()
            goto Lb4
        Lb1:
            r8.m8602c()
        Lb4:
            android.view.VelocityTracker r9 = r8.f8954c
            r9.clear()
            android.view.VelocityTracker r9 = r8.f8954c
            r9.recycle()
            goto Ld5
        Lbf:
            boolean r0 = r8.f8956e
            if (r0 == 0) goto Lc9
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r8.f8954c = r0
        Lc9:
            float r0 = r9.getX()
            r8.f8964m = r0
            float r9 = r9.getY()
            r8.f8965n = r9
        Ld5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lxj.xpopup.widget.SmartDragLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        this.f8952a = view;
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        int i4 = this.f8961j;
        if (i3 > i4) {
            i3 = i4;
        }
        int i5 = this.f8962k;
        if (i3 < i5) {
            i3 = i5;
        }
        int i6 = this.f8962k;
        float f2 = ((i3 - i6) * 1.0f) / (this.f8961j - i6);
        this.f8966o = i3 > getScrollY();
        if (this.f8958g) {
            setBackgroundColor(this.f8955d.m8361a(f2));
        }
        InterfaceC2850d interfaceC2850d = this.f8967p;
        if (interfaceC2850d != null) {
            if (this.f8959h && f2 == 0.0f) {
                EnumC2802b enumC2802b = this.f8960i;
                EnumC2802b enumC2802b2 = EnumC2802b.Close;
                if (enumC2802b != enumC2802b2) {
                    this.f8960i = enumC2802b2;
                    interfaceC2850d.onClose();
                }
            }
            if (f2 == 1.0f) {
                EnumC2802b enumC2802b3 = this.f8960i;
                EnumC2802b enumC2802b4 = EnumC2802b.Open;
                if (enumC2802b3 != enumC2802b4) {
                    this.f8960i = enumC2802b4;
                    this.f8967p.mo8397a();
                }
            }
        }
        super.scrollTo(i2, i3);
    }

    public void setOnCloseListener(InterfaceC2850d interfaceC2850d) {
        this.f8967p = interfaceC2850d;
    }

    public SmartDragLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SmartDragLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8955d = new C2773e();
        this.f8956e = true;
        this.f8957f = true;
        this.f8958g = true;
        this.f8959h = false;
        this.f8960i = EnumC2802b.Close;
        if (this.f8956e) {
            this.f8953b = new OverScroller(context);
        }
    }

    /* renamed from: b */
    public void m8607b(boolean z) {
        this.f8956e = z;
    }

    /* renamed from: a */
    public void m8604a(int i2) {
        post(new RunnableC2849c(i2));
    }

    /* renamed from: a */
    public void m8605a(boolean z) {
        this.f8957f = z;
    }

    /* renamed from: c */
    public void m8608c(boolean z) {
        this.f8958g = z;
    }
}
