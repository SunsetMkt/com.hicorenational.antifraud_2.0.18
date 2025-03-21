package p251g.p252a.p254b1;

import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p267x0.InterfaceC4572c;

/* compiled from: ParallelFailureHandling.java */
@InterfaceC4545e
/* renamed from: g.a.b1.a */
/* loaded from: classes2.dex */
public enum EnumC4470a implements InterfaceC4572c<Long, Throwable, EnumC4470a> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    @Override // p251g.p252a.p267x0.InterfaceC4572c
    public EnumC4470a apply(Long l2, Throwable th) {
        return this;
    }
}
