package anet.channel.detect;

import android.text.TextUtils;
import android.util.Pair;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;

/* compiled from: Taobao */
/* renamed from: anet.channel.detect.c */
/* loaded from: classes.dex */
class RunnableC0761c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RequestStatistic f789a;

    /* renamed from: b */
    final /* synthetic */ ExceptionDetector f790b;

    RunnableC0761c(ExceptionDetector exceptionDetector, RequestStatistic requestStatistic) {
        this.f790b = exceptionDetector;
        this.f789a = requestStatistic;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f789a == null) {
                return;
            }
            if (!TextUtils.isEmpty(this.f789a.f1002ip) && this.f789a.ret == 0) {
                if ("guide-acs.m.taobao.com".equalsIgnoreCase(this.f789a.host)) {
                    this.f790b.f774b = this.f789a.f1002ip;
                } else if ("msgacs.m.taobao.com".equalsIgnoreCase(this.f789a.host)) {
                    this.f790b.f775c = this.f789a.f1002ip;
                } else if ("gw.alicdn.com".equalsIgnoreCase(this.f789a.host)) {
                    this.f790b.f776d = this.f789a.f1002ip;
                }
            }
            if (!TextUtils.isEmpty(this.f789a.url)) {
                this.f790b.f777e.add(Pair.create(this.f789a.url, Integer.valueOf(this.f789a.statusCode)));
            }
            if (this.f790b.m469c()) {
                this.f790b.m468b();
            }
        } catch (Throwable th) {
            ALog.m714e("anet.ExceptionDetector", "network detect fail.", null, th, new Object[0]);
        }
    }
}
