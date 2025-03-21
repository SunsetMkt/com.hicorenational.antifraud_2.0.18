package p000a.p001a.p004l;

import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.CookieMonitorStat;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.HttpCookie;
import p000a.p001a.p004l.C0015a;

/* compiled from: Taobao */
/* renamed from: a.a.l.d */
/* loaded from: classes.dex */
final class RunnableC0018d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f47a;

    /* renamed from: b */
    final /* synthetic */ String f48b;

    RunnableC0018d(String str, String str2) {
        this.f47a = str;
        this.f48b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0015a.a aVar;
        C0015a.a aVar2;
        C0015a.a aVar3;
        C0015a.a aVar4;
        C0015a.a aVar5;
        C0015a.a aVar6;
        C0015a.a aVar7;
        aVar = C0015a.f39e;
        if (aVar == null) {
            return;
        }
        try {
            aVar2 = C0015a.f39e;
            if (TextUtils.isEmpty(aVar2.f41a)) {
                return;
            }
            aVar3 = C0015a.f39e;
            if (!HttpCookie.domainMatches(aVar3.f44d, HttpUrl.parse(this.f47a).host()) || TextUtils.isEmpty(this.f48b)) {
                return;
            }
            String str = this.f48b;
            StringBuilder sb = new StringBuilder();
            aVar4 = C0015a.f39e;
            sb.append(aVar4.f41a);
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            if (str.contains(sb.toString())) {
                return;
            }
            CookieMonitorStat cookieMonitorStat = new CookieMonitorStat(this.f47a);
            aVar5 = C0015a.f39e;
            cookieMonitorStat.cookieName = aVar5.f41a;
            aVar6 = C0015a.f39e;
            cookieMonitorStat.cookieText = aVar6.f42b;
            aVar7 = C0015a.f39e;
            cookieMonitorStat.setCookie = aVar7.f43c;
            cookieMonitorStat.missType = 1;
            AppMonitor.getInstance().commitStat(cookieMonitorStat);
        } catch (Exception e2) {
            ALog.m714e(C0015a.f35a, "cookieMonitorReport error.", null, e2, new Object[0]);
        }
    }
}
