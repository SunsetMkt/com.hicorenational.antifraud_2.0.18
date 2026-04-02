package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.httpdns.probe.IPProbeItem;
import com.alibaba.sdk.android.utils.AMSConfigUtils;
import com.alibaba.sdk.android.utils.AMSDevReporter;
import com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class HttpDns implements HttpDnsService {
    private boolean isExpiredIPEnabled = false;
    private static d hostManager = d.a();
    private static DegradationFilter degradationFilter = null;
    static HttpDns instance = null;
    private static boolean inited = false;
    private static String sAccountId = null;
    private static String sSecretKey = null;
    private static Context sContext = null;

    /* JADX INFO: renamed from: com.alibaba.sdk.android.httpdns.HttpDns$1 */
    class AnonymousClass1 implements SDKMessageCallback {
        AnonymousClass1() {
        }

        @Override // com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback
        public void crashDefendMessage(int i2, int i3) {
            boolean unused = HttpDns.inited = true;
            if (i2 > i3) {
                b.b(true);
            } else {
                i.f("crash limit exceeds, httpdns disabled");
                b.b(false);
            }
        }
    }

    /* JADX INFO: renamed from: com.alibaba.sdk.android.httpdns.HttpDns$2 */
    class AnonymousClass2 implements SDKMessageCallback {
        AnonymousClass2() {
        }

        @Override // com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback
        public void crashDefendMessage(int i2, int i3) {
            boolean unused = HttpDns.inited = true;
            if (i2 > i3) {
                b.b(true);
            } else {
                i.f("crash limit exceeds, httpdns disabled");
                b.b(false);
            }
        }
    }

    /* JADX INFO: renamed from: com.alibaba.sdk.android.httpdns.HttpDns$3 */
    class AnonymousClass3 implements SDKMessageCallback {
        AnonymousClass3() {
        }

        @Override // com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback
        public void crashDefendMessage(int i2, int i3) {
            boolean unused = HttpDns.inited = true;
            if (i2 > i3) {
                b.b(true);
            } else {
                i.f("crash limit exceeds, httpdns disabled");
                b.b(false);
            }
        }
    }

    private HttpDns(Context context, String str) {
        f.c(str);
        com.alibaba.sdk.android.httpdns.a.a.a().c(context, str);
        com.alibaba.sdk.android.httpdns.a.a.a().a(com.alibaba.sdk.android.httpdns.d.b.a(context));
    }

    private static void disableReport() {
        com.alibaba.sdk.android.httpdns.d.b.a().k();
    }

    private static String getAccountId() {
        if (!TextUtils.isEmpty(sAccountId)) {
            return sAccountId;
        }
        sAccountId = AMSConfigUtils.getAccountId(sContext);
        return sAccountId;
    }

    private String getIpByHost(String str) {
        if (!b.a()) {
            i.f("HttpDns service turned off");
            return null;
        }
        String[] ipsByHost = getIpsByHost(str);
        if (ipsByHost != null && ipsByHost.length > 0) {
            return ipsByHost[0];
        }
        return null;
    }

    private String[] getIpsByHost(String str) {
        if (!b.a()) {
            i.f("HttpDns service turned off");
        } else {
            if (!l.b(str)) {
                return f.f20c;
            }
            if (l.c(str)) {
                return new String[]{str};
            }
            DegradationFilter degradationFilter2 = degradationFilter;
            if (degradationFilter2 != null && degradationFilter2.shouldDegradeHttpDNS(str)) {
                return f.f20c;
            }
            if (u.e()) {
                return getIpsByHostAsync(str);
            }
            e eVarM12a = hostManager.m12a(str);
            if (eVarM12a != null && eVarM12a.m22b() && this.isExpiredIPEnabled) {
                if (!hostManager.m17a(str)) {
                    i.d("refresh host async: " + str);
                    c.a().submit(new q(str, s.QUERY_HOST));
                }
                return eVarM12a.getIps();
            }
            if (eVarM12a != null && !eVarM12a.m22b()) {
                return eVarM12a.getIps();
            }
            i.d("refresh host sync: " + str);
            try {
                return (String[]) c.a().submit(new q(str, s.QUERY_HOST)).get();
            } catch (Exception e2) {
                i.a(e2);
            }
        }
        return f.f20c;
    }

    private static String getSecretKey() {
        if (!TextUtils.isEmpty(sSecretKey)) {
            return sSecretKey;
        }
        sSecretKey = AMSConfigUtils.getHttpdnsSecretKey(sContext);
        return sSecretKey;
    }

    public static synchronized HttpDnsService getService(Context context) {
        if (instance == null && context != null) {
            sContext = context.getApplicationContext();
            b.a(sContext);
            com.alibaba.sdk.android.httpdns.d.b.a(sContext).a(new SDKMessageCallback() { // from class: com.alibaba.sdk.android.httpdns.HttpDns.3
                AnonymousClass3() {
                }

                @Override // com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback
                public void crashDefendMessage(int i2, int i3) {
                    boolean unused = HttpDns.inited = true;
                    if (i2 > i3) {
                        b.b(true);
                    } else {
                        i.f("crash limit exceeds, httpdns disabled");
                        b.b(false);
                    }
                }
            });
            if (!inited) {
                i.f("sdk crash defend not returned");
            }
            if (b.a()) {
                initHttpDns(sContext, getAccountId(), getSecretKey());
            } else {
                instance = new HttpDns(sContext, getAccountId());
            }
        }
        return instance;
    }

    public static synchronized HttpDnsService getService(Context context, String str) {
        if (instance == null && context != null) {
            sContext = context.getApplicationContext();
            setAccountId(str);
            b.a(sContext);
            com.alibaba.sdk.android.httpdns.d.b.a(sContext).a(new SDKMessageCallback() { // from class: com.alibaba.sdk.android.httpdns.HttpDns.1
                AnonymousClass1() {
                }

                @Override // com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback
                public void crashDefendMessage(int i2, int i3) {
                    boolean unused = HttpDns.inited = true;
                    if (i2 > i3) {
                        b.b(true);
                    } else {
                        i.f("crash limit exceeds, httpdns disabled");
                        b.b(false);
                    }
                }
            });
            if (!inited) {
                i.f("sdk crash defend not returned");
            }
            if (b.a()) {
                initHttpDns(sContext, getAccountId(), getSecretKey());
            } else {
                instance = new HttpDns(sContext, getAccountId());
            }
        }
        return instance;
    }

    public static synchronized HttpDnsService getService(Context context, String str, String str2) {
        if (instance == null && context != null) {
            sContext = context.getApplicationContext();
            setAccountId(str);
            setSecretKey(str2);
            b.a(sContext);
            com.alibaba.sdk.android.httpdns.d.b.a(sContext).a(new SDKMessageCallback() { // from class: com.alibaba.sdk.android.httpdns.HttpDns.2
                AnonymousClass2() {
                }

                @Override // com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback
                public void crashDefendMessage(int i2, int i3) {
                    boolean unused = HttpDns.inited = true;
                    if (i2 > i3) {
                        b.b(true);
                    } else {
                        i.f("crash limit exceeds, httpdns disabled");
                        b.b(false);
                    }
                }
            });
            if (!inited) {
                i.f("sdk crash defend not returned");
            }
            if (b.a()) {
                initHttpDns(sContext, getAccountId(), getSecretKey());
            } else {
                instance = new HttpDns(sContext, getAccountId());
            }
        }
        return instance;
    }

    private static void initHttpDns(Context context, String str, String str2) {
        if (instance == null) {
            HashMap map = new HashMap();
            map.put(AMSDevReporter.AMSSdkExtInfoKeyEnum.AMS_EXTINFO_KEY_VERSION.toString(), "1.3.2.3-no-bssid-ssid");
            AMSDevReporter.asyncReport(context, AMSDevReporter.AMSSdkTypeEnum.AMS_HTTPDNS, map);
            p.setContext(context);
            q.setContext(context);
            com.alibaba.sdk.android.httpdns.b.b.a(context);
            com.alibaba.sdk.android.httpdns.b.b.b(context);
            u.a(context);
            n.a().a(context, str);
            if (!TextUtils.isEmpty(str2)) {
                a.setSecretKey(str2);
            }
            reportActive(context, str);
            instance = new HttpDns(context, str);
        }
    }

    private static void reportActive(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            i.f("report active failed due to missing context or accountid");
        } else {
            com.alibaba.sdk.android.httpdns.d.b.a(context).setAccountId(str);
            com.alibaba.sdk.android.httpdns.d.b.a(context).l();
        }
    }

    private static void reportHttpDnsSuccess(String str, int i2) {
        com.alibaba.sdk.android.httpdns.d.b bVarA = com.alibaba.sdk.android.httpdns.d.b.a();
        if (bVarA != null) {
            bVarA.a(str, i2, com.alibaba.sdk.android.httpdns.d.c.a(), com.alibaba.sdk.android.httpdns.b.b.m7a() ? 1 : 0);
        }
    }

    private static void reportUserGetIP(String str, int i2) {
        com.alibaba.sdk.android.httpdns.d.b bVarA = com.alibaba.sdk.android.httpdns.d.b.a();
        if (bVarA != null) {
            bVarA.b(str, i2, com.alibaba.sdk.android.httpdns.d.c.a(), com.alibaba.sdk.android.httpdns.b.b.m7a() ? 1 : 0);
        }
    }

    private static void setAccountId(String str) {
        sAccountId = str;
    }

    private static void setSecretKey(String str) {
        sSecretKey = str;
    }

    static synchronized void switchDnsService(boolean z) {
        b.a(z);
        if (!b.a()) {
            i.f("httpdns service disabled");
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void clearSdnsGlobalParams() {
        f.clearSdnsGlobalParams();
    }

    @Override // com.alibaba.sdk.android.httpdns.net64.Net64Service
    public void enableIPv6(boolean z) {
        com.alibaba.sdk.android.httpdns.net64.a.a().enableIPv6(z);
        try {
            com.alibaba.sdk.android.httpdns.d.b bVarA = com.alibaba.sdk.android.httpdns.d.b.a();
            if (bVarA != null) {
                bVarA.e(z ? 1 : 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.net64.Net64Service
    public String getIPv6ByHostAsync(String str) {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!b.a()) {
            i.f("HttpDns service turned off");
            return null;
        }
        if (com.alibaba.sdk.android.httpdns.net64.a.a().m26a()) {
            getIpsByHostAsync(str);
            e eVarM12a = hostManager.m12a(str);
            if (eVarM12a != null) {
                String iPv6ByHostAsync = com.alibaba.sdk.android.httpdns.net64.a.a().getIPv6ByHostAsync(str);
                if (this.isExpiredIPEnabled) {
                    i.d("ipv6 is expired enable, hostName: " + str + " ipv6: " + iPv6ByHostAsync);
                    return iPv6ByHostAsync;
                }
                if (!eVarM12a.m22b()) {
                    i.d("ipv6 is not expired, hostName: " + str + " ipv6: " + iPv6ByHostAsync);
                    return iPv6ByHostAsync;
                }
                if (!eVarM12a.c()) {
                    i.d("ipv6 is expired.");
                    return null;
                }
                i.d("ipv6 is from cache, hostName: " + str + " ipv6: " + iPv6ByHostAsync);
                return iPv6ByHostAsync;
            }
        }
        return null;
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public String getIpByHostAsync(String str) {
        try {
            if (!b.a()) {
                i.f("HttpDns service turned off");
                return null;
            }
            String[] ipsByHostAsync = getIpsByHostAsync(str);
            if (ipsByHostAsync != null && ipsByHostAsync.length > 0) {
                return ipsByHostAsync[0];
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0093 A[PHI: r4
  0x0093: PHI (r4v5 boolean) = (r4v1 boolean), (r4v6 boolean) binds: [B:91:0x0062, B:87:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HTTPDNSResult getIpsByHostAsync(String str, Map<String, String> map, String str2) {
        boolean zM22b;
        q qVar;
        Map<String, String> map2 = f.extra;
        map2.putAll(map);
        if (!b.a()) {
            i.f("HttpDns service turned off");
            return new HTTPDNSResult(str, f.f20c, map2);
        }
        if (!l.b(str)) {
            return new HTTPDNSResult(str, f.f20c, map2);
        }
        if (l.c(str)) {
            return new HTTPDNSResult(str, new String[]{str}, map2);
        }
        DegradationFilter degradationFilter2 = degradationFilter;
        if (degradationFilter2 != null && degradationFilter2.shouldDegradeHttpDNS(str)) {
            return new HTTPDNSResult(str, f.f20c, map2);
        }
        e eVarM12a = hostManager.m12a(str);
        if (eVarM12a != null) {
            zM22b = eVarM12a.m22b();
            if (!zM22b) {
                if (eVarM12a != null && !str2.equals(eVarM12a.getCacheKey())) {
                    if (!u.e()) {
                        i.d("refresh host async: " + str);
                        qVar = new q(str, s.QUERY_HOST, map2, str2);
                        c.a().submit(qVar);
                    }
                    t.a().g(str);
                }
            }
            if (eVarM12a != null) {
                reportUserGetIP(str, 0);
                return new HTTPDNSResult(str, f.f20c, map2);
            }
            if (u.e()) {
                i.d("[HttpDns] disabled return Nil.");
                reportUserGetIP(str, 0);
                return new HTTPDNSResult(str, f.f20c, map2);
            }
            if (!str2.equals(eVarM12a.getCacheKey())) {
                return new HTTPDNSResult(str, f.f20c, map2);
            }
            if (this.isExpiredIPEnabled) {
                reportHttpDnsSuccess(str, 1);
                reportUserGetIP(str, 1);
                return new HTTPDNSResult(str, eVarM12a.getIps(), eVarM12a.m21a());
            }
            if (eVarM12a.c()) {
                i.d("[HttpDns] ips from cache:" + Arrays.toString(eVarM12a.getIps()));
                return new HTTPDNSResult(str, eVarM12a.getIps(), eVarM12a.m21a());
            }
            if (zM22b) {
                i.f("[HttpDns] return Nil.");
                reportUserGetIP(str, 0);
                return new HTTPDNSResult(str, f.f20c, map2);
            }
            i.d("[HttpDns] not expired return " + Arrays.toString(eVarM12a.getIps()));
            reportHttpDnsSuccess(str, 1);
            reportUserGetIP(str, 1);
            return new HTTPDNSResult(str, eVarM12a.getIps(), eVarM12a.m21a());
        }
        zM22b = false;
        if (!hostManager.m17a(str)) {
            if (!u.e()) {
                i.d("refresh host async: " + str);
                qVar = new q(str, s.QUERY_HOST, map2, str2);
                c.a().submit(qVar);
            }
            t.a().g(str);
        }
        if (eVarM12a != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x007a A[PHI: r4
  0x007a: PHI (r4v5 boolean) = (r4v1 boolean), (r4v6 boolean) binds: [B:91:0x0049, B:87:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String[] getIpsByHostAsync(String str) {
        boolean zM22b;
        q qVar;
        if (!b.a()) {
            i.f("HttpDns service turned off");
            return f.f20c;
        }
        if (!l.b(str)) {
            return f.f20c;
        }
        if (l.c(str)) {
            return new String[]{str};
        }
        DegradationFilter degradationFilter2 = degradationFilter;
        if (degradationFilter2 != null && degradationFilter2.shouldDegradeHttpDNS(str)) {
            return f.f20c;
        }
        e eVarM12a = hostManager.m12a(str);
        if (eVarM12a != null) {
            zM22b = eVarM12a.m22b();
            if (!zM22b) {
                if (eVarM12a != null && eVarM12a.getCacheKey() != null) {
                    if (!u.e()) {
                        i.d("refresh host async: " + str);
                        qVar = new q(str, s.QUERY_HOST);
                        c.a().submit(qVar);
                    }
                    t.a().g(str);
                }
            }
            if (eVarM12a != null) {
                reportUserGetIP(str, 0);
                return f.f20c;
            }
            if (u.e()) {
                i.d("[HttpDns] disabled return Nil.");
                reportUserGetIP(str, 0);
                return f.f20c;
            }
            if (eVarM12a.getCacheKey() != null) {
                return f.f20c;
            }
            if (this.isExpiredIPEnabled) {
                reportHttpDnsSuccess(str, 1);
                reportUserGetIP(str, 1);
                return eVarM12a.getIps();
            }
            if (eVarM12a.c()) {
                i.d("[HttpDns] ips from cache:" + Arrays.toString(eVarM12a.getIps()));
                return eVarM12a.getIps();
            }
            if (zM22b) {
                i.f("[HttpDns] return Nil.");
                reportUserGetIP(str, 0);
                return f.f20c;
            }
            i.d("[HttpDns] not expired return " + Arrays.toString(eVarM12a.getIps()));
            reportHttpDnsSuccess(str, 1);
            reportUserGetIP(str, 1);
            return eVarM12a.getIps();
        }
        zM22b = false;
        if (!hostManager.m17a(str)) {
            if (!u.e()) {
                i.d("refresh host async: " + str);
                qVar = new q(str, s.QUERY_HOST);
                c.a().submit(qVar);
            }
            t.a().g(str);
        }
        if (eVarM12a != null) {
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public String getSessionId() {
        return com.alibaba.sdk.android.httpdns.e.a.a().getSessionId();
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setAuthCurrentTime(long j2) {
        if (b.a()) {
            a.setAuthCurrentTime(j2);
        } else {
            i.f("HttpDns service turned off");
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setCachedIPEnabled(boolean z) {
        setCachedIPEnabled(z, true);
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setCachedIPEnabled(boolean z, boolean z2) {
        try {
            if (!b.a()) {
                i.f("HttpDns service turned off");
                return;
            }
            i.f("Httpdns DB cache enable = " + z + ". autoCleanCacheAfterLoad = " + z2);
            com.alibaba.sdk.android.httpdns.b.b.a(z, z2);
            d.a().m14a();
            com.alibaba.sdk.android.httpdns.d.b bVarA = com.alibaba.sdk.android.httpdns.d.b.a();
            if (bVarA != null) {
                bVarA.c(z ? 1 : 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setDegradationFilter(DegradationFilter degradationFilter2) {
        if (b.a()) {
            degradationFilter = degradationFilter2;
        } else {
            i.f("HttpDns service turned off");
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setExpiredIPEnabled(boolean z) {
        if (!b.a()) {
            i.f("HttpDns service turned off");
            return;
        }
        this.isExpiredIPEnabled = z;
        com.alibaba.sdk.android.httpdns.d.b bVarA = com.alibaba.sdk.android.httpdns.d.b.a();
        if (bVarA != null) {
            bVarA.d(z ? 1 : 0);
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setHTTPSRequestEnabled(boolean z) {
        if (b.a()) {
            f.setHTTPSRequestEnabled(z);
        } else {
            i.f("HttpDns service turned off");
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setIPProbeList(List<IPProbeItem> list) {
        if (b.a()) {
            f.a(list);
        } else {
            i.f("HttpDns service turned off");
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setLogEnabled(boolean z) {
        i.setLogEnabled(z);
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setLogger(ILogger iLogger) {
        i.setLogger(iLogger);
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setPreResolveAfterNetworkChanged(boolean z) {
        if (b.a()) {
            p.f2592i = z;
        } else {
            i.f("HttpDns service turned off");
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setPreResolveHosts(ArrayList<String> arrayList) {
        if (!b.a()) {
            i.f("HttpDns service turned off");
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String str = arrayList.get(i2);
            if (l.b(str) && !hostManager.m17a(str)) {
                c.a().submit(new q(str, s.QUERY_HOST));
            }
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setRegion(String str) {
        if (!b.a()) {
            i.f("HttpDns service turned off");
        } else if (TextUtils.isEmpty(str)) {
            i.f("region cannot be empty");
        } else {
            n.a().b(sContext, str);
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setSdnsGlobalParams(Map<String, String> map) {
        f.setSdnsGlobalParams(map);
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setTimeoutInterval(int i2) {
        if (b.a()) {
            f.setTimeoutInterval(i2);
        } else {
            i.f("HttpDns service turned off");
        }
    }
}
