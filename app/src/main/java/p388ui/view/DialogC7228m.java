package p388ui.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;

/* compiled from: ColorPickerDialog.java */
/* renamed from: ui.view.m */
/* loaded from: classes2.dex */
public class DialogC7228m extends Dialog {

    /* renamed from: a */
    private final boolean f24870a;

    /* renamed from: b */
    private final String f24871b;

    /* renamed from: c */
    Context f24872c;

    /* renamed from: d */
    private String f24873d;

    /* renamed from: e */
    private int f24874e;

    /* renamed from: f */
    private b f24875f;

    /* compiled from: ColorPickerDialog.java */
    /* renamed from: ui.view.m$a */
    private class a extends View {

        /* renamed from: a */
        private Paint f24876a;

        /* renamed from: b */
        private Paint f24877b;

        /* renamed from: c */
        private Paint f24878c;

        /* renamed from: d */
        private Paint f24879d;

        /* renamed from: e */
        private Shader f24880e;

        /* renamed from: f */
        private float f24881f;

        /* renamed from: g */
        private float f24882g;

        /* renamed from: h */
        private float f24883h;

        /* renamed from: i */
        private float f24884i;

        /* renamed from: j */
        private final int[] f24885j;

        /* renamed from: k */
        private final int[] f24886k;

        /* renamed from: l */
        private int f24887l;

        /* renamed from: m */
        private int f24888m;

        /* renamed from: n */
        private float f24889n;

        /* renamed from: o */
        private float f24890o;

        /* renamed from: p */
        private boolean f24891p;

        /* renamed from: q */
        private boolean f24892q;

        /* renamed from: r */
        private boolean f24893r;

        /* renamed from: s */
        private boolean f24894s;

        public a(Context context, int i2, int i3) {
            super(context);
            this.f24891p = true;
            int i4 = i2 - 36;
            this.f24887l = i4;
            this.f24888m = i3;
            setMinimumHeight(i4);
            setMinimumWidth(i3);
            this.f24885j = new int[]{SupportMenu.CATEGORY_MASK, -65281, -16776961, -16711681, -16711936, InputDeviceCompat.SOURCE_ANY, SupportMenu.CATEGORY_MASK};
            SweepGradient sweepGradient = new SweepGradient(0.0f, 0.0f, this.f24885j, (float[]) null);
            this.f24876a = new Paint(1);
            this.f24876a.setShader(sweepGradient);
            this.f24876a.setStyle(Paint.Style.STROKE);
            this.f24876a.setStrokeWidth(50.0f);
            this.f24889n = ((i3 / 2) * 0.7f) - (this.f24876a.getStrokeWidth() * 0.5f);
            this.f24877b = new Paint(1);
            this.f24877b.setColor(DialogC7228m.this.f24874e);
            this.f24877b.setStrokeWidth(5.0f);
            this.f24890o = (this.f24889n - (this.f24876a.getStrokeWidth() / 2.0f)) * 0.7f;
            this.f24878c = new Paint(1);
            this.f24878c.setColor(Color.parseColor("#72A1D1"));
            this.f24878c.setStrokeWidth(4.0f);
            this.f24886k = new int[]{ViewCompat.MEASURED_STATE_MASK, this.f24877b.getColor(), -1};
            this.f24879d = new Paint(1);
            this.f24879d.setStrokeWidth(5.0f);
            this.f24881f = (-this.f24889n) - (this.f24876a.getStrokeWidth() * 0.5f);
            this.f24882g = this.f24889n + (this.f24876a.getStrokeWidth() * 0.5f) + (this.f24878c.getStrokeMiter() * 0.5f) + 15.0f;
            this.f24883h = this.f24889n + (this.f24876a.getStrokeWidth() * 0.5f);
            this.f24884i = this.f24882g + 50.0f;
        }

        /* renamed from: a */
        private boolean m25974a(float f2, float f3) {
            return f2 <= this.f24883h && f2 >= this.f24881f && f3 <= this.f24884i && f3 >= this.f24882g;
        }

        /* renamed from: a */
        private boolean m25975a(float f2, float f3, float f4) {
            double d2 = f4;
            return ((double) ((f2 * f2) + (f3 * f3))) * 3.141592653589793d < (d2 * 3.141592653589793d) * d2;
        }

        /* renamed from: a */
        private boolean m25976a(float f2, float f3, float f4, float f5) {
            double d2 = f4;
            double d3 = f5;
            double d4 = ((f2 * f2) + (f3 * f3)) * 3.141592653589793d;
            return d4 < (d2 * 3.141592653589793d) * d2 && d4 > (d3 * 3.141592653589793d) * d3;
        }

