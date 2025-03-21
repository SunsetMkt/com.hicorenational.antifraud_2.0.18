package p000a.p001a.p004l;

import anet.channel.util.ALog;
import java.net.HttpCookie;
import p000a.p001a.p004l.C0015a;

/* compiled from: Taobao */
/* renamed from: a.a.l.c */
/* loaded from: classes.dex */
final class RunnableC0017c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f46a;

    RunnableC0017c(String str) {
        this.f46a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0015a.a aVar;
        C0015a.a aVar2;
        C0015a.a aVar3;
        C0015a.a aVar4;
        C0015a.a aVar5;
        C0015a.a aVar6;
        aVar = C0015a.f39e;
        if (aVar == null) {
            return;
        }
        try {
            for (HttpCookie httpCookie : HttpCookie.parse(this.f46a)) {
                String name = httpCookie.getName();
                aVar2 = C0015a.f39e;
                if (name.equals(aVar2.f41a)) {
                    aVar3 = C0015a.f39e;
                    aVar3.f42b = httpCookie.toString();
                    aVar4 = C0015a.f39e;
                    aVar4.f44d = httpCookie.getDomain();
                    aVar5 = C0015a.f39e;
                    aVar5.f43c = this.f46a;
                    aVar6 = C0015a.f39e;
                    aVar6.m127a();
                    return;
                }
            }
        } catch (Exception e2) {
            ALog.m714e(C0015a.f35a, "cookieMonitorSave error.", null, e2, new Object[0]);
        }
    }
}
