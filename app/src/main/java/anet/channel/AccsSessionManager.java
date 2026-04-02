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

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class AccsSessionManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static CopyOnWriteArraySet<ISessionListener> f1310c = new CopyOnWriteArraySet<>();
    SessionCenter a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Set<String> f1311b = Collections.EMPTY_SET;

    AccsSessionManager(SessionCenter sessionCenter) {
        this.a = null;
        this.a = sessionCenter;
    }

    private boolean b() {
        return !(GlobalAppRuntimeInfo.isAppBackground() && AwcnConfig.isAccsSessionCreateForbiddenInBg()) && NetworkStatusHelper.isConnected();
    }

    public synchronized void checkAndStartSession() {
        Collection<SessionInfo> collectionA = this.a.f1363g.a();
        Set<String> treeSet = Collections.EMPTY_SET;
        if (!collectionA.isEmpty()) {
            treeSet = new TreeSet<>();
        }
        for (SessionInfo sessionInfo : collectionA) {
            if (sessionInfo.isKeepAlive) {
                treeSet.add(StringUtils.concatString(StrategyCenter.getInstance().getSchemeByHost(sessionInfo.host, sessionInfo.isAccs ? HttpConstant.HTTPS : HttpConstant.HTTP), HttpConstant.SCHEME_SPLIT, sessionInfo.host));
            }
        }
        for (String str : this.f1311b) {
            if (!treeSet.contains(str)) {
                a(str);
            }
        }
        if (b()) {
            for (String str2 : treeSet) {
                try {
                    this.a.get(str2, ConnType.TypeLevel.SPDY, 0L);
                } catch (Exception unused) {
                    ALog.e("start session failed", null, Constants.KEY_HOST, str2);
                }
            }
            this.f1311b = treeSet;
        }
    }

    public synchronized void forceCloseSession(boolean z) {
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.AccsSessionManager", "forceCloseSession", this.a.f1359c, "reCreate", Boolean.valueOf(z));
        }
        Iterator<String> it = this.f1311b.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        if (z) {
            checkAndStartSession();
        }
    }

    public void notifyListener(Intent intent) {
        ThreadPoolExecutorFactory.submitScheduledTask(new a(this, intent));
    }

    public void registerListener(ISessionListener iSessionListener) {
        if (iSessionListener != null) {
            f1310c.add(iSessionListener);
        }
    }

    public void unregisterListener(ISessionListener iSessionListener) {
        f1310c.remove(iSessionListener);
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ALog.d("awcn.AccsSessionManager", "closeSessions", this.a.f1359c, Constants.KEY_HOST, str);
        this.a.a(str).b(false);
    }
}
