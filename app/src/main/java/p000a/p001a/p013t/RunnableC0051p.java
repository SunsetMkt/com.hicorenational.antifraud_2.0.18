package p000a.p001a.p013t;

import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.DefaultFinishEvent;

/* compiled from: Taobao */
/* renamed from: a.a.t.p */
/* loaded from: classes.dex */
class RunnableC0051p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0048m f148a;

    RunnableC0051p(C0048m c0048m) {
        this.f148a = c0048m;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f148a.f141a.f138d.compareAndSet(false, true)) {
            RequestStatistic requestStatistic = this.f148a.f141a.f135a.f1364f;
            if (requestStatistic.isDone.compareAndSet(false, true)) {
                requestStatistic.statusCode = ErrorConstant.ERROR_REQUEST_TIME_OUT;
                requestStatistic.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_REQUEST_TIME_OUT);
                requestStatistic.rspEnd = System.currentTimeMillis();
                ALog.m715e("anet.UnifiedRequestTask", "task time out", this.f148a.f141a.f137c, "rs", requestStatistic);
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_REQUEST_TIME_OUT, null, requestStatistic, null));
            }
            this.f148a.f141a.m198b();
            C0047l c0047l = this.f148a.f141a;
            c0047l.f136b.mo151a(new DefaultFinishEvent(ErrorConstant.ERROR_REQUEST_TIME_OUT, (String) null, c0047l.f135a.m824a()));
        }
    }
}
