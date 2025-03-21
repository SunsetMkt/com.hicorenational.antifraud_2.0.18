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
import com.hicorenational.antifraud.C2113R;
import manager.FloatingWindow;
import manager.IFloatingWindow;
import manager.NotificationHelper;
import p000a.p001a.p014u.C0052a;
import util.C7301n1;

/* loaded from: classes.dex */
public class WarnGuidService extends Service {

    /* renamed from: w */
    public static final String f6337w = "extra_warn_guide_content";

    /* renamed from: x */
    public static int f6338x = 1;

    /* renamed from: a */
    TextView f6339a;

    /* renamed from: b */
    TextView f6340b;

    /* renamed from: c */
    ImageView f6341c;

    /* renamed from: d */
    View f6342d;

    /* renamed from: e */
    View f6343e;

    /* renamed from: f */
    TextView f6344f;

    /* renamed from: g */
    View f6345g;

    /* renamed from: h */
    IFloatingWindow f6346h;

    /* renamed from: i */
    WindowManager.LayoutParams f6347i;

    /* renamed from: j */
    private WindowManager f6348j;

    /* renamed from: k */
    private float f6349k;

    /* renamed from: l */
    private float f6350l;

    /* renamed from: m */
    private float f6351m;

    /* renamed from: n */
    private float f6352n;

    /* renamed from: o */
    private float f6353o;

    /* renamed from: p */
    private float f6354p;

    /* renamed from: q */
    private int f6355q;

    /* renamed from: r */
    private int f6356r;

    /* renamed from: s */
    private NotificationManager f6357s;

    /* renamed from: t */
    private String f6358t = "appid";

    /* renamed from: u */
    private String f6359u = NotificationHelper.CHANEL_NAME;

    /* renamed from: v */
    private View.OnTouchListener f6360v = new ViewOnTouchListenerC2120a();

    /* renamed from: com.hicorenational.antifraud.service.WarnGuidService$a */
    class ViewOnTouchListenerC2120a implements View.OnTouchListener {
        ViewOnTouchListenerC2120a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
        
