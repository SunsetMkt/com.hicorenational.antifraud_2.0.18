package com.luozm.captcha;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.luozm.captcha.Captcha;

/* JADX INFO: loaded from: classes2.dex */
class PictureVertifyView extends AppCompatImageView {
    private static final int s = 1;
    private static final int t = 2;
    private static final int u = 3;
    private static final int v = 4;
    private static final int w = 5;
    private static final int x = 6;
    private static final int y = 20;
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f5319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f f5320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bitmap f5321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Path f5322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Paint f5323f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Paint f5324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f5325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f5326i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f5327j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f5328k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private a f5329l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private d f5330m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f5331n;
    private float o;
    private float p;
    private float q;
    private float r;

    interface a {
        void a();

        void a(long j2);
    }

    public PictureVertifyView(Context context) {
        this(context, null);
    }

    private void e() {
        try {
            if (Math.abs(this.f5320c.a - this.f5319b.a) >= 20 || Math.abs(this.f5320c.f5338b - this.f5319b.f5338b) >= 20) {
                d();
                if (this.f5329l != null) {
                    this.f5329l.a();
                }
            } else {
                a();
                if (this.f5329l != null) {
                    this.f5329l.a(this.f5326i - this.f5325h);
                }
            }
        } catch (Exception unused) {
            d();
            a aVar = this.f5329l;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    private Bitmap f() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        getDrawable().setBounds(0, 0, getWidth(), getHeight());
        canvas.clipPath(this.f5322e);
        getDrawable().draw(canvas);
        this.f5330m.a(canvas, this.f5322e);
        return b(bitmapCreateBitmap);
    }

    private void g() {
        if (this.f5319b == null) {
            this.f5319b = this.f5330m.a(getWidth(), getHeight(), this.f5327j);
            if (this.f5331n == 1) {
                this.f5320c = new f(0, this.f5319b.f5338b);
            } else {
                this.f5320c = this.f5330m.b(getWidth(), getHeight(), this.f5327j);
            }
        }
        if (this.f5322e == null) {
            this.f5322e = this.f5330m.a(this.f5327j);
            Path path = this.f5322e;
            f fVar = this.f5319b;
            path.offset(fVar.a, fVar.f5338b);
        }
        if (this.f5321d == null) {
            this.f5321d = f();
        }
    }

    void a(int i2) {
        this.f5325h = System.currentTimeMillis();
        this.a = 1;
        this.f5320c.a = (int) ((i2 / 100.0f) * (getWidth() - this.f5327j));
        invalidate();
    }

    void b(int i2) {
        this.a = 2;
        this.f5320c.a = (int) ((i2 / 100.0f) * (getWidth() - this.f5327j));
        invalidate();
    }

    void c() {
        this.a = 4;
        this.f5321d = null;
        this.f5319b = null;
        this.f5322e = null;
        invalidate();
    }

    void d() {
        this.a = 6;
        invalidate();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && this.f5331n == 2 && (motionEvent.getX() < this.f5320c.a || motionEvent.getX() > this.f5320c.a + this.f5327j || motionEvent.getY() < this.f5320c.f5338b || motionEvent.getY() > this.f5320c.f5338b + this.f5327j)) {
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        g();
        if (this.a != 5) {
            canvas.drawPath(this.f5322e, this.f5324g);
        }
        int i2 = this.a;
        if (i2 == 2 || i2 == 4 || i2 == 1 || i2 == 6) {
            Bitmap bitmap = this.f5321d;
            f fVar = this.f5320c;
            canvas.drawBitmap(bitmap, fVar.a, fVar.f5338b, this.f5323f);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f5331n == 2 && this.f5321d != null && this.f5328k) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.q = x2;
                this.r = y2;
                a(x2, y2);
            } else if (action == 1) {
                b();
            } else if (action == 2) {
                b(x2 - this.o, y2 - this.p);
            }
            this.o = x2;
            this.p = y2;
        }
        return true;
    }

    public PictureVertifyView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PictureVertifyView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = 4;
        this.f5327j = 50;
        this.f5328k = true;
        this.f5330m = new e(context);
        this.f5324g = this.f5330m.b();
        this.f5323f = this.f5330m.a();
        setLayerType(1, this.f5323f);
    }

    void d(@Captcha.g int i2) {
        this.f5331n = i2;
        this.f5322e = null;
        this.f5320c = null;
        this.f5319b = null;
        this.f5321d = null;
        invalidate();
    }

    void b(float f2, float f3) {
        this.a = 2;
        f fVar = this.f5320c;
        fVar.a = (int) (fVar.a + f2);
        fVar.f5338b = (int) (fVar.f5338b + f3);
        invalidate();
    }

    void a(float f2, float f3) {
        this.a = 1;
        f fVar = this.f5320c;
        int i2 = this.f5327j;
        fVar.a = (int) (f2 - (i2 / 2.0f));
        fVar.f5338b = (int) (f3 - (i2 / 2.0f));
        this.f5325h = System.currentTimeMillis();
        invalidate();
    }

    void c(int i2) {
        this.f5327j = i2;
        this.f5322e = null;
        this.f5320c = null;
        this.f5319b = null;
        this.f5321d = null;
        invalidate();
    }

    void b() {
        this.a = 3;
        this.f5326i = System.currentTimeMillis();
        e();
        invalidate();
    }

    void a() {
        this.a = 5;
        invalidate();
    }

    private Bitmap b(Bitmap bitmap) {
        f fVar = this.f5319b;
        int i2 = fVar.a;
        int i3 = fVar.f5338b;
        int i4 = this.f5327j;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i2, i3, i4, i4);
        bitmap.recycle();
        return bitmapCreateBitmap;
    }

    void a(a aVar) {
        this.f5329l = aVar;
    }

    void a(d dVar) {
        this.f5330m = dVar;
    }

    public void a(Bitmap bitmap) {
        this.f5322e = null;
        this.f5320c = null;
        this.f5319b = null;
        this.f5321d.recycle();
        this.f5321d = null;
        setImageBitmap(bitmap);
    }

    void a(boolean z) {
        this.f5328k = z;
    }
}
