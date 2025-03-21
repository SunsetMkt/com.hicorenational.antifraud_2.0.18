package zxing.android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;

/* compiled from: InactivityTimer.java */
/* renamed from: zxing.android.c */
/* loaded from: classes2.dex */
public final class C7344c {

    /* renamed from: e */
    private static final String f25813e = "c";

    /* renamed from: f */
    private static final long f25814f = 300000;

    /* renamed from: a */
    private final Activity f25815a;

    /* renamed from: b */
    private final BroadcastReceiver f25816b = new c();

    /* renamed from: c */
    private boolean f25817c = false;

    /* renamed from: d */
    private AsyncTask<Object, Object, Object> f25818d;

    /* compiled from: InactivityTimer.java */
    /* renamed from: zxing.android.c$b */
    private final class b extends AsyncTask<Object, Object, Object> {
        private b() {
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(300000L);
                String unused = C7344c.f25813e;
                C7344c.this.f25815a.finish();
                return null;
            } catch (InterruptedException unused2) {
                return null;
            }
        }
    }

    /* compiled from: InactivityTimer.java */
    /* renamed from: zxing.android.c$c */
    private final class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                if (intent.getIntExtra("plugged", -1) <= 0) {
                    C7344c.this.m26831a();
                } else {
                    C7344c.this.m26830f();
                }
            }
        }
    }

    public C7344c(Activity activity) {
        this.f25815a = activity;
        m26831a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public synchronized void m26830f() {
        AsyncTask<Object, Object, Object> asyncTask = this.f25818d;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.f25818d = null;
        }
    }

    /* renamed from: c */
    public synchronized void m26833c() {
        if (!this.f25817c) {
            this.f25815a.registerReceiver(this.f25816b, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.f25817c = true;
        }
        m26831a();
    }

    /* renamed from: d */
    public void m26834d() {
        m26830f();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public synchronized void m26831a() {
        m26830f();
        this.f25818d = new b();
        this.f25818d.execute(new Object[0]);
    }

    /* renamed from: b */
    public synchronized void m26832b() {
        m26830f();
        if (this.f25817c) {
            this.f25815a.unregisterReceiver(this.f25816b);
            this.f25817c = false;
        }
    }
}
