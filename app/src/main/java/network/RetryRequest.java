package network;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.p267x0.InterfaceC4584o;
import util.C7301n1;

/* loaded from: classes2.dex */
public class RetryRequest implements InterfaceC4584o<AbstractC4469b0<? extends Throwable>, AbstractC4469b0<?>> {
    private final int maxRetries;
    private int retryCount;

    public RetryRequest(int i2) {
        this.maxRetries = i2;
    }

    /* renamed from: a */
    public /* synthetic */ InterfaceC4504g0 m24920a(Throwable th) throws Exception {
        int i2 = this.retryCount + 1;
        this.retryCount = i2;
        if (i2 > this.maxRetries) {
            return AbstractC4469b0.m16561a(th);
        }
        C7301n1.m26454a("hsc", "retryCount==" + this.retryCount);
        return AbstractC4469b0.m16633l("" + this.retryCount);
    }

    @Override // p251g.p252a.p267x0.InterfaceC4584o
    public AbstractC4469b0<?> apply(AbstractC4469b0<? extends Throwable> abstractC4469b0) throws Exception {
        return abstractC4469b0.m16915j(new InterfaceC4584o() { // from class: network.b
            @Override // p251g.p252a.p267x0.InterfaceC4584o
            public final Object apply(Object obj) {
                return RetryRequest.this.m24920a((Throwable) obj);
            }
        });
    }
}
