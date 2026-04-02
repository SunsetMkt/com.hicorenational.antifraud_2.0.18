package com.lxj.xpopup.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: CustomGestureDetector.java */
/* JADX INFO: loaded from: classes2.dex */
class b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f5481k = -1;
    private int a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5482b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ScaleGestureDetector f5483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private VelocityTracker f5484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f5485e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f5486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f5487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f5488h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f5489i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private c f5490j;

    /* JADX INFO: compiled from: CustomGestureDetector.java */
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
            b.this.f5490j.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
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

    b(Context context, c cVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f5489i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f5488h = viewConfiguration.getScaledTouchSlop();
        this.f5490j = cVar;
        this.f5483c = new ScaleGestureDetector(context, new a());
    }

    private float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f5482b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private float c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f5482b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    private boolean d(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.a = motionEvent.getPointerId(0);
            this.f5484d = VelocityTracker.obtain();
            VelocityTracker velocityTracker = this.f5484d;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            this.f5486f = b(motionEvent);
            this.f5487g = c(motionEvent);
            this.f5485e = false;
        } else if (action == 1) {
            this.a = -1;
            if (this.f5485e && this.f5484d != null) {
                this.f5486f = b(motionEvent);
                this.f5487g = c(motionEvent);
                this.f5484d.addMovement(motionEvent);
                this.f5484d.computeCurrentVelocity(1000);
                float xVelocity = this.f5484d.getXVelocity();
                float yVelocity = this.f5484d.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f5489i) {
                    this.f5490j.onFling(this.f5486f, this.f5487g, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker2 = this.f5484d;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f5484d = null;
            }
        } else if (action == 2) {
            float fB = b(motionEvent);
            float fC = c(motionEvent);
            float f2 = fB - this.f5486f;
            float f3 = fC - this.f5487g;
            if (!this.f5485e) {
                this.f5485e = Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) this.f5488h);
            }
            if (this.f5485e) {
                this.f5490j.onDrag(f2, f3);
                this.f5486f = fB;
                this.f5487g = fC;
                VelocityTracker velocityTracker3 = this.f5484d;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.a = -1;
            VelocityTracker velocityTracker4 = this.f5484d;
            if (velocityTracker4 != null) {
                velocityTracker4.recycle();
                this.f5484d = null;
            }
        } else if (action == 6) {
            int iA = l.a(motionEvent.getAction());
            if (motionEvent.getPointerId(iA) == this.a) {
                int i2 = iA == 0 ? 1 : 0;
                this.a = motionEvent.getPointerId(i2);
                this.f5486f = motionEvent.getX(i2);
                this.f5487g = motionEvent.getY(i2);
            }
        }
        int i3 = this.a;
        if (i3 == -1) {
            i3 = 0;
        }
        this.f5482b = motionEvent.findPointerIndex(i3);
        return true;
    }

    public boolean a() {
        return this.f5485e;
    }

    public boolean a(MotionEvent motionEvent) {
        try {
            if (motionEvent.getPointerCount() > 1) {
                this.f5483c.onTouchEvent(motionEvent);
            }
            return d(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    public boolean b() {
        return this.f5483c.isInProgress();
    }
}
