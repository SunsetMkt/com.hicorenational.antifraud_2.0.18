package p388ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class VirusKillingView extends View {

    /* renamed from: u */
    private static final String f24746u = "VirusKilling";

    /* renamed from: v */
    private static final int f24747v = 1000;

    /* renamed from: a */
    private float f24748a;

    /* renamed from: b */
    private float f24749b;

    /* renamed from: c */
    private Paint f24750c;

    /* renamed from: d */
    private Paint f24751d;

    /* renamed from: e */
    private Paint f24752e;

    /* renamed from: f */
    private Paint f24753f;

    /* renamed from: g */
    private Paint f24754g;

    /* renamed from: h */
    private Paint f24755h;

    /* renamed from: i */
    private RectF f24756i;

    /* renamed from: j */
    private float f24757j;

    /* renamed from: k */
    private float f24758k;

    /* renamed from: l */
    private float f24759l;

    /* renamed from: m */
    private boolean f24760m;

    /* renamed from: n */
    private Thread f24761n;

    /* renamed from: o */
    private int f24762o;

    /* renamed from: p */
    private Handler f24763p;

    /* renamed from: q */
    private float f24764q;

    /* renamed from: r */
    private float f24765r;

    /* renamed from: s */
    private float f24766s;

    /* renamed from: t */
    private int f24767t;

    /* renamed from: ui.view.VirusKillingView$a */
    class HandlerC7202a extends Handler {
        HandlerC7202a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1000) {
                return;
            }
            synchronized (this) {
                if (VirusKillingView.this.f24759l < 1.0f) {
                    VirusKillingView.this.f24759l = 360.0f;
                } else {
                    VirusKillingView.m25873b(VirusKillingView.this);
                    VirusKillingView.this.invalidate();
                }
            }
        }
    }

    /* renamed from: ui.view.VirusKillingView$b */
    class RunnableC7203b implements Runnable {
        RunnableC7203b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    Thread.sleep(VirusKillingView.this.f24767t);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (!VirusKillingView.this.f24760m) {
                    return;
                } else {
                    VirusKillingView.this.f24763p.sendEmptyMessage(1000);
                }
            }
        }
    }

    public VirusKillingView(Context context) {
        super(context);
        this.f24759l = 360.0f;
        this.f24760m = true;
        this.f24762o = 0;
        this.f24763p = new HandlerC7202a();
        this.f24767t = 20;
        m25881e();
    }

    /* renamed from: b */
    static /* synthetic */ float m25873b(VirusKillingView virusKillingView) {
        float f2 = virusKillingView.f24759l;
        virusKillingView.f24759l = f2 - 1.0f;
        return f2;
    }

    /* renamed from: f */
    private void m25883f(Canvas canvas) {
        String valueOf = String.valueOf(this.f24762o);
        this.f24764q = this.f24752e.measureText(valueOf);
        this.f24765r = (getWidth() - this.f24764q) / 2.0f;
        Paint.FontMetrics fontMetrics = this.f24752e.getFontMetrics();
        this.f24766s = (getHeight() / 2) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f);
        canvas.drawText(valueOf, this.f24765r, this.f24766s, this.f24752e);
    }

    public int getSchedule() {
        return this.f24762o;
    }

    public int getmScanSpeed() {
        return this.f24767t;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m25872a(canvas);
        m25875b(canvas);
        m25878d(canvas);
        m25877c(canvas);
        m25883f(canvas);
        m25882e(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int min = Math.min(m25874b(i2), m25871a(i3));
        setMeasuredDimension(min, min);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f24748a = getWidth();
        this.f24749b = getHeight();
        float f2 = this.f24748a;
        this.f24756i = new RectF((float) (f2 * 0.1d), (float) (f2 * 0.1d), (float) (f2 * 0.9d), (float) (f2 * 0.9d));
        float f3 = this.f24748a;
        this.f24754g.setShader(new LinearGradient((float) (f3 * 0.3d), (float) (f3 * 0.9d), (float) (f3 * 0.1d), (float) (f3 * 0.5d), new int[]{Color.parseColor("#B1D6FD"), 0}, (float[]) null, Shader.TileMode.CLAMP));
        float f4 = this.f24748a;
        this.f24758k = (float) (f4 * 0.4d);
        this.f24757j = (float) (f4 * 0.25d);
    }

    public void setSchedule(int i2) {
        if (i2 < 0 || i2 > 100) {
            return;
        }
        this.f24762o = i2;
        postInvalidate();
    }

    public void setmScanSpeed(int i2) {
        if (i2 < 20 || i2 > 1000) {
            return;
        }
        this.f24767t = i2;
    }

    /* renamed from: b */
    private int m25874b(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return i2;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(400, size);
        }
        return 400;
    }

    /* renamed from: c */
    private void m25877c(Canvas canvas) {
        canvas.drawCircle(this.f24748a / 2.0f, this.f24749b / 2.0f, this.f24757j, this.f24750c);
        canvas.drawCircle(this.f24748a / 2.0f, this.f24749b / 2.0f, this.f24758k, this.f24750c);
    }

    /* renamed from: d */
    private void m25878d(Canvas canvas) {
        float f2 = this.f24748a;
        float f3 = this.f24749b;
        canvas.drawLine((float) (f2 * 0.1d), (float) (f3 * 0.5d), (float) (f2 * 0.9d), (float) (f3 * 0.5d), this.f24751d);
        float f4 = this.f24748a;
        float f5 = this.f24749b;
        canvas.drawLine((float) (f4 * 0.5d), (float) (f5 * 0.1d), (float) (f4 * 0.5d), (float) (f5 * 0.9d), this.f24751d);
    }

    /* renamed from: e */
    private void m25881e() {
        this.f24750c = new Paint();
        this.f24750c.setStrokeWidth(4.0f);
        this.f24750c.setAntiAlias(true);
        this.f24750c.setStyle(Paint.Style.STROKE);
        this.f24750c.setColor(Color.parseColor("#E3F0FC"));
        this.f24751d = new Paint();
        this.f24751d.setStrokeWidth(4.0f);
        this.f24751d.setAntiAlias(true);
        this.f24751d.setStyle(Paint.Style.STROKE);
        this.f24751d.setColor(Color.parseColor("#E3F0FC"));
        this.f24752e = new Paint(1);
        this.f24752e.setTextSize(90.0f);
        this.f24752e.setColor(Color.parseColor("#000000"));
        this.f24753f = new Paint(1);
        this.f24753f.setTextSize(30.0f);
        this.f24753f.setColor(Color.parseColor("#000000"));
        this.f24754g = new Paint();
        this.f24754g.setStrokeWidth(1.0f);
        this.f24754g.setColor(Color.parseColor("#2E93FE"));
        this.f24755h = new Paint();
        this.f24755h.setStrokeWidth(1.0f);
        this.f24755h.setColor(Color.parseColor("#3B9BFE"));
    }

    /* renamed from: a */
    private int m25871a(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return i2;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(400, size);
        }
        return 400;
    }

    /* renamed from: c */
    public void m25886c() {
        this.f24760m = true;
        this.f24761n = new Thread(new RunnableC7203b());
        this.f24761n.start();
    }

    /* renamed from: d */
    public void m25887d() {
        this.f24760m = false;
    }

    /* renamed from: b */
    private void m25875b(Canvas canvas) {
        canvas.drawArc(this.f24756i, this.f24759l, 2.0f, true, this.f24755h);
    }

    /* renamed from: a */
    private void m25872a(Canvas canvas) {
        canvas.drawArc(this.f24756i, this.f24759l, 100.0f, true, this.f24754g);
    }

    /* renamed from: b */
    public void m25885b() {
        this.f24760m = true;
    }

    /* renamed from: a */
    public boolean m25884a() {
        return this.f24760m;
    }

    public VirusKillingView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24759l = 360.0f;
        this.f24760m = true;
        this.f24762o = 0;
        this.f24763p = new HandlerC7202a();
        this.f24767t = 20;
        m25881e();
    }

    public VirusKillingView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24759l = 360.0f;
        this.f24760m = true;
        this.f24762o = 0;
        this.f24763p = new HandlerC7202a();
        this.f24767t = 20;
        m25881e();
    }

    /* renamed from: e */
    private void m25882e(Canvas canvas) {
        canvas.drawText("%", this.f24765r + this.f24764q + 5.0f, (getHeight() / 2) + 20, this.f24753f);
    }
}
