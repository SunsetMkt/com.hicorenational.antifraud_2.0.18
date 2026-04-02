package com.umeng.message.inapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.proguard.ad;
import com.umeng.message.proguard.af;
import com.umeng.message.proguard.ah;
import com.umeng.message.proguard.ai;
import com.umeng.message.proguard.bb;
import com.umeng.message.proguard.f;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class UmengSplashMessageActivity extends Activity {
    private static final String a = UmengSplashMessageActivity.class.getName();
    private static int s = 2000;
    private static int t = 1000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Activity f7925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private af f7926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ImageView f7927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ImageView f7928e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f7929f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f7932i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a f7933j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private UInAppMessage f7934k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private UInAppHandler f7935l;
    private long q;
    private long r;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f7930g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f7931h = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f7936m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f7937n = false;
    private boolean o = false;
    private boolean p = false;
    private af.a u = new af.a() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1
        @Override // com.umeng.message.proguard.af.a
        public final void a(Bitmap[] bitmapArr) {
            if (UmengSplashMessageActivity.this.c()) {
                return;
            }
            if (UmengSplashMessageActivity.this.f7932i != null) {
                UmengSplashMessageActivity.this.f7932i.a();
                UmengSplashMessageActivity.c(UmengSplashMessageActivity.this);
            }
            try {
                if (bitmapArr.length == 1) {
                    UmengSplashMessageActivity.this.f7927d.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1.1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            UmengSplashMessageActivity.d(UmengSplashMessageActivity.this);
                            if (TextUtils.equals("none", UmengSplashMessageActivity.this.f7934k.action_type)) {
                                return;
                            }
                            UmengSplashMessageActivity.a(UmengSplashMessageActivity.this, SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.q);
                            ai.a(UmengSplashMessageActivity.this.f7925b).a(UmengSplashMessageActivity.this.f7934k.msg_id, UmengSplashMessageActivity.this.f7934k.msg_type, 1, 1, 0, 0, 0, (int) UmengSplashMessageActivity.this.r, 0);
                            UmengSplashMessageActivity.this.d();
                            UmengSplashMessageActivity.this.f7935l.handleInAppMessage(UmengSplashMessageActivity.this.f7925b, UmengSplashMessageActivity.this.f7934k, 16);
                            UmengSplashMessageActivity.this.finish();
                        }
                    });
                    UmengSplashMessageActivity.this.f7928e.setVisibility(8);
                    UmengSplashMessageActivity.this.f7927d.setImageBitmap(bitmapArr[0]);
                    UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f7927d);
                }
                if (bitmapArr.length == 2) {
                    UmengSplashMessageActivity.this.f7927d.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1.2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            UmengSplashMessageActivity.m(UmengSplashMessageActivity.this);
                            if (TextUtils.equals("none", UmengSplashMessageActivity.this.f7934k.action_type)) {
                                return;
                            }
                            UmengSplashMessageActivity.a(UmengSplashMessageActivity.this, SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.q);
                            ai.a(UmengSplashMessageActivity.this.f7925b).a(UmengSplashMessageActivity.this.f7934k.msg_id, UmengSplashMessageActivity.this.f7934k.msg_type, 1, 0, 1, UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.o), 0, (int) UmengSplashMessageActivity.this.r, 0);
                            UmengSplashMessageActivity.this.d();
                            UmengSplashMessageActivity.this.f7935l.handleInAppMessage(UmengSplashMessageActivity.this.f7925b, UmengSplashMessageActivity.this.f7934k, 16);
                            UmengSplashMessageActivity.this.finish();
                        }
                    });
                    UmengSplashMessageActivity.this.f7928e.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1.3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            UmengSplashMessageActivity.o(UmengSplashMessageActivity.this);
                            if (TextUtils.equals("none", UmengSplashMessageActivity.this.f7934k.bottom_action_type)) {
                                return;
                            }
                            UmengSplashMessageActivity.a(UmengSplashMessageActivity.this, SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.q);
                            ai.a(UmengSplashMessageActivity.this.f7925b).a(UmengSplashMessageActivity.this.f7934k.msg_id, UmengSplashMessageActivity.this.f7934k.msg_type, 1, 0, UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f7937n), 1, 0, (int) UmengSplashMessageActivity.this.r, 0);
                            UmengSplashMessageActivity.this.d();
                            UmengSplashMessageActivity.this.f7935l.handleInAppMessage(UmengSplashMessageActivity.this.f7925b, UmengSplashMessageActivity.this.f7934k, 17);
                            UmengSplashMessageActivity.this.finish();
                        }
                    });
                    UmengSplashMessageActivity.this.f7927d.setImageBitmap(bitmapArr[0]);
                    UmengSplashMessageActivity.this.f7928e.setImageBitmap(bitmapArr[1]);
                    UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f7927d);
                    UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f7928e);
                }
                UmengSplashMessageActivity.this.q = SystemClock.elapsedRealtime();
                if (UmengSplashMessageActivity.this.f7934k.display_button) {
                    UmengSplashMessageActivity.this.f7929f.setVisibility(0);
                    UmengSplashMessageActivity.this.f7929f.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1.4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            UmengSplashMessageActivity.a(UmengSplashMessageActivity.this, SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.q);
                            ai.a(UmengSplashMessageActivity.this.f7925b).a(UmengSplashMessageActivity.this.f7934k.msg_id, UmengSplashMessageActivity.this.f7934k.msg_type, 1, UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f7936m), UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f7937n), UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.o), 1, (int) UmengSplashMessageActivity.this.r, 0);
                            UmengSplashMessageActivity.this.d();
                            UmengSplashMessageActivity.this.finish();
                        }
                    });
                } else {
                    UmengSplashMessageActivity.this.f7929f.setVisibility(8);
                }
                InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f7925b).a(UmengSplashMessageActivity.this.f7934k);
                InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f7925b).a(UmengSplashMessageActivity.this.f7934k.msg_id, 1);
                InAppMessageManager inAppMessageManager = InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f7925b);
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                inAppMessageManager.b("KEY_LAST_SHOW_SPLASH_TS", sb.toString());
                UmengSplashMessageActivity.s(UmengSplashMessageActivity.this);
                UmengSplashMessageActivity.this.f7933j = UmengSplashMessageActivity.this.new a(UmengSplashMessageActivity.this.f7934k.display_time * 1000, UmengSplashMessageActivity.t);
                UmengSplashMessageActivity.this.f7933j.b();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    };
    private final ad v = new ad() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.2
        @Override // com.umeng.message.proguard.ad
        public final void a(UInAppMessage uInAppMessage) {
            UInAppMessage uInAppMessage2;
            String strA = InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f7925b).a();
            if (TextUtils.isEmpty(strA)) {
                uInAppMessage2 = null;
            } else {
                try {
                    uInAppMessage2 = new UInAppMessage(new JSONObject(strA));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    uInAppMessage2 = null;
                }
            }
            if (uInAppMessage != null) {
                if (uInAppMessage2 != null && !uInAppMessage.msg_id.equals(uInAppMessage2.msg_id)) {
                    InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f7925b).a(new File(f.a((Context) UmengSplashMessageActivity.this.f7925b, uInAppMessage2.msg_id)));
                }
                UmengSplashMessageActivity.this.f7934k = uInAppMessage;
            } else if (uInAppMessage2 == null) {
                return;
            } else {
                UmengSplashMessageActivity.this.f7934k = uInAppMessage2;
            }
            if (UmengSplashMessageActivity.this.f7934k.show_type == 1 && !UmengSplashMessageActivity.u(UmengSplashMessageActivity.this)) {
                InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f7925b).a(UmengSplashMessageActivity.this.f7934k.msg_id, 0);
            }
            InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f7925b);
            if (InAppMessageManager.b(UmengSplashMessageActivity.this.f7934k) && InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f7925b).c(UmengSplashMessageActivity.this.f7934k)) {
                if (UmengSplashMessageActivity.this.f7934k.msg_type == 0) {
                    UMLog.mutlInfo(UmengSplashMessageActivity.a, 2, "SPLASH_A");
                    UmengSplashMessageActivity umengSplashMessageActivity = UmengSplashMessageActivity.this;
                    umengSplashMessageActivity.f7926c = new af(umengSplashMessageActivity.f7925b, UmengSplashMessageActivity.this.f7934k);
                    UmengSplashMessageActivity.this.f7926c.a = UmengSplashMessageActivity.this.u;
                    UmengSplashMessageActivity.this.f7926c.execute(UmengSplashMessageActivity.this.f7934k.image_url);
                }
                if (UmengSplashMessageActivity.this.f7934k.msg_type == 1) {
                    UMLog.mutlInfo(UmengSplashMessageActivity.a, 2, "SPLASH_B");
                    UmengSplashMessageActivity umengSplashMessageActivity2 = UmengSplashMessageActivity.this;
                    umengSplashMessageActivity2.f7926c = new af(umengSplashMessageActivity2.f7925b, UmengSplashMessageActivity.this.f7934k);
                    UmengSplashMessageActivity.this.f7926c.a = UmengSplashMessageActivity.this.u;
                    UmengSplashMessageActivity.this.f7926c.execute(UmengSplashMessageActivity.this.f7934k.image_url, UmengSplashMessageActivity.this.f7934k.bottom_image_url);
                }
            }
        }

        @Override // com.umeng.message.proguard.ad
        public final void b(UInAppMessage uInAppMessage) {
        }
    };

    class a extends ah {
        a(long j2, long j3) {
            super(j2, j3);
        }

        @Override // com.umeng.message.proguard.ah
        public final void a(long j2) {
            if (UmengSplashMessageActivity.this.f7930g) {
                return;
            }
            UmengSplashMessageActivity.this.f7929f.setVisibility(0);
            UmengSplashMessageActivity.this.f7929f.setText(((int) Math.ceil((j2 * 1.0d) / ((double) UmengSplashMessageActivity.t))) + d.c.a.b.a.a.f10074g + UmengSplashMessageActivity.this.f7934k.display_name);
        }

        @Override // com.umeng.message.proguard.ah
        public final void e() {
            if (UmengSplashMessageActivity.this.c() && UmengSplashMessageActivity.this.f7930g) {
                return;
            }
            if (!UmengSplashMessageActivity.this.f7930g) {
                ai.a(UmengSplashMessageActivity.this.f7925b).a(UmengSplashMessageActivity.this.f7934k.msg_id, UmengSplashMessageActivity.this.f7934k.msg_type, 1, UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f7936m), UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f7937n), UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.o), 0, UmengSplashMessageActivity.this.f7934k.display_time * 1000, 0);
            }
            UmengSplashMessageActivity.this.d();
            UmengSplashMessageActivity.this.finish();
        }
    }

    static /* synthetic */ int a(boolean z) {
        return z ? 1 : 0;
    }

    static /* synthetic */ a c(UmengSplashMessageActivity umengSplashMessageActivity) {
        umengSplashMessageActivity.f7932i = null;
        return null;
    }

    static /* synthetic */ boolean d(UmengSplashMessageActivity umengSplashMessageActivity) {
        umengSplashMessageActivity.f7936m = true;
        return true;
    }

    static /* synthetic */ boolean m(UmengSplashMessageActivity umengSplashMessageActivity) {
        umengSplashMessageActivity.f7937n = true;
        return true;
    }

    static /* synthetic */ boolean o(UmengSplashMessageActivity umengSplashMessageActivity) {
        umengSplashMessageActivity.o = true;
        return true;
    }

    static /* synthetic */ boolean s(UmengSplashMessageActivity umengSplashMessageActivity) {
        umengSplashMessageActivity.f7930g = false;
        return false;
    }

    static /* synthetic */ boolean u(UmengSplashMessageActivity umengSplashMessageActivity) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Long.parseLong(InAppMessageManager.getInstance(umengSplashMessageActivity.f7925b).a("KEY_LAST_SHOW_SPLASH_TS", "0")));
        Calendar calendar2 = Calendar.getInstance();
        return calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7925b = this;
        if ((getIntent().getFlags() & 4194304) > 0) {
            finish();
            return;
        }
        if (onCustomPretreatment()) {
            return;
        }
        setRequestedOrientation(1);
        FrameLayout frameLayout = new FrameLayout(this.f7925b);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this.f7925b);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 13.0f);
        this.f7927d = new ImageView(this.f7925b);
        this.f7927d.setLayoutParams(layoutParams);
        this.f7927d.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(this.f7927d);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0, 3.0f);
        this.f7928e = new ImageView(this.f7925b);
        this.f7928e.setLayoutParams(layoutParams2);
        this.f7928e.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(this.f7928e);
        frameLayout.addView(linearLayout);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        layoutParams3.rightMargin = bb.a(30.0f);
        layoutParams3.topMargin = bb.a(20.0f);
        this.f7929f = new TextView(this.f7925b);
        this.f7929f.setLayoutParams(layoutParams3);
        int iA = bb.a(6.0f);
        int i2 = iA / 3;
        this.f7929f.setPadding(iA, i2, iA, i2);
        this.f7929f.setTextSize(14.0f);
        this.f7929f.setBackgroundColor(Color.parseColor("#80000000"));
        this.f7929f.setTextColor(-1);
        this.f7929f.setVisibility(8);
        frameLayout.addView(this.f7929f);
        setContentView(frameLayout);
        if (!InAppMessageManager.a && System.currentTimeMillis() - Long.parseLong(InAppMessageManager.getInstance(this.f7925b).a("KEY_SPLASH_TS", "0")) <= InAppMessageManager.f7890d) {
            this.v.a(null);
        } else {
            ai.a(this).a(this.v);
        }
        this.f7935l = InAppMessageManager.getInstance(this.f7925b).getInAppHandler();
        this.f7932i = new a(s, t);
        this.f7932i.b();
    }

    public boolean onCustomPretreatment() {
        return false;
    }

    @Override // android.app.Activity
    protected final void onDestroy() {
        a aVar = this.f7932i;
        if (aVar != null) {
            aVar.a();
        }
        a aVar2 = this.f7933j;
        if (aVar2 != null) {
            aVar2.a();
        }
        af afVar = this.f7926c;
        if (afVar != null) {
            afVar.a = null;
        }
        this.p = false;
        this.f7936m = false;
        this.f7937n = false;
        this.o = false;
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected final void onPause() {
        super.onPause();
        a aVar = this.f7932i;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f7933j != null) {
            this.r += SystemClock.elapsedRealtime() - this.q;
            this.f7933j.c();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        a aVar = this.f7932i;
        if (aVar != null) {
            aVar.d();
        }
        if (this.f7933j != null) {
            this.q = SystemClock.elapsedRealtime();
            this.f7933j.d();
        }
    }

    @Override // android.app.Activity
    protected final void onStart() {
        super.onStart();
    }

    static /* synthetic */ long a(UmengSplashMessageActivity umengSplashMessageActivity, long j2) {
        long j3 = umengSplashMessageActivity.r + j2;
        umengSplashMessageActivity.r = j3;
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean c() {
        boolean z;
        z = this.p;
        this.p = true;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        if (this.f7931h) {
            this.f7931h = false;
            Intent intent = new Intent();
            intent.setClassName(this.f7925b, InAppMessageManager.getInstance(this).f7894c);
            intent.setFlags(CommonNetImpl.FLAG_SHARE);
            try {
                this.f7925b.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    static /* synthetic */ void a(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 1.0f);
        alphaAnimation.setDuration(500L);
        view.startAnimation(alphaAnimation);
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
    }
}
