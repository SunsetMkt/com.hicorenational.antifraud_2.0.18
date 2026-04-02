package cn.qqtheme.framework.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.core.view.GravityCompat;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import c.a.a.d.l;
import com.google.android.material.timepicker.TimeModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class WheelView extends View {
    public static final float e0 = 2.0f;
    public static final int f0 = -1;
    public static final int g0 = 16;
    public static final int h0 = -16611122;
    public static final int i0 = -4473925;
    public static final int j0 = -8139290;
    public static final int k0 = 220;
    public static final float l0 = 2.0f;
    public static final int m0 = 3;
    private static final float n0 = 13.0f;
    private static final int o0 = 1;
    private static final int p0 = 2;
    private static final int q0 = 3;
    private static final int r0 = 5;
    private static final float s0 = 0.8f;
    private float A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private float J;
    private long K;
    private int L;
    private int M;
    private int N;
    private int O;
    private f a;

    /* JADX INFO: renamed from: b */
    private GestureDetector f1984b;
    private float b0;

    /* JADX INFO: renamed from: c */
    private g f1985c;
    private boolean c0;

    /* JADX INFO: renamed from: d */
    private h f1986d;
    private boolean d0;

    /* JADX INFO: renamed from: e */
    private boolean f1987e;

    /* JADX INFO: renamed from: f */
    private ScheduledFuture<?> f1988f;

    /* JADX INFO: renamed from: g */
    private Paint f1989g;

    /* JADX INFO: renamed from: h */
    private Paint f1990h;

    /* JADX INFO: renamed from: i */
    private Paint f1991i;

    /* JADX INFO: renamed from: j */
    private Paint f1992j;

    /* JADX INFO: renamed from: k */
    private List<l> f1993k;

    /* JADX INFO: renamed from: l */
    private String f1994l;

    /* JADX INFO: renamed from: m */
    private int f1995m;

    /* JADX INFO: renamed from: n */
    private int f1996n;
    private int o;
    private int p;
    private float q;
    private Typeface r;
    private int s;
    private int t;
    private c u;
    private float v;
    private int w;
    private boolean x;
    private float y;
    private float z;

    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            WheelView.this.a(f3);
            return true;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WheelView.this.f1985c != null) {
                WheelView.this.f1985c.a(WheelView.this.C);
            }
            if (WheelView.this.f1986d != null) {
                WheelView.this.f1986d.a(true, WheelView.this.C, ((l) WheelView.this.f1993k.get(WheelView.this.C)).getName());
            }
        }
    }

    public static class c {

        /* JADX INFO: renamed from: i */
        public static final float f1997i = 0.0f;

        /* JADX INFO: renamed from: j */
        public static final float f1998j = 1.0f;
        protected boolean a;

        /* JADX INFO: renamed from: b */
        protected boolean f1999b;

        /* JADX INFO: renamed from: c */
        protected int f2000c;

        /* JADX INFO: renamed from: d */
        protected int f2001d;

        /* JADX INFO: renamed from: e */
        protected int f2002e;

        /* JADX INFO: renamed from: f */
        protected int f2003f;

        /* JADX INFO: renamed from: g */
        protected float f2004g;

        /* JADX INFO: renamed from: h */
        protected float f2005h;

        public c() {
            this.a = true;
            this.f1999b = false;
            this.f2000c = WheelView.j0;
            this.f2001d = WheelView.i0;
            this.f2002e = 100;
            this.f2003f = 220;
            this.f2004g = 0.1f;
            this.f2005h = 2.0f;
        }

        public c a(boolean z) {
            this.f1999b = z;
            if (z && this.f2000c == -8139290) {
                this.f2000c = this.f2001d;
                this.f2003f = 255;
            }
            return this;
        }

        public c b(boolean z) {
            this.a = z;
            return this;
        }

        public c c(@IntRange(from = 1, to = 255) int i2) {
            this.f2002e = i2;
            return this;
        }

        public c d(@ColorInt int i2) {
            this.f1999b = true;
            this.f2001d = i2;
            return this;
        }

        public String toString() {
            return "visible=" + this.a + ",color=" + this.f2000c + ",alpha=" + this.f2003f + ",thick=" + this.f2005h;
        }

        public c b(@ColorInt int i2) {
            this.f2000c = i2;
            return this;
        }

        public c b(float f2) {
            this.f2005h = f2;
            return this;
        }

        public c a(@IntRange(from = 1, to = 255) int i2) {
            this.f2003f = i2;
            return this;
        }

        public c a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            this.f2004g = f2;
            return this;
        }

        public c(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            this.a = true;
            this.f1999b = false;
            this.f2000c = WheelView.j0;
            this.f2001d = WheelView.i0;
            this.f2002e = 100;
            this.f2003f = 220;
            this.f2004g = 0.1f;
            this.f2005h = 2.0f;
            this.f2004g = f2;
        }
    }

    private static class d extends TimerTask {
        float a = 2.1474836E9f;

        /* JADX INFO: renamed from: b */
        final float f2006b;

        /* JADX INFO: renamed from: c */
        final WheelView f2007c;

        d(WheelView wheelView, float f2) {
            this.f2007c = wheelView;
            this.f2006b = f2;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            if (this.a == 2.1474836E9f) {
                if (Math.abs(this.f2006b) <= 2000.0f) {
                    this.a = this.f2006b;
                } else if (this.f2006b > 0.0f) {
                    this.a = 2000.0f;
                } else {
                    this.a = -2000.0f;
                }
            }
            if (Math.abs(this.a) >= 0.0f && Math.abs(this.a) <= 20.0f) {
                this.f2007c.a();
                this.f2007c.a.sendEmptyMessage(2000);
                return;
            }
            int i2 = (int) ((this.a * 10.0f) / 1000.0f);
            float f2 = i2;
            this.f2007c.A -= f2;
            if (!this.f2007c.x) {
                float f3 = this.f2007c.q;
                float f4 = (-this.f2007c.B) * f3;
                float itemCount = ((this.f2007c.getItemCount() - 1) - this.f2007c.B) * f3;
                double d2 = ((double) f3) * 0.25d;
                if (((double) this.f2007c.A) - d2 < f4) {
                    f4 = this.f2007c.A + f2;
                } else if (((double) this.f2007c.A) + d2 > itemCount) {
                    itemCount = this.f2007c.A + f2;
                }
                if (this.f2007c.A <= f4) {
                    this.a = 40.0f;
                    this.f2007c.A = (int) f4;
                } else if (this.f2007c.A >= itemCount) {
                    this.f2007c.A = (int) itemCount;
                    this.a = -40.0f;
                }
            }
            float f5 = this.a;
            if (f5 < 0.0f) {
                this.a = f5 + 20.0f;
            } else {
                this.a = f5 - 20.0f;
            }
            this.f2007c.a.sendEmptyMessage(1000);
        }
    }

    @Deprecated
    public static class e extends c {
    }

    private static class f extends Handler {

        /* JADX INFO: renamed from: b */
        static final int f2008b = 1000;

        /* JADX INFO: renamed from: c */
        static final int f2009c = 2000;

        /* JADX INFO: renamed from: d */
        static final int f2010d = 3000;
        final WheelView a;

        f(WheelView wheelView) {
            this.a = wheelView;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1000) {
                this.a.invalidate();
            } else if (i2 == 2000) {
                this.a.b(2);
            } else {
                if (i2 != 3000) {
                    return;
                }
                this.a.d();
            }
        }
    }

    public interface g {
        void a(int i2);
    }

    @Deprecated
    public interface h {
        void a(boolean z, int i2, String str);
    }

    @Deprecated
    public interface i extends h {
    }

    private static class j extends TimerTask {
        int a = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: b */
        int f2011b = 0;

        /* JADX INFO: renamed from: c */
        int f2012c;

        /* JADX INFO: renamed from: d */
        final WheelView f2013d;

        j(WheelView wheelView, int i2) {
            this.f2013d = wheelView;
            this.f2012c = i2;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (this.a == Integer.MAX_VALUE) {
                this.a = this.f2012c;
            }
            int i2 = this.a;
            this.f2011b = (int) (i2 * 0.1f);
            if (this.f2011b == 0) {
                if (i2 < 0) {
                    this.f2011b = -1;
                } else {
                    this.f2011b = 1;
                }
            }
            if (Math.abs(this.a) <= 1) {
                this.f2013d.a();
                this.f2013d.a.sendEmptyMessage(PathInterpolatorCompat.MAX_NUM_POINTS);
                return;
            }
            this.f2013d.A += this.f2011b;
            if (!this.f2013d.x) {
                float f2 = this.f2013d.q;
                float itemCount = ((this.f2013d.getItemCount() - 1) - this.f2013d.B) * f2;
                if (this.f2013d.A <= (-this.f2013d.B) * f2 || this.f2013d.A >= itemCount) {
                    this.f2013d.A -= this.f2011b;
                    this.f2013d.a();
                    this.f2013d.a.sendEmptyMessage(PathInterpolatorCompat.MAX_NUM_POINTS);
                    return;
                }
            }
            this.f2013d.a.sendEmptyMessage(1000);
            this.a -= this.f2011b;
        }
    }

    private static class k implements l {
        private String name;

        /* synthetic */ k(String str, a aVar) {
            this(str);
        }

        @Override // c.a.a.d.l
        public String getName() {
            return this.name;
        }

        private k(String str) {
            this.name = str;
        }
    }

    public WheelView(Context context) {
        this(context, null);
    }

    protected int getItemCount() {
        List<l> list = this.f1993k;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final int getSelectedIndex() {
        return this.C;
    }

    /* JADX WARN: Removed duplicated region for block: B:206:0x02d1  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onDraw(Canvas canvas) {
        List<l> list = this.f1993k;
        if (list == null || list.size() == 0) {
            return;
        }
        String[] strArr = new String[this.E];
        this.D = this.B + (((int) (this.A / this.q)) % this.f1993k.size());
        if (this.x) {
            if (this.D < 0) {
                this.D = this.f1993k.size() + this.D;
            }
            if (this.D > this.f1993k.size() - 1) {
                this.D -= this.f1993k.size();
            }
        } else {
            if (this.D < 0) {
                this.D = 0;
            }
            if (this.D > this.f1993k.size() - 1) {
                this.D = this.f1993k.size() - 1;
            }
        }
        float f2 = this.A % this.q;
        int i2 = 0;
        while (true) {
            int i3 = this.E;
            if (i2 >= i3) {
                break;
            }
            int i4 = this.D - ((i3 / 2) - i2);
            if (this.x) {
                strArr[i2] = this.f1993k.get(a(i4)).getName();
            } else if (i4 < 0) {
                strArr[i2] = "";
            } else if (i4 > this.f1993k.size() - 1) {
                strArr[i2] = "";
            } else {
                strArr[i2] = this.f1993k.get(i4).getName();
            }
            i2++;
        }
        c cVar = this.u;
        if (cVar.a) {
            float f3 = cVar.f2004g;
            int i5 = this.G;
            float f4 = this.y;
            float f5 = 1.0f - f3;
            canvas.drawLine(i5 * f3, f4, i5 * f5, f4, this.f1991i);
            int i6 = this.G;
            float f6 = this.z;
            canvas.drawLine(i6 * f3, f6, i6 * f5, f6, this.f1991i);
        }
        c cVar2 = this.u;
        if (cVar2.f1999b) {
            this.f1992j.setColor(cVar2.f2001d);
            this.f1992j.setAlpha(this.u.f2002e);
            canvas.drawRect(0.0f, this.y, this.G, this.z, this.f1992j);
        }
        for (int i7 = 0; i7 < this.E; i7++) {
            canvas.save();
            double d2 = ((this.q * i7) - f2) / this.H;
            float f7 = (float) (90.0d - ((d2 / 3.141592653589793d) * 180.0d));
            if (f7 >= 90.0f || f7 <= -90.0f) {
                canvas.restore();
            } else {
                String strA = a((Object) strArr[i7]);
                String str = (this.f1987e || TextUtils.isEmpty(this.f1994l) || TextUtils.isEmpty(strA)) ? strA : strA + this.f1994l;
                if (this.d0) {
                    c(str);
                    this.M = 17;
                } else {
                    this.M = GravityCompat.START;
                }
                a(str);
                b(str);
                String str2 = strA;
                float fCos = (float) ((((double) this.H) - (Math.cos(d2) * ((double) this.H))) - ((Math.sin(d2) * ((double) this.f1996n)) / 2.0d));
                canvas.translate(0.0f, fCos);
                float f8 = this.y;
                if (fCos > f8 || this.f1996n + fCos < f8) {
                    float f9 = this.z;
                    if (fCos <= f9 && this.f1996n + fCos >= f9) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.G, this.z - fCos);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                        canvas.drawText(str, this.N, this.f1996n - this.b0, this.f1990h);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.z - fCos, this.G, (int) this.q);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * s0);
                        canvas.drawText(str, this.O, this.f1996n, this.f1989g);
                        canvas.restore();
                    } else if (fCos >= this.y) {
                        int i8 = this.f1996n;
                        if (i8 + fCos <= this.z) {
                            canvas.clipRect(0, 0, this.G, i8);
                            float f10 = this.f1996n - this.b0;
                            Iterator<l> it = this.f1993k.iterator();
                            int i9 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                String str3 = str2;
                                if (it.next().getName().equals(str3)) {
                                    this.C = i9;
                                    break;
                                } else {
                                    i9++;
                                    str2 = str3;
                                }
                            }
                            if (this.f1987e && !TextUtils.isEmpty(this.f1994l)) {
                                str = str + this.f1994l;
                            }
                            canvas.drawText(str, this.N, f10, this.f1990h);
                        } else {
                            canvas.save();
                            canvas.clipRect(0.0f, 0.0f, this.G, this.q);
                            canvas.scale(1.0f, ((float) Math.sin(d2)) * s0);
                            float fPow = (float) Math.pow(Math.abs(f7) / 90.0f, 2.2d);
                            int i10 = this.o;
                            if (i10 != 0) {
                                this.f1989g.setTextSkewX((i10 > 0 ? 1 : -1) * (f7 <= 0.0f ? 1 : -1) * 0.5f * fPow);
                                this.f1989g.setAlpha((int) ((1.0f - fPow) * 255.0f));
                            }
                            canvas.drawText(str, this.O + (this.o * fPow), this.f1996n, this.f1989g);
                            canvas.restore();
                        }
                        canvas.restore();
                        this.f1990h.setTextSize(this.p);
                    }
                } else {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.G, this.y - fCos);
                    canvas.scale(1.0f, ((float) Math.sin(d2)) * s0);
                    canvas.drawText(str, this.O, this.f1996n, this.f1989g);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.y - fCos, this.G, (int) this.q);
                    canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                    canvas.drawText(str, this.N, this.f1996n - this.b0, this.f1990h);
                    canvas.restore();
                }
                canvas.restore();
                this.f1990h.setTextSize(this.p);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        this.L = i2;
        g();
        setMeasuredDimension(this.G, this.F);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = this.f1984b.onTouchEvent(motionEvent);
        ViewParent parent = getParent();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.K = System.currentTimeMillis();
            a();
            this.J = motionEvent.getRawY();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        } else if (action != 2) {
            if (!zOnTouchEvent) {
                float y = motionEvent.getY();
                int i2 = this.H;
                double dAcos = Math.acos((i2 - y) / i2) * ((double) this.H);
                float f2 = this.q;
                int i3 = (int) ((dAcos + ((double) (f2 / 2.0f))) / ((double) f2));
                this.I = (int) (((i3 - (this.E / 2)) * f2) - (((this.A % f2) + f2) % f2));
                if (System.currentTimeMillis() - this.K > 120) {
                    b(3);
                } else {
                    b(1);
                }
            }
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        } else {
            float rawY = this.J - motionEvent.getRawY();
            this.J = motionEvent.getRawY();
            this.A += rawY;
            if (!this.x) {
                float f3 = (-this.B) * this.q;
                float size = (this.f1993k.size() - 1) - this.B;
                float f4 = this.q;
                float f5 = size * f4;
                float f6 = this.A;
                if (((double) f6) - (((double) f4) * 0.25d) < f3) {
                    f3 = f6 - rawY;
                } else if (((double) f6) + (((double) f4) * 0.25d) > f5) {
                    f5 = f6 - rawY;
                }
                float f7 = this.A;
                if (f7 < f3) {
                    this.A = (int) f3;
                } else if (f7 > f5) {
                    this.A = (int) f5;
                }
            }
        }
        if (motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public final void setCycleDisable(boolean z) {
        this.x = !z;
    }

    public void setDividerColor(@ColorInt int i2) {
        this.u.b(i2);
        this.f1991i.setColor(i2);
    }

    public void setDividerConfig(c cVar) {
        if (cVar == null) {
            this.u.b(false);
            this.u.a(false);
            return;
        }
        this.u = cVar;
        this.f1991i.setColor(cVar.f2000c);
        this.f1991i.setStrokeWidth(cVar.f2005h);
        this.f1991i.setAlpha(cVar.f2003f);
        this.f1992j.setColor(cVar.f2001d);
        this.f1992j.setAlpha(cVar.f2002e);
    }

    public final void setGravity(int i2) {
        this.M = i2;
    }

    public final void setItems(List<?> list) {
        this.f1993k.clear();
        for (Object obj : list) {
            if (obj instanceof l) {
                this.f1993k.add((l) obj);
            } else {
                if (!(obj instanceof CharSequence) && !(obj instanceof Number)) {
                    throw new IllegalArgumentException("please implements " + l.class.getName());
                }
                this.f1993k.add(new k(obj.toString(), null));
            }
        }
        g();
        invalidate();
    }

    public final void setLabel(String str) {
        a(str, true);
    }

    @Deprecated
    public void setLineConfig(c cVar) {
        setDividerConfig(cVar);
    }

    public final void setLineSpaceMultiplier(@FloatRange(from = 2.0d, to = 4.0d) float f2) {
        this.v = f2;
        e();
    }

    public final void setOffset(@IntRange(from = 1, to = 5) int i2) {
        if (i2 < 1 || i2 > 5) {
            throw new IllegalArgumentException("must between 1 and 5");
        }
        int i3 = (i2 * 2) + 1;
        if (i2 % 2 != 0) {
            i2--;
        }
        setVisibleItemCount(i3 + i2);
    }

    public final void setOnItemSelectListener(g gVar) {
        this.f1985c = gVar;
    }

    @Deprecated
    public final void setOnWheelListener(h hVar) {
        this.f1986d = hVar;
    }

    @Deprecated
    public void setPadding(int i2) {
        setTextPadding(i2);
    }

    public final void setSelectedIndex(int i2) {
        List<l> list = this.f1993k;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.f1993k.size();
        if (i2 == 0 || (i2 > 0 && i2 < size && i2 != this.C)) {
            this.B = i2;
            this.A = 0.0f;
            this.I = 0;
            invalidate();
        }
    }

    public void setTextColor(@ColorInt int i2) {
        this.s = i2;
        this.t = i2;
        this.f1989g.setColor(i2);
        this.f1990h.setColor(i2);
    }

    public void setTextPadding(int i2) {
        this.w = c.a.a.g.b.b(getContext(), i2);
    }

    public final void setTextSize(float f2) {
        if (f2 > 0.0f) {
            this.p = (int) (getContext().getResources().getDisplayMetrics().density * f2);
            this.f1989g.setTextSize(this.p);
            this.f1990h.setTextSize(this.p);
        }
    }

    public void setTextSizeAutoFit(boolean z) {
        this.d0 = z;
    }

    public void setTextSkewXOffset(int i2) {
        this.o = i2;
        if (i2 != 0) {
            this.f1990h.setTextScaleX(1.0f);
        }
    }

    public final void setTypeface(Typeface typeface) {
        this.r = typeface;
        this.f1989g.setTypeface(this.r);
        this.f1990h.setTypeface(this.r);
    }

    public void setUseWeight(boolean z) {
        this.c0 = z;
    }

    public final void setVisibleItemCount(int i2) {
        if (i2 % 2 == 0) {
            throw new IllegalArgumentException("must be odd");
        }
        if (i2 != this.E) {
            this.E = i2;
        }
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1987e = true;
        this.f1993k = new ArrayList();
        this.o = 0;
        this.p = 16;
        this.r = Typeface.DEFAULT;
        this.s = i0;
        this.t = h0;
        this.u = new c();
        this.v = 2.0f;
        this.w = -1;
        this.x = true;
        this.A = 0.0f;
        this.B = -1;
        this.E = 7;
        this.I = 0;
        this.J = 0.0f;
        this.K = 0L;
        this.M = 17;
        this.N = 0;
        this.O = 0;
        this.c0 = false;
        this.d0 = true;
        float f2 = getResources().getDisplayMetrics().density;
        if (f2 < 1.0f) {
            this.b0 = 2.4f;
        } else if (1.0f <= f2 && f2 < 2.0f) {
            this.b0 = 3.6f;
        } else if (1.0f <= f2 && f2 < 2.0f) {
            this.b0 = 4.5f;
        } else if (2.0f <= f2 && f2 < 3.0f) {
            this.b0 = 6.0f;
        } else if (f2 >= 3.0f) {
            this.b0 = f2 * 2.5f;
        }
        e();
        a(context);
    }

    private void c() {
        this.f1989g = new Paint();
        this.f1989g.setAntiAlias(true);
        this.f1989g.setColor(this.s);
        this.f1989g.setTypeface(this.r);
        this.f1989g.setTextSize(this.p);
        this.f1990h = new Paint();
        this.f1990h.setAntiAlias(true);
        this.f1990h.setColor(this.t);
        this.f1990h.setTextScaleX(1.0f);
        this.f1990h.setTypeface(this.r);
        this.f1990h.setTextSize(this.p);
        this.f1991i = new Paint();
        this.f1991i.setAntiAlias(true);
        this.f1991i.setColor(this.u.f2000c);
        this.f1991i.setStrokeWidth(this.u.f2005h);
        this.f1991i.setAlpha(this.u.f2003f);
        this.f1992j = new Paint();
        this.f1992j.setAntiAlias(true);
        this.f1992j.setColor(this.u.f2001d);
        this.f1992j.setAlpha(this.u.f2002e);
        setLayerType(1, null);
    }

    public void d() {
        if (this.f1985c == null && this.f1986d == null) {
            return;
        }
        postDelayed(new b(), 200L);
    }

    private void e() {
        float f2 = this.v;
        if (f2 < 1.5f) {
            this.v = 1.5f;
        } else if (f2 > 4.0f) {
            this.v = 4.0f;
        }
    }

    private void f() {
        Rect rect = new Rect();
        for (int i2 = 0; i2 < this.f1993k.size(); i2++) {
            String strA = a(this.f1993k.get(i2));
            this.f1990h.getTextBounds(strA, 0, strA.length(), rect);
            int iWidth = rect.width();
            if (iWidth > this.f1995m) {
                this.f1995m = iWidth;
            }
            this.f1990h.getTextBounds("\u6d4b\u8bd5", 0, 2, rect);
            this.f1996n = rect.height() + 2;
        }
        this.q = this.v * this.f1996n;
    }

    private void g() {
        int i2;
        if (this.f1993k == null) {
            return;
        }
        f();
        int i3 = (int) (this.q * (this.E - 1));
        this.F = (int) (((double) (i3 * 2)) / 3.141592653589793d);
        this.H = (int) (((double) i3) / 3.141592653589793d);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (this.c0) {
            this.G = View.MeasureSpec.getSize(this.L);
        } else if (layoutParams == null || (i2 = layoutParams.width) <= 0) {
            this.G = this.f1995m;
            if (this.w < 0) {
                this.w = c.a.a.g.b.b(getContext(), n0);
            }
            this.G += this.w * 2;
            if (!TextUtils.isEmpty(this.f1994l)) {
                this.G += a(this.f1990h, this.f1994l);
            }
        } else {
            this.G = i2;
        }
        c.a.a.g.d.b("measuredWidth=" + this.G + ",measuredHeight=" + this.F);
        int i4 = this.F;
        float f2 = this.q;
        this.y = (((float) i4) - f2) / 2.0f;
        this.z = (((float) i4) + f2) / 2.0f;
        if (this.B == -1) {
            if (this.x) {
                this.B = (this.f1993k.size() + 1) / 2;
            } else {
                this.B = 0;
            }
        }
        this.D = this.B;
    }

    private void b() {
        if (isInEditMode()) {
            setItems(new String[]{"\u674e\u7389\u6c5f", "\u7537", "\u8d35\u5dde", "\u7a7f\u9752\u4eba"});
        }
    }

    public final void a(List<?> list, int i2) {
        setItems(list);
        setSelectedIndex(i2);
    }

    public void b(int i2) {
        a();
        if (i2 == 2 || i2 == 3) {
            float f2 = this.A;
            float f3 = this.q;
            this.I = (int) (((f2 % f3) + f3) % f3);
            int i3 = this.I;
            if (i3 > f3 / 2.0f) {
                this.I = (int) (f3 - i3);
            } else {
                this.I = -i3;
            }
        }
        this.f1988f = Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new j(this, this.I), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void a(List<String> list, String str) {
        int iIndexOf = list.indexOf(str);
        if (iIndexOf == -1) {
            iIndexOf = 0;
        }
        a(list, iIndexOf);
    }

    public final void a(String[] strArr, int i2) {
        a(Arrays.asList(strArr), i2);
    }

    public final void a(String[] strArr, String str) {
        a(Arrays.asList(strArr), str);
    }

    public final void a(String str, boolean z) {
        this.f1994l = str;
        this.f1987e = z;
    }

    public final void setItems(String[] strArr) {
        setItems(Arrays.asList(strArr));
    }

    public void a(@ColorInt int i2, @ColorInt int i3) {
        this.s = i2;
        this.t = i3;
        this.f1989g.setColor(i2);
        this.f1990h.setColor(i3);
    }

    private void b(String str) {
        Rect rect = new Rect();
        this.f1989g.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.M;
        if (i2 == 3) {
            this.O = c.a.a.g.b.b(getContext(), 8.0f);
        } else if (i2 == 5) {
            this.O = (this.G - rect.width()) - ((int) this.b0);
        } else {
            if (i2 != 17) {
                return;
            }
            this.O = (int) (((double) (this.G - rect.width())) * 0.5d);
        }
    }

    private void a(Context context) {
        this.a = new f(this);
        this.f1984b = new GestureDetector(context, new a());
        this.f1984b.setIsLongpressEnabled(false);
        c();
        b();
    }

    public void a(float f2) {
        a();
        this.f1988f = Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new d(this, f2), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    private void c(String str) {
        Rect rect = new Rect();
        this.f1990h.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.p;
        for (int iWidth = rect.width(); iWidth > this.G; iWidth = rect.width()) {
            i2--;
            this.f1990h.setTextSize(i2);
            this.f1990h.getTextBounds(str, 0, str.length(), rect);
        }
        this.f1989g.setTextSize(i2);
    }

    public void a() {
        ScheduledFuture<?> scheduledFuture = this.f1988f;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.f1988f.cancel(true);
        this.f1988f = null;
    }

    private int a(int i2) {
        if (i2 < 0) {
            return a(i2 + this.f1993k.size());
        }
        return i2 > this.f1993k.size() + (-1) ? a(i2 - this.f1993k.size()) : i2;
    }

    private String a(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof l) {
            return ((l) obj).getName();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void a(String str) {
        Rect rect = new Rect();
        this.f1990h.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.M;
        if (i2 == 3) {
            this.N = c.a.a.g.b.b(getContext(), 8.0f);
        } else if (i2 == 5) {
            this.N = (this.G - rect.width()) - ((int) this.b0);
        } else {
            if (i2 != 17) {
                return;
            }
            this.N = (int) (((double) (this.G - rect.width())) * 0.5d);
        }
    }

    private int a(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        paint.getTextWidths(str, new float[length]);
        int iCeil = 0;
        for (int i2 = 0; i2 < length; i2++) {
            iCeil += (int) Math.ceil(r2[i2]);
        }
        return iCeil;
    }
}
