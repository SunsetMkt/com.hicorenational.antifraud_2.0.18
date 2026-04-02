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

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public class c extends ImageView {
    final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Matrix f6693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Matrix f6694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f6696f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f6697g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Bitmap f6698h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f6699i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f6700j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f6701k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private PointF f6702l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private PointF f6703m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f6704n;
    private float o;
    private Rect p;

    public c(Context context) {
        super(context);
        this.f6693c = new Matrix();
        this.f6694d = new Matrix();
        this.f6695e = 0;
        this.f6696f = 1.0f;
        this.f6697g = 1.0f;
        this.f6699i = false;
        this.a = "TouchView";
        this.f6702l = new PointF();
        this.f6703m = new PointF();
        this.f6704n = 1.0f;
        this.o = 0.0f;
        this.f6692b = false;
        this.p = new Rect();
        getDrawingRect(this.p);
        a();
    }

    private void a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        boolean z;
        Animation scaleAnimation;
        if (this.f6698h == null) {
            return;
        }
        float fWidth = this.p.width();
        float fHeight = this.p.height();
        float[] fArr = new float[9];
        this.f6693c.getValues(fArr);
        float f2 = fArr[2];
        float f3 = fArr[5];
        float f4 = fArr[0];
        TranslateAnimation translateAnimation = null;
        float f5 = this.f6696f;
        if (f4 > f5) {
            this.o = f5 / f4;
            Matrix matrix = this.f6693c;
            float f6 = this.o;
            PointF pointF = this.f6703m;
            matrix.postScale(f6, f6, pointF.x, pointF.y);
            setImageMatrix(this.f6693c);
            float f7 = this.o;
            float f8 = 1.0f / f7;
            float f9 = 1.0f / f7;
            PointF pointF2 = this.f6703m;
            scaleAnimation = new ScaleAnimation(f8, 1.0f, f9, 1.0f, pointF2.x, pointF2.y);
        } else {
            float f10 = this.f6697g;
            if (f4 < f10) {
                this.o = f10 / f4;
                Matrix matrix2 = this.f6693c;
                float f11 = this.o;
                PointF pointF3 = this.f6703m;
                matrix2.postScale(f11, f11, pointF3.x, pointF3.y);
                float f12 = this.o;
                PointF pointF4 = this.f6703m;
                scaleAnimation = new ScaleAnimation(1.0f, f12, 1.0f, f12, pointF4.x, pointF4.y);
            } else {
                float width = this.f6698h.getWidth() * f4;
                float height = this.f6698h.getHeight() * f4;
                int i2 = this.p.left;
                float f13 = i2 - f2;
                float f14 = r9.top - f3;
                if (f13 < 0.0f) {
                    f2 = i2;
                    z = true;
                } else {
                    z = false;
                }
                if (f14 < 0.0f) {
                    f3 = this.p.top;
                    z = true;
                }
                float f15 = height - f14;
                if (width - f13 < fWidth) {
                    f2 = this.p.left - (width - fWidth);
                    z = true;
                }
                if (f15 < fHeight) {
                    f3 = this.p.top - (height - fHeight);
                    z = true;
                }
                if (z) {
                    float f16 = fArr[2] - f2;
                    float f17 = fArr[5] - f3;
                    fArr[2] = f2;
                    fArr[5] = f3;
                    this.f6693c.setValues(fArr);
                    setImageMatrix(this.f6693c);
                    translateAnimation = new TranslateAnimation(f16, 0.0f, f17, 0.0f);
                } else {
                    setImageMatrix(this.f6693c);
                }
                scaleAnimation = translateAnimation;
            }
        }
        if (scaleAnimation != null) {
            this.f6699i = true;
            scaleAnimation.setDuration(300L);
            startAnimation(scaleAnimation);
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    c.this.post(new Runnable() { // from class: com.tencent.connect.avatar.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.clearAnimation();
                            c.this.b();
                        }
                    });
                    c.this.f6699i = false;
                }
            }).start();
        }
    }

    private void c() {
        if (this.f6698h == null) {
            return;
        }
        float[] fArr = {fMax, 0.0f, this.f6700j, 0.0f, fMax, this.f6701k, 0.0f, 0.0f, 0.0f};
        this.f6693c.getValues(fArr);
        float fMax = Math.max(this.p.width() / this.f6698h.getWidth(), this.p.height() / this.f6698h.getHeight());
        this.f6700j = this.p.left - (((this.f6698h.getWidth() * fMax) - this.p.width()) / 2.0f);
        this.f6701k = this.p.top - (((this.f6698h.getHeight() * fMax) - this.p.height()) / 2.0f);
        this.f6693c.setValues(fArr);
        this.f6696f = Math.min(2048.0f / this.f6698h.getWidth(), 2048.0f / this.f6698h.getHeight());
        this.f6697g = fMax;
        float f2 = this.f6696f;
        float f3 = this.f6697g;
        if (f2 < f3) {
            this.f6696f = f3;
        }
        setImageMatrix(this.f6693c);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f6699i) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f6693c.set(getImageMatrix());
            this.f6694d.set(this.f6693c);
            this.f6702l.set(motionEvent.getX(), motionEvent.getY());
            this.f6695e = 1;
        } else if (action == 1) {
            b();
            this.f6695e = 0;
        } else if (action == 2) {
            int i2 = this.f6695e;
            if (i2 == 1) {
                this.f6693c.set(this.f6694d);
                this.f6693c.postTranslate(motionEvent.getX() - this.f6702l.x, motionEvent.getY() - this.f6702l.y);
                setImageMatrix(this.f6693c);
            } else if (i2 == 2) {
                Matrix matrix = this.f6693c;
                matrix.set(matrix);
                float fA = a(motionEvent);
                if (fA > 10.0f) {
                    this.f6693c.set(this.f6694d);
                    float f2 = fA / this.f6704n;
                    Matrix matrix2 = this.f6693c;
                    PointF pointF = this.f6703m;
                    matrix2.postScale(f2, f2, pointF.x, pointF.y);
                }
                setImageMatrix(this.f6693c);
            }
        } else if (action == 5) {
            this.f6704n = a(motionEvent);
            if (this.f6704n > 10.0f) {
                this.f6694d.set(this.f6693c);
                a(this.f6703m);
                this.f6695e = 2;
            }
        } else if (action == 6) {
        }
        this.f6692b = true;
        return true;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f6698h = bitmap;
        if (bitmap != null) {
            this.f6698h = bitmap;
        }
    }

    private float a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void a(Rect rect) {
        this.p = rect;
        if (this.f6698h != null) {
            c();
        }
    }

    private void a(PointF pointF) {
        if (this.f6698h == null) {
            return;
        }
        float[] fArr = new float[9];
        this.f6693c.getValues(fArr);
        float f2 = fArr[2];
        float f3 = fArr[5];
        float f4 = fArr[0];
        float width = this.f6698h.getWidth() * f4;
        float height = this.f6698h.getHeight() * f4;
        float f5 = this.p.left - f2;
        if (f5 <= 1.0f) {
            f5 = 1.0f;
        }
        float f6 = (f2 + width) - this.p.right;
        if (f6 <= 1.0f) {
            f6 = 1.0f;
        }
        float fWidth = (this.p.width() * f5) / (f6 + f5);
        Rect rect = this.p;
        float f7 = fWidth + rect.left;
        float f8 = rect.top - f3;
        float f9 = (f3 + height) - rect.bottom;
        if (f8 <= 1.0f) {
            f8 = 1.0f;
        }
        if (f9 <= 1.0f) {
            f9 = 1.0f;
        }
        pointF.set(f7, ((this.p.height() * f8) / (f9 + f8)) + this.p.top);
    }
}
