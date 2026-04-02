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

/* JADX INFO: compiled from: PhotoViewAttacher.java */
/* JADX INFO: loaded from: classes2.dex */
public class k implements View.OnTouchListener, View.OnLayoutChangeListener {
    private static float O = 4.0f;
    private static float b0 = 2.5f;
    private static float c0 = 1.0f;
    private static int d0 = 200;
    private static final int e0 = -1;
    private static final int f0 = 0;
    private static final int g0 = 1;
    private static final int h0 = 2;
    private static final int i0 = -1;
    private static final int j0 = 0;
    private static final int k0 = 1;
    private static final int l0 = 2;
    private static int m0 = 1;
    private float B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean G;
    public boolean H;
    float M;
    float N;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f5497h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private GestureDetector f5498i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.lxj.xpopup.photoview.b f5499j;
    private com.lxj.xpopup.photoview.d p;
    private com.lxj.xpopup.photoview.f q;
    private com.lxj.xpopup.photoview.e r;
    private j s;
    private View.OnClickListener t;
    private View.OnLongClickListener u;
    private g v;
    private h w;
    private i x;
    private f y;
    private Interpolator a = new AccelerateDecelerateInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5491b = d0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f5492c = c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f5493d = b0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f5494e = O;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5495f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f5496g = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Matrix f5500k = new Matrix();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Matrix f5501l = new Matrix();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Matrix f5502m = new Matrix();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final RectF f5503n = new RectF();
    private final float[] o = new float[9];
    private int z = 2;
    private int A = 2;
    public boolean F = false;
    private boolean I = true;
    private boolean J = false;
    private ImageView.ScaleType K = ImageView.ScaleType.FIT_CENTER;
    private com.lxj.xpopup.photoview.c L = new a();

    /* JADX INFO: compiled from: PhotoViewAttacher.java */
    class a implements com.lxj.xpopup.photoview.c {
        a() {
        }

