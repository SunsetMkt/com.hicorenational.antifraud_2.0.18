package com.lxj.xpopup.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.viewpager.widget.ViewPager;
import com.lxj.xpopup.p186e.InterfaceC2810d;
import com.lxj.xpopup.photoview.PhotoView;
import com.lxj.xpopup.photoview.ViewOnTouchListenerC2839k;

/* loaded from: classes.dex */
public class PhotoViewContainer extends FrameLayout {

    /* renamed from: k */
    private static final String f8914k = "PhotoViewContainer";

    /* renamed from: a */
    private ViewDragHelper f8915a;

    /* renamed from: b */
    public ViewPager f8916b;

    /* renamed from: c */
    private int f8917c;

    /* renamed from: d */
    private int f8918d;

    /* renamed from: e */
    private InterfaceC2810d f8919e;

    /* renamed from: f */
    public boolean f8920f;

    /* renamed from: g */
    boolean f8921g;

    /* renamed from: h */
    private float f8922h;

    /* renamed from: i */
    private float f8923i;

    /* renamed from: j */
    ViewDragHelper.Callback f8924j;

    /* renamed from: com.lxj.xpopup.widget.PhotoViewContainer$a */
    class C2842a extends ViewDragHelper.Callback {
        C2842a() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull View view, int i2, int i3) {
            int top = PhotoViewContainer.this.f8916b.getTop() + (i3 / 2);
            return top >= 0 ? Math.min(top, PhotoViewContainer.this.f8918d) : -Math.min(-top, PhotoViewContainer.this.f8918d);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(@NonNull View view) {
            return 1;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i2, int i3, int i4, int i5) {
            super.onViewPositionChanged(view, i2, i3, i4, i5);
            ViewPager viewPager = PhotoViewContainer.this.f8916b;
            if (view != viewPager) {
                viewPager.offsetTopAndBottom(i5);
            }
            float abs = (Math.abs(i3) * 1.0f) / PhotoViewContainer.this.f8918d;
            float f2 = 1.0f - (0.2f * abs);
            PhotoViewContainer.this.f8916b.setScaleX(f2);
            PhotoViewContainer.this.f8916b.setScaleY(f2);
            view.setScaleX(f2);
            view.setScaleY(f2);
            if (PhotoViewContainer.this.f8919e != null) {
                PhotoViewContainer.this.f8919e.mo8419a(i5, f2, abs);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@NonNull View view, float f2, float f3) {
            super.onViewReleased(view, f2, f3);
            if (Math.abs(view.getTop()) > PhotoViewContainer.this.f8917c) {
                if (PhotoViewContainer.this.f8919e != null) {
                    PhotoViewContainer.this.f8919e.mo8418a();
                }
            } else {
                PhotoViewContainer.this.f8915a.smoothSlideViewTo(PhotoViewContainer.this.f8916b, 0, 0);
                PhotoViewContainer.this.f8915a.smoothSlideViewTo(view, 0, 0);
                ViewCompat.postInvalidateOnAnimation(PhotoViewContainer.this);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(@NonNull View view, int i2) {
            return !PhotoViewContainer.this.f8920f;
        }
    }

    public PhotoViewContainer(@NonNull Context context) {
        this(context, null);
    }

    private PhotoView getCurrentPhotoView() {
        ViewPager viewPager = this.f8916b;
        return (PhotoView) viewPager.getChildAt(viewPager.getCurrentItem());
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f8915a.continueSettling(false)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000e, code lost:
    
        if (r0 != 3) goto L17;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getAction()
            if (r0 == 0) goto L48
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L40
            r3 = 2
            if (r0 == r3) goto L11
            r2 = 3
            if (r0 == r2) goto L40
            goto L54
        L11:
            float r0 = r6.getX()
            float r3 = r5.f8922h
            float r0 = r0 - r3
            float r3 = r6.getY()
            float r4 = r5.f8923i
            float r3 = r3 - r4
            androidx.viewpager.widget.ViewPager r4 = r5.f8916b
            r4.dispatchTouchEvent(r6)
            float r3 = java.lang.Math.abs(r3)
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 <= 0) goto L31
            r1 = 1
        L31:
            r5.f8921g = r1
            float r0 = r6.getX()
            r5.f8922h = r0
            float r0 = r6.getY()
            r5.f8923i = r0
            goto L54
        L40:
            r0 = 0
            r5.f8922h = r0
            r5.f8923i = r0
            r5.f8921g = r1
            goto L54
        L48:
            float r0 = r6.getX()
            r5.f8922h = r0
            float r0 = r6.getY()
            r5.f8923i = r0
        L54:
            boolean r6 = super.dispatchTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lxj.xpopup.widget.PhotoViewContainer.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8920f = false;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f8916b = (ViewPager) getChildAt(0);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean shouldInterceptTouchEvent = this.f8915a.shouldInterceptTouchEvent(motionEvent);
        if (motionEvent.getPointerCount() > 1 && motionEvent.getAction() == 2) {
            return false;
        }
        if (m8590b() && this.f8921g) {
            return true;
        }
        return shouldInterceptTouchEvent && this.f8921g;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f8918d = getHeight() / 3;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return false;
        }
        try {
            this.f8915a.processTouchEvent(motionEvent);
        } catch (Exception unused) {
        }
        return true;
    }

    public void setOnDragChangeListener(InterfaceC2810d interfaceC2810d) {
        this.f8919e = interfaceC2810d;
    }

    public PhotoViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    private void m8588a() {
        this.f8917c = m8593a(this.f8917c);
        this.f8915a = ViewDragHelper.create(this, this.f8924j);
        setBackgroundColor(0);
    }

    /* renamed from: b */
    private boolean m8590b() {
        PhotoView currentPhotoView = getCurrentPhotoView();
        if (currentPhotoView != null) {
            ViewOnTouchListenerC2839k viewOnTouchListenerC2839k = currentPhotoView.f8805a;
            if (viewOnTouchListenerC2839k.f8835C || viewOnTouchListenerC2839k.f8836D) {
                return true;
            }
        }
        return false;
    }

    public PhotoViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8917c = 80;
        this.f8920f = false;
        this.f8921g = false;
        this.f8924j = new C2842a();
        m8588a();
    }

    /* renamed from: a */
    public int m8593a(float f2) {
        return (int) ((f2 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }
}
