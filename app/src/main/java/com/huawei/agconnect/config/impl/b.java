package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.ConfigReader;
import com.huawei.agconnect.core.Service;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements AGConnectOptions {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f4305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AGCRoutePolicy f4307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConfigReader f4308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e f4309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<String, String> f4310g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<Service> f4311h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, String> f4312i = new HashMap();

    public b(Context context, String str, AGCRoutePolicy aGCRoutePolicy, InputStream inputStream, Map<String, String> map, List<Service> list, String str2) {
        this.f4305b = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        str = str == null ? this.f4305b.getPackageName() : str;
        this.f4306c = str;
        if (inputStream != null) {
            this.f4308e = new i(inputStream, str);
            Utils.closeQuietly(inputStream);
        } else {
            this.f4308e = new m(this.f4305b, str);
        }
        this.f4309f = new e(this.f4308e);
        if (aGCRoutePolicy != AGCRoutePolicy.UNKNOWN && "1.0".equals(this.f4308e.getString("/configuration_version", null))) {
            throw new RuntimeException("The file version does not match,please download the latest agconnect-services.json from the AGC website.");
        }
        this.f4307d = (aGCRoutePolicy == null || aGCRoutePolicy == AGCRoutePolicy.UNKNOWN) ? Utils.getRoutePolicyFromJson(this.f4308e.getString("/region", null), this.f4308e.getString("/agcgw/url", null)) : aGCRoutePolicy;
        this.f4310g = Utils.fixKeyPathMap(map);
        this.f4311h = list;
        this.a = str2 == null ? b() : str2;
    }

    private String a(String str) {
        Map<String, JsonProcessingFactory.JsonProcessor> processors = JsonProcessingFactory.getProcessors();
        if (!processors.containsKey(str)) {
            return null;
        }
        if (this.f4312i.containsKey(str)) {
            return this.f4312i.get(str);
        }
        JsonProcessingFactory.JsonProcessor jsonProcessor = processors.get(str);
        if (jsonProcessor == null) {
            return null;
        }
        String strProcessOption = jsonProcessor.processOption(this);
        this.f4312i.put(str, strProcessOption);
        return strProcessOption;
    }

    private String b() {
        return String.valueOf(("{packageName='" + this.f4306c + "', routePolicy=" + this.f4307d + ", reader=" + this.f4308e.toString().hashCode() + ", customConfigMap=" + new JSONObject(this.f4310g).toString().hashCode() + '}').hashCode());
    }

    public List<Service> a() {
        return this.f4311h;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public boolean getBoolean(String str, boolean z) {
        return Boolean.parseBoolean(getString(str, String.valueOf(z)));
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public Context getContext() {
        return this.f4305b;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getIdentifier() {
        return this.a;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public int getInt(String str) {
        return getInt(str, 0);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public int getInt(String str, int i2) {
        try {
            return Integer.parseInt(getString(str, String.valueOf(i2)));
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getPackageName() {
        return this.f4306c;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public AGCRoutePolicy getRoutePolicy() {
        AGCRoutePolicy aGCRoutePolicy = this.f4307d;
        return aGCRoutePolicy == null ? AGCRoutePolicy.UNKNOWN : aGCRoutePolicy;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str) {
        return getString(str, null);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str, String str2) {
        if (str == null) {
            return str2;
        }
        String strFixPath = Utils.fixPath(str);
        String str3 = this.f4310g.get(strFixPath);
        if (str3 != null) {
            return str3;
        }
        String strA = a(strFixPath);
        if (strA != null) {
            return strA;
        }
        String string = this.f4308e.getString(strFixPath, str2);
        return e.a(string) ? this.f4309f.decrypt(string, str2) : string;
    }
}
