package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class StrategyConfig implements Serializable {
    public static final String NO_RESULT = "No_Result";
    private SerialLruCache<String, String> a = null;

    /* JADX INFO: renamed from: b */
    private Map<String, String> f1567b = null;

    /* JADX INFO: renamed from: c */
    private transient StrategyInfoHolder f1568c = null;

    StrategyConfig() {
    }

    StrategyConfig a() {
        StrategyConfig strategyConfig = new StrategyConfig();
        synchronized (this) {
            strategyConfig.a = new SerialLruCache<>(this.a, 256);
            strategyConfig.f1567b = new ConcurrentHashMap(this.f1567b);
            strategyConfig.f1568c = this.f1568c;
        }
        return strategyConfig;
    }

    void b() {
        if (this.a == null) {
            this.a = new SerialLruCache<>(256);
        }
        if (this.f1567b == null) {
            this.f1567b = new ConcurrentHashMap();
        }
    }

    String b(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this) {
            str2 = this.f1567b.get(str);
        }
        return str2;
    }

    void a(StrategyInfoHolder strategyInfoHolder) {
        this.f1568c = strategyInfoHolder;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    void a(l.d dVar) {
        if (dVar.f1625b == null) {
            return;
        }
        synchronized (this) {
            TreeMap treeMap = null;
            for (int i2 = 0; i2 < dVar.f1625b.length; i2++) {
                l.b bVar = dVar.f1625b[i2];
                if (bVar.f1621j) {
                    this.a.remove(bVar.a);
                } else if (bVar.f1615d != null) {
                    if (treeMap == null) {
                        treeMap = new TreeMap();
                    }
                    treeMap.put(bVar.a, bVar.f1615d);
                } else {
                    if (!HttpConstant.HTTP.equalsIgnoreCase(bVar.f1614c) && !HttpConstant.HTTPS.equalsIgnoreCase(bVar.f1614c)) {
                        this.a.put(bVar.a, NO_RESULT);
                    } else {
                        this.a.put(bVar.a, bVar.f1614c);
                    }
                    if (!TextUtils.isEmpty(bVar.f1616e)) {
                        this.f1567b.put(bVar.a, bVar.f1616e);
                    } else {
                        this.f1567b.remove(bVar.a);
                    }
                }
            }
            if (treeMap != null) {
                for (Map.Entry entry : treeMap.entrySet()) {
                    String str = (String) entry.getValue();
                    if (this.a.containsKey(str)) {
                        this.a.put((String) entry.getKey(), this.a.get(str));
                    } else {
                        this.a.put((String) entry.getKey(), NO_RESULT);
                    }
                }
            }
        }
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.StrategyConfig", "", null, "SchemeMap", this.a.toString());
            ALog.d("awcn.StrategyConfig", "", null, "UnitMap", this.f1567b.toString());
        }
    }

    String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str) || !anet.channel.strategy.utils.c.c(str)) {
            return null;
        }
        synchronized (this) {
            str2 = this.a.get(str);
            if (str2 == null) {
                this.a.put(str, NO_RESULT);
            }
        }
        if (str2 == null) {
            this.f1568c.d().a(str, false);
            return str2;
        }
        if (NO_RESULT.equals(str2)) {
            return null;
        }
        return str2;
    }
}
