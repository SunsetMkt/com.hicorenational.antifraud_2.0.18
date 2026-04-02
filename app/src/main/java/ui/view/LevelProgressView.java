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
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class LevelProgressView extends View {
    public static final String[] u = {"0", "200", "500", "800", "1500", "3000", "8000", "15000"};
    private Paint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f14540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Paint f14541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Paint f14542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Paint f14543e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Paint f14544f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Paint f14545g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Paint f14546h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f14547i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f14548j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f14549k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f14550l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f14551m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Paint f14552n;
    private Bitmap o;
    private float p;
    private ValueAnimator q;
    private long r;
    private View s;
    private float t;

    public LevelProgressView(Context context) {
        super(context);
        this.f14547i = 12;
        this.f14548j = 8;
        this.f14549k = 45;
        this.p = 0.0f;
        this.r = 1000L;
        this.t = 0.0f;
        a();
    }

    public void a() {
        Typeface typefaceCreate = Typeface.create(Typeface.SANS_SERIF, 1);
        this.a = new Paint();
        this.a.setStyle(Paint.Style.FILL);
        this.a.setColor(Color.parseColor("#ffffff"));
        this.a.setAntiAlias(true);
        this.f14542d = new Paint();
        this.f14542d.setStyle(Paint.Style.FILL);
        this.f14542d.setColor(Color.parseColor("#ffffff"));
        this.f14542d.setAntiAlias(true);
        this.f14540b = new Paint();
        this.f14540b.setStyle(Paint.Style.FILL);
        this.f14540b.setColor(Color.parseColor("#D1D2D6"));
        this.f14540b.setAntiAlias(true);
        this.f14543e = new Paint();
        this.f14543e.setStyle(Paint.Style.FILL);
        this.f14543e.setColor(Color.parseColor("#333333"));
        this.f14543e.setAntiAlias(true);
        this.f14541c = new Paint();
        this.f14541c.setColor(Color.parseColor("#D1D2D6"));
        this.f14541c.setStrokeWidth(4.0f);
        this.f14544f = new Paint();
        this.f14544f.setColor(Color.parseColor("#333333"));
        this.f14544f.setStrokeWidth(4.0f);
        this.f14545g = new Paint();
        this.f14545g.setAntiAlias(true);
        this.f14545g.setColor(Color.parseColor("#CCCCCC"));
        this.f14545g.setTextSize(a(getContext(), 10.0f));
        this.f14545g.setTypeface(typefaceCreate);
        this.f14546h = new Paint();
        this.f14546h.setAntiAlias(true);
        this.f14546h.setColor(Color.parseColor("#333333"));
        this.f14546h.setTextSize(a(getContext(), 10.0f));
        this.f14546h.setTypeface(typefaceCreate);
        this.f14552n = new Paint();
        this.f14552n.setAntiAlias(true);
        this.o = BitmapFactory.decodeResource(getResources(), R.drawable.iv_level_point);
        this.f14549k = a(getContext(), 16.0f);
        this.f14548j = a(getContext(), 3.0f);
        this.f14547i = a(getContext(), 4.0f);
        this.f14550l = a(getContext(), 15.0f);
        this.f14551m = a(getContext(), 18.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int length;
        int i2;
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        int width2 = this.s.getWidth();
        int i3 = this.f14549k;
        String[] strArr = u;
        int length2 = ((width - (i3 * 2)) - ((strArr.length * 2) * this.f14547i)) / (strArr.length - 1);
        float f2 = height / 2;
        canvas.drawLine((r6 * 2) + i3, f2, (width - i3) - (r6 * 2), f2, this.f14541c);
        float f3 = this.p;
        if (f3 == 0.0f) {
            this.t = this.f14549k + (this.f14547i * 1);
            i2 = 1;
        } else {
            if (f3 != 15000.0f) {
                length = 0;
                while (true) {
                    String[] strArr2 = u;
                    if (length >= strArr2.length) {
                        i2 = 0;
                        break;
                    }
                    int i4 = Integer.parseInt(strArr2[length]);
                    length++;
                    int i5 = Integer.parseInt(u[length]);
                    float f4 = this.p;
                    float f5 = i4;
                    if (f4 >= f5 && f4 < i5) {
                        float f6 = ((f4 - f5) / (i5 - i4)) * length2;
                        int i6 = length - 1;
                        this.t = this.f14549k + (this.f14547i * ((i6 * 2) + 1)) + (i6 * length2) + f6;
                        break;
                    }
                }
            } else {
                length = u.length;
                int i7 = length - 1;
                this.t = this.f14549k + (this.f14547i * ((i7 * 2) + 1)) + (i7 * length2);
            }
            i2 = length;
        }
        g2.a(this.s, 0L, ((width - width2) * this.t) / width);
        canvas.drawLine(this.f14549k + this.f14547i, f2, this.t, f2, this.f14544f);
        canvas.drawBitmap(this.o, this.t - this.f14548j, r12 - this.f14550l, this.f14552n);
        for (int i8 = 0; i8 < u.length; i8++) {
            if (i8 < i2) {
                int i9 = this.f14549k;
                int i10 = (i8 * 2) + 1;
                int i11 = length2 * i8;
                canvas.drawCircle(i9 + (r2 * i10) + i11, f2, this.f14547i, this.f14542d);
                canvas.drawCircle(this.f14549k + (this.f14547i * i10) + i11, f2, this.f14548j, this.f14543e);
                String[] strArr3 = u;
                canvas.drawText(strArr3[i8], ((this.f14549k + (this.f14547i * i10)) + i11) - a(strArr3[i8]), this.f14551m + r12, this.f14546h);
            } else {
                int i12 = this.f14549k;
                int i13 = (i8 * 2) + 1;
                int i14 = length2 * i8;
                canvas.drawCircle(i12 + (r2 * i13) + i14, f2, this.f14547i, this.a);
                canvas.drawCircle(this.f14549k + (this.f14547i * i13) + i14, f2, this.f14548j, this.f14540b);
                String[] strArr4 = u;
                canvas.drawText(strArr4[i8], ((this.f14549k + (this.f14547i * i13)) + i14) - a(strArr4[i8]), this.f14551m + r12, this.f14545g);
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
        this.q.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ui.view.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.a(valueAnimator);
            }
        });
        this.q.setDuration(this.r);
        this.q.start();
    }

    public LevelProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14547i = 12;
        this.f14548j = 8;
        this.f14549k = 45;
        this.p = 0.0f;
        this.r = 1000L;
        this.t = 0.0f;
        a();
    }

    public LevelProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14547i = 12;
        this.f14548j = 8;
        this.f14549k = 45;
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
        return this.f14545g.measureText(str) / 2.0f;
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
