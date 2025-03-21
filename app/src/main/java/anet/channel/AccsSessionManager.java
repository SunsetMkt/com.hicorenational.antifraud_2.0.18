package anet.channel;

import android.content.Intent;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;
import com.taobao.accs.common.Constants;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class AccsSessionManager {

    /* renamed from: c */
    private static CopyOnWriteArraySet<ISessionListener> f632c = new CopyOnWriteArraySet<>();

    /* renamed from: a */
    SessionCenter f633a;

    /* renamed from: b */
    Set<String> f634b = Collections.EMPTY_SET;

    AccsSessionManager(SessionCenter sessionCenter) {
        this.f633a = null;
        this.f633a = sessionCenter;
    }

    /* renamed from: b */
    private boolean m400b() {
        return !(GlobalAppRuntimeInfo.isAppBackground() && AwcnConfig.isAccsSessionCreateForbiddenInBg()) && NetworkStatusHelper.isConnected();
    }

    public synchronized void checkAndStartSession() {
        Collection<SessionInfo> m450a = this.f633a.f716g.m450a();
        Set<String> set = Collections.EMPTY_SET;
        if (!m450a.isEmpty()) {
            set = new TreeSet<>();
        }
        for (SessionInfo sessionInfo : m450a) {
            if (sessionInfo.isKeepAlive) {
                set.add(StringUtils.concatString(StrategyCenter.getInstance().getSchemeByHost(sessionInfo.host, sessionInfo.isAccs ? HttpConstant.HTTPS : HttpConstant.HTTP), HttpConstant.SCHEME_SPLIT, sessionInfo.host));
            }
        }
        for (String str : this.f634b) {
            if (!set.contains(str)) {
                m399a(str);
            }
        }
        if (m400b()) {
            for (String str2 : set) {
                try {
                    this.f633a.get(str2, ConnType.TypeLevel.SPDY, 0L);
                } catch (Exception unused) {
                    ALog.m715e("start session failed", null, Constants.KEY_HOST, str2);
                }
            }
            this.f634b = set;
        }
    }

    public synchronized void forceCloseSession(boolean z) {
        if (ALog.isPrintLog(1)) {
            ALog.m713d("awcn.AccsSessionManager", "forceCloseSession", this.f633a.f712c, "reCreate", Boolean.valueOf(z));
        }
        Iterator<String> it = this.f634b.iterator();
        while (it.hasNext()) {
            m399a(it.next());
        }
        if (z) {
            checkAndStartSession();
        }
    }

    public void notifyListener(Intent intent) {
        ThreadPoolExecutorFactory.submitScheduledTask(new RunnableC0742a(this, intent));
    }

    public void registerListener(ISessionListener iSessionListener) {
        if (iSessionListener != null) {
            f632c.add(iSessionListener);
        }
    }

    public void unregisterListener(ISessionListener iSessionListener) {
        f632c.remove(iSessionListener);
    }

    /* renamed from: a */
    private void m399a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ALog.m713d("awcn.AccsSessionManager", "closeSessions", this.f633a.f712c, Constants.KEY_HOST, str);
        this.f633a.m418a(str).m439b(false);
    }
}
