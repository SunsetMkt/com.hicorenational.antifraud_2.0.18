package com.xiaomi.push.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C0334r;
import com.xiaomi.push.dy;
import com.xiaomi.push.fl;
import com.xiaomi.push.fm;
import com.xiaomi.push.fn;
import com.xiaomi.push.fq;
import com.xiaomi.push.fx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;

/* loaded from: classes2.dex */
public class ServiceClient {

    /* renamed from: a, reason: collision with other field name */
    private static ServiceClient f922a;

    /* renamed from: a, reason: collision with other field name */
    private static String f923a;

    /* renamed from: a, reason: collision with other field name */
    private Context f925a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f928a;

    /* renamed from: b, reason: collision with other field name */
    private Messenger f929b;

    /* renamed from: b, reason: collision with root package name */
    private static String f13269b = fx.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* renamed from: a, reason: collision with root package name */
    private static long f13268a = 0;

    /* renamed from: a, reason: collision with other field name */
    private Messenger f926a = null;

    /* renamed from: a, reason: collision with other field name */
    private final BroadcastReceiver f924a = new BroadcastReceiver() { // from class: com.xiaomi.push.service.ServiceClient.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.push.au.m150a();
        }
    };

    /* renamed from: a, reason: collision with other field name */
    private List<Message> f927a = new ArrayList();

    /* renamed from: b, reason: collision with other field name */
    private boolean f930b = false;

    private ServiceClient(Context context) {
        this.f928a = false;
        this.f925a = context.getApplicationContext();
        C0334r.a(this.f925a);
        a(this.f925a);
        if (m645a()) {
            com.xiaomi.channel.commonutils.logger.b.c("use miui push service");
            this.f928a = true;
        }
    }

    private void b() {
        this.f925a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f925a, (Class<?>) XMPushService.class), 1, 1);
    }

    public static ServiceClient getInstance(Context context) {
        if (f922a == null) {
            f922a = new ServiceClient(context);
        }
        return f922a;
    }

    public static String getSession() {
        return f923a;
    }

    public static void setSession(String str) {
        f923a = str;
    }

    public boolean batchSendMessage(fn[] fnVarArr, boolean z) {
        if (!com.xiaomi.push.au.m151a(this.f925a)) {
            return false;
        }
        Intent a2 = a();
        Bundle[] bundleArr = new Bundle[fnVarArr.length];
        for (int i2 = 0; i2 < fnVarArr.length; i2++) {
            String a3 = dy.a();
            if (!TextUtils.isEmpty(a3)) {
                fl flVar = new fl("pf", null, null, null);
                fl flVar2 = new fl("sent", null, null, null);
                flVar2.m429a(a3);
                flVar.a(flVar2);
                fnVarArr[i2].a(flVar);
            }
            com.xiaomi.channel.commonutils.logger.b.c("SEND:" + fnVarArr[i2].mo431a());
            bundleArr[i2] = fnVarArr[i2].a();
        }
        if (bundleArr.length <= 0) {
            return false;
        }
        a2.setAction(an.f13370g);
        a2.putExtra(an.J, f923a);
        a2.putExtra("ext_packets", bundleArr);
        a2.putExtra("ext_encrypt", z);
        return startServiceSafely(a2);
    }

    public void checkAlive() {
        Intent a2 = a();
        a2.setAction("com.xiaomi.push.check_alive");
        startServiceSafely(a2);
    }

    public boolean closeChannel() {
        Intent a2 = a();
        a2.setAction(an.f13372i);
        return startServiceSafely(a2);
    }

    @Deprecated
    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return forceReconnection(str, str2, str3, str4, str5, z, a(list), a(list2));
    }

    public boolean isMiuiPushServiceEnabled() {
        return this.f928a;
    }

    public boolean notifyMessage(Bundle bundle, String str, String str2) {
        if (bundle == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("Failed to notify message: bundle|userId|chid may be empty");
            return false;
        }
        Intent a2 = a();
        if (bundle == null) {
            return false;
        }
        a2.setAction(an.o);
        a2.putExtras(bundle);
        com.xiaomi.channel.commonutils.logger.b.e("notify: chid=" + str2 + " bundle:" + bundle);
        return startServiceSafely(a2);
    }

    @Deprecated
    public int openChannel(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return openChannel(str, str2, str3, str4, str5, a(list), a(list2), z);
    }

    @Deprecated
    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        resetConnection(str, str2, str3, str4, str5, z, a(list), a(list2));
    }

    public boolean sendIQ(fm fmVar) {
        if (!com.xiaomi.push.au.m151a(this.f925a)) {
            return false;
        }
        Intent a2 = a();
        Bundle a3 = fmVar.a();
        if (a3 == null) {
            return false;
        }
        com.xiaomi.channel.commonutils.logger.b.c("SEND:" + fmVar.mo431a());
        a2.setAction(an.f13369f);
        a2.putExtra(an.J, f923a);
        a2.putExtra("ext_packet", a3);
        return startServiceSafely(a2);
    }

    public boolean sendMessage(fn fnVar, boolean z) {
        if (!com.xiaomi.push.au.m151a(this.f925a)) {
            return false;
        }
        Intent a2 = a();
        String a3 = dy.a();
        if (!TextUtils.isEmpty(a3)) {
            fl flVar = new fl("pf", null, null, null);
            fl flVar2 = new fl("sent", null, null, null);
            flVar2.m429a(a3);
            flVar.a(flVar2);
            fnVar.a(flVar);
        }
        Bundle a4 = fnVar.a();
        if (a4 == null) {
            return false;
        }
        com.xiaomi.channel.commonutils.logger.b.c("SEND:" + fnVar.mo431a());
        a2.setAction(an.f13368e);
        a2.putExtra(an.J, f923a);
        a2.putExtra("ext_packet", a4);
        a2.putExtra("ext_encrypt", z);
        return startServiceSafely(a2);
    }

    public boolean sendPresence(fq fqVar) {
        if (!com.xiaomi.push.au.m151a(this.f925a)) {
            return false;
        }
        Intent a2 = a();
        Bundle a3 = fqVar.a();
        if (a3 == null) {
            return false;
        }
        com.xiaomi.channel.commonutils.logger.b.c("SEND:" + fqVar.mo431a());
        a2.setAction(an.f13371h);
        a2.putExtra(an.J, f923a);
        a2.putExtra("ext_packet", a3);
        return startServiceSafely(a2);
    }

    public void setMessenger(Messenger messenger) {
        this.f926a = messenger;
    }

    public boolean startServiceSafely(Intent intent) {
        try {
            if (com.xiaomi.push.j.m626a() || Build.VERSION.SDK_INT < 26) {
                this.f925a.startService(intent);
                return true;
            }
            m644a(intent);
            return true;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return false;
        }
    }

    @Deprecated
    public void updateChannelInfo(String str, List<NameValuePair> list, List<NameValuePair> list2) {
        updateChannelInfo(str, a(list), a(list2));
    }

    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent a2 = a();
        a2.setAction(an.f13373j);
        a(a2, str, str2, str3, str4, str5, z, map, map2);
        return startServiceSafely(a2);
    }

    public int openChannel(String str, String str2, String str3, String str4, String str5, Map<String, String> map, Map<String, String> map2, boolean z) {
        Intent a2 = a();
        a2.setAction(an.f13367d);
        a(a2, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(a2);
        return 0;
    }

    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent a2 = a();
        a2.setAction(an.f13374k);
        a(a2, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(a2);
    }

    public void updateChannelInfo(String str, Map<String, String> map, Map<String, String> map2) {
        Intent a2 = a();
        a2.setAction(an.f13375l);
        if (map != null) {
            String a3 = a(map);
            if (!TextUtils.isEmpty(a3)) {
                a2.putExtra(an.D, a3);
            }
        }
        if (map2 != null) {
            String a4 = a(map2);
            if (!TextUtils.isEmpty(a4)) {
                a2.putExtra(an.E, a4);
            }
        }
        a2.putExtra(an.v, str);
        startServiceSafely(a2);
    }

    public boolean closeChannel(String str) {
        Intent a2 = a();
        a2.setAction(an.f13372i);
        a2.putExtra(an.v, str);
        return startServiceSafely(a2);
    }

    private void a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                com.xiaomi.push.au.m146a(context);
            } else {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.addCategory("android.intent.category.DEFAULT");
                com.xiaomi.push.m.a(context.getApplicationContext(), this.f924a, intentFilter, 2);
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m50a("add network status listener failed:" + th);
        }
    }

    public boolean closeChannel(String str, String str2) {
        Intent a2 = a();
        a2.setAction(an.f13372i);
        a2.putExtra(an.v, str);
        a2.putExtra(an.s, str2);
        return startServiceSafely(a2);
    }

    private Map<String, String> a(List<NameValuePair> list) {
        HashMap hashMap = new HashMap();
        if (list != null && list.size() > 0) {
            for (NameValuePair nameValuePair : list) {
                if (nameValuePair != null) {
                    hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        }
        return hashMap;
    }

    private void a(Intent intent, String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        intent.putExtra(an.s, str);
        intent.putExtra(an.v, str2);
        intent.putExtra(an.z, str3);
        intent.putExtra(an.B, str5);
        intent.putExtra(an.A, str4);
        intent.putExtra(an.C, z);
        intent.putExtra(an.J, f923a);
        intent.putExtra(an.N, this.f926a);
        if (map != null && map.size() > 0) {
            String a2 = a(map);
            if (!TextUtils.isEmpty(a2)) {
                intent.putExtra(an.D, a2);
            }
        }
        if (map2 == null || map2.size() <= 0) {
            return;
        }
        String a3 = a(map2);
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        intent.putExtra(an.E, a3);
    }

    public boolean sendMessage(byte[] bArr, String str, String str2) {
        String str3;
        if (com.xiaomi.push.au.m151a(this.f925a) && bArr != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Intent a2 = a();
            if (bArr == null) {
                return false;
            }
            a2.setAction(an.f13368e);
            a2.putExtra(an.J, f923a);
            a2.putExtra("ext_raw_packet", bArr);
            int indexOf = str.indexOf("@");
            String str4 = null;
            String substring = indexOf != -1 ? str.substring(0, indexOf) : null;
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf != -1) {
                str4 = str.substring(indexOf + 1, lastIndexOf);
                str3 = str.substring(lastIndexOf + 1);
            } else {
                str3 = null;
            }
            a2.putExtra(an.s, substring);
            a2.putExtra(an.t, str4);
            a2.putExtra(an.u, str3);
            StringBuilder sb = new StringBuilder();
            sb.append(f13269b);
            long j2 = f13268a;
            f13268a = 1 + j2;
            sb.append(j2);
            String sb2 = sb.toString();
            a2.putExtra("ext_pkt_id", sb2);
            a2.putExtra("ext_chid", str2);
            com.xiaomi.channel.commonutils.logger.b.e("SEND: chid=" + str2 + ", packetId=" + sb2);
            return startServiceSafely(a2);
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("Failed to send message: message|userId|chid may be empty, or the network is unavailable.");
        return false;
    }

    private String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        int i2 = 1;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(Constants.COLON_SEPARATOR);
            sb.append(entry.getValue());
            if (i2 < map.size()) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            i2++;
        }
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    private boolean m645a() {
        if (com.xiaomi.push.x.f1108a) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f925a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 104;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private String m641a() {
        try {
            return this.f925a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    private Intent a() {
        if (isMiuiPushServiceEnabled()) {
            Intent intent = new Intent();
            intent.setPackage("com.xiaomi.xmsf");
            intent.setClassName("com.xiaomi.xmsf", m641a());
            intent.putExtra(an.F, this.f925a.getPackageName());
            m643a();
            return intent;
        }
        Intent intent2 = new Intent(this.f925a, (Class<?>) XMPushService.class);
        intent2.putExtra(an.F, this.f925a.getPackageName());
        b();
        return intent2;
    }

    /* renamed from: a, reason: collision with other method in class */
    private void m643a() {
        this.f925a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f925a, (Class<?>) XMPushService.class), 2, 1);
    }

    /* renamed from: a, reason: collision with other method in class */
    private synchronized void m644a(Intent intent) {
        if (this.f930b) {
            Message a2 = a(intent);
            if (this.f927a.size() >= 50) {
                this.f927a.remove(0);
            }
            this.f927a.add(a2);
            return;
        }
        if (this.f929b == null) {
            this.f925a.bindService(intent, new ServiceConnection() { // from class: com.xiaomi.push.service.ServiceClient.2
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    synchronized (ServiceClient.this) {
                        ServiceClient.this.f929b = new Messenger(iBinder);
                        ServiceClient.this.f930b = false;
                        Iterator it = ServiceClient.this.f927a.iterator();
                        while (it.hasNext()) {
                            try {
                                ServiceClient.this.f929b.send((Message) it.next());
                            } catch (RemoteException e2) {
                                com.xiaomi.channel.commonutils.logger.b.a(e2);
                            }
                        }
                        ServiceClient.this.f927a.clear();
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    ServiceClient.this.f929b = null;
                    ServiceClient.this.f930b = false;
                }
            }, 1);
            this.f930b = true;
            this.f927a.clear();
            this.f927a.add(a(intent));
        } else {
            try {
                this.f929b.send(a(intent));
            } catch (RemoteException unused) {
                this.f929b = null;
                this.f930b = false;
            }
        }
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }
}
