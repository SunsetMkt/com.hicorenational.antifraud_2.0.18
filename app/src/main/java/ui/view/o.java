package ui.view;

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
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.xiaomi.mipush.sdk.Constants;
import util.s1;

/* JADX INFO: compiled from: ColorPickerDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class o extends Dialog {
    private final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Context f14740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f14741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f14743f;

    /* JADX INFO: compiled from: ColorPickerDialog.java */
    private class a extends View {
        private Paint a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Paint f14744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Paint f14745c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Paint f14746d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Shader f14747e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f14748f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f14749g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f14750h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private float f14751i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int[] f14752j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int[] f14753k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f14754l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f14755m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private float f14756n;
        private float o;
        private boolean p;
        private boolean q;
        private boolean r;
        private boolean s;

        public a(Context context, int i2, int i3) {
            super(context);
            this.p = true;
            int i4 = i2 - 36;
            this.f14754l = i4;
            this.f14755m = i3;
            setMinimumHeight(i4);
            setMinimumWidth(i3);
            this.f14752j = new int[]{SupportMenu.CATEGORY_MASK, -65281, -16776961, -16711681, -16711936, InputDeviceCompat.SOURCE_ANY, SupportMenu.CATEGORY_MASK};
            SweepGradient sweepGradient = new SweepGradient(0.0f, 0.0f, this.f14752j, (float[]) null);
            this.a = new Paint(1);
            this.a.setShader(sweepGradient);
            this.a.setStyle(Paint.Style.STROKE);
            this.a.setStrokeWidth(50.0f);
            this.f14756n = ((i3 / 2) * 0.7f) - (this.a.getStrokeWidth() * 0.5f);
            this.f14744b = new Paint(1);
            this.f14744b.setColor(o.this.f14742e);
            this.f14744b.setStrokeWidth(5.0f);
            this.o = (this.f14756n - (this.a.getStrokeWidth() / 2.0f)) * 0.7f;
            this.f14745c = new Paint(1);
            this.f14745c.setColor(Color.parseColor("#72A1D1"));
            this.f14745c.setStrokeWidth(4.0f);
            this.f14753k = new int[]{ViewCompat.MEASURED_STATE_MASK, this.f14744b.getColor(), -1};
            this.f14746d = new Paint(1);
            this.f14746d.setStrokeWidth(5.0f);
            this.f14748f = (-this.f14756n) - (this.a.getStrokeWidth() * 0.5f);
            this.f14749g = this.f14756n + (this.a.getStrokeWidth() * 0.5f) + (this.f14745c.getStrokeMiter() * 0.5f) + 15.0f;
            this.f14750h = this.f14756n + (this.a.getStrokeWidth() * 0.5f);
            this.f14751i = this.f14749g + 50.0f;
        }

        private boolean a(float f2, float f3) {
            return f2 <= this.f14750h && f2 >= this.f14748f && f3 <= this.f14751i && f3 >= this.f14749g;
        }

        private boolean a(float f2, float f3, float f4) {
            double d2 = f4;
            return ((double) ((f2 * f2) + (f3 * f3))) * 3.141592653589793d < (d2 * 3.141592653589793d) * d2;
        }

        private boolean a(float f2, float f3, float f4, float f5) {
            double d2 = f4;
            double d3 = f5;
            double d4 = ((double) ((f2 * f2) + (f3 * f3))) * 3.141592653589793d;
            return d4 < (d2 * 3.141592653589793d) * d2 && d4 > (d3 * 3.141592653589793d) * d3;
        }

        private int b(int[] iArr, float f2) {
            int i2;
            int i3;
            float f3;
            if (f2 < 0.0f) {
                i2 = iArr[0];
                i3 = iArr[1];
                f3 = this.f14750h;
                f2 += f3;
            } else {
                i2 = iArr[1];
                i3 = iArr[2];
                f3 = this.f14750h;
            }
            float f4 = f2 / f3;
            return Color.argb(a(Color.alpha(i2), Color.alpha(i3), f4), a(Color.red(i2), Color.red(i3), f4), a(Color.green(i2), Color.green(i3), f4), a(Color.blue(i2), Color.blue(i3), f4));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            canvas.translate(this.f14755m / 2, (this.f14754l / 2) - 50);
            canvas.drawCircle(0.0f, 0.0f, this.o, this.f14744b);
            if (this.r || this.s) {
                int color = this.f14744b.getColor();
                this.f14744b.setStyle(Paint.Style.STROKE);
                if (this.r) {
                    this.f14744b.setAlpha(255);
                } else if (this.s) {
                    this.f14744b.setAlpha(144);
                }
                canvas.drawCircle(0.0f, 0.0f, this.o + this.f14744b.getStrokeWidth(), this.f14744b);
                this.f14744b.setStyle(Paint.Style.FILL);
                this.f14744b.setColor(color);
            }
            float f2 = this.f14756n;
            canvas.drawOval(new RectF(-f2, -f2, f2, f2), this.a);
            if (this.p) {
                this.f14753k[1] = this.f14744b.getColor();
            }
            this.f14747e = new LinearGradient(this.f14748f, 0.0f, this.f14750h, 0.0f, this.f14753k, (float[]) null, Shader.TileMode.MIRROR);
            this.f14746d.setShader(this.f14747e);
            canvas.drawRect(this.f14748f, this.f14749g, this.f14750h, this.f14751i, this.f14746d);
            float strokeWidth = this.f14745c.getStrokeWidth() / 2.0f;
            float f3 = this.f14748f;
            float f4 = 2.0f * strokeWidth;
            canvas.drawLine(f3 - strokeWidth, this.f14749g - f4, f3 - strokeWidth, this.f14751i + f4, this.f14745c);
            float f5 = this.f14748f - f4;
            float f6 = this.f14749g;
            canvas.drawLine(f5, f6 - strokeWidth, this.f14750h + f4, f6 - strokeWidth, this.f14745c);
            float f7 = this.f14750h;
            canvas.drawLine(f7 + strokeWidth, this.f14749g - f4, f7 + strokeWidth, this.f14751i + f4, this.f14745c);
            float f8 = this.f14748f - f4;
            float f9 = this.f14751i;
            canvas.drawLine(f8, f9 + strokeWidth, this.f14750h + f4, f9 + strokeWidth, this.f14745c);
            super.onDraw(canvas);
        }

        @Override // android.view.View
        protected void onMeasure(int i2, int i3) {
            super.onMeasure(this.f14755m, this.f14754l);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            float x = motionEvent.getX() - (this.f14755m / 2);
            float y = (motionEvent.getY() - (this.f14754l / 2)) + 50.0f;
            boolean zA = a(x, y, this.f14756n + (this.a.getStrokeWidth() / 2.0f), this.f14756n - (this.a.getStrokeWidth() / 2.0f));
            boolean zA2 = a(x, y, this.o);
            boolean zA3 = a(x, y);
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    if (this.r && zA2 && o.this.f14743f != null) {
                        o.this.f14743f.a(this.f14744b.getColor());
                        o.this.dismiss();
                    }
                    if (this.p) {
                        this.p = false;
                    }
                    if (this.q) {
                        this.q = false;
                    }
                    if (this.r) {
                        this.r = false;
                    }
                    if (this.s) {
                        this.s = false;
                    }
                    invalidate();
                } else if (action == 2) {
                }
                return true;
            }
            this.p = zA;
            this.q = zA3;
            this.r = zA2;
            if (this.p && zA) {
                float fAtan2 = (float) (((double) ((float) Math.atan2(y, x))) / 6.283185307179586d);
                if (fAtan2 < 0.0f) {
                    fAtan2 += 1.0f;
                }
                this.f14744b.setColor(a(this.f14752j, fAtan2));
                s1.e("ColorPicker", "\u8272\u73af\u5185, \u5750\u6807: " + x + Constants.ACCEPT_TIME_SEPARATOR_SP + y);
            } else if (this.q && zA3) {
                this.f14744b.setColor(b(this.f14753k, x));
            }
            s1.e("ColorPicker", "[MOVE] \u9ad8\u4eae: " + this.r + "\u5fae\u4eae: " + this.s + " \u4e2d\u5fc3: " + zA2);
            if ((this.r && zA2) || (this.s && zA2)) {
                this.r = true;
                this.s = false;
            } else if (this.r || this.s) {
                this.r = false;
                this.s = true;
            } else {
                this.r = false;
                this.s = false;
            }
            invalidate();
            return true;
        }

        private int a(int[] iArr, float f2) {
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
            return Color.argb(a(Color.alpha(i3), Color.alpha(i4), f3), a(Color.red(i3), Color.red(i4), f3), a(Color.green(i3), Color.green(i4), f3), a(Color.blue(i3), Color.blue(i4), f3));
        }

        private int a(int i2, int i3, float f2) {
            return i2 + Math.round(f2 * (i3 - i2));
        }
    }

    /* JADX INFO: compiled from: ColorPickerDialog.java */
    public interface b {
        void a(int i2);
    }

    public o(Context context, String str, b bVar) {
        this(context, ViewCompat.MEASURED_STATE_MASK, str, bVar);
    }

    public b c() {
        return this.f14743f;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WindowManager windowManager = getWindow().getWindowManager();
        setContentView(new a(this.f14740c, (int) (windowManager.getDefaultDisplay().getHeight() * 0.5f), (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f)));
        a(this.f14741d);
    }

    public void setmListener(b bVar) {
        this.f14743f = bVar;
    }

    public o(Context context, int i2, String str, b bVar) {
        super(context);
        this.a = true;
        this.f14739b = "ColorPicker";
        this.f14740c = context;
        this.f14743f = bVar;
        this.f14742e = i2;
        this.f14741d = str;
    }

    public String a() {
        return this.f14741d;
    }

    public int b() {
        return this.f14742e;
    }

    public void a(String str) {
        this.f14741d = str;
    }

    public void a(int i2) {
        this.f14742e = i2;
    }
}
