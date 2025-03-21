package com.lxj.xpopup.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;

/* compiled from: PhotoViewAttacher.java */
/* renamed from: com.lxj.xpopup.photoview.k */
/* loaded from: classes.dex */
public class ViewOnTouchListenerC2839k implements View.OnTouchListener, View.OnLayoutChangeListener {

    /* renamed from: O */
    private static float f8820O = 4.0f;

    /* renamed from: b0 */
    private static float f8821b0 = 2.5f;

    /* renamed from: c0 */
    private static float f8822c0 = 1.0f;

    /* renamed from: d0 */
    private static int f8823d0 = 200;

    /* renamed from: e0 */
    private static final int f8824e0 = -1;

    /* renamed from: f0 */
    private static final int f8825f0 = 0;

    /* renamed from: g0 */
    private static final int f8826g0 = 1;

    /* renamed from: h0 */
    private static final int f8827h0 = 2;

    /* renamed from: i0 */
    private static final int f8828i0 = -1;

    /* renamed from: j0 */
    private static final int f8829j0 = 0;

    /* renamed from: k0 */
    private static final int f8830k0 = 1;

    /* renamed from: l0 */
    private static final int f8831l0 = 2;

    /* renamed from: m0 */
    private static int f8832m0 = 1;

    /* renamed from: B */
    private float f8834B;

    /* renamed from: C */
    public boolean f8835C;

    /* renamed from: D */
    public boolean f8836D;

    /* renamed from: E */
    public boolean f8837E;

    /* renamed from: G */
    public boolean f8839G;

    /* renamed from: H */
    public boolean f8840H;

    /* renamed from: M */
    float f8845M;

    /* renamed from: N */
    float f8846N;

    /* renamed from: h */
    private ImageView f8854h;

    /* renamed from: i */
    private GestureDetector f8855i;

    /* renamed from: j */
    private C2830b f8856j;

    /* renamed from: p */
    private InterfaceC2832d f8862p;

    /* renamed from: q */
    private InterfaceC2834f f8863q;

    /* renamed from: r */
    private InterfaceC2833e f8864r;

    /* renamed from: s */
    private InterfaceC2838j f8865s;

    /* renamed from: t */
    private View.OnClickListener f8866t;

    /* renamed from: u */
    private View.OnLongClickListener f8867u;

    /* renamed from: v */
    private InterfaceC2835g f8868v;

    /* renamed from: w */
    private InterfaceC2836h f8869w;

    /* renamed from: x */
    private InterfaceC2837i f8870x;

    /* renamed from: y */
    private f f8871y;

    /* renamed from: a */
    private Interpolator f8847a = new AccelerateDecelerateInterpolator();

    /* renamed from: b */
    private int f8848b = f8823d0;

    /* renamed from: c */
    private float f8849c = f8822c0;

    /* renamed from: d */
    private float f8850d = f8821b0;

    /* renamed from: e */
    private float f8851e = f8820O;

    /* renamed from: f */
    private boolean f8852f = true;

    /* renamed from: g */
    private boolean f8853g = false;

    /* renamed from: k */
    private final Matrix f8857k = new Matrix();

    /* renamed from: l */
    private final Matrix f8858l = new Matrix();

    /* renamed from: m */
    private final Matrix f8859m = new Matrix();

    /* renamed from: n */
    private final RectF f8860n = new RectF();

    /* renamed from: o */
    private final float[] f8861o = new float[9];

    /* renamed from: z */
    private int f8872z = 2;

    /* renamed from: A */
    private int f8833A = 2;

    /* renamed from: F */
    public boolean f8838F = false;

    /* renamed from: I */
    private boolean f8841I = true;

    /* renamed from: J */
    private boolean f8842J = false;

    /* renamed from: K */
    private ImageView.ScaleType f8843K = ImageView.ScaleType.FIT_CENTER;

    /* renamed from: L */
    private InterfaceC2831c f8844L = new a();

