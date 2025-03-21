package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import com.umeng.analytics.pro.C3351bh;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Point.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0086\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0086\n\u001a\r\u0010\n\u001a\u00020\u0002*\u00020\u0004H\u0086\b\u001a\r\u0010\u000b\u001a\u00020\u0004*\u00020\u0002H\u0086\b\u001a\r\u0010\f\u001a\u00020\u0002*\u00020\u0002H\u0086\n\u001a\r\u0010\f\u001a\u00020\u0004*\u00020\u0004H\u0086\n¨\u0006\r"}, m23546d2 = {"component1", "", "Landroid/graphics/Point;", "", "Landroid/graphics/PointF;", "component2", "minus", C3351bh.f11576aA, "xy", "plus", "toPoint", "toPointF", "unaryMinus", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class PointKt {
    public static final int component1(@InterfaceC5816d Point point) {
        C5544i0.m22546f(point, "$receiver");
        return point.x;
    }

    public static final int component2(@InterfaceC5816d Point point) {
        C5544i0.m22546f(point, "$receiver");
        return point.y;
    }

    @InterfaceC5816d
    public static final Point minus(@InterfaceC5816d Point point, @InterfaceC5816d Point point2) {
        C5544i0.m22546f(point, "$receiver");
        C5544i0.m22546f(point2, C3351bh.f11576aA);
        Point point3 = new Point(point.x, point.y);
        point3.offset(-point2.x, -point2.y);
        return point3;
    }

    @InterfaceC5816d
    public static final Point plus(@InterfaceC5816d Point point, @InterfaceC5816d Point point2) {
        C5544i0.m22546f(point, "$receiver");
        C5544i0.m22546f(point2, C3351bh.f11576aA);
        Point point3 = new Point(point.x, point.y);
        point3.offset(point2.x, point2.y);
        return point3;
    }

    @InterfaceC5816d
    public static final Point toPoint(@InterfaceC5816d PointF pointF) {
        C5544i0.m22546f(pointF, "$receiver");
        return new Point((int) pointF.x, (int) pointF.y);
    }

    @InterfaceC5816d
    public static final PointF toPointF(@InterfaceC5816d Point point) {
        C5544i0.m22546f(point, "$receiver");
        return new PointF(point);
    }

    @InterfaceC5816d
    public static final Point unaryMinus(@InterfaceC5816d Point point) {
        C5544i0.m22546f(point, "$receiver");
        return new Point(-point.x, -point.y);
    }

    public static final float component1(@InterfaceC5816d PointF pointF) {
        C5544i0.m22546f(pointF, "$receiver");
        return pointF.x;
    }

    public static final float component2(@InterfaceC5816d PointF pointF) {
        C5544i0.m22546f(pointF, "$receiver");
        return pointF.y;
    }

    @InterfaceC5816d
    public static final PointF unaryMinus(@InterfaceC5816d PointF pointF) {
        C5544i0.m22546f(pointF, "$receiver");
        return new PointF(-pointF.x, -pointF.y);
    }

    @InterfaceC5816d
    public static final PointF minus(@InterfaceC5816d PointF pointF, @InterfaceC5816d PointF pointF2) {
        C5544i0.m22546f(pointF, "$receiver");
        C5544i0.m22546f(pointF2, C3351bh.f11576aA);
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(-pointF2.x, -pointF2.y);
        return pointF3;
    }

    @InterfaceC5816d
    public static final PointF plus(@InterfaceC5816d PointF pointF, @InterfaceC5816d PointF pointF2) {
        C5544i0.m22546f(pointF, "$receiver");
        C5544i0.m22546f(pointF2, C3351bh.f11576aA);
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(pointF2.x, pointF2.y);
        return pointF3;
    }

    @InterfaceC5816d
    public static final Point minus(@InterfaceC5816d Point point, int i2) {
        C5544i0.m22546f(point, "$receiver");
        Point point2 = new Point(point.x, point.y);
        int i3 = -i2;
        point2.offset(i3, i3);
        return point2;
    }

    @InterfaceC5816d
    public static final Point plus(@InterfaceC5816d Point point, int i2) {
        C5544i0.m22546f(point, "$receiver");
        Point point2 = new Point(point.x, point.y);
        point2.offset(i2, i2);
        return point2;
    }

    @InterfaceC5816d
    public static final PointF minus(@InterfaceC5816d PointF pointF, float f2) {
        C5544i0.m22546f(pointF, "$receiver");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        float f3 = -f2;
        pointF2.offset(f3, f3);
        return pointF2;
    }

    @InterfaceC5816d
    public static final PointF plus(@InterfaceC5816d PointF pointF, float f2) {
        C5544i0.m22546f(pointF, "$receiver");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(f2, f2);
        return pointF2;
    }
}
