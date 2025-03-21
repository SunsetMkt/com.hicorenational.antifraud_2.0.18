package anet.channel.e;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.session.TnetSpdySession;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import com.just.agentweb.DefaultWebClient;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f1756a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NetworkStatusHelper.NetworkStatus f1757b;

    e(List list, NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f1756a = list;
        this.f1757b = networkStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        AtomicInteger atomicInteger;
        IConnStrategy b2;
        IConnStrategy iConnStrategy = (IConnStrategy) this.f1756a.get(0);
        StringBuilder sb = new StringBuilder();
        sb.append(DefaultWebClient.HTTPS_SCHEME);
        str = a.f1744b;
        sb.append(str);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Http3Detect");
        atomicInteger = a.f1750h;
        sb3.append(atomicInteger.getAndIncrement());
        String sb4 = sb3.toString();
        b2 = a.b(iConnStrategy);
        TnetSpdySession tnetSpdySession = new TnetSpdySession(GlobalAppRuntimeInfo.getContext(), new anet.channel.entity.a(sb2, sb4, b2));
        tnetSpdySession.registerEventcb(257, new f(this, iConnStrategy));
        tnetSpdySession.q.isCommitted = true;
        tnetSpdySession.connect();
    }
}
