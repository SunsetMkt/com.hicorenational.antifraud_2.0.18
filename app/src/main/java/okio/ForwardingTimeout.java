package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import p286h.InterfaceC5713y;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ForwardingTimeout.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0001H\u0016J\b\u0010\u0007\u001a\u00020\u0001H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u001c\u0010\u0002\u001a\u00020\u00018\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0003¨\u0006\u0012"}, m23546d2 = {"Lokio/ForwardingTimeout;", "Lokio/Timeout;", "delegate", "(Lokio/Timeout;)V", "()Lokio/Timeout;", "setDelegate", "clearDeadline", "clearTimeout", "deadlineNanoTime", "", "hasDeadline", "", "throwIfReached", "", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "timeoutNanos", "okio"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public class ForwardingTimeout extends Timeout {

    @InterfaceC5816d
    private Timeout delegate;

    public ForwardingTimeout(@InterfaceC5816d Timeout timeout) {
        C5544i0.m22546f(timeout, "delegate");
        this.delegate = timeout;
    }

    @Override // okio.Timeout
    @InterfaceC5816d
    public Timeout clearDeadline() {
        return this.delegate.clearDeadline();
    }

    @Override // okio.Timeout
    @InterfaceC5816d
    public Timeout clearTimeout() {
        return this.delegate.clearTimeout();
    }

    @Override // okio.Timeout
    public long deadlineNanoTime() {
        return this.delegate.deadlineNanoTime();
    }

    @InterfaceC5481e(name = "delegate")
    @InterfaceC5816d
    public final Timeout delegate() {
        return this.delegate;
    }

    @Override // okio.Timeout
    public boolean hasDeadline() {
        return this.delegate.hasDeadline();
    }

    /* renamed from: setDelegate, reason: collision with other method in class */
    public final /* synthetic */ void m26880setDelegate(@InterfaceC5816d Timeout timeout) {
        C5544i0.m22546f(timeout, "<set-?>");
        this.delegate = timeout;
    }

    @Override // okio.Timeout
    public void throwIfReached() throws IOException {
        this.delegate.throwIfReached();
    }

    @Override // okio.Timeout
    @InterfaceC5816d
    public Timeout timeout(long j2, @InterfaceC5816d TimeUnit timeUnit) {
        C5544i0.m22546f(timeUnit, "unit");
        return this.delegate.timeout(j2, timeUnit);
    }

    @Override // okio.Timeout
    public long timeoutNanos() {
        return this.delegate.timeoutNanos();
    }

    @Override // okio.Timeout
    @InterfaceC5816d
    public Timeout deadlineNanoTime(long j2) {
        return this.delegate.deadlineNanoTime(j2);
    }

    @InterfaceC5816d
    public final ForwardingTimeout setDelegate(@InterfaceC5816d Timeout timeout) {
        C5544i0.m22546f(timeout, "delegate");
        this.delegate = timeout;
        return this;
    }
}
