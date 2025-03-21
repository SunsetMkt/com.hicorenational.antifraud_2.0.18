package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.AGConnectApp;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.CustomAuthProvider;
import com.huawei.agconnect.CustomCredentialsProvider;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.core.p169a.C2264b;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.agconnect.config.impl.a */
/* loaded from: classes.dex */
public class C2248a extends AGConnectApp {

    /* renamed from: a */
    private static final Map<String, AGConnectApp> f6868a = new HashMap();

    /* renamed from: b */
    private static final Object f6869b = new Object();

    /* renamed from: c */
    private static String f6870c;

    /* renamed from: d */
    private AGConnectServicesConfig f6871d;

    private C2248a(Context context, String str) {
        this.f6871d = AGConnectServicesConfig.fromContext(context, str);
    }

    /* renamed from: a */
    public static AGConnectApp m6408a() {
        return m6411a(f6870c);
    }

    /* renamed from: a */
    public static AGConnectApp m6409a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        f6870c = context.getPackageName();
        return m6410a(context, f6870c);
    }

    /* renamed from: a */
    public static AGConnectApp m6410a(Context context, String str) {
        AGConnectApp aGConnectApp;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("packageName can not be empty");
        }
        synchronized (f6869b) {
            aGConnectApp = f6868a.get(str);
            if (aGConnectApp == null) {
                f6868a.put(str, new C2248a(context, str));
            }
        }
        return aGConnectApp;
    }

    /* renamed from: a */
    public static AGConnectApp m6411a(String str) {
        AGConnectApp aGConnectApp;
        synchronized (f6869b) {
            aGConnectApp = f6868a.get(str);
            if (aGConnectApp == null) {
                throw new IllegalStateException("you should call AGConnectApp.initialize first");
            }
        }
        return aGConnectApp;
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setApiKey(String str) {
        this.f6871d.setParam("/client/api_key", str);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setAppId(String str) {
        this.f6871d.setParam("/client/app_id", str);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setClientId(String str) {
        this.f6871d.setParam("/client/client_id", str);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setClientSecret(String str) {
        this.f6871d.setParam("/client/client_secret", str);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setCpId(String str) {
        this.f6871d.setParam("/client/cp_id", str);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setCustomAuthProvider(CustomAuthProvider customAuthProvider) {
        ((C2264b) AGConnectInstance.getInstance()).m6459a(customAuthProvider);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setCustomCredentialsProvider(CustomCredentialsProvider customCredentialsProvider) {
        ((C2264b) AGConnectInstance.getInstance()).m6460a(customCredentialsProvider);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setParam(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("path can not be empty");
        }
        this.f6871d.setParam(str, str2);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setProductId(String str) {
        this.f6871d.setParam("/client/product_id", str);
    }
}
