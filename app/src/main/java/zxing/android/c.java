package zxing.android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;

/* JADX INFO: compiled from: InactivityTimer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: e */
    private static final String f15136e = "c";

    /* JADX INFO: renamed from: f */
    private static final long f15137f = 300000;
    private final Activity a;

    /* JADX INFO: renamed from: b */
    private final BroadcastReceiver f15138b = new C0329c();

    /* JADX INFO: renamed from: c */
    private boolean f15139c = false;

    /* JADX INFO: renamed from: d */
    private AsyncTask<Object, Object, Object> f15140d;

    /* JADX INFO: compiled from: InactivityTimer.java */
    private final class b extends AsyncTask<Object, Object, Object> {
        private b() {
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(300000L);
                String unused = c.f15136e;
                c.this.a.finish();
                return null;
            } catch (InterruptedException unused2) {
                return null;
            }
        }

        /* synthetic */ b(c cVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: zxing.android.c$c */
    /* JADX INFO: compiled from: InactivityTimer.java */
    private final class C0329c extends BroadcastReceiver {
        private C0329c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                if (intent.getIntExtra("plugged", -1) <= 0) {
                    c.this.a();
                } else {
                    c.this.f();
                }
            }
        }

        /* synthetic */ C0329c(c cVar, a aVar) {
            this();
        }
    }

    public c(Activity activity) {
        this.a = activity;
        a();
    }

    public synchronized void f() {
        AsyncTask<Object, Object, Object> asyncTask = this.f15140d;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.f15140d = null;
        }
    }

    public synchronized void c() {
        if (!this.f15139c) {
            this.a.registerReceiver(this.f15138b, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.f15139c = true;
        }
        a();
    }

    public void d() {
        f();
    }

    @SuppressLint({"NewApi"})
    public synchronized void a() {
        f();
        this.f15140d = new b();
        this.f15140d.execute(new Object[0]);
    }

    public synchronized void b() {
        f();
        if (this.f15139c) {
            this.a.unregisterReceiver(this.f15138b);
            this.f15139c = false;
        }
    }
}
