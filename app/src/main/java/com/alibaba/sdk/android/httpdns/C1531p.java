package com.alibaba.sdk.android.httpdns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.alibaba.sdk.android.httpdns.p112b.C1505b;
import java.util.ArrayList;

/* renamed from: com.alibaba.sdk.android.httpdns.p */
/* loaded from: classes.dex */
public class C1531p {

    /* renamed from: a */
    private static Context f3966a = null;

    /* renamed from: i */
    static boolean f3967i = false;

    /* renamed from: j */
    private static String f3968j;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static String m3559f() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) f3966a.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                String typeName = activeNetworkInfo.getTypeName();
                C1522i.m3525d("[detectCurrentNetwork] - Network name:" + typeName + " subType name: " + activeNetworkInfo.getSubtypeName());
                return typeName == null ? "None_Network" : typeName;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return "None_Network";
    }

    public static void setContext(Context context) {
        if (context == null) {
            throw new IllegalStateException("Context can't be null");
        }
        f3966a = context;
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.alibaba.sdk.android.httpdns.p.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                try {
                    if (!isInitialStickyBroadcast() && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                        C1505b.m3439b(context2);
                        String m3559f = C1531p.m3559f();
                        if (m3559f != "None_Network" && !m3559f.equalsIgnoreCase(C1531p.f3968j)) {
                            C1522i.m3525d("[BroadcastReceiver.onReceive] - Network state changed");
                            ArrayList<String> m3478a = C1513d.m3470a().m3478a();
                            C1513d.m3470a().clear();
                            C1513d.m3470a().m3479a();
                            if (C1531p.f3967i && HttpDns.instance != null) {
                                C1522i.m3525d("[BroadcastReceiver.onReceive] - refresh host");
                                HttpDns.instance.setPreResolveHosts(m3478a);
                            }
                        }
                        String unused = C1531p.f3968j = m3559f;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            f3966a.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
