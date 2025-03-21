package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Iterator;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Region.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0007\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\n\u001a0\u0010\b\u001a\u00020\t*\u00020\u00012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u000bH\u0086\b\u001a\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010*\u00020\u0001H\u0086\u0002\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f¨\u0006\u0017"}, m23546d2 = {"and", "Landroid/graphics/Region;", "r", "Landroid/graphics/Rect;", "contains", "", C3351bh.f11576aA, "Landroid/graphics/Point;", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "rect", "iterator", "", "minus", "not", "or", "plus", "unaryMinus", "xor", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class RegionKt {
    @InterfaceC5816d
    public static final Region and(@InterfaceC5816d Region region, @InterfaceC5816d Rect rect) {
        C5544i0.m22546f(region, "$receiver");
        C5544i0.m22546f(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.INTERSECT);
        return region2;
    }

    public static final boolean contains(@InterfaceC5816d Region region, @InterfaceC5816d Point point) {
        C5544i0.m22546f(region, "$receiver");
        C5544i0.m22546f(point, C3351bh.f11576aA);
        return region.contains(point.x, point.y);
    }

    public static final void forEach(@InterfaceC5816d Region region, @InterfaceC5816d InterfaceC5506l<? super Rect, C5715y1> interfaceC5506l) {
        C5544i0.m22546f(region, "$receiver");
        C5544i0.m22546f(interfaceC5506l, "action");
        RegionIterator regionIterator = new RegionIterator(region);
        while (true) {
            Rect rect = new Rect();
            if (!regionIterator.next(rect)) {
                return;
            } else {
                interfaceC5506l.invoke(rect);
            }
        }
    }

    @InterfaceC5816d
    public static final Iterator<Rect> iterator(@InterfaceC5816d Region region) {
        C5544i0.m22546f(region, "$receiver");
        return new RegionKt$iterator$1(region);
    }

    @InterfaceC5816d
    public static final Region minus(@InterfaceC5816d Region region, @InterfaceC5816d Rect rect) {
        C5544i0.m22546f(region, "$receiver");
        C5544i0.m22546f(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.DIFFERENCE);
        return region2;
    }

    @InterfaceC5816d
    public static final Region not(@InterfaceC5816d Region region) {
        C5544i0.m22546f(region, "$receiver");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    @InterfaceC5816d
    /* renamed from: or */
    public static final Region m390or(@InterfaceC5816d Region region, @InterfaceC5816d Rect rect) {
        C5544i0.m22546f(region, "$receiver");
        C5544i0.m22546f(rect, "r");
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    @InterfaceC5816d
    public static final Region plus(@InterfaceC5816d Region region, @InterfaceC5816d Rect rect) {
        C5544i0.m22546f(region, "$receiver");
        C5544i0.m22546f(rect, "r");
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    @InterfaceC5816d
    public static final Region unaryMinus(@InterfaceC5816d Region region) {
        C5544i0.m22546f(region, "$receiver");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    @InterfaceC5816d
    public static final Region xor(@InterfaceC5816d Region region, @InterfaceC5816d Rect rect) {
        C5544i0.m22546f(region, "$receiver");
        C5544i0.m22546f(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.XOR);
        return region2;
    }

    @InterfaceC5816d
    public static final Region and(@InterfaceC5816d Region region, @InterfaceC5816d Region region2) {
        C5544i0.m22546f(region, "$receiver");
        C5544i0.m22546f(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.INTERSECT);
        return region3;
    }

    @InterfaceC5816d
    public static final Region minus(@InterfaceC5816d Region region, @InterfaceC5816d Region region2) {
        C5544i0.m22546f(region, "$receiver");
        C5544i0.m22546f(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.DIFFERENCE);
        return region3;
    }

    @InterfaceC5816d
    /* renamed from: or */
    public static final Region m391or(@InterfaceC5816d Region region, @InterfaceC5816d Region region2) {
        C5544i0.m22546f(region, "$receiver");
        C5544i0.m22546f(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    @InterfaceC5816d
    public static final Region plus(@InterfaceC5816d Region region, @InterfaceC5816d Region region2) {
        C5544i0.m22546f(region, "$receiver");
        C5544i0.m22546f(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    @InterfaceC5816d
    public static final Region xor(@InterfaceC5816d Region region, @InterfaceC5816d Region region2) {
        C5544i0.m22546f(region, "$receiver");
        C5544i0.m22546f(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.XOR);
        return region3;
    }
}
