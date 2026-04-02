package okio;

import anet.channel.util.HttpConstant;
import i.q2.e;
import i.q2.t.i0;
import i.y;
import j.c.a.d;

/* JADX INFO: renamed from: okio.-GzipSinkExtensions, reason: invalid class name */
/* JADX INFO: compiled from: GzipSink.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(name = "-GzipSinkExtensions")
@y(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b\u00a8\u0006\u0003"}, d2 = {HttpConstant.GZIP, "Lokio/GzipSink;", "Lokio/Sink;", "okio"}, k = 2, mv = {1, 1, 16})
public final class GzipSinkExtensions {
    @d
    public static final GzipSink gzip(@d Sink sink) {
        i0.f(sink, "$this$gzip");
        return new GzipSink(sink);
    }
}
