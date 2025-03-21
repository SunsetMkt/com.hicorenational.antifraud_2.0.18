package p388ui.view;

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
import com.hicorenational.antifraud.C2113R;
import util.C7337y1;

/* loaded from: classes2.dex */
public class LevelProgressView extends View {

    /* renamed from: u */
    public static final String[] f24526u = {"0", "200", "500", "800", "1500", "3000", "8000", "15000"};

    /* renamed from: a */
    private Paint f24527a;

    /* renamed from: b */
    private Paint f24528b;

    /* renamed from: c */
    private Paint f24529c;

    /* renamed from: d */
    private Paint f24530d;

    /* renamed from: e */
    private Paint f24531e;

    /* renamed from: f */
    private Paint f24532f;

    /* renamed from: g */
    private Paint f24533g;

    /* renamed from: h */
    private Paint f24534h;

    /* renamed from: i */
    private int f24535i;

    /* renamed from: j */
    private int f24536j;

    /* renamed from: k */
    private int f24537k;

    /* renamed from: l */
    private int f24538l;

    /* renamed from: m */
    private int f24539m;

    /* renamed from: n */
    private Paint f24540n;

    /* renamed from: o */
    private Bitmap f24541o;

    /* renamed from: p */
    private float f24542p;

    /* renamed from: q */
    private ValueAnimator f24543q;

    /* renamed from: r */
    private long f24544r;

    /* renamed from: s */
    private View f24545s;

    /* renamed from: t */
    private float f24546t;

    public LevelProgressView(Context context) {
        super(context);
        this.f24535i = 12;
        this.f24536j = 8;
        this.f24537k = 45;
        this.f24542p = 0.0f;
        this.f24544r = 1000L;
        this.f24546t = 0.0f;
        m25770a();
    }

