package com.taobao.accs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.internal.ACCSManagerImpl;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3054v;
import java.io.Serializable;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes.dex */
public final class ACCSManager {
    private static final String TAG = "ACCSManager";
    public static Map<String, InterfaceC2965b> mAccsInstances = new ConcurrentHashMap(2);
    public static Context mContext = null;
    public static String mDefaultAppkey = null;
    public static String mDefaultConfigTag = "default";
    public static int mEnv;

    private ACCSManager() {
    }

    @Deprecated
    public static void bindApp(Context context, String str, String str2, String str3, IAppReceiver iAppReceiver) {
        if (TextUtils.isEmpty(mDefaultAppkey)) {
            throw new RuntimeException("old interface!!, please AccsManager.setAppkey() first!");
        }
        C3054v.m9282a();
        getManagerImpl(context).mo8928a(context, mDefaultAppkey, str2, str3, iAppReceiver);
    }

    @Deprecated
    public static void bindService(Context context, String str) {
        getManagerImpl(context).mo8940b(context, str);
    }

    @Deprecated
    public static void bindUser(Context context, String str) {
        bindUser(context, str, false);
    }

    @Deprecated
    public static void clearLoginInfoImpl(Context context) {
        getManagerImpl(context).mo8948e(context);
    }

    protected static InterfaceC2965b createAccsInstance(Context context, String str) {
        return new ACCSManagerImpl(context, str);
    }

    public static void forceDisableService(Context context) {
        getManagerImpl(context).mo8944c(context);
    }

    public static void forceEnableService(Context context) {
        getManagerImpl(context).mo8946d(context);
    }

    @Deprecated
    public static Map<String, Boolean> forceReConnectChannel(Context context) throws Exception {
        return getManagerImpl(context).mo8943c();
    }

