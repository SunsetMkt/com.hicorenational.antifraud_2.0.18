package ui.view;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: DownTimer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class r {
    private long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f14791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Handler f14794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Runnable f14795f;

    /* JADX INFO: compiled from: DownTimer.java */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                long j2 = r.this.a - (r.this.f14791b * ((long) r.this.f14792c));
                if (j2 <= 0) {
                    r.this.f14792c = 0;
                    r rVar = r.this;
                    rVar.f14794e.removeCallbacks(rVar.f14795f);
                    r.this.d();
                    return;
                }
                r.this.a(j2);
                r.d(r.this);
                r rVar2 = r.this;
                rVar2.f14794e.postDelayed(rVar2.f14795f, rVar2.f14791b);
            }
        }
    }

    public r(long j2, long j3) {
        this.f14793d = false;
        this.f14794e = new a(Looper.getMainLooper());
        this.f14795f = new Runnable() { // from class: ui.view.c
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c();
            }
        };
        this.a = j2;
        this.f14791b = j3;
        this.f14792c = 0;
        this.f14793d = false;
        this.f14794e.post(this.f14795f);
    }

    static /* synthetic */ int d(r rVar) {
        int i2 = rVar.f14792c;
        rVar.f14792c = i2 + 1;
        return i2;
    }

    public abstract void a(long j2);

    public abstract void d();

    public boolean b() {
        return Build.VERSION.SDK_INT >= 29 ? !this.f14794e.hasCallbacks(this.f14795f) : this.f14793d;
    }

    public /* synthetic */ void c() {
        this.f14794e.sendEmptyMessage(1);
    }

    public void a(long j2, long j3) {
        this.a = j2;
        this.f14791b = j3;
        this.f14792c = 0;
        this.f14793d = false;
        this.f14794e.post(this.f14795f);
    }

    public void a() {
        this.f14794e.removeCallbacks(this.f14795f);
        this.f14793d = true;
    }

    public r() {
        this.f14793d = false;
        this.f14794e = new a(Looper.getMainLooper());
        this.f14795f = new Runnable() { // from class: ui.view.c
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c();
            }
        };
    }
}
