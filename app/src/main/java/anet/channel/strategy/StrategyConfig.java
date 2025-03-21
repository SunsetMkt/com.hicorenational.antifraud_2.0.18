package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.C0842l;
import anet.channel.strategy.utils.C0848c;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class StrategyConfig implements Serializable {
    public static final String NO_RESULT = "No_Result";

    /* renamed from: a */
    private SerialLruCache<String, String> f1048a = null;

    /* renamed from: b */
    private Map<String, String> f1049b = null;

    /* renamed from: c */
    private transient StrategyInfoHolder f1050c = null;

    StrategyConfig() {
    }

    /* renamed from: a */
    StrategyConfig m633a() {
        StrategyConfig strategyConfig = new StrategyConfig();
        synchronized (this) {
            strategyConfig.f1048a = new SerialLruCache<>(this.f1048a, 256);
            strategyConfig.f1049b = new ConcurrentHashMap(this.f1049b);
            strategyConfig.f1050c = this.f1050c;
        }
        return strategyConfig;
    }

    /* renamed from: b */
    void m638b() {
        if (this.f1048a == null) {
            this.f1048a = new SerialLruCache<>(256);
        }
        if (this.f1049b == null) {
            this.f1049b = new ConcurrentHashMap();
        }
    }

    /* renamed from: b */
    String m637b(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this) {
            str2 = this.f1049b.get(str);
        }
        return str2;
    }

    /* renamed from: a */
    void m635a(StrategyInfoHolder strategyInfoHolder) {
        this.f1050c = strategyInfoHolder;
    }

    /* renamed from: a */
    void m636a(C0842l.d dVar) {
        if (dVar.f1132b == null) {
            return;
        }
        synchronized (this) {
            TreeMap treeMap = null;
            for (int i2 = 0; i2 < dVar.f1132b.length; i2++) {
                C0842l.b bVar = dVar.f1132b[i2];
                if (bVar.f1126j) {
                    this.f1048a.remove(bVar.f1117a);
                } else if (bVar.f1120d != null) {
                    if (treeMap == null) {
                        treeMap = new TreeMap();
                    }
                    treeMap.put(bVar.f1117a, bVar.f1120d);
                } else {
                    if (!HttpConstant.HTTP.equalsIgnoreCase(bVar.f1119c) && !HttpConstant.HTTPS.equalsIgnoreCase(bVar.f1119c)) {
                        this.f1048a.put(bVar.f1117a, NO_RESULT);
                    } else {
                        this.f1048a.put(bVar.f1117a, bVar.f1119c);
                    }
                    if (!TextUtils.isEmpty(bVar.f1121e)) {
                        this.f1049b.put(bVar.f1117a, bVar.f1121e);
                    } else {
                        this.f1049b.remove(bVar.f1117a);
                    }
                }
            }
            if (treeMap != null) {
                for (Map.Entry entry : treeMap.entrySet()) {
                    String str = (String) entry.getValue();
                    if (this.f1048a.containsKey(str)) {
                        this.f1048a.put(entry.getKey(), this.f1048a.get(str));
                    } else {
                        this.f1048a.put(entry.getKey(), NO_RESULT);
                    }
                }
            }
        }
        if (ALog.isPrintLog(1)) {
            ALog.m713d("awcn.StrategyConfig", "", null, "SchemeMap", this.f1048a.toString());
            ALog.m713d("awcn.StrategyConfig", "", null, "UnitMap", this.f1049b.toString());
        }
    }

    /* renamed from: a */
    String m634a(String str) {
        String str2;
        if (TextUtils.isEmpty(str) || !C0848c.m709c(str)) {
            return null;
        }
        synchronized (this) {
            str2 = this.f1048a.get(str);
            if (str2 == null) {
                this.f1048a.put(str, NO_RESULT);
            }
        }
        if (str2 == null) {
            this.f1050c.m648d().m660a(str, false);
            return str2;
        }
        if (NO_RESULT.equals(str2)) {
            return null;
        }
        return str2;
    }
}
