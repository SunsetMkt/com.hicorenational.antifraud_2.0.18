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
import com.lxj.xpopup.e.d;
import com.lxj.xpopup.photoview.PhotoView;
import com.lxj.xpopup.photoview.k;

/* JADX INFO: loaded from: classes2.dex */
public class PhotoViewContainer extends FrameLayout {

    /* JADX INFO: renamed from: k */
    private static final String f5533k = "PhotoViewContainer";
    private ViewDragHelper a;

    /* JADX INFO: renamed from: b */
    public ViewPager f5534b;

    /* JADX INFO: renamed from: c */
    private int f5535c;

    /* JADX INFO: renamed from: d */
    private int f5536d;

    /* JADX INFO: renamed from: e */
    private d f5537e;

    /* JADX INFO: renamed from: f */
    public boolean f5538f;

    /* JADX INFO: renamed from: g */
    boolean f5539g;

    /* JADX INFO: renamed from: h */
    private float f5540h;

    /* JADX INFO: renamed from: i */
    private float f5541i;

    /* JADX INFO: renamed from: j */
    ViewDragHelper.Callback f5542j;

    class a extends ViewDragHelper.Callback {
        a() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull View view, int i2, int i3) {
            int top = PhotoViewContainer.this.f5534b.getTop() + (i3 / 2);
            return top >= 0 ? Math.min(top, PhotoViewContainer.this.f5536d) : -Math.min(-top, PhotoViewContainer.this.f5536d);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(@NonNull View view) {
            return 1;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i2, int i3, int i4, int i5) {
            super.onViewPositionChanged(view, i2, i3, i4, i5);
            ViewPager viewPager = PhotoViewContainer.this.f5534b;
            if (view != viewPager) {
                viewPager.offsetTopAndBottom(i5);
            }
            float fAbs = (Math.abs(i3) * 1.0f) / PhotoViewContainer.this.f5536d;
            float f2 = 1.0f - (0.2f * fAbs);
            PhotoViewContainer.this.f5534b.setScaleX(f2);
            PhotoViewContainer.this.f5534b.setScaleY(f2);
            view.setScaleX(f2);
            view.setScaleY(f2);
            if (PhotoViewContainer.this.f5537e != null) {
                PhotoViewContainer.this.f5537e.a(i5, f2, fAbs);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@NonNull View view, float f2, float f3) {
            super.onViewReleased(view, f2, f3);
            if (Math.abs(view.getTop()) > PhotoViewContainer.this.f5535c) {
                if (PhotoViewContainer.this.f5537e != null) {
                    PhotoViewContainer.this.f5537e.a();
                }
            } else {
                PhotoViewContainer.this.a.smoothSlideViewTo(PhotoViewContainer.this.f5534b, 0, 0);
                PhotoViewContainer.this.a.smoothSlideViewTo(view, 0, 0);
                ViewCompat.postInvalidateOnAnimation(PhotoViewContainer.this);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(@NonNull View view, int i2) {
            return !PhotoViewContainer.this.f5538f;
        }
    }

    public PhotoViewContainer(@NonNull Context context) {
        this(context, null);
    }

    private PhotoView getCurrentPhotoView() {
        ViewPager viewPager = this.f5534b;
        return (PhotoView) viewPager.getChildAt(viewPager.getCurrentItem());
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.a.continueSettling(false)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0040  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.f5540h = 0.0f;
                this.f5541i = 0.0f;
                this.f5539g = false;
            } else if (action == 2) {
                float x = motionEvent.getX() - this.f5540h;
                float y = motionEvent.getY() - this.f5541i;
                this.f5534b.dispatchTouchEvent(motionEvent);
                this.f5539g = Math.abs(y) > Math.abs(x);
                this.f5540h = motionEvent.getX();
                this.f5541i = motionEvent.getY();
            } else if (action == 3) {
            }
        } else {
            this.f5540h = motionEvent.getX();
            this.f5541i = motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f5538f = false;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f5534b = (ViewPager) getChildAt(0);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean zShouldInterceptTouchEvent = this.a.shouldInterceptTouchEvent(motionEvent);
        if (motionEvent.getPointerCount() > 1 && motionEvent.getAction() == 2) {
            return false;
        }
        if (b() && this.f5539g) {
            return true;
        }
        return zShouldInterceptTouchEvent && this.f5539g;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f5536d = getHeight() / 3;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return false;
        }
        try {
            this.a.processTouchEvent(motionEvent);
        } catch (Exception unused) {
        }
        return true;
    }

    public void setOnDragChangeListener(d dVar) {
        this.f5537e = dVar;
    }

    public PhotoViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        this.f5535c = a(this.f5535c);
        this.a = ViewDragHelper.create(this, this.f5542j);
        setBackgroundColor(0);
    }

    private boolean b() {
        PhotoView currentPhotoView = getCurrentPhotoView();
        if (currentPhotoView != null) {
            k kVar = currentPhotoView.a;
            if (kVar.C || kVar.D) {
                return true;
            }
        }
        return false;
    }

    public PhotoViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5535c = 80;
        this.f5538f = false;
        this.f5539g = false;
        this.f5542j = new a();
        a();
    }

    public int a(float f2) {
        return (int) ((f2 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }
}
