package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import com.umeng.analytics.pro.C3351bh;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Rect.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u0000\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\f\u001a\r\u0010\u0004\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0004\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\b\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\b\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0012\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\r\u0010\u0014\u001a\u00020\u0001*\u00020\u0003H\u0086\b\u001a\r\u0010\u0015\u001a\u00020\u0003*\u00020\u0001H\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0011*\u00020\u0001H\u0086\b\u001a\r\u0010\u0016\u001a\u00020\u0011*\u00020\u0003H\u0086\b\u001a\u0015\u0010\u0017\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0086\b\u001a\u0015\u0010\u001a\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u001a\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f¨\u0006\u001b"}, m23546d2 = {"and", "Landroid/graphics/Rect;", "r", "Landroid/graphics/RectF;", "component1", "", "", "component2", "component3", "component4", "contains", "", C3351bh.f11576aA, "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "minus", "xy", "Landroid/graphics/Region;", "or", "plus", "toRect", "toRectF", "toRegion", "transform", "m", "Landroid/graphics/Matrix;", "xor", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class RectKt {
    @SuppressLint({"CheckResult"})
    @InterfaceC5816d
    public static final Rect and(@InterfaceC5816d Rect rect, @InterfaceC5816d Rect rect2) {
        C5544i0.m22546f(rect, "$receiver");
        C5544i0.m22546f(rect2, "r");
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        return rect3;
    }

    public static final int component1(@InterfaceC5816d Rect rect) {
        C5544i0.m22546f(rect, "$receiver");
        return rect.left;
    }

    public static final int component2(@InterfaceC5816d Rect rect) {
        C5544i0.m22546f(rect, "$receiver");
        return rect.top;
    }

    public static final int component3(@InterfaceC5816d Rect rect) {
        C5544i0.m22546f(rect, "$receiver");
        return rect.right;
    }

    public static final int component4(@InterfaceC5816d Rect rect) {
        C5544i0.m22546f(rect, "$receiver");
        return rect.bottom;
    }

    public static final boolean contains(@InterfaceC5816d Rect rect, @InterfaceC5816d Point point) {
        C5544i0.m22546f(rect, "$receiver");
        C5544i0.m22546f(point, C3351bh.f11576aA);
        return rect.contains(point.x, point.y);
    }

    @InterfaceC5816d
    public static final Region minus(@InterfaceC5816d Rect rect, @InterfaceC5816d Rect rect2) {
        C5544i0.m22546f(rect, "$receiver");
        C5544i0.m22546f(rect2, "r");
        Region region = new Region(rect);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    @InterfaceC5816d
    /* renamed from: or */
    public static final Rect m388or(@InterfaceC5816d Rect rect, @InterfaceC5816d Rect rect2) {
        C5544i0.m22546f(rect, "$receiver");
        C5544i0.m22546f(rect2, "r");
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    @InterfaceC5816d
    public static final Rect plus(@InterfaceC5816d Rect rect, @InterfaceC5816d Rect rect2) {
        C5544i0.m22546f(rect, "$receiver");
        C5544i0.m22546f(rect2, "r");
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    @InterfaceC5816d
    public static final Rect toRect(@InterfaceC5816d RectF rectF) {
        C5544i0.m22546f(rectF, "$receiver");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return rect;
    }

    @InterfaceC5816d
    public static final RectF toRectF(@InterfaceC5816d Rect rect) {
        C5544i0.m22546f(rect, "$receiver");
        return new RectF(rect);
    }

    @InterfaceC5816d
    public static final Region toRegion(@InterfaceC5816d Rect rect) {
        C5544i0.m22546f(rect, "$receiver");
        return new Region(rect);
    }

    @InterfaceC5816d
    public static final RectF transform(@InterfaceC5816d RectF rectF, @InterfaceC5816d Matrix matrix) {
        C5544i0.m22546f(rectF, "$receiver");
        C5544i0.m22546f(matrix, "m");
        matrix.mapRect(rectF);
        return rectF;
    }

    @InterfaceC5816d
    public static final Region xor(@InterfaceC5816d Rect rect, @InterfaceC5816d Rect rect2) {
        C5544i0.m22546f(rect, "$receiver");
        C5544i0.m22546f(rect2, "r");
        Region region = new Region(rect);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    public static final float component1(@InterfaceC5816d RectF rectF) {
        C5544i0.m22546f(rectF, "$receiver");
        return rectF.left;
    }

    public static final float component2(@InterfaceC5816d RectF rectF) {
        C5544i0.m22546f(rectF, "$receiver");
        return rectF.top;
    }

    public static final float component3(@InterfaceC5816d RectF rectF) {
        C5544i0.m22546f(rectF, "$receiver");
        return rectF.right;
    }

    public static final float component4(@InterfaceC5816d RectF rectF) {
        C5544i0.m22546f(rectF, "$receiver");
        return rectF.bottom;
    }

    public static final boolean contains(@InterfaceC5816d RectF rectF, @InterfaceC5816d PointF pointF) {
        C5544i0.m22546f(rectF, "$receiver");
        C5544i0.m22546f(pointF, C3351bh.f11576aA);
        return rectF.contains(pointF.x, pointF.y);
    }

    @InterfaceC5816d
    public static final Region toRegion(@InterfaceC5816d RectF rectF) {
        C5544i0.m22546f(rectF, "$receiver");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return new Region(rect);
    }

    @SuppressLint({"CheckResult"})
    @InterfaceC5816d
    public static final RectF and(@InterfaceC5816d RectF rectF, @InterfaceC5816d RectF rectF2) {
        C5544i0.m22546f(rectF, "$receiver");
        C5544i0.m22546f(rectF2, "r");
        RectF rectF3 = new RectF(rectF);
        rectF3.intersect(rectF2);
        return rectF3;
    }

    @InterfaceC5816d
    public static final Region minus(@InterfaceC5816d RectF rectF, @InterfaceC5816d RectF rectF2) {
        C5544i0.m22546f(rectF, "$receiver");
        C5544i0.m22546f(rectF2, "r");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    @InterfaceC5816d
    /* renamed from: or */
    public static final RectF m389or(@InterfaceC5816d RectF rectF, @InterfaceC5816d RectF rectF2) {
        C5544i0.m22546f(rectF, "$receiver");
        C5544i0.m22546f(rectF2, "r");
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    @InterfaceC5816d
    public static final RectF plus(@InterfaceC5816d RectF rectF, @InterfaceC5816d RectF rectF2) {
        C5544i0.m22546f(rectF, "$receiver");
        C5544i0.m22546f(rectF2, "r");
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    @InterfaceC5816d
    public static final Region xor(@InterfaceC5816d RectF rectF, @InterfaceC5816d RectF rectF2) {
        C5544i0.m22546f(rectF, "$receiver");
        C5544i0.m22546f(rectF2, "r");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    @InterfaceC5816d
    public static final Rect plus(@InterfaceC5816d Rect rect, int i2) {
        C5544i0.m22546f(rect, "$receiver");
        Rect rect2 = new Rect(rect);
        rect2.offset(i2, i2);
        return rect2;
    }

    @InterfaceC5816d
    public static final RectF plus(@InterfaceC5816d RectF rectF, float f2) {
        C5544i0.m22546f(rectF, "$receiver");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(f2, f2);
        return rectF2;
    }

    @InterfaceC5816d
    public static final Rect plus(@InterfaceC5816d Rect rect, @InterfaceC5816d Point point) {
        C5544i0.m22546f(rect, "$receiver");
        C5544i0.m22546f(point, "xy");
        Rect rect2 = new Rect(rect);
        rect2.offset(point.x, point.y);
        return rect2;
    }

    @InterfaceC5816d
    public static final Rect minus(@InterfaceC5816d Rect rect, int i2) {
        C5544i0.m22546f(rect, "$receiver");
        Rect rect2 = new Rect(rect);
        int i3 = -i2;
        rect2.offset(i3, i3);
        return rect2;
    }

    @InterfaceC5816d
    public static final RectF plus(@InterfaceC5816d RectF rectF, @InterfaceC5816d PointF pointF) {
        C5544i0.m22546f(rectF, "$receiver");
        C5544i0.m22546f(pointF, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(pointF.x, pointF.y);
        return rectF2;
    }

    @InterfaceC5816d
    public static final RectF minus(@InterfaceC5816d RectF rectF, float f2) {
        C5544i0.m22546f(rectF, "$receiver");
        RectF rectF2 = new RectF(rectF);
        float f3 = -f2;
        rectF2.offset(f3, f3);
        return rectF2;
    }

    @InterfaceC5816d
    public static final Rect minus(@InterfaceC5816d Rect rect, @InterfaceC5816d Point point) {
        C5544i0.m22546f(rect, "$receiver");
        C5544i0.m22546f(point, "xy");
        Rect rect2 = new Rect(rect);
        rect2.offset(-point.x, -point.y);
        return rect2;
    }

    @InterfaceC5816d
    public static final RectF minus(@InterfaceC5816d RectF rectF, @InterfaceC5816d PointF pointF) {
        C5544i0.m22546f(rectF, "$receiver");
        C5544i0.m22546f(pointF, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(-pointF.x, -pointF.y);
        return rectF2;
    }
}
