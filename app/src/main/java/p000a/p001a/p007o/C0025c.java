package p000a.p001a.p007o;

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
import p000a.p001a.p003k.C0014b;
import p000a.p001a.p004l.C0015a;
import p000a.p001a.p009q.C0029a;

/* compiled from: Taobao */
/* renamed from: a.a.o.c */
/* loaded from: classes.dex */
public class C0025c implements Serializable {

    /* renamed from: a */
    private static final String f72a = "anet.NetworkSdkSetting";

    /* renamed from: c */
    private static Context f74c;
    public static ENV CURRENT_ENV = ENV.ONLINE;

    /* renamed from: b */
    private static AtomicBoolean f73b = new AtomicBoolean(false);

    /* renamed from: d */
    private static HashMap<String, Object> f75d = null;

    /* renamed from: a */
    private static void m149a() {
        try {
            Utils.invokeStaticMethodThrowException("anet.channel.TaobaoNetworkAdapter", "init", new Class[]{Context.class, HashMap.class}, f74c, f75d);
            ALog.m716i(f72a, "init taobao adapter success", null, new Object[0]);
        } catch (Exception e2) {
            ALog.m716i(f72a, "initTaobaoAdapter failed. maybe not taobao app", null, e2);
        }
    }

    public static Context getContext() {
        return f74c;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f73b.compareAndSet(false, true)) {
                ALog.m715e(f72a, "NetworkSdkSetting init", null, new Object[0]);
                f74c = context;
                GlobalAppRuntimeInfo.setInitTime(System.currentTimeMillis());
                GlobalAppRuntimeInfo.setContext(context);
                C0014b.m82d();
                m149a();
                C0029a.m166d();
                if (!AwcnConfig.isTbNextLaunch()) {
                    C0015a.m115a(context);
                }
                SessionCenter.init(context);
            }
        } catch (Throwable th) {
            ALog.m714e(f72a, "Network SDK initial failed!", null, th, new Object[0]);
        }
    }

    public static void setTtid(String str) {
        GlobalAppRuntimeInfo.setTtid(str);
    }

    public static void init(Application application, HashMap<String, Object> hashMap) {
        try {
            GlobalAppRuntimeInfo.setTtid((String) hashMap.get(Constants.KEY_TTID));
            GlobalAppRuntimeInfo.setUtdid((String) hashMap.get("deviceId"));
            String str = (String) hashMap.get(UMModuleRegister.PROCESS);
            if (!TextUtils.isEmpty(str)) {
                GlobalAppRuntimeInfo.setCurrentProcess(str);
            }
            f75d = new HashMap<>(hashMap);
            init(application.getApplicationContext());
            f75d = null;
        } catch (Exception e2) {
            ALog.m714e(f72a, "Network SDK initial failed!", null, e2, new Object[0]);
        }
    }
}
