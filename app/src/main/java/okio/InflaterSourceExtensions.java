package okio;

import java.util.zip.Inflater;
import p286h.InterfaceC5713y;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: InflaterSource.kt */
@InterfaceC5481e(name = "-InflaterSourceExtensions")
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086\b¨\u0006\u0005"}, m23546d2 = {"inflate", "Lokio/InflaterSource;", "Lokio/Source;", "inflater", "Ljava/util/zip/Inflater;", "okio"}, m23547k = 2, m23548mv = {1, 1, 16})
/* renamed from: okio.-InflaterSourceExtensions, reason: invalid class name */
/* loaded from: classes2.dex */
public final class InflaterSourceExtensions {
    @InterfaceC5816d
    public static final InflaterSource inflate(@InterfaceC5816d Source source, @InterfaceC5816d Inflater inflater) {
        C5544i0.m22546f(source, "$this$inflate");
        C5544i0.m22546f(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }

    public static /* synthetic */ InflaterSource inflate$default(Source source, Inflater inflater, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            inflater = new Inflater();
        }
        C5544i0.m22546f(source, "$this$inflate");
        C5544i0.m22546f(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }
}
