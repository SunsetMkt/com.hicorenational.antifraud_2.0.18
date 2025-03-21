package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.AssetsUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, b> f6847b = new ConcurrentHashMap(16);

    /* renamed from: c, reason: collision with root package name */
    private static final Object f6848c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private a f6849a;

    public b(Context context, boolean z) {
        a(context, z);
        f6847b.put(context.getPackageName(), this);
    }

    public static b a(String str) {
        return f6847b.get(str);
    }

    private void a(Context context, boolean z) {
        long currentTimeMillis;
        String[] split;
        StringBuilder sb;
        long currentTimeMillis2 = System.currentTimeMillis();
        String a2 = com.huawei.hms.framework.network.grs.h.c.a("grs_route_config_files_list.txt", context);
        Logger.i("LocalManagerProxy", "Io.getConfigContent timeCost:" + (System.currentTimeMillis() - currentTimeMillis2));
        Logger.i("LocalManagerProxy", "initLocalManager configFileListContent:" + a2);
        if (TextUtils.isEmpty(a2)) {
            Logger.i("LocalManagerProxy", "Get config files list by AssetsManager");
            currentTimeMillis = System.currentTimeMillis();
            split = AssetsUtil.list(context, GrsApp.getInstance().getBrand(""));
            sb = new StringBuilder();
        } else {
            currentTimeMillis = System.currentTimeMillis();
            Logger.i("LocalManagerProxy", "Get config files list use configFileListContent: " + a2);
            split = a2.split("#");
            sb = new StringBuilder();
        }
        sb.append("list timeCost:");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        Logger.i("LocalManagerProxy", sb.toString());
        List<String> arrayList = split == null ? new ArrayList<>() : Arrays.asList(split);
        String appConfigName = GrsApp.getInstance().getAppConfigName();
        Logger.i("LocalManagerProxy", "appConfigName is: " + appConfigName);
        Logger.i("LocalManagerProxy", "contains APP_20_CONFIG_FILE_NAME: " + arrayList.contains("grs_app_global_route_config.json"));
        this.f6849a = new d(false, z);
        if (arrayList.contains("grs_app_global_route_config.json") || !TextUtils.isEmpty(appConfigName)) {
            this.f6849a = new d(context, appConfigName, z);
        }
        if (!this.f6849a.c() && arrayList.contains("grs_sdk_global_route_config.json")) {
            this.f6849a = new c(context, z);
        }
        this.f6849a.a(context, arrayList);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("on initLocalManager finish, check appGrs: ");
        sb2.append(this.f6849a.f6842a == null);
        Logger.i("LocalManagerProxy", sb2.toString());
    }

    public com.huawei.hms.framework.network.grs.local.model.a a() {
        return this.f6849a.a();
    }

    public String a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z) {
        String a2;
        synchronized (f6848c) {
            a2 = this.f6849a.a(context, aVar, grsBaseInfo, str, str2, z);
        }
        return a2;
    }

    public Map<String, String> a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z) {
        Map<String, String> a2;
        synchronized (f6848c) {
            a2 = this.f6849a.a(context, aVar, grsBaseInfo, str, z);
        }
        return a2;
    }

    public Set<String> b() {
        return this.f6849a.b();
    }
}
