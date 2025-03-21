package okio;

import java.io.Closeable;
import java.io.IOException;
import p286h.InterfaceC5713y;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Source.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, m23546d2 = {"Lokio/Source;", "Ljava/io/Closeable;", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "okio"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public interface Source extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long read(@InterfaceC5816d Buffer buffer, long j2) throws IOException;

    @InterfaceC5816d
    Timeout timeout();
}
