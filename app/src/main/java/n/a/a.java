package n.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import anet.channel.entity.ConnType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: AutoFocusManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class a implements Camera.AutoFocusCallback {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f12812g = 2000;
    private boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f12815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Camera f12816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AsyncTask<?, ?, ?> f12817e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f12811f = a.class.getSimpleName();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Collection<String> f12813h = new ArrayList(2);

    /* JADX INFO: compiled from: AutoFocusManager.java */
    private final class b extends AsyncTask<Object, Object, Object> {
        private b() {
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(a.f12812g);
            } catch (InterruptedException unused) {
            }
            a.this.a();
            return null;
        }
    }

    static {
        f12813h.add(ConnType.PK_AUTO);
        f12813h.add("macro");
    }

    a(Context context, Camera camera) {
        this.f12816d = camera;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String focusMode = camera.getParameters().getFocusMode();
        this.f12815c = defaultSharedPreferences.getBoolean(zxing.android.f.f15168g, true) && f12813h.contains(focusMode);
        String str = "Current focus mode '" + focusMode + "'; use auto focus? " + this.f12815c;
        a();
    }

    @SuppressLint({"NewApi"})
    private synchronized void c() {
        if (!this.a && this.f12817e == null) {
            b bVar = new b();
            try {
                bVar.execute(new Object[0]);
                this.f12817e = bVar;
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    private synchronized void d() {
        if (this.f12817e != null) {
            if (this.f12817e.getStatus() != AsyncTask.Status.FINISHED) {
                this.f12817e.cancel(true);
            }
            this.f12817e = null;
        }
    }

    synchronized void a() {
        if (this.f12815c) {
            this.f12817e = null;
            if (!this.a && !this.f12814b) {
                try {
                    this.f12816d.autoFocus(this);
                    this.f12814b = true;
                } catch (RuntimeException unused) {
                    c();
                }
            }
        }
    }

    synchronized void b() {
        this.a = true;
        if (this.f12815c) {
            d();
            try {
                this.f12816d.cancelAutoFocus();
            } catch (RuntimeException unused) {
            }
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z, Camera camera) {
        this.f12814b = false;
        c();
    }
}
