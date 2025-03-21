package com.taobao.agoo;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3043k;
import com.taobao.agoo.BaseNotifyClickActivity;
import java.util.Iterator;
import java.util.Set;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.MsgDO;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.control.NotifManager;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class BaseNotifyClick {
    private static final String TAG = "accs.BaseNotifyClick";
    private AgooFactory agooFactory;
    private Context context;
    private String msgSource;
    private NotifManager notifyManager;

    private void buildMessage(Intent intent) {
        ThreadPoolExecutorFactory.execute(new RunnableC3056a(this, intent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String parseMsgByThirdPush(Intent intent) {
        String parseMsgFromIntent;
        Set<BaseNotifyClickActivity.INotifyListener> set = BaseNotifyClickActivity.notifyListeners;
        if (set != null && set.size() > 0) {
            Iterator<BaseNotifyClickActivity.INotifyListener> it = BaseNotifyClickActivity.notifyListeners.iterator();
            parseMsgFromIntent = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BaseNotifyClickActivity.INotifyListener next = it.next();
                String parseMsgFromIntent2 = next.parseMsgFromIntent(intent);
                if (!TextUtils.isEmpty(parseMsgFromIntent2)) {
                    this.msgSource = next.getMsgSource();
                    parseMsgFromIntent = parseMsgFromIntent2;
                    break;
                }
                parseMsgFromIntent = parseMsgFromIntent2;
            }
        } else {
            ALog.m9182e(TAG, "no impl, try use default impl to parse intent!", new Object[0]);
            BaseNotifyClickActivity.INotifyListener c3063b = new C3063b();
            parseMsgFromIntent = c3063b.parseMsgFromIntent(intent);
            if (TextUtils.isEmpty(parseMsgFromIntent)) {
                c3063b = new C3067f();
                parseMsgFromIntent = c3063b.parseMsgFromIntent(intent);
            }
            if (TextUtils.isEmpty(parseMsgFromIntent)) {
                c3063b = new C3065d();
                parseMsgFromIntent = c3063b.parseMsgFromIntent(intent);
            }
            if (TextUtils.isEmpty(parseMsgFromIntent)) {
                c3063b = new C3066e();
                parseMsgFromIntent = c3063b.parseMsgFromIntent(intent);
            }
            if (TextUtils.isEmpty(parseMsgFromIntent)) {
                c3063b = new C3064c();
                parseMsgFromIntent = c3063b.parseMsgFromIntent(intent);
            }
            if (TextUtils.isEmpty(parseMsgFromIntent)) {
                C3043k.m9250a("accs", "error", "parse 3push error", 0.0d);
            } else {
                this.msgSource = c3063b.getMsgSource();
                C3043k.m9250a("accs", "error", "parse 3push default " + this.msgSource, 0.0d);
            }
        }
        ALog.m9183i(TAG, "parseMsgByThirdPush", "result", parseMsgFromIntent, "msgSource", this.msgSource);
        return parseMsgFromIntent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportClickNotifyMsg(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("id");
            String stringExtra2 = intent.getStringExtra(AgooConstants.MESSAGE_SOURCE);
            String stringExtra3 = intent.getStringExtra(AgooConstants.MESSAGE_REPORT);
            String stringExtra4 = intent.getStringExtra(AgooConstants.MESSAGE_EXT);
            MsgDO msgDO = new MsgDO();
            msgDO.msgIds = stringExtra;
            msgDO.extData = stringExtra4;
            msgDO.messageSource = stringExtra2;
            msgDO.reportStr = stringExtra3;
            msgDO.msgStatus = "8";
            ALog.m9183i(TAG, "reportClickNotifyMsg messageId:" + stringExtra + " source:" + stringExtra2 + " reportStr:" + stringExtra3 + " status:" + msgDO.msgStatus, new Object[0]);
            this.notifyManager.report(msgDO, null);
        } catch (Exception e2) {
            ALog.m9182e(TAG, "reportClickNotifyMsg exception: " + e2, new Object[0]);
        }
    }

    public void onCreate(Context context, Intent intent) {
        ALog.m9183i(TAG, "onCreate", new Object[0]);
        this.context = context;
        buildMessage(intent);
    }

    public abstract void onMessage(Intent intent);

    public void onNewIntent(Intent intent) {
        ALog.m9183i(TAG, "onNewIntent", new Object[0]);
        buildMessage(intent);
    }
}
