package a.a.l;

import a.a.l.a;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.CookieMonitorStat;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.HttpCookie;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1144a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f1145b;

    d(String str, String str2) {
        this.f1144a = str;
        this.f1145b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.C0002a c0002a;
        a.C0002a c0002a2;
        a.C0002a c0002a3;
        a.C0002a c0002a4;
        a.C0002a c0002a5;
        a.C0002a c0002a6;
        a.C0002a c0002a7;
        c0002a = a.f1136e;
        if (c0002a == null) {
            return;
        }
        try {
            c0002a2 = a.f1136e;
            if (TextUtils.isEmpty(c0002a2.f1138a)) {
                return;
            }
            c0002a3 = a.f1136e;
            if (!HttpCookie.domainMatches(c0002a3.f1141d, HttpUrl.parse(this.f1144a).host()) || TextUtils.isEmpty(this.f1145b)) {
                return;
            }
            String str = this.f1145b;
            StringBuilder sb = new StringBuilder();
            c0002a4 = a.f1136e;
            sb.append(c0002a4.f1138a);
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            if (str.contains(sb.toString())) {
                return;
            }
            CookieMonitorStat cookieMonitorStat = new CookieMonitorStat(this.f1144a);
            c0002a5 = a.f1136e;
            cookieMonitorStat.cookieName = c0002a5.f1138a;
            c0002a6 = a.f1136e;
            cookieMonitorStat.cookieText = c0002a6.f1139b;
            c0002a7 = a.f1136e;
            cookieMonitorStat.setCookie = c0002a7.f1140c;
            cookieMonitorStat.missType = 1;
            AppMonitor.getInstance().commitStat(cookieMonitorStat);
        } catch (Exception e2) {
            ALog.e(a.f1132a, "cookieMonitorReport error.", null, e2, new Object[0]);
        }
    }
}
