package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.ConfigReader;
import com.huawei.agconnect.config.LazyInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c extends AGConnectServicesConfig {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LazyInputStream f4314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile ConfigReader f4315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f4316e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AGCRoutePolicy f4317f = AGCRoutePolicy.UNKNOWN;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<String, String> f4318g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile e f4319h;

    public c(Context context, String str) {
        this.a = context;
        this.f4313b = str;
    }

    private static LazyInputStream a(Context context, final InputStream inputStream) {
        return new LazyInputStream(context) { // from class: com.huawei.agconnect.config.impl.c.1
            @Override // com.huawei.agconnect.config.LazyInputStream
            public InputStream get(Context context2) {
                return inputStream;
            }
        };
    }

    private static String a(String str) {
        int i2 = 0;
        if (str.length() > 0) {
            while (str.charAt(i2) == '/') {
                i2++;
            }
        }
        return '/' + str.substring(i2);
    }

    private void a() {
        if (this.f4315d == null) {
            synchronized (this.f4316e) {
                if (this.f4315d == null) {
                    if (this.f4314c != null) {
                        this.f4315d = new i(this.f4314c.loadInputStream(), "UTF-8");
                        this.f4314c.close();
                        this.f4314c = null;
                    } else {
                        this.f4315d = new m(this.a, this.f4313b);
                    }
                    this.f4319h = new e(this.f4315d);
                }
                b();
            }
        }
    }

    private String b(String str) {
        JsonProcessingFactory.JsonProcessor jsonProcessor;
        Map<String, JsonProcessingFactory.JsonProcessor> processors = JsonProcessingFactory.getProcessors();
        if (processors.containsKey(str) && (jsonProcessor = processors.get(str)) != null) {
            return jsonProcessor.processOption(this);
        }
        return null;
    }

    private void b() {
        if (this.f4317f != AGCRoutePolicy.UNKNOWN || this.f4315d == null) {
            return;
        }
        this.f4317f = Utils.getRoutePolicyFromJson(this.f4315d.getString("/region", null), this.f4315d.getString("/agcgw/url", null));
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
        return this.a;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getIdentifier() {
        return Utils.DEFAULT_NAME;
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
        return this.f4313b;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public AGCRoutePolicy getRoutePolicy() {
        if (this.f4317f == null) {
            this.f4317f = AGCRoutePolicy.UNKNOWN;
        }
        if (this.f4317f == AGCRoutePolicy.UNKNOWN && this.f4315d == null) {
            a();
        }
        AGCRoutePolicy aGCRoutePolicy = this.f4317f;
        return aGCRoutePolicy == null ? AGCRoutePolicy.UNKNOWN : aGCRoutePolicy;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str) {
        return getString(str, null);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("path must not be null.");
        }
        if (this.f4315d == null) {
            a();
        }
        String strA = a(str);
        String str3 = this.f4318g.get(strA);
        if (str3 != null) {
            return str3;
        }
        String strB = b(strA);
        if (strB != null) {
            return strB;
        }
        String string = this.f4315d.getString(strA, str2);
        return e.a(string) ? this.f4319h.decrypt(string, str2) : string;
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void overlayWith(LazyInputStream lazyInputStream) {
        this.f4314c = lazyInputStream;
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void overlayWith(InputStream inputStream) {
        overlayWith(a(this.a, inputStream));
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void setParam(String str, String str2) {
        this.f4318g.put(Utils.fixPath(str), str2);
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void setRoutePolicy(AGCRoutePolicy aGCRoutePolicy) {
        this.f4317f = aGCRoutePolicy;
    }
}
