package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.strategy.utils.C0846a;
import anet.channel.strategy.utils.C0848c;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.a */
/* loaded from: classes.dex */
class C0825a {

    /* renamed from: a */
    final ConcurrentHashMap<String, List<IPConnStrategy>> f1069a = new ConcurrentHashMap<>();

    /* renamed from: b */
    final HashMap<String, Object> f1070b = new HashMap<>();

    C0825a() {
    }

    /* renamed from: a */
    List m663a(String str) {
        Object obj;
        if (TextUtils.isEmpty(str) || !C0848c.m709c(str) || DispatchConstants.getAmdcServerDomain().equalsIgnoreCase(str)) {
            return Collections.EMPTY_LIST;
        }
        if (ALog.isPrintLog(1)) {
            ALog.m713d("awcn.LocalDnsStrategyTable", "try resolve ip with local dns", null, Constants.KEY_HOST, str);
        }
        List list = Collections.EMPTY_LIST;
        if (!this.f1069a.containsKey(str)) {
            synchronized (this.f1070b) {
                if (this.f1070b.containsKey(str)) {
                    obj = this.f1070b.get(str);
                } else {
                    obj = new Object();
                    this.f1070b.put(str, obj);
                    m662a(str, obj);
                }
            }
            if (obj != null) {
                try {
                    synchronized (obj) {
                        obj.wait(500L);
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
        List<IPConnStrategy> list2 = this.f1069a.get(str);
        if (list2 != null && list2 != Collections.EMPTY_LIST) {
            list = new ArrayList(list2);
        }
        ALog.m716i("awcn.LocalDnsStrategyTable", "get local strategy", null, "strategyList", list2);
        return list;
    }

    /* renamed from: a */
    void m664a(String str, ConnProtocol connProtocol) {
        List<IPConnStrategy> list = this.f1069a.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<IPConnStrategy> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getProtocol().equals(connProtocol)) {
                return;
            }
        }
        list.add(IPConnStrategy.m631a(list.get(0).getIp(), !m666a(connProtocol) ? 80 : Constants.PORT, connProtocol, 0, 0, 1, 45000));
        ALog.m716i("awcn.LocalDnsStrategyTable", "setProtocolForHost", null, "strategyList", list);
    }

    /* renamed from: a */
    void m665a(String str, IConnStrategy iConnStrategy, ConnEvent connEvent) {
        List<IPConnStrategy> list;
        if (connEvent.isSuccess || TextUtils.isEmpty(str) || connEvent.isAccs || (list = this.f1069a.get(str)) == null || list == Collections.EMPTY_LIST) {
            return;
        }
        Iterator<IPConnStrategy> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == iConnStrategy) {
                it.remove();
            }
        }
        if (list.isEmpty()) {
            this.f1069a.put(str, Collections.EMPTY_LIST);
        }
    }

    /* renamed from: a */
    private void m662a(String str, Object obj) {
        C0846a.m702a(new RunnableC0826b(this, str, obj));
    }

    /* renamed from: a */
    boolean m666a(ConnProtocol connProtocol) {
        return connProtocol.protocol.equalsIgnoreCase(HttpConstant.HTTPS) || connProtocol.protocol.equalsIgnoreCase(ConnType.H2S) || !TextUtils.isEmpty(connProtocol.publicKey);
    }
}
