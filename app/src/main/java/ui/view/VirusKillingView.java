package ui.view;

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

/* JADX INFO: loaded from: classes2.dex */
public class VirusKillingView extends View {
    private static final String u = "VirusKilling";
    private static final int v = 1000;
    private float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f14655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Paint f14656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Paint f14657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Paint f14658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Paint f14659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Paint f14660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Paint f14661h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private RectF f14662i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f14663j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f14664k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f14665l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f14666m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Thread f14667n;
    private int o;
    private Handler p;
    private float q;
    private float r;
    private float s;
    private int t;

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1000) {
                return;
            }
            synchronized (this) {
                if (VirusKillingView.this.f14665l < 1.0f) {
                    VirusKillingView.this.f14665l = 360.0f;
                } else {
                    VirusKillingView.b(VirusKillingView.this);
                    VirusKillingView.this.invalidate();
                }
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    Thread.sleep(VirusKillingView.this.t);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (!VirusKillingView.this.f14666m) {
                    return;
                } else {
                    VirusKillingView.this.p.sendEmptyMessage(1000);
                }
            }
        }
    }

    public VirusKillingView(Context context) {
        super(context);
        this.f14665l = 360.0f;
        this.f14666m = true;
        this.o = 0;
        this.p = new a();
        this.t = 20;
        e();
    }

    static /* synthetic */ float b(VirusKillingView virusKillingView) {
        float f2 = virusKillingView.f14665l;
        virusKillingView.f14665l = f2 - 1.0f;
        return f2;
    }

    private void f(Canvas canvas) {
        String strValueOf = String.valueOf(this.o);
        this.q = this.f14658e.measureText(strValueOf);
        this.r = (getWidth() - this.q) / 2.0f;
        Paint.FontMetrics fontMetrics = this.f14658e.getFontMetrics();
        this.s = (getHeight() / 2) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f);
        canvas.drawText(strValueOf, this.r, this.s, this.f14658e);
    }

    public int getSchedule() {
        return this.o;
    }

    public int getmScanSpeed() {
        return this.t;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
        d(canvas);
        c(canvas);
        f(canvas);
        e(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int iMin = Math.min(b(i2), a(i3));
        setMeasuredDimension(iMin, iMin);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.a = getWidth();
        this.f14655b = getHeight();
        float f2 = this.a;
        this.f14662i = new RectF((float) (((double) f2) * 0.1d), (float) (((double) f2) * 0.1d), (float) (((double) f2) * 0.9d), (float) (((double) f2) * 0.9d));
        float f3 = this.a;
        this.f14660g.setShader(new LinearGradient((float) (((double) f3) * 0.3d), (float) (((double) f3) * 0.9d), (float) (((double) f3) * 0.1d), (float) (((double) f3) * 0.5d), new int[]{Color.parseColor("#B1D6FD"), 0}, (float[]) null, Shader.TileMode.CLAMP));
        float f4 = this.a;
        this.f14664k = (float) (((double) f4) * 0.4d);
        this.f14663j = (float) (((double) f4) * 0.25d);
    }

    public void setSchedule(int i2) {
        if (i2 < 0 || i2 > 100) {
            return;
        }
        this.o = i2;
        postInvalidate();
    }

    public void setmScanSpeed(int i2) {
        if (i2 < 20 || i2 > 1000) {
            return;
        }
        this.t = i2;
    }

    private int b(int i2) {
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

    private void c(Canvas canvas) {
        canvas.drawCircle(this.a / 2.0f, this.f14655b / 2.0f, this.f14663j, this.f14656c);
        canvas.drawCircle(this.a / 2.0f, this.f14655b / 2.0f, this.f14664k, this.f14656c);
    }

    private void d(Canvas canvas) {
        float f2 = this.a;
        float f3 = this.f14655b;
        canvas.drawLine((float) (((double) f2) * 0.1d), (float) (((double) f3) * 0.5d), (float) (((double) f2) * 0.9d), (float) (((double) f3) * 0.5d), this.f14657d);
        float f4 = this.a;
        float f5 = this.f14655b;
        canvas.drawLine((float) (((double) f4) * 0.5d), (float) (((double) f5) * 0.1d), (float) (((double) f4) * 0.5d), (float) (((double) f5) * 0.9d), this.f14657d);
    }

    private void e() {
        this.f14656c = new Paint();
        this.f14656c.setStrokeWidth(4.0f);
        this.f14656c.setAntiAlias(true);
        this.f14656c.setStyle(Paint.Style.STROKE);
        this.f14656c.setColor(Color.parseColor("#E3F0FC"));
        this.f14657d = new Paint();
        this.f14657d.setStrokeWidth(4.0f);
        this.f14657d.setAntiAlias(true);
        this.f14657d.setStyle(Paint.Style.STROKE);
        this.f14657d.setColor(Color.parseColor("#E3F0FC"));
        this.f14658e = new Paint(1);
        this.f14658e.setTextSize(90.0f);
        this.f14658e.setColor(Color.parseColor("#000000"));
        this.f14659f = new Paint(1);
        this.f14659f.setTextSize(30.0f);
        this.f14659f.setColor(Color.parseColor("#000000"));
        this.f14660g = new Paint();
        this.f14660g.setStrokeWidth(1.0f);
        this.f14660g.setColor(Color.parseColor("#2E93FE"));
        this.f14661h = new Paint();
        this.f14661h.setStrokeWidth(1.0f);
        this.f14661h.setColor(Color.parseColor("#3B9BFE"));
    }

    private int a(int i2) {
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

    public void c() {
        this.f14666m = true;
        this.f14667n = new Thread(new b());
        this.f14667n.start();
    }

    public void d() {
        this.f14666m = false;
    }

    private void b(Canvas canvas) {
        canvas.drawArc(this.f14662i, this.f14665l, 2.0f, true, this.f14661h);
    }

    private void a(Canvas canvas) {
        canvas.drawArc(this.f14662i, this.f14665l, 100.0f, true, this.f14660g);
    }

    public void b() {
        this.f14666m = true;
    }

    public boolean a() {
        return this.f14666m;
    }

    public VirusKillingView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14665l = 360.0f;
        this.f14666m = true;
        this.o = 0;
        this.p = new a();
        this.t = 20;
        e();
    }

    public VirusKillingView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14665l = 360.0f;
        this.f14666m = true;
        this.o = 0;
        this.p = new a();
        this.t = 20;
        e();
    }

    private void e(Canvas canvas) {
        canvas.drawText("%", this.r + this.q + 5.0f, (getHeight() / 2) + 20, this.f14659f);
    }
}
