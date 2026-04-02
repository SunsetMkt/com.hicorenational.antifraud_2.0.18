package b.a.t;

import android.os.Looper;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.DefaultFinishEvent;
import b.a.p.b;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class m {
    protected l a;

    /* JADX INFO: compiled from: Taobao */
    class a implements b.a {
        private int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Request f1897b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private b.a.p.a f1898c;

        a(int i2, Request request, b.a.p.a aVar) {
            this.a = 0;
            this.f1897b = null;
            this.f1898c = null;
            this.a = i2;
            this.f1897b = request;
            this.f1898c = aVar;
        }

        @Override // b.a.p.b.a
        public Future a(Request request, b.a.p.a aVar) {
            if (m.this.a.f1894d.get()) {
                ALog.i("anet.UnifiedRequestTask", "request canneled or timeout in processing interceptor", request.getSeq(), new Object[0]);
                return null;
            }
            if (this.a < b.a.p.c.a()) {
                return b.a.p.c.a(this.a).a(m.this.new a(this.a + 1, request, aVar));
            }
            m.this.a.a.a(request);
            m.this.a.f1892b = aVar;
            b.a.j.a aVarA = b.a.k.b.l() ? b.a.j.b.a(m.this.a.a.g(), m.this.a.a.h()) : null;
            l lVar = m.this.a;
            lVar.f1895e = aVarA != null ? new c(lVar, aVarA) : new g(lVar, null, null);
            m.this.a.f1895e.run();
            m.this.c();
            return null;
        }

        @Override // b.a.p.b.a
        public b.a.p.a callback() {
            return this.f1898c;
        }

        @Override // b.a.p.b.a
        public Request request() {
            return this.f1897b;
        }
    }

    public m(anetwork.channel.entity.k kVar, anetwork.channel.entity.g gVar) {
        gVar.a(kVar.f1794i);
        this.a = new l(kVar, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.a.f1896f = ThreadPoolExecutorFactory.submitScheduledTask(new p(this), this.a.a.b(), TimeUnit.MILLISECONDS);
    }

    void b() {
        if (this.a.f1894d.compareAndSet(false, true)) {
            ALog.e("anet.UnifiedRequestTask", "task cancelled", this.a.f1893c, "URL", this.a.a.f().simpleUrlString());
            RequestStatistic requestStatistic = this.a.a.f1791f;
            if (requestStatistic.isDone.compareAndSet(false, true)) {
                requestStatistic.ret = 2;
                requestStatistic.statusCode = ErrorConstant.ERROR_REQUEST_CANCEL;
                requestStatistic.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_REQUEST_CANCEL);
                requestStatistic.rspEnd = System.currentTimeMillis();
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_REQUEST_CANCEL, null, requestStatistic, null));
                if (requestStatistic.recDataSize > OSSConstants.MIN_PART_SIZE_LIMIT) {
                    anet.channel.monitor.b.a().a(requestStatistic.sendStart, requestStatistic.rspEnd, requestStatistic.recDataSize);
                }
            }
            this.a.b();
            this.a.a();
            l lVar = this.a;
            lVar.f1892b.a(new DefaultFinishEvent(ErrorConstant.ERROR_REQUEST_CANCEL, (String) null, lVar.a.a()));
        }
    }

    public Future a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        anetwork.channel.entity.k kVar = this.a.a;
        RequestStatistic requestStatistic = kVar.f1791f;
        requestStatistic.reqServiceTransmissionEnd = jCurrentTimeMillis;
        requestStatistic.start = jCurrentTimeMillis;
        requestStatistic.isReqSync = kVar.c();
        this.a.a.f1791f.isReqMain = Looper.myLooper() == Looper.getMainLooper();
        try {
            this.a.a.f1791f.netReqStart = Long.valueOf(this.a.a.a(b.a.u.a.o)).longValue();
        } catch (Exception unused) {
        }
        String strA = this.a.a.a(b.a.u.a.p);
        if (!TextUtils.isEmpty(strA)) {
            this.a.a.f1791f.traceId = strA;
        }
        String strA2 = this.a.a.a(b.a.u.a.q);
        anetwork.channel.entity.k kVar2 = this.a.a;
        RequestStatistic requestStatistic2 = kVar2.f1791f;
        requestStatistic2.process = strA2;
        requestStatistic2.pTraceId = kVar2.a(b.a.u.a.r);
        l lVar = this.a;
        ALog.e("anet.UnifiedRequestTask", "[traceId:" + strA + "]start", lVar.f1893c, "bizId", lVar.a.a().getBizId(), "processFrom", strA2, "url", this.a.a.g());
        if (!b.a.k.b.a(this.a.a.f())) {
            ThreadPoolExecutorFactory.submitPriorityTask(new o(this), ThreadPoolExecutorFactory.Priority.HIGH);
            return new f(this);
        }
        d dVar = new d(this.a);
        this.a.f1895e = dVar;
        dVar.f1858b = new anet.channel.request.b(ThreadPoolExecutorFactory.submitBackupTask(new n(this)), this.a.a.a().getSeq());
        c();
        return new f(this);
    }
}
