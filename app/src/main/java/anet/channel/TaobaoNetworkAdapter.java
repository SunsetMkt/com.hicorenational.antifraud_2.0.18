package anet.channel;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import anet.channel.Config;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.appmonitor.C0746a;
import anet.channel.entity.C0783c;
import anet.channel.entity.ConnType;
import anet.channel.entity.ENV;
import anet.channel.flow.NetworkAnalysis;
import anet.channel.fulltrace.C0785a;
import anet.channel.p017a.C0743a;
import anet.channel.p017a.C0744b;
import anet.channel.p019c.C0754a;
import anet.channel.p020d.C0757a;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.StrategyTemplate;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import anet.channel.util.StringUtils;
import anet.channel.util.Utils;
import com.taobao.accs.common.Constants;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import p000a.p001a.p003k.C0014b;
import p000a.p001a.p014u.C0052a;

/* loaded from: classes.dex */
public class TaobaoNetworkAdapter implements Serializable {
    public static AtomicBoolean isInited = new AtomicBoolean();

    /* renamed from: a */
    private static void m442a(String str, String str2, ConnProtocol connProtocol, boolean z, boolean z2) {
        StrategyTemplate.getInstance().registerConnProtocol(str, connProtocol);
        if (z) {
            if (!z2) {
                SessionCenter.getInstance(new Config.Builder().setAppkey(str2).setEnv(ENV.ONLINE).build()).registerSessionInfo(SessionInfo.create(str, z, false, null, null, null));
            } else {
                SessionCenter.getInstance(new Config.Builder().setAppkey(str2).setEnv(ENV.ONLINE).build()).get(HttpUrl.parse(StringUtils.concatString(HttpConstant.HTTPS, HttpConstant.SCHEME_SPLIT, str)), C0783c.f843a, 0L);
            }
        }
    }

    public static void init(Context context, HashMap<String, Object> hashMap) {
        boolean z;
        if (isInited.compareAndSet(false, true)) {
            if (hashMap != null && AgooConstants.TAOBAO_PACKAGE.equals(hashMap.get(UMModuleRegister.PROCESS))) {
                AwcnConfig.setAccsSessionCreateForbiddenInBg(true);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put("liveng-bfrtc.alibabausercontent.com");
                jSONArray.put("livecb-bfrtc.alibabausercontent.com");
                jSONArray.put("liveca-bfrtc.alibabausercontent.com");
                AwcnConfig.setHttpDnsNotifyWhiteList(jSONArray.toString());
            }
            if (hashMap != null && Constants.CHANNEL_PROCESS_NAME.equals(hashMap.get(UMModuleRegister.PROCESS)) && C0014b.m96i()) {
                ALog.m715e("awcn.TaobaoNetworkAdapter", "channelLocalInstanceEnable", null, new Object[0]);
                C0014b.m101l(false);
            }
            ALog.setLog(new C0757a());
            C0014b.m68a(new C0754a());
            AppMonitor.setInstance(new C0746a());
            NetworkAnalysis.setInstance(new C0744b());
            C0785a.m517a(new C0743a());
            ThreadPoolExecutorFactory.submitPriorityTask(new RunnableC0793j(), ThreadPoolExecutorFactory.Priority.NORMAL);
            if (hashMap != null) {
                try {
                    if (AgooConstants.TAOBAO_PACKAGE.equals(hashMap.get(UMModuleRegister.PROCESS)) && ((Boolean) hashMap.get("isDebuggable")).booleanValue()) {
                        Utils.invokeStaticMethodThrowException("com.taobao.android.request.analysis.RequestRecorder", "init", new Class[]{Context.class}, context);
                    }
                } catch (Exception e2) {
                    ALog.m714e("awcn.TaobaoNetworkAdapter", "RequestRecorder error.", null, e2, new Object[0]);
                }
            }
            if (hashMap != null) {
                try {
                    if (!hashMap.containsKey("isNextLaunch") || PreferenceManager.getDefaultSharedPreferences(context).getBoolean(AwcnConfig.NEXT_LAUNCH_FORBID, false)) {
                        z = false;
                    } else {
                        GlobalAppRuntimeInfo.addBucketInfo("isNextLaunch", C0052a.f158j);
                        z = true;
                    }
                    AwcnConfig.setTbNextLaunch(z);
                } catch (Exception unused) {
                }
            }
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            boolean z2 = defaultSharedPreferences.getBoolean(AwcnConfig.HTTP3_ENABLE, true);
            AwcnConfig.setHttp3OrangeEnable(z2);
            if (z2 && hashMap != null && AgooConstants.TAOBAO_PACKAGE.equals(hashMap.get(UMModuleRegister.PROCESS))) {
                AwcnConfig.setHttp3Enable(true);
                ALog.m715e("awcn.TaobaoNetworkAdapter", "http3 enabled.", null, new Object[0]);
            }
            if (hashMap != null) {
                try {
                    String str = (String) hashMap.get(UMModuleRegister.PROCESS);
                    boolean containsKey = hashMap.containsKey("ngLaunch");
                    if (AgooConstants.TAOBAO_PACKAGE.equals(str)) {
                        if (defaultSharedPreferences.getBoolean(C0014b.f9a, true)) {
                            C0014b.m86e(true);
                            ALog.m715e("awcn.TaobaoNetworkAdapter", "bindservice optimize enabled.", null, new Object[0]);
                        }
                        String str2 = (String) hashMap.get("onlineAppKey");
                        m442a("guide-acs.m.taobao.com", str2, ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, ConnType.PK_ACS), true, containsKey);
                        ConnProtocol valueOf = ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, ConnType.PK_CDN);
                        m442a("gw.alicdn.com", str2, valueOf, false, containsKey);
                        m442a("dorangesource.alicdn.com", str2, valueOf, false, containsKey);
                        m442a("ossgw.alicdn.com", str2, valueOf, false, containsKey);
                    }
                } catch (Exception unused2) {
                }
            }
        }
    }
}
