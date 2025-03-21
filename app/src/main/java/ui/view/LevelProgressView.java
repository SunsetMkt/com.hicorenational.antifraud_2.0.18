package ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.hicorenational.antifraud.R;
import util.y1;

/* loaded from: classes2.dex */
public class LevelProgressView extends View {
    public static final String[] u = {"0", "200", "500", "800", "1500", "3000", "8000", "15000"};

    /* renamed from: a, reason: collision with root package name */
    private Paint f20327a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f20328b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f20329c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f20330d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f20331e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f20332f;

    /* renamed from: g, reason: collision with root package name */
    private Paint f20333g;

    /* renamed from: h, reason: collision with root package name */
    private Paint f20334h;

    /* renamed from: i, reason: collision with root package name */
    private int f20335i;

    /* renamed from: j, reason: collision with root package name */
    private int f20336j;

    /* renamed from: k, reason: collision with root package name */
    private int f20337k;

    /* renamed from: l, reason: collision with root package name */
    private int f20338l;

    /* renamed from: m, reason: collision with root package name */
    private int f20339m;
    private Paint n;
    private Bitmap o;
    private float p;
    private ValueAnimator q;
    private long r;
    private View s;
    private float t;

    public LevelProgressView(Context context) {
        super(context);
        this.f20335i = 12;
        this.f20336j = 8;
        this.f20337k = 45;
        this.p = 0.0f;
        this.r = 1000L;
        this.t = 0.0f;
        a();
    }

