package com.taobao.accs.client;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.taobao.accs.IAgooAppReceiver;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
@Keep
public class GlobalClientInfo {
    public static final String AGOO_SERVICE_ID = "agooSend";
    public static Context a = null;

    /* JADX INFO: renamed from: b */
    public static IAgooAppReceiver f5716b = null;

    /* JADX INFO: renamed from: c */
    public static String f5717c = null;

    /* JADX INFO: renamed from: d */
    public static boolean f5718d = false;

    /* JADX INFO: renamed from: e */
    private static final String f5719e = "com.taobao.accs.client.GlobalClientInfo";

    /* JADX INFO: renamed from: f */
    private static volatile GlobalClientInfo f5720f;

    /* JADX INFO: renamed from: l */
    private static Map<String, String> f5721l = new ConcurrentHashMap();

    /* JADX INFO: renamed from: m */
    private static Map<String, Map<String, String>> f5722m = new ConcurrentHashMap();

    /* JADX INFO: renamed from: g */
    private ConcurrentHashMap<String, ILoginInfo> f5723g;

    /* JADX INFO: renamed from: h */
    private ConcurrentHashMap<String, IAppReceiver> f5724h;

    /* JADX INFO: renamed from: i */
    private ActivityManager f5725i;

    /* JADX INFO: renamed from: j */
    private ConnectivityManager f5726j;

    /* JADX INFO: renamed from: k */
    private PackageInfo f5727k;

    /* JADX INFO: renamed from: n */
    private Map<String, AccsDataListener> f5728n = new ConcurrentHashMap();

    static {
        f5721l.put(AGOO_SERVICE_ID, "org.android.agoo.accs.AgooService");
        f5721l.put(AgooConstants.AGOO_SERVICE_AGOOACK, "org.android.agoo.accs.AgooService");
        f5721l.put("agooTokenReport", "org.android.agoo.accs.AgooService");
    }

    private GlobalClientInfo(Context context) {
        a = getContext();
        if (a == null && context != null) {
            a = context.getApplicationContext();
        }
        ThreadPoolExecutorFactory.execute(new c(this));
    }

    private void a(String str, Map<String, String> map) {
        if (map == null) {
            return;
        }
        if (f5722m.get(str) == null) {
            f5722m.put(str, new ConcurrentHashMap());
        }
        f5722m.get(str).putAll(map);
    }

    public static Context getContext() {
        return a;
    }

    @Keep
    public static GlobalClientInfo getInstance(Context context) {
        if (f5720f == null) {
            synchronized (GlobalClientInfo.class) {
                if (f5720f == null) {
                    f5720f = new GlobalClientInfo(context);
                }
            }
        }
        return f5720f;
    }

    public void clearLoginInfoImpl() {
        this.f5723g = null;
    }

    public ActivityManager getActivityManager() {
        if (this.f5725i == null) {
            this.f5725i = (ActivityManager) a.getSystemService("activity");
        }
        return this.f5725i;
    }

    public Map<String, String> getAllService(String str) {
        if (f5722m.get(str) == null || f5722m.get(str).isEmpty()) {
            return null;
        }
        return f5722m.get(str);
    }

    public Map<String, IAppReceiver> getAppReceiver() {
        return this.f5724h;
    }

    public ConnectivityManager getConnectivityManager() {
        if (this.f5726j == null) {
            this.f5726j = (ConnectivityManager) a.getSystemService("connectivity");
        }
        return this.f5726j;
    }

    public AccsDataListener getListener(String str) {
        return this.f5728n.get(str);
    }

    public String getNick(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.f5723g;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getNick();
    }

    public PackageInfo getPackageInfo() {
        try {
            if (this.f5727k == null) {
                this.f5727k = a.getPackageManager().getPackageInfo(a.getPackageName(), 0);
            }
        } catch (Throwable th) {
            ALog.e("GlobalClientInfo", "getPackageInfo", th, new Object[0]);
        }
        return this.f5727k;
    }

    public String getService(String str) {
        return f5721l.get(str);
    }

    public String getSid(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.f5723g;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getSid();
    }

    public String getUserId(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.f5723g;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getUserId();
    }

    public void registerAllRemoteService(String str, Map<String, String> map) {
        if (f5722m.get(str) == null) {
            f5722m.put(str, new ConcurrentHashMap());
        }
        f5722m.get(str).putAll(map);
    }

    public void registerListener(String str, AccsAbstractDataListener accsAbstractDataListener) {
        registerListener(str, (AccsDataListener) accsAbstractDataListener);
    }

    @Keep
    public void registerRemoteListener(String str, AccsDataListener accsDataListener) {
        this.f5728n.put(str, accsDataListener);
    }

    public void registerRemoteService(String str, String str2) {
        f5721l.put(str, str2);
    }

    public void registerService(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f5721l.put(str, str2);
    }

    public void setAppReceiver(String str, IAppReceiver iAppReceiver) {
        if (iAppReceiver != null) {
            if (iAppReceiver instanceof IAgooAppReceiver) {
                f5716b = (IAgooAppReceiver) iAppReceiver;
                return;
            }
            if (this.f5724h == null) {
                this.f5724h = new ConcurrentHashMap<>(2);
            }
            this.f5724h.put(str, iAppReceiver);
            a(str, iAppReceiver.getAllServices());
        }
    }

    public void setLoginInfoImpl(String str, ILoginInfo iLoginInfo) {
        if (this.f5723g == null) {
            this.f5723g = new ConcurrentHashMap<>(1);
        }
        if (iLoginInfo != null) {
            this.f5723g.put(str, iLoginInfo);
        }
    }

    @Keep
    public void setRemoteAgooAppReceiver(IAgooAppReceiver iAgooAppReceiver) {
        f5716b = iAgooAppReceiver;
    }

    @Keep
    public void setRemoteAppReceiver(String str, IAppReceiver iAppReceiver) {
        if (this.f5724h == null) {
            this.f5724h = new ConcurrentHashMap<>(2);
        }
        this.f5724h.put(str, iAppReceiver);
        a(str, iAppReceiver.getAllServices());
    }

    public void unRegisterService(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f5721l.remove(str);
    }

    public void unregisterListener(String str) {
        this.f5728n.remove(str);
    }

    public void unregisterRemoteListener(String str) {
        this.f5728n.remove(str);
    }

    public void unregisterRemoteService(String str) {
        f5721l.remove(str);
    }

    public String getService(String str, String str2) {
        if (f5722m.get(str) != null) {
            return f5722m.get(str).get(str2);
        }
        return null;
    }

    public void registerListener(String str, AccsDataListener accsDataListener) {
        if (TextUtils.isEmpty(str) || accsDataListener == null) {
            return;
        }
        this.f5728n.put(str, accsDataListener);
    }
}
