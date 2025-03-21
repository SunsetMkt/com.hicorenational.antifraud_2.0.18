package anet.channel.strategy;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.strategy.C0827c;
import anet.channel.strategy.C0842l;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.DispatchEvent;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.strategy.utils.C0846a;
import anet.channel.strategy.utils.C0848c;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import anet.channel.util.StringUtils;
import com.taobao.accs.common.Constants;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.g */
/* loaded from: classes.dex */
class C0837g implements IStrategyInstance, HttpDispatcher.IDispatchEventListener {

    /* renamed from: a */
    boolean f1097a = false;

    /* renamed from: b */
    StrategyInfoHolder f1098b = null;

    /* renamed from: c */
    long f1099c = 0;

    /* renamed from: d */
    CopyOnWriteArraySet<IStrategyListener> f1100d = new CopyOnWriteArraySet<>();

    /* renamed from: e */
    private IStrategyFilter f1101e = new C0838h(this);

    C0837g() {
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public void forceRefreshStrategy(String str) {
        if (m686a() || TextUtils.isEmpty(str)) {
            return;
        }
        ALog.m716i("awcn.StrategyCenter", "force refresh strategy", null, Constants.KEY_HOST, str);
        this.f1098b.m648d().m660a(str, true);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getCNameByHost(String str) {
        if (m686a() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f1098b.m648d().getCnameByHost(str);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getClientIp() {
        return m686a() ? "" : this.f1098b.m648d().f1063b;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public List<IConnStrategy> getConnStrategyListByHost(String str) {
        return getConnStrategyListByHost(str, this.f1101e);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getFormalizeUrl(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (parse == null) {
            ALog.m715e("awcn.StrategyCenter", "url is invalid.", null, "URL", str);
            return null;
        }
        String urlString = parse.urlString();
        try {
            String schemeByHost = getSchemeByHost(parse.host(), parse.scheme());
            if (!schemeByHost.equalsIgnoreCase(parse.scheme())) {
                urlString = StringUtils.concatString(schemeByHost, com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, str.substring(str.indexOf("//")));
            }
            if (ALog.isPrintLog(1)) {
                ALog.m713d("awcn.StrategyCenter", "", null, "raw", StringUtils.simplifyString(str, 128), "ret", StringUtils.simplifyString(urlString, 128));
            }
        } catch (Exception e2) {
            ALog.m714e("awcn.StrategyCenter", "getFormalizeUrl failed", null, e2, "raw", str);
        }
        return urlString;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    @Deprecated
    public String getSchemeByHost(String str) {
        return getSchemeByHost(str, null);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getUnitByHost(String str) {
        if (m686a()) {
            return null;
        }
        return this.f1098b.f1052b.m637b(str);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public synchronized void initialize(Context context) {
        if (this.f1097a || context == null) {
            return;
        }
        try {
            ALog.m716i("awcn.StrategyCenter", "StrategyCenter initialize started.", null, new Object[0]);
            AmdcRuntimeInfo.setContext(context);
            C0843m.m694a(context);
            HttpDispatcher.getInstance().addListener(this);
            this.f1098b = StrategyInfoHolder.m639a();
            this.f1097a = true;
            ALog.m716i("awcn.StrategyCenter", "StrategyCenter initialize finished.", null, new Object[0]);
        } catch (Exception e2) {
            ALog.m714e("awcn.StrategyCenter", "StrategyCenter initialize failed.", null, e2, new Object[0]);
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public void notifyConnEvent(String str, IConnStrategy iConnStrategy, ConnEvent connEvent) {
        if (m686a() || iConnStrategy == null || !(iConnStrategy instanceof IPConnStrategy)) {
            return;
        }
        IPConnStrategy iPConnStrategy = (IPConnStrategy) iConnStrategy;
        if (iPConnStrategy.f1037b == 1) {
            this.f1098b.f1053c.m665a(str, iConnStrategy, connEvent);
        } else if (iPConnStrategy.f1037b == 0) {
            this.f1098b.m648d().m659a(str, iConnStrategy, connEvent);
        }
    }

    @Override // anet.channel.strategy.dispatch.HttpDispatcher.IDispatchEventListener
    public void onEvent(DispatchEvent dispatchEvent) {
        if (dispatchEvent.eventType != 1 || this.f1098b == null) {
            return;
        }
        ALog.m713d("awcn.StrategyCenter", "receive amdc event", null, new Object[0]);
        C0842l.d m690a = C0842l.m690a((JSONObject) dispatchEvent.extraObject);
        if (m690a == null) {
            return;
        }
        this.f1098b.m644a(m690a);
        saveData();
        Iterator<IStrategyListener> it = this.f1100d.iterator();
        while (it.hasNext()) {
            try {
                it.next().onStrategyUpdated(m690a);
            } catch (Exception e2) {
                ALog.m714e("awcn.StrategyCenter", "onStrategyUpdated failed", null, e2, new Object[0]);
            }
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public void registerListener(IStrategyListener iStrategyListener) {
        ALog.m715e("awcn.StrategyCenter", "registerListener", null, "listener", this.f1100d);
        if (iStrategyListener != null) {
            this.f1100d.add(iStrategyListener);
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public synchronized void saveData() {
        ALog.m716i("awcn.StrategyCenter", "saveData", null, new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f1099c > 30000) {
            this.f1099c = currentTimeMillis;
            C0846a.m703a(new RunnableC0839i(this), 500L);
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public synchronized void switchEnv() {
        C0843m.m693a();
        HttpDispatcher.getInstance().switchENV();
        if (this.f1098b != null) {
            this.f1098b.m646b();
            this.f1098b = StrategyInfoHolder.m639a();
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public void unregisterListener(IStrategyListener iStrategyListener) {
        ALog.m715e("awcn.StrategyCenter", "unregisterListener", null, "listener", this.f1100d);
        this.f1100d.remove(iStrategyListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m686a() {
        if (this.f1098b != null) {
            return false;
        }
        ALog.m718w("StrategyCenter not initialized", null, "isInitialized", Boolean.valueOf(this.f1097a));
        return true;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public List<IConnStrategy> getConnStrategyListByHost(String str, IStrategyFilter iStrategyFilter) {
        if (TextUtils.isEmpty(str) || m686a()) {
            return Collections.EMPTY_LIST;
        }
        String cnameByHost = this.f1098b.m648d().getCnameByHost(str);
        if (!TextUtils.isEmpty(cnameByHost)) {
            str = cnameByHost;
        }
        List queryByHost = this.f1098b.m648d().queryByHost(str);
        if (queryByHost.isEmpty()) {
            queryByHost = this.f1098b.f1053c.m663a(str);
        }
        if (queryByHost.isEmpty() || iStrategyFilter == null) {
            ALog.m713d("getConnStrategyListByHost", null, Constants.KEY_HOST, str, "result", queryByHost);
            return queryByHost;
        }
        boolean z = !AwcnConfig.isIpv6Enable() || (AwcnConfig.isIpv6BlackListEnable() && this.f1098b.m648d().m661a(str, AwcnConfig.getIpv6BlackListTtl()));
        ListIterator<IConnStrategy> listIterator = queryByHost.listIterator();
        while (listIterator.hasNext()) {
            IConnStrategy next = listIterator.next();
            if (!iStrategyFilter.accept(next)) {
                listIterator.remove();
            } else if (z && C0848c.m708b(next.getIp())) {
                listIterator.remove();
            }
        }
        if (ALog.isPrintLog(1)) {
            ALog.m713d("getConnStrategyListByHost", null, Constants.KEY_HOST, str, "result", queryByHost);
        }
        return queryByHost;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getSchemeByHost(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (m686a()) {
            return str2;
        }
        String m634a = this.f1098b.f1052b.m634a(str);
        if (m634a != null || TextUtils.isEmpty(str2)) {
            str2 = m634a;
        }
        if (str2 == null && (str2 = C0827c.a.f1076a.m667a(str)) == null) {
            str2 = HttpConstant.HTTP;
        }
        ALog.m713d("awcn.StrategyCenter", "getSchemeByHost", null, Constants.KEY_HOST, str, "scheme", str2);
        return str2;
    }
}
