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

/* compiled from: Taobao */
@Keep
/* loaded from: classes.dex */
public class GlobalClientInfo {
    public static final String AGOO_SERVICE_ID = "agooSend";

    /* renamed from: a */
    public static Context f9386a = null;

    /* renamed from: b */
    public static IAgooAppReceiver f9387b = null;

    /* renamed from: c */
    public static String f9388c = null;

    /* renamed from: d */
    public static boolean f9389d = false;

    /* renamed from: e */
    private static final String f9390e = "com.taobao.accs.client.GlobalClientInfo";

    /* renamed from: f */
    private static volatile GlobalClientInfo f9391f;

    /* renamed from: l */
    private static Map<String, String> f9392l = new ConcurrentHashMap();

    /* renamed from: m */
    private static Map<String, Map<String, String>> f9393m = new ConcurrentHashMap();

    /* renamed from: g */
    private ConcurrentHashMap<String, ILoginInfo> f9394g;

    /* renamed from: h */
    private ConcurrentHashMap<String, IAppReceiver> f9395h;

    /* renamed from: i */
    private ActivityManager f9396i;

    /* renamed from: j */
    private ConnectivityManager f9397j;

    /* renamed from: k */
    private PackageInfo f9398k;

    /* renamed from: n */
    private Map<String, AccsDataListener> f9399n = new ConcurrentHashMap();

    static {
        f9392l.put(AGOO_SERVICE_ID, "org.android.agoo.accs.AgooService");
        f9392l.put(AgooConstants.AGOO_SERVICE_AGOOACK, "org.android.agoo.accs.AgooService");
        f9392l.put("agooTokenReport", "org.android.agoo.accs.AgooService");
    }

    private GlobalClientInfo(Context context) {
        f9386a = getContext();
        if (f9386a == null && context != null) {
            f9386a = context.getApplicationContext();
        }
        ThreadPoolExecutorFactory.execute(new RunnableC2980c(this));
    }

    /* renamed from: a */
    private void m8975a(String str, Map<String, String> map) {
        if (map == null) {
            return;
        }
        if (f9393m.get(str) == null) {
            f9393m.put(str, new ConcurrentHashMap());
        }
        f9393m.get(str).putAll(map);
    }

    public static Context getContext() {
        return f9386a;
    }

    @Keep
    public static GlobalClientInfo getInstance(Context context) {
        if (f9391f == null) {
            synchronized (GlobalClientInfo.class) {
                if (f9391f == null) {
                    f9391f = new GlobalClientInfo(context);
                }
            }
        }
        return f9391f;
    }

    public void clearLoginInfoImpl() {
        this.f9394g = null;
    }

    public ActivityManager getActivityManager() {
        if (this.f9396i == null) {
            this.f9396i = (ActivityManager) f9386a.getSystemService("activity");
        }
        return this.f9396i;
    }

    public Map<String, String> getAllService(String str) {
        if (f9393m.get(str) == null || f9393m.get(str).isEmpty()) {
            return null;
        }
        return f9393m.get(str);
    }

    public Map<String, IAppReceiver> getAppReceiver() {
        return this.f9395h;
    }

    public ConnectivityManager getConnectivityManager() {
        if (this.f9397j == null) {
            this.f9397j = (ConnectivityManager) f9386a.getSystemService("connectivity");
        }
        return this.f9397j;
    }

    public AccsDataListener getListener(String str) {
        return this.f9399n.get(str);
    }

    public String getNick(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.f9394g;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getNick();
    }

    public PackageInfo getPackageInfo() {
        try {
            if (this.f9398k == null) {
                this.f9398k = f9386a.getPackageManager().getPackageInfo(f9386a.getPackageName(), 0);
            }
        } catch (Throwable th) {
            ALog.m9181e("GlobalClientInfo", "getPackageInfo", th, new Object[0]);
        }
        return this.f9398k;
    }

    public String getService(String str) {
        return f9392l.get(str);
    }

    public String getSid(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.f9394g;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getSid();
    }

    public String getUserId(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.f9394g;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getUserId();
    }

    public void registerAllRemoteService(String str, Map<String, String> map) {
        if (f9393m.get(str) == null) {
            f9393m.put(str, new ConcurrentHashMap());
        }
        f9393m.get(str).putAll(map);
    }

    public void registerListener(String str, AccsAbstractDataListener accsAbstractDataListener) {
        registerListener(str, (AccsDataListener) accsAbstractDataListener);
    }

    @Keep
    public void registerRemoteListener(String str, AccsDataListener accsDataListener) {
        this.f9399n.put(str, accsDataListener);
    }

    public void registerRemoteService(String str, String str2) {
        f9392l.put(str, str2);
    }

    public void registerService(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f9392l.put(str, str2);
    }

    public void setAppReceiver(String str, IAppReceiver iAppReceiver) {
        if (iAppReceiver != null) {
            if (iAppReceiver instanceof IAgooAppReceiver) {
                f9387b = (IAgooAppReceiver) iAppReceiver;
                return;
            }
            if (this.f9395h == null) {
                this.f9395h = new ConcurrentHashMap<>(2);
            }
            this.f9395h.put(str, iAppReceiver);
            m8975a(str, iAppReceiver.getAllServices());
        }
    }

    public void setLoginInfoImpl(String str, ILoginInfo iLoginInfo) {
        if (this.f9394g == null) {
            this.f9394g = new ConcurrentHashMap<>(1);
        }
        if (iLoginInfo != null) {
            this.f9394g.put(str, iLoginInfo);
        }
    }

    @Keep
    public void setRemoteAgooAppReceiver(IAgooAppReceiver iAgooAppReceiver) {
        f9387b = iAgooAppReceiver;
    }

    @Keep
    public void setRemoteAppReceiver(String str, IAppReceiver iAppReceiver) {
        if (this.f9395h == null) {
            this.f9395h = new ConcurrentHashMap<>(2);
        }
        this.f9395h.put(str, iAppReceiver);
        m8975a(str, iAppReceiver.getAllServices());
    }

    public void unRegisterService(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f9392l.remove(str);
    }

    public void unregisterListener(String str) {
        this.f9399n.remove(str);
    }

    public void unregisterRemoteListener(String str) {
        this.f9399n.remove(str);
    }

    public void unregisterRemoteService(String str) {
        f9392l.remove(str);
    }

    public String getService(String str, String str2) {
        if (f9393m.get(str) != null) {
            return f9393m.get(str).get(str2);
        }
        return null;
    }

    public void registerListener(String str, AccsDataListener accsDataListener) {
        if (TextUtils.isEmpty(str) || accsDataListener == null) {
            return;
        }
        this.f9399n.put(str, accsDataListener);
    }
}
