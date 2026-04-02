package network;

import h.a.b0;
import h.a.g0;
import h.a.x0.o;
import util.s1;

/* JADX INFO: loaded from: classes2.dex */
public class RetryRequest implements o<b0<? extends Throwable>, b0<?>> {
    private final int maxRetries;
    private int retryCount;

    public RetryRequest(int i2) {
        this.maxRetries = i2;
    }

    public /* synthetic */ g0 a(Throwable th) throws Exception {
        int i2 = this.retryCount + 1;
        this.retryCount = i2;
        if (i2 > this.maxRetries) {
            return b0.a(th);
        }
        s1.a("hsc", "retryCount==" + this.retryCount);
        return b0.l("" + this.retryCount);
    }

    @Override // h.a.x0.o
    public b0<?> apply(b0<? extends Throwable> b0Var) throws Exception {
        return b0Var.j(new o() { // from class: network.b
            @Override // h.a.x0.o
            public final Object apply(Object obj) {
                return this.a.a((Throwable) obj);
            }
        });
    }
}
