package com.tencent.tauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.connect.common.AssistActivity;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C3293k;
import com.tencent.open.utils.C3295m;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class AuthActivity extends Activity {
    public static final String ACTION_SHARE_PRIZE = "sharePrize";

    /* renamed from: a */
    private static int f11340a;

    /* renamed from: b */
    private Map<String, ActionHandler> f11341b = new HashMap();

    /* compiled from: ProGuard */
    interface ActionHandler {
        void handleAction(Activity activity, Bundle bundle);
    }

    /* renamed from: a */
    private void m10726a() {
        this.f11341b.put("action_common_channel", new ActionHandler() { // from class: com.tencent.tauth.AuthActivity.1
            @Override // com.tencent.tauth.AuthActivity.ActionHandler
            public void handleAction(Activity activity, Bundle bundle) {
                SLog.m10502i("openSDK_LOG.AuthActivity", "-->handleActionUri--common channel. ");
                Intent intent = new Intent(activity, (Class<?>) AssistActivity.class);
                intent.putExtras(bundle);
                intent.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_COMMON_CHANNEL);
                intent.setFlags(603979776);
                AuthActivity.this.startActivity(intent);
                AuthActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            super.finish();
        } catch (Exception e2) {
            SLog.m10501e("openSDK_LOG.AuthActivity", "activity finish exception: ", e2);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            SLog.m10508w("openSDK_LOG.AuthActivity", "-->onCreate, getIntent() return null");
            finish();
            return;
        }
        Uri uri = null;
        try {
            uri = getIntent().getData();
        } catch (Exception e2) {
            SLog.m10501e("openSDK_LOG.AuthActivity", "onCreate exception: ", e2);
        }
        SLog.m10506v("openSDK_LOG.AuthActivity", "-->onCreate, uri: " + uri);
        m10726a();
        try {
            m10727a(uri);
        } catch (Exception e3) {
            SLog.m10501e("openSDK_LOG.AuthActivity", "onCreate exception: ", e3);
            finish();
        }
    }

    /* renamed from: a */
    private void m10727a(Uri uri) {
        SLog.m10502i("openSDK_LOG.AuthActivity", "-->handleActionUri--start");
        if (uri != null && uri.toString() != null) {
            String str = "";
            if (!uri.toString().equals("")) {
                String uri2 = uri.toString();
                Bundle m10664a = C3295m.m10664a(uri2.substring(uri2.indexOf("#") + 1));
                if (m10664a == null) {
                    SLog.m10508w("openSDK_LOG.AuthActivity", "-->handleActionUri, bundle is null");
                    finish();
                    return;
                }
                String string = m10664a.getString("action");
                SLog.m10502i("openSDK_LOG.AuthActivity", "-->handleActionUri, action: " + string);
                if (string == null) {
                    finish();
                    return;
                }
                if (string.equals("shareToQQ") || string.equals("shareToQzone") || string.equals("sendToMyComputer") || string.equals("shareToTroopBar")) {
                    if (string.equals("shareToQzone") && C3293k.m10634a((Context) this, "com.tencent.mobileqq") != null && C3293k.m10645c(this, "5.2.0") < 0) {
                        f11340a++;
                        if (f11340a == 2) {
                            f11340a = 0;
                            finish();
                            return;
                        }
                    }
                    SLog.m10502i("openSDK_LOG.AuthActivity", "-->handleActionUri, most share action, start assistactivity");
                    Intent intent = new Intent(this, (Class<?>) AssistActivity.class);
                    intent.putExtras(m10664a);
                    intent.setFlags(603979776);
                    startActivity(intent);
                    finish();
                    return;
                }
                if (string.equals("addToQQFavorites")) {
                    Intent intent2 = getIntent();
                    intent2.putExtras(m10664a);
                    intent2.putExtra(Constants.KEY_ACTION, "action_share");
                    IUiListener listnerWithAction = UIListenerManager.getInstance().getListnerWithAction(string);
                    if (listnerWithAction != null) {
                        UIListenerManager.getInstance().handleDataToListener(intent2, listnerWithAction);
                    }
                    finish();
                    return;
                }
                if (string.equals(ACTION_SHARE_PRIZE)) {
                    Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
                    try {
                        str = C3295m.m10696d(m10664a.getString("response")).getString("activityid");
                    } catch (Exception e2) {
                        SLog.m10501e("openSDK_LOG.AuthActivity", "sharePrize parseJson has exception.", e2);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        launchIntentForPackage.putExtra(ACTION_SHARE_PRIZE, true);
                        Bundle bundle = new Bundle();
                        bundle.putString("activityid", str);
                        launchIntentForPackage.putExtras(bundle);
                    }
                    startActivity(launchIntentForPackage);
                    finish();
                    return;
                }
                if (string.equals("sdkSetAvatar")) {
                    boolean booleanExtra = getIntent().getBooleanExtra(Constants.KEY_STAY, false);
                    Intent intent3 = new Intent(this, (Class<?>) AssistActivity.class);
                    intent3.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_EDIT_AVATAR);
                    intent3.putExtra(Constants.KEY_STAY, booleanExtra);
                    intent3.putExtras(m10664a);
                    intent3.setFlags(603979776);
                    startActivity(intent3);
                    finish();
                    return;
                }
                if ("sdkSetDynamicAvatar".equals(string)) {
                    boolean booleanExtra2 = getIntent().getBooleanExtra(Constants.KEY_STAY, false);
                    Intent intent4 = new Intent(this, (Class<?>) AssistActivity.class);
                    intent4.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_EDIT_DYNAMIC_AVATAR);
                    intent4.putExtra(Constants.KEY_STAY, booleanExtra2);
                    intent4.putExtras(m10664a);
                    intent4.setFlags(603979776);
                    startActivity(intent4);
                    finish();
                    return;
                }
                if (string.equals("sdkSetEmotion")) {
                    boolean booleanExtra3 = getIntent().getBooleanExtra(Constants.KEY_STAY, false);
                    Intent intent5 = new Intent(this, (Class<?>) AssistActivity.class);
                    intent5.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_EDIT_EMOTION);
                    intent5.putExtra(Constants.KEY_STAY, booleanExtra3);
                    intent5.putExtras(m10664a);
                    intent5.setFlags(603979776);
                    startActivity(intent5);
                    finish();
                    return;
                }
                if (string.equals("bindGroup")) {
                    SLog.m10502i("openSDK_LOG.AuthActivity", "-->handleActionUri--bind group callback.");
                    boolean booleanExtra4 = getIntent().getBooleanExtra(Constants.KEY_STAY, false);
                    Intent intent6 = new Intent(this, (Class<?>) AssistActivity.class);
                    intent6.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_BIND_GROUP);
                    intent6.putExtra(Constants.KEY_STAY, booleanExtra4);
                    intent6.putExtras(m10664a);
                    intent6.setFlags(603979776);
                    startActivity(intent6);
                    finish();
                    return;
                }
                if (string.equals("joinGroup")) {
                    SLog.m10502i("openSDK_LOG.AuthActivity", "-->handleActionUri--join group callback. ");
                    boolean booleanExtra5 = getIntent().getBooleanExtra(Constants.KEY_STAY, false);
                    Intent intent7 = new Intent(this, (Class<?>) AssistActivity.class);
                    intent7.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_JOIN_GROUP);
                    intent7.putExtra(Constants.KEY_STAY, booleanExtra5);
                    intent7.putExtras(m10664a);
                    intent7.setFlags(603979776);
                    startActivity(intent7);
                    finish();
                    return;
                }
                if (!"guildOpen".equals(string)) {
                    ActionHandler actionHandler = this.f11341b.get(string);
                    if (actionHandler != null) {
                        actionHandler.handleAction(this, m10664a);
                        return;
                    } else {
                        finish();
                        return;
                    }
                }
                Intent intent8 = new Intent(this, (Class<?>) AssistActivity.class);
                intent8.putExtras(m10664a);
                intent8.putExtra(Constants.KEY_REQUEST_CODE, Constants.REQUEST_GUILD);
                intent8.setFlags(603979776);
                startActivity(intent8);
                finish();
                return;
            }
        }
        SLog.m10508w("openSDK_LOG.AuthActivity", "-->handleActionUri, uri invalid");
        finish();
    }
}
