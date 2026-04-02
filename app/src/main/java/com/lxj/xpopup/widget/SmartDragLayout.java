package com.lxj.xpopup.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ViewCompat;
import com.lxj.xpopup.c.e;

/* JADX INFO: loaded from: classes2.dex */
public class SmartDragLayout extends FrameLayout implements NestedScrollingParent {
    private static final String q = "SmartDragLayout";
    private View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    OverScroller f5556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    VelocityTracker f5557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    e f5558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f5559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f5560f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f5561g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f5562h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    com.lxj.xpopup.d.b f5563i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f5564j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f5565k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f5566l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    float f5567m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    float f5568n;
    boolean o;
    private d p;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartDragLayout smartDragLayout = SmartDragLayout.this;
            smartDragLayout.a(smartDragLayout.f5564j - smartDragLayout.getScrollY());
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartDragLayout smartDragLayout = SmartDragLayout.this;
            smartDragLayout.a(smartDragLayout.f5565k - smartDragLayout.getScrollY());
        }
    }

    class c implements Runnable {
        final /* synthetic */ int a;

        c(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartDragLayout smartDragLayout = SmartDragLayout.this;
            smartDragLayout.f5556b.startScroll(smartDragLayout.getScrollX(), SmartDragLayout.this.getScrollY(), 0, this.a, com.lxj.xpopup.b.a());
            ViewCompat.postInvalidateOnAnimation(SmartDragLayout.this);
        }
    }

    public interface d {
        void a();

        void onClose();
    }

    public SmartDragLayout(Context context) {
        this(context, null);
    }

    private void c() {
        if (this.f5559e) {
            this.f5556b.startScroll(getScrollX(), getScrollY(), 0, (getScrollY() > (this.o ? this.f5564j - this.f5565k : (this.f5564j - this.f5565k) * 2) / 3 ? this.f5564j : this.f5565k) - getScrollY(), com.lxj.xpopup.b.a());
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void a() {
        this.f5562h = true;
        this.f5563i = com.lxj.xpopup.d.b.Closing;
        post(new b());
    }

    public void b() {
        this.f5563i = com.lxj.xpopup.d.b.Opening;
        post(new a());
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f5556b.computeScrollOffset()) {
            scrollTo(this.f5556b.getCurrX(), this.f5556b.getCurrY());
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.f5562h = true;
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return 2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.o = false;
        this.f5562h = false;
        setTranslationY(0.0f);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.f5564j = this.a.getMeasuredHeight();
        this.f5565k = 0;
        int measuredWidth = (getMeasuredWidth() / 2) - (this.a.getMeasuredWidth() / 2);
        if (this.f5559e) {
            this.a.layout(measuredWidth, getMeasuredHeight(), this.a.getMeasuredWidth() + measuredWidth, getMeasuredHeight() + this.f5564j);
            if (this.f5563i == com.lxj.xpopup.d.b.Open) {
                scrollTo(getScrollX(), getScrollY() - (this.f5566l - this.f5564j));
            }
        } else {
            this.a.layout(measuredWidth, getMeasuredHeight() - this.a.getMeasuredHeight(), this.a.getMeasuredWidth() + measuredWidth, getMeasuredHeight());
        }
        this.f5566l = this.f5564j;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        if ((getScrollY() > this.f5565k && getScrollY() < this.f5564j) && f3 < -1500.0f) {
            a();
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
            if (scrollY < this.f5564j) {
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
        this.f5556b.abortAnimation();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return i2 == 2 && this.f5559e;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        c();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f5556b.computeScrollOffset()) {
            this.f5567m = 0.0f;
            this.f5568n = 0.0f;
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            if (this.f5559e) {
                this.f5557c = VelocityTracker.obtain();
            }
            this.f5567m = motionEvent.getX();
            this.f5568n = motionEvent.getY();
        } else if (action == 1) {
            Rect rect = new Rect();
            this.a.getGlobalVisibleRect(rect);
            if (!com.lxj.xpopup.f.c.a(motionEvent.getRawX(), motionEvent.getRawY(), rect) && this.f5560f && ((float) Math.sqrt(Math.pow(motionEvent.getX() - this.f5567m, 2.0d) + Math.pow(motionEvent.getY() - this.f5568n, 2.0d))) < ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                performClick();
            }
            if (this.f5559e) {
                if (this.f5557c.getYVelocity() > 1500.0f) {
                    a();
                } else {
                    c();
                }
                this.f5557c.clear();
                this.f5557c.recycle();
            }
        } else if (action != 2) {
            if (action == 3) {
            }
        } else if (this.f5559e) {
            this.f5557c.addMovement(motionEvent);
            this.f5557c.computeCurrentVelocity(1000);
            scrollTo(getScrollX(), getScrollY() - ((int) (motionEvent.getY() - this.f5568n)));
            this.f5568n = motionEvent.getY();
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        this.a = view;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void scrollTo(int i2, int i3) {
        int i4 = this.f5564j;
        if (i3 > i4) {
            i3 = i4;
        }
        int i5 = this.f5565k;
        if (i3 < i5) {
            i3 = i5;
        }
        int i6 = this.f5565k;
        float f2 = ((i3 - i6) * 1.0f) / (this.f5564j - i6);
        this.o = i3 > getScrollY();
        if (this.f5561g) {
            setBackgroundColor(this.f5558d.a(f2));
        }
        d dVar = this.p;
        if (dVar != null) {
            if (this.f5562h && f2 == 0.0f) {
                com.lxj.xpopup.d.b bVar = this.f5563i;
                com.lxj.xpopup.d.b bVar2 = com.lxj.xpopup.d.b.Close;
                if (bVar != bVar2) {
                    this.f5563i = bVar2;
                    dVar.onClose();
                }
            } else if (f2 == 1.0f) {
                com.lxj.xpopup.d.b bVar3 = this.f5563i;
                com.lxj.xpopup.d.b bVar4 = com.lxj.xpopup.d.b.Open;
                if (bVar3 != bVar4) {
                    this.f5563i = bVar4;
                    this.p.a();
                }
            }
        }
        super.scrollTo(i2, i3);
    }

    public void setOnCloseListener(d dVar) {
        this.p = dVar;
    }

    public SmartDragLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SmartDragLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5558d = new e();
        this.f5559e = true;
        this.f5560f = true;
        this.f5561g = true;
        this.f5562h = false;
        this.f5563i = com.lxj.xpopup.d.b.Close;
        if (this.f5559e) {
            this.f5556b = new OverScroller(context);
        }
    }

    public void b(boolean z) {
        this.f5559e = z;
    }

    public void a(int i2) {
        post(new c(i2));
    }

    public void a(boolean z) {
        this.f5560f = z;
    }

    public void c(boolean z) {
        this.f5561g = z;
    }
}
