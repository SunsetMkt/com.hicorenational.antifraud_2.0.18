package com.huawei.agconnect.core.p169a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.ServiceDiscovery;
import com.huawei.agconnect.core.ServiceRegistrar;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.agconnect.core.a.c */
/* loaded from: classes.dex */
public class C2265c {

    /* renamed from: a */
    private final Context f6936a;

    /* renamed from: com.huawei.agconnect.core.a.c$a */
    private static class a implements Serializable, Comparator<Map.Entry<String, Integer>> {
        private a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            return entry.getValue().intValue() - entry2.getValue().intValue();
        }
    }

    C2265c(Context context) {
        this.f6936a = context;
    }

    /* renamed from: a */
    private <T extends ServiceRegistrar> T m6461a(String str) {
        StringBuilder sb;
        String localizedMessage;
        try {
            Class<?> cls = Class.forName(str);
            if (ServiceRegistrar.class.isAssignableFrom(cls)) {
                return (T) Class.forName(str).newInstance();
            }
            String str2 = cls + " must extends from ServiceRegistrar.";
            return null;
        } catch (ClassNotFoundException e2) {
            String str3 = "Can not found service class, " + e2.getMessage();
            return null;
        } catch (IllegalAccessException e3) {
            sb = new StringBuilder();
            sb.append("instantiate service class exception ");
            localizedMessage = e3.getLocalizedMessage();
            sb.append(localizedMessage);
            sb.toString();
            return null;
        } catch (InstantiationException e4) {
            sb = new StringBuilder();
            sb.append("instantiate service class exception ");
            localizedMessage = e4.getLocalizedMessage();
            sb.append(localizedMessage);
            sb.toString();
            return null;
        }
    }

    /* renamed from: b */
    private List<String> m6462b() {
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        Bundle m6463c = m6463c();
        if (m6463c == null) {
            return arrayList;
        }
        HashMap hashMap = new HashMap(10);
        for (String str : m6463c.keySet()) {
            if ("com.huawei.agconnect.core.ServiceRegistrar".equals(m6463c.getString(str))) {
                String[] split = str.split(Constants.COLON_SEPARATOR);
                if (split.length == 2) {
                    try {
                        hashMap.put(split[0], Integer.valueOf(split[1]));
                    } catch (NumberFormatException e2) {
                        sb = new StringBuilder();
                        sb.append("registrar configuration format error:");
                        str = e2.getMessage();
                    }
                } else if (split.length == 1) {
                    hashMap.put(split[0], 1000);
                } else {
                    sb = new StringBuilder();
                    sb.append("registrar configuration error, ");
                    sb.append(str);
                    sb.toString();
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(hashMap.entrySet());
        Collections.sort(arrayList2, new a());
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Map.Entry) it.next()).getKey());
        }
        return arrayList;
    }

    /* renamed from: c */
    private Bundle m6463c() {
        ServiceInfo serviceInfo;
        PackageManager packageManager = this.f6936a.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            serviceInfo = packageManager.getServiceInfo(new ComponentName(this.f6936a, (Class<?>) ServiceDiscovery.class), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            String str = "get ServiceDiscovery exception." + e2.getLocalizedMessage();
        }
        if (serviceInfo == null) {
            return null;
        }
        return serviceInfo.metaData;
    }

    /* renamed from: a */
    public List<Service> m6464a() {
        List<String> m6462b = m6462b();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = m6462b.iterator();
        while (it.hasNext()) {
            ServiceRegistrar m6461a = m6461a(it.next());
            if (m6461a != null) {
                m6461a.initialize(this.f6936a);
                List<Service> services = m6461a.getServices(this.f6936a);
                if (services != null) {
                    arrayList.addAll(services);
                }
            }
        }
        String str = "services:" + arrayList.size();
        return arrayList;
    }
}
