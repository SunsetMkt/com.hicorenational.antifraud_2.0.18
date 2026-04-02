package com.hicorenational.antifraud.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.hicorenational.antifraud.R;
import manager.FloatingWindow;
import manager.IFloatingWindow;
import manager.NotificationHelper;
import util.s1;

/* JADX INFO: loaded from: classes.dex */
public class WarnGuidService extends Service {
    public static final String w = "extra_warn_guide_content";
    public static int x = 1;
    TextView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    TextView f4000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ImageView f4001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    View f4002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    View f4003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    TextView f4004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    View f4005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    IFloatingWindow f4006h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    WindowManager.LayoutParams f4007i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private WindowManager f4008j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f4009k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f4010l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f4011m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f4012n;
    private float o;
    private float p;
    private int q;
    private int r;
    private NotificationManager s;
    private String t = "appid";
    private String u = NotificationHelper.CHANEL_NAME;
    private View.OnTouchListener v = new a();

    class a implements View.OnTouchListener {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0016  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                WarnGuidService.this.a(motionEvent);
            } else if (action == 1) {
                WarnGuidService.this.b();
            } else if (action == 2) {
                WarnGuidService.this.b(motionEvent);
            } else if (action == 3) {
            }
            return true;
        }
    }

    public class b extends Binder {
        public b() {
        }

        public WarnGuidService a() {
            return WarnGuidService.this;
        }
    }

    private Notification c() {
        Notification.Builder contentText = new Notification.Builder(this).setSmallIcon(R.mipmap.logo).setContentTitle(NotificationHelper.CHANEL_NAME).setContentText("\u6253\u51fb\u9632\u8303\u7f51\u7edc\u8bc8\u9a97");
        if (Build.VERSION.SDK_INT < 26) {
            return contentText.build();
        }
        this.s.createNotificationChannel(new NotificationChannel(this.t, this.u, 4));
        return new Notification.Builder(getApplicationContext(), this.t).build();
    }

    private void d() {
        if (Build.VERSION.SDK_INT >= 18) {
            startForeground(x, c());
        } else {
            startForeground(x, new Notification());
        }
    }

    private void e() {
        try {
            this.f4008j.updateViewLayout(this.f4005g, this.f4007i);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        s1.c(b.a.u.a.f1912n, "WarnGuidService-----------------------onBind");
        return new b();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f4008j = (WindowManager) getSystemService("window");
        this.s = (NotificationManager) getSystemService("notification");
        d();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        s1.c(b.a.u.a.f1912n, "\u670d\u52a1onDestroy-----------------------    ");
        IFloatingWindow iFloatingWindow = this.f4006h;
        if (iFloatingWindow != null) {
            iFloatingWindow.removeAll();
            this.f4006h.dismiss();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        String stringExtra;
        try {
            stringExtra = intent.getStringExtra(w);
        } catch (Exception e2) {
            e2.printStackTrace();
            stringExtra = "";
        }
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "\u8bf7\u8fdb\u5165\u76f8\u5e94\u8bbe\u7f6e";
        }
        a(stringExtra);
        return super.onStartCommand(intent, i2, i3);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        s1.c(b.a.u.a.f1912n, "WarnGuidService-----------------------onUnbind");
        return super.onUnbind(intent);
    }

    public /* synthetic */ void b(View view) {
        this.f4002d.setVisibility(0);
        this.f4003e.setVisibility(8);
    }

    private void a(String str) {
        this.f4006h = new FloatingWindow(this);
        this.f4007i = this.f4006h.getWarnGuideLayoutParams();
        this.f4006h.setParams(this.f4007i);
        this.f4005g = LayoutInflater.from(this).inflate(R.layout.layout_warn_guide, (ViewGroup) null);
        this.f4002d = this.f4005g.findViewById(R.id.layout_open);
        this.f4003e = this.f4005g.findViewById(R.id.layout_close);
        this.a = (TextView) this.f4005g.findViewById(R.id.tv_scale_open);
        this.f4000b = (TextView) this.f4005g.findViewById(R.id.tv_scale_close);
        this.f4001c = (ImageView) this.f4005g.findViewById(R.id.iv_close);
        this.f4004f = (TextView) this.f4005g.findViewById(R.id.tv_guide);
        if (!TextUtils.isEmpty(str)) {
            this.f4004f.setText(str);
        }
        this.f4005g.setOnTouchListener(this.v);
        this.q = this.f4008j.getDefaultDisplay().getWidth();
        this.r = this.f4008j.getDefaultDisplay().getHeight();
        this.f4000b.setOnClickListener(new View.OnClickListener() { // from class: com.hicorenational.antifraud.service.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.a(view);
            }
        });
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.hicorenational.antifraud.service.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.b(view);
            }
        });
        this.f4001c.setOnClickListener(new View.OnClickListener() { // from class: com.hicorenational.antifraud.service.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.c(view);
            }
        });
        this.f4006h.setContentView(this.f4005g);
        this.f4006h.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MotionEvent motionEvent) {
        this.f4009k = motionEvent.getRawX();
        this.f4010l = motionEvent.getRawY();
        String str = "mXInView====" + this.o;
        String str2 = "mXInScreen====" + this.f4009k;
        WindowManager.LayoutParams layoutParams = this.f4007i;
        layoutParams.x = (int) this.f4009k;
        layoutParams.y = ((int) (this.f4010l - this.p)) - (this.f4005g.getHeight() / 2);
        e();
    }

    public /* synthetic */ void c(View view) {
        this.f4006h.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        a();
    }

    public /* synthetic */ void a(View view) {
        this.f4002d.setVisibility(8);
        this.f4003e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MotionEvent motionEvent) {
        this.o = motionEvent.getX();
        this.p = motionEvent.getY();
        this.f4011m = motionEvent.getRawX();
        this.f4012n = motionEvent.getRawY();
        this.f4009k = motionEvent.getRawX();
        this.f4010l = motionEvent.getRawY();
    }

    private void a() {
        String str = "wmParams.x ====" + this.f4007i.x;
        String str2 = "mScreenWidth====" + this.q;
        int i2 = this.f4007i.x;
        if (i2 > 0 && i2 < this.q) {
            e();
            return;
        }
        if (Math.abs(this.f4007i.x) < 0) {
            this.f4007i.x = 0;
        } else {
            int iAbs = Math.abs(this.f4007i.x);
            int i3 = this.q;
            if (iAbs > i3) {
                this.f4007i.x = i3;
            }
        }
        e();
    }
}
