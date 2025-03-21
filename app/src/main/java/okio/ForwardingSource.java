package okio;

import java.io.IOException;
import p286h.EnumC5220d;
import p286h.InterfaceC5216c;
import p286h.InterfaceC5467o0;
import p286h.InterfaceC5713y;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ForwardingSource.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\r\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0013\u0010\u0002\u001a\u00020\u00018\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0011"}, m23546d2 = {"Lokio/ForwardingSource;", "Lokio/Source;", "delegate", "(Lokio/Source;)V", "()Lokio/Source;", "close", "", "-deprecated_delegate", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "toString", "", "okio"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public abstract class ForwardingSource implements Source {

    @InterfaceC5816d
    private final Source delegate;

    public ForwardingSource(@InterfaceC5816d Source source) {
        C5544i0.m22546f(source, "delegate");
        this.delegate = source;
    }

    @InterfaceC5481e(name = "-deprecated_delegate")
    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to val", replaceWith = @InterfaceC5467o0(expression = "delegate", imports = {}))
    @InterfaceC5816d
    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final Source m26879deprecated_delegate() {
        return this.delegate;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @InterfaceC5481e(name = "delegate")
    @InterfaceC5816d
    public final Source delegate() {
        return this.delegate;
    }

    @Override // okio.Source
    public long read(@InterfaceC5816d Buffer buffer, long j2) throws IOException {
        C5544i0.m22546f(buffer, "sink");
        return this.delegate.read(buffer, j2);
    }

    @Override // okio.Source
    @InterfaceC5816d
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    @InterfaceC5816d
    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
