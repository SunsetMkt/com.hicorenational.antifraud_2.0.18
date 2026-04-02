package b.a.o;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.SessionCenter;
import anet.channel.entity.ENV;
import anet.channel.util.ALog;
import anet.channel.util.Utils;
import com.taobao.accs.common.Constants;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class c implements Serializable {
    private static final String a = "anet.NetworkSdkSetting";

    /* JADX INFO: renamed from: c */
    private static Context f1847c;
    public static ENV CURRENT_ENV = ENV.ONLINE;

    /* JADX INFO: renamed from: b */
    private static AtomicBoolean f1846b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d */
    private static HashMap<String, Object> f1848d = null;

    private static void a() {
        try {
            Utils.invokeStaticMethodThrowException("anet.channel.TaobaoNetworkAdapter", "init", new Class[]{Context.class, HashMap.class}, f1847c, f1848d);
            ALog.i(a, "init taobao adapter success", null, new Object[0]);
        } catch (Exception e2) {
            ALog.i(a, "initTaobaoAdapter failed. maybe not taobao app", null, e2);
        }
    }

    public static Context getContext() {
        return f1847c;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f1846b.compareAndSet(false, true)) {
                ALog.e(a, "NetworkSdkSetting init", null, new Object[0]);
                f1847c = context;
                GlobalAppRuntimeInfo.setInitTime(System.currentTimeMillis());
                GlobalAppRuntimeInfo.setContext(context);
                b.a.k.b.d();
                a();
                b.a.q.a.d();
                if (!AwcnConfig.isTbNextLaunch()) {
                    b.a.l.a.a(context);
                }
                SessionCenter.init(context);
            }
        } catch (Throwable th) {
            ALog.e(a, "Network SDK initial failed!", null, th, new Object[0]);
        }
    }

    public static void setTtid(String str) {
        GlobalAppRuntimeInfo.setTtid(str);
    }

    public static void init(Application application, HashMap<String, Object> map) {
        try {
            GlobalAppRuntimeInfo.setTtid((String) map.get(Constants.KEY_TTID));
            GlobalAppRuntimeInfo.setUtdid((String) map.get("deviceId"));
            String str = (String) map.get(UMModuleRegister.PROCESS);
            if (!TextUtils.isEmpty(str)) {
                GlobalAppRuntimeInfo.setCurrentProcess(str);
            }
            f1848d = new HashMap<>(map);
            init(application.getApplicationContext());
            f1848d = null;
        } catch (Exception e2) {
            ALog.e(a, "Network SDK initial failed!", null, e2, new Object[0]);
        }
    }
}
