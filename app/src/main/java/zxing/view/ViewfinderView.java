package zxing.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.hicorenational.antifraud.C2113R;
import java.util.ArrayList;
import java.util.List;
import p031c.p035b.p043c.C1109t;
import p381m.p382a.C5929d;

/* loaded from: classes2.dex */
public final class ViewfinderView extends View {

    /* renamed from: o */
    private static final int[] f25867o = {0, 64, 128, 192, 255, 192, 128, 64};

    /* renamed from: p */
    private static final long f25868p = 80;

    /* renamed from: q */
    private static final int f25869q = 160;

    /* renamed from: r */
    private static final int f25870r = 20;

    /* renamed from: s */
    private static final int f25871s = 6;

    /* renamed from: a */
    private C5929d f25872a;

    /* renamed from: b */
    private final Paint f25873b;

    /* renamed from: c */
    private Bitmap f25874c;

    /* renamed from: d */
    private final int f25875d;

    /* renamed from: e */
    private final int f25876e;

    /* renamed from: f */
    private final int f25877f;

    /* renamed from: g */
    private final int f25878g;

    /* renamed from: h */
    private final int f25879h;

    /* renamed from: i */
    private int f25880i;

    /* renamed from: j */
    private List<C1109t> f25881j;

    /* renamed from: k */
    private List<C1109t> f25882k;

    /* renamed from: l */
    private int f25883l;

    /* renamed from: m */
    private final int f25884m;

