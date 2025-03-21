package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.StrategyStatObject;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.C0842l;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.utils.C0846a;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class StrategyInfoHolder implements NetworkStatusHelper.INetworkStatusChangeListener {

    /* renamed from: a */
    Map<String, StrategyTable> f1051a = new LruStrategyMap();

    /* renamed from: b */
    volatile StrategyConfig f1052b = null;

    /* renamed from: c */
    final C0825a f1053c = new C0825a();

    /* renamed from: d */
    private final StrategyTable f1054d = new StrategyTable("Unknown");

    /* renamed from: e */
    private final Set<String> f1055e = new HashSet();

    /* renamed from: f */
    private volatile String f1056f = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    static class LruStrategyMap extends SerialLruCache<String, StrategyTable> {
        public LruStrategyMap() {
            super(3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // anet.channel.strategy.utils.SerialLruCache
        public boolean entryRemoved(Map.Entry<String, StrategyTable> entry) {
            C0846a.m702a(new RunnableC0836f(this, entry));
            return true;
        }
    }

    private StrategyInfoHolder() {
        try {
            m641e();
            m643g();
        } catch (Throwable unused) {
        }
        m642f();
    }

    /* renamed from: a */
    public static StrategyInfoHolder m639a() {
        return new StrategyInfoHolder();
    }

    /* renamed from: e */
    private void m641e() {
        NetworkStatusHelper.addStatusChangeListener(this);
        this.f1056f = m640a(NetworkStatusHelper.getStatus());
    }

    /* renamed from: f */
    private void m642f() {
        Iterator<Map.Entry<String, StrategyTable>> it = this.f1051a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().m658a();
        }
        synchronized (this) {
            if (this.f1052b == null) {
                StrategyConfig strategyConfig = new StrategyConfig();
                strategyConfig.m638b();
                strategyConfig.m635a(this);
                this.f1052b = strategyConfig;
            }
        }
    }

    /* renamed from: g */
    private void m643g() {
        ALog.m716i("awcn.StrategyInfoHolder", RequestParameters.X_OSS_RESTORE, null, new Object[0]);
        String str = this.f1056f;
        if (!AwcnConfig.isAsyncLoadStrategyEnable()) {
            if (!TextUtils.isEmpty(str)) {
                m645a(str, true);
            }
            this.f1052b = (StrategyConfig) C0843m.m692a("StrategyConfig", null);
            if (this.f1052b != null) {
                this.f1052b.m638b();
                this.f1052b.m635a(this);
            }
        }
        C0846a.m702a(new RunnableC0828d(this, str));
    }

    /* renamed from: b */
    void m646b() {
        NetworkStatusHelper.removeStatusChangeListener(this);
    }

    /* renamed from: c */
    void m647c() {
        synchronized (this) {
            for (StrategyTable strategyTable : this.f1051a.values()) {
                if (strategyTable.f1065d) {
                    StrategyStatObject strategyStatObject = new StrategyStatObject(1);
                    strategyStatObject.writeStrategyFileId = strategyTable.f1062a;
                    C0843m.m695a(strategyTable, strategyTable.f1062a, strategyStatObject);
                    strategyTable.f1065d = false;
                }
            }
            C0843m.m695a(this.f1052b.m633a(), "StrategyConfig", null);
        }
    }

    /* renamed from: d */
    StrategyTable m648d() {
        StrategyTable strategyTable = this.f1054d;
        String str = this.f1056f;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f1051a) {
                strategyTable = this.f1051a.get(str);
                if (strategyTable == null) {
                    strategyTable = new StrategyTable(str);
                    this.f1051a.put(str, strategyTable);
                }
            }
        }
        return strategyTable;
    }

    @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
    public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f1056f = m640a(networkStatus);
        String str = this.f1056f;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f1051a) {
            if (!this.f1051a.containsKey(str)) {
                C0846a.m702a(new RunnableC0835e(this, str));
            }
        }
    }

    /* renamed from: a */
    protected void m645a(String str, boolean z) {
        synchronized (this.f1055e) {
            if (this.f1055e.contains(str)) {
                return;
            }
            this.f1055e.add(str);
            StrategyStatObject strategyStatObject = null;
            if (z) {
                strategyStatObject = new StrategyStatObject(0);
                strategyStatObject.readStrategyFileId = str;
            }
            StrategyTable strategyTable = (StrategyTable) C0843m.m692a(str, strategyStatObject);
            if (strategyTable != null) {
                strategyTable.m658a();
                synchronized (this.f1051a) {
                    this.f1051a.put(strategyTable.f1062a, strategyTable);
                }
            }
            synchronized (this.f1055e) {
                this.f1055e.remove(str);
            }
            if (z) {
                strategyStatObject.isSucceed = strategyTable != null ? 1 : 0;
                AppMonitor.getInstance().commitStat(strategyStatObject);
            }
        }
    }

    /* renamed from: a */
    private String m640a(NetworkStatusHelper.NetworkStatus networkStatus) {
        if (networkStatus.isWifi()) {
            String md5ToHex = StringUtils.md5ToHex(NetworkStatusHelper.getWifiBSSID());
            if (TextUtils.isEmpty(md5ToHex)) {
                md5ToHex = "";
            }
            return "WIFI$" + md5ToHex;
        }
        if (!networkStatus.isMobile()) {
            return "";
        }
        return networkStatus.getType() + "$" + NetworkStatusHelper.getApn();
    }

    /* renamed from: a */
    void m644a(C0842l.d dVar) {
        int i2 = dVar.f1137g;
        if (i2 != 0) {
            AmdcRuntimeInfo.updateAmdcLimit(i2, dVar.f1138h);
        }
        m648d().update(dVar);
        this.f1052b.m636a(dVar);
    }
}
