package a.a.l;

import a.a.l.a;
import anet.channel.util.ALog;
import java.net.HttpCookie;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1143a;

    c(String str) {
        this.f1143a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.C0002a c0002a;
        a.C0002a c0002a2;
        a.C0002a c0002a3;
        a.C0002a c0002a4;
        a.C0002a c0002a5;
        a.C0002a c0002a6;
        c0002a = a.f1136e;
        if (c0002a == null) {
            return;
        }
        try {
            for (HttpCookie httpCookie : HttpCookie.parse(this.f1143a)) {
                String name = httpCookie.getName();
                c0002a2 = a.f1136e;
                if (name.equals(c0002a2.f1138a)) {
                    c0002a3 = a.f1136e;
                    c0002a3.f1139b = httpCookie.toString();
                    c0002a4 = a.f1136e;
                    c0002a4.f1141d = httpCookie.getDomain();
                    c0002a5 = a.f1136e;
                    c0002a5.f1140c = this.f1143a;
                    c0002a6 = a.f1136e;
                    c0002a6.a();
                    return;
                }
            }
        } catch (Exception e2) {
            ALog.e(a.f1132a, "cookieMonitorSave error.", null, e2, new Object[0]);
        }
    }
}
