package anet.channel.request;

import anet.channel.util.ALog;
import java.util.concurrent.Future;

/* compiled from: Taobao */
/* renamed from: anet.channel.request.b */
/* loaded from: classes.dex */
public class C0803b implements Cancelable {
    public static final C0803b NULL = new C0803b(null, null);

    /* renamed from: a */
    private final Future<?> f952a;

    /* renamed from: b */
    private final String f953b;

    public C0803b(Future<?> future, String str) {
        this.f952a = future;
        this.f953b = str;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        if (this.f952a != null) {
            ALog.m716i("awcn.FutureCancelable", "cancel request", this.f953b, new Object[0]);
            this.f952a.cancel(true);
        }
    }
}
