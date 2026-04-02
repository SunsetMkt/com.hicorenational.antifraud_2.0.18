package com.taobao.accs.client;

import android.content.Context;
import com.taobao.accs.ChannelService;
import com.taobao.accs.IProcessName;
import com.taobao.accs.client.AccsConfig;
import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.t;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
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
        ALog.d("GlobalConfig", "setAlarmHeartbeatEnable", "enable", Boolean.valueOf(z));
        enableAlarmHeartbeat = z;
    }

    public static void setChannelProcessName(String str) {
        a.f5731d = str;
    }

    public static void setChannelReuse(boolean z, AccsConfig.ACCS_GROUP accs_group) {
        GlobalClientInfo.f5718d = z;
        mGroup = accs_group;
    }

    public static void setControlFrameMaxRetry(int i2) {
        Message.CONTROL_MAX_RETRY_TIMES = i2;
    }

    public static void setCurrProcessNameImpl(IProcessName iProcessName) {
        a.f5732e = iProcessName;
    }

    public static void setEnableForeground(Context context, boolean z) {
        ALog.i("GlobalConfig", "setEnableForeground", "enable", Boolean.valueOf(z));
        t.a(context, ChannelService.SUPPORT_FOREGROUND_VERSION_KEY, z ? 21 : 0);
    }

    public static void setJobHeartbeatEnable(boolean z) {
        ALog.d("GlobalConfig", "setJobHeartBeatEnable", "enable", Boolean.valueOf(z));
        enableJobHeartbeat = z;
    }

    public static void setMainProcessName(String str) {
        a.f5730c = str;
    }
}
