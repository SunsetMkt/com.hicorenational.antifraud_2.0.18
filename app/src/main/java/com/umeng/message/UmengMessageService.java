package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.umeng.message.common.UPLog;
import com.umeng.message.proguard.AbstractServiceC3597q;

/* loaded from: classes2.dex */
public abstract class UmengMessageService extends AbstractServiceC3597q {
    private static final String TAG = "MessageService";

    @Override // com.umeng.message.proguard.AbstractServiceC3597q
    public void onHandleWork(Intent intent) {
        super.onHandleWork(intent);
        try {
            String stringExtra = intent.getStringExtra("um_command");
            if ("handle".equals(stringExtra)) {
                String stringExtra2 = intent.getStringExtra("body");
                onMessage(this, intent);
                UPLog.m12145i(TAG, "message:", stringExtra2);
            } else if ("third_token".equals(stringExtra)) {
                String stringExtra3 = intent.getStringExtra("type");
                String stringExtra4 = intent.getStringExtra("third_token");
                if (!TextUtils.isEmpty(stringExtra3) && !TextUtils.isEmpty(stringExtra4)) {
                    onThirdToken(stringExtra3, stringExtra4);
                    UPLog.m12145i(TAG, "third push type:", stringExtra3, "token:", stringExtra4);
                    return;
                }
                UPLog.m12145i(TAG, "third push skipped! type:", stringExtra3, "token:", stringExtra4);
            }
        } catch (Throwable th) {
            UPLog.m12143e(TAG, th);
        }
    }

    public abstract void onMessage(Context context, Intent intent);

    public void onThirdToken(String str, String str2) {
    }
}
