package b.a.l;

import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.CookieMonitorStat;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.HttpCookie;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
final class d implements Runnable {
    final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f1825b;

    d(String str, String str2) {
        this.a = str;
        this.f1825b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (a.f1819e == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(a.f1819e.a) || !HttpCookie.domainMatches(a.f1819e.f1823d, HttpUrl.parse(this.a).host()) || TextUtils.isEmpty(this.f1825b)) {
                return;
            }
            if (this.f1825b.contains(a.f1819e.a + ContainerUtils.KEY_VALUE_DELIMITER)) {
                return;
            }
            CookieMonitorStat cookieMonitorStat = new CookieMonitorStat(this.a);
            cookieMonitorStat.cookieName = a.f1819e.a;
            cookieMonitorStat.cookieText = a.f1819e.f1821b;
            cookieMonitorStat.setCookie = a.f1819e.f1822c;
            cookieMonitorStat.missType = 1;
            AppMonitor.getInstance().commitStat(cookieMonitorStat);
        } catch (Exception e2) {
            ALog.e(a.a, "cookieMonitorReport error.", null, e2, new Object[0]);
        }
    }
}
