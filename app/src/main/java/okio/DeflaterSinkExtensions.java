package okio;

import java.util.zip.Deflater;
import p286h.InterfaceC5713y;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: DeflaterSink.kt */
@InterfaceC5481e(name = "-DeflaterSinkExtensions")
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086\b¨\u0006\u0005"}, m23546d2 = {"deflate", "Lokio/DeflaterSink;", "Lokio/Sink;", "deflater", "Ljava/util/zip/Deflater;", "okio"}, m23547k = 2, m23548mv = {1, 1, 16})
/* renamed from: okio.-DeflaterSinkExtensions, reason: invalid class name */
/* loaded from: classes2.dex */
public final class DeflaterSinkExtensions {
    @InterfaceC5816d
    public static final DeflaterSink deflate(@InterfaceC5816d Sink sink, @InterfaceC5816d Deflater deflater) {
        C5544i0.m22546f(sink, "$this$deflate");
        C5544i0.m22546f(deflater, "deflater");
        return new DeflaterSink(sink, deflater);
    }

    public static /* synthetic */ DeflaterSink deflate$default(Sink sink, Deflater deflater, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            deflater = new Deflater();
        }
        C5544i0.m22546f(sink, "$this$deflate");
        C5544i0.m22546f(deflater, "deflater");
        return new DeflaterSink(sink, deflater);
    }
}
