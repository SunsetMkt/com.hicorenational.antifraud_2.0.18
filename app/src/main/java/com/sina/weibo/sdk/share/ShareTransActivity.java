package com.sina.weibo.sdk.share;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.sina.weibo.sdk.C2906a;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.p194b.C2923a;
import com.sina.weibo.sdk.p194b.C2925c;
import com.sina.weibo.sdk.p194b.C2926d;
import com.sina.weibo.sdk.p194b.C2927e;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ShareTransActivity extends BaseActivity {

    /* renamed from: t */
    private Intent f9327t;

    /* renamed from: u */
    private FrameLayout f9328u;

    /* renamed from: v */
    private AsyncTaskC2944d f9329v;

    /* renamed from: w */
    private String f9330w;

    /* renamed from: x */
    private Handler f9331x = new Handler(Looper.getMainLooper()) { // from class: com.sina.weibo.sdk.share.ShareTransActivity.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                Object obj = message.obj;
                if (obj instanceof Intent) {
                    ShareTransActivity.this.m8870b((Intent) obj);
                    return;
                }
            }
            ShareTransActivity.this.m8873j();
        }
    };

    /* renamed from: c */
    private static void m8871c(Intent intent) {
        if (intent == null || intent.getFlags() == 0) {
            return;
        }
        int flags = intent.getFlags();
        String binaryString = Integer.toBinaryString(flags);
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 19) {
            arrayList.add(64);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            arrayList.add(128);
        }
        arrayList.add(1);
        arrayList.add(2);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            flags &= ~((Integer) it.next()).intValue();
        }
        C2925c.m8837a("WBShareTag", "clear flags: " + binaryString + "->" + Integer.toBinaryString(flags));
        intent.setFlags(flags);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m8873j() {
        FrameLayout frameLayout = this.f9328u;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        Handler handler = this.f9331x;
        if (handler != null) {
            handler.removeMessages(0);
            this.f9331x = null;
        }
        try {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt("_weibo_resp_errcode", 1);
            intent.putExtras(bundle);
            setResult(-1, intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        C2925c.m8837a("WBShareTag", "onActivityResult. Means share result coming!");
        Handler handler = this.f9331x;
        if (handler != null) {
            if (i3 != -1) {
                handler.sendEmptyMessageDelayed(0, 100L);
                return;
            }
            Message obtain = Message.obtain(handler, 1);
            obtain.obj = intent;
            this.f9331x.sendMessageDelayed(obtain, 100L);
        }
    }

    @Override // com.sina.weibo.sdk.share.BaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2925c.m8837a("WBShareTag", "start share activity.");
        this.f9327t = getIntent();
        Intent intent = this.f9327t;
        if (intent == null) {
            finish();
            return;
        }
        if (intent.getIntExtra("start_flag", -1) != 1001) {
            finish();
            return;
        }
        this.f9328u = new FrameLayout(this);
        int intExtra = getIntent().getIntExtra("progress_id", -1);
        View inflate = intExtra != -1 ? ((LayoutInflater) getSystemService("layout_inflater")).inflate(intExtra, (ViewGroup) null) : new ProgressBar(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f9328u.addView(inflate, layoutParams);
        this.f9328u.setBackgroundColor(855638016);
        setContentView(this.f9328u);
        C2925c.m8837a("WBShareTag", "prepare wb resource.");
        Bundle extras = this.f9327t.getExtras();
        if (extras == null) {
            finish();
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        weiboMultiMessage.readFromBundle(extras);
        if (weiboMultiMessage.multiImageObject == null && weiboMultiMessage.videoSourceObject == null) {
            m8863a(weiboMultiMessage);
            return;
        }
        AsyncTaskC2944d asyncTaskC2944d = this.f9329v;
        if (asyncTaskC2944d != null) {
            asyncTaskC2944d.cancel(true);
        }
        this.f9329v = new AsyncTaskC2944d(this, new InterfaceC2942b() { // from class: com.sina.weibo.sdk.share.ShareTransActivity.2
            @Override // com.sina.weibo.sdk.share.InterfaceC2942b
            /* renamed from: a */
            public final void mo8874a(C2943c c2943c) {
                ShareTransActivity.this.f9328u.setVisibility(4);
                if (c2943c == null) {
                    ShareTransActivity.this.m8872c("Trans result is null.");
                    return;
                }
                if (c2943c.f9335z) {
                    ShareTransActivity.this.m8863a(c2943c.f9334A);
                } else if (TextUtils.isEmpty(c2943c.errorMessage)) {
                    ShareTransActivity.this.m8872c("Trans resource fail.");
                } else {
                    ShareTransActivity.this.m8872c(c2943c.errorMessage);
                }
            }
        });
        this.f9329v.execute(weiboMultiMessage);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C2925c.m8837a("WBShareTag", "start share activity again. Means share result coming!");
        int intExtra = intent.getIntExtra("start_flag", -1);
        if (intExtra == 1001) {
            return;
        }
        if (intExtra == 1002) {
            m8870b(intent);
        } else {
            m8873j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8870b(Intent intent) {
        FrameLayout frameLayout = this.f9328u;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        Handler handler = this.f9331x;
        if (handler != null) {
            handler.removeMessages(0);
            this.f9331x = null;
        }
        if (!m8868a(intent)) {
            m8873j();
            return;
        }
        m8871c(intent);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8863a(WeiboMultiMessage weiboMultiMessage) {
        C2925c.m8837a("WBShareTag", "start wb composer");
        try {
            this.f9327t.putExtra("start_flag", 1002);
            this.f9330w = C2926d.m8840f(String.valueOf((Math.random() * 10000.0d) + System.currentTimeMillis()));
            this.f9327t.putExtra("share_back_flag", this.f9330w);
            this.f9327t.putExtra("share_flag_for_new_version", 1);
            Bundle extras = this.f9327t.getExtras();
            Intent intent = new Intent("com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY");
            C2923a.a m8824c = C2923a.m8824c(this);
            if (m8824c != null) {
                intent.setPackage(m8824c.packageName);
            }
            intent.putExtras(weiboMultiMessage.writeToBundle(extras));
            intent.putExtra("_weibo_sdkVersion", "0041005000");
            intent.putExtra("_weibo_appPackage", getPackageName());
            intent.putExtra("_weibo_appKey", C2906a.m8801a().getAppKey());
            intent.putExtra("_weibo_flag", 538116905);
            intent.putExtra("_weibo_sign", C2926d.m8840f(C2927e.m8842b(this, getPackageName())));
            String stringExtra = this.f9327t.getStringExtra("start_web_activity");
            if (!TextUtils.isEmpty(stringExtra) && "com.sina.weibo.sdk.web.WebActivity".equals(stringExtra)) {
                intent.setClassName(this, stringExtra);
                startActivityForResult(intent, 10001);
            } else {
                if (C2906a.m8803a(this)) {
                    if (m8824c != null) {
                        intent.setPackage(m8824c.packageName);
                    }
                    startActivityForResult(intent, 10001);
                    return;
                }
                m8872c("Start weibo client's composer fail. And Weibo client is not installed.");
            }
        } catch (Throwable th) {
            C2925c.m8838b("WBShareTag", "start wb composer fail," + th.getMessage());
            m8872c("Start weibo client's composer fail. " + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8872c(String str) {
        FrameLayout frameLayout = this.f9328u;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        Handler handler = this.f9331x;
        if (handler != null) {
            handler.removeMessages(0);
            this.f9331x = null;
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("_weibo_resp_errcode", 2);
        bundle.putString("_weibo_resp_errstr", str);
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    /* renamed from: a */
    private boolean m8868a(Intent intent) {
        if (TextUtils.isEmpty(this.f9330w) || intent == null || !intent.getExtras().containsKey("share_back_flag")) {
            return false;
        }
        return TextUtils.equals(this.f9330w, intent.getStringExtra("share_back_flag"));
    }
}
