package com.taobao.accs.client;

import android.content.Context;
import com.taobao.accs.ChannelService;
import com.taobao.accs.IProcessName;
import com.taobao.accs.client.AccsConfig;
import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3052t;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class GlobalConfig {
    public static AccsConfig.ACCS_GROUP mGroup = AccsConfig.ACCS_GROUP.OPEN;
    public static boolean enableCookie = true;
    private static boolean enableJobHeartbeat = false;
    private static boolean enableAlarmHeartbeat = false;

    public static boolean isAlarmHeartbeatEnable() {
        return enableAlarmHeartbeat;
    }

    public static boolean isJobHeartbeatEnable() {
        return enableJobHeartbeat;
    }

    public static void setAlarmHeartbeatEnable(boolean z) {
        ALog.m9180d("GlobalConfig", "setAlarmHeartbeatEnable", "enable", Boolean.valueOf(z));
        enableAlarmHeartbeat = z;
    }

    public static void setChannelProcessName(String str) {
        C2978a.f9403d = str;
    }

    public static void setChannelReuse(boolean z, AccsConfig.ACCS_GROUP accs_group) {
        GlobalClientInfo.f9389d = z;
        mGroup = accs_group;
    }

    public static void setControlFrameMaxRetry(int i2) {
        Message.CONTROL_MAX_RETRY_TIMES = i2;
    }

    public static void setCurrProcessNameImpl(IProcessName iProcessName) {
        C2978a.f9404e = iProcessName;
    }

    public static void setEnableForeground(Context context, boolean z) {
        ALog.m9183i("GlobalConfig", "setEnableForeground", "enable", Boolean.valueOf(z));
        C3052t.m9275a(context, ChannelService.SUPPORT_FOREGROUND_VERSION_KEY, z ? 21 : 0);
    }

    public static void setJobHeartbeatEnable(boolean z) {
        ALog.m9180d("GlobalConfig", "setJobHeartBeatEnable", "enable", Boolean.valueOf(z));
        enableJobHeartbeat = z;
    }

    public static void setMainProcessName(String str) {
        C2978a.f9402c = str;
    }
}
