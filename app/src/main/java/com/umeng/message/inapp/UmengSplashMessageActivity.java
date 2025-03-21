package com.umeng.message.inapp;

import android.app.Activity;
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
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.proguard.AbstractC3559ah;
import com.umeng.message.proguard.AsyncTaskC3557af;
import com.umeng.message.proguard.C3560ai;
import com.umeng.message.proguard.C3580bb;
import com.umeng.message.proguard.InterfaceC3555ad;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Calendar;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes2.dex */
public class UmengSplashMessageActivity extends Activity {

    /* renamed from: a */
    private static final String f13114a = UmengSplashMessageActivity.class.getName();

    /* renamed from: s */
    private static int f13115s = 2000;

    /* renamed from: t */
    private static int f13116t = 1000;

    /* renamed from: b */
    private Activity f13117b;

    /* renamed from: c */
    private AsyncTaskC3557af f13118c;

    /* renamed from: d */
    private ImageView f13119d;

    /* renamed from: e */
    private ImageView f13120e;

    /* renamed from: f */
    private TextView f13121f;

    /* renamed from: i */
    private C3550a f13124i;

    /* renamed from: j */
    private C3550a f13125j;

    /* renamed from: k */
    private UInAppMessage f13126k;

    /* renamed from: l */
    private UInAppHandler f13127l;

    /* renamed from: q */
    private long f13132q;

    /* renamed from: r */
    private long f13133r;

    /* renamed from: g */
    private boolean f13122g = true;

    /* renamed from: h */
    private boolean f13123h = true;

    /* renamed from: m */
    private boolean f13128m = false;

    /* renamed from: n */
    private boolean f13129n = false;

    /* renamed from: o */
    private boolean f13130o = false;

    /* renamed from: p */
    private boolean f13131p = false;