        @Override // com.lxj.xpopup.photoview.c
        public void onDrag(float f2, float f3) {
            if (k.this.f5499j.b()) {
                return;
            }
            if (k.this.x != null) {
                k.this.x.onDrag(f2, f3);
            }
            k.this.f5502m.postTranslate(f2, f3);
            k.this.n();
            k kVar = k.this;
            kVar.C = kVar.A == 0 && k.this.f() != 1.0f;
            k kVar2 = k.this;
            kVar2.D = kVar2.A == 1 && k.this.f() != 1.0f;
            k kVar3 = k.this;
            kVar3.E = kVar3.z == 0 && k.this.f() != 1.0f;
            k kVar4 = k.this;
            kVar4.F = kVar4.z == 1 && k.this.f() != 1.0f;
            ViewParent parent = k.this.f5497h.getParent();
            if (parent == null) {
                return;
            }
            if (!k.this.f5495f || k.this.f5499j.b() || k.this.f5496g) {
                if (k.this.z == 2 && k.this.J && k.this.H) {
                    parent.requestDisallowInterceptTouchEvent(false);
                    return;
                } else {
                    parent.requestDisallowInterceptTouchEvent(true);
                    return;
                }
            }
            if ((k.this.z == 2 && !k.this.J) || ((k.this.z == 0 && f2 >= 0.0f && k.this.H) || (k.this.z == 1 && f2 <= -0.0f && k.this.H))) {
                parent.requestDisallowInterceptTouchEvent(false);
                return;
            }
            if (k.this.A != 2 || !k.this.G) {
                k kVar5 = k.this;
                if (!kVar5.C || f3 <= 0.0f || !kVar5.G) {
                    k kVar6 = k.this;
                    if (!kVar6.D || f3 >= 0.0f || !kVar6.G) {
                        if (k.this.J) {
                            if ((k.this.A == 0 && f3 > 0.0f && k.this.G) || (k.this.A == 1 && f3 < 0.0f && k.this.G)) {
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

        @Override // com.lxj.xpopup.photoview.c
        public void onFling(float f2, float f3, float f4, float f5) {
            k kVar = k.this;
            kVar.y = kVar.new f(kVar.f5497h.getContext());
            f fVar = k.this.y;
            k kVar2 = k.this;
            int iB = kVar2.b(kVar2.f5497h);
            k kVar3 = k.this;
            fVar.a(iB, kVar3.a(kVar3.f5497h), (int) f4, (int) f5);
            k.this.f5497h.post(k.this.y);
        }

        @Override // com.lxj.xpopup.photoview.c
        public void onScale(float f2, float f3, float f4) {
            if (k.this.f() < k.this.f5494e || f2 < 1.0f) {
                if (k.this.v != null) {
                    k.this.v.onScaleChange(f2, f3, f4);
                }
                k.this.f5502m.postScale(f2, f2, f3, f4);
                k.this.n();
            }
        }
    }

    /* JADX INFO: compiled from: PhotoViewAttacher.java */
    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (k.this.w == null || k.this.f() > k.c0 || motionEvent.getPointerCount() > k.m0 || motionEvent2.getPointerCount() > k.m0) {
                return false;
            }
            return k.this.w.onFling(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (k.this.u != null) {
                k.this.u.onLongClick(k.this.f5497h);
            }
        }
    }

    /* JADX INFO: compiled from: PhotoViewAttacher.java */
    class c implements GestureDetector.OnDoubleTapListener {
        c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float f2 = k.this.f();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (f2 < k.this.d()) {
                    k.this.a(k.this.d(), x, y, true);
                } else if (f2 < k.this.d() || f2 >= k.this.c()) {
                    k.this.a(k.this.e(), x, y, true);
                } else {
                    k.this.a(k.this.c(), x, y, true);
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
            if (k.this.t != null) {
                k.this.t.onClick(k.this.f5497h);
            }
            RectF rectFA = k.this.a();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (k.this.s != null) {
                k.this.s.onViewTap(k.this.f5497h, x, y);
            }
            if (rectFA == null) {
                return false;
            }
            if (!rectFA.contains(x, y)) {
                if (k.this.r == null) {
                    return false;
                }
                k.this.r.onOutsidePhotoTap(k.this.f5497h);
                return false;
            }
            float fWidth = (x - rectFA.left) / rectFA.width();
            float fHeight = (y - rectFA.top) / rectFA.height();
            if (k.this.q == null) {
                return true;
            }
            k.this.q.onPhotoTap(k.this.f5497h, fWidth, fHeight);
            return true;
        }
    }

    /* JADX INFO: compiled from: PhotoViewAttacher.java */
    static /* synthetic */ class d {
        static final /* synthetic */ int[] a = new int[ImageView.ScaleType.values().length];

        static {
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: PhotoViewAttacher.java */
    private class e implements Runnable {
        private final float a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f5504b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f5505c = System.currentTimeMillis();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f5506d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f5507e;

        public e(float f2, float f3, float f4, float f5) {
            this.a = f4;
            this.f5504b = f5;
            this.f5506d = f2;
            this.f5507e = f3;
        }

        private float a() {
            return k.this.a.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.f5505c) * 1.0f) / k.this.f5491b));
        }

        @Override // java.lang.Runnable
        public void run() {
            float fA = a();
            float f2 = this.f5506d;
            k.this.L.onScale((f2 + ((this.f5507e - f2) * fA)) / k.this.f(), this.a, this.f5504b);
            if (fA < 1.0f) {
                com.lxj.xpopup.photoview.a.a(k.this.f5497h, this);
            }
        }
    }

    /* JADX INFO: compiled from: PhotoViewAttacher.java */
    private class f implements Runnable {
        private final OverScroller a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5509b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f5510c;

        public f(Context context) {
            this.a = new OverScroller(context);
        }

        public void a() {
            this.a.forceFinished(true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.a.isFinished() && this.a.computeScrollOffset()) {
                int currX = this.a.getCurrX();
                int currY = this.a.getCurrY();
                k.this.f5502m.postTranslate(this.f5509b - currX, this.f5510c - currY);
                k.this.n();
                this.f5509b = currX;
                this.f5510c = currY;
                com.lxj.xpopup.photoview.a.a(k.this.f5497h, this);
            }
        }

        public void a(int i2, int i3, int i4, int i5) {
            int i6;
            int iRound;
            int i7;
            int iRound2;
            RectF rectFA = k.this.a();
            if (rectFA == null) {
                return;
            }
            int iRound3 = Math.round(-rectFA.left);
            float f2 = i2;
            if (f2 < rectFA.width()) {
                iRound = Math.round(rectFA.width() - f2);
                i6 = 0;
            } else {
                i6 = iRound3;
                iRound = i6;
            }
            int iRound4 = Math.round(-rectFA.top);
            float f3 = i3;
            if (f3 < rectFA.height()) {
                iRound2 = Math.round(rectFA.height() - f3);
                i7 = 0;
            } else {
                i7 = iRound4;
                iRound2 = i7;
            }
            this.f5509b = iRound3;
            this.f5510c = iRound4;
            if (iRound3 == iRound && iRound4 == iRound2) {
                return;
            }
            this.a.fling(iRound3, iRound4, i4, i5, i6, iRound, i7, iRound2, 0, 0);
        }
    }

    public k(ImageView imageView) {
        this.f5497h = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.B = 0.0f;
        this.f5499j = new com.lxj.xpopup.photoview.b(imageView.getContext(), this.L);
        this.f5498i = new GestureDetector(imageView.getContext(), new b());
        this.f5498i.setOnDoubleTapListener(new c());
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i2 == i6 && i3 == i7 && i4 == i8 && i5 == i9) {
            return;
        }
        a(this.f5497h.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0120  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        com.lxj.xpopup.photoview.b bVar;
        boolean z2;
        GestureDetector gestureDetector;
        RectF rectFA;
        boolean z3 = false;
        if (!this.I || !l.a((ImageView) view)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.C = false;
                if (f() < this.f5492c) {
                    RectF rectFA2 = a();
                    if (rectFA2 != null) {
                        view.post(new e(f(), this.f5492c, rectFA2.centerX(), rectFA2.centerY()));
                        z = true;
                    }
                } else if (f() > this.f5494e && (rectFA = a()) != null) {
                    view.post(new e(f(), this.f5494e, rectFA.centerX(), rectFA.centerY()));
                    z = true;
                }
            } else if (action == 2) {
                float fAbs = Math.abs(motionEvent.getX() - this.M);
                float fAbs2 = Math.abs(motionEvent.getY() - this.N);
                if (this.J) {
                    this.G = fAbs2 > fAbs;
                    this.H = fAbs > fAbs2 * 2.0f;
                } else {
                    this.G = ((double) f()) != 1.0d && fAbs2 > fAbs;
                    this.H = ((double) f()) != 1.0d && fAbs > fAbs2 * 2.0f;
                }
            } else if (action != 3) {
            }
            bVar = this.f5499j;
            if (bVar == null) {
                boolean zB = bVar.b();
                boolean zA = this.f5499j.a();
                boolean zA2 = this.f5499j.a(motionEvent);
                boolean z4 = (zB || this.f5499j.b()) ? false : true;
                boolean z5 = (zA || this.f5499j.a()) ? false : true;
                if (z4 && z5) {
                    z3 = true;
                }
                this.f5496g = z3;
                z2 = zA2;
            } else {
                z2 = z;
            }
            gestureDetector = this.f5498i;
            if (gestureDetector == null && gestureDetector.onTouchEvent(motionEvent)) {
                return true;
            }
        }
        this.M = motionEvent.getX();
        this.N = motionEvent.getY();
        ViewParent parent = view.getParent();
        m();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        z = false;
        bVar = this.f5499j;
        if (bVar == null) {
        }
        gestureDetector = this.f5498i;
        return gestureDetector == null ? z2 : z2;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.t = onClickListener;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f5498i.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.u = onLongClickListener;
    }

    public void setOnMatrixChangeListener(com.lxj.xpopup.photoview.d dVar) {
        this.p = dVar;
    }

    public void setOnOutsidePhotoTapListener(com.lxj.xpopup.photoview.e eVar) {
        this.r = eVar;
    }

    public void setOnPhotoTapListener(com.lxj.xpopup.photoview.f fVar) {
        this.q = fVar;
    }

    public void setOnScaleChangeListener(g gVar) {
        this.v = gVar;
    }

    public void setOnSingleFlingListener(h hVar) {
        this.w = hVar;
    }

    public void setOnViewDragListener(i iVar) {
        this.x = iVar;
    }

    public void setOnViewTapListener(j jVar) {
        this.s = jVar;
    }

    private void m() {
        f fVar = this.y;
        if (fVar != null) {
            fVar.a();
            this.y = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (o()) {
            e(p());
        }
    }

    private boolean o() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        RectF rectFD = d(p());
        if (rectFD == null) {
            return false;
        }
        float fHeight = rectFD.height();
        float fWidth = rectFD.width();
        float fA = a(this.f5497h);
        float f8 = 0.0f;
        if (fHeight > fA || rectFD.top < 0.0f) {
            float f9 = rectFD.top;
            if (f9 >= 0.0f) {
                this.A = 0;
                f2 = -f9;
            } else {
                float f10 = rectFD.bottom;
                if (f10 <= fA) {
                    this.A = 1;
                    f2 = fA - f10;
                } else {
                    this.A = -1;
                    f2 = 0.0f;
                }
            }
        } else {
            int i2 = d.a[this.K.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f6 = (fA - fHeight) / 2.0f;
                    f7 = rectFD.top;
                } else {
                    f6 = fA - fHeight;
                    f7 = rectFD.top;
                }
                f5 = f6 - f7;
            } else {
                f5 = -rectFD.top;
            }
            this.A = 2;
            f2 = f5;
        }
        float fB = b(this.f5497h);
        if (fWidth > fB || rectFD.left < 0.0f) {
            float f11 = rectFD.left;
            if (f11 >= 0.0f) {
                this.z = 0;
                f8 = -f11;
            } else {
                float f12 = rectFD.right;
                if (f12 <= fB) {
                    f8 = fB - f12;
                    this.z = 1;
                } else {
                    this.z = -1;
                }
            }
        } else {
            int i3 = d.a[this.K.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    f3 = (fB - fWidth) / 2.0f;
                    f4 = rectFD.left;
                } else {
                    f3 = fB - fWidth;
                    f4 = rectFD.left;
                }
                f8 = f3 - f4;
            } else {
                f8 = -rectFD.left;
            }
            this.z = 2;
        }
        this.f5502m.postTranslate(f8, f2);
        return true;
    }

