package com.taobao.agoo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.control.NotifManager;

/* compiled from: Taobao */
/* renamed from: com.taobao.agoo.a */
/* loaded from: classes2.dex */
class RunnableC3056a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Intent f9769a;

    /* renamed from: b */
    final /* synthetic */ BaseNotifyClick f9770b;

    RunnableC3056a(BaseNotifyClick baseNotifyClick, Intent intent) {
        this.f9770b = baseNotifyClick;
        this.f9769a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        Intent intent;
        String parseMsgByThirdPush;
        String str;
        String str2;
        NotifManager notifManager;
        AgooFactory agooFactory;
        AgooFactory agooFactory2;
        String str3;
        AgooFactory agooFactory3;
        AgooFactory agooFactory4;
        Context context;
        NotifManager notifManager2;
        Intent intent2 = null;
        try {
            try {
                if (this.f9769a != null) {
                    parseMsgByThirdPush = this.f9770b.parseMsgByThirdPush(this.f9769a);
                    if (!TextUtils.isEmpty(parseMsgByThirdPush)) {
                        str2 = this.f9770b.msgSource;
                        if (!TextUtils.isEmpty(str2)) {
                            notifManager = this.f9770b.notifyManager;
                            if (notifManager == null) {
                                this.f9770b.notifyManager = new NotifManager();
                            }
                            agooFactory = this.f9770b.agooFactory;
                            if (agooFactory == null) {
                                this.f9770b.agooFactory = new AgooFactory();
                                agooFactory4 = this.f9770b.agooFactory;
                                context = this.f9770b.context;
                                notifManager2 = this.f9770b.notifyManager;
                                agooFactory4.init(context, notifManager2, null);
                            }
                            agooFactory2 = this.f9770b.agooFactory;
                            byte[] bytes = parseMsgByThirdPush.getBytes("UTF-8");
                            str3 = this.f9770b.msgSource;
                            Bundle msgReceiverPreHandler = agooFactory2.msgReceiverPreHandler(bytes, str3, null, false);
                            String string = msgReceiverPreHandler.getString("body");
                            ALog.m9183i("accs.BaseNotifyClick", "begin parse EncryptedMsg", new Object[0]);
                            String parseEncryptedMsg = AgooFactory.parseEncryptedMsg(string);
                            if (TextUtils.isEmpty(parseEncryptedMsg)) {
                                ALog.m9182e("accs.BaseNotifyClick", "parse EncryptedMsg fail, empty", new Object[0]);
                            } else {
                                msgReceiverPreHandler.putString("body", parseEncryptedMsg);
                            }
                            intent = new Intent();
                            try {
                                intent.putExtras(msgReceiverPreHandler);
                                agooFactory3 = this.f9770b.agooFactory;
                                agooFactory3.saveMsg(parseMsgByThirdPush.getBytes("UTF-8"), "2");
                                this.f9770b.reportClickNotifyMsg(intent);
                                this.f9770b.onMessage(intent);
                                return;
                            } catch (Throwable th) {
                                intent2 = intent;
                                th = th;
                                try {
                                    ALog.m9181e("accs.BaseNotifyClick", "buildMessage", th, new Object[0]);
                                    try {
                                        this.f9770b.onMessage(intent2);
                                        return;
                                    } catch (Throwable th2) {
                                        ALog.m9181e("accs.BaseNotifyClick", "onMessage", th2, new Object[0]);
                                        return;
                                    }
                                } catch (Throwable th3) {
                                    try {
                                        this.f9770b.onMessage(intent2);
                                    } catch (Throwable th4) {
                                        ALog.m9181e("accs.BaseNotifyClick", "onMessage", th4, new Object[0]);
                                    }
                                    throw th3;
                                }
                            }
                        }
                    }
                    str = this.f9770b.msgSource;
                    ALog.m9182e("accs.BaseNotifyClick", "parseMsgFromNotifyListener null!!", "source", str);
                }
                this.f9770b.onMessage(intent);
                return;
            } catch (Throwable th5) {
                ALog.m9181e("accs.BaseNotifyClick", "onMessage", th5, new Object[0]);
                return;
            }
            intent = null;
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
