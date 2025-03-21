package p000a.p001a.p013t;

import android.os.Looper;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.monitor.C0796b;
import anet.channel.request.C0803b;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.entity.C0895g;
import anetwork.channel.entity.C0899k;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p000a.p001a.p002j.C0010b;
import p000a.p001a.p002j.InterfaceC0009a;
import p000a.p001a.p003k.C0014b;
import p000a.p001a.p008p.C0028c;
import p000a.p001a.p008p.InterfaceC0026a;
import p000a.p001a.p008p.InterfaceC0027b;
import p000a.p001a.p014u.C0052a;

/* compiled from: Taobao */
/* renamed from: a.a.t.m */
/* loaded from: classes.dex */
class C0048m {

    /* renamed from: a */
    protected C0047l f141a;

    /* compiled from: Taobao */
    /* renamed from: a.a.t.m$a */
    class a implements InterfaceC0027b.a {

        /* renamed from: a */
        private int f142a;

        /* renamed from: b */
        private Request f143b;

        /* renamed from: c */
        private InterfaceC0026a f144c;

        a(int i2, Request request, InterfaceC0026a interfaceC0026a) {
            this.f142a = 0;
            this.f143b = null;
            this.f144c = null;
            this.f142a = i2;
            this.f143b = request;
            this.f144c = interfaceC0026a;
        }

        @Override // p000a.p001a.p008p.InterfaceC0027b.a
        /* renamed from: a */
        public Future mo153a(Request request, InterfaceC0026a interfaceC0026a) {
            if (C0048m.this.f141a.f138d.get()) {
                ALog.m716i("anet.UnifiedRequestTask", "request canneled or timeout in processing interceptor", request.getSeq(), new Object[0]);
                return null;
            }
            if (this.f142a < C0028c.m154a()) {
                return C0028c.m155a(this.f142a).m152a(C0048m.this.new a(this.f142a + 1, request, interfaceC0026a));
            }
            C0048m.this.f141a.f135a.m826a(request);
            C0048m.this.f141a.f136b = interfaceC0026a;
            InterfaceC0009a m56a = C0014b.m102l() ? C0010b.m56a(C0048m.this.f141a.f135a.m833g(), C0048m.this.f141a.f135a.m834h()) : null;
            C0047l c0047l = C0048m.this.f141a;
            c0047l.f139e = m56a != null ? new C0038c(c0047l, m56a) : new C0042g(c0047l, null, null);
            C0048m.this.f141a.f139e.run();
            C0048m.this.m200c();
            return null;
        }

        @Override // p000a.p001a.p008p.InterfaceC0027b.a
        public InterfaceC0026a callback() {
            return this.f144c;
        }

        @Override // p000a.p001a.p008p.InterfaceC0027b.a
        public Request request() {
            return this.f143b;
        }
    }

    public C0048m(C0899k c0899k, C0895g c0895g) {
        c0895g.m820a(c0899k.f1367i);
        this.f141a = new C0047l(c0899k, c0895g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m200c() {
        this.f141a.f140f = ThreadPoolExecutorFactory.submitScheduledTask(new RunnableC0051p(this), this.f141a.f135a.m828b(), TimeUnit.MILLISECONDS);
    }

    /* renamed from: b */
    void m202b() {
        if (this.f141a.f138d.compareAndSet(false, true)) {
            ALog.m715e("anet.UnifiedRequestTask", "task cancelled", this.f141a.f137c, "URL", this.f141a.f135a.m832f().simpleUrlString());
            RequestStatistic requestStatistic = this.f141a.f135a.f1364f;
            if (requestStatistic.isDone.compareAndSet(false, true)) {
                requestStatistic.ret = 2;
                requestStatistic.statusCode = ErrorConstant.ERROR_REQUEST_CANCEL;
                requestStatistic.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_REQUEST_CANCEL);
                requestStatistic.rspEnd = System.currentTimeMillis();
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_REQUEST_CANCEL, null, requestStatistic, null));
                if (requestStatistic.recDataSize > OSSConstants.MIN_PART_SIZE_LIMIT) {
                    C0796b.m526a().m531a(requestStatistic.sendStart, requestStatistic.rspEnd, requestStatistic.recDataSize);
                }
            }
            this.f141a.m198b();
            this.f141a.m197a();
            C0047l c0047l = this.f141a;
            c0047l.f136b.mo151a(new DefaultFinishEvent(ErrorConstant.ERROR_REQUEST_CANCEL, (String) null, c0047l.f135a.m824a()));
        }
    }

    /* renamed from: a */
    public Future m201a() {
        long currentTimeMillis = System.currentTimeMillis();
        C0899k c0899k = this.f141a.f135a;
        RequestStatistic requestStatistic = c0899k.f1364f;
        requestStatistic.reqServiceTransmissionEnd = currentTimeMillis;
        requestStatistic.start = currentTimeMillis;
        requestStatistic.isReqSync = c0899k.m829c();
        this.f141a.f135a.f1364f.isReqMain = Looper.myLooper() == Looper.getMainLooper();
        try {
            this.f141a.f135a.f1364f.netReqStart = Long.valueOf(this.f141a.f135a.m825a(C0052a.f163o)).longValue();
        } catch (Exception unused) {
        }
        String m825a = this.f141a.f135a.m825a(C0052a.f164p);
        if (!TextUtils.isEmpty(m825a)) {
            this.f141a.f135a.f1364f.traceId = m825a;
        }
        String m825a2 = this.f141a.f135a.m825a(C0052a.f165q);
        C0899k c0899k2 = this.f141a.f135a;
        RequestStatistic requestStatistic2 = c0899k2.f1364f;
        requestStatistic2.process = m825a2;
        requestStatistic2.pTraceId = c0899k2.m825a(C0052a.f166r);
        C0047l c0047l = this.f141a;
        ALog.m715e("anet.UnifiedRequestTask", "[traceId:" + m825a + "]start", c0047l.f137c, "bizId", c0047l.f135a.m824a().getBizId(), "processFrom", m825a2, "url", this.f141a.f135a.m833g());
        if (!C0014b.m71a(this.f141a.f135a.m832f())) {
            ThreadPoolExecutorFactory.submitPriorityTask(new RunnableC0050o(this), ThreadPoolExecutorFactory.Priority.HIGH);
            return new FutureC0041f(this);
        }
        C0039d c0039d = new C0039d(this.f141a);
        this.f141a.f139e = c0039d;
        c0039d.f92b = new C0803b(ThreadPoolExecutorFactory.submitBackupTask(new RunnableC0049n(this)), this.f141a.f135a.m824a().getSeq());
        m200c();
        return new FutureC0041f(this);
    }
}
