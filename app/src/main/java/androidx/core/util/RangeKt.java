package androidx.core.util;

import android.util.Range;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p319v2.InterfaceC5638g;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Range.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\f\u001a6\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\u0007\u001a7\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\n\u001a0\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u00022\u0006\u0010\t\u001a\u0002H\u0002H\u0087\f¢\u0006\u0002\u0010\n\u001a(\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a(\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0007¨\u0006\u000e"}, m23546d2 = {"and", "Landroid/util/Range;", ExifInterface.GPS_DIRECTION_TRUE, "", DispatchConstants.OTHER, "plus", SurveyH5Bean.VALUE, "(Landroid/util/Range;Ljava/lang/Comparable;)Landroid/util/Range;", "rangeTo", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Landroid/util/Range;", "toClosedRange", "Lkotlin/ranges/ClosedRange;", "toRange", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class RangeKt {
    @RequiresApi(21)
    @InterfaceC5816d
    public static final <T extends Comparable<? super T>> Range<T> and(@InterfaceC5816d Range<T> range, @InterfaceC5816d Range<T> range2) {
        C5544i0.m22546f(range, "$receiver");
        C5544i0.m22546f(range2, DispatchConstants.OTHER);
        Range<T> intersect = range.intersect(range2);
        C5544i0.m22521a((Object) intersect, "intersect(other)");
        return intersect;
    }

    @RequiresApi(21)
    @InterfaceC5816d
    public static final <T extends Comparable<? super T>> Range<T> plus(@InterfaceC5816d Range<T> range, @InterfaceC5816d T t) {
        C5544i0.m22546f(range, "$receiver");
        C5544i0.m22546f(t, SurveyH5Bean.VALUE);
        Range<T> extend = range.extend((Range<T>) t);
        C5544i0.m22521a((Object) extend, "extend(value)");
        return extend;
    }

    @RequiresApi(21)
    @InterfaceC5816d
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(@InterfaceC5816d T t, @InterfaceC5816d T t2) {
        C5544i0.m22546f(t, "$receiver");
        C5544i0.m22546f(t2, "that");
        return new Range<>(t, t2);
    }

    @RequiresApi(21)
    @InterfaceC5816d
    public static final <T extends Comparable<? super T>> InterfaceC5638g<T> toClosedRange(@InterfaceC5816d final Range<T> range) {
        C5544i0.m22546f(range, "$receiver");
        return (InterfaceC5638g<T>) new InterfaceC5638g<T>() { // from class: androidx.core.util.RangeKt$toClosedRange$1
            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            @Override // p286h.p319v2.InterfaceC5638g
            public boolean contains(@InterfaceC5816d Comparable comparable) {
                C5544i0.m22546f(comparable, SurveyH5Bean.VALUE);
                return InterfaceC5638g.a.m23020a(this, comparable);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // p286h.p319v2.InterfaceC5638g
            public Comparable getEndInclusive() {
                return range.getUpper();
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // p286h.p319v2.InterfaceC5638g
            public Comparable getStart() {
                return range.getLower();
            }

            @Override // p286h.p319v2.InterfaceC5638g
            public boolean isEmpty() {
                return InterfaceC5638g.a.m23019a(this);
            }
        };
    }

    @RequiresApi(21)
    @InterfaceC5816d
    public static final <T extends Comparable<? super T>> Range<T> toRange(@InterfaceC5816d InterfaceC5638g<T> interfaceC5638g) {
        C5544i0.m22546f(interfaceC5638g, "$receiver");
        return new Range<>(interfaceC5638g.getStart(), interfaceC5638g.getEndInclusive());
    }

    @RequiresApi(21)
    @InterfaceC5816d
    public static final <T extends Comparable<? super T>> Range<T> plus(@InterfaceC5816d Range<T> range, @InterfaceC5816d Range<T> range2) {
        C5544i0.m22546f(range, "$receiver");
        C5544i0.m22546f(range2, DispatchConstants.OTHER);
        Range<T> extend = range.extend(range2);
        C5544i0.m22521a((Object) extend, "extend(other)");
        return extend;
    }
}
