package okio;

import anet.channel.util.HttpConstant;
import p286h.InterfaceC5713y;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: GzipSink.kt */
@InterfaceC5481e(name = "-GzipSinkExtensions")
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b¨\u0006\u0003"}, m23546d2 = {HttpConstant.GZIP, "Lokio/GzipSink;", "Lokio/Sink;", "okio"}, m23547k = 2, m23548mv = {1, 1, 16})
/* renamed from: okio.-GzipSinkExtensions, reason: invalid class name */
/* loaded from: classes2.dex */
public final class GzipSinkExtensions {
    @InterfaceC5816d
    public static final GzipSink gzip(@InterfaceC5816d Sink sink) {
        C5544i0.m22546f(sink, "$this$gzip");
        return new GzipSink(sink);
    }
}
