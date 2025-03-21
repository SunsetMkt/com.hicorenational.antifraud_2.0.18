package p388ui.view;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: DownTimer.java */
/* renamed from: ui.view.p */
/* loaded from: classes2.dex */
public abstract class AbstractC7237p {

    /* renamed from: a */
    private long f24941a;

    /* renamed from: b */
    private long f24942b;

    /* renamed from: c */
    private int f24943c;

    /* renamed from: d */
    private boolean f24944d;

    /* renamed from: e */
    Handler f24945e;

    /* renamed from: f */
    Runnable f24946f;

    /* compiled from: DownTimer.java */
    /* renamed from: ui.view.p$a */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                long j2 = AbstractC7237p.this.f24941a - (AbstractC7237p.this.f24942b * AbstractC7237p.this.f24943c);
                if (j2 <= 0) {
                    AbstractC7237p.this.f24943c = 0;
                    AbstractC7237p abstractC7237p = AbstractC7237p.this;
                    abstractC7237p.f24945e.removeCallbacks(abstractC7237p.f24946f);
                    AbstractC7237p.this.mo25434d();
                    return;
                }
                AbstractC7237p.this.mo25433a(j2);
                AbstractC7237p.m26010d(AbstractC7237p.this);
                AbstractC7237p abstractC7237p2 = AbstractC7237p.this;
                abstractC7237p2.f24945e.postDelayed(abstractC7237p2.f24946f, abstractC7237p2.f24942b);
            }
        }
    }

    public AbstractC7237p(long j2, long j3) {
        this.f24944d = false;
        this.f24945e = new a(Looper.getMainLooper());
        this.f24946f = new Runnable() { // from class: ui.view.c
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC7237p.this.m26014c();
            }
        };
        this.f24941a = j2;
        this.f24942b = j3;
        this.f24943c = 0;
        this.f24944d = false;
        this.f24945e.post(this.f24946f);
    }

    /* renamed from: d */
    static /* synthetic */ int m26010d(AbstractC7237p abstractC7237p) {
        int i2 = abstractC7237p.f24943c;
        abstractC7237p.f24943c = i2 + 1;
        return i2;
    }

    /* renamed from: a */
    public abstract void mo25433a(long j2);

    /* renamed from: d */
    public abstract void mo25434d();

    /* renamed from: b */
    public boolean m26013b() {
        return Build.VERSION.SDK_INT >= 29 ? !this.f24945e.hasCallbacks(this.f24946f) : this.f24944d;
    }

    /* renamed from: c */
    public /* synthetic */ void m26014c() {
        this.f24945e.sendEmptyMessage(1);
    }

    /* renamed from: a */
    public void m26012a(long j2, long j3) {
        this.f24941a = j2;
        this.f24942b = j3;
        this.f24943c = 0;
        this.f24944d = false;
        this.f24945e.post(this.f24946f);
    }

    /* renamed from: a */
    public void m26011a() {
        this.f24945e.removeCallbacks(this.f24946f);
        this.f24944d = true;
    }

    public AbstractC7237p() {
        this.f24944d = false;
        this.f24945e = new a(Looper.getMainLooper());
        this.f24946f = new Runnable() { // from class: ui.view.c
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC7237p.this.m26014c();
            }
        };
    }
}