            if (r3 != 3) goto L13;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r3, android.view.MotionEvent r4) {
            /*
                r2 = this;
                int r3 = r4.getAction()
                r0 = 1
                if (r3 == 0) goto L1c
                if (r3 == r0) goto L16
                r1 = 2
                if (r3 == r1) goto L10
                r4 = 3
                if (r3 == r4) goto L16
                goto L21
            L10:
                com.hicorenational.antifraud.service.WarnGuidService r3 = com.hicorenational.antifraud.service.WarnGuidService.this
                com.hicorenational.antifraud.service.WarnGuidService.m5968b(r3, r4)
                goto L21
            L16:
                com.hicorenational.antifraud.service.WarnGuidService r3 = com.hicorenational.antifraud.service.WarnGuidService.this
                com.hicorenational.antifraud.service.WarnGuidService.m5963a(r3)
                goto L21
            L1c:
                com.hicorenational.antifraud.service.WarnGuidService r3 = com.hicorenational.antifraud.service.WarnGuidService.this
                com.hicorenational.antifraud.service.WarnGuidService.m5964a(r3, r4)
            L21:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hicorenational.antifraud.service.WarnGuidService.ViewOnTouchListenerC2120a.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    /* renamed from: com.hicorenational.antifraud.service.WarnGuidService$b */
    public class BinderC2121b extends Binder {
        public BinderC2121b() {
        }

        /* renamed from: a */
        public WarnGuidService m5975a() {
            return WarnGuidService.this;
        }
    }

    /* renamed from: c */
    private Notification m5969c() {
        Notification.Builder contentText = new Notification.Builder(this).setSmallIcon(C2113R.mipmap.logo).setContentTitle(NotificationHelper.CHANEL_NAME).setContentText("打击防范网络诈骗");
        if (Build.VERSION.SDK_INT < 26) {
            return contentText.build();
        }
        this.f6357s.createNotificationChannel(new NotificationChannel(this.f6358t, this.f6359u, 4));
        return new Notification.Builder(getApplicationContext(), this.f6358t).build();
    }

    /* renamed from: d */
    private void m5970d() {
        if (Build.VERSION.SDK_INT >= 18) {
            startForeground(f6338x, m5969c());
        } else {
            startForeground(f6338x, new Notification());
        }
    }

    /* renamed from: e */
    private void m5971e() {
        try {
            this.f6348j.updateViewLayout(this.f6345g, this.f6347i);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        C7301n1.m26459c(C0052a.f162n, "WarnGuidService-----------------------onBind");
        return new BinderC2121b();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f6348j = (WindowManager) getSystemService("window");
        this.f6357s = (NotificationManager) getSystemService("notification");
        m5970d();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C7301n1.m26459c(C0052a.f162n, "服务onDestroy-----------------------    ");
        IFloatingWindow iFloatingWindow = this.f6346h;
        if (iFloatingWindow != null) {
            iFloatingWindow.removeAll();
            this.f6346h.dismiss();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        String str;
        try {
            str = intent.getStringExtra(f6337w);
        } catch (Exception e2) {
            e2.printStackTrace();
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = "请进入相应设置";
        }
        m5965a(str);
        return super.onStartCommand(intent, i2, i3);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        C7301n1.m26459c(C0052a.f162n, "WarnGuidService-----------------------onUnbind");
        return super.onUnbind(intent);
    }

    /* renamed from: b */
    public /* synthetic */ void m5973b(View view) {
        this.f6342d.setVisibility(0);
        this.f6343e.setVisibility(8);
    }

    /* renamed from: a */
    private void m5965a(String str) {
        this.f6346h = new FloatingWindow(this);
        this.f6347i = this.f6346h.getWarnGuideLayoutParams();
        this.f6346h.setParams(this.f6347i);
        this.f6345g = LayoutInflater.from(this).inflate(C2113R.layout.layout_warn_guide, (ViewGroup) null);
        this.f6342d = this.f6345g.findViewById(C2113R.id.layout_open);
        this.f6343e = this.f6345g.findViewById(C2113R.id.layout_close);
        this.f6339a = (TextView) this.f6345g.findViewById(C2113R.id.tv_scale_open);
        this.f6340b = (TextView) this.f6345g.findViewById(C2113R.id.tv_scale_close);
        this.f6341c = (ImageView) this.f6345g.findViewById(C2113R.id.iv_close);
        this.f6344f = (TextView) this.f6345g.findViewById(C2113R.id.tv_guide);
        if (!TextUtils.isEmpty(str)) {
            this.f6344f.setText(str);
        }
        this.f6345g.setOnTouchListener(this.f6360v);
        this.f6355q = this.f6348j.getDefaultDisplay().getWidth();
        this.f6356r = this.f6348j.getDefaultDisplay().getHeight();
        this.f6340b.setOnClickListener(new View.OnClickListener() { // from class: com.hicorenational.antifraud.service.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WarnGuidService.this.m5972a(view);
            }
        });
        this.f6339a.setOnClickListener(new View.OnClickListener() { // from class: com.hicorenational.antifraud.service.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WarnGuidService.this.m5973b(view);
            }
        });
        this.f6341c.setOnClickListener(new View.OnClickListener() { // from class: com.hicorenational.antifraud.service.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WarnGuidService.this.m5974c(view);
            }
        });
        this.f6346h.setContentView(this.f6345g);
        this.f6346h.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m5967b(MotionEvent motionEvent) {
        this.f6349k = motionEvent.getRawX();
        this.f6350l = motionEvent.getRawY();
        String str = "mXInView====" + this.f6353o;
        String str2 = "mXInScreen====" + this.f6349k;
        WindowManager.LayoutParams layoutParams = this.f6347i;
        layoutParams.x = (int) this.f6349k;
        layoutParams.y = ((int) (this.f6350l - this.f6354p)) - (this.f6345g.getHeight() / 2);
        m5971e();
    }

    /* renamed from: c */
    public /* synthetic */ void m5974c(View view) {
        this.f6346h.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m5966b() {
        m5961a();
    }

    /* renamed from: a */
    public /* synthetic */ void m5972a(View view) {
        this.f6342d.setVisibility(8);
        this.f6343e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5962a(MotionEvent motionEvent) {
        this.f6353o = motionEvent.getX();
        this.f6354p = motionEvent.getY();
        this.f6351m = motionEvent.getRawX();
        this.f6352n = motionEvent.getRawY();
        this.f6349k = motionEvent.getRawX();
        this.f6350l = motionEvent.getRawY();
    }

    /* renamed from: a */
    private void m5961a() {
        String str = "wmParams.x ====" + this.f6347i.x;
        String str2 = "mScreenWidth====" + this.f6355q;
        int i2 = this.f6347i.x;
        if (i2 > 0 && i2 < this.f6355q) {
            m5971e();
            return;
        }
        if (Math.abs(this.f6347i.x) < 0) {
            this.f6347i.x = 0;
        } else {
            int abs = Math.abs(this.f6347i.x);
            int i3 = this.f6355q;
            if (abs > i3) {
                this.f6347i.x = i3;
            }
        }
        m5971e();
    }
}
