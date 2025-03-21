package com.huawei.agconnect;

import android.content.Context;
import com.huawei.agconnect.config.impl.C2248a;

@Deprecated
/* loaded from: classes.dex */
public abstract class AGConnectApp {
    public static AGConnectApp getInstance() {
        return C2248a.m6408a();
    }

    private static AGConnectApp getInstance(String str) {
        return C2248a.m6411a(str);
    }

    public static AGConnectApp initialize(Context context) {
        return C2248a.m6409a(context);
    }

    private static AGConnectApp initialize(Context context, String str) {
        return C2248a.m6410a(context, str);
    }

    public abstract void setApiKey(String str);

    public abstract void setAppId(String str);

    public abstract void setClientId(String str);

    public abstract void setClientSecret(String str);

    public abstract void setCpId(String str);

    public abstract void setCustomAuthProvider(CustomAuthProvider customAuthProvider);

    public abstract void setCustomCredentialsProvider(CustomCredentialsProvider customCredentialsProvider);

    public abstract void setParam(String str, String str2);

    public abstract void setProductId(String str);
}
