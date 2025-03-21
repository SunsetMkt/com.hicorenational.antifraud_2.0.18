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

/* renamed from: com.huawei.agconnect.config.impl.b */
/* loaded from: classes.dex */
public class C2249b implements AGConnectOptions {

    /* renamed from: a */
    private final String f6872a;

    /* renamed from: b */
    private final Context f6873b;

    /* renamed from: c */
    private final String f6874c;

    /* renamed from: d */
    private final AGCRoutePolicy f6875d;

    /* renamed from: e */
    private final ConfigReader f6876e;

    /* renamed from: f */
    private final C2252e f6877f;

    /* renamed from: g */
    private final Map<String, String> f6878g;

    /* renamed from: h */
    private final List<Service> f6879h;

    /* renamed from: i */
    private final Map<String, String> f6880i = new HashMap();

    public C2249b(Context context, String str, AGCRoutePolicy aGCRoutePolicy, InputStream inputStream, Map<String, String> map, List<Service> list, String str2) {
        this.f6873b = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        str = str == null ? this.f6873b.getPackageName() : str;
        this.f6874c = str;
        if (inputStream != null) {
            this.f6876e = new C2256i(inputStream, str);
            Utils.closeQuietly(inputStream);
        } else {
            this.f6876e = new C2260m(this.f6873b, str);
        }
        this.f6877f = new C2252e(this.f6876e);
        if (aGCRoutePolicy != AGCRoutePolicy.UNKNOWN && "1.0".equals(this.f6876e.getString("/configuration_version", null))) {
            throw new RuntimeException("The file version does not match,please download the latest agconnect-services.json from the AGC website.");
        }
        this.f6875d = (aGCRoutePolicy == null || aGCRoutePolicy == AGCRoutePolicy.UNKNOWN) ? Utils.getRoutePolicyFromJson(this.f6876e.getString("/region", null), this.f6876e.getString("/agcgw/url", null)) : aGCRoutePolicy;
        this.f6878g = Utils.fixKeyPathMap(map);
        this.f6879h = list;
        this.f6872a = str2 == null ? m6413b() : str2;
    }

    /* renamed from: a */
    private String m6412a(String str) {
        Map<String, JsonProcessingFactory.JsonProcessor> processors = JsonProcessingFactory.getProcessors();
        if (!processors.containsKey(str)) {
            return null;
        }
        if (this.f6880i.containsKey(str)) {
            return this.f6880i.get(str);
        }
        JsonProcessingFactory.JsonProcessor jsonProcessor = processors.get(str);
        if (jsonProcessor == null) {
            return null;
        }
        String processOption = jsonProcessor.processOption(this);
        this.f6880i.put(str, processOption);
        return processOption;
    }

    /* renamed from: b */
    private String m6413b() {
        return String.valueOf(("{packageName='" + this.f6874c + "', routePolicy=" + this.f6875d + ", reader=" + this.f6876e.toString().hashCode() + ", customConfigMap=" + new JSONObject(this.f6878g).toString().hashCode() + '}').hashCode());
    }

    /* renamed from: a */
    public List<Service> m6414a() {
        return this.f6879h;
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
        return this.f6873b;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getIdentifier() {
        return this.f6872a;
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
        return this.f6874c;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public AGCRoutePolicy getRoutePolicy() {
        AGCRoutePolicy aGCRoutePolicy = this.f6875d;
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
        String fixPath = Utils.fixPath(str);
        String str3 = this.f6878g.get(fixPath);
        if (str3 != null) {
            return str3;
        }
        String m6412a = m6412a(fixPath);
        if (m6412a != null) {
            return m6412a;
        }
        String string = this.f6876e.getString(fixPath, str2);
        return C2252e.m6429a(string) ? this.f6877f.decrypt(string, str2) : string;
    }
}
