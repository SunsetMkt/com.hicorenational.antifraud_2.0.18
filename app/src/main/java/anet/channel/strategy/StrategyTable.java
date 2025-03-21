package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.entity.ConnType;
import anet.channel.p021e.C0774a;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.C0842l;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.strategy.utils.C0848c;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class StrategyTable implements Serializable {

    /* renamed from: e */
    protected static Comparator<StrategyCollection> f1061e = new C0845o();

    /* renamed from: a */
    protected String f1062a;

    /* renamed from: b */
    protected volatile String f1063b;

    /* renamed from: c */
    Map<String, Long> f1064c;

    /* renamed from: d */
    protected transient boolean f1065d = false;

    /* renamed from: f */
    private HostLruCache f1066f;

    /* renamed from: g */
    private volatile transient int f1067g;

    /* compiled from: Taobao */
    private static class HostLruCache extends SerialLruCache<String, StrategyCollection> {
        public HostLruCache(int i2) {
            super(i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // anet.channel.strategy.utils.SerialLruCache
        public boolean entryRemoved(Map.Entry<String, StrategyCollection> entry) {
            if (!entry.getValue().f1043d) {
                return true;
            }
            Iterator<Map.Entry<String, StrategyCollection>> it = entrySet().iterator();
            while (it.hasNext()) {
                if (!it.next().getValue().f1043d) {
                    it.remove();
                    return false;
                }
            }
            return false;
        }
    }

    protected StrategyTable(String str) {
        this.f1062a = str;
        m658a();
    }

    /* renamed from: b */
    private void m655b() {
        if (HttpDispatcher.getInstance().isInitHostsChanged(this.f1062a)) {
            for (String str : HttpDispatcher.getInstance().getInitHosts()) {
                this.f1066f.put(str, new StrategyCollection(str));
            }
        }
    }

    /* renamed from: c */
    private void m657c() {
        try {
            if (HttpDispatcher.getInstance().isInitHostsChanged(this.f1062a)) {
                TreeSet treeSet = null;
                synchronized (this.f1066f) {
                    for (String str : HttpDispatcher.getInstance().getInitHosts()) {
                        if (!this.f1066f.containsKey(str)) {
                            this.f1066f.put(str, new StrategyCollection(str));
                            if (treeSet == null) {
                                treeSet = new TreeSet();
                            }
                            treeSet.add(str);
                        }
                    }
                }
                if (treeSet != null) {
                    m654a(treeSet);
                }
            }
        } catch (Exception e2) {
            ALog.m714e("awcn.StrategyTable", "checkInitHost failed", this.f1062a, e2, new Object[0]);
        }
    }

    /* renamed from: a */
    protected void m658a() {
        if (this.f1066f == null) {
            this.f1066f = new HostLruCache(256);
            m655b();
        }
        Iterator<StrategyCollection> it = this.f1066f.values().iterator();
        while (it.hasNext()) {
            it.next().checkInit();
        }
        ALog.m716i("awcn.StrategyTable", "strategy map", null, "size", Integer.valueOf(this.f1066f.size()));
        this.f1067g = GlobalAppRuntimeInfo.isTargetProcess() ? 0 : -1;
        if (this.f1064c == null) {
            this.f1064c = new ConcurrentHashMap();
        }
    }

    public String getCnameByHost(String str) {
        StrategyCollection strategyCollection;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f1066f) {
            strategyCollection = this.f1066f.get(str);
        }
        if (strategyCollection != null && strategyCollection.isExpired() && AmdcRuntimeInfo.getAmdcLimitLevel() == 0) {
            m653a(str);
        }
        if (strategyCollection != null) {
            return strategyCollection.f1042c;
        }
        return null;
    }

    public List<IConnStrategy> queryByHost(String str) {
        StrategyCollection strategyCollection;
        if (TextUtils.isEmpty(str) || !C0848c.m709c(str)) {
            return Collections.EMPTY_LIST;
        }
        m657c();
        synchronized (this.f1066f) {
            strategyCollection = this.f1066f.get(str);
            if (strategyCollection == null) {
                strategyCollection = new StrategyCollection(str);
                this.f1066f.put(str, strategyCollection);
            }
        }
        if (strategyCollection.f1041b == 0 || (strategyCollection.isExpired() && AmdcRuntimeInfo.getAmdcLimitLevel() == 0)) {
            m653a(str);
        }
        return strategyCollection.queryStrategyList();
    }

    public void update(C0842l.d dVar) {
        C0842l.b[] bVarArr;
        ALog.m716i("awcn.StrategyTable", "update strategyTable with httpDns response", this.f1062a, new Object[0]);
        try {
            this.f1063b = dVar.f1131a;
            this.f1067g = dVar.f1136f;
            bVarArr = dVar.f1132b;
        } catch (Throwable th) {
            ALog.m714e("awcn.StrategyTable", "fail to update strategyTable", this.f1062a, th, new Object[0]);
        }
        if (bVarArr == null) {
            return;
        }
        synchronized (this.f1066f) {
            for (C0842l.b bVar : bVarArr) {
                if (bVar != null && bVar.f1117a != null) {
                    if (bVar.f1126j) {
                        this.f1066f.remove(bVar.f1117a);
                    } else {
                        StrategyCollection strategyCollection = this.f1066f.get(bVar.f1117a);
                        if (strategyCollection == null) {
                            strategyCollection = new StrategyCollection(bVar.f1117a);
                            this.f1066f.put(bVar.f1117a, strategyCollection);
                        }
                        strategyCollection.update(bVar);
                    }
                }
            }
        }
        this.f1065d = true;
        if (ALog.isPrintLog(1)) {
            StringBuilder sb = new StringBuilder("uniqueId : ");
            sb.append(this.f1062a);
            sb.append("\n-------------------------domains:------------------------------------");
            ALog.m713d("awcn.StrategyTable", sb.toString(), null, new Object[0]);
            synchronized (this.f1066f) {
                for (Map.Entry<String, StrategyCollection> entry : this.f1066f.entrySet()) {
                    sb.setLength(0);
                    sb.append(entry.getKey());
                    sb.append(" = ");
                    sb.append(entry.getValue().toString());
                    ALog.m713d("awcn.StrategyTable", sb.toString(), null, new Object[0]);
                }
            }
        }
    }

    /* renamed from: b */
    private void m656b(Set<String> set) {
        TreeSet treeSet = new TreeSet(f1061e);
        synchronized (this.f1066f) {
            treeSet.addAll(this.f1066f.values());
        }
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            StrategyCollection strategyCollection = (StrategyCollection) it.next();
            if (!strategyCollection.isExpired() || set.size() >= 40) {
                return;
            }
            strategyCollection.f1041b = 30000 + currentTimeMillis;
            set.add(strategyCollection.f1040a);
        }
    }

    /* renamed from: a */
    private void m653a(String str) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(str);
        m654a(treeSet);
    }

    /* renamed from: a */
    protected void m660a(String str, boolean z) {
        StrategyCollection strategyCollection;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f1066f) {
            strategyCollection = this.f1066f.get(str);
            if (strategyCollection == null) {
                strategyCollection = new StrategyCollection(str);
                this.f1066f.put(str, strategyCollection);
            }
        }
        if (z || strategyCollection.f1041b == 0 || (strategyCollection.isExpired() && AmdcRuntimeInfo.getAmdcLimitLevel() == 0)) {
            m653a(str);
        }
    }

    /* renamed from: a */
    private void m654a(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        if ((GlobalAppRuntimeInfo.isAppBackground() && AppLifecycle.lastEnterBackgroundTime > 0) || !NetworkStatusHelper.isConnected()) {
            ALog.m716i("awcn.StrategyTable", "app in background or no network", this.f1062a, new Object[0]);
            return;
        }
        int amdcLimitLevel = AmdcRuntimeInfo.getAmdcLimitLevel();
        if (amdcLimitLevel == 3) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f1066f) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                StrategyCollection strategyCollection = this.f1066f.get(it.next());
                if (strategyCollection != null) {
                    strategyCollection.f1041b = 30000 + currentTimeMillis;
                }
            }
        }
        if (amdcLimitLevel == 0) {
            m656b(set);
        }
        HttpDispatcher.getInstance().sendAmdcRequest(set, this.f1067g);
    }

    /* renamed from: a */
    void m659a(String str, IConnStrategy iConnStrategy, ConnEvent connEvent) {
        StrategyCollection strategyCollection;
        if (ALog.isPrintLog(1)) {
            ALog.m713d("awcn.StrategyTable", "[notifyConnEvent]", null, "Host", str, "IConnStrategy", iConnStrategy, "ConnEvent", connEvent);
        }
        String str2 = iConnStrategy.getProtocol().protocol;
        if (ConnType.HTTP3.equals(str2) || ConnType.HTTP3_PLAIN.equals(str2)) {
            C0774a.m495a(connEvent.isSuccess);
            ALog.m715e("awcn.StrategyTable", "enable http3", null, "uniqueId", this.f1062a, "enable", Boolean.valueOf(connEvent.isSuccess));
        }
        if (!connEvent.isSuccess && C0848c.m708b(iConnStrategy.getIp())) {
            this.f1064c.put(str, Long.valueOf(System.currentTimeMillis()));
            ALog.m715e("awcn.StrategyTable", "disable ipv6", null, "uniqueId", this.f1062a, Constants.KEY_HOST, str);
        }
        synchronized (this.f1066f) {
            strategyCollection = this.f1066f.get(str);
        }
        if (strategyCollection != null) {
            strategyCollection.notifyConnEvent(iConnStrategy, connEvent);
        }
    }

    /* renamed from: a */
    boolean m661a(String str, long j2) {
        Long l2 = this.f1064c.get(str);
        if (l2 == null) {
            return false;
        }
        if (l2.longValue() + j2 >= System.currentTimeMillis()) {
            return true;
        }
        this.f1064c.remove(str);
        return false;
    }
}
