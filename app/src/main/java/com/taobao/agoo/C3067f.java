package com.taobao.agoo;

import android.content.Intent;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.BaseNotifyClickActivity;

/* compiled from: Taobao */
/* renamed from: com.taobao.agoo.f */
/* loaded from: classes2.dex */
public class C3067f implements BaseNotifyClickActivity.INotifyListener {
    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String getMsgSource() {
        return "xiaomi";
    }

    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String parseMsgFromIntent(Intent intent) {
        try {
            String str = (String) Class.forName("com.xiaomi.mipush.sdk.PushMessageHelper").getField("KEY_MESSAGE").get(null);
            if (intent.getSerializableExtra(str) == null) {
                return null;
            }
            Class<?> cls = Class.forName("com.xiaomi.mipush.sdk.MiPushMessage");
            return (String) cls.getMethod("getContent", new Class[0]).invoke(cls.cast(intent.getSerializableExtra(str)), new Object[0]);
        } catch (Throwable th) {
            ALog.m9181e("DefaultXiaomiMsgParseImpl", "parseMsgFromIntent", th, new Object[0]);
            return null;
        }
    }
}
