package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;

/* loaded from: classes.dex */
public class GrsApp {
    private static final String BRAND;
    private static final GrsApp INSTANCE = new GrsApp();
    private static final String TAG = "GrsApp";
    private String appConfigName;

    static {
        String str;
        String name = GrsApp.class.getPackage().getName();
        if ("com.huawei.hms.framework.network.grs".equals(name)) {
            str = "";
        } else {
            String[] split = name.split("\\.");
            Logger.m6801v(TAG, "current brand is: " + split[1]);
            str = split[1];
        }
        BRAND = str;
    }

    private GrsApp() {
    }

    public static GrsApp getInstance() {
        return INSTANCE;
    }

    public String getAppConfigName() {
        return this.appConfigName;
    }

    public String getBrand(String str) {
        if (TextUtils.isEmpty(BRAND)) {
            return "";
        }
        return BRAND + str;
    }

    public String getIssueCountryCode(Context context) {
        return C2357a.m6806a(context, false).getCountryCode();
    }

    public void setAppConfigName(String str) {
        this.appConfigName = str;
    }
}
