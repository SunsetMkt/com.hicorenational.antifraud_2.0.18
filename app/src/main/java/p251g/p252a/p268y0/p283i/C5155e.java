package p251g.p252a.p268y0.p283i;

import java.util.concurrent.atomic.AtomicBoolean;
import p324i.p338d.InterfaceC5823d;

/* compiled from: BooleanSubscription.java */
/* renamed from: g.a.y0.i.e */
/* loaded from: classes2.dex */
public final class C5155e extends AtomicBoolean implements InterfaceC5823d {
    private static final long serialVersionUID = -8127758972444290902L;

    @Override // p324i.p338d.InterfaceC5823d
    public void cancel() {
        lazySet(true);
    }

    public boolean isCancelled() {
        return get();
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void request(long j2) {
        EnumC5160j.validate(j2);
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "BooleanSubscription(cancelled=" + get() + ")";
    }
}
