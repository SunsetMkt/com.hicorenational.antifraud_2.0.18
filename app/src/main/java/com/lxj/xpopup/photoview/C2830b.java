package com.lxj.xpopup.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* compiled from: CustomGestureDetector.java */
/* renamed from: com.lxj.xpopup.photoview.b */
/* loaded from: classes.dex */
class C2830b {

    /* renamed from: k */
    private static final int f8808k = -1;

    /* renamed from: a */
    private int f8809a = -1;

    /* renamed from: b */
    private int f8810b = 0;

    /* renamed from: c */
    private final ScaleGestureDetector f8811c;

    /* renamed from: d */
    private VelocityTracker f8812d;

    /* renamed from: e */
    private boolean f8813e;

    /* renamed from: f */
    private float f8814f;

    /* renamed from: g */
    private float f8815g;

    /* renamed from: h */
    private final float f8816h;

    /* renamed from: i */
    private final float f8817i;

    /* renamed from: j */
    private InterfaceC2831c f8818j;

    /* compiled from: CustomGestureDetector.java */
    /* renamed from: com.lxj.xpopup.photoview.b$a */
    class a implements ScaleGestureDetector.OnScaleGestureListener {
        a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            if (scaleFactor < 0.0f) {
                return true;
            }
            C2830b.this.f8818j.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    C2830b(Context context, InterfaceC2831c interfaceC2831c) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f8817i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f8816h = viewConfiguration.getScaledTouchSlop();
        this.f8818j = interfaceC2831c;
        this.f8811c = new ScaleGestureDetector(context, new a());
    }

    /* renamed from: b */
    private float m8507b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f8810b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    /* renamed from: c */
    private float m8508c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f8810b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    /* renamed from: d */
    private boolean m8509d(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f8809a = motionEvent.getPointerId(0);
            this.f8812d = VelocityTracker.obtain();
            VelocityTracker velocityTracker = this.f8812d;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            this.f8814f = m8507b(motionEvent);
            this.f8815g = m8508c(motionEvent);
            this.f8813e = false;
        } else if (action == 1) {
            this.f8809a = -1;
            if (this.f8813e && this.f8812d != null) {
                this.f8814f = m8507b(motionEvent);
                this.f8815g = m8508c(motionEvent);
                this.f8812d.addMovement(motionEvent);
                this.f8812d.computeCurrentVelocity(1000);
                float xVelocity = this.f8812d.getXVelocity();
                float yVelocity = this.f8812d.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f8817i) {
                    this.f8818j.onFling(this.f8814f, this.f8815g, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker2 = this.f8812d;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f8812d = null;
            }
        } else if (action == 2) {
            float m8507b = m8507b(motionEvent);
            float m8508c = m8508c(motionEvent);
            float f2 = m8507b - this.f8814f;
            float f3 = m8508c - this.f8815g;
            if (!this.f8813e) {
                this.f8813e = Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) this.f8816h);
            }
            if (this.f8813e) {
                this.f8818j.onDrag(f2, f3);
                this.f8814f = m8507b;
                this.f8815g = m8508c;
                VelocityTracker velocityTracker3 = this.f8812d;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.f8809a = -1;
            VelocityTracker velocityTracker4 = this.f8812d;
            if (velocityTracker4 != null) {
                velocityTracker4.recycle();
                this.f8812d = null;
            }
        } else if (action == 6) {
            int m8582a = C2840l.m8582a(motionEvent.getAction());
            if (motionEvent.getPointerId(m8582a) == this.f8809a) {
                int i2 = m8582a == 0 ? 1 : 0;
                this.f8809a = motionEvent.getPointerId(i2);
                this.f8814f = motionEvent.getX(i2);
                this.f8815g = motionEvent.getY(i2);
            }
        }
        int i3 = this.f8809a;
        if (i3 == -1) {
            i3 = 0;
        }
        this.f8810b = motionEvent.findPointerIndex(i3);
        return true;
    }

    /* renamed from: a */
    public boolean m8510a() {
        return this.f8813e;
    }

    /* renamed from: a */
    public boolean m8511a(MotionEvent motionEvent) {
        try {
            if (motionEvent.getPointerCount() > 1) {
                this.f8811c.onTouchEvent(motionEvent);
            }
            return m8509d(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    /* renamed from: b */
    public boolean m8512b() {
        return this.f8811c.isInProgress();
    }
}
