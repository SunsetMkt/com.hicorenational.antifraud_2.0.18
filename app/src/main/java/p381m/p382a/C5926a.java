package p381m.p382a;

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
import zxing.android.C7347f;

/* compiled from: AutoFocusManager.java */
/* renamed from: m.a.a */
/* loaded from: classes2.dex */
final class C5926a implements Camera.AutoFocusCallback {

    /* renamed from: g */
    private static final long f21366g = 2000;

    /* renamed from: a */
    private boolean f21368a;

    /* renamed from: b */
    private boolean f21369b;

    /* renamed from: c */
    private final boolean f21370c;

    /* renamed from: d */
    private final Camera f21371d;

    /* renamed from: e */
    private AsyncTask<?, ?, ?> f21372e;

    /* renamed from: f */
    private static final String f21365f = C5926a.class.getSimpleName();

    /* renamed from: h */
    private static final Collection<String> f21367h = new ArrayList(2);

    /* compiled from: AutoFocusManager.java */
    /* renamed from: m.a.a$b */
    private final class b extends AsyncTask<Object, Object, Object> {
        private b() {
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(C5926a.f21366g);
            } catch (InterruptedException unused) {
            }
            C5926a.this.m24875a();
            return null;
        }
    }

    static {
        f21367h.add(ConnType.PK_AUTO);
        f21367h.add("macro");
    }

    C5926a(Context context, Camera camera) {
        this.f21371d = camera;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String focusMode = camera.getParameters().getFocusMode();
        this.f21370c = defaultSharedPreferences.getBoolean(C7347f.f25865g, true) && f21367h.contains(focusMode);
        String str = "Current focus mode '" + focusMode + "'; use auto focus? " + this.f21370c;
        m24875a();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    private synchronized void m24873c() {
        if (!this.f21368a && this.f21372e == null) {
            b bVar = new b();
            try {
                bVar.execute(new Object[0]);
                this.f21372e = bVar;
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    /* renamed from: d */
    private synchronized void m24874d() {
        if (this.f21372e != null) {
            if (this.f21372e.getStatus() != AsyncTask.Status.FINISHED) {
                this.f21372e.cancel(true);
            }
            this.f21372e = null;
        }
    }

    /* renamed from: a */
    synchronized void m24875a() {
        if (this.f21370c) {
            this.f21372e = null;
            if (!this.f21368a && !this.f21369b) {
                try {
                    this.f21371d.autoFocus(this);
                    this.f21369b = true;
                } catch (RuntimeException unused) {
                    m24873c();
                }
            }
        }
    }

    /* renamed from: b */
    synchronized void m24876b() {
        this.f21368a = true;
        if (this.f21370c) {
            m24874d();
            try {
                this.f21371d.cancelAutoFocus();
            } catch (RuntimeException unused) {
            }
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z, Camera camera) {
        this.f21369b = false;
        m24873c();
    }
}
