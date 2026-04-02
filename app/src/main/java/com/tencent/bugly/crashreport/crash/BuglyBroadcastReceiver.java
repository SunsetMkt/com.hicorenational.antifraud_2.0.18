package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class BuglyBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: d */
    private static BuglyBroadcastReceiver f6211d;

    /* JADX INFO: renamed from: b */
    private Context f6212b;

    /* JADX INFO: renamed from: c */
    private String f6213c;

    /* JADX INFO: renamed from: e */
    private boolean f6214e = true;
    private IntentFilter a = new IntentFilter();

    /* JADX INFO: renamed from: com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver$1 */
    /* JADX INFO: compiled from: BUGLY */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ BuglyBroadcastReceiver a;

        AnonymousClass1(BuglyBroadcastReceiver buglyBroadcastReceiver) {
            buglyBroadcastReceiver = buglyBroadcastReceiver;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                an.a(BuglyBroadcastReceiver.f6211d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                synchronized (buglyBroadcastReceiver) {
                    BuglyBroadcastReceiver.this.f6212b.registerReceiver(BuglyBroadcastReceiver.f6211d, BuglyBroadcastReceiver.this.a);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static synchronized BuglyBroadcastReceiver getInstance() {
        if (f6211d == null) {
            f6211d = new BuglyBroadcastReceiver();
        }
        return f6211d;
    }

    public synchronized void addFilter(String str) {
        if (!this.a.hasAction(str)) {
            this.a.addAction(str);
        }
        an.c("add action %s", str);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            if (an.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public synchronized void register(Context context) {
        this.f6212b = context;
        aq.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.1
            final /* synthetic */ BuglyBroadcastReceiver a;

            AnonymousClass1(BuglyBroadcastReceiver this) {
                buglyBroadcastReceiver = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    an.a(BuglyBroadcastReceiver.f6211d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                    synchronized (buglyBroadcastReceiver) {
                        BuglyBroadcastReceiver.this.f6212b.registerReceiver(BuglyBroadcastReceiver.f6211d, BuglyBroadcastReceiver.this.a);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public synchronized void unregister(Context context) {
        try {
            an.a(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.f6212b = context;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
        }
    }

    protected final synchronized boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f6214e) {
                    this.f6214e = false;
                    return true;
                }
                String strF = com.tencent.bugly.crashreport.common.info.b.f(this.f6212b);
                an.c("is Connect BC " + strF, new Object[0]);
                an.a("network %s changed to %s", "" + this.f6213c, "" + strF);
                if (strF == null) {
                    this.f6213c = null;
                    return true;
                }
                String str = this.f6213c;
                this.f6213c = strF;
                long jCurrentTimeMillis = System.currentTimeMillis();
                com.tencent.bugly.crashreport.common.strategy.a aVarA = com.tencent.bugly.crashreport.common.strategy.a.a();
                ak akVarA = ak.a();
                com.tencent.bugly.crashreport.common.info.a aVarA2 = com.tencent.bugly.crashreport.common.info.a.a(context);
                if (aVarA != null && akVarA != null && aVarA2 != null) {
                    if (!strF.equals(str)) {
                        if (jCurrentTimeMillis - akVarA.a(c.a) > 30000) {
                            an.a("try to upload crash on network changed.", new Object[0]);
                            c cVarA = c.a();
                            if (cVarA != null) {
                                cVarA.a(0L);
                            }
                        }
                        if (jCurrentTimeMillis - akVarA.a(1001) > 30000) {
                            an.a("try to upload userinfo on network changed.", new Object[0]);
                            com.tencent.bugly.crashreport.biz.b.f6156b.b();
                        }
                    }
                    return true;
                }
                an.d("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }
}