    /* renamed from: a */
    public void m25770a() {
        Typeface create = Typeface.create(Typeface.SANS_SERIF, 1);
        this.f24527a = new Paint();
        this.f24527a.setStyle(Paint.Style.FILL);
        this.f24527a.setColor(Color.parseColor("#ffffff"));
        this.f24527a.setAntiAlias(true);
        this.f24530d = new Paint();
        this.f24530d.setStyle(Paint.Style.FILL);
        this.f24530d.setColor(Color.parseColor("#ffffff"));
        this.f24530d.setAntiAlias(true);
        this.f24528b = new Paint();
        this.f24528b.setStyle(Paint.Style.FILL);
        this.f24528b.setColor(Color.parseColor("#D1D2D6"));
        this.f24528b.setAntiAlias(true);
        this.f24531e = new Paint();
        this.f24531e.setStyle(Paint.Style.FILL);
        this.f24531e.setColor(Color.parseColor("#333333"));
        this.f24531e.setAntiAlias(true);
        this.f24529c = new Paint();
        this.f24529c.setColor(Color.parseColor("#D1D2D6"));
        this.f24529c.setStrokeWidth(4.0f);
        this.f24532f = new Paint();
        this.f24532f.setColor(Color.parseColor("#333333"));
        this.f24532f.setStrokeWidth(4.0f);
        this.f24533g = new Paint();
        this.f24533g.setAntiAlias(true);
        this.f24533g.setColor(Color.parseColor("#CCCCCC"));
        this.f24533g.setTextSize(m25768a(getContext(), 10.0f));
        this.f24533g.setTypeface(create);
        this.f24534h = new Paint();
        this.f24534h.setAntiAlias(true);
        this.f24534h.setColor(Color.parseColor("#333333"));
        this.f24534h.setTextSize(m25768a(getContext(), 10.0f));
        this.f24534h.setTypeface(create);
        this.f24540n = new Paint();
        this.f24540n.setAntiAlias(true);
        this.f24541o = BitmapFactory.decodeResource(getResources(), C2113R.drawable.iv_level_point);
        this.f24537k = m25768a(getContext(), 16.0f);
        this.f24536j = m25768a(getContext(), 3.0f);
        this.f24535i = m25768a(getContext(), 4.0f);
        this.f24538l = m25768a(getContext(), 15.0f);
        this.f24539m = m25768a(getContext(), 18.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i2;
        int i3;
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        int width2 = this.f24545s.getWidth();
        int i4 = this.f24537k;
        String[] strArr = f24526u;
        int length = ((width - (i4 * 2)) - ((strArr.length * 2) * this.f24535i)) / (strArr.length - 1);
        float f2 = height / 2;
        canvas.drawLine((r6 * 2) + i4, f2, (width - i4) - (r6 * 2), f2, this.f24529c);
        float f3 = this.f24542p;
        if (f3 == 0.0f) {
            this.f24546t = this.f24537k + (this.f24535i * 1);
            i3 = 1;
        } else {
            if (f3 != 15000.0f) {
                i2 = 0;
                while (true) {
                    String[] strArr2 = f24526u;
                    if (i2 >= strArr2.length) {
                        i3 = 0;
                        break;
                    }
                    int parseInt = Integer.parseInt(strArr2[i2]);
                    i2++;
                    int parseInt2 = Integer.parseInt(f24526u[i2]);
                    float f4 = this.f24542p;
                    float f5 = parseInt;
                    if (f4 >= f5 && f4 < parseInt2) {
                        float f6 = ((f4 - f5) / (parseInt2 - parseInt)) * length;
                        int i5 = i2 - 1;
                        this.f24546t = this.f24537k + (this.f24535i * ((i5 * 2) + 1)) + (i5 * length) + f6;
                        break;
                    }
                }
            } else {
                i2 = f24526u.length;
                int i6 = i2 - 1;
                this.f24546t = this.f24537k + (this.f24535i * ((i6 * 2) + 1)) + (i6 * length);
            }
            i3 = i2;
        }
        C7337y1.m26723a(this.f24545s, 0L, ((width - width2) * this.f24546t) / width);
        canvas.drawLine(this.f24537k + this.f24535i, f2, this.f24546t, f2, this.f24532f);
        canvas.drawBitmap(this.f24541o, this.f24546t - this.f24536j, r12 - this.f24538l, this.f24540n);
        for (int i7 = 0; i7 < f24526u.length; i7++) {
            if (i7 < i3) {
                int i8 = this.f24537k;
                int i9 = (i7 * 2) + 1;
                int i10 = length * i7;
                canvas.drawCircle(i8 + (r2 * i9) + i10, f2, this.f24535i, this.f24530d);
                canvas.drawCircle(this.f24537k + (this.f24535i * i9) + i10, f2, this.f24536j, this.f24531e);
                String[] strArr3 = f24526u;
                canvas.drawText(strArr3[i7], ((this.f24537k + (this.f24535i * i9)) + i10) - m25769a(strArr3[i7]), this.f24539m + r12, this.f24534h);
            } else {
                int i11 = this.f24537k;
                int i12 = (i7 * 2) + 1;
                int i13 = length * i7;
                canvas.drawCircle(i11 + (r2 * i12) + i13, f2, this.f24535i, this.f24527a);
                canvas.drawCircle(this.f24537k + (this.f24535i * i12) + i13, f2, this.f24536j, this.f24528b);
                String[] strArr4 = f24526u;
                canvas.drawText(strArr4[i7], ((this.f24537k + (this.f24535i * i12)) + i13) - m25769a(strArr4[i7]), this.f24539m + r12, this.f24533g);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        getSuggestedMinimumWidth();
        super.onMeasure(i2, i3);
    }

    public void setLevelPointView(View view) {
        this.f24545s = view;
    }

    public void setProgress(float f2) {
        if (f2 <= 0.0f) {
            f2 = 0.0f;
        }
        if (f2 >= 15000.0f) {
            f2 = 15000.0f;
        }
        this.f24543q = ValueAnimator.ofFloat(0.0f, Float.valueOf(f2).floatValue());
        this.f24543q.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ui.view.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LevelProgressView.this.m25771a(valueAnimator);
            }
        });
        this.f24543q.setDuration(this.f24544r);
        this.f24543q.start();
    }

    public LevelProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24535i = 12;
        this.f24536j = 8;
        this.f24537k = 45;
        this.f24542p = 0.0f;
        this.f24544r = 1000L;
        this.f24546t = 0.0f;
        m25770a();
    }

    public LevelProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24535i = 12;
        this.f24536j = 8;
        this.f24537k = 45;
        this.f24542p = 0.0f;
        this.f24544r = 1000L;
        this.f24546t = 0.0f;
        m25770a();
    }

    /* renamed from: a */
    public /* synthetic */ void m25771a(ValueAnimator valueAnimator) {
        this.f24542p = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* renamed from: a */
    public float m25769a(String str) {
        return this.f24533g.measureText(str) / 2.0f;
    }

    /* renamed from: a */
    public static int m25768a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