    /* renamed from: n */
    Bitmap f25885n;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25884m = 10;
        this.f25873b = new Paint(1);
        Resources resources = getResources();
        this.f25875d = resources.getColor(C2113R.color.viewfinder_mask);
        this.f25876e = resources.getColor(C2113R.color.result_view);
        this.f25877f = resources.getColor(C2113R.color.viewfinder_laser);
        this.f25878g = resources.getColor(C2113R.color.possible_result_points);
        this.f25879h = resources.getColor(C2113R.color.status_text);
        this.f25880i = 0;
        this.f25881j = new ArrayList(5);
        this.f25882k = null;
        this.f25885n = BitmapFactory.decodeResource(resources, C2113R.drawable.scan_light);
    }

    /* renamed from: a */
    private void m26835a(Canvas canvas, Rect rect) {
        this.f25873b.setColor(-1);
        this.f25873b.setStrokeWidth(2.0f);
        this.f25873b.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect, this.f25873b);
        this.f25873b.setColor(Color.parseColor("#21b3e2"));
        this.f25873b.setStyle(Paint.Style.FILL);
        int i2 = rect.left;
        canvas.drawRect(i2 - 10, rect.top, i2, r1 + 45, this.f25873b);
        int i3 = rect.left;
        canvas.drawRect(i3 - 10, r1 - 10, i3 + 45, rect.top, this.f25873b);
        canvas.drawRect(rect.right, rect.top, r0 + 10, r1 + 45, this.f25873b);
        int i4 = rect.right;
        canvas.drawRect(i4 - 45, r1 - 10, i4 + 10, rect.top, this.f25873b);
        canvas.drawRect(r0 - 10, r1 - 45, rect.left, rect.bottom, this.f25873b);
        int i5 = rect.left;
        canvas.drawRect(i5 - 10, rect.bottom, i5 + 45, r1 + 10, this.f25873b);
        canvas.drawRect(rect.right, r1 - 45, r0 + 10, rect.bottom, this.f25873b);
        int i6 = rect.right;
        canvas.drawRect(i6 - 45, rect.bottom, i6 + 10, r10 + 10, this.f25873b);
    }

    /* renamed from: b */
    private void m26837b(Canvas canvas, Rect rect) {
        if (this.f25883l == 0) {
            this.f25883l = rect.top;
        }
        int i2 = this.f25883l;
        if (i2 >= rect.bottom) {
            this.f25883l = rect.top;
        } else {
            this.f25883l = i2 + 10;
        }
        int i3 = rect.left;
        int i4 = this.f25883l;
        canvas.drawBitmap(this.f25885n, (Rect) null, new Rect(i3, i4, rect.right, i4 + 30), this.f25873b);
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        C5929d c5929d = this.f25872a;
        if (c5929d == null) {
            return;
        }
        Rect m24904b = c5929d.m24904b();
        Rect m24905c = this.f25872a.m24905c();
        if (m24904b == null || m24905c == null) {
            return;
        }
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        this.f25873b.setColor(this.f25874c != null ? this.f25876e : this.f25875d);
        float f2 = width;
        canvas.drawRect(0.0f, 0.0f, f2, m24904b.top, this.f25873b);
        canvas.drawRect(0.0f, m24904b.top, m24904b.left, m24904b.bottom + 1, this.f25873b);
        canvas.drawRect(m24904b.right + 1, m24904b.top, f2, m24904b.bottom + 1, this.f25873b);
        canvas.drawRect(0.0f, m24904b.bottom + 1, f2, height, this.f25873b);
        if (this.f25874c != null) {
            this.f25873b.setAlpha(f25869q);
            canvas.drawBitmap(this.f25874c, (Rect) null, m24904b, this.f25873b);
            return;
        }
        m26835a(canvas, m24904b);
        m26836a(canvas, m24904b, width);
        m26837b(canvas, m24904b);
        float width2 = m24904b.width() / m24905c.width();
        float height2 = m24904b.height() / m24905c.height();
        List<C1109t> list = this.f25881j;
        List<C1109t> list2 = this.f25882k;
        int i2 = m24904b.left;
        int i3 = m24904b.top;
        if (list.isEmpty()) {
            this.f25882k = null;
        } else {
            this.f25881j = new ArrayList(5);
            this.f25882k = list;
            this.f25873b.setAlpha(f25869q);
            this.f25873b.setColor(this.f25878g);
            synchronized (list) {
                for (C1109t c1109t : list) {
                    canvas.drawCircle(((int) (c1109t.m1922a() * width2)) + i2, ((int) (c1109t.m1923b() * height2)) + i3, 6.0f, this.f25873b);
                }
            }
        }
        if (list2 != null) {
            this.f25873b.setAlpha(80);
            this.f25873b.setColor(this.f25878g);
            synchronized (list2) {
                for (C1109t c1109t2 : list2) {
                    canvas.drawCircle(((int) (c1109t2.m1922a() * width2)) + i2, ((int) (c1109t2.m1923b() * height2)) + i3, 3.0f, this.f25873b);
                }
            }
        }
        postInvalidateDelayed(f25868p, m24904b.left - 6, m24904b.top - 6, m24904b.right + 6, m24904b.bottom + 6);
    }

    public void setCameraManager(C5929d c5929d) {
        this.f25872a = c5929d;
    }

    /* renamed from: a */
    private void m26836a(Canvas canvas, Rect rect, int i2) {
        String string = getResources().getString(C2113R.string.viewfinderview_status_text1);
        String string2 = getResources().getString(C2113R.string.viewfinderview_status_text2);
        this.f25873b.setColor(this.f25879h);
        this.f25873b.setTextSize(45);
        canvas.drawText(string, (i2 - ((int) this.f25873b.measureText(string))) / 2, rect.top - 180, this.f25873b);
        canvas.drawText(string2, (i2 - ((int) this.f25873b.measureText(string2))) / 2, (rect.top - 180) + 60, this.f25873b);
    }

    /* renamed from: a */
    public void m26838a() {
        Bitmap bitmap = this.f25874c;
        this.f25874c = null;
        if (bitmap != null) {
            bitmap.recycle();
        }
        invalidate();
    }

    /* renamed from: a */
    public void m26839a(Bitmap bitmap) {
        this.f25874c = bitmap;
        invalidate();
    }

    /* renamed from: a */
    public void m26840a(C1109t c1109t) {
        List<C1109t> list = this.f25881j;
        synchronized (list) {
            list.add(c1109t);
            int size = list.size();
            if (size > 20) {
                list.subList(0, size - 10).clear();
            }
        }
    }
}