    /* compiled from: PhotoViewAttacher.java */
    /* renamed from: com.lxj.xpopup.photoview.k$a */
    class a implements InterfaceC2831c {
        a() {
        }

        @Override // com.lxj.xpopup.photoview.InterfaceC2831c
        public void onDrag(float f2, float f3) {
            if (ViewOnTouchListenerC2839k.this.f8856j.m8512b()) {
                return;
            }
            if (ViewOnTouchListenerC2839k.this.f8870x != null) {
                ViewOnTouchListenerC2839k.this.f8870x.onDrag(f2, f3);
            }
            ViewOnTouchListenerC2839k.this.f8859m.postTranslate(f2, f3);
            ViewOnTouchListenerC2839k.this.m8538n();
            ViewOnTouchListenerC2839k viewOnTouchListenerC2839k = ViewOnTouchListenerC2839k.this;
            viewOnTouchListenerC2839k.f8835C = viewOnTouchListenerC2839k.f8833A == 0 && ViewOnTouchListenerC2839k.this.m8572f() != 1.0f;
            ViewOnTouchListenerC2839k viewOnTouchListenerC2839k2 = ViewOnTouchListenerC2839k.this;
            viewOnTouchListenerC2839k2.f8836D = viewOnTouchListenerC2839k2.f8833A == 1 && ViewOnTouchListenerC2839k.this.m8572f() != 1.0f;
            ViewOnTouchListenerC2839k viewOnTouchListenerC2839k3 = ViewOnTouchListenerC2839k.this;
            viewOnTouchListenerC2839k3.f8837E = viewOnTouchListenerC2839k3.f8872z == 0 && ViewOnTouchListenerC2839k.this.m8572f() != 1.0f;
            ViewOnTouchListenerC2839k viewOnTouchListenerC2839k4 = ViewOnTouchListenerC2839k.this;
            viewOnTouchListenerC2839k4.f8838F = viewOnTouchListenerC2839k4.f8872z == 1 && ViewOnTouchListenerC2839k.this.m8572f() != 1.0f;
            ViewParent parent = ViewOnTouchListenerC2839k.this.f8854h.getParent();
            if (parent == null) {
                return;
            }
            if (!ViewOnTouchListenerC2839k.this.f8852f || ViewOnTouchListenerC2839k.this.f8856j.m8512b() || ViewOnTouchListenerC2839k.this.f8853g) {
                if (ViewOnTouchListenerC2839k.this.f8872z == 2 && ViewOnTouchListenerC2839k.this.f8842J && ViewOnTouchListenerC2839k.this.f8840H) {
                    parent.requestDisallowInterceptTouchEvent(false);
                    return;
                } else {
                    parent.requestDisallowInterceptTouchEvent(true);
                    return;
                }
            }
            if ((ViewOnTouchListenerC2839k.this.f8872z == 2 && !ViewOnTouchListenerC2839k.this.f8842J) || ((ViewOnTouchListenerC2839k.this.f8872z == 0 && f2 >= 0.0f && ViewOnTouchListenerC2839k.this.f8840H) || (ViewOnTouchListenerC2839k.this.f8872z == 1 && f2 <= -0.0f && ViewOnTouchListenerC2839k.this.f8840H))) {
                parent.requestDisallowInterceptTouchEvent(false);
                return;
            }
            if (ViewOnTouchListenerC2839k.this.f8833A != 2 || !ViewOnTouchListenerC2839k.this.f8839G) {
                ViewOnTouchListenerC2839k viewOnTouchListenerC2839k5 = ViewOnTouchListenerC2839k.this;
                if (!viewOnTouchListenerC2839k5.f8835C || f3 <= 0.0f || !viewOnTouchListenerC2839k5.f8839G) {
                    ViewOnTouchListenerC2839k viewOnTouchListenerC2839k6 = ViewOnTouchListenerC2839k.this;
                    if (!viewOnTouchListenerC2839k6.f8836D || f3 >= 0.0f || !viewOnTouchListenerC2839k6.f8839G) {
                        if (ViewOnTouchListenerC2839k.this.f8842J) {
                            if ((ViewOnTouchListenerC2839k.this.f8833A == 0 && f3 > 0.0f && ViewOnTouchListenerC2839k.this.f8839G) || (ViewOnTouchListenerC2839k.this.f8833A == 1 && f3 < 0.0f && ViewOnTouchListenerC2839k.this.f8839G)) {
                                parent.requestDisallowInterceptTouchEvent(false);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            parent.requestDisallowInterceptTouchEvent(false);
        }

        @Override // com.lxj.xpopup.photoview.InterfaceC2831c
        public void onFling(float f2, float f3, float f4, float f5) {
            ViewOnTouchListenerC2839k viewOnTouchListenerC2839k = ViewOnTouchListenerC2839k.this;
            viewOnTouchListenerC2839k.f8871y = viewOnTouchListenerC2839k.new f(viewOnTouchListenerC2839k.f8854h.getContext());
            f fVar = ViewOnTouchListenerC2839k.this.f8871y;
            ViewOnTouchListenerC2839k viewOnTouchListenerC2839k2 = ViewOnTouchListenerC2839k.this;
            int m8518b = viewOnTouchListenerC2839k2.m8518b(viewOnTouchListenerC2839k2.f8854h);
            ViewOnTouchListenerC2839k viewOnTouchListenerC2839k3 = ViewOnTouchListenerC2839k.this;
            fVar.m8581a(m8518b, viewOnTouchListenerC2839k3.m8513a(viewOnTouchListenerC2839k3.f8854h), (int) f4, (int) f5);
            ViewOnTouchListenerC2839k.this.f8854h.post(ViewOnTouchListenerC2839k.this.f8871y);
        }

        @Override // com.lxj.xpopup.photoview.InterfaceC2831c
        public void onScale(float f2, float f3, float f4) {
            if (ViewOnTouchListenerC2839k.this.m8572f() < ViewOnTouchListenerC2839k.this.f8851e || f2 < 1.0f) {
                if (ViewOnTouchListenerC2839k.this.f8868v != null) {
                    ViewOnTouchListenerC2839k.this.f8868v.onScaleChange(f2, f3, f4);
                }
                ViewOnTouchListenerC2839k.this.f8859m.postScale(f2, f2, f3, f4);
                ViewOnTouchListenerC2839k.this.m8538n();
            }
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    /* renamed from: com.lxj.xpopup.photoview.k$b */
    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (ViewOnTouchListenerC2839k.this.f8869w == null || ViewOnTouchListenerC2839k.this.m8572f() > ViewOnTouchListenerC2839k.f8822c0 || motionEvent.getPointerCount() > ViewOnTouchListenerC2839k.f8832m0 || motionEvent2.getPointerCount() > ViewOnTouchListenerC2839k.f8832m0) {
                return false;
            }
            return ViewOnTouchListenerC2839k.this.f8869w.onFling(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (ViewOnTouchListenerC2839k.this.f8867u != null) {
                ViewOnTouchListenerC2839k.this.f8867u.onLongClick(ViewOnTouchListenerC2839k.this.f8854h);
            }
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    /* renamed from: com.lxj.xpopup.photoview.k$c */
    class c implements GestureDetector.OnDoubleTapListener {
        c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float m8572f = ViewOnTouchListenerC2839k.this.m8572f();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (m8572f < ViewOnTouchListenerC2839k.this.m8568d()) {
                    ViewOnTouchListenerC2839k.this.m8554a(ViewOnTouchListenerC2839k.this.m8568d(), x, y, true);
                } else if (m8572f < ViewOnTouchListenerC2839k.this.m8568d() || m8572f >= ViewOnTouchListenerC2839k.this.m8565c()) {
                    ViewOnTouchListenerC2839k.this.m8554a(ViewOnTouchListenerC2839k.this.m8570e(), x, y, true);
                } else {
                    ViewOnTouchListenerC2839k.this.m8554a(ViewOnTouchListenerC2839k.this.m8565c(), x, y, true);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (ViewOnTouchListenerC2839k.this.f8866t != null) {
                ViewOnTouchListenerC2839k.this.f8866t.onClick(ViewOnTouchListenerC2839k.this.f8854h);
            }
            RectF m8551a = ViewOnTouchListenerC2839k.this.m8551a();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (ViewOnTouchListenerC2839k.this.f8865s != null) {
                ViewOnTouchListenerC2839k.this.f8865s.onViewTap(ViewOnTouchListenerC2839k.this.f8854h, x, y);
            }
            if (m8551a == null) {
                return false;
            }
            if (!m8551a.contains(x, y)) {
                if (ViewOnTouchListenerC2839k.this.f8864r == null) {
                    return false;
                }
                ViewOnTouchListenerC2839k.this.f8864r.onOutsidePhotoTap(ViewOnTouchListenerC2839k.this.f8854h);
                return false;
            }
            float width = (x - m8551a.left) / m8551a.width();
            float height = (y - m8551a.top) / m8551a.height();
            if (ViewOnTouchListenerC2839k.this.f8863q == null) {
                return true;
            }
            ViewOnTouchListenerC2839k.this.f8863q.onPhotoTap(ViewOnTouchListenerC2839k.this.f8854h, width, height);
            return true;
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    /* renamed from: com.lxj.xpopup.photoview.k$d */
    static /* synthetic */ class d {

        /* renamed from: a */
        static final /* synthetic */ int[] f8876a = new int[ImageView.ScaleType.values().length];

        static {
            try {
                f8876a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8876a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8876a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8876a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    /* renamed from: com.lxj.xpopup.photoview.k$e */
    private class e implements Runnable {

        /* renamed from: a */
        private final float f8877a;

        /* renamed from: b */
        private final float f8878b;

        /* renamed from: c */
        private final long f8879c = System.currentTimeMillis();

        /* renamed from: d */
        private final float f8880d;

        /* renamed from: e */
        private final float f8881e;

        public e(float f2, float f3, float f4, float f5) {
            this.f8877a = f4;
            this.f8878b = f5;
            this.f8880d = f2;
            this.f8881e = f3;
        }

        /* renamed from: a */
        private float m8579a() {
            return ViewOnTouchListenerC2839k.this.f8847a.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.f8879c) * 1.0f) / ViewOnTouchListenerC2839k.this.f8848b));
        }

        @Override // java.lang.Runnable
        public void run() {
            float m8579a = m8579a();
            float f2 = this.f8880d;
            ViewOnTouchListenerC2839k.this.f8844L.onScale((f2 + ((this.f8881e - f2) * m8579a)) / ViewOnTouchListenerC2839k.this.m8572f(), this.f8877a, this.f8878b);
            if (m8579a < 1.0f) {
                C2829a.m8504a(ViewOnTouchListenerC2839k.this.f8854h, this);
            }
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    /* renamed from: com.lxj.xpopup.photoview.k$f */
    private class f implements Runnable {

        /* renamed from: a */
        private final OverScroller f8883a;

        /* renamed from: b */
        private int f8884b;

        /* renamed from: c */
        private int f8885c;

        public f(Context context) {
            this.f8883a = new OverScroller(context);
        }

        /* renamed from: a */
        public void m8580a() {
            this.f8883a.forceFinished(true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f8883a.isFinished() && this.f8883a.computeScrollOffset()) {
                int currX = this.f8883a.getCurrX();
                int currY = this.f8883a.getCurrY();
                ViewOnTouchListenerC2839k.this.f8859m.postTranslate(this.f8884b - currX, this.f8885c - currY);
                ViewOnTouchListenerC2839k.this.m8538n();
                this.f8884b = currX;
                this.f8885c = currY;
                C2829a.m8504a(ViewOnTouchListenerC2839k.this.f8854h, this);
            }
        }

        /* renamed from: a */
        public void m8581a(int i2, int i3, int i4, int i5) {
            int i6;
            int i7;
            int i8;
            int i9;
            RectF m8551a = ViewOnTouchListenerC2839k.this.m8551a();
            if (m8551a == null) {
                return;
            }
            int round = Math.round(-m8551a.left);
            float f2 = i2;
            if (f2 < m8551a.width()) {
                i7 = Math.round(m8551a.width() - f2);
                i6 = 0;
            } else {
                i6 = round;
                i7 = i6;
            }
            int round2 = Math.round(-m8551a.top);
            float f3 = i3;
            if (f3 < m8551a.height()) {
                i9 = Math.round(m8551a.height() - f3);
                i8 = 0;
            } else {
                i8 = round2;
                i9 = i8;
            }
            this.f8884b = round;
            this.f8885c = round2;
            if (round == i7 && round2 == i9) {
                return;
            }
            this.f8883a.fling(round, round2, i4, i5, i6, i7, i8, i9, 0, 0);
        }
    }

    public ViewOnTouchListenerC2839k(ImageView imageView) {
        this.f8854h = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.f8834B = 0.0f;
        this.f8856j = new C2830b(imageView.getContext(), this.f8844L);
        this.f8855i = new GestureDetector(imageView.getContext(), new b());
        this.f8855i.setOnDoubleTapListener(new c());
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i2 == i6 && i3 == i7 && i4 == i8 && i5 == i9) {
            return;
        }
        m8517a(this.f8854h.getDrawable());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        if (r0 != 3) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0120  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lxj.xpopup.photoview.ViewOnTouchListenerC2839k.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f8866t = onClickListener;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f8855i.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f8867u = onLongClickListener;
    }

    public void setOnMatrixChangeListener(InterfaceC2832d interfaceC2832d) {
        this.f8862p = interfaceC2832d;
    }

    public void setOnOutsidePhotoTapListener(InterfaceC2833e interfaceC2833e) {
        this.f8864r = interfaceC2833e;
    }

    public void setOnPhotoTapListener(InterfaceC2834f interfaceC2834f) {
        this.f8863q = interfaceC2834f;
    }

    public void setOnScaleChangeListener(InterfaceC2835g interfaceC2835g) {
        this.f8868v = interfaceC2835g;
    }

    public void setOnSingleFlingListener(InterfaceC2836h interfaceC2836h) {
        this.f8869w = interfaceC2836h;
    }

    public void setOnViewDragListener(InterfaceC2837i interfaceC2837i) {
        this.f8870x = interfaceC2837i;
    }

    public void setOnViewTapListener(InterfaceC2838j interfaceC2838j) {
        this.f8865s = interfaceC2838j;
    }

    /* renamed from: m */
    private void m8536m() {
        f fVar = this.f8871y;
        if (fVar != null) {
            fVar.m8580a();
            this.f8871y = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m8538n() {
        if (m8540o()) {
            m8525e(m8541p());
        }
    }

    /* renamed from: o */
    private boolean m8540o() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        RectF m8523d = m8523d(m8541p());
        if (m8523d == null) {
            return false;
        }
        float height = m8523d.height();
        float width = m8523d.width();
        float m8513a = m8513a(this.f8854h);
        float f8 = 0.0f;
        if (height > m8513a || m8523d.top < 0.0f) {
            float f9 = m8523d.top;
            if (f9 >= 0.0f) {
                this.f8833A = 0;
                f2 = -f9;
            } else {
                float f10 = m8523d.bottom;
                if (f10 <= m8513a) {
                    this.f8833A = 1;
                    f2 = m8513a - f10;
                } else {
                    this.f8833A = -1;
                    f2 = 0.0f;
                }
            }
        } else {
            int i2 = d.f8876a[this.f8843K.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f6 = (m8513a - height) / 2.0f;
                    f7 = m8523d.top;
                } else {
                    f6 = m8513a - height;
                    f7 = m8523d.top;
                }
                f5 = f6 - f7;
            } else {
                f5 = -m8523d.top;
            }
            this.f8833A = 2;
            f2 = f5;
        }
        float m8518b = m8518b(this.f8854h);
        if (width > m8518b || m8523d.left < 0.0f) {
            float f11 = m8523d.left;
            if (f11 >= 0.0f) {
                this.f8872z = 0;
                f8 = -f11;
            } else {
                float f12 = m8523d.right;
                if (f12 <= m8518b) {
                    f8 = m8518b - f12;
                    this.f8872z = 1;
                } else {
                    this.f8872z = -1;
                }
            }
        } else {
            int i3 = d.f8876a[this.f8843K.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    f3 = (m8518b - width) / 2.0f;
                    f4 = m8523d.left;
                } else {
                    f3 = m8518b - width;
                    f4 = m8523d.left;
                }
                f8 = f3 - f4;
            } else {
                f8 = -m8523d.left;
            }
            this.f8872z = 2;
        }
        this.f8859m.postTranslate(f8, f2);
        return true;
    }

    /* renamed from: p */
    private Matrix m8541p() {
        this.f8858l.set(this.f8857k);
        this.f8858l.postConcat(this.f8859m);
        return this.f8858l;
    }

    /* renamed from: q */
    private void m8544q() {
        this.f8859m.reset();
        m8571e(this.f8834B);
        m8525e(m8541p());
        m8540o();
    }

    /* renamed from: c */
    public boolean m8567c(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        if (this.f8854h.getDrawable() == null) {
            return false;
        }
        this.f8859m.set(matrix);
        m8538n();
        return true;
    }

    /* renamed from: d */
    public float m8568d() {
        return this.f8850d;
    }

    /* renamed from: e */
    public void m8571e(float f2) {
        this.f8859m.postRotate(f2 % 360.0f);
        m8538n();
    }

    /* renamed from: f */
    public void m8573f(float f2) {
        this.f8859m.setRotate(f2 % 360.0f);
        m8538n();
    }

    /* renamed from: g */
    public ImageView.ScaleType m8574g() {
        return this.f8843K;
    }

    @Deprecated
    /* renamed from: h */
    public boolean m8576h() {
        return this.f8841I;
    }

    /* renamed from: i */
    public boolean m8577i() {
        return this.f8841I;
    }

    /* renamed from: j */
    public void m8578j() {
        if (this.f8841I) {
            m8517a(this.f8854h.getDrawable());
        } else {
            m8544q();
        }
    }

    /* renamed from: b */
    public void m8562b(float f2) {
        C2840l.m8583a(this.f8849c, this.f8850d, f2);
        this.f8851e = f2;
    }

    /* renamed from: d */
    public void m8569d(float f2) {
        C2840l.m8583a(f2, this.f8850d, this.f8851e);
        this.f8849c = f2;
    }

    /* renamed from: g */
    public void m8575g(float f2) {
        m8555a(f2, false);
    }

    /* renamed from: a */
    public RectF m8551a() {
        m8540o();
        return m8523d(m8541p());
    }

    /* renamed from: e */
    public float m8570e() {
        return this.f8849c;
    }

    /* renamed from: f */
    public float m8572f() {
        return (float) Math.sqrt(((float) Math.pow(m8550a(this.f8859m, 0), 2.0d)) + ((float) Math.pow(m8550a(this.f8859m, 3), 2.0d)));
    }

    /* renamed from: d */
    private RectF m8523d(Matrix matrix) {
        if (this.f8854h.getDrawable() == null) {
            return null;
        }
        this.f8860n.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.f8860n);
        return this.f8860n;
    }

    /* renamed from: e */
    private void m8525e(Matrix matrix) {
        RectF m8523d;
        this.f8854h.setImageMatrix(matrix);
        if (this.f8862p == null || (m8523d = m8523d(matrix)) == null) {
            return;
        }
        this.f8862p.onMatrixChanged(m8523d);
    }

    /* renamed from: b */
    public void m8564b(boolean z) {
        this.f8841I = z;
        m8578j();
    }

    /* renamed from: a */
    public void m8552a(float f2) {
        this.f8834B = f2 % 360.0f;
        m8578j();
        m8571e(this.f8834B);
        m8538n();
    }

    /* renamed from: c */
    public float m8565c() {
        return this.f8851e;
    }

    /* renamed from: b */
    public void m8563b(Matrix matrix) {
        matrix.set(this.f8859m);
    }

    /* renamed from: c */
    public void m8566c(float f2) {
        C2840l.m8583a(this.f8849c, f2, this.f8851e);
        this.f8850d = f2;
    }

    /* renamed from: b */
    public Matrix m8561b() {
        return this.f8858l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public int m8518b(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    /* renamed from: a */
    public void m8560a(boolean z) {
        this.f8852f = z;
    }

    /* renamed from: a */
    public void m8553a(float f2, float f3, float f4) {
        C2840l.m8583a(f2, f3, f4);
        this.f8849c = f2;
        this.f8850d = f3;
        this.f8851e = f4;
    }

    /* renamed from: a */
    public void m8555a(float f2, boolean z) {
        m8554a(f2, this.f8854h.getRight() / 2, this.f8854h.getBottom() / 2, z);
    }

    /* renamed from: a */
    public void m8554a(float f2, float f3, float f4, boolean z) {
        if (z) {
            this.f8854h.post(new e(m8572f(), f2, f3, f4));
        } else {
            this.f8859m.setScale(f2, f2, f3, f4);
            m8538n();
        }
    }

    /* renamed from: a */
    public void m8558a(Interpolator interpolator) {
        this.f8847a = interpolator;
    }

    /* renamed from: a */
    public void m8559a(ImageView.ScaleType scaleType) {
        if (!C2840l.m8584a(scaleType) || scaleType == this.f8843K) {
            return;
        }
        this.f8843K = scaleType;
        m8578j();
    }

    /* renamed from: a */
    public void m8557a(Matrix matrix) {
        matrix.set(m8541p());
    }

    /* renamed from: a */
    public void m8556a(int i2) {
        this.f8848b = i2;
    }

    /* renamed from: a */
    public float m8550a(Matrix matrix, int i2) {
        matrix.getValues(this.f8861o);
        return this.f8861o[i2];
    }

    /* renamed from: a */
    private void m8517a(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float m8518b = m8518b(this.f8854h);
        float m8513a = m8513a(this.f8854h);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f8857k.reset();
        float f2 = intrinsicWidth;
        float f3 = m8518b / f2;
        float f4 = intrinsicHeight;
        float f5 = m8513a / f4;
        ImageView.ScaleType scaleType = this.f8843K;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.f8857k.postTranslate((m8518b - f2) / 2.0f, (m8513a - f4) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f3, f5);
            this.f8857k.postScale(max, max);
            this.f8857k.postTranslate((m8518b - (f2 * max)) / 2.0f, (m8513a - (f4 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f3, f5));
            this.f8857k.postScale(min, min);
            this.f8857k.postTranslate((m8518b - (f2 * min)) / 2.0f, (m8513a - (f4 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
            RectF rectF2 = new RectF(0.0f, 0.0f, m8518b, m8513a);
            if (((int) this.f8834B) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f4, f2);
            }
            int i2 = d.f8876a[this.f8843K.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    this.f8857k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                } else if (i2 == 3) {
                    this.f8857k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                } else if (i2 == 4) {
                    this.f8857k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                }
            } else if (f4 > m8513a && (f4 * 1.0f) / f2 > (m8513a * 1.0f) / m8518b) {
                this.f8842J = true;
                this.f8857k.setRectToRect(rectF, new RectF(0.0f, 0.0f, m8518b, f4 * f3), Matrix.ScaleToFit.START);
            } else {
                this.f8857k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            }
        }
        m8544q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m8513a(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }
}