    /* renamed from: u */
    private AsyncTaskC3557af.a f13134u = new AsyncTaskC3557af.a() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1
        @Override // com.umeng.message.proguard.AsyncTaskC3557af.a
        /* renamed from: a */
        public final void mo12211a(Bitmap[] bitmapArr) {
            if (UmengSplashMessageActivity.this.m12188c()) {
                return;
            }
            if (UmengSplashMessageActivity.this.f13124i != null) {
                UmengSplashMessageActivity.this.f13124i.m12238a();
                UmengSplashMessageActivity.m12187c(UmengSplashMessageActivity.this);
            }
            try {
                if (bitmapArr.length == 1) {
                    UmengSplashMessageActivity.this.f13119d.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1.1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            UmengSplashMessageActivity.m12190d(UmengSplashMessageActivity.this);
                            if (TextUtils.equals("none", UmengSplashMessageActivity.this.f13126k.action_type)) {
                                return;
                            }
                            UmengSplashMessageActivity.m12178a(UmengSplashMessageActivity.this, SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.f13132q);
                            C3560ai.m12243a(UmengSplashMessageActivity.this.f13117b).m12249a(UmengSplashMessageActivity.this.f13126k.msg_id, UmengSplashMessageActivity.this.f13126k.msg_type, 1, 1, 0, 0, 0, (int) UmengSplashMessageActivity.this.f13133r, 0);
                            UmengSplashMessageActivity.this.m12189d();
                            UmengSplashMessageActivity.this.f13127l.handleInAppMessage(UmengSplashMessageActivity.this.f13117b, UmengSplashMessageActivity.this.f13126k, 16);
                            UmengSplashMessageActivity.this.finish();
                        }
                    });
                    UmengSplashMessageActivity.this.f13120e.setVisibility(8);
                    UmengSplashMessageActivity.this.f13119d.setImageBitmap(bitmapArr[0]);
                    UmengSplashMessageActivity.m12182a(UmengSplashMessageActivity.this.f13119d);
                }
                if (bitmapArr.length == 2) {
                    UmengSplashMessageActivity.this.f13119d.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1.2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            UmengSplashMessageActivity.m12199m(UmengSplashMessageActivity.this);
                            if (TextUtils.equals("none", UmengSplashMessageActivity.this.f13126k.action_type)) {
                                return;
                            }
                            UmengSplashMessageActivity.m12178a(UmengSplashMessageActivity.this, SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.f13132q);
                            C3560ai.m12243a(UmengSplashMessageActivity.this.f13117b).m12249a(UmengSplashMessageActivity.this.f13126k.msg_id, UmengSplashMessageActivity.this.f13126k.msg_type, 1, 0, 1, UmengSplashMessageActivity.m12177a(UmengSplashMessageActivity.this.f13130o), 0, (int) UmengSplashMessageActivity.this.f13133r, 0);
                            UmengSplashMessageActivity.this.m12189d();
                            UmengSplashMessageActivity.this.f13127l.handleInAppMessage(UmengSplashMessageActivity.this.f13117b, UmengSplashMessageActivity.this.f13126k, 16);
                            UmengSplashMessageActivity.this.finish();
                        }
                    });
                    UmengSplashMessageActivity.this.f13120e.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1.3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            UmengSplashMessageActivity.m12201o(UmengSplashMessageActivity.this);
                            if (TextUtils.equals("none", UmengSplashMessageActivity.this.f13126k.bottom_action_type)) {
                                return;
                            }
                            UmengSplashMessageActivity.m12178a(UmengSplashMessageActivity.this, SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.f13132q);
                            C3560ai.m12243a(UmengSplashMessageActivity.this.f13117b).m12249a(UmengSplashMessageActivity.this.f13126k.msg_id, UmengSplashMessageActivity.this.f13126k.msg_type, 1, 0, UmengSplashMessageActivity.m12177a(UmengSplashMessageActivity.this.f13129n), 1, 0, (int) UmengSplashMessageActivity.this.f13133r, 0);
                            UmengSplashMessageActivity.this.m12189d();
                            UmengSplashMessageActivity.this.f13127l.handleInAppMessage(UmengSplashMessageActivity.this.f13117b, UmengSplashMessageActivity.this.f13126k, 17);
                            UmengSplashMessageActivity.this.finish();
                        }
                    });
                    UmengSplashMessageActivity.this.f13119d.setImageBitmap(bitmapArr[0]);
                    UmengSplashMessageActivity.this.f13120e.setImageBitmap(bitmapArr[1]);
                    UmengSplashMessageActivity.m12182a(UmengSplashMessageActivity.this.f13119d);
                    UmengSplashMessageActivity.m12182a(UmengSplashMessageActivity.this.f13120e);
                }
                UmengSplashMessageActivity.this.f13132q = SystemClock.elapsedRealtime();
                if (UmengSplashMessageActivity.this.f13126k.display_button) {
                    UmengSplashMessageActivity.this.f13121f.setVisibility(0);
                    UmengSplashMessageActivity.this.f13121f.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1.4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            UmengSplashMessageActivity.m12178a(UmengSplashMessageActivity.this, SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.f13132q);
                            C3560ai.m12243a(UmengSplashMessageActivity.this.f13117b).m12249a(UmengSplashMessageActivity.this.f13126k.msg_id, UmengSplashMessageActivity.this.f13126k.msg_type, 1, UmengSplashMessageActivity.m12177a(UmengSplashMessageActivity.this.f13128m), UmengSplashMessageActivity.m12177a(UmengSplashMessageActivity.this.f13129n), UmengSplashMessageActivity.m12177a(UmengSplashMessageActivity.this.f13130o), 1, (int) UmengSplashMessageActivity.this.f13133r, 0);
                            UmengSplashMessageActivity.this.m12189d();
                            UmengSplashMessageActivity.this.finish();
                        }
                    });
                } else {
                    UmengSplashMessageActivity.this.f13121f.setVisibility(8);
                }
                InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f13117b).m12161a(UmengSplashMessageActivity.this.f13126k);
                InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f13117b).m12164a(UmengSplashMessageActivity.this.f13126k.msg_id, 1);
                InAppMessageManager inAppMessageManager = InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f13117b);
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                inAppMessageManager.m12167b("KEY_LAST_SHOW_SPLASH_TS", sb.toString());
                UmengSplashMessageActivity.m12205s(UmengSplashMessageActivity.this);
                UmengSplashMessageActivity.this.f13125j = UmengSplashMessageActivity.this.new C3550a(UmengSplashMessageActivity.this.f13126k.display_time * 1000, UmengSplashMessageActivity.f13116t);
                UmengSplashMessageActivity.this.f13125j.m12239b();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    };

    /* renamed from: v */
    private final InterfaceC3555ad f13135v = new InterfaceC3555ad() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.2
        /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:5:0x0026  */
        @Override // com.umeng.message.proguard.InterfaceC3555ad
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void mo12212a(com.umeng.message.entity.UInAppMessage r7) {
            /*
                Method dump skipped, instructions count: 347
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.inapp.UmengSplashMessageActivity.C35492.mo12212a(com.umeng.message.entity.UInAppMessage):void");
        }

        @Override // com.umeng.message.proguard.InterfaceC3555ad
        /* renamed from: b */
        public final void mo12213b(UInAppMessage uInAppMessage) {
        }
    };

    /* renamed from: com.umeng.message.inapp.UmengSplashMessageActivity$a */
    class C3550a extends AbstractC3559ah {
        C3550a(long j2, long j3) {
            super(j2, j3);
        }

        @Override // com.umeng.message.proguard.AbstractC3559ah
        /* renamed from: a */
        public final void mo12214a(long j2) {
            if (UmengSplashMessageActivity.this.f13122g) {
                return;
            }
            UmengSplashMessageActivity.this.f13121f.setVisibility(0);
            UmengSplashMessageActivity.this.f13121f.setText(((int) Math.ceil((j2 * 1.0d) / UmengSplashMessageActivity.f13116t)) + AbstractC1191a.f2568g + UmengSplashMessageActivity.this.f13126k.display_name);
        }

        @Override // com.umeng.message.proguard.AbstractC3559ah
        /* renamed from: e */
        public final void mo12215e() {
            if (UmengSplashMessageActivity.this.m12188c() && UmengSplashMessageActivity.this.f13122g) {
                return;
            }
            if (!UmengSplashMessageActivity.this.f13122g) {
                C3560ai.m12243a(UmengSplashMessageActivity.this.f13117b).m12249a(UmengSplashMessageActivity.this.f13126k.msg_id, UmengSplashMessageActivity.this.f13126k.msg_type, 1, UmengSplashMessageActivity.m12177a(UmengSplashMessageActivity.this.f13128m), UmengSplashMessageActivity.m12177a(UmengSplashMessageActivity.this.f13129n), UmengSplashMessageActivity.m12177a(UmengSplashMessageActivity.this.f13130o), 0, UmengSplashMessageActivity.this.f13126k.display_time * 1000, 0);
            }
            UmengSplashMessageActivity.this.m12189d();
            UmengSplashMessageActivity.this.finish();
        }
    }

    /* renamed from: a */
    static /* synthetic */ int m12177a(boolean z) {
        return z ? 1 : 0;
    }

    /* renamed from: c */
    static /* synthetic */ C3550a m12187c(UmengSplashMessageActivity umengSplashMessageActivity) {
        umengSplashMessageActivity.f13124i = null;
        return null;
    }

    /* renamed from: d */
    static /* synthetic */ boolean m12190d(UmengSplashMessageActivity umengSplashMessageActivity) {
        umengSplashMessageActivity.f13128m = true;
        return true;
    }

    /* renamed from: m */
    static /* synthetic */ boolean m12199m(UmengSplashMessageActivity umengSplashMessageActivity) {
        umengSplashMessageActivity.f13129n = true;
        return true;
    }

    /* renamed from: o */
    static /* synthetic */ boolean m12201o(UmengSplashMessageActivity umengSplashMessageActivity) {
        umengSplashMessageActivity.f13130o = true;
        return true;
    }

    /* renamed from: s */
    static /* synthetic */ boolean m12205s(UmengSplashMessageActivity umengSplashMessageActivity) {
        umengSplashMessageActivity.f13122g = false;
        return false;
    }

    /* renamed from: u */
    static /* synthetic */ boolean m12207u(UmengSplashMessageActivity umengSplashMessageActivity) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Long.parseLong(InAppMessageManager.getInstance(umengSplashMessageActivity.f13117b).m12160a("KEY_LAST_SHOW_SPLASH_TS", "0")));
        Calendar calendar2 = Calendar.getInstance();
        return calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f13117b = this;
        if ((getIntent().getFlags() & 4194304) > 0) {
            finish();
            return;
        }
        if (onCustomPretreatment()) {
            return;
        }
        setRequestedOrientation(1);
        FrameLayout frameLayout = new FrameLayout(this.f13117b);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this.f13117b);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 13.0f);
        this.f13119d = new ImageView(this.f13117b);
        this.f13119d.setLayoutParams(layoutParams);
        this.f13119d.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(this.f13119d);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0, 3.0f);
        this.f13120e = new ImageView(this.f13117b);
        this.f13120e.setLayoutParams(layoutParams2);
        this.f13120e.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(this.f13120e);
        frameLayout.addView(linearLayout);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        layoutParams3.rightMargin = C3580bb.m12337a(30.0f);
        layoutParams3.topMargin = C3580bb.m12337a(20.0f);
        this.f13121f = new TextView(this.f13117b);
        this.f13121f.setLayoutParams(layoutParams3);
        int m12337a = C3580bb.m12337a(6.0f);
        int i2 = m12337a / 3;
        this.f13121f.setPadding(m12337a, i2, m12337a, i2);
        this.f13121f.setTextSize(14.0f);
        this.f13121f.setBackgroundColor(Color.parseColor("#80000000"));
        this.f13121f.setTextColor(-1);
        this.f13121f.setVisibility(8);
        frameLayout.addView(this.f13121f);
        setContentView(frameLayout);
        if (InAppMessageManager.f13064a) {
            C3560ai.m12243a(this).m12248a(this.f13135v);
        } else if (System.currentTimeMillis() - Long.parseLong(InAppMessageManager.getInstance(this.f13117b).m12160a("KEY_SPLASH_TS", "0")) > InAppMessageManager.f13065d) {
            C3560ai.m12243a(this).m12248a(this.f13135v);
        } else {
            this.f13135v.mo12212a(null);
        }
        this.f13127l = InAppMessageManager.getInstance(this.f13117b).getInAppHandler();
        this.f13124i = new C3550a(f13115s, f13116t);
        this.f13124i.m12239b();
    }

    public boolean onCustomPretreatment() {
        return false;
    }

    @Override // android.app.Activity
    protected final void onDestroy() {
        C3550a c3550a = this.f13124i;
        if (c3550a != null) {
            c3550a.m12238a();
        }
        C3550a c3550a2 = this.f13125j;
        if (c3550a2 != null) {
            c3550a2.m12238a();
        }
        AsyncTaskC3557af asyncTaskC3557af = this.f13118c;
        if (asyncTaskC3557af != null) {
            asyncTaskC3557af.f13165a = null;
        }
        this.f13131p = false;
        this.f13128m = false;
        this.f13129n = false;
        this.f13130o = false;
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected final void onPause() {
        super.onPause();
        C3550a c3550a = this.f13124i;
        if (c3550a != null) {
            c3550a.m12240c();
        }
        if (this.f13125j != null) {
            this.f13133r += SystemClock.elapsedRealtime() - this.f13132q;
            this.f13125j.m12240c();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        C3550a c3550a = this.f13124i;
        if (c3550a != null) {
            c3550a.m12241d();
        }
        if (this.f13125j != null) {
            this.f13132q = SystemClock.elapsedRealtime();
            this.f13125j.m12241d();
        }
    }

    @Override // android.app.Activity
    protected final void onStart() {
        super.onStart();
    }

    /* renamed from: a */
    static /* synthetic */ long m12178a(UmengSplashMessageActivity umengSplashMessageActivity, long j2) {
        long j3 = umengSplashMessageActivity.f13133r + j2;
        umengSplashMessageActivity.f13133r = j3;
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public synchronized boolean m12188c() {
        boolean z;
        z = this.f13131p;
        this.f13131p = true;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public synchronized void m12189d() {
        if (this.f13123h) {
            this.f13123h = false;
            Intent intent = new Intent();
            intent.setClassName(this.f13117b, InAppMessageManager.getInstance(this).f13069c);
            intent.setFlags(CommonNetImpl.FLAG_SHARE);
            try {
                this.f13117b.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m12182a(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 1.0f);
        alphaAnimation.setDuration(500L);
        view.startAnimation(alphaAnimation);
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
    }
}