    private Matrix p() {
        this.f5501l.set(this.f5500k);
        this.f5501l.postConcat(this.f5502m);
        return this.f5501l;
    }

    private void q() {
        this.f5502m.reset();
        e(this.B);
        e(p());
        o();
    }

    public boolean c(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        if (this.f5497h.getDrawable() == null) {
            return false;
        }
        this.f5502m.set(matrix);
        n();
        return true;
    }

    public float d() {
        return this.f5493d;
    }

    public void e(float f2) {
        this.f5502m.postRotate(f2 % 360.0f);
        n();
    }

    public void f(float f2) {
        this.f5502m.setRotate(f2 % 360.0f);
        n();
    }

    public ImageView.ScaleType g() {
        return this.K;
    }

    @Deprecated
    public boolean h() {
        return this.I;
    }

    public boolean i() {
        return this.I;
    }

    public void j() {
        if (this.I) {
            a(this.f5497h.getDrawable());
        } else {
            q();
        }
    }

    public void b(float f2) {
        l.a(this.f5492c, this.f5493d, f2);
        this.f5494e = f2;
    }

    public void d(float f2) {
        l.a(f2, this.f5493d, this.f5494e);
        this.f5492c = f2;
    }

    public void g(float f2) {
        a(f2, false);
    }

    public RectF a() {
        o();
        return d(p());
    }

