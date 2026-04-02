package anet.channel.request;

import anet.channel.util.ALog;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class b implements Cancelable {
    public static final b NULL = new b(null, null);
    private final Future<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1525b;

    public b(Future<?> future, String str) {
        this.a = future;
        this.f1525b = str;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        if (this.a != null) {
            ALog.i("awcn.FutureCancelable", "cancel request", this.f1525b, new Object[0]);
            this.a.cancel(true);
        }
    }
}
