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

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class HttpDispatcher {

    /* renamed from: a */
    private CopyOnWriteArraySet<IDispatchEventListener> f1079a;

    /* renamed from: b */
    private C0830a f1080b;

    /* renamed from: c */
    private volatile boolean f1081c;

    /* renamed from: d */
    private Set<String> f1082d;

    /* renamed from: e */
    private Set<String> f1083e;

    /* renamed from: f */
    private AtomicBoolean f1084f;

    /* compiled from: Taobao */
    public interface IDispatchEventListener {
        void onEvent(DispatchEvent dispatchEvent);
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.dispatch.HttpDispatcher$a */
    private static class C0829a {

        /* renamed from: a */
        static HttpDispatcher f1085a = new HttpDispatcher();

        private C0829a() {
        }
    }

    public static HttpDispatcher getInstance() {
        return C0829a.f1085a;
    }

    public static void setInitHosts(List<String> list) {
        if (list != null) {
            DispatchConstants.initHostArray = (String[]) list.toArray(new String[0]);
        }
    }

    /* renamed from: a */
    void m671a(DispatchEvent dispatchEvent) {
        Iterator<IDispatchEventListener> it = this.f1079a.iterator();
        while (it.hasNext()) {
            try {
                it.next().onEvent(dispatchEvent);
            } catch (Exception unused) {
            }
        }
    }

    public synchronized void addHosts(List<String> list) {
        if (list != null) {
            this.f1083e.addAll(list);
            this.f1082d.clear();
        }
    }

    public void addListener(IDispatchEventListener iDispatchEventListener) {
        this.f1079a.add(iDispatchEventListener);
    }

    public synchronized Set<String> getInitHosts() {
        m670a();
        return new HashSet(this.f1083e);
    }

    public boolean isInitHostsChanged(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean contains = this.f1082d.contains(str);
        if (!contains) {
            this.f1082d.add(str);
        }
        return !contains;
    }

    public void removeListener(IDispatchEventListener iDispatchEventListener) {
        this.f1079a.remove(iDispatchEventListener);
    }

    public void sendAmdcRequest(Set<String> set, int i2) {
        if (!this.f1081c || set == null || set.isEmpty()) {
            ALog.m715e("awcn.HttpDispatcher", "invalid parameter", null, new Object[0]);
            return;
        }
        if (ALog.isPrintLog(2)) {
            ALog.m716i("awcn.HttpDispatcher", "sendAmdcRequest", null, DispatchConstants.HOSTS, set.toString());
        }
        HashMap hashMap = new HashMap();
        hashMap.put(DispatchConstants.HOSTS, set);
        hashMap.put(DispatchConstants.CONFIG_VERSION, String.valueOf(i2));
        this.f1080b.m674a(hashMap);
    }

    public void setEnable(boolean z) {
        this.f1081c = z;
    }

    public void switchENV() {
        this.f1082d.clear();
        this.f1083e.clear();
        this.f1084f.set(false);
    }

    private HttpDispatcher() {
        this.f1079a = new CopyOnWriteArraySet<>();
        this.f1080b = new C0830a();
        this.f1081c = true;
        this.f1082d = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f1083e = new TreeSet();
        this.f1084f = new AtomicBoolean();
        m670a();
    }

    /* renamed from: a */
    private void m670a() {
        if (this.f1084f.get() || GlobalAppRuntimeInfo.getContext() == null || !this.f1084f.compareAndSet(false, true)) {
            return;
        }
        this.f1083e.add(DispatchConstants.getAmdcServerDomain());
        if (GlobalAppRuntimeInfo.isTargetProcess()) {
            this.f1083e.addAll(Arrays.asList(DispatchConstants.initHostArray));
        }
    }
}
