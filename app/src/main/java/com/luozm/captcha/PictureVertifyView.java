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

/* loaded from: classes.dex */
class PictureVertifyView extends AppCompatImageView {

    /* renamed from: s */
    private static final int f8440s = 1;

    /* renamed from: t */
    private static final int f8441t = 2;

    /* renamed from: u */
    private static final int f8442u = 3;

    /* renamed from: v */
    private static final int f8443v = 4;

    /* renamed from: w */
    private static final int f8444w = 5;

    /* renamed from: x */
    private static final int f8445x = 6;

    /* renamed from: y */
    private static final int f8446y = 20;

    /* renamed from: a */
    private int f8447a;

    /* renamed from: b */
    private C2745f f8448b;

    /* renamed from: c */
    private C2745f f8449c;

    /* renamed from: d */
    private Bitmap f8450d;

    /* renamed from: e */
    private Path f8451e;

    /* renamed from: f */
    private Paint f8452f;

    /* renamed from: g */
    private Paint f8453g;

    /* renamed from: h */
    private long f8454h;

    /* renamed from: i */
    private long f8455i;

    /* renamed from: j */
    private int f8456j;

    /* renamed from: k */
    private boolean f8457k;

    /* renamed from: l */
    private InterfaceC2738a f8458l;

    /* renamed from: m */
    private AbstractC2743d f8459m;

    /* renamed from: n */
    private int f8460n;

    /* renamed from: o */
    private float f8461o;

    /* renamed from: p */
    private float f8462p;

    /* renamed from: q */
    private float f8463q;

    /* renamed from: r */
    private float f8464r;

    /* renamed from: com.luozm.captcha.PictureVertifyView$a */
    interface InterfaceC2738a {
        /* renamed from: a */
        void mo8166a();

        /* renamed from: a */
        void mo8167a(long j2);
    }

    public PictureVertifyView(Context context) {
        this(context, null);
    }

    /* renamed from: e */
    private void m8173e() {
        try {
            if (Math.abs(this.f8449c.f8476a - this.f8448b.f8476a) >= 20 || Math.abs(this.f8449c.f8477b - this.f8448b.f8477b) >= 20) {
                m8188d();
                if (this.f8458l != null) {
                    this.f8458l.mo8166a();
                }
            } else {
                m8176a();
                if (this.f8458l != null) {
                    this.f8458l.mo8167a(this.f8455i - this.f8454h);
                }
            }
        } catch (Exception unused) {
            m8188d();
            InterfaceC2738a interfaceC2738a = this.f8458l;
            if (interfaceC2738a != null) {
                interfaceC2738a.mo8166a();
            }
        }
    }

