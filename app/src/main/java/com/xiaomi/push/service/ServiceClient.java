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
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C4092au;
import com.xiaomi.push.C4177dy;
import com.xiaomi.push.C4218fl;
import com.xiaomi.push.C4219fm;
import com.xiaomi.push.C4220fn;
import com.xiaomi.push.C4223fq;
import com.xiaomi.push.C4230fx;
import com.xiaomi.push.C4300j;
import com.xiaomi.push.C4303m;
import com.xiaomi.push.C4309r;
import com.xiaomi.push.C4409x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;

/* loaded from: classes2.dex */
public class ServiceClient {

    /* renamed from: a */
    private static ServiceClient f16401a;

    /* renamed from: a */
    private static String f16402a;

    /* renamed from: a */
    private Context f16405a;

    /* renamed from: a */
    private boolean f16408a;

    /* renamed from: b */
    private Messenger f16409b;

    /* renamed from: b */
    private static String f16403b = C4230fx.m14900a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* renamed from: a */
    private static long f16400a = 0;

    /* renamed from: a */
    private Messenger f16406a = null;

    /* renamed from: a */
    private final BroadcastReceiver f16404a = new BroadcastReceiver() { // from class: com.xiaomi.push.service.ServiceClient.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C4092au.m13797a();
        }
    };

    /* renamed from: a */
    private List<Message> f16407a = new ArrayList();

    /* renamed from: b */
    private boolean f16410b = false;

    private ServiceClient(Context context) {
        this.f16408a = false;
        this.f16405a = context.getApplicationContext();
        C4309r.m15718a(this.f16405a);
        m15740a(this.f16405a);
        if (m15743a()) {
            AbstractC4022b.m13359c("use miui push service");
            this.f16408a = true;
        }
    }

    /* renamed from: b */
    private void m15745b() {
        this.f16405a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f16405a, (Class<?>) XMPushService.class), 1, 1);
    }

    public static ServiceClient getInstance(Context context) {
        if (f16401a == null) {
            f16401a = new ServiceClient(context);
        }
        return f16401a;
    }

    public static String getSession() {
        return f16402a;
    }

    public static void setSession(String str) {
        f16402a = str;
    }

    public boolean batchSendMessage(C4220fn[] c4220fnArr, boolean z) {
        if (!C4092au.m13799a(this.f16405a)) {
            return false;
        }
        Intent m15731a = m15731a();
        Bundle[] bundleArr = new Bundle[c4220fnArr.length];
        for (int i2 = 0; i2 < c4220fnArr.length; i2++) {
            String m14577a = C4177dy.m14577a();
            if (!TextUtils.isEmpty(m14577a)) {
                C4218fl c4218fl = new C4218fl("pf", null, null, null);
                C4218fl c4218fl2 = new C4218fl("sent", null, null, null);
                c4218fl2.m14823a(m14577a);
                c4218fl.m14822a(c4218fl2);
                c4220fnArr[i2].m14861a(c4218fl);
            }
            AbstractC4022b.m13359c("SEND:" + c4220fnArr[i2].mo14829a());
            bundleArr[i2] = c4220fnArr[i2].mo14827a();
        }
        if (bundleArr.length <= 0) {
            return false;
        }
        m15731a.setAction(AbstractC4362an.f16605g);
        m15731a.putExtra(AbstractC4362an.f16590J, f16402a);
        m15731a.putExtra("ext_packets", bundleArr);
        m15731a.putExtra("ext_encrypt", z);
        return startServiceSafely(m15731a);
    }

    public void checkAlive() {
        Intent m15731a = m15731a();
        m15731a.setAction("com.xiaomi.push.check_alive");
        startServiceSafely(m15731a);
    }

    public boolean closeChannel() {
        Intent m15731a = m15731a();
        m15731a.setAction(AbstractC4362an.f16607i);
        return startServiceSafely(m15731a);
    }

    @Deprecated
    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return forceReconnection(str, str2, str3, str4, str5, z, m15738a(list), m15738a(list2));
    }

    public boolean isMiuiPushServiceEnabled() {
        return this.f16408a;
    }

    public boolean notifyMessage(Bundle bundle, String str, String str2) {
        if (bundle == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AbstractC4022b.m13347a("Failed to notify message: bundle|userId|chid may be empty");
            return false;
        }
        Intent m15731a = m15731a();
        if (bundle == null) {
            return false;
        }
        m15731a.setAction(AbstractC4362an.f16613o);
        m15731a.putExtras(bundle);
        AbstractC4022b.m13363e("notify: chid=" + str2 + " bundle:" + bundle);
        return startServiceSafely(m15731a);
    }

    @Deprecated
    public int openChannel(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return openChannel(str, str2, str3, str4, str5, m15738a(list), m15738a(list2), z);
    }

    @Deprecated
    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        resetConnection(str, str2, str3, str4, str5, z, m15738a(list), m15738a(list2));
    }

    public boolean sendIQ(C4219fm c4219fm) {
        if (!C4092au.m13799a(this.f16405a)) {
            return false;
        }
        Intent m15731a = m15731a();
        Bundle mo14827a = c4219fm.mo14827a();
        if (mo14827a == null) {
            return false;
        }
        AbstractC4022b.m13359c("SEND:" + c4219fm.mo14829a());
        m15731a.setAction(AbstractC4362an.f16604f);
        m15731a.putExtra(AbstractC4362an.f16590J, f16402a);
        m15731a.putExtra("ext_packet", mo14827a);
        return startServiceSafely(m15731a);
    }

    public boolean sendMessage(C4220fn c4220fn, boolean z) {
        if (!C4092au.m13799a(this.f16405a)) {
            return false;
        }
        Intent m15731a = m15731a();
        String m14577a = C4177dy.m14577a();
        if (!TextUtils.isEmpty(m14577a)) {
            C4218fl c4218fl = new C4218fl("pf", null, null, null);
            C4218fl c4218fl2 = new C4218fl("sent", null, null, null);
            c4218fl2.m14823a(m14577a);
            c4218fl.m14822a(c4218fl2);
            c4220fn.m14861a(c4218fl);
        }
        Bundle mo14827a = c4220fn.mo14827a();
        if (mo14827a == null) {
            return false;
        }
        AbstractC4022b.m13359c("SEND:" + c4220fn.mo14829a());
        m15731a.setAction(AbstractC4362an.f16603e);
        m15731a.putExtra(AbstractC4362an.f16590J, f16402a);
        m15731a.putExtra("ext_packet", mo14827a);
        m15731a.putExtra("ext_encrypt", z);
        return startServiceSafely(m15731a);
    }

    public boolean sendPresence(C4223fq c4223fq) {
        if (!C4092au.m13799a(this.f16405a)) {
            return false;
        }
        Intent m15731a = m15731a();
        Bundle mo14827a = c4223fq.mo14827a();
        if (mo14827a == null) {
            return false;
        }
        AbstractC4022b.m13359c("SEND:" + c4223fq.mo14829a());
        m15731a.setAction(AbstractC4362an.f16606h);
        m15731a.putExtra(AbstractC4362an.f16590J, f16402a);
        m15731a.putExtra("ext_packet", mo14827a);
        return startServiceSafely(m15731a);
    }

    public void setMessenger(Messenger messenger) {
        this.f16406a = messenger;
    }

    public boolean startServiceSafely(Intent intent) {
        try {
            if (C4300j.m15680a() || Build.VERSION.SDK_INT < 26) {
                this.f16405a.startService(intent);
                return true;
            }
            m15741a(intent);
            return true;
        } catch (Exception e2) {
            AbstractC4022b.m13351a(e2);
            return false;
        }
    }

    @Deprecated
    public void updateChannelInfo(String str, List<NameValuePair> list, List<NameValuePair> list2) {
        updateChannelInfo(str, m15738a(list), m15738a(list2));
    }

    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent m15731a = m15731a();
        m15731a.setAction(AbstractC4362an.f16608j);
        m15742a(m15731a, str, str2, str3, str4, str5, z, map, map2);
        return startServiceSafely(m15731a);
    }

    public int openChannel(String str, String str2, String str3, String str4, String str5, Map<String, String> map, Map<String, String> map2, boolean z) {
        Intent m15731a = m15731a();
        m15731a.setAction(AbstractC4362an.f16602d);
        m15742a(m15731a, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(m15731a);
        return 0;
    }

    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent m15731a = m15731a();
        m15731a.setAction(AbstractC4362an.f16609k);
        m15742a(m15731a, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(m15731a);
    }

    public void updateChannelInfo(String str, Map<String, String> map, Map<String, String> map2) {
        Intent m15731a = m15731a();
        m15731a.setAction(AbstractC4362an.f16610l);
        if (map != null) {
            String m15736a = m15736a(map);
            if (!TextUtils.isEmpty(m15736a)) {
                m15731a.putExtra(AbstractC4362an.f16584D, m15736a);
            }
        }
        if (map2 != null) {
            String m15736a2 = m15736a(map2);
            if (!TextUtils.isEmpty(m15736a2)) {
                m15731a.putExtra(AbstractC4362an.f16585E, m15736a2);
            }
        }
        m15731a.putExtra(AbstractC4362an.f16620v, str);
        startServiceSafely(m15731a);
    }

    public boolean closeChannel(String str) {
        Intent m15731a = m15731a();
        m15731a.setAction(AbstractC4362an.f16607i);
        m15731a.putExtra(AbstractC4362an.f16620v, str);
        return startServiceSafely(m15731a);
    }

    /* renamed from: a */
    private void m15740a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                C4092au.m13788a(context);
            } else {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.addCategory("android.intent.category.DEFAULT");
                C4303m.m15699a(context.getApplicationContext(), this.f16404a, intentFilter, 2);
            }
        } catch (Throwable th) {
            AbstractC4022b.m13347a("add network status listener failed:" + th);
        }
    }

    public boolean closeChannel(String str, String str2) {
        Intent m15731a = m15731a();
        m15731a.setAction(AbstractC4362an.f16607i);
        m15731a.putExtra(AbstractC4362an.f16620v, str);
        m15731a.putExtra(AbstractC4362an.f16617s, str2);
        return startServiceSafely(m15731a);
    }

    /* renamed from: a */
    private Map<String, String> m15738a(List<NameValuePair> list) {
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

    /* renamed from: a */
    private void m15742a(Intent intent, String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        intent.putExtra(AbstractC4362an.f16617s, str);
        intent.putExtra(AbstractC4362an.f16620v, str2);
        intent.putExtra(AbstractC4362an.f16624z, str3);
        intent.putExtra(AbstractC4362an.f16582B, str5);
        intent.putExtra(AbstractC4362an.f16581A, str4);
        intent.putExtra(AbstractC4362an.f16583C, z);
        intent.putExtra(AbstractC4362an.f16590J, f16402a);
        intent.putExtra(AbstractC4362an.f16594N, this.f16406a);
        if (map != null && map.size() > 0) {
            String m15736a = m15736a(map);
            if (!TextUtils.isEmpty(m15736a)) {
                intent.putExtra(AbstractC4362an.f16584D, m15736a);
            }
        }
        if (map2 == null || map2.size() <= 0) {
            return;
        }
        String m15736a2 = m15736a(map2);
        if (TextUtils.isEmpty(m15736a2)) {
            return;
        }
        intent.putExtra(AbstractC4362an.f16585E, m15736a2);
    }

    public boolean sendMessage(byte[] bArr, String str, String str2) {
        String str3;
        if (C4092au.m13799a(this.f16405a) && bArr != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Intent m15731a = m15731a();
            if (bArr == null) {
                return false;
            }
            m15731a.setAction(AbstractC4362an.f16603e);
            m15731a.putExtra(AbstractC4362an.f16590J, f16402a);
            m15731a.putExtra("ext_raw_packet", bArr);
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
            m15731a.putExtra(AbstractC4362an.f16617s, substring);
            m15731a.putExtra(AbstractC4362an.f16618t, str4);
            m15731a.putExtra(AbstractC4362an.f16619u, str3);
            StringBuilder sb = new StringBuilder();
            sb.append(f16403b);
            long j2 = f16400a;
            f16400a = 1 + j2;
            sb.append(j2);
            String sb2 = sb.toString();
            m15731a.putExtra("ext_pkt_id", sb2);
            m15731a.putExtra("ext_chid", str2);
            AbstractC4022b.m13363e("SEND: chid=" + str2 + ", packetId=" + sb2);
            return startServiceSafely(m15731a);
        }
        AbstractC4022b.m13347a("Failed to send message: message|userId|chid may be empty, or the network is unavailable.");
        return false;
    }

    /* renamed from: a */
    private String m15736a(Map<String, String> map) {
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

    /* renamed from: a */
    private boolean m15743a() {
        if (C4409x.f16836a) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f16405a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 104;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    private String m15735a() {
        try {
            return this.f16405a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    /* renamed from: a */
    private Intent m15731a() {
        if (isMiuiPushServiceEnabled()) {
            Intent intent = new Intent();
            intent.setPackage("com.xiaomi.xmsf");
            intent.setClassName("com.xiaomi.xmsf", m15735a());
            intent.putExtra(AbstractC4362an.f16586F, this.f16405a.getPackageName());
            m15739a();
            return intent;
        }
        Intent intent2 = new Intent(this.f16405a, (Class<?>) XMPushService.class);
        intent2.putExtra(AbstractC4362an.f16586F, this.f16405a.getPackageName());
        m15745b();
        return intent2;
    }

    /* renamed from: a */
    private void m15739a() {
        this.f16405a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f16405a, (Class<?>) XMPushService.class), 2, 1);
    }

    /* renamed from: a */
    private synchronized void m15741a(Intent intent) {
        if (this.f16410b) {
            Message m15732a = m15732a(intent);
            if (this.f16407a.size() >= 50) {
                this.f16407a.remove(0);
            }
            this.f16407a.add(m15732a);
            return;
        }
        if (this.f16409b == null) {
            this.f16405a.bindService(intent, new ServiceConnection() { // from class: com.xiaomi.push.service.ServiceClient.2
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    synchronized (ServiceClient.this) {
                        ServiceClient.this.f16409b = new Messenger(iBinder);
                        ServiceClient.this.f16410b = false;
                        Iterator it = ServiceClient.this.f16407a.iterator();
                        while (it.hasNext()) {
                            try {
                                ServiceClient.this.f16409b.send((Message) it.next());
                            } catch (RemoteException e2) {
                                AbstractC4022b.m13351a(e2);
                            }
                        }
                        ServiceClient.this.f16407a.clear();
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    ServiceClient.this.f16409b = null;
                    ServiceClient.this.f16410b = false;
                }
            }, 1);
            this.f16410b = true;
            this.f16407a.clear();
            this.f16407a.add(m15732a(intent));
        } else {
            try {
                this.f16409b.send(m15732a(intent));
            } catch (RemoteException unused) {
                this.f16409b = null;
                this.f16410b = false;
            }
        }
    }

    /* renamed from: a */
    private Message m15732a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }
}
