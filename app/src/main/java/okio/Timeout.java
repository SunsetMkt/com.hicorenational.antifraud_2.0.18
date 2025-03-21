package okio;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.common.Constants;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.InterfaceC5479c;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p311t.C5535f0;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Timeout.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\u0000H\u0016J\b\u0010\t\u001a\u00020\u0000H\u0016J\u0016\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001f\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012H\u0086\bJ\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m23546d2 = {"Lokio/Timeout;", "", "()V", "deadlineNanoTime", "", "hasDeadline", "", "timeoutNanos", "clearDeadline", "clearTimeout", "deadline", "duration", "unit", "Ljava/util/concurrent/TimeUnit;", "intersectWith", "", DispatchConstants.OTHER, "block", "Lkotlin/Function0;", "throwIfReached", "timeout", "waitUntilNotified", Constants.KEY_MONIROT, "Companion", "okio"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public class Timeout {
    public static final Companion Companion = new Companion(null);

    @InterfaceC5479c
    @InterfaceC5816d
    public static final Timeout NONE = new Timeout() { // from class: okio.Timeout$Companion$NONE$1
        @Override // okio.Timeout
        @InterfaceC5816d
        public Timeout deadlineNanoTime(long j2) {
            return this;
        }

        @Override // okio.Timeout
        public void throwIfReached() {
        }

        @Override // okio.Timeout
        @InterfaceC5816d
        public Timeout timeout(long j2, @InterfaceC5816d TimeUnit timeUnit) {
            C5544i0.m22546f(timeUnit, "unit");
            return this;
        }
    };
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    /* compiled from: Timeout.kt */
    @InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m23546d2 = {"Lokio/Timeout$Companion;", "", "()V", "NONE", "Lokio/Timeout;", "minTimeout", "", "aNanos", "bNanos", "okio"}, m23547k = 1, m23548mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public final long minTimeout(long j2, long j3) {
            return (j2 != 0 && (j3 == 0 || j2 < j3)) ? j2 : j3;
        }

        public /* synthetic */ Companion(C5586v c5586v) {
            this();
        }
    }

    @InterfaceC5816d
    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    @InterfaceC5816d
    public Timeout clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    @InterfaceC5816d
    public final Timeout deadline(long j2, @InterfaceC5816d TimeUnit timeUnit) {
        C5544i0.m22546f(timeUnit, "unit");
        if (j2 > 0) {
            return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j2));
        }
        throw new IllegalArgumentException(("duration <= 0: " + j2).toString());
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final void intersectWith(@InterfaceC5816d Timeout timeout, @InterfaceC5816d InterfaceC5495a<C5715y1> interfaceC5495a) {
        C5544i0.m22546f(timeout, DispatchConstants.OTHER);
        C5544i0.m22546f(interfaceC5495a, "block");
        long timeoutNanos = timeoutNanos();
        timeout(Companion.minTimeout(timeout.timeoutNanos(), timeoutNanos()), TimeUnit.NANOSECONDS);
        if (!hasDeadline()) {
            if (timeout.hasDeadline()) {
                deadlineNanoTime(timeout.deadlineNanoTime());
            }
            try {
                interfaceC5495a.invoke();
                return;
            } finally {
                C5535f0.m22474b(1);
                timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout.hasDeadline()) {
                    clearDeadline();
                }
                C5535f0.m22471a(1);
            }
        }
        long deadlineNanoTime = deadlineNanoTime();
        if (timeout.hasDeadline()) {
            deadlineNanoTime(Math.min(deadlineNanoTime(), timeout.deadlineNanoTime()));
        }
        try {
            interfaceC5495a.invoke();
        } finally {
            C5535f0.m22474b(1);
            timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            if (timeout.hasDeadline()) {
                deadlineNanoTime(deadlineNanoTime);
            }
            C5535f0.m22471a(1);
        }
    }

    public void throwIfReached() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    @InterfaceC5816d
    public Timeout timeout(long j2, @InterfaceC5816d TimeUnit timeUnit) {
        C5544i0.m22546f(timeUnit, "unit");
        if (j2 >= 0) {
            this.timeoutNanos = timeUnit.toNanos(j2);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j2).toString());
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(@InterfaceC5816d Object obj) throws InterruptedIOException {
        C5544i0.m22546f(obj, Constants.KEY_MONIROT);
        try {
            boolean hasDeadline = hasDeadline();
            long timeoutNanos = timeoutNanos();
            long j2 = 0;
            if (!hasDeadline && timeoutNanos == 0) {
                obj.wait();
                return;
            }
            long nanoTime = System.nanoTime();
            if (hasDeadline && timeoutNanos != 0) {
                timeoutNanos = Math.min(timeoutNanos, deadlineNanoTime() - nanoTime);
            } else if (hasDeadline) {
                timeoutNanos = deadlineNanoTime() - nanoTime;
            }
            if (timeoutNanos > 0) {
                long j3 = timeoutNanos / 1000000;
                Long.signum(j3);
                obj.wait(j3, (int) (timeoutNanos - (1000000 * j3)));
                j2 = System.nanoTime() - nanoTime;
            }
            if (j2 >= timeoutNanos) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    @InterfaceC5816d
    public Timeout deadlineNanoTime(long j2) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j2;
        return this;
    }
}
