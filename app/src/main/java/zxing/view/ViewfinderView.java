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
import com.hicorenational.antifraud.R;
import d.b.c.t;
import java.util.ArrayList;
import java.util.List;
import n.a.d;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewfinderView extends View {
    private static final int[] o = {0, 64, 128, 192, 255, 192, 128, 64};
    private static final long p = 80;
    private static final int q = 160;
    private static final int r = 20;
    private static final int s = 6;
    private d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f15170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bitmap f15171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f15172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f15173e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f15174f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f15175g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f15176h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f15177i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<t> f15178j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<t> f15179k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f15180l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f15181m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    Bitmap f15182n;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15181m = 10;
        this.f15170b = new Paint(1);
        Resources resources = getResources();
        this.f15172d = resources.getColor(R.color.viewfinder_mask);
        this.f15173e = resources.getColor(R.color.result_view);
        this.f15174f = resources.getColor(R.color.viewfinder_laser);
        this.f15175g = resources.getColor(R.color.possible_result_points);
        this.f15176h = resources.getColor(R.color.status_text);
        this.f15177i = 0;
        this.f15178j = new ArrayList(5);
        this.f15179k = null;
        this.f15182n = BitmapFactory.decodeResource(resources, R.drawable.scan_light);
    }

    private void a(Canvas canvas, Rect rect) {
        this.f15170b.setColor(-1);
        this.f15170b.setStrokeWidth(2.0f);
        this.f15170b.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect, this.f15170b);
        this.f15170b.setColor(Color.parseColor("#21b3e2"));
        this.f15170b.setStyle(Paint.Style.FILL);
        int i2 = rect.left;
        canvas.drawRect(i2 - 10, rect.top, i2, r1 + 45, this.f15170b);
        int i3 = rect.left;
        canvas.drawRect(i3 - 10, r1 - 10, i3 + 45, rect.top, this.f15170b);
        canvas.drawRect(rect.right, rect.top, r0 + 10, r1 + 45, this.f15170b);
        int i4 = rect.right;
        canvas.drawRect(i4 - 45, r1 - 10, i4 + 10, rect.top, this.f15170b);
        canvas.drawRect(r0 - 10, r1 - 45, rect.left, rect.bottom, this.f15170b);
        int i5 = rect.left;
        canvas.drawRect(i5 - 10, rect.bottom, i5 + 45, r1 + 10, this.f15170b);
        canvas.drawRect(rect.right, r1 - 45, r0 + 10, rect.bottom, this.f15170b);
        int i6 = rect.right;
        canvas.drawRect(i6 - 45, rect.bottom, i6 + 10, r10 + 10, this.f15170b);
    }

    private void b(Canvas canvas, Rect rect) {
        if (this.f15180l == 0) {
            this.f15180l = rect.top;
        }
        int i2 = this.f15180l;
        if (i2 >= rect.bottom) {
            this.f15180l = rect.top;
        } else {
            this.f15180l = i2 + 10;
        }
        int i3 = rect.left;
        int i4 = this.f15180l;
        canvas.drawBitmap(this.f15182n, (Rect) null, new Rect(i3, i4, rect.right, i4 + 30), this.f15170b);
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        d dVar = this.a;
        if (dVar == null) {
            return;
        }
        Rect rectB = dVar.b();
        Rect rectC = this.a.c();
        if (rectB == null || rectC == null) {
            return;
        }
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        this.f15170b.setColor(this.f15171c != null ? this.f15173e : this.f15172d);
        float f2 = width;
        canvas.drawRect(0.0f, 0.0f, f2, rectB.top, this.f15170b);
        canvas.drawRect(0.0f, rectB.top, rectB.left, rectB.bottom + 1, this.f15170b);
        canvas.drawRect(rectB.right + 1, rectB.top, f2, rectB.bottom + 1, this.f15170b);
        canvas.drawRect(0.0f, rectB.bottom + 1, f2, height, this.f15170b);
        if (this.f15171c != null) {
            this.f15170b.setAlpha(q);
            canvas.drawBitmap(this.f15171c, (Rect) null, rectB, this.f15170b);
            return;
        }
        a(canvas, rectB);
        a(canvas, rectB, width);
        b(canvas, rectB);
        float fWidth = rectB.width() / rectC.width();
        float fHeight = rectB.height() / rectC.height();
        List<t> list = this.f15178j;
        List<t> list2 = this.f15179k;
        int i2 = rectB.left;
        int i3 = rectB.top;
        if (list.isEmpty()) {
            this.f15179k = null;
        } else {
            this.f15178j = new ArrayList(5);
            this.f15179k = list;
            this.f15170b.setAlpha(q);
            this.f15170b.setColor(this.f15175g);
            synchronized (list) {
                for (t tVar : list) {
                    canvas.drawCircle(((int) (tVar.a() * fWidth)) + i2, ((int) (tVar.b() * fHeight)) + i3, 6.0f, this.f15170b);
                }
            }
        }
        if (list2 != null) {
            this.f15170b.setAlpha(80);
            this.f15170b.setColor(this.f15175g);
            synchronized (list2) {
                for (t tVar2 : list2) {
                    canvas.drawCircle(((int) (tVar2.a() * fWidth)) + i2, ((int) (tVar2.b() * fHeight)) + i3, 3.0f, this.f15170b);
                }
            }
        }
        postInvalidateDelayed(p, rectB.left - 6, rectB.top - 6, rectB.right + 6, rectB.bottom + 6);
    }

    public void setCameraManager(d dVar) {
        this.a = dVar;
    }

    private void a(Canvas canvas, Rect rect, int i2) {
        String string = getResources().getString(R.string.viewfinderview_status_text1);
        String string2 = getResources().getString(R.string.viewfinderview_status_text2);
        this.f15170b.setColor(this.f15176h);
        this.f15170b.setTextSize(45);
        canvas.drawText(string, (i2 - ((int) this.f15170b.measureText(string))) / 2, rect.top - 180, this.f15170b);
        canvas.drawText(string2, (i2 - ((int) this.f15170b.measureText(string2))) / 2, (rect.top - 180) + 60, this.f15170b);
    }

    public void a() {
        Bitmap bitmap = this.f15171c;
        this.f15171c = null;
        if (bitmap != null) {
            bitmap.recycle();
        }
        invalidate();
    }

    public void a(Bitmap bitmap) {
        this.f15171c = bitmap;
        invalidate();
    }

    public void a(t tVar) {
        List<t> list = this.f15178j;
        synchronized (list) {
            list.add(tVar);
            int size = list.size();
            if (size > 20) {
                list.subList(0, size - 10).clear();
            }
        }
    }
}
