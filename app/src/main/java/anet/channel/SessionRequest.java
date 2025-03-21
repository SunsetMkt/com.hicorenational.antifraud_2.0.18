package anet.channel;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.C0781a;
import anet.channel.entity.C0783c;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventType;
import anet.channel.session.C0813d;
import anet.channel.session.TnetSpdySession;
import anet.channel.statist.AlarmObject;
import anet.channel.statist.SessionConnStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.utils.C0848c;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.C0857c;
import anet.channel.util.C0863i;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.C3042j;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.analytics.pro.C3397d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class SessionRequest {

    /* renamed from: a */
    SessionCenter f721a;

    /* renamed from: b */
    C0773e f722b;

    /* renamed from: c */
    SessionInfo f723c;

    /* renamed from: e */
    volatile Session f725e;

    /* renamed from: i */
    private String f729i;

    /* renamed from: j */
    private String f730j;

    /* renamed from: k */
    private volatile Future f731k;

    /* renamed from: d */
    volatile boolean f724d = false;

    /* renamed from: f */
    volatile boolean f726f = false;

    /* renamed from: g */
    HashMap<SessionGetCallback, RunnableC0741c> f727g = new HashMap<>();

    /* renamed from: h */
    SessionConnStat f728h = null;

    /* renamed from: l */
    private Object f732l = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    interface IConnCb {
        void onDisConnect(Session session, long j2, int i2);

        void onFailed(Session session, long j2, int i2, int i3);

        void onSuccess(Session session, long j2);
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.SessionRequest$a */
    class C0739a implements IConnCb {

        /* renamed from: a */
        boolean f733a = false;

        /* renamed from: c */
        private Context f735c;

        /* renamed from: d */
        private List<C0781a> f736d;

        /* renamed from: e */
        private C0781a f737e;

        C0739a(Context context, List<C0781a> list, C0781a c0781a) {
            this.f735c = context;
            this.f736d = list;
            this.f737e = c0781a;
        }

        @Override // anet.channel.SessionRequest.IConnCb
        public void onDisConnect(Session session, long j2, int i2) {
            SessionInfo sessionInfo;
            boolean isAppBackground = GlobalAppRuntimeInfo.isAppBackground();
            ALog.m713d("awcn.SessionRequest", "Connect Disconnect", this.f737e.m515h(), C3397d.f11932aw, session, Constants.KEY_HOST, SessionRequest.this.m429a(), "appIsBg", Boolean.valueOf(isAppBackground), "isHandleFinish", Boolean.valueOf(this.f733a));
            SessionRequest sessionRequest = SessionRequest.this;
            sessionRequest.f722b.m488b(sessionRequest, session);
            if (this.f733a) {
                return;
            }
            this.f733a = true;
            if (session.f702t) {
                if (isAppBackground && ((sessionInfo = SessionRequest.this.f723c) == null || !sessionInfo.isAccs || AwcnConfig.isAccsSessionCreateForbiddenInBg())) {
                    ALog.m715e("awcn.SessionRequest", "[onDisConnect]app background, don't Recreate", this.f737e.m515h(), C3397d.f11932aw, session);
                    return;
                }
                if (!NetworkStatusHelper.isConnected()) {
                    ALog.m715e("awcn.SessionRequest", "[onDisConnect]no network, don't Recreate", this.f737e.m515h(), C3397d.f11932aw, session);
                    return;
                }
                try {
                    ALog.m713d("awcn.SessionRequest", "session disconnected, try to recreate session", this.f737e.m515h(), new Object[0]);
                    int i3 = 10000;
                    if (SessionRequest.this.f723c != null && SessionRequest.this.f723c.isAccs) {
                        i3 = AwcnConfig.getAccsReconnectionDelayPeriod();
                    }
                    ThreadPoolExecutorFactory.submitScheduledTask(new RunnableC0792i(this, session), (long) (Math.random() * i3), TimeUnit.MILLISECONDS);
                } catch (Exception unused) {
                }
            }
        }

        @Override // anet.channel.SessionRequest.IConnCb
        public void onFailed(Session session, long j2, int i2, int i3) {
            if (ALog.isPrintLog(1)) {
                ALog.m713d("awcn.SessionRequest", "Connect failed", this.f737e.m515h(), C3397d.f11932aw, session, Constants.KEY_HOST, SessionRequest.this.m429a(), "isHandleFinish", Boolean.valueOf(this.f733a));
            }
            if (SessionRequest.this.f726f) {
                SessionRequest.this.f726f = false;
                return;
            }
            if (this.f733a) {
                return;
            }
            this.f733a = true;
            SessionRequest sessionRequest = SessionRequest.this;
            sessionRequest.f722b.m488b(sessionRequest, session);
            if (!session.f703u || !NetworkStatusHelper.isConnected() || this.f736d.isEmpty()) {
                SessionRequest.this.m440c();
                SessionRequest.this.m433a(session, i2, i3);
                synchronized (SessionRequest.this.f727g) {
                    for (Map.Entry<SessionGetCallback, RunnableC0741c> entry : SessionRequest.this.f727g.entrySet()) {
                        RunnableC0741c value = entry.getValue();
                        if (value.f741b.compareAndSet(false, true)) {
                            ThreadPoolExecutorFactory.removeScheduleTask(value);
                            entry.getKey().onSessionGetFail();
                        }
                    }
                    SessionRequest.this.f727g.clear();
                }
                return;
            }
            if (ALog.isPrintLog(1)) {
                ALog.m713d("awcn.SessionRequest", "use next connInfo to create session", this.f737e.m515h(), Constants.KEY_HOST, SessionRequest.this.m429a());
            }
            C0781a c0781a = this.f737e;
            if (c0781a.f836b == c0781a.f837c && (i3 == -2003 || i3 == -2410)) {
                ListIterator<C0781a> listIterator = this.f736d.listIterator();
                while (listIterator.hasNext()) {
                    if (session.getIp().equals(listIterator.next().f835a.getIp())) {
                        listIterator.remove();
                    }
                }
            }
            if (C0848c.m708b(session.getIp())) {
                ListIterator<C0781a> listIterator2 = this.f736d.listIterator();
                while (listIterator2.hasNext()) {
                    if (C0848c.m708b(listIterator2.next().f835a.getIp())) {
                        listIterator2.remove();
                    }
                }
            }
            if (!this.f736d.isEmpty()) {
                C0781a remove = this.f736d.remove(0);
                SessionRequest sessionRequest2 = SessionRequest.this;
                Context context = this.f735c;
                sessionRequest2.m424a(context, remove, sessionRequest2.new C0739a(context, this.f736d, remove), remove.m515h());
                return;
            }
            SessionRequest.this.m440c();
            SessionRequest.this.m433a(session, i2, i3);
            synchronized (SessionRequest.this.f727g) {
                for (Map.Entry<SessionGetCallback, RunnableC0741c> entry2 : SessionRequest.this.f727g.entrySet()) {
                    RunnableC0741c value2 = entry2.getValue();
                    if (value2.f741b.compareAndSet(false, true)) {
                        ThreadPoolExecutorFactory.removeScheduleTask(value2);
                        entry2.getKey().onSessionGetFail();
                    }
                }
                SessionRequest.this.f727g.clear();
            }
        }

        @Override // anet.channel.SessionRequest.IConnCb
        public void onSuccess(Session session, long j2) {
            ALog.m713d("awcn.SessionRequest", "Connect Success", this.f737e.m515h(), C3397d.f11932aw, session, Constants.KEY_HOST, SessionRequest.this.m429a());
            try {
                if (SessionRequest.this.f726f) {
                    SessionRequest.this.f726f = false;
                    session.close(false);
                    return;
                }
                SessionRequest.this.f722b.m487a(SessionRequest.this, session);
                SessionRequest.this.m432a(session);
                synchronized (SessionRequest.this.f727g) {
                    for (Map.Entry<SessionGetCallback, RunnableC0741c> entry : SessionRequest.this.f727g.entrySet()) {
                        RunnableC0741c value = entry.getValue();
                        if (value.f741b.compareAndSet(false, true)) {
                            ThreadPoolExecutorFactory.removeScheduleTask(value);
                            entry.getKey().onSessionGetSuccess(session);
                        }
                    }
                    SessionRequest.this.f727g.clear();
                }
            } catch (Exception e2) {
                ALog.m714e("awcn.SessionRequest", "[onSuccess]:", this.f737e.m515h(), e2, new Object[0]);
            } finally {
                SessionRequest.this.m440c();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.SessionRequest$b */
    private class RunnableC0740b implements Runnable {

        /* renamed from: a */
        String f738a;

        RunnableC0740b(String str) {
            this.f738a = null;
            this.f738a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SessionRequest.this.f724d) {
                ALog.m715e("awcn.SessionRequest", "Connecting timeout!!! reset status!", this.f738a, new Object[0]);
                SessionConnStat sessionConnStat = SessionRequest.this.f728h;
                sessionConnStat.ret = 2;
                sessionConnStat.totalTime = System.currentTimeMillis() - SessionRequest.this.f728h.start;
                if (SessionRequest.this.f725e != null) {
                    SessionRequest.this.f725e.f703u = false;
                    SessionRequest.this.f725e.close();
                    SessionRequest sessionRequest = SessionRequest.this;
                    sessionRequest.f728h.syncValueFromSession(sessionRequest.f725e);
                }
                AppMonitor.getInstance().commitStat(SessionRequest.this.f728h);
                SessionRequest.this.m436a(false);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.SessionRequest$c */
    protected class RunnableC0741c implements Runnable {

        /* renamed from: a */
        SessionGetCallback f740a;

        /* renamed from: b */
        AtomicBoolean f741b = new AtomicBoolean(false);

        protected RunnableC0741c(SessionGetCallback sessionGetCallback) {
            this.f740a = null;
            this.f740a = sessionGetCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f741b.compareAndSet(false, true)) {
                ALog.m715e("awcn.SessionRequest", "get session timeout", null, new Object[0]);
                synchronized (SessionRequest.this.f727g) {
                    SessionRequest.this.f727g.remove(this.f740a);
                }
                this.f740a.onSessionGetFail();
            }
        }
    }

    SessionRequest(String str, SessionCenter sessionCenter) {
        this.f729i = str;
        String str2 = this.f729i;
        this.f730j = str2.substring(str2.indexOf(HttpConstant.SCHEME_SPLIT) + 3);
        this.f721a = sessionCenter;
        this.f723c = sessionCenter.f716g.m453b(this.f730j);
        this.f722b = sessionCenter.f714e;
    }

    /* renamed from: b */
    protected synchronized void m438b(Context context, int i2, String str, SessionGetCallback sessionGetCallback, long j2) {
        Session m484a = this.f722b.m484a(this, i2);
        if (m484a != null) {
            ALog.m713d("awcn.SessionRequest", "Available Session exist!!!", str, new Object[0]);
            sessionGetCallback.onSessionGetSuccess(m484a);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = C0863i.m740a(null);
        }
        ALog.m713d("awcn.SessionRequest", "SessionRequest start", str, Constants.KEY_HOST, this.f729i, "type", Integer.valueOf(i2));
        if (this.f724d) {
            ALog.m713d("awcn.SessionRequest", "session connecting", str, Constants.KEY_HOST, m429a());
            if (m437b() == i2) {
                RunnableC0741c runnableC0741c = new RunnableC0741c(sessionGetCallback);
                synchronized (this.f727g) {
                    this.f727g.put(sessionGetCallback, runnableC0741c);
                }
                ThreadPoolExecutorFactory.submitScheduledTask(runnableC0741c, j2, TimeUnit.MILLISECONDS);
            } else {
                sessionGetCallback.onSessionGetFail();
            }
            return;
        }
        m436a(true);
        this.f731k = ThreadPoolExecutorFactory.submitScheduledTask(new RunnableC0740b(str), 45L, TimeUnit.SECONDS);
        this.f728h = new SessionConnStat();
        this.f728h.start = System.currentTimeMillis();
        if (!NetworkStatusHelper.isConnected()) {
            if (ALog.isPrintLog(1)) {
                ALog.m713d("awcn.SessionRequest", "network is not available, can't create session", str, "isConnected", Boolean.valueOf(NetworkStatusHelper.isConnected()));
            }
            m440c();
            throw new RuntimeException("no network");
        }
        List<IConnStrategy> m422a = m422a(i2, str);
        if (m422a.isEmpty()) {
            ALog.m716i("awcn.SessionRequest", "no avalible strategy, can't create session", str, Constants.KEY_HOST, this.f729i, "type", Integer.valueOf(i2));
            m440c();
            throw new NoAvailStrategyException("no avalible strategy");
        }
        List<C0781a> m423a = m423a(m422a, str);
        try {
            C0781a remove = m423a.remove(0);
            m424a(context, remove, new C0739a(context, m423a, remove), remove.m515h());
            RunnableC0741c runnableC0741c2 = new RunnableC0741c(sessionGetCallback);
            synchronized (this.f727g) {
                this.f727g.put(sessionGetCallback, runnableC0741c2);
            }
            ThreadPoolExecutorFactory.submitScheduledTask(runnableC0741c2, j2, TimeUnit.MILLISECONDS);
        } catch (Throwable unused) {
            m440c();
        }
        return;
    }

    /* renamed from: c */
    void m440c() {
        m436a(false);
        synchronized (this.f732l) {
            this.f732l.notifyAll();
        }
    }

    /* renamed from: a */
    protected String m429a() {
        return this.f729i;
    }

    /* renamed from: a */
    void m436a(boolean z) {
        this.f724d = z;
        if (z) {
            return;
        }
        if (this.f731k != null) {
            this.f731k.cancel(true);
            this.f731k = null;
        }
        this.f725e = null;
    }

    /* renamed from: c */
    private void m428c(Session session, int i2, String str) {
        SessionInfo sessionInfo = this.f723c;
        if (sessionInfo == null || !sessionInfo.isAccs) {
            return;
        }
        ALog.m715e("awcn.SessionRequest", "sendConnectInfoToAccsByCallBack", null, new Object[0]);
        Intent intent = new Intent(Constants.ACTION_ACCS_CONNECT_INFO);
        intent.putExtra("command", 103);
        intent.putExtra(Constants.KEY_HOST, session.getHost());
        intent.putExtra(Constants.KEY_CENTER_HOST, true);
        boolean isAvailable = session.isAvailable();
        if (!isAvailable) {
            intent.putExtra(Constants.KEY_ERROR_CODE, i2);
            intent.putExtra(Constants.KEY_ERROR_DETAIL, str);
        }
        intent.putExtra(Constants.KEY_CONNECT_AVAILABLE, isAvailable);
        intent.putExtra(Constants.KEY_TYPE_INAPP, true);
        this.f721a.f717h.notifyListener(intent);
    }

    /* renamed from: a */
    protected synchronized void m431a(Context context, int i2, String str, SessionGetCallback sessionGetCallback, long j2) {
        Session m484a = this.f722b.m484a(this, i2);
        if (m484a != null) {
            ALog.m713d("awcn.SessionRequest", "Available Session exist!!!", str, new Object[0]);
            if (sessionGetCallback != null) {
                sessionGetCallback.onSessionGetSuccess(m484a);
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = C0863i.m740a(null);
        }
        ALog.m713d("awcn.SessionRequest", "SessionRequest start", str, Constants.KEY_HOST, this.f729i, "type", Integer.valueOf(i2));
        if (this.f724d) {
            ALog.m713d("awcn.SessionRequest", "session connecting", str, Constants.KEY_HOST, m429a());
            if (sessionGetCallback != null) {
                if (m437b() == i2) {
                    RunnableC0741c runnableC0741c = new RunnableC0741c(sessionGetCallback);
                    synchronized (this.f727g) {
                        this.f727g.put(sessionGetCallback, runnableC0741c);
                    }
                    ThreadPoolExecutorFactory.submitScheduledTask(runnableC0741c, j2, TimeUnit.MILLISECONDS);
                } else {
                    sessionGetCallback.onSessionGetFail();
                }
            }
            return;
        }
        m436a(true);
        this.f731k = ThreadPoolExecutorFactory.submitScheduledTask(new RunnableC0740b(str), 45L, TimeUnit.SECONDS);
        this.f728h = new SessionConnStat();
        this.f728h.start = System.currentTimeMillis();
        if (!NetworkStatusHelper.isConnected()) {
            if (ALog.isPrintLog(1)) {
                ALog.m713d("awcn.SessionRequest", "network is not available, can't create session", str, "isConnected", Boolean.valueOf(NetworkStatusHelper.isConnected()));
            }
            m440c();
            throw new RuntimeException("no network");
        }
        List<IConnStrategy> m422a = m422a(i2, str);
        if (!m422a.isEmpty()) {
            List<C0781a> m423a = m423a(m422a, str);
            try {
                C0781a remove = m423a.remove(0);
                m424a(context, remove, new C0739a(context, m423a, remove), remove.m515h());
                if (sessionGetCallback != null) {
                    RunnableC0741c runnableC0741c2 = new RunnableC0741c(sessionGetCallback);
                    synchronized (this.f727g) {
                        this.f727g.put(sessionGetCallback, runnableC0741c2);
                    }
                    ThreadPoolExecutorFactory.submitScheduledTask(runnableC0741c2, j2, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable unused) {
                m440c();
            }
            return;
        }
        ALog.m716i("awcn.SessionRequest", "no avalible strategy, can't create session", str, Constants.KEY_HOST, this.f729i, "type", Integer.valueOf(i2));
        m440c();
        throw new NoAvailStrategyException("no avalible strategy");
    }

    /* renamed from: b */
    protected void m439b(boolean z) {
        ALog.m713d("awcn.SessionRequest", "closeSessions", this.f721a.f712c, Constants.KEY_HOST, this.f729i, "autoCreate", Boolean.valueOf(z));
        if (!z && this.f725e != null) {
            this.f725e.f703u = false;
            this.f725e.close(false);
        }
        List<Session> m486a = this.f722b.m486a(this);
        if (m486a != null) {
            for (Session session : m486a) {
                if (session != null) {
                    session.close(z);
                }
            }
        }
    }

    /* renamed from: a */
    void m432a(Session session) {
        AlarmObject alarmObject = new AlarmObject();
        alarmObject.module = "networkPrefer";
        alarmObject.modulePoint = C3351bh.f11648bt;
        alarmObject.arg = this.f729i;
        alarmObject.isSuccess = true;
        AppMonitor.getInstance().commitAlarm(alarmObject);
        this.f728h.syncValueFromSession(session);
        SessionConnStat sessionConnStat = this.f728h;
        sessionConnStat.ret = 1;
        sessionConnStat.totalTime = System.currentTimeMillis() - this.f728h.start;
        AppMonitor.getInstance().commitStat(this.f728h);
    }

    /* renamed from: b */
    protected int m437b() {
        Session session = this.f725e;
        if (session != null) {
            return session.f692j.getType();
        }
        return -1;
    }

    /* renamed from: b */
    private void m427b(Session session, int i2, String str) {
        SessionInfo sessionInfo;
        Context context = GlobalAppRuntimeInfo.getContext();
        if (context == null || (sessionInfo = this.f723c) == null || !sessionInfo.isAccs) {
            return;
        }
        ALog.m715e("awcn.SessionRequest", "sendConnectInfoToAccsByService", null, new Object[0]);
        try {
            Intent intent = new Intent(Constants.ACTION_RECEIVE);
            intent.setPackage(context.getPackageName());
            intent.setClassName(context, C3042j.msgService);
            intent.putExtra("command", 103);
            intent.putExtra(Constants.KEY_HOST, session.getHost());
            intent.putExtra(Constants.KEY_CENTER_HOST, true);
            boolean isAvailable = session.isAvailable();
            if (!isAvailable) {
                intent.putExtra(Constants.KEY_ERROR_CODE, i2);
                intent.putExtra(Constants.KEY_ERROR_DETAIL, str);
            }
            intent.putExtra(Constants.KEY_CONNECT_AVAILABLE, isAvailable);
            intent.putExtra(Constants.KEY_TYPE_INAPP, true);
            if (Build.VERSION.SDK_INT >= 26) {
                context.bindService(intent, new ServiceConnectionC0788h(this, intent, context), 1);
            } else {
                context.startService(intent);
            }
        } catch (Throwable th) {
            ALog.m714e("awcn.SessionRequest", "sendConnectInfoToAccsByService", null, th, new Object[0]);
        }
    }

    /* renamed from: a */
    void m433a(Session session, int i2, int i3) {
        if (256 != i2 || i3 == -2613 || i3 == -2601) {
            return;
        }
        AlarmObject alarmObject = new AlarmObject();
        alarmObject.module = "networkPrefer";
        alarmObject.modulePoint = C3351bh.f11648bt;
        alarmObject.arg = this.f729i;
        alarmObject.errorCode = String.valueOf(i3);
        alarmObject.isSuccess = false;
        AppMonitor.getInstance().commitAlarm(alarmObject);
        SessionConnStat sessionConnStat = this.f728h;
        sessionConnStat.ret = 0;
        sessionConnStat.appendErrorTrace(i3);
        this.f728h.errorCode = String.valueOf(i3);
        this.f728h.totalTime = System.currentTimeMillis() - this.f728h.start;
        this.f728h.syncValueFromSession(session);
        AppMonitor.getInstance().commitStat(this.f728h);
    }

    /* renamed from: a */
    private List<IConnStrategy> m422a(int i2, String str) {
        HttpUrl parse;
        List<IConnStrategy> list = Collections.EMPTY_LIST;
        try {
            parse = HttpUrl.parse(m429a());
        } catch (Throwable th) {
            ALog.m714e("awcn.SessionRequest", "", str, th, new Object[0]);
        }
        if (parse == null) {
            return Collections.EMPTY_LIST;
        }
        list = StrategyCenter.getInstance().getConnStrategyListByHost(parse.host());
        if (!list.isEmpty()) {
            boolean equalsIgnoreCase = HttpConstant.HTTPS.equalsIgnoreCase(parse.scheme());
            boolean m726b = C0857c.m726b();
            ListIterator<IConnStrategy> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                IConnStrategy next = listIterator.next();
                ConnType valueOf = ConnType.valueOf(next.getProtocol());
                if (valueOf != null) {
                    if (valueOf.isSSL() == equalsIgnoreCase && (i2 == C0783c.f845c || valueOf.getType() == i2)) {
                        if (m726b && C0848c.m708b(next.getIp())) {
                            listIterator.remove();
                        }
                    }
                    listIterator.remove();
                }
            }
        }
        if (ALog.isPrintLog(1)) {
            ALog.m713d("awcn.SessionRequest", "[getAvailStrategy]", str, "strategies", list);
        }
        return list;
    }

    /* renamed from: a */
    private List<C0781a> m423a(List<IConnStrategy> list, String str) {
        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (i2 < list.size()) {
            IConnStrategy iConnStrategy = list.get(i2);
            int retryTimes = iConnStrategy.getRetryTimes();
            int i4 = i3;
            for (int i5 = 0; i5 <= retryTimes; i5++) {
                i4++;
                C0781a c0781a = new C0781a(m429a(), str + AbstractC1191a.f2606s1 + i4, iConnStrategy);
                c0781a.f836b = i5;
                c0781a.f837c = retryTimes;
                arrayList.add(c0781a);
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m424a(Context context, C0781a c0781a, IConnCb iConnCb, String str) {
        ConnType m510c = c0781a.m510c();
        if (context != null && !m510c.isHttpType()) {
            TnetSpdySession tnetSpdySession = new TnetSpdySession(context, c0781a);
            tnetSpdySession.initConfig(this.f721a.f713d);
            tnetSpdySession.initSessionInfo(this.f723c);
            tnetSpdySession.setTnetPublicKey(this.f721a.f716g.m454c(this.f730j));
            this.f725e = tnetSpdySession;
        } else {
            this.f725e = new C0813d(context, c0781a);
        }
        ALog.m716i("awcn.SessionRequest", "create connection...", str, "Host", m429a(), "Type", c0781a.m510c(), "IP", c0781a.m508a(), "Port", Integer.valueOf(c0781a.m509b()), "heartbeat", Integer.valueOf(c0781a.m514g()), C3397d.f11932aw, this.f725e);
        m425a(this.f725e, iConnCb, System.currentTimeMillis());
        this.f725e.connect();
        SessionConnStat sessionConnStat = this.f728h;
        sessionConnStat.retryTimes++;
        sessionConnStat.startConnect = System.currentTimeMillis();
        SessionConnStat sessionConnStat2 = this.f728h;
        if (sessionConnStat2.retryTimes == 0) {
            sessionConnStat2.putExtra("firstIp", c0781a.m508a());
        }
    }

    /* renamed from: a */
    private void m425a(Session session, IConnCb iConnCb, long j2) {
        if (iConnCb == null) {
            return;
        }
        session.registerEventcb(EventType.ALL, new C0784f(this, iConnCb, j2));
        session.registerEventcb(1792, new C0787g(this, session));
    }

    /* renamed from: a */
    protected void m435a(String str) {
        ALog.m713d("awcn.SessionRequest", "reCreateSession", str, Constants.KEY_HOST, this.f729i);
        m439b(true);
    }

    /* renamed from: a */
    protected void m430a(long j2) throws InterruptedException, TimeoutException {
        ALog.m713d("awcn.SessionRequest", "[await]", null, "timeoutMs", Long.valueOf(j2));
        if (j2 <= 0) {
            return;
        }
        synchronized (this.f732l) {
            long currentTimeMillis = System.currentTimeMillis() + j2;
            while (this.f724d) {
                long currentTimeMillis2 = System.currentTimeMillis();
                if (currentTimeMillis2 >= currentTimeMillis) {
                    break;
                } else {
                    this.f732l.wait(currentTimeMillis - currentTimeMillis2);
                }
            }
            if (this.f724d) {
                throw new TimeoutException();
            }
        }
    }

    /* renamed from: a */
    void m434a(Session session, int i2, String str) {
        if (AwcnConfig.isSendConnectInfoByService()) {
            m427b(session, i2, str);
        }
        m428c(session, i2, str);
    }
}
