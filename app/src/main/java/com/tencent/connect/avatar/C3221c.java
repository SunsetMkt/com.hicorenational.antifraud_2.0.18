package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/* compiled from: ProGuard */
/* renamed from: com.tencent.connect.avatar.c */
/* loaded from: classes2.dex */
public class C3221c extends ImageView {

    /* renamed from: a */
    final String f10985a;

    /* renamed from: b */
    public boolean f10986b;

    /* renamed from: c */
    private Matrix f10987c;

    /* renamed from: d */
    private Matrix f10988d;

    /* renamed from: e */
    private int f10989e;

    /* renamed from: f */
    private float f10990f;

    /* renamed from: g */
    private float f10991g;

    /* renamed from: h */
    private Bitmap f10992h;

    /* renamed from: i */
    private boolean f10993i;

    /* renamed from: j */
    private float f10994j;

    /* renamed from: k */
    private float f10995k;

    /* renamed from: l */
    private PointF f10996l;

    /* renamed from: m */
    private PointF f10997m;

    /* renamed from: n */
    private float f10998n;

    /* renamed from: o */
    private float f10999o;

    /* renamed from: p */
    private Rect f11000p;

    public C3221c(Context context) {
        super(context);
        this.f10987c = new Matrix();
        this.f10988d = new Matrix();
        this.f10989e = 0;
        this.f10990f = 1.0f;
        this.f10991g = 1.0f;
        this.f10993i = false;
        this.f10985a = "TouchView";
        this.f10996l = new PointF();
        this.f10997m = new PointF();
        this.f10998n = 1.0f;
        this.f10999o = 0.0f;
        this.f10986b = false;
        this.f11000p = new Rect();
        getDrawingRect(this.f11000p);
        m10297a();
    }