        /* renamed from: b */
        private int m25977b(int[] iArr, float f2) {
            int i2;
            int i3;
            float f3;
            if (f2 < 0.0f) {
                i2 = iArr[0];
                i3 = iArr[1];
                f3 = this.f24883h;
                f2 += f3;
            } else {
                i2 = iArr[1];
                i3 = iArr[2];
                f3 = this.f24883h;
            }
            float f4 = f2 / f3;
            return Color.argb(m25972a(Color.alpha(i2), Color.alpha(i3), f4), m25972a(Color.red(i2), Color.red(i3), f4), m25972a(Color.green(i2), Color.green(i3), f4), m25972a(Color.blue(i2), Color.blue(i3), f4));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            canvas.translate(this.f24888m / 2, (this.f24887l / 2) - 50);
            canvas.drawCircle(0.0f, 0.0f, this.f24890o, this.f24877b);
            if (this.f24893r || this.f24894s) {
                int color = this.f24877b.getColor();
                this.f24877b.setStyle(Paint.Style.STROKE);
                if (this.f24893r) {
                    this.f24877b.setAlpha(255);
                } else if (this.f24894s) {
                    this.f24877b.setAlpha(144);
                }
                canvas.drawCircle(0.0f, 0.0f, this.f24890o + this.f24877b.getStrokeWidth(), this.f24877b);
                this.f24877b.setStyle(Paint.Style.FILL);
                this.f24877b.setColor(color);
            }
            float f2 = this.f24889n;
            canvas.drawOval(new RectF(-f2, -f2, f2, f2), this.f24876a);
            if (this.f24891p) {
                this.f24886k[1] = this.f24877b.getColor();
            }
            this.f24880e = new LinearGradient(this.f24881f, 0.0f, this.f24883h, 0.0f, this.f24886k, (float[]) null, Shader.TileMode.MIRROR);
            this.f24879d.setShader(this.f24880e);
            canvas.drawRect(this.f24881f, this.f24882g, this.f24883h, this.f24884i, this.f24879d);
            float strokeWidth = this.f24878c.getStrokeWidth() / 2.0f;
            float f3 = this.f24881f;
            float f4 = 2.0f * strokeWidth;
            canvas.drawLine(f3 - strokeWidth, this.f24882g - f4, f3 - strokeWidth, this.f24884i + f4, this.f24878c);
            float f5 = this.f24881f - f4;
            float f6 = this.f24882g;
            canvas.drawLine(f5, f6 - strokeWidth, this.f24883h + f4, f6 - strokeWidth, this.f24878c);
            float f7 = this.f24883h;
            canvas.drawLine(f7 + strokeWidth, this.f24882g - f4, f7 + strokeWidth, this.f24884i + f4, this.f24878c);
            float f8 = this.f24881f - f4;
            float f9 = this.f24884i;
            canvas.drawLine(f8, f9 + strokeWidth, this.f24883h + f4, f9 + strokeWidth, this.f24878c);
            super.onDraw(canvas);
        }

        @Override // android.view.View
        protected void onMeasure(int i2, int i3) {
            super.onMeasure(this.f24888m, this.f24887l);
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x0044, code lost:
        
            if (r13 != 2) goto L53;
         */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouchEvent(android.view.MotionEvent r13) {
            /*
                Method dump skipped, instructions count: 308
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p388ui.view.DialogC7228m.a.onTouchEvent(android.view.MotionEvent):boolean");
        }

        /* renamed from: a */
        private int m25973a(int[] iArr, float f2) {
            if (f2 <= 0.0f) {
                return iArr[0];
            }
            if (f2 >= 1.0f) {
                return iArr[iArr.length - 1];
            }
            float length = f2 * (iArr.length - 1);
            int i2 = (int) length;
            float f3 = length - i2;
            int i3 = iArr[i2];
            int i4 = iArr[i2 + 1];
            return Color.argb(m25972a(Color.alpha(i3), Color.alpha(i4), f3), m25972a(Color.red(i3), Color.red(i4), f3), m25972a(Color.green(i3), Color.green(i4), f3), m25972a(Color.blue(i3), Color.blue(i4), f3));
        }

        /* renamed from: a */
        private int m25972a(int i2, int i3, float f2) {
            return i2 + Math.round(f2 * (i3 - i2));
        }
    }

    /* compiled from: ColorPickerDialog.java */
    /* renamed from: ui.view.m$b */
    public interface b {
        /* renamed from: a */
        void m25978a(int i2);
    }

    public DialogC7228m(Context context, String str, b bVar) {
        this(context, ViewCompat.MEASURED_STATE_MASK, str, bVar);
    }

    /* renamed from: c */
    public b m25971c() {
        return this.f24875f;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WindowManager windowManager = getWindow().getWindowManager();
        setContentView(new a(this.f24872c, (int) (windowManager.getDefaultDisplay().getHeight() * 0.5f), (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f)));
        m25969a(this.f24873d);
    }

    public void setmListener(b bVar) {
        this.f24875f = bVar;
    }

    public DialogC7228m(Context context, int i2, String str, b bVar) {
        super(context);
        this.f24870a = true;
        this.f24871b = "ColorPicker";
        this.f24872c = context;
        this.f24875f = bVar;
        this.f24874e = i2;
        this.f24873d = str;
    }

    /* renamed from: a */
    public String m25967a() {
        return this.f24873d;
    }

    /* renamed from: b */
    public int m25970b() {
        return this.f24874e;
    }

    /* renamed from: a */
    public void m25969a(String str) {
        this.f24873d = str;
    }

    /* renamed from: a */
    public void m25968a(int i2) {
        this.f24874e = i2;
    }
}
