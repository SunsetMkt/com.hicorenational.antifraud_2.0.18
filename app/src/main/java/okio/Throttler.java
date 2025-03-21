package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.InterfaceC5482f;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Throttler.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\fJ$\u0010\u0006\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0013J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\f\u0010\u0016\u001a\u00020\u0004*\u00020\u0004H\u0002J\f\u0010\u0017\u001a\u00020\u0004*\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m23546d2 = {"Lokio/Throttler;", "", "()V", "allocatedUntil", "", "(J)V", "bytesPerSecond", "maxByteCount", "waitByteCount", "byteCountOrWaitNanos", "now", "byteCount", "byteCountOrWaitNanos$okio", "", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "take", "take$okio", "waitNanos", "nanosToWait", "bytesToNanos", "nanosToBytes", "okio"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;
    private long maxByteCount;
    private long waitByteCount;

    public Throttler(long j2) {
        this.allocatedUntil = j2;
        this.waitByteCount = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        this.maxByteCount = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    }

    public static /* synthetic */ void bytesPerSecond$default(Throttler throttler, long j2, long j3, long j4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j3 = throttler.waitByteCount;
        }
        long j5 = j3;
        if ((i2 & 4) != 0) {
            j4 = throttler.maxByteCount;
        }
        throttler.bytesPerSecond(j2, j5, j4);
    }

    private final long bytesToNanos(long j2) {
        return (j2 * 1000000000) / this.bytesPerSecond;
    }

    private final long nanosToBytes(long j2) {
        return (j2 * this.bytesPerSecond) / 1000000000;
    }

    private final void waitNanos(long j2) {
        long j3 = j2 / 1000000;
        wait(j3, (int) (j2 - (1000000 * j3)));
    }

    public final long byteCountOrWaitNanos$okio(long j2, long j3) {
        if (this.bytesPerSecond == 0) {
            return j3;
        }
        long max = Math.max(this.allocatedUntil - j2, 0L);
        long nanosToBytes = this.maxByteCount - nanosToBytes(max);
        if (nanosToBytes >= j3) {
            this.allocatedUntil = j2 + max + bytesToNanos(j3);
            return j3;
        }
        long j4 = this.waitByteCount;
        if (nanosToBytes >= j4) {
            this.allocatedUntil = j2 + bytesToNanos(this.maxByteCount);
            return nanosToBytes;
        }
        long min = Math.min(j4, j3);
        long bytesToNanos = max + bytesToNanos(min - this.maxByteCount);
        if (bytesToNanos != 0) {
            return -bytesToNanos;
        }
        this.allocatedUntil = j2 + bytesToNanos(this.maxByteCount);
        return min;
    }

    @InterfaceC5482f
    public final void bytesPerSecond(long j2) {
        bytesPerSecond$default(this, j2, 0L, 0L, 6, null);
    }

    @InterfaceC5482f
    public final void bytesPerSecond(long j2, long j3) {
        bytesPerSecond$default(this, j2, j3, 0L, 4, null);
    }

    @InterfaceC5482f
    public final void bytesPerSecond(long j2, long j3, long j4) {
        synchronized (this) {
            if (!(j2 >= 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(j3 > 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(j4 >= j3)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.bytesPerSecond = j2;
            this.waitByteCount = j3;
            this.maxByteCount = j4;
            notifyAll();
            C5715y1 c5715y1 = C5715y1.f20665a;
        }
    }

    @InterfaceC5816d
    public final Sink sink(@InterfaceC5816d final Sink sink) {
        C5544i0.m22546f(sink, "sink");
        return new ForwardingSink(sink) { // from class: okio.Throttler$sink$1
            @Override // okio.ForwardingSink, okio.Sink
            public void write(@InterfaceC5816d Buffer buffer, long j2) throws IOException {
                C5544i0.m22546f(buffer, "source");
                while (j2 > 0) {
                    try {
                        long take$okio = Throttler.this.take$okio(j2);
                        super.write(buffer, take$okio);
                        j2 -= take$okio;
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException("interrupted");
                    }
                }
            }
        };
    }

    @InterfaceC5816d
    public final Source source(@InterfaceC5816d final Source source) {
        C5544i0.m22546f(source, "source");
        return new ForwardingSource(source) { // from class: okio.Throttler$source$1
            @Override // okio.ForwardingSource, okio.Source
            public long read(@InterfaceC5816d Buffer buffer, long j2) {
                C5544i0.m22546f(buffer, "sink");
                try {
                    return super.read(buffer, Throttler.this.take$okio(j2));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException("interrupted");
                }
            }
        };
    }

    public final long take$okio(long j2) {
        long byteCountOrWaitNanos$okio;
        if (!(j2 > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        synchronized (this) {
            while (true) {
                byteCountOrWaitNanos$okio = byteCountOrWaitNanos$okio(System.nanoTime(), j2);
                if (byteCountOrWaitNanos$okio < 0) {
                    waitNanos(-byteCountOrWaitNanos$okio);
                }
            }
        }
        return byteCountOrWaitNanos$okio;
    }

    public Throttler() {
        this(System.nanoTime());
    }
}
