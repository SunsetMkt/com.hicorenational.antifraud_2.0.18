package com.huawei.agconnect.core.p169a;

import android.content.Context;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.AGConnectOptionsBuilder;
import com.huawei.agconnect.CustomAuthProvider;
import com.huawei.agconnect.CustomCredentialsProvider;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.impl.C2249b;
import com.huawei.agconnect.config.impl.Utils;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.service.auth.AuthProvider;
import com.huawei.agconnect.core.service.auth.CredentialsProvider;
import com.huawei.agconnect.core.service.auth.OnTokenListener;
import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.hmf.tasks.Task;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.agconnect.core.a.b */
/* loaded from: classes.dex */
public class C2264b extends AGConnectInstance {

    /* renamed from: a */
    private static List<Service> f6926a;

    /* renamed from: b */
    private static final Map<String, AGConnectInstance> f6927b = new HashMap();

    /* renamed from: c */
    private static String f6928c;

    /* renamed from: d */
    private final AGConnectOptions f6929d;

    /* renamed from: e */
    private final C2266d f6930e;

    /* renamed from: f */
    private final C2266d f6931f;

    public C2264b(AGConnectOptions aGConnectOptions) {
        this.f6929d = aGConnectOptions;
        List<Service> list = f6926a;
        this.f6930e = new C2266d(f6926a, aGConnectOptions.getContext());
        this.f6931f = new C2266d(null, aGConnectOptions.getContext());
        if (aGConnectOptions instanceof C2249b) {
            this.f6931f.m6470a(((C2249b) aGConnectOptions).m6414a(), aGConnectOptions.getContext());
        }
    }

    /* renamed from: a */
    public static AGConnectInstance m6450a() {
        String str = f6928c;
        if (str == null) {
            str = Utils.DEFAULT_NAME;
        }
        return m6453a(str);
    }

    /* renamed from: a */
    public static AGConnectInstance m6451a(AGConnectOptions aGConnectOptions) {
        return m6452a(aGConnectOptions, false);
    }

    /* renamed from: a */
    private static synchronized AGConnectInstance m6452a(AGConnectOptions aGConnectOptions, boolean z) {
        AGConnectInstance aGConnectInstance;
        synchronized (C2264b.class) {
            aGConnectInstance = f6927b.get(aGConnectOptions.getIdentifier());
            if (aGConnectInstance == null || z) {
                aGConnectInstance = new C2264b(aGConnectOptions);
                f6927b.put(aGConnectOptions.getIdentifier(), aGConnectInstance);
            }
        }
        return aGConnectInstance;
    }

    /* renamed from: a */
    public static synchronized AGConnectInstance m6453a(String str) {
        AGConnectInstance aGConnectInstance;
        synchronized (C2264b.class) {
            aGConnectInstance = f6927b.get(str);
            if (aGConnectInstance == null && !Utils.DEFAULT_NAME.equals(str)) {
                String str2 = "not find instance for : " + str;
            }
        }
        return aGConnectInstance;
    }

    /* renamed from: a */
    public static synchronized void m6454a(Context context) {
        synchronized (C2264b.class) {
            if (f6927b.size() > 0) {
                return;
            }
            m6455a(context, AGConnectServicesConfig.fromContext(context));
        }
    }