    public float e() {
        return this.f5492c;
    }

    public float f() {
        return (float) Math.sqrt(((float) Math.pow(a(this.f5502m, 0), 2.0d)) + ((float) Math.pow(a(this.f5502m, 3), 2.0d)));
    }

    private RectF d(Matrix matrix) {
        if (this.f5497h.getDrawable() == null) {
            return null;
        }
        this.f5503n.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.f5503n);
        return this.f5503n;
    }

    private void e(Matrix matrix) {
        RectF rectFD;
        this.f5497h.setImageMatrix(matrix);
        if (this.p == null || (rectFD = d(matrix)) == null) {
            return;
        }
        this.p.onMatrixChanged(rectFD);
    }

    public void b(boolean z) {
        this.I = z;
        j();
    }

    public void a(float f2) {
        this.B = f2 % 360.0f;
        j();
        e(this.B);
        n();
    }

    public float c() {
        return this.f5494e;
    }

    public void b(Matrix matrix) {
        matrix.set(this.f5502m);
    }

    public void c(float f2) {
        l.a(this.f5492c, f2, this.f5494e);
        this.f5493d = f2;
    }

    public Matrix b() {
        return this.f5501l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    public void a(boolean z) {
        this.f5495f = z;
    }

    public void a(float f2, float f3, float f4) {
        l.a(f2, f3, f4);
        this.f5492c = f2;
        this.f5493d = f3;
        this.f5494e = f4;
    }

    public void a(float f2, boolean z) {
        a(f2, this.f5497h.getRight() / 2, this.f5497h.getBottom() / 2, z);
    }

    public void a(float f2, float f3, float f4, boolean z) {
        if (z) {
            this.f5497h.post(new e(f(), f2, f3, f4));
        } else {
            this.f5502m.setScale(f2, f2, f3, f4);
            n();
        }
    }

    public void a(Interpolator interpolator) {
        this.a = interpolator;
    }

    public void a(ImageView.ScaleType scaleType) {
        if (!l.a(scaleType) || scaleType == this.K) {
            return;
        }
        this.K = scaleType;
        j();
    }

    public void a(Matrix matrix) {
        matrix.set(p());
    }

    public void a(int i2) {
        this.f5491b = i2;
    }

    public float a(Matrix matrix, int i2) {
        matrix.getValues(this.o);
        return this.o[i2];
    }

    private void a(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float fB = b(this.f5497h);
        float fA = a(this.f5497h);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f5500k.reset();
        float f2 = intrinsicWidth;
        float f3 = fB / f2;
        float f4 = intrinsicHeight;
        float f5 = fA / f4;
        ImageView.ScaleType scaleType = this.K;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.f5500k.postTranslate((fB - f2) / 2.0f, (fA - f4) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(f3, f5);
            this.f5500k.postScale(fMax, fMax);
            this.f5500k.postTranslate((fB - (f2 * fMax)) / 2.0f, (fA - (f4 * fMax)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = Math.min(1.0f, Math.min(f3, f5));
            this.f5500k.postScale(fMin, fMin);
            this.f5500k.postTranslate((fB - (f2 * fMin)) / 2.0f, (fA - (f4 * fMin)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
            RectF rectF2 = new RectF(0.0f, 0.0f, fB, fA);
            if (((int) this.B) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f4, f2);
            }
            int i2 = d.a[this.K.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    this.f5500k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                } else if (i2 == 3) {
                    this.f5500k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                } else if (i2 == 4) {
                    this.f5500k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                }
            } else if (f4 > fA && (f4 * 1.0f) / f2 > (fA * 1.0f) / fB) {
                this.J = true;
                this.f5500k.setRectToRect(rectF, new RectF(0.0f, 0.0f, fB, f4 * f3), Matrix.ScaleToFit.START);
            } else {
                this.f5500k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            }
        }
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }
}
