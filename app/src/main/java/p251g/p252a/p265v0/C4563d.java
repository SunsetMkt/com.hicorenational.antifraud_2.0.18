package p251g.p252a.p265v0;

import p251g.p252a.p263t0.InterfaceC4543c;
import p251g.p252a.p263t0.InterfaceC4546f;

/* compiled from: OnErrorNotImplementedException.java */
@InterfaceC4543c
/* renamed from: g.a.v0.d */
/* loaded from: classes2.dex */
public final class C4563d extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    public C4563d(String str, @InterfaceC4546f Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }

    public C4563d(@InterfaceC4546f Throwable th) {
        super(th != null ? th.getMessage() : null, th == null ? new NullPointerException() : th);
    }
}
