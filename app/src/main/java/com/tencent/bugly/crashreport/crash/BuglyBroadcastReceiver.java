package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.crashreport.biz.C3111b;
import com.tencent.bugly.crashreport.common.info.C3113a;
import com.tencent.bugly.crashreport.common.info.C3114b;
import com.tencent.bugly.crashreport.common.strategy.C3116a;
import com.tencent.bugly.proguard.C3148ak;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3154aq;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class BuglyBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: d */
    private static BuglyBroadcastReceiver f10259d;

    /* renamed from: b */
    private Context f10261b;

    /* renamed from: c */
    private String f10262c;

    /* renamed from: e */
    private boolean f10263e = true;

    /* renamed from: a */
    private IntentFilter f10260a = new IntentFilter();

    public static synchronized BuglyBroadcastReceiver getInstance() {
        BuglyBroadcastReceiver buglyBroadcastReceiver;
        synchronized (BuglyBroadcastReceiver.class) {
            if (f10259d == null) {
                f10259d = new BuglyBroadcastReceiver();
            }
            buglyBroadcastReceiver = f10259d;
        }
        return buglyBroadcastReceiver;
    }

    public synchronized void addFilter(String str) {
        if (!this.f10260a.hasAction(str)) {
            this.f10260a.addAction(str);
        }
        C3151an.m9921c("add action %s", str);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            m9649a(context, intent);
        } catch (Throwable th) {
            if (C3151an.m9916a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public synchronized void register(Context context) {
        this.f10261b = context;
        C3154aq.m9969a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C3151an.m9914a(BuglyBroadcastReceiver.f10259d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                    synchronized (this) {
                        BuglyBroadcastReceiver.this.f10261b.registerReceiver(BuglyBroadcastReceiver.f10259d, BuglyBroadcastReceiver.this.f10260a);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public synchronized void unregister(Context context) {
        try {
            C3151an.m9914a(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.f10261b = context;
        } catch (Throwable th) {
            if (!C3151an.m9916a(th)) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    protected final synchronized boolean m9649a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f10263e) {
                    this.f10263e = false;
                    return true;
                }
                String m9606f = C3114b.m9606f(this.f10261b);
                C3151an.m9921c("is Connect BC " + m9606f, new Object[0]);
                C3151an.m9915a("network %s changed to %s", "" + this.f10262c, "" + m9606f);
                if (m9606f == null) {
                    this.f10262c = null;
                    return true;
                }
                String str = this.f10262c;
                this.f10262c = m9606f;
                long currentTimeMillis = System.currentTimeMillis();
                C3116a m9635a = C3116a.m9635a();
                C3148ak m9863a = C3148ak.m9863a();
                C3113a m9531a = C3113a.m9531a(context);
                if (m9635a != null && m9863a != null && m9531a != null) {
                    if (!m9606f.equals(str)) {
                        if (currentTimeMillis - m9863a.m9882a(C3127c.f10360a) > 30000) {
                            C3151an.m9915a("try to upload crash on network changed.", new Object[0]);
                            C3127c m9705a = C3127c.m9705a();
                            if (m9705a != null) {
                                m9705a.m9710a(0L);
                            }
                        }
                        if (currentTimeMillis - m9863a.m9882a(1001) > 30000) {
                            C3151an.m9915a("try to upload userinfo on network changed.", new Object[0]);
                            C3111b.f10113b.m9486b();
                        }
                    }
                    return true;
                }
                C3151an.m9922d("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }
}
