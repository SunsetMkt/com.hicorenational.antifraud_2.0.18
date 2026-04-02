package anet.channel.detect;

import android.text.TextUtils;
import android.util.Pair;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ RequestStatistic a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ExceptionDetector f1413b;

    c(ExceptionDetector exceptionDetector, RequestStatistic requestStatistic) {
        this.f1413b = exceptionDetector;
        this.a = requestStatistic;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.a == null) {
                return;
            }
            if (!TextUtils.isEmpty(this.a.ip) && this.a.ret == 0) {
                if ("guide-acs.m.taobao.com".equalsIgnoreCase(this.a.host)) {
                    this.f1413b.f1402b = this.a.ip;
                } else if ("msgacs.m.taobao.com".equalsIgnoreCase(this.a.host)) {
                    this.f1413b.f1403c = this.a.ip;
                } else if ("gw.alicdn.com".equalsIgnoreCase(this.a.host)) {
                    this.f1413b.f1404d = this.a.ip;
                }
            }
            if (!TextUtils.isEmpty(this.a.url)) {
                this.f1413b.f1405e.add(Pair.create(this.a.url, Integer.valueOf(this.a.statusCode)));
            }
            if (this.f1413b.c()) {
                this.f1413b.b();
            }
        } catch (Throwable th) {
            ALog.e("anet.ExceptionDetector", "network detect fail.", null, th, new Object[0]);
        }
    }
}
