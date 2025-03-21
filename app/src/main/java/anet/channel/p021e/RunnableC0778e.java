package anet.channel.p021e;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.entity.C0781a;
import anet.channel.session.TnetSpdySession;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import com.just.agentweb.DefaultWebClient;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* renamed from: anet.channel.e.e */
/* loaded from: classes.dex */
final class RunnableC0778e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f830a;

    /* renamed from: b */
    final /* synthetic */ NetworkStatusHelper.NetworkStatus f831b;

    RunnableC0778e(List list, NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f830a = list;
        this.f831b = networkStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        AtomicInteger atomicInteger;
        IConnStrategy m496b;
        IConnStrategy iConnStrategy = (IConnStrategy) this.f830a.get(0);
        StringBuilder sb = new StringBuilder();
        sb.append(DefaultWebClient.HTTPS_SCHEME);
        str = C0774a.f818b;
        sb.append(str);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Http3Detect");
        atomicInteger = C0774a.f824h;
        sb3.append(atomicInteger.getAndIncrement());
        String sb4 = sb3.toString();
        m496b = C0774a.m496b(iConnStrategy);
        TnetSpdySession tnetSpdySession = new TnetSpdySession(GlobalAppRuntimeInfo.getContext(), new C0781a(sb2, sb4, m496b));
        tnetSpdySession.registerEventcb(257, new C0779f(this, iConnStrategy));
        tnetSpdySession.f699q.isCommitted = true;
        tnetSpdySession.connect();
    }
}
