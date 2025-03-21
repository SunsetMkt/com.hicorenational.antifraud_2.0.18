package com.taobao.accs;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.SessionCenter;
import anet.channel.entity.ENV;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3054v;
import com.umeng.analytics.pro.C3336at;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ACCSClient {
    private static String TAG = "ACCSClient";
    public static Map<String, ACCSClient> mACCSClients = new ConcurrentHashMap(2);
    private static Context mContext;
    private String OTAG = TAG;
    protected InterfaceC2965b mAccsManager;
    private AccsClientConfig mConfig;

    public ACCSClient(AccsClientConfig accsClientConfig) {
        this.mConfig = accsClientConfig;
        this.OTAG += accsClientConfig.getTag();
        if (mContext == null) {
            mContext = GlobalClientInfo.f9386a;
        }
        this.mAccsManager = ACCSManager.getAccsInstance(mContext, accsClientConfig.getAppKey(), accsClientConfig.getTag());
    }

    public static ACCSClient getAccsClient() throws AccsException {
        return getAccsClient(null);
    }

    public static synchronized String init(Context context, String str) throws AccsException {
        String init;
        synchronized (ACCSClient.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
                    if (!AccsClientConfig.loadedStaticConfig) {
                        configByTag = new AccsClientConfig.Builder().setAppKey(str).build();
                        ALog.m9183i(TAG, "init", "create config, appkey as tag");
                    }
                    init = init(context, configByTag);
                }
            }
            throw new AccsException("params error");
        }
        return init;
    }

    public static synchronized void setEnvironment(Context context, @AccsClientConfig.ENV int i2) {
        synchronized (ACCSClient.class) {
            if (i2 < 0 || i2 > 2) {
                try {
                    ALog.m9182e(TAG, "env error", C3336at.f11487a, Integer.valueOf(i2));
                    i2 = 0;
                } finally {
                    try {
                    } finally {
                    }
                }
            }
            int i3 = AccsClientConfig.mEnv;
            AccsClientConfig.mEnv = i2;
            if (i3 != i2 && C3054v.m9289e(context)) {
                ALog.m9183i(TAG, "setEnvironment", "preEnv", Integer.valueOf(i3), "toEnv", Integer.valueOf(i2));
                C3054v.m9287c(context);
                C3054v.m9290f(context);
                C3054v.m9288d(context);
                if (i2 == 2) {
                    SessionCenter.switchEnvironment(ENV.TEST);
                } else if (i2 == 1) {
                    SessionCenter.switchEnvironment(ENV.PREPARE);
                }
                Iterator<Map.Entry<String, ACCSClient>> it = mACCSClients.entrySet().iterator();
                while (it.hasNext()) {
                    try {
                        getAccsClient(it.next().getKey());
                    } catch (AccsException e2) {
                        ALog.m9181e(TAG, "setEnvironment update client", e2, new Object[0]);
                    }
                }
            }
        }
    }

    private void updateConfig(AccsClientConfig accsClientConfig) {
        this.mConfig = accsClientConfig;
        this.mAccsManager = ACCSManager.getAccsInstance(mContext, accsClientConfig.getAppKey(), accsClientConfig.getTag());
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b != null) {
            interfaceC2965b.mo8930a(accsClientConfig);
        }
    }

    public void bindApp(String str, IAppReceiver iAppReceiver) {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b == null) {
            ALog.m9182e(this.OTAG, "bindApp mAccsManager null", new Object[0]);
        } else {
            interfaceC2965b.mo8928a(mContext, this.mConfig.getAppKey(), this.mConfig.getAppSecret(), str, iAppReceiver);
        }
    }

    public void bindService(String str) {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b == null) {
            ALog.m9182e(this.OTAG, "bindService mAccsManager null", new Object[0]);
        } else {
            interfaceC2965b.mo8940b(mContext, str);
        }
    }

    public void bindUser(String str) {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b == null) {
            ALog.m9182e(this.OTAG, "bindUser mAccsManager null", new Object[0]);
        } else {
            interfaceC2965b.mo8923a(mContext, str);
        }
    }

    public boolean cancel(String str) {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b != null) {
            return interfaceC2965b.mo8935a(str);
        }
        ALog.m9182e(this.OTAG, "cancel mAccsManager null", new Object[0]);
        return false;
    }

    public void clearLoginInfo() {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b == null) {
            ALog.m9182e(this.OTAG, "clearLoginInfo mAccsManager null", new Object[0]);
        } else {
            interfaceC2965b.mo8948e(mContext);
        }
    }

    public void forceDisableService() {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b == null) {
            ALog.m9182e(this.OTAG, "forceDisableService mAccsManager null", new Object[0]);
        } else {
            interfaceC2965b.mo8944c(mContext);
        }
    }

    public void forceEnableService() {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b == null) {
            ALog.m9182e(this.OTAG, "forceEnableService mAccsManager null", new Object[0]);
        } else {
            interfaceC2965b.mo8946d(mContext);
        }
    }

    public Map<String, Boolean> forceReConnectChannel() throws Exception {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b != null) {
            return interfaceC2965b.mo8943c();
        }
        ALog.m9182e(this.OTAG, "forceReConnectChannel mAccsManager null", new Object[0]);
        return null;
    }

    public Map<String, Boolean> getChannelState() throws Exception {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b != null) {
            return interfaceC2965b.mo8939b();
        }
        ALog.m9182e(this.OTAG, "getChannelState mAccsManager null", new Object[0]);
        return null;
    }

    @Deprecated
    public String getUserUnit() {
        return null;
    }

    public boolean isAccsConnected() {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        return interfaceC2965b != null && interfaceC2965b.mo8933a();
    }

    public boolean isChannelError(int i2) {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b != null) {
            return interfaceC2965b.mo8934a(i2);
        }
        ALog.m9182e(this.OTAG, "isChannelError mAccsManager null", new Object[0]);
        return true;
    }

    public boolean isNetworkReachable() {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b != null) {
            return interfaceC2965b.mo8942b(mContext);
        }
        ALog.m9182e(this.OTAG, "isNetworkReachable mAccsManager null", new Object[0]);
        return false;
    }

    public void registerConnectStateListener(AccsConnectStateListener accsConnectStateListener) {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b == null) {
            ALog.m9182e(this.OTAG, "registerConnectStateListener mAccsManager null", new Object[0]);
        } else {
            interfaceC2965b.mo8931a(accsConnectStateListener);
        }
    }

    public void registerDataListener(String str, AccsAbstractDataListener accsAbstractDataListener) {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b == null) {
            ALog.m9182e(this.OTAG, "registerDataListener mAccsManager null", new Object[0]);
        } else {
            interfaceC2965b.mo8925a(mContext, str, accsAbstractDataListener);
        }
    }

    public void registerSerivce(String str, String str2) {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b == null) {
            ALog.m9182e(this.OTAG, "registerSerivce mAccsManager null", new Object[0]);
        } else {
            interfaceC2965b.mo8926a(mContext, str, str2);
        }
    }

    public void sendBusinessAck(String str, String str2, String str3, short s, String str4, Map<Integer, String> map) {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b == null) {
            ALog.m9182e(this.OTAG, "sendBusinessAck mAccsManager null", new Object[0]);
        } else {
            interfaceC2965b.mo8932a(str, str2, str3, s, str4, map);
        }
    }

    public String sendData(ACCSManager.AccsRequest accsRequest) {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b != null) {
            return interfaceC2965b.mo8914a(mContext, accsRequest);
        }
        ALog.m9182e(this.OTAG, "sendData mAccsManager null", new Object[0]);
        return null;
    }

    public String sendPushResponse(ACCSManager.AccsRequest accsRequest, TaoBaseService.ExtraInfo extraInfo) {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b != null) {
            return interfaceC2965b.mo8915a(mContext, accsRequest, extraInfo);
        }
        ALog.m9182e(this.OTAG, "sendPushResponse mAccsManager null", new Object[0]);
        return null;
    }

    public String sendRequest(ACCSManager.AccsRequest accsRequest) {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b != null) {
            return interfaceC2965b.mo8936b(mContext, accsRequest);
        }
        ALog.m9182e(this.OTAG, "sendRequest mAccsManager null", new Object[0]);
        return null;
    }

    public void setLoginInfo(ILoginInfo iLoginInfo) {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b == null) {
            ALog.m9182e(this.OTAG, "setLoginInfo mAccsManager null", new Object[0]);
        } else {
            interfaceC2965b.mo8922a(mContext, iLoginInfo);
        }
    }

    public void startInAppConnection(String str, IAppReceiver iAppReceiver) {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b == null) {
            ALog.m9182e(this.OTAG, "startInAppConnection mAccsManager null", new Object[0]);
            return;
        }
        Context context = mContext;
        String appKey = this.mConfig.getAppKey();
        this.mConfig.getAppSecret();
        interfaceC2965b.mo8927a(context, appKey, str, iAppReceiver);
    }

    public void unRegisterConnectStateListener(AccsConnectStateListener accsConnectStateListener) {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b == null) {
            ALog.m9182e(this.OTAG, "unRegisterConnectStateListener mAccsManager null", new Object[0]);
        } else {
            interfaceC2965b.mo8941b(accsConnectStateListener);
        }
    }

    public void unRegisterDataListener(String str) {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b == null) {
            ALog.m9182e(this.OTAG, "unRegisterDataListener mAccsManager null", new Object[0]);
        } else {
            interfaceC2965b.mo8949e(mContext, str);
        }
    }

    public void unRegisterSerivce(String str) {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b == null) {
            ALog.m9182e(this.OTAG, "unRegisterSerivce mAccsManager null", new Object[0]);
        } else {
            interfaceC2965b.mo8947d(mContext, str);
        }
    }

    public void unbindService(String str) {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b == null) {
            ALog.m9182e(this.OTAG, "unbindService mAccsManager null", new Object[0]);
        } else {
            interfaceC2965b.mo8945c(mContext, str);
        }
    }

    public void unbindUser() {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b == null) {
            ALog.m9182e(this.OTAG, "unbindUser mAccsManager null", new Object[0]);
        } else {
            interfaceC2965b.mo8920a(mContext);
        }
    }

    public static synchronized ACCSClient getAccsClient(String str) throws AccsException {
        synchronized (ACCSClient.class) {
            if (TextUtils.isEmpty(str)) {
                str = AccsClientConfig.DEFAULT_CONFIGTAG;
                ALog.m9186w(TAG, "getAccsClient", "configTag is null, use default!");
            }
            ALog.m9183i(TAG, "getAccsClient", Constants.KEY_CONFIG_TAG, str);
            AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
            if (configByTag == null) {
                ALog.m9182e(TAG, "getAccsClient", "configTag not exist, please init first!!");
                throw new AccsException("configTag not exist");
            }
            ACCSClient aCCSClient = mACCSClients.get(str);
            if (aCCSClient == null) {
                ALog.m9180d(TAG, "getAccsClient create client", new Object[0]);
                ACCSClient aCCSClient2 = new ACCSClient(configByTag);
                mACCSClients.put(str, aCCSClient2);
                aCCSClient2.updateConfig(configByTag);
                return aCCSClient2;
            }
            if (configByTag.equals(aCCSClient.mConfig)) {
                ALog.m9183i(TAG, "getAccsClient exists", new Object[0]);
            } else {
                ALog.m9183i(TAG, "getAccsClient update config", "old config", aCCSClient.mConfig.getTag(), "new config", configByTag.getTag());
                aCCSClient.updateConfig(configByTag);
            }
            return aCCSClient;
        }
    }

    public void bindUser(String str, boolean z) {
        InterfaceC2965b interfaceC2965b = this.mAccsManager;
        if (interfaceC2965b == null) {
            ALog.m9182e(this.OTAG, "bindUser mAccsManager null", new Object[0]);
        } else {
            interfaceC2965b.mo8929a(mContext, str, z);
        }
    }

    public static synchronized String init(Context context, AccsClientConfig accsClientConfig) throws AccsException {
        String tag;
        synchronized (ACCSClient.class) {
            if (context != null && accsClientConfig != null) {
                mContext = context.getApplicationContext();
                GlobalClientInfo.f9386a = context.getApplicationContext();
                ALog.m9180d(TAG, "init", "config", accsClientConfig);
                tag = accsClientConfig.getTag();
            } else {
                throw new AccsException("init AccsClient params error");
            }
        }
        return tag;
    }
}