    /* renamed from: a */
    private void m10297a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m10301b() {
        boolean z;
        Animation animation;
        if (this.f10992h == null) {
            return;
        }
        float width = this.f11000p.width();
        float height = this.f11000p.height();
        float[] fArr = new float[9];
        this.f10987c.getValues(fArr);
        float f2 = fArr[2];
        float f3 = fArr[5];
        float f4 = fArr[0];
        TranslateAnimation translateAnimation = null;
        float f5 = this.f10990f;
        if (f4 > f5) {
            this.f10999o = f5 / f4;
            Matrix matrix = this.f10987c;
            float f6 = this.f10999o;
            PointF pointF = this.f10997m;
            matrix.postScale(f6, f6, pointF.x, pointF.y);
            setImageMatrix(this.f10987c);
            float f7 = this.f10999o;
            float f8 = 1.0f / f7;
            float f9 = 1.0f / f7;
            PointF pointF2 = this.f10997m;
            animation = new ScaleAnimation(f8, 1.0f, f9, 1.0f, pointF2.x, pointF2.y);
        } else {
            float f10 = this.f10991g;
            if (f4 < f10) {
                this.f10999o = f10 / f4;
                Matrix matrix2 = this.f10987c;
                float f11 = this.f10999o;
                PointF pointF3 = this.f10997m;
                matrix2.postScale(f11, f11, pointF3.x, pointF3.y);
                float f12 = this.f10999o;
                PointF pointF4 = this.f10997m;
                animation = new ScaleAnimation(1.0f, f12, 1.0f, f12, pointF4.x, pointF4.y);
            } else {
                float width2 = this.f10992h.getWidth() * f4;
                float height2 = this.f10992h.getHeight() * f4;
                int i2 = this.f11000p.left;
                float f13 = i2 - f2;
                float f14 = r9.top - f3;
                if (f13 < 0.0f) {
                    f2 = i2;
                    z = true;
                } else {
                    z = false;
                }
                if (f14 < 0.0f) {
                    f3 = this.f11000p.top;
                    z = true;
                }
                float f15 = height2 - f14;
                if (width2 - f13 < width) {
                    f2 = this.f11000p.left - (width2 - width);
                    z = true;
                }
                if (f15 < height) {
                    f3 = this.f11000p.top - (height2 - height);
                    z = true;
                }
                if (z) {
                    float f16 = fArr[2] - f2;
                    float f17 = fArr[5] - f3;
                    fArr[2] = f2;
                    fArr[5] = f3;
                    this.f10987c.setValues(fArr);
                    setImageMatrix(this.f10987c);
                    translateAnimation = new TranslateAnimation(f16, 0.0f, f17, 0.0f);
                } else {
                    setImageMatrix(this.f10987c);
                }
                animation = translateAnimation;
            }
        }
        if (animation != null) {
            this.f10993i = true;
            animation.setDuration(300L);
            startAnimation(animation);
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    C3221c.this.post(new Runnable() { // from class: com.tencent.connect.avatar.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            C3221c.this.clearAnimation();
                            C3221c.this.m10301b();
                        }
                    });
                    C3221c.this.f10993i = false;
                }
            }).start();
        }
    }

    /* renamed from: c */
    private void m10302c() {
        if (this.f10992h == null) {
            return;
        }
        float[] fArr = {r1, 0.0f, this.f10994j, 0.0f, r1, this.f10995k, 0.0f, 0.0f, 0.0f};
        this.f10987c.getValues(fArr);
        float max = Math.max(this.f11000p.width() / this.f10992h.getWidth(), this.f11000p.height() / this.f10992h.getHeight());
        this.f10994j = this.f11000p.left - (((this.f10992h.getWidth() * max) - this.f11000p.width()) / 2.0f);
        this.f10995k = this.f11000p.top - (((this.f10992h.getHeight() * max) - this.f11000p.height()) / 2.0f);
        this.f10987c.setValues(fArr);
        this.f10990f = Math.min(2048.0f / this.f10992h.getWidth(), 2048.0f / this.f10992h.getHeight());
        this.f10991g = max;
        float f2 = this.f10990f;
        float f3 = this.f10991g;
        if (f2 < f3) {
            this.f10990f = f3;
        }
        setImageMatrix(this.f10987c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
    
        if (r0 != 6) goto L28;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.f10993i
            r1 = 1
            if (r0 == 0) goto L6
            return r1
        L6:
            int r0 = r6.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 == 0) goto L92
            if (r0 == r1) goto L8b
            r2 = 1092616192(0x41200000, float:10.0)
            r3 = 2
            if (r0 == r3) goto L39
            r4 = 5
            if (r0 == r4) goto L1d
            r6 = 6
            if (r0 == r6) goto L8b
            goto Lb1
        L1d:
            float r6 = r5.m10296a(r6)
            r5.f10998n = r6
            float r6 = r5.f10998n
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 <= 0) goto Lb1
            android.graphics.Matrix r6 = r5.f10988d
            android.graphics.Matrix r0 = r5.f10987c
            r6.set(r0)
            android.graphics.PointF r6 = r5.f10997m
            r5.m10298a(r6)
            r5.f10989e = r3
            goto Lb1
        L39:
            int r0 = r5.f10989e
            if (r0 != r1) goto L61
            android.graphics.Matrix r0 = r5.f10987c
            android.graphics.Matrix r2 = r5.f10988d
            r0.set(r2)
            float r0 = r6.getX()
            android.graphics.PointF r2 = r5.f10996l
            float r2 = r2.x
            float r0 = r0 - r2
            float r6 = r6.getY()
            android.graphics.PointF r2 = r5.f10996l
            float r2 = r2.y
            float r6 = r6 - r2
            android.graphics.Matrix r2 = r5.f10987c
            r2.postTranslate(r0, r6)
            android.graphics.Matrix r6 = r5.f10987c
            r5.setImageMatrix(r6)
            goto Lb1
        L61:
            if (r0 != r3) goto Lb1
            android.graphics.Matrix r0 = r5.f10987c
            r0.set(r0)
            float r6 = r5.m10296a(r6)
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 <= 0) goto L85
            android.graphics.Matrix r0 = r5.f10987c
            android.graphics.Matrix r2 = r5.f10988d
            r0.set(r2)
            float r0 = r5.f10998n
            float r6 = r6 / r0
            android.graphics.Matrix r0 = r5.f10987c
            android.graphics.PointF r2 = r5.f10997m
            float r3 = r2.x
            float r2 = r2.y
            r0.postScale(r6, r6, r3, r2)
        L85:
            android.graphics.Matrix r6 = r5.f10987c
            r5.setImageMatrix(r6)
            goto Lb1
        L8b:
            r5.m10301b()
            r6 = 0
            r5.f10989e = r6
            goto Lb1
        L92:
            android.graphics.Matrix r0 = r5.f10987c
            android.graphics.Matrix r2 = r5.getImageMatrix()
            r0.set(r2)
            android.graphics.Matrix r0 = r5.f10988d
            android.graphics.Matrix r2 = r5.f10987c
            r0.set(r2)
            android.graphics.PointF r0 = r5.f10996l
            float r2 = r6.getX()
            float r6 = r6.getY()
            r0.set(r2, r6)
            r5.f10989e = r1
        Lb1:
            r5.f10986b = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.avatar.C3221c.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f10992h = bitmap;
        if (bitmap != null) {
            this.f10992h = bitmap;
        }
    }

    /* renamed from: a */
    private float m10296a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* renamed from: a */
    public void m10303a(Rect rect) {
        this.f11000p = rect;
        if (this.f10992h != null) {
            m10302c();
        }
    }

    /* renamed from: a */
    private void m10298a(PointF pointF) {
        if (this.f10992h == null) {
            return;
        }
        float[] fArr = new float[9];
        this.f10987c.getValues(fArr);
        float f2 = fArr[2];
        float f3 = fArr[5];
        float f4 = fArr[0];
        float width = this.f10992h.getWidth() * f4;
        float height = this.f10992h.getHeight() * f4;
        float f5 = this.f11000p.left - f2;
        if (f5 <= 1.0f) {
            f5 = 1.0f;
        }
        float f6 = (f2 + width) - this.f11000p.right;
        if (f6 <= 1.0f) {
            f6 = 1.0f;
        }
        float width2 = (this.f11000p.width() * f5) / (f6 + f5);
        Rect rect = this.f11000p;
        float f7 = width2 + rect.left;
        float f8 = rect.top - f3;
        float f9 = (f3 + height) - rect.bottom;
        if (f8 <= 1.0f) {
            f8 = 1.0f;
        }
        if (f9 <= 1.0f) {
            f9 = 1.0f;
        }
        pointF.set(f7, ((this.f11000p.height() * f8) / (f9 + f8)) + this.f11000p.top);
    }
}
