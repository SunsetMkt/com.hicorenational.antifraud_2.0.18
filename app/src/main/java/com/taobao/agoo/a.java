package com.taobao.agoo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.control.NotifManager;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f8702a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseNotifyClick f8703b;

    a(BaseNotifyClick baseNotifyClick, Intent intent) {
        this.f8703b = baseNotifyClick;
        this.f8702a = intent;
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
                if (this.f8702a != null) {
                    parseMsgByThirdPush = this.f8703b.parseMsgByThirdPush(this.f8702a);
                    if (!TextUtils.isEmpty(parseMsgByThirdPush)) {
                        str2 = this.f8703b.msgSource;
                        if (!TextUtils.isEmpty(str2)) {
                            notifManager = this.f8703b.notifyManager;
                            if (notifManager == null) {
                                this.f8703b.notifyManager = new NotifManager();
                            }
                            agooFactory = this.f8703b.agooFactory;
                            if (agooFactory == null) {
                                this.f8703b.agooFactory = new AgooFactory();
                                agooFactory4 = this.f8703b.agooFactory;
                                context = this.f8703b.context;
                                notifManager2 = this.f8703b.notifyManager;
                                agooFactory4.init(context, notifManager2, null);
                            }
                            agooFactory2 = this.f8703b.agooFactory;
                            byte[] bytes = parseMsgByThirdPush.getBytes("UTF-8");
                            str3 = this.f8703b.msgSource;
                            Bundle msgReceiverPreHandler = agooFactory2.msgReceiverPreHandler(bytes, str3, null, false);
                            String string = msgReceiverPreHandler.getString("body");
                            ALog.i("accs.BaseNotifyClick", "begin parse EncryptedMsg", new Object[0]);
                            String parseEncryptedMsg = AgooFactory.parseEncryptedMsg(string);
                            if (TextUtils.isEmpty(parseEncryptedMsg)) {
                                ALog.e("accs.BaseNotifyClick", "parse EncryptedMsg fail, empty", new Object[0]);
                            } else {
                                msgReceiverPreHandler.putString("body", parseEncryptedMsg);
                            }
                            intent = new Intent();
                            try {
                                intent.putExtras(msgReceiverPreHandler);
                                agooFactory3 = this.f8703b.agooFactory;
                                agooFactory3.saveMsg(parseMsgByThirdPush.getBytes("UTF-8"), "2");
                                this.f8703b.reportClickNotifyMsg(intent);
                                this.f8703b.onMessage(intent);
                                return;
                            } catch (Throwable th) {
                                intent2 = intent;
                                th = th;
                                try {
                                    ALog.e("accs.BaseNotifyClick", "buildMessage", th, new Object[0]);
                                    try {
                                        this.f8703b.onMessage(intent2);
                                        return;
                                    } catch (Throwable th2) {
                                        ALog.e("accs.BaseNotifyClick", "onMessage", th2, new Object[0]);
                                        return;
                                    }
                                } catch (Throwable th3) {
                                    try {
                                        this.f8703b.onMessage(intent2);
                                    } catch (Throwable th4) {
                                        ALog.e("accs.BaseNotifyClick", "onMessage", th4, new Object[0]);
                                    }
                                    throw th3;
                                }
                            }
                        }
                    }
                    str = this.f8703b.msgSource;
                    ALog.e("accs.BaseNotifyClick", "parseMsgFromNotifyListener null!!", "source", str);
                }
                this.f8703b.onMessage(intent);
                return;
            } catch (Throwable th5) {
                ALog.e("accs.BaseNotifyClick", "onMessage", th5, new Object[0]);
                return;
            }
            intent = null;
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
