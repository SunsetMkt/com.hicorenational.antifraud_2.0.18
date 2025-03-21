package com.huawei.hms.framework.network.grs.p174f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.AssetsUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.local.model.C2389a;
import com.huawei.hms.framework.network.grs.p173e.C2361a;
import com.huawei.hms.framework.network.grs.p178h.C2384c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.framework.network.grs.f.b */
/* loaded from: classes.dex */
public class C2365b {

    /* renamed from: b */
    private static final Map<String, C2365b> f7367b = new ConcurrentHashMap(16);

    /* renamed from: c */
    private static final Object f7368c = new Object();

    /* renamed from: a */
    private AbstractC2364a f7369a;

    public C2365b(Context context, boolean z) {
        m6882a(context, z);
        f7367b.put(context.getPackageName(), this);
    }

    /* renamed from: a */
    public static C2365b m6881a(String str) {
        return f7367b.get(str);
    }

    /* renamed from: a */
    private void m6882a(Context context, boolean z) {
        long currentTimeMillis;
        String[] split;
        StringBuilder sb;
        long currentTimeMillis2 = System.currentTimeMillis();
        String m6980a = C2384c.m6980a("grs_route_config_files_list.txt", context);
        Logger.m6799i("LocalManagerProxy", "Io.getConfigContent timeCost:" + (System.currentTimeMillis() - currentTimeMillis2));
        Logger.m6799i("LocalManagerProxy", "initLocalManager configFileListContent:" + m6980a);
        if (TextUtils.isEmpty(m6980a)) {
            Logger.m6799i("LocalManagerProxy", "Get config files list by AssetsManager");
            currentTimeMillis = System.currentTimeMillis();
            split = AssetsUtil.list(context, GrsApp.getInstance().getBrand(""));
            sb = new StringBuilder();
        } else {
            currentTimeMillis = System.currentTimeMillis();
            Logger.m6799i("LocalManagerProxy", "Get config files list use configFileListContent: " + m6980a);
            split = m6980a.split("#");
            sb = new StringBuilder();
        }
        sb.append("list timeCost:");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        Logger.m6799i("LocalManagerProxy", sb.toString());
        List<String> arrayList = split == null ? new ArrayList<>() : Arrays.asList(split);
        String appConfigName = GrsApp.getInstance().getAppConfigName();
        Logger.m6799i("LocalManagerProxy", "appConfigName is: " + appConfigName);
        Logger.m6799i("LocalManagerProxy", "contains APP_20_CONFIG_FILE_NAME: " + arrayList.contains("grs_app_global_route_config.json"));
        this.f7369a = new C2367d(false, z);
        if (arrayList.contains("grs_app_global_route_config.json") || !TextUtils.isEmpty(appConfigName)) {
            this.f7369a = new C2367d(context, appConfigName, z);
        }
        if (!this.f7369a.m6877c() && arrayList.contains("grs_sdk_global_route_config.json")) {
            this.f7369a = new C2366c(context, z);
        }
        this.f7369a.m6872a(context, arrayList);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("on initLocalManager finish, check appGrs: ");
        sb2.append(this.f7369a.f7362a == null);
        Logger.m6799i("LocalManagerProxy", sb2.toString());
    }

    /* renamed from: a */
    public C2389a m6883a() {
        return this.f7369a.m6867a();
    }

    /* renamed from: a */
    public String m6884a(Context context, C2361a c2361a, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z) {
        String m6868a;
        synchronized (f7368c) {
            m6868a = this.f7369a.m6868a(context, c2361a, grsBaseInfo, str, str2, z);
        }
        return m6868a;
    }

    /* renamed from: a */
    public Map<String, String> m6885a(Context context, C2361a c2361a, GrsBaseInfo grsBaseInfo, String str, boolean z) {
        Map<String, String> m6871a;
        synchronized (f7368c) {
            m6871a = this.f7369a.m6871a(context, c2361a, grsBaseInfo, str, z);
        }
        return m6871a;
    }

    /* renamed from: b */
    public Set<String> m6886b() {
        return this.f7369a.m6874b();
    }
}
