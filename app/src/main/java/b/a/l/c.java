package b.a.l;

import anet.channel.util.ALog;
import java.net.HttpCookie;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
final class c implements Runnable {
    final /* synthetic */ String a;

    c(String str) {
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a.f1819e == null) {
            return;
        }
        try {
            for (HttpCookie httpCookie : HttpCookie.parse(this.a)) {
                if (httpCookie.getName().equals(a.f1819e.a)) {
                    a.f1819e.f1821b = httpCookie.toString();
                    a.f1819e.f1823d = httpCookie.getDomain();
                    a.f1819e.f1822c = this.a;
                    a.f1819e.a();
                    return;
                }
            }
        } catch (Exception e2) {
            ALog.e(a.a, "cookieMonitorSave error.", null, e2, new Object[0]);
        }
    }
}
