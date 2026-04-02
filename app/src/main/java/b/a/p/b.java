package b.a.p;

import anet.channel.request.Request;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public interface b {

    /* JADX INFO: compiled from: Taobao */
    public interface a {
        Future a(Request request, b.a.p.a aVar);

        b.a.p.a callback();

        Request request();
    }

    Future a(a aVar);
}
