package okio;

import p286h.InterfaceC5713y;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Okio.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0005*\u00020\u0006¨\u0006\u0007"}, m23546d2 = {"blackholeSink", "Lokio/Sink;", "blackhole", "buffer", "Lokio/BufferedSink;", "Lokio/BufferedSource;", "Lokio/Source;", "okio"}, m23547k = 5, m23548mv = {1, 1, 16}, m23551xs = "okio/Okio")
/* loaded from: classes2.dex */
final /* synthetic */ class Okio__OkioKt {
    @InterfaceC5481e(name = "blackhole")
    @InterfaceC5816d
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    @InterfaceC5816d
    public static final BufferedSource buffer(@InterfaceC5816d Source source) {
        C5544i0.m22546f(source, "$this$buffer");
        return new RealBufferedSource(source);
    }

    @InterfaceC5816d
    public static final BufferedSink buffer(@InterfaceC5816d Sink sink) {
        C5544i0.m22546f(sink, "$this$buffer");
        return new RealBufferedSink(sink);
    }
}
