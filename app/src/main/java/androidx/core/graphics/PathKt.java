package androidx.core.graphics;

import android.graphics.Path;
import androidx.annotation.RequiresApi;
import com.umeng.analytics.pro.C3351bh;
import java.util.Collection;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Path.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f¨\u0006\f"}, m23546d2 = {"and", "Landroid/graphics/Path;", C3351bh.f11576aA, "flatten", "", "Landroidx/core/graphics/PathSegment;", "error", "", "minus", "or", "plus", "xor", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class PathKt {
    @RequiresApi(19)
    @InterfaceC5816d
    public static final Path and(@InterfaceC5816d Path path, @InterfaceC5816d Path path2) {
        C5544i0.m22546f(path, "$receiver");
        C5544i0.m22546f(path2, C3351bh.f11576aA);
        Path path3 = new Path();
        path3.op(path, path2, Path.Op.INTERSECT);
        return path3;
    }

    @RequiresApi(26)
    @InterfaceC5816d
    public static final Iterable<PathSegment> flatten(@InterfaceC5816d Path path, float f2) {
        C5544i0.m22546f(path, "$receiver");
        Collection<PathSegment> flatten = PathUtils.flatten(path, f2);
        C5544i0.m22521a((Object) flatten, "PathUtils.flatten(this, error)");
        return flatten;
    }

    @RequiresApi(26)
    @InterfaceC5816d
    public static /* bridge */ /* synthetic */ Iterable flatten$default(Path path, float f2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.5f;
        }
        return flatten(path, f2);
    }

    @RequiresApi(19)
    @InterfaceC5816d
    public static final Path minus(@InterfaceC5816d Path path, @InterfaceC5816d Path path2) {
        C5544i0.m22546f(path, "$receiver");
        C5544i0.m22546f(path2, C3351bh.f11576aA);
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.DIFFERENCE);
        return path3;
    }

    @RequiresApi(19)
    @InterfaceC5816d
    /* renamed from: or */
    public static final Path m387or(@InterfaceC5816d Path path, @InterfaceC5816d Path path2) {
        C5544i0.m22546f(path, "$receiver");
        C5544i0.m22546f(path2, C3351bh.f11576aA);
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @RequiresApi(19)
    @InterfaceC5816d
    public static final Path plus(@InterfaceC5816d Path path, @InterfaceC5816d Path path2) {
        C5544i0.m22546f(path, "$receiver");
        C5544i0.m22546f(path2, C3351bh.f11576aA);
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @RequiresApi(19)
    @InterfaceC5816d
    public static final Path xor(@InterfaceC5816d Path path, @InterfaceC5816d Path path2) {
        C5544i0.m22546f(path, "$receiver");
        C5544i0.m22546f(path2, C3351bh.f11576aA);
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.XOR);
        return path3;
    }
}
