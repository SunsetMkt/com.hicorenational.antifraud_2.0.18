package com.tencent.connect.common;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.open.log.SLog;
import com.tencent.open.p212b.C3263e;
import com.tencent.open.p212b.C3266h;
import com.tencent.open.utils.C3295m;
import com.tencent.tauth.Tencent;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class AssistActivity extends Activity {
    public static final String EXTRA_INTENT = "openSDK_LOG.AssistActivity.ExtraIntent";
    public static final String KEY_EXTRA_PENDING_INTENT = "key_extra_pending_intent";
    public static final String KEY_REQUEST_ORIENTATION = "key_request_orientation";

    /* renamed from: d */
    private String f11006d;

    /* renamed from: e */
    private QQStayReceiver f11007e;

    /* renamed from: f */
    private boolean f11008f;

    /* renamed from: c */
    private boolean f11005c = false;

    /* renamed from: a */
    protected boolean f11003a = false;

    /* renamed from: b */
    protected Handler f11004b = new Handler() { // from class: com.tencent.connect.common.AssistActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && !AssistActivity.this.isFinishing()) {
                SLog.m10508w("openSDK_LOG.AssistActivity", "-->finish by timeout");
                AssistActivity.this.finish();
            }
        }
    };

    /* compiled from: ProGuard */
    private class QQStayReceiver extends BroadcastReceiver {
        private QQStayReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str = "#";
            Intent intent2 = new Intent();
            intent2.putExtra(Constants.KEY_ACTION, "action_share");
            try {
                Uri uri = (Uri) intent.getParcelableExtra("uriData");
                String uri2 = uri.toString();
                if (!uri2.contains("#")) {
                    str = "?";
                }
                for (String str2 : uri2.substring(uri2.indexOf(str) + 1).split("&")) {
                    String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    intent2.putExtra(split[0], split[1]);
                }
                intent2.setData(uri);
            } catch (Exception e2) {
                SLog.m10502i("openSDK_LOG.AssistActivity", "QQStayReceiver parse uri error : " + e2.getMessage());
                intent2.putExtra("result", "error");
                intent2.putExtra("response", "parse error.");
            }
            AssistActivity.this.setResult(-1, intent2);
        }
    }

    /* renamed from: a */
    private void m10304a(Intent intent, boolean z) {
        if (intent == null) {
            SLog.m10498d("openSDK_LOG.AssistActivity", "reportStartActivitySuccess, but intent is null.");
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra(Constants.KEY_PASS_REPORT_VIA_PARAM);
        if (bundleExtra != null) {
            C3295m.m10663a(bundleExtra, z ? "0" : "1");
            C3266h.m10468a().m10470a(bundleExtra, this.f11006d, intent.getBooleanExtra(Constants.KEY_PASS_REPORT_VIA_TIMELY, false));
        }
    }

    public static Intent getAssistActivityIntent(Context context) {
        return new Intent(context, (Class<?>) AssistActivity.class);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("--onActivityResult--requestCode: ");
        sb.append(i2);
        sb.append(" | resultCode: ");
        sb.append(i3);
        sb.append("data = null ? ");
        sb.append(intent == null);
        SLog.m10502i("openSDK_LOG.AssistActivity", sb.toString());
        super.onActivityResult(i2, i3, intent);
        if (i2 == 0) {
            return;
        }
        if (intent != null) {
            intent.putExtra(Constants.KEY_ACTION, "action_login");
        }
        setResultData(i2, intent);
        if (this.f11008f) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.connect.common.AssistActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    SLog.m10502i("openSDK_LOG.AssistActivity", "onActivityResult finish delay");
                    AssistActivity.this.finish();
                }
            }, 200L);
        } else {
            SLog.m10502i("openSDK_LOG.AssistActivity", "onActivityResult finish immediate");
            finish();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0175  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onCreate(android.os.Bundle r15) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.common.AssistActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        SLog.m10502i("openSDK_LOG.AssistActivity", "-->onDestroy");
        super.onDestroy();
        QQStayReceiver qQStayReceiver = this.f11007e;
        if (qQStayReceiver != null) {
            unregisterReceiver(qQStayReceiver);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        SLog.m10502i("openSDK_LOG.AssistActivity", "--onNewIntent");
        super.onNewIntent(intent);
        int intExtra = intent.getIntExtra(Constants.KEY_REQUEST_CODE, -1);
        SLog.m10502i("openSDK_LOG.AssistActivity", "--onNewIntent callbackRequestCode= " + intExtra);
        if (intExtra == 10108) {
            intent.putExtra(Constants.KEY_ACTION, "action_request_avatar");
            if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            finish();
            return;
        }
        if (intExtra == 10109) {
            intent.putExtra(Constants.KEY_ACTION, "action_request_set_emotion");
            if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            finish();
            return;
        }
        if (intExtra == 10110) {
            intent.putExtra(Constants.KEY_ACTION, "action_request_dynamic_avatar");
            if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            finish();
            return;
        }
        if (intExtra == 10111) {
            intent.putExtra(Constants.KEY_ACTION, "joinGroup");
            if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            finish();
            return;
        }
        if (intExtra == 10112) {
            intent.putExtra(Constants.KEY_ACTION, "bindGroup");
            if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            finish();
            return;
        }
        if (intExtra == 10113) {
            intent.putExtra(Constants.KEY_ACTION, intent.getStringExtra("action"));
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            SLog.m10502i("openSDK_LOG.AssistActivity", "--onNewIntent--activity not finished, finish now");
            finish();
            return;
        }
        if (intExtra != 10114) {
            intent.putExtra(Constants.KEY_ACTION, "action_share");
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            SLog.m10502i("openSDK_LOG.AssistActivity", "--onNewIntent--activity not finished, finish now");
            finish();
            return;
        }
        intent.putExtra(Constants.KEY_ACTION, intent.getStringExtra("action"));
        setResult(-1, intent);
        if (isFinishing()) {
            return;
        }
        SLog.m10502i("openSDK_LOG.AssistActivity", "--onNewIntent--activity not finished, finish now");
        finish();
    }

    @Override // android.app.Activity
    protected void onPause() {
        SLog.m10502i("openSDK_LOG.AssistActivity", "-->onPause");
        this.f11004b.removeMessages(0);
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        SLog.m10502i("openSDK_LOG.AssistActivity", "-->onResume");
        super.onResume();
        Intent intent = getIntent();
        if (intent.getBooleanExtra("is_login", false)) {
            return;
        }
        if (!intent.getBooleanExtra("is_qq_mobile_share", false) && this.f11005c && !isFinishing()) {
            finish();
        }
        if (!this.f11003a) {
            this.f11003a = true;
        } else {
            this.f11004b.sendMessage(this.f11004b.obtainMessage(0));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        SLog.m10502i("openSDK_LOG.AssistActivity", "--onSaveInstanceState--");
        bundle.putBoolean("RESTART_FLAG", true);
        bundle.putBoolean("RESUME_FLAG", this.f11003a);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        SLog.m10502i("openSDK_LOG.AssistActivity", "-->onStart");
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onStop() {
        SLog.m10502i("openSDK_LOG.AssistActivity", "-->onStop");
        super.onStop();
        if (Tencent.disableResetOrientation) {
            return;
        }
        try {
            int intExtra = getIntent().getIntExtra(KEY_REQUEST_ORIENTATION, -1);
            SLog.m10502i("openSDK_LOG.AssistActivity", "getRequestedOrientation= " + intExtra);
            if (intExtra != -1) {
                setRequestedOrientation(intExtra);
            }
        } catch (Throwable th) {
            SLog.m10501e("openSDK_LOG.AssistActivity", "reset requestedOrientation catch exception", th);
        }
    }

    public void setResultData(int i2, Intent intent) {
        if (intent == null) {
            SLog.m10508w("openSDK_LOG.AssistActivity", "--setResultData--intent is null, setResult ACTIVITY_CANCEL");
            setResult(0);
            if (i2 == 11101) {
                C3263e.m10457a().m10459a("", this.f11006d, "2", "1", "7", "2");
                return;
            }
            return;
        }
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_RESPONSE);
            SLog.m10498d("openSDK_LOG.AssistActivity", "--setResultDataForLogin-- ");
            if (TextUtils.isEmpty(stringExtra)) {
                SLog.m10508w("openSDK_LOG.AssistActivity", "--setResultData--response is empty, setResult ACTIVITY_OK");
                setResult(-1, intent);
            } else {
                JSONObject jSONObject = new JSONObject(stringExtra);
                String optString = jSONObject.optString("openid");
                String optString2 = jSONObject.optString("access_token");
                String optString3 = jSONObject.optString("proxy_code");
                long optLong = jSONObject.optLong("proxy_expires_in");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    SLog.m10502i("openSDK_LOG.AssistActivity", "--setResultData--openid and token not empty, setResult ACTIVITY_OK");
                    setResult(-1, intent);
                    C3263e.m10457a().m10459a(optString, this.f11006d, "2", "1", "7", "0");
                } else if (TextUtils.isEmpty(optString3) || optLong == 0) {
                    SLog.m10508w("openSDK_LOG.AssistActivity", "--setResultData--openid or token is empty, setResult ACTIVITY_CANCEL");
                    setResult(0, intent);
                    C3263e.m10457a().m10459a("", this.f11006d, "2", "1", "7", "1");
                } else {
                    SLog.m10502i("openSDK_LOG.AssistActivity", "--setResultData--proxy_code and proxy_expires_in are valid");
                    setResult(-1, intent);
                }
            }
        } catch (Exception e2) {
            SLog.m10500e("openSDK_LOG.AssistActivity", "--setResultData--parse response failed");
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0043  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m10305a(android.os.Bundle r13) {
        /*
            r12 = this;
            java.lang.String r0 = "viaShareType"
            java.lang.String r8 = r13.getString(r0)
            java.lang.String r0 = "callbackAction"
            java.lang.String r0 = r13.getString(r0)
            java.lang.String r1 = "url"
            java.lang.String r1 = r13.getString(r1)
            java.lang.String r2 = "openId"
            java.lang.String r2 = r13.getString(r2)
            java.lang.String r3 = "appId"
            java.lang.String r3 = r13.getString(r3)
            java.lang.String r13 = "shareToQQ"
            boolean r13 = r13.equals(r0)
            java.lang.String r4 = ""
            if (r13 == 0) goto L2f
            java.lang.String r13 = "ANDROIDQQ.SHARETOQQ.XX"
            java.lang.String r4 = "10"
        L2c:
            r5 = r4
            r4 = r13
            goto L3d
        L2f:
            java.lang.String r13 = "shareToQzone"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L3c
            java.lang.String r13 = "ANDROIDQQ.SHARETOQZ.XX"
            java.lang.String r4 = "11"
            goto L2c
        L3c:
            r5 = r4
        L3d:
            boolean r13 = com.tencent.open.utils.C3295m.m10678a(r12, r1)
            if (r13 != 0) goto L6e
            com.tencent.connect.common.UIListenerManager r13 = com.tencent.connect.common.UIListenerManager.getInstance()
            com.tencent.tauth.IUiListener r13 = r13.getListnerWithAction(r0)
            if (r13 == 0) goto L59
            com.tencent.tauth.UiError r0 = new com.tencent.tauth.UiError
            r1 = -6
            r6 = 0
            java.lang.String r7 = "打开浏览器失败!"
            r0.<init>(r1, r7, r6)
            r13.onError(r0)
        L59:
            com.tencent.open.b.e r1 = com.tencent.open.p212b.C3263e.m10457a()
            java.lang.String r6 = "3"
            java.lang.String r7 = "1"
            java.lang.String r9 = "0"
            java.lang.String r10 = "2"
            java.lang.String r11 = "0"
            r1.m10461a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r12.finish()
            goto L7f
        L6e:
            com.tencent.open.b.e r1 = com.tencent.open.p212b.C3263e.m10457a()
            java.lang.String r6 = "3"
            java.lang.String r7 = "0"
            java.lang.String r9 = "0"
            java.lang.String r10 = "2"
            java.lang.String r11 = "0"
            r1.m10461a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L7f:
            android.content.Intent r13 = r12.getIntent()
            java.lang.String r0 = "shareH5"
            r13.removeExtra(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.common.AssistActivity.m10305a(android.os.Bundle):void");
    }
}
