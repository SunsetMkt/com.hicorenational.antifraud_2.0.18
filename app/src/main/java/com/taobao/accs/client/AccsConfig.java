package com.taobao.accs.client;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsException;
import com.taobao.accs.IProcessName;
import com.taobao.accs.utl.ALog;
import com.umeng.analytics.pro.C3336at;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes.dex */
public class AccsConfig {
    private static final String TAG = "AccsConfig";
    public static AccsClientConfig.Builder mBuilder = null;
    private static boolean mInitConfig = false;

    /* compiled from: Taobao */
    public enum ACCS_GROUP {
        TAOBAO,
        ALIYUN,
        OPEN
    }

    /* compiled from: Taobao */
    public enum SECURITY_TYPE {
        SECURITY_TAOBAO,
        SECURITY_OPEN,
        SECURITY_OFF
    }

    public static void build() {
        try {
            AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(ACCSManager.getDefaultConfig(null));
            if (AccsClientConfig.loadedStaticConfig && configByTag != null) {
                ALog.m9186w(TAG, "default config already exists", new Object[0]);
            }
            getBuilder().build();
        } catch (AccsException e2) {
            ALog.m9181e(TAG, "build config error", e2, new Object[0]);
        }
    }

    public static void disableInappKeepAlive() {
        getBuilder().setKeepAlive(false);
    }

    private static AccsClientConfig.Builder getBuilder() {
        if (TextUtils.isEmpty(ACCSManager.mDefaultAppkey)) {
            throw new RuntimeException("old interface!!, please AccsManager.setAppkey() first!");
        }
        if (mBuilder == null) {
            mBuilder = new AccsClientConfig.Builder().setAppKey(ACCSManager.mDefaultAppkey).setTag(ACCSManager.getDefaultConfig(null)).setAutoUnit(true);
        }
        return mBuilder;
    }

    public static void setAccsCenterHosts(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            ALog.m9182e(TAG, "setAccsCenterHost null", new Object[0]);
            return;
        }
        ALog.m9183i(TAG, "setAccsCenterHost", C3336at.f11487a, Integer.valueOf(ACCSManager.mEnv), "releaseHost", str, "prepareHost", str2, "dailyHost", str3);
        int i2 = ACCSManager.mEnv;
        if (i2 == 1) {
            getBuilder().setInappHost(str2);
        } else if (i2 != 2) {
            getBuilder().setInappHost(str);
        } else {
            getBuilder().setInappHost(str3);
        }
    }

    public static void setAccsCenterIps(String[] strArr, String[] strArr2, String[] strArr3) {
    }

    public static void setAuthCode(String str) {
        getBuilder().setAutoCode(str);
        C2978a.f9401b = str;
    }

    public static void setChannelHosts(String str, String str2, String str3) {
        ALog.m9183i(TAG, C3336at.f11487a, Integer.valueOf(ACCSManager.mEnv), "setChannelHosts", "releaseHost", str, "prepareHost", str2, "dailyHost", str3);
        int i2 = ACCSManager.mEnv;
        if (i2 == 1) {
            getBuilder().setChannelHost(str2);
        } else if (i2 != 2) {
            getBuilder().setChannelHost(str);
        } else {
            getBuilder().setChannelHost(str3);
        }
    }

    public static void setChannelIps(String[] strArr, String[] strArr2, String[] strArr3) {
    }

    public static void setChannelProcessName(String str) {
        GlobalConfig.setChannelProcessName(str);
    }

    public static void setChannelReuse(boolean z, ACCS_GROUP accs_group) {
        GlobalConfig.setChannelReuse(z, accs_group);
    }

    public static void setControlFrameMaxRetry(int i2) {
        GlobalConfig.setControlFrameMaxRetry(i2);
    }

    public static void setCurrProcessNameImpl(IProcessName iProcessName) {
        GlobalConfig.setCurrProcessNameImpl(iProcessName);
    }

    public static void setEnableForground(Context context, boolean z) {
        GlobalConfig.setEnableForeground(context, z);
    }

    public static void setMainProcessName(String str) {
        GlobalConfig.setMainProcessName(str);
    }

    public static void setTnetPubkey(int i2, int i3) {
        ALog.m9183i(TAG, "setTnetPubkey", "pubKey", Integer.valueOf(i2), "channelPubKey", Integer.valueOf(i3));
        getBuilder().setInappPubKey(i2).setChannelPubKey(i3);
    }
}