    public static InterfaceC2965b getAccsInstance(Context context, String str, String str2) {
        InterfaceC2965b interfaceC2965b;
        if (context == null || TextUtils.isEmpty(str2)) {
            ALog.m9182e(TAG, "getAccsInstance param null", Constants.KEY_CONFIG_TAG, str2);
            return null;
        }
        String str3 = str2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + AccsClientConfig.mEnv;
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.m9180d(TAG, "getAccsInstance", "key", str3);
        }
        synchronized (ACCSManager.class) {
            interfaceC2965b = mAccsInstances.get(str3);
            if (interfaceC2965b == null) {
                try {
                    interfaceC2965b = createAccsInstance(context, str2);
                } catch (Exception e2) {
                    ALog.m9182e(TAG, "createAccsInstance error", e2.getMessage());
                }
                if (interfaceC2965b != null) {
                    mAccsInstances.put(str3, interfaceC2965b);
                }
            }
        }
        return interfaceC2965b;
    }

    @Deprecated
    public static Map<String, Boolean> getChannelState(Context context) throws Exception {
        return getManagerImpl(context).mo8939b();
    }

    @Deprecated
    public static String getDefaultAppkey(Context context) {
        if (TextUtils.isEmpty(mDefaultAppkey)) {
            ALog.m9182e(TAG, "old interface!!, please AccsManager.setAppkey() first!", new Object[0]);
            mDefaultAppkey = C3054v.m9281a(context, Constants.SP_KEY_DEFAULT_APPKEY, null);
            if (TextUtils.isEmpty(mDefaultAppkey)) {
                mDefaultAppkey = "0";
            }
        }
        return mDefaultAppkey;
    }

    public static String getDefaultConfig(Context context) {
        return mDefaultConfigTag;
    }

    private static synchronized InterfaceC2965b getManagerImpl(Context context) {
        InterfaceC2965b accsInstance;
        synchronized (ACCSManager.class) {
            accsInstance = getAccsInstance(context, null, getDefaultConfig(context));
        }
        return accsInstance;
    }

    @Deprecated
    public static String getUserUnit(Context context) {
        return null;
    }

    @Deprecated
    public static boolean isAccsConnected(Context context) {
        return getManagerImpl(context).mo8933a();
    }

    @Deprecated
    public static boolean isChannelError(Context context, int i2) {
        return getManagerImpl(context).mo8934a(i2);
    }

    @Deprecated
    public static boolean isNetworkReachable(Context context) {
        return getManagerImpl(context).mo8942b(context);
    }

    @Deprecated
    public static void registerDataListener(Context context, String str, AccsAbstractDataListener accsAbstractDataListener) {
        GlobalClientInfo.getInstance(context).registerListener(str, accsAbstractDataListener);
    }

    @Deprecated
    public static void registerSerivce(Context context, String str, String str2) {
        GlobalClientInfo.getInstance(context).registerService(str, str2);
    }

    @Deprecated
    public static String sendData(Context context, String str, String str2, byte[] bArr, String str3) {
        return getManagerImpl(context).mo8917a(context, str, str2, bArr, str3);
    }

    @Deprecated
    public static String sendPushResponse(Context context, AccsRequest accsRequest, TaoBaseService.ExtraInfo extraInfo) {
        return getManagerImpl(context).mo8915a(context, accsRequest, extraInfo);
    }

    @Deprecated
    public static String sendRequest(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return getManagerImpl(context).mo8938b(context, str, str2, bArr, str3, str4, url);
    }

    @Deprecated
    public static void setAppkey(Context context, String str, @AccsClientConfig.ENV int i2) {
    }

    @Deprecated
    public static void setDefaultConfig(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ALog.m9183i(TAG, "setDefaultConfig", Constants.KEY_CONFIG_TAG, str);
        mDefaultConfigTag = str;
    }

    @Deprecated
    public static void setLoginInfoImpl(Context context, ILoginInfo iLoginInfo) {
        getManagerImpl(context).mo8922a(context, iLoginInfo);
    }

    @Deprecated
    public static void setMode(Context context, int i2) {
        mEnv = i2;
        getManagerImpl(context).mo8921a(context, i2);
    }

    @Deprecated
    public static void setProxy(Context context, String str, int i2) {
        getManagerImpl(context).mo8924a(context, str, i2);
    }

    @Deprecated
    public static void setServiceListener(Context context, String str, IServiceReceiver iServiceReceiver) {
    }

    @Deprecated
    public static void startInAppConnection(Context context, String str, String str2, String str3, IAppReceiver iAppReceiver) {
        C3054v.m9282a();
        getManagerImpl(context).mo8927a(context, mDefaultAppkey, str3, iAppReceiver);
    }

    @Deprecated
    public static void unRegisterDataListener(Context context, String str) {
        GlobalClientInfo.getInstance(context).unregisterListener(str);
    }

    @Deprecated
    public static void unbindApp(Context context) {
    }

    @Deprecated
    public static void unbindService(Context context, String str) {
        getManagerImpl(context).mo8945c(context, str);
    }

    @Deprecated
    public static void unbindUser(Context context) {
        getManagerImpl(context).mo8920a(context);
    }

    @Deprecated
    public static void unregisterService(Context context, String str) {
        GlobalClientInfo.getInstance(context).unRegisterService(str);
    }

    @Deprecated
    public static void bindUser(Context context, String str, boolean z) {
        if (TextUtils.isEmpty(mDefaultAppkey)) {
            throw new RuntimeException("old interface!!, please AccsManager.setAppkey() first!");
        }
        getManagerImpl(context).mo8929a(context, str, z);
    }

    @Deprecated
    public static String sendData(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return getManagerImpl(context).mo8919a(context, str, str2, bArr, str3, str4, url);
    }

    @Deprecated
    public static String sendRequest(Context context, String str, String str2, byte[] bArr, String str3) {
        return sendRequest(context, str, str2, bArr, str3, null);
    }

    @Deprecated
    public static String sendData(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return getManagerImpl(context).mo8918a(context, str, str2, bArr, str3, str4);
    }

    @Deprecated
    public static String sendRequest(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return getManagerImpl(context).mo8937b(context, str, str2, bArr, str3, str4);
    }

    @Deprecated
    public static void startInAppConnection(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        startInAppConnection(context, mDefaultAppkey, "", str2, iAppReceiver);
    }

    @Deprecated
    public static String sendData(Context context, AccsRequest accsRequest) {
        return getManagerImpl(context).mo8914a(context, accsRequest);
    }

    @Deprecated
    public static String sendRequest(Context context, AccsRequest accsRequest) {
        return getManagerImpl(context).mo8936b(context, accsRequest);
    }

    @Deprecated
    public static void bindApp(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        bindApp(context, mDefaultAppkey, "", str2, iAppReceiver);
    }

    /* compiled from: Taobao */
    public static class AccsRequest implements Serializable {
        public String businessId;
        public byte[] data;
        public String dataId;
        public URL host;
        public boolean isUnitBusiness = false;
        public String serviceId;
        public String tag;
        public String target;
        public String targetServiceName;
        public int timeout;
        public String userId;

        public AccsRequest(String str, String str2, byte[] bArr, String str3, String str4, URL url, String str5) {
            this.userId = str;
            this.serviceId = str2;
            this.data = bArr;
            this.dataId = str3;
            this.target = str4;
            this.host = url;
            this.businessId = str5;
        }

        public void setBusinessId(String str) {
            this.businessId = str;
        }

        public void setHost(URL url) {
            this.host = url;
        }

        public void setIsUnitBusiness(boolean z) {
            this.isUnitBusiness = z;
        }

        public void setTag(String str) {
            this.tag = str;
        }

        public void setTarget(String str) {
            this.target = str;
        }

        public void setTargetServiceName(String str) {
            this.targetServiceName = str;
        }

        public void setTimeOut(int i2) {
            this.timeout = i2;
        }

        public AccsRequest(String str, String str2, byte[] bArr, String str3) {
            this.userId = str;
            this.serviceId = str2;
            this.data = bArr;
            this.dataId = str3;
        }
    }
}