    /* renamed from: f */
    private Bitmap m8174f() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        getDrawable().setBounds(0, 0, getWidth(), getHeight());
        canvas.clipPath(this.f8451e);
        getDrawable().draw(canvas);
        this.f8459m.mo8196a(canvas, this.f8451e);
        return m8172b(createBitmap);
    }

    /* renamed from: g */
    private void m8175g() {
        if (this.f8448b == null) {
            this.f8448b = this.f8459m.mo8195a(getWidth(), getHeight(), this.f8456j);
            if (this.f8460n == 1) {
                this.f8449c = new C2745f(0, this.f8448b.f8477b);
            } else {
                this.f8449c = this.f8459m.mo8198b(getWidth(), getHeight(), this.f8456j);
            }
        }
        if (this.f8451e == null) {
            this.f8451e = this.f8459m.mo8194a(this.f8456j);
            Path path = this.f8451e;
            C2745f c2745f = this.f8448b;
            path.offset(c2745f.f8476a, c2745f.f8477b);
        }
        if (this.f8450d == null) {
            this.f8450d = m8174f();
        }
    }

    /* renamed from: a */
    void m8178a(int i2) {
        this.f8454h = System.currentTimeMillis();
        this.f8447a = 1;
        this.f8449c.f8476a = (int) ((i2 / 100.0f) * (getWidth() - this.f8456j));
        invalidate();
    }

    /* renamed from: b */
    void m8185b(int i2) {
        this.f8447a = 2;
        this.f8449c.f8476a = (int) ((i2 / 100.0f) * (getWidth() - this.f8456j));
        invalidate();
    }

    /* renamed from: c */
    void m8186c() {
        this.f8447a = 4;
        this.f8450d = null;
        this.f8448b = null;
        this.f8451e = null;
        invalidate();
    }

    /* renamed from: d */
    void m8188d() {
        this.f8447a = 6;
        invalidate();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && this.f8460n == 2 && (motionEvent.getX() < this.f8449c.f8476a || motionEvent.getX() > this.f8449c.f8476a + this.f8456j || motionEvent.getY() < this.f8449c.f8477b || motionEvent.getY() > this.f8449c.f8477b + this.f8456j)) {
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m8175g();
        if (this.f8447a != 5) {
            canvas.drawPath(this.f8451e, this.f8453g);
        }
        int i2 = this.f8447a;
        if (i2 == 2 || i2 == 4 || i2 == 1 || i2 == 6) {
            Bitmap bitmap = this.f8450d;
            C2745f c2745f = this.f8449c;
            canvas.drawBitmap(bitmap, c2745f.f8476a, c2745f.f8477b, this.f8452f);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f8460n == 2 && this.f8450d != null && this.f8457k) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f8463q = x;
                this.f8464r = y;
                m8177a(x, y);
            } else if (action == 1) {
                m8183b();
            } else if (action == 2) {
                m8184b(x - this.f8461o, y - this.f8462p);
            }
            this.f8461o = x;
            this.f8462p = y;
        }
        return true;
    }

    public PictureVertifyView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PictureVertifyView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8447a = 4;
        this.f8456j = 50;
        this.f8457k = true;
        this.f8459m = new C2744e(context);
        this.f8453g = this.f8459m.mo8197b();
        this.f8452f = this.f8459m.mo8193a();
        setLayerType(1, this.f8452f);
    }

    /* renamed from: d */
    void m8189d(@Captcha.InterfaceC2737g int i2) {
        this.f8460n = i2;
        this.f8451e = null;
        this.f8449c = null;
        this.f8448b = null;
        this.f8450d = null;
        invalidate();
    }

    /* renamed from: b */
    void m8184b(float f2, float f3) {
        this.f8447a = 2;
        C2745f c2745f = this.f8449c;
        c2745f.f8476a = (int) (c2745f.f8476a + f2);
        c2745f.f8477b = (int) (c2745f.f8477b + f3);
        invalidate();
    }

    /* renamed from: a */
    void m8177a(float f2, float f3) {
        this.f8447a = 1;
        C2745f c2745f = this.f8449c;
        int i2 = this.f8456j;
        c2745f.f8476a = (int) (f2 - (i2 / 2.0f));
        c2745f.f8477b = (int) (f3 - (i2 / 2.0f));
        this.f8454h = System.currentTimeMillis();
        invalidate();
    }

    /* renamed from: c */
    void m8187c(int i2) {
        this.f8456j = i2;
        this.f8451e = null;
        this.f8449c = null;
        this.f8448b = null;
        this.f8450d = null;
        invalidate();
    }

    /* renamed from: b */
    void m8183b() {
        this.f8447a = 3;
        this.f8455i = System.currentTimeMillis();
        m8173e();
        invalidate();
    }

    /* renamed from: a */
    void m8176a() {
        this.f8447a = 5;
        invalidate();
    }

    /* renamed from: b */
    private Bitmap m8172b(Bitmap bitmap) {
        C2745f c2745f = this.f8448b;
        int i2 = c2745f.f8476a;
        int i3 = c2745f.f8477b;
        int i4 = this.f8456j;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, i2, i3, i4, i4);
        bitmap.recycle();
        return createBitmap;
    }

    /* renamed from: a */
    void m8180a(InterfaceC2738a interfaceC2738a) {
        this.f8458l = interfaceC2738a;
    }

    /* renamed from: a */
    void m8181a(AbstractC2743d abstractC2743d) {
        this.f8459m = abstractC2743d;
    }

    /* renamed from: a */
    public void m8179a(Bitmap bitmap) {
        this.f8451e = null;
        this.f8449c = null;
        this.f8448b = null;
        this.f8450d.recycle();
        this.f8450d = null;
        setImageBitmap(bitmap);
    }

    /* renamed from: a */
    void m8182a(boolean z) {
        this.f8457k = z;
    }
}
