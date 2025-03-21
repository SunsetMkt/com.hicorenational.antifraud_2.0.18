package com.umeng.commonsdk.service;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.utils.UMUtils;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes2.dex */
public class UMGlobalContext {
    private static final String TAG = "UMGlobalContext";
    private String mAppVersion;
    private String mAppkey;
    private Context mApplicationContext;
    private String mChannel;
    private String mProcessName;

    /* renamed from: com.umeng.commonsdk.service.UMGlobalContext$a */
    private static class C3487a {

        /* renamed from: a */
        private static final UMGlobalContext f12678a = new UMGlobalContext();

        private C3487a() {
        }
    }

    public static Context getAppContext(Context context) {
        if (C3487a.f12678a.mApplicationContext == null && context != null) {
            C3487a.f12678a.mApplicationContext = context.getApplicationContext();
        }
        return C3487a.f12678a.mApplicationContext;
    }

    public static UMGlobalContext getInstance(Context context) {
        if (C3487a.f12678a.mApplicationContext == null && context != null) {
            C3487a.f12678a.mApplicationContext = context;
        }
        return C3487a.f12678a;
    }

    public String getAppVersion() {
        if (TextUtils.isEmpty(this.mAppVersion)) {
            this.mAppVersion = UMUtils.getAppVersionName(this.mApplicationContext);
        }
        return this.mAppVersion;
    }

    public String getAppkey() {
        if (TextUtils.isEmpty(this.mAppkey)) {
            this.mAppkey = UMConfigure.sAppkey;
        }
        return this.mAppkey;
    }

    public String getChannel() {
        if (TextUtils.isEmpty(this.mChannel)) {
            this.mChannel = UMConfigure.sChannel;
        }
        return this.mChannel;
    }

    public String getProcessName(Context context) {
        if (TextUtils.isEmpty(this.mProcessName)) {
            if (context != null) {
                Context context2 = C3487a.f12678a.mApplicationContext;
                if (context2 != null) {
                    this.mProcessName = UMFrUtils.getCurrentProcessName(context2);
                } else {
                    this.mProcessName = UMFrUtils.getCurrentProcessName(context);
                }
            } else {
                this.mProcessName = UMFrUtils.getCurrentProcessName(C3487a.f12678a.mApplicationContext);
            }
        }
        return this.mProcessName;
    }

    public boolean isMainProcess(Context context) {
        return UMUtils.isMainProgress(context);
    }

    public String toString() {
        if (C3487a.f12678a.mApplicationContext == null) {
            return "uninitialized.";
        }
        StringBuilder sb = new StringBuilder("[");
        sb.append("appkey:" + this.mAppkey + Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("channel:" + this.mChannel + Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("procName:" + this.mProcessName + "]");
        return sb.toString();
    }

    private UMGlobalContext() {
        this.mProcessName = "";
    }

    public static Context getAppContext() {
        return C3487a.f12678a.mApplicationContext;
    }
}
