package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.httpdns.net64.C1528a;
import com.alibaba.sdk.android.httpdns.p111a.C1502a;
import com.alibaba.sdk.android.httpdns.p112b.C1505b;
import com.alibaba.sdk.android.httpdns.p114d.C1515b;
import com.alibaba.sdk.android.httpdns.p114d.C1516c;
import com.alibaba.sdk.android.httpdns.p115e.C1518a;
import com.alibaba.sdk.android.httpdns.probe.IPProbeItem;
import com.alibaba.sdk.android.utils.AMSConfigUtils;
import com.alibaba.sdk.android.utils.AMSDevReporter;
import com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpDns implements HttpDnsService {
    private boolean isExpiredIPEnabled = false;
    private static C1513d hostManager = C1513d.m3470a();
    private static DegradationFilter degradationFilter = null;
    static HttpDns instance = null;
    private static boolean inited = false;
    private static String sAccountId = null;
    private static String sSecretKey = null;
    private static Context sContext = null;

    private HttpDns(Context context, String str) {
        C1519f.m3521c(str);
        C1502a.m3416a().m3424c(context, str);
        C1502a.m3416a().m3423a(C1515b.m3487a(context));
    }

    private static void disableReport() {
        C1515b.m3486a().m3503k();
    }

    private static String getAccountId() {
        if (!TextUtils.isEmpty(sAccountId)) {
            return sAccountId;
        }
        sAccountId = AMSConfigUtils.getAccountId(sContext);
        return sAccountId;
    }

    private String getIpByHost(String str) {
        if (!C1503b.m3428a()) {
            C1522i.m3527f("HttpDns service turned off");
            return null;
        }
        String[] ipsByHost = getIpsByHost(str);
        if (ipsByHost != null && ipsByHost.length > 0) {
            return ipsByHost[0];
        }
        return null;
    }

    private String[] getIpsByHost(String str) {
        if (!C1503b.m3428a()) {
            C1522i.m3527f("HttpDns service turned off");
        } else {
            if (!C1525l.m3531b(str)) {
                return C1519f.f3925c;
            }
            if (C1525l.m3532c(str)) {
                return new String[]{str};
            }
            DegradationFilter degradationFilter2 = degradationFilter;
            if (degradationFilter2 != null && degradationFilter2.shouldDegradeHttpDNS(str)) {
                return C1519f.f3925c;
            }
            if (C1543u.m3595e()) {
                return getIpsByHostAsync(str);
            }
            C1517e m3477a = hostManager.m3477a(str);
            if (m3477a != null && m3477a.m3514b() && this.isExpiredIPEnabled) {
                if (!hostManager.m3482a(str)) {
                    C1522i.m3525d("refresh host async: " + str);
                    C1511c.m3462a().submit(new CallableC1540q(str, EnumC1541s.QUERY_HOST));
                }
                return m3477a.getIps();
            }
            if (m3477a != null && !m3477a.m3514b()) {
                return m3477a.getIps();
            }
            C1522i.m3525d("refresh host sync: " + str);
            try {
                return (String[]) C1511c.m3462a().submit(new CallableC1540q(str, EnumC1541s.QUERY_HOST)).get();
            } catch (Exception e2) {
                C1522i.m3523a(e2);
            }
        }
        return C1519f.f3925c;
    }

    private static String getSecretKey() {
        if (!TextUtils.isEmpty(sSecretKey)) {
            return sSecretKey;
        }
        sSecretKey = AMSConfigUtils.getHttpdnsSecretKey(sContext);
        return sSecretKey;
    }

    public static synchronized HttpDnsService getService(Context context) {
        HttpDns httpDns;
        synchronized (HttpDns.class) {
            if (instance == null && context != null) {
                sContext = context.getApplicationContext();
                C1503b.m3426a(sContext);
                C1515b.m3487a(sContext).m3495a(new SDKMessageCallback() { // from class: com.alibaba.sdk.android.httpdns.HttpDns.3
                    @Override // com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback
                    public void crashDefendMessage(int i2, int i3) {
                        boolean unused = HttpDns.inited = true;
                        if (i2 > i3) {
                            C1503b.m3429b(true);
                        } else {
                            C1522i.m3527f("crash limit exceeds, httpdns disabled");
                            C1503b.m3429b(false);
                        }
                    }
                });
                if (!inited) {
                    C1522i.m3527f("sdk crash defend not returned");
                }
                if (C1503b.m3428a()) {
                    initHttpDns(sContext, getAccountId(), getSecretKey());
                } else {
                    instance = new HttpDns(sContext, getAccountId());
                }
            }
            httpDns = instance;
        }
        return httpDns;
    }

    public static synchronized HttpDnsService getService(Context context, String str) {
        HttpDns httpDns;
        synchronized (HttpDns.class) {
            if (instance == null && context != null) {
                sContext = context.getApplicationContext();
                setAccountId(str);
                C1503b.m3426a(sContext);
                C1515b.m3487a(sContext).m3495a(new SDKMessageCallback() { // from class: com.alibaba.sdk.android.httpdns.HttpDns.1
                    @Override // com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback
                    public void crashDefendMessage(int i2, int i3) {
                        boolean unused = HttpDns.inited = true;
                        if (i2 > i3) {
                            C1503b.m3429b(true);
                        } else {
                            C1522i.m3527f("crash limit exceeds, httpdns disabled");
                            C1503b.m3429b(false);
                        }
                    }
                });
                if (!inited) {
                    C1522i.m3527f("sdk crash defend not returned");
                }
                if (C1503b.m3428a()) {
                    initHttpDns(sContext, getAccountId(), getSecretKey());
                } else {
                    instance = new HttpDns(sContext, getAccountId());
                }
            }
            httpDns = instance;
        }
        return httpDns;
    }

    public static synchronized HttpDnsService getService(Context context, String str, String str2) {
        HttpDns httpDns;
        synchronized (HttpDns.class) {
            if (instance == null && context != null) {
                sContext = context.getApplicationContext();
                setAccountId(str);
                setSecretKey(str2);
                C1503b.m3426a(sContext);
                C1515b.m3487a(sContext).m3495a(new SDKMessageCallback() { // from class: com.alibaba.sdk.android.httpdns.HttpDns.2
                    @Override // com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback
                    public void crashDefendMessage(int i2, int i3) {
                        boolean unused = HttpDns.inited = true;
                        if (i2 > i3) {
                            C1503b.m3429b(true);
                        } else {
                            C1522i.m3527f("crash limit exceeds, httpdns disabled");
                            C1503b.m3429b(false);
                        }
                    }
                });
                if (!inited) {
                    C1522i.m3527f("sdk crash defend not returned");
                }
                if (C1503b.m3428a()) {
                    initHttpDns(sContext, getAccountId(), getSecretKey());
                } else {
                    instance = new HttpDns(sContext, getAccountId());
                }
            }
            httpDns = instance;
        }
        return httpDns;
    }

    private static void initHttpDns(Context context, String str, String str2) {
        if (instance == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(AMSDevReporter.AMSSdkExtInfoKeyEnum.AMS_EXTINFO_KEY_VERSION.toString(), "1.3.2.3-no-bssid-ssid");
            AMSDevReporter.asyncReport(context, AMSDevReporter.AMSSdkTypeEnum.AMS_HTTPDNS, hashMap);
            C1531p.setContext(context);
            CallableC1540q.setContext(context);
            C1505b.m3434a(context);
            C1505b.m3439b(context);
            C1543u.m3587a(context);
            C1527n.m3536a().m3544a(context, str);
            if (!TextUtils.isEmpty(str2)) {
                C1501a.setSecretKey(str2);
            }
            reportActive(context, str);
            instance = new HttpDns(context, str);
        }
    }

    private static void reportActive(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            C1522i.m3527f("report active failed due to missing context or accountid");
        } else {
            C1515b.m3487a(context).setAccountId(str);
            C1515b.m3487a(context).m3505l();
        }
    }

    private static void reportHttpDnsSuccess(String str, int i2) {
        C1515b m3486a = C1515b.m3486a();
        if (m3486a != null) {
            m3486a.m3489a(str, i2, C1516c.m3506a(), C1505b.m3438a() ? 1 : 0);
        }
    }

    private static void reportUserGetIP(String str, int i2) {
        C1515b m3486a = C1515b.m3486a();
        if (m3486a != null) {
            m3486a.m3496b(str, i2, C1516c.m3506a(), C1505b.m3438a() ? 1 : 0);
        }
    }

    private static void setAccountId(String str) {
        sAccountId = str;
    }

    private static void setSecretKey(String str) {
        sSecretKey = str;
    }

    static synchronized void switchDnsService(boolean z) {
        synchronized (HttpDns.class) {
            C1503b.m3427a(z);
            if (!C1503b.m3428a()) {
                C1522i.m3527f("httpdns service disabled");
            }
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void clearSdnsGlobalParams() {
        C1519f.clearSdnsGlobalParams();
    }

    @Override // com.alibaba.sdk.android.httpdns.net64.Net64Service
    public void enableIPv6(boolean z) {
        C1528a.m3551a().enableIPv6(z);
        try {
            C1515b m3486a = C1515b.m3486a();
            if (m3486a != null) {
                m3486a.m3501e(z ? 1 : 0);
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
        if (!C1503b.m3428a()) {
            C1522i.m3527f("HttpDns service turned off");
            return null;
        }
        if (C1528a.m3551a().m3554a()) {
            getIpsByHostAsync(str);
            C1517e m3477a = hostManager.m3477a(str);
            if (m3477a != null) {
                String iPv6ByHostAsync = C1528a.m3551a().getIPv6ByHostAsync(str);
                if (this.isExpiredIPEnabled) {
                    C1522i.m3525d("ipv6 is expired enable, hostName: " + str + " ipv6: " + iPv6ByHostAsync);
                    return iPv6ByHostAsync;
                }
                if (!m3477a.m3514b()) {
                    C1522i.m3525d("ipv6 is not expired, hostName: " + str + " ipv6: " + iPv6ByHostAsync);
                    return iPv6ByHostAsync;
                }
                if (!m3477a.m3515c()) {
                    C1522i.m3525d("ipv6 is expired.");
                    return null;
                }
                C1522i.m3525d("ipv6 is from cache, hostName: " + str + " ipv6: " + iPv6ByHostAsync);
                return iPv6ByHostAsync;
            }
        }
        return null;
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public String getIpByHostAsync(String str) {
        try {
            if (!C1503b.m3428a()) {
                C1522i.m3527f("HttpDns service turned off");
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

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0058, code lost:
    
        if (r4 != false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cd  */
    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alibaba.sdk.android.httpdns.HTTPDNSResult getIpsByHostAsync(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.HttpDns.getIpsByHostAsync(java.lang.String, java.util.Map, java.lang.String):com.alibaba.sdk.android.httpdns.HTTPDNSResult");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
    
        if (r4 != false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String[] getIpsByHostAsync(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.HttpDns.getIpsByHostAsync(java.lang.String):java.lang.String[]");
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public String getSessionId() {
        return C1518a.m3516a().getSessionId();
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setAuthCurrentTime(long j2) {
        if (C1503b.m3428a()) {
            C1501a.setAuthCurrentTime(j2);
        } else {
            C1522i.m3527f("HttpDns service turned off");
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setCachedIPEnabled(boolean z) {
        setCachedIPEnabled(z, true);
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setCachedIPEnabled(boolean z, boolean z2) {
        try {
            if (!C1503b.m3428a()) {
                C1522i.m3527f("HttpDns service turned off");
                return;
            }
            C1522i.m3527f("Httpdns DB cache enable = " + z + ". autoCleanCacheAfterLoad = " + z2);
            C1505b.m3437a(z, z2);
            C1513d.m3470a().m3479a();
            C1515b m3486a = C1515b.m3486a();
            if (m3486a != null) {
                m3486a.m3499c(z ? 1 : 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setDegradationFilter(DegradationFilter degradationFilter2) {
        if (C1503b.m3428a()) {
            degradationFilter = degradationFilter2;
        } else {
            C1522i.m3527f("HttpDns service turned off");
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setExpiredIPEnabled(boolean z) {
        if (!C1503b.m3428a()) {
            C1522i.m3527f("HttpDns service turned off");
            return;
        }
        this.isExpiredIPEnabled = z;
        C1515b m3486a = C1515b.m3486a();
        if (m3486a != null) {
            m3486a.m3500d(z ? 1 : 0);
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setHTTPSRequestEnabled(boolean z) {
        if (C1503b.m3428a()) {
            C1519f.setHTTPSRequestEnabled(z);
        } else {
            C1522i.m3527f("HttpDns service turned off");
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setIPProbeList(List<IPProbeItem> list) {
        if (C1503b.m3428a()) {
            C1519f.m3519a(list);
        } else {
            C1522i.m3527f("HttpDns service turned off");
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setLogEnabled(boolean z) {
        C1522i.setLogEnabled(z);
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setLogger(ILogger iLogger) {
        C1522i.setLogger(iLogger);
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setPreResolveAfterNetworkChanged(boolean z) {
        if (C1503b.m3428a()) {
            C1531p.f3967i = z;
        } else {
            C1522i.m3527f("HttpDns service turned off");
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setPreResolveHosts(ArrayList<String> arrayList) {
        if (!C1503b.m3428a()) {
            C1522i.m3527f("HttpDns service turned off");
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String str = arrayList.get(i2);
            if (C1525l.m3531b(str) && !hostManager.m3482a(str)) {
                C1511c.m3462a().submit(new CallableC1540q(str, EnumC1541s.QUERY_HOST));
            }
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setRegion(String str) {
        if (!C1503b.m3428a()) {
            C1522i.m3527f("HttpDns service turned off");
        } else if (TextUtils.isEmpty(str)) {
            C1522i.m3527f("region cannot be empty");
        } else {
            C1527n.m3536a().m3547b(sContext, str);
        }
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setSdnsGlobalParams(Map<String, String> map) {
        C1519f.setSdnsGlobalParams(map);
    }

    @Override // com.alibaba.sdk.android.httpdns.HttpDnsService
    public void setTimeoutInterval(int i2) {
        if (C1503b.m3428a()) {
            C1519f.setTimeoutInterval(i2);
        } else {
            C1522i.m3527f("HttpDns service turned off");
        }
    }
}
