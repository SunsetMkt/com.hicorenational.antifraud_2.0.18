package anet.channel.strategy.dispatch;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.util.ALog;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class HttpDispatcher {
    private CopyOnWriteArraySet<IDispatchEventListener> a;

    /* JADX INFO: renamed from: b */
    private anet.channel.strategy.dispatch.a f1588b;

    /* JADX INFO: renamed from: c */
    private volatile boolean f1589c;

    /* JADX INFO: renamed from: d */
    private Set<String> f1590d;

    /* JADX INFO: renamed from: e */
    private Set<String> f1591e;

    /* JADX INFO: renamed from: f */
    private AtomicBoolean f1592f;

    /* JADX INFO: compiled from: Taobao */
    public interface IDispatchEventListener {
        void onEvent(DispatchEvent dispatchEvent);
    }

    /* JADX INFO: compiled from: Taobao */
    private static class a {
        static HttpDispatcher a = new HttpDispatcher();

        private a() {
        }
    }

    /* synthetic */ HttpDispatcher(e eVar) {
        this();
    }

    public static HttpDispatcher getInstance() {
        return a.a;
    }

    public static void setInitHosts(List<String> list) {
        if (list != null) {
            DispatchConstants.initHostArray = (String[]) list.toArray(new String[0]);
        }
    }

    void a(DispatchEvent dispatchEvent) {
        Iterator<IDispatchEventListener> it = this.a.iterator();
        while (it.hasNext()) {
            try {
                it.next().onEvent(dispatchEvent);
            } catch (Exception unused) {
            }
        }
    }

    public synchronized void addHosts(List<String> list) {
        if (list != null) {
            this.f1591e.addAll(list);
            this.f1590d.clear();
        }
    }

    public void addListener(IDispatchEventListener iDispatchEventListener) {
        this.a.add(iDispatchEventListener);
    }

    public synchronized Set<String> getInitHosts() {
        a();
        return new HashSet(this.f1591e);
    }

    public boolean isInitHostsChanged(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean zContains = this.f1590d.contains(str);
        if (!zContains) {
            this.f1590d.add(str);
        }
        return !zContains;
    }

    public void removeListener(IDispatchEventListener iDispatchEventListener) {
        this.a.remove(iDispatchEventListener);
    }

    public void sendAmdcRequest(Set<String> set, int i2) {
        if (!this.f1589c || set == null || set.isEmpty()) {
            ALog.e("awcn.HttpDispatcher", "invalid parameter", null, new Object[0]);
            return;
        }
        if (ALog.isPrintLog(2)) {
            ALog.i("awcn.HttpDispatcher", "sendAmdcRequest", null, DispatchConstants.HOSTS, set.toString());
        }
        HashMap map = new HashMap();
        map.put(DispatchConstants.HOSTS, set);
        map.put(DispatchConstants.CONFIG_VERSION, String.valueOf(i2));
        this.f1588b.a(map);
    }

    public void setEnable(boolean z) {
        this.f1589c = z;
    }

    public void switchENV() {
        this.f1590d.clear();
        this.f1591e.clear();
        this.f1592f.set(false);
    }

    private HttpDispatcher() {
        this.a = new CopyOnWriteArraySet<>();
        this.f1588b = new anet.channel.strategy.dispatch.a();
        this.f1589c = true;
        this.f1590d = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f1591e = new TreeSet();
        this.f1592f = new AtomicBoolean();
        a();
    }

    private void a() {
        if (this.f1592f.get() || GlobalAppRuntimeInfo.getContext() == null || !this.f1592f.compareAndSet(false, true)) {
            return;
        }
        this.f1591e.add(DispatchConstants.getAmdcServerDomain());
        if (GlobalAppRuntimeInfo.isTargetProcess()) {
            this.f1591e.addAll(Arrays.asList(DispatchConstants.initHostArray));
        }
    }
}