    /* renamed from: a */
    private static synchronized void m6455a(Context context, AGConnectOptions aGConnectOptions) {
        synchronized (C2264b.class) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            m6457b();
            if (f6926a == null) {
                f6926a = new C2265c(context).m6464a();
            }
            m6452a(aGConnectOptions, true);
            f6928c = aGConnectOptions.getIdentifier();
            C2263a.m6449a();
        }
    }

    /* renamed from: a */
    public static synchronized void m6456a(Context context, AGConnectOptionsBuilder aGConnectOptionsBuilder) {
        synchronized (C2264b.class) {
            m6458b(context, aGConnectOptionsBuilder);
            m6455a(context, aGConnectOptionsBuilder.build(context));
        }
    }

    /* renamed from: b */
    private static void m6457b() {
        JsonProcessingFactory.registerProcessor("/agcgw/url", new JsonProcessingFactory.JsonProcessor() { // from class: com.huawei.agconnect.core.a.b.1
            @Override // com.huawei.agconnect.JsonProcessingFactory.JsonProcessor
            public String processOption(AGConnectOptions aGConnectOptions) {
                String str;
                if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.CHINA)) {
                    str = "/agcgw_all/CN";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.RUSSIA)) {
                    str = "/agcgw_all/RU";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.GERMANY)) {
                    str = "/agcgw_all/DE";
                } else {
                    if (!aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.SINGAPORE)) {
                        return null;
                    }
                    str = "/agcgw_all/SG";
                }
                return aGConnectOptions.getString(str);
            }
        });
        JsonProcessingFactory.registerProcessor("/agcgw/backurl", new JsonProcessingFactory.JsonProcessor() { // from class: com.huawei.agconnect.core.a.b.2
            @Override // com.huawei.agconnect.JsonProcessingFactory.JsonProcessor
            public String processOption(AGConnectOptions aGConnectOptions) {
                String str;
                if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.CHINA)) {
                    str = "/agcgw_all/CN_back";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.RUSSIA)) {
                    str = "/agcgw_all/RU_back";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.GERMANY)) {
                    str = "/agcgw_all/DE_back";
                } else {
                    if (!aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.SINGAPORE)) {
                        return null;
                    }
                    str = "/agcgw_all/SG_back";
                }
                return aGConnectOptions.getString(str);
            }
        });
    }

    /* renamed from: b */
    private static void m6458b(Context context, AGConnectOptionsBuilder aGConnectOptionsBuilder) {
        AGConnectServicesConfig fromContext = AGConnectServicesConfig.fromContext(context);
        if (aGConnectOptionsBuilder.getInputStream() != null) {
            try {
                String utils = Utils.toString(aGConnectOptionsBuilder.getInputStream(), "UTF-8");
                aGConnectOptionsBuilder.getInputStream().reset();
                fromContext.overlayWith(new ByteArrayInputStream(utils.getBytes(Charset.forName("UTF-8"))));
            } catch (IOException unused) {
            }
        }
        for (Map.Entry<String, String> entry : aGConnectOptionsBuilder.getCustomConfigMap().entrySet()) {
            fromContext.setParam(entry.getKey(), entry.getValue());
        }
        if (aGConnectOptionsBuilder.getRoutePolicy() != AGCRoutePolicy.UNKNOWN) {
            fromContext.setRoutePolicy(aGConnectOptionsBuilder.getRoutePolicy());
        }
    }

    /* renamed from: a */
    public void m6459a(final CustomAuthProvider customAuthProvider) {
        this.f6931f.m6470a(Collections.singletonList(Service.builder((Class<?>) AuthProvider.class, new AuthProvider() { // from class: com.huawei.agconnect.core.a.b.4
            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public void addTokenListener(OnTokenListener onTokenListener) {
            }

            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public Task<Token> getTokens() {
                return customAuthProvider.getTokens(false);
            }

            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public Task<Token> getTokens(boolean z) {
                return customAuthProvider.getTokens(z);
            }

            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public String getUid() {
                return "";
            }

            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public void removeTokenListener(OnTokenListener onTokenListener) {
            }
        }).build()), this.f6929d.getContext());
    }

    /* renamed from: a */
    public void m6460a(final CustomCredentialsProvider customCredentialsProvider) {
        this.f6931f.m6470a(Collections.singletonList(Service.builder((Class<?>) CredentialsProvider.class, new CredentialsProvider() { // from class: com.huawei.agconnect.core.a.b.3
            @Override // com.huawei.agconnect.core.service.auth.CredentialsProvider
            public Task<Token> getTokens() {
                return customCredentialsProvider.getTokens(false);
            }

            @Override // com.huawei.agconnect.core.service.auth.CredentialsProvider
            public Task<Token> getTokens(boolean z) {
                return customCredentialsProvider.getTokens(z);
            }
        }).build()), this.f6929d.getContext());
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public Context getContext() {
        return this.f6929d.getContext();
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public String getIdentifier() {
        return this.f6929d.getIdentifier();
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public AGConnectOptions getOptions() {
        return this.f6929d;
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public <T> T getService(Class<? super T> cls) {
        T t = (T) this.f6931f.m6469a(this, cls);
        return t != null ? t : (T) this.f6930e.m6469a(this, cls);
    }
}
