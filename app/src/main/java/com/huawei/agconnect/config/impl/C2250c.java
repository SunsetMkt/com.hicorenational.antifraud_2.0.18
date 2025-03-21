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

/* renamed from: com.huawei.agconnect.config.impl.c */
/* loaded from: classes.dex */
public class C2250c extends AGConnectServicesConfig {

    /* renamed from: a */
    private final Context f6881a;

    /* renamed from: b */
    private final String f6882b;

    /* renamed from: c */
    private LazyInputStream f6883c;

    /* renamed from: d */
    private volatile ConfigReader f6884d;

    /* renamed from: e */
    private final Object f6885e = new Object();

    /* renamed from: f */
    private AGCRoutePolicy f6886f = AGCRoutePolicy.UNKNOWN;

    /* renamed from: g */
    private final Map<String, String> f6887g = new HashMap();

    /* renamed from: h */
    private volatile C2252e f6888h;

    public C2250c(Context context, String str) {
        this.f6881a = context;
        this.f6882b = str;
    }

    /* renamed from: a */
    private static LazyInputStream m6415a(Context context, final InputStream inputStream) {
        return new LazyInputStream(context) { // from class: com.huawei.agconnect.config.impl.c.1
            @Override // com.huawei.agconnect.config.LazyInputStream
            public InputStream get(Context context2) {
                return inputStream;
            }
        };
    }

    /* renamed from: a */
    private static String m6416a(String str) {
        int i2 = 0;
        if (str.length() > 0) {
            while (str.charAt(i2) == '/') {
                i2++;
            }
        }
        return '/' + str.substring(i2);
    }

    /* renamed from: a */
    private void m6417a() {
        if (this.f6884d == null) {
            synchronized (this.f6885e) {
                if (this.f6884d == null) {
                    if (this.f6883c != null) {
                        this.f6884d = new C2256i(this.f6883c.loadInputStream(), "UTF-8");
                        this.f6883c.close();
                        this.f6883c = null;
                    } else {
                        this.f6884d = new C2260m(this.f6881a, this.f6882b);
                    }
                    this.f6888h = new C2252e(this.f6884d);
                }
                m6419b();
            }
        }
    }

    /* renamed from: b */
    private String m6418b(String str) {
        JsonProcessingFactory.JsonProcessor jsonProcessor;
        Map<String, JsonProcessingFactory.JsonProcessor> processors = JsonProcessingFactory.getProcessors();
        if (processors.containsKey(str) && (jsonProcessor = processors.get(str)) != null) {
            return jsonProcessor.processOption(this);
        }
        return null;
    }

    /* renamed from: b */
    private void m6419b() {
        if (this.f6886f != AGCRoutePolicy.UNKNOWN || this.f6884d == null) {
            return;
        }
        this.f6886f = Utils.getRoutePolicyFromJson(this.f6884d.getString("/region", null), this.f6884d.getString("/agcgw/url", null));
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
        return this.f6881a;
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
        return this.f6882b;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public AGCRoutePolicy getRoutePolicy() {
        if (this.f6886f == null) {
            this.f6886f = AGCRoutePolicy.UNKNOWN;
        }
        if (this.f6886f == AGCRoutePolicy.UNKNOWN && this.f6884d == null) {
            m6417a();
        }
        AGCRoutePolicy aGCRoutePolicy = this.f6886f;
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
        if (this.f6884d == null) {
            m6417a();
        }
        String m6416a = m6416a(str);
        String str3 = this.f6887g.get(m6416a);
        if (str3 != null) {
            return str3;
        }
        String m6418b = m6418b(m6416a);
        if (m6418b != null) {
            return m6418b;
        }
        String string = this.f6884d.getString(m6416a, str2);
        return C2252e.m6429a(string) ? this.f6888h.decrypt(string, str2) : string;
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void overlayWith(LazyInputStream lazyInputStream) {
        this.f6883c = lazyInputStream;
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void overlayWith(InputStream inputStream) {
        overlayWith(m6415a(this.f6881a, inputStream));
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void setParam(String str, String str2) {
        this.f6887g.put(Utils.fixPath(str), str2);
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void setRoutePolicy(AGCRoutePolicy aGCRoutePolicy) {
        this.f6886f = aGCRoutePolicy;
    }
}