    public void a() {
        Typeface create = Typeface.create(Typeface.SANS_SERIF, 1);
        this.f20327a = new Paint();
        this.f20327a.setStyle(Paint.Style.FILL);
        this.f20327a.setColor(Color.parseColor("#ffffff"));
        this.f20327a.setAntiAlias(true);
        this.f20330d = new Paint();
        this.f20330d.setStyle(Paint.Style.FILL);
        this.f20330d.setColor(Color.parseColor("#ffffff"));
        this.f20330d.setAntiAlias(true);
        this.f20328b = new Paint();
        this.f20328b.setStyle(Paint.Style.FILL);
        this.f20328b.setColor(Color.parseColor("#D1D2D6"));
        this.f20328b.setAntiAlias(true);
        this.f20331e = new Paint();
        this.f20331e.setStyle(Paint.Style.FILL);
        this.f20331e.setColor(Color.parseColor("#333333"));
        this.f20331e.setAntiAlias(true);
        this.f20329c = new Paint();
        this.f20329c.setColor(Color.parseColor("#D1D2D6"));
        this.f20329c.setStrokeWidth(4.0f);
        this.f20332f = new Paint();
        this.f20332f.setColor(Color.parseColor("#333333"));
        this.f20332f.setStrokeWidth(4.0f);
        this.f20333g = new Paint();
        this.f20333g.setAntiAlias(true);
        this.f20333g.setColor(Color.parseColor("#CCCCCC"));
        this.f20333g.setTextSize(a(getContext(), 10.0f));
        this.f20333g.setTypeface(create);
        this.f20334h = new Paint();
        this.f20334h.setAntiAlias(true);
        this.f20334h.setColor(Color.parseColor("#333333"));
        this.f20334h.setTextSize(a(getContext(), 10.0f));
        this.f20334h.setTypeface(create);
        this.n = new Paint();
        this.n.setAntiAlias(true);
        this.o = BitmapFactory.decodeResource(getResources(), R.drawable.iv_level_point);
        this.f20337k = a(getContext(), 16.0f);
        this.f20336j = a(getContext(), 3.0f);
        this.f20335i = a(getContext(), 4.0f);
        this.f20338l = a(getContext(), 15.0f);
        this.f20339m = a(getContext(), 18.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i2;
        int i3;
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        int width2 = this.s.getWidth();
        int i4 = this.f20337k;
        String[] strArr = u;
        int length = ((width - (i4 * 2)) - ((strArr.length * 2) * this.f20335i)) / (strArr.length - 1);
        float f2 = height / 2;
        canvas.drawLine((r6 * 2) + i4, f2, (width - i4) - (r6 * 2), f2, this.f20329c);
        float f3 = this.p;
        if (f3 == 0.0f) {
            this.t = this.f20337k + (this.f20335i * 1);
            i3 = 1;
        } else {
            if (f3 != 15000.0f) {
                i2 = 0;
                while (true) {
                    String[] strArr2 = u;
                    if (i2 >= strArr2.length) {
                        i3 = 0;
                        break;
                    }
                    int parseInt = Integer.parseInt(strArr2[i2]);
                    i2++;
                    int parseInt2 = Integer.parseInt(u[i2]);
                    float f4 = this.p;
                    float f5 = parseInt;
                    if (f4 >= f5 && f4 < parseInt2) {
                        float f6 = ((f4 - f5) / (parseInt2 - parseInt)) * length;
                        int i5 = i2 - 1;
                        this.t = this.f20337k + (this.f20335i * ((i5 * 2) + 1)) + (i5 * length) + f6;
                        break;
                    }
                }
            } else {
                i2 = u.length;
                int i6 = i2 - 1;
                this.t = this.f20337k + (this.f20335i * ((i6 * 2) + 1)) + (i6 * length);
            }
            i3 = i2;
        }
        y1.a(this.s, 0L, ((width - width2) * this.t) / width);
        canvas.drawLine(this.f20337k + this.f20335i, f2, this.t, f2, this.f20332f);
        canvas.drawBitmap(this.o, this.t - this.f20336j, r12 - this.f20338l, this.n);
        for (int i7 = 0; i7 < u.length; i7++) {
            if (i7 < i3) {
                int i8 = this.f20337k;
                int i9 = (i7 * 2) + 1;
                int i10 = length * i7;
                canvas.drawCircle(i8 + (r2 * i9) + i10, f2, this.f20335i, this.f20330d);
                canvas.drawCircle(this.f20337k + (this.f20335i * i9) + i10, f2, this.f20336j, this.f20331e);
                String[] strArr3 = u;
                canvas.drawText(strArr3[i7], ((this.f20337k + (this.f20335i * i9)) + i10) - a(strArr3[i7]), this.f20339m + r12, this.f20334h);
            } else {
                int i11 = this.f20337k;
                int i12 = (i7 * 2) + 1;
                int i13 = length * i7;
                canvas.drawCircle(i11 + (r2 * i12) + i13, f2, this.f20335i, this.f20327a);
                canvas.drawCircle(this.f20337k + (this.f20335i * i12) + i13, f2, this.f20336j, this.f20328b);
                String[] strArr4 = u;
                canvas.drawText(strArr4[i7], ((this.f20337k + (this.f20335i * i12)) + i13) - a(strArr4[i7]), this.f20339m + r12, this.f20333g);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        getSuggestedMinimumWidth();
        super.onMeasure(i2, i3);
    }

    public void setLevelPointView(View view) {
        this.s = view;
    }

    public void setProgress(float f2) {
        if (f2 <= 0.0f) {
            f2 = 0.0f;
        }
        if (f2 >= 15000.0f) {
            f2 = 15000.0f;
        }
        this.q = ValueAnimator.ofFloat(0.0f, Float.valueOf(f2).floatValue());
        this.q.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ui.view.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LevelProgressView.this.a(valueAnimator);
            }
        });
        this.q.setDuration(this.r);
        this.q.start();
    }

    public LevelProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20335i = 12;
        this.f20336j = 8;
        this.f20337k = 45;
        this.p = 0.0f;
        this.r = 1000L;
        this.t = 0.0f;
        a();
    }

    public LevelProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20335i = 12;
        this.f20336j = 8;
        this.f20337k = 45;
        this.p = 0.0f;
        this.r = 1000L;
        this.t = 0.0f;
        a();
    }

    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        this.p = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    public float a(String str) {
        return this.f20333g.measureText(str) / 2.0f;
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
